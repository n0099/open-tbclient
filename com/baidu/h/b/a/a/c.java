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
            i = Integer.parseInt(cVar.cfZ);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        switch (i) {
            case 0:
            case 3:
                return (cVar.cgd == null || cVar.cgd.cgC == null || TextUtils.isEmpty(cVar.cgd.cgC.word)) ? "" : "" + cVar.cgd.cgC.word;
            case 1:
            case 2:
            case 4:
                if (cVar.cgd == null || cVar.cgd.cgC == null || TextUtils.isEmpty(cVar.cgd.cgC.word)) {
                    str = "";
                } else {
                    str = cVar.cgd.cgC.word;
                }
                return str + context.getString(a.C0121a.livesdk_pic);
            case 5:
                return "" + context.getString(a.C0121a.livesdk_voice);
            default:
                return "" + context.getString(a.C0121a.livesdk_not_support_msg_type);
        }
    }

    public static String a(Context context, com.baidu.h.a.b.a.c cVar, boolean z) {
        String a2 = a(context, cVar);
        if (z && !TextUtils.isEmpty(cVar.cge)) {
            String b = b(context, cVar);
            if (!a2.startsWith(b)) {
                return b + a2;
            }
            return a2;
        }
        return a2;
    }

    public static String b(Context context, com.baidu.h.a.b.a.c cVar) {
        return (cVar == null || TextUtils.isEmpty(cVar.cge)) ? "" : context.getString(a.C0121a.livesdk_reply) + cVar.cgg + " ";
    }

    public static void c(Context context, com.baidu.h.a.b.a.c cVar) {
        if (cVar != null && cVar.cgl != null && cVar.cgl.cgC != null && !TextUtils.isEmpty(cVar.cgl.cgC.word)) {
            String b = b(context, cVar);
            if (cVar.cgl.cgC.word.startsWith(b)) {
                cVar.cgl.cgC.word = cVar.cgl.cgC.word.replace(b, "");
            }
        }
    }
}
