package com.baidu.fsg.base.widget.textfilter;

import android.text.TextUtils;
import java.util.List;
/* loaded from: classes11.dex */
public class NumberEditTextPasteFilter implements IEditTextPasteFilter {
    private static final String a = NumberEditTextPasteFilter.class.getSimpleName();

    @Override // com.baidu.fsg.base.widget.textfilter.IEditTextPasteFilter
    public String intercept(String str) {
        List<String> regxParse = EditTextPasteFilterUtils.regxParse(str, EditTextPasteFilterUtils.REGX_NUMBER);
        if (regxParse == null || regxParse.size() <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (String str2 : regxParse) {
            if (!TextUtils.isEmpty(str2)) {
                sb.append(str2);
            }
        }
        return sb.toString();
    }
}
