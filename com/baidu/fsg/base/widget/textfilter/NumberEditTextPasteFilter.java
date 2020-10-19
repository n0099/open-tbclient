package com.baidu.fsg.base.widget.textfilter;

import android.text.TextUtils;
import java.util.List;
/* loaded from: classes16.dex */
public class NumberEditTextPasteFilter implements IEditTextPasteFilter {

    /* renamed from: a  reason: collision with root package name */
    private static final String f1561a = NumberEditTextPasteFilter.class.getSimpleName();

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
