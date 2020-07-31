package com.baidu.d.b.a.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.d.a;
/* loaded from: classes4.dex */
public class c {
    public static String a(Context context, com.baidu.d.a.b.a.c cVar) {
        String str;
        int i = -1;
        try {
            i = Integer.parseInt(cVar.bqP);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        switch (i) {
            case 0:
            case 3:
                return (cVar.bqT == null || cVar.bqT.brs == null || TextUtils.isEmpty(cVar.bqT.brs.word)) ? "" : "" + cVar.bqT.brs.word;
            case 1:
            case 2:
            case 4:
                if (cVar.bqT == null || cVar.bqT.brs == null || TextUtils.isEmpty(cVar.bqT.brs.word)) {
                    str = "";
                } else {
                    str = cVar.bqT.brs.word;
                }
                return str + context.getString(a.C0112a.livesdk_pic);
            case 5:
                return "" + context.getString(a.C0112a.livesdk_voice);
            default:
                return "" + context.getString(a.C0112a.livesdk_not_support_msg_type);
        }
    }

    public static String a(Context context, com.baidu.d.a.b.a.c cVar, boolean z) {
        String a = a(context, cVar);
        if (z && !TextUtils.isEmpty(cVar.bqU)) {
            String b = b(context, cVar);
            if (!a.startsWith(b)) {
                return b + a;
            }
            return a;
        }
        return a;
    }

    public static String b(Context context, com.baidu.d.a.b.a.c cVar) {
        return (cVar == null || TextUtils.isEmpty(cVar.bqU)) ? "" : context.getString(a.C0112a.livesdk_reply) + cVar.bqW + " ";
    }

    public static void c(Context context, com.baidu.d.a.b.a.c cVar) {
        if (cVar != null && cVar.brb != null && cVar.brb.brs != null && !TextUtils.isEmpty(cVar.brb.brs.word)) {
            String b = b(context, cVar);
            if (cVar.brb.brs.word.startsWith(b)) {
                cVar.brb.brs.word = cVar.brb.brs.word.replace(b, "");
            }
        }
    }
}
