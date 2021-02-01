package com.baidu.h.b.a.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.h.a;
/* loaded from: classes10.dex */
public class c {
    public static String a(Context context, com.baidu.h.a.b.a.c cVar) {
        String str;
        int i = -1;
        try {
            i = Integer.parseInt(cVar.cez);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        switch (i) {
            case 0:
            case 3:
                return (cVar.ceD == null || cVar.ceD.cfc == null || TextUtils.isEmpty(cVar.ceD.cfc.word)) ? "" : "" + cVar.ceD.cfc.word;
            case 1:
            case 2:
            case 4:
                if (cVar.ceD == null || cVar.ceD.cfc == null || TextUtils.isEmpty(cVar.ceD.cfc.word)) {
                    str = "";
                } else {
                    str = cVar.ceD.cfc.word;
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
        if (z && !TextUtils.isEmpty(cVar.ceE)) {
            String b2 = b(context, cVar);
            if (!a2.startsWith(b2)) {
                return b2 + a2;
            }
            return a2;
        }
        return a2;
    }

    public static String b(Context context, com.baidu.h.a.b.a.c cVar) {
        return (cVar == null || TextUtils.isEmpty(cVar.ceE)) ? "" : context.getString(a.C0115a.livesdk_reply) + cVar.ceG + " ";
    }

    public static void c(Context context, com.baidu.h.a.b.a.c cVar) {
        if (cVar != null && cVar.ceL != null && cVar.ceL.cfc != null && !TextUtils.isEmpty(cVar.ceL.cfc.word)) {
            String b2 = b(context, cVar);
            if (cVar.ceL.cfc.word.startsWith(b2)) {
                cVar.ceL.cfc.word = cVar.ceL.cfc.word.replace(b2, "");
            }
        }
    }
}
