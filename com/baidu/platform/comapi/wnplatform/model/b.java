package com.baidu.platform.comapi.wnplatform.model;

import android.os.Bundle;
/* loaded from: classes6.dex */
public class b extends com.baidu.platform.comapi.walknavi.a {

    /* renamed from: a  reason: collision with root package name */
    private d f4432a;

    /* renamed from: b  reason: collision with root package name */
    private c f4433b;

    @Override // com.baidu.platform.comapi.walknavi.a
    public void release() {
        this.f4432a = null;
        this.f4433b = null;
    }

    @Override // com.baidu.platform.comapi.walknavi.a
    public boolean ready() {
        return true;
    }

    public d a() {
        if (this.f4432a == null) {
            this.f4432a = new d();
        }
        return this.f4432a;
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
