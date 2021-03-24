package com.baidu.platform.comapi.wnplatform.h;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.baidu.mapapi.UIMsg;
import com.baidu.mapapi.walknavi.model.RouteGuideKind;
import com.baidu.platform.comapi.walknavi.d.j;
import java.util.List;
/* loaded from: classes2.dex */
public class g extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ f f10285a;

    public g(f fVar) {
        this.f10285a = fVar;
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
        List list13;
        List<a> list14;
        com.baidu.platform.comapi.walknavi.g.a aVar;
        switch (message.what) {
            case 4098:
                this.f10285a.a(message);
                return;
            case 4099:
            case 4103:
            case 4104:
            case UIMsg.k_event.MV_MAP_SETMAPMODE /* 4109 */:
            default:
                return;
            case 4100:
                list = this.f10285a.f10280a;
                if (list != null) {
                    Bundle bundle = new Bundle();
                    com.baidu.platform.comapi.walknavi.b.a().D().a(bundle);
                    list2 = this.f10285a.f10280a;
                    for (a aVar2 : list2) {
                        if (aVar2 != null) {
                            aVar2.b(bundle);
                        }
                    }
                    return;
                }
                return;
            case 4101:
                list3 = this.f10285a.f10280a;
                if (list3 != null) {
                    Bundle bundle2 = new Bundle();
                    com.baidu.platform.comapi.walknavi.g.a.a.a(bundle2, 2, message.arg1, message.arg2);
                    list4 = this.f10285a.f10280a;
                    for (a aVar3 : list4) {
                        if (aVar3 != null) {
                            aVar3.c(bundle2);
                        }
                    }
                    return;
                }
                return;
            case 4102:
                list5 = this.f10285a.f10280a;
                if (list5 != null) {
                    list6 = this.f10285a.f10280a;
                    for (a aVar4 : list6) {
                        if (aVar4 != null) {
                            aVar4.f(null);
                        }
                    }
                    return;
                }
                return;
            case 4105:
                list7 = this.f10285a.f10280a;
                if (list7 != null) {
                    byte[] l = com.baidu.platform.comapi.walknavi.b.a().D().l();
                    list8 = this.f10285a.f10280a;
                    for (a aVar5 : list8) {
                        if (aVar5 != null) {
                            aVar5.a(l);
                        }
                    }
                    return;
                }
                return;
            case 4106:
                list9 = this.f10285a.f10280a;
                if (list9 != null) {
                    Bundle n = com.baidu.platform.comapi.walknavi.b.a().D().n();
                    list10 = this.f10285a.f10280a;
                    for (a aVar6 : list10) {
                        if (aVar6 != null) {
                            aVar6.e(n);
                        }
                    }
                    return;
                }
                return;
            case UIMsg.WalkNaviMsg.NL_UI_MESSAGE_TYPE_SPEED_UPDATE /* 4107 */:
                list11 = this.f10285a.f10280a;
                if (list11 != null) {
                    Bundle bundle3 = new Bundle();
                    com.baidu.platform.comapi.walknavi.b.a().a(bundle3);
                    list12 = this.f10285a.f10280a;
                    for (a aVar7 : list12) {
                        if (aVar7 != null) {
                            aVar7.a(bundle3);
                        }
                    }
                }
                if (j.b()) {
                    return;
                }
                this.f10285a.c();
                return;
            case 4108:
                list13 = this.f10285a.f10280a;
                if (list13 != null) {
                    Bundle bundle4 = new Bundle();
                    com.baidu.platform.comapi.walknavi.b.a().D().c(bundle4);
                    list14 = this.f10285a.f10280a;
                    for (a aVar8 : list14) {
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
                if (!(com.baidu.platform.comapi.walknavi.b.a().Q() instanceof com.baidu.platform.comapi.walknavi.g.a) || (aVar = (com.baidu.platform.comapi.walknavi.g.a) com.baidu.platform.comapi.walknavi.b.a().Q()) == null) {
                    return;
                }
                aVar.a(RouteGuideKind.values()[i]);
                return;
        }
    }
}
