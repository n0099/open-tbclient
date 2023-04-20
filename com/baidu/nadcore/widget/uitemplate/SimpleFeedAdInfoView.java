package com.baidu.nadcore.widget.uitemplate;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatRatingBar;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.widget.uiwidget.SimpleAdInfoView;
import com.baidu.tieba.R;
import com.baidu.tieba.aq0;
import com.baidu.tieba.zp0;
/* loaded from: classes2.dex */
public class SimpleFeedAdInfoView extends SimpleAdInfoView {
    public TextView i;
    public AppCompatRatingBar j;
    public TextView k;

    public SimpleFeedAdInfoView(@NonNull Context context) {
        this(context, null);
    }

    @Override // com.baidu.nadcore.widget.uiwidget.SimpleAdInfoView
    public void a(AttributeSet attributeSet) {
        super.a(attributeSet);
        this.i = (TextView) findViewById(R.id.nad_operate_ad_name);
        this.j = (AppCompatRatingBar) findViewById(R.id.nad_operate_ad_rating_bar);
        this.k = (TextView) findViewById(R.id.nad_operate_ad_rating_text);
        c();
        setRatingBarViewLP(R.drawable.nad_feed_ad_operate_rating_star_full);
    }

    public void setRatingBarViewLP(int i) {
        Drawable drawable;
        if (this.j == null || (drawable = getResources().getDrawable(i)) == null) {
            return;
        }
        int intrinsicHeight = drawable.getIntrinsicHeight();
        ViewGroup.LayoutParams layoutParams = this.j.getLayoutParams();
        layoutParams.width = -2;
        layoutParams.height = intrinsicHeight;
        this.j.setLayoutParams(layoutParams);
    }

    public void update(AdBaseModel adBaseModel) {
        aq0 aq0Var;
        zp0.a aVar;
        int i;
        if (adBaseModel != null && (aq0Var = adBaseModel.i) != null) {
            setAdInfo(aq0Var);
            c();
            zp0 zp0Var = adBaseModel.p;
            if (zp0Var != null && (aVar = zp0Var.j) != null && (i = aVar.h) != 0) {
                setRatingBarViewLP(i);
            }
        }
    }

    public SimpleFeedAdInfoView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SimpleFeedAdInfoView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void c() {
        TextView textView = this.i;
        if (textView != null) {
            textView.setTextColor(getResources().getColor(R.color.NAD_FC1));
        }
        AppCompatRatingBar appCompatRatingBar = this.j;
        if (appCompatRatingBar != null) {
            appCompatRatingBar.getProgressDrawable().setColorFilter(getResources().getColor(R.color.NAD_FC74), PorterDuff.Mode.SRC_ATOP);
        }
        TextView textView2 = this.k;
        if (textView2 != null) {
            textView2.setTextColor(getResources().getColor(R.color.NAD_FC2));
        }
        TextView textView3 = this.a;
        if (textView3 != null) {
            textView3.setTextColor(getResources().getColor(R.color.NAD_FC2));
        }
        TextView textView4 = this.b;
        if (textView4 != null) {
            textView4.setTextColor(getResources().getColor(R.color.NAD_FC2));
        }
        TextView textView5 = this.c;
        if (textView5 != null) {
            textView5.setTextColor(getResources().getColor(R.color.NAD_FC2));
        }
        TextView textView6 = this.d;
        if (textView6 != null) {
            textView6.setTextColor(getResources().getColor(R.color.NAD_FC2));
        }
    }

    @Override // com.baidu.nadcore.widget.uiwidget.SimpleAdInfoView
    public void setAdInfo(aq0 aq0Var) {
        super.setAdInfo(aq0Var);
        if (this.i != null) {
            if (!TextUtils.isEmpty(aq0Var.c)) {
                this.i.setText(aq0Var.c);
                this.i.setVisibility(0);
            } else {
                this.i.setVisibility(8);
            }
        }
        TextView textView = this.k;
        if (textView != null) {
            double d = aq0Var.e;
            if (d != -1.0d) {
                textView.setText(String.valueOf(d));
                this.k.setVisibility(0);
            } else {
                textView.setVisibility(8);
            }
        }
        AppCompatRatingBar appCompatRatingBar = this.j;
        if (appCompatRatingBar != null) {
            double d2 = aq0Var.e;
            if (d2 != -1.0d) {
                appCompatRatingBar.setRating((float) d2);
                this.j.setVisibility(0);
                return;
            }
            appCompatRatingBar.setVisibility(8);
        }
    }
}
