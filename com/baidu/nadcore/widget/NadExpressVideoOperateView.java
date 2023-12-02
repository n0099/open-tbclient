package com.baidu.nadcore.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.widget.view.NadExpressNaBaseView;
import com.baidu.tieba.R;
import com.baidu.tieba.aq0;
import com.baidu.tieba.bq0;
import com.baidu.tieba.cx0;
import com.baidu.tieba.eq0;
import com.baidu.tieba.ln0;
import com.baidu.tieba.mn0;
import com.baidu.tieba.on0;
/* loaded from: classes3.dex */
public class NadExpressVideoOperateView extends NadExpressNaBaseView {
    @Nullable
    public AdImageView k;
    @Nullable
    public TextView l;
    @Nullable
    public ImageView m;
    public aq0 n;
    @Nullable
    public ViewGroup o;
    public final eq0 p;

    /* loaded from: classes3.dex */
    public class a extends eq0 {
        public a() {
        }

        @Override // com.baidu.tieba.eq0, com.baidu.tieba.xp0
        public void onEnd(int i) {
            if (NadExpressVideoOperateView.this.b != null && (NadExpressVideoOperateView.this.getTag() instanceof AdBaseModel)) {
                NadExpressVideoOperateView.this.b.f((AdBaseModel) NadExpressVideoOperateView.this.getTag());
            }
        }

        @Override // com.baidu.tieba.eq0, com.baidu.tieba.xp0
        public void onError(int i, int i2, String str) {
            if (NadExpressVideoOperateView.this.b != null && (NadExpressVideoOperateView.this.getTag() instanceof AdBaseModel)) {
                NadExpressVideoOperateView.this.b.e((AdBaseModel) NadExpressVideoOperateView.this.getTag(), str);
            }
        }

        @Override // com.baidu.tieba.eq0, com.baidu.tieba.xp0
        public void onPause() {
            if (NadExpressVideoOperateView.this.b != null && (NadExpressVideoOperateView.this.getTag() instanceof AdBaseModel)) {
                NadExpressVideoOperateView.this.b.c((AdBaseModel) NadExpressVideoOperateView.this.getTag());
            }
        }

        @Override // com.baidu.tieba.eq0, com.baidu.tieba.xp0
        public void onPrepared() {
            if (NadExpressVideoOperateView.this.b != null && (NadExpressVideoOperateView.this.getTag() instanceof AdBaseModel)) {
                NadExpressVideoOperateView.this.b.d((AdBaseModel) NadExpressVideoOperateView.this.getTag());
            }
        }

        @Override // com.baidu.tieba.eq0, com.baidu.tieba.xp0
        public void onResume() {
            if (NadExpressVideoOperateView.this.b != null && (NadExpressVideoOperateView.this.getTag() instanceof AdBaseModel)) {
                NadExpressVideoOperateView.this.b.a((AdBaseModel) NadExpressVideoOperateView.this.getTag());
            }
        }

        @Override // com.baidu.tieba.eq0, com.baidu.tieba.xp0
        public void onStart() {
            if (NadExpressVideoOperateView.this.m != null) {
                NadExpressVideoOperateView.this.m.setVisibility(8);
            }
            TextView textView = NadExpressVideoOperateView.this.l;
            if (textView != null) {
                textView.setVisibility(8);
            }
            if (NadExpressVideoOperateView.this.k != null) {
                NadExpressVideoOperateView.this.k.setVisibility(8);
            }
            if (NadExpressVideoOperateView.this.b != null && (NadExpressVideoOperateView.this.getTag() instanceof AdBaseModel)) {
                NadExpressVideoOperateView.this.b.b((AdBaseModel) NadExpressVideoOperateView.this.getTag());
            }
        }
    }

    public NadExpressVideoOperateView(Context context) {
        this(context, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchWindowVisibilityChanged(int i) {
        boolean z;
        super.dispatchWindowVisibilityChanged(i);
        if (this.n == null) {
            return;
        }
        if (i == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z && this.n.isPause()) {
            this.n.resume();
        }
        if (!z && this.n.isPlaying()) {
            this.n.pause();
        }
    }

    @Override // com.baidu.nadcore.widget.view.NadExpressNaBaseView
    public void h(Context context) {
        this.k = (AdImageView) findViewById(R.id.nad_feed_template_cover_image);
        this.l = (TextView) findViewById(R.id.nad_feed_template_big_video_length_id);
        this.m = (ImageView) findViewById(R.id.nad_feed_template_big_image_video_icon_id);
        this.o = (ViewGroup) findViewById(R.id.nad_feed_template_video_id);
    }

    public NadExpressVideoOperateView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // com.baidu.nadcore.widget.view.NadExpressNaBaseView
    public void g(LayoutInflater layoutInflater, on0 on0Var) {
        int i;
        if (on0Var != null && on0Var.a(AdBaseModel.STYLE.VIDEO) != 0) {
            i = on0Var.a(AdBaseModel.STYLE.VIDEO);
        } else {
            i = R.layout.nad_feed_video;
        }
        layoutInflater.inflate(i, this);
    }

    public NadExpressVideoOperateView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, null);
    }

    public NadExpressVideoOperateView(Context context, AttributeSet attributeSet, int i, on0 on0Var) {
        super(context, attributeSet, i, on0Var);
        this.p = new a();
    }

    public final void A() {
        if (!(getTag() instanceof mn0)) {
            AdImageView adImageView = this.k;
            if (adImageView != null) {
                adImageView.setVisibility(0);
            }
            ImageView imageView = this.m;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            TextView textView = this.l;
            if (textView != null && !TextUtils.isEmpty(textView.getText())) {
                this.l.setVisibility(0);
            }
            ViewGroup viewGroup = this.o;
            if (viewGroup != null) {
                viewGroup.setVisibility(8);
                return;
            }
            return;
        }
        mn0 mn0Var = (mn0) getTag();
        if (this.o == null) {
            return;
        }
        if (this.n == null) {
            bq0 bq0Var = new bq0();
            bq0Var.a = 1;
            this.n = aq0.a.a(getContext(), 0, bq0Var);
            cx0 cx0Var = new cx0();
            cx0Var.j(1);
            this.n.d(cx0Var);
            this.n.attachToContainer(this.o);
            ln0 ln0Var = mn0Var.j;
            if (ln0Var != null) {
                this.n.c(ln0Var);
            }
            this.n.a(this.p);
        }
        if (!this.n.isPlaying()) {
            AdImageView adImageView2 = this.k;
            if (adImageView2 != null) {
                adImageView2.setVisibility(8);
            }
            ImageView imageView2 = this.m;
            if (imageView2 != null) {
                imageView2.setVisibility(8);
            }
            TextView textView2 = this.l;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
            ViewGroup viewGroup2 = this.o;
            if (viewGroup2 != null) {
                viewGroup2.setVisibility(0);
            }
            this.n.start();
        }
    }

    @Override // com.baidu.nadcore.widget.feed.AdFeedBaseView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        A();
    }

    @Override // com.baidu.nadcore.widget.feed.AdFeedBaseView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        aq0 aq0Var = this.n;
        if (aq0Var != null) {
            aq0Var.release();
            this.n = null;
        }
    }
}
