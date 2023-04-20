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
import com.baidu.tieba.fc1;
import com.baidu.tieba.g01;
import com.baidu.tieba.hs0;
import com.baidu.tieba.is0;
import com.baidu.tieba.ls0;
import com.baidu.tieba.rz0;
import com.baidu.tieba.xp0;
import com.baidu.tieba.zp0;
/* loaded from: classes2.dex */
public abstract class NadRewardVideoView extends NadRewardBaseView {
    public final ls0 q;
    public hs0 r;
    public ViewGroup s;
    public NadRewardVolumeView t;

    public abstract void I();

    public abstract void J();

    @Override // com.baidu.nadcore.widget.view.NadRewardBaseView
    public void m(LayoutInflater layoutInflater, zp0 zp0Var) {
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
            hs0 hs0Var = NadRewardVideoView.this.r;
            if (hs0Var != null) {
                hs0Var.mute(z);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b extends ls0 {
        public b() {
        }

        @Override // com.baidu.tieba.ls0, com.baidu.tieba.es0
        public void a(int i) {
            boolean z;
            if (NadRewardVideoView.this.t != null) {
                NadRewardVolumeView nadRewardVolumeView = NadRewardVideoView.this.t;
                if (g01.c(NadRewardVideoView.this.getContext()) <= 0) {
                    z = true;
                } else {
                    z = false;
                }
                nadRewardVolumeView.setVolumeState(z);
            }
        }

        @Override // com.baidu.tieba.ls0, com.baidu.tieba.es0
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

        @Override // com.baidu.tieba.ls0, com.baidu.tieba.es0
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

        @Override // com.baidu.tieba.ls0, com.baidu.tieba.es0
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

        @Override // com.baidu.tieba.ls0, com.baidu.tieba.es0
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

        @Override // com.baidu.tieba.ls0, com.baidu.tieba.es0
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

        @Override // com.baidu.tieba.ls0, com.baidu.tieba.es0
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
                if (g01.c(NadRewardVideoView.this.getContext()) <= 0) {
                    NadRewardVideoView.this.t.setVolumeState(true);
                }
                NadRewardVideoView.this.t.setVisibility(0);
            }
            NadRewardVideoView.this.I();
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
            hs0 hs0Var = NadRewardVideoView.this.r;
            if (hs0Var != null) {
                hs0Var.resume();
            }
        }

        @Override // com.baidu.nadcore.widget.uitemplate.NadRewardCountDownView.g
        public void b() {
            hs0 hs0Var = NadRewardVideoView.this.r;
            if (hs0Var != null) {
                hs0Var.pause();
            }
        }

        @Override // com.baidu.nadcore.widget.uitemplate.NadRewardCountDownView.g
        public void c() {
            fc1 fc1Var = NadRewardVideoView.this.o;
            if (fc1Var != null) {
                fc1Var.h(this.a);
            }
            NadRewardVideoView.this.j();
        }

        @Override // com.baidu.nadcore.widget.uitemplate.NadRewardCountDownView.g
        public void e() {
            fc1 fc1Var = NadRewardVideoView.this.o;
            if (fc1Var != null) {
                fc1Var.g(true, this.a);
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
            hs0 hs0Var = NadRewardVideoView.this.r;
            if (hs0Var != null && hs0Var.isPause()) {
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

    public NadRewardVideoView(Context context, AttributeSet attributeSet, int i, zp0 zp0Var) {
        super(context, attributeSet, i, zp0Var);
        NadRewardVolumeView nadRewardVolumeView = (NadRewardVolumeView) findViewById(R.id.nad_reward_volumn_icon);
        this.t = nadRewardVolumeView;
        nadRewardVolumeView.setVolumeListener(new a());
        this.q = new b();
    }

    @Override // com.baidu.nadcore.widget.view.NadRewardBaseView
    public void j() {
        super.j();
        hs0 hs0Var = this.r;
        if (hs0Var != null) {
            hs0Var.release();
            this.r = null;
        }
    }

    @Override // com.baidu.nadcore.widget.view.NadRewardBaseView
    public void r(AdBaseModel adBaseModel) {
        if ((adBaseModel instanceof xp0) && adBaseModel.j != null) {
            if (this.s != null) {
                is0 is0Var = new is0();
                is0Var.a = 2;
                if (this.r == null) {
                    this.r = hs0.a.b(getContext(), 0, is0Var);
                }
                rz0 rz0Var = new rz0();
                rz0Var.j(2);
                rz0Var.l(false);
                rz0Var.n(true);
                this.r.d(rz0Var);
                this.r.attachToContainer(this.s);
                this.r.c(adBaseModel.j);
                this.r.a(this.q);
                zp0 zp0Var = adBaseModel.p;
                if (zp0Var != null) {
                    this.r.mute(zp0Var.h);
                }
                this.r.start();
            }
            setVisibility(0);
            return;
        }
        setVisibility(8);
    }
}
