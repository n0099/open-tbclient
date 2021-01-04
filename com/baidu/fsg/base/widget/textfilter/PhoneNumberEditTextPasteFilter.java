package com.baidu.fsg.base.widget.textfilter;

import android.text.TextUtils;
/* loaded from: classes6.dex */
public class PhoneNumberEditTextPasteFilter implements IEditTextPasteFilter {

    /* renamed from: a  reason: collision with root package name */
    private static final String f2102a = PhoneNumberEditTextPasteFilter.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private static final String f2103b = "86";

    @Override // com.baidu.fsg.base.widget.textfilter.IEditTextPasteFilter
    public String intercept(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.startsWith(f2103b)) {
            return str.substring(f2103b.length());
        }
        return str;
    }
}
