package com.baidu.searchbox.upload.provider;

import com.baidu.searchbox.ugc.bridge.UploadProviderImpl_Factory;
/* loaded from: classes7.dex */
public class UploadProviderManager {
    public static IUploadInterface getUploadProvider() {
        return UploadProviderImpl_Factory.get();
    }
}
