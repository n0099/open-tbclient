package com.baidu.platform.comapi.wnplatform.i;

import android.os.Bundle;
import android.os.Handler;
import com.baidu.mapsdkplatform.comapi.map.MessageCenter;
/* loaded from: classes2.dex */
public class b extends com.baidu.platform.comapi.walknavi.a {

    /* renamed from: a  reason: collision with root package name */
    public a f9847a = null;

    /* renamed from: b  reason: collision with root package name */
    public int f9848b = 1;

    /* renamed from: c  reason: collision with root package name */
    public Handler f9849c;

    public b() {
        c cVar = new c(this);
        this.f9849c = cVar;
        MessageCenter.registMessage(4099, cVar);
        b();
    }

    private void b() {
    }

    @Override // com.baidu.platform.comapi.walknavi.a
    public boolean ready() {
        return true;
    }

    @Override // com.baidu.platform.comapi.walknavi.a
    public void release() {
        this.f9849c = null;
        this.f9847a = null;
        MessageCenter.registMessage(4099, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bundle a(int i) {
        return com.baidu.platform.comapi.walknavi.b.a().D().a(i);
    }

    public void a(a aVar) {
        this.f9847a = aVar;
    }

    public boolean a(int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4) {
        return com.baidu.platform.comapi.walknavi.b.a().D().a(iArr, iArr2, iArr3, iArr4);
    }

    public int a(int i, int i2, int i3, byte[] bArr) {
        a aVar = this.f9847a;
        if (aVar != null) {
            aVar.a();
        }
        return com.baidu.platform.comapi.walknavi.b.a().D().a(i, i2, i3, bArr);
    }

    public void a() {
        com.baidu.platform.comapi.walknavi.b.a().D().c();
    }
}
