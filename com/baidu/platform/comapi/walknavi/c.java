package com.baidu.platform.comapi.walknavi;

import com.baidu.mapapi.walknavi.adapter.IWNPCEngineInitListener;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public class c implements com.baidu.platform.comapi.walknavi.d.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ IWNPCEngineInitListener f4406a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ b f4407b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, IWNPCEngineInitListener iWNPCEngineInitListener) {
        this.f4407b = bVar;
        this.f4406a = iWNPCEngineInitListener;
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
            this.f4407b.P = true;
            this.f4406a.onSuccess();
        } else if (i == 2 || i == 4 || i == 3) {
            this.f4407b.P = false;
            this.f4406a.onFail("您的手机暂不支持3D模型导航");
        } else if (i == 1) {
            this.f4407b.P = false;
            this.f4406a.onFail("当前网络异常，请稍候再试");
        } else if (i == 6 || i == 5 || i == -1) {
            this.f4407b.P = false;
            this.f4406a.onFail("初始化失败，请稍候再试");
        } else {
            this.f4407b.P = false;
            this.f4406a.onFail("未知错误导致初始化失败");
        }
    }
}
