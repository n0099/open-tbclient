package com.baidu.mobad.nativevideo;

import android.content.Context;
import com.baidu.mobad.feeds.BaiduNative;
import com.baidu.mobad.feeds.NativeErrorCode;
import com.baidu.mobad.feeds.NativeResponse;
import com.baidu.mobad.feeds.RequestParameters;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a implements BaiduNative.BaiduNativeNetworkListener {

    /* renamed from: a  reason: collision with root package name */
    public com.baidu.mobads.production.b.e f8058a;

    /* renamed from: b  reason: collision with root package name */
    public InterfaceC0103a f8059b;

    /* renamed from: c  reason: collision with root package name */
    public BaiduNative f8060c;

    /* renamed from: com.baidu.mobad.nativevideo.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0103a {
        void a(NativeErrorCode nativeErrorCode);

        void a(List<e> list);
    }

    public a(Context context, String str, InterfaceC0103a interfaceC0103a) {
        com.baidu.mobads.production.h.a aVar = new com.baidu.mobads.production.h.a(context, str);
        this.f8058a = aVar;
        this.f8059b = interfaceC0103a;
        this.f8060c = new BaiduNative(context, str, this, aVar);
    }

    public void a(RequestParameters requestParameters) {
        this.f8060c.makeRequest(requestParameters);
    }

    @Override // com.baidu.mobad.feeds.BaiduNative.BaiduNativeNetworkListener
    public void onNativeFail(NativeErrorCode nativeErrorCode) {
        this.f8059b.a(nativeErrorCode);
    }

    @Override // com.baidu.mobad.feeds.BaiduNative.BaiduNativeNetworkListener
    public void onNativeLoad(List<NativeResponse> list) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            com.baidu.mobads.production.b.e eVar = this.f8058a;
            arrayList.add(new XAdVideoResponse(list.get(i), eVar.f8436d, eVar.f8440h));
        }
        this.f8059b.a(arrayList);
    }
}
