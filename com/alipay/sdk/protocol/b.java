package com.alipay.sdk.protocol;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public a f1909a;

    /* renamed from: b  reason: collision with root package name */
    public String f1910b;

    /* renamed from: c  reason: collision with root package name */
    public String[] f1911c;

    public b(String str) {
        this.f1910b = str;
    }

    public static void a(b bVar) {
        String[] c2 = bVar.c();
        if (c2.length == 3 && TextUtils.equals("tid", c2[0])) {
            com.alipay.sdk.tid.b a2 = com.alipay.sdk.tid.b.a(com.alipay.sdk.sys.b.a().b());
            if (TextUtils.isEmpty(c2[1]) || TextUtils.isEmpty(c2[2])) {
                return;
            }
            a2.a(c2[1], c2[2]);
        }
    }

    public static String[] b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return str.split(";");
    }

    public String[] c() {
        return this.f1911c;
    }

    public b(String str, a aVar) {
        this.f1910b = str;
        this.f1909a = aVar;
    }

    public a b() {
        return this.f1909a;
    }

    public static List<b> a(JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList();
        if (jSONObject == null) {
            return arrayList;
        }
        String[] b2 = b(jSONObject.optString("name", ""));
        for (int i2 = 0; i2 < b2.length; i2++) {
            a a2 = a.a(b2[i2]);
            if (a2 != a.None) {
                b bVar = new b(b2[i2], a2);
                bVar.f1911c = a(b2[i2]);
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    public static String[] a(String str) {
        ArrayList arrayList = new ArrayList();
        int indexOf = str.indexOf(40);
        int lastIndexOf = str.lastIndexOf(41);
        if (indexOf == -1 || lastIndexOf == -1 || lastIndexOf <= indexOf) {
            return null;
        }
        for (String str2 : str.substring(indexOf + 1, lastIndexOf).split("' *, *'", -1)) {
            arrayList.add(str2.trim().replaceAll("'", "").replaceAll("\"", ""));
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public String a() {
        return this.f1910b;
    }
}
