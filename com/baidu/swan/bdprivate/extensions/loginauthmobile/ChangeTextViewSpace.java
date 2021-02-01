package com.baidu.swan.bdprivate.extensions.loginauthmobile;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.ScaleXSpan;
import android.util.AttributeSet;
import android.widget.TextView;
/* loaded from: classes9.dex */
public class ChangeTextViewSpace extends TextView {
    private float dUc;
    private CharSequence dUd;

    public ChangeTextViewSpace(Context context) {
        super(context);
        this.dUc = 0.0f;
        this.dUd = "";
    }

    public ChangeTextViewSpace(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dUc = 0.0f;
        this.dUd = "";
    }

    public ChangeTextViewSpace(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dUc = 0.0f;
        this.dUd = "";
    }

    public float getSpacing() {
        return this.dUc;
    }

    public void setSpacing(float f) {
        this.dUc = f;
        aPE();
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        this.dUd = charSequence;
        aPE();
    }

    @Override // android.widget.TextView
    public CharSequence getText() {
        return this.dUd;
    }

    private void aPE() {
        if (this != null && this.dUd != null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < this.dUd.length(); i++) {
                sb.append(this.dUd.charAt(i));
                if (i + 1 < this.dUd.length() && (!uF(this.dUd.charAt(i) + "") || !uF(this.dUd.charAt(i + 1) + ""))) {
                    sb.append(" ");
                }
            }
            SpannableString spannableString = new SpannableString(sb.toString());
            if (sb.toString().length() > 1) {
                for (int i2 = 1; i2 < sb.toString().length(); i2 += 2) {
                    spannableString.setSpan(new ScaleXSpan((this.dUc + 1.0f) / 10.0f), i2, i2 + 1, 33);
                }
            }
            super.setText(spannableString, TextView.BufferType.SPANNABLE);
        }
    }

    public static boolean uF(String str) {
        return str.matches("^[a-zA-Z]*");
    }
}
