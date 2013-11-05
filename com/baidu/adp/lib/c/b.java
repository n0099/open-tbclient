package com.baidu.adp.lib.c;

import android.location.Address;
import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f421a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.f421a = aVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i;
        int i2;
        switch (message.what) {
            case 0:
                this.f421a.d();
                String str = "";
                i = this.f421a.j;
                switch (i) {
                    case 1:
                        str = "糟糕！检测不到地理位置信息哦亲，请在手机设置中开启GPS功能";
                        break;
                    case 2:
                        str = "糟糕！检测不到地理位置信息哦亲，请在手机设置中开启无线网络定位功能";
                        break;
                    case 3:
                        str = "糟糕！检测不到地理位置信息哦亲，请在手机设置中开启GPS或者无线网络定位功能";
                        break;
                    case 4:
                        str = "糟糕！定位失败，请稍后再试";
                        break;
                }
                a aVar = this.f421a;
                i2 = this.f421a.j;
                aVar.a(i2, str, (Address) null);
                return false;
            default:
                return false;
        }
    }
}
