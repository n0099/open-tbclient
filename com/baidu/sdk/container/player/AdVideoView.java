package com.baidu.sdk.container.player;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.baidu.mobads.container.widget.player.PlayerEvent;
import com.baidu.sdk.container.player.BaseMediaPlayer;
import d.a.f0.a.i.a;
import d.a.f0.a.k.h;
import java.lang.ref.SoftReference;
/* loaded from: classes2.dex */
public class AdVideoView extends RelativeLayout {
    public boolean A;
    public int B;
    public boolean C;
    public Surface D;
    public d.a.f0.a.i.d E;
    public SurfaceHolder F;
    public d.a.f0.a.i.b G;

    /* renamed from: e  reason: collision with root package name */
    public BaseMediaPlayer f9953e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.f0.a.i.a f9954f;

    /* renamed from: g  reason: collision with root package name */
    public a.InterfaceC0535a f9955g;

    /* renamed from: h  reason: collision with root package name */
    public a.b f9956h;

    /* renamed from: i  reason: collision with root package name */
    public Context f9957i;
    public AdVideoProgressBar j;
    public int k;
    public int l;
    public boolean m;
    public int n;
    public e o;
    public d.a.f0.a.i.c p;
    public View q;
    public boolean r;
    public String s;
    public d t;
    public boolean u;
    public boolean v;
    public boolean w;
    public boolean x;
    public boolean y;
    public int z;

    /* loaded from: classes2.dex */
    public class a implements d.a.f0.a.i.e {
        public a() {
        }

        @Override // d.a.f0.a.i.e
        public void playStateChanged(int i2) {
            AdVideoView.this.k(i2);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements d.a.f0.a.i.d {
        public b() {
        }

        @Override // d.a.f0.a.i.d
        public void surfaceCreated(Surface surface) {
            AdVideoView.this.D = surface;
            AdVideoView.this.v = true;
            AdVideoView.this.w();
        }

        @Override // d.a.f0.a.i.d
        public void surfaceDestroy() {
            if (AdVideoView.this.f9955g != null) {
                AdVideoView.this.f9955g.onDestroyed();
            }
            AdVideoView.this.u = false;
            AdVideoView.this.v = false;
            AdVideoView.this.B();
        }
    }

    /* loaded from: classes2.dex */
    public class c implements d.a.f0.a.i.b {
        public c() {
        }

        @Override // d.a.f0.a.i.b
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            AdVideoView.this.F = surfaceHolder;
            AdVideoView.this.v = true;
            AdVideoView.this.w();
        }

        @Override // d.a.f0.a.i.b
        public void surfaceDestroy() {
            if (AdVideoView.this.f9955g != null) {
                AdVideoView.this.f9955g.onDestroyed();
            }
            AdVideoView.this.u = false;
            AdVideoView.this.v = false;
            AdVideoView.this.B();
        }
    }

    /* loaded from: classes2.dex */
    public class d extends BroadcastReceiver {
        public d() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if ("android.intent.action.SCREEN_OFF".equals(action)) {
                Context context2 = AdVideoView.this.f9957i;
                if (d.a.f0.a.k.c.a(context2, context2.getPackageName())) {
                    return;
                }
                AdVideoView.this.w = true;
                AdVideoView.this.B();
            } else if ("android.intent.action.USER_PRESENT".equals(action)) {
                AdVideoView.this.w = false;
                AdVideoView.this.w();
            }
        }

        public /* synthetic */ d(AdVideoView adVideoView, a aVar) {
            this();
        }
    }

    /* loaded from: classes2.dex */
    public static class e implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public SoftReference<AdVideoView> f9961e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f9962f = false;

        public e(AdVideoView adVideoView) {
            this.f9961e = new SoftReference<>(adVideoView);
        }

