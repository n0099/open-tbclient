package com.baidu.platform.comapi.wnplatform.model;

import android.os.Bundle;
/* loaded from: classes15.dex */
public class b extends com.baidu.platform.comapi.walknavi.a {

    /* renamed from: a  reason: collision with root package name */
    private e f4660a;

    /* renamed from: b  reason: collision with root package name */
    private d f4661b;

    @Override // com.baidu.platform.comapi.walknavi.a
    public void release() {
        this.f4660a = null;
        this.f4661b = null;
    }

    @Override // com.baidu.platform.comapi.walknavi.a
    public boolean ready() {
        return true;
    }

    public e a() {
        if (this.f4660a == null) {
            this.f4660a = new e();
        }
        return this.f4660a;
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
