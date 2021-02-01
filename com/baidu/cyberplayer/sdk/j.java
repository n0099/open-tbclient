package com.baidu.cyberplayer.sdk;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.utils.DuplayerHandlerThread;
import com.baidu.cyberplayer.sdk.utils.DuplayerHandlerThreadPool;
import java.io.FileDescriptor;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Map;
/* loaded from: classes4.dex */
public class j extends PlayerProvider implements CyberPlayerManager.OnBufferingUpdateListener, CyberPlayerManager.OnCompletionListener, CyberPlayerManager.OnErrorListener, CyberPlayerManager.OnInfoListener, CyberPlayerManager.OnPreparedListener, CyberPlayerManager.OnSeekCompleteListener, CyberPlayerManager.OnVideoSizeChangedListener {

    /* renamed from: a  reason: collision with root package name */
    private k f1774a;

    /* renamed from: b  reason: collision with root package name */
    private CyberPlayerManager.OnPreparedListener f1775b;
    private CyberPlayerManager.OnCompletionListener c;
    private CyberPlayerManager.OnBufferingUpdateListener d;
    private CyberPlayerManager.OnSeekCompleteListener e;
    private CyberPlayerManager.OnVideoSizeChangedListener f;
    private CyberPlayerManager.OnErrorListener g;
    private CyberPlayerManager.OnInfoListener h;
    private int i;
    private int j;
    private a k;
    private b l;
    private DuplayerHandlerThread m;
    private boolean n;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class a extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference<j> f1776a;

