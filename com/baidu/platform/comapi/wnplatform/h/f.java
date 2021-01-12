package com.baidu.platform.comapi.wnplatform.h;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.baidu.mapapi.UIMsg;
import com.baidu.mapsdkplatform.comapi.map.MessageCenter;
import com.baidu.platform.comapi.walknavi.d.j;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes6.dex */
public class f extends com.baidu.platform.comapi.walknavi.a {
    private static int d = 0;

    /* renamed from: a  reason: collision with root package name */
    private List<a> f4413a;

    /* renamed from: b  reason: collision with root package name */
    private List<b> f4414b;
    private Handler c = new g(this);
    private com.baidu.platform.comapi.wnplatform.j.b e = new h(this);
    private com.baidu.platform.comapi.wnplatform.c.b f = new i(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int a() {
        int i = d;
        d = i + 1;
        return i;
    }

    @Override // com.baidu.platform.comapi.walknavi.a
    public void release() {
        this.f4413a = null;
        this.f4414b = null;
        MessageCenter.unregistMessage(4098, this.c);
        MessageCenter.unregistMessage(4100, this.c);
        MessageCenter.unregistMessage(4101, this.c);
        MessageCenter.unregistMessage(4102, this.c);
        MessageCenter.unregistMessage(4105, this.c);
        MessageCenter.unregistMessage(4106, this.c);
        MessageCenter.unregistMessage(UIMsg.WalkNaviMsg.NL_UI_MESSAGE_TYPE_SPEED_UPDATE, this.c);
        MessageCenter.unregistMessage(4111, this.c);
        MessageCenter.unregistMessage(4110, this.c);
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
        MessageCenter.registMessage(4111, this.c);
        MessageCenter.registMessage(4110, this.c);
        MessageCenter.registMessage(4108, this.c);
        switch (com.baidu.platform.comapi.walknavi.g.a.b.f4282a) {
            case 1:
                com.baidu.platform.comapi.walknavi.b.a().P().a(this.f);
                com.baidu.platform.comapi.walknavi.b.a().D().c(1);
                break;
            case 2:
                com.baidu.platform.comapi.walknavi.b.a().D().c(2);
                break;
            case 3:
                com.baidu.platform.comapi.walknavi.b.a().S().a(this.f);
                com.baidu.platform.comapi.walknavi.b.a().D().c(3);
                break;
        }
        com.baidu.platform.comapi.walknavi.b.a().O().a(this.e);
        return true;
    }

    public void a(a aVar) {
        if (this.f4413a == null) {
            this.f4413a = new LinkedList();
        }
        this.f4413a.add(aVar);
    }

    public void b(a aVar) {
        if (this.f4413a != null && aVar != null) {
            this.f4413a.remove(aVar);
        }
    }

    public void a(b bVar) {
        if (this.f4414b == null) {
            this.f4414b = new LinkedList();
        }
        this.f4414b.add(bVar);
    }

    public void b(b bVar) {
        if (this.f4414b != null && bVar != null) {
            this.f4414b.remove(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (com.baidu.platform.comapi.walknavi.b.a().Q() != null) {
            if (com.baidu.platform.comapi.walknavi.b.a().Q().r() > 0.2d) {
                j.a().a();
            } else {
                j.a().b();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Message message) {
        if (this.f4414b != null) {
            switch (message.arg1) {
                case 2:
                    if (this.f4414b != null) {
                        for (b bVar : this.f4414b) {
                            if (bVar != null) {
                                bVar.b(message);
                            }
                        }
                    }
                    j.a().f();
                    return;
                case 3:
                    if (this.f4414b != null) {
                        for (b bVar2 : this.f4414b) {
                            if (bVar2 != null) {
                                bVar2.c(message);
                            }
                        }
                    }
                    j.a().g();
                    return;
                case 4:
                    com.baidu.platform.comapi.walknavi.b.a().R().a(a(1), 1);
                    if (this.f4414b != null) {
                        for (b bVar3 : this.f4414b) {
                            if (bVar3 != null) {
                                bVar3.d(message);
                            }
                        }
                        return;
                    }
                    return;
                case 5:
                    if (this.f4414b != null) {
                        for (b bVar4 : this.f4414b) {
                            if (bVar4 != null) {
                                bVar4.e(message);
                            }
                        }
                        return;
                    }
                    return;
                case 6:
                default:
                    return;
                case 7:
                    if (com.baidu.platform.comapi.walknavi.d.e.c().d()) {
                        j.a().e();
                        return;
                    } else if (this.f4414b != null) {
                        for (b bVar5 : this.f4414b) {
                            if (bVar5 != null) {
                                bVar5.f(message);
                            }
                        }
                        return;
                    } else {
                        return;
                    }
            }
        }
    }

    private Bundle a(int i) {
        return com.baidu.platform.comapi.walknavi.b.a().D().a(i);
    }
}
