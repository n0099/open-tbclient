package com.baidu.swan.apps.component.components.textarea;

import android.content.Context;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;
/* loaded from: classes11.dex */
public class SwanEditText extends AppCompatEditText {
    private a bQK;

    /* loaded from: classes11.dex */
    public interface a {
        void ad(int i, int i2);
    }

    public SwanEditText(Context context) {
        super(context);
        setTextIsSelectable(true);
    }

    public SwanEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setTextIsSelectable(true);
    }

    public SwanEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setTextIsSelectable(true);
    }

    @Override // android.widget.TextView
    protected void onSelectionChanged(int i, int i2) {
        super.onSelectionChanged(i, i2);
        if (this.bQK != null) {
            this.bQK.ad(i, i2);
        }
    }

    public void setSelectListener(a aVar) {
        this.bQK = aVar;
    }
}
