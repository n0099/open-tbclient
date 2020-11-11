package com.baidu.mobad.nativevideo;

import android.app.Activity;
import android.content.Context;
import com.baidu.mobad.feeds.BaiduNative;
import com.baidu.mobad.feeds.NativeErrorCode;
import com.baidu.mobad.feeds.NativeResponse;
import com.baidu.mobad.feeds.RequestParameters;
import com.baidu.mobads.production.c.c;
import com.baidu.mobads.production.i.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class BaiduVideoNative implements BaiduNative.BaiduNativeNetworkListener {

    /* renamed from: a  reason: collision with root package name */
    private c f2277a;
    private BaiduVideoNetworkListener b;
    private BaiduNative c;

    /* loaded from: classes7.dex */
    public interface BaiduVideoNetworkListener {
        void onAdFail(NativeErrorCode nativeErrorCode);

        void onAdLoad(List<BaiduVideoResponse> list);
    }

    public BaiduVideoNative(Context context, String str, BaiduVideoNetworkListener baiduVideoNetworkListener) {
        this.f2277a = new a(context, str);
        this.b = baiduVideoNetworkListener;
        this.c = new BaiduNative(context, str, this, this.f2277a);
    }

    public void makeRequest(RequestParameters requestParameters) {
        this.c.makeRequest(requestParameters);
    }

    @Override // com.baidu.mobad.feeds.BaiduNative.BaiduNativeNetworkListener
    public void onNativeLoad(List<NativeResponse> list) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                arrayList.add(new XAdVideoResponse(list.get(i2)));
                i = i2 + 1;
            } else {
                this.b.onAdLoad(arrayList);
                return;
            }
        }
    }

    @Override // com.baidu.mobad.feeds.BaiduNative.BaiduNativeNetworkListener
    public void onNativeFail(NativeErrorCode nativeErrorCode) {
        this.b.onAdFail(nativeErrorCode);
    }

    public static void setAppSid(Activity activity, String str) {
        BaiduNative.setAppSid(activity, str);
    }
}
