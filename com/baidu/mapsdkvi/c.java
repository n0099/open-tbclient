package com.baidu.mapsdkvi;

import android.net.NetworkInfo;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public String f2299a;
    public int b;
    public int c;

    public c(NetworkInfo networkInfo) {
        this.f2299a = networkInfo.getTypeName();
        this.b = networkInfo.getType();
        switch (d.f2300a[networkInfo.getState().ordinal()]) {
            case 1:
                this.c = 2;
                return;
            case 2:
                this.c = 1;
                return;
            default:
                this.c = 0;
                return;
        }
    }
}
