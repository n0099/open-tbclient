package com.baidu.swan.bdprivate.extensions.loginauthmobile;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.ScaleXSpan;
import android.util.AttributeSet;
import android.widget.TextView;
/* loaded from: classes11.dex */
public class ChangeTextViewSpace extends TextView {
    private float cWO;
    private CharSequence cWP;

    public ChangeTextViewSpace(Context context) {
        super(context);
        this.cWO = 0.0f;
        this.cWP = "";
    }

    public ChangeTextViewSpace(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cWO = 0.0f;
        this.cWP = "";
    }

    public ChangeTextViewSpace(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cWO = 0.0f;
        this.cWP = "";
    }

    public float getSpacing() {
        return this.cWO;
    }

    public void setSpacing(float f) {
        this.cWO = f;
        ayp();
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        this.cWP = charSequence;
        ayp();
    }

    @Override // android.widget.TextView
    public CharSequence getText() {
        return this.cWP;
    }

    private void ayp() {
        if (this != null && this.cWP != null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < this.cWP.length(); i++) {
                sb.append(this.cWP.charAt(i));
                if (i + 1 < this.cWP.length() && (!rb(this.cWP.charAt(i) + "") || !rb(this.cWP.charAt(i + 1) + ""))) {
                    sb.append(" ");
                }
            }
            SpannableString spannableString = new SpannableString(sb.toString());
            if (sb.toString().length() > 1) {
                for (int i2 = 1; i2 < sb.toString().length(); i2 += 2) {
                    spannableString.setSpan(new ScaleXSpan((this.cWO + 1.0f) / 10.0f), i2, i2 + 1, 33);
                }
            }
            super.setText(spannableString, TextView.BufferType.SPANNABLE);
        }
    }

    public static boolean rb(String str) {
        return str.matches("^[a-zA-Z]*");
    }
}
