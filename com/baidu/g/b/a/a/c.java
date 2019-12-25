package com.baidu.g.b.a.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.livesdk.R;
/* loaded from: classes2.dex */
public class c {
    public static String a(Context context, com.baidu.g.a.b.a.c cVar) {
        String str;
        int i = -1;
        try {
            i = Integer.parseInt(cVar.aCI);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        switch (i) {
            case 0:
            case 3:
                return (cVar.aCM == null || cVar.aCM.aDl == null || TextUtils.isEmpty(cVar.aCM.aDl.word)) ? "" : "" + cVar.aCM.aDl.word;
            case 1:
            case 2:
            case 4:
                if (cVar.aCM == null || cVar.aCM.aDl == null || TextUtils.isEmpty(cVar.aCM.aDl.word)) {
                    str = "";
                } else {
                    str = cVar.aCM.aDl.word;
                }
                return str + context.getString(R.string.livesdk_pic);
            case 5:
                return "" + context.getString(R.string.livesdk_voice);
            default:
                return "" + context.getString(R.string.livesdk_not_support_msg_type);
        }
    }

    public static String a(Context context, com.baidu.g.a.b.a.c cVar, boolean z) {
        String a = a(context, cVar);
        if (z && !TextUtils.isEmpty(cVar.aCN)) {
            String b = b(context, cVar);
            if (!a.startsWith(b)) {
                return b + a;
            }
            return a;
        }
        return a;
    }

    public static String b(Context context, com.baidu.g.a.b.a.c cVar) {
        return (cVar == null || TextUtils.isEmpty(cVar.aCN)) ? "" : context.getString(R.string.livesdk_reply) + cVar.aCP + HanziToPinyin.Token.SEPARATOR;
    }

    public static void c(Context context, com.baidu.g.a.b.a.c cVar) {
        if (cVar != null && cVar.aCU != null && cVar.aCU.aDl != null && !TextUtils.isEmpty(cVar.aCU.aDl.word)) {
            String b = b(context, cVar);
            if (cVar.aCU.aDl.word.startsWith(b)) {
                cVar.aCU.aDl.word = cVar.aCU.aDl.word.replace(b, "");
            }
        }
    }
}
