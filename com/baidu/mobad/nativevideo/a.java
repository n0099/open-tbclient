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
    public com.baidu.mobads.production.b.e f8059a;

    /* renamed from: b  reason: collision with root package name */
    public InterfaceC0104a f8060b;

    /* renamed from: c  reason: collision with root package name */
    public BaiduNative f8061c;

    /* renamed from: com.baidu.mobad.nativevideo.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0104a {
        void a(NativeErrorCode nativeErrorCode);

        void a(List<e> list);
    }

    public a(Context context, String str, InterfaceC0104a interfaceC0104a) {
        com.baidu.mobads.production.h.a aVar = new com.baidu.mobads.production.h.a(context, str);
        this.f8059a = aVar;
        this.f8060b = interfaceC0104a;
        this.f8061c = new BaiduNative(context, str, this, aVar);
    }

    public void a(RequestParameters requestParameters) {
        this.f8061c.makeRequest(requestParameters);
    }

    @Override // com.baidu.mobad.feeds.BaiduNative.BaiduNativeNetworkListener
    public void onNativeFail(NativeErrorCode nativeErrorCode) {
        this.f8060b.a(nativeErrorCode);
    }

    @Override // com.baidu.mobad.feeds.BaiduNative.BaiduNativeNetworkListener
    public void onNativeLoad(List<NativeResponse> list) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            com.baidu.mobads.production.b.e eVar = this.f8059a;
            arrayList.add(new XAdVideoResponse(list.get(i), eVar.f8437d, eVar.f8441h));
        }
        this.f8060b.a(arrayList);
    }
}
