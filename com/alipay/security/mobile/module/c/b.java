package com.alipay.security.mobile.module.c;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public File f2090a;

    /* renamed from: b  reason: collision with root package name */
    public com.alipay.security.mobile.module.http.v2.a f2091b;

    public b(String str, com.alipay.security.mobile.module.http.v2.a aVar) {
        this.f2090a = null;
        this.f2091b = null;
        this.f2090a = new File(str);
        this.f2091b = aVar;
    }

    public static String a(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "id");
            jSONObject.put("error", str);
            return jSONObject.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b() {
        if (this.f2090a == null) {
            return;
        }
        if (this.f2090a.exists() && this.f2090a.isDirectory() && this.f2090a.list().length != 0) {
            ArrayList arrayList = new ArrayList();
            for (String str : this.f2090a.list()) {
                arrayList.add(str);
            }
            Collections.sort(arrayList);
            String str2 = (String) arrayList.get(arrayList.size() - 1);
            int size = arrayList.size();
            if (str2.equals(new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime()) + ".log")) {
                if (arrayList.size() < 2) {
                    return;
                }
                str2 = (String) arrayList.get(arrayList.size() - 2);
                size--;
            }
            if (!this.f2091b.a(a(com.alipay.security.mobile.module.a.b.a(this.f2090a.getAbsolutePath(), str2)))) {
                size--;
            }
            for (int i = 0; i < size; i++) {
                new File(this.f2090a, (String) arrayList.get(i)).delete();
            }
        }
    }

    public final void a() {
        new Thread(new c(this)).start();
    }
}
