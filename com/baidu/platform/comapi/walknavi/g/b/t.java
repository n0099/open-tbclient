package com.baidu.platform.comapi.walknavi.g.b;

import android.os.Handler;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class t implements com.baidu.platform.comapi.walknavi.d.c {
    final /* synthetic */ String a;
    final /* synthetic */ c b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(c cVar, String str) {
        this.b = cVar;
        this.a = str;
    }

    @Override // com.baidu.platform.comapi.walknavi.d.c
    public void a(boolean z, float f) {
        Handler handler;
        if (z) {
            this.b.R = z;
            handler = this.b.n;
            handler.postDelayed(new u(this), 500L);
            return;
        }
        com.baidu.platform.comapi.walknavi.d.e.c().a(this.a, true);
    }

    @Override // com.baidu.platform.comapi.walknavi.d.c
    public void a(int i) {
        com.baidu.platform.comapi.wnplatform.d.a.b("aaaaa progress: " + i);
    }

    @Override // com.baidu.platform.comapi.walknavi.d.c
    public void a(int i, String str) {
        com.baidu.platform.comapi.wnplatform.d.a.b("aaaaa responseCode = " + i + ", responseMessage = " + str);
    }
}
