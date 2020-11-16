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
            i = Integer.parseInt(cVar.bTd);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        switch (i) {
            case 0:
            case 3:
                return (cVar.bTh == null || cVar.bTh.bTG == null || TextUtils.isEmpty(cVar.bTh.bTG.word)) ? "" : "" + cVar.bTh.bTG.word;
            case 1:
            case 2:
            case 4:
                if (cVar.bTh == null || cVar.bTh.bTG == null || TextUtils.isEmpty(cVar.bTh.bTG.word)) {
                    str = "";
                } else {
                    str = cVar.bTh.bTG.word;
                }
                return str + context.getString(a.C0133a.livesdk_pic);
            case 5:
                return "" + context.getString(a.C0133a.livesdk_voice);
            default:
                return "" + context.getString(a.C0133a.livesdk_not_support_msg_type);
        }
    }

    public static String a(Context context, com.baidu.h.a.b.a.c cVar, boolean z) {
        String a2 = a(context, cVar);
        if (z && !TextUtils.isEmpty(cVar.bTi)) {
            String b = b(context, cVar);
            if (!a2.startsWith(b)) {
                return b + a2;
            }
            return a2;
        }
        return a2;
    }

    public static String b(Context context, com.baidu.h.a.b.a.c cVar) {
        return (cVar == null || TextUtils.isEmpty(cVar.bTi)) ? "" : context.getString(a.C0133a.livesdk_reply) + cVar.bTk + " ";
    }

    public static void c(Context context, com.baidu.h.a.b.a.c cVar) {
        if (cVar != null && cVar.bTp != null && cVar.bTp.bTG != null && !TextUtils.isEmpty(cVar.bTp.bTG.word)) {
            String b = b(context, cVar);
            if (cVar.bTp.bTG.word.startsWith(b)) {
                cVar.bTp.bTG.word = cVar.bTp.bTG.word.replace(b, "");
            }
        }
    }
}
