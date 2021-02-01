package com.baidu.mapsdkplatform.comapi.synchronization.data;

import android.os.Message;
import com.baidu.mapsdkplatform.comapi.synchronization.c.c;
import com.baidu.mapsdkplatform.comapi.synchronization.data.g;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class h extends com.baidu.mapsdkplatform.comapi.synchronization.c.e {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ g f3128a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.f3128a = gVar;
    }

    @Override // com.baidu.mapsdkplatform.comapi.synchronization.c.e
    public void a(c.a aVar) {
        g.b bVar;
        g.b bVar2;
        g.b bVar3;
        bVar = this.f3128a.j;
        Message obtainMessage = bVar.obtainMessage();
        obtainMessage.what = 100001;
        obtainMessage.obj = aVar;
        bVar2 = this.f3128a.j;
        if (bVar2 != null) {
            bVar3 = this.f3128a.j;
            bVar3.sendMessage(obtainMessage);
        }
        if (c.a.SERVER_ERROR == aVar || c.a.NETWORK_ERROR == aVar || c.a.INNER_ERROR == aVar) {
            g.b(this.f3128a);
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.synchronization.c.e
    public void a(String str) {
        g.b bVar;
        g.b bVar2;
        g.b bVar3;
        bVar = this.f3128a.j;
        Message obtainMessage = bVar.obtainMessage();
        obtainMessage.what = 100000;
        obtainMessage.obj = str;
        bVar2 = this.f3128a.j;
        if (bVar2 != null) {
            bVar3 = this.f3128a.j;
            bVar3.sendMessage(obtainMessage);
        }
        this.f3128a.k = 0;
    }
}
