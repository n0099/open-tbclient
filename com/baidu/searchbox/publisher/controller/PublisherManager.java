package com.baidu.searchbox.publisher.controller;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.android.app.event.EventBusWrapper;
import com.baidu.pyramid.runtime.service.c;
import com.baidu.searchbox.browser.ILightBrowser;
import com.baidu.searchbox.publisher.controller.listener.PublishRequestListener;
import com.baidu.searchbox.publisher.controller.listener.PublishTextImageParams;
import com.baidu.searchbox.publisher.controller.listener.PublishTextImagesCallback;
import com.baidu.searchbox.publisher.controller.listener.SelectAtListener;
import com.baidu.searchbox.publisher.controller.listener.SelectTopicListener;
import com.baidu.searchbox.ugc.activity.ReplyPublishActivity;
import com.baidu.searchbox.ugc.activity.TextImagePublishActivity;
import com.baidu.searchbox.ugc.activity.VideoPublishActivity;
import com.baidu.searchbox.ugc.draft.DraftData;
import com.baidu.searchbox.ugc.model.AtSelectEvent;
import com.baidu.searchbox.ugc.model.HttpRequestPublishModule;
import com.baidu.searchbox.ugc.model.PublishModels;
import com.baidu.searchbox.ugc.model.PublishRequestModel;
import com.baidu.searchbox.ugc.model.TopicSelectEvent;
import com.baidu.searchbox.ugc.provider.listener.OnVideoShareListener;
import com.baidu.searchbox.ugc.request.PublishRequestManager;
import com.baidu.searchbox.ugc.service.AtService;
import com.baidu.searchbox.ugc.utils.DraftUtils;
import com.baidu.searchbox.ugc.utils.UgcUBCUtils;
import com.baidu.searchbox.ugc.webjs.UgcSchemeModel;
import com.baidu.searchbox.ugc.webjs.UnitedSchemeUGCDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.upload.provider.UploadProviderManager;
import com.baidu.searchbox.upload.provider.listener.UploadImageListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import rx.functions.b;
/* loaded from: classes13.dex */
public final class PublisherManager implements IPublisherManagerInterface {
    public static boolean GLOBAL_DEBUG = false;
    private static final String TAG = PublisherManager.class.getSimpleName();
    private String openTextPublishSchemeUrl = "baiduboxapp://v6/ugc/publish?upgrade=1&params=%7B%22icons%22%3A%5B%220%22%2C%224%22%2C%223%22%5D%2C%22source%22%3A%22ugc%22%2C%22source_from%22%3A%22userhome%22%2C%22url%22%3A%22%2Fsearchbox%3Faction%3Dugc%26cmd%3D177%26type%3Dbaijiahao%22%2C%22support_gif%22%3A1%2C%22topic_pageurl%22%3A%22baiduboxapp%3A%2F%2Fv1%2Feasybrowse%2Fopen%3Furl%3Dhttps%253A%252F%252Fmbd.baidu.com%252Fwebpage%253Ftype%253Dtopic%2526action%253Dsearch%26style%3D%257b%2522menumode%2522%253a%25222%2522%252c%2522showtoolbar%2522%253a%25221%2522%257d%26newbrowser%3D1%22%2C%22at_pageurl%22%3A%22baiduboxapp%3A%2F%2Fv1%2Feasybrowse%2Fopen%3Fnewbrowser%3D1%26style%3D%257B%2522menumode%2522%253A%25222%2522%252C%2522showtoolbar%2522%253A%25221%2522%257D%26url%3Dhttps%253A%252F%252Fmbd.baidu.com%252Fwebpage%253Ftype%253Dtopic%2526action%253Dat%26newbrowser%3D1%22%2C%22camera_buttons%22%3A%5B%22timer%22%2C%22speed%22%2C%22music%22%2C%22face%22%2C%22filter%22%2C%22sticker%22%5D%2C%22timer_count%22%3A%5B%223%22%2C%2210%22%5D%2C%22duration%22%3A%7B%22min%22%3A%223%22%2C%22max%22%3A%2220%22%7D%2C%22music_pageurl%22%3A%22https%3A%2F%2Fsv.baidu.com%2Ffeedvideoui%2Fview%2Fvideomusic%22%2C%22placeholder%22%3A%22%E5%88%86%E4%BA%AB%E6%96%B0%E9%B2%9C%E4%BA%8B%E2%80%A6%22%2C%22ugcCallback%22%3A%22profile_callback_dynamic_365%22%7D\n";
    private String openPhotoAlbumPublisherSchemeUrl = "baiduboxapp://v6/ugc/publish?upgrade=1&params=%7B%22icons%22%3A%5B%220%22%2C%224%22%2C%223%22%5D%2C%22source%22%3A%22ugc%22%2C%22source_from%22%3A%22userhome%22%2C%22url%22%3A%22%2Fsearchbox%3Faction%3Dugc%26cmd%3D177%26type%3Dbaijiahao%22%2C%22support_gif%22%3A1%2C%22topic_pageurl%22%3A%22baiduboxapp%3A%2F%2Fv1%2Feasybrowse%2Fopen%3Furl%3Dhttps%253A%252F%252Fmbd.baidu.com%252Fwebpage%253Ftype%253Dtopic%2526action%253Dsearch%26style%3D%257b%2522menumode%2522%253a%25222%2522%252c%2522showtoolbar%2522%253a%25221%2522%257d%26newbrowser%3D1%22%2C%22at_pageurl%22%3A%22baiduboxapp%3A%2F%2Fv1%2Feasybrowse%2Fopen%3Fnewbrowser%3D1%26style%3D%257B%2522menumode%2522%253A%25222%2522%252C%2522showtoolbar%2522%253A%25221%2522%257D%26url%3Dhttps%253A%252F%252Fmbd.baidu.com%252Fwebpage%253Ftype%253Dtopic%2526action%253Dat%26newbrowser%3D1%22%2C%22camera_buttons%22%3A%5B%22timer%22%2C%22speed%22%2C%22music%22%2C%22face%22%2C%22filter%22%2C%22sticker%22%5D%2C%22timer_count%22%3A%5B%223%22%2C%2210%22%5D%2C%22duration%22%3A%7B%22min%22%3A%223%22%2C%22max%22%3A%2220%22%7D%2C%22music_pageurl%22%3A%22https%3A%2F%2Fsv.baidu.com%2Ffeedvideoui%2Fview%2Fvideomusic%22%2C%22placeholder%22%3A%22%E5%88%86%E4%BA%AB%E6%96%B0%E9%B2%9C%E4%BA%8B%E2%80%A6%22%2C%22ugcCallback%22%3A%22profile_callback_dynamic_365%22%7D\n";
    private String openPublisherMenuSchemeUrl = "baiduboxapp://v6/ugc/publish?upgrade=1&params=%7B%22icons%22%3A%5B%220%22%2C%224%22%2C%223%22%5D%2C%22source%22%3A%22ugc%22%2C%22source_from%22%3A%22userhome%22%2C%22url%22%3A%22%2Fsearchbox%3Faction%3Dugc%26cmd%3D177%26type%3Dbaijiahao%22%2C%22support_gif%22%3A1%2C%22topic_pageurl%22%3A%22baiduboxapp%3A%2F%2Fv1%2Feasybrowse%2Fopen%3Furl%3Dhttps%253A%252F%252Fmbd.baidu.com%252Fwebpage%253Ftype%253Dtopic%2526action%253Dsearch%26style%3D%257b%2522menumode%2522%253a%25222%2522%252c%2522showtoolbar%2522%253a%25221%2522%257d%26newbrowser%3D1%22%2C%22at_pageurl%22%3A%22baiduboxapp%3A%2F%2Fv1%2Feasybrowse%2Fopen%3Fnewbrowser%3D1%26style%3D%257B%2522menumode%2522%253A%25222%2522%252C%2522showtoolbar%2522%253A%25221%2522%257D%26url%3Dhttps%253A%252F%252Fmbd.baidu.com%252Fwebpage%253Ftype%253Dtopic%2526action%253Dat%26newbrowser%3D1%22%2C%22camera_buttons%22%3A%5B%22timer%22%2C%22speed%22%2C%22music%22%2C%22face%22%2C%22filter%22%2C%22sticker%22%5D%2C%22timer_count%22%3A%5B%223%22%2C%2210%22%5D%2C%22duration%22%3A%7B%22min%22%3A%223%22%2C%22max%22%3A%2220%22%7D%2C%22music_pageurl%22%3A%22https%3A%2F%2Fsv.baidu.com%2Ffeedvideoui%2Fview%2Fvideomusic%22%2C%22placeholder%22%3A%22%E5%88%86%E4%BA%AB%E6%96%B0%E9%B2%9C%E4%BA%8B%E2%80%A6%22%2C%22ugcCallback%22%3A%22profile_callback_dynamic_365%22%7D\n";

