package com.baidu.fsg.base.widget.textfilter;

import java.util.List;
/* loaded from: classes5.dex */
public class IDCardEditTextPasteFilter implements IEditTextPasteFilter {

    /* renamed from: a  reason: collision with root package name */
    private static final String f2051a = IDCardEditTextPasteFilter.class.getSimpleName();

    @Override // com.baidu.fsg.base.widget.textfilter.IEditTextPasteFilter
    public String intercept(String str) {
        List<String> regxParse = EditTextPasteFilterUtils.regxParse(str, EditTextPasteFilterUtils.REGX_ID);
        StringBuilder sb = new StringBuilder();
        if (regxParse != null && regxParse.size() > 0) {
            for (String str2 : regxParse) {
                sb.append(str2);
            }
        }
        return sb.toString();
    }
}
