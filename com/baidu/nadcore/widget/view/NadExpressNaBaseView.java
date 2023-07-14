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
import com.baidu.tieba.de1;
import com.baidu.tieba.ee1;
import com.baidu.tieba.ps0;
import com.baidu.tieba.ud1;
import com.baidu.tieba.vd1;
/* loaded from: classes3.dex */
public abstract class NadExpressNaBaseView extends AdFeedBaseView {
    @NonNull
    public final ee1 i;
    @Nullable
    public TextView j;
    @Nullable
    public de1 k;
    @Nullable
    public NadExpressBottomView l;

    @Override // com.baidu.nadcore.widget.feed.AdFeedBaseView
    public View getView() {
        return this;
    }

    public abstract void j(LayoutInflater layoutInflater, ps0 ps0Var);

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
        de1 c = this.i.c(adBaseModel);
        this.k = c;
        if (c != null) {
            c.i(0);
            this.k.update(adBaseModel, this);
            this.k.j();
            ud1 ud1Var = this.c;
            if (ud1Var != null) {
                this.k.h(ud1Var);
            }
            vd1 vd1Var = this.a;
            if (vd1Var != null) {
                this.k.f(vd1Var);
            }
        }
    }

    public void o(AdBaseModel adBaseModel) {
        int i;
        if (adBaseModel != null && this.j != null) {
            ps0 ps0Var = adBaseModel.p;
            if (ps0Var != null && !ps0Var.l) {
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
    public void setViewDownloadListener(ud1 ud1Var) {
        super.setViewDownloadListener(ud1Var);
        de1 de1Var = this.k;
        if (de1Var != null) {
            de1Var.h(ud1Var);
        }
    }

    @Override // com.baidu.nadcore.widget.feed.AdFeedBaseView
    public void setViewStatChangeListener(vd1 vd1Var) {
        super.setViewStatChangeListener(vd1Var);
        de1 de1Var = this.k;
        if (de1Var != null) {
            de1Var.f(vd1Var);
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

    public NadExpressNaBaseView(Context context, AttributeSet attributeSet, int i, @Nullable ps0 ps0Var) {
        super(context, attributeSet, i);
        j(LayoutInflater.from(context), ps0Var);
        i(context);
        this.i = new ee1(this);
    }

    @Override // com.baidu.nadcore.widget.feed.AdFeedBaseView
    public void c() {
        super.c();
        de1 de1Var = this.k;
        if (de1Var != null) {
            de1Var.e();
        }
    }

    public de1 getOperateBar() {
        return this.k;
    }
}
