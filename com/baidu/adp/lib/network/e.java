package com.baidu.adp.lib.network;

import android.content.Context;
import android.os.Build;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class e {
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

    public void a(Context context, boolean z) {
        this.b = context;
        b.a = z;
        if (Integer.parseInt(Build.VERSION.SDK) < 8) {
            System.setProperty("http.keepAlive", "false");
        }
    }

    public void a(String str) {
        b.b = str;
    }

    public void b(String str) {
        b.c = str;
    }

    public void c(String str) {
        b.d = str;
    }

    public f a(String str, boolean z, int i, int i2, int i3, d dVar, a aVar, LinkedList<BasicNameValuePair> linkedList) {
        f a2 = b.a(str, z, i, i3, dVar, aVar, linkedList);
        if (a2 != null && a2.a == 206) {
            int length = a2.d.length;
            int length2 = a2.d.length;
            ArrayList arrayList = new ArrayList();
            arrayList.add(a2.d);
            a2.d = b.a(str, length, length2, arrayList, i, i2, i3, dVar, aVar, linkedList);
            a2.a = 200;
        } else if (a2 != null && a2.a == 413) {
            a2.d = b.a(str, 0L, i.d(), new ArrayList(), i, i2, i3, dVar, aVar, linkedList);
            a2.a = a2.d != null ? 200 : a2.a;
        }
        if (dVar != null) {
            dVar.a(a2);
        }
        return a2;
    }

    public f a(String str, byte[] bArr, int i, int i2, d dVar, a aVar, LinkedList<BasicNameValuePair> linkedList) {
        return b.a(false, str, bArr, i, i2, dVar, aVar, linkedList);
    }

    public f a(String str, byte[] bArr, boolean z, int i, int i2, d dVar, a aVar, LinkedList<BasicNameValuePair> linkedList) {
        return b.a(z, str, bArr, i, i2, dVar, aVar, linkedList);
    }

    public f a(String str, boolean z, ArrayList<BasicNameValuePair> arrayList, HashMap<String, byte[]> hashMap, int i, int i2, d dVar, a aVar, h hVar, LinkedList<BasicNameValuePair> linkedList) {
        return b.a(str, z, arrayList, hashMap, i, i2, dVar, aVar, (h) null, linkedList);
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, d dVar, a aVar, LinkedList<BasicNameValuePair> linkedList) {
        return b.a(str, str2, z, i, i2, i3, dVar, aVar, linkedList);
    }

    public Context b() {
        return this.b;
    }

    private e() {
    }
}
