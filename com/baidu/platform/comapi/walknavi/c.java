package com.baidu.platform.comapi.walknavi;

import com.baidu.mapapi.walknavi.adapter.IWNPCEngineInitListener;
/* loaded from: classes2.dex */
public class c implements com.baidu.platform.comapi.walknavi.d.c {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ IWNPCEngineInitListener f9821a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ b f9822b;

    public c(b bVar, IWNPCEngineInitListener iWNPCEngineInitListener) {
        this.f9822b = bVar;
        this.f9821a = iWNPCEngineInitListener;
    }

    @Override // com.baidu.platform.comapi.walknavi.d.c
    public void a(int i2) {
    }

    @Override // com.baidu.platform.comapi.walknavi.d.c
    public void a(int i2, String str) {
        com.baidu.platform.comapi.wnplatform.d.a.b("downloadnpc:responseCode = " + i2 + ", responseMessage = " + str);
        if (i2 == 0) {
            this.f9822b.N = true;
            this.f9821a.onSuccess();
        } else if (i2 == 2 || i2 == 4 || i2 == 3) {
            this.f9822b.N = false;
            this.f9821a.onFail("您的手机暂不支持3D模型导航");
        } else if (i2 == 1) {
            this.f9822b.N = false;
            this.f9821a.onFail("当前网络异常，请稍候再试");
        } else if (i2 == 6 || i2 == 5 || i2 == -1) {
            this.f9822b.N = false;
            this.f9821a.onFail("初始化失败，请稍候再试");
        } else {
            this.f9822b.N = false;
            this.f9821a.onFail("未知错误导致初始化失败");
        }
    }

    @Override // com.baidu.platform.comapi.walknavi.d.c
    public void a(boolean z, float f2) {
    }
}
