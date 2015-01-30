package com.baidu.adp.lib.d;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements Handler.Callback {
    final /* synthetic */ a ke;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.ke = aVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i;
        int i2;
        switch (message.what) {
            case 0:
                this.ke.dE();
                String str = "";
                i = this.ke.errorCode;
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
                a aVar = this.ke;
                i2 = this.ke.errorCode;
                aVar.a(i2, str, null);
                return false;
            default:
                return false;
        }
    }
}
