package com.baidu.platform.comapi.wnplatform.d;

import android.os.Bundle;
/* loaded from: classes4.dex */
public class d extends a {
    private int a = 0;
    private int b = 0;
    private int c = 1;

    public void a() {
        this.a = 0;
        this.b = 0;
    }

    public void a(Bundle bundle, int i) {
        a();
        if (bundle != null) {
            this.c = i;
            this.a = bundle.getInt("totaldistance");
            this.b = bundle.getInt("totaltime");
        }
    }

    public int b() {
        return this.a;
    }
}
