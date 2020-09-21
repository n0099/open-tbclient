package com.baidu.h.b.a.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.h.a;
/* loaded from: classes23.dex */
public class c {
    public static String a(Context context, com.baidu.h.a.b.a.c cVar) {
        String str;
        int i = -1;
        try {
            i = Integer.parseInt(cVar.bAf);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        switch (i) {
            case 0:
            case 3:
                return (cVar.bAj == null || cVar.bAj.bAI == null || TextUtils.isEmpty(cVar.bAj.bAI.word)) ? "" : "" + cVar.bAj.bAI.word;
            case 1:
            case 2:
            case 4:
                if (cVar.bAj == null || cVar.bAj.bAI == null || TextUtils.isEmpty(cVar.bAj.bAI.word)) {
                    str = "";
                } else {
                    str = cVar.bAj.bAI.word;
                }
                return str + context.getString(a.C0131a.livesdk_pic);
            case 5:
                return "" + context.getString(a.C0131a.livesdk_voice);
            default:
                return "" + context.getString(a.C0131a.livesdk_not_support_msg_type);
        }
    }

    public static String a(Context context, com.baidu.h.a.b.a.c cVar, boolean z) {
        String a = a(context, cVar);
        if (z && !TextUtils.isEmpty(cVar.bAk)) {
            String b = b(context, cVar);
            if (!a.startsWith(b)) {
                return b + a;
            }
            return a;
        }
        return a;
    }

    public static String b(Context context, com.baidu.h.a.b.a.c cVar) {
        return (cVar == null || TextUtils.isEmpty(cVar.bAk)) ? "" : context.getString(a.C0131a.livesdk_reply) + cVar.bAm + " ";
    }

    public static void c(Context context, com.baidu.h.a.b.a.c cVar) {
        if (cVar != null && cVar.bAr != null && cVar.bAr.bAI != null && !TextUtils.isEmpty(cVar.bAr.bAI.word)) {
            String b = b(context, cVar);
            if (cVar.bAr.bAI.word.startsWith(b)) {
                cVar.bAr.bAI.word = cVar.bAr.bAI.word.replace(b, "");
            }
        }
    }
}
