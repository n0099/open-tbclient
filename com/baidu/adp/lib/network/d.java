package com.baidu.adp.lib.network;

import android.content.Context;
import android.os.Build;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static d f512a;
    private Context b;

    public static synchronized d a() {
        d dVar;
        synchronized (d.class) {
            if (f512a == null) {
                f512a = new d();
            }
            dVar = f512a;
        }
        return dVar;
    }

    public void a(Context context, boolean z) {
        this.b = context;
        b.f511a = z;
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

    public e a(String str, boolean z, int i, c cVar, a aVar) {
        e a2 = b.a(str, z, i, cVar, aVar);
        if (a2 != null && a2.f513a == 206) {
            int length = a2.d.length;
            int length2 = a2.d.length;
            ArrayList arrayList = new ArrayList();
            arrayList.add(a2.d);
            a2.d = b.a(str, length, length2, arrayList, i, cVar, aVar);
            a2.f513a = 200;
        } else if (a2 != null && a2.f513a == 413) {
            a2.d = b.a(str, 0L, g.d(), new ArrayList(), i, cVar, aVar);
            a2.f513a = a2.d != null ? 200 : a2.f513a;
        }
        if (cVar != null) {
            cVar.a(a2);
        }
        return a2;
    }

    public e a(String str, byte[] bArr, boolean z, int i, c cVar, a aVar) {
        return b.a(z, str, bArr, i, cVar, aVar);
    }

    public e a(String str, boolean z, ArrayList<BasicNameValuePair> arrayList, HashMap<String, byte[]> hashMap, int i, c cVar, a aVar, f fVar) {
        try {
            return b.a(str, z, arrayList, hashMap, i, cVar, aVar, null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public e a(String str, ArrayList<BasicNameValuePair> arrayList, String str2, byte[] bArr, int i, c cVar, a aVar) {
        HashMap<String, byte[]> hashMap = new HashMap<>();
        if (str2 != null) {
            hashMap.put(str2, bArr);
        }
        return a(str, false, arrayList, hashMap, i, cVar, aVar, null);
    }

    public boolean a(String str, String str2, boolean z, int i, c cVar, a aVar) {
        return b.a(str, str2, z, i, cVar, aVar);
    }

    public Context b() {
        return this.b;
    }

    private d() {
    }
}
