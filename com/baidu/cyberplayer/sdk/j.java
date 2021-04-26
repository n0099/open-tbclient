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
/* loaded from: classes2.dex */
public class j extends PlayerProvider implements CyberPlayerManager.OnBufferingUpdateListener, CyberPlayerManager.OnCompletionListener, CyberPlayerManager.OnErrorListener, CyberPlayerManager.OnInfoListener, CyberPlayerManager.OnPreparedListener, CyberPlayerManager.OnSeekCompleteListener, CyberPlayerManager.OnVideoSizeChangedListener {

    /* renamed from: a  reason: collision with root package name */
    public k f5115a;

    /* renamed from: b  reason: collision with root package name */
    public CyberPlayerManager.OnPreparedListener f5116b;

    /* renamed from: c  reason: collision with root package name */
    public CyberPlayerManager.OnCompletionListener f5117c;

    /* renamed from: d  reason: collision with root package name */
    public CyberPlayerManager.OnBufferingUpdateListener f5118d;

    /* renamed from: e  reason: collision with root package name */
    public CyberPlayerManager.OnSeekCompleteListener f5119e;

    /* renamed from: f  reason: collision with root package name */
    public CyberPlayerManager.OnVideoSizeChangedListener f5120f;

    /* renamed from: g  reason: collision with root package name */
    public CyberPlayerManager.OnErrorListener f5121g;

    /* renamed from: h  reason: collision with root package name */
    public CyberPlayerManager.OnInfoListener f5122h;

    /* renamed from: i  reason: collision with root package name */
    public int f5123i;
    public int j;
    public a k;
    public b l;
    public DuplayerHandlerThread m;
    public boolean n;

    /* loaded from: classes2.dex */
    public static class a extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public final WeakReference<j> f5124a;

