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
import com.baidu.tieba.er0;
import com.baidu.tieba.gd1;
import com.baidu.tieba.hr0;
import com.baidu.tieba.pt0;
import com.baidu.tieba.rj0;
import com.baidu.tieba.tt0;
/* loaded from: classes2.dex */
public class PortraitVideoView extends AdFeedBaseView implements View.OnClickListener {
    public pt0 i;
    public NadVideoAdOverContainer j;
    public ImageView k;
    public ViewGroup l;
    public final tt0 m;

    /* loaded from: classes2.dex */
    public class a extends tt0 {
        public a() {
        }

        @Override // com.baidu.tieba.tt0, com.baidu.tieba.mt0
        public void onEnd(int i) {
            if (PortraitVideoView.this.b != null && (PortraitVideoView.this.getTag() instanceof AdBaseModel)) {
                PortraitVideoView.this.b.f((AdBaseModel) PortraitVideoView.this.getTag());
            }
            PortraitVideoView.this.B();
        }

        @Override // com.baidu.tieba.tt0, com.baidu.tieba.mt0
        public void onError(int i, int i2, String str) {
            if (PortraitVideoView.this.b != null && (PortraitVideoView.this.getTag() instanceof AdBaseModel)) {
                PortraitVideoView.this.b.e((AdBaseModel) PortraitVideoView.this.getTag(), str);
            }
        }

        @Override // com.baidu.tieba.tt0, com.baidu.tieba.mt0
        public void onPause() {
            if (PortraitVideoView.this.b != null && (PortraitVideoView.this.getTag() instanceof AdBaseModel)) {
                PortraitVideoView.this.b.c((AdBaseModel) PortraitVideoView.this.getTag());
            }
        }

        @Override // com.baidu.tieba.tt0, com.baidu.tieba.mt0
        public void onPrepared() {
            if (PortraitVideoView.this.b != null && (PortraitVideoView.this.getTag() instanceof AdBaseModel)) {
                PortraitVideoView.this.b.d((AdBaseModel) PortraitVideoView.this.getTag());
            }
        }

        @Override // com.baidu.tieba.tt0, com.baidu.tieba.mt0
        public void onResume() {
            if (PortraitVideoView.this.b != null && (PortraitVideoView.this.getTag() instanceof AdBaseModel)) {
                PortraitVideoView.this.b.a((AdBaseModel) PortraitVideoView.this.getTag());
            }
        }

        @Override // com.baidu.tieba.tt0, com.baidu.tieba.mt0
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
            PortraitVideoView.this.w();
        }
    }

    /* loaded from: classes2.dex */
    public class c implements View.OnClickListener {
        public final /* synthetic */ gd1 a;

        public c(gd1 gd1Var) {
            this.a = gd1Var;
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

    public void D(AdBaseModel adBaseModel) {
        this.j.setVisibility(0);
        this.j.setData(adBaseModel);
        this.j.setTag(R.id.nad_mini_video_model, adBaseModel);
    }

    @Override // com.baidu.nadcore.widget.feed.AdFeedBaseView
    public void setViewStatChangeListener(gd1 gd1Var) {
        super.setViewStatChangeListener(gd1Var);
        this.j.setOnUiClickListener(new c(gd1Var));
    }

    @Override // com.baidu.nadcore.widget.feed.AdFeedBaseView
    public void update(@NonNull AdBaseModel adBaseModel) {
        super.update(adBaseModel);
        D(adBaseModel);
        E(adBaseModel);
    }

    public void y(Context context) {
        NadVideoAdOverContainer nadVideoAdOverContainer = (NadVideoAdOverContainer) findViewById(R.id.nad_ui_layout);
        this.j = nadVideoAdOverContainer;
        nadVideoAdOverContainer.setOnClickListener(this);
        ImageView imageView = (ImageView) findViewById(R.id.video_pause_icon);
        this.k = imageView;
        imageView.setOnClickListener(this);
        this.l = (ViewGroup) findViewById(R.id.nad_mini_video_player_container);
    }

    public PortraitVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchVisibilityChanged(View view2, int i) {
        super.dispatchVisibilityChanged(view2, i);
        if (i == 0) {
            if (this.i != null) {
                C();
                return;
            }
            return;
        }
        pt0 pt0Var = this.i;
        if (pt0Var != null && pt0Var.isPlaying()) {
            z();
        }
    }

    public void x(LayoutInflater layoutInflater, hr0 hr0Var) {
        int i;
        if (hr0Var != null && hr0Var.a(AdBaseModel.STYLE.PORTRAIT_VIDEO) != 0) {
            i = hr0Var.a(AdBaseModel.STYLE.PORTRAIT_VIDEO);
        } else {
            i = R.layout.nad_portrait_video;
        }
        layoutInflater.inflate(i, this);
    }

    public PortraitVideoView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, null);
    }

    public PortraitVideoView(Context context, AttributeSet attributeSet, int i, hr0 hr0Var) {
        super(context, attributeSet, i, hr0Var);
        x(LayoutInflater.from(context), hr0Var);
        y(context);
        this.m = new a();
    }

    public void A() {
        this.l.setVisibility(0);
        pt0 pt0Var = this.i;
        if (pt0Var != null) {
            pt0Var.start();
        }
    }

    public final void B() {
        Log.d("PortraitVideoView", "start to showTailFrame");
        this.j.A(true);
        this.l.setVisibility(4);
    }

    public void C() {
        if (this.j.v()) {
            v();
        }
        pt0 pt0Var = this.i;
        if (pt0Var != null) {
            if (pt0Var.isPause()) {
                this.i.resume();
            } else {
                this.i.start();
            }
            this.k.setVisibility(4);
        }
    }

    public void v() {
        this.j.A(false);
        this.l.setVisibility(0);
    }

    public void w() {
        if (!this.j.v()) {
            return;
        }
        v();
        A();
    }

    public void z() {
        pt0 pt0Var = this.i;
        if (pt0Var != null && pt0Var.isPlaying()) {
            this.i.pause();
            this.k.setVisibility(0);
        }
    }

    public void E(AdBaseModel adBaseModel) {
        w();
        this.j.setOnNewTailFrameReplayClickListener(new b());
        if (this.i == null) {
            pt0 a2 = pt0.a.a(rj0.b(), 0);
            this.i = a2;
            a2.a(this.m);
        }
        er0 er0Var = adBaseModel.j;
        if (er0Var != null) {
            this.i.c(er0Var);
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
