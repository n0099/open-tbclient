package com.baidu.g.b.a.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.livesdk.R;
/* loaded from: classes3.dex */
public class c {
    public static String a(Context context, com.baidu.g.a.b.a.c cVar) {
        String str;
        int i = -1;
        try {
            i = Integer.parseInt(cVar.aHJ);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        switch (i) {
            case 0:
            case 3:
                return (cVar.aHN == null || cVar.aHN.aIm == null || TextUtils.isEmpty(cVar.aHN.aIm.word)) ? "" : "" + cVar.aHN.aIm.word;
            case 1:
            case 2:
            case 4:
                if (cVar.aHN == null || cVar.aHN.aIm == null || TextUtils.isEmpty(cVar.aHN.aIm.word)) {
                    str = "";
                } else {
                    str = cVar.aHN.aIm.word;
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
        if (z && !TextUtils.isEmpty(cVar.aHO)) {
            String b = b(context, cVar);
            if (!a.startsWith(b)) {
                return b + a;
            }
            return a;
        }
        return a;
    }

    public static String b(Context context, com.baidu.g.a.b.a.c cVar) {
        return (cVar == null || TextUtils.isEmpty(cVar.aHO)) ? "" : context.getString(R.string.livesdk_reply) + cVar.aHQ + HanziToPinyin.Token.SEPARATOR;
    }

    public static void c(Context context, com.baidu.g.a.b.a.c cVar) {
        if (cVar != null && cVar.aHV != null && cVar.aHV.aIm != null && !TextUtils.isEmpty(cVar.aHV.aIm.word)) {
            String b = b(context, cVar);
            if (cVar.aHV.aIm.word.startsWith(b)) {
                cVar.aHV.aIm.word = cVar.aHV.aIm.word.replace(b, "");
            }
        }
    }
}
