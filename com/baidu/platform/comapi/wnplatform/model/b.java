package com.baidu.platform.comapi.wnplatform.model;

import android.os.Bundle;
/* loaded from: classes20.dex */
public class b extends com.baidu.platform.comapi.walknavi.a {
    private e a;
    private d b;

    @Override // com.baidu.platform.comapi.walknavi.a
    public void release() {
        this.a = null;
        this.b = null;
    }

    @Override // com.baidu.platform.comapi.walknavi.a
    public boolean ready() {
        return true;
    }

    public e a() {
        if (this.a == null) {
            this.a = new e();
        }
        return this.a;
    }

    public void a(Bundle bundle, int i) {
        if (bundle != null) {
            a().a(bundle, i);
        }
    }

    public boolean a(com.baidu.platform.comapi.wnplatform.e.a aVar) {
        if (aVar == null) {
            return false;
        }
        return a().a(aVar);
    }

    public int b() {
        return a().e();
    }
}
