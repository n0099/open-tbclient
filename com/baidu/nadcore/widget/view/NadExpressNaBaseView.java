package com.baidu.nadcore.widget.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.widget.feed.AdFeedBaseView;
import com.baidu.nadcore.widget.uitemplate.NadExpressBottomView;
import com.baidu.tieba.R;
import com.baidu.tieba.m81;
import com.baidu.tieba.n81;
import com.baidu.tieba.on0;
import com.baidu.tieba.x81;
import com.baidu.tieba.y81;
/* loaded from: classes3.dex */
public abstract class NadExpressNaBaseView extends AdFeedBaseView {
    @Nullable
    public TextView h;
    @Nullable
    public x81 i;
    @Nullable
    public NadExpressBottomView j;

    public abstract void g(LayoutInflater layoutInflater, on0 on0Var);

    @Override // com.baidu.nadcore.widget.feed.AdFeedBaseView
    public View getView() {
        return this;
    }

    public abstract void h(Context context);

    public NadExpressNaBaseView(Context context) {
        this(context, null);
    }

    public void f(Context context) {
        this.h = (TextView) findViewById(R.id.nad_feed_template_base_title_id);
        this.j = (NadExpressBottomView) findViewById(R.id.nad_feed_ad_label_view);
        h(context);
    }

    public void i(AdBaseModel adBaseModel) {
        int i;
        if (adBaseModel != null && this.h != null) {
            on0 on0Var = adBaseModel.p;
            if (on0Var != null && !on0Var.f) {
                return;
            }
            if (adBaseModel.b) {
                i = R.color.NAD_FC4;
            } else {
                i = R.color.NAD_FC1;
            }
            TextView textView = this.h;
            textView.setTextColor(textView.getContext().getResources().getColor(i));
        }
    }

    @Override // com.baidu.nadcore.widget.feed.AdFeedBaseView
    public void onClick(View view2) {
        super.onClick(view2);
        if (getTag() instanceof AdBaseModel) {
            i((AdBaseModel) getTag());
        }
    }

    public void setMaxTitleLine(int i) {
        TextView textView = this.h;
        if (textView != null) {
            textView.setMaxLines(i);
        }
    }

    public void setTitleColor(int i) {
        TextView textView = this.h;
        if (textView != null) {
            textView.setTextColor(i);
        }
    }

    public void setTitleSize(float f) {
        TextView textView = this.h;
        if (textView != null) {
            textView.setTextSize(f);
        }
    }

    @Override // com.baidu.nadcore.widget.feed.AdFeedBaseView
    public void setViewDownloadListener(m81 m81Var) {
        super.setViewDownloadListener(m81Var);
        x81 x81Var = this.i;
        if (x81Var != null) {
            x81Var.c(m81Var);
        }
    }

    @Override // com.baidu.nadcore.widget.feed.AdFeedBaseView
    public void setViewStatChangeListener(n81 n81Var) {
        super.setViewStatChangeListener(n81Var);
        x81 x81Var = this.i;
        if (x81Var != null) {
            x81Var.b(n81Var);
        }
    }

    public NadExpressNaBaseView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setTitleLineSpacing(float f, float f2) {
        TextView textView = this.h;
        if (textView != null) {
            textView.setLineSpacing(f, f2);
        }
    }

    public NadExpressNaBaseView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, null);
    }

    public NadExpressNaBaseView(Context context, AttributeSet attributeSet, int i, @Nullable on0 on0Var) {
        super(context, attributeSet, i);
        g(LayoutInflater.from(context), on0Var);
        f(context);
        new y81(this);
    }

    @Override // com.baidu.nadcore.widget.feed.AdFeedBaseView
    public void b() {
        super.b();
        x81 x81Var = this.i;
        if (x81Var != null) {
            x81Var.a();
        }
    }

    public x81 getOperateBar() {
        return this.i;
    }
}
