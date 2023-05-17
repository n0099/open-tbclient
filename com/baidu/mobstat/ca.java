package com.baidu.mobstat;

import android.content.Context;
import android.text.TextUtils;
/* loaded from: classes3.dex */
public class ca {
    public static ca a = new ca();
    public static String b = "";

    public static ca a() {
        return a;
    }

    public void a(Context context, final bz bzVar) {
        String a2 = cc.a(context);
        b = a2;
        if (!TextUtils.isEmpty(a2)) {
            if (bzVar != null) {
                bzVar.a(b);
                return;
            }
            return;
        }
        by.a(context, new cb() { // from class: com.baidu.mobstat.ca.1
            @Override // com.baidu.mobstat.cb
            public void a(String str) {
                if (!TextUtils.isEmpty(str)) {
                    String unused = ca.b = str;
                    bz bzVar2 = bzVar;
                    if (bzVar2 != null) {
                        bzVar2.a(ca.b);
                    }
                }
            }
        });
    }
}
