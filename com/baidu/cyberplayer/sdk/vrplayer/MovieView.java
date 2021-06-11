package com.baidu.cyberplayer.sdk.vrplayer;

import android.content.Context;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.CyberPlayer;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.ICyberVideoView;
import com.baidu.cyberplayer.sdk.Keep;
import com.baidu.cyberplayer.sdk.o;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.util.HashMap;
import java.util.Map;
@Keep
/* loaded from: classes2.dex */
public class MovieView extends FrameLayout implements ICyberVideoView {
    public g A;
    public CyberPlayerManager.OnVideoSizeChangedListener B;
    public CyberPlayerManager.OnErrorListener C;
    public c D;
    public View.OnTouchListener E;
    public d F;
    public h G;
    public h H;
    public int I;
    public int J;
    public boolean K;
    public boolean L;
    public int M;
    public int N;
    public int O;
    public int P;
    public int Q;
    public int R;
    public int S;
    public i T;
    public String U;
    public boolean V;
    public int W;

    /* renamed from: a  reason: collision with root package name */
    public int f5030a;
    public int aa;
    public int ab;
    public boolean ac;
    public float ad;
    public HashMap<String, String> ae;

    /* renamed from: b  reason: collision with root package name */
    public Context f5031b;

    /* renamed from: c  reason: collision with root package name */
    public Surface f5032c;

    /* renamed from: d  reason: collision with root package name */
    public View f5033d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f5034e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f5035f;

    /* renamed from: g  reason: collision with root package name */
    public String f5036g;

    /* renamed from: h  reason: collision with root package name */
    public CyberPlayer f5037h;

    /* renamed from: i  reason: collision with root package name */
    public int f5038i;
    public boolean j;
    public String k;
    public String l;
    public Uri m;
    public Uri n;
    public Map<String, String> o;
    public boolean p;
    public String q;
    public CyberPlayerManager.OnCompletionListener r;
    public CyberPlayerManager.OnPreparedListener s;
    public CyberPlayerManager.OnBufferingUpdateListener t;
    public f u;
    public CyberPlayerManager.OnSeekCompleteListener v;
    public CyberPlayerManager.OnInfoListener w;
    public b x;
    public a y;
    public e z;

    /* loaded from: classes2.dex */
    public interface a {
        void a();
    }

    /* loaded from: classes2.dex */
    public interface b {
        void a();
    }

    /* loaded from: classes2.dex */
    public interface c {
    }

    /* loaded from: classes2.dex */
    public interface d {
    }

    /* loaded from: classes2.dex */
    public interface e {
        void a();
    }

    /* loaded from: classes2.dex */
    public interface f {
        void a();
    }

    /* loaded from: classes2.dex */
    public interface g {
        void a();
    }

    /* loaded from: classes2.dex */
    public enum h {
        ERROR,
        IDLE,
        PREPARING,
        PREPARED,
        PLAYING,
        PAUSED,
        PLAYBACK_COMPLETED
    }

    /* loaded from: classes2.dex */
    public enum i {
        PAUSED,
        RESUMED
    }

    public MovieView(Context context) {
        super(context);
        this.f5034e = true;
        this.f5035f = false;
        this.f5038i = 0;
        this.j = true;
        this.m = null;
        this.n = null;
        this.p = false;
        this.f5030a = 0;
        this.U = "0.0.0.0";
        this.V = true;
        this.W = 0;
        this.aa = 0;
        this.ab = 0;
        this.ac = false;
        this.ad = 1.0f;
        this.ae = new HashMap<>();
        h hVar = h.IDLE;
        this.G = hVar;
        this.H = hVar;
        this.K = false;
        this.T = i.PAUSED;
        if (isInEditMode()) {
            return;
        }
        a(context);
    }

