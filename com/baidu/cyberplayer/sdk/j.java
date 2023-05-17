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
/* loaded from: classes3.dex */
public class j extends PlayerProvider implements CyberPlayerManager.OnBufferingUpdateListener, CyberPlayerManager.OnCompletionListener, CyberPlayerManager.OnErrorListener, CyberPlayerManager.OnInfoListener, CyberPlayerManager.OnPreparedListener, CyberPlayerManager.OnSeekCompleteListener, CyberPlayerManager.OnVideoSizeChangedListener {
    public k a;
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

    /* loaded from: classes3.dex */
    public static class a extends Handler {
        public final WeakReference<j> a;

        public a(j jVar, Looper looper) {
            super(looper);
            this.a = new WeakReference<>(jVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            j jVar = this.a.get();
            if (jVar == null) {
                CyberLog.e("MediaPlayerAsync", "EventHandler,MediaPlayerImpl went away with unhandled events msg.what:" + message.what);
                return;
            }
            CyberLog.i("MediaPlayerAsync", "EventHandler handleMessage what=" + message.what);
            switch (message.what) {
                case 1:
                    if (jVar.b != null) {
                        jVar.b.onPrepared();
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
                    jVar.j = message.arg1;
                    jVar.k = message.arg2;
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
                case 9:
                    if (jVar.i != null) {
                        jVar.i.onMediaSourceChanged(message.arg1, message.arg2, null);
                        return;
                    }
                    return;
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends Handler {
        public final WeakReference<j> a;

        public b(j jVar, Looper looper) {
            super(looper);
            this.a = new WeakReference<>(jVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            String str;
            j jVar = this.a.get();
            if (jVar == null || (jVar.a == null && message.what != 8)) {
                CyberLog.e("MediaPlayerAsync", "RequestHandler,MediaPlayerImpl went away with unhandled events msg.what:" + message.what);
                return;
            }
            CyberLog.i("MediaPlayerAsync", "RequestHandler handleMessage what=" + message.what);
            switch (message.what) {
                case 1:
                    jVar.a.stop();
                    return;
                case 2:
                    try {
                        jVar.a.setOnPreparedListener(null);
                        jVar.a.setOnCompletionListener(null);
                        jVar.a.setOnBufferingUpdateListener(null);
                        jVar.a.setOnSeekCompleteListener(null);
                        jVar.a.setOnVideoSizeChangedListener(null);
                        jVar.a.setOnErrorListener(null);
                        jVar.a.setOnInfoListener(null);
                        jVar.a.release();
                        jVar.a = null;
                        return;
                    } catch (Exception unused) {
                        return;
                    }
                case 3:
                    jVar.a.reset();
                    return;
                case 4:
                    jVar.a.pause();
                    return;
                case 5:
                    jVar.a.start();
                    return;
                case 6:
                    jVar.a.prepareAsync();
                    return;
                case 7:
                    if (message.obj instanceof Long) {
                        jVar.a.seekTo((int) ((Long) message.obj).longValue(), message.arg1);
                        return;
                    }
                    return;
                case 8:
                    jVar.d();
                    return;
                case 9:
                    Object obj = message.obj;
                    if (obj == null) {
                        jVar.a.setSurface(null);
                        return;
                    } else if ((obj instanceof Surface) && ((Surface) obj).isValid()) {
                        try {
                            jVar.a.setSurface((Surface) message.obj);
                            return;
                        } catch (Exception unused2) {
                            str = "setSurface exception!";
                            break;
                        }
                    } else {
                        return;
                    }
                    break;
                case 10:
                    if (message.obj instanceof FileDescriptor) {
                        jVar.a.setDataSource((FileDescriptor) message.obj);
                        return;
                    }
                    return;
                case 11:
                    Object obj2 = message.obj;
                    if (obj2 instanceof Boolean) {
                        float f = ((Boolean) obj2).booleanValue() ? 0.0f : 1.0f;
                        jVar.a.setVolume(f, f);
                        return;
                    }
                    return;
                case 12:
                    Object obj3 = message.obj;
                    if (obj3 instanceof ArrayList) {
                        ArrayList arrayList = (ArrayList) obj3;
                        jVar.a.setDataSource((Context) arrayList.get(0), (Uri) arrayList.get(1));
                        return;
                    }
                    return;
                case 13:
                    Object obj4 = message.obj;
                    if (obj4 instanceof ArrayList) {
                        ArrayList arrayList2 = (ArrayList) obj4;
                        jVar.a.setDataSource((Context) arrayList2.get(0), (Uri) arrayList2.get(1), (Map) arrayList2.get(2));
                        return;
                    }
                    return;
                case 14:
                    if (message.obj instanceof String) {
                        jVar.a.setDataSource(String.valueOf(message.obj));
                        return;
                    }
                    return;
                case 15:
                    Object obj5 = message.obj;
                    if (obj5 instanceof ArrayList) {
                        ArrayList arrayList3 = (ArrayList) obj5;
                        try {
                            jVar.a.setDataSource((String) arrayList3.get(0), (Map) arrayList3.get(1));
                            return;
                        } catch (IllegalArgumentException e) {
                            jVar.b(7, -1004, -1004, null);
                            e.printStackTrace();
                            return;
                        }
                    }
                    return;
                case 16:
                    Object obj6 = message.obj;
                    if (obj6 instanceof ArrayList) {
                        ArrayList arrayList4 = (ArrayList) obj6;
                        jVar.a.setWakeMode((Context) arrayList4.get(0), ((Integer) arrayList4.get(1)).intValue());
                        return;
                    }
                    return;
                case 17:
                    if (message.obj instanceof Boolean) {
                        jVar.a.setScreenOnWhilePlaying(((Boolean) message.obj).booleanValue());
                        return;
                    }
                    return;
                case 18:
                    Object obj7 = message.obj;
                    if (obj7 == null) {
                        jVar.a.setDisplay(null);
                        return;
                    } else if ((obj7 instanceof SurfaceHolder) && ((SurfaceHolder) obj7).getSurface() != null && ((SurfaceHolder) message.obj).getSurface().isValid()) {
                        try {
                            jVar.a.setDisplay((SurfaceHolder) message.obj);
                            return;
                        } catch (Exception unused3) {
                            str = "setDisplay exception!";
                            break;
                        }
                    } else {
                        return;
                    }
                    break;
                case 19:
                    if (message.obj instanceof Boolean) {
                        jVar.a.setLooping(((Boolean) message.obj).booleanValue());
                        return;
                    }
                    return;
                case 20:
                    Object obj8 = message.obj;
                    if (obj8 instanceof ArrayList) {
                        ArrayList arrayList5 = (ArrayList) obj8;
                        jVar.a.setVolume(((Float) arrayList5.get(0)).floatValue(), ((Float) arrayList5.get(1)).floatValue());
                        return;
                    }
                    return;
                case 21:
                    Object obj9 = message.obj;
                    if (obj9 instanceof Float) {
                        jVar.a.setSpeed(((Float) obj9).floatValue());
                        return;
                    }
                    return;
                case 22:
                    Object obj10 = message.obj;
                    if (obj10 instanceof ArrayList) {
                        ArrayList arrayList6 = (ArrayList) obj10;
                        jVar.a.changeProxyDynamic((String) arrayList6.get(0), ((Boolean) arrayList6.get(1)).booleanValue());
                        return;
                    }
                    return;
                default:
                    str = "RequestHandler Unknown message type=" + message.what;
                    break;
            }
            CyberLog.e("MediaPlayerAsync", str);
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

    private void c() {
        a aVar;
        Looper myLooper = Looper.myLooper();
        if (myLooper != null) {
            aVar = new a(this, myLooper);
        } else {
            Looper mainLooper = Looper.getMainLooper();
            if (mainLooper == null) {
                this.l = null;
                this.o = false;
                if (o.m() || Thread.currentThread() == Looper.getMainLooper().getThread()) {
                    this.n = DuplayerHandlerThreadPool.getInstance().obtain();
                    this.m = new b(this, this.n.getLooper());
                    CyberLog.i("MediaPlayerAsync", "initPlayer, use request handler. thread:" + Thread.currentThread().getName() + " request thread:" + this.n.getName() + " mRequestHandler:" + this.m);
                    this.o = true;
                } else {
                    CyberLog.i("MediaPlayerAsync", "initPlayer, don't use request handler. thread:" + Thread.currentThread().getName());
                    this.m = null;
                }
                a(8);
            }
            aVar = new a(this, mainLooper);
        }
        this.l = aVar;
        this.o = false;
        if (o.m()) {
        }
        this.n = DuplayerHandlerThreadPool.getInstance().obtain();
        this.m = new b(this, this.n.getLooper());
        CyberLog.i("MediaPlayerAsync", "initPlayer, use request handler. thread:" + Thread.currentThread().getName() + " request thread:" + this.n.getName() + " mRequestHandler:" + this.m);
        this.o = true;
        a(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void d() {
        this.a = new k();
        CyberLog.i("MediaPlayerAsync", "createPlayer mPlayer=" + this.a);
        this.a.setOnPreparedListener(this);
        this.a.setOnCompletionListener(this);
        this.a.setOnBufferingUpdateListener(this);
        this.a.setOnSeekCompleteListener(this);
        this.a.setOnVideoSizeChangedListener(this);
        this.a.setOnErrorListener(this);
        this.a.setOnInfoListener(this);
    }

    private synchronized void e() {
        CyberLog.i("MediaPlayerAsync", "quitRequestHandlerThread");
        if (this.o) {
            DuplayerHandlerThreadPool.getInstance().recycle(this.n);
            this.n = null;
        }
    }

    public boolean b() {
        return (!this.o || this.m == null || this.n == null) ? false : true;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void changeProxyDynamic(String str, boolean z) {
        a(22, -1, -1, a(str, Boolean.valueOf(z)));
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getCurrentPosition() {
        k kVar = this.a;
        if (kVar != null) {
            return kVar.getCurrentPosition();
        }
        return 0;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getCurrentPositionSync() {
        k kVar = this.a;
        if (kVar != null) {
            return kVar.getCurrentPositionSync();
        }
        return 0;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getDecodeMode() {
        return 4;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public long getDownloadSpeed() {
        k kVar = this.a;
        if (kVar != null) {
            return kVar.getDownloadSpeed();
        }
        return 0L;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getDuration() {
        k kVar = this.a;
        if (kVar != null) {
            return kVar.getDuration();
        }
        return -1;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public long getPlayedTime() {
        k kVar = this.a;
        if (kVar != null) {
            return kVar.getPlayedTime();
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
        k kVar = this.a;
        return kVar != null && kVar.isLooping();
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public boolean isPlaying() {
        k kVar = this.a;
        return kVar != null && kVar.isPlaying();
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
    public void seekTo(long j) {
        seekTo(j, 3);
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

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void switchMediaSource(int i) {
        b(9, i == -1 ? 0 : -100, i, null);
    }
}