    @Override // com.baidu.searchbox.publisher.controller.IPublisherManagerInterface
    public void openPublisher(Context context, UgcSchemeModel ugcSchemeModel) {
        openPublisher(context, ugcSchemeModel, -1);
    }

    @Override // com.baidu.searchbox.publisher.controller.IPublisherManagerInterface
    public void openPublisher(Context context, UgcSchemeModel ugcSchemeModel, int i) {
        UnitedSchemeUGCDispatcher unitedSchemeUGCDispatcher = new UnitedSchemeUGCDispatcher();
        if (ugcSchemeModel == null) {
            unitedSchemeUGCDispatcher.invoke(context, dispatchUri(this.openPublisherMenuSchemeUrl), null);
            return;
        }
        unitedSchemeUGCDispatcher.setContext(context);
        unitedSchemeUGCDispatcher.openPublisher(ugcSchemeModel, i);
    }

    private void openImageTextPublishActivity(Context context, UgcSchemeModel ugcSchemeModel, int i) {
        JSONObject jSONObject;
        if (ugcSchemeModel == null) {
            try {
                jSONObject = new JSONObject(dispatchUri(this.openTextPublishSchemeUrl).getParam("params"));
            } catch (JSONException e) {
                e.printStackTrace();
                jSONObject = null;
            }
            ugcSchemeModel = UgcSchemeModel.parserSchemeModel(jSONObject);
            ugcSchemeModel.publishType = "0";
        }
        UnitedSchemeUGCDispatcher.openImageTextPublishActivity(context, ugcSchemeModel, i);
    }

