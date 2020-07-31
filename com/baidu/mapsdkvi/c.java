package com.baidu.mapsdkvi;

import android.net.NetworkInfo;
/* loaded from: classes10.dex */
public class c {
    public String a;
    public int b;
    public int c;

    public c(NetworkInfo networkInfo) {
        this.a = networkInfo.getTypeName();
        this.b = networkInfo.getType();
        switch (d.a[networkInfo.getState().ordinal()]) {
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
