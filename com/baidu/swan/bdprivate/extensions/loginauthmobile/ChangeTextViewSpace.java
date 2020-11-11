package com.baidu.swan.bdprivate.extensions.loginauthmobile;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.ScaleXSpan;
import android.util.AttributeSet;
import android.widget.TextView;
/* loaded from: classes8.dex */
public class ChangeTextViewSpace extends TextView {
    private CharSequence dIA;
    private float dIz;

    public ChangeTextViewSpace(Context context) {
        super(context);
        this.dIz = 0.0f;
        this.dIA = "";
    }

    public ChangeTextViewSpace(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dIz = 0.0f;
        this.dIA = "";
    }

    public ChangeTextViewSpace(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dIz = 0.0f;
        this.dIA = "";
    }

    public float getSpacing() {
        return this.dIz;
    }

    public void setSpacing(float f) {
        this.dIz = f;
        aOl();
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        this.dIA = charSequence;
        aOl();
    }

    @Override // android.widget.TextView
    public CharSequence getText() {
        return this.dIA;
    }

    private void aOl() {
        if (this != null && this.dIA != null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < this.dIA.length(); i++) {
                sb.append(this.dIA.charAt(i));
                if (i + 1 < this.dIA.length() && (!uW(this.dIA.charAt(i) + "") || !uW(this.dIA.charAt(i + 1) + ""))) {
                    sb.append(" ");
                }
            }
            SpannableString spannableString = new SpannableString(sb.toString());
            if (sb.toString().length() > 1) {
                for (int i2 = 1; i2 < sb.toString().length(); i2 += 2) {
                    spannableString.setSpan(new ScaleXSpan((this.dIz + 1.0f) / 10.0f), i2, i2 + 1, 33);
                }
            }
            super.setText(spannableString, TextView.BufferType.SPANNABLE);
        }
    }

    public static boolean uW(String str) {
        return str.matches("^[a-zA-Z]*");
    }
}
