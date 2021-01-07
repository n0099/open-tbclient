package com.baidu.platform.comapi.wnplatform.i;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.baidu.mapapi.walknavi.model.RouteGuideKind;
import com.baidu.platform.comapi.walknavi.d.j;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class g extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ f f4646a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.f4646a = fVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        List list;
        List<a> list2;
        List list3;
        List<a> list4;
        List list5;
        List<a> list6;
        List list7;
        List<a> list8;
        List list9;
        List<a> list10;
        List list11;
        List<a> list12;
        com.baidu.platform.comapi.walknavi.g.a aVar;
        List list13;
        List<a> list14;
        switch (message.what) {
            case 4098:
                this.f4646a.a(message);
                return;
            case 4100:
                list13 = this.f4646a.f4644a;
                if (list13 != null) {
                    Bundle bundle = new Bundle();
                    com.baidu.platform.comapi.walknavi.b.a().G().a(bundle);
                    list14 = this.f4646a.f4644a;
                    for (a aVar2 : list14) {
                        if (aVar2 != null) {
                            aVar2.b(bundle);
                        }
                    }
                    return;
                }
                return;
            case 4101:
                list11 = this.f4646a.f4644a;
                if (list11 != null) {
                    Bundle bundle2 = new Bundle();
                    com.baidu.platform.comapi.walknavi.g.b.a.a(bundle2, 2, message.arg1, message.arg2);
                    list12 = this.f4646a.f4644a;
                    for (a aVar3 : list12) {
                        if (aVar3 != null) {
                            aVar3.c(bundle2);
                        }
                    }
                    return;
                }
                return;
            case 4102:
                list9 = this.f4646a.f4644a;
                if (list9 != null) {
                    list10 = this.f4646a.f4644a;
                    for (a aVar4 : list10) {
                        if (aVar4 != null) {
                            aVar4.f(null);
                        }
                    }
                    return;
                }
                return;
            case 4105:
                list7 = this.f4646a.f4644a;
                if (list7 != null) {
                    byte[] l = com.baidu.platform.comapi.walknavi.b.a().G().l();
                    list8 = this.f4646a.f4644a;
                    for (a aVar5 : list8) {
                        if (aVar5 != null) {
                            aVar5.a(l);
                        }
                    }
                    return;
                }
                return;
            case 4106:
                list5 = this.f4646a.f4644a;
                if (list5 != null) {
                    Bundle n = com.baidu.platform.comapi.walknavi.b.a().G().n();
                    list6 = this.f4646a.f4644a;
                    for (a aVar6 : list6) {
                        if (aVar6 != null) {
                            aVar6.e(n);
                        }
                    }
                    return;
                }
                return;
            case 4107:
                list3 = this.f4646a.f4644a;
                if (list3 != null) {
                    Bundle bundle3 = new Bundle();
                    com.baidu.platform.comapi.walknavi.b.a().a(bundle3);
                    list4 = this.f4646a.f4644a;
                    for (a aVar7 : list4) {
                        if (aVar7 != null) {
                            aVar7.a(bundle3);
                        }
                    }
                }
                if (!j.b()) {
                    this.f4646a.c();
                    return;
                }
                return;
            case 4108:
                list = this.f4646a.f4644a;
                if (list != null) {
                    Bundle bundle4 = new Bundle();
                    com.baidu.platform.comapi.walknavi.b.a().G().c(bundle4);
                    list2 = this.f4646a.f4644a;
                    for (a aVar8 : list2) {
                        if (aVar8 != null) {
                            aVar8.d(bundle4);
                        }
                    }
                    return;
                }
                return;
            case 4110:
                j.a(false);
                return;
            case 4111:
                int i = message.arg1;
                if ((com.baidu.platform.comapi.walknavi.b.a().T() instanceof com.baidu.platform.comapi.walknavi.g.a) && (aVar = (com.baidu.platform.comapi.walknavi.g.a) com.baidu.platform.comapi.walknavi.b.a().T()) != null) {
                    aVar.a(RouteGuideKind.values()[i]);
                    return;
                }
                return;
            case 65301:
                if (message.arg1 != 1 && message.arg1 == 0 && com.baidu.platform.comapi.walknavi.b.a().T() != null) {
                    com.baidu.platform.comapi.walknavi.b.a().T().s();
                    return;
                }
                return;
            default:
                return;
        }
    }
}
