package com.baidu.nadcore.widget.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.widget.uitemplate.NadRewardCountDownView;
import com.baidu.nadcore.widget.uitemplate.NadRewardVolumeView;
import com.baidu.tieba.R;
import com.baidu.tieba.fr0;
import com.baidu.tieba.hr0;
import com.baidu.tieba.nd1;
import com.baidu.tieba.o11;
import com.baidu.tieba.pt0;
import com.baidu.tieba.qt0;
import com.baidu.tieba.tt0;
import com.baidu.tieba.z01;
/* loaded from: classes2.dex */
public abstract class NadRewardVideoView extends NadRewardBaseView {
    public final tt0 q;
    public pt0 r;
    public ViewGroup s;
    public NadRewardVolumeView t;

    public abstract void G();

    public abstract void H();

    @Override // com.baidu.nadcore.widget.view.NadRewardBaseView
    public void m(LayoutInflater layoutInflater, hr0 hr0Var) {
    }

    @Override // com.baidu.nadcore.widget.view.NadRewardBaseView
    public void s(AdBaseModel adBaseModel) {
    }

    /* loaded from: classes2.dex */
    public class a implements NadRewardVolumeView.b {
        public a() {
        }

        @Override // com.baidu.nadcore.widget.uitemplate.NadRewardVolumeView.b
        public void a(boolean z) {
            pt0 pt0Var = NadRewardVideoView.this.r;
            if (pt0Var != null) {
                pt0Var.mute(z);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b extends tt0 {
        public b() {
        }

        @Override // com.baidu.tieba.tt0, com.baidu.tieba.mt0
        public void a(int i) {
            boolean z;
            if (NadRewardVideoView.this.t != null) {
                NadRewardVolumeView nadRewardVolumeView = NadRewardVideoView.this.t;
                if (o11.c(NadRewardVideoView.this.getContext()) <= 0) {
                    z = true;
                } else {
                    z = false;
                }
                nadRewardVolumeView.setVolumeState(z);
            }
        }

        @Override // com.baidu.tieba.tt0, com.baidu.tieba.mt0
        public void onEnd(int i) {
            if (NadRewardVideoView.this.b != null && (NadRewardVideoView.this.getTag() instanceof AdBaseModel)) {
                NadRewardVideoView.this.b.f((AdBaseModel) NadRewardVideoView.this.getTag());
            }
            NadRewardVideoView nadRewardVideoView = NadRewardVideoView.this;
            if (nadRewardVideoView.o != null && (nadRewardVideoView.getTag() instanceof AdBaseModel)) {
                NadRewardVideoView nadRewardVideoView2 = NadRewardVideoView.this;
                nadRewardVideoView2.o.f((AdBaseModel) nadRewardVideoView2.getTag());
            }
            if (NadRewardVideoView.this.t != null) {
                NadRewardVideoView.this.t.setVisibility(8);
            }
            NadRewardVideoView.this.H();
            NadRewardCountDownView nadRewardCountDownView = NadRewardVideoView.this.n;
            if (nadRewardCountDownView != null) {
                nadRewardCountDownView.u();
                NadRewardVideoView.this.n.bringToFront();
            }
            View findViewById = NadRewardVideoView.this.findViewById(R.id.nad_base_delete_id);
            if (findViewById != null) {
                findViewById.bringToFront();
            }
        }

        @Override // com.baidu.tieba.tt0, com.baidu.tieba.mt0
        public void onError(int i, int i2, String str) {
            if (NadRewardVideoView.this.b != null && (NadRewardVideoView.this.getTag() instanceof AdBaseModel)) {
                NadRewardVideoView.this.b.e((AdBaseModel) NadRewardVideoView.this.getTag(), str);
            }
            NadRewardVideoView nadRewardVideoView = NadRewardVideoView.this;
            if (nadRewardVideoView.o != null && (nadRewardVideoView.getTag() instanceof AdBaseModel)) {
                NadRewardVideoView nadRewardVideoView2 = NadRewardVideoView.this;
                nadRewardVideoView2.o.e((AdBaseModel) nadRewardVideoView2.getTag(), str);
            }
            if (NadRewardVideoView.this.t != null) {
                NadRewardVideoView.this.t.setVisibility(8);
            }
        }

        @Override // com.baidu.tieba.tt0, com.baidu.tieba.mt0
        public void onPause() {
            if (NadRewardVideoView.this.b != null && (NadRewardVideoView.this.getTag() instanceof AdBaseModel)) {
                NadRewardVideoView.this.b.c((AdBaseModel) NadRewardVideoView.this.getTag());
            }
            NadRewardVideoView nadRewardVideoView = NadRewardVideoView.this;
            if (nadRewardVideoView.o != null && (nadRewardVideoView.getTag() instanceof AdBaseModel)) {
                NadRewardVideoView nadRewardVideoView2 = NadRewardVideoView.this;
                nadRewardVideoView2.o.c((AdBaseModel) nadRewardVideoView2.getTag());
            }
        }

        @Override // com.baidu.tieba.tt0, com.baidu.tieba.mt0
        public void onPrepared() {
            if (NadRewardVideoView.this.b != null && (NadRewardVideoView.this.getTag() instanceof AdBaseModel)) {
                NadRewardVideoView.this.b.d((AdBaseModel) NadRewardVideoView.this.getTag());
            }
            NadRewardVideoView nadRewardVideoView = NadRewardVideoView.this;
            if (nadRewardVideoView.o != null && (nadRewardVideoView.getTag() instanceof AdBaseModel)) {
                NadRewardVideoView nadRewardVideoView2 = NadRewardVideoView.this;
                nadRewardVideoView2.o.d((AdBaseModel) nadRewardVideoView2.getTag());
            }
        }

        @Override // com.baidu.tieba.tt0, com.baidu.tieba.mt0
        public void onResume() {
            if (NadRewardVideoView.this.b != null && (NadRewardVideoView.this.getTag() instanceof AdBaseModel)) {
                NadRewardVideoView.this.b.a((AdBaseModel) NadRewardVideoView.this.getTag());
            }
            NadRewardVideoView nadRewardVideoView = NadRewardVideoView.this;
            if (nadRewardVideoView.o != null && (nadRewardVideoView.getTag() instanceof AdBaseModel)) {
                NadRewardVideoView nadRewardVideoView2 = NadRewardVideoView.this;
                nadRewardVideoView2.o.a((AdBaseModel) nadRewardVideoView2.getTag());
            }
        }

        @Override // com.baidu.tieba.tt0, com.baidu.tieba.mt0
        public void onStart() {
            if (NadRewardVideoView.this.b != null && (NadRewardVideoView.this.getTag() instanceof AdBaseModel)) {
                NadRewardVideoView.this.b.b((AdBaseModel) NadRewardVideoView.this.getTag());
            }
            NadRewardVideoView nadRewardVideoView = NadRewardVideoView.this;
            if (nadRewardVideoView.o != null && (nadRewardVideoView.getTag() instanceof AdBaseModel)) {
                NadRewardVideoView nadRewardVideoView2 = NadRewardVideoView.this;
                nadRewardVideoView2.o.b((AdBaseModel) nadRewardVideoView2.getTag());
            }
            if (NadRewardVideoView.this.t != null && (NadRewardVideoView.this.getTag() instanceof AdBaseModel)) {
                AdBaseModel adBaseModel = (AdBaseModel) NadRewardVideoView.this.getTag();
                if (adBaseModel.p != null) {
                    NadRewardVideoView.this.t.setVolumeState(adBaseModel.p.h);
                }
                if (o11.c(NadRewardVideoView.this.getContext()) <= 0) {
                    NadRewardVideoView.this.t.setVolumeState(true);
                }
                NadRewardVideoView.this.t.setVisibility(0);
            }
            NadRewardVideoView.this.G();
        }
    }

    /* loaded from: classes2.dex */
    public class c implements NadRewardCountDownView.g {
        public final /* synthetic */ AdBaseModel a;

        @Override // com.baidu.nadcore.widget.uitemplate.NadRewardCountDownView.g
        public void d() {
        }

        public c(AdBaseModel adBaseModel) {
            this.a = adBaseModel;
        }

        @Override // com.baidu.nadcore.widget.uitemplate.NadRewardCountDownView.g
        public void a() {
            pt0 pt0Var = NadRewardVideoView.this.r;
            if (pt0Var != null) {
                pt0Var.resume();
            }
        }

        @Override // com.baidu.nadcore.widget.uitemplate.NadRewardCountDownView.g
        public void b() {
            pt0 pt0Var = NadRewardVideoView.this.r;
            if (pt0Var != null) {
                pt0Var.pause();
            }
        }

        @Override // com.baidu.nadcore.widget.uitemplate.NadRewardCountDownView.g
        public void c() {
            nd1 nd1Var = NadRewardVideoView.this.o;
            if (nd1Var != null) {
                nd1Var.h(this.a);
            }
            NadRewardVideoView.this.j();
        }

        @Override // com.baidu.nadcore.widget.uitemplate.NadRewardCountDownView.g
        public void e() {
            nd1 nd1Var = NadRewardVideoView.this.o;
            if (nd1Var != null) {
                nd1Var.g(true, this.a);
            }
            NadRewardVideoView.this.j();
        }

        @Override // com.baidu.nadcore.widget.uitemplate.NadRewardCountDownView.g
        public void f() {
            if (NadRewardVideoView.this.r.isPlaying()) {
                NadRewardVideoView.this.r.stop();
            }
        }

        @Override // com.baidu.nadcore.widget.uitemplate.NadRewardCountDownView.g
        public void g() {
            pt0 pt0Var = NadRewardVideoView.this.r;
            if (pt0Var != null && pt0Var.isPause()) {
                NadRewardVideoView.this.r.resume();
            }
        }
    }

    public NadRewardVideoView(Context context) {
        this(context, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchWindowVisibilityChanged(int i) {
        boolean z;
        super.dispatchWindowVisibilityChanged(i);
        if (this.r == null) {
            return;
        }
        if (i == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z && this.r.isPause()) {
            this.r.resume();
        }
        if (!z && this.r.isPlaying()) {
            this.r.pause();
        }
    }

    @Override // com.baidu.nadcore.widget.view.NadRewardBaseView
    public void n(Context context) {
        this.s = (ViewGroup) findViewById(R.id.reward_ad_video_container);
    }

    @Override // com.baidu.nadcore.widget.view.NadRewardBaseView
    public void q(AdBaseModel adBaseModel) {
        super.q(adBaseModel);
        this.n.setRewardDownInnerListener(new c(adBaseModel));
    }

    public NadRewardVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NadRewardVideoView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, null);
    }

    public NadRewardVideoView(Context context, AttributeSet attributeSet, int i, hr0 hr0Var) {
        super(context, attributeSet, i, hr0Var);
        NadRewardVolumeView nadRewardVolumeView = (NadRewardVolumeView) findViewById(R.id.nad_reward_volumn_icon);
        this.t = nadRewardVolumeView;
        nadRewardVolumeView.setVolumeListener(new a());
        this.q = new b();
    }

    @Override // com.baidu.nadcore.widget.view.NadRewardBaseView
    public void j() {
        super.j();
        pt0 pt0Var = this.r;
        if (pt0Var != null) {
            pt0Var.release();
            this.r = null;
        }
    }

    @Override // com.baidu.nadcore.widget.view.NadRewardBaseView
    public void r(AdBaseModel adBaseModel) {
        if ((adBaseModel instanceof fr0) && adBaseModel.j != null) {
            if (this.s != null) {
                qt0 qt0Var = new qt0();
                qt0Var.a = 2;
                if (this.r == null) {
                    this.r = pt0.a.b(getContext(), 0, qt0Var);
                }
                z01 z01Var = new z01();
                z01Var.j(2);
                z01Var.l(false);
                z01Var.n(true);
                this.r.d(z01Var);
                this.r.attachToContainer(this.s);
                this.r.c(adBaseModel.j);
                this.r.a(this.q);
                hr0 hr0Var = adBaseModel.p;
                if (hr0Var != null) {
                    this.r.mute(hr0Var.h);
                }
                this.r.start();
            }
            setVisibility(0);
            return;
        }
        setVisibility(8);
    }
}
