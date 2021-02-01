package com.baidu.live.view.emojiview;

import android.content.Context;
import android.content.res.Resources;
import android.text.Spannable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.EditText;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes11.dex */
public class d {
    public static Spannable a(Context context, Spannable spannable, int i, int i2, int i3) {
        b.bw(context);
        int length = spannable.length();
        HashMap hashMap = new HashMap();
        c[] cVarArr = (c[]) spannable.getSpans(0, length, c.class);
        for (int i4 = 0; i4 < cVarArr.length; i4++) {
            hashMap.put(Integer.valueOf(spannable.getSpanStart(cVarArr[i4])), Integer.valueOf(spannable.getSpanEnd(cVarArr[i4])));
        }
        Matcher matcher = Pattern.compile("\\[([一-龥\\w])+\\]").matcher(spannable);
        while (matcher.find()) {
            Integer num = (Integer) hashMap.get(Integer.valueOf(matcher.start()));
            if (num == null || num.intValue() != matcher.end()) {
                String group = matcher.group();
                String str = "";
                Integer num2 = b.XP().get(group);
                int i5 = -1;
                if (num2 != null && num2.intValue() >= 0) {
                    i5 = num2.intValue();
                } else {
                    String str2 = b.XQ().get(group);
                    if (TextUtils.isEmpty(str2)) {
                        i5 = iq(group.replaceAll("\\[jx]|\\[/jx]", ""));
                        str = str2;
                    } else {
                        str = str2;
                    }
                }
                if (i5 > 0 || !TextUtils.isEmpty(str)) {
                    spannable.setSpan(new c(context, i5, str, i, i2, i3), matcher.start(), matcher.end(), 33);
                }
            }
        }
        return spannable;
    }

    public static void b(EditText editText, String str) {
        if (editText != null && str != null) {
            editText.getText().toString();
            int selectionStart = editText.getSelectionStart();
            int selectionEnd = editText.getSelectionEnd();
            if (selectionStart < 0) {
                editText.append(str);
            } else {
                editText.getText().replace(Math.min(selectionStart, selectionEnd), Math.max(selectionStart, selectionEnd), str, 0, str.length());
            }
        }
    }

    public static void b(EditText editText) {
        editText.dispatchKeyEvent(new KeyEvent(0L, 0L, 0, 67, 0, 0, 0, 0, 6));
    }

    public static int iq(String str) {
        Resources resources = TbadkCoreApplication.getInst().getApp().getResources();
        if (TbadkCoreApplication.getInst().isQuanmin()) {
            return resources.getIdentifier(str, "drawable", "com.baidu.minivideo.live");
        }
        return resources.getIdentifier(str, "drawable", TbadkCoreApplication.getInst().getApp().getApplicationInfo().packageName);
    }

    public static int ir(String str) {
        return str.replaceAll("\\[([一-龥\\w])+\\]", "1").length();
    }
}
