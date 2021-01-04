package com.baidu.j.b.a.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.j.a;
/* loaded from: classes10.dex */
public class c {
    public static String a(Context context, com.baidu.j.a.b.a.c cVar) {
        String str;
        int i = -1;
        try {
            i = Integer.parseInt(cVar.cfd);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        switch (i) {
            case 0:
            case 3:
                return (cVar.cfh == null || cVar.cfh.cfG == null || TextUtils.isEmpty(cVar.cfh.cfG.word)) ? "" : "" + cVar.cfh.cfG.word;
            case 1:
            case 2:
            case 4:
                if (cVar.cfh == null || cVar.cfh.cfG == null || TextUtils.isEmpty(cVar.cfh.cfG.word)) {
                    str = "";
                } else {
                    str = cVar.cfh.cfG.word;
                }
                return str + context.getString(a.C0153a.livesdk_pic);
            case 5:
                return "" + context.getString(a.C0153a.livesdk_voice);
            default:
                return "" + context.getString(a.C0153a.livesdk_not_support_msg_type);
        }
    }

    public static String a(Context context, com.baidu.j.a.b.a.c cVar, boolean z) {
        String a2 = a(context, cVar);
        if (z && !TextUtils.isEmpty(cVar.cfi)) {
            String b2 = b(context, cVar);
            if (!a2.startsWith(b2)) {
                return b2 + a2;
            }
            return a2;
        }
        return a2;
    }

    public static String b(Context context, com.baidu.j.a.b.a.c cVar) {
        return (cVar == null || TextUtils.isEmpty(cVar.cfi)) ? "" : context.getString(a.C0153a.livesdk_reply) + cVar.cfk + " ";
    }

    public static void c(Context context, com.baidu.j.a.b.a.c cVar) {
        if (cVar != null && cVar.cfp != null && cVar.cfp.cfG != null && !TextUtils.isEmpty(cVar.cfp.cfG.word)) {
            String b2 = b(context, cVar);
            if (cVar.cfp.cfG.word.startsWith(b2)) {
                cVar.cfp.cfG.word = cVar.cfp.cfG.word.replace(b2, "");
            }
        }
    }
}