        public a(j jVar, Looper looper) {
            super(looper);
            this.f5124a = new WeakReference<>(jVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            j jVar = this.f5124a.get();
            if (jVar == null) {
                CyberLog.e("MediaPlayerAsync", "EventHandler,MediaPlayerImpl went away with unhandled events msg.what:" + message.what);
                return;
            }
            CyberLog.i("MediaPlayerAsync", "EventHandler handleMessage what=" + message.what);
            switch (message.what) {
                case 1:
                    if (jVar.f5116b != null) {
                        jVar.f5116b.onPrepared();
                        return;
                    }
                    return;
                case 2:
                    if (jVar.f5117c != null) {
                        jVar.f5117c.onCompletion();
                        return;
                    }
                    return;
                case 3:
                    if (jVar.f5118d != null) {
                        jVar.f5118d.onBufferingUpdate(message.arg1);
                        return;
                    }
                    return;
                case 4:
                    if (jVar.f5119e != null) {
                        jVar.f5119e.onSeekComplete();
                        return;
                    }
                    return;
                case 5:
                    jVar.f5123i = message.arg1;
                    jVar.j = message.arg2;
                    if (jVar.f5120f != null) {
                        jVar.f5120f.onVideoSizeChanged(message.arg1, message.arg2, 1, 1);
                        return;
                    }
                    return;
                case 6:
                default:
                    CyberLog.e("MediaPlayerAsync", "EventHandler Unknown message type=" + message.what);
                    return;
                case 7:
                    if (jVar.f5121g != null) {
                        jVar.f5121g.onError(message.arg1, message.arg2, null);
                        return;
                    }
                    return;
                case 8:
                    if (jVar.f5122h != null) {
                        jVar.f5122h.onInfo(message.arg1, message.arg2, null);
                        return;
                    }
                    return;
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class b extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public final WeakReference<j> f5125a;

        public b(j jVar, Looper looper) {
            super(looper);
            this.f5125a = new WeakReference<>(jVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            String str;
            j jVar = this.f5125a.get();
            if (jVar == null || (jVar.f5115a == null && message.what != 8)) {
                CyberLog.e("MediaPlayerAsync", "RequestHandler,MediaPlayerImpl went away with unhandled events msg.what:" + message.what);
                return;
            }
            CyberLog.i("MediaPlayerAsync", "RequestHandler handleMessage what=" + message.what);
            switch (message.what) {
                case 1:
                    jVar.f5115a.stop();
                    return;
                case 2:
                    try {
                        jVar.f5115a.setOnPreparedListener(null);
                        jVar.f5115a.setOnCompletionListener(null);
                        jVar.f5115a.setOnBufferingUpdateListener(null);
                        jVar.f5115a.setOnSeekCompleteListener(null);
                        jVar.f5115a.setOnVideoSizeChangedListener(null);
                        jVar.f5115a.setOnErrorListener(null);
                        jVar.f5115a.setOnInfoListener(null);
                        jVar.f5115a.release();
                        jVar.f5115a = null;
                        return;
                    } catch (Exception unused) {
                        return;
                    }
                case 3:
                    jVar.f5115a.reset();
                    return;
                case 4:
                    jVar.f5115a.pause();
                    return;
                case 5:
                    jVar.f5115a.start();
                    return;
                case 6:
                    jVar.f5115a.prepareAsync();
                    return;
                case 7:
                    if (message.obj instanceof Long) {
                        jVar.f5115a.seekTo((int) ((Long) message.obj).longValue());
                        return;
                    }
                    return;
                case 8:
                    jVar.d();
                    return;
                case 9:
                    Object obj = message.obj;
                    if (obj == null) {
                        jVar.f5115a.setSurface(null);
                        return;
                    } else if ((obj instanceof Surface) && ((Surface) obj).isValid()) {
                        try {
                            jVar.f5115a.setSurface((Surface) message.obj);
                            return;
                        } catch (Exception unused2) {
                            str = "setSurface exception!";
                            break;
                        }
                    } else {
                        return;
                    }
                case 10:
                    if (message.obj instanceof FileDescriptor) {
                        jVar.f5115a.setDataSource((FileDescriptor) message.obj);
                        return;
                    }
                    return;
                case 11:
                    Object obj2 = message.obj;
                    if (obj2 instanceof Boolean) {
                        float f2 = ((Boolean) obj2).booleanValue() ? 0.0f : 1.0f;
                        jVar.f5115a.setVolume(f2, f2);
                        return;
                    }
                    return;
                case 12:
                    Object obj3 = message.obj;
                    if (obj3 instanceof ArrayList) {
                        ArrayList arrayList = (ArrayList) obj3;
                        jVar.f5115a.setDataSource((Context) arrayList.get(0), (Uri) arrayList.get(1));
                        return;
                    }
                    return;
                case 13:
                    Object obj4 = message.obj;
                    if (obj4 instanceof ArrayList) {
                        ArrayList arrayList2 = (ArrayList) obj4;
                        jVar.f5115a.setDataSource((Context) arrayList2.get(0), (Uri) arrayList2.get(1), (Map) arrayList2.get(2));
                        return;
                    }
                    return;
                case 14:
                    if (message.obj instanceof String) {
                        jVar.f5115a.setDataSource(String.valueOf(message.obj));
                        return;
                    }
                    return;
                case 15:
                    Object obj5 = message.obj;
                    if (obj5 instanceof ArrayList) {
                        ArrayList arrayList3 = (ArrayList) obj5;
                        try {
                            jVar.f5115a.setDataSource((String) arrayList3.get(0), (Map) arrayList3.get(1));
                            return;
                        } catch (IllegalArgumentException e2) {
                            jVar.b(7, -1004, -1004, null);
                            e2.printStackTrace();
                            return;
                        }
                    }
                    return;
                case 16:
                    Object obj6 = message.obj;
                    if (obj6 instanceof ArrayList) {
                        ArrayList arrayList4 = (ArrayList) obj6;
                        jVar.f5115a.setWakeMode((Context) arrayList4.get(0), ((Integer) arrayList4.get(1)).intValue());
                        return;
                    }
                    return;
                case 17:
                    if (message.obj instanceof Boolean) {
                        jVar.f5115a.setScreenOnWhilePlaying(((Boolean) message.obj).booleanValue());
                        return;
                    }
                    return;
                case 18:
                    Object obj7 = message.obj;
                    if (obj7 == null) {
                        jVar.f5115a.setDisplay(null);
                        return;
                    } else if ((obj7 instanceof SurfaceHolder) && ((SurfaceHolder) obj7).getSurface() != null && ((SurfaceHolder) message.obj).getSurface().isValid()) {
                        try {
                            jVar.f5115a.setDisplay((SurfaceHolder) message.obj);
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
                default:
                    str = "RequestHandler Unknown message type=" + message.what;
                    break;
                case 20:
                    Object obj8 = message.obj;
                    if (obj8 instanceof ArrayList) {
                        ArrayList arrayList5 = (ArrayList) obj8;
                        jVar.f5115a.setVolume(((Float) arrayList5.get(0)).floatValue(), ((Float) arrayList5.get(1)).floatValue());
                        return;
                    }
                    return;
                case 21:
                    Object obj9 = message.obj;
                    if (obj9 instanceof Float) {
                        jVar.f5115a.setSpeed(((Float) obj9).floatValue());
                        return;
                    }
                    return;
                case 22:
                    Object obj10 = message.obj;
                    if (obj10 instanceof ArrayList) {
                        ArrayList arrayList6 = (ArrayList) obj10;
                        jVar.f5115a.changeProxyDynamic((String) arrayList6.get(0), ((Boolean) arrayList6.get(1)).booleanValue());
                        return;
                    }
                    return;
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

    private boolean a(int i2) {
        if (this.n) {
            b bVar = this.l;
            if (bVar != null) {
                bVar.sendEmptyMessage(i2);
                return true;
            }
            return true;
        }
        return false;
    }

    private boolean a(int i2, int i3, int i4, Object obj) {
        if (this.n) {
            b bVar = this.l;
            if (bVar != null) {
                this.l.sendMessage(bVar.obtainMessage(i2, i3, i4, obj));
                return true;
            }
            return true;
        }
        return false;
    }

    private boolean b(int i2) {
        if (this.n) {
            a aVar = this.k;
            if (aVar != null) {
                aVar.sendEmptyMessage(i2);
                return true;
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(int i2, int i3, int i4, Object obj) {
        if (this.n) {
            a aVar = this.k;
            if (aVar != null) {
                this.k.sendMessage(aVar.obtainMessage(i2, i3, i4, obj));
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
                this.k = null;
                this.n = false;
                if (n.m() || Thread.currentThread() == Looper.getMainLooper().getThread()) {
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
            aVar = new a(this, mainLooper);
        }
        this.k = aVar;
        this.n = false;
        if (n.m()) {
        }
        this.m = DuplayerHandlerThreadPool.getInstance().obtain();
        this.l = new b(this, this.m.getLooper());
        CyberLog.i("MediaPlayerAsync", "initPlayer, use request handler. thread:" + Thread.currentThread().getName() + " request thread:" + this.m.getName() + " mRequestHandler:" + this.l);
        this.n = true;
        a(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void d() {
        this.f5115a = new k();
        CyberLog.i("MediaPlayerAsync", "createPlayer mPlayer=" + this.f5115a);
        this.f5115a.setOnPreparedListener(this);
        this.f5115a.setOnCompletionListener(this);
        this.f5115a.setOnBufferingUpdateListener(this);
        this.f5115a.setOnSeekCompleteListener(this);
        this.f5115a.setOnVideoSizeChangedListener(this);
        this.f5115a.setOnErrorListener(this);
        this.f5115a.setOnInfoListener(this);
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
        k kVar = this.f5115a;
        if (kVar != null) {
            return kVar.getCurrentPosition();
        }
        return 0;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getCurrentPositionSync() {
        k kVar = this.f5115a;
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
        k kVar = this.f5115a;
        if (kVar != null) {
            return kVar.getDownloadSpeed();
        }
        return 0L;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getDuration() {
        k kVar = this.f5115a;
        if (kVar != null) {
            return kVar.getDuration();
        }
        return -1;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public long getPlayedTime() {
        k kVar = this.f5115a;
        if (kVar != null) {
            return kVar.getPlayedTime();
        }
        return 0L;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getVideoHeight() {
        return this.j;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getVideoWidth() {
        return this.f5123i;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public boolean isLooping() {
        k kVar = this.f5115a;
        return kVar != null && kVar.isLooping();
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public boolean isPlaying() {
        k kVar = this.f5115a;
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
    public void onBufferingUpdate(int i2) {
        b(3, i2, -1, null);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
    public void onCompletion() {
        b(2);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
    public boolean onError(int i2, int i3, Object obj) {
        return b(7, i2, i3, null);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
    public boolean onInfo(int i2, int i3, Object obj) {
        return b(8, i2, i3, null);
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
    public void onVideoSizeChanged(int i2, int i3, int i4, int i5) {
        b(5, i2, i3, null);
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
        b bVar = this.l;
        if (bVar != null) {
            bVar.removeCallbacksAndMessages(null);
        }
        this.k.removeCallbacksAndMessages(null);
        a(2);
        e();
        this.l = null;
        this.f5116b = null;
        this.f5117c = null;
        this.f5118d = null;
        this.f5119e = null;
        this.f5120f = null;
        this.f5121g = null;
        this.f5122h = null;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void reset() {
        b bVar = this.l;
        if (bVar != null) {
            bVar.removeCallbacksAndMessages(null);
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
        this.f5118d = onBufferingUpdateListener;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnCompletionListener(CyberPlayerManager.OnCompletionListener onCompletionListener) {
        this.f5117c = onCompletionListener;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnErrorListener(CyberPlayerManager.OnErrorListener onErrorListener) {
        this.f5121g = onErrorListener;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnInfoListener(CyberPlayerManager.OnInfoListener onInfoListener) {
        this.f5122h = onInfoListener;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnPreparedListener(CyberPlayerManager.OnPreparedListener onPreparedListener) {
        this.f5116b = onPreparedListener;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnSeekCompleteListener(CyberPlayerManager.OnSeekCompleteListener onSeekCompleteListener) {
        this.f5119e = onSeekCompleteListener;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnVideoSizeChangedListener(CyberPlayerManager.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        this.f5120f = onVideoSizeChangedListener;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setScreenOnWhilePlaying(boolean z) {
        a(17, -1, -1, Boolean.valueOf(z));
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setSpeed(float f2) {
        a(21, -1, -1, Float.valueOf(f2));
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setSurface(Surface surface) {
        a(9, 0, 0, surface);
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setVolume(float f2, float f3) {
        a(20, -1, -1, a(Float.valueOf(f2), Float.valueOf(f3)));
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setWakeMode(Context context, int i2) {
        a(16, -1, -1, a(context, Integer.valueOf(i2)));
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
