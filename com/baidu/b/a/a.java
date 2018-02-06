package com.baidu.b.a;

import android.content.Context;
import com.baidu.b.a.b.b;
import com.baidu.b.a.b.c;
import com.baidu.b.a.b.d;
/* loaded from: classes3.dex */
public class a {
    public static void init(Context context) {
        try {
            System.loadLibrary("criusbase");
            System.loadLibrary("crius");
        } catch (Throwable th) {
        }
    }

    public static void a(b bVar) {
        com.baidu.b.a.b.a.tw().b(bVar);
    }

    public static void a(c cVar) {
        d.tx().b(cVar);
    }
}
