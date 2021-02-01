package com.baidu.mobads.nativecpu;

import android.view.View;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public interface IBasicCPUData {
    int getActionType();

    int getAdHeight();

    String getAdLogoUrl();

    int getAdWidth();

    String getAppPackageName();

    String getAppPermissionUrl();

    String getAppPrivacyUrl();

    String getAppPublisher();

    String getAppVersion();

    String getAuthor();

    String getBaiduLogoUrl();

    String getBrandName();

    String getChannelId();

    String getChannelName();

    int getCommentCounts();

    String getContentClickUrl();

    String getDesc();

    JSONArray getDislikeReasons();

    int getDownloadStatus();

    int getDuration();

    JSONObject getExtra();

    String getIconUrl();

    List<String> getImageUrls();

    int getPlayCounts();

    int getPresentationType();

    List<String> getSmallImageUrls();

    int getStyleType();

    int getThumbHeight();

    String getThumbUrl();

    int getThumbWidth();

    String getTitle();

    String getType();

    String getUpdateTime();

    String getVUrl();

    void handleClick(View view);

    boolean isDownloadApp();

    boolean isTop();

    void markDislike(String[] strArr);

    void onImpression(View view);
}
