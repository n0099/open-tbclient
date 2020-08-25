package com.baidu.tbadk.core.view.spanGroup;

import android.text.Editable;
import android.text.SpannableStringBuilder;
/* loaded from: classes2.dex */
public class b extends Editable.Factory {
    private c exz;

    public b(c cVar) {
        this.exz = cVar;
    }

    @Override // android.text.Editable.Factory
    public Editable newEditable(CharSequence charSequence) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
        spannableStringBuilder.setSpan(this.exz, 0, charSequence.length(), 18);
        return spannableStringBuilder;
    }
}
