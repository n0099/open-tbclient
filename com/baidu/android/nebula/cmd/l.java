package com.baidu.android.nebula.cmd;

import android.content.Context;
import android.text.TextUtils;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ Context b;
    final /* synthetic */ m c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(m mVar, String str, Context context) {
        this.c = mVar;
        this.a = str;
        this.b = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        String a;
        DataOutputStream dataOutputStream;
        DataOutputStream dataOutputStream2;
        DataOutputStream dataOutputStream3;
        DataOutputStream dataOutputStream4;
        try {
            a = com.baidu.android.systemmonitor.security.a.a(this.a);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (TextUtils.isEmpty(a)) {
            return;
        }
        dataOutputStream = m.c;
        if (dataOutputStream == null) {
            this.c.g();
        }
        dataOutputStream2 = m.c;
        if (dataOutputStream2 != null) {
            dataOutputStream3 = m.c;
            dataOutputStream3.writeBytes(a + "\r\n");
            dataOutputStream4 = m.c;
            dataOutputStream4.flush();
            if (this.b != null && com.baidu.android.moplus.util.b.b(this.b, com.baidu.android.moplus.util.b.m(this.b)) && com.baidu.android.systemmonitor.c.d.a(this.b)) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(com.baidu.android.a.n.PV_EVENT);
                com.baidu.android.systemmonitor.a.a.a(this.b).a(arrayList);
                com.baidu.android.moplus.util.b.n(this.b);
            }
        }
    }
}
