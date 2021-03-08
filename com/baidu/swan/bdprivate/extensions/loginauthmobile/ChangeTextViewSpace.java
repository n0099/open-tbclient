package com.baidu.swan.bdprivate.extensions.loginauthmobile;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.ScaleXSpan;
import android.util.AttributeSet;
import android.widget.TextView;
/* loaded from: classes8.dex */
public class ChangeTextViewSpace extends TextView {
    private float dVD;
    private CharSequence dVE;

    public ChangeTextViewSpace(Context context) {
        super(context);
        this.dVD = 0.0f;
        this.dVE = "";
    }

    public ChangeTextViewSpace(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dVD = 0.0f;
        this.dVE = "";
    }

    public ChangeTextViewSpace(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dVD = 0.0f;
        this.dVE = "";
    }

    public float getSpacing() {
        return this.dVD;
    }

    public void setSpacing(float f) {
        this.dVD = f;
        aPH();
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        this.dVE = charSequence;
        aPH();
    }

    @Override // android.widget.TextView
    public CharSequence getText() {
        return this.dVE;
    }

    private void aPH() {
        if (this != null && this.dVE != null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < this.dVE.length(); i++) {
                sb.append(this.dVE.charAt(i));
                if (i + 1 < this.dVE.length() && (!uM(this.dVE.charAt(i) + "") || !uM(this.dVE.charAt(i + 1) + ""))) {
                    sb.append(" ");
                }
            }
            SpannableString spannableString = new SpannableString(sb.toString());
            if (sb.toString().length() > 1) {
                for (int i2 = 1; i2 < sb.toString().length(); i2 += 2) {
                    spannableString.setSpan(new ScaleXSpan((this.dVD + 1.0f) / 10.0f), i2, i2 + 1, 33);
                }
            }
            super.setText(spannableString, TextView.BufferType.SPANNABLE);
        }
    }

    public static boolean uM(String str) {
        return str.matches("^[a-zA-Z]*");
    }
}
