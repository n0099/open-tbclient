package com.baidu.swan.bdprivate.extensions.loginauthmobile;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.ScaleXSpan;
import android.util.AttributeSet;
import android.widget.TextView;
/* loaded from: classes3.dex */
public class ChangeTextViewSpace extends TextView {
    private float dgb;
    private CharSequence dgc;

    public ChangeTextViewSpace(Context context) {
        super(context);
        this.dgb = 0.0f;
        this.dgc = "";
    }

    public ChangeTextViewSpace(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dgb = 0.0f;
        this.dgc = "";
    }

    public ChangeTextViewSpace(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dgb = 0.0f;
        this.dgc = "";
    }

    public float getSpacing() {
        return this.dgb;
    }

    public void setSpacing(float f) {
        this.dgb = f;
        aGy();
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        this.dgc = charSequence;
        aGy();
    }

    @Override // android.widget.TextView
    public CharSequence getText() {
        return this.dgc;
    }

    private void aGy() {
        if (this != null && this.dgc != null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < this.dgc.length(); i++) {
                sb.append(this.dgc.charAt(i));
                if (i + 1 < this.dgc.length() && (!tk(this.dgc.charAt(i) + "") || !tk(this.dgc.charAt(i + 1) + ""))) {
                    sb.append(" ");
                }
            }
            SpannableString spannableString = new SpannableString(sb.toString());
            if (sb.toString().length() > 1) {
                for (int i2 = 1; i2 < sb.toString().length(); i2 += 2) {
                    spannableString.setSpan(new ScaleXSpan((this.dgb + 1.0f) / 10.0f), i2, i2 + 1, 33);
                }
            }
            super.setText(spannableString, TextView.BufferType.SPANNABLE);
        }
    }

    public static boolean tk(String str) {
        return str.matches("^[a-zA-Z]*");
    }
}
