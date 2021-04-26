package com.baidu.pano.platform.a.a;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final Comparator<byte[]> f9205a = new c();

    /* renamed from: b  reason: collision with root package name */
    public List<byte[]> f9206b = new LinkedList();

    /* renamed from: c  reason: collision with root package name */
    public List<byte[]> f9207c = new ArrayList(64);

    /* renamed from: d  reason: collision with root package name */
    public int f9208d = 0;

    /* renamed from: e  reason: collision with root package name */
    public final int f9209e;

    public b(int i2) {
        this.f9209e = i2;
    }

    public synchronized byte[] a(int i2) {
        for (int i3 = 0; i3 < this.f9207c.size(); i3++) {
            byte[] bArr = this.f9207c.get(i3);
            if (bArr.length >= i2) {
                this.f9208d -= bArr.length;
                this.f9207c.remove(i3);
                this.f9206b.remove(bArr);
                return bArr;
            }
        }
        return new byte[i2];
    }

    public synchronized void a(byte[] bArr) {
        if (bArr != null) {
            if (bArr.length <= this.f9209e) {
                this.f9206b.add(bArr);
                int binarySearch = Collections.binarySearch(this.f9207c, bArr, f9205a);
                if (binarySearch < 0) {
                    binarySearch = (-binarySearch) - 1;
                }
                this.f9207c.add(binarySearch, bArr);
                this.f9208d += bArr.length;
                a();
            }
        }
    }

    private synchronized void a() {
        while (this.f9208d > this.f9209e) {
            byte[] remove = this.f9206b.remove(0);
            this.f9207c.remove(remove);
            this.f9208d -= remove.length;
        }
    }
}
