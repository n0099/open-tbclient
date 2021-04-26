package com.baidu.mapsdkvi;

import android.net.NetworkInfo;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public String f8238a;

    /* renamed from: b  reason: collision with root package name */
    public int f8239b;

    /* renamed from: c  reason: collision with root package name */
    public int f8240c;

    public c(NetworkInfo networkInfo) {
        this.f8238a = networkInfo.getTypeName();
        this.f8239b = networkInfo.getType();
        int i2 = d.f8241a[networkInfo.getState().ordinal()];
        if (i2 == 1) {
            this.f8240c = 2;
        } else if (i2 != 2) {
            this.f8240c = 0;
        } else {
            this.f8240c = 1;
        }
    }
}
