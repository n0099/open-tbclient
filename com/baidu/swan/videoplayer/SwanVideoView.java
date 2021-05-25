package com.baidu.swan.videoplayer;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.swan.videoplayer.widget.MediaController;
import d.a.l0.v.a;
import java.io.IOException;
import java.util.Map;
/* loaded from: classes3.dex */
public class SwanVideoView extends FrameLayout {
    public MediaPlayer.OnCompletionListener A;
    public MediaPlayer.OnVideoSizeChangedListener B;
    public MediaPlayer.OnErrorListener C;
    public MediaPlayer.OnBufferingUpdateListener D;
    public MediaPlayer.OnSeekCompleteListener E;
    public a.InterfaceC1087a F;

    /* renamed from: e  reason: collision with root package name */
    public int f11872e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f11873f;

    /* renamed from: g  reason: collision with root package name */
    public Uri f11874g;

    /* renamed from: h  reason: collision with root package name */
    public Map<String, String> f11875h;

    /* renamed from: i  reason: collision with root package name */
    public MediaController f11876i;
    public MediaPlayer j;
    public int k;
    public Context l;
    public int m;
    public boolean n;
    public boolean o;
    public boolean p;
    public RelativeLayout q;
    public ProgressBar r;
    public TextView s;
    public int t;
    public d.a.l0.v.a u;
    public int v;
    public int w;
    public FrameLayout x;
    public d.a.l0.v.h.a y;
    public MediaPlayer.OnPreparedListener z;

