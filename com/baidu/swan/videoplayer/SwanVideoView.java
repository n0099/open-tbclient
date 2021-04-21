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
import d.b.h0.s.a;
import java.io.IOException;
import java.util.Map;
/* loaded from: classes3.dex */
public class SwanVideoView extends FrameLayout {
    public MediaPlayer.OnCompletionListener A;
    public MediaPlayer.OnVideoSizeChangedListener B;
    public MediaPlayer.OnErrorListener C;
    public MediaPlayer.OnBufferingUpdateListener D;
    public MediaPlayer.OnSeekCompleteListener E;
    public a.InterfaceC1063a F;

    /* renamed from: e  reason: collision with root package name */
    public int f12718e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f12719f;

    /* renamed from: g  reason: collision with root package name */
    public Uri f12720g;

    /* renamed from: h  reason: collision with root package name */
    public Map<String, String> f12721h;
    public MediaController i;
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
    public d.b.h0.s.a u;
    public int v;
    public int w;
    public FrameLayout x;
    public d.b.h0.s.h.a y;
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
            if (SwanVideoView.this.f12719f) {
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
            SwanVideoView.this.f12719f = false;
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
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
            SwanVideoView.this.v = mediaPlayer.getVideoWidth();
            SwanVideoView.this.w = mediaPlayer.getVideoHeight();
            if (SwanVideoView.this.v == 0 || SwanVideoView.this.w == 0) {
                return;
            }
            if (SwanVideoView.this.u != null) {
                SwanVideoView.this.u.setVideoSize(SwanVideoView.this.v, SwanVideoView.this.w);
            }
            if (SwanVideoView.this.y != null) {
                SwanVideoView.this.y.onVideoSizeChanged(i, i2);
            }
            SwanVideoView.this.requestLayout();
        }
    }

    /* loaded from: classes3.dex */
    public class d implements MediaPlayer.OnErrorListener {
        public d() {
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            Log.d("SwanVideoView", "onError: " + i + "," + i2);
            SwanVideoView.this.setCurrentState(-1);
            SwanVideoView.this.f12719f = false;
            SwanVideoView.this.setCacheViewVisibility(false);
            if (SwanVideoView.this.y != null) {
                SwanVideoView.this.y.onError(i, i2, null);
            }
            return SwanVideoView.this.y != null;
        }
    }

    /* loaded from: classes3.dex */
    public class e implements MediaPlayer.OnBufferingUpdateListener {
        public e() {
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            Log.d("SwanVideoView", "onBufferingUpdate: percent=" + i);
            SwanVideoView.this.k = i;
            if (SwanVideoView.this.y != null) {
                SwanVideoView.this.y.onBufferingUpdate(i);
            }
            if (SwanVideoView.this.i != null) {
                SwanVideoView.this.i.l((i * SwanVideoView.this.getDuration()) / 100);
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
    public class g implements a.InterfaceC1063a {
        public g() {
        }

        @Override // d.b.h0.s.a.InterfaceC1063a
        public void a(a.b bVar, int i, int i2, int i3) {
        }

        @Override // d.b.h0.s.a.InterfaceC1063a
        public void b(a.b bVar) {
        }

        @Override // d.b.h0.s.a.InterfaceC1063a
        public void c(a.b bVar, int i, int i2) {
            if (bVar.b() == SwanVideoView.this.u && SwanVideoView.this.j != null) {
                SwanVideoView swanVideoView = SwanVideoView.this;
                swanVideoView.p(swanVideoView.j, bVar);
            }
        }
    }

    public SwanVideoView(Context context) {
        super(context);
        this.f12718e = 0;
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
    public void setCurrentState(int i) {
        if (this.f12718e != i) {
            this.f12718e = i;
            MediaController mediaController = this.i;
            if (mediaController != null) {
                mediaController.s();
            }
        }
    }

    public final void A() {
        try {
            this.j.reset();
            this.j.setDataSource(this.l, this.f12720g, this.f12721h);
            this.j.prepareAsync();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public void B(int i) {
        if (t()) {
            if (i >= this.j.getDuration()) {
                i = this.j.getDuration() - 1000;
            }
            this.j.seekTo(i);
            setCacheViewVisibility(true);
        }
    }

    public void C() {
        if (this.j == null) {
            return;
        }
        int i = this.f12718e;
        if (i != -1 && i != 5) {
            if (t()) {
                d.b.h0.s.h.a aVar = this.y;
                if (aVar != null) {
                    if (this.f12718e == 4) {
                        aVar.onResume();
                    } else {
                        aVar.onStart();
                    }
                }
                this.j.start();
                setCurrentState(3);
            }
        } else {
            if (this.f12718e == 5) {
                this.j.stop();
            }
            A();
            setCacheViewVisibility(true);
            setCurrentState(1);
        }
        this.f12719f = true;
    }

    public void D() {
        MediaPlayer mediaPlayer = this.j;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            z();
            this.f12719f = false;
        }
    }

    public final void E() {
        if (this.p) {
            if (this.i.getVisibility() != 0) {
                this.i.i();
            } else {
                this.i.h();
            }
        }
    }

    public Bitmap getBitmap() {
        d.b.h0.s.a aVar = this.u;
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
        return this.f12718e;
    }

    public String getCurrentPlayingUrl() {
        Uri uri = this.f12720g;
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

    public d.b.h0.s.h.a getVideoPlayerCallback() {
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
        this.s.setText(d.b.h0.s.f.laoding);
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
        this.i = new MediaController(context);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams2.gravity = 80;
        this.i.setVisibility(8);
        addView(this.i, layoutParams2);
        this.i.f(this);
        r();
        o();
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        setCurrentState(0);
    }

    public void setHeaders(Map<String, String> map) {
        this.f12721h = map;
    }

    public void setInitPlayPosition(int i) {
        this.m = i;
        MediaPlayer mediaPlayer = this.j;
        if (mediaPlayer != null) {
            mediaPlayer.seekTo(i);
            this.m = -1;
        }
    }

    public void setIsLandscape(boolean z) {
        MediaController mediaController = this.i;
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
            MediaController mediaController = this.i;
            if (mediaController == null || !this.p) {
                return;
            }
            mediaController.setMute(z);
        }
    }

    public void setRenderView(d.b.h0.s.a aVar) {
        int i;
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
        int i2 = this.v;
        if (i2 > 0 && (i = this.w) > 0) {
            aVar.setVideoSize(i2, i);
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
        this.f12720g = parse;
        if (parse == null) {
            return;
        }
        MediaPlayer mediaPlayer = this.j;
        if (mediaPlayer != null) {
            try {
                mediaPlayer.setDataSource(this.l, parse, this.f12721h);
                this.j.prepareAsync();
                setCacheViewVisibility(true);
                setCurrentState(1);
            } catch (IOException unused) {
                setCurrentState(-1);
                this.f12719f = false;
                this.C.onError(this.j, 1, 0);
            }
        }
        requestLayout();
        invalidate();
    }

    public void setVideoPlayerCallback(d.b.h0.s.h.a aVar) {
        this.y = aVar;
        MediaController mediaController = this.i;
        if (mediaController != null) {
            mediaController.setToggleScreenListener(aVar);
        }
    }

    public void setVideoScalingMode(int i) {
        if (i != 1 && i != 2 && i != 3) {
            Log.e("SwanVideoView", "setVideoScalingMode: param should be VID");
            return;
        }
        if (i == 1) {
            this.t = 0;
        } else if (i == 2) {
            this.t = 1;
        } else {
            this.t = 3;
        }
        d.b.h0.s.a aVar = this.u;
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
        int i;
        return (this.j == null || (i = this.f12718e) == -1 || i == 0 || i == 1) ? false : true;
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
            this.f12719f = false;
            this.C.onError(this.j, 1, 0);
        }
    }

    public void x() {
        if (t() && this.j.isPlaying()) {
            this.j.pause();
            setCurrentState(4);
        }
        this.f12719f = false;
        d.b.h0.s.h.a aVar = this.y;
        if (aVar != null) {
            aVar.onPause();
        }
    }

    public void y() {
        z();
        this.f12719f = false;
        d.b.h0.s.a aVar = this.u;
        if (aVar != null) {
            aVar.release();
        }
        MediaController mediaController = this.i;
        if (mediaController != null) {
            mediaController.setToggleScreenListener(null);
            this.i.f(null);
            this.i = null;
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
        this.f12718e = 0;
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

    public SwanVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f12718e = 0;
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