        public a(j jVar, Looper looper) {
            super(looper);
            this.f1776a = new WeakReference<>(jVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            j jVar = this.f1776a.get();
            if (jVar == null) {
                CyberLog.e("MediaPlayerAsync", "EventHandler,MediaPlayerImpl went away with unhandled events msg.what:" + message.what);
                return;
            }
            CyberLog.i("MediaPlayerAsync", "EventHandler handleMessage what=" + message.what);
            switch (message.what) {
                case 1:
                    if (jVar.f1775b != null) {
                        jVar.f1775b.onPrepared();
                        return;
                    }
                    return;
                case 2:
                    if (jVar.c != null) {
                        jVar.c.onCompletion();
                        return;
                    }
                    return;
                case 3:
                    if (jVar.d != null) {
                        jVar.d.onBufferingUpdate(message.arg1);
                        return;
                    }
                    return;
                case 4:
                    if (jVar.e != null) {
                        jVar.e.onSeekComplete();
                        return;
                    }
                    return;
                case 5:
                    jVar.i = message.arg1;
                    jVar.j = message.arg2;
                    if (jVar.f != null) {
                        jVar.f.onVideoSizeChanged(message.arg1, message.arg2, 1, 1);
                        return;
                    }
                    return;
                case 6:
                default:
                    CyberLog.e("MediaPlayerAsync", "EventHandler Unknown message type=" + message.what);
                    return;
                case 7:
                    if (jVar.g != null) {
                        jVar.g.onError(message.arg1, message.arg2, null);
                        return;
                    }
                    return;
                case 8:
                    if (jVar.h != null) {
                        jVar.h.onInfo(message.arg1, message.arg2, null);
                        return;
                    }
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class b extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference<j> f1777a;

        public b(j jVar, Looper looper) {
            super(looper);
            this.f1777a = new WeakReference<>(jVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            j jVar = this.f1777a.get();
            if (jVar == null || (jVar.f1774a == null && message.what != 8)) {
                CyberLog.e("MediaPlayerAsync", "RequestHandler,MediaPlayerImpl went away with unhandled events msg.what:" + message.what);
                return;
            }
            CyberLog.i("MediaPlayerAsync", "RequestHandler handleMessage what=" + message.what);
            switch (message.what) {
                case 1:
                    jVar.f1774a.stop();
                    return;
                case 2:
                    try {
                        jVar.f1774a.setOnPreparedListener(null);
                        jVar.f1774a.setOnCompletionListener(null);
                        jVar.f1774a.setOnBufferingUpdateListener(null);
                        jVar.f1774a.setOnSeekCompleteListener(null);
                        jVar.f1774a.setOnVideoSizeChangedListener(null);
                        jVar.f1774a.setOnErrorListener(null);
                        jVar.f1774a.setOnInfoListener(null);
                        jVar.f1774a.release();
                        jVar.f1774a = null;
                        return;
                    } catch (Exception e) {
                        return;
                    }
                case 3:
                    jVar.f1774a.reset();
                    return;
                case 4:
                    jVar.f1774a.pause();
                    return;
                case 5:
                    jVar.f1774a.start();
                    return;
                case 6:
                    jVar.f1774a.prepareAsync();
                    return;
                case 7:
                    if (message.obj instanceof Long) {
                        jVar.f1774a.seekTo((int) ((Long) message.obj).longValue());
                        return;
                    }
                    return;
                case 8:
                    jVar.d();
                    return;
                case 9:
                    if (message.obj == null) {
                        jVar.f1774a.setSurface(null);
                        return;
                    } else if ((message.obj instanceof Surface) && ((Surface) message.obj).isValid()) {
                        try {
                            jVar.f1774a.setSurface((Surface) message.obj);
                            return;
                        } catch (Exception e2) {
                            CyberLog.e("MediaPlayerAsync", "setSurface exception!");
                            return;
                        }
                    } else {
                        return;
                    }
                case 10:
                    if (message.obj instanceof FileDescriptor) {
                        jVar.f1774a.setDataSource((FileDescriptor) message.obj);
                        return;
                    }
                    return;
                case 11:
                    if (message.obj instanceof Boolean) {
                        float f = ((Boolean) message.obj).booleanValue() ? 0.0f : 1.0f;
                        jVar.f1774a.setVolume(f, f);
                        return;
                    }
                    return;
                case 12:
                    if (message.obj instanceof ArrayList) {
                        ArrayList arrayList = (ArrayList) message.obj;
                        jVar.f1774a.setDataSource((Context) arrayList.get(0), (Uri) arrayList.get(1));
                        return;
                    }
                    return;
                case 13:
                    if (message.obj instanceof ArrayList) {
                        ArrayList arrayList2 = (ArrayList) message.obj;
                        jVar.f1774a.setDataSource((Context) arrayList2.get(0), (Uri) arrayList2.get(1), (Map) arrayList2.get(2));
                        return;
                    }
                    return;
                case 14:
                    if (message.obj instanceof String) {
                        jVar.f1774a.setDataSource(String.valueOf(message.obj));
                        return;
                    }
                    return;
                case 15:
                    if (message.obj instanceof ArrayList) {
                        ArrayList arrayList3 = (ArrayList) message.obj;
                        try {
                            jVar.f1774a.setDataSource((String) arrayList3.get(0), (Map) arrayList3.get(1));
                            return;
                        } catch (IllegalArgumentException e3) {
                            jVar.b(7, -1004, -1004, null);
                            e3.printStackTrace();
                            return;
                        }
                    }
                    return;
                case 16:
                    if (message.obj instanceof ArrayList) {
                        ArrayList arrayList4 = (ArrayList) message.obj;
                        jVar.f1774a.setWakeMode((Context) arrayList4.get(0), ((Integer) arrayList4.get(1)).intValue());
                        return;
                    }
                    return;
                case 17:
                    if (message.obj instanceof Boolean) {
                        jVar.f1774a.setScreenOnWhilePlaying(((Boolean) message.obj).booleanValue());
                        return;
                    }
                    return;
                case 18:
                    if (message.obj == null) {
                        jVar.f1774a.setDisplay(null);
                        return;
                    } else if ((message.obj instanceof SurfaceHolder) && ((SurfaceHolder) message.obj).getSurface() != null && ((SurfaceHolder) message.obj).getSurface().isValid()) {
                        try {
                            jVar.f1774a.setDisplay((SurfaceHolder) message.obj);
                            return;
                        } catch (Exception e4) {
                            CyberLog.e("MediaPlayerAsync", "setDisplay exception!");
                            return;
                        }
                    } else {
                        return;
                    }
                case 19:
                default:
                    CyberLog.e("MediaPlayerAsync", "RequestHandler Unknown message type=" + message.what);
                    return;
                case 20:
                    if (message.obj instanceof ArrayList) {
                        ArrayList arrayList5 = (ArrayList) message.obj;
                        jVar.f1774a.setVolume(((Float) arrayList5.get(0)).floatValue(), ((Float) arrayList5.get(1)).floatValue());
                        return;
                    }
                    return;
                case 21:
                    if (message.obj instanceof Float) {
                        jVar.f1774a.setSpeed(((Float) message.obj).floatValue());
                        return;
                    }
                    return;
                case 22:
                    if (message.obj instanceof ArrayList) {
                        ArrayList arrayList6 = (ArrayList) message.obj;
                        jVar.f1774a.changeProxyDynamic((String) arrayList6.get(0), ((Boolean) arrayList6.get(1)).booleanValue());
                        return;
                    }
                    return;
            }
        }
    }

    public j() {
        c();
    }

    public static PlayerProvider a() {
        j jVar = new j();
        if (jVar.b()) {
            return jVar;
        }
        jVar.release();
        return null;
    }

    private ArrayList<Object> a(Object... objArr) {
        ArrayList<Object> arrayList = new ArrayList<>();
        for (Object obj : objArr) {
            arrayList.add(obj);
        }
        return arrayList;
    }

    private boolean a(int i) {
        if (this.n) {
            if (this.l != null) {
                this.l.sendEmptyMessage(i);
            }
            return true;
        }
        return false;
    }

    private boolean a(int i, int i2, int i3, Object obj) {
        if (this.n) {
            if (this.l != null) {
                this.l.sendMessage(this.l.obtainMessage(i, i2, i3, obj));
            }
            return true;
        }
        return false;
    }

    private boolean b(int i) {
        if (this.n) {
            if (this.k != null) {
                this.k.sendEmptyMessage(i);
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(int i, int i2, int i3, Object obj) {
        if (this.n) {
            if (this.k != null) {
                this.k.sendMessage(this.k.obtainMessage(i, i2, i3, obj));
            }
            return true;
        }
        return false;
    }

    private void c() {
        Looper myLooper = Looper.myLooper();
        if (myLooper != null) {
            this.k = new a(this, myLooper);
        } else {
            Looper mainLooper = Looper.getMainLooper();
            if (mainLooper != null) {
                this.k = new a(this, mainLooper);
            } else {
                this.k = null;
            }
        }
        this.n = false;
        if (!n.m() || Thread.currentThread() == Looper.getMainLooper().getThread()) {
            this.m = DuplayerHandlerThreadPool.getInstance().obtain();
            this.l = new b(this, this.m.getLooper());
            CyberLog.i("MediaPlayerAsync", "initPlayer, use request handler. thread:" + Thread.currentThread().getName() + " request thread:" + this.m.getName() + " mRequestHandler:" + this.l);
            this.n = true;
        } else {
            CyberLog.i("MediaPlayerAsync", "initPlayer, don't use request handler. thread:" + Thread.currentThread().getName());
            this.l = null;
        }
        a(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void d() {
        this.f1774a = new k();
        CyberLog.i("MediaPlayerAsync", "createPlayer mPlayer=" + this.f1774a);
        this.f1774a.setOnPreparedListener(this);
        this.f1774a.setOnCompletionListener(this);
        this.f1774a.setOnBufferingUpdateListener(this);
        this.f1774a.setOnSeekCompleteListener(this);
        this.f1774a.setOnVideoSizeChangedListener(this);
        this.f1774a.setOnErrorListener(this);
        this.f1774a.setOnInfoListener(this);
    }

    private synchronized void e() {
        CyberLog.i("MediaPlayerAsync", "quitRequestHandlerThread");
        if (this.n) {
            DuplayerHandlerThreadPool.getInstance().recycle(this.m);
            this.m = null;
        }
    }

    public boolean b() {
        return (!this.n || this.l == null || this.m == null) ? false : true;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void changeProxyDynamic(String str, boolean z) {
        a(22, -1, -1, a(str, Boolean.valueOf(z)));
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getCurrentPosition() {
        if (this.f1774a != null) {
            return this.f1774a.getCurrentPosition();
        }
        return 0;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getCurrentPositionSync() {
        if (this.f1774a != null) {
            return this.f1774a.getCurrentPositionSync();
        }
        return 0;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getDecodeMode() {
        return 4;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public long getDownloadSpeed() {
        if (this.f1774a != null) {
            return this.f1774a.getDownloadSpeed();
        }
        return 0L;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getDuration() {
        if (this.f1774a != null) {
            return this.f1774a.getDuration();
        }
        return -1;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public long getPlayedTime() {
        if (this.f1774a != null) {
            return this.f1774a.getPlayedTime();
        }
        return 0L;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getVideoHeight() {
        return this.j;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getVideoWidth() {
        return this.i;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public boolean isLooping() {
        return this.f1774a != null && this.f1774a.isLooping();
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public boolean isPlaying() {
        return this.f1774a != null && this.f1774a.isPlaying();
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public boolean isRemotePlayer() {
        return false;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void muteOrUnmuteAudio(boolean z) {
        a(11, -1, -1, Boolean.valueOf(z));
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnBufferingUpdateListener
    public void onBufferingUpdate(int i) {
        b(3, i, -1, null);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
    public void onCompletion() {
        b(2);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
    public boolean onError(int i, int i2, Object obj) {
        return b(7, i, i2, null);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
    public boolean onInfo(int i, int i2, Object obj) {
        return b(8, i, i2, null);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
    public void onPrepared() {
        b(1);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
    public void onSeekComplete() {
        b(4);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnVideoSizeChangedListener
    public void onVideoSizeChanged(int i, int i2, int i3, int i4) {
        b(5, i, i2, null);
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
        if (this.l != null) {
            this.l.removeCallbacksAndMessages(null);
        }
        this.k.removeCallbacksAndMessages(null);
        a(2);
        e();
        this.l = null;
        this.f1775b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void reset() {
        if (this.l != null) {
            this.l.removeCallbacksAndMessages(null);
        }
        this.k.removeCallbacksAndMessages(null);
        a(3);
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void seekTo(long j) {
        a(7, -1, -1, Long.valueOf(j));
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setDataSource(Context context, Uri uri) {
        a(12, -1, -1, a(context, uri));
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setDataSource(Context context, Uri uri, Map<String, String> map) {
        a(13, -1, -1, a(context, uri, map));
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setDataSource(FileDescriptor fileDescriptor) {
        a(10, -1, -1, fileDescriptor);
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setDataSource(String str) {
        a(14, -1, -1, str);
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setDataSource(String str, Map<String, String> map) {
        a(15, -1, -1, a(str, map));
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
    public void setOnPreparedListener(CyberPlayerManager.OnPreparedListener onPreparedListener) {
        this.f1775b = onPreparedListener;
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
    public void setVolume(float f, float f2) {
        a(20, -1, -1, a(Float.valueOf(f), Float.valueOf(f2)));
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setWakeMode(Context context, int i) {
        a(16, -1, -1, a(context, Integer.valueOf(i)));
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void start() {
        a(5);
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void stop() {
        a(1);
    }
}
