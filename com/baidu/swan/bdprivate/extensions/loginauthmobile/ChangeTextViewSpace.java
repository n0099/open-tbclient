package com.baidu.swan.bdprivate.extensions.loginauthmobile;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.ScaleXSpan;
import android.util.AttributeSet;
import android.widget.TextView;
/* loaded from: classes8.dex */
public class ChangeTextViewSpace extends TextView {
    private float dRW;
    private CharSequence dRX;

    public ChangeTextViewSpace(Context context) {
        super(context);
        this.dRW = 0.0f;
        this.dRX = "";
    }

    public ChangeTextViewSpace(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dRW = 0.0f;
        this.dRX = "";
    }

    public ChangeTextViewSpace(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dRW = 0.0f;
        this.dRX = "";
    }

    public float getSpacing() {
        return this.dRW;
    }

    public void setSpacing(float f) {
        this.dRW = f;
        aPl();
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        this.dRX = charSequence;
        aPl();
    }

    @Override // android.widget.TextView
    public CharSequence getText() {
        return this.dRX;
    }

    private void aPl() {
        if (this != null && this.dRX != null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < this.dRX.length(); i++) {
                sb.append(this.dRX.charAt(i));
                if (i + 1 < this.dRX.length() && (!um(this.dRX.charAt(i) + "") || !um(this.dRX.charAt(i + 1) + ""))) {
                    sb.append(" ");
                }
            }
            SpannableString spannableString = new SpannableString(sb.toString());
            if (sb.toString().length() > 1) {
                for (int i2 = 1; i2 < sb.toString().length(); i2 += 2) {
                    spannableString.setSpan(new ScaleXSpan((this.dRW + 1.0f) / 10.0f), i2, i2 + 1, 33);
                }
            }
            super.setText(spannableString, TextView.BufferType.SPANNABLE);
        }
    }

    public static boolean um(String str) {
        return str.matches("^[a-zA-Z]*");
    }
}
