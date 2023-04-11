package com.baidu.nadcore.widget.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.baidu.nadcore.business.uitemplate.NadVideoAdOverContainer;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.widget.feed.AdFeedBaseView;
import com.baidu.tieba.R;
import com.baidu.tieba.gs0;
import com.baidu.tieba.ii0;
import com.baidu.tieba.ks0;
import com.baidu.tieba.vp0;
import com.baidu.tieba.xb1;
import com.baidu.tieba.yp0;
/* loaded from: classes2.dex */
public class PortraitVideoView extends AdFeedBaseView implements View.OnClickListener {
    public gs0 i;
    public NadVideoAdOverContainer j;
    public ImageView k;
    public ViewGroup l;
    public final ks0 m;

    /* loaded from: classes2.dex */
    public class a extends ks0 {
        public a() {
        }

        @Override // com.baidu.tieba.ks0, com.baidu.tieba.ds0
        public void onEnd(int i) {
            if (PortraitVideoView.this.b != null && (PortraitVideoView.this.getTag() instanceof AdBaseModel)) {
                PortraitVideoView.this.b.f((AdBaseModel) PortraitVideoView.this.getTag());
            }
            PortraitVideoView.this.D();
        }

        @Override // com.baidu.tieba.ks0, com.baidu.tieba.ds0
        public void onError(int i, int i2, String str) {
            if (PortraitVideoView.this.b != null && (PortraitVideoView.this.getTag() instanceof AdBaseModel)) {
                PortraitVideoView.this.b.e((AdBaseModel) PortraitVideoView.this.getTag(), str);
            }
        }

        @Override // com.baidu.tieba.ks0, com.baidu.tieba.ds0
        public void onPause() {
            if (PortraitVideoView.this.b != null && (PortraitVideoView.this.getTag() instanceof AdBaseModel)) {
                PortraitVideoView.this.b.c((AdBaseModel) PortraitVideoView.this.getTag());
            }
        }

        @Override // com.baidu.tieba.ks0, com.baidu.tieba.ds0
        public void onPrepared() {
            if (PortraitVideoView.this.b != null && (PortraitVideoView.this.getTag() instanceof AdBaseModel)) {
                PortraitVideoView.this.b.d((AdBaseModel) PortraitVideoView.this.getTag());
            }
        }

        @Override // com.baidu.tieba.ks0, com.baidu.tieba.ds0
        public void onResume() {
            if (PortraitVideoView.this.b != null && (PortraitVideoView.this.getTag() instanceof AdBaseModel)) {
                PortraitVideoView.this.b.a((AdBaseModel) PortraitVideoView.this.getTag());
            }
        }

        @Override // com.baidu.tieba.ks0, com.baidu.tieba.ds0
        public void onStart() {
            if (PortraitVideoView.this.b != null && (PortraitVideoView.this.getTag() instanceof AdBaseModel)) {
                PortraitVideoView.this.b.b((AdBaseModel) PortraitVideoView.this.getTag());
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            PortraitVideoView.this.y();
        }
    }

    /* loaded from: classes2.dex */
    public class c implements View.OnClickListener {
        public final /* synthetic */ xb1 a;

        public c(xb1 xb1Var) {
            this.a = xb1Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (!(PortraitVideoView.this.getTag() instanceof AdBaseModel)) {
                return;
            }
            this.a.b((AdBaseModel) PortraitVideoView.this.getTag());
        }
    }

    public PortraitVideoView(Context context) {
        this(context, null);
    }

    public void A(Context context) {
        NadVideoAdOverContainer nadVideoAdOverContainer = (NadVideoAdOverContainer) findViewById(R.id.nad_ui_layout);
        this.j = nadVideoAdOverContainer;
        nadVideoAdOverContainer.setOnClickListener(this);
        ImageView imageView = (ImageView) findViewById(R.id.video_pause_icon);
        this.k = imageView;
        imageView.setOnClickListener(this);
        this.l = (ViewGroup) findViewById(R.id.nad_mini_video_player_container);
    }

