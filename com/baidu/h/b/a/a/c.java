package com.baidu.h.b.a.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.h.a;
/* loaded from: classes18.dex */
public class c {
    public static String a(Context context, com.baidu.h.a.b.a.c cVar) {
        String str;
        int i = -1;
        try {
            i = Integer.parseInt(cVar.bwI);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        switch (i) {
            case 0:
            case 3:
                return (cVar.bwM == null || cVar.bwM.bxl == null || TextUtils.isEmpty(cVar.bwM.bxl.word)) ? "" : "" + cVar.bwM.bxl.word;
            case 1:
            case 2:
            case 4:
                if (cVar.bwM == null || cVar.bwM.bxl == null || TextUtils.isEmpty(cVar.bwM.bxl.word)) {
                    str = "";
                } else {
                    str = cVar.bwM.bxl.word;
                }
                return str + context.getString(a.C0130a.livesdk_pic);
            case 5:
                return "" + context.getString(a.C0130a.livesdk_voice);
            default:
                return "" + context.getString(a.C0130a.livesdk_not_support_msg_type);
        }
    }

    public static String a(Context context, com.baidu.h.a.b.a.c cVar, boolean z) {
        String a = a(context, cVar);
        if (z && !TextUtils.isEmpty(cVar.bwN)) {
            String b = b(context, cVar);
            if (!a.startsWith(b)) {
                return b + a;
            }
            return a;
        }
        return a;
    }

    public static String b(Context context, com.baidu.h.a.b.a.c cVar) {
        return (cVar == null || TextUtils.isEmpty(cVar.bwN)) ? "" : context.getString(a.C0130a.livesdk_reply) + cVar.bwP + " ";
    }

    public static void c(Context context, com.baidu.h.a.b.a.c cVar) {
        if (cVar != null && cVar.bwU != null && cVar.bwU.bxl != null && !TextUtils.isEmpty(cVar.bwU.bxl.word)) {
            String b = b(context, cVar);
            if (cVar.bwU.bxl.word.startsWith(b)) {
                cVar.bwU.bxl.word = cVar.bwU.bxl.word.replace(b, "");
            }
        }
    }
}
