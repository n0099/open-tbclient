package com.baidu.apollon.a;

import android.util.SparseArray;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final SparseArray<ArrayList<b>> f3591a = new SparseArray<>();

    /* renamed from: b  reason: collision with root package name */
    public int f3592b;

    /* renamed from: com.baidu.apollon.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0059a {
        void a();
    }

    /* loaded from: classes.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public int f3593a;

        /* renamed from: b  reason: collision with root package name */
        public int f3594b;

        /* renamed from: c  reason: collision with root package name */
        public int f3595c;

        /* renamed from: d  reason: collision with root package name */
        public InterfaceC0059a f3596d;

        public b(int i2, int i3, int i4, InterfaceC0059a interfaceC0059a) {
            this.f3593a = i2;
            this.f3594b = i3;
            this.f3595c = i4;
            this.f3596d = interfaceC0059a;
        }
    }

    public a(int i2) {
        this.f3592b = 0;
        this.f3592b = i2;
    }

    public void a(b bVar) {
        int i2 = bVar.f3593a;
        if (i2 < 0) {
            return;
        }
        ArrayList<b> arrayList = this.f3591a.get(i2);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.f3591a.put(bVar.f3593a, arrayList);
        }
        arrayList.add(bVar);
    }

    public void b(int i2) {
        ArrayList<b> arrayList = this.f3591a.get(this.f3592b);
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        Iterator<b> it = arrayList.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next.f3595c == i2) {
                this.f3592b = next.f3594b;
                next.f3596d.a();
                return;
            }
        }
    }

    public void a(int i2) {
        this.f3592b = i2;
    }
}
