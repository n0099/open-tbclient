package com.baidu.swan.apps.component.components.textarea;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatEditText;
/* loaded from: classes8.dex */
public class SwanEditText extends AppCompatEditText {
    private a cNW;

    /* loaded from: classes8.dex */
    public interface a {
        void ab(int i, int i2);
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
        if (this.cNW != null) {
            this.cNW.ab(i, i2);
        }
    }

    public void setSelectListener(a aVar) {
        this.cNW = aVar;
    }
}
