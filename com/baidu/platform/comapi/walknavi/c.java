package com.baidu.platform.comapi.walknavi;

import com.baidu.mapapi.walknavi.adapter.IWNPCEngineInitListener;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes20.dex */
public class c implements com.baidu.platform.comapi.walknavi.d.c {
    final /* synthetic */ IWNPCEngineInitListener a;
    final /* synthetic */ b b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, IWNPCEngineInitListener iWNPCEngineInitListener) {
        this.b = bVar;
        this.a = iWNPCEngineInitListener;
    }

    @Override // com.baidu.platform.comapi.walknavi.d.c
    public void a(boolean z, float f) {
    }

    @Override // com.baidu.platform.comapi.walknavi.d.c
    public void a(int i) {
    }

    @Override // com.baidu.platform.comapi.walknavi.d.c
    public void a(int i, String str) {
        com.baidu.platform.comapi.wnplatform.d.a.b("downloadnpc:responseCode = " + i + ", responseMessage = " + str);
        if (i == 0) {
            this.b.P = true;
            this.a.onSuccess();
        } else if (i == 2 || i == 4 || i == 3) {
            this.b.P = false;
            this.a.onFail("您的手机暂不支持3D模型导航");
        } else if (i == 1) {
            this.b.P = false;
            this.a.onFail("当前网络异常，请稍候再试");
        } else if (i == 6 || i == 5 || i == -1) {
            this.b.P = false;
            this.a.onFail("初始化失败，请稍候再试");
        } else {
            this.b.P = false;
            this.a.onFail("未知错误导致初始化失败");
        }
    }
}
