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
import com.baidu.tieba.db3;
import com.baidu.tieba.qz2;
import com.baidu.tieba.wo2;
import com.baidu.tieba.y43;
import com.baidu.tieba.zz2;
/* loaded from: classes4.dex */
public class LoadingView extends FrameLayout implements y43<LoadingView> {
    public View a;
    public SmoothProgressBar b;
    public TextView c;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.y43
    public LoadingView getLoadingView() {
        return this;
    }

    /* loaded from: classes4.dex */
    public class a implements db3 {
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
        if (qz2.e()) {
            view2 = zz2.a().d(R.layout.obfuscated_res_0x7f0d00bf);
        } else {
            view2 = null;
        }
        if (view2 != null) {
            addView(view2, 0, new LinearLayout.LayoutParams(-2, getContext().getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f070818)));
        } else {
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d00bf, (ViewGroup) this, true);
        }
        this.a = findViewById(R.id.obfuscated_res_0x7f091fb3);
        this.b = (SmoothProgressBar) findViewById(R.id.obfuscated_res_0x7f091654);
        this.c = (TextView) findViewById(R.id.obfuscated_res_0x7f091767);
        setPageResources();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        wo2.M().f(this, new a());
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        wo2.M().g(this);
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
