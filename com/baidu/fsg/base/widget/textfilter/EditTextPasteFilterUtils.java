package com.baidu.fsg.base.widget.textfilter;

import android.content.Context;
import android.text.ClipboardManager;
import android.text.TextUtils;
import android.util.AttributeSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes11.dex */
public class EditTextPasteFilterUtils {
    public static final String EDITTEXT_PASTE_INTERCEPTOR_KEY = "textPasteInteceptor";
    public static final String EDITTEXT_PASTE_INTERCEPTOR_SEPERATOR = "\\|";
    public static final String REGX_DIGIT = "[1-9]\\d*[\\.]{0,1}\\d*|0\\.\\d*|\\.\\d*";
    public static final String REGX_EMAIL = "\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";
    public static final String REGX_ID = "[0-9xX]+";
    public static final String REGX_NUMBER = "[0-9]+";
    public static final String regxEmailOrPhone = "\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*|[0-9]+";

    public static List<IEditTextPasteFilter> parseEditTextPasteFilter(AttributeSet attributeSet) {
        if (attributeSet == null) {
            return null;
        }
        return parseEditTextPasteFilter(attributeSet.getAttributeValue(null, EDITTEXT_PASTE_INTERCEPTOR_KEY));
    }

    public static List<IEditTextPasteFilter> parseEditTextPasteFilter(String str) {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            String[] split = str.trim().split(EDITTEXT_PASTE_INTERCEPTOR_SEPERATOR);
            String name = EditTextPasteFilterUtils.class.getPackage().getName();
            int length = split.length;
            for (int i = 0; i < length; i++) {
                try {
                    Object newInstance = Class.forName(name + "." + split[i].trim()).newInstance();
                    if (newInstance != null && (newInstance instanceof IEditTextPasteFilter)) {
                        arrayList.add((IEditTextPasteFilter) newInstance);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
        return arrayList;
    }

    public static String applyEditTextPasteFilters(Context context, List<IEditTextPasteFilter> list) {
        String str;
        ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
        if (clipboardManager == null) {
            return "";
        }
        CharSequence text = clipboardManager.getText();
        if (TextUtils.isEmpty(text)) {
            str = "";
        } else {
            str = text.toString();
        }
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        Iterator<IEditTextPasteFilter> it = list.iterator();
        while (true) {
            String str2 = str;
            if (it.hasNext()) {
                str = it.next().intercept(str2);
            } else {
                return str2;
            }
        }
    }

    public static List<String> regxParse(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        Matcher matcher = Pattern.compile(str2).matcher(str);
        while (matcher.find()) {
            arrayList.add(matcher.group());
        }
        return arrayList;
    }
}
