package com.baidu.cyberplayer.sdk.b;

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
import com.baidu.cyberplayer.sdk.n;
import com.baidu.sapi2.ecommerce.callback.AddressManageCallback;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class a extends FrameLayout implements ICyberVideoView {
    public g A;
    public CyberPlayerManager.OnVideoSizeChangedListener B;
    public CyberPlayerManager.OnErrorListener C;
    public c D;
    public View.OnTouchListener E;
    public d F;
    public h G;
    public h H;
    public int I;
    public boolean J;
    public boolean K;
    public int L;
    public int M;
    public int N;
    public int O;
    public int P;
    public int Q;
    public int R;
    public i S;
    public String T;
    public boolean U;
    public int V;
    public int W;

    /* renamed from: a  reason: collision with root package name */
    public int f4858a;
    public int aa;
    public boolean ab;
    public float ac;
    public HashMap<String, String> ad;

    /* renamed from: b  reason: collision with root package name */
    public Context f4859b;

    /* renamed from: c  reason: collision with root package name */
    public Surface f4860c;

    /* renamed from: d  reason: collision with root package name */
    public View f4861d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f4862e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f4863f;

    /* renamed from: g  reason: collision with root package name */
    public String f4864g;

    /* renamed from: h  reason: collision with root package name */
    public CyberPlayer f4865h;
    public int i;
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
    public InterfaceC0072a y;
    public e z;

    /* renamed from: com.baidu.cyberplayer.sdk.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0072a {
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
    public enum i {
        PAUSED,
        RESUMED
    }

    public a(Context context) {
        super(context);
        this.f4862e = true;
        this.f4863f = false;
        this.i = 0;
        this.j = true;
        this.m = null;
        this.n = null;
        this.p = false;
        this.f4858a = 0;
        this.T = "0.0.0.0";
        this.U = true;
        this.V = 0;
        this.W = 0;
        this.aa = 0;
        this.ab = false;
        this.ac = 1.0f;
        this.ad = new HashMap<>();
        h hVar = h.IDLE;
        this.G = hVar;
        this.H = hVar;
        this.J = false;
        this.S = i.PAUSED;
        if (isInEditMode()) {
            return;
        }
        a(context);
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4862e = true;
        this.f4863f = false;
        this.i = 0;
        this.j = true;
        this.m = null;
        this.n = null;
        this.p = false;
        this.f4858a = 0;
        this.T = "0.0.0.0";
        this.U = true;
        this.V = 0;
        this.W = 0;
        this.aa = 0;
        this.ab = false;
        this.ac = 1.0f;
        this.ad = new HashMap<>();
        h hVar = h.IDLE;
        this.G = hVar;
        this.H = hVar;
        this.J = false;
        this.S = i.PAUSED;
        a(context);
    }

    public a(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f4862e = true;
        this.f4863f = false;
        this.i = 0;
        this.j = true;
        this.m = null;
        this.n = null;
        this.p = false;
        this.f4858a = 0;
        this.T = "0.0.0.0";
        this.U = true;
        this.V = 0;
        this.W = 0;
        this.aa = 0;
        this.ab = false;
        this.ac = 1.0f;
        this.ad = new HashMap<>();
        h hVar = h.IDLE;
        this.G = hVar;
        this.H = hVar;
        this.J = false;
        this.S = i.PAUSED;
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
        if (i2 == 0 || i3 == 0 || this.f4861d == null) {
            return;
        }
        a(1, "on23DVideoSizeChanged w:" + i2 + " h:" + i3);
    }

    public void a(int i2, String str) {
    }

    public void a(Context context) {
        if (context != null) {
            this.f4859b = context.getApplicationContext();
        } else {
            CyberLog.e("VrMovieView", "Context not be null");
        }
    }

    public void a(boolean z) {
        a(z, true);
    }

    public void a(boolean z, boolean z2) {
        CyberPlayer cyberPlayer = this.f4865h;
        if (cyberPlayer != null) {
            cyberPlayer.setDisplay(null);
            this.f4865h.release();
            this.f4865h = null;
        }
        setCurPlayerState(h.IDLE);
        if (z2) {
            this.H = h.IDLE;
        }
        ((AudioManager) this.f4859b.getSystemService("audio")).abandonAudioFocus(null);
    }

    public boolean a(int i2) {
        return false;
    }

    public void b(int i2) {
        f();
        a(i2);
        Object[] objArr = new Object[1];
        View view = this.f4861d;
        objArr[0] = Integer.valueOf(view == null ? 0 : view.hashCode());
        a(1, String.format("rendView hashCode = %d", objArr));
        setFocusable(true);
        setFocusableInTouchMode(true);
    }

    public boolean b() {
        return this.f4863f;
    }

    public void c() {
        this.I = 0;
        this.K = false;
    }

    public void c(int i2) {
        a(this.n != null, false);
        ((AudioManager) this.f4859b.getSystemService("audio")).requestAudioFocus(null, 3, 1);
        this.f4865h = d(i2);
        HashMap<String, String> hashMap = this.ad;
        if (hashMap != null) {
            for (String str : hashMap.keySet()) {
                this.f4865h.setOption(str, this.ad.get(str));
            }
        }
        Surface surface = this.f4860c;
        if (surface != null) {
            this.f4865h.setSurface(surface);
        }
        this.f4865h.setOnPreparedListener(new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.cyberplayer.sdk.b.a.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                a.this.a(1, "onPrepared");
                a.this.setCurPlayerState(h.PREPARED);
                a aVar = a.this;
                aVar.f4865h.setLooping(aVar.J);
                CyberPlayerManager.OnPreparedListener onPreparedListener = a.this.s;
                if (onPreparedListener != null) {
                    onPreparedListener.onPrepared();
                }
                a aVar2 = a.this;
                int i3 = aVar2.I;
                if (i3 != 0) {
                    aVar2.seekTo(i3);
                }
                a aVar3 = a.this;
                if (aVar3.H == h.PLAYING) {
                    aVar3.start();
                } else if (aVar3.K) {
                    aVar3.pauseBuffering();
                }
            }
        });
        this.f4865h.setOnVideoSizeChangedListener(new CyberPlayerManager.OnVideoSizeChangedListener() { // from class: com.baidu.cyberplayer.sdk.b.a.2
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
                CyberPlayerManager.OnVideoSizeChangedListener onVideoSizeChangedListener = a.this.B;
                if (onVideoSizeChangedListener != null) {
                    onVideoSizeChangedListener.onVideoSizeChanged(i3, i4, i5, i6);
                }
            }
        });
        this.f4865h.setOnCompletionListener(new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.cyberplayer.sdk.b.a.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                a.this.a(1, "onCompletion");
                a.this.setCurPlayerState(h.PLAYBACK_COMPLETED);
                a aVar = a.this;
                aVar.H = h.PLAYBACK_COMPLETED;
                CyberPlayerManager.OnCompletionListener onCompletionListener = aVar.r;
                if (onCompletionListener != null) {
                    onCompletionListener.onCompletion();
                }
            }
        });
        this.f4865h.setOnErrorListener(new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.cyberplayer.sdk.b.a.4
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
        this.f4865h.setOnInfoListener(new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.cyberplayer.sdk.b.a.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i3, int i4, Object obj) {
                a.this.a(1, String.format("onInfo:what=%d,extra=%d", Integer.valueOf(i3), Integer.valueOf(i4)));
                CyberPlayerManager.OnInfoListener onInfoListener = a.this.w;
                if (onInfoListener != null) {
                    onInfoListener.onInfo(i3, i4, null);
                }
                if (i3 == 701) {
                    a.this.a(2, "onBufferingStart");
                    b bVar = a.this.x;
                    if (bVar != null) {
                        bVar.a();
                    }
                } else if (i3 == 702) {
                    a.this.a(2, "onBufferingEnd");
                    InterfaceC0072a interfaceC0072a = a.this.y;
                    if (interfaceC0072a != null) {
                        interfaceC0072a.a();
                    }
                } else if (i3 == 3) {
                    a.this.a(1, "onRenderStart");
                    e eVar = a.this.z;
                    if (eVar != null) {
                        eVar.a();
                    }
                }
                return true;
            }
        });
        this.f4865h.setOnBufferingUpdateListener(new CyberPlayerManager.OnBufferingUpdateListener() { // from class: com.baidu.cyberplayer.sdk.b.a.6
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnBufferingUpdateListener
            public void onBufferingUpdate(int i3) {
                a.this.a(2, String.format("onBufferingUpdate:percent=%d", Integer.valueOf(i3)));
                CyberPlayerManager.OnBufferingUpdateListener onBufferingUpdateListener = a.this.t;
                if (onBufferingUpdateListener != null) {
                    onBufferingUpdateListener.onBufferingUpdate(i3);
                }
            }
        });
        this.f4865h.setOnSeekCompleteListener(new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.cyberplayer.sdk.b.a.7
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                a.this.a(1, "onSeekComplete");
                CyberPlayerManager.OnSeekCompleteListener onSeekCompleteListener = a.this.v;
                if (onSeekCompleteListener != null) {
                    onSeekCompleteListener.onSeekComplete();
                }
            }
        });
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void changeProxyDynamic(String str) {
        if (this.f4865h != null && TextUtils.isEmpty(n.c())) {
            HashMap<String, String> hashMap = this.ad;
            String str2 = hashMap != null ? hashMap.get(CyberPlayerManager.OPT_HTTP_PROXY) : null;
            if (TextUtils.isEmpty(str)) {
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                this.f4865h.changeProxyDynamic(null, false);
            } else if (str.equals(str2)) {
                return;
            } else {
                this.f4865h.changeProxyDynamic(str, true);
            }
            this.f4865h.seekTo(getCurrentPosition() + AddressManageCallback.VoiceRecognitionResult.ERROR_CODE_VOICE_RECOGNITION_CANCEL);
            HashMap<String, String> hashMap2 = this.ad;
            if (hashMap2 != null) {
                hashMap2.put(CyberPlayerManager.OPT_HTTP_PROXY, str);
            }
        }
    }

    public CyberPlayer d(int i2) {
        int i3 = this.V;
        if (i3 == 3 || i3 < 0 || i3 > 4) {
            this.V = 0;
        }
        a(1, "createplayer : " + i2);
        return new CyberPlayer(this.V, null);
    }

    public boolean d() {
        return (this.f4863f || this.f4860c == null) ? false : true;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void destory() {
        destroy();
    }

    public void destroy() {
        a(1, "destroy");
        HashMap<String, String> hashMap = this.ad;
        if (hashMap != null) {
            hashMap.clear();
        }
        a(false);
        f();
        destroyRender();
        this.f4860c = null;
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
        c(this.i);
        c();
        try {
            if (Build.VERSION.SDK_INT >= 14) {
                this.f4865h.setDataSource(this.f4859b, this.m, this.o);
            } else {
                this.f4865h.setDataSource(this.m.toString());
            }
            if (this.f4863f) {
                a(1, "video is 2d");
            } else {
                this.f4865h.setSurface(this.f4860c);
            }
            this.f4865h.prepareAsync();
            if (this.ab) {
                muteOrUnmuteAudio(this.ab);
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
            this.f4865h.seekTo(i2);
            i2 = 0;
        }
        this.I = i2;
    }

    public void enableCache(String str) {
        this.f4864g = str;
    }

    public void f() {
        CyberPlayer cyberPlayer = this.f4865h;
        if (cyberPlayer != null) {
            cyberPlayer.setDisplay(null);
        }
        View view = this.f4861d;
        if (view != null) {
            removeView(view);
            this.f4861d = null;
        }
    }

    public void g() {
        if (isInPlaybackState() && (this.f4865h.isPlaying() || this.G == h.PREPARED)) {
            a(1, "pausePlayer");
            this.f4865h.pause();
            setCurPlayerState(h.PAUSED);
        }
        this.H = h.PAUSED;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public int getCurrentPosition() {
        if (isInPlaybackState()) {
            return this.f4865h.getCurrentPosition();
        }
        return 0;
    }

    public int getDecodeMode() {
        return this.V;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public int getDuration() {
        if (isInPlaybackState()) {
            return this.f4865h.getDuration();
        }
        return -1;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public long getPlayedTime() {
        h hVar;
        CyberPlayer cyberPlayer = this.f4865h;
        if (cyberPlayer == null || (hVar = this.G) == h.IDLE || hVar == h.PREPARING) {
            return -1L;
        }
        return cyberPlayer.getPlayedTime();
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
        this.f4863f = true;
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
        return (this.f4861d == null || this.f4865h == null || !b()) ? false : true;
    }

    public boolean isEnableDetachedSurfaceTextureView() {
        return this.f4862e;
    }

    public boolean isEnableMediaCodec() {
        return this.j;
    }

    public boolean isInPlaybackState() {
        h hVar;
        return (this.f4865h == null || (hVar = this.G) == h.ERROR || hVar == h.IDLE || hVar == h.PREPARING) ? false : true;
    }

    public boolean isLooping() {
        return this.J;
    }

    public boolean isPlayerIdle() {
        return this.f4865h != null && this.G == h.IDLE;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public boolean isPlaying() {
        return isInPlaybackState() && this.f4865h.isPlaying();
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void muteOrUnmuteAudio(boolean z) {
        this.ab = z;
        a(1, "muteOrUnmuteAudio flag:" + z);
        CyberPlayer cyberPlayer = this.f4865h;
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
            this.K = true;
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
        this.ab = false;
        this.ac = 1.0f;
        resetPlayer();
    }

    public void resetPlayer() {
        CyberPlayer cyberPlayer = this.f4865h;
        if (cyberPlayer != null) {
            cyberPlayer.reset();
            this.f4865h.setSurface(this.f4860c);
        }
        setCurPlayerState(h.IDLE);
        this.H = h.IDLE;
        this.W = 0;
        this.aa = 0;
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
    public void setClarityInfo(String str) {
    }

    public void setCurPlayerState(h hVar) {
        this.G = hVar;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setDecodeMode(int i2) {
        this.V = i2;
    }

    public void setEnableDetachedSurfaceTextureView(boolean z) {
        this.f4862e = z;
    }

    public void setEnableMediaCodec(boolean z) {
        this.j = z;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setExternalInfo(String str, Object obj) {
        CyberPlayer cyberPlayer;
        if (TextUtils.isEmpty(str) || (cyberPlayer = this.f4865h) == null) {
            return;
        }
        cyberPlayer.setExternalInfo(str, obj);
    }

    public void setHttpProxy(String str) {
        this.q = str;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setLooping(boolean z) {
        CyberPlayer cyberPlayer = this.f4865h;
        if (cyberPlayer != null && this.G != h.ERROR) {
            cyberPlayer.setLooping(z);
        }
        this.J = z;
    }

    public void setOnBufferingEndListener(InterfaceC0072a interfaceC0072a) {
        this.y = interfaceC0072a;
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
        HashMap<String, String> hashMap = this.ad;
        if (hashMap != null) {
            hashMap.put(str, str2);
        }
        if (this.f4865h != null) {
            if (str == null || !str.equals(CyberPlayerManager.OPT_HTTP_PROXY) || TextUtils.isEmpty(n.c())) {
                this.f4865h.setOption(str, str2);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setPlayJson(String str) {
        CyberPlayer cyberPlayer = this.f4865h;
        if (cyberPlayer != null) {
            cyberPlayer.setPlayJson(str);
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
        this.f4858a = i2;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setSpeed(float f2) {
        a(1, "setSpeed()");
        this.ac = f2;
        CyberPlayer cyberPlayer = this.f4865h;
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
        this.O = i2;
    }

    public void setVolume(float f2) {
        CyberPlayer cyberPlayer = this.f4865h;
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
            this.f4865h.start();
            setCurPlayerState(h.PLAYING);
        }
        this.H = h.PLAYING;
        a(1, "startPlayer");
    }

    public void stop() {
        a(1, IntentConfig.STOP);
        a(false);
        pauseRender();
        HashMap<String, String> hashMap = this.ad;
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
