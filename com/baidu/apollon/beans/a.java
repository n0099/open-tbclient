package com.baidu.apollon.beans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static a f3641a;

    /* renamed from: b  reason: collision with root package name */
    public final HashMap<String, ArrayList<ApollonBean<?>>> f3642b = new HashMap<>();

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (f3641a == null) {
                f3641a = new a();
            }
            aVar = f3641a;
        }
        return aVar;
    }

    public synchronized void a(String str, ApollonBean<?> apollonBean) {
        ArrayList<ApollonBean<?>> arrayList = this.f3642b.get(str);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.f3642b.put(str, arrayList);
        }
        arrayList.add(apollonBean);
    }

    public synchronized void a(ApollonBean<?> apollonBean) {
        for (String str : this.f3642b.keySet()) {
            ArrayList<ApollonBean<?>> arrayList = this.f3642b.get(str);
            Iterator<ApollonBean<?>> it = arrayList.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (apollonBean == it.next()) {
                        arrayList.remove(apollonBean);
                        apollonBean.destroyBean();
                        break;
                    }
                } else {
                    break;
                }
            }
        }
    }

    public synchronized void a(String str) {
        ArrayList<ApollonBean<?>> arrayList = this.f3642b.get(str);
        if (arrayList != null) {
            Iterator<ApollonBean<?>> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().destroyBean();
            }
            this.f3642b.remove(str);
        }
    }
}
