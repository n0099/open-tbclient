package com.baidu.platform.comapi.walknavi;

import android.net.wifi.WifiManager;
import com.baidu.platform.comapi.walknavi.g.a;
import com.baidu.platform.comapi.walknavi.widget.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class f implements a.InterfaceC0291a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WifiManager f3007a;
    final /* synthetic */ a.b b;
    final /* synthetic */ int c;
    final /* synthetic */ b d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(b bVar, WifiManager wifiManager, a.b bVar2, int i) {
        this.d = bVar;
        this.f3007a = wifiManager;
        this.b = bVar2;
        this.c = i;
    }

    @Override // com.baidu.platform.comapi.walknavi.widget.a.InterfaceC0291a
    public void a() {
        this.f3007a.setWifiEnabled(true);
        if (this.b != null) {
            this.b.a(this.c);
        }
    }
}
