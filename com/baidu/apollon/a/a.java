package com.baidu.apollon.a;

import android.util.SparseArray;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final SparseArray<ArrayList<b>> f3569a = new SparseArray<>();

    /* renamed from: b  reason: collision with root package name */
    public int f3570b;

    /* renamed from: com.baidu.apollon.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0057a {
        void a();
    }

    /* loaded from: classes.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public int f3571a;

        /* renamed from: b  reason: collision with root package name */
        public int f3572b;

        /* renamed from: c  reason: collision with root package name */
        public int f3573c;

        /* renamed from: d  reason: collision with root package name */
        public InterfaceC0057a f3574d;

        public b(int i2, int i3, int i4, InterfaceC0057a interfaceC0057a) {
            this.f3571a = i2;
            this.f3572b = i3;
            this.f3573c = i4;
            this.f3574d = interfaceC0057a;
        }
    }

    public a(int i2) {
        this.f3570b = 0;
        this.f3570b = i2;
    }

    public void a(b bVar) {
        int i2 = bVar.f3571a;
        if (i2 < 0) {
            return;
        }
        ArrayList<b> arrayList = this.f3569a.get(i2);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.f3569a.put(bVar.f3571a, arrayList);
        }
        arrayList.add(bVar);
    }

    public void b(int i2) {
        ArrayList<b> arrayList = this.f3569a.get(this.f3570b);
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        Iterator<b> it = arrayList.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next.f3573c == i2) {
                this.f3570b = next.f3572b;
                next.f3574d.a();
                return;
            }
        }
    }

    public void a(int i2) {
        this.f3570b = i2;
    }
}
