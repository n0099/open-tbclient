package com.baidu.searchbox.ugc.request;

import com.baidu.searchbox.publisher.controller.PublisherManagerFactory;
import com.baidu.searchbox.publisher.controller.listener.PublishRequestListener;
import com.baidu.searchbox.ugc.model.HttpRequestPublishModule;
import com.baidu.searchbox.ugc.model.PublishModels;
import com.baidu.searchbox.ugc.model.PublishRequestModel;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes12.dex */
public class PublishRequestManager {
    private static volatile PublishRequestManager sPublishRequestManager;

    /* loaded from: classes12.dex */
    public interface PublishRequestCallback {
        void onFailed(String str);

        void onSuccess(PublishModels.PublishResultInfo publishResultInfo);
    }

    public static PublishRequestManager getInstance() {
        if (sPublishRequestManager == null) {
            synchronized (PublishRequestManager.class) {
                if (sPublishRequestManager == null) {
                    sPublishRequestManager = new PublishRequestManager();
                }
            }
        }
        return sPublishRequestManager;
    }

    public void publishRequest(PublishRequestModel publishRequestModel, final PublishRequestCallback publishRequestCallback) {
        PublisherManagerFactory.get().doPublish(publishRequestModel.postUrl, HttpRequestPublishModule.generateRequestPublishParams(publishRequestModel.data, publishRequestModel.serverTopicsRule, publishRequestModel.title, publishRequestModel.inputStr, publishRequestModel.imageUrlList, publishRequestModel.videoInfo, publishRequestModel.sourceFrom, publishRequestModel.sourceid, publishRequestModel.sourceType, publishRequestModel.publishType, publishRequestModel.sourceKey, publishRequestModel.topic, publishRequestModel.locationObject, publishRequestModel.extObject, publishRequestModel.questionReply, publishRequestModel.swanObject, publishRequestModel.questionAsk), new PublishRequestListener() { // from class: com.baidu.searchbox.ugc.request.PublishRequestManager.1
            @Override // com.baidu.searchbox.publisher.controller.listener.PublishRequestListener
            public void onSuccess(String str) {
                PublishModels.PublishResultInfo publishResultInfo;
                try {
                    publishResultInfo = HttpRequestPublishModule.parsePublishResponse(new JSONObject(str));
                } catch (JSONException e) {
                    e.printStackTrace();
                    publishResultInfo = null;
                }
                if (publishResultInfo != null && publishRequestCallback != null) {
                    publishRequestCallback.onSuccess(publishResultInfo);
                } else if (publishRequestCallback != null) {
                    publishRequestCallback.onFailed("");
                }
            }

            @Override // com.baidu.searchbox.publisher.controller.listener.PublishRequestListener
            public void onFailed(String str) {
                if (publishRequestCallback != null) {
                    publishRequestCallback.onFailed(str);
                }
            }
        });
    }
}