    private void openPhotoAlbumPublisher(Context context, UgcSchemeModel ugcSchemeModel) {
        JSONObject jSONObject;
        if (ugcSchemeModel == null) {
            try {
                jSONObject = new JSONObject(dispatchUri(this.openPhotoAlbumPublisherSchemeUrl).getParam("params"));
            } catch (JSONException e) {
                e.printStackTrace();
                jSONObject = null;
            }
            ugcSchemeModel = UgcSchemeModel.parserSchemeModel(jSONObject);
            ugcSchemeModel.publishType = "4";
        }
        UnitedSchemeUGCDispatcher.openPhotoAlbumPublishActivity(context, ugcSchemeModel);
    }

    @Override // com.baidu.searchbox.publisher.controller.IPublisherManagerInterface
    public void selectTopic(final Context context, String str, final SelectTopicListener selectTopicListener) {
        EventBusWrapper.registerOnMainThread(context, TopicSelectEvent.class, new b<TopicSelectEvent>() { // from class: com.baidu.searchbox.publisher.controller.PublisherManager.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            public void call(TopicSelectEvent topicSelectEvent) {
                if (topicSelectEvent != null && selectTopicListener != null) {
                    selectTopicListener.callbackTopic(topicSelectEvent.mTopicItem);
                }
                EventBusWrapper.unregister(context);
            }
        });
        ((ILightBrowser) c.a(ILightBrowser.SERVICE_REFERENCE)).open(context, str);
    }

    @Override // com.baidu.searchbox.publisher.controller.IPublisherManagerInterface
    public void selectAt(final Context context, String str, final SelectAtListener selectAtListener) {
        EventBusWrapper.registerOnMainThread(context, AtSelectEvent.class, new b<AtSelectEvent>() { // from class: com.baidu.searchbox.publisher.controller.PublisherManager.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            public void call(AtSelectEvent atSelectEvent) {
                if (atSelectEvent != null && selectAtListener != null) {
                    selectAtListener.callbackAt(atSelectEvent.mAtUserInfoItem);
                }
                EventBusWrapper.unregister(context);
            }
        });
        AtService atService = (AtService) c.a(AtService.SERVICE_REFERENCE);
        if (atService != null) {
            atService.open(context);
        } else {
            ((ILightBrowser) c.a(ILightBrowser.SERVICE_REFERENCE)).open(context, str);
        }
    }

    @Override // com.baidu.searchbox.publisher.controller.IPublisherManagerInterface
    public void doPublish(String str, Map<String, String> map, PublishRequestListener publishRequestListener) {
        new HttpRequestPublishModule().requestPublish(str, map, publishRequestListener);
    }

    @Override // com.baidu.searchbox.publisher.controller.IPublisherManagerInterface
    public void doPublishTextImages(final PublishTextImageParams publishTextImageParams, final PublishTextImagesCallback publishTextImagesCallback) {
        if (publishTextImageParams == null) {
            if (publishTextImagesCallback != null) {
                publishTextImagesCallback.onPublishFail("参数不能为null");
                return;
            }
            return;
        }
        final PublishRequestManager.PublishRequestCallback publishRequestCallback = new PublishRequestManager.PublishRequestCallback() { // from class: com.baidu.searchbox.publisher.controller.PublisherManager.3
            @Override // com.baidu.searchbox.ugc.request.PublishRequestManager.PublishRequestCallback
            public void onSuccess(PublishModels.PublishResultInfo publishResultInfo) {
                if (publishTextImagesCallback != null) {
                    publishTextImagesCallback.onPublishSuccess(publishResultInfo);
                }
            }

            @Override // com.baidu.searchbox.ugc.request.PublishRequestManager.PublishRequestCallback
            public void onFailed(String str) {
                if (publishTextImagesCallback != null) {
                    publishTextImagesCallback.onPublishFail(str);
                }
            }
        };
        if (publishTextImageParams.images.size() > 0) {
            final ArrayList arrayList = new ArrayList();
            UploadProviderManager.getUploadProvider().upLoadImage(publishTextImageParams.images, new UploadImageListener() { // from class: com.baidu.searchbox.publisher.controller.PublisherManager.4
                @Override // com.baidu.searchbox.upload.provider.listener.UploadImageListener
                public void uploadSuccess(String str, int i, int i2, long j) {
                    PublishModels.ImageData imageData = new PublishModels.ImageData();
                    imageData.url = str;
                    imageData.width = i;
                    imageData.height = i2;
                    imageData.size = j;
                    arrayList.add(imageData);
                    if (publishTextImagesCallback != null) {
                        publishTextImagesCallback.onUploadSuccess(str, i, i2);
                    }
                    if (arrayList.size() == publishTextImageParams.images.size()) {
                        PublisherManager.this.requestPublishTextImages(publishTextImageParams, arrayList, publishRequestCallback);
                    }
                }

                @Override // com.baidu.searchbox.upload.provider.listener.UploadImageListener
                public void uploadFail() {
                    if (publishTextImagesCallback != null) {
                        publishTextImagesCallback.onUploadFail(null);
                    }
                }

                @Override // com.baidu.searchbox.upload.provider.listener.UploadImageListener
                public void uploadProgress(float f) {
                }
            });
            return;
        }
        requestPublishTextImages(publishTextImageParams, null, publishRequestCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestPublishTextImages(PublishTextImageParams publishTextImageParams, List<PublishModels.ImageData> list, PublishRequestManager.PublishRequestCallback publishRequestCallback) {
        PublishRequestModel publishRequestModel = new PublishRequestModel();
        publishRequestModel.inputStr = publishTextImageParams.inputStr;
        publishRequestModel.imageUrlList = list;
        publishRequestModel.postUrl = publishTextImageParams.postUrl;
        publishRequestModel.sourceFrom = publishTextImageParams.sourceFrom;
        publishRequestModel.data = publishTextImageParams.data == null ? new JSONObject() : publishTextImageParams.data;
        publishRequestModel.topic = publishTextImageParams.topic;
        publishRequestModel.extObject = publishTextImageParams.ext;
        PublishRequestManager.getInstance().publishRequest(publishRequestModel, publishRequestCallback);
    }

    @Override // com.baidu.searchbox.publisher.controller.IPublisherManagerInterface
    public void saveDraft(String str, DraftData draftData) {
        if (!TextUtils.isEmpty(str)) {
            DraftUtils.saveDraft(str, draftData);
        }
    }

    @Override // com.baidu.searchbox.publisher.controller.IPublisherManagerInterface
    public void deleteDraft(String str) {
        DraftUtils.deleteDraft(str);
    }

    @Override // com.baidu.searchbox.publisher.controller.IPublisherManagerInterface
    public DraftData getDraft(String str) {
        return DraftUtils.getDraft(str);
    }

    @Override // com.baidu.searchbox.publisher.controller.IPublisherManagerInterface
    public void setUbcConfig(UgcUBCUtils.UbcConfig ubcConfig) {
        UgcUBCUtils.setUbcConfig(ubcConfig);
    }

    @Override // com.baidu.searchbox.publisher.controller.IPublisherManagerInterface
    public void setDebug(boolean z) {
    }

    @Override // com.baidu.searchbox.publisher.controller.IPublisherManagerInterface
    public Class getTextImagePublishActivity() {
        return TextImagePublishActivity.class;
    }

    @Override // com.baidu.searchbox.publisher.controller.IPublisherManagerInterface
    public Class getVideoPublishActivity() {
        return VideoPublishActivity.class;
    }

    @Override // com.baidu.searchbox.publisher.controller.IPublisherManagerInterface
    public Class getReplyPublishActivity() {
        return ReplyPublishActivity.class;
    }

    @Override // com.baidu.searchbox.publisher.controller.IPublisherManagerInterface
    public void setOnVideoShareListener(OnVideoShareListener onVideoShareListener) {
        VideoPublishActivity.sVideoShareListener = onVideoShareListener;
    }

    @Override // com.baidu.searchbox.publisher.controller.IPublisherManagerInterface
    public OnVideoShareListener getOnVideoShareListener() {
        return VideoPublishActivity.sVideoShareListener;
    }

    @Override // com.baidu.searchbox.publisher.controller.IPublisherManagerInterface
    public void setVideoUploadInfo(String str) {
        HttpRequestPublishModule.videoInfo = HttpRequestPublishModule.getVideoInfo(str);
    }

    private UnitedSchemeEntity dispatchUri(String str) {
        UnitedSchemeEntity unitedSchemeEntity = new UnitedSchemeEntity(Uri.parse(str));
        unitedSchemeEntity.getPath(true);
        unitedSchemeEntity.getPath(true);
        return unitedSchemeEntity;
    }
}
