package com.baidu.fsg.base.widget.textfilter;

import android.text.TextUtils;
/* loaded from: classes2.dex */
public class PhoneNumberEditTextPasteFilter implements IEditTextPasteFilter {

    /* renamed from: a  reason: collision with root package name */
    public static final String f5561a = "PhoneNumberEditTextPasteFilter";

    /* renamed from: b  reason: collision with root package name */
    public static final String f5562b = "86";

    @Override // com.baidu.fsg.base.widget.textfilter.IEditTextPasteFilter
    public String intercept(String str) {
        return TextUtils.isEmpty(str) ? "" : str.startsWith("86") ? str.substring(2) : str;
    }
}
