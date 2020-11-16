package com.baidu.fsg.base.widget.textfilter;

import android.text.TextUtils;
/* loaded from: classes15.dex */
public class PhoneNumberEditTextPasteFilter implements IEditTextPasteFilter {

    /* renamed from: a  reason: collision with root package name */
    private static final String f1564a = PhoneNumberEditTextPasteFilter.class.getSimpleName();
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
