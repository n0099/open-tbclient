package com.baidu.tbadk.core.atomData;

import android.content.Context;
/* loaded from: classes.dex */
public class bx extends com.baidu.tbadk.core.frameworkData.a {
    private static Class<?> a;
    private static boolean b;

    public bx(Context context, int i) {
        this(context, i, false);
    }

    public bx(Context context, boolean z) {
        this(context, 16, z);
    }

    public bx(Context context) {
        this(context, 16);
    }

    public bx(Context context, int i, boolean z) {
        super(context);
        getIntent().putExtra("showBack", true);
        getIntent().putExtra("NotifiIdKey", i);
        getIntent().addFlags(268435456);
        getIntent().putExtra("is_show_chat", z);
        b = z;
        aw.a = true;
        aw.b = i;
    }

    public static void a(Class<?> cls) {
        a = cls;
    }

    public static String a() {
        if (a == null) {
            return null;
        }
        return a.getName();
    }
}
