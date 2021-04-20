package com.baidu.apollon.a;

import android.util.SparseArray;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final SparseArray<ArrayList<b>> f3529a = new SparseArray<>();

    /* renamed from: b  reason: collision with root package name */
    public int f3530b;

    /* renamed from: com.baidu.apollon.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0058a {
        void a();
    }

    /* loaded from: classes.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public int f3531a;

        /* renamed from: b  reason: collision with root package name */
        public int f3532b;

        /* renamed from: c  reason: collision with root package name */
        public int f3533c;

        /* renamed from: d  reason: collision with root package name */
        public InterfaceC0058a f3534d;

        public b(int i, int i2, int i3, InterfaceC0058a interfaceC0058a) {
            this.f3531a = i;
            this.f3532b = i2;
            this.f3533c = i3;
            this.f3534d = interfaceC0058a;
        }
    }

    public a(int i) {
        this.f3530b = 0;
        this.f3530b = i;
    }

    public void a(b bVar) {
        int i = bVar.f3531a;
        if (i < 0) {
            return;
        }
        ArrayList<b> arrayList = this.f3529a.get(i);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.f3529a.put(bVar.f3531a, arrayList);
        }
        arrayList.add(bVar);
    }

    public void b(int i) {
        ArrayList<b> arrayList = this.f3529a.get(this.f3530b);
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        Iterator<b> it = arrayList.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next.f3533c == i) {
                this.f3530b = next.f3532b;
                next.f3534d.a();
                return;
            }
        }
    }

    public void a(int i) {
        this.f3530b = i;
    }
}
