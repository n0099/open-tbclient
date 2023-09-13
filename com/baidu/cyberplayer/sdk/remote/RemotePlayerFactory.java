package com.baidu.cyberplayer.sdk.remote;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.CyberPlayerCoreInvoker;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.PlayerConfigManager;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
import com.baidu.cyberplayer.sdk.extractor.RemoteExtractor;
import com.baidu.cyberplayer.sdk.remote.IRemotePlayerFactory;
import com.baidu.cyberplayer.sdk.statistics.UbcRemoteStat;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes3.dex */
public class RemotePlayerFactory {
    public static final int BINDER_ALIVE = 1;
    public static final int BINDER_DIED = -1;
    public static final int BINDER_IDLE = 0;
    public static final int BINDER_RECOVERING = 2;
    public static final int BINDER_RECOVER_FAILED = -2;
    public static final String TAG = "RemotePlayer";
    public static volatile RemotePlayerFactory sInstance;
    public String mClientID;
    public int mInstallType;
    public int mPcdnType;
    public volatile IRemotePlayerFactory mRemoteBinder;
    public Class<?> mServiceClass;
    public volatile int mBinderState = 0;
    public final Object mLock = new Object();
    public ArrayList<WeakReference<RemoteServerListener>> mListenersList = new ArrayList<>();
    public RemotePrefetchListenerProxy mPrefetchListenerProxy = null;
    public ServiceConnection mConnection = new ServiceConnection() { // from class: com.baidu.cyberplayer.sdk.remote.RemotePlayerFactory.1
        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            CyberLog.e("RemotePlayer", "RemotePlayer service disconnected");
            RemotePlayerFactory.this.mRemoteBinder = null;
            synchronized (RemotePlayerFactory.this) {
                RemotePlayerFactory remotePlayerFactory = RemotePlayerFactory.this;
                int i = 2;
                if (RemotePlayerFactory.this.mBinderState != 2) {
                    i = -1;
                }
                remotePlayerFactory.mBinderState = i;
                UbcRemoteStat.getInstance().updateUbcStat(UbcRemoteStat.DISCONNECTED, System.currentTimeMillis());
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            CyberLog.i("RemotePlayer", "RemotePlayer service connected");
            RemotePlayerFactory.this.mRemoteBinder = IRemotePlayerFactory.Stub.asInterface(iBinder);
            synchronized (RemotePlayerFactory.this) {
                RemotePlayerFactory.this.mBinderState = 1;
                UbcRemoteStat.getInstance().updateUbcStat(UbcRemoteStat.CONNECTED, System.currentTimeMillis());
            }
            try {
                RemotePlayerFactory.this.mRemoteBinder.asBinder().linkToDeath(RemotePlayerFactory.this.mDeathRecipient, 0);
                if (RemotePlayerFactory.this.mPrefetchListenerProxy != null) {
                    RemotePlayerFactory.this.mRemoteBinder.setPrefetchListener(RemotePlayerFactory.this.mPrefetchListenerProxy);
                }
            } catch (RemoteException e) {
                e.printStackTrace();
                RemotePlayerFactory.this.mRemoteBinder = null;
                synchronized (RemotePlayerFactory.this) {
                    RemotePlayerFactory.this.mBinderState = -1;
                    UbcRemoteStat.getInstance().updateUbcStat(UbcRemoteStat.LINK_DEATH_FAILED, System.currentTimeMillis());
                }
            }
            RemotePlayerFactory remotePlayerFactory = RemotePlayerFactory.this;
            remotePlayerFactory.remoteInstallNewType(remotePlayerFactory.mInstallType);
        }
    };
    public IBinder.DeathRecipient mDeathRecipient = new IBinder.DeathRecipient() { // from class: com.baidu.cyberplayer.sdk.remote.RemotePlayerFactory.2
        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            CyberLog.i("RemotePlayer", "RemotePlayer service binder died");
            if (RemotePlayerFactory.this.mRemoteBinder != null) {
                RemotePlayerFactory.this.mRemoteBinder.asBinder().unlinkToDeath(RemotePlayerFactory.this.mDeathRecipient, 0);
                RemotePlayerFactory.this.mRemoteBinder = null;
                synchronized (RemotePlayerFactory.this) {
                    RemotePlayerFactory.this.mBinderState = -1;
                    UbcRemoteStat.getInstance().updateUbcStat(UbcRemoteStat.BINDER_DIED, System.currentTimeMillis());
                    UbcRemoteStat.getInstance().uploadUbcStat();
                }
            }
            synchronized (RemotePlayerFactory.this.mLock) {
                Iterator it = RemotePlayerFactory.this.mListenersList.iterator();
                while (it.hasNext()) {
                    RemoteServerListener remoteServerListener = (RemoteServerListener) ((WeakReference) it.next()).get();
                    if (remoteServerListener != null) {
                        remoteServerListener.binderDied();
                    } else {
                        it.remove();
                    }
                }
                RemotePlayerFactory.this.mListenersList.clear();
            }
            RemotePlayerFactory remotePlayerFactory = RemotePlayerFactory.this;
            remotePlayerFactory.connectRemote(remotePlayerFactory.mServiceClass, RemotePlayerFactory.this.mClientID, RemotePlayerFactory.this.mInstallType, CyberPlayerManager.getInstallOpts(), RemotePlayerFactory.this.mPcdnType);
        }
    };

    /* loaded from: classes3.dex */
    public interface RemoteServerListener {
        void binderDied();
    }

    /* loaded from: classes3.dex */
    public static class RemoteImpl extends IRemotePlayerFactory.Stub implements CyberPlayerManager.OnPrefetchListener {
        public RemoteCallbackList<IPrefetchListener> mListenerList = new RemoteCallbackList<>();
        public RemotePlayerService mRemoteService;

        public RemoteImpl(RemotePlayerService remotePlayerService) {
            this.mRemoteService = remotePlayerService;
        }

        @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayerFactory
        public IBinder createPlayer(int i) {
            if (!CyberPlayerManager.isCoreLoaded(1)) {
                CyberLog.w("RemotePlayer", "RemotePlayer has not load kernel, create failed!");
                return null;
            }
            return new RemotePlayer(i, this.mRemoteService);
        }

        @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayerFactory
        public boolean hasCacheFile(String str) {
            return CyberPlayerManager.hasCacheFile(str);
        }

        @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayerFactory
        public void remoteInstallNewType(int i) {
            RemotePlayerService remotePlayerService = this.mRemoteService;
            if (remotePlayerService == null) {
                return;
            }
            try {
                remotePlayerService.remoteInstallNewType(i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayerFactory
        public void setPrefetchListener(IPrefetchListener iPrefetchListener) {
            CyberPlayerCoreInvoker.setPrefetchListener(this);
            if (iPrefetchListener != null) {
                this.mListenerList.register(iPrefetchListener);
            }
        }

        @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayerFactory
        public boolean updatePlayerConfig(String str) {
            PlayerConfigManager.getInstance().updatePlayerConfig(str);
            return true;
        }

        @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayerFactory
        public long calculateVideoCacheSizeCanBeCleared() {
            return CyberPlayerManager.getVideoCacheSizeCanBeCleared();
        }

        @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayerFactory
        public IBinder createExtractor() {
            if (!CyberPlayerManager.isCoreLoaded(1)) {
                CyberLog.w("RemotePlayer", "RemoteExtractor has not load kernel, create failed!");
                return null;
            }
            return new RemoteExtractor(this.mRemoteService);
        }

        @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayerFactory
        public IBinder createDownloader(int i, String str, PrefetchOptions prefetchOptions) {
            if (!CyberPlayerManager.isCoreLoaded(1)) {
                CyberLog.w("RemotePlayer", "RemoteDownloader has not load kernel, create failed!");
                return null;
            }
            return new RemoteDownloader(i, str, prefetchOptions, this.mRemoteService);
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPrefetchListener
        public void onPrefetchStatusChanged(String str, boolean z, int i, String str2) {
            synchronized (this.mListenerList) {
                int beginBroadcast = this.mListenerList.beginBroadcast();
                CyberLog.i("RemotePlayer", "[PrefetchCallback]onPrefetchStatus num:" + beginBroadcast);
                for (int i2 = 0; i2 < beginBroadcast; i2++) {
                    try {
                        this.mListenerList.getBroadcastItem(i2).onPrefetchStatusChanged(str, z, i, str2);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
                this.mListenerList.finishBroadcast();
            }
        }

        @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayerFactory
        public void prefetch(String str, String str2, String str3, int i, int i2, int i3, String str4, int i4, int i5, int i6, int i7, PrefetchOptions prefetchOptions) {
            if (i == 1) {
                CyberLog.i(PrefetchEvent.MODULE, "RemotePlayer prefetch");
                CyberPlayerCoreInvoker.kernelNetInit();
                CyberPlayerCoreInvoker.pcdnNetInit();
                CyberPlayerManager.prefetch(str, str2, str3, i2, i3, null, str4, i4, i5, i6, i7, prefetchOptions);
            } else if (i == 2) {
                CyberLog.i("RemotePlayer", "RemotePlayer preconnect");
                CyberPlayerManager.preconnect(str, str2, str3, i3, null, str4, i4, i5, i6, i7);
            }
        }

        @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayerFactory
        public void sendGlobalCommond(String str, int i, long j, String str2, PrefetchOptions prefetchOptions) {
            CyberPlayerCoreInvoker.sendGlobalCommond(str, i, j, str2, prefetchOptions);
        }
    }

    public static RemotePlayerFactory getInstance() {
        if (sInstance == null) {
            synchronized (RemotePlayerFactory.class) {
                if (sInstance == null) {
                    sInstance = new RemotePlayerFactory();
                }
            }
        }
        return sInstance;
    }

    public IBinder createExtractor() {
        if (this.mRemoteBinder != null) {
            try {
                return this.mRemoteBinder.createExtractor();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public synchronized int getBinderState() {
        return this.mBinderState;
    }

    public long getVideoCacheSizeCanBeCleared() {
        if (this.mRemoteBinder == null) {
            return -1L;
        }
        try {
            return this.mRemoteBinder.calculateVideoCacheSizeCanBeCleared();
        } catch (RemoteException unused) {
            return -1L;
        }
    }

    public void addListener(RemoteServerListener remoteServerListener) {
        synchronized (this.mLock) {
            this.mListenersList.add(new WeakReference<>(remoteServerListener));
        }
    }

    public IBinder createPlayer(int i) {
        if (this.mRemoteBinder != null) {
            try {
                return this.mRemoteBinder.createPlayer(i);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public int hasCacheFile(String str) {
        if (this.mRemoteBinder == null) {
            return -1;
        }
        try {
            return this.mRemoteBinder.hasCacheFile(str) ? 1 : 0;
        } catch (RemoteException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public void removeListener(RemoteServerListener remoteServerListener) {
        synchronized (this.mLock) {
            Iterator<WeakReference<RemoteServerListener>> it = this.mListenersList.iterator();
            while (it.hasNext()) {
                RemoteServerListener remoteServerListener2 = it.next().get();
                if (remoteServerListener2 == null || remoteServerListener2.equals(remoteServerListener)) {
                    it.remove();
                }
            }
        }
    }

    public boolean updatePlayerConfig(String str) {
        if (this.mRemoteBinder == null) {
            return false;
        }
        try {
            this.mRemoteBinder.updatePlayerConfig(str);
            return true;
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void remoteInstallNewType(int i) {
        if (this.mRemoteBinder == null) {
            return;
        }
        try {
            if (CyberCfgManager.getInstance().getCfgBoolValue("remote_install_new_type", true)) {
                CyberLog.e("RemotePlayer", "RemoteBinder remoteInstallNewType: " + i);
                this.mRemoteBinder.remoteInstallNewType(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean setPrefetchListener(CyberPlayerManager.OnPrefetchListener onPrefetchListener) {
        boolean updatePrefetchListener;
        if (this.mRemoteBinder == null) {
            return false;
        }
        CyberLog.w("RemotePlayer", "[PrefetchCallback]setPrefetchListenertusChanged:" + onPrefetchListener);
        RemotePrefetchListenerProxy remotePrefetchListenerProxy = this.mPrefetchListenerProxy;
        if (remotePrefetchListenerProxy == null) {
            this.mPrefetchListenerProxy = new RemotePrefetchListenerProxy(onPrefetchListener);
            updatePrefetchListener = true;
        } else {
            updatePrefetchListener = remotePrefetchListenerProxy.updatePrefetchListener(onPrefetchListener);
        }
        if (updatePrefetchListener) {
            try {
                this.mRemoteBinder.setPrefetchListener(this.mPrefetchListenerProxy);
            } catch (RemoteException e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }

    public void connectRemote(Class<?> cls, String str, int i, Map<String, String> map, int i2) {
        if (cls == null) {
            return;
        }
        CyberLog.i("RemotePlayer", "RemotePlayer connect service: " + i);
        this.mServiceClass = cls;
        this.mClientID = str;
        this.mPcdnType = i2;
        this.mInstallType = i;
        boolean cfgBoolValue = CyberCfgManager.getInstance().getCfgBoolValue(CyberCfgManager.KEY_INT_ZEUS_INIT_REFACTOR, true);
        Intent intent = new Intent(CyberPlayerManager.getApplicationContext(), this.mServiceClass);
        intent.putExtra("clientID", this.mClientID);
        intent.putExtra("installType", this.mInstallType);
        intent.putExtra("installOpts", (Serializable) map);
        intent.putExtra("isZeusLauncher", cfgBoolValue);
        intent.putExtra("pcdnType", this.mPcdnType);
        boolean z = false;
        try {
            z = CyberPlayerManager.getApplicationContext().bindService(intent, this.mConnection, 1);
            synchronized (this) {
                this.mBinderState = 2;
                UbcRemoteStat.getInstance().updateUbcStat(UbcRemoteStat.BIND_SERVICE, System.currentTimeMillis());
            }
        } catch (Exception unused) {
            CyberLog.e("RemotePlayer", "Failed binding to service!");
        }
        if (!z) {
            CyberLog.i("RemotePlayer", "Failed binding to service! need retry!");
            synchronized (this) {
                this.mBinderState = -2;
                UbcRemoteStat.getInstance().updateUbcStat(UbcRemoteStat.BIND_FAILED, System.currentTimeMillis());
            }
        }
        remoteInstallNewType(this.mInstallType);
    }

    public IBinder createDownloader(int i, String str, PrefetchOptions prefetchOptions) {
        if (this.mRemoteBinder != null) {
            try {
                return this.mRemoteBinder.createDownloader(i, str, prefetchOptions);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public boolean prefetch(String str, String str2, String str3, int i, int i2, int i3, String str4, int i4, int i5, int i6, int i7, PrefetchOptions prefetchOptions, CyberPlayerManager.OnPrefetchListener onPrefetchListener) {
        if (this.mRemoteBinder == null) {
            return false;
        }
        try {
            setPrefetchListener(onPrefetchListener);
            this.mRemoteBinder.prefetch(str, str2, str3, i, i2, i3, str4, i4, i5, i6, i7, prefetchOptions);
            return true;
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void sendGlobalCommondToRemote(String str, int i, long j, String str2, PrefetchOptions prefetchOptions) {
        if (this.mRemoteBinder == null) {
            return;
        }
        try {
            this.mRemoteBinder.sendGlobalCommond(str, i, j, str2, prefetchOptions);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
