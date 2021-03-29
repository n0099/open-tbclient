package com.baidu.swan.bdprivate.extensions.loginauthmobile;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.ScaleXSpan;
import android.util.AttributeSet;
import android.widget.TextView;
/* loaded from: classes3.dex */
public class ChangeTextViewSpace extends TextView {

    /* renamed from: e  reason: collision with root package name */
    public float f12710e;

    /* renamed from: f  reason: collision with root package name */
    public CharSequence f12711f;

    public ChangeTextViewSpace(Context context) {
        super(context);
        this.f12710e = 0.0f;
        this.f12711f = "";
    }

    public static boolean b(String str) {
        return str.matches("^[a-zA-Z]*");
    }

    public final void a() {
        if (this.f12711f == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < this.f12711f.length()) {
            sb.append(this.f12711f.charAt(i));
            int i2 = i + 1;
            if (i2 < this.f12711f.length()) {
                if (b(this.f12711f.charAt(i) + "")) {
                    if (b(this.f12711f.charAt(i2) + "")) {
                    }
                }
                sb.append(" ");
            }
            i = i2;
        }
        SpannableString spannableString = new SpannableString(sb.toString());
        if (sb.toString().length() > 1) {
            for (int i3 = 1; i3 < sb.toString().length(); i3 += 2) {
                spannableString.setSpan(new ScaleXSpan((this.f12710e + 1.0f) / 10.0f), i3, i3 + 1, 33);
            }
        }
        super.setText(spannableString, TextView.BufferType.SPANNABLE);
    }

    public float getSpacing() {
        return this.f12710e;
    }

    @Override // android.widget.TextView
    public CharSequence getText() {
        return this.f12711f;
    }

    public void setSpacing(float f2) {
        this.f12710e = f2;
        a();
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        this.f12711f = charSequence;
        a();
    }

    public ChangeTextViewSpace(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12710e = 0.0f;
        this.f12711f = "";
    }

    public ChangeTextViewSpace(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f12710e = 0.0f;
        this.f12711f = "";
    }
}
