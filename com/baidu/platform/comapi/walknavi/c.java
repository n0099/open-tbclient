package com.baidu.platform.comapi.walknavi;

import com.baidu.mapapi.walknavi.adapter.IWNPCEngineInitListener;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class c implements com.baidu.platform.comapi.walknavi.d.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ IWNPCEngineInitListener f4407a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ b f4408b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, IWNPCEngineInitListener iWNPCEngineInitListener) {
        this.f4408b = bVar;
        this.f4407a = iWNPCEngineInitListener;
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
            this.f4408b.P = true;
            this.f4407a.onSuccess();
        } else if (i == 2 || i == 4 || i == 3) {
            this.f4408b.P = false;
            this.f4407a.onFail("您的手机暂不支持3D模型导航");
        } else if (i == 1) {
            this.f4408b.P = false;
            this.f4407a.onFail("当前网络异常，请稍候再试");
        } else if (i == 6 || i == 5 || i == -1) {
            this.f4408b.P = false;
            this.f4407a.onFail("初始化失败，请稍候再试");
        } else {
            this.f4408b.P = false;
            this.f4407a.onFail("未知错误导致初始化失败");
        }
    }
}
