package com.baidu.platform.comapi.wnplatform.i;

import android.os.Bundle;
import android.os.Handler;
import com.baidu.mapsdkplatform.comapi.map.MessageCenter;
/* loaded from: classes2.dex */
public class b extends com.baidu.platform.comapi.walknavi.a {

    /* renamed from: a  reason: collision with root package name */
    public a f10212a = null;

    /* renamed from: b  reason: collision with root package name */
    public int f10213b = 1;

    /* renamed from: c  reason: collision with root package name */
    public Handler f10214c;

    public b() {
        c cVar = new c(this);
        this.f10214c = cVar;
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
        this.f10214c = null;
        this.f10212a = null;
        MessageCenter.registMessage(4099, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bundle a(int i2) {
        return com.baidu.platform.comapi.walknavi.b.a().D().a(i2);
    }

    public void a(a aVar) {
        this.f10212a = aVar;
    }

    public boolean a(int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4) {
        return com.baidu.platform.comapi.walknavi.b.a().D().a(iArr, iArr2, iArr3, iArr4);
    }

    public int a(int i2, int i3, int i4, byte[] bArr) {
        a aVar = this.f10212a;
        if (aVar != null) {
            aVar.a();
        }
        return com.baidu.platform.comapi.walknavi.b.a().D().a(i2, i3, i4, bArr);
    }

    public void a() {
        com.baidu.platform.comapi.walknavi.b.a().D().c();
    }
}
