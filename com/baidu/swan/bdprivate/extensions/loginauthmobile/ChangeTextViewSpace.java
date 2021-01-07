package com.baidu.swan.bdprivate.extensions.loginauthmobile;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.ScaleXSpan;
import android.util.AttributeSet;
import android.widget.TextView;
/* loaded from: classes9.dex */
public class ChangeTextViewSpace extends TextView {
    private float dWI;
    private CharSequence dWJ;

    public ChangeTextViewSpace(Context context) {
        super(context);
        this.dWI = 0.0f;
        this.dWJ = "";
    }

    public ChangeTextViewSpace(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dWI = 0.0f;
        this.dWJ = "";
    }

    public ChangeTextViewSpace(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dWI = 0.0f;
        this.dWJ = "";
    }

    public float getSpacing() {
        return this.dWI;
    }

    public void setSpacing(float f) {
        this.dWI = f;
        aTf();
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        this.dWJ = charSequence;
        aTf();
    }

    @Override // android.widget.TextView
    public CharSequence getText() {
        return this.dWJ;
    }

    private void aTf() {
        if (this != null && this.dWJ != null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < this.dWJ.length(); i++) {
                sb.append(this.dWJ.charAt(i));
                if (i + 1 < this.dWJ.length() && (!vx(this.dWJ.charAt(i) + "") || !vx(this.dWJ.charAt(i + 1) + ""))) {
                    sb.append(" ");
                }
            }
            SpannableString spannableString = new SpannableString(sb.toString());
            if (sb.toString().length() > 1) {
                for (int i2 = 1; i2 < sb.toString().length(); i2 += 2) {
                    spannableString.setSpan(new ScaleXSpan((this.dWI + 1.0f) / 10.0f), i2, i2 + 1, 33);
                }
            }
            super.setText(spannableString, TextView.BufferType.SPANNABLE);
        }
    }

    public static boolean vx(String str) {
        return str.matches("^[a-zA-Z]*");
    }
}
