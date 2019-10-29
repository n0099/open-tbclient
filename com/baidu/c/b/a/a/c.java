package com.baidu.c.b.a.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.livesdk.R;
/* loaded from: classes6.dex */
public class c {
    public static String a(Context context, com.baidu.c.a.b.a.c cVar) {
        String str;
        int i = -1;
        try {
            i = Integer.parseInt(cVar.avi);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        switch (i) {
            case 0:
            case 3:
                return (cVar.avm == null || cVar.avm.avL == null || TextUtils.isEmpty(cVar.avm.avL.word)) ? "" : "" + cVar.avm.avL.word;
            case 1:
            case 2:
            case 4:
                if (cVar.avm == null || cVar.avm.avL == null || TextUtils.isEmpty(cVar.avm.avL.word)) {
                    str = "";
                } else {
                    str = cVar.avm.avL.word;
                }
                return str + context.getString(R.string.livesdk_pic);
            case 5:
                return "" + context.getString(R.string.livesdk_voice);
            default:
                return "" + context.getString(R.string.livesdk_not_support_msg_type);
        }
    }

    public static String a(Context context, com.baidu.c.a.b.a.c cVar, boolean z) {
        String a = a(context, cVar);
        if (z && !TextUtils.isEmpty(cVar.avn)) {
            String b = b(context, cVar);
            if (!a.startsWith(b)) {
                return b + a;
            }
            return a;
        }
        return a;
    }

    public static String b(Context context, com.baidu.c.a.b.a.c cVar) {
        return (cVar == null || TextUtils.isEmpty(cVar.avn)) ? "" : context.getString(R.string.livesdk_reply) + cVar.avp + HanziToPinyin.Token.SEPARATOR;
    }

    public static void c(Context context, com.baidu.c.a.b.a.c cVar) {
        if (cVar != null && cVar.avu != null && cVar.avu.avL != null && !TextUtils.isEmpty(cVar.avu.avL.word)) {
            String b = b(context, cVar);
            if (cVar.avu.avL.word.startsWith(b)) {
                cVar.avu.avL.word = cVar.avu.avL.word.replace(b, "");
            }
        }
    }
}
