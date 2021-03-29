package com.baidu.fsg.base.widget.textfilter;

import java.util.List;
/* loaded from: classes2.dex */
public class IDCardEditTextPasteFilter implements IEditTextPasteFilter {

    /* renamed from: a  reason: collision with root package name */
    public static final String f5524a = "IDCardEditTextPasteFilter";

    @Override // com.baidu.fsg.base.widget.textfilter.IEditTextPasteFilter
    public String intercept(String str) {
        List<String> regxParse = EditTextPasteFilterUtils.regxParse(str, "[0-9xX]+");
        StringBuilder sb = new StringBuilder();
        if (regxParse != null && regxParse.size() > 0) {
            for (String str2 : regxParse) {
                sb.append(str2);
            }
        }
        return sb.toString();
    }
}