    public MovieView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5034e = true;
        this.f5035f = false;
        this.f5038i = 0;
        this.j = true;
        this.m = null;
        this.n = null;
        this.p = false;
        this.f5030a = 0;
        this.U = "0.0.0.0";
        this.V = true;
        this.W = 0;
        this.aa = 0;
        this.ab = 0;
        this.ac = false;
        this.ad = 1.0f;
        this.ae = new HashMap<>();
        h hVar = h.IDLE;
        this.G = hVar;
        this.H = hVar;
        this.K = false;
        this.T = i.PAUSED;
        a(context);
    }

    public MovieView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f5034e = true;
        this.f5035f = false;
        this.f5038i = 0;
        this.j = true;
        this.m = null;
        this.n = null;
        this.p = false;
        this.f5030a = 0;
        this.U = "0.0.0.0";
        this.V = true;
        this.W = 0;
        this.aa = 0;
        this.ab = 0;
        this.ac = false;
        this.ad = 1.0f;
        this.ae = new HashMap<>();
        h hVar = h.IDLE;
        this.G = hVar;
        this.H = hVar;
        this.K = false;
        this.T = i.PAUSED;
        a(context);
    }

    public void a(int i2, int i3) {
        setCurPlayerState(h.ERROR);
        this.H = h.ERROR;
        CyberPlayerManager.OnErrorListener onErrorListener = this.C;
        if (onErrorListener != null) {
            onErrorListener.onError(i2, i3, null);
        }
    }

    public void a(int i2, int i3, int i4, int i5) {
        if (i2 == 0 || i3 == 0 || this.f5033d == null) {
            return;
        }
        a(1, "on23DVideoSizeChanged w:" + i2 + " h:" + i3);
    }

    public void a(int i2, String str) {
    }

    public void a(Context context) {
        if (context != null) {
            this.f5031b = context.getApplicationContext();
        } else {
            CyberLog.e("VrMovieView", "Context not be null");
        }
    }

    public void a(boolean z) {
        a(z, true);
    }

    public void a(boolean z, boolean z2) {
        CyberPlayer cyberPlayer = this.f5037h;
        if (cyberPlayer != null) {
            cyberPlayer.setDisplay(null);
            this.f5037h.release();
            this.f5037h = null;
        }
        setCurPlayerState(h.IDLE);
        if (z2) {
            this.H = h.IDLE;
        }
        ((AudioManager) this.f5031b.getSystemService("audio")).abandonAudioFocus(null);
    }

    public boolean a(int i2) {
        return false;
    }

    public void b(int i2) {
        f();
        a(i2);
        Object[] objArr = new Object[1];
        View view = this.f5033d;
        objArr[0] = Integer.valueOf(view == null ? 0 : view.hashCode());
        a(1, String.format("rendView hashCode = %d", objArr));
        setFocusable(true);
        setFocusableInTouchMode(true);
    }

    public void b(int i2, int i3) {
        if (!isInPlaybackState()) {
            this.I = i2;
            this.J = i3;
            return;
        }
        this.f5037h.seekTo(i2, i3);
        this.I = 0;
        this.J = 3;
    }

    public boolean b() {
        return this.f5035f;
    }

    public void c() {
        this.I = 0;
        this.J = 3;
        this.L = false;
    }

    public void c(int i2) {
        a(this.n != null, false);
        ((AudioManager) this.f5031b.getSystemService("audio")).requestAudioFocus(null, 3, 1);
        this.f5037h = d(i2);
        HashMap<String, String> hashMap = this.ae;
        if (hashMap != null) {
            for (String str : hashMap.keySet()) {
                this.f5037h.setOption(str, this.ae.get(str));
            }
        }
        Surface surface = this.f5032c;
        if (surface != null) {
            this.f5037h.setSurface(surface);
        }
        this.f5037h.setOnPreparedListener(new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.cyberplayer.sdk.vrplayer.MovieView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                MovieView.this.a(1, "onPrepared");
                MovieView.this.setCurPlayerState(h.PREPARED);
                MovieView movieView = MovieView.this;
                movieView.f5037h.setLooping(movieView.K);
                CyberPlayerManager.OnPreparedListener onPreparedListener = MovieView.this.s;
                if (onPreparedListener != null) {
                    onPreparedListener.onPrepared();
                }
                MovieView movieView2 = MovieView.this;
                int i3 = movieView2.I;
                if (i3 != 0) {
                    movieView2.seekTo(i3, movieView2.J);
                }
                MovieView movieView3 = MovieView.this;
                if (movieView3.H == h.PLAYING) {
                    movieView3.start();
                } else if (movieView3.L) {
                    movieView3.pauseBuffering();
                }
            }
        });
        this.f5037h.setOnVideoSizeChangedListener(new CyberPlayerManager.OnVideoSizeChangedListener() { // from class: com.baidu.cyberplayer.sdk.vrplayer.MovieView.2
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnVideoSizeChangedListener
            public void onVideoSizeChanged(int i3, int i4, int i5, int i6) {
                MovieView.this.a(1, String.format("onVideoSizeChanged,w=%d,h=%d", Integer.valueOf(i3), Integer.valueOf(i4)));
                if (i3 == 0 || i4 == 0) {
                    return;
                }
                MovieView.this.a(i3, i4, i5, i6);
                MovieView.this.requestLayout();
                MovieView.this.aa = i3;
                MovieView.this.ab = i4;
                CyberPlayerManager.OnVideoSizeChangedListener onVideoSizeChangedListener = MovieView.this.B;
                if (onVideoSizeChangedListener != null) {
                    onVideoSizeChangedListener.onVideoSizeChanged(i3, i4, i5, i6);
                }
            }
        });
        this.f5037h.setOnCompletionListener(new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.cyberplayer.sdk.vrplayer.MovieView.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                MovieView.this.a(1, "onCompletion");
                MovieView.this.setCurPlayerState(h.PLAYBACK_COMPLETED);
                MovieView movieView = MovieView.this;
                movieView.H = h.PLAYBACK_COMPLETED;
                CyberPlayerManager.OnCompletionListener onCompletionListener = movieView.r;
                if (onCompletionListener != null) {
                    onCompletionListener.onCompletion();
                }
            }
        });
        this.f5037h.setOnErrorListener(new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.cyberplayer.sdk.vrplayer.MovieView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i3, int i4, Object obj) {
                MovieView.this.a(1, String.format("onError:err=%d,detail=%d", Integer.valueOf(i3), Integer.valueOf(i4)));
                if (i3 == -10000 && (i4 == 11 || i4 == 101 || i4 == -110 || i4 == -5)) {
                    i4 = 300;
                }
                MovieView.this.a(i3, i4);
                return true;
            }
        });
        this.f5037h.setOnInfoListener(new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.cyberplayer.sdk.vrplayer.MovieView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i3, int i4, Object obj) {
                MovieView.this.a(1, String.format("onInfo:what=%d,extra=%d", Integer.valueOf(i3), Integer.valueOf(i4)));
                CyberPlayerManager.OnInfoListener onInfoListener = MovieView.this.w;
                if (onInfoListener != null) {
                    onInfoListener.onInfo(i3, i4, null);
                }
                if (i3 == 701) {
                    MovieView.this.a(2, "onBufferingStart");
                    b bVar = MovieView.this.x;
                    if (bVar != null) {
                        bVar.a();
                    }
                } else if (i3 == 702) {
                    MovieView.this.a(2, "onBufferingEnd");
                    a aVar = MovieView.this.y;
                    if (aVar != null) {
                        aVar.a();
                    }
                } else if (i3 == 3) {
                    MovieView.this.a(1, "onRenderStart");
                    e eVar = MovieView.this.z;
                    if (eVar != null) {
                        eVar.a();
                    }
                }
                return true;
            }
        });
        this.f5037h.setOnBufferingUpdateListener(new CyberPlayerManager.OnBufferingUpdateListener() { // from class: com.baidu.cyberplayer.sdk.vrplayer.MovieView.6
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnBufferingUpdateListener
            public void onBufferingUpdate(int i3) {
                MovieView.this.a(2, String.format("onBufferingUpdate:percent=%d", Integer.valueOf(i3)));
                CyberPlayerManager.OnBufferingUpdateListener onBufferingUpdateListener = MovieView.this.t;
                if (onBufferingUpdateListener != null) {
                    onBufferingUpdateListener.onBufferingUpdate(i3);
                }
            }
        });
        this.f5037h.setOnSeekCompleteListener(new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.cyberplayer.sdk.vrplayer.MovieView.7
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                MovieView.this.a(1, "onSeekComplete");
                CyberPlayerManager.OnSeekCompleteListener onSeekCompleteListener = MovieView.this.v;
                if (onSeekCompleteListener != null) {
                    onSeekCompleteListener.onSeekComplete();
                }
            }
        });
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void changeProxyDynamic(String str) {
        if (this.f5037h != null && TextUtils.isEmpty(o.c())) {
            HashMap<String, String> hashMap = this.ae;
            String str2 = hashMap != null ? hashMap.get(CyberPlayerManager.OPT_HTTP_PROXY) : null;
            if (TextUtils.isEmpty(str)) {
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                this.f5037h.changeProxyDynamic(null, false);
            } else if (str.equals(str2)) {
                return;
            } else {
                this.f5037h.changeProxyDynamic(str, true);
            }
            this.f5037h.seekTo(getCurrentPosition() - 500);
            HashMap<String, String> hashMap2 = this.ae;
            if (hashMap2 != null) {
                hashMap2.put(CyberPlayerManager.OPT_HTTP_PROXY, str);
            }
        }
    }

    public CyberPlayer d(int i2) {
        int i3 = this.W;
        if (i3 == 3 || i3 < 0 || i3 > 4) {
            this.W = 0;
        }
        a(1, "createplayer : " + i2);
        return new CyberPlayer(this.W, null);
    }

    public boolean d() {
        return (this.f5035f || this.f5032c == null) ? false : true;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void destory() {
        destroy();
    }

    public void destroy() {
        a(1, "destroy");
        HashMap<String, String> hashMap = this.ae;
        if (hashMap != null) {
            hashMap.clear();
        }
        a(false);
        f();
        destroyRender();
        this.f5032c = null;
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

    public void destroyRender() {
    }

    public void e() {
        if (this.m == null || !d()) {
            return;
        }
        a(1, String.format("uri:%s ", this.m));
        c(this.f5038i);
        c();
        try {
            if (Build.VERSION.SDK_INT >= 14) {
                this.f5037h.setDataSource(this.f5031b, this.m, this.o);
            } else {
                this.f5037h.setDataSource(this.m.toString());
            }
            if (this.f5035f) {
                a(1, "video is 2d");
            } else {
                this.f5037h.setSurface(this.f5032c);
            }
            this.f5037h.prepareAsync();
            if (this.ac) {
                muteOrUnmuteAudio(this.ac);
            }
            setCurPlayerState(h.PREPARING);
        } catch (Exception unused) {
            a(1, 0);
        }
        requestLayout();
        invalidate();
    }

    public void e(int i2) {
        if (isInPlaybackState()) {
            this.f5037h.seekTo(i2);
            i2 = 0;
        }
        this.I = i2;
    }

    public void enableCache(String str) {
        this.f5036g = str;
    }

    public void f() {
        CyberPlayer cyberPlayer = this.f5037h;
        if (cyberPlayer != null) {
            cyberPlayer.setDisplay(null);
        }
        View view = this.f5033d;
        if (view != null) {
            removeView(view);
            this.f5033d = null;
        }
    }

    public void g() {
        if (isInPlaybackState() && (this.f5037h.isPlaying() || this.G == h.PREPARED)) {
            a(1, "pausePlayer");
            this.f5037h.pause();
            setCurPlayerState(h.PAUSED);
        }
        this.H = h.PAUSED;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public int getCurrentPosition() {
        if (isInPlaybackState()) {
            return this.f5037h.getCurrentPosition();
        }
        return 0;
    }

    public int getDecodeMode() {
        return this.W;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public int getDuration() {
        if (isInPlaybackState()) {
            return this.f5037h.getDuration();
        }
        return -1;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public long getPlayedTime() {
        h hVar;
        CyberPlayer cyberPlayer = this.f5037h;
        if (cyberPlayer == null || (hVar = this.G) == h.IDLE || hVar == h.PREPARING) {
            return -1L;
        }
        return cyberPlayer.getPlayedTime();
    }

    public int getPlayerType() {
        return this.f5038i;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public int getVideoHeight() {
        return this.ab;
    }

    public Uri getVideoUri() {
        return this.m;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public int getVideoWidth() {
        return this.aa;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public View getView() {
        return this;
    }

    public int getViewType() {
        return this.P;
    }

    public boolean init2D() {
        this.f5035f = true;
        if (this.f5038i == 0) {
            this.f5038i = 1;
        }
        if (this.P == 0) {
            this.P = 1;
        }
        a(1, String.format("playerType:" + this.f5038i + " interactiveMode:" + this.M + " displayMode:" + this.N + " sourceType:" + this.Q + " viewType:" + this.P, new Object[0]));
        b(this.P);
        return true;
    }

    public boolean isAllReady() {
        return (this.f5033d == null || this.f5037h == null || !b()) ? false : true;
    }

    public boolean isEnableDetachedSurfaceTextureView() {
        return this.f5034e;
    }

    public boolean isEnableMediaCodec() {
        return this.j;
    }

    public boolean isInPlaybackState() {
        h hVar;
        return (this.f5037h == null || (hVar = this.G) == h.ERROR || hVar == h.IDLE || hVar == h.PREPARING) ? false : true;
    }

    public boolean isLooping() {
        return this.K;
    }

    public boolean isPlayerIdle() {
        return this.f5037h != null && this.G == h.IDLE;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public boolean isPlaying() {
        return isInPlaybackState() && this.f5037h.isPlaying();
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void muteOrUnmuteAudio(boolean z) {
        this.ac = z;
        a(1, "muteOrUnmuteAudio flag:" + z);
        CyberPlayer cyberPlayer = this.f5037h;
        if (cyberPlayer != null) {
            cyberPlayer.muteOrUnmuteAudio(z);
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
            this.L = true;
        }
    }

    public void pauseRender() {
    }

    public void reStart() {
        this.p = true;
        setVideoName(this.k);
        setVideoURI(this.m);
        start();
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void reset() {
        this.ac = false;
        this.ad = 1.0f;
        resetPlayer();
    }

    public void resetPlayer() {
        CyberPlayer cyberPlayer = this.f5037h;
        if (cyberPlayer != null) {
            cyberPlayer.reset();
            this.f5037h.setSurface(this.f5032c);
        }
        setCurPlayerState(h.IDLE);
        this.H = h.IDLE;
        this.aa = 0;
        this.ab = 0;
    }

    public void resumeRender() {
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void seekTo(int i2) {
        if (i2 < 0 || getDuration() == 0) {
            return;
        }
        a(1, "seekTo");
        f fVar = this.u;
        if (fVar != null) {
            fVar.a();
        }
        e(i2);
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void seekTo(int i2, int i3) {
        if (i2 < 0 || getDuration() == 0) {
            return;
        }
        a(1, "seekTo");
        f fVar = this.u;
        if (fVar != null) {
            fVar.a();
        }
        b(i2, i3);
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setClarityInfo(String str) {
    }

    public void setCurPlayerState(h hVar) {
        this.G = hVar;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setDecodeMode(int i2) {
        this.W = i2;
    }

    public void setEnableDetachedSurfaceTextureView(boolean z) {
        this.f5034e = z;
    }

    public void setEnableMediaCodec(boolean z) {
        this.j = z;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setExternalInfo(String str, Object obj) {
        CyberPlayer cyberPlayer;
        if (TextUtils.isEmpty(str) || (cyberPlayer = this.f5037h) == null) {
            return;
        }
        cyberPlayer.setExternalInfo(str, obj);
    }

    public void setHttpProxy(String str) {
        this.q = str;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setLooping(boolean z) {
        CyberPlayer cyberPlayer = this.f5037h;
        if (cyberPlayer != null && this.G != h.ERROR) {
            cyberPlayer.setLooping(z);
        }
        this.K = z;
    }

    public void setOnBufferingEndListener(a aVar) {
        this.y = aVar;
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

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnMediaSourceChangedListener(CyberPlayerManager.OnMediaSourceChangedListener onMediaSourceChangedListener) {
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
        HashMap<String, String> hashMap = this.ae;
        if (hashMap != null) {
            hashMap.put(str, str2);
        }
        if (this.f5037h != null) {
            if (str == null || !str.equals(CyberPlayerManager.OPT_HTTP_PROXY) || TextUtils.isEmpty(o.c())) {
                this.f5037h.setOption(str, str2);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setPlayJson(String str) {
        CyberPlayer cyberPlayer = this.f5037h;
        if (cyberPlayer != null) {
            cyberPlayer.setPlayJson(str);
        }
    }

    public void setPlayerType(int i2) {
        this.f5038i = i2;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setRemote(boolean z) {
        this.V = z;
    }

    public void setScaleType(int i2) {
        this.f5030a = i2;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setSpeed(float f2) {
        a(1, "setSpeed()");
        this.ad = f2;
        CyberPlayer cyberPlayer = this.f5037h;
        if (cyberPlayer != null) {
            cyberPlayer.setSpeed(f2);
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
        this.P = i2;
    }

    public void setVolume(float f2) {
        CyberPlayer cyberPlayer = this.f5037h;
        if (cyberPlayer != null) {
            cyberPlayer.setVolume(f2, f2);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void start() {
        a(1, IntentConfig.START);
        startPlayer();
        resumeRender();
    }

    public void startPlayer() {
        if (isInPlaybackState()) {
            this.f5037h.start();
            setCurPlayerState(h.PLAYING);
        }
        this.H = h.PLAYING;
        a(1, "startPlayer");
    }

    public void stop() {
        a(1, IntentConfig.STOP);
        a(false);
        pauseRender();
        HashMap<String, String> hashMap = this.ae;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void stopPlayback() {
        stop();
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void switchMediaSource(int i2) {
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
