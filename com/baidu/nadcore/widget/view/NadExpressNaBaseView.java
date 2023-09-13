package com.baidu.nadcore.widget.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.widget.feed.AdFeedBaseView;
import com.baidu.nadcore.widget.uitemplate.NadExpressBottomView;
import com.baidu.tieba.R;
import com.baidu.tieba.gd1;
import com.baidu.tieba.hd1;
import com.baidu.tieba.pd1;
import com.baidu.tieba.qd1;
import com.baidu.tieba.zr0;
/* loaded from: classes3.dex */
public abstract class NadExpressNaBaseView extends AdFeedBaseView {
    @NonNull
    public final qd1 i;
    @Nullable
    public TextView j;
    @Nullable
    public pd1 k;
    @Nullable
    public NadExpressBottomView l;

    @Override // com.baidu.nadcore.widget.feed.AdFeedBaseView
    public View getView() {
        return this;
    }

    public abstract void j(LayoutInflater layoutInflater, zr0 zr0Var);

    public abstract void k(Context context);

    public abstract void m(AdBaseModel adBaseModel);

    public abstract void n(AdBaseModel adBaseModel);

    public NadExpressNaBaseView(Context context) {
        this(context, null);
    }

    public void i(Context context) {
        this.j = (TextView) findViewById(R.id.nad_feed_template_base_title_id);
        this.l = (NadExpressBottomView) findViewById(R.id.nad_feed_ad_label_view);
        k(context);
    }

    public void l(AdBaseModel adBaseModel) {
        pd1 c = this.i.c(adBaseModel);
        this.k = c;
        if (c != null) {
            c.i(0);
            this.k.update(adBaseModel, this);
            this.k.j();
            gd1 gd1Var = this.c;
            if (gd1Var != null) {
                this.k.h(gd1Var);
            }
            hd1 hd1Var = this.a;
            if (hd1Var != null) {
                this.k.f(hd1Var);
            }
        }
    }

    public void o(AdBaseModel adBaseModel) {
        int i;
        if (adBaseModel != null && this.j != null) {
            zr0 zr0Var = adBaseModel.p;
            if (zr0Var != null && !zr0Var.l) {
                return;
            }
            if (adBaseModel.b) {
                i = R.color.NAD_FC4;
            } else {
                i = R.color.NAD_FC1;
            }
            TextView textView = this.j;
            textView.setTextColor(textView.getContext().getResources().getColor(i));
        }
    }

    @Override // com.baidu.nadcore.widget.feed.AdFeedBaseView
    public void onClick(View view2) {
        super.onClick(view2);
        if (getTag() instanceof AdBaseModel) {
            o((AdBaseModel) getTag());
        }
    }

    public void setMaxTitleLine(int i) {
        TextView textView = this.j;
        if (textView != null) {
            textView.setMaxLines(i);
        }
    }

    public void setTitleColor(int i) {
        TextView textView = this.j;
        if (textView != null) {
            textView.setTextColor(i);
        }
    }

    public void setTitleSize(float f) {
        TextView textView = this.j;
        if (textView != null) {
            textView.setTextSize(f);
        }
    }

    @Override // com.baidu.nadcore.widget.feed.AdFeedBaseView
    public void setViewDownloadListener(gd1 gd1Var) {
        super.setViewDownloadListener(gd1Var);
        pd1 pd1Var = this.k;
        if (pd1Var != null) {
            pd1Var.h(gd1Var);
        }
    }

    @Override // com.baidu.nadcore.widget.feed.AdFeedBaseView
    public void setViewStatChangeListener(hd1 hd1Var) {
        super.setViewStatChangeListener(hd1Var);
        pd1 pd1Var = this.k;
        if (pd1Var != null) {
            pd1Var.f(hd1Var);
        }
    }

    @Override // com.baidu.nadcore.widget.feed.AdFeedBaseView
    public void update(@NonNull AdBaseModel adBaseModel) {
        super.update(adBaseModel);
        m(adBaseModel);
        NadExpressBottomView nadExpressBottomView = this.l;
        if (nadExpressBottomView != null) {
            nadExpressBottomView.update(adBaseModel);
        }
        l(adBaseModel);
        n(adBaseModel);
        o(adBaseModel);
        TextView textView = this.j;
        if (textView != null) {
            textView.setText(adBaseModel.f.g);
        }
    }

    public NadExpressNaBaseView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setTitleLineSpacing(float f, float f2) {
        TextView textView = this.j;
        if (textView != null) {
            textView.setLineSpacing(f, f2);
        }
    }

    public NadExpressNaBaseView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, null);
    }

    public NadExpressNaBaseView(Context context, AttributeSet attributeSet, int i, @Nullable zr0 zr0Var) {
        super(context, attributeSet, i);
        j(LayoutInflater.from(context), zr0Var);
        i(context);
        this.i = new qd1(this);
    }

    @Override // com.baidu.nadcore.widget.feed.AdFeedBaseView
    public void c() {
        super.c();
        pd1 pd1Var = this.k;
        if (pd1Var != null) {
            pd1Var.e();
        }
    }

    public pd1 getOperateBar() {
        return this.k;
    }
}
