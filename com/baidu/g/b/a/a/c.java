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
            i = Integer.parseInt(cVar.aHI);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        switch (i) {
            case 0:
            case 3:
                return (cVar.aHM == null || cVar.aHM.aIl == null || TextUtils.isEmpty(cVar.aHM.aIl.word)) ? "" : "" + cVar.aHM.aIl.word;
            case 1:
            case 2:
            case 4:
                if (cVar.aHM == null || cVar.aHM.aIl == null || TextUtils.isEmpty(cVar.aHM.aIl.word)) {
                    str = "";
                } else {
                    str = cVar.aHM.aIl.word;
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
        if (z && !TextUtils.isEmpty(cVar.aHN)) {
            String b = b(context, cVar);
            if (!a.startsWith(b)) {
                return b + a;
            }
            return a;
        }
        return a;
    }

    public static String b(Context context, com.baidu.g.a.b.a.c cVar) {
        return (cVar == null || TextUtils.isEmpty(cVar.aHN)) ? "" : context.getString(R.string.livesdk_reply) + cVar.aHP + HanziToPinyin.Token.SEPARATOR;
    }

    public static void c(Context context, com.baidu.g.a.b.a.c cVar) {
        if (cVar != null && cVar.aHU != null && cVar.aHU.aIl != null && !TextUtils.isEmpty(cVar.aHU.aIl.word)) {
            String b = b(context, cVar);
            if (cVar.aHU.aIl.word.startsWith(b)) {
                cVar.aHU.aIl.word = cVar.aHU.aIl.word.replace(b, "");
            }
        }
    }
}
