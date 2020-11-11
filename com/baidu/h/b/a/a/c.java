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
            i = Integer.parseInt(cVar.bUN);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        switch (i) {
            case 0:
            case 3:
                return (cVar.bUR == null || cVar.bUR.bVq == null || TextUtils.isEmpty(cVar.bUR.bVq.word)) ? "" : "" + cVar.bUR.bVq.word;
            case 1:
            case 2:
            case 4:
                if (cVar.bUR == null || cVar.bUR.bVq == null || TextUtils.isEmpty(cVar.bUR.bVq.word)) {
                    str = "";
                } else {
                    str = cVar.bUR.bVq.word;
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
        if (z && !TextUtils.isEmpty(cVar.bUS)) {
            String b = b(context, cVar);
            if (!a2.startsWith(b)) {
                return b + a2;
            }
            return a2;
        }
        return a2;
    }

    public static String b(Context context, com.baidu.h.a.b.a.c cVar) {
        return (cVar == null || TextUtils.isEmpty(cVar.bUS)) ? "" : context.getString(a.C0135a.livesdk_reply) + cVar.bUU + " ";
    }

    public static void c(Context context, com.baidu.h.a.b.a.c cVar) {
        if (cVar != null && cVar.bUZ != null && cVar.bUZ.bVq != null && !TextUtils.isEmpty(cVar.bUZ.bVq.word)) {
            String b = b(context, cVar);
            if (cVar.bUZ.bVq.word.startsWith(b)) {
                cVar.bUZ.bVq.word = cVar.bUZ.bVq.word.replace(b, "");
            }
        }
    }
}
