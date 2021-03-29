package com.baidu.apollon.a;

import android.util.SparseArray;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final SparseArray<ArrayList<b>> f3494a = new SparseArray<>();

    /* renamed from: b  reason: collision with root package name */
    public int f3495b;

    /* renamed from: com.baidu.apollon.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0059a {
        void a();
    }

    /* loaded from: classes.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public int f3496a;

        /* renamed from: b  reason: collision with root package name */
        public int f3497b;

        /* renamed from: c  reason: collision with root package name */
        public int f3498c;

        /* renamed from: d  reason: collision with root package name */
        public InterfaceC0059a f3499d;

        public b(int i, int i2, int i3, InterfaceC0059a interfaceC0059a) {
            this.f3496a = i;
            this.f3497b = i2;
            this.f3498c = i3;
            this.f3499d = interfaceC0059a;
        }
    }

    public a(int i) {
        this.f3495b = 0;
        this.f3495b = i;
    }

    public void a(b bVar) {
        int i = bVar.f3496a;
        if (i < 0) {
            return;
        }
        ArrayList<b> arrayList = this.f3494a.get(i);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.f3494a.put(bVar.f3496a, arrayList);
        }
        arrayList.add(bVar);
    }

    public void b(int i) {
        ArrayList<b> arrayList = this.f3494a.get(this.f3495b);
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        Iterator<b> it = arrayList.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next.f3498c == i) {
                this.f3495b = next.f3497b;
                next.f3499d.a();
                return;
            }
        }
    }

    public void a(int i) {
        this.f3495b = i;
    }
}
