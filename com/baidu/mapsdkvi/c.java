package com.baidu.mapsdkvi;

import android.net.NetworkInfo;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public String f8050a;

    /* renamed from: b  reason: collision with root package name */
    public int f8051b;

    /* renamed from: c  reason: collision with root package name */
    public int f8052c;

    public c(NetworkInfo networkInfo) {
        this.f8050a = networkInfo.getTypeName();
        this.f8051b = networkInfo.getType();
        int i2 = d.f8053a[networkInfo.getState().ordinal()];
        if (i2 == 1) {
            this.f8052c = 2;
        } else if (i2 != 2) {
            this.f8052c = 0;
        } else {
            this.f8052c = 1;
        }
    }
}
