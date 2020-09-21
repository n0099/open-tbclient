package com.baidu.swan.bdprivate.extensions.loginauthmobile;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.ScaleXSpan;
import android.util.AttributeSet;
import android.widget.TextView;
/* loaded from: classes3.dex */
public class ChangeTextViewSpace extends TextView {
    private float dib;
    private CharSequence dic;

    public ChangeTextViewSpace(Context context) {
        super(context);
        this.dib = 0.0f;
        this.dic = "";
    }

    public ChangeTextViewSpace(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dib = 0.0f;
        this.dic = "";
    }

    public ChangeTextViewSpace(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dib = 0.0f;
        this.dic = "";
    }

    public float getSpacing() {
        return this.dib;
    }

    public void setSpacing(float f) {
        this.dib = f;
        aHi();
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        this.dic = charSequence;
        aHi();
    }

    @Override // android.widget.TextView
    public CharSequence getText() {
        return this.dic;
    }

    private void aHi() {
        if (this != null && this.dic != null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < this.dic.length(); i++) {
                sb.append(this.dic.charAt(i));
                if (i + 1 < this.dic.length() && (!tD(this.dic.charAt(i) + "") || !tD(this.dic.charAt(i + 1) + ""))) {
                    sb.append(" ");
                }
            }
            SpannableString spannableString = new SpannableString(sb.toString());
            if (sb.toString().length() > 1) {
                for (int i2 = 1; i2 < sb.toString().length(); i2 += 2) {
                    spannableString.setSpan(new ScaleXSpan((this.dib + 1.0f) / 10.0f), i2, i2 + 1, 33);
                }
            }
            super.setText(spannableString, TextView.BufferType.SPANNABLE);
        }
    }

    public static boolean tD(String str) {
        return str.matches("^[a-zA-Z]*");
    }
}
