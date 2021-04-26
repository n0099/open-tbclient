package com.baidu.apollon.a;

import android.util.SparseArray;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final SparseArray<ArrayList<b>> f3568a = new SparseArray<>();

    /* renamed from: b  reason: collision with root package name */
    public int f3569b;

    /* renamed from: com.baidu.apollon.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0058a {
        void a();
    }

    /* loaded from: classes.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public int f3570a;

        /* renamed from: b  reason: collision with root package name */
        public int f3571b;

        /* renamed from: c  reason: collision with root package name */
        public int f3572c;

        /* renamed from: d  reason: collision with root package name */
        public InterfaceC0058a f3573d;

        public b(int i2, int i3, int i4, InterfaceC0058a interfaceC0058a) {
            this.f3570a = i2;
            this.f3571b = i3;
            this.f3572c = i4;
            this.f3573d = interfaceC0058a;
        }
    }

    public a(int i2) {
        this.f3569b = 0;
        this.f3569b = i2;
    }

    public void a(b bVar) {
        int i2 = bVar.f3570a;
        if (i2 < 0) {
            return;
        }
        ArrayList<b> arrayList = this.f3568a.get(i2);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.f3568a.put(bVar.f3570a, arrayList);
        }
        arrayList.add(bVar);
    }

    public void b(int i2) {
        ArrayList<b> arrayList = this.f3568a.get(this.f3569b);
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        Iterator<b> it = arrayList.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next.f3572c == i2) {
                this.f3569b = next.f3571b;
                next.f3573d.a();
                return;
            }
        }
    }

    public void a(int i2) {
        this.f3569b = i2;
    }
}
