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
import com.baidu.tieba.br2;
import com.baidu.tieba.d73;
import com.baidu.tieba.e23;
import com.baidu.tieba.id3;
import com.baidu.tieba.v13;
/* loaded from: classes3.dex */
public class LoadingView extends FrameLayout implements d73<LoadingView> {
    public View a;
    public SmoothProgressBar b;
    public TextView c;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.d73
    public LoadingView getLoadingView() {
        return this;
    }

    /* loaded from: classes3.dex */
    public class a implements id3 {
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
        if (v13.e()) {
            view2 = e23.a().d(R.layout.obfuscated_res_0x7f0d00bb);
        } else {
            view2 = null;
        }
        if (view2 != null) {
            addView(view2, 0, new LinearLayout.LayoutParams(-2, getContext().getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f07069c)));
        } else {
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d00bb, (ViewGroup) this, true);
        }
        this.a = findViewById(R.id.root_container);
        this.b = (SmoothProgressBar) findViewById(R.id.loading_bar);
        this.c = (TextView) findViewById(R.id.obfuscated_res_0x7f09168f);
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

    public void setMsg(String str) {
        this.c.setText(str);
    }

    public void setPageResources() {
        View view2 = this.a;
        if (view2 != null) {
            view2.setBackground(view2.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080188));
        }
        SmoothProgressBar smoothProgressBar = this.b;
        if (smoothProgressBar != null) {
            smoothProgressBar.setIndeterminateDrawable(smoothProgressBar.getResources().getDrawable(R.drawable.obfuscated_res_0x7f08018c));
        }
        TextView textView = this.c;
        if (textView != null) {
            textView.setTextColor(textView.getResources().getColor(R.color.obfuscated_res_0x7f060320));
        }
    }
}
