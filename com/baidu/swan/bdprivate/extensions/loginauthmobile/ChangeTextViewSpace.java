package com.baidu.swan.bdprivate.extensions.loginauthmobile;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.ScaleXSpan;
import android.util.AttributeSet;
import android.widget.TextView;
/* loaded from: classes8.dex */
public class ChangeTextViewSpace extends TextView {
    private float dCH;
    private CharSequence dCI;

    public ChangeTextViewSpace(Context context) {
        super(context);
        this.dCH = 0.0f;
        this.dCI = "";
    }

    public ChangeTextViewSpace(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dCH = 0.0f;
        this.dCI = "";
    }

    public ChangeTextViewSpace(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dCH = 0.0f;
        this.dCI = "";
    }

    public float getSpacing() {
        return this.dCH;
    }

    public void setSpacing(float f) {
        this.dCH = f;
        aLL();
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        this.dCI = charSequence;
        aLL();
    }

    @Override // android.widget.TextView
    public CharSequence getText() {
        return this.dCI;
    }

    private void aLL() {
        if (this != null && this.dCI != null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < this.dCI.length(); i++) {
                sb.append(this.dCI.charAt(i));
                if (i + 1 < this.dCI.length() && (!uI(this.dCI.charAt(i) + "") || !uI(this.dCI.charAt(i + 1) + ""))) {
                    sb.append(" ");
                }
            }
            SpannableString spannableString = new SpannableString(sb.toString());
            if (sb.toString().length() > 1) {
                for (int i2 = 1; i2 < sb.toString().length(); i2 += 2) {
                    spannableString.setSpan(new ScaleXSpan((this.dCH + 1.0f) / 10.0f), i2, i2 + 1, 33);
                }
            }
            super.setText(spannableString, TextView.BufferType.SPANNABLE);
        }
    }

    public static boolean uI(String str) {
        return str.matches("^[a-zA-Z]*");
    }
}
