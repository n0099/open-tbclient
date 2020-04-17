package com.baidu.c.b.a.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.c.a;
/* loaded from: classes6.dex */
public class c {
    public static String a(Context context, com.baidu.c.a.b.a.c cVar) {
        String str;
        int i = -1;
        try {
            i = Integer.parseInt(cVar.bdM);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        switch (i) {
            case 0:
            case 3:
                return (cVar.bdQ == null || cVar.bdQ.beq == null || TextUtils.isEmpty(cVar.bdQ.beq.word)) ? "" : "" + cVar.bdQ.beq.word;
            case 1:
            case 2:
            case 4:
                if (cVar.bdQ == null || cVar.bdQ.beq == null || TextUtils.isEmpty(cVar.bdQ.beq.word)) {
                    str = "";
                } else {
                    str = cVar.bdQ.beq.word;
                }
                return str + context.getString(a.C0071a.livesdk_pic);
            case 5:
                return "" + context.getString(a.C0071a.livesdk_voice);
            default:
                return "" + context.getString(a.C0071a.livesdk_not_support_msg_type);
        }
    }

    public static String a(Context context, com.baidu.c.a.b.a.c cVar, boolean z) {
        String a = a(context, cVar);
        if (z && !TextUtils.isEmpty(cVar.bdR)) {
            String b = b(context, cVar);
            if (!a.startsWith(b)) {
                return b + a;
            }
            return a;
        }
        return a;
    }

    public static String b(Context context, com.baidu.c.a.b.a.c cVar) {
        return (cVar == null || TextUtils.isEmpty(cVar.bdR)) ? "" : context.getString(a.C0071a.livesdk_reply) + cVar.bdT + " ";
    }

    public static void c(Context context, com.baidu.c.a.b.a.c cVar) {
        if (cVar != null && cVar.bdY != null && cVar.bdY.beq != null && !TextUtils.isEmpty(cVar.bdY.beq.word)) {
            String b = b(context, cVar);
            if (cVar.bdY.beq.word.startsWith(b)) {
                cVar.bdY.beq.word = cVar.bdY.beq.word.replace(b, "");
            }
        }
    }
}
