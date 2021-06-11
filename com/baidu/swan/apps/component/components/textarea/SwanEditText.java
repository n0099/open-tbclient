package com.baidu.swan.apps.component.components.textarea;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatEditText;
/* loaded from: classes2.dex */
public class SwanEditText extends AppCompatEditText {

    /* renamed from: e  reason: collision with root package name */
    public a f10734e;

    /* loaded from: classes2.dex */
    public interface a {
        void a(int i2, int i3);
    }

    public SwanEditText(Context context) {
        super(context);
        setTextIsSelectable(true);
    }

    @Override // android.widget.TextView
    public void onSelectionChanged(int i2, int i3) {
        super.onSelectionChanged(i2, i3);
        a aVar = this.f10734e;
        if (aVar != null) {
            aVar.a(i2, i3);
        }
    }

    public void setSelectListener(a aVar) {
        this.f10734e = aVar;
    }

    public SwanEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setTextIsSelectable(true);
    }

    public SwanEditText(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        setTextIsSelectable(true);
    }
}
