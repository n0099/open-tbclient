package com.baidu.swan.apps.res.ui.pullrefresh;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.swan.apps.res.ui.DrawableCenterTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.np2;
import com.baidu.tieba.xj3;
/* loaded from: classes4.dex */
public class HeaderRefreshIndicator extends DrawableCenterTextView {
    public boolean n;
    public boolean o;

    public HeaderRefreshIndicator(Context context) {
        this(context, null);
    }

    public HeaderRefreshIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.n = false;
        this.o = false;
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public void i() {
        if (this.n) {
            return;
        }
        this.n = true;
        this.o = np2.M().a();
        j();
        setTextSize(1, 11.0f);
        setCompoundDrawablePadding(xj3.f(getContext(), 5.0f));
        b(0);
    }

    public void k() {
        boolean a = np2.M().a();
        if (this.o != a) {
            j();
            this.o = a;
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        k();
    }

    public void j() {
        setBackground(getResources().getDrawable(R.drawable.obfuscated_res_0x7f0801d7));
        setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f06045d));
        c(getResources().getDrawable(R.drawable.obfuscated_res_0x7f0801d8), 0, xj3.f(getContext(), 11.0f), xj3.f(getContext(), 11.0f));
    }
}
