package com.baidu.platform.comapi.wnplatform.model;

import android.os.Bundle;
/* loaded from: classes2.dex */
public class b extends com.baidu.platform.comapi.walknavi.a {

    /* renamed from: a  reason: collision with root package name */
    public d f10242a;

    /* renamed from: b  reason: collision with root package name */
    public c f10243b;

    public d a() {
        if (this.f10242a == null) {
            this.f10242a = new d();
        }
        return this.f10242a;
    }

    public int b() {
        return a().b();
    }

    @Override // com.baidu.platform.comapi.walknavi.a
    public boolean ready() {
        return true;
    }

    @Override // com.baidu.platform.comapi.walknavi.a
    public void release() {
        this.f10242a = null;
        this.f10243b = null;
    }

    public void a(Bundle bundle, int i2) {
        if (bundle == null) {
            return;
        }
        a().a(bundle, i2);
    }
}
