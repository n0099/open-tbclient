package com.baidu.searchbox.ugc.activity;

import android.app.Activity;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.searchbox.ugc.emoji.EmojiconEditText;
import com.baidu.searchbox.ugc.model.PublishModels;
import com.baidu.searchbox.ugc.model.UgcTagDisplayModel;
import com.baidu.searchbox.ugc.model.UgcTagItem;
import com.baidu.searchbox.ugc.model.UgcVoteInfo;
import java.util.List;
/* loaded from: classes12.dex */
public interface IPublishView {
    Activity getContext();

    EmojiconEditText getInput();

    TextView getNumberTV();

    TextView getPublishTv();

    UgcTagItem getTag();

    ImageView getTopicSelectIv();

    List<UgcVoteInfo.VoteOption> getVoteOption();

    void hidePKContainer();

    void initPKView();

    void initUgcTagView(UgcTagDisplayModel ugcTagDisplayModel);

    boolean isEmojiShown();

    void onUploadVideoErrorCancle();

    void setVideoUploadEnd();

    void setVideoUploadStart();

    void showPublishFailed(String str);

    void showPublishStart();

    void showPublishSuccess(PublishModels.PublishResultInfo publishResultInfo);

    void showUploadFailed();

    void showVoteView(UgcVoteInfo ugcVoteInfo);

    void updateUploadVideoProgress(long j, long j2);
}
