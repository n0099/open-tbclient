package com.baidu.swan.bdprivate.extensions.loginauthmobile;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.ScaleXSpan;
import android.util.AttributeSet;
import android.widget.TextView;
/* loaded from: classes25.dex */
public class ChangeTextViewSpace extends TextView {
    private float dNP;
    private CharSequence dNQ;

    public ChangeTextViewSpace(Context context) {
        super(context);
        this.dNP = 0.0f;
        this.dNQ = "";
    }

    public ChangeTextViewSpace(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dNP = 0.0f;
        this.dNQ = "";
    }

    public ChangeTextViewSpace(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dNP = 0.0f;
        this.dNQ = "";
    }

    public float getSpacing() {
        return this.dNP;
    }

    public void setSpacing(float f) {
        this.dNP = f;
        aQJ();
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        this.dNQ = charSequence;
        aQJ();
    }

    @Override // android.widget.TextView
    public CharSequence getText() {
        return this.dNQ;
    }

    private void aQJ() {
        if (this != null && this.dNQ != null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < this.dNQ.length(); i++) {
                sb.append(this.dNQ.charAt(i));
                if (i + 1 < this.dNQ.length() && (!vy(this.dNQ.charAt(i) + "") || !vy(this.dNQ.charAt(i + 1) + ""))) {
                    sb.append(" ");
                }
            }
            SpannableString spannableString = new SpannableString(sb.toString());
            if (sb.toString().length() > 1) {
                for (int i2 = 1; i2 < sb.toString().length(); i2 += 2) {
                    spannableString.setSpan(new ScaleXSpan((this.dNP + 1.0f) / 10.0f), i2, i2 + 1, 33);
                }
            }
            super.setText(spannableString, TextView.BufferType.SPANNABLE);
        }
    }

    public static boolean vy(String str) {
        return str.matches("^[a-zA-Z]*");
    }
}
