package com.baidu.tbadk.core.view.spanGroup;

import android.text.Editable;
import android.text.SpannableStringBuilder;
/* loaded from: classes.dex */
public class b extends Editable.Factory {
    private c ezJ;

    public b(c cVar) {
        this.ezJ = cVar;
    }

    @Override // android.text.Editable.Factory
    public Editable newEditable(CharSequence charSequence) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
        spannableStringBuilder.setSpan(this.ezJ, 0, charSequence.length(), 18);
        return spannableStringBuilder;
    }
}
