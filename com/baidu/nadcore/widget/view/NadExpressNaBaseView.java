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
import com.baidu.tieba.j81;
import com.baidu.tieba.k81;
import com.baidu.tieba.mn0;
import com.baidu.tieba.s81;
import com.baidu.tieba.t81;
/* loaded from: classes3.dex */
public abstract class NadExpressNaBaseView extends AdFeedBaseView {
    @Nullable
    public TextView h;
    @Nullable
    public s81 i;
    @Nullable
    public NadExpressBottomView j;

    public abstract void g(LayoutInflater layoutInflater, mn0 mn0Var);

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
            mn0 mn0Var = adBaseModel.p;
            if (mn0Var != null && !mn0Var.f) {
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
    public void setViewDownloadListener(j81 j81Var) {
        super.setViewDownloadListener(j81Var);
        s81 s81Var = this.i;
        if (s81Var != null) {
            s81Var.c(j81Var);
        }
    }

    @Override // com.baidu.nadcore.widget.feed.AdFeedBaseView
    public void setViewStatChangeListener(k81 k81Var) {
        super.setViewStatChangeListener(k81Var);
        s81 s81Var = this.i;
        if (s81Var != null) {
            s81Var.b(k81Var);
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

    public NadExpressNaBaseView(Context context, AttributeSet attributeSet, int i, @Nullable mn0 mn0Var) {
        super(context, attributeSet, i);
        g(LayoutInflater.from(context), mn0Var);
        f(context);
        new t81(this);
    }

    @Override // com.baidu.nadcore.widget.feed.AdFeedBaseView
    public void b() {
        super.b();
        s81 s81Var = this.i;
        if (s81Var != null) {
            s81Var.a();
        }
    }

    public s81 getOperateBar() {
        return this.i;
    }
}
