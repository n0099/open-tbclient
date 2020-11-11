package com.baidu.tbadk.core.view.spanGroup;

import android.text.Editable;
import android.text.SpannableStringBuilder;
/* loaded from: classes.dex */
public class b extends Editable.Factory {
    private c fab;

    public b(c cVar) {
        this.fab = cVar;
    }

    @Override // android.text.Editable.Factory
    public Editable newEditable(CharSequence charSequence) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
        spannableStringBuilder.setSpan(this.fab, 0, charSequence.length(), 18);
        return spannableStringBuilder;
    }
}
