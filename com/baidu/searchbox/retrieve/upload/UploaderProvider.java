package com.baidu.searchbox.retrieve.upload;

import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
@Autowired
/* loaded from: classes2.dex */
public class UploaderProvider {
    public static final BaseContentUploader DEFAULT_CONTENT_UPLOADER = new DefaultContentUploader();
    public static final BaseFileUploader DEFAULT_FILE_UPLOADER = new DefaultFileUploader();

    @Inject(force = false)
    public static BaseContentUploader getContentUploader() {
        return ContentUploader_Factory.get();
    }

    @Inject(force = false)
    public static BaseFileUploader getFileUploader() {
        return DEFAULT_FILE_UPLOADER;
    }
}
