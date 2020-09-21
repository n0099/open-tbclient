package com.baidu.platform.comapi.wnplatform.i;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.baidu.mapsdkplatform.comapi.map.MessageCenter;
import com.baidu.platform.comapi.walknavi.d.j;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class f extends com.baidu.platform.comapi.walknavi.a {
    private static int d = 0;
    private List<a> a;
    private List<b> b;
    private Handler c = new g(this);
    private com.baidu.platform.comapi.wnplatform.k.b e = new h(this);
    private com.baidu.platform.comapi.wnplatform.c.b f = new i(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int a() {
        int i = d;
        d = i + 1;
        return i;
    }

    @Override // com.baidu.platform.comapi.walknavi.a
    public void release() {
        MessageCenter.unregistMessage(4098, this.c);
        MessageCenter.unregistMessage(4100, this.c);
        MessageCenter.unregistMessage(4101, this.c);
        MessageCenter.unregistMessage(4102, this.c);
        MessageCenter.unregistMessage(4105, this.c);
        MessageCenter.unregistMessage(4106, this.c);
        MessageCenter.unregistMessage(4107, this.c);
        MessageCenter.unregistMessage(4111, this.c);
        MessageCenter.unregistMessage(4110, this.c);
        MessageCenter.unregistMessage(4108, this.c);
        this.c = null;
        this.a = null;
        this.b = null;
        com.baidu.platform.comapi.walknavi.b.a().S().b(this.f);
        this.f = null;
    }

    @Override // com.baidu.platform.comapi.walknavi.a
    public boolean ready() {
        MessageCenter.registMessage(65301, this.c);
        MessageCenter.registMessage(4098, this.c);
        MessageCenter.registMessage(4100, this.c);
        MessageCenter.registMessage(4101, this.c);
        MessageCenter.registMessage(4102, this.c);
        MessageCenter.registMessage(4105, this.c);
        MessageCenter.registMessage(4106, this.c);
        MessageCenter.registMessage(4107, this.c);
        MessageCenter.registMessage(4111, this.c);
        MessageCenter.registMessage(4110, this.c);
        MessageCenter.registMessage(4108, this.c);
        switch (com.baidu.platform.comapi.walknavi.g.b.b.a) {
            case 1:
                com.baidu.platform.comapi.walknavi.b.a().S().a(this.f);
                com.baidu.platform.comapi.walknavi.b.a().G().d(1);
                break;
            case 2:
                com.baidu.platform.comapi.walknavi.b.a().G().d(2);
                break;
            case 3:
                com.baidu.platform.comapi.walknavi.b.a().V().a(this.f);
                com.baidu.platform.comapi.walknavi.b.a().G().d(3);
                break;
        }
        com.baidu.platform.comapi.walknavi.b.a().R().a(this.e);
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
            this.a = null;
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
            this.b = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (com.baidu.platform.comapi.walknavi.b.a().T() != null) {
            if (com.baidu.platform.comapi.walknavi.b.a().T().r() > 0.2d) {
                j.a().a();
            } else {
                j.a().b();
            }
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
                    }
                    j.a().f();
                    return;
                case 3:
                    if (this.b != null) {
                        for (b bVar2 : this.b) {
                            if (bVar2 != null) {
                                bVar2.c(message);
                            }
                        }
                    }
                    j.a().g();
                    return;
                case 4:
                    com.baidu.platform.comapi.walknavi.b.a().U().a(a(1), 1);
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
                case 6:
                    if (this.b != null) {
                        for (b bVar5 : this.b) {
                            if (bVar5 != null) {
                                bVar5.f(message);
                            }
                        }
                        return;
                    }
                    return;
                case 7:
                    if (com.baidu.platform.comapi.walknavi.d.e.c().d()) {
                        j.a().e();
                        return;
                    } else if (this.b != null) {
                        for (b bVar6 : this.b) {
                            if (bVar6 != null) {
                                bVar6.g(message);
                            }
                        }
                        return;
                    } else {
                        return;
                    }
                default:
                    return;
            }
        }
    }

    private Bundle a(int i) {
        return com.baidu.platform.comapi.walknavi.b.a().G().b(i);
    }
}
