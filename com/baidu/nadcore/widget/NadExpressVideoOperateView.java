package com.baidu.nadcore.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.Rect;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.widget.view.NadExpressNaBaseView;
import com.baidu.tieba.R;
import com.baidu.tieba.gr0;
import com.baidu.tieba.h31;
import com.baidu.tieba.ku0;
import com.baidu.tieba.lu0;
import com.baidu.tieba.ou0;
import com.baidu.tieba.q61;
import com.baidu.tieba.u11;
import com.baidu.tieba.wr0;
import com.baidu.tieba.xr0;
import com.baidu.tieba.zr0;
import java.util.Locale;
/* loaded from: classes3.dex */
public class NadExpressVideoOperateView extends NadExpressNaBaseView {
    @Nullable
    public AdImageView m;
    @Nullable
    public TextView n;
    @Nullable
    public ImageView o;
    public ku0 p;
    @Nullable
    public ViewGroup q;
    public final ou0 r;

    /* loaded from: classes3.dex */
    public class a extends ou0 {
        public a() {
        }

        @Override // com.baidu.tieba.ou0, com.baidu.tieba.hu0
        public void onEnd(int i) {
            if (NadExpressVideoOperateView.this.b != null && (NadExpressVideoOperateView.this.getTag() instanceof AdBaseModel)) {
                NadExpressVideoOperateView.this.b.f((AdBaseModel) NadExpressVideoOperateView.this.getTag());
            }
        }

        @Override // com.baidu.tieba.ou0, com.baidu.tieba.hu0
        public void onError(int i, int i2, String str) {
            if (NadExpressVideoOperateView.this.b != null && (NadExpressVideoOperateView.this.getTag() instanceof AdBaseModel)) {
                NadExpressVideoOperateView.this.b.e((AdBaseModel) NadExpressVideoOperateView.this.getTag(), str);
            }
        }

        @Override // com.baidu.tieba.ou0, com.baidu.tieba.hu0
        public void onPause() {
            if (NadExpressVideoOperateView.this.b != null && (NadExpressVideoOperateView.this.getTag() instanceof AdBaseModel)) {
                NadExpressVideoOperateView.this.b.c((AdBaseModel) NadExpressVideoOperateView.this.getTag());
            }
        }

        @Override // com.baidu.tieba.ou0, com.baidu.tieba.hu0
        public void onPrepared() {
            if (NadExpressVideoOperateView.this.b != null && (NadExpressVideoOperateView.this.getTag() instanceof AdBaseModel)) {
                NadExpressVideoOperateView.this.b.d((AdBaseModel) NadExpressVideoOperateView.this.getTag());
            }
        }

        @Override // com.baidu.tieba.ou0, com.baidu.tieba.hu0
        public void onResume() {
            if (NadExpressVideoOperateView.this.b != null && (NadExpressVideoOperateView.this.getTag() instanceof AdBaseModel)) {
                NadExpressVideoOperateView.this.b.a((AdBaseModel) NadExpressVideoOperateView.this.getTag());
            }
        }

