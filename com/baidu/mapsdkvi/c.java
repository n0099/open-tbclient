package com.baidu.mapsdkvi;

import android.net.NetworkInfo;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public String f7916a;

    /* renamed from: b  reason: collision with root package name */
    public int f7917b;

    /* renamed from: c  reason: collision with root package name */
    public int f7918c;

    public c(NetworkInfo networkInfo) {
        this.f7916a = networkInfo.getTypeName();
        this.f7917b = networkInfo.getType();
        int i = d.f7919a[networkInfo.getState().ordinal()];
        if (i == 1) {
            this.f7918c = 2;
        } else if (i != 2) {
            this.f7918c = 0;
        } else {
            this.f7918c = 1;
        }
    }
}