        public void a(boolean z) {
            this.f9962f = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            AdVideoView adVideoView;
            SoftReference<AdVideoView> softReference = this.f9961e;
            if (softReference == null || (adVideoView = softReference.get()) == null) {
                return;
            }
            int currentPosition = adVideoView.getCurrentPosition();
            int duration = adVideoView.getDuration();
            if (adVideoView.j != null && duration > 0) {
                adVideoView.j.setProgress(currentPosition / duration);
            }
            if (this.f9962f) {
                adVideoView.postDelayed(this, 200L);
            }
        }
    }

    public AdVideoView(Context context) {
        super(context);
        this.k = -1;
        this.l = -16777216;
        this.m = false;
        this.n = 4;
        this.s = "";
        this.v = false;
        this.w = false;
        this.x = false;
        this.A = false;
        this.B = 1;
        this.C = false;
        this.E = new b();
        this.G = new c();
        this.f9957i = context;
        m();
    }

    public void A(String str) {
        this.z = 0;
        this.s = str;
        this.u = true;
        this.A = true;
        w();
    }

    public void B() {
        if (this.f9953e != null) {
            x();
            this.y = true;
            this.x = false;
            this.f9953e.m(null);
            this.f9953e.t();
            this.f9953e.j();
            this.f9953e.i();
            this.f9953e = null;
            e eVar = this.o;
            if (eVar != null) {
                eVar.a(false);
            }
        }
    }

    public final void C() {
        d dVar;
        Context context = this.f9957i;
        if (context == null || (dVar = this.t) == null) {
            return;
        }
        try {
            context.unregisterReceiver(dVar);
            this.t = null;
        } catch (Throwable unused) {
            this.t = null;
        }
    }

    public int getCurrentPosition() {
        BaseMediaPlayer baseMediaPlayer = this.f9953e;
        if (baseMediaPlayer != null) {
            return baseMediaPlayer.a();
        }
        return 0;
    }

    public int getDuration() {
        BaseMediaPlayer baseMediaPlayer = this.f9953e;
        if (baseMediaPlayer != null) {
            return baseMediaPlayer.b();
        }
        return 0;
    }

    public int getLastPosition() {
        return this.z;
    }

    public final void j() {
        removeAllViews();
        this.A = false;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        setBackgroundColor(Color.parseColor("#000000"));
        addView((View) this.p, layoutParams);
    }

    public final void k(int i2) {
        switch (i2) {
            case 256:
                this.z = 0;
                this.A = false;
                l();
                d.a.f0.a.i.a aVar = this.f9954f;
                if (aVar != null) {
                    aVar.playCompletion();
                    return;
                }
                return;
            case 257:
                this.A = false;
                this.z = 0;
                u();
                return;
            case 258:
                a.b bVar = this.f9956h;
                if (bVar != null) {
                    bVar.onPrepared();
                }
                int i3 = this.z;
                if (i3 > 0) {
                    this.f9953e.k(i3);
                }
                setVideoMute(this.r);
                d.a.f0.a.i.c cVar = this.p;
                if (cVar != null) {
                    cVar.onVideoSizeChanged(this.f9953e.d(), this.f9953e.c());
                }
                AdVideoProgressBar adVideoProgressBar = this.j;
                if (adVideoProgressBar != null) {
                    adVideoProgressBar.setProgress(this.z / getDuration());
                    e eVar = this.o;
                    if (eVar != null) {
                        removeCallbacks(eVar);
                        this.o.a(true);
                        postDelayed(this.o, 200L);
                    }
                }
                if (this.u && h.e(this)) {
                    t();
                    return;
                }
                return;
            case 259:
            default:
                return;
            case 260:
                this.A = true;
                l();
                d.a.f0.a.i.a aVar2 = this.f9954f;
                if (aVar2 != null) {
                    aVar2.renderingStart();
                    return;
                }
                return;
            case PlayerEvent.PLAY_LOADING_START /* 261 */:
                z();
                return;
            case PlayerEvent.PLAY_LOADING_END /* 262 */:
                l();
                return;
        }
    }

    public final void l() {
        View view = this.q;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    public final void m() {
    }

    public void n() {
        o();
        q(false);
        j();
        p();
    }

    public final void o() {
        if (this.f9953e == null) {
            this.y = false;
            BaseMediaPlayer baseMediaPlayer = new BaseMediaPlayer(this.f9957i);
            this.f9953e = baseMediaPlayer;
            baseMediaPlayer.m(new a());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        v();
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        C();
        B();
    }

    public final void p() {
        if (this.m) {
            AdVideoProgressBar adVideoProgressBar = new AdVideoProgressBar(this.f9957i);
            this.j = adVideoProgressBar;
            adVideoProgressBar.setProgressColor(this.k);
            this.j.setProgressBackgroundColor(this.l);
            this.j.setProgressHeight(this.n);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.n);
            layoutParams.addRule(12);
            addView(this.j, layoutParams);
            this.j.setProgress(0.0f);
            this.j.setVisibility(4);
            this.o = new e(this);
            return;
        }
        AdVideoProgressBar adVideoProgressBar2 = this.j;
        if (adVideoProgressBar2 != null) {
            adVideoProgressBar2.setVisibility(8);
        }
    }

    public final void q(boolean z) {
        if (z) {
            this.C = true;
            this.p = new BaseSurfaceView(this.f9957i, this.G);
        } else if (Build.VERSION.SDK_INT >= 14) {
            this.C = false;
            this.p = new BaseTextureView(this.f9957i, this.E);
        } else {
            this.C = true;
            this.p = new BaseSurfaceView(this.f9957i, this.G);
        }
        this.p.setDisplayMode(this.B);
    }

    public void r() {
        this.u = false;
        BaseMediaPlayer baseMediaPlayer = this.f9953e;
        if (baseMediaPlayer == null || baseMediaPlayer.f9967i == BaseMediaPlayer.State.PLAYBACKCOMPLETED) {
            return;
        }
        baseMediaPlayer.g();
        d.a.f0.a.i.a aVar = this.f9954f;
        if (aVar != null) {
            aVar.playPause();
        }
        x();
    }

    public void s() {
        this.u = true;
        w();
    }

    public void setAdVideoViewListener(d.a.f0.a.i.a aVar) {
        this.f9954f = aVar;
    }

    public void setDestroyedListener(a.InterfaceC0535a interfaceC0535a) {
        this.f9955g = interfaceC0535a;
    }

    public void setDisplayMode(int i2) {
        this.B = i2;
    }

    public void setPreparedListener(a.b bVar) {
        this.f9956h = bVar;
    }

    public void setProgressBar(boolean z, int i2, int i3, int i4) {
        this.m = z;
        this.l = i2;
        this.k = i3;
        this.n = h.a(getContext(), i4);
    }

    public void setProgressBarVisibility(int i2) {
        if (this.m) {
            this.j.setVisibility(i2);
        }
    }

    public void setVideoMute(boolean z) {
        this.r = z;
        if (z) {
            y(0.0f, 0.0f);
        } else {
            y(1.0f, 1.0f);
        }
    }

    public void setVideoUrl(String str) {
        this.s = str;
        if (TextUtils.isEmpty(str)) {
            u();
            return;
        }
        BaseMediaPlayer baseMediaPlayer = this.f9953e;
        if (baseMediaPlayer != null) {
            baseMediaPlayer.p(str);
        }
    }

    public final void t() {
        BaseMediaPlayer baseMediaPlayer = this.f9953e;
        if (baseMediaPlayer != null) {
            if (this.C) {
                baseMediaPlayer.l(this.F);
                this.f9953e.n(true);
            } else {
                baseMediaPlayer.o(this.D);
                this.f9953e.r(this.f9957i, 10);
            }
            this.f9953e.s();
        }
    }

    public final void u() {
        d.a.f0.a.i.a aVar = this.f9954f;
        if (aVar != null) {
            aVar.playFailure();
        }
        l();
        B();
    }

    public final void v() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        if (this.f9957i == null || this.t != null) {
            return;
        }
        d dVar = new d(this, null);
        this.t = dVar;
        this.f9957i.registerReceiver(dVar, intentFilter);
    }

    public final void w() {
        if (!TextUtils.isEmpty(this.s) && this.u && this.v) {
            Context context = this.f9957i;
            if ((d.a.f0.a.k.c.a(context, context.getPackageName()) || !this.w) && this.A) {
                d.a.f0.a.i.a aVar = this.f9954f;
                if (aVar != null) {
                    aVar.playResume();
                }
                if (!this.y) {
                    t();
                } else if (this.x) {
                } else {
                    B();
                    this.x = true;
                    o();
                    setVideoUrl(this.s);
                    t();
                }
            }
        }
    }

    public final void x() {
        BaseMediaPlayer baseMediaPlayer = this.f9953e;
        if (baseMediaPlayer == null) {
            return;
        }
        this.z = baseMediaPlayer.a();
    }

    public final void y(float f2, float f3) {
        BaseMediaPlayer baseMediaPlayer = this.f9953e;
        if (baseMediaPlayer != null) {
            baseMediaPlayer.q(f2, f3);
        }
    }

    public final void z() {
        View view = this.q;
        if (view == null) {
            this.q = new ProgressBar(this.f9957i);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            this.q.setLayoutParams(layoutParams);
            addView(this.q);
            return;
        }
        view.setVisibility(0);
    }

    public AdVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.k = -1;
        this.l = -16777216;
        this.m = false;
        this.n = 4;
        this.s = "";
        this.v = false;
        this.w = false;
        this.x = false;
        this.A = false;
        this.B = 1;
        this.C = false;
        this.E = new b();
        this.G = new c();
        this.f9957i = context;
        m();
    }

    public AdVideoView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.k = -1;
        this.l = -16777216;
        this.m = false;
        this.n = 4;
        this.s = "";
        this.v = false;
        this.w = false;
        this.x = false;
        this.A = false;
        this.B = 1;
        this.C = false;
        this.E = new b();
        this.G = new c();
        this.f9957i = context;
        m();
    }
}
