package com.baidu.apollon.a;

import android.util.SparseArray;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final SparseArray<ArrayList<b>> f3572a = new SparseArray<>();

    /* renamed from: b  reason: collision with root package name */
    public int f3573b;

    /* renamed from: com.baidu.apollon.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0058a {
        void a();
    }

    /* loaded from: classes.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public int f3574a;

        /* renamed from: b  reason: collision with root package name */
        public int f3575b;

        /* renamed from: c  reason: collision with root package name */
        public int f3576c;

        /* renamed from: d  reason: collision with root package name */
        public InterfaceC0058a f3577d;

        public b(int i2, int i3, int i4, InterfaceC0058a interfaceC0058a) {
            this.f3574a = i2;
            this.f3575b = i3;
            this.f3576c = i4;
            this.f3577d = interfaceC0058a;
        }
    }

    public a(int i2) {
        this.f3573b = 0;
        this.f3573b = i2;
    }

    public void a(b bVar) {
        int i2 = bVar.f3574a;
        if (i2 < 0) {
            return;
        }
        ArrayList<b> arrayList = this.f3572a.get(i2);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.f3572a.put(bVar.f3574a, arrayList);
        }
        arrayList.add(bVar);
    }

    public void b(int i2) {
        ArrayList<b> arrayList = this.f3572a.get(this.f3573b);
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        Iterator<b> it = arrayList.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next.f3576c == i2) {
                this.f3573b = next.f3575b;
                next.f3577d.a();
                return;
            }
        }
    }

    public void a(int i2) {
        this.f3573b = i2;
    }
}
