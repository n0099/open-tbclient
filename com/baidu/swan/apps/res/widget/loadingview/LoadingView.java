package com.baidu.swan.apps.res.widget.loadingview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.swan.apps.res.ui.SmoothProgressBar;
import com.baidu.tieba.R;
import com.baidu.tieba.h53;
import com.baidu.tieba.nu2;
import com.baidu.tieba.pa3;
import com.baidu.tieba.q53;
import com.baidu.tieba.ug3;
/* loaded from: classes4.dex */
public class LoadingView extends FrameLayout implements pa3<LoadingView> {
    public View a;
    public SmoothProgressBar b;
    public TextView c;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pa3
    public LoadingView getLoadingView() {
        return this;
    }

    /* loaded from: classes4.dex */
    public class a implements ug3 {
        public a() {
        }
    }

    public LoadingView(Context context) {
        super(context);
        a();
    }

    public void setMsg(int i) {
        this.c.setText(i);
    }

    public LoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public LoadingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    public void a() {
        View view2;
        if (h53.e()) {
            view2 = q53.a().d(R.layout.obfuscated_res_0x7f0d00c2);
        } else {
            view2 = null;
        }
        if (view2 != null) {
            addView(view2, 0, new LinearLayout.LayoutParams(-2, getContext().getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f07081d)));
        } else {
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d00c2, (ViewGroup) this, true);
        }
        this.a = findViewById(R.id.obfuscated_res_0x7f091fa7);
        this.b = (SmoothProgressBar) findViewById(R.id.obfuscated_res_0x7f09163a);
        this.c = (TextView) findViewById(R.id.obfuscated_res_0x7f09174d);
        setPageResources();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        nu2.M().f(this, new a());
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        nu2.M().g(this);
    }

    public void setMsg(String str) {
        this.c.setText(str);
    }

    public void setPageResources() {
        View view2 = this.a;
        if (view2 != null) {
            view2.setBackground(view2.getResources().getDrawable(R.drawable.obfuscated_res_0x7f0801a2));
        }
        SmoothProgressBar smoothProgressBar = this.b;
        if (smoothProgressBar != null) {
            smoothProgressBar.setIndeterminateDrawable(smoothProgressBar.getResources().getDrawable(R.drawable.obfuscated_res_0x7f0801a6));
        }
        TextView textView = this.c;
        if (textView != null) {
            textView.setTextColor(textView.getResources().getColor(R.color.obfuscated_res_0x7f060445));
        }
    }
}
