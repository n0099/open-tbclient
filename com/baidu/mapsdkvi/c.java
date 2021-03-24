package com.baidu.mapsdkvi;

import android.net.NetworkInfo;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public String f7915a;

    /* renamed from: b  reason: collision with root package name */
    public int f7916b;

    /* renamed from: c  reason: collision with root package name */
    public int f7917c;

    public c(NetworkInfo networkInfo) {
        this.f7915a = networkInfo.getTypeName();
        this.f7916b = networkInfo.getType();
        int i = d.f7918a[networkInfo.getState().ordinal()];
        if (i == 1) {
            this.f7917c = 2;
        } else if (i != 2) {
            this.f7917c = 0;
        } else {
            this.f7917c = 1;
        }
    }
}
