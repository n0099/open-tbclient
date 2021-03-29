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
import d.b.h0.z0.j;
import d.b.i0.i2.f;
import d.b.i0.i2.n;
/* loaded from: classes.dex */
public class VideoPasterContentView extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public VideoPasterOverlayView f2481e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f2482f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f2483g;

    /* renamed from: h  reason: collision with root package name */
    public TbCyberVideoView f2484h;
    public d.b.i0.i2.f i;
    public i j;
    public boolean k;
    public j l;
    public boolean m;
    public int n;
    public int o;
    public d.b.c.m.e.a p;
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
            if (VideoPasterContentView.this.f2484h == null) {
                return;
            }
            if (!TextUtils.equals(VideoPasterContentView.this.r, "NEWINDEX")) {
                VideoPasterContentView.this.f2484h.setVolume(1.0f, 1.0f);
            } else if (TbSingleton.getInstance().isVideoCardMute()) {
                VideoPasterContentView.this.f2484h.setVolume(0.0f, 0.0f);
            } else {
                VideoPasterContentView.this.f2484h.setVolume(1.0f, 1.0f);
            }
            VideoPasterContentView videoPasterContentView = VideoPasterContentView.this;
            videoPasterContentView.u = videoPasterContentView.f2484h.getDuration();
            if (VideoPasterContentView.this.f2481e != null) {
                VideoPasterContentView.this.f2481e.o(VideoPasterContentView.this.f2484h.getVideoWidth(), VideoPasterContentView.this.f2484h.getVideoHeight(), VideoPasterContentView.this.r);
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
        public boolean onError(int i, int i2, Object obj) {
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
            d.b.b.e.m.e.a().removeCallbacks(VideoPasterContentView.this.v);
        }
    }

    /* loaded from: classes.dex */
    public class e implements f.b {
        public e() {
        }

        @Override // d.b.i0.i2.f.b
        public void a() {
        }
    }

    /* loaded from: classes.dex */
    public class f extends d.b.b.e.l.c<d.b.b.j.d.a> {
        public f() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.b.e.l.c
        public void onLoaded(d.b.b.j.d.a aVar, String str, int i) {
            super.onLoaded((f) aVar, str, i);
            if (aVar == null || aVar.p() == null || VideoPasterContentView.this.f2481e == null) {
                return;
            }
            VideoPasterContentView.this.f2481e.o(aVar.r(), aVar.m(), VideoPasterContentView.this.r);
        }
    }

    /* loaded from: classes.dex */
    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b.b.e.m.e.a().removeCallbacks(VideoPasterContentView.this.v);
            if (VideoPasterContentView.this.m) {
                return;
            }
            boolean z = VideoPasterContentView.this.f2484h.getCurrentPositionSync() == 0 && VideoPasterContentView.this.n == 100;
            if (VideoPasterContentView.this.f2484h.getCurrentPositionSync() > VideoPasterContentView.this.n) {
                VideoPasterContentView.this.o();
            } else if (z) {
                d.b.b.e.m.e.a().postDelayed(VideoPasterContentView.this.v, 20L);
            } else {
                VideoPasterContentView.this.o();
            }
        }
    }

    /* loaded from: classes.dex */
    public class h implements j.b {
        public h() {
        }

        @Override // d.b.h0.z0.j.b
        public void a(long j) {
            VideoPasterContentView.this.u();
        }

        @Override // d.b.h0.z0.j.b
        public void b(long j, long j2) {
            VideoPasterContentView.this.q = (int) (j2 / 1000);
            if (VideoPasterContentView.this.f2481e != null) {
                VideoPasterContentView.this.f2481e.setCountDownNum((int) VideoPasterContentView.this.q);
            }
            if (VideoPasterContentView.this.q == 0) {
                VideoPasterContentView.this.u();
                VideoPasterContentView.this.l.s();
            }
        }
    }

    /* loaded from: classes.dex */
    public interface i {
        void b();

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
        d.b.c.m.e.a aVar = this.p;
        if (aVar == null) {
            return;
        }
        if (aVar.a() == 0) {
            j jVar = this.l;
            if (jVar != null) {
                jVar.p();
            }
        } else if (this.p.a() == 1) {
            this.f2483g.setVisibility(0);
            this.f2484h.setVideoPath(this.p.l);
            this.f2484h.start();
            d.b.i0.i2.f fVar = this.i;
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
            d.b.b.e.m.e.a().removeCallbacks(this.v);
            d.b.b.e.m.e.a().postDelayed(this.v, 20L);
        }
        VideoPasterOverlayView videoPasterOverlayView = this.f2481e;
        if (videoPasterOverlayView != null) {
            videoPasterOverlayView.l();
        }
        this.s = true;
    }

    public void B() {
        TbImageView tbImageView;
        d.b.c.m.e.a aVar = this.p;
        if (aVar == null || aVar.a() != 1 || (tbImageView = this.f2483g) == null) {
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
        d.b.c.m.e.a aVar = this.p;
        if (aVar == null) {
            return;
        }
        if (aVar.a() == 0) {
            j jVar = this.l;
            if (jVar != null) {
                jVar.o();
            }
        } else if (this.p.a() == 1) {
            this.f2483g.setVisibility(0);
            this.f2484h.stopPlayback();
            d.b.i0.i2.f fVar = this.i;
            if (fVar != null) {
                fVar.n();
            }
            j jVar2 = this.l;
            if (jVar2 != null) {
                jVar2.o();
            }
            d.b.b.e.m.e.a().removeCallbacks(this.v);
        }
        VideoPasterOverlayView videoPasterOverlayView = this.f2481e;
        if (videoPasterOverlayView != null) {
            videoPasterOverlayView.m();
        }
        this.s = false;
        this.m = false;
    }

    public void E(boolean z, boolean z2, String str) {
        d.b.c.m.e.a aVar = this.p;
        if (aVar == null || !aVar.d() || this.p.c()) {
            return;
        }
        this.f2481e.n(this.p, z, z2);
        if (this.k) {
            return;
        }
        if (this.p.a() == 0) {
            this.f2481e.setCountDownNum(this.p.j);
            C(this.p.j);
        } else if (this.p.a() == 1) {
            this.f2481e.setCountDownNum(this.p.j);
            C(this.p.j);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.r = str;
        if (this.p.a() == 0) {
            removeAllViews();
            addView(this.f2482f);
            addView(this.f2481e.getRootView(), layoutParams);
            this.f2482f.setScaleType(ImageView.ScaleType.FIT_CENTER);
            d.b.b.e.l.d.h().m(this.p.k, 10, new f(), null);
            this.f2482f.W(this.p.k, 10, false);
        } else if (this.p.a() == 1) {
            y();
            removeAllViews();
            addView(this.f2484h.getView());
            addView(this.f2483g);
            addView(this.f2481e.getRootView(), layoutParams);
            this.f2483g.W(this.p.m, 10, false);
            this.f2484h.setVideoPath(this.p.l);
            this.f2484h.start();
            d.b.b.e.m.e.a().removeCallbacks(this.v);
            d.b.b.e.m.e.a().postDelayed(this.v, 20L);
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
        d.b.c.m.e.a aVar = this.p;
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
        this.f2483g.setVisibility(8);
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
        this.f2481e = new VideoPasterOverlayView(getContext());
        this.f2482f = new TbImageView(getContext());
        this.f2483g = new TbImageView(getContext());
        TbCyberVideoView tbCyberVideoView = new TbCyberVideoView(getContext());
        this.f2484h = tbCyberVideoView;
        tbCyberVideoView.setStageType(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR);
        setBackgroundResource(R.color.black_alpha100);
        this.f2484h.setContinuePlayEnable(true);
        this.f2484h.setOnPreparedListener(new a());
        this.f2484h.setOnCompletionListener(new b());
        this.f2484h.setOnErrorListener(new c());
        this.f2484h.setOnSurfaceDestroyedListener(new d());
        d.b.i0.i2.f fVar = new d.b.i0.i2.f();
        this.i = fVar;
        fVar.l(this.f2484h);
        this.i.i(new e());
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

    public void setData(d.b.c.m.e.a aVar) {
        this.p = aVar;
    }

    public void setOverlayViewCallback(VideoPasterOverlayView.b bVar) {
        VideoPasterOverlayView videoPasterOverlayView = this.f2481e;
        if (videoPasterOverlayView != null) {
            videoPasterOverlayView.setOverlayViewCallback(bVar);
        }
    }

    public boolean t() {
        TbCyberVideoView tbCyberVideoView = this.f2484h;
        return tbCyberVideoView != null && tbCyberVideoView.isPlaying();
    }

    public final void u() {
        this.t = true;
        i iVar = this.j;
        if (iVar != null) {
            iVar.b();
        }
        removeAllViews();
        this.p = null;
        this.q = 0L;
        this.k = false;
        this.s = false;
        this.m = false;
        this.n = 100;
        d.b.b.e.m.e.a().removeCallbacks(this.v);
    }

    public void v() {
        VideoPasterOverlayView videoPasterOverlayView = this.f2481e;
        if (videoPasterOverlayView != null) {
            videoPasterOverlayView.g();
        }
    }

    public void w() {
        VideoPasterOverlayView videoPasterOverlayView = this.f2481e;
        if (videoPasterOverlayView != null) {
            videoPasterOverlayView.h();
        }
        d.b.c.m.e.a aVar = this.p;
        if (aVar != null && aVar.d() && !this.p.c() && this.k && this.p.a() == 1) {
            this.f2483g.setVisibility(0);
            int c2 = n.d().c(this.p.l);
            this.o = c2;
            this.n = (c2 <= 100 || this.u <= c2) ? 100 : 100;
            d.b.b.e.m.e.a().removeCallbacks(this.v);
            d.b.b.e.m.e.a().postDelayed(this.v, 20L);
        }
    }

    public void x() {
        y();
        D();
        this.f2481e.i();
        this.k = false;
        this.p = null;
        this.q = 0L;
        this.m = false;
        this.n = 100;
        d.b.b.e.m.e.a().removeCallbacks(this.v);
    }

    public final void y() {
        d.b.c.m.e.a aVar = this.p;
        if (aVar == null || aVar.a() != 1) {
            return;
        }
        n.d().e(this.p.l);
        TbCyberVideoView tbCyberVideoView = this.f2484h;
        if (tbCyberVideoView != null) {
            tbCyberVideoView.seekTo(0);
        }
    }

    public void z(int i2) {
        VideoPasterOverlayView videoPasterOverlayView = this.f2481e;
        if (videoPasterOverlayView != null) {
            videoPasterOverlayView.k(i2);
        }
    }
}
