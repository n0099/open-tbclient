package com.baidu.platform.comapi.wnplatform.h;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.baidu.mapapi.UIMsg;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class f extends Handler {
    final /* synthetic */ e a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.a = eVar;
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
        switch (message.what) {
            case 4098:
                this.a.a(message);
                return;
            case 4099:
            case 4103:
            case 4104:
            default:
                return;
            case 4100:
                list13 = this.a.a;
                if (list13 != null) {
                    Bundle bundle = new Bundle();
                    com.baidu.platform.comapi.walknavi.b.a().y().a(bundle);
                    list14 = this.a.a;
                    for (a aVar : list14) {
                        if (aVar != null) {
                            aVar.b(bundle);
                        }
                    }
                    return;
                }
                return;
            case 4101:
                list11 = this.a.a;
                if (list11 != null) {
                    Bundle bundle2 = new Bundle();
                    com.baidu.platform.comapi.walknavi.g.a.a.a(bundle2, 2, message.arg1, message.arg2);
                    list12 = this.a.a;
                    for (a aVar2 : list12) {
                        if (aVar2 != null) {
                            aVar2.c(bundle2);
                        }
                    }
                    return;
                }
                return;
            case 4102:
                list9 = this.a.a;
                if (list9 != null) {
                    list10 = this.a.a;
                    for (a aVar3 : list10) {
                        if (aVar3 != null) {
                            aVar3.f(null);
                        }
                    }
                    return;
                }
                return;
            case 4105:
                list7 = this.a.a;
                if (list7 != null) {
                    byte[] k = com.baidu.platform.comapi.walknavi.b.a().y().k();
                    list8 = this.a.a;
                    for (a aVar4 : list8) {
                        if (aVar4 != null) {
                            aVar4.a(k);
                        }
                    }
                    return;
                }
                return;
            case 4106:
                list5 = this.a.a;
                if (list5 != null) {
                    Bundle n = com.baidu.platform.comapi.walknavi.b.a().y().n();
                    list6 = this.a.a;
                    for (a aVar5 : list6) {
                        if (aVar5 != null) {
                            aVar5.e(n);
                        }
                    }
                    return;
                }
                return;
            case UIMsg.WalkNaviMsg.NL_UI_MESSAGE_TYPE_SPEED_UPDATE /* 4107 */:
                list3 = this.a.a;
                if (list3 != null) {
                    Bundle bundle3 = new Bundle();
                    com.baidu.platform.comapi.walknavi.b.a().a(bundle3);
                    list4 = this.a.a;
                    for (a aVar6 : list4) {
                        if (aVar6 != null) {
                            aVar6.a(bundle3);
                        }
                    }
                    return;
                }
                return;
            case 4108:
                list = this.a.a;
                if (list != null) {
                    Bundle bundle4 = new Bundle();
                    com.baidu.platform.comapi.walknavi.b.a().y().c(bundle4);
                    list2 = this.a.a;
                    for (a aVar7 : list2) {
                        if (aVar7 != null) {
                            aVar7.d(bundle4);
                        }
                    }
                    return;
                }
                return;
        }
    }
}
