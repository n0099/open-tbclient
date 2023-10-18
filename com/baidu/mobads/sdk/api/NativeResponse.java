package com.baidu.mobads.sdk.api;

import android.content.Context;
import android.view.View;
import android.webkit.WebView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
import com.yy.sdk.crashreportbaidu.ActivityHistory;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public interface NativeResponse extends AbstractData {
    public static final int ACTION_TYPE_APP_DOWNLOAD = 2;
    public static final int ACTION_TYPE_DEEP_LINK = 3;
    public static final int ACTION_TYPE_LANDING_PAGE = 1;
    public static final int INFO_FLOW_GROUP_PIC = 35;
    public static final int INFO_FLOW_GROUP_PIC_LOGO = 36;
    public static final int INFO_FLOW_LEFT_PIC = 33;
    public static final int INFO_FLOW_PIC_BOTTOM_TITLE = 28;
    public static final int INFO_FLOW_PIC_LOGO = 30;
    public static final int INFO_FLOW_PIC_TOP_TITLE = 29;
    public static final int INFO_FLOW_PORTRAIT_IMAGE = 42;
    public static final int INFO_FLOW_PORTRAIT_VIDEO = 41;
    public static final int INFO_FLOW_RIGHT_PIC = 34;
    public static final int INFO_FLOW_VIDEO_TOP_TITLE = 37;

    /* loaded from: classes3.dex */
    public interface AdDislikeListener {
        void onDislikeClick();
    }

    /* loaded from: classes3.dex */
    public interface AdDownloadWindowListener extends AdPrivacyListener {
        void adDownloadWindowClose();

        void adDownloadWindowShow();
    }

    /* loaded from: classes3.dex */
    public interface AdInteractionListener {
        void onADExposed();

        void onADExposureFailed(int i);

        void onADStatusChanged();

        void onAdClick();

        void onAdUnionClick();
    }

    /* loaded from: classes3.dex */
    public interface AdPrivacyListener {
        void onADFunctionClick();

        void onADPermissionClose();

        void onADPermissionShow();

        void onADPrivacyClick();
    }

    /* loaded from: classes3.dex */
    public interface AdShakeViewListener {
        void onDismiss();
    }

    /* loaded from: classes3.dex */
    public interface CustomizeMediaPlayer {
        String getVideoUrl();

        void reportPlayError(int i);

        void reportPlayFrozen(int i);

        void reportPlayerReady();

        void reportVideoMuteChange(int i, boolean z);

        void reportVideoPause(int i, VideoReason videoReason);

        void reportVideoReplay();

        void reportVideoResume(int i);

        void reportVideoShow();

        void reportVideoStart(boolean z);

        void reportVideoStop(int i, VideoReason videoReason);
    }

    void biddingFail(String str);

    void biddingFail(String str, HashMap<String, Object> hashMap);

    void biddingSuccess(String str);

    void cancelAppDownload();

    void clearImpressionTaskWhenBack();

    void dislikeClick(DislikeEvent dislikeEvent);

    void functionClick();

    String getActButtonString();

    int getAdActionType();

    Object getAdDataForKey(String str);

    String getAdLogoUrl();

    String getAdMaterialType();

    String getAppFunctionLink();

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

    CustomizeMediaPlayer getCustomizeMediaPlayer();

    String getDesc();

    List<DislikeEvent> getDislikeList();

    int getDownloadStatus();

    int getDuration();

    String getECPMLevel();

    Map<String, String> getExtras();

    String getHtmlSnippet();

    String getIconUrl();

    String getImageUrl();

    int getMainPicHeight();

    int getMainPicWidth();

    String getMarketingPendant();

    MaterialType getMaterialType();

    List<String> getMultiPicUrls();

    String getPublisher();

    int getStyleType();

    String getTitle();

    String getVideoUrl();

    WebView getWebView();

    boolean isAdAvailable(Context context);

    boolean isAutoPlay();

    @Deprecated
    boolean isNeedDownloadApp();

    boolean isNonWifiAutoPlay();

    void pauseAppDownload();

    void permissionClick();

    void privacyClick();

    void recordImpression(View view2);

    void registerViewForInteraction(View view2, List<View> list, List<View> list2, AdInteractionListener adInteractionListener);

    View renderShakeView(int i, int i2, AdShakeViewListener adShakeViewListener);

    View renderSlideView(int i, int i2, int i3, AdShakeViewListener adShakeViewListener);

    void resumeAppDownload();

    void setAdPrivacyListener(AdPrivacyListener adPrivacyListener);

    void stopNativeView(View view2);

    void unionLogoClick();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class MaterialType {
        public static final /* synthetic */ MaterialType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final MaterialType HTML;
        public static final MaterialType NORMAL;
        public static final MaterialType VIDEO;
        public transient /* synthetic */ FieldHolder $fh;
        public final String value;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1577320809, "Lcom/baidu/mobads/sdk/api/NativeResponse$MaterialType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1577320809, "Lcom/baidu/mobads/sdk/api/NativeResponse$MaterialType;");
                    return;
                }
            }
            NORMAL = new MaterialType("NORMAL", 0, "normal");
            VIDEO = new MaterialType(HlsPlaylistParser.TYPE_VIDEO, 1, "video");
            MaterialType materialType = new MaterialType("HTML", 2, "html");
            HTML = materialType;
            $VALUES = new MaterialType[]{NORMAL, VIDEO, materialType};
        }

        public MaterialType(String str, int i, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i), str2};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str3 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.value = str2;
        }

        public static MaterialType parse(String str) {
            InterceptResult invokeL;
            MaterialType[] values;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                for (MaterialType materialType : values()) {
                    if (materialType.value.equalsIgnoreCase(str)) {
                        return materialType;
                    }
                }
                return null;
            }
            return (MaterialType) invokeL.objValue;
        }

        public static MaterialType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
                return (MaterialType) Enum.valueOf(MaterialType.class, str);
            }
            return (MaterialType) invokeL.objValue;
        }

        public static MaterialType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
                return (MaterialType[]) $VALUES.clone();
            }
            return (MaterialType[]) invokeV.objValue;
        }

        public String getValue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.value;
            }
            return (String) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class VideoReason {
        public static final /* synthetic */ VideoReason[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final VideoReason AD_CLOSE;
        public static final VideoReason BACKGROUND;
        public static final VideoReason JUMP_LANDING_PAGE;
        public static final VideoReason JUMP_OTHER_APP;
        public static final VideoReason OTHER_REASON;
        public static final VideoReason PLAY_COMPLETE;
        public static final VideoReason USER_CLICK;
        public transient /* synthetic */ FieldHolder $fh;
        public int code;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1748963955, "Lcom/baidu/mobads/sdk/api/NativeResponse$VideoReason;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1748963955, "Lcom/baidu/mobads/sdk/api/NativeResponse$VideoReason;");
                    return;
                }
            }
            JUMP_LANDING_PAGE = new VideoReason("JUMP_LANDING_PAGE", 0, 1);
            BACKGROUND = new VideoReason(ActivityHistory.BACKGROUND, 1, 2);
            USER_CLICK = new VideoReason("USER_CLICK", 2, 3);
            JUMP_OTHER_APP = new VideoReason("JUMP_OTHER_APP", 3, 4);
            PLAY_COMPLETE = new VideoReason("PLAY_COMPLETE", 4, 5);
            AD_CLOSE = new VideoReason("AD_CLOSE", 5, 6);
            VideoReason videoReason = new VideoReason("OTHER_REASON", 6, 7);
            OTHER_REASON = videoReason;
            $VALUES = new VideoReason[]{JUMP_LANDING_PAGE, BACKGROUND, USER_CLICK, JUMP_OTHER_APP, PLAY_COMPLETE, AD_CLOSE, videoReason};
        }

        public VideoReason(String str, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.code = i2;
        }

        public static VideoReason valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (VideoReason) Enum.valueOf(VideoReason.class, str);
            }
            return (VideoReason) invokeL.objValue;
        }

        public static VideoReason[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (VideoReason[]) $VALUES.clone();
            }
            return (VideoReason[]) invokeV.objValue;
        }

        public int getCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.code;
            }
            return invokeV.intValue;
        }
    }
}
