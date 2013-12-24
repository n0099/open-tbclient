package com.baidu.android.moplus.util;

import android.content.Context;
import android.net.LocalServerSocket;
import com.baidu.android.common.util.DeviceId;
import com.baidu.android.common.util.Util;
import java.io.IOException;
/* loaded from: classes.dex */
public class c {
    private static LocalServerSocket a;
    private static c b;

    private c(Context context) {
    }

    public static c a(Context context) {
        if (b == null) {
            b = new c(context);
        }
        return b;
    }

    private String c(Context context) {
        return Util.toMd5(("com.baidu.pushservice.singelinstancev1" + DeviceId.getDeviceID(context)).getBytes(), false);
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
