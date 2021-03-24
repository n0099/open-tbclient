package com.baidu.searchbox.logsystem.basic.upload;

import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.searchbox.logsystem.uploadfile.BOSAttachFileUploader_Factory;
@Autowired
/* loaded from: classes3.dex */
public class UploaderProvider {
    public static final BaseContentUploader DEFAULT_CONTENT_UPLOADER = new DefaultContentUploader();
    public static final BaseAttachFileUploader DEFAULT_FILE_UPLOADER = new DefaultAttachFileUploader();

    @Inject(force = false)
    public static BaseAttachFileUploader getAttachUploader() {
        return BOSAttachFileUploader_Factory.get();
    }

    @Inject(force = false)
    public static BaseContentUploader getContentUploader() {
        return DEFAULT_CONTENT_UPLOADER;
    }

    public static BaseAttachFileUploader getDefaultAttachUploader() {
        return DEFAULT_FILE_UPLOADER;
    }

    public static BaseContentUploader getDefaultContentUploader() {
        return DEFAULT_CONTENT_UPLOADER;
    }
}
