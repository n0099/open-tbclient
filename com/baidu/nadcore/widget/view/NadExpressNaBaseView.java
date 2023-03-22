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
import com.baidu.tieba.ec1;
import com.baidu.tieba.fc1;
import com.baidu.tieba.vb1;
import com.baidu.tieba.wb1;
import com.baidu.tieba.xp0;
/* loaded from: classes2.dex */
public abstract class NadExpressNaBaseView extends AdFeedBaseView {
    @NonNull
    public final fc1 i;
    @Nullable
    public TextView j;
    @Nullable
    public ec1 k;
    @Nullable
    public NadExpressBottomView l;

    @Override // com.baidu.nadcore.widget.feed.AdFeedBaseView
    public View getView() {
        return this;
    }

    public abstract void j(LayoutInflater layoutInflater, xp0 xp0Var);

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
        ec1 c = this.i.c(adBaseModel);
        this.k = c;
        if (c != null) {
            c.i(0);
            this.k.update(adBaseModel, this);
            this.k.j();
            vb1 vb1Var = this.c;
            if (vb1Var != null) {
                this.k.h(vb1Var);
            }
            wb1 wb1Var = this.a;
            if (wb1Var != null) {
                this.k.f(wb1Var);
            }
        }
    }

    public void o(AdBaseModel adBaseModel) {
        int i;
        if (adBaseModel != null && this.j != null) {
            xp0 xp0Var = adBaseModel.p;
            if (xp0Var != null && !xp0Var.l) {
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
    public void setViewDownloadListener(vb1 vb1Var) {
        super.setViewDownloadListener(vb1Var);
        ec1 ec1Var = this.k;
        if (ec1Var != null) {
            ec1Var.h(vb1Var);
        }
    }

    @Override // com.baidu.nadcore.widget.feed.AdFeedBaseView
    public void setViewStatChangeListener(wb1 wb1Var) {
        super.setViewStatChangeListener(wb1Var);
        ec1 ec1Var = this.k;
        if (ec1Var != null) {
            ec1Var.f(wb1Var);
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

    public NadExpressNaBaseView(Context context, AttributeSet attributeSet, int i, @Nullable xp0 xp0Var) {
        super(context, attributeSet, i);
        j(LayoutInflater.from(context), xp0Var);
        i(context);
        this.i = new fc1(this);
    }

    @Override // com.baidu.nadcore.widget.feed.AdFeedBaseView
    public void c() {
        super.c();
        ec1 ec1Var = this.k;
        if (ec1Var != null) {
            ec1Var.e();
        }
    }

    public ec1 getOperateBar() {
        return this.k;
    }
}
