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
            i = Integer.parseInt(cVar.bqu);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        switch (i) {
            case 0:
            case 3:
                return (cVar.bqy == null || cVar.bqy.bqX == null || TextUtils.isEmpty(cVar.bqy.bqX.word)) ? "" : "" + cVar.bqy.bqX.word;
            case 1:
            case 2:
            case 4:
                if (cVar.bqy == null || cVar.bqy.bqX == null || TextUtils.isEmpty(cVar.bqy.bqX.word)) {
                    str = "";
                } else {
                    str = cVar.bqy.bqX.word;
                }
                return str + context.getString(a.C0095a.livesdk_pic);
            case 5:
                return "" + context.getString(a.C0095a.livesdk_voice);
            default:
                return "" + context.getString(a.C0095a.livesdk_not_support_msg_type);
        }
    }

    public static String a(Context context, com.baidu.c.a.b.a.c cVar, boolean z) {
        String a = a(context, cVar);
        if (z && !TextUtils.isEmpty(cVar.bqz)) {
            String b = b(context, cVar);
            if (!a.startsWith(b)) {
                return b + a;
            }
            return a;
        }
        return a;
    }

    public static String b(Context context, com.baidu.c.a.b.a.c cVar) {
        return (cVar == null || TextUtils.isEmpty(cVar.bqz)) ? "" : context.getString(a.C0095a.livesdk_reply) + cVar.bqB + " ";
    }

    public static void c(Context context, com.baidu.c.a.b.a.c cVar) {
        if (cVar != null && cVar.bqG != null && cVar.bqG.bqX != null && !TextUtils.isEmpty(cVar.bqG.bqX.word)) {
            String b = b(context, cVar);
            if (cVar.bqG.bqX.word.startsWith(b)) {
                cVar.bqG.bqX.word = cVar.bqG.bqX.word.replace(b, "");
            }
        }
    }
}
