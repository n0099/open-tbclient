package com.baidu.platform.comapi.wnplatform.i;

import android.os.Bundle;
import android.os.Handler;
import com.baidu.mapsdkplatform.comapi.map.MessageCenter;
/* loaded from: classes4.dex */
public class b extends com.baidu.platform.comapi.walknavi.a {
    private a a = null;
    private int b = 1;
    private Handler c = new c(this);

    public b() {
        MessageCenter.registMessage(4099, this.c);
        a();
    }

    @Override // com.baidu.platform.comapi.walknavi.a
    public void release() {
        this.c = null;
        this.a = null;
        MessageCenter.registMessage(4099, this.c);
    }

    @Override // com.baidu.platform.comapi.walknavi.a
    public boolean ready() {
        return true;
    }

    private void a() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bundle a(int i) {
        return com.baidu.platform.comapi.walknavi.b.a().y().a(i);
    }

    public void a(a aVar) {
        this.a = aVar;
    }

    public boolean a(int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4) {
        return com.baidu.platform.comapi.walknavi.b.a().y().a(iArr, iArr2, iArr3, iArr4);
    }

    public int a(int i, int i2, int i3, byte[] bArr) {
        if (this.a != null) {
            this.a.a();
        }
        return com.baidu.platform.comapi.walknavi.b.a().y().a(i, i2, i3, bArr);
    }
}
