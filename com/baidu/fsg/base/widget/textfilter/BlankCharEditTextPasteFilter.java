package com.baidu.fsg.base.widget.textfilter;

import android.text.TextUtils;
/* loaded from: classes15.dex */
public class BlankCharEditTextPasteFilter implements IEditTextPasteFilter {
    private static final String a = BlankCharEditTextPasteFilter.class.getSimpleName();

    @Override // com.baidu.fsg.base.widget.textfilter.IEditTextPasteFilter
    public String intercept(String str) {
        return !TextUtils.isEmpty(str) ? str.replaceAll("\\s", "") : "";
    }
}
