package com.baidu.platform.comapi.wnplatform.h;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.baidu.mapapi.UIMsg;
import com.baidu.mapsdkplatform.comapi.map.MessageCenter;
import com.baidu.platform.comapi.walknavi.d.j;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class f extends com.baidu.platform.comapi.walknavi.a {

    /* renamed from: d  reason: collision with root package name */
    public static int f10280d;

    /* renamed from: a  reason: collision with root package name */
    public List<a> f10281a;

    /* renamed from: b  reason: collision with root package name */
    public List<b> f10282b;

    /* renamed from: c  reason: collision with root package name */
    public Handler f10283c = new g(this);

    /* renamed from: e  reason: collision with root package name */
    public com.baidu.platform.comapi.wnplatform.j.b f10284e = new h(this);

    /* renamed from: f  reason: collision with root package name */
    public com.baidu.platform.comapi.wnplatform.c.b f10285f = new i(this);

    public static /* synthetic */ int a() {
        int i = f10280d;
        f10280d = i + 1;
        return i;
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

    @Override // com.baidu.platform.comapi.walknavi.a
    public boolean ready() {
        MessageCenter.registMessage(4098, this.f10283c);
        MessageCenter.registMessage(4100, this.f10283c);
        MessageCenter.registMessage(4101, this.f10283c);
        MessageCenter.registMessage(4102, this.f10283c);
        MessageCenter.registMessage(4105, this.f10283c);
        MessageCenter.registMessage(4106, this.f10283c);
        MessageCenter.registMessage(UIMsg.WalkNaviMsg.NL_UI_MESSAGE_TYPE_SPEED_UPDATE, this.f10283c);
        MessageCenter.registMessage(4111, this.f10283c);
        MessageCenter.registMessage(4110, this.f10283c);
        MessageCenter.registMessage(4108, this.f10283c);
        int i = com.baidu.platform.comapi.walknavi.g.a.b.f10067a;
        if (i == 1) {
            com.baidu.platform.comapi.walknavi.b.a().P().a(this.f10285f);
            com.baidu.platform.comapi.walknavi.b.a().D().c(1);
        } else if (i == 2) {
            com.baidu.platform.comapi.walknavi.b.a().D().c(2);
        } else if (i == 3) {
            com.baidu.platform.comapi.walknavi.b.a().S().a(this.f10285f);
            com.baidu.platform.comapi.walknavi.b.a().D().c(3);
        }
        com.baidu.platform.comapi.walknavi.b.a().O().a(this.f10284e);
        return true;
    }

    @Override // com.baidu.platform.comapi.walknavi.a
    public void release() {
        this.f10281a = null;
        this.f10282b = null;
        MessageCenter.unregistMessage(4098, this.f10283c);
        MessageCenter.unregistMessage(4100, this.f10283c);
        MessageCenter.unregistMessage(4101, this.f10283c);
        MessageCenter.unregistMessage(4102, this.f10283c);
        MessageCenter.unregistMessage(4105, this.f10283c);
        MessageCenter.unregistMessage(4106, this.f10283c);
        MessageCenter.unregistMessage(UIMsg.WalkNaviMsg.NL_UI_MESSAGE_TYPE_SPEED_UPDATE, this.f10283c);
        MessageCenter.unregistMessage(4111, this.f10283c);
        MessageCenter.unregistMessage(4110, this.f10283c);
        MessageCenter.unregistMessage(4108, this.f10283c);
        this.f10283c = null;
    }

    public void b(a aVar) {
        List<a> list = this.f10281a;
        if (list == null || aVar == null) {
            return;
        }
        list.remove(aVar);
    }

    public void a(a aVar) {
        if (this.f10281a == null) {
            this.f10281a = new LinkedList();
        }
        this.f10281a.add(aVar);
    }

    public void b(b bVar) {
        List<b> list = this.f10282b;
        if (list == null || bVar == null) {
            return;
        }
        list.remove(bVar);
    }

    public void a(b bVar) {
        if (this.f10282b == null) {
            this.f10282b = new LinkedList();
        }
        this.f10282b.add(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Message message) {
        List<b> list = this.f10282b;
        if (list == null) {
            return;
        }
        int i = message.arg1;
        if (i == 2) {
            if (list != null) {
                for (b bVar : list) {
                    if (bVar != null) {
                        bVar.b(message);
                    }
                }
            }
            j.a().f();
        } else if (i == 3) {
            if (list != null) {
                for (b bVar2 : list) {
                    if (bVar2 != null) {
                        bVar2.c(message);
                    }
                }
            }
            j.a().g();
        } else if (i == 4) {
            com.baidu.platform.comapi.walknavi.b.a().R().a(a(1), 1);
            List<b> list2 = this.f10282b;
            if (list2 != null) {
                for (b bVar3 : list2) {
                    if (bVar3 != null) {
                        bVar3.d(message);
                    }
                }
            }
        } else if (i == 5) {
            if (list != null) {
                for (b bVar4 : list) {
                    if (bVar4 != null) {
                        bVar4.e(message);
                    }
                }
            }
        } else if (i == 7) {
            if (com.baidu.platform.comapi.walknavi.d.e.c().d()) {
                j.a().e();
                return;
            }
            List<b> list3 = this.f10282b;
            if (list3 != null) {
                for (b bVar5 : list3) {
                    if (bVar5 != null) {
                        bVar5.f(message);
                    }
                }
            }
        }
    }

    private Bundle a(int i) {
        return com.baidu.platform.comapi.walknavi.b.a().D().a(i);
    }
}
