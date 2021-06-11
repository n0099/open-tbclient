package com.baidu.mapsdkvi;

import android.net.NetworkInfo;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public String f7993a;

    /* renamed from: b  reason: collision with root package name */
    public int f7994b;

    /* renamed from: c  reason: collision with root package name */
    public int f7995c;

    public c(NetworkInfo networkInfo) {
        this.f7993a = networkInfo.getTypeName();
        this.f7994b = networkInfo.getType();
        int i2 = d.f7996a[networkInfo.getState().ordinal()];
        if (i2 == 1) {
            this.f7995c = 2;
        } else if (i2 != 2) {
            this.f7995c = 0;
        } else {
            this.f7995c = 1;
        }
    }
}
