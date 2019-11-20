package com.baidu.c.b.a.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.livesdk.R;
/* loaded from: classes6.dex */
public class c {
    public static String a(Context context, com.baidu.c.a.b.a.c cVar) {
        String str;
        int i = -1;
        try {
            i = Integer.parseInt(cVar.auQ);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        switch (i) {
            case 0:
            case 3:
                return (cVar.auU == null || cVar.auU.avt == null || TextUtils.isEmpty(cVar.auU.avt.word)) ? "" : "" + cVar.auU.avt.word;
            case 1:
            case 2:
            case 4:
                if (cVar.auU == null || cVar.auU.avt == null || TextUtils.isEmpty(cVar.auU.avt.word)) {
                    str = "";
                } else {
                    str = cVar.auU.avt.word;
                }
                return str + context.getString(R.string.livesdk_pic);
            case 5:
                return "" + context.getString(R.string.livesdk_voice);
            default:
                return "" + context.getString(R.string.livesdk_not_support_msg_type);
        }
    }

    public static String a(Context context, com.baidu.c.a.b.a.c cVar, boolean z) {
        String a = a(context, cVar);
        if (z && !TextUtils.isEmpty(cVar.auV)) {
            String b = b(context, cVar);
            if (!a.startsWith(b)) {
                return b + a;
            }
            return a;
        }
        return a;
    }

    public static String b(Context context, com.baidu.c.a.b.a.c cVar) {
        return (cVar == null || TextUtils.isEmpty(cVar.auV)) ? "" : context.getString(R.string.livesdk_reply) + cVar.auX + HanziToPinyin.Token.SEPARATOR;
    }

    public static void c(Context context, com.baidu.c.a.b.a.c cVar) {
        if (cVar != null && cVar.avc != null && cVar.avc.avt != null && !TextUtils.isEmpty(cVar.avc.avt.word)) {
            String b = b(context, cVar);
            if (cVar.avc.avt.word.startsWith(b)) {
                cVar.avc.avt.word = cVar.avc.avt.word.replace(b, "");
            }
        }
    }
}
