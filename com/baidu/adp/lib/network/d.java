package com.baidu.adp.lib.network;

import android.content.Context;
import android.os.Build;
import com.baidu.browser.webpool.BdWebPoolView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class d {
    private static d a;
    private Context b;

    public static synchronized d a() {
        d dVar;
        synchronized (d.class) {
            if (a == null) {
                a = new d();
            }
            dVar = a;
        }
        return dVar;
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

    public e a(String str, boolean z, int i, int i2, c cVar, a aVar, LinkedList<BasicNameValuePair> linkedList) {
        e a2 = b.a(str, z, i, cVar, aVar, linkedList);
        if (a2 != null && a2.a == 206) {
            int length = a2.d.length;
            int length2 = a2.d.length;
            ArrayList arrayList = new ArrayList();
            arrayList.add(a2.d);
            a2.d = b.a(str, length, length2, arrayList, i, i2, cVar, aVar, linkedList);
            a2.a = BdWebPoolView.DELAYED_TIME;
        } else if (a2 != null && a2.a == 413) {
            a2.d = b.a(str, 0L, g.d(), new ArrayList(), i, i2, cVar, aVar, linkedList);
            a2.a = a2.d != null ? BdWebPoolView.DELAYED_TIME : a2.a;
        }
        if (cVar != null) {
            cVar.a(a2);
        }
        return a2;
    }

    public e a(String str, byte[] bArr, boolean z, int i, c cVar, a aVar, LinkedList<BasicNameValuePair> linkedList) {
        return b.a(z, str, bArr, i, cVar, aVar, linkedList);
    }

    public e a(String str, boolean z, ArrayList<BasicNameValuePair> arrayList, HashMap<String, byte[]> hashMap, int i, c cVar, a aVar, f fVar, LinkedList<BasicNameValuePair> linkedList) {
        return b.a(str, z, arrayList, hashMap, i, cVar, aVar, (f) null, linkedList);
    }

    public e a(String str, ArrayList<BasicNameValuePair> arrayList, String str2, byte[] bArr, int i, c cVar, a aVar, LinkedList<BasicNameValuePair> linkedList) {
        HashMap<String, byte[]> hashMap = new HashMap<>();
        if (str2 != null) {
            hashMap.put(str2, bArr);
        }
        return a(str, false, arrayList, hashMap, i, cVar, aVar, null, linkedList);
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, c cVar, a aVar, LinkedList<BasicNameValuePair> linkedList) {
        return b.a(str, str2, z, i, i2, cVar, aVar, linkedList);
    }

    public Context b() {
        return this.b;
    }

    private d() {
    }
}
