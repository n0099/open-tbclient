package com.baidu.searchbox.ugc.bridge;
/* loaded from: classes4.dex */
public class UploadProviderImpl_Factory {
    private static volatile UploadProviderImpl instance;

    private UploadProviderImpl_Factory() {
    }

    public static synchronized UploadProviderImpl get() {
        UploadProviderImpl uploadProviderImpl;
        synchronized (UploadProviderImpl_Factory.class) {
            if (instance == null) {
                instance = new UploadProviderImpl();
            }
            uploadProviderImpl = instance;
        }
        return uploadProviderImpl;
    }
}
