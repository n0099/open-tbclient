package com.baidu.h.b.a.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.h.a;
/* loaded from: classes9.dex */
public class c {
    public static String a(Context context, com.baidu.h.a.b.a.c cVar) {
        String str;
        int i = -1;
        try {
            i = Integer.parseInt(cVar.can);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        switch (i) {
            case 0:
            case 3:
                return (cVar.car == null || cVar.car.caQ == null || TextUtils.isEmpty(cVar.car.caQ.word)) ? "" : "" + cVar.car.caQ.word;
            case 1:
            case 2:
            case 4:
                if (cVar.car == null || cVar.car.caQ == null || TextUtils.isEmpty(cVar.car.caQ.word)) {
                    str = "";
                } else {
                    str = cVar.car.caQ.word;
                }
                return str + context.getString(a.C0115a.livesdk_pic);
            case 5:
                return "" + context.getString(a.C0115a.livesdk_voice);
            default:
                return "" + context.getString(a.C0115a.livesdk_not_support_msg_type);
        }
    }

    public static String a(Context context, com.baidu.h.a.b.a.c cVar, boolean z) {
        String a2 = a(context, cVar);
        if (z && !TextUtils.isEmpty(cVar.cas)) {
            String b2 = b(context, cVar);
            if (!a2.startsWith(b2)) {
                return b2 + a2;
            }
            return a2;
        }
        return a2;
    }

    public static String b(Context context, com.baidu.h.a.b.a.c cVar) {
        return (cVar == null || TextUtils.isEmpty(cVar.cas)) ? "" : context.getString(a.C0115a.livesdk_reply) + cVar.cau + " ";
    }

    public static void c(Context context, com.baidu.h.a.b.a.c cVar) {
        if (cVar != null && cVar.caz != null && cVar.caz.caQ != null && !TextUtils.isEmpty(cVar.caz.caQ.word)) {
            String b2 = b(context, cVar);
            if (cVar.caz.caQ.word.startsWith(b2)) {
                cVar.caz.caQ.word = cVar.caz.caQ.word.replace(b2, "");
            }
        }
    }
}
