package com.baidu.platform.comapi.wnplatform.h;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.baidu.mapapi.UIMsg;
import com.baidu.mapsdkplatform.comapi.map.MessageCenter;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class e extends com.baidu.platform.comapi.walknavi.a {
    private List<a> a;
    private List<b> b;
    private Handler c = new f(this);
    private com.baidu.platform.comapi.wnplatform.j.b d = new g(this);
    private com.baidu.platform.comapi.wnplatform.b.b e = new h(this);

    @Override // com.baidu.platform.comapi.walknavi.a
    public void release() {
        this.a = null;
        this.b = null;
        MessageCenter.unregistMessage(4098, this.c);
        MessageCenter.unregistMessage(4100, this.c);
        MessageCenter.unregistMessage(4101, this.c);
        MessageCenter.unregistMessage(4102, this.c);
        MessageCenter.unregistMessage(4105, this.c);
        MessageCenter.unregistMessage(4106, this.c);
        MessageCenter.unregistMessage(UIMsg.WalkNaviMsg.NL_UI_MESSAGE_TYPE_SPEED_UPDATE, this.c);
        MessageCenter.unregistMessage(4108, this.c);
        this.c = null;
    }

    @Override // com.baidu.platform.comapi.walknavi.a
    public boolean ready() {
        MessageCenter.registMessage(4098, this.c);
        MessageCenter.registMessage(4100, this.c);
        MessageCenter.registMessage(4101, this.c);
        MessageCenter.registMessage(4102, this.c);
        MessageCenter.registMessage(4105, this.c);
        MessageCenter.registMessage(4106, this.c);
        MessageCenter.registMessage(UIMsg.WalkNaviMsg.NL_UI_MESSAGE_TYPE_SPEED_UPDATE, this.c);
        MessageCenter.registMessage(4108, this.c);
        switch (com.baidu.platform.comapi.walknavi.g.a.b.a) {
            case 1:
                com.baidu.platform.comapi.walknavi.b.a().K().a(this.e);
                com.baidu.platform.comapi.walknavi.b.a().y().c(1);
                break;
            case 2:
                com.baidu.platform.comapi.walknavi.b.a().y().c(2);
                break;
            case 3:
                com.baidu.platform.comapi.walknavi.b.a().N().a(this.e);
                com.baidu.platform.comapi.walknavi.b.a().y().c(3);
                break;
        }
        com.baidu.platform.comapi.walknavi.b.a().J().a(this.d);
        return true;
    }

    public void a(a aVar) {
        if (this.a == null) {
            this.a = new LinkedList();
        }
        this.a.add(aVar);
    }

    public void b(a aVar) {
        if (this.a != null && aVar != null) {
            this.a.remove(aVar);
        }
    }

    public void a(b bVar) {
        if (this.b == null) {
            this.b = new LinkedList();
        }
        this.b.add(bVar);
    }

    public void b(b bVar) {
        if (this.b != null && bVar != null) {
            this.b.remove(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Message message) {
        if (this.b != null) {
            switch (message.arg1) {
                case 2:
                    if (this.b != null) {
                        for (b bVar : this.b) {
                            if (bVar != null) {
                                bVar.b(message);
                            }
                        }
                        return;
                    }
                    return;
                case 3:
                    if (this.b != null) {
                        for (b bVar2 : this.b) {
                            if (bVar2 != null) {
                                bVar2.c(message);
                            }
                        }
                        return;
                    }
                    return;
                case 4:
                    com.baidu.platform.comapi.walknavi.b.a().M().a(a(1), 1);
                    if (this.b != null) {
                        for (b bVar3 : this.b) {
                            if (bVar3 != null) {
                                bVar3.d(message);
                            }
                        }
                        return;
                    }
                    return;
                case 5:
                    if (this.b != null) {
                        for (b bVar4 : this.b) {
                            if (bVar4 != null) {
                                bVar4.e(message);
                            }
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private Bundle a(int i) {
        return com.baidu.platform.comapi.walknavi.b.a().y().a(i);
    }
}
