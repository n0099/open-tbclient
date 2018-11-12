package com.baidu.platform.comapi.wnplatform.d;

import android.os.Bundle;
/* loaded from: classes4.dex */
public class b extends com.baidu.platform.comapi.walknavi.a {
    private d a;
    private c b;

    @Override // com.baidu.platform.comapi.walknavi.a
    public void release() {
        this.a = null;
        this.b = null;
    }

    @Override // com.baidu.platform.comapi.walknavi.a
    public boolean ready() {
        return true;
    }

    public d a() {
        if (this.a == null) {
            this.a = new d();
        }
        return this.a;
    }

    public void a(Bundle bundle, int i) {
        if (bundle != null) {
            a().a(bundle, i);
        }
    }

    public int b() {
        return a().b();
    }
}
