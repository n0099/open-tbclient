package com.baidu.platform.comapi.wnplatform.model;

import android.os.Bundle;
/* loaded from: classes3.dex */
public class b extends com.baidu.platform.comapi.walknavi.a {

    /* renamed from: a  reason: collision with root package name */
    private e f4661a;

    /* renamed from: b  reason: collision with root package name */
    private d f4662b;

    @Override // com.baidu.platform.comapi.walknavi.a
    public void release() {
        this.f4661a = null;
        this.f4662b = null;
    }

    @Override // com.baidu.platform.comapi.walknavi.a
    public boolean ready() {
        return true;
    }

    public e a() {
        if (this.f4661a == null) {
            this.f4661a = new e();
        }
        return this.f4661a;
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
