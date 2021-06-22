package com.baidu.swan.bdprivate.extensions.loginauthmobile;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.ScaleXSpan;
import android.util.AttributeSet;
import android.widget.TextView;
/* loaded from: classes3.dex */
public class ChangeTextViewSpace extends TextView {

    /* renamed from: e  reason: collision with root package name */
    public float f11558e;

    /* renamed from: f  reason: collision with root package name */
    public CharSequence f11559f;

    public ChangeTextViewSpace(Context context) {
        super(context);
        this.f11558e = 0.0f;
        this.f11559f = "";
    }

    public static boolean b(String str) {
        return str.matches("^[a-zA-Z]*");
    }

    public final void a() {
        if (this.f11559f == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        while (i2 < this.f11559f.length()) {
            sb.append(this.f11559f.charAt(i2));
            int i3 = i2 + 1;
            if (i3 < this.f11559f.length()) {
                if (b(this.f11559f.charAt(i2) + "")) {
                    if (b(this.f11559f.charAt(i3) + "")) {
                    }
                }
                sb.append(" ");
            }
            i2 = i3;
        }
        SpannableString spannableString = new SpannableString(sb.toString());
        if (sb.toString().length() > 1) {
            for (int i4 = 1; i4 < sb.toString().length(); i4 += 2) {
                spannableString.setSpan(new ScaleXSpan((this.f11558e + 1.0f) / 10.0f), i4, i4 + 1, 33);
            }
        }
        super.setText(spannableString, TextView.BufferType.SPANNABLE);
    }

    public float getSpacing() {
        return this.f11558e;
    }

    @Override // android.widget.TextView
    public CharSequence getText() {
        return this.f11559f;
    }

    public void setSpacing(float f2) {
        this.f11558e = f2;
        a();
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        this.f11559f = charSequence;
        a();
    }

    public ChangeTextViewSpace(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11558e = 0.0f;
        this.f11559f = "";
    }

    public ChangeTextViewSpace(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f11558e = 0.0f;
        this.f11559f = "";
    }
}