    /* loaded from: classes3.dex */
    public class a implements MediaPlayer.OnPreparedListener {
        public a() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            SwanVideoView.this.setCurrentState(2);
            SwanVideoView.this.setCacheViewVisibility(false);
            if (SwanVideoView.this.y != null) {
                SwanVideoView.this.y.onPrepared();
            }
            SwanVideoView.this.v = mediaPlayer.getVideoWidth();
            SwanVideoView.this.w = mediaPlayer.getVideoHeight();
            if (SwanVideoView.this.v != 0 && SwanVideoView.this.w != 0 && SwanVideoView.this.u != null) {
                SwanVideoView.this.u.setVideoSize(SwanVideoView.this.v, SwanVideoView.this.w);
            }
            if (SwanVideoView.this.f11873f) {
                SwanVideoView.this.C();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements MediaPlayer.OnCompletionListener {
        public b() {
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            Log.d("SwanVideoView", "onCompletion");
            SwanVideoView.this.setCacheViewVisibility(false);
            SwanVideoView.this.setCurrentState(5);
            SwanVideoView.this.f11873f = false;
            if (SwanVideoView.this.y != null) {
                SwanVideoView.this.y.onEnd();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements MediaPlayer.OnVideoSizeChangedListener {
        public c() {
        }

        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i2, int i3) {
            SwanVideoView.this.v = mediaPlayer.getVideoWidth();
            SwanVideoView.this.w = mediaPlayer.getVideoHeight();
            if (SwanVideoView.this.v == 0 || SwanVideoView.this.w == 0) {
                return;
            }
            if (SwanVideoView.this.u != null) {
                SwanVideoView.this.u.setVideoSize(SwanVideoView.this.v, SwanVideoView.this.w);
            }
            if (SwanVideoView.this.y != null) {
                SwanVideoView.this.y.onVideoSizeChanged(i2, i3);
            }
            SwanVideoView.this.requestLayout();
        }
    }

    /* loaded from: classes3.dex */
    public class d implements MediaPlayer.OnErrorListener {
        public d() {
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
            Log.d("SwanVideoView", "onError: " + i2 + "," + i3);
            SwanVideoView.this.setCurrentState(-1);
            SwanVideoView.this.f11873f = false;
            SwanVideoView.this.setCacheViewVisibility(false);
            if (SwanVideoView.this.y != null) {
                SwanVideoView.this.y.onError(i2, i3, null);
            }
            return SwanVideoView.this.y != null;
        }
    }

    /* loaded from: classes3.dex */
    public class e implements MediaPlayer.OnBufferingUpdateListener {
        public e() {
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i2) {
            Log.d("SwanVideoView", "onBufferingUpdate: percent=" + i2);
            SwanVideoView.this.k = i2;
            if (SwanVideoView.this.y != null) {
                SwanVideoView.this.y.onBufferingUpdate(i2);
            }
            if (SwanVideoView.this.f11876i != null) {
                SwanVideoView.this.f11876i.l((i2 * SwanVideoView.this.getDuration()) / 100);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements MediaPlayer.OnSeekCompleteListener {
        public f() {
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            Log.d("SwanVideoView", "onSeekComplete");
            SwanVideoView.this.setCacheViewVisibility(false);
            if (SwanVideoView.this.y != null) {
                SwanVideoView.this.y.onSeekEnd();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements a.InterfaceC1087a {
        public g() {
        }

        @Override // d.a.l0.v.a.InterfaceC1087a
        public void a(a.b bVar) {
        }

        @Override // d.a.l0.v.a.InterfaceC1087a
        public void b(a.b bVar, int i2, int i3) {
            if (bVar.b() == SwanVideoView.this.u && SwanVideoView.this.j != null) {
                SwanVideoView swanVideoView = SwanVideoView.this;
                swanVideoView.p(swanVideoView.j, bVar);
            }
        }

        @Override // d.a.l0.v.a.InterfaceC1087a
        public void c(a.b bVar, int i2, int i3, int i4) {
        }
    }

    public SwanVideoView(Context context) {
        super(context);
        this.f11872e = 0;
        this.m = -1;
        this.p = true;
        this.t = 0;
        this.z = new a();
        this.A = new b();
        this.B = new c();
        this.C = new d();
        this.D = new e();
        this.E = new f();
        this.F = new g();
        s(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCacheViewVisibility(boolean z) {
        if (z) {
            this.q.setVisibility(0);
        } else {
            this.q.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCurrentState(int i2) {
        if (this.f11872e != i2) {
            this.f11872e = i2;
            MediaController mediaController = this.f11876i;
            if (mediaController != null) {
                mediaController.s();
            }
        }
    }

    public final void A() {
        try {
            this.j.reset();
            this.j.setDataSource(this.l, this.f11874g, this.f11875h);
            this.j.prepareAsync();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public void B(int i2) {
        if (t()) {
            if (i2 >= this.j.getDuration()) {
                i2 = this.j.getDuration() - 1000;
            }
            this.j.seekTo(i2);
            setCacheViewVisibility(true);
        }
    }

    public void C() {
        if (this.j == null) {
            return;
        }
        int i2 = this.f11872e;
        if (i2 != -1 && i2 != 5) {
            if (t()) {
                d.a.l0.v.h.a aVar = this.y;
                if (aVar != null) {
                    if (this.f11872e == 4) {
                        aVar.onResume();
                    } else {
                        aVar.onStart();
                    }
                }
                this.j.start();
                setCurrentState(3);
            }
        } else {
            if (this.f11872e == 5) {
                this.j.stop();
            }
            A();
            setCacheViewVisibility(true);
            setCurrentState(1);
        }
        this.f11873f = true;
    }

    public void D() {
        MediaPlayer mediaPlayer = this.j;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            z();
            this.f11873f = false;
        }
    }

    public final void E() {
        if (this.p) {
            if (this.f11876i.getVisibility() != 0) {
                this.f11876i.i();
            } else {
                this.f11876i.h();
            }
        }
    }

    public Bitmap getBitmap() {
        d.a.l0.v.a aVar = this.u;
        if (aVar != null) {
            return aVar.getBitmap();
        }
        return null;
    }

    public int getBufferPercentage() {
        if (this.j != null) {
            return this.k;
        }
        return 0;
    }

    public int getCurrentPlayerState() {
        return this.f11872e;
    }

    public String getCurrentPlayingUrl() {
        Uri uri = this.f11874g;
        if (uri != null) {
            return uri.toString();
        }
        return null;
    }

    public int getCurrentPosition() {
        if (t()) {
            return this.j.getCurrentPosition();
        }
        return 0;
    }

    public int getDuration() {
        if (t()) {
            return this.j.getDuration();
        }
        return 0;
    }

    public int getVideoHeight() {
        return this.j.getVideoHeight();
    }

    public d.a.l0.v.h.a getVideoPlayerCallback() {
        return this.y;
    }

    public int getVideoWidth() {
        return this.j.getVideoWidth();
    }

    public final void o() {
        this.q = new RelativeLayout(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.q.setVisibility(8);
        addView(this.q, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        ProgressBar progressBar = new ProgressBar(getContext());
        this.r = progressBar;
        progressBar.setId(16908308);
        this.r.setMax(100);
        this.r.setProgress(10);
        this.r.setSecondaryProgress(100);
        this.q.addView(this.r, layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams3.addRule(9);
        layoutParams3.addRule(3, 16908308);
        TextView textView = new TextView(getContext());
        this.s = textView;
        textView.setTextColor(-1);
        this.s.setText(d.a.l0.v.f.laoding);
        this.s.setGravity(1);
        this.q.addView(this.s, layoutParams3);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            E();
        }
        return super.onTouchEvent(motionEvent);
    }

    public final void p(MediaPlayer mediaPlayer, a.b bVar) {
        if (mediaPlayer == null) {
            return;
        }
        if (bVar == null) {
            mediaPlayer.setDisplay(null);
        } else {
            bVar.a(mediaPlayer);
        }
    }

    public MediaPlayer q() {
        MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.setLooping(this.n);
        mediaPlayer.setWakeMode(getContext(), 10);
        return mediaPlayer;
    }

    public final void r() {
        setRenderView(new TextureRenderView(getContext()));
    }

    public final void s(Context context) {
        this.l = context.getApplicationContext();
        this.x = new FrameLayout(context);
        ViewGroup.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.x.setBackgroundColor(-16777216);
        addView(this.x, layoutParams);
        this.f11876i = new MediaController(context);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams2.gravity = 80;
        this.f11876i.setVisibility(8);
        addView(this.f11876i, layoutParams2);
        this.f11876i.f(this);
        r();
        o();
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        setCurrentState(0);
    }

    public void setHeaders(Map<String, String> map) {
        this.f11875h = map;
    }

    public void setInitPlayPosition(int i2) {
        this.m = i2;
        MediaPlayer mediaPlayer = this.j;
        if (mediaPlayer != null) {
            mediaPlayer.seekTo(i2);
            this.m = -1;
        }
    }

    public void setIsLandscape(boolean z) {
        MediaController mediaController = this.f11876i;
        if (mediaController != null) {
            mediaController.m(z);
        }
    }

    public void setLooping(boolean z) {
        this.n = z;
        MediaPlayer mediaPlayer = this.j;
        if (mediaPlayer != null) {
            mediaPlayer.setLooping(z);
        }
    }

    public void setMediaControllerEnabled(boolean z) {
        this.p = z;
    }

    public void setMuted(boolean z) {
        if (this.j != null) {
            setVolume(z ? 0.0f : 1.0f);
            this.o = z;
            MediaController mediaController = this.f11876i;
            if (mediaController == null || !this.p) {
                return;
            }
            mediaController.setMute(z);
        }
    }

    public void setRenderView(d.a.l0.v.a aVar) {
        int i2;
        if (this.u != null) {
            MediaPlayer mediaPlayer = this.j;
            if (mediaPlayer != null) {
                mediaPlayer.setDisplay(null);
            }
            View view = this.u.getView();
            this.u.a(this.F);
            this.u.release();
            this.u = null;
            this.x.removeView(view);
        }
        if (aVar == null) {
            return;
        }
        this.u = aVar;
        aVar.setAspectRatio(this.t);
        int i3 = this.v;
        if (i3 > 0 && (i2 = this.w) > 0) {
            aVar.setVideoSize(i3, i2);
        }
        View view2 = this.u.getView();
        view2.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
        this.x.addView(view2);
        this.u.b(this.F);
    }

    public void setSurface(Surface surface) {
        this.j.setSurface(surface);
    }

    public void setVideoPath(String str) {
        Uri parse = Uri.parse(str);
        this.f11874g = parse;
        if (parse == null) {
            return;
        }
        MediaPlayer mediaPlayer = this.j;
        if (mediaPlayer != null) {
            try {
                mediaPlayer.setDataSource(this.l, parse, this.f11875h);
                this.j.prepareAsync();
                setCacheViewVisibility(true);
                setCurrentState(1);
            } catch (IOException unused) {
                setCurrentState(-1);
                this.f11873f = false;
                this.C.onError(this.j, 1, 0);
            }
        }
        requestLayout();
        invalidate();
    }

    public void setVideoPlayerCallback(d.a.l0.v.h.a aVar) {
        this.y = aVar;
        MediaController mediaController = this.f11876i;
        if (mediaController != null) {
            mediaController.setToggleScreenListener(aVar);
        }
    }

    public void setVideoScalingMode(int i2) {
        if (i2 != 1 && i2 != 2 && i2 != 3) {
            Log.e("SwanVideoView", "setVideoScalingMode: param should be VID");
            return;
        }
        if (i2 == 1) {
            this.t = 0;
        } else if (i2 == 2) {
            this.t = 1;
        } else {
            this.t = 3;
        }
        d.a.l0.v.a aVar = this.u;
        if (aVar != null) {
            aVar.setAspectRatio(this.t);
        }
    }

    public void setVolume(float f2) {
        MediaPlayer mediaPlayer = this.j;
        if (mediaPlayer != null) {
            mediaPlayer.setVolume(f2, f2);
        }
    }

    public final boolean t() {
        int i2;
        return (this.j == null || (i2 = this.f11872e) == -1 || i2 == 0 || i2 == 1) ? false : true;
    }

    public boolean u() {
        return this.o;
    }

    public boolean v() {
        return t() && this.j.isPlaying();
    }

    public void w() {
        try {
            MediaPlayer q = q();
            this.j = q;
            q.setOnPreparedListener(this.z);
            this.j.setOnCompletionListener(this.A);
            this.j.setOnErrorListener(this.C);
            this.j.setOnBufferingUpdateListener(this.D);
            this.j.setOnSeekCompleteListener(this.E);
            this.j.setOnVideoSizeChangedListener(this.B);
            this.k = 0;
            this.j.setAudioStreamType(3);
            this.j.setScreenOnWhilePlaying(true);
        } catch (IllegalArgumentException unused) {
            setCurrentState(-1);
            this.f11873f = false;
            this.C.onError(this.j, 1, 0);
        }
    }

    public void x() {
        if (t() && this.j.isPlaying()) {
            this.j.pause();
            setCurrentState(4);
        }
        this.f11873f = false;
        d.a.l0.v.h.a aVar = this.y;
        if (aVar != null) {
            aVar.onPause();
        }
    }

    public void y() {
        z();
        this.f11873f = false;
        d.a.l0.v.a aVar = this.u;
        if (aVar != null) {
            aVar.release();
        }
        MediaController mediaController = this.f11876i;
        if (mediaController != null) {
            mediaController.setToggleScreenListener(null);
            this.f11876i.f(null);
            this.f11876i = null;
        }
        if (this.y != null) {
            this.y = null;
        }
    }

    public final void z() {
        MediaPlayer mediaPlayer = this.j;
        if (mediaPlayer != null) {
            mediaPlayer.reset();
            this.j.setDisplay(null);
            this.j.release();
            this.j = null;
            setCurrentState(0);
        }
        if (this.y != null) {
            this.y = null;
        }
    }

    public SwanVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11872e = 0;
        this.m = -1;
        this.p = true;
        this.t = 0;
        this.z = new a();
        this.A = new b();
        this.B = new c();
        this.C = new d();
        this.D = new e();
        this.E = new f();
        this.F = new g();
        s(context);
    }

    public SwanVideoView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f11872e = 0;
        this.m = -1;
        this.p = true;
        this.t = 0;
        this.z = new a();
        this.A = new b();
        this.B = new c();
        this.C = new d();
        this.D = new e();
        this.E = new f();
        this.F = new g();
        s(context);
    }
}
