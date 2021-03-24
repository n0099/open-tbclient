package com.baidu.pass.ecommerce.common.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewParent;
import android.widget.RadioButton;
import android.widget.RadioGroup;
/* loaded from: classes2.dex */
public class CheckedRadioButton extends RadioButton {
    public CheckedRadioButton(Context context) {
        super(context);
    }

    @Override // android.widget.RadioButton, android.widget.CompoundButton, android.widget.Checkable
    public void toggle() {
        ViewParent parent;
        setChecked(!isChecked());
        if (isChecked() || (parent = getParent()) == null || !(parent instanceof RadioGroup)) {
            return;
        }
        ((RadioGroup) parent).clearCheck();
    }

    public CheckedRadioButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CheckedRadioButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
