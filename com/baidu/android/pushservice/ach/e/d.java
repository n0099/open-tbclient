package com.baidu.android.pushservice.ach.e;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import com.baidu.protect.sdk.Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class d {
    public static volatile d c;
    public c a;
    public Context b;

    public d(Context context) {
        this.a = null;
        this.b = context.getApplicationContext();
        LinkedList linkedList = new LinkedList();
        linkedList.add(new b());
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (cVar.b(context)) {
                this.a = cVar;
                return;
            }
        }
    }

    public static d a(Context context) {
        return (d) Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.l(-15952, null, context);
    }

    public void a() {
        Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.v(-15951, this, null);
    }

    public void a(Service service, Intent intent, int i, boolean z) {
        Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.v(-15946, this, service, intent, Integer.valueOf(i), Boolean.valueOf(z));
    }
}
