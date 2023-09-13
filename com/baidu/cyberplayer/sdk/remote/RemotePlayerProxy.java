package com.baidu.cyberplayer.sdk.remote;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.PlayerProvider;
import com.baidu.cyberplayer.sdk.context.ICyberMsgHandler;
import com.baidu.cyberplayer.sdk.remote.IRemotePlayer;
import com.baidu.cyberplayer.sdk.remote.IRemotePlayerListener;
import com.baidu.cyberplayer.sdk.remote.RemotePlayerFactory;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import java.io.FileDescriptor;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class RemotePlayerProxy extends PlayerProvider implements RemotePlayerFactory.RemoteServerListener {
    public static final int ASYNC_MESSAGE_ON_BUFFERING_UPDATE = 2;
    public static final int ASYNC_MESSAGE_ON_COMPLETION = 1;
    public static final int ASYNC_MESSAGE_ON_ERROR = 5;
    public static final int ASYNC_MESSAGE_ON_INFO = 6;
    public static final int ASYNC_MESSAGE_ON_MEDIASOURCE_CHANED = 7;
    public static final int ASYNC_MESSAGE_ON_MEDIA_RUNTIME_INFO = 8;
    public static final int ASYNC_MESSAGE_ON_PREPARED = 0;
    public static final int ASYNC_MESSAGE_ON_SEEK_COMPLETE = 3;
    public static final int ASYNC_MESSAGE_ON_VIDEO_SIZE_CHANGED = 4;
    public CyberPlayerManager.HttpDNS mHttpDNS;
    public ICyberMsgHandler mInjectedHandler;
    public CyberPlayerManager.OnMediaSourceChangedListener mMediaSourceChangedListener;
    public CyberPlayerManager.OnBufferingUpdateListener mOnBufferingUpdateListener;
    public CyberPlayerManager.OnCompletionListener mOnCompletionListener;
    public CyberPlayerManager.OnErrorListener mOnErrorListener;
    public CyberPlayerManager.OnInfoListener mOnInfoListener;
    public CyberPlayerManager.OnMediaRuntimeInfoListener mOnMediaRuntimeInfoListener;
    public CyberPlayerManager.OnPreparedListener mOnPreparedListener;
    public CyberPlayerManager.OnSeekCompleteListener mOnSeekCompleteListener;
    public CyberPlayerManager.OnVideoSizeChangedListener mOnVideoSizeChangeListener;
    public IRemotePlayer mRemotePlayer;
    public PrivateRemoteListener mRemotePlayerListener;
    public Surface mSurface;
    public boolean mFirstDispNotifyEnable = false;
    public int mDuration = -1;
    public int mCurrentPosition = -1;
    public PrivateHandler mAsyncMessageHandler = new PrivateHandler(this);

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public boolean isRemotePlayer() {
        return true;
    }

    /* loaded from: classes3.dex */
    public static class PrivateHandler extends Handler {
        public final WeakReference<RemotePlayerProxy> mWeakPlayer;

        public PrivateHandler(RemotePlayerProxy remotePlayerProxy) {
            this.mWeakPlayer = new WeakReference<>(remotePlayerProxy);
        }

        public static void saveFirstDisplayInfoSendMessageCost(RemotePlayerProxy remotePlayerProxy, String str) {
            Object obj;
            try {
                if (!TextUtils.isEmpty(str) && (obj = new JSONObject(str).get("first_disp_notify_time")) != null && (obj instanceof String)) {
                    long parseLong = Long.parseLong((String) obj);
                    if (parseLong > 0) {
                        long currentTimeMillis = System.currentTimeMillis() - parseLong;
                        CyberLog.i("RemotePlayerProxy", "costTime:" + currentTimeMillis);
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("notify_fsp_thread_cost", currentTimeMillis);
                        remotePlayerProxy.sendCommand(1003, DpStatConstants.SESSION_TYPE_FIRST_SCREEN, 0L, jSONObject.toString());
                    }
                }
            } catch (JSONException unused) {
            }
        }

        public RemotePlayerProxy getPlayerProxy() {
            WeakReference<RemotePlayerProxy> weakReference = this.mWeakPlayer;
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            RemotePlayerProxy remotePlayerProxy = this.mWeakPlayer.get();
            if (remotePlayerProxy == null) {
                return;
            }
            switch (message.what) {
                case 0:
                    if (remotePlayerProxy.mOnPreparedListener != null) {
                        remotePlayerProxy.mOnPreparedListener.onPrepared();
                        return;
                    }
                    return;
                case 1:
                    if (remotePlayerProxy.mOnCompletionListener != null) {
                        remotePlayerProxy.mOnCompletionListener.onCompletion();
                        return;
                    }
                    return;
                case 2:
                    if (remotePlayerProxy.mOnBufferingUpdateListener != null) {
                        remotePlayerProxy.mOnBufferingUpdateListener.onBufferingUpdate(message.arg1);
                        return;
                    }
                    return;
                case 3:
                    if (remotePlayerProxy.mOnSeekCompleteListener != null) {
                        remotePlayerProxy.mOnSeekCompleteListener.onSeekComplete();
                        return;
                    }
                    return;
                case 4:
                    if (remotePlayerProxy.mOnVideoSizeChangeListener != null) {
                        int[] iArr = (int[]) message.obj;
                        remotePlayerProxy.mOnVideoSizeChangeListener.onVideoSizeChanged(iArr[0], iArr[1], iArr[2], iArr[3]);
                        return;
                    }
                    return;
                case 5:
                    if (remotePlayerProxy.mOnErrorListener != null) {
                        remotePlayerProxy.mOnErrorListener.onError(message.arg1, message.arg2, message.obj);
                        return;
                    }
                    return;
                case 6:
                    if (remotePlayerProxy.mOnInfoListener != null) {
                        remotePlayerProxy.mOnInfoListener.onInfo(message.arg1, message.arg2, message.obj);
                    }
                    int i = message.arg1;
                    if (904 == i) {
                        saveFirstDisplayInfoSendMessageCost(remotePlayerProxy, (String) message.obj);
                        return;
                    } else if (910 == i) {
                        remotePlayerProxy.mCurrentPosition = message.arg2;
                        return;
                    } else {
                        return;
                    }
                case 7:
                    if (remotePlayerProxy.mMediaSourceChangedListener != null) {
                        remotePlayerProxy.mMediaSourceChangedListener.onMediaSourceChanged(message.arg1, message.arg2, message.obj);
                        return;
                    }
                    return;
                case 8:
                    if (remotePlayerProxy.mOnMediaRuntimeInfoListener != null) {
                        remotePlayerProxy.mOnMediaRuntimeInfoListener.onRuntimeInfo((String) message.obj);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class PrivateRemoteListener extends IRemotePlayerListener.Stub {
        public PrivateHandler mHandler;
        public CyberPlayerManager.HttpDNS mHttpDNS;
        public ICyberMsgHandler mInjectedHandler;

        public PrivateRemoteListener(PrivateHandler privateHandler, ICyberMsgHandler iCyberMsgHandler, CyberPlayerManager.HttpDNS httpDNS) {
            this.mHandler = privateHandler;
            this.mHttpDNS = httpDNS;
            this.mInjectedHandler = iCyberMsgHandler;
        }

        @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayerListener
        public boolean onError(int i, int i2, String str) {
            PrivateHandler privateHandler = this.mHandler;
            if (privateHandler != null) {
                Message obtain = Message.obtain(privateHandler, 5);
                obtain.arg1 = i;
                obtain.arg2 = i2;
                obtain.obj = str;
                ICyberMsgHandler iCyberMsgHandler = this.mInjectedHandler;
                if (iCyberMsgHandler != null) {
                    iCyberMsgHandler.sendMessage(obtain);
                    return true;
                }
                this.mHandler.sendMessage(obtain);
                return true;
            }
            return true;
        }

        @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayerListener
        public boolean onMediaSourceChanged(int i, int i2, String str) {
            PrivateHandler privateHandler = this.mHandler;
            if (privateHandler != null) {
                Message obtain = Message.obtain(privateHandler, 7);
                obtain.arg1 = i;
                obtain.arg2 = i2;
                obtain.obj = str;
                ICyberMsgHandler iCyberMsgHandler = this.mInjectedHandler;
                if (iCyberMsgHandler != null) {
                    iCyberMsgHandler.sendMessage(obtain);
                    return true;
                }
                this.mHandler.sendMessage(obtain);
                return true;
            }
            return true;
        }

        @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayerListener
        public void onBufferingUpdate(int i) {
            PrivateHandler privateHandler = this.mHandler;
            if (privateHandler != null) {
                Message obtain = Message.obtain(privateHandler, 2);
                obtain.arg1 = i;
                ICyberMsgHandler iCyberMsgHandler = this.mInjectedHandler;
                if (iCyberMsgHandler != null) {
                    iCyberMsgHandler.sendMessage(obtain);
                } else {
                    this.mHandler.sendMessage(obtain);
                }
            }
        }

        @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayerListener
        public void onMediaRuntimeInfo(String str) {
            PrivateHandler privateHandler = this.mHandler;
            if (privateHandler != null) {
                Message obtain = Message.obtain(privateHandler, 8);
                obtain.obj = str;
                ICyberMsgHandler iCyberMsgHandler = this.mInjectedHandler;
                if (iCyberMsgHandler != null) {
                    iCyberMsgHandler.sendMessage(obtain);
                } else {
                    this.mHandler.sendMessage(obtain);
                }
            }
        }

        @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayerListener
        public void onCallback(String str, List<String> list) {
            if (str.equals("onHttpDNS")) {
                if (this.mHttpDNS != null && list != null && list.size() > 0) {
                    list.clear();
                    List<String> ipList = this.mHttpDNS.getIpList(list.get(0));
                    if (ipList != null) {
                        list.addAll(ipList);
                    }
                } else if (list != null) {
                    list.clear();
                }
            }
        }

        @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayerListener
        public synchronized void onCompletion() {
            if (this.mHandler != null) {
                if (this.mInjectedHandler != null) {
                    this.mInjectedHandler.sendEmptyMessage(this.mHandler, 1);
                } else {
                    this.mHandler.sendEmptyMessage(1);
                }
            }
        }

        @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayerListener
        public void onPrepared() {
            PrivateHandler privateHandler = this.mHandler;
            if (privateHandler != null) {
                ICyberMsgHandler iCyberMsgHandler = this.mInjectedHandler;
                if (iCyberMsgHandler != null) {
                    iCyberMsgHandler.sendEmptyMessage(privateHandler, 0);
                } else {
                    privateHandler.sendEmptyMessage(0);
                }
            }
        }

        @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayerListener
        public void onSeekComplete() {
            PrivateHandler privateHandler = this.mHandler;
            if (privateHandler != null) {
                ICyberMsgHandler iCyberMsgHandler = this.mInjectedHandler;
                if (iCyberMsgHandler != null) {
                    iCyberMsgHandler.sendEmptyMessage(privateHandler, 3);
                } else {
                    privateHandler.sendEmptyMessage(3);
                }
            }
        }

        public void release() {
            this.mHandler = null;
            this.mHttpDNS = null;
        }

        @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayerListener
        public boolean onInfo(int i, int i2, String str) {
            RemotePlayerProxy playerProxy;
            PrivateHandler privateHandler = this.mHandler;
            if (privateHandler != null) {
                if (904 == i && (playerProxy = privateHandler.getPlayerProxy()) != null && playerProxy.mFirstDispNotifyEnable) {
                    playerProxy.mOnInfoListener.onInfo(CyberPlayerManager.MEDIA_INFO_FIRST_DISP_INTERVAL_SUB_T, i2, str);
                }
                Message obtain = Message.obtain(this.mHandler, 6);
                obtain.arg1 = i;
                obtain.arg2 = i2;
                obtain.obj = str;
                ICyberMsgHandler iCyberMsgHandler = this.mInjectedHandler;
                if (iCyberMsgHandler != null) {
                    iCyberMsgHandler.sendMessage(obtain);
                    return true;
                }
                this.mHandler.sendMessage(obtain);
                return true;
            }
            return true;
        }

        @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayerListener
        public void onVideoSizeChanged(int i, int i2, int i3, int i4) {
            PrivateHandler privateHandler = this.mHandler;
            if (privateHandler != null) {
                Message obtain = Message.obtain(privateHandler, 4);
                obtain.obj = new int[]{i, i2, i3, i4};
                ICyberMsgHandler iCyberMsgHandler = this.mInjectedHandler;
                if (iCyberMsgHandler != null) {
                    iCyberMsgHandler.sendMessage(obtain);
                } else {
                    this.mHandler.sendMessage(obtain);
                }
            }
        }
    }

    public RemotePlayerProxy(IRemotePlayer iRemotePlayer, CyberPlayerManager.HttpDNS httpDNS) {
        this.mRemotePlayer = iRemotePlayer;
        this.mHttpDNS = httpDNS;
        if (CyberPlayerManager.getCyberMediaContext() != null) {
            this.mInjectedHandler = CyberPlayerManager.getCyberMediaContext().getCyberMsgHandler();
        }
        PrivateRemoteListener privateRemoteListener = new PrivateRemoteListener(this.mAsyncMessageHandler, this.mInjectedHandler, httpDNS);
        this.mRemotePlayerListener = privateRemoteListener;
        IRemotePlayer iRemotePlayer2 = this.mRemotePlayer;
        if (iRemotePlayer2 != null) {
            try {
                iRemotePlayer2.addListener(privateRemoteListener);
                RemotePlayerFactory.getInstance().addListener(this);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void seekTo(long j) {
        seekTo(j, 3);
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setClarityInfo(String str) {
        IRemotePlayer iRemotePlayer = this.mRemotePlayer;
        if (iRemotePlayer != null) {
            try {
                iRemotePlayer.setClarityInfo(str);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setDataSource(FileDescriptor fileDescriptor) {
        CyberPlayerManager.OnErrorListener onErrorListener = this.mOnErrorListener;
        if (onErrorListener != null) {
            onErrorListener.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, "setDataSource(FileDescriptor)");
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setDisplay(SurfaceHolder surfaceHolder) {
        Surface surface;
        if (this.mRemotePlayer == null) {
            return;
        }
        if (surfaceHolder != null) {
            try {
                surface = surfaceHolder.getSurface();
            } catch (RemoteException e) {
                e.printStackTrace();
                CyberPlayerManager.OnErrorListener onErrorListener = this.mOnErrorListener;
                if (onErrorListener != null) {
                    onErrorListener.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, "setDisplay()");
                    return;
                }
                return;
            }
        } else {
            surface = null;
        }
        this.mRemotePlayer.setSurface(surface);
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setEnableDumediaUA(boolean z) {
        IRemotePlayer iRemotePlayer = this.mRemotePlayer;
        if (iRemotePlayer == null) {
            return;
        }
        try {
            iRemotePlayer.setEnableDumediaUA(z);
        } catch (RemoteException e) {
            e.printStackTrace();
            CyberPlayerManager.OnErrorListener onErrorListener = this.mOnErrorListener;
            if (onErrorListener != null) {
                onErrorListener.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, "setEnableDumediaUA(boolean)");
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setLooping(boolean z) {
        IRemotePlayer iRemotePlayer = this.mRemotePlayer;
        if (iRemotePlayer == null) {
            return;
        }
        try {
            iRemotePlayer.setLooping(z);
        } catch (RemoteException e) {
            e.printStackTrace();
            CyberPlayerManager.OnErrorListener onErrorListener = this.mOnErrorListener;
            if (onErrorListener != null) {
                onErrorListener.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, "setLooping(boolean)");
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnBufferingUpdateListener(CyberPlayerManager.OnBufferingUpdateListener onBufferingUpdateListener) {
        this.mOnBufferingUpdateListener = onBufferingUpdateListener;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnCompletionListener(CyberPlayerManager.OnCompletionListener onCompletionListener) {
        this.mOnCompletionListener = onCompletionListener;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnErrorListener(CyberPlayerManager.OnErrorListener onErrorListener) {
        this.mOnErrorListener = onErrorListener;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnInfoListener(CyberPlayerManager.OnInfoListener onInfoListener) {
        this.mOnInfoListener = onInfoListener;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnMediaSourceChangedListener(CyberPlayerManager.OnMediaSourceChangedListener onMediaSourceChangedListener) {
        this.mMediaSourceChangedListener = onMediaSourceChangedListener;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnPreparedListener(CyberPlayerManager.OnPreparedListener onPreparedListener) {
        this.mOnPreparedListener = onPreparedListener;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnSeekCompleteListener(CyberPlayerManager.OnSeekCompleteListener onSeekCompleteListener) {
        this.mOnSeekCompleteListener = onSeekCompleteListener;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnVideoSizeChangedListener(CyberPlayerManager.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        this.mOnVideoSizeChangeListener = onVideoSizeChangedListener;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOptions(Map<String, String> map) {
        if (this.mRemotePlayer == null) {
            return;
        }
        if (map != null) {
            try {
                if (map.containsKey(CyberPlayerManager.OPT_FIRST_DISP_NOTIFY_SUB_T)) {
                    this.mFirstDispNotifyEnable = TextUtils.equals(map.get(CyberPlayerManager.OPT_FIRST_DISP_NOTIFY_SUB_T), "1");
                }
            } catch (RemoteException unused) {
                CyberPlayerManager.OnErrorListener onErrorListener = this.mOnErrorListener;
                if (onErrorListener != null) {
                    onErrorListener.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, "setOptions(Map)");
                    return;
                }
                return;
            }
        }
        this.mRemotePlayer.setOptions(map);
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setPlayJson(String str) {
        try {
            if (this.mRemotePlayer != null) {
                this.mRemotePlayer.setPlayJson(str);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
            CyberPlayerManager.OnErrorListener onErrorListener = this.mOnErrorListener;
            if (onErrorListener != null) {
                onErrorListener.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, "setPlayJson(String)");
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setScreenOnWhilePlaying(boolean z) {
        IRemotePlayer iRemotePlayer = this.mRemotePlayer;
        if (iRemotePlayer == null) {
            return;
        }
        try {
            iRemotePlayer.setScreenOnWhilePlaying(z);
        } catch (RemoteException e) {
            e.printStackTrace();
            CyberPlayerManager.OnErrorListener onErrorListener = this.mOnErrorListener;
            if (onErrorListener != null) {
                onErrorListener.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, "setScreenOnWhilePlaying(boolean)");
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setSpeed(float f) {
        IRemotePlayer iRemotePlayer = this.mRemotePlayer;
        if (iRemotePlayer == null) {
            return;
        }
        try {
            iRemotePlayer.setSpeed(f);
        } catch (RemoteException e) {
            e.printStackTrace();
            CyberPlayerManager.OnErrorListener onErrorListener = this.mOnErrorListener;
            if (onErrorListener != null) {
                onErrorListener.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, "setSpeed(float)");
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setSurface(Surface surface) {
        if (this.mRemotePlayer == null) {
            return;
        }
        Surface surface2 = this.mSurface;
        if (surface2 == surface && surface2 != null) {
            return;
        }
        try {
            this.mRemotePlayer.setSurface(surface);
            this.mSurface = surface;
        } catch (RemoteException e) {
            e.printStackTrace();
            CyberPlayerManager.OnErrorListener onErrorListener = this.mOnErrorListener;
            if (onErrorListener != null) {
                onErrorListener.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, "setSurface()");
            }
            this.mSurface = null;
        }
    }

    public static RemotePlayerProxy create(int i, CyberPlayerManager.HttpDNS httpDNS) {
        IRemotePlayer asInterface = IRemotePlayer.Stub.asInterface(RemotePlayerFactory.getInstance().createPlayer(i));
        if (asInterface != null) {
            return new RemotePlayerProxy(asInterface, httpDNS);
        }
        return null;
    }

    private void setDataSource(Uri uri, Map<String, String> map) {
        IRemotePlayer iRemotePlayer = this.mRemotePlayer;
        if (iRemotePlayer == null) {
            return;
        }
        try {
            iRemotePlayer.setDataSource(new RemoteDataSource(uri, map));
        } catch (RemoteException e) {
            e.printStackTrace();
            CyberPlayerManager.OnErrorListener onErrorListener = this.mOnErrorListener;
            if (onErrorListener != null) {
                onErrorListener.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, "setDataSource(Uri, Map)");
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void changeProxyDynamic(String str, boolean z) {
        IRemotePlayer iRemotePlayer = this.mRemotePlayer;
        if (iRemotePlayer == null) {
            return;
        }
        try {
            iRemotePlayer.changeProxyDynamic(str, z);
        } catch (RemoteException e) {
            e.printStackTrace();
            CyberPlayerManager.OnErrorListener onErrorListener = this.mOnErrorListener;
            if (onErrorListener != null) {
                onErrorListener.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, "changeProxyDynamic(String, boolean)");
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void getMediaRuntimeInfo(int i, CyberPlayerManager.OnMediaRuntimeInfoListener onMediaRuntimeInfoListener) {
        IRemotePlayer iRemotePlayer = this.mRemotePlayer;
        if (iRemotePlayer == null) {
            return;
        }
        this.mOnMediaRuntimeInfoListener = onMediaRuntimeInfoListener;
        try {
            iRemotePlayer.getMediaRuntimeInfo(i);
        } catch (Exception unused) {
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void seekTo(long j, int i) {
        IRemotePlayer iRemotePlayer = this.mRemotePlayer;
        if (iRemotePlayer == null) {
            return;
        }
        try {
            iRemotePlayer.seekTo(j, i);
        } catch (RemoteException e) {
            e.printStackTrace();
            CyberPlayerManager.OnErrorListener onErrorListener = this.mOnErrorListener;
            if (onErrorListener != null) {
                onErrorListener.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, "seekTo(long)");
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOption(String str, long j) {
        setOption(str, String.valueOf(j));
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setVolume(float f, float f2) {
        IRemotePlayer iRemotePlayer = this.mRemotePlayer;
        if (iRemotePlayer == null) {
            return;
        }
        try {
            iRemotePlayer.setVolume(f, f2);
        } catch (RemoteException e) {
            e.printStackTrace();
            CyberPlayerManager.OnErrorListener onErrorListener = this.mOnErrorListener;
            if (onErrorListener != null) {
                onErrorListener.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, "setVolume(float, float)");
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setWakeMode(Context context, int i) {
        IRemotePlayer iRemotePlayer = this.mRemotePlayer;
        if (iRemotePlayer == null) {
            return;
        }
        try {
            iRemotePlayer.setWakeMode(i);
        } catch (RemoteException e) {
            e.printStackTrace();
            CyberPlayerManager.OnErrorListener onErrorListener = this.mOnErrorListener;
            if (onErrorListener != null) {
                onErrorListener.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, "setWakeMode()");
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void switchMediaSource(int i, CyberPlayerManager.MediaSourceSwitchMode mediaSourceSwitchMode) {
        IRemotePlayer iRemotePlayer = this.mRemotePlayer;
        if (iRemotePlayer != null) {
            try {
                iRemotePlayer.switchMediaSource(i, mediaSourceSwitchMode.ordinal());
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void updateDisplaySize(int i, int i2) {
        try {
            if (this.mRemotePlayer != null) {
                this.mRemotePlayer.updateDisplaySize(i, i2);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.remote.RemotePlayerFactory.RemoteServerListener
    public void binderDied() {
        PrivateHandler privateHandler = this.mAsyncMessageHandler;
        if (privateHandler != null) {
            Message obtain = Message.obtain(privateHandler, 5);
            obtain.arg1 = CyberPlayerManager.MEDIA_ERROR_REMOTE_DIED;
            obtain.arg2 = CyberPlayerManager.MEDIA_ERROR_REMOTE_DIED;
            obtain.obj = "binderState=" + RemotePlayerFactory.getInstance().getBinderState();
            ICyberMsgHandler iCyberMsgHandler = this.mInjectedHandler;
            if (iCyberMsgHandler != null) {
                iCyberMsgHandler.sendMessage(obtain);
            } else {
                this.mAsyncMessageHandler.sendMessage(obtain);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getDecodeMode() {
        IRemotePlayer iRemotePlayer = this.mRemotePlayer;
        if (iRemotePlayer != null) {
            try {
                return iRemotePlayer.getDecodeMode();
            } catch (RemoteException e) {
                e.printStackTrace();
                CyberPlayerManager.OnErrorListener onErrorListener = this.mOnErrorListener;
                if (onErrorListener != null) {
                    onErrorListener.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, "getDecodeMode() binderState=" + RemotePlayerFactory.getInstance().getBinderState());
                }
            }
        }
        return 0;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getCurrentPosition() {
        int i = this.mCurrentPosition;
        if (i > -1) {
            return i;
        }
        IRemotePlayer iRemotePlayer = this.mRemotePlayer;
        if (iRemotePlayer != null) {
            try {
                return iRemotePlayer.getCurrentPosition();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getCurrentPositionSync() {
        IRemotePlayer iRemotePlayer = this.mRemotePlayer;
        if (iRemotePlayer != null) {
            try {
                return iRemotePlayer.getCurrentPositionSync();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public long getDownloadSpeed() {
        IRemotePlayer iRemotePlayer = this.mRemotePlayer;
        if (iRemotePlayer != null) {
            try {
                return iRemotePlayer.getDownloadSpeed();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return 0L;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getDuration() {
        int i = this.mDuration;
        if (i > -1) {
            return i;
        }
        IRemotePlayer iRemotePlayer = this.mRemotePlayer;
        if (iRemotePlayer != null) {
            try {
                int duration = iRemotePlayer.getDuration();
                this.mDuration = duration;
                return duration;
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public long getPlayedTime() {
        IRemotePlayer iRemotePlayer = this.mRemotePlayer;
        if (iRemotePlayer != null) {
            try {
                return iRemotePlayer.getPlayedTime();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return 0L;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public String getPlayerConfigOptions() {
        IRemotePlayer iRemotePlayer = this.mRemotePlayer;
        if (iRemotePlayer != null) {
            try {
                return iRemotePlayer.getPlayerConfigOptions();
            } catch (RemoteException unused) {
            }
        }
        return "";
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getVideoHeight() {
        IRemotePlayer iRemotePlayer = this.mRemotePlayer;
        if (iRemotePlayer != null) {
            try {
                return iRemotePlayer.getVideoHeight();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getVideoWidth() {
        IRemotePlayer iRemotePlayer = this.mRemotePlayer;
        if (iRemotePlayer != null) {
            try {
                return iRemotePlayer.getVideoWidth();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public boolean isLooping() {
        IRemotePlayer iRemotePlayer = this.mRemotePlayer;
        if (iRemotePlayer != null) {
            try {
                return iRemotePlayer.isLooping();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public boolean isPlaying() {
        IRemotePlayer iRemotePlayer = this.mRemotePlayer;
        if (iRemotePlayer != null) {
            try {
                return iRemotePlayer.isPlaying();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void pause() {
        IRemotePlayer iRemotePlayer = this.mRemotePlayer;
        if (iRemotePlayer == null) {
            return;
        }
        try {
            iRemotePlayer.pause();
        } catch (RemoteException e) {
            e.printStackTrace();
            CyberPlayerManager.OnErrorListener onErrorListener = this.mOnErrorListener;
            if (onErrorListener != null) {
                onErrorListener.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, "pause()");
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void prepareAsync() {
        IRemotePlayer iRemotePlayer = this.mRemotePlayer;
        if (iRemotePlayer == null) {
            return;
        }
        try {
            iRemotePlayer.prepareAsync();
        } catch (RemoteException e) {
            e.printStackTrace();
            CyberPlayerManager.OnErrorListener onErrorListener = this.mOnErrorListener;
            if (onErrorListener != null) {
                onErrorListener.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, "prepareAsync()");
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void reset() {
        IRemotePlayer iRemotePlayer = this.mRemotePlayer;
        if (iRemotePlayer == null) {
            return;
        }
        try {
            iRemotePlayer.reset();
            this.mAsyncMessageHandler.removeCallbacksAndMessages(null);
            if (this.mInjectedHandler != null) {
                this.mInjectedHandler.removeCallbacksAndMessages();
            }
        } catch (RemoteException e) {
            e.printStackTrace();
            CyberPlayerManager.OnErrorListener onErrorListener = this.mOnErrorListener;
            if (onErrorListener != null) {
                onErrorListener.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, "reset()");
            }
        }
        this.mDuration = -1;
        this.mCurrentPosition = -1;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void start() {
        IRemotePlayer iRemotePlayer = this.mRemotePlayer;
        if (iRemotePlayer == null) {
            return;
        }
        try {
            iRemotePlayer.start();
        } catch (RemoteException e) {
            e.printStackTrace();
            CyberPlayerManager.OnErrorListener onErrorListener = this.mOnErrorListener;
            if (onErrorListener != null) {
                onErrorListener.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, "start()");
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void stepToNextFrame() {
        IRemotePlayer iRemotePlayer = this.mRemotePlayer;
        if (iRemotePlayer == null) {
            return;
        }
        try {
            iRemotePlayer.stepToNextFrame();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void stop() {
        IRemotePlayer iRemotePlayer = this.mRemotePlayer;
        if (iRemotePlayer == null) {
            return;
        }
        try {
            iRemotePlayer.stop();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void muteOrUnmuteAudio(boolean z) {
        IRemotePlayer iRemotePlayer = this.mRemotePlayer;
        if (iRemotePlayer == null) {
            return;
        }
        try {
            iRemotePlayer.muteOrUnmuteAudio(z);
        } catch (RemoteException e) {
            e.printStackTrace();
            CyberPlayerManager.OnErrorListener onErrorListener = this.mOnErrorListener;
            if (onErrorListener != null) {
                onErrorListener.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, "muteOrUnmuteAudio(" + z + ") binderState=" + RemotePlayerFactory.getInstance().getBinderState());
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE, INVOKE, IPUT, IPUT, IGET, INVOKE, IGET, INVOKE, IPUT, IPUT, IGET]}, finally: {[INVOKE, INVOKE, IPUT, IPUT, IGET, INVOKE, IGET, INVOKE, IPUT, IPUT, IGET, IPUT, IPUT, IPUT, IPUT, IPUT, IPUT, IPUT, IPUT, IPUT, IPUT, IPUT, INVOKE, IPUT, IPUT, IPUT, IPUT, IPUT, IPUT, IPUT, IPUT, IPUT, IPUT, IPUT, IPUT, IF] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0050, code lost:
        if (r0 == null) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0052, code lost:
        r0.removeCallbacksAndMessages();
        r4.mInjectedHandler = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0057, code lost:
        r4.mHttpDNS = null;
        r4.mOnPreparedListener = null;
        r4.mOnCompletionListener = null;
        r4.mOnBufferingUpdateListener = null;
        r4.mOnSeekCompleteListener = null;
        r4.mOnVideoSizeChangeListener = null;
        r4.mOnErrorListener = null;
        r4.mOnInfoListener = null;
        r4.mMediaSourceChangedListener = null;
        r4.mDuration = -1;
        r4.mCurrentPosition = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x006d, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x002c, code lost:
        if (r0 != null) goto L12;
     */
    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void release() {
        ICyberMsgHandler iCyberMsgHandler;
        IRemotePlayer iRemotePlayer = this.mRemotePlayer;
        if (iRemotePlayer == null) {
            return;
        }
        try {
            try {
                iRemotePlayer.removeListener(this.mRemotePlayerListener);
                this.mRemotePlayer.release();
                RemotePlayerFactory.getInstance().removeListener(this);
                this.mRemotePlayer = null;
                this.mSurface = null;
                this.mAsyncMessageHandler.removeCallbacksAndMessages(null);
                this.mRemotePlayerListener.release();
                this.mRemotePlayerListener = null;
                this.mAsyncMessageHandler = null;
                iCyberMsgHandler = this.mInjectedHandler;
            } catch (RemoteException e) {
                e.printStackTrace();
                RemotePlayerFactory.getInstance().removeListener(this);
                this.mRemotePlayer = null;
                this.mSurface = null;
                this.mAsyncMessageHandler.removeCallbacksAndMessages(null);
                this.mRemotePlayerListener.release();
                this.mRemotePlayerListener = null;
                this.mAsyncMessageHandler = null;
                iCyberMsgHandler = this.mInjectedHandler;
            }
        } catch (Throwable th) {
            RemotePlayerFactory.getInstance().removeListener(this);
            this.mRemotePlayer = null;
            this.mSurface = null;
            this.mAsyncMessageHandler.removeCallbacksAndMessages(null);
            this.mRemotePlayerListener.release();
            this.mRemotePlayerListener = null;
            this.mAsyncMessageHandler = null;
            ICyberMsgHandler iCyberMsgHandler2 = this.mInjectedHandler;
            if (iCyberMsgHandler2 != null) {
                iCyberMsgHandler2.removeCallbacksAndMessages();
                this.mInjectedHandler = null;
            }
            this.mHttpDNS = null;
            this.mOnPreparedListener = null;
            this.mOnCompletionListener = null;
            this.mOnBufferingUpdateListener = null;
            this.mOnSeekCompleteListener = null;
            this.mOnVideoSizeChangeListener = null;
            this.mOnErrorListener = null;
            this.mOnInfoListener = null;
            this.mMediaSourceChangedListener = null;
            this.mDuration = -1;
            this.mCurrentPosition = -1;
            throw th;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void sendCommand(int i, int i2, long j, String str) {
        IRemotePlayer iRemotePlayer = this.mRemotePlayer;
        if (iRemotePlayer == null) {
            return;
        }
        try {
            iRemotePlayer.sendCommand(i, i2, j, str);
        } catch (RemoteException e) {
            e.printStackTrace();
            CyberPlayerManager.OnErrorListener onErrorListener = this.mOnErrorListener;
            if (onErrorListener != null) {
                onErrorListener.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, "sendCommand what=" + i + " arg1=" + i2 + " arg2=" + j + " binderState=" + RemotePlayerFactory.getInstance().getBinderState());
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setDataSource(Context context, Uri uri) {
        setDataSource(uri, (Map<String, String>) null);
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOption(String str, String str2) {
        if (this.mRemotePlayer == null) {
            return;
        }
        try {
            if (TextUtils.equals(str, CyberPlayerManager.OPT_FIRST_DISP_NOTIFY_SUB_T)) {
                this.mFirstDispNotifyEnable = TextUtils.equals(str2, "1");
            }
            this.mRemotePlayer.setOption(str, str2);
        } catch (RemoteException e) {
            e.printStackTrace();
            CyberPlayerManager.OnErrorListener onErrorListener = this.mOnErrorListener;
            if (onErrorListener != null) {
                onErrorListener.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, "setOption(String, String)");
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setDataSource(Context context, Uri uri, Map<String, String> map) {
        setDataSource(uri, map);
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setDataSource(String str) {
        setDataSource(Uri.parse(str), (Map<String, String>) null);
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setDataSource(String str, Map<String, String> map) {
        setDataSource(Uri.parse(str), map);
    }
}
