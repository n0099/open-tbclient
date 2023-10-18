package com.baidu.mobads.sdk.api;

import android.view.View;
/* loaded from: classes3.dex */
public interface PrerollVideoResponse {
    public static final String GIF = "gif";
    public static final String NORMAL = "normal";
    public static final String VIDEO = "video";

    String getAdLogoUrl();

    String getBaiduLogoUrl();

    String getDesc();

    String getIconUrl();

    String getImageUrl();

    String getMaterialType();

    String getTitle();

    String getVideoUrl();

    void handleClick(View view2);

    void handleClick(View view2, int i);

    void recordImpression(View view2);
}
