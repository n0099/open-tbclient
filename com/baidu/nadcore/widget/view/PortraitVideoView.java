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
import com.baidu.tieba.hd1;
import com.baidu.tieba.ku0;
import com.baidu.tieba.ou0;
import com.baidu.tieba.tj0;
import com.baidu.tieba.wr0;
import com.baidu.tieba.zr0;
/* loaded from: classes3.dex */
public class PortraitVideoView extends AdFeedBaseView implements View.OnClickListener {
    public ku0 i;
    public NadVideoAdOverContainer j;
    public ImageView k;
    public ViewGroup l;
    public final ou0 m;

    /* loaded from: classes3.dex */
    public class a extends ou0 {
        public a() {
        }

        @Override // com.baidu.tieba.ou0, com.baidu.tieba.hu0
        public void onEnd(int i) {
            if (PortraitVideoView.this.b != null && (PortraitVideoView.this.getTag() instanceof AdBaseModel)) {
                PortraitVideoView.this.b.f((AdBaseModel) PortraitVideoView.this.getTag());
            }
            PortraitVideoView.this.D();
        }

        @Override // com.baidu.tieba.ou0, com.baidu.tieba.hu0
        public void onError(int i, int i2, String str) {
            if (PortraitVideoView.this.b != null && (PortraitVideoView.this.getTag() instanceof AdBaseModel)) {
                PortraitVideoView.this.b.e((AdBaseModel) PortraitVideoView.this.getTag(), str);
            }
        }

        @Override // com.baidu.tieba.ou0, com.baidu.tieba.hu0
        public void onPause() {
            if (PortraitVideoView.this.b != null && (PortraitVideoView.this.getTag() instanceof AdBaseModel)) {
                PortraitVideoView.this.b.c((AdBaseModel) PortraitVideoView.this.getTag());
            }
        }

        @Override // com.baidu.tieba.ou0, com.baidu.tieba.hu0
        public void onPrepared() {
            if (PortraitVideoView.this.b != null && (PortraitVideoView.this.getTag() instanceof AdBaseModel)) {
                PortraitVideoView.this.b.d((AdBaseModel) PortraitVideoView.this.getTag());
            }
        }

        @Override // com.baidu.tieba.ou0, com.baidu.tieba.hu0
        public void onResume() {
            if (PortraitVideoView.this.b != null && (PortraitVideoView.this.getTag() instanceof AdBaseModel)) {
                PortraitVideoView.this.b.a((AdBaseModel) PortraitVideoView.this.getTag());
            }
        }

        @Override // com.baidu.tieba.ou0, com.baidu.tieba.hu0
        public void onStart() {
            if (PortraitVideoView.this.b != null && (PortraitVideoView.this.getTag() instanceof AdBaseModel)) {
                PortraitVideoView.this.b.b((AdBaseModel) PortraitVideoView.this.getTag());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            PortraitVideoView.this.y();
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public final /* synthetic */ hd1 a;

        public c(hd1 hd1Var) {
            this.a = hd1Var;
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
    public void setViewStatChangeListener(hd1 hd1Var) {
        super.setViewStatChangeListener(hd1Var);
        this.j.setOnUiClickListener(new c(hd1Var));
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
        ku0 ku0Var = this.i;
        if (ku0Var != null && ku0Var.isPlaying()) {
            B();
        }
    }

    public void z(LayoutInflater layoutInflater, zr0 zr0Var) {
        int i;
        if (zr0Var != null && zr0Var.a(AdBaseModel.STYLE.PORTRAIT_VIDEO) != 0) {
            i = zr0Var.a(AdBaseModel.STYLE.PORTRAIT_VIDEO);
        } else {
            i = R.layout.nad_portrait_video;
        }
        layoutInflater.inflate(i, this);
    }

    public PortraitVideoView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, null);
    }

    public PortraitVideoView(Context context, AttributeSet attributeSet, int i, zr0 zr0Var) {
        super(context, attributeSet, i, zr0Var);
        z(LayoutInflater.from(context), zr0Var);
        A(context);
        this.m = new a();
    }

    public void B() {
        ku0 ku0Var = this.i;
        if (ku0Var != null && ku0Var.isPlaying()) {
            this.i.pause();
            this.k.setVisibility(0);
        }
    }

    public void C() {
        this.l.setVisibility(0);
        ku0 ku0Var = this.i;
        if (ku0Var != null) {
            ku0Var.start();
        }
    }

    public final void D() {
        Log.d("PortraitVideoView", "start to showTailFrame");
        this.j.F(true);
        this.l.setVisibility(4);
    }

    public void E() {
        if (this.j.z()) {
            x();
        }
        ku0 ku0Var = this.i;
        if (ku0Var != null) {
            if (ku0Var.isPause()) {
                this.i.resume();
            } else {
                this.i.start();
            }
            this.k.setVisibility(4);
        }
    }

    public void x() {
        this.j.F(false);
        this.l.setVisibility(0);
    }

    public void y() {
        if (!this.j.z()) {
            return;
        }
        x();
        C();
    }

    public void G(AdBaseModel adBaseModel) {
        y();
        this.j.setOnNewTailFrameReplayClickListener(new b());
        if (this.i == null) {
            ku0 a2 = ku0.a.a(tj0.b(), 0);
            this.i = a2;
            a2.a(this.m);
        }
        wr0 wr0Var = adBaseModel.j;
        if (wr0Var != null) {
            this.i.c(wr0Var);
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
