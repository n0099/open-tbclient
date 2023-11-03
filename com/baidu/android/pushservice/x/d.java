package com.baidu.android.pushservice.x;

import android.content.Context;
/* loaded from: classes.dex */
public class d {
    public g a(Context context, int i, String str) {
        if (i != 200) {
            switch (i) {
                case 100:
                    return new j(context, i, str);
                case 101:
                    return new e(context, i, str);
                case 102:
                    return new b(context, i, str);
                case 103:
                    return new f(context, i, str);
                case 104:
                    return new c(context, i, str);
                default:
                    return null;
            }
        }
        return new i(context, i, str);
    }
}
