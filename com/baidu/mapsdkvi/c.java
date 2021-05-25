package com.baidu.mapsdkvi;

import android.net.NetworkInfo;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public String f7950a;

    /* renamed from: b  reason: collision with root package name */
    public int f7951b;

    /* renamed from: c  reason: collision with root package name */
    public int f7952c;

    public c(NetworkInfo networkInfo) {
        this.f7950a = networkInfo.getTypeName();
        this.f7951b = networkInfo.getType();
        int i2 = d.f7953a[networkInfo.getState().ordinal()];
        if (i2 == 1) {
            this.f7952c = 2;
        } else if (i2 != 2) {
            this.f7952c = 0;
        } else {
            this.f7952c = 1;
        }
    }
}
