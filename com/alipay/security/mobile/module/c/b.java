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
    public File f2063a;

    /* renamed from: b  reason: collision with root package name */
    public com.alipay.security.mobile.module.http.v2.a f2064b;

    public b(String str, com.alipay.security.mobile.module.http.v2.a aVar) {
        this.f2063a = null;
        this.f2064b = null;
        this.f2063a = new File(str);
        this.f2064b = aVar;
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
        if (this.f2063a == null) {
            return;
        }
        if (this.f2063a.exists() && this.f2063a.isDirectory() && this.f2063a.list().length != 0) {
            ArrayList arrayList = new ArrayList();
            for (String str : this.f2063a.list()) {
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
            if (!this.f2064b.a(a(com.alipay.security.mobile.module.a.b.a(this.f2063a.getAbsolutePath(), str2)))) {
                size--;
            }
            for (int i2 = 0; i2 < size; i2++) {
                new File(this.f2063a, (String) arrayList.get(i2)).delete();
            }
        }
    }

    public final void a() {
        new Thread(new c(this)).start();
    }
}
