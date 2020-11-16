package com.baidu.swan.bdprivate.extensions.loginauthmobile;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.ScaleXSpan;
import android.util.AttributeSet;
import android.widget.TextView;
/* loaded from: classes7.dex */
public class ChangeTextViewSpace extends TextView {
    private float dGR;
    private CharSequence dGS;

    public ChangeTextViewSpace(Context context) {
        super(context);
        this.dGR = 0.0f;
        this.dGS = "";
    }

    public ChangeTextViewSpace(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dGR = 0.0f;
        this.dGS = "";
    }

    public ChangeTextViewSpace(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dGR = 0.0f;
        this.dGS = "";
    }

    public float getSpacing() {
        return this.dGR;
    }

    public void setSpacing(float f) {
        this.dGR = f;
        aND();
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        this.dGS = charSequence;
        aND();
    }

    @Override // android.widget.TextView
    public CharSequence getText() {
        return this.dGS;
    }

    private void aND() {
        if (this != null && this.dGS != null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < this.dGS.length(); i++) {
                sb.append(this.dGS.charAt(i));
                if (i + 1 < this.dGS.length() && (!uR(this.dGS.charAt(i) + "") || !uR(this.dGS.charAt(i + 1) + ""))) {
                    sb.append(" ");
                }
            }
            SpannableString spannableString = new SpannableString(sb.toString());
            if (sb.toString().length() > 1) {
                for (int i2 = 1; i2 < sb.toString().length(); i2 += 2) {
                    spannableString.setSpan(new ScaleXSpan((this.dGR + 1.0f) / 10.0f), i2, i2 + 1, 33);
                }
            }
            super.setText(spannableString, TextView.BufferType.SPANNABLE);
        }
    }

    public static boolean uR(String str) {
        return str.matches("^[a-zA-Z]*");
    }
}
