package com.baidu.swan.bdprivate.extensions.loginauthmobile;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.ScaleXSpan;
import android.util.AttributeSet;
import android.widget.TextView;
/* loaded from: classes4.dex */
public class ChangeTextViewSpace extends TextView {
    public float a;
    public CharSequence b;

    public ChangeTextViewSpace(Context context) {
        super(context);
        this.a = 0.0f;
        this.b = "";
    }

    public static boolean b(String str) {
        return str.matches("^[a-zA-Z]*");
    }

    public void setSpacing(float f) {
        this.a = f;
        a();
    }

    public ChangeTextViewSpace(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = 0.0f;
        this.b = "";
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        this.b = charSequence;
        a();
    }

    public ChangeTextViewSpace(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = 0.0f;
        this.b = "";
    }

    public final void a() {
        if (this.b == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < this.b.length()) {
            sb.append(this.b.charAt(i));
            int i2 = i + 1;
            if (i2 < this.b.length()) {
                if (b(this.b.charAt(i) + "")) {
                    if (b(this.b.charAt(i2) + "")) {
                    }
                }
                sb.append(" ");
            }
            i = i2;
        }
        SpannableString spannableString = new SpannableString(sb.toString());
        if (sb.toString().length() > 1) {
            for (int i3 = 1; i3 < sb.toString().length(); i3 += 2) {
                spannableString.setSpan(new ScaleXSpan((this.a + 1.0f) / 10.0f), i3, i3 + 1, 33);
            }
        }
        super.setText(spannableString, TextView.BufferType.SPANNABLE);
    }

    public float getSpacing() {
        return this.a;
    }

    @Override // android.widget.TextView
    public CharSequence getText() {
        return this.b;
    }
}
