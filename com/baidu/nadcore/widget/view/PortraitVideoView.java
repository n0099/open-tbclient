package com.baidu.nadcore.widget.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.nadcore.business.uitemplate.NadVideoAdOverContainer;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.widget.feed.AdFeedBaseView;
import com.baidu.tieba.R;
import com.baidu.tieba.aq0;
import com.baidu.tieba.n81;
import com.baidu.tieba.on0;
/* loaded from: classes3.dex */
public class PortraitVideoView extends AdFeedBaseView implements View.OnClickListener {
    public aq0 h;
    public NadVideoAdOverContainer i;
    public ImageView j;
    public ViewGroup k;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public final /* synthetic */ n81 a;

        public a(n81 n81Var) {
            this.a = n81Var;
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

    public void h(Context context) {
        NadVideoAdOverContainer nadVideoAdOverContainer = (NadVideoAdOverContainer) findViewById(R.id.nad_ui_layout);
        this.i = nadVideoAdOverContainer;
        nadVideoAdOverContainer.setOnClickListener(this);
        ImageView imageView = (ImageView) findViewById(R.id.video_pause_icon);
        this.j = imageView;
        imageView.setOnClickListener(this);
        this.k = (ViewGroup) findViewById(R.id.nad_mini_video_player_container);
    }

    @Override // com.baidu.nadcore.widget.feed.AdFeedBaseView
    public void setViewStatChangeListener(n81 n81Var) {
        super.setViewStatChangeListener(n81Var);
        this.i.setOnUiClickListener(new a(n81Var));
    }

    public PortraitVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchVisibilityChanged(View view2, int i) {
        super.dispatchVisibilityChanged(view2, i);
        if (i == 0) {
            if (this.h != null) {
                j();
                return;
            }
            return;
        }
        aq0 aq0Var = this.h;
        if (aq0Var != null && aq0Var.isPlaying()) {
            i();
        }
    }

    public void g(LayoutInflater layoutInflater, on0 on0Var) {
        int i;
        if (on0Var != null && on0Var.a(AdBaseModel.STYLE.PORTRAIT_VIDEO) != 0) {
            i = on0Var.a(AdBaseModel.STYLE.PORTRAIT_VIDEO);
        } else {
            i = R.layout.nad_portrait_video;
        }
        layoutInflater.inflate(i, this);
    }

    public PortraitVideoView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, null);
    }

    public PortraitVideoView(Context context, AttributeSet attributeSet, int i, on0 on0Var) {
        super(context, attributeSet, i, on0Var);
        g(LayoutInflater.from(context), on0Var);
        h(context);
    }

    public void f() {
        this.i.F(false);
        this.k.setVisibility(0);
    }

    public void i() {
        aq0 aq0Var = this.h;
        if (aq0Var != null && aq0Var.isPlaying()) {
            this.h.pause();
            this.j.setVisibility(0);
        }
    }

    public void j() {
        if (this.i.z()) {
            f();
        }
        aq0 aq0Var = this.h;
        if (aq0Var != null) {
            if (aq0Var.isPause()) {
                this.h.resume();
            } else {
                this.h.start();
            }
            this.j.setVisibility(4);
        }
    }

    @Override // com.baidu.nadcore.widget.feed.AdFeedBaseView
    public void onClick(View view2) {
        if (view2.getId() == R.id.nad_ui_layout || view2.getId() == R.id.video_pause_icon) {
            Log.d("PortraitVideoView", "onclick area： cover");
            if (this.h.isPlaying()) {
                this.h.pause();
                this.j.setVisibility(0);
                return;
            }
            this.h.resume();
            this.j.setVisibility(4);
        }
    }
}
