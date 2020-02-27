package com.baidu.fsg.base.widget.textfilter;

import java.util.List;
/* loaded from: classes4.dex */
public class DigitEditTextPasteFilter implements IEditTextPasteFilter {
    private static final String a = DigitEditTextPasteFilter.class.getSimpleName();

    @Override // com.baidu.fsg.base.widget.textfilter.IEditTextPasteFilter
    public String intercept(String str) {
        List<String> regxParse = EditTextPasteFilterUtils.regxParse(str, EditTextPasteFilterUtils.REGX_DIGIT);
        return (regxParse == null || regxParse.size() <= 0) ? "" : regxParse.get(0);
    }
}
