package com.baidu.platform.comapi.walknavi.g;

import android.app.Activity;
import android.content.Intent;
import com.baidu.platform.comapi.walknavi.widget.a;
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class g implements a.InterfaceC0105a {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(a aVar) {
        this.a = aVar;
    }

    @Override // com.baidu.platform.comapi.walknavi.widget.a.InterfaceC0105a
    public void a() {
        Activity activity;
        Activity activity2;
        Activity activity3;
        Activity activity4;
        try {
            Intent intent = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
            activity4 = this.a.i;
            activity4.startActivity(intent);
        } catch (Exception e) {
            activity = this.a.i;
            if (activity != null) {
                activity2 = this.a.i;
                activity3 = this.a.i;
                com.baidu.platform.comapi.walknavi.g.c.b.a(activity2, com.baidu.platform.comapi.wnplatform.o.a.a.b(activity3, R.string.abc_capital_on));
            }
        }
    }
}
