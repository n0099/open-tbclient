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
import com.baidu.tieba.k81;
import com.baidu.tieba.mn0;
import com.baidu.tieba.xp0;
/* loaded from: classes3.dex */
public class PortraitVideoView extends AdFeedBaseView implements View.OnClickListener {
    public xp0 h;
    public NadVideoAdOverContainer i;
    public ImageView j;
    public ViewGroup k;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public final /* synthetic */ k81 a;

        public a(k81 k81Var) {
            this.a = k81Var;
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
    public void setViewStatChangeListener(k81 k81Var) {
        super.setViewStatChangeListener(k81Var);
        this.i.setOnUiClickListener(new a(k81Var));
    }

    public PortraitVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchVisibilityChanged(View view2, int i) {
        super.dispatchVisibilityChanged(view2, i);
        if (i == 0) {
            if (this.h != null) {
                k();
                return;
            }
            return;
        }
        xp0 xp0Var = this.h;
        if (xp0Var != null && xp0Var.isPlaying()) {
            i();
        }
    }

    public void g(LayoutInflater layoutInflater, mn0 mn0Var) {
        int i;
        if (mn0Var != null && mn0Var.a(AdBaseModel.STYLE.PORTRAIT_VIDEO) != 0) {
            i = mn0Var.a(AdBaseModel.STYLE.PORTRAIT_VIDEO);
        } else {
            i = R.layout.nad_portrait_video;
        }
        layoutInflater.inflate(i, this);
    }

    public PortraitVideoView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, null);
    }

    public PortraitVideoView(Context context, AttributeSet attributeSet, int i, mn0 mn0Var) {
        super(context, attributeSet, i, mn0Var);
        g(LayoutInflater.from(context), mn0Var);
        h(context);
    }

    public void f() {
        this.i.F(false);
        this.k.setVisibility(0);
    }

    public void i() {
        xp0 xp0Var = this.h;
        if (xp0Var != null && xp0Var.isPlaying()) {
            this.h.pause();
            this.j.setVisibility(0);
        }
    }

    public void k() {
        if (this.i.z()) {
            f();
        }
        xp0 xp0Var = this.h;
        if (xp0Var != null) {
            if (xp0Var.isPause()) {
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
