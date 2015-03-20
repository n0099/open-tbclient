package com.baidu.adp.lib.network.willdelete;

import android.content.Context;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class e {
    private static e wl;
    private Context mContext;

    public static synchronized e hu() {
        e eVar;
        synchronized (e.class) {
            if (wl == null) {
                wl = new e();
            }
            eVar = wl;
        }
        return eVar;
    }

    public void init(Context context, boolean z) {
        this.mContext = context;
        b.wc = z;
        System.setProperty("http.keepAlive", "false");
    }

    public void aj(String str) {
        b.cookie = str;
    }

    public void setUserAgent(String str) {
        b.wd = str;
    }

    public void setUid(String str) {
        b.uid = str;
    }

    public f a(String str, boolean z, int i, int i2, int i3, d dVar, a aVar, LinkedList<BasicNameValuePair> linkedList) {
        f a = b.a(str, z, i, i3, dVar, aVar, linkedList);
        if (a != null && a.wm == 206) {
            int length = a.data.length;
            int length2 = a.data.length;
            ArrayList arrayList = new ArrayList();
            arrayList.add(a.data);
            a.data = b.a(str, length, length2, arrayList, i, i2, i3, dVar, aVar, linkedList);
            a.wm = 200;
        } else if (a != null && a.wm == 413) {
            a.data = b.a(str, 0L, h.hy(), new ArrayList(), i, i2, i3, dVar, aVar, linkedList);
            a.wm = a.data != null ? 200 : a.wm;
        }
        if (dVar != null) {
            dVar.a(a);
        }
        return a;
    }

    public f a(String str, int i, int i2, int i3, d dVar, a aVar, LinkedList<BasicNameValuePair> linkedList) {
        return a(str, false, i, i2, i3, dVar, aVar, linkedList);
    }

    public f a(String str, byte[] bArr, boolean z, int i, int i2, d dVar, a aVar, LinkedList<BasicNameValuePair> linkedList) {
        return b.a(z, str, bArr, i, i2, dVar, aVar, linkedList);
    }

    public f b(String str, boolean z, ArrayList<BasicNameValuePair> arrayList, HashMap<String, byte[]> hashMap, int i, int i2, d dVar, a aVar, com.baidu.adp.lib.network.http.d dVar2, LinkedList<BasicNameValuePair> linkedList) {
        return b.a(str, z, arrayList, hashMap, i, i2, dVar, aVar, (com.baidu.adp.lib.network.http.d) null, linkedList);
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, d dVar, a aVar, LinkedList<BasicNameValuePair> linkedList) {
        return b.a(str, str2, z, i, i2, i3, dVar, aVar, linkedList);
    }

    public Context getContext() {
        return this.mContext;
    }

    private e() {
    }
}
