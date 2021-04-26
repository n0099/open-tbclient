package com.baidu.fsg.base.widget.textfilter;

import android.text.TextUtils;
import java.util.List;
/* loaded from: classes2.dex */
public class NumberEditTextPasteFilter implements IEditTextPasteFilter {

    /* renamed from: a  reason: collision with root package name */
    public static final String f5709a = "NumberEditTextPasteFilter";

    @Override // com.baidu.fsg.base.widget.textfilter.IEditTextPasteFilter
    public String intercept(String str) {
        List<String> regxParse = EditTextPasteFilterUtils.regxParse(str, "[0-9]+");
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
