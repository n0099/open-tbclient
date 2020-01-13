package com.baidu.mapsdkplatform.comapi.synchronization.data;

import android.os.Message;
import com.baidu.mapsdkplatform.comapi.synchronization.c.c;
import com.baidu.mapsdkplatform.comapi.synchronization.data.g;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class h extends com.baidu.mapsdkplatform.comapi.synchronization.c.e {
    final /* synthetic */ g a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.a = gVar;
    }

    @Override // com.baidu.mapsdkplatform.comapi.synchronization.c.e
    public void a(c.a aVar) {
        g.b bVar;
        g.b bVar2;
        g.b bVar3;
        bVar = this.a.j;
        Message obtainMessage = bVar.obtainMessage();
        obtainMessage.what = 100001;
        obtainMessage.obj = aVar;
        bVar2 = this.a.j;
        if (bVar2 != null) {
            bVar3 = this.a.j;
            bVar3.sendMessage(obtainMessage);
        }
        if (c.a.SERVER_ERROR == aVar || c.a.NETWORK_ERROR == aVar || c.a.INNER_ERROR == aVar) {
            g.b(this.a);
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.synchronization.c.e
    public void a(String str) {
        g.b bVar;
        g.b bVar2;
        g.b bVar3;
        bVar = this.a.j;
        Message obtainMessage = bVar.obtainMessage();
        obtainMessage.what = 100000;
        obtainMessage.obj = str;
        bVar2 = this.a.j;
        if (bVar2 != null) {
            bVar3 = this.a.j;
            bVar3.sendMessage(obtainMessage);
        }
        this.a.k = 0;
    }
}
