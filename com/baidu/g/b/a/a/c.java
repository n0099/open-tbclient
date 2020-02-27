package com.baidu.g.b.a.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.livesdk.R;
/* loaded from: classes3.dex */
public class c {
    public static String a(Context context, com.baidu.g.a.b.a.c cVar) {
        String str;
        int i = -1;
        try {
            i = Integer.parseInt(cVar.aHH);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        switch (i) {
            case 0:
            case 3:
                return (cVar.aHL == null || cVar.aHL.aIk == null || TextUtils.isEmpty(cVar.aHL.aIk.word)) ? "" : "" + cVar.aHL.aIk.word;
            case 1:
            case 2:
            case 4:
                if (cVar.aHL == null || cVar.aHL.aIk == null || TextUtils.isEmpty(cVar.aHL.aIk.word)) {
                    str = "";
                } else {
                    str = cVar.aHL.aIk.word;
                }
                return str + context.getString(R.string.livesdk_pic);
            case 5:
                return "" + context.getString(R.string.livesdk_voice);
            default:
                return "" + context.getString(R.string.livesdk_not_support_msg_type);
        }
    }

    public static String a(Context context, com.baidu.g.a.b.a.c cVar, boolean z) {
        String a = a(context, cVar);
        if (z && !TextUtils.isEmpty(cVar.aHM)) {
            String b = b(context, cVar);
            if (!a.startsWith(b)) {
                return b + a;
            }
            return a;
        }
        return a;
    }

    public static String b(Context context, com.baidu.g.a.b.a.c cVar) {
        return (cVar == null || TextUtils.isEmpty(cVar.aHM)) ? "" : context.getString(R.string.livesdk_reply) + cVar.aHO + HanziToPinyin.Token.SEPARATOR;
    }

    public static void c(Context context, com.baidu.g.a.b.a.c cVar) {
        if (cVar != null && cVar.aHT != null && cVar.aHT.aIk != null && !TextUtils.isEmpty(cVar.aHT.aIk.word)) {
            String b = b(context, cVar);
            if (cVar.aHT.aIk.word.startsWith(b)) {
                cVar.aHT.aIk.word = cVar.aHT.aIk.word.replace(b, "");
            }
        }
    }
}
