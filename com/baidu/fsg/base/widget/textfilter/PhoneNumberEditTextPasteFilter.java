package com.baidu.fsg.base.widget.textfilter;

import android.text.TextUtils;
/* loaded from: classes6.dex */
public class PhoneNumberEditTextPasteFilter implements IEditTextPasteFilter {

    /* renamed from: a  reason: collision with root package name */
    private static final String f2103a = PhoneNumberEditTextPasteFilter.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private static final String f2104b = "86";

    @Override // com.baidu.fsg.base.widget.textfilter.IEditTextPasteFilter
    public String intercept(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.startsWith(f2104b)) {
            return str.substring(f2104b.length());
        }
        return str;
    }
}
