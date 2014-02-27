package com.baidu.adp.lib.network;

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

    /* JADX WARN: Removed duplicated region for block: B:9:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static f a(String str, boolean z, int i, int i2, int i3, d dVar, a aVar, LinkedList<BasicNameValuePair> linkedList) {
        int i4;
        f fVar;
        f a2 = b.a(str, z, i, i3, dVar, aVar, linkedList);
        if (a2 != null && a2.a == 206) {
            int length = a2.d.length;
            int length2 = a2.d.length;
            ArrayList arrayList = new ArrayList();
            arrayList.add(a2.d);
            a2.d = b.a(str, length, length2, arrayList, i, 100, i3, dVar, aVar, linkedList);
            i4 = 200;
            fVar = a2;
        } else {
            if (a2 != null && a2.a == 413) {
                a2.d = b.a(str, 0L, i.a() ? 500000 : 200000, new ArrayList(), i, 100, i3, dVar, aVar, linkedList);
                if (a2.d != null) {
                    i4 = 200;
                    fVar = a2;
                } else {
                    i4 = a2.a;
                    fVar = a2;
                }
            }
            if (dVar != null) {
                dVar.a(a2);
            }
            return a2;
        }
        fVar.a = i4;
        if (dVar != null) {
        }
        return a2;
    }

    public static f a(String str, byte[] bArr, boolean z, int i, int i2, d dVar, a aVar, LinkedList<BasicNameValuePair> linkedList) {
        return b.a(z, str, bArr, i, i2, null, aVar, linkedList);
    }

    public static f a(String str, boolean z, ArrayList<BasicNameValuePair> arrayList, HashMap<String, byte[]> hashMap, int i, int i2, d dVar, a aVar, LinkedList<BasicNameValuePair> linkedList) {
        return b.a(str, z, arrayList, hashMap, i, i2, (d) null, aVar, (h) null, linkedList);
    }

    public final Context b() {
        return this.b;
    }

    private e() {
    }
}
