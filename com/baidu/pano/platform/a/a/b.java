package com.baidu.pano.platform.a.a;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final Comparator<byte[]> f8877a = new c();

    /* renamed from: b  reason: collision with root package name */
    public List<byte[]> f8878b = new LinkedList();

    /* renamed from: c  reason: collision with root package name */
    public List<byte[]> f8879c = new ArrayList(64);

    /* renamed from: d  reason: collision with root package name */
    public int f8880d = 0;

    /* renamed from: e  reason: collision with root package name */
    public final int f8881e;

    public b(int i) {
        this.f8881e = i;
    }

    public synchronized byte[] a(int i) {
        for (int i2 = 0; i2 < this.f8879c.size(); i2++) {
            byte[] bArr = this.f8879c.get(i2);
            if (bArr.length >= i) {
                this.f8880d -= bArr.length;
                this.f8879c.remove(i2);
                this.f8878b.remove(bArr);
                return bArr;
            }
        }
        return new byte[i];
    }

    public synchronized void a(byte[] bArr) {
        if (bArr != null) {
            if (bArr.length <= this.f8881e) {
                this.f8878b.add(bArr);
                int binarySearch = Collections.binarySearch(this.f8879c, bArr, f8877a);
                if (binarySearch < 0) {
                    binarySearch = (-binarySearch) - 1;
                }
                this.f8879c.add(binarySearch, bArr);
                this.f8880d += bArr.length;
                a();
            }
        }
    }

    private synchronized void a() {
        while (this.f8880d > this.f8881e) {
            byte[] remove = this.f8878b.remove(0);
            this.f8879c.remove(remove);
            this.f8880d -= remove.length;
        }
    }
}
