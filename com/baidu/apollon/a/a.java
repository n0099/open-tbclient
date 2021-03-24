package com.baidu.apollon.a;

import android.util.SparseArray;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final SparseArray<ArrayList<b>> f3493a = new SparseArray<>();

    /* renamed from: b  reason: collision with root package name */
    public int f3494b;

    /* renamed from: com.baidu.apollon.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0058a {
        void a();
    }

    /* loaded from: classes2.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public int f3495a;

        /* renamed from: b  reason: collision with root package name */
        public int f3496b;

        /* renamed from: c  reason: collision with root package name */
        public int f3497c;

        /* renamed from: d  reason: collision with root package name */
        public InterfaceC0058a f3498d;

        public b(int i, int i2, int i3, InterfaceC0058a interfaceC0058a) {
            this.f3495a = i;
            this.f3496b = i2;
            this.f3497c = i3;
            this.f3498d = interfaceC0058a;
        }
    }

    public a(int i) {
        this.f3494b = 0;
        this.f3494b = i;
    }

    public void a(b bVar) {
        int i = bVar.f3495a;
        if (i < 0) {
            return;
        }
        ArrayList<b> arrayList = this.f3493a.get(i);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.f3493a.put(bVar.f3495a, arrayList);
        }
        arrayList.add(bVar);
    }

    public void b(int i) {
        ArrayList<b> arrayList = this.f3493a.get(this.f3494b);
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        Iterator<b> it = arrayList.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next.f3497c == i) {
                this.f3494b = next.f3496b;
                next.f3498d.a();
                return;
            }
        }
    }

    public void a(int i) {
        this.f3494b = i;
    }
}
