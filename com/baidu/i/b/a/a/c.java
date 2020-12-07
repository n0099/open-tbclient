package com.baidu.i.b.a.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.i.a;
/* loaded from: classes11.dex */
public class c {
    public static String a(Context context, com.baidu.i.a.b.a.c cVar) {
        String str;
        int i = -1;
        try {
            i = Integer.parseInt(cVar.bYt);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        switch (i) {
            case 0:
            case 3:
                return (cVar.bYx == null || cVar.bYx.bYW == null || TextUtils.isEmpty(cVar.bYx.bYW.word)) ? "" : "" + cVar.bYx.bYW.word;
            case 1:
            case 2:
            case 4:
                if (cVar.bYx == null || cVar.bYx.bYW == null || TextUtils.isEmpty(cVar.bYx.bYW.word)) {
                    str = "";
                } else {
                    str = cVar.bYx.bYW.word;
                }
                return str + context.getString(a.C0161a.livesdk_pic);
            case 5:
                return "" + context.getString(a.C0161a.livesdk_voice);
            default:
                return "" + context.getString(a.C0161a.livesdk_not_support_msg_type);
        }
    }

    public static String a(Context context, com.baidu.i.a.b.a.c cVar, boolean z) {
        String a2 = a(context, cVar);
        if (z && !TextUtils.isEmpty(cVar.bYy)) {
            String b = b(context, cVar);
            if (!a2.startsWith(b)) {
                return b + a2;
            }
            return a2;
        }
        return a2;
    }

    public static String b(Context context, com.baidu.i.a.b.a.c cVar) {
        return (cVar == null || TextUtils.isEmpty(cVar.bYy)) ? "" : context.getString(a.C0161a.livesdk_reply) + cVar.bYA + " ";
    }

    public static void c(Context context, com.baidu.i.a.b.a.c cVar) {
        if (cVar != null && cVar.bYF != null && cVar.bYF.bYW != null && !TextUtils.isEmpty(cVar.bYF.bYW.word)) {
            String b = b(context, cVar);
            if (cVar.bYF.bYW.word.startsWith(b)) {
                cVar.bYF.bYW.word = cVar.bYF.bYW.word.replace(b, "");
            }
        }
    }
}
