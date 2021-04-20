package com.baidu.mapsdkplatform.comapi.synchronization.data;

import android.os.Message;
import com.baidu.mapsdkplatform.comapi.synchronization.c.c;
import com.baidu.mapsdkplatform.comapi.synchronization.data.g;
import com.baidu.wallet.base.widget.CustomerServiceMenu;
/* loaded from: classes2.dex */
public class h extends com.baidu.mapsdkplatform.comapi.synchronization.c.e {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ g f7846a;

    public h(g gVar) {
        this.f7846a = gVar;
    }

    @Override // com.baidu.mapsdkplatform.comapi.synchronization.c.e
    public void a(c.a aVar) {
        g.b bVar;
        g.b bVar2;
        g.b bVar3;
        bVar = this.f7846a.j;
        Message obtainMessage = bVar.obtainMessage();
        obtainMessage.what = CustomerServiceMenu.TRANSFER_RECORD;
        obtainMessage.obj = aVar;
        bVar2 = this.f7846a.j;
        if (bVar2 != null) {
            bVar3 = this.f7846a.j;
            bVar3.sendMessage(obtainMessage);
        }
        if (c.a.SERVER_ERROR == aVar || c.a.NETWORK_ERROR == aVar || c.a.INNER_ERROR == aVar) {
            g.b(this.f7846a);
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.synchronization.c.e
    public void a(String str) {
        g.b bVar;
        g.b bVar2;
        g.b bVar3;
        bVar = this.f7846a.j;
        Message obtainMessage = bVar.obtainMessage();
        obtainMessage.what = 100000;
        obtainMessage.obj = str;
        bVar2 = this.f7846a.j;
        if (bVar2 != null) {
            bVar3 = this.f7846a.j;
            bVar3.sendMessage(obtainMessage);
        }
        this.f7846a.k = 0;
    }
}
