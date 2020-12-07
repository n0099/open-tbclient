package com.baidu.searchbox.logsystem.basic.upload;

import com.baidu.searchbox.logsystem.uploadfile.BOSAttachFileUploader_Factory;
/* loaded from: classes20.dex */
public class UploaderProvider {
    private static final BaseContentUploader DEFAULT_CONTENT_UPLOADER = new DefaultContentUploader();
    private static final BaseAttachFileUploader DEFAULT_FILE_UPLOADER = new DefaultAttachFileUploader();

    public static BaseAttachFileUploader getAttachUploader() {
        return BOSAttachFileUploader_Factory.get();
    }

    public static BaseContentUploader getContentUploader() {
        return DEFAULT_CONTENT_UPLOADER;
    }

    public static BaseContentUploader getDefaultContentUploader() {
        return DEFAULT_CONTENT_UPLOADER;
    }

    public static BaseAttachFileUploader getDefaultAttachUploader() {
        return DEFAULT_FILE_UPLOADER;
    }
}
