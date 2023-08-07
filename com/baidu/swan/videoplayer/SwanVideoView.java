package com.baidu.swan.videoplayer;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.PlaybackParams;
import android.net.Uri;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.baidu.swan.videoplayer.media.video.view.MediaGestureLayout;
import com.baidu.swan.videoplayer.widget.MediaController;
import com.baidu.swan.videoplayer.widget.MediaTipStateLayer;
import com.baidu.tieba.R;
import com.baidu.tieba.ns4;
import com.baidu.tieba.qs4;
import com.baidu.tieba.rs4;
import com.baidu.tieba.ss4;
import com.baidu.tieba.ts4;
import com.baidu.tieba.vr4;
import com.baidu.tieba.yr4;
import java.io.IOException;
import java.util.Map;
/* loaded from: classes4.dex */
public class SwanVideoView extends FrameLayout {
    public boolean A;
    public AudioManager B;
    public AudioManager.OnAudioFocusChangeListener C;
    public boolean D;
    public MediaPlayer.OnPreparedListener E;
    public MediaPlayer.OnCompletionListener F;
    public MediaPlayer.OnVideoSizeChangedListener G;
    public MediaPlayer.OnErrorListener H;
    public MediaPlayer.OnBufferingUpdateListener I;
    public MediaPlayer.OnSeekCompleteListener J;
    public vr4.a K;
    public int a;
    public boolean b;
    public Uri c;
    public Map<String, String> d;
    public MediaController e;
    public rs4 f;
    public ss4 g;
    public ts4 h;
    public qs4 i;
    public MediaTipStateLayer j;
    public ns4 k;
    public MediaPlayer l;
    public int m;
    public Context n;
    public int o;
    public boolean p;
    public boolean q;
    public boolean r;
    public boolean s;
    public View t;
    public int u;
    public vr4 v;
    public int w;
    public int x;
    public FrameLayout y;
    public yr4 z;

    public void setDirection(int i) {
    }

    /* loaded from: classes4.dex */
    public class a extends MediaGestureLayout.c {
        public a() {
        }

        @Override // com.baidu.swan.videoplayer.media.video.view.MediaGestureLayout.c, com.baidu.swan.videoplayer.media.video.view.MediaGestureLayout.b
        public void a(MotionEvent motionEvent) {
            SwanVideoView.this.a0();
        }

        @Override // com.baidu.swan.videoplayer.media.video.view.MediaGestureLayout.c, com.baidu.swan.videoplayer.media.video.view.MediaGestureLayout.b
        public void c(int i) {
            SwanVideoView.this.H(i);
        }

