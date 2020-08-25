package com.baidu.swan.bdprivate.extensions.loginauthmobile;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.ScaleXSpan;
import android.util.AttributeSet;
import android.widget.TextView;
/* loaded from: classes3.dex */
public class ChangeTextViewSpace extends TextView {
    private float dfX;
    private CharSequence dfY;

    public ChangeTextViewSpace(Context context) {
        super(context);
        this.dfX = 0.0f;
        this.dfY = "";
    }

    public ChangeTextViewSpace(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dfX = 0.0f;
        this.dfY = "";
    }

    public ChangeTextViewSpace(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dfX = 0.0f;
        this.dfY = "";
    }

    public float getSpacing() {
        return this.dfX;
    }

    public void setSpacing(float f) {
        this.dfX = f;
        aGy();
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        this.dfY = charSequence;
        aGy();
    }

    @Override // android.widget.TextView
    public CharSequence getText() {
        return this.dfY;
    }

    private void aGy() {
        if (this != null && this.dfY != null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < this.dfY.length(); i++) {
                sb.append(this.dfY.charAt(i));
                if (i + 1 < this.dfY.length() && (!tj(this.dfY.charAt(i) + "") || !tj(this.dfY.charAt(i + 1) + ""))) {
                    sb.append(" ");
                }
            }
            SpannableString spannableString = new SpannableString(sb.toString());
            if (sb.toString().length() > 1) {
                for (int i2 = 1; i2 < sb.toString().length(); i2 += 2) {
                    spannableString.setSpan(new ScaleXSpan((this.dfX + 1.0f) / 10.0f), i2, i2 + 1, 33);
                }
            }
            super.setText(spannableString, TextView.BufferType.SPANNABLE);
        }
    }

    public static boolean tj(String str) {
        return str.matches("^[a-zA-Z]*");
    }
}
