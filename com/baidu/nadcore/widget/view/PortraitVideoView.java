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
import com.baidu.tieba.as0;
import com.baidu.tieba.iu0;
import com.baidu.tieba.kk0;
import com.baidu.tieba.mu0;
import com.baidu.tieba.xr0;
import com.baidu.tieba.zd1;
/* loaded from: classes3.dex */
public class PortraitVideoView extends AdFeedBaseView implements View.OnClickListener {
    public iu0 i;
    public NadVideoAdOverContainer j;
    public ImageView k;
    public ViewGroup l;
    public final mu0 m;

    /* loaded from: classes3.dex */
    public class a extends mu0 {
        public a() {
        }

        @Override // com.baidu.tieba.mu0, com.baidu.tieba.fu0
        public void onEnd(int i) {
            if (PortraitVideoView.this.b != null && (PortraitVideoView.this.getTag() instanceof AdBaseModel)) {
                PortraitVideoView.this.b.f((AdBaseModel) PortraitVideoView.this.getTag());
            }
            PortraitVideoView.this.D();
        }

        @Override // com.baidu.tieba.mu0, com.baidu.tieba.fu0
        public void onError(int i, int i2, String str) {
            if (PortraitVideoView.this.b != null && (PortraitVideoView.this.getTag() instanceof AdBaseModel)) {
                PortraitVideoView.this.b.e((AdBaseModel) PortraitVideoView.this.getTag(), str);
            }
        }

        @Override // com.baidu.tieba.mu0, com.baidu.tieba.fu0
        public void onPause() {
            if (PortraitVideoView.this.b != null && (PortraitVideoView.this.getTag() instanceof AdBaseModel)) {
                PortraitVideoView.this.b.c((AdBaseModel) PortraitVideoView.this.getTag());
            }
        }

        @Override // com.baidu.tieba.mu0, com.baidu.tieba.fu0
        public void onPrepared() {
            if (PortraitVideoView.this.b != null && (PortraitVideoView.this.getTag() instanceof AdBaseModel)) {
                PortraitVideoView.this.b.d((AdBaseModel) PortraitVideoView.this.getTag());
            }
        }

        @Override // com.baidu.tieba.mu0, com.baidu.tieba.fu0
        public void onResume() {
            if (PortraitVideoView.this.b != null && (PortraitVideoView.this.getTag() instanceof AdBaseModel)) {
                PortraitVideoView.this.b.a((AdBaseModel) PortraitVideoView.this.getTag());
            }
        }

        @Override // com.baidu.tieba.mu0, com.baidu.tieba.fu0
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
        public final /* synthetic */ zd1 a;

        public c(zd1 zd1Var) {
            this.a = zd1Var;
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
    public void setViewStatChangeListener(zd1 zd1Var) {
        super.setViewStatChangeListener(zd1Var);
        this.j.setOnUiClickListener(new c(zd1Var));
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
        iu0 iu0Var = this.i;
        if (iu0Var != null && iu0Var.isPlaying()) {
            B();
        }
    }

    public void z(LayoutInflater layoutInflater, as0 as0Var) {
        int i;
        if (as0Var != null && as0Var.a(AdBaseModel.STYLE.PORTRAIT_VIDEO) != 0) {
            i = as0Var.a(AdBaseModel.STYLE.PORTRAIT_VIDEO);
        } else {
            i = R.layout.nad_portrait_video;
        }
        layoutInflater.inflate(i, this);
    }

    public PortraitVideoView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, null);
    }

    public PortraitVideoView(Context context, AttributeSet attributeSet, int i, as0 as0Var) {
        super(context, attributeSet, i, as0Var);
        z(LayoutInflater.from(context), as0Var);
        A(context);
        this.m = new a();
    }

    public void B() {
        iu0 iu0Var = this.i;
        if (iu0Var != null && iu0Var.isPlaying()) {
            this.i.pause();
            this.k.setVisibility(0);
        }
    }

    public void C() {
        this.l.setVisibility(0);
        iu0 iu0Var = this.i;
        if (iu0Var != null) {
            iu0Var.start();
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
        iu0 iu0Var = this.i;
        if (iu0Var != null) {
            if (iu0Var.isPause()) {
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
            iu0 a2 = iu0.a.a(kk0.b(), 0);
            this.i = a2;
            a2.a(this.m);
        }
        xr0 xr0Var = adBaseModel.j;
        if (xr0Var != null) {
            this.i.c(xr0Var);
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
