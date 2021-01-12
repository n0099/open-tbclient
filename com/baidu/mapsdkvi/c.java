package com.baidu.mapsdkvi;

import android.net.NetworkInfo;
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public String f3185a;

    /* renamed from: b  reason: collision with root package name */
    public int f3186b;
    public int c;

    public c(NetworkInfo networkInfo) {
        this.f3185a = networkInfo.getTypeName();
        this.f3186b = networkInfo.getType();
        switch (d.f3187a[networkInfo.getState().ordinal()]) {
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
