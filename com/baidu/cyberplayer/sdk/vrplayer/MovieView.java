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
import com.baidu.cyberplayer.sdk.mediainfo.MediaInfo;
import com.baidu.cyberplayer.sdk.q;
import com.baidu.searchbox.download.constants.DownloadStatisticConstants;
import com.yy.mobile.framework.revenuesdk.baseapi.ErrorCode;
import java.util.HashMap;
import java.util.Map;
@Keep
/* loaded from: classes3.dex */
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

    /* renamed from: T  reason: collision with root package name */
    public i f1041T;
    public String U;
    public boolean V;
    public int W;
    public int a;
    public int aa;
    public int ab;
    public boolean ac;
    public float ad;
    public HashMap<String, String> ae;
    public Context b;
    public Surface c;
    public View d;
    public boolean e;
    public boolean f;
    public String g;
    public CyberPlayer h;
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
    public a y;
    public e z;

    /* loaded from: classes3.dex */
    public interface a {
        void a();
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a();
    }

    /* loaded from: classes3.dex */
    public interface c {
    }

    /* loaded from: classes3.dex */
    public interface d {
    }

    /* loaded from: classes3.dex */
    public interface e {
        void a();
    }

    /* loaded from: classes3.dex */
    public interface f {
        void a();
    }

    /* loaded from: classes3.dex */
    public interface g {
        void a();
    }

    /* loaded from: classes3.dex */
    public enum h {
        ERROR,
        IDLE,
        PREPARING,
        PREPARED,
        PLAYING,
        PAUSED,
        PLAYBACK_COMPLETED
    }

    /* loaded from: classes3.dex */
    public enum i {
        PAUSED,
        RESUMED
    }

    public void a(int i2, String str) {
    }

    public boolean a(int i2) {
        return false;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void debugShowOptions(View view2) {
    }

    public void destroyRender() {
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public View getView() {
        return this;
    }

    public void pauseRender() {
    }

    public void resumeRender() {
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setClarityInfo(String str) {
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setExternalSurface(Surface surface) {
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public boolean setFilterRegion(float f2, float f3, float f4, float f5) {
        return false;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnMediaSourceChangedListener(CyberPlayerManager.OnMediaSourceChangedListener onMediaSourceChangedListener) {
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setVideoRotation(int i2) {
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setVideoScalingMode(int i2) {
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void stepToNextFrame() {
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void switchMediaSource(int i2) {
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void switchMediaSource(int i2, CyberPlayerManager.MediaSourceSwitchMode mediaSourceSwitchMode) {
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public boolean takeSnapshotAsync(ICyberVideoView.OnSnapShotCompleteListener onSnapShotCompleteListener) {
        return true;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public boolean takeSnapshotAsync(ICyberVideoView.OnSnapShotCompleteListener onSnapShotCompleteListener, float f2, int i2, int i3) {
        return true;
    }

    public MovieView(Context context) {
        super(context);
        this.e = true;
        this.f = false;
        this.i = 0;
        this.j = true;
        this.m = null;
        this.n = null;
        this.p = false;
        this.a = 0;
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
        this.f1041T = i.PAUSED;
        if (!isInEditMode()) {
            a(context);
        }
    }

    public MovieView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = true;
        this.f = false;
        this.i = 0;
        this.j = true;
        this.m = null;
        this.n = null;
        this.p = false;
        this.a = 0;
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
        this.f1041T = i.PAUSED;
        a(context);
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOption(String str, String str2) {
        if (this.G == h.IDLE) {
            HashMap<String, String> hashMap = this.ae;
            if (hashMap != null) {
                hashMap.put(str, str2);
            }
            if (this.h != null) {
                if (str != null && str.equals(CyberPlayerManager.OPT_HTTP_PROXY) && !TextUtils.isEmpty(q.c())) {
                    return;
                }
                this.h.setOption(str, str2);
                return;
            }
            return;
        }
        a(1, "Do not set option when the video player playing");
    }

    public MovieView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.e = true;
        this.f = false;
        this.i = 0;
        this.j = true;
        this.m = null;
        this.n = null;
        this.p = false;
        this.a = 0;
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
        this.f1041T = i.PAUSED;
        a(context);
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void seekTo(int i2, int i3) {
        if (i2 >= 0 && getDuration() != 0) {
            a(1, "seekTo");
            f fVar = this.u;
            if (fVar != null) {
                fVar.a();
            }
            b(i2, i3);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setExternalInfo(String str, Object obj) {
        CyberPlayer cyberPlayer;
        if (!TextUtils.isEmpty(str) && (cyberPlayer = this.h) != null) {
            cyberPlayer.setExternalInfo(str, obj);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setVideoURI(Uri uri, Map<String, String> map) {
        setVideoURI(uri, map, null);
    }

    public void a(int i2, int i3) {
        setCurPlayerState(h.ERROR);
        this.H = h.ERROR;
        CyberPlayerManager.OnErrorListener onErrorListener = this.C;
        if (onErrorListener != null) {
            onErrorListener.onError(i2, i3, null);
        }
    }

    public void b(int i2, int i3) {
        if (isInPlaybackState()) {
            this.h.seekTo(i2, i3);
            this.I = 0;
            this.J = 3;
            return;
        }
        this.I = i2;
        this.J = i3;
    }

    public void a(int i2, int i3, int i4, int i5) {
        if (i2 != 0 && i3 != 0 && this.d != null) {
            a(1, "on23DVideoSizeChanged w:" + i2 + " h:" + i3);
        }
    }

    public void a(Context context) {
        if (context != null) {
            this.b = context.getApplicationContext();
        } else {
            CyberLog.e("VrMovieView", "Context not be null");
        }
    }

    public void b(int i2) {
        int hashCode;
        f();
        a(i2);
        Object[] objArr = new Object[1];
        View view2 = this.d;
        if (view2 == null) {
            hashCode = 0;
        } else {
            hashCode = view2.hashCode();
        }
        objArr[0] = Integer.valueOf(hashCode);
        a(1, String.format("rendView hashCode = %d", objArr));
        setFocusable(true);
        setFocusableInTouchMode(true);
    }

    public CyberPlayer d(int i2) {
        int i3 = this.W;
        if (i3 == 3 || i3 < 0 || i3 > 4) {
            this.W = 0;
        }
        a(1, "createplayer : " + i2);
        return new CyberPlayer(this.W, null);
    }

    public void e(int i2) {
        if (isInPlaybackState()) {
            this.h.seekTo(i2);
            this.I = 0;
            return;
        }
        this.I = i2;
    }

    public void enableCache(String str) {
        this.g = str;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void getMediaRuntimeInfo(CyberPlayerManager.OnMediaRuntimeInfoListener onMediaRuntimeInfoListener) {
        CyberPlayer cyberPlayer = this.h;
        if (cyberPlayer != null) {
            cyberPlayer.getMediaRuntimeInfo(onMediaRuntimeInfoListener);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void muteOrUnmuteAudio(boolean z) {
        this.ac = z;
        a(1, "muteOrUnmuteAudio flag:" + z);
        CyberPlayer cyberPlayer = this.h;
        if (cyberPlayer != null) {
            cyberPlayer.muteOrUnmuteAudio(z);
        } else {
            a(1, "muteOrUnmuteAudio must call after setVideoPath or setVideoURI");
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void seekTo(int i2) {
        if (i2 >= 0 && getDuration() != 0) {
            a(1, "seekTo");
            f fVar = this.u;
            if (fVar != null) {
                fVar.a();
            }
            e(i2);
        }
    }

    public void setCurPlayerState(h hVar) {
        this.G = hVar;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setDecodeMode(int i2) {
        this.W = i2;
    }

    public void setEnableDetachedSurfaceTextureView(boolean z) {
        this.e = z;
    }

    public void setEnableMediaCodec(boolean z) {
        this.j = z;
    }

    public void setHttpProxy(String str) {
        this.q = str;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setLooping(boolean z) {
        CyberPlayer cyberPlayer = this.h;
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
    public void setPlayJson(String str) {
        CyberPlayer cyberPlayer = this.h;
        if (cyberPlayer != null) {
            cyberPlayer.setPlayJson(str);
        }
    }

    public void setPlayerType(int i2) {
        this.i = i2;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setRemote(boolean z) {
        this.V = z;
    }

    public void setScaleType(int i2) {
        this.a = i2;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setSpeed(float f2) {
        a(1, "setSpeed()");
        this.ad = f2;
        CyberPlayer cyberPlayer = this.h;
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
    public void setVideoURI(Uri uri) {
        setVideoURI(uri, null);
    }

    public void setViewType(int i2) {
        this.P = i2;
    }

    public void setVolume(float f2) {
        CyberPlayer cyberPlayer = this.h;
        if (cyberPlayer != null) {
            cyberPlayer.setVolume(f2, f2);
        }
    }

    public void a(boolean z) {
        a(z, true);
    }

    public void a(boolean z, boolean z2) {
        CyberPlayer cyberPlayer = this.h;
        if (cyberPlayer != null) {
            cyberPlayer.setDisplay(null);
            this.h.release();
            this.h = null;
        }
        setCurPlayerState(h.IDLE);
        if (z2) {
            this.H = h.IDLE;
        }
        ((AudioManager) this.b.getSystemService("audio")).abandonAudioFocus(null);
    }

    public boolean b() {
        return this.f;
    }

    public void c() {
        this.I = 0;
        this.J = 3;
        this.L = false;
    }

    public boolean d() {
        if (!this.f && this.c != null) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void destory() {
        destroy();
    }

    public void f() {
        CyberPlayer cyberPlayer = this.h;
        if (cyberPlayer != null) {
            cyberPlayer.setDisplay(null);
        }
        View view2 = this.d;
        if (view2 != null) {
            removeView(view2);
            this.d = null;
        }
    }

    public void g() {
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

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public int getDecodeMode() {
        return this.W;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public int getDuration() {
        if (isInPlaybackState()) {
            return this.h.getDuration();
        }
        return -1;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public MediaInfo getMediaInfo() {
        CyberPlayer cyberPlayer = this.h;
        if (cyberPlayer == null) {
            return null;
        }
        return cyberPlayer.getMediaInfo();
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public long getPlayedTime() {
        h hVar;
        CyberPlayer cyberPlayer = this.h;
        if (cyberPlayer != null && (hVar = this.G) != h.IDLE && hVar != h.PREPARING) {
            return cyberPlayer.getPlayedTime();
        }
        return -1L;
    }

    public int getPlayerType() {
        return this.i;
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

    public int getViewType() {
        return this.P;
    }

    public boolean isAllReady() {
        if (this.d != null && this.h != null && b()) {
            return true;
        }
        return false;
    }

    public boolean isEnableDetachedSurfaceTextureView() {
        return this.e;
    }

    public boolean isEnableMediaCodec() {
        return this.j;
    }

    public boolean isInPlaybackState() {
        h hVar;
        if (this.h != null && (hVar = this.G) != h.ERROR && hVar != h.IDLE && hVar != h.PREPARING) {
            return true;
        }
        return false;
    }

    public boolean isLooping() {
        return this.K;
    }

    public boolean isPlayerIdle() {
        if (this.h != null && this.G == h.IDLE) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public boolean isPlaying() {
        if (isInPlaybackState() && this.h.isPlaying()) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void pause() {
        a(1, DownloadStatisticConstants.UBC_TYPE_PAUSE);
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
        CyberPlayer cyberPlayer = this.h;
        if (cyberPlayer != null) {
            cyberPlayer.reset();
            this.h.setSurface(this.c);
        }
        setCurPlayerState(h.IDLE);
        this.H = h.IDLE;
        this.aa = 0;
        this.ab = 0;
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
        HashMap<String, String> hashMap = this.ae;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void stopPlayback() {
        stop();
    }

    public void c(int i2) {
        boolean z;
        if (this.n != null) {
            z = true;
        } else {
            z = false;
        }
        a(z, false);
        ((AudioManager) this.b.getSystemService("audio")).requestAudioFocus(null, 3, 1);
        this.h = d(i2);
        HashMap<String, String> hashMap = this.ae;
        if (hashMap != null) {
            for (String str : hashMap.keySet()) {
                this.h.setOption(str, this.ae.get(str));
            }
        }
        Surface surface = this.c;
        if (surface != null) {
            this.h.setSurface(surface);
        }
        this.h.setOnPreparedListener(new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.cyberplayer.sdk.vrplayer.MovieView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                MovieView.this.a(1, "onPrepared");
                MovieView.this.setCurPlayerState(h.PREPARED);
                MovieView movieView = MovieView.this;
                movieView.h.setLooping(movieView.K);
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
        this.h.setOnVideoSizeChangedListener(new CyberPlayerManager.OnVideoSizeChangedListener() { // from class: com.baidu.cyberplayer.sdk.vrplayer.MovieView.2
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnVideoSizeChangedListener
            public void onVideoSizeChanged(int i3, int i4, int i5, int i6) {
                MovieView.this.a(1, String.format("onVideoSizeChanged,w=%d,h=%d", Integer.valueOf(i3), Integer.valueOf(i4)));
                if (i3 != 0 && i4 != 0) {
                    MovieView.this.a(i3, i4, i5, i6);
                    MovieView.this.requestLayout();
                    MovieView.this.aa = i3;
                    MovieView.this.ab = i4;
                    CyberPlayerManager.OnVideoSizeChangedListener onVideoSizeChangedListener = MovieView.this.B;
                    if (onVideoSizeChangedListener != null) {
                        onVideoSizeChangedListener.onVideoSizeChanged(i3, i4, i5, i6);
                    }
                }
            }
        });
        this.h.setOnCompletionListener(new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.cyberplayer.sdk.vrplayer.MovieView.3
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
        this.h.setOnErrorListener(new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.cyberplayer.sdk.vrplayer.MovieView.4
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
        this.h.setOnInfoListener(new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.cyberplayer.sdk.vrplayer.MovieView.5
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
        this.h.setOnBufferingUpdateListener(new CyberPlayerManager.OnBufferingUpdateListener() { // from class: com.baidu.cyberplayer.sdk.vrplayer.MovieView.6
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnBufferingUpdateListener
            public void onBufferingUpdate(int i3) {
                MovieView.this.a(2, String.format("onBufferingUpdate:percent=%d", Integer.valueOf(i3)));
                CyberPlayerManager.OnBufferingUpdateListener onBufferingUpdateListener = MovieView.this.t;
                if (onBufferingUpdateListener != null) {
                    onBufferingUpdateListener.onBufferingUpdate(i3);
                }
            }
        });
        this.h.setOnSeekCompleteListener(new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.cyberplayer.sdk.vrplayer.MovieView.7
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
        String str2;
        if (this.h == null || !TextUtils.isEmpty(q.c())) {
            return;
        }
        HashMap<String, String> hashMap = this.ae;
        if (hashMap != null) {
            str2 = hashMap.get(CyberPlayerManager.OPT_HTTP_PROXY);
        } else {
            str2 = null;
        }
        if (!TextUtils.isEmpty(str)) {
            if (str.equals(str2)) {
                return;
            }
            this.h.changeProxyDynamic(str, true);
        } else if (TextUtils.isEmpty(str2)) {
            return;
        } else {
            this.h.changeProxyDynamic(null, false);
        }
        this.h.seekTo(getCurrentPosition() + ErrorCode.SERVER_ERROR);
        HashMap<String, String> hashMap2 = this.ae;
        if (hashMap2 != null) {
            hashMap2.put(CyberPlayerManager.OPT_HTTP_PROXY, str);
        }
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

    public void e() {
        if (this.m != null && d()) {
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
    }

    public boolean init2D() {
        this.f = true;
        if (this.i == 0) {
            this.i = 1;
        }
        if (this.P == 0) {
            this.P = 1;
        }
        a(1, String.format("playerType:" + this.i + " interactiveMode:" + this.M + " displayMode:" + this.N + " sourceType:" + this.Q + " viewType:" + this.P, new Object[0]));
        b(this.P);
        return true;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setVideoURI(Uri uri, Map<String, String> map, Map<String, String> map2) {
        a(1, "videoURI:" + uri.toString());
        if (map2 != null) {
            this.ae.putAll(map2);
        }
        this.n = this.m;
        this.m = uri;
        this.o = map;
        e();
    }
}
