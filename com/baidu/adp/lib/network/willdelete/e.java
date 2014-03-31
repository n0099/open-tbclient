package com.baidu.adp.lib.network.willdelete;

import android.content.Context;
import android.os.Build;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public final class e {
    private static e a;
    private Context b;

    public static synchronized e a() {
        e eVar;
        synchronized (e.class) {
            if (a == null) {
                a = new e();
            }
            eVar = a;
        }
        return eVar;
    }

    public final void a(Context context, boolean z) {
        this.b = context;
        b.a = false;
        if (Integer.parseInt(Build.VERSION.SDK) < 8) {
            System.setProperty("http.keepAlive", "false");
        }
    }

    public static f a(String str, boolean z, ArrayList<BasicNameValuePair> arrayList, HashMap<String, byte[]> hashMap, int i, int i2, d dVar, a aVar, LinkedList<BasicNameValuePair> linkedList) {
        return b.a(str, z, arrayList, hashMap, i, -1, (d) null, aVar, (com.baidu.adp.lib.network.http.d) null, linkedList);
    }

    public final Context b() {
        return this.b;
    }

    private e() {
    }
}
