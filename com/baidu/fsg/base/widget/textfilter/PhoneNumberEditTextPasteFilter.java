package com.baidu.fsg.base.widget.textfilter;

import android.text.TextUtils;
/* loaded from: classes5.dex */
public class PhoneNumberEditTextPasteFilter implements IEditTextPasteFilter {

    /* renamed from: a  reason: collision with root package name */
    private static final String f2053a = PhoneNumberEditTextPasteFilter.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private static final String f2054b = "86";

    @Override // com.baidu.fsg.base.widget.textfilter.IEditTextPasteFilter
    public String intercept(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.startsWith(f2054b)) {
            return str.substring(f2054b.length());
        }
        return str;
    }
}
