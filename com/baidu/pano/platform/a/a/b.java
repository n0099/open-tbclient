package com.baidu.pano.platform.a.a;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final Comparator<byte[]> f9319a = new c();

    /* renamed from: b  reason: collision with root package name */
    public List<byte[]> f9320b = new LinkedList();

    /* renamed from: c  reason: collision with root package name */
    public List<byte[]> f9321c = new ArrayList(64);

    /* renamed from: d  reason: collision with root package name */
    public int f9322d = 0;

    /* renamed from: e  reason: collision with root package name */
    public final int f9323e;

    public b(int i) {
        this.f9323e = i;
    }

    public synchronized byte[] a(int i) {
        for (int i2 = 0; i2 < this.f9321c.size(); i2++) {
            byte[] bArr = this.f9321c.get(i2);
            if (bArr.length >= i) {
                this.f9322d -= bArr.length;
                this.f9321c.remove(i2);
                this.f9320b.remove(bArr);
                return bArr;
            }
        }
        return new byte[i];
    }

    public synchronized void a(byte[] bArr) {
        if (bArr != null) {
            if (bArr.length <= this.f9323e) {
                this.f9320b.add(bArr);
                int binarySearch = Collections.binarySearch(this.f9321c, bArr, f9319a);
                if (binarySearch < 0) {
                    binarySearch = (-binarySearch) - 1;
                }
                this.f9321c.add(binarySearch, bArr);
                this.f9322d += bArr.length;
                a();
            }
        }
    }

    private synchronized void a() {
        while (this.f9322d > this.f9323e) {
            byte[] remove = this.f9320b.remove(0);
            this.f9321c.remove(remove);
            this.f9322d -= remove.length;
        }
    }
}
