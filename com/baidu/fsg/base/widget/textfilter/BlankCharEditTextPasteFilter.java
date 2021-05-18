package com.baidu.fsg.base.widget.textfilter;

import android.text.TextUtils;
/* loaded from: classes2.dex */
public class BlankCharEditTextPasteFilter implements IEditTextPasteFilter {

    /* renamed from: a  reason: collision with root package name */
    public static final String f5560a = "BlankCharEditTextPasteFilter";

    @Override // com.baidu.fsg.base.widget.textfilter.IEditTextPasteFilter
    public String intercept(String str) {
        return !TextUtils.isEmpty(str) ? str.replaceAll("\\s", "") : "";
    }
}
