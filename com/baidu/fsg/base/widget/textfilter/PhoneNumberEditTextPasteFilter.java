package com.baidu.fsg.base.widget.textfilter;

import android.text.TextUtils;
/* loaded from: classes2.dex */
public class PhoneNumberEditTextPasteFilter implements IEditTextPasteFilter {
    private static final String a = PhoneNumberEditTextPasteFilter.class.getSimpleName();
    private static final String b = "86";

    @Override // com.baidu.fsg.base.widget.textfilter.IEditTextPasteFilter
    public String intercept(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.startsWith(b)) {
            return str.substring(b.length());
        }
        return str;
    }
}
