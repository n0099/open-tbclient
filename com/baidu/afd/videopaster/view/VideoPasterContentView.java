package com.baidu.afd.videopaster.view;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.afd.videopaster.view.VideoPasterOverlayView;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
import com.tencent.connect.common.Constants;
import d.a.m0.z0.j;
import d.a.n0.k2.f;
import d.a.n0.k2.n;
/* loaded from: classes.dex */
public class VideoPasterContentView extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public VideoPasterOverlayView f2535e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f2536f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f2537g;

    /* renamed from: h  reason: collision with root package name */
    public TbCyberVideoView f2538h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.n0.k2.f f2539i;
    public i j;
    public boolean k;
    public j l;
    public boolean m;
    public int n;
    public int o;
    public d.a.d.m.e.a p;
    public long q;
    public String r;
    public boolean s;
    public boolean t;
    public int u;
    public Runnable v;

    /* loaded from: classes.dex */
    public class a implements CyberPlayerManager.OnPreparedListener {
        public a() {
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            if (VideoPasterContentView.this.f2538h == null) {
                return;
            }
            if (!TextUtils.equals(VideoPasterContentView.this.r, "NEWINDEX")) {
                VideoPasterContentView.this.f2538h.setVolume(1.0f, 1.0f);
            } else if (TbSingleton.getInstance().isVideoCardMute()) {
                VideoPasterContentView.this.f2538h.setVolume(0.0f, 0.0f);
            } else {
                VideoPasterContentView.this.f2538h.setVolume(1.0f, 1.0f);
            }
            VideoPasterContentView videoPasterContentView = VideoPasterContentView.this;
            videoPasterContentView.u = videoPasterContentView.f2538h.getDuration();
            if (VideoPasterContentView.this.f2535e != null) {
                VideoPasterContentView.this.f2535e.o(VideoPasterContentView.this.f2538h.getVideoWidth(), VideoPasterContentView.this.f2538h.getVideoHeight(), VideoPasterContentView.this.r);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements CyberPlayerManager.OnCompletionListener {
        public b() {
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            VideoPasterContentView.this.u();
        }
    }

    /* loaded from: classes.dex */
    public class c implements CyberPlayerManager.OnErrorListener {
        public c() {
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i2, int i3, Object obj) {
            VideoPasterContentView.this.u();
            return false;
        }
    }

    /* loaded from: classes.dex */
    public class d implements TbCyberVideoView.g {
        public d() {
        }

        @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.g
        public void onSurfaceDestroyed() {
            VideoPasterContentView.this.m = false;
            VideoPasterContentView.this.n = 100;
            d.a.c.e.m.e.a().removeCallbacks(VideoPasterContentView.this.v);
        }
    }

    /* loaded from: classes.dex */
    public class e implements f.b {
        public e() {
        }

        @Override // d.a.n0.k2.f.b
        public void a() {
        }
    }

    /* loaded from: classes.dex */
    public class f extends d.a.c.e.l.c<d.a.c.k.d.a> {
        public f() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.l.c
        public void onLoaded(d.a.c.k.d.a aVar, String str, int i2) {
            super.onLoaded((f) aVar, str, i2);
            if (aVar == null || aVar.p() == null || VideoPasterContentView.this.f2535e == null) {
                return;
            }
            VideoPasterContentView.this.f2535e.o(aVar.r(), aVar.m(), VideoPasterContentView.this.r);
        }
    }

    /* loaded from: classes.dex */
    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.c.e.m.e.a().removeCallbacks(VideoPasterContentView.this.v);
            if (VideoPasterContentView.this.m) {
                return;
            }
            boolean z = VideoPasterContentView.this.f2538h.getCurrentPositionSync() == 0 && VideoPasterContentView.this.n == 100;
            if (VideoPasterContentView.this.f2538h.getCurrentPositionSync() > VideoPasterContentView.this.n) {
                VideoPasterContentView.this.o();
            } else if (z) {
                d.a.c.e.m.e.a().postDelayed(VideoPasterContentView.this.v, 20L);
            } else {
                VideoPasterContentView.this.o();
            }
        }
    }

    /* loaded from: classes.dex */
    public class h implements j.b {
        public h() {
        }

        @Override // d.a.m0.z0.j.b
        public void a(long j, long j2) {
            VideoPasterContentView.this.q = (int) (j2 / 1000);
            if (VideoPasterContentView.this.f2535e != null) {
                VideoPasterContentView.this.f2535e.setCountDownNum((int) VideoPasterContentView.this.q);
            }
            if (VideoPasterContentView.this.q == 0) {
                VideoPasterContentView.this.u();
                VideoPasterContentView.this.l.s();
            }
        }

        @Override // d.a.m0.z0.j.b
        public void b(long j) {
            VideoPasterContentView.this.u();
        }
    }

    /* loaded from: classes.dex */
    public interface i {
        void a();

        void onDetachedFromWindow();
    }

    public VideoPasterContentView(Context context) {
        super(context);
        this.k = false;
        this.m = false;
        this.n = 100;
        this.o = 0;
        this.s = false;
        this.t = false;
        this.u = 0;
        this.v = new g();
        p();
    }

    public void A() {
        d.a.d.m.e.a aVar = this.p;
        if (aVar == null) {
            return;
        }
        if (aVar.a() == 0) {
            j jVar = this.l;
            if (jVar != null) {
                jVar.p();
            }
        } else if (this.p.a() == 1) {
            this.f2537g.setVisibility(0);
            this.f2538h.setVideoPath(this.p.l);
            this.f2538h.start();
            d.a.n0.k2.f fVar = this.f2539i;
            if (fVar != null) {
                fVar.m();
            }
            j jVar2 = this.l;
            if (jVar2 != null) {
                jVar2.p();
            }
            int i2 = 100;
            if (this.k) {
                int c2 = n.d().c(this.p.l);
                this.o = c2;
                if (c2 > 100 && this.u > c2) {
                    i2 = c2;
                }
                this.n = i2;
            } else {
                this.n = 100;
            }
            d.a.c.e.m.e.a().removeCallbacks(this.v);
            d.a.c.e.m.e.a().postDelayed(this.v, 20L);
        }
        VideoPasterOverlayView videoPasterOverlayView = this.f2535e;
        if (videoPasterOverlayView != null) {
            videoPasterOverlayView.l();
        }
        this.s = true;
    }

    public void B() {
        TbImageView tbImageView;
        d.a.d.m.e.a aVar = this.p;
        if (aVar == null || aVar.a() != 1 || (tbImageView = this.f2537g) == null) {
            return;
        }
        tbImageView.setVisibility(0);
    }

    public final void C(int i2) {
        j jVar = this.l;
        if (jVar != null) {
            jVar.s();
            this.l.q(null);
        }
        j jVar2 = new j(i2 * 1000, 1000L);
        this.l = jVar2;
        jVar2.q(new h());
        this.l.r();
        this.t = false;
    }

    public void D() {
        d.a.d.m.e.a aVar = this.p;
        if (aVar == null) {
            return;
        }
        if (aVar.a() == 0) {
            j jVar = this.l;
            if (jVar != null) {
                jVar.o();
            }
        } else if (this.p.a() == 1) {
            this.f2537g.setVisibility(0);
            this.f2538h.stopPlayback();
            d.a.n0.k2.f fVar = this.f2539i;
            if (fVar != null) {
                fVar.n();
            }
            j jVar2 = this.l;
            if (jVar2 != null) {
                jVar2.o();
            }
            d.a.c.e.m.e.a().removeCallbacks(this.v);
        }
        VideoPasterOverlayView videoPasterOverlayView = this.f2535e;
        if (videoPasterOverlayView != null) {
            videoPasterOverlayView.m();
        }
        this.s = false;
        this.m = false;
    }

    public void E(boolean z, boolean z2, String str) {
        d.a.d.m.e.a aVar = this.p;
        if (aVar == null || !aVar.d() || this.p.c()) {
            return;
        }
        this.f2535e.n(this.p, z, z2);
        if (this.k) {
            return;
        }
        if (this.p.a() == 0) {
            this.f2535e.setCountDownNum(this.p.j);
            C(this.p.j);
        } else if (this.p.a() == 1) {
            this.f2535e.setCountDownNum(this.p.j);
            C(this.p.j);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.r = str;
        if (this.p.a() == 0) {
            removeAllViews();
            addView(this.f2536f);
            addView(this.f2535e.getRootView(), layoutParams);
            this.f2536f.setScaleType(ImageView.ScaleType.FIT_CENTER);
            d.a.c.e.l.d.h().m(this.p.k, 10, new f(), null);
            this.f2536f.U(this.p.k, 10, false);
        } else if (this.p.a() == 1) {
            y();
            removeAllViews();
            addView(this.f2538h.getView());
            addView(this.f2537g);
            addView(this.f2535e.getRootView(), layoutParams);
            this.f2537g.U(this.p.m, 10, false);
            this.f2538h.setVideoPath(this.p.l);
            this.f2538h.start();
            d.a.c.e.m.e.a().removeCallbacks(this.v);
            d.a.c.e.m.e.a().postDelayed(this.v, 20L);
        }
        this.k = true;
        this.s = true;
    }

    public int getCurDuration() {
        j jVar;
        if (this.p == null || (jVar = this.l) == null) {
            return 0;
        }
        return ((int) jVar.n()) / 1000;
    }

    public int getTotalDuration() {
        d.a.d.m.e.a aVar = this.p;
        if (aVar == null) {
            return -1;
        }
        return aVar.j;
    }

    public final void o() {
        if (this.m) {
            return;
        }
        this.m = true;
        this.f2537g.setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        i iVar = this.j;
        if (iVar != null) {
            iVar.onDetachedFromWindow();
        }
    }

    public final void p() {
        this.f2535e = new VideoPasterOverlayView(getContext());
        this.f2536f = new TbImageView(getContext());
        this.f2537g = new TbImageView(getContext());
        TbCyberVideoView tbCyberVideoView = new TbCyberVideoView(getContext());
        this.f2538h = tbCyberVideoView;
        tbCyberVideoView.setStageType(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR);
        setBackgroundResource(R.color.black_alpha100);
        this.f2538h.setContinuePlayEnable(true);
        this.f2538h.setOnPreparedListener(new a());
        this.f2538h.setOnCompletionListener(new b());
        this.f2538h.setOnErrorListener(new c());
        this.f2538h.setOnSurfaceDestroyedListener(new d());
        d.a.n0.k2.f fVar = new d.a.n0.k2.f();
        this.f2539i = fVar;
        fVar.l(this.f2538h);
        this.f2539i.i(new e());
        setBackgroundColor(-16777216);
    }

    public boolean q() {
        return this.k;
    }

    public boolean r() {
        return this.s;
    }

    public boolean s() {
        return this.t;
    }

    public void setContentViewCallback(i iVar) {
        this.j = iVar;
    }

    public void setData(d.a.d.m.e.a aVar) {
        this.p = aVar;
    }

    public void setOverlayViewCallback(VideoPasterOverlayView.b bVar) {
        VideoPasterOverlayView videoPasterOverlayView = this.f2535e;
        if (videoPasterOverlayView != null) {
            videoPasterOverlayView.setOverlayViewCallback(bVar);
        }
    }

    public boolean t() {
        TbCyberVideoView tbCyberVideoView = this.f2538h;
        return tbCyberVideoView != null && tbCyberVideoView.isPlaying();
    }

    public final void u() {
        this.t = true;
        i iVar = this.j;
        if (iVar != null) {
            iVar.a();
        }
        removeAllViews();
        this.p = null;
        this.q = 0L;
        this.k = false;
        this.s = false;
        this.m = false;
        this.n = 100;
        d.a.c.e.m.e.a().removeCallbacks(this.v);
    }

    public void v() {
        VideoPasterOverlayView videoPasterOverlayView = this.f2535e;
        if (videoPasterOverlayView != null) {
            videoPasterOverlayView.g();
        }
    }

    public void w() {
        VideoPasterOverlayView videoPasterOverlayView = this.f2535e;
        if (videoPasterOverlayView != null) {
            videoPasterOverlayView.h();
        }
        d.a.d.m.e.a aVar = this.p;
        if (aVar != null && aVar.d() && !this.p.c() && this.k && this.p.a() == 1) {
            this.f2537g.setVisibility(0);
            int c2 = n.d().c(this.p.l);
            this.o = c2;
            this.n = (c2 <= 100 || this.u <= c2) ? 100 : 100;
            d.a.c.e.m.e.a().removeCallbacks(this.v);
            d.a.c.e.m.e.a().postDelayed(this.v, 20L);
        }
    }

    public void x() {
        y();
        D();
        this.f2535e.i();
        this.k = false;
        this.p = null;
        this.q = 0L;
        this.m = false;
        this.n = 100;
        d.a.c.e.m.e.a().removeCallbacks(this.v);
    }

    public final void y() {
        d.a.d.m.e.a aVar = this.p;
        if (aVar == null || aVar.a() != 1) {
            return;
        }
        n.d().e(this.p.l);
        TbCyberVideoView tbCyberVideoView = this.f2538h;
        if (tbCyberVideoView != null) {
            tbCyberVideoView.seekTo(0);
        }
    }

    public void z(int i2) {
        VideoPasterOverlayView videoPasterOverlayView = this.f2535e;
        if (videoPasterOverlayView != null) {
            videoPasterOverlayView.k(i2);
        }
    }
}
