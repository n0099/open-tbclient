package com.baidu.searchbox.publisher.controller.listener;

import com.baidu.searchbox.ugc.model.PublishModels;
/* loaded from: classes5.dex */
public interface PublishTextImagesCallback {
    void onPublishFail(String str);

    void onPublishSuccess(PublishModels.PublishResultInfo publishResultInfo);

    void onUploadFail(String str);

    void onUploadSuccess(String str, int i, int i2);
}