    public void F(AdBaseModel adBaseModel) {
        this.j.setVisibility(0);
        this.j.setData(adBaseModel);
        this.j.setTag(R.id.nad_mini_video_model, adBaseModel);
    }

    @Override // com.baidu.nadcore.widget.feed.AdFeedBaseView
    public void setViewStatChangeListener(xb1 xb1Var) {
        super.setViewStatChangeListener(xb1Var);
        this.j.setOnUiClickListener(new c(xb1Var));
    }

    @Override // com.baidu.nadcore.widget.feed.AdFeedBaseView
    public void update(@NonNull AdBaseModel adBaseModel) {
        super.update(adBaseModel);
        F(adBaseModel);
        G(adBaseModel);
    }

    public PortraitVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchVisibilityChanged(View view2, int i) {
        super.dispatchVisibilityChanged(view2, i);
        if (i == 0) {
            if (this.i != null) {
                E();
                return;
            }
            return;
        }
        gs0 gs0Var = this.i;
        if (gs0Var != null && gs0Var.isPlaying()) {
            B();
        }
    }

    public void z(LayoutInflater layoutInflater, yp0 yp0Var) {
        int i;
        if (yp0Var != null && yp0Var.a(AdBaseModel.STYLE.PORTRAIT_VIDEO) != 0) {
            i = yp0Var.a(AdBaseModel.STYLE.PORTRAIT_VIDEO);
        } else {
            i = R.layout.nad_portrait_video;
        }
        layoutInflater.inflate(i, this);
    }

    public PortraitVideoView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, null);
    }

    public PortraitVideoView(Context context, AttributeSet attributeSet, int i, yp0 yp0Var) {
        super(context, attributeSet, i, yp0Var);
        z(LayoutInflater.from(context), yp0Var);
        A(context);
        this.m = new a();
    }

    public void B() {
        gs0 gs0Var = this.i;
        if (gs0Var != null && gs0Var.isPlaying()) {
            this.i.pause();
            this.k.setVisibility(0);
        }
    }

    public void C() {
        this.l.setVisibility(0);
        gs0 gs0Var = this.i;
        if (gs0Var != null) {
            gs0Var.start();
        }
    }

    public final void D() {
        Log.d("PortraitVideoView", "start to showTailFrame");
        this.j.A(true);
        this.l.setVisibility(4);
    }

    public void E() {
        if (this.j.v()) {
            x();
        }
        gs0 gs0Var = this.i;
        if (gs0Var != null) {
            if (gs0Var.isPause()) {
                this.i.resume();
            } else {
                this.i.start();
            }
            this.k.setVisibility(4);
        }
    }

    public void x() {
        this.j.A(false);
        this.l.setVisibility(0);
    }

    public void y() {
        if (!this.j.v()) {
            return;
        }
        x();
        C();
    }

    public void G(AdBaseModel adBaseModel) {
        y();
        this.j.setOnNewTailFrameReplayClickListener(new b());
        if (this.i == null) {
            gs0 a2 = gs0.a.a(ii0.b(), 0);
            this.i = a2;
            a2.a(this.m);
        }
        vp0 vp0Var = adBaseModel.j;
        if (vp0Var != null) {
            this.i.c(vp0Var);
        }
        this.i.attachToContainer(this.l);
    }

    @Override // com.baidu.nadcore.widget.feed.AdFeedBaseView
    public void onClick(View view2) {
        if (view2.getId() == R.id.nad_ui_layout || view2.getId() == R.id.video_pause_icon) {
            Log.d("PortraitVideoView", "onclick area： cover");
            if (this.i.isPlaying()) {
                this.i.pause();
                this.k.setVisibility(0);
                return;
            }
            this.i.resume();
            this.k.setVisibility(4);
        }
    }
}
