package com.baidu.fsg.base.widget.textfilter;

import java.util.List;
/* loaded from: classes2.dex */
public class DigitEditTextPasteFilter implements IEditTextPasteFilter {

    /* renamed from: a  reason: collision with root package name */
    public static final String f5522a = "DigitEditTextPasteFilter";

    @Override // com.baidu.fsg.base.widget.textfilter.IEditTextPasteFilter
    public String intercept(String str) {
        List<String> regxParse = EditTextPasteFilterUtils.regxParse(str, "[1-9]\\d*[\\.]{0,1}\\d*|0\\.\\d*|\\.\\d*");
        return (regxParse == null || regxParse.size() <= 0) ? "" : regxParse.get(0);
    }
}
