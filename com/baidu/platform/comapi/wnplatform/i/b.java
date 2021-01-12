package com.baidu.platform.comapi.wnplatform.i;

import android.os.Bundle;
import android.os.Handler;
import com.baidu.mapsdkplatform.comapi.map.MessageCenter;
/* loaded from: classes6.dex */
public class b extends com.baidu.platform.comapi.walknavi.a {

    /* renamed from: a  reason: collision with root package name */
    private a f4418a = null;

    /* renamed from: b  reason: collision with root package name */
    private int f4419b = 1;
    private Handler c = new c(this);

    public b() {
        MessageCenter.registMessage(4099, this.c);
        b();
    }

    @Override // com.baidu.platform.comapi.walknavi.a
    public void release() {
        this.c = null;
        this.f4418a = null;
        MessageCenter.registMessage(4099, this.c);
    }

    @Override // com.baidu.platform.comapi.walknavi.a
    public boolean ready() {
        return true;
    }

    private void b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bundle a(int i) {
        return com.baidu.platform.comapi.walknavi.b.a().D().a(i);
    }

    public void a(a aVar) {
        this.f4418a = aVar;
    }

    public boolean a(int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4) {
        return com.baidu.platform.comapi.walknavi.b.a().D().a(iArr, iArr2, iArr3, iArr4);
    }

    public int a(int i, int i2, int i3, byte[] bArr) {
        if (this.f4418a != null) {
            this.f4418a.a();
        }
        return com.baidu.platform.comapi.walknavi.b.a().D().a(i, i2, i3, bArr);
    }

    public void a() {
        com.baidu.platform.comapi.walknavi.b.a().D().c();
    }
}
