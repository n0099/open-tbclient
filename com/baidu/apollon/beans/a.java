package com.baidu.apollon.beans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static a f3599a;

    /* renamed from: b  reason: collision with root package name */
    public final HashMap<String, ArrayList<ApollonBean<?>>> f3600b = new HashMap<>();

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (f3599a == null) {
                f3599a = new a();
            }
            aVar = f3599a;
        }
        return aVar;
    }

    public synchronized void a(String str, ApollonBean<?> apollonBean) {
        ArrayList<ApollonBean<?>> arrayList = this.f3600b.get(str);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.f3600b.put(str, arrayList);
        }
        arrayList.add(apollonBean);
    }

    public synchronized void a(ApollonBean<?> apollonBean) {
        for (String str : this.f3600b.keySet()) {
            ArrayList<ApollonBean<?>> arrayList = this.f3600b.get(str);
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
        ArrayList<ApollonBean<?>> arrayList = this.f3600b.get(str);
        if (arrayList != null) {
            Iterator<ApollonBean<?>> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().destroyBean();
            }
            this.f3600b.remove(str);
        }
    }
}
