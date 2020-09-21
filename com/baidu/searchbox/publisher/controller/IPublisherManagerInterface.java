package com.baidu.searchbox.publisher.controller;

import android.content.Context;
import com.baidu.searchbox.publisher.controller.listener.SelectAtListener;
import com.baidu.searchbox.publisher.controller.listener.SelectTopicListener;
import com.baidu.searchbox.ugc.draft.DraftData;
import com.baidu.searchbox.ugc.provider.listener.OnVideoShareListener;
import com.baidu.searchbox.ugc.utils.UgcUBCUtils;
import com.baidu.searchbox.ugc.webjs.UgcSchemeModel;
/* loaded from: classes5.dex */
public interface IPublisherManagerInterface {
    void deleteDraft(String str);

    DraftData getDraft(String str);

    OnVideoShareListener getOnVideoShareListener();

    Class getReplyPublishActivity();

    Class getTextImagePublishActivity();

    Class getVideoPublishActivity();

    void openPublisher(Context context, UgcSchemeModel ugcSchemeModel);

    void openPublisher(Context context, UgcSchemeModel ugcSchemeModel, int i);

    void saveDraft(String str, DraftData draftData);

    void selectAt(Context context, String str, SelectAtListener selectAtListener);

    void selectTopic(Context context, String str, SelectTopicListener selectTopicListener);

    void setDebug(boolean z);

    void setOnVideoShareListener(OnVideoShareListener onVideoShareListener);

    void setUbcConfig(UgcUBCUtils.UbcConfig ubcConfig);

    void setVideoUploadInfo(String str);
}
