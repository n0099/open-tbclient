package com.baidu.adp.lib.c;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class c implements Handler.Callback {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.a = aVar;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i;
        int i2;
        switch (message.what) {
            case 0:
                this.a.c();
                String str = "";
                i = this.a.j;
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
                a aVar = this.a;
                i2 = this.a.j;
                a.a(aVar, i2, str, null);
                return false;
            default:
                return false;
        }
    }
}
