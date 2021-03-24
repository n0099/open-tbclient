package com.baidu.platform.comapi.wnplatform.model;

import android.os.Bundle;
/* loaded from: classes2.dex */
public class b extends com.baidu.platform.comapi.walknavi.a {

    /* renamed from: a  reason: collision with root package name */
    public d f10316a;

    /* renamed from: b  reason: collision with root package name */
    public c f10317b;

    public d a() {
        if (this.f10316a == null) {
            this.f10316a = new d();
        }
        return this.f10316a;
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
        this.f10316a = null;
        this.f10317b = null;
    }

    public void a(Bundle bundle, int i) {
        if (bundle == null) {
            return;
        }
        a().a(bundle, i);
    }
}
