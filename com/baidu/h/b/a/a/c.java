package com.baidu.h.b.a.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.h.a;
/* loaded from: classes15.dex */
public class c {
    public static String a(Context context, com.baidu.h.a.b.a.c cVar) {
        String str;
        int i = -1;
        try {
            i = Integer.parseInt(cVar.bPd);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        switch (i) {
            case 0:
            case 3:
                return (cVar.bPh == null || cVar.bPh.bPG == null || TextUtils.isEmpty(cVar.bPh.bPG.word)) ? "" : "" + cVar.bPh.bPG.word;
            case 1:
            case 2:
            case 4:
                if (cVar.bPh == null || cVar.bPh.bPG == null || TextUtils.isEmpty(cVar.bPh.bPG.word)) {
                    str = "";
                } else {
                    str = cVar.bPh.bPG.word;
                }
                return str + context.getString(a.C0135a.livesdk_pic);
            case 5:
                return "" + context.getString(a.C0135a.livesdk_voice);
            default:
                return "" + context.getString(a.C0135a.livesdk_not_support_msg_type);
        }
    }

    public static String a(Context context, com.baidu.h.a.b.a.c cVar, boolean z) {
        String a2 = a(context, cVar);
        if (z && !TextUtils.isEmpty(cVar.bPi)) {
            String b = b(context, cVar);
            if (!a2.startsWith(b)) {
                return b + a2;
            }
            return a2;
        }
        return a2;
    }

    public static String b(Context context, com.baidu.h.a.b.a.c cVar) {
        return (cVar == null || TextUtils.isEmpty(cVar.bPi)) ? "" : context.getString(a.C0135a.livesdk_reply) + cVar.bPk + " ";
    }

    public static void c(Context context, com.baidu.h.a.b.a.c cVar) {
        if (cVar != null && cVar.bPp != null && cVar.bPp.bPG != null && !TextUtils.isEmpty(cVar.bPp.bPG.word)) {
            String b = b(context, cVar);
            if (cVar.bPp.bPG.word.startsWith(b)) {
                cVar.bPp.bPG.word = cVar.bPp.bPG.word.replace(b, "");
            }
        }
    }
}
