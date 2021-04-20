package com.baidu.platform.comapi.walknavi;

import com.baidu.mapapi.walknavi.adapter.IWNPCEngineInitListener;
/* loaded from: classes2.dex */
public class c implements com.baidu.platform.comapi.walknavi.d.c {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ IWNPCEngineInitListener f9466a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ b f9467b;

    public c(b bVar, IWNPCEngineInitListener iWNPCEngineInitListener) {
        this.f9467b = bVar;
        this.f9466a = iWNPCEngineInitListener;
    }

    @Override // com.baidu.platform.comapi.walknavi.d.c
    public void a(int i) {
    }

    @Override // com.baidu.platform.comapi.walknavi.d.c
    public void a(int i, String str) {
        com.baidu.platform.comapi.wnplatform.d.a.b("downloadnpc:responseCode = " + i + ", responseMessage = " + str);
        if (i == 0) {
            this.f9467b.N = true;
            this.f9466a.onSuccess();
        } else if (i == 2 || i == 4 || i == 3) {
            this.f9467b.N = false;
            this.f9466a.onFail("您的手机暂不支持3D模型导航");
        } else if (i == 1) {
            this.f9467b.N = false;
            this.f9466a.onFail("当前网络异常，请稍候再试");
        } else if (i == 6 || i == 5 || i == -1) {
            this.f9467b.N = false;
            this.f9466a.onFail("初始化失败，请稍候再试");
        } else {
            this.f9467b.N = false;
            this.f9466a.onFail("未知错误导致初始化失败");
        }
    }

    @Override // com.baidu.platform.comapi.walknavi.d.c
    public void a(boolean z, float f2) {
    }
}
