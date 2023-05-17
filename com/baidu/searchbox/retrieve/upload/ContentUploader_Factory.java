package com.baidu.searchbox.retrieve.upload;
/* loaded from: classes4.dex */
public class ContentUploader_Factory {
    public static volatile ContentUploader instance;

    public static synchronized ContentUploader get() {
        ContentUploader contentUploader;
        synchronized (ContentUploader_Factory.class) {
            if (instance == null) {
                instance = new ContentUploader();
            }
            contentUploader = instance;
        }
        return contentUploader;
    }
}
