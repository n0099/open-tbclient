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
import com.baidu.nadcore.widget.uiwidget.SimpleAdInfoView;
import com.baidu.tieba.R;
import com.baidu.tieba.wm0;
/* loaded from: classes3.dex */
public class SimpleFeedAdInfoView extends SimpleAdInfoView {
    public TextView j;
    public AppCompatRatingBar k;
    public TextView l;

    public SimpleFeedAdInfoView(@NonNull Context context) {
        this(context, null);
    }

    @Override // com.baidu.nadcore.widget.uiwidget.SimpleAdInfoView
    public void b(AttributeSet attributeSet) {
        super.b(attributeSet);
        this.j = (TextView) findViewById(R.id.nad_operate_ad_name);
        this.k = (AppCompatRatingBar) findViewById(R.id.nad_operate_ad_rating_bar);
        this.l = (TextView) findViewById(R.id.nad_operate_ad_rating_text);
        g();
        setRatingBarViewLP(R.drawable.nad_feed_ad_operate_rating_star_full);
    }

    public void setRatingBarViewLP(int i) {
        Drawable drawable;
        if (this.k == null || (drawable = getResources().getDrawable(i)) == null) {
            return;
        }
        int intrinsicHeight = drawable.getIntrinsicHeight();
        ViewGroup.LayoutParams layoutParams = this.k.getLayoutParams();
        layoutParams.width = -2;
        layoutParams.height = intrinsicHeight;
        this.k.setLayoutParams(layoutParams);
    }

    public SimpleFeedAdInfoView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SimpleFeedAdInfoView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void g() {
        TextView textView = this.j;
        if (textView != null) {
            textView.setTextColor(getResources().getColor(R.color.NAD_FC1));
        }
        AppCompatRatingBar appCompatRatingBar = this.k;
        if (appCompatRatingBar != null) {
            appCompatRatingBar.getProgressDrawable().setColorFilter(getResources().getColor(R.color.NAD_FC74), PorterDuff.Mode.SRC_ATOP);
        }
        TextView textView2 = this.l;
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
    public void setAdInfo(wm0 wm0Var) {
        super.setAdInfo(wm0Var);
        if (this.j != null) {
            if (!TextUtils.isEmpty(wm0Var.c)) {
                this.j.setText(wm0Var.c);
                this.j.setVisibility(0);
            } else {
                this.j.setVisibility(8);
            }
        }
        TextView textView = this.l;
        if (textView != null) {
            double d = wm0Var.e;
            if (d != -1.0d) {
                textView.setText(String.valueOf(d));
                this.l.setVisibility(0);
            } else {
                textView.setVisibility(8);
            }
        }
        AppCompatRatingBar appCompatRatingBar = this.k;
        if (appCompatRatingBar != null) {
            double d2 = wm0Var.e;
            if (d2 != -1.0d) {
                appCompatRatingBar.setRating((float) d2);
                this.k.setVisibility(0);
                return;
            }
            appCompatRatingBar.setVisibility(8);
        }
    }
}
