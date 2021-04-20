package com.baidu.swan.apps.component.components.textarea;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatEditText;
/* loaded from: classes2.dex */
public class SwanEditText extends AppCompatEditText {

    /* renamed from: e  reason: collision with root package name */
    public a f11786e;

    /* loaded from: classes2.dex */
    public interface a {
        void a(int i, int i2);
    }

    public SwanEditText(Context context) {
        super(context);
        setTextIsSelectable(true);
    }

    @Override // android.widget.TextView
    public void onSelectionChanged(int i, int i2) {
        super.onSelectionChanged(i, i2);
        a aVar = this.f11786e;
        if (aVar != null) {
            aVar.a(i, i2);
        }
    }

    public void setSelectListener(a aVar) {
        this.f11786e = aVar;
    }

    public SwanEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setTextIsSelectable(true);
    }

    public SwanEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setTextIsSelectable(true);
    }
}