        @Override // com.baidu.tieba.ou0, com.baidu.tieba.hu0
        public void onStart() {
            if (NadExpressVideoOperateView.this.o != null) {
                NadExpressVideoOperateView.this.o.setVisibility(8);
            }
            TextView textView = NadExpressVideoOperateView.this.n;
            if (textView != null) {
                textView.setVisibility(8);
            }
            if (NadExpressVideoOperateView.this.m != null) {
                NadExpressVideoOperateView.this.m.setVisibility(8);
            }
            if (NadExpressVideoOperateView.this.b != null && (NadExpressVideoOperateView.this.getTag() instanceof AdBaseModel)) {
                NadExpressVideoOperateView.this.b.b((AdBaseModel) NadExpressVideoOperateView.this.getTag());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends ViewOutlineProvider {
        public b() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view2, Outline outline) {
            outline.setRoundRect(new Rect(0, 0, NadExpressVideoOperateView.this.q.getWidth(), NadExpressVideoOperateView.this.q.getHeight()), q61.c.a(NadExpressVideoOperateView.this.getContext(), 8.0f));
        }
    }

    public NadExpressVideoOperateView(Context context) {
        this(context, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchWindowVisibilityChanged(int i) {
        boolean z;
        super.dispatchWindowVisibilityChanged(i);
        if (this.p == null) {
            return;
        }
        if (i == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z && this.p.isPause()) {
            this.p.resume();
        }
        if (!z && this.p.isPlaying()) {
            this.p.pause();
        }
    }

    @Override // com.baidu.nadcore.widget.view.NadExpressNaBaseView
    public void k(Context context) {
        this.m = (AdImageView) findViewById(R.id.nad_feed_template_cover_image);
        this.n = (TextView) findViewById(R.id.nad_feed_template_big_video_length_id);
        this.o = (ImageView) findViewById(R.id.nad_feed_template_big_image_video_icon_id);
        this.q = (ViewGroup) findViewById(R.id.nad_feed_template_video_id);
    }

    public NadExpressVideoOperateView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // com.baidu.nadcore.widget.view.NadExpressNaBaseView
    public void j(LayoutInflater layoutInflater, zr0 zr0Var) {
        int i;
        if (zr0Var != null && zr0Var.a(AdBaseModel.STYLE.VIDEO) != 0) {
            i = zr0Var.a(AdBaseModel.STYLE.VIDEO);
        } else {
            i = R.layout.nad_feed_video;
        }
        layoutInflater.inflate(i, this);
    }

    public NadExpressVideoOperateView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, null);
    }

    public NadExpressVideoOperateView(Context context, AttributeSet attributeSet, int i, zr0 zr0Var) {
        super(context, attributeSet, i, zr0Var);
        this.r = new a();
    }

    public final void G() {
        Resources resources = getContext().getResources();
        int e = q61.c.e(getContext()) - (resources.getDimensionPixelSize(R.dimen.NAD_F_M_W_X001) * 2);
        ViewGroup viewGroup = this.q;
        if (viewGroup != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) viewGroup.getLayoutParams();
            layoutParams.width = e;
            layoutParams.height = Math.round((e / resources.getInteger(R.integer.nad_list_big_image_width)) * resources.getInteger(R.integer.nad_list_big_image_height));
            this.q.setLayoutParams(layoutParams);
            if (Build.VERSION.SDK_INT >= 21) {
                this.q.setOutlineProvider(new b());
                this.q.setClipToOutline(true);
            }
        }
        AdImageView adImageView = this.m;
        if (adImageView != null) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) adImageView.getLayoutParams();
            layoutParams2.width = e;
            layoutParams2.height = Math.round((e / resources.getInteger(R.integer.nad_list_big_image_width)) * resources.getInteger(R.integer.nad_list_big_image_height));
            this.m.setLayoutParams(layoutParams2);
        }
    }

    public final void H() {
        if (!(getTag() instanceof xr0)) {
            AdImageView adImageView = this.m;
            if (adImageView != null) {
                adImageView.setVisibility(0);
            }
            ImageView imageView = this.o;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            TextView textView = this.n;
            if (textView != null && !TextUtils.isEmpty(textView.getText())) {
                this.n.setVisibility(0);
            }
            ViewGroup viewGroup = this.q;
            if (viewGroup != null) {
                viewGroup.setVisibility(8);
                return;
            }
            return;
        }
        xr0 xr0Var = (xr0) getTag();
        if (this.q == null) {
            return;
        }
        if (this.p == null) {
            lu0 lu0Var = new lu0();
            lu0Var.a = 1;
            this.p = ku0.a.b(getContext(), 0, lu0Var);
            u11 u11Var = new u11();
            u11Var.j(1);
            this.p.d(u11Var);
            this.p.attachToContainer(this.q);
            wr0 wr0Var = xr0Var.j;
            if (wr0Var != null) {
                this.p.c(wr0Var);
            }
            this.p.a(this.r);
        }
        if (!this.p.isPlaying()) {
            AdImageView adImageView2 = this.m;
            if (adImageView2 != null) {
                adImageView2.setVisibility(8);
            }
            ImageView imageView2 = this.o;
            if (imageView2 != null) {
                imageView2.setVisibility(8);
            }
            TextView textView2 = this.n;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
            ViewGroup viewGroup2 = this.q;
            if (viewGroup2 != null) {
                viewGroup2.setVisibility(0);
            }
            this.p.start();
        }
    }

    @Override // com.baidu.nadcore.widget.view.NadExpressNaBaseView
    public void m(AdBaseModel adBaseModel) {
        gr0 gr0Var;
        if ((adBaseModel instanceof xr0) && adBaseModel.j != null) {
            xr0 xr0Var = (xr0) adBaseModel;
            TextView textView = this.n;
            if (textView != null) {
                int i = xr0Var.j.c;
                if (i != 0) {
                    this.n.setText(String.format(Locale.ENGLISH, "%02d:%02d", Integer.valueOf((i / 60) % 60), Integer.valueOf(i % 60)));
                    int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.nad_template_m8);
                    int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.nad_template_m10);
                    this.n.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
                    this.n.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    this.n.setCompoundDrawablePadding(dimensionPixelSize2);
                    this.n.setGravity(16);
                    this.n.setVisibility(0);
                } else {
                    textView.setVisibility(8);
                }
            }
            if (this.q != null) {
                if (this.p == null) {
                    lu0 lu0Var = new lu0();
                    lu0Var.a = 1;
                    this.p = ku0.a.b(getContext(), 0, lu0Var);
                    u11 u11Var = new u11();
                    u11Var.j(1);
                    this.p.d(u11Var);
                    this.p.attachToContainer(this.q);
                }
                this.p.c(adBaseModel.j);
                this.p.a(this.r);
            }
            if (this.m != null && xr0Var.f.k.size() > 0 && (gr0Var = (gr0) h31.d(xr0Var.f.k, 0)) != null) {
                this.m.r(gr0Var.a);
                return;
            }
            return;
        }
        setVisibility(8);
    }

    @Override // com.baidu.nadcore.widget.view.NadExpressNaBaseView
    public void n(AdBaseModel adBaseModel) {
        setMaxTitleLine(2);
        TextView textView = this.n;
        if (textView != null) {
            textView.setTextColor(getResources().getColor(R.color.NAD_FC6));
            this.n.setBackground(getResources().getDrawable(R.drawable.nad_feed_video_tips_bg));
        }
        ImageView imageView = this.o;
        if (imageView != null) {
            imageView.setImageDrawable(getResources().getDrawable(R.drawable.nad_feed_video_play));
        }
        G();
    }

    @Override // com.baidu.nadcore.widget.feed.AdFeedBaseView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        H();
    }

    @Override // com.baidu.nadcore.widget.feed.AdFeedBaseView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ku0 ku0Var = this.p;
        if (ku0Var != null) {
            ku0Var.release();
            this.p = null;
        }
    }
}
