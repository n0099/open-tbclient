package com.baidu.cyberplayer.sdk.c;

import android.content.Context;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.cyberplayer.sdk.CyberPlayer;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.ICyberVideoView;
import com.baidu.cyberplayer.sdk.m;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class a extends FrameLayout implements ICyberVideoView {
    protected g A;
    protected CyberPlayerManager.OnVideoSizeChangedListener B;
    protected CyberPlayerManager.OnErrorListener C;
    protected c D;
    protected View.OnTouchListener E;
    protected d F;
    protected h G;
    protected h H;
    protected int I;
    protected boolean J;
    protected boolean K;
    protected int L;
    protected int M;
    protected int N;
    protected int O;
    protected int P;
    protected int Q;
    protected int R;
    protected i S;
    private String T;
    private boolean U;
    private int V;
    private int W;
    private int a;
    private int aa;
    private boolean ab;
    private float ac;
    private HashMap<String, String> ad;
    protected Context b;
    protected Surface c;
    protected View d;
    protected boolean e;
    protected boolean f;
    protected String g;
    protected CyberPlayer h;
    protected int i;
    protected boolean j;
    protected String k;
    protected String l;
    protected Uri m;
    protected Uri n;
    protected Map<String, String> o;
    protected boolean p;
    protected String q;
    protected CyberPlayerManager.OnCompletionListener r;
    protected CyberPlayerManager.OnPreparedListener s;
    protected CyberPlayerManager.OnBufferingUpdateListener t;
    protected f u;
    protected CyberPlayerManager.OnSeekCompleteListener v;
    protected CyberPlayerManager.OnInfoListener w;
    protected b x;
    protected InterfaceC0110a y;
    protected e z;

    /* renamed from: com.baidu.cyberplayer.sdk.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0110a {
        void a();
    }

    /* loaded from: classes.dex */
    public interface b {
        void a();
    }

    /* loaded from: classes.dex */
    public interface c {
    }

    /* loaded from: classes.dex */
    public interface d {
    }

    /* loaded from: classes.dex */
    public interface e {
        void a();
    }

    /* loaded from: classes.dex */
    public interface f {
        void a();
    }

    /* loaded from: classes.dex */
    public interface g {
        void a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public enum h {
        ERROR,
        IDLE,
        PREPARING,
        PREPARED,
        PLAYING,
        PAUSED,
        PLAYBACK_COMPLETED
    }

    /* loaded from: classes.dex */
    protected enum i {
        PAUSED,
        RESUMED
    }

    public a(Context context) {
        super(context);
        this.e = true;
        this.f = false;
        this.i = 0;
        this.j = true;
        this.m = null;
        this.n = null;
        this.p = false;
        this.a = 0;
        this.T = "0.0.0.0";
        this.U = true;
        this.V = 0;
        this.W = 0;
        this.aa = 0;
        this.ab = false;
        this.ac = 1.0f;
        this.ad = new HashMap<>();
        this.G = h.IDLE;
        this.H = h.IDLE;
        this.J = false;
        this.S = i.PAUSED;
        if (isInEditMode()) {
            return;
        }
        a(context);
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = true;
        this.f = false;
        this.i = 0;
        this.j = true;
        this.m = null;
        this.n = null;
        this.p = false;
        this.a = 0;
        this.T = "0.0.0.0";
        this.U = true;
        this.V = 0;
        this.W = 0;
        this.aa = 0;
        this.ab = false;
        this.ac = 1.0f;
        this.ad = new HashMap<>();
        this.G = h.IDLE;
        this.H = h.IDLE;
        this.J = false;
        this.S = i.PAUSED;
        a(context);
    }

    public a(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.e = true;
        this.f = false;
        this.i = 0;
        this.j = true;
        this.m = null;
        this.n = null;
        this.p = false;
        this.a = 0;
        this.T = "0.0.0.0";
        this.U = true;
        this.V = 0;
        this.W = 0;
        this.aa = 0;
        this.ab = false;
        this.ac = 1.0f;
        this.ad = new HashMap<>();
        this.G = h.IDLE;
        this.H = h.IDLE;
        this.J = false;
        this.S = i.PAUSED;
        a(context);
    }

    protected void a(int i2, int i3) {
        setCurPlayerState(h.ERROR);
        this.H = h.ERROR;
        if (this.C != null) {
            this.C.onError(i2, i3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i2, int i3, int i4, int i5) {
        if (i2 == 0 || i3 == 0 || this.d == null) {
            return;
        }
        a(1, "on23DVideoSizeChanged w:" + i2 + " h:" + i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i2, String str) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Context context) {
        if (context == null) {
            throw new RuntimeException("Context not be null");
        }
        this.b = context.getApplicationContext();
    }

    protected void a(boolean z) {
        a(z, true);
    }

    protected void a(boolean z, boolean z2) {
        if (this.h != null) {
            this.h.setDisplay(null);
            this.h.release();
            this.h = null;
        }
        setCurPlayerState(h.IDLE);
        if (z2) {
            this.H = h.IDLE;
        }
        ((AudioManager) this.b.getSystemService("audio")).abandonAudioFocus(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(int i2) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(int i2) {
        f();
        a(i2);
        Object[] objArr = new Object[1];
        objArr[0] = Integer.valueOf(this.d == null ? 0 : this.d.hashCode());
        a(1, String.format("rendView hashCode = %d", objArr));
        setFocusable(true);
        setFocusableInTouchMode(true);
    }

    protected boolean b() {
        return this.f;
    }

    protected void c() {
        this.I = 0;
        this.K = false;
    }

    protected void c(int i2) {
        a(this.n != null, false);
        ((AudioManager) this.b.getSystemService("audio")).requestAudioFocus(null, 3, 1);
        this.h = d(i2);
        if (this.ad != null) {
            for (String str : this.ad.keySet()) {
                this.h.setOption(str, this.ad.get(str));
            }
        }
        if (this.c != null) {
            this.h.setSurface(this.c);
        }
        this.h.setOnPreparedListener(new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.cyberplayer.sdk.c.a.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                a.this.a(1, "onPrepared");
                a.this.setCurPlayerState(h.PREPARED);
                a.this.h.setLooping(a.this.J);
                if (a.this.s != null) {
                    a.this.s.onPrepared();
                }
                if (a.this.I != 0) {
                    a.this.seekTo(a.this.I);
                }
                if (a.this.H == h.PLAYING) {
                    a.this.start();
                } else if (a.this.K) {
                    a.this.pauseBuffering();
                }
            }
        });
        this.h.setOnVideoSizeChangedListener(new CyberPlayerManager.OnVideoSizeChangedListener() { // from class: com.baidu.cyberplayer.sdk.c.a.2
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnVideoSizeChangedListener
            public void onVideoSizeChanged(int i3, int i4, int i5, int i6) {
                a.this.a(1, String.format("onVideoSizeChanged,w=%d,h=%d", Integer.valueOf(i3), Integer.valueOf(i4)));
                if (i3 == 0 || i4 == 0) {
                    return;
                }
                a.this.a(i3, i4, i5, i6);
                a.this.requestLayout();
                a.this.W = i3;
                a.this.aa = i4;
                if (a.this.B != null) {
                    a.this.B.onVideoSizeChanged(i3, i4, i5, i6);
                }
            }
        });
        this.h.setOnCompletionListener(new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.cyberplayer.sdk.c.a.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                a.this.a(1, "onCompletion");
                a.this.setCurPlayerState(h.PLAYBACK_COMPLETED);
                a.this.H = h.PLAYBACK_COMPLETED;
                if (a.this.r != null) {
                    a.this.r.onCompletion();
                }
            }
        });
        this.h.setOnErrorListener(new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.cyberplayer.sdk.c.a.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i3, int i4, Object obj) {
                a.this.a(1, String.format("onError:err=%d,detail=%d", Integer.valueOf(i3), Integer.valueOf(i4)));
                if (i3 == -10000 && (i4 == 11 || i4 == 101 || i4 == -110 || i4 == -5)) {
                    i4 = 300;
                }
                a.this.a(i3, i4);
                return true;
            }
        });
        this.h.setOnInfoListener(new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.cyberplayer.sdk.c.a.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i3, int i4, Object obj) {
                a.this.a(1, String.format("onInfo:what=%d,extra=%d", Integer.valueOf(i3), Integer.valueOf(i4)));
                if (a.this.w != null) {
                    a.this.w.onInfo(i3, i4, null);
                }
                if (i3 == 701) {
                    a.this.a(2, "onBufferingStart");
                    if (a.this.x != null) {
                        a.this.x.a();
                    }
                } else if (i3 == 702) {
                    a.this.a(2, "onBufferingEnd");
                    if (a.this.y != null) {
                        a.this.y.a();
                    }
                } else if (i3 == 3) {
                    a.this.a(1, "onRenderStart");
                    if (a.this.z != null) {
                        a.this.z.a();
                    }
                }
                return true;
            }
        });
        this.h.setOnBufferingUpdateListener(new CyberPlayerManager.OnBufferingUpdateListener() { // from class: com.baidu.cyberplayer.sdk.c.a.6
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnBufferingUpdateListener
            public void onBufferingUpdate(int i3) {
                a.this.a(2, String.format("onBufferingUpdate:percent=%d", Integer.valueOf(i3)));
                if (a.this.t != null) {
                    a.this.t.onBufferingUpdate(i3);
                }
            }
        });
        this.h.setOnSeekCompleteListener(new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.cyberplayer.sdk.c.a.7
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                a.this.a(1, "onSeekComplete");
                if (a.this.v != null) {
                    a.this.v.onSeekComplete();
                }
            }
        });
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void changeProxyDynamic(String str) {
        if (this.h != null && TextUtils.isEmpty(m.c())) {
            String str2 = this.ad != null ? this.ad.get(CyberPlayerManager.OPT_HTTP_PROXY) : null;
            if (TextUtils.isEmpty(str)) {
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                this.h.changeProxyDynamic(null, false);
            } else if (str.equals(str2)) {
                return;
            } else {
                this.h.changeProxyDynamic(str, true);
            }
            this.h.seekTo(getCurrentPosition() - 500);
            if (this.ad != null) {
                this.ad.put(CyberPlayerManager.OPT_HTTP_PROXY, str);
            }
        }
    }

    protected CyberPlayer d(int i2) {
        if (this.V == 3 || this.V < 0 || this.V > 4) {
            this.V = 0;
        }
        a(1, "createplayer : " + i2);
        return new CyberPlayer(this.V, null);
    }

    protected boolean d() {
        return (this.f || this.c == null) ? false : true;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void destory() {
        destroy();
    }

    public void destroy() {
        a(1, "destroy");
        if (this.ad != null) {
            this.ad.clear();
        }
        a(false);
        f();
        destroyRender();
        this.c = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = null;
        this.z = null;
        this.A = null;
        this.B = null;
        this.C = null;
        this.D = null;
    }

    protected void destroyRender() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e() {
        if (this.m == null || !d()) {
            return;
        }
        a(1, String.format("uri:%s ", this.m));
        c(this.i);
        c();
        try {
            if (Build.VERSION.SDK_INT >= 14) {
                this.h.setDataSource(this.b, this.m, this.o);
            } else {
                this.h.setDataSource(this.m.toString());
            }
            if (this.f) {
                a(1, "video is 2d");
            } else {
                this.h.setSurface(this.c);
            }
            this.h.prepareAsync();
            if (this.ab) {
                muteOrUnmuteAudio(this.ab);
            }
            setCurPlayerState(h.PREPARING);
        } catch (Exception e2) {
            a(1, 0);
        }
        requestLayout();
        invalidate();
    }

    protected void e(int i2) {
        if (!isInPlaybackState()) {
            this.I = i2;
            return;
        }
        this.h.seekTo(i2);
        this.I = 0;
    }

    public void enableCache(String str) {
        this.g = str;
    }

    protected void f() {
        if (this.h != null) {
            this.h.setDisplay(null);
        }
        if (this.d != null) {
            removeView(this.d);
            this.d = null;
        }
    }

    protected void g() {
        if (isInPlaybackState() && (this.h.isPlaying() || this.G == h.PREPARED)) {
            a(1, "pausePlayer");
            this.h.pause();
            setCurPlayerState(h.PAUSED);
        }
        this.H = h.PAUSED;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public int getCurrentPosition() {
        if (isInPlaybackState()) {
            return this.h.getCurrentPosition();
        }
        return 0;
    }

    public int getDecodeMode() {
        return this.V;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public int getDuration() {
        if (isInPlaybackState()) {
            return this.h.getDuration();
        }
        return -1;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public long getPlayedTime() {
        if (this.h == null || this.G == h.IDLE || this.G == h.PREPARING) {
            return -1L;
        }
        return this.h.getPlayedTime();
    }

    public int getPlayerType() {
        return this.i;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public int getVideoHeight() {
        return this.aa;
    }

    public Uri getVideoUri() {
        return this.m;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public int getVideoWidth() {
        return this.W;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public View getView() {
        return this;
    }

    public int getViewType() {
        return this.O;
    }

    public boolean init2D() {
        this.f = true;
        if (this.i == 0) {
            this.i = 1;
        }
        if (this.O == 0) {
            this.O = 1;
        }
        a(1, String.format("playerType:" + this.i + " interactiveMode:" + this.L + " displayMode:" + this.M + " sourceType:" + this.P + " viewType:" + this.O, new Object[0]));
        b(this.O);
        return true;
    }

    public boolean isAllReady() {
        return (this.d == null || this.h == null || !b()) ? false : true;
    }

    public boolean isEnableDetachedSurfaceTextureView() {
        return this.e;
    }

    public boolean isEnableMediaCodec() {
        return this.j;
    }

    public boolean isInPlaybackState() {
        return (this.h == null || this.G == h.ERROR || this.G == h.IDLE || this.G == h.PREPARING) ? false : true;
    }

    public boolean isLooping() {
        return this.J;
    }

    public boolean isPlayerIdle() {
        return this.h != null && this.G == h.IDLE;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public boolean isPlaying() {
        return isInPlaybackState() && this.h.isPlaying();
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void muteOrUnmuteAudio(boolean z) {
        this.ab = z;
        a(1, "muteOrUnmuteAudio flag:" + z);
        if (this.h != null) {
            this.h.muteOrUnmuteAudio(z);
        } else {
            a(1, "muteOrUnmuteAudio must call after setVideoPath or setVideoURI");
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void pause() {
        a(1, "pause");
        g();
    }

    public void pauseBuffering() {
        a(1, "pauseBuffering");
        if (isInPlaybackState()) {
            a(1, "current state is in playback state ");
        } else {
            this.K = true;
        }
    }

    protected void pauseRender() {
    }

    public void reStart() {
        this.p = true;
        setVideoName(this.k);
        setVideoURI(this.m);
        start();
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void reset() {
        this.ab = false;
        this.ac = 1.0f;
        resetPlayer();
    }

    public void resetPlayer() {
        if (this.h != null) {
            this.h.reset();
            this.h.setSurface(this.c);
        }
        setCurPlayerState(h.IDLE);
        this.H = h.IDLE;
        this.W = 0;
        this.aa = 0;
    }

    protected void resumeRender() {
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void seekTo(int i2) {
        if (i2 < 0 || getDuration() == 0) {
            return;
        }
        a(1, "seekTo");
        if (this.u != null) {
            this.u.a();
        }
        e(i2);
    }

    protected void setCurPlayerState(h hVar) {
        this.G = hVar;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setDecodeMode(int i2) {
        this.V = i2;
    }

    public void setEnableDetachedSurfaceTextureView(boolean z) {
        this.e = z;
    }

    public void setEnableMediaCodec(boolean z) {
        this.j = z;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setExternalInfo(String str, Object obj) {
        if (TextUtils.isEmpty(str) || this.h == null) {
            return;
        }
        this.h.setExternalInfo(str, obj);
    }

    public void setHttpProxy(String str) {
        this.q = str;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setLooping(boolean z) {
        if (this.h != null && this.G != h.ERROR) {
            this.h.setLooping(z);
        }
        this.J = z;
    }

    public void setOnBufferingEndListener(InterfaceC0110a interfaceC0110a) {
        this.y = interfaceC0110a;
    }

    public void setOnBufferingStartListener(b bVar) {
        this.x = bVar;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnBufferingUpdateListener(CyberPlayerManager.OnBufferingUpdateListener onBufferingUpdateListener) {
        this.t = onBufferingUpdateListener;
    }

    public void setOnClickListener(c cVar) {
        this.D = cVar;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnCompletionListener(CyberPlayerManager.OnCompletionListener onCompletionListener) {
        this.r = onCompletionListener;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnErrorListener(CyberPlayerManager.OnErrorListener onErrorListener) {
        this.C = onErrorListener;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnInfoListener(CyberPlayerManager.OnInfoListener onInfoListener) {
        this.w = onInfoListener;
    }

    public void setOnPitchYawRollListener(d dVar) {
        this.F = dVar;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnPreparedListener(CyberPlayerManager.OnPreparedListener onPreparedListener) {
        this.s = onPreparedListener;
    }

    public void setOnRenderStartListener(e eVar) {
        this.z = eVar;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnSeekCompleteListener(CyberPlayerManager.OnSeekCompleteListener onSeekCompleteListener) {
        this.v = onSeekCompleteListener;
    }

    public void setOnSeekStartListener(f fVar) {
        this.u = fVar;
    }

    public void setOnSurfaceReadyListener(g gVar) {
        this.A = gVar;
    }

    @Override // android.view.View
    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        super.setOnTouchListener(onTouchListener);
        this.E = onTouchListener;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnVideoSizeChangedListener(CyberPlayerManager.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        this.B = onVideoSizeChangedListener;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOption(String str, String str2) {
        if (this.G != h.IDLE) {
            a(1, "Do not set option when the video player playing");
            return;
        }
        if (this.ad != null) {
            this.ad.put(str, str2);
        }
        if (this.h != null) {
            if (str == null || !str.equals(CyberPlayerManager.OPT_HTTP_PROXY) || TextUtils.isEmpty(m.c())) {
                this.h.setOption(str, str2);
            }
        }
    }

    public void setPlayerType(int i2) {
        this.i = i2;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setRemote(boolean z) {
        this.U = z;
    }

    public void setScaleType(int i2) {
        this.a = i2;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setSpeed(float f2) {
        a(1, "setSpeed()");
        this.ac = f2;
        if (this.h != null) {
            this.h.setSpeed(f2);
        } else {
            a(1, "setSpeed must call after setVideoPath or setVideoURI");
        }
    }

    public void setVideoName(String str) {
        a(1, "videoName:" + str);
        this.l = this.k;
        this.k = str;
    }

    public void setVideoPath(String str) {
        setVideoURI(Uri.parse(str));
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setVideoRotation(int i2) {
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setVideoScalingMode(int i2) {
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setVideoURI(Uri uri) {
        setVideoURI(uri, null);
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setVideoURI(Uri uri, Map<String, String> map) {
        a(1, "videoURI:" + uri.toString());
        this.n = this.m;
        this.m = uri;
        this.o = map;
        e();
    }

    public void setViewType(int i2) {
        this.O = i2;
    }

    public void setVolume(float f2) {
        if (this.h != null) {
            this.h.setVolume(f2, f2);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void start() {
        a(1, "start");
        startPlayer();
        resumeRender();
    }

    public void startPlayer() {
        if (isInPlaybackState()) {
            this.h.start();
            setCurPlayerState(h.PLAYING);
        }
        this.H = h.PLAYING;
        a(1, "startPlayer");
    }

    public void stop() {
        a(1, "stop");
        a(false);
        pauseRender();
        if (this.ad != null) {
            this.ad.clear();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void stopPlayback() {
        stop();
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public boolean takeSnapshotAsync(ICyberVideoView.OnSnapShotCompleteListener onSnapShotCompleteListener) {
        return true;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public boolean takeSnapshotAsync(ICyberVideoView.OnSnapShotCompleteListener onSnapShotCompleteListener, float f2, int i2, int i3) {
        return true;
    }
}
