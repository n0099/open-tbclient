package com.baidu.mobad.nativevideo;

import android.content.Context;
import android.view.View;
/* loaded from: classes14.dex */
public interface BaiduVideoResponse {

    /* loaded from: classes14.dex */
    public enum PrerollMaterialType {
        NORMAL,
        VIDEO,
        GIF
    }

    String getAdLogoUrl();

    String getBaiduLogoUrl();

    int getDuration();

    String getImageUrl();

    PrerollMaterialType getMaterialType();

    String getVideoUrl();

    void handleClick(View view);

    void handleClick(View view, int i);

    boolean isDownloadApp();

    void onClickAd(Context context);

    void onClose(Context context, int i);

    void onComplete(Context context);

    void onError(Context context, int i, int i2);

    void onFullScreen(Context context, int i);

    void onStart(Context context);

    void recordImpression(View view);
}
