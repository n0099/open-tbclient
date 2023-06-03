package com.baidu.cyberplayer.sdk;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
import com.baidu.cyberplayer.sdk.utils.DuplayerHandlerThread;
import com.baidu.cyberplayer.sdk.utils.DuplayerHandlerThreadPool;
import java.io.FileDescriptor;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Map;
/* loaded from: classes3.dex */
public class l extends PlayerProvider implements CyberPlayerManager.OnBufferingUpdateListener, CyberPlayerManager.OnCompletionListener, CyberPlayerManager.OnErrorListener, CyberPlayerManager.OnInfoListener, CyberPlayerManager.OnPreparedListener, CyberPlayerManager.OnSeekCompleteListener, CyberPlayerManager.OnVideoSizeChangedListener {
    public m a;
    public CyberPlayerManager.OnPreparedListener b;
    public CyberPlayerManager.OnCompletionListener c;
    public CyberPlayerManager.OnBufferingUpdateListener d;
    public CyberPlayerManager.OnSeekCompleteListener e;
    public CyberPlayerManager.OnVideoSizeChangedListener f;
    public CyberPlayerManager.OnErrorListener g;
    public CyberPlayerManager.OnInfoListener h;
    public CyberPlayerManager.OnMediaSourceChangedListener i;
    public int j;
    public int k;
    public a l;
    public b m;
    public DuplayerHandlerThread n;
    public boolean o;

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getDecodeMode() {
        return 4;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void getMediaRuntimeInfo(CyberPlayerManager.OnMediaRuntimeInfoListener onMediaRuntimeInfoListener) {
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public String getPlayerConfigOptions() {
        return "";
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public boolean isRemotePlayer() {
        return false;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void stepToNextFrame() {
    }

    /* loaded from: classes3.dex */
    public static class a extends Handler {
        public final WeakReference<l> a;
        public boolean b;
        public int c;
        public int d;

        public a(l lVar, Looper looper) {
            super(looper);
            this.b = CyberCfgManager.getInstance().getCfgBoolValue(CyberCfgManager.KEY_INT_ENABLE_HEARTBEAT_UPLOAD_STATISTICS, true);
            this.c = CyberCfgManager.getInstance().getCfgIntValue(CyberCfgManager.KEY_INT_HEARTBEAT_UPLOAD_STATISTICS_PERIOD, 3600);
            this.d = CyberCfgManager.getInstance().getCfgIntValue(CyberCfgManager.KEY_INT_HEARTBEAT_UPLOAD_COUNT_MAX, 10);
            this.a = new WeakReference<>(lVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            l lVar = this.a.get();
            if (lVar == null) {
                CyberLog.e("MediaPlayerAsync", "EventHandler,MediaPlayerImpl went away with unhandled events msg.what:" + message.what);
                return;
            }
            CyberLog.i("MediaPlayerAsync", "EventHandler handleMessage what=" + message.what);
            int i = message.what;
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i == 5) {
                                lVar.j = message.arg1;
                                lVar.k = message.arg2;
                                if (lVar.f != null) {
                                    lVar.f.onVideoSizeChanged(message.arg1, message.arg2, 1, 1);
                                    return;
                                }
                                return;
                            } else if (i != 7) {
                                if (i != 8) {
                                    if (i != 9) {
                                        if (i != 100) {
                                            CyberLog.e("MediaPlayerAsync", "EventHandler Unknown message type=" + message.what);
                                            return;
                                        }
                                        int i2 = message.arg1;
                                        lVar.a.a(i2);
                                        int i3 = i2 + 1;
                                        Message obtainMessage = obtainMessage(100, i3, -1, null);
                                        if (i3 < this.d) {
                                            sendMessageDelayed(obtainMessage, this.c * 1000);
                                            return;
                                        }
                                        return;
                                    } else if (lVar.i != null) {
                                        lVar.i.onMediaSourceChanged(message.arg1, message.arg2, null);
                                        return;
                                    } else {
                                        return;
                                    }
                                } else if (lVar.h != null) {
                                    lVar.h.onInfo(message.arg1, message.arg2, null);
                                    return;
                                } else {
                                    return;
                                }
                            } else if (lVar.g != null) {
                                lVar.g.onError(message.arg1, message.arg2, null);
                                return;
                            } else {
                                return;
                            }
                        } else if (lVar.e != null) {
                            lVar.e.onSeekComplete();
                            lVar.b(8, 910, lVar.a.getCurrentPosition(), null);
                            return;
                        } else {
                            return;
                        }
                    } else if (lVar.d != null) {
                        lVar.d.onBufferingUpdate(message.arg1);
                        return;
                    } else {
                        return;
                    }
                } else if (lVar.c != null) {
                    lVar.c.onCompletion();
                    return;
                } else {
                    return;
                }
            }
            if (lVar.b != null) {
                lVar.b.onPrepared();
            }
            if (this.b) {
                sendMessageDelayed(obtainMessage(100, 0, -1, null), this.c * 1000);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends Handler {
        public final WeakReference<l> a;

        public b(l lVar, Looper looper) {
            super(looper);
            this.a = new WeakReference<>(lVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            float f;
            l lVar = this.a.get();
            if (lVar != null && (lVar.a != null || message.what == 8)) {
                CyberLog.i("MediaPlayerAsync", "RequestHandler handleMessage what=" + message.what);
                switch (message.what) {
                    case 1:
                        lVar.a.stop();
                        return;
                    case 2:
                        try {
                            lVar.a.setOnPreparedListener(null);
                            lVar.a.setOnCompletionListener(null);
                            lVar.a.setOnBufferingUpdateListener(null);
                            lVar.a.setOnSeekCompleteListener(null);
                            lVar.a.setOnVideoSizeChangedListener(null);
                            lVar.a.setOnErrorListener(null);
                            lVar.a.setOnInfoListener(null);
                            lVar.a.release();
                            lVar.a = null;
                            return;
                        } catch (Exception unused) {
                            return;
                        }
                    case 3:
                        lVar.a.reset();
                        return;
                    case 4:
                        lVar.a.pause();
                        return;
                    case 5:
                        lVar.a.start();
                        sendEmptyMessageDelayed(23, 1000L);
                        return;
                    case 6:
                        lVar.a.prepareAsync();
                        return;
                    case 7:
                        if (message.obj instanceof Long) {
                            lVar.a.seekTo((int) ((Long) message.obj).longValue(), message.arg1);
                            return;
                        }
                        return;
                    case 8:
                        lVar.d();
                        return;
                    case 9:
                        Object obj = message.obj;
                        if (obj != null) {
                            if ((obj instanceof Surface) && ((Surface) obj).isValid()) {
                                try {
                                    lVar.a.setSurface((Surface) message.obj);
                                    return;
                                } catch (Exception unused2) {
                                    CyberLog.e("MediaPlayerAsync", "setSurface exception!");
                                    return;
                                }
                            }
                            return;
                        }
                        lVar.a.setSurface(null);
                        return;
                    case 10:
                        if (message.obj instanceof FileDescriptor) {
                            lVar.a.setDataSource((FileDescriptor) message.obj);
                            return;
                        }
                        return;
                    case 11:
                        Object obj2 = message.obj;
                        if (obj2 instanceof Boolean) {
                            if (((Boolean) obj2).booleanValue()) {
                                f = 0.0f;
                            } else {
                                f = 1.0f;
                            }
                            lVar.a.setVolume(f, f);
                            return;
                        }
                        return;
                    case 12:
                        Object obj3 = message.obj;
                        if (obj3 instanceof ArrayList) {
                            ArrayList arrayList = (ArrayList) obj3;
                            lVar.a.setDataSource((Context) arrayList.get(0), (Uri) arrayList.get(1));
                            return;
                        }
                        return;
                    case 13:
                        Object obj4 = message.obj;
                        if (obj4 instanceof ArrayList) {
                            ArrayList arrayList2 = (ArrayList) obj4;
                            lVar.a.setDataSource((Context) arrayList2.get(0), (Uri) arrayList2.get(1), (Map) arrayList2.get(2));
                            return;
                        }
                        return;
                    case 14:
                        if (message.obj instanceof String) {
                            lVar.a.setDataSource(String.valueOf(message.obj));
                            return;
                        }
                        return;
                    case 15:
                        Object obj5 = message.obj;
                        if (obj5 instanceof ArrayList) {
                            ArrayList arrayList3 = (ArrayList) obj5;
                            try {
                                lVar.a.setDataSource((String) arrayList3.get(0), (Map) arrayList3.get(1));
                                return;
                            } catch (IllegalArgumentException e) {
                                lVar.b(7, -1004, -1004, null);
                                e.printStackTrace();
                                return;
                            }
                        }
                        return;
                    case 16:
                        Object obj6 = message.obj;
                        if (obj6 instanceof ArrayList) {
                            ArrayList arrayList4 = (ArrayList) obj6;
                            int intValue = ((Integer) arrayList4.get(1)).intValue();
                            lVar.a.setWakeMode((Context) arrayList4.get(0), intValue);
                            return;
                        }
                        return;
                    case 17:
                        if (message.obj instanceof Boolean) {
                            lVar.a.setScreenOnWhilePlaying(((Boolean) message.obj).booleanValue());
                            return;
                        }
                        return;
                    case 18:
                        Object obj7 = message.obj;
                        if (obj7 != null) {
                            if ((obj7 instanceof SurfaceHolder) && ((SurfaceHolder) obj7).getSurface() != null && ((SurfaceHolder) message.obj).getSurface().isValid()) {
                                try {
                                    lVar.a.setDisplay((SurfaceHolder) message.obj);
                                    return;
                                } catch (Exception unused3) {
                                    CyberLog.e("MediaPlayerAsync", "setDisplay exception!");
                                    return;
                                }
                            }
                            return;
                        }
                        lVar.a.setDisplay(null);
                        return;
                    case 19:
                        if (message.obj instanceof Boolean) {
                            lVar.a.setLooping(((Boolean) message.obj).booleanValue());
                            return;
                        }
                        return;
                    case 20:
                        Object obj8 = message.obj;
                        if (obj8 instanceof ArrayList) {
                            ArrayList arrayList5 = (ArrayList) obj8;
                            lVar.a.setVolume(((Float) arrayList5.get(0)).floatValue(), ((Float) arrayList5.get(1)).floatValue());
                            return;
                        }
                        return;
                    case 21:
                        Object obj9 = message.obj;
                        if (obj9 instanceof Float) {
                            lVar.a.setSpeed(((Float) obj9).floatValue());
                            return;
                        }
                        return;
                    case 22:
                        Object obj10 = message.obj;
                        if (obj10 instanceof ArrayList) {
                            ArrayList arrayList6 = (ArrayList) obj10;
                            boolean booleanValue = ((Boolean) arrayList6.get(1)).booleanValue();
                            lVar.a.changeProxyDynamic((String) arrayList6.get(0), booleanValue);
                            return;
                        }
                        return;
                    case 23:
                        try {
                            if (!lVar.a.isPlaying()) {
                                return;
                            }
                            lVar.b(8, 910, lVar.a.getCurrentPosition(), null);
                            if (!hasMessages(23)) {
                                sendEmptyMessageDelayed(23, 1000L);
                                return;
                            }
                            return;
                        } catch (Exception unused4) {
                            CyberLog.e("MediaPlayerAsync", "REQ_UPDATE_POSITION exception!");
                            return;
                        }
                    default:
                        CyberLog.e("MediaPlayerAsync", "RequestHandler Unknown message type=" + message.what);
                        return;
                }
            }
            CyberLog.e("MediaPlayerAsync", "RequestHandler,MediaPlayerImpl went away with unhandled events msg.what:" + message.what);
        }
    }

    public l() {
        c();
    }

    public static PlayerProvider a() {
        l lVar = new l();
        if (!lVar.b()) {
            lVar.release();
            return null;
        }
        return lVar;
    }

    private synchronized void e() {
        CyberLog.i("MediaPlayerAsync", "quitRequestHandlerThread");
        if (this.o) {
            DuplayerHandlerThreadPool.getInstance().recycle(this.n);
            this.n = null;
        }
    }

    public boolean b() {
        if (this.o && this.m != null && this.n != null) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getCurrentPosition() {
        m mVar = this.a;
        if (mVar != null) {
            return mVar.getCurrentPosition();
        }
        return 0;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getCurrentPositionSync() {
        m mVar = this.a;
        if (mVar != null) {
            return mVar.getCurrentPositionSync();
        }
        return 0;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public long getDownloadSpeed() {
        m mVar = this.a;
        if (mVar != null) {
            return mVar.getDownloadSpeed();
        }
        return 0L;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getDuration() {
        m mVar = this.a;
        if (mVar != null) {
            return mVar.getDuration();
        }
        return -1;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public long getPlayedTime() {
        m mVar = this.a;
        if (mVar != null) {
            return mVar.getPlayedTime();
        }
        return 0L;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getVideoHeight() {
        return this.k;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getVideoWidth() {
        return this.j;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public boolean isLooping() {
        m mVar = this.a;
        if (mVar != null && mVar.isLooping()) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public boolean isPlaying() {
        m mVar = this.a;
        if (mVar != null && mVar.isPlaying()) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
    public void onCompletion() {
        b(2);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
    public void onPrepared() {
        b(1);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
    public void onSeekComplete() {
        b(4);
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void pause() {
        a(4);
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void prepareAsync() {
        a(6);
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void release() {
        b bVar = this.m;
        if (bVar != null) {
            bVar.removeCallbacksAndMessages(null);
        }
        this.l.removeCallbacksAndMessages(null);
        a(2);
        e();
        this.m = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void reset() {
        b bVar = this.m;
        if (bVar != null) {
            bVar.removeCallbacksAndMessages(null);
        }
        this.l.removeCallbacksAndMessages(null);
        a(3);
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void start() {
        a(5);
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void stop() {
        a(1);
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void changeProxyDynamic(String str, boolean z) {
        a(22, -1, -1, a(str, Boolean.valueOf(z)));
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void seekTo(long j, int i) {
        a(7, i, -1, Long.valueOf(j));
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setDataSource(Context context, Uri uri) {
        a(12, -1, -1, a(context, uri));
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setVolume(float f, float f2) {
        a(20, -1, -1, a(Float.valueOf(f), Float.valueOf(f2)));
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setWakeMode(Context context, int i) {
        a(16, -1, -1, a(context, Integer.valueOf(i)));
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void switchMediaSource(int i, CyberPlayerManager.MediaSourceSwitchMode mediaSourceSwitchMode) {
        if (this.i != null) {
            if (mediaSourceSwitchMode == CyberPlayerManager.MediaSourceSwitchMode.MEDIASOURCE_SWITCH_ABR_MODE) {
                b(9, 0, i, null);
            } else {
                b(9, -100, i, null);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void muteOrUnmuteAudio(boolean z) {
        a(11, -1, -1, Boolean.valueOf(z));
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnBufferingUpdateListener
    public void onBufferingUpdate(int i) {
        b(3, i, -1, null);
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void seekTo(long j) {
        seekTo(j, 3);
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setDataSource(FileDescriptor fileDescriptor) {
        a(10, -1, -1, fileDescriptor);
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setDisplay(SurfaceHolder surfaceHolder) {
        a(18, -1, -1, surfaceHolder);
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setLooping(boolean z) {
        a(19, -1, -1, Boolean.valueOf(z));
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnBufferingUpdateListener(CyberPlayerManager.OnBufferingUpdateListener onBufferingUpdateListener) {
        this.d = onBufferingUpdateListener;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnCompletionListener(CyberPlayerManager.OnCompletionListener onCompletionListener) {
        this.c = onCompletionListener;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnErrorListener(CyberPlayerManager.OnErrorListener onErrorListener) {
        this.g = onErrorListener;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnInfoListener(CyberPlayerManager.OnInfoListener onInfoListener) {
        this.h = onInfoListener;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnMediaSourceChangedListener(CyberPlayerManager.OnMediaSourceChangedListener onMediaSourceChangedListener) {
        this.i = onMediaSourceChangedListener;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnPreparedListener(CyberPlayerManager.OnPreparedListener onPreparedListener) {
        this.b = onPreparedListener;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnSeekCompleteListener(CyberPlayerManager.OnSeekCompleteListener onSeekCompleteListener) {
        this.e = onSeekCompleteListener;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnVideoSizeChangedListener(CyberPlayerManager.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        this.f = onVideoSizeChangedListener;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setScreenOnWhilePlaying(boolean z) {
        a(17, -1, -1, Boolean.valueOf(z));
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setSpeed(float f) {
        a(21, -1, -1, Float.valueOf(f));
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setSurface(Surface surface) {
        a(9, 0, 0, surface);
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setDataSource(String str, Map<String, String> map) {
        a(15, -1, -1, a(str, map));
    }

    private ArrayList<Object> a(Object... objArr) {
        ArrayList<Object> arrayList = new ArrayList<>();
        for (Object obj : objArr) {
            arrayList.add(obj);
        }
        return arrayList;
    }

    private boolean b(int i) {
        if (this.o) {
            a aVar = this.l;
            if (aVar != null) {
                aVar.sendEmptyMessage(i);
                return true;
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setDataSource(String str) {
        a(14, -1, -1, str);
    }

    private boolean a(int i) {
        if (this.o) {
            b bVar = this.m;
            if (bVar != null) {
                bVar.sendEmptyMessage(i);
                return true;
            }
            return true;
        }
        return false;
    }

    private boolean a(int i, int i2, int i3, Object obj) {
        if (this.o) {
            b bVar = this.m;
            if (bVar != null) {
                this.m.sendMessage(bVar.obtainMessage(i, i2, i3, obj));
                return true;
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(int i, int i2, int i3, Object obj) {
        if (this.o) {
            a aVar = this.l;
            if (aVar != null) {
                this.l.sendMessage(aVar.obtainMessage(i, i2, i3, obj));
                return true;
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnVideoSizeChangedListener
    public void onVideoSizeChanged(int i, int i2, int i3, int i4) {
        b(5, i, i2, null);
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void sendCommand(int i, int i2, long j, String str) {
        try {
            if (this.a != null) {
                this.a.sendCommand(i, i2, j, str);
            }
        } catch (Exception unused) {
        }
    }

    private void c() {
        Looper myLooper = Looper.myLooper();
        if (myLooper != null) {
            this.l = new a(this, myLooper);
        } else {
            Looper mainLooper = Looper.getMainLooper();
            if (mainLooper != null) {
                this.l = new a(this, mainLooper);
            } else {
                this.l = null;
            }
        }
        this.o = false;
        if (q.o() && Thread.currentThread() != Looper.getMainLooper().getThread()) {
            CyberLog.i("MediaPlayerAsync", "initPlayer, don't use request handler. thread:" + Thread.currentThread().getName());
            this.m = null;
        } else {
            this.n = DuplayerHandlerThreadPool.getInstance().obtain();
            this.m = new b(this, this.n.getLooper());
            CyberLog.i("MediaPlayerAsync", "initPlayer, use request handler. thread:" + Thread.currentThread().getName() + " request thread:" + this.n.getName() + " mRequestHandler:" + this.m);
            this.o = true;
        }
        a(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void d() {
        this.a = new m();
        CyberLog.i("MediaPlayerAsync", "createPlayer mPlayer=" + this.a);
        this.a.setOnPreparedListener(this);
        this.a.setOnCompletionListener(this);
        this.a.setOnBufferingUpdateListener(this);
        this.a.setOnSeekCompleteListener(this);
        this.a.setOnVideoSizeChangedListener(this);
        this.a.setOnErrorListener(this);
        this.a.setOnInfoListener(this);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
    public boolean onError(int i, int i2, Object obj) {
        return b(7, i, i2, null);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
    public boolean onInfo(int i, int i2, Object obj) {
        return b(8, i, i2, null);
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setDataSource(Context context, Uri uri, Map<String, String> map) {
        a(13, -1, -1, a(context, uri, map));
    }
}
