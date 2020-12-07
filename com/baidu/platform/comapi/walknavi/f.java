package com.baidu.platform.comapi.walknavi;

import android.net.wifi.WifiManager;
import com.baidu.platform.comapi.walknavi.g.a;
import com.baidu.platform.comapi.walknavi.widget.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes26.dex */
public class f implements a.InterfaceC0302a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WifiManager f3009a;
    final /* synthetic */ a.b b;
    final /* synthetic */ int c;
    final /* synthetic */ b d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(b bVar, WifiManager wifiManager, a.b bVar2, int i) {
        this.d = bVar;
        this.f3009a = wifiManager;
        this.b = bVar2;
        this.c = i;
    }

    @Override // com.baidu.platform.comapi.walknavi.widget.a.InterfaceC0302a
    public void a() {
        this.f3009a.setWifiEnabled(true);
        if (this.b != null) {
            this.b.a(this.c);
        }
    }
}
