package com.baidu.mobads.production.b;

import com.baidu.mobad.feeds.BaiduNative;
import com.baidu.mobad.feeds.NativeResponse;
import com.baidu.mobad.feeds.XAdNativeResponse;
/* loaded from: classes2.dex */
public class b implements BaiduNative.NativeDownloadListener {
    @Override // com.baidu.mobad.feeds.BaiduNative.NativeDownloadListener
    public void onADStatusChanged(NativeResponse nativeResponse) {
        if (nativeResponse instanceof XAdNativeResponse) {
            ((XAdNativeResponse) nativeResponse).onADStatusChanged();
        }
    }
}
