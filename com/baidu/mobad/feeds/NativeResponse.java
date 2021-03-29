package com.baidu.mobad.feeds;

import android.content.Context;
import android.view.View;
import android.webkit.WebView;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public interface NativeResponse {
    public static final int INFO_FLOW_GROUP_PIC = 35;
    public static final int INFO_FLOW_GROUP_PIC_LOGO = 36;
    public static final int INFO_FLOW_LEFT_PIC = 33;
    public static final int INFO_FLOW_PIC_BOTTOM_TITLE = 28;
    public static final int INFO_FLOW_PIC_LOGO = 30;
    public static final int INFO_FLOW_PIC_TOP_TITLE = 29;
    public static final int INFO_FLOW_RIGHT_PIC = 34;
    public static final int INFO_FLOW_VIDEO_TOP_TITLE = 37;

    /* loaded from: classes2.dex */
    public interface AdInteractionListener {
        void onADExposed();

        void onADStatusChanged();

        void onAdClick();

        void onAdUnionClick();
    }

    /* loaded from: classes2.dex */
    public interface AdPrivacyListener {
        void onADPermissionClose();

        void onADPermissionShow();

        void onADPrivacyClick();
    }

    /* loaded from: classes2.dex */
    public enum MaterialType {
        NORMAL("normal"),
        VIDEO("video"),
        HTML("html");
        

        /* renamed from: a  reason: collision with root package name */
        public final String f8016a;

        MaterialType(String str) {
            this.f8016a = str;
        }

        public static MaterialType parse(String str) {
            MaterialType[] values;
            for (MaterialType materialType : values()) {
                if (materialType.f8016a.equalsIgnoreCase(str)) {
                    return materialType;
                }
            }
            return null;
        }

        public String getValue() {
            return this.f8016a;
        }
    }

    String getAdLogoUrl();

    String getAdMaterialType();

    String getAppPackage();

    String getAppPermissionLink();

    String getAppPrivacyLink();

    long getAppSize();

    String getAppVersion();

    String getBaiduLogoUrl();

    String getBrandName();

    int getContainerHeight();

    int getContainerSizeType();

    int getContainerWidth();

    String getDesc();

    int getDownloadStatus();

    int getDuration();

    String getECPMLevel();

    Map<String, String> getExtras();

    String getHtmlSnippet();

    String getIconUrl();

    String getImageUrl();

    int getMainPicHeight();

    int getMainPicWidth();

    MaterialType getMaterialType();

    List<String> getMultiPicUrls();

    String getPublisher();

    int getStyleType();

    String getTitle();

    String getVideoUrl();

    WebView getWebView();

    void handleClick(View view);

    void handleClick(View view, int i);

    boolean isAdAvailable(Context context);

    boolean isAutoPlay();

    boolean isDownloadApp();

    boolean isNonWifiAutoPlay();

    void onClickAd(Context context);

    void onClose(Context context, int i);

    void onComplete(Context context);

    void onError(Context context, int i, int i2);

    void onFullScreen(Context context, int i);

    void onStart(Context context);

    void pauseAppDownload();

    void permissionClick();

    void privacyClick();

    void recordImpression(View view);

    void registerViewForInteraction(View view, AdInteractionListener adInteractionListener);

    void resumeAppDownload();

    void setAdPrivacyListener(AdPrivacyListener adPrivacyListener);

    void unionLogoClick();
}
