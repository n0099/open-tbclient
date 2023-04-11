package com.baidu.swan.apps.res.ui;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import com.baidu.tieba.R;
import com.baidu.tieba.br2;
import com.baidu.tieba.id3;
/* loaded from: classes3.dex */
public class CommonEmptyView extends RelativeLayout {
    public ImageView a;
    public TextView b;
    public TextView c;
    public TextView d;
    public TextView e;
    public FrameLayout f;
    public TextView g;

    /* loaded from: classes3.dex */
    public class a implements id3 {
        public a() {
        }
    }

    public CommonEmptyView(Context context) {
        this(context, null);
    }

    public void setButtonText(int i) {
        this.e.setText(i);
    }

    public void setButtonTextColor(ColorStateList colorStateList) {
        this.e.setTextColor(colorStateList);
    }

    public void setIcon(int i) {
        this.a.setImageDrawable(getResources().getDrawable(i));
    }

    public void setLinkClickListener(View.OnClickListener onClickListener) {
        this.d.setVisibility(0);
        this.d.setOnClickListener(onClickListener);
    }

    public void setSubTitle(int i) {
        this.c.setVisibility(0);
        this.c.setText(i);
        this.c.setTextColor(getContext().getResources().getColor(R.color.obfuscated_res_0x7f060305));
    }

    public void setTextButtonClickListener(View.OnClickListener onClickListener) {
        this.e.setVisibility(0);
        this.e.setOnClickListener(onClickListener);
    }

    public void setTitle(int i) {
        this.b.setText(i);
    }

    public void setTitleColor(int i) {
        this.b.setTextColor(i);
    }

    public CommonEmptyView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CommonEmptyView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    public final void a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d009e, (ViewGroup) this, true);
        setBackground(context.getResources().getDrawable(R.color.obfuscated_res_0x7f060302));
        this.a = (ImageView) findViewById(R.id.obfuscated_res_0x7f0909ac);
        this.b = (TextView) findViewById(R.id.obfuscated_res_0x7f0909b0);
        this.c = (TextView) findViewById(R.id.obfuscated_res_0x7f0909af);
        this.d = (TextView) findViewById(R.id.obfuscated_res_0x7f0909ad);
        this.e = (TextView) findViewById(R.id.obfuscated_res_0x7f0909ab);
        this.f = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f0909aa);
        this.g = (TextView) findViewById(R.id.obfuscated_res_0x7f0909ae);
        setPageResources();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        br2.M().f(this, new a());
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        br2.M().g(this);
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        FrameLayout frameLayout = this.f;
        if (frameLayout != null && frameLayout.getLayoutParams() != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f.getLayoutParams();
            int i = configuration.orientation;
            if (i == 1) {
                layoutParams.bottomMargin = getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f07013c);
            } else if (i == 2) {
                layoutParams.bottomMargin = getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f07013b);
            }
            this.f.setLayoutParams(layoutParams);
        }
    }

    public void setButtonText(String str) {
        this.e.setText(str);
    }

    public void setIcon(Drawable drawable) {
        this.a.setImageDrawable(drawable);
    }

    public void setSubTitle(String str) {
        this.c.setVisibility(0);
        this.c.setText(str);
        this.c.setTextColor(getContext().getResources().getColor(R.color.obfuscated_res_0x7f060305));
    }

    public void setTitle(String str) {
        this.b.setText(str);
    }

    public void setPageResources() {
        setBackgroundColor(-1);
        TextView textView = this.b;
        if (textView != null) {
            textView.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f060307));
        }
        TextView textView2 = this.d;
        if (textView2 != null) {
            textView2.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f060305));
        }
        TextView textView3 = this.e;
        if (textView3 != null) {
            textView3.setBackground(getResources().getDrawable(R.drawable.obfuscated_res_0x7f08014e));
            this.e.setTextColor(AppCompatResources.getColorStateList(getContext(), R.color.obfuscated_res_0x7f060920));
        }
        TextView textView4 = this.c;
        if (textView4 != null) {
            textView4.setTextColor(getContext().getResources().getColor(R.color.obfuscated_res_0x7f060305));
        }
    }
}
