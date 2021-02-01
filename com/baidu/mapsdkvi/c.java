package com.baidu.mapsdkvi;

import android.net.NetworkInfo;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public String f3183a;

    /* renamed from: b  reason: collision with root package name */
    public int f3184b;
    public int c;

    public c(NetworkInfo networkInfo) {
        this.f3183a = networkInfo.getTypeName();
        this.f3184b = networkInfo.getType();
        switch (d.f3185a[networkInfo.getState().ordinal()]) {
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
