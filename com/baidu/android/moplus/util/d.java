package com.baidu.android.moplus.util;

import android.content.Context;
import android.net.LocalServerSocket;
import com.baidu.android.nebula.a.f;
import java.io.IOException;
/* loaded from: classes.dex */
public class d {
    private static LocalServerSocket a;
    private static d b;

    private d(Context context) {
    }

    public static d a(Context context) {
        if (b == null) {
            b = new d(context);
        }
        return b;
    }

    private String c(Context context) {
        return f.a(("com.baidu.pushservice.singelinstancev1" + com.baidu.android.nebula.a.b.a(context)).getBytes(), false);
    }

    public boolean a() {
        return a != null;
    }

    public void b() {
        try {
            if (a != null) {
                a.close();
                a = null;
            }
        } catch (IOException e) {
        }
    }

    public boolean b(Context context) {
        if (a == null) {
            try {
                a = new LocalServerSocket(c(context));
            } catch (Exception e) {
            }
        }
        return a != null;
    }
}
