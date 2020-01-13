package com.baidu.platform.comapi.walknavi.g.b;

import android.content.Context;
import com.baidu.mapapi.NetworkUtil;
import com.baidu.platform.comapi.walknavi.g.b.c;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
class u implements Runnable {
    final /* synthetic */ t a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar) {
        this.a = tVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        Context context2;
        Context context3;
        context = this.a.b.l;
        if (!NetworkUtil.isWifiState(context)) {
            context2 = this.a.b.l;
            if (context2 != null) {
                c cVar = this.a.b;
                String str = this.a.a;
                context3 = this.a.b.l;
                cVar.a(str, com.baidu.platform.comapi.wnplatform.o.a.a.b(context3, R.string.status_bar_notification_info_overflow), 4);
                return;
            }
            return;
        }
        this.a.b.a(this.a.a, (c.d) null);
    }
}
