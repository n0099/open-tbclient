package com.baidu.cyberplayer.sdk.remote;

import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.Surface;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.CyberPlayer;
import com.baidu.cyberplayer.sdk.CyberPlayerCoreInvoker;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.remote.IRemotePlayer;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class RemotePlayer extends IRemotePlayer.Stub implements CyberPlayerManager.HttpDNS, CyberPlayerManager.OnPreparedListener, CyberPlayerManager.OnCompletionListener, CyberPlayerManager.OnBufferingUpdateListener, CyberPlayerManager.OnSeekCompleteListener, CyberPlayerManager.OnVideoSizeChangedListener, CyberPlayerManager.OnErrorListener, CyberPlayerManager.OnInfoListener, CyberPlayerManager.OnMediaRuntimeInfoListener, CyberPlayerManager.OnMediaSourceChangedListener {
    public int mMode;
    public CyberPlayer mPlayer;
    public RemotePlayerService mRemoteService;
    public Surface mSurface;
    public RemoteCallbackList<IRemotePlayerListener> mListenerList = new RemoteCallbackList<>();
    public final Object mSurfaceMonitor = new Object();

    public RemotePlayer(int i, RemotePlayerService remotePlayerService) {
        this.mMode = i;
        this.mRemoteService = remotePlayerService;
        CyberPlayer cyberPlayer = new CyberPlayer(i, this, false);
        this.mPlayer = cyberPlayer;
        cyberPlayer.setIsInMainProcess(false);
        this.mPlayer.setOnPreparedListener(this);
        this.mPlayer.setOnCompletionListener(this);
        this.mPlayer.setOnBufferingUpdateListener(this);
        this.mPlayer.setOnVideoSizeChangedListener(this);
        this.mPlayer.setOnSeekCompleteListener(this);
        this.mPlayer.setOnErrorListener(this);
        this.mPlayer.setOnInfoListener(this);
        this.mPlayer.setOnMediaSourceChangedListener(this);
        CyberPlayerCoreInvoker.kernelNetInit();
        CyberPlayerCoreInvoker.pcdnNetInit();
    }

    @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayer
    public void setOption(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (str.equals(CyberPlayerManager.OPT_PCDN_NETHANDLE)) {
            if (!TextUtils.isEmpty(str2) && this.mRemoteService != null) {
                getPlayer().setOption(CyberPlayerManager.OPT_PCDN_NETHANDLE, String.valueOf(this.mRemoteService.getPCDNNetHandle()));
            }
        } else if (str.equals(CyberPlayerManager.OPT_KERNEL_NET_NETHANDLE)) {
            if (!TextUtils.isEmpty(str2) && this.mRemoteService != null) {
                getPlayer().setOption(CyberPlayerManager.OPT_KERNEL_NET_NETHANDLE, String.valueOf(this.mRemoteService.getKernelNetHandle()));
            }
        } else {
            getPlayer().setOption(str, str2);
        }
    }

    private CyberPlayer getPlayer() {
        return this.mPlayer;
    }

    @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayer
    public int getCurrentPosition() {
        return getPlayer().getCurrentPosition();
    }

    @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayer
    public int getCurrentPositionSync() {
        return getPlayer().getCurrentPositionSync();
    }

    @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayer
    public int getDecodeMode() {
        return getPlayer().getDecodeMode();
    }

    @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayer
    public long getDownloadSpeed() {
        return getPlayer().getDownloadSpeed();
    }

    @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayer
    public int getDuration() {
        return getPlayer().getDuration();
    }

    @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayer
    public long getPlayedTime() {
        return getPlayer().getPlayedTime();
    }

    @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayer
    public String getPlayerConfigOptions() {
        return getPlayer().getPlayerConfigOptions();
    }

    @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayer
    public int getVideoHeight() {
        return getPlayer().getVideoHeight();
    }

    @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayer
    public int getVideoWidth() {
        return getPlayer().getVideoWidth();
    }

    @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayer
    public boolean isLooping() {
        return getPlayer().isLooping();
    }

    @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayer
    public boolean isPlaying() {
        return getPlayer().isPlaying();
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
    public void onCompletion() {
        synchronized (this.mListenerList) {
            int beginBroadcast = this.mListenerList.beginBroadcast();
            for (int i = 0; i < beginBroadcast; i++) {
                IRemotePlayerListener broadcastItem = this.mListenerList.getBroadcastItem(i);
                if (broadcastItem != null) {
                    try {
                        broadcastItem.onCompletion();
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            }
            this.mListenerList.finishBroadcast();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
    public void onPrepared() {
        synchronized (this.mListenerList) {
            int beginBroadcast = this.mListenerList.beginBroadcast();
            for (int i = 0; i < beginBroadcast; i++) {
                IRemotePlayerListener broadcastItem = this.mListenerList.getBroadcastItem(i);
                if (broadcastItem != null) {
                    try {
                        broadcastItem.onPrepared();
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            }
            this.mListenerList.finishBroadcast();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
    public void onSeekComplete() {
        synchronized (this.mListenerList) {
            int beginBroadcast = this.mListenerList.beginBroadcast();
            for (int i = 0; i < beginBroadcast; i++) {
                IRemotePlayerListener broadcastItem = this.mListenerList.getBroadcastItem(i);
                if (broadcastItem != null) {
                    try {
                        broadcastItem.onSeekComplete();
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            }
            this.mListenerList.finishBroadcast();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayer
    public void pause() {
        getPlayer().pause();
    }

    @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayer
    public void prepareAsync() {
        getPlayer().prepareAsync();
    }

    @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayer
    public void reset() {
        getPlayer().reset();
    }

    @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayer
    public void start() {
        getPlayer().start();
    }

    @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayer
    public void stepToNextFrame() {
        getPlayer().stepToNextFrame();
    }

    @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayer
    public void stop() {
        getPlayer().stop();
    }

    @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayer
    public void addListener(IRemotePlayerListener iRemotePlayerListener) {
        this.mListenerList.register(iRemotePlayerListener);
    }

    @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayer
    public void getMediaRuntimeInfo(int i) {
        getPlayer().getMediaRuntimeInfo(i, this);
    }

    @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayer
    public void muteOrUnmuteAudio(boolean z) {
        getPlayer().muteOrUnmuteAudio(z);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnBufferingUpdateListener
    public void onBufferingUpdate(int i) {
        synchronized (this.mListenerList) {
            int beginBroadcast = this.mListenerList.beginBroadcast();
            for (int i2 = 0; i2 < beginBroadcast; i2++) {
                IRemotePlayerListener broadcastItem = this.mListenerList.getBroadcastItem(i2);
                if (broadcastItem != null) {
                    try {
                        broadcastItem.onBufferingUpdate(i);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            }
            this.mListenerList.finishBroadcast();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnMediaRuntimeInfoListener
    public void onRuntimeInfo(String str) {
        synchronized (this.mListenerList) {
            int beginBroadcast = this.mListenerList.beginBroadcast();
            for (int i = 0; i < beginBroadcast; i++) {
                IRemotePlayerListener broadcastItem = this.mListenerList.getBroadcastItem(i);
                if (broadcastItem != null) {
                    try {
                        broadcastItem.onMediaRuntimeInfo(str);
                    } catch (RemoteException unused) {
                    }
                }
            }
            this.mListenerList.finishBroadcast();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayer
    public void removeListener(IRemotePlayerListener iRemotePlayerListener) {
        this.mListenerList.unregister(iRemotePlayerListener);
    }

    @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayer
    public void setClarityInfo(String str) throws RemoteException {
        if (str != null) {
            getPlayer().setClarityInfo(str);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayer
    public void setDataSource(RemoteDataSource remoteDataSource) {
        getPlayer().setDataSource(CyberPlayerManager.getApplicationContext(), remoteDataSource.getUri(), remoteDataSource.getHeaders());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("is_remote_play", 1);
            sendCommand(1003, DpStatConstants.SESSION_TYPE_PLAY_COMMON, 0L, jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayer
    public void setEnableDumediaUA(boolean z) {
        getPlayer().setEnableDumediaUA(z);
    }

    @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayer
    public void setLooping(boolean z) {
        getPlayer().setLooping(z);
    }

    @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayer
    public void setPlayJson(String str) {
        getPlayer().setPlayJson(str);
    }

    @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayer
    public void setScreenOnWhilePlaying(boolean z) {
        getPlayer().setScreenOnWhilePlaying(z);
    }

    @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayer
    public void setSpeed(float f) {
        getPlayer().setSpeed(f);
    }

    @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayer
    public void setSurface(Surface surface) {
        getPlayer().setSurface(surface);
        synchronized (this.mSurfaceMonitor) {
            if (this.mSurface != null && this.mSurface != surface) {
                this.mSurface.release();
            }
            this.mSurface = surface;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayer
    public void setWakeMode(int i) {
        getPlayer().setWakeMode(CyberPlayerManager.getApplicationContext(), i);
    }

    @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayer
    public void changeProxyDynamic(String str, boolean z) {
        getPlayer().changeProxyDynamic(str, z);
    }

    @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayer
    public void seekTo(long j, int i) {
        getPlayer().seekTo(j, i);
    }

    @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayer
    public void setVolume(float f, float f2) {
        getPlayer().setVolume(f, f2);
    }

    @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayer
    public void switchMediaSource(int i, int i2) {
        getPlayer().switchMediaSource(i, CyberPlayerManager.MediaSourceSwitchMode.values()[i2]);
    }

    @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayer
    public void updateDisplaySize(int i, int i2) {
        getPlayer().updateDisplaySize(i, i2);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.HttpDNS
    public List<String> getIpList(String str) {
        ArrayList arrayList;
        synchronized (this.mListenerList) {
            int beginBroadcast = this.mListenerList.beginBroadcast();
            arrayList = null;
            for (int i = 0; i < beginBroadcast; i++) {
                IRemotePlayerListener broadcastItem = this.mListenerList.getBroadcastItem(i);
                if (broadcastItem != null) {
                    try {
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.add(str);
                        broadcastItem.onCallback("onHttpDNS", arrayList2);
                        if (arrayList2.size() > 0) {
                            arrayList = arrayList2;
                        }
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            }
            this.mListenerList.finishBroadcast();
        }
        return arrayList;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
    public boolean onError(int i, int i2, Object obj) {
        boolean z;
        String str;
        synchronized (this.mListenerList) {
            int beginBroadcast = this.mListenerList.beginBroadcast();
            z = false;
            for (int i3 = 0; i3 < beginBroadcast; i3++) {
                IRemotePlayerListener broadcastItem = this.mListenerList.getBroadcastItem(i3);
                if (broadcastItem != null) {
                    try {
                        if (obj instanceof String) {
                            str = (String) obj;
                        } else {
                            str = null;
                        }
                        z = broadcastItem.onError(i, i2, str);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            }
            this.mListenerList.finishBroadcast();
        }
        return z;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
    public boolean onInfo(int i, int i2, Object obj) {
        boolean z;
        String str;
        synchronized (this.mListenerList) {
            int beginBroadcast = this.mListenerList.beginBroadcast();
            z = false;
            for (int i3 = 0; i3 < beginBroadcast; i3++) {
                IRemotePlayerListener broadcastItem = this.mListenerList.getBroadcastItem(i3);
                if (broadcastItem != null) {
                    try {
                        if (obj instanceof String) {
                            str = (String) obj;
                        } else {
                            str = null;
                        }
                        z = broadcastItem.onInfo(i, i2, str);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            }
            this.mListenerList.finishBroadcast();
        }
        return z;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnMediaSourceChangedListener
    public boolean onMediaSourceChanged(int i, int i2, Object obj) {
        boolean z;
        String str;
        synchronized (this.mListenerList) {
            int beginBroadcast = this.mListenerList.beginBroadcast();
            z = false;
            for (int i3 = 0; i3 < beginBroadcast; i3++) {
                IRemotePlayerListener broadcastItem = this.mListenerList.getBroadcastItem(i3);
                if (broadcastItem != null) {
                    try {
                        if (obj instanceof String) {
                            str = (String) obj;
                        } else {
                            str = null;
                        }
                        z = broadcastItem.onMediaSourceChanged(i, i2, str);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            }
            this.mListenerList.finishBroadcast();
        }
        return z;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnVideoSizeChangedListener
    public void onVideoSizeChanged(int i, int i2, int i3, int i4) {
        synchronized (this.mListenerList) {
            int beginBroadcast = this.mListenerList.beginBroadcast();
            for (int i5 = 0; i5 < beginBroadcast; i5++) {
                IRemotePlayerListener broadcastItem = this.mListenerList.getBroadcastItem(i5);
                if (broadcastItem != null) {
                    try {
                        broadcastItem.onVideoSizeChanged(i, i2, i3, i4);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            }
            this.mListenerList.finishBroadcast();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayer
    public void sendCommand(int i, int i2, long j, String str) {
        getPlayer().sendCommand(i, i2, j, str);
    }

    @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayer
    public void release() {
        synchronized (this) {
            if (this.mPlayer != null) {
                this.mPlayer.release();
            }
        }
        synchronized (this.mListenerList) {
            this.mListenerList.kill();
        }
        if (this.mSurface != null) {
            synchronized (this.mSurfaceMonitor) {
                if (this.mSurface != null && this.mSurface.isValid()) {
                    CyberLog.i("remotePlayer", "release mSurface");
                    this.mSurface.release();
                    this.mSurface = null;
                }
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayer
    public void setOptions(Map map) throws RemoteException {
        RemotePlayerService remotePlayerService;
        RemotePlayerService remotePlayerService2;
        if (map == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        for (Map.Entry entry : map.entrySet()) {
            if (((String) entry.getKey()).equals(CyberPlayerManager.OPT_PCDN_NETHANDLE)) {
                if (!TextUtils.isEmpty((CharSequence) entry.getValue()) && (remotePlayerService = this.mRemoteService) != null) {
                    hashMap.put(CyberPlayerManager.OPT_PCDN_NETHANDLE, String.valueOf(remotePlayerService.getPCDNNetHandle()));
                }
            } else if (((String) entry.getKey()).equals(CyberPlayerManager.OPT_KERNEL_NET_NETHANDLE)) {
                if (!TextUtils.isEmpty((CharSequence) entry.getValue()) && (remotePlayerService2 = this.mRemoteService) != null) {
                    hashMap.put(CyberPlayerManager.OPT_KERNEL_NET_NETHANDLE, String.valueOf(remotePlayerService2.getKernelNetHandle()));
                }
            } else {
                hashMap.put((String) entry.getKey(), (String) entry.getValue());
            }
        }
        getPlayer().setOptions(hashMap);
    }
}
