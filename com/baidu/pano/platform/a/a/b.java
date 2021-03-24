package com.baidu.pano.platform.a.a;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final Comparator<byte[]> f9318a = new c();

    /* renamed from: b  reason: collision with root package name */
    public List<byte[]> f9319b = new LinkedList();

    /* renamed from: c  reason: collision with root package name */
    public List<byte[]> f9320c = new ArrayList(64);

    /* renamed from: d  reason: collision with root package name */
    public int f9321d = 0;

    /* renamed from: e  reason: collision with root package name */
    public final int f9322e;

    public b(int i) {
        this.f9322e = i;
    }

    public synchronized byte[] a(int i) {
        for (int i2 = 0; i2 < this.f9320c.size(); i2++) {
            byte[] bArr = this.f9320c.get(i2);
            if (bArr.length >= i) {
                this.f9321d -= bArr.length;
                this.f9320c.remove(i2);
                this.f9319b.remove(bArr);
                return bArr;
            }
        }
        return new byte[i];
    }

    public synchronized void a(byte[] bArr) {
        if (bArr != null) {
            if (bArr.length <= this.f9322e) {
                this.f9319b.add(bArr);
                int binarySearch = Collections.binarySearch(this.f9320c, bArr, f9318a);
                if (binarySearch < 0) {
                    binarySearch = (-binarySearch) - 1;
                }
                this.f9320c.add(binarySearch, bArr);
                this.f9321d += bArr.length;
                a();
            }
        }
    }

    private synchronized void a() {
        while (this.f9321d > this.f9322e) {
            byte[] remove = this.f9319b.remove(0);
            this.f9320c.remove(remove);
            this.f9321d -= remove.length;
        }
    }
}
