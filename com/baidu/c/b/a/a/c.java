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
            i = Integer.parseInt(cVar.bdR);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        switch (i) {
            case 0:
            case 3:
                return (cVar.bdV == null || cVar.bdV.bew == null || TextUtils.isEmpty(cVar.bdV.bew.word)) ? "" : "" + cVar.bdV.bew.word;
            case 1:
            case 2:
            case 4:
                if (cVar.bdV == null || cVar.bdV.bew == null || TextUtils.isEmpty(cVar.bdV.bew.word)) {
                    str = "";
                } else {
                    str = cVar.bdV.bew.word;
                }
                return str + context.getString(a.C0092a.livesdk_pic);
            case 5:
                return "" + context.getString(a.C0092a.livesdk_voice);
            default:
                return "" + context.getString(a.C0092a.livesdk_not_support_msg_type);
        }
    }

    public static String a(Context context, com.baidu.c.a.b.a.c cVar, boolean z) {
        String a = a(context, cVar);
        if (z && !TextUtils.isEmpty(cVar.bdW)) {
            String b = b(context, cVar);
            if (!a.startsWith(b)) {
                return b + a;
            }
            return a;
        }
        return a;
    }

    public static String b(Context context, com.baidu.c.a.b.a.c cVar) {
        return (cVar == null || TextUtils.isEmpty(cVar.bdW)) ? "" : context.getString(a.C0092a.livesdk_reply) + cVar.bdY + " ";
    }

    public static void c(Context context, com.baidu.c.a.b.a.c cVar) {
        if (cVar != null && cVar.bed != null && cVar.bed.bew != null && !TextUtils.isEmpty(cVar.bed.bew.word)) {
            String b = b(context, cVar);
            if (cVar.bed.bew.word.startsWith(b)) {
                cVar.bed.bew.word = cVar.bed.bew.word.replace(b, "");
            }
        }
    }
}
