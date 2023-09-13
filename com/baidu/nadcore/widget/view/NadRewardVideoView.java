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
import com.baidu.tieba.i21;
import com.baidu.tieba.ku0;
import com.baidu.tieba.lu0;
import com.baidu.tieba.od1;
import com.baidu.tieba.ou0;
import com.baidu.tieba.u11;
import com.baidu.tieba.xr0;
import com.baidu.tieba.zr0;
/* loaded from: classes3.dex */
public abstract class NadRewardVideoView extends NadRewardBaseView {
    public final ou0 q;
    public ku0 r;
    public ViewGroup s;
    public NadRewardVolumeView t;

    public abstract void I();

    public abstract void J();

    @Override // com.baidu.nadcore.widget.view.NadRewardBaseView
    public void m(LayoutInflater layoutInflater, zr0 zr0Var) {
    }

    @Override // com.baidu.nadcore.widget.view.NadRewardBaseView
    public void s(AdBaseModel adBaseModel) {
    }

    /* loaded from: classes3.dex */
    public class a implements NadRewardVolumeView.b {
        public a() {
        }

        @Override // com.baidu.nadcore.widget.uitemplate.NadRewardVolumeView.b
        public void a(boolean z) {
            ku0 ku0Var = NadRewardVideoView.this.r;
            if (ku0Var != null) {
                ku0Var.mute(z);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends ou0 {
        public b() {
        }

        @Override // com.baidu.tieba.ou0, com.baidu.tieba.hu0
        public void a(int i) {
            boolean z;
            if (NadRewardVideoView.this.t != null) {
                NadRewardVolumeView nadRewardVolumeView = NadRewardVideoView.this.t;
                if (i21.c(NadRewardVideoView.this.getContext()) <= 0) {
                    z = true;
                } else {
                    z = false;
                }
                nadRewardVolumeView.setVolumeState(z);
            }
        }

        @Override // com.baidu.tieba.ou0, com.baidu.tieba.hu0
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
            NadRewardVideoView.this.J();
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

        @Override // com.baidu.tieba.ou0, com.baidu.tieba.hu0
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

        @Override // com.baidu.tieba.ou0, com.baidu.tieba.hu0
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

        @Override // com.baidu.tieba.ou0, com.baidu.tieba.hu0
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

        @Override // com.baidu.tieba.ou0, com.baidu.tieba.hu0
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

        @Override // com.baidu.tieba.ou0, com.baidu.tieba.hu0
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
                if (i21.c(NadRewardVideoView.this.getContext()) <= 0) {
                    NadRewardVideoView.this.t.setVolumeState(true);
                }
                NadRewardVideoView.this.t.setVisibility(0);
            }
            NadRewardVideoView.this.I();
        }
    }

    /* loaded from: classes3.dex */
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
            ku0 ku0Var = NadRewardVideoView.this.r;
            if (ku0Var != null) {
                ku0Var.resume();
            }
        }

        @Override // com.baidu.nadcore.widget.uitemplate.NadRewardCountDownView.g
        public void b() {
            od1 od1Var = NadRewardVideoView.this.o;
            if (od1Var != null) {
                od1Var.h(this.a);
            }
            NadRewardVideoView.this.j();
        }

        @Override // com.baidu.nadcore.widget.uitemplate.NadRewardCountDownView.g
        public void c() {
            ku0 ku0Var = NadRewardVideoView.this.r;
            if (ku0Var != null) {
                ku0Var.pause();
            }
        }

        @Override // com.baidu.nadcore.widget.uitemplate.NadRewardCountDownView.g
        public void e() {
            od1 od1Var = NadRewardVideoView.this.o;
            if (od1Var != null) {
                od1Var.g(true, this.a);
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
            ku0 ku0Var = NadRewardVideoView.this.r;
            if (ku0Var != null && ku0Var.isPause()) {
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

    public NadRewardVideoView(Context context, AttributeSet attributeSet, int i, zr0 zr0Var) {
        super(context, attributeSet, i, zr0Var);
        NadRewardVolumeView nadRewardVolumeView = (NadRewardVolumeView) findViewById(R.id.nad_reward_volumn_icon);
        this.t = nadRewardVolumeView;
        nadRewardVolumeView.setVolumeListener(new a());
        this.q = new b();
    }

    @Override // com.baidu.nadcore.widget.view.NadRewardBaseView
    public void j() {
        super.j();
        ku0 ku0Var = this.r;
        if (ku0Var != null) {
            ku0Var.release();
            this.r = null;
        }
    }

    @Override // com.baidu.nadcore.widget.view.NadRewardBaseView
    public void r(AdBaseModel adBaseModel) {
        if ((adBaseModel instanceof xr0) && adBaseModel.j != null) {
            if (this.s != null) {
                lu0 lu0Var = new lu0();
                lu0Var.a = 2;
                if (this.r == null) {
                    this.r = ku0.a.b(getContext(), 0, lu0Var);
                }
                u11 u11Var = new u11();
                u11Var.j(2);
                u11Var.l(false);
                u11Var.n(true);
                this.r.d(u11Var);
                this.r.attachToContainer(this.s);
                this.r.c(adBaseModel.j);
                this.r.a(this.q);
                zr0 zr0Var = adBaseModel.p;
                if (zr0Var != null) {
                    this.r.mute(zr0Var.h);
                }
                this.r.start();
            }
            setVisibility(0);
            return;
        }
        setVisibility(8);
    }
}
