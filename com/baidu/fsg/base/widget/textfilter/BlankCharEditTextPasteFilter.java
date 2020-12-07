package com.baidu.fsg.base.widget.textfilter;

import android.text.TextUtils;
/* loaded from: classes16.dex */
public class BlankCharEditTextPasteFilter implements IEditTextPasteFilter {

    /* renamed from: a  reason: collision with root package name */
    private static final String f1562a = BlankCharEditTextPasteFilter.class.getSimpleName();

    @Override // com.baidu.fsg.base.widget.textfilter.IEditTextPasteFilter
    public String intercept(String str) {
        return !TextUtils.isEmpty(str) ? str.replaceAll("\\s", "") : "";
    }
}
