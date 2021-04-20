package com.baidu.mapsdkvi;

import android.net.NetworkInfo;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public String f7951a;

    /* renamed from: b  reason: collision with root package name */
    public int f7952b;

    /* renamed from: c  reason: collision with root package name */
    public int f7953c;

    public c(NetworkInfo networkInfo) {
        this.f7951a = networkInfo.getTypeName();
        this.f7952b = networkInfo.getType();
        int i = d.f7954a[networkInfo.getState().ordinal()];
        if (i == 1) {
            this.f7953c = 2;
        } else if (i != 2) {
            this.f7953c = 0;
        } else {
            this.f7953c = 1;
        }
    }
}
