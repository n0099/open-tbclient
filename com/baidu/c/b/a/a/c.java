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
            i = Integer.parseInt(cVar.blt);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        switch (i) {
            case 0:
            case 3:
                return (cVar.blx == null || cVar.blx.blW == null || TextUtils.isEmpty(cVar.blx.blW.word)) ? "" : "" + cVar.blx.blW.word;
            case 1:
            case 2:
            case 4:
                if (cVar.blx == null || cVar.blx.blW == null || TextUtils.isEmpty(cVar.blx.blW.word)) {
                    str = "";
                } else {
                    str = cVar.blx.blW.word;
                }
                return str + context.getString(a.C0094a.livesdk_pic);
            case 5:
                return "" + context.getString(a.C0094a.livesdk_voice);
            default:
                return "" + context.getString(a.C0094a.livesdk_not_support_msg_type);
        }
    }

    public static String a(Context context, com.baidu.c.a.b.a.c cVar, boolean z) {
        String a = a(context, cVar);
        if (z && !TextUtils.isEmpty(cVar.bly)) {
            String b = b(context, cVar);
            if (!a.startsWith(b)) {
                return b + a;
            }
            return a;
        }
        return a;
    }

    public static String b(Context context, com.baidu.c.a.b.a.c cVar) {
        return (cVar == null || TextUtils.isEmpty(cVar.bly)) ? "" : context.getString(a.C0094a.livesdk_reply) + cVar.blA + " ";
    }

    public static void c(Context context, com.baidu.c.a.b.a.c cVar) {
        if (cVar != null && cVar.blF != null && cVar.blF.blW != null && !TextUtils.isEmpty(cVar.blF.blW.word)) {
            String b = b(context, cVar);
            if (cVar.blF.blW.word.startsWith(b)) {
                cVar.blF.blW.word = cVar.blF.blW.word.replace(b, "");
            }
        }
    }
}
