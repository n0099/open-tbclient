package com.baidu.cyberplayer.sdk.remote;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.remote.IRemoteDownloader;
import com.baidu.cyberplayer.sdk.remote.IRemoteDownloaderListener;
import com.baidu.cyberplayer.sdk.remote.RemotePlayerFactory;
import com.baidu.cyberplayer.sdk.videodownload.CyberDownloader;
import com.baidu.cyberplayer.sdk.videodownload.DownloaderProvider;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class RemoteDownloaderProxy extends DownloaderProvider implements RemotePlayerFactory.RemoteServerListener {
    public static final int ASYNC_MESSAGE_ON_ERROR = 2;
    public static final int ASYNC_MESSAGE_ON_EVENT = 1;
    public static final String TAG = "RemoteDownloaderProxy";
    public PrivateHandler mAsyncMessageHandler = new PrivateHandler(this, Looper.getMainLooper());
    public CyberDownloader.DownloaderListener mListener;
    public IRemoteDownloader mRemoteDownloader;
    public PrivateRemoteListener mRemotePlayerListener;

    /* loaded from: classes3.dex */
    public static class PrivateHandler extends Handler {
        public final WeakReference<RemoteDownloaderProxy> mWeakDownloader;

        public PrivateHandler(RemoteDownloaderProxy remoteDownloaderProxy, Looper looper) {
            super(looper);
            this.mWeakDownloader = new WeakReference<>(remoteDownloaderProxy);
        }

        public RemoteDownloaderProxy getPlayerProxy() {
            WeakReference<RemoteDownloaderProxy> weakReference = this.mWeakDownloader;
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Object obj;
            RemoteDownloaderProxy playerProxy = getPlayerProxy();
            if (playerProxy == null) {
                CyberLog.w(RemoteDownloaderProxy.TAG, "remoteDownloaderProxy is null");
                return;
            }
            CyberLog.i(RemoteDownloaderProxy.TAG, "handleMessage, thread:" + Thread.currentThread().getName());
            int i = message.what;
            Bundle bundle = null;
            if (i != 1) {
                if (i == 2 && (obj = message.obj) != null && (obj instanceof String)) {
                    CyberLog.e("PrivateHandler", "ASYNC_MSG_ON_ERROR status:" + ((String) obj));
                    if (playerProxy.mListener != null) {
                        playerProxy.mListener.onTransfer(null, message.arg1, message.arg2, message.obj);
                        return;
                    }
                    return;
                }
                return;
            }
            Object obj2 = message.obj;
            if (obj2 != null && (obj2 instanceof String)) {
                String str = (String) obj2;
                CyberLog.i("PrivateHandler", "ASYNC_MSG_ON_EVENT key = " + str + ", what = " + message.arg1 + ", extra = " + message.arg2);
                if (playerProxy.mListener != null) {
                    CyberDownloader.DownloaderListener downloaderListener = playerProxy.mListener;
                    int i2 = message.arg1;
                    int i3 = message.arg2;
                    if (message.peekData() != null) {
                        bundle = message.getData();
                    }
                    downloaderListener.onTransfer(str, i2, i3, bundle);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class PrivateRemoteListener extends IRemoteDownloaderListener.Stub {
        public PrivateHandler mHandler;

        public PrivateRemoteListener(PrivateHandler privateHandler) {
            this.mHandler = privateHandler;
        }

        @Override // com.baidu.cyberplayer.sdk.remote.IRemoteDownloaderListener
        public void onCallback(String str, int i, int i2, Bundle bundle) throws RemoteException {
            CyberLog.i("PrivateRemoteListener", "onCallback key = " + str + ", what = " + i + ", extra = " + i2);
            PrivateHandler privateHandler = this.mHandler;
            if (privateHandler != null) {
                Message obtain = Message.obtain(privateHandler, 1);
                obtain.arg1 = i;
                obtain.arg2 = i2;
                obtain.obj = str;
                obtain.setData(bundle);
                this.mHandler.sendMessage(obtain);
            }
        }

        public void release() {
            this.mHandler = null;
        }
    }

    public RemoteDownloaderProxy(IRemoteDownloader iRemoteDownloader) {
        this.mRemoteDownloader = iRemoteDownloader;
        PrivateRemoteListener privateRemoteListener = new PrivateRemoteListener(this.mAsyncMessageHandler);
        this.mRemotePlayerListener = privateRemoteListener;
        IRemoteDownloader iRemoteDownloader2 = this.mRemoteDownloader;
        if (iRemoteDownloader2 != null) {
            try {
                iRemoteDownloader2.addListener(privateRemoteListener);
                RemotePlayerFactory.getInstance().addListener(this);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.videodownload.DownloaderProvider
    public void addTask(CyberDownloadItem cyberDownloadItem) {
        try {
            this.mRemoteDownloader.addTask(cyberDownloadItem);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.videodownload.DownloaderProvider
    public void cancelTask(String str) {
        try {
            this.mRemoteDownloader.cancelTask(str);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.videodownload.DownloaderProvider
    public void clearCacheFile(String str) {
        try {
            this.mRemoteDownloader.clearCacheFile(str);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.videodownload.DownloaderProvider
    public Bundle getDownloadInfo(String str) {
        try {
            return this.mRemoteDownloader.getDownloadInfo(str);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.videodownload.DownloaderProvider
    public void pauseTask(String str) {
        try {
            this.mRemoteDownloader.pauseTask(str);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.videodownload.DownloaderProvider
    public void resumeTask(String str) {
        try {
            this.mRemoteDownloader.resumeTask(str);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.videodownload.DownloaderProvider
    public void setListener(CyberDownloader.DownloaderListener downloaderListener) {
        CyberLog.i(TAG, "setListener:" + downloaderListener);
        this.mListener = downloaderListener;
    }

    public static DownloaderProvider create(int i, String str, PrefetchOptions prefetchOptions) {
        IRemoteDownloader asInterface = IRemoteDownloader.Stub.asInterface(RemotePlayerFactory.getInstance().createDownloader(i, str, prefetchOptions));
        if (asInterface != null) {
            return new RemoteDownloaderProxy(asInterface);
        }
        return null;
    }

    @Override // com.baidu.cyberplayer.sdk.remote.RemotePlayerFactory.RemoteServerListener
    public void binderDied() {
        CyberLog.i(TAG, "RemoteDownloader service binder died");
        PrivateHandler privateHandler = this.mAsyncMessageHandler;
        if (privateHandler != null) {
            Message obtain = Message.obtain(privateHandler, 2);
            obtain.arg1 = 4;
            obtain.arg2 = CyberPlayerManager.MEDIA_ERROR_REMOTE_DIED;
            obtain.obj = "binderState=" + RemotePlayerFactory.getInstance().getBinderState();
            this.mAsyncMessageHandler.sendMessage(obtain);
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET]}, finally: {[IGET, IPUT, IPUT, IPUT, INVOKE, IPUT, IPUT, IPUT, IPUT, IF] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x001d, code lost:
        if (r0 == null) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x001f, code lost:
        r0.release();
        r3.mRemotePlayerListener = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0024, code lost:
        r3.mRemoteDownloader = null;
        r3.mAsyncMessageHandler = null;
        r3.mListener = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002a, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0012, code lost:
        if (r0 != null) goto L12;
     */
    @Override // com.baidu.cyberplayer.sdk.videodownload.DownloaderProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void release() {
        PrivateRemoteListener privateRemoteListener;
        IRemoteDownloader iRemoteDownloader = this.mRemoteDownloader;
        if (iRemoteDownloader == null) {
            return;
        }
        try {
            try {
                iRemoteDownloader.removeListener(this.mRemotePlayerListener);
                this.mRemoteDownloader.release();
                privateRemoteListener = this.mRemotePlayerListener;
            } catch (RemoteException e) {
                e.printStackTrace();
                privateRemoteListener = this.mRemotePlayerListener;
            }
        } catch (Throwable th) {
            PrivateRemoteListener privateRemoteListener2 = this.mRemotePlayerListener;
            if (privateRemoteListener2 != null) {
                privateRemoteListener2.release();
                this.mRemotePlayerListener = null;
            }
            this.mRemoteDownloader = null;
            this.mAsyncMessageHandler = null;
            this.mListener = null;
            throw th;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.videodownload.DownloaderProvider
    public void cancelAllTasks() {
        try {
            this.mRemoteDownloader.cancelAllTasks();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.videodownload.DownloaderProvider
    public void clearAllCaches() {
        try {
            this.mRemoteDownloader.clearAllCaches();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.videodownload.DownloaderProvider
    public long getAllCacheSize() {
        try {
            return this.mRemoteDownloader.getAllCacheSize();
        } catch (RemoteException e) {
            e.printStackTrace();
            return 0L;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.videodownload.DownloaderProvider
    public void pauseAllTasks() {
        try {
            this.mRemoteDownloader.pauseAllTasks();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.videodownload.DownloaderProvider
    public void resumeAllTasks() {
        try {
            this.mRemoteDownloader.resumeAllTasks();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