        @Override // com.baidu.swan.videoplayer.media.video.view.MediaGestureLayout.c, com.baidu.swan.videoplayer.media.video.view.MediaGestureLayout.b
        public void onDoubleTap(MotionEvent motionEvent) {
            if (SwanVideoView.this.z()) {
                SwanVideoView.this.C();
            } else {
                SwanVideoView.this.X();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements MediaPlayer.OnPreparedListener {
        public b() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            SwanVideoView.this.setCurrentState(2);
            SwanVideoView.this.setCacheViewVisibility(false);
            if (SwanVideoView.this.z != null) {
                SwanVideoView.this.z.onPrepared();
            }
            SwanVideoView.this.w = mediaPlayer.getVideoWidth();
            SwanVideoView.this.x = mediaPlayer.getVideoHeight();
            if (SwanVideoView.this.w != 0 && SwanVideoView.this.x != 0 && SwanVideoView.this.v != null) {
                SwanVideoView.this.v.setVideoSize(SwanVideoView.this.w, SwanVideoView.this.x);
            }
            if (SwanVideoView.this.b) {
                SwanVideoView.this.X();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements MediaPlayer.OnCompletionListener {
        public c() {
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            Log.d("SwanVideoView", "onCompletion");
            SwanVideoView.this.setCacheViewVisibility(false);
            SwanVideoView.this.setCurrentState(5);
            SwanVideoView.this.b = false;
            if (SwanVideoView.this.z != null) {
                SwanVideoView.this.z.a();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements MediaPlayer.OnVideoSizeChangedListener {
        public d() {
        }

        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
            SwanVideoView.this.w = mediaPlayer.getVideoWidth();
            SwanVideoView.this.x = mediaPlayer.getVideoHeight();
            if (SwanVideoView.this.w != 0 && SwanVideoView.this.x != 0) {
                if (SwanVideoView.this.v != null) {
                    SwanVideoView.this.v.setVideoSize(SwanVideoView.this.w, SwanVideoView.this.x);
                }
                if (SwanVideoView.this.z != null) {
                    SwanVideoView.this.z.onVideoSizeChanged(i, i2);
                }
                SwanVideoView.this.requestLayout();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements MediaPlayer.OnErrorListener {
        public e() {
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            Log.d("SwanVideoView", "onError: " + i + "," + i2);
            SwanVideoView.this.setCurrentState(-1);
            SwanVideoView.this.b = false;
            SwanVideoView.this.setCacheViewVisibility(false);
            if (SwanVideoView.this.z != null) {
                SwanVideoView.this.z.onError(i, i2, null);
            }
            if (SwanVideoView.this.z == null) {
                return false;
            }
            return true;
        }
    }

    /* loaded from: classes4.dex */
    public class f implements MediaPlayer.OnBufferingUpdateListener {
        public f() {
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            Log.d("SwanVideoView", "onBufferingUpdate: percent=" + i);
            SwanVideoView.this.m = i;
            if (SwanVideoView.this.z != null) {
                SwanVideoView.this.z.onBufferingUpdate(i);
            }
            if (SwanVideoView.this.e != null) {
                SwanVideoView.this.e.o((i * SwanVideoView.this.getDuration()) / 100);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements MediaPlayer.OnSeekCompleteListener {
        public g() {
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            Log.d("SwanVideoView", "onSeekComplete");
            SwanVideoView.this.setCacheViewVisibility(false);
            if (SwanVideoView.this.z != null) {
                SwanVideoView.this.z.onSeekEnd();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements vr4.a {
        @Override // com.baidu.tieba.vr4.a
        public void a(vr4.b bVar) {
        }

        @Override // com.baidu.tieba.vr4.a
        public void c(vr4.b bVar, int i, int i2, int i3) {
        }

        public h() {
        }

        @Override // com.baidu.tieba.vr4.a
        public void b(vr4.b bVar, int i, int i2) {
            if (bVar.b() == SwanVideoView.this.v && SwanVideoView.this.l != null) {
                SwanVideoView swanVideoView = SwanVideoView.this;
                swanVideoView.r(swanVideoView.l, bVar);
            }
        }
    }

    public SwanVideoView(Context context) {
        super(context);
        this.a = 0;
        this.o = -1;
        this.s = true;
        this.u = 0;
        this.E = new b();
        this.F = new c();
        this.G = new d();
        this.H = new e();
        this.I = new f();
        this.J = new g();
        this.K = new h();
        v(context);
    }

    public void setVideoPath(String str) {
        Uri parse = Uri.parse(str);
        this.c = parse;
        if (parse == null) {
            return;
        }
        MediaPlayer mediaPlayer = this.l;
        if (mediaPlayer != null) {
            try {
                mediaPlayer.setDataSource(this.n, parse, this.d);
                this.l.prepareAsync();
                setCacheViewVisibility(true);
                setCurrentState(1);
            } catch (IOException unused) {
                setCurrentState(-1);
                this.b = false;
                this.H.onError(this.l, 1, 0);
            }
        }
        requestLayout();
        invalidate();
    }

    public SwanVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = 0;
        this.o = -1;
        this.s = true;
        this.u = 0;
        this.E = new b();
        this.F = new c();
        this.G = new d();
        this.H = new e();
        this.I = new f();
        this.J = new g();
        this.K = new h();
        v(context);
    }

    public SwanVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = 0;
        this.o = -1;
        this.s = true;
        this.u = 0;
        this.E = new b();
        this.F = new c();
        this.G = new d();
        this.H = new e();
        this.I = new f();
        this.J = new g();
        this.K = new h();
        v(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCacheViewVisibility(boolean z) {
        if (z) {
            this.t.setVisibility(0);
        } else {
            this.t.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCurrentState(int i) {
        if (this.a != i) {
            this.a = i;
            MediaController mediaController = this.e;
            if (mediaController != null) {
                mediaController.E();
            }
        }
    }

    public void H(int i) {
        if (w()) {
            if (i >= this.l.getDuration()) {
                i = this.l.getDuration() - 1000;
            }
            this.l.seekTo(i);
            if (i > 0) {
                setCacheViewVisibility(true);
            }
        }
    }

    public int I(String str) {
        try {
            if (J(Float.parseFloat(str))) {
                this.g.g(str);
                return 0;
            }
            return 1001;
        } catch (NumberFormatException unused) {
            return 202;
        }
    }

    public boolean J(float f2) {
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                PlaybackParams playbackParams = this.l.getPlaybackParams();
                playbackParams.setSpeed(f2);
                boolean isPlaying = this.l.isPlaying();
                this.l.setPlaybackParams(playbackParams);
                if (!isPlaying) {
                    this.l.pause();
                    return true;
                }
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public void K(boolean z) {
        MediaController mediaController = this.e;
        if (mediaController != null && this.s) {
            mediaController.r(z);
        }
    }

    public void L(boolean z) {
        MediaController mediaController = this.e;
        if (mediaController != null && this.s) {
            mediaController.s(z);
        }
    }

    public void M(boolean z) {
        MediaController mediaController = this.e;
        if (mediaController != null && this.s) {
            mediaController.y(z);
        }
    }

    public void N(boolean z) {
        MediaController mediaController = this.e;
        if (mediaController != null && this.s) {
            mediaController.t(z);
        }
    }

    public void O(boolean z) {
        MediaController mediaController = this.e;
        if (mediaController != null && this.s) {
            mediaController.u(z);
        }
    }

    public void P(boolean z) {
        MediaController mediaController = this.e;
        if (mediaController != null && this.s) {
            mediaController.v(z);
        }
    }

    public void Q(String str) {
        MediaController mediaController = this.e;
        if (mediaController != null && this.s) {
            mediaController.k();
        }
        ts4 ts4Var = this.h;
        if (ts4Var != null) {
            ts4Var.e(str);
        }
    }

    public void S(boolean z) {
        MediaController mediaController = this.e;
        if (mediaController != null && this.s) {
            mediaController.w(z);
        }
    }

    public void T(boolean z) {
        MediaController mediaController = this.e;
        if (mediaController != null && this.s) {
            mediaController.x(z);
        }
    }

    public void V(boolean z) {
        rs4 rs4Var = this.f;
        if (rs4Var != null) {
            if (z) {
                rs4Var.h();
            } else {
                rs4Var.b();
            }
        }
    }

    public void W(boolean z) {
        MediaController mediaController;
        this.r = z;
        rs4 rs4Var = this.f;
        if (rs4Var != null) {
            rs4Var.i(z);
        }
        if (z && (mediaController = this.e) != null) {
            mediaController.k();
        }
    }

    public void b0(boolean z) {
        this.k.h(z);
    }

    public void c0(MediaTipStateLayer.TipState tipState) {
        this.j.h(tipState);
    }

    public final void q(Context context) {
        this.i = new qs4(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.i.h(new a());
        addView(this.i.f(), layoutParams);
        this.i.d(this);
    }

    public void setAudioFocusListener(AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener) {
        this.C = onAudioFocusChangeListener;
    }

    public void setHeaders(Map<String, String> map) {
        this.d = map;
    }

    public void setInitPlayPosition(int i) {
        this.o = i;
        MediaPlayer mediaPlayer = this.l;
        if (mediaPlayer != null) {
            mediaPlayer.seekTo(i);
            this.o = -1;
        }
    }

    public void setIsLandscape(boolean z) {
        this.A = z;
        MediaController mediaController = this.e;
        if (mediaController != null) {
            mediaController.p(z);
        }
        ns4 ns4Var = this.k;
        if (ns4Var != null) {
            ns4Var.g(z);
        }
        MediaTipStateLayer mediaTipStateLayer = this.j;
        if (mediaTipStateLayer != null) {
            mediaTipStateLayer.g(z);
        }
        t();
    }

    public void setLooping(boolean z) {
        this.p = z;
        MediaPlayer mediaPlayer = this.l;
        if (mediaPlayer != null) {
            mediaPlayer.setLooping(z);
        }
    }

    public void setMediaControllerEnabled(boolean z) {
        MediaController mediaController;
        this.s = z;
        if (!z && (mediaController = this.e) != null) {
            mediaController.k();
        }
    }

    public void setMediaGesture(@NonNull ns4 ns4Var) {
        this.k = ns4Var;
        this.i.e(ns4Var);
    }

    public void setMuted(boolean z) {
        float f2;
        if (this.l != null) {
            if (z) {
                f2 = 0.0f;
            } else {
                f2 = 1.0f;
            }
            setVolume(f2);
            this.q = z;
            MediaController mediaController = this.e;
            if (mediaController != null) {
                mediaController.setMute(z);
            }
        }
    }

    public void setSilentTips(String str) {
        rs4 rs4Var = this.f;
        if (rs4Var != null) {
            rs4Var.g(str);
        }
    }

    public void setSurface(Surface surface) {
        this.l.setSurface(surface);
    }

    public void setTitle(String str) {
        MediaController mediaController = this.e;
        if (mediaController != null && this.s) {
            mediaController.setTitle(str);
        }
    }

    public void setVideoPlayerCallback(yr4 yr4Var) {
        this.z = yr4Var;
        MediaController mediaController = this.e;
        if (mediaController != null) {
            mediaController.setToggleScreenListener(yr4Var);
        }
    }

    public void setVideoScalingMode(int i) {
        if (i != 1 && i != 2 && i != 3) {
            Log.e("SwanVideoView", "setVideoScalingMode: param should be VID");
            return;
        }
        if (i == 1) {
            this.u = 0;
        } else if (i == 2) {
            this.u = 1;
        } else {
            this.u = 3;
        }
        vr4 vr4Var = this.v;
        if (vr4Var != null) {
            vr4Var.setAspectRatio(this.u);
        }
    }

    public void setVolume(float f2) {
        MediaPlayer mediaPlayer = this.l;
        if (mediaPlayer != null) {
            mediaPlayer.setVolume(f2, f2);
        }
    }

    public final void r(MediaPlayer mediaPlayer, vr4.b bVar) {
        if (mediaPlayer == null) {
            return;
        }
        if (bVar == null) {
            mediaPlayer.setDisplay(null);
        } else {
            bVar.a(mediaPlayer);
        }
    }

    public boolean A() {
        return this.r;
    }

    public void C() {
        if (w() && this.l.isPlaying()) {
            this.l.pause();
            setCurrentState(4);
        }
        this.b = false;
        yr4 yr4Var = this.z;
        if (yr4Var != null) {
            yr4Var.onPause();
        }
    }

    public final void E() {
        MediaPlayer mediaPlayer = this.l;
        if (mediaPlayer != null) {
            mediaPlayer.reset();
            this.l.setDisplay(null);
            this.l.release();
            this.l = null;
            setCurrentState(0);
        }
        if (this.z != null) {
            this.z = null;
        }
        AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener = this.C;
        if (onAudioFocusChangeListener != null) {
            this.D = false;
            this.B.abandonAudioFocus(onAudioFocusChangeListener);
            this.C = null;
        }
    }

    public final boolean F() {
        if (this.B.requestAudioFocus(this.C, 3, 1) == 1) {
            return true;
        }
        return false;
    }

    public final void G() {
        try {
            this.l.reset();
            this.l.setDataSource(this.n, this.c, this.d);
            this.l.prepareAsync();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public void R() {
        ss4 ss4Var = this.g;
        if (ss4Var != null) {
            ss4Var.l();
        }
    }

    public void U() {
        ss4 ss4Var = this.g;
        if (ss4Var != null) {
            ss4Var.m();
        }
    }

    public void Y() {
        if (!this.D && !F()) {
            c0(MediaTipStateLayer.TipState.ERROR);
            this.D = false;
            return;
        }
        this.D = true;
        X();
    }

    public void Z() {
        MediaPlayer mediaPlayer = this.l;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            E();
            this.b = false;
        }
    }

    public final void a0() {
        if (!this.s) {
            return;
        }
        if (this.e.getVisibility() != 0) {
            this.e.l();
        } else {
            this.e.k();
        }
    }

    public Bitmap getBitmap() {
        vr4 vr4Var = this.v;
        if (vr4Var != null) {
            return vr4Var.getBitmap();
        }
        return null;
    }

    public int getBufferPercentage() {
        if (this.l != null) {
            return this.m;
        }
        return 0;
    }

    public int getCurrentPlayerState() {
        return this.a;
    }

    public String getCurrentPlayingUrl() {
        Uri uri = this.c;
        if (uri != null) {
            return uri.toString();
        }
        return null;
    }

    public int getCurrentPosition() {
        if (w()) {
            return this.l.getCurrentPosition();
        }
        return 0;
    }

    public int getDuration() {
        if (w()) {
            return this.l.getDuration();
        }
        return 0;
    }

    public MediaTipStateLayer.TipState getTipState() {
        return this.j.c();
    }

    public int getVideoHeight() {
        return this.l.getVideoHeight();
    }

    public yr4 getVideoPlayerCallback() {
        return this.z;
    }

    public int getVideoWidth() {
        return this.l.getVideoWidth();
    }

    public final void p() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0931, (ViewGroup) null);
        this.t = inflate;
        addView(inflate);
    }

    public MediaPlayer s() {
        MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.setLooping(this.p);
        mediaPlayer.setWakeMode(getContext(), 10);
        return mediaPlayer;
    }

    public final void t() {
        ss4 ss4Var = this.g;
        if (ss4Var != null) {
            ss4Var.e();
            this.g.d();
        }
    }

    public final void u() {
        setRenderView(new TextureRenderView(getContext()));
    }

    public boolean w() {
        int i;
        if (this.l != null && (i = this.a) != -1 && i != 0 && i != 1) {
            return true;
        }
        return false;
    }

    public boolean x() {
        return this.A;
    }

    public boolean y() {
        return this.q;
    }

    public boolean z() {
        if (w() && this.l.isPlaying()) {
            return true;
        }
        return false;
    }

    public void B() {
        try {
            MediaPlayer s = s();
            this.l = s;
            s.setOnPreparedListener(this.E);
            this.l.setOnCompletionListener(this.F);
            this.l.setOnErrorListener(this.H);
            this.l.setOnBufferingUpdateListener(this.I);
            this.l.setOnSeekCompleteListener(this.J);
            this.l.setOnVideoSizeChangedListener(this.G);
            this.m = 0;
            this.l.setAudioStreamType(3);
            this.l.setScreenOnWhilePlaying(true);
        } catch (IllegalArgumentException unused) {
            setCurrentState(-1);
            this.b = false;
            this.H.onError(this.l, 1, 0);
        }
    }

    public void D() {
        E();
        this.b = false;
        vr4 vr4Var = this.v;
        if (vr4Var != null) {
            vr4Var.release();
        }
        MediaController mediaController = this.e;
        if (mediaController != null) {
            mediaController.setToggleScreenListener(null);
            this.e.i(null);
            this.e = null;
        }
        if (this.h != null) {
            this.h = null;
        }
        ss4 ss4Var = this.g;
        if (ss4Var != null) {
            ss4Var.release();
            this.g = null;
        }
        rs4 rs4Var = this.f;
        if (rs4Var != null) {
            rs4Var.f();
            this.f = null;
        }
        if (this.z != null) {
            this.z = null;
        }
    }

    public void X() {
        if (this.l == null) {
            return;
        }
        int i = this.a;
        if (i != -1 && i != 5) {
            if (w()) {
                yr4 yr4Var = this.z;
                if (yr4Var != null) {
                    if (this.a == 4) {
                        yr4Var.onResume();
                    } else {
                        yr4Var.onStart();
                    }
                }
                this.l.start();
                setCurrentState(3);
            }
        } else {
            if (this.a == 5) {
                this.l.stop();
            }
            G();
            setCacheViewVisibility(true);
            setCurrentState(1);
        }
        this.b = true;
    }

    public void setRenderView(vr4 vr4Var) {
        int i;
        if (this.v != null) {
            MediaPlayer mediaPlayer = this.l;
            if (mediaPlayer != null) {
                mediaPlayer.setDisplay(null);
            }
            View view2 = this.v.getView();
            this.v.a(this.K);
            this.v.release();
            this.v = null;
            this.y.removeView(view2);
        }
        if (vr4Var == null) {
            return;
        }
        this.v = vr4Var;
        vr4Var.setAspectRatio(this.u);
        int i2 = this.w;
        if (i2 > 0 && (i = this.x) > 0) {
            vr4Var.setVideoSize(i2, i);
        }
        View view3 = this.v.getView();
        view3.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
        this.y.addView(view3);
        this.v.b(this.K);
    }

    public final void v(Context context) {
        this.n = context.getApplicationContext();
        this.y = new FrameLayout(context);
        ViewGroup.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.y.setBackgroundColor(-16777216);
        addView(this.y, layoutParams);
        q(context);
        this.h = new ts4(getContext());
        addView(this.h.a(), new FrameLayout.LayoutParams(-1, -1));
        this.e = new MediaController(context);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams2.gravity = 80;
        this.e.setVisibility(8);
        addView(this.e, layoutParams2);
        this.e.i(this);
        this.f = new rs4(getContext());
        addView(this.f.a(), new FrameLayout.LayoutParams(-1, -1));
        ss4 ss4Var = new ss4(getContext());
        this.g = ss4Var;
        ss4Var.b(this);
        addView(this.g.c(), new FrameLayout.LayoutParams(-1, -1));
        this.j = new MediaTipStateLayer(getContext());
        addView(this.j.b(), new FrameLayout.LayoutParams(-1, -1));
        this.j.a(this);
        u();
        p();
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        setCurrentState(0);
        this.B = (AudioManager) this.n.getSystemService("audio");
    }
}
