package com.baidu.loginshare;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.net.wifi.WifiManager;
import java.net.InetSocketAddress;
import java.net.Proxy;
/* loaded from: classes.dex */
public final class l {
    private static int a = 1;
    private static int b = 2;
    private static int c = 3;
    private static String d = "wap";
    private static String e = "net";
    private static String f = "http://";
    private static String g = "https://";
    private static String h = "10.0.0.172";
    private static int i = 80;

    private static Proxy a(Context context) {
        Cursor cursor;
        String string;
        if (!((WifiManager) context.getSystemService("wifi")).isWifiEnabled()) {
            try {
                try {
                    cursor = context.getContentResolver().query(Uri.parse("content://telephony/carriers/preferapn"), null, null, null, null);
                    if (cursor != null) {
                        try {
                            if (cursor.moveToNext() && (string = cursor.getString(cursor.getColumnIndex("proxy"))) != null && string.trim().length() > 0) {
                                Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(string, 80));
                                if (cursor == null || cursor.isClosed()) {
                                    return proxy;
                                }
                                cursor.close();
                                return proxy;
                            }
                        } catch (Throwable th) {
                            th = th;
                            if (cursor != null && !cursor.isClosed()) {
                                cursor.close();
                            }
                            throw th;
                        }
                    }
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    cursor = null;
                }
            } catch (Exception e2) {
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(String str) {
        return str != null && str.length() > 0;
    }
}
