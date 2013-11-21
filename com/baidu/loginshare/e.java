package com.baidu.loginshare;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.net.wifi.WifiManager;
import java.net.InetSocketAddress;
import java.net.Proxy;
/* loaded from: classes.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static final int f945a = 1;
    public static final int b = 2;
    public static final int c = 3;
    public static final String d = "wap";
    public static final String e = "net";
    public static final String f = "http://";
    public static final String g = "https://";
    public static final String h = "10.0.0.172";
    public static final int i = 80;

    public static Proxy a(Context context) {
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
