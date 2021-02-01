package com.baidu.mobad.nativevideo;

import android.content.Context;
import com.baidu.mobad.feeds.BaiduNative;
import com.baidu.mobad.feeds.NativeErrorCode;
import com.baidu.mobad.feeds.NativeResponse;
import com.baidu.mobad.feeds.RequestParameters;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class a implements BaiduNative.BaiduNativeNetworkListener {

    /* renamed from: a  reason: collision with root package name */
    private com.baidu.mobads.production.b.e f3245a;

    /* renamed from: b  reason: collision with root package name */
    private InterfaceC0261a f3246b;
    private BaiduNative c;

    /* renamed from: com.baidu.mobad.nativevideo.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0261a {
        void a(NativeErrorCode nativeErrorCode);

        void a(List<e> list);
    }

    public a(Context context, String str, InterfaceC0261a interfaceC0261a) {
        this.f3245a = new com.baidu.mobads.production.h.a(context, str);
        this.f3246b = interfaceC0261a;
        this.c = new BaiduNative(context, str, this, this.f3245a);
    }

    public void a(RequestParameters requestParameters) {
        this.c.makeRequest(requestParameters);
    }

    @Override // com.baidu.mobad.feeds.BaiduNative.BaiduNativeNetworkListener
    public void onNativeLoad(List<NativeResponse> list) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                arrayList.add(new XAdVideoResponse(list.get(i2), this.f3245a.d, this.f3245a.h));
                i = i2 + 1;
            } else {
                this.f3246b.a(arrayList);
                return;
            }
        }
    }

    @Override // com.baidu.mobad.feeds.BaiduNative.BaiduNativeNetworkListener
    public void onNativeFail(NativeErrorCode nativeErrorCode) {
        this.f3246b.a(nativeErrorCode);
    }
}
