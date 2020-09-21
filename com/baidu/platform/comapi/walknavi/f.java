package com.baidu.platform.comapi.walknavi;

import android.net.wifi.WifiManager;
import com.baidu.platform.comapi.walknavi.g.a;
import com.baidu.platform.comapi.walknavi.widget.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class f implements a.InterfaceC0252a {
    final /* synthetic */ WifiManager a;
    final /* synthetic */ a.b b;
    final /* synthetic */ int c;
    final /* synthetic */ b d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(b bVar, WifiManager wifiManager, a.b bVar2, int i) {
        this.d = bVar;
        this.a = wifiManager;
        this.b = bVar2;
        this.c = i;
    }

    @Override // com.baidu.platform.comapi.walknavi.widget.a.InterfaceC0252a
    public void a() {
        this.a.setWifiEnabled(true);
        if (this.b != null) {
            this.b.a(this.c);
        }
    }
}
