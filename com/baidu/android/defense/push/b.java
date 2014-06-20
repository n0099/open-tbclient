package com.baidu.android.defense.push;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import java.io.UnsupportedEncodingException;
/* loaded from: classes.dex */
public class b {
    private b() {
    }

    public static Intent a(Context context) {
        return b(context);
    }

    public static String a(String str) {
        try {
            return com.baidu.android.nebula.a.k.a(com.baidu.android.nebula.a.i.a(str.getBytes(), "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC/7VlVn9LIrZ71PL2RZMbK/Yxc\r\ndb046w/cXVylxS7ouPY06namZUFVhdbUnNRJzmGUZlzs3jUbvMO3l+4c9cw/n9aQ\r\nrm/brgaRDeZbeSrQYRZv60xzJIimuFFxsRM+ku6/dAyYmXiQXlRbgvFQ0MsVng4j\r\nv+cXhtTis2Kbwb8mQwIDAQAB\r\n", 1024), "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static Intent b(Context context) {
        Intent intent = new Intent("com.baidu.android.pushservice.action.METHOD");
        intent.addFlags(32);
        intent.putExtra("app", PendingIntent.getBroadcast(context, 0, new Intent(), 0));
        intent.putExtra("method_version", "V2");
        return intent;
    }
}
