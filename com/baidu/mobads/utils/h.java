package com.baidu.mobads.utils;

import com.baidu.live.tbadk.statics.AlaStaticKeys;
import com.baidu.mobads.interfaces.IXAdConstants4PDK;
import com.baidu.mobads.interfaces.IXAdContainerFactory;
import com.baidu.mobads.interfaces.utils.IXAdConstants;
import com.baidu.webkit.internal.GlobalConstants;
/* loaded from: classes7.dex */
public class h implements IXAdConstants {

    /* renamed from: a  reason: collision with root package name */
    private static String[] f2442a = {"com.android.chrome", "com.UCMobile", "com.uc.browser", "com.uc.browser.hd", "com.tencent.mtt", "com.tencent.padbrowser", "com.baidu.browser.apps", "com.android.browser", "com.oupeng.mini.android", "com.oupeng.mobile", "com.oupeng.browser", "com.opera.mini.android", "com.opera.browser", "com.opera.browser.beta", "com.mediawoz.xbrowser", "com.mx.browser", "com.mx.browser.tablet", "org.mozilla.firefox", "com.tiantianmini.android.browser", "com.ijinshan.browser_fast", "sogou.mobile.explorer", "com.dolphin.browser.cn", "com.qihoo.browser", GlobalConstants.SEARCHBOX_PACKAGE_NAME};

    @Override // com.baidu.mobads.interfaces.utils.IXAdConstants
    public String getInfoKeyErrorCode() {
        return "INFO_KEY_ERROR_CODE";
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdConstants
    public String getInfoKeyErrorMessage() {
        return "INFO_KEY_ERROR_MESSAGE";
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdConstants
    public String getInfoKeyErrorModule() {
        return "INFO_KEY_ERROR_MODULE";
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdConstants
    public int getAdCreativeTypeText() {
        return 1;
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdConstants
    public int getAdCreativeTypeImage() {
        return 2;
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdConstants
    public String feedsTrackerParameterKeyProgress() {
        return "progress";
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdConstants
    public String feedsTrackerParameterKeyList() {
        return "trackerUrl";
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdConstants
    public int getAdCreativeTypeVideo() {
        return 8;
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdConstants
    public int getAdCreativeTypeRichmedia() {
        return 16;
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdConstants
    public String getSupportedActionType4RequestingNone() {
        return "NA";
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdConstants
    public String getSupportedActionType4RequestingLandingPage() {
        return "LP";
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdConstants
    public String getSupportedActionType4RequestingDownload() {
        return "DL";
    }

    public String a() {
        return "APO";
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdConstants
    public String getSupportedActionType4RequestingMap() {
        return "MAP";
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdConstants
    public String getSupportedActionType4RequestingSMS() {
        return "SMS";
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdConstants
    public String getSupportedActionType4RequestingMail() {
        return "MAIL";
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdConstants
    public String getSupportedActionType4RequestingMakeCall() {
        return "PHONE";
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdConstants
    public String getSupportedActionType4RequestingVideo() {
        return "VIDEO";
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdConstants
    public String getSupportedActionType4RequestingRichMedia() {
        return "RM";
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdConstants
    public String getRemoteVersion() {
        IXAdContainerFactory adContainerFactory = XAdSDKFoundationFacade.getInstance().getAdContainerFactory();
        return adContainerFactory != null ? "" + adContainerFactory.getRemoteVersion() : "0.0.0";
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdConstants
    public String getSN() {
        return XAdSDKFoundationFacade.getInstance().getSystemUtils().getEncodedSN(XAdSDKFoundationFacade.getInstance().getApplicationContext());
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdConstants
    public String getAppSec() {
        return XAdSDKFoundationFacade.getInstance().getCommonUtils().getAppSec(XAdSDKFoundationFacade.getInstance().getApplicationContext());
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdConstants
    public String getAppSid() {
        return XAdSDKFoundationFacade.getInstance().getCommonUtils().getAppId(XAdSDKFoundationFacade.getInstance().getApplicationContext());
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdConstants
    public String getAppPackageNameOfPublisher() {
        return XAdSDKFoundationFacade.getInstance().getApplicationContext().getPackageName();
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdConstants
    public int getCanSendEmail() {
        return 0;
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdConstants
    public int getCanSendSMS() {
        return 1;
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdConstants
    public int getCanShowMap() {
        return 2;
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdConstants
    public int getCanShowDownload() {
        return 3;
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdConstants
    public int getCanSendCalender() {
        return 4;
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdConstants
    public String getProductionTypeBanner() {
        return IXAdConstants4PDK.SlotType.SLOT_TYPE_BANNER.getValue();
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdConstants
    public String getProductionTypeSplash() {
        return IXAdConstants4PDK.SlotType.SLOT_TYPE_SPLASH.getValue();
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdConstants
    public String getProductionTypeWall() {
        return "wall";
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdConstants
    public String getProductionTypeRWall() {
        return "rwall";
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdConstants
    public String getProductionTypeVideo() {
        return "video";
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdConstants
    public String getProductionTypeIcon() {
        return AlaStaticKeys.ALA_STATIC_VALUE_ICON;
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdConstants
    public String getProductionTypeInterstitial() {
        return IXAdConstants4PDK.SlotType.SLOT_TYPE_INTERSTITIAL.getValue();
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdConstants
    public String getProductionTypeNRWall() {
        return "nrwall";
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdConstants
    public String getProductionTypeFeeds() {
        return IXAdConstants4PDK.SlotType.SLOT_TYPE_FEEDS.getValue();
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdConstants
    public String[] getSupportedBrowsers() {
        return f2442a;
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdConstants
    public void setSupportedBrowsers(String[] strArr) {
        f2442a = strArr;
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdConstants
    public int getActTypeLandingPage() {
        return 1;
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdConstants
    public int getActTypeDownload() {
        return 2;
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdConstants
    public int getActTypeOpenMap() {
        return 4;
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdConstants
    public int getActTypeSendSMS() {
        return 8;
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdConstants
    public int getActTypeSendMail() {
        return 16;
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdConstants
    public int getActTypeMakeCall() {
        return 32;
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdConstants
    public int getActTypePlayVideo() {
        return 64;
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdConstants
    public int getActTypeRichMedia() {
        return 128;
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdConstants
    public int getActTypeNothing2Do() {
        return 256;
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdConstants
    public int getActTypeOpenExternalApp() {
        return 512;
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdConstants
    public String errorIo() {
        return "errorIo";
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdConstants
    public String errorTimeout() {
        return "errorTimeout";
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdConstants
    public String errorNullAsset() {
        return "errorNullAsset";
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdConstants
    public String errorUnknown() {
        return "errorUnknown";
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdConstants
    public String videoStateError() {
        return "videoStateError";
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdConstants
    public String videoStateIdle() {
        return "videoStateIdle";
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdConstants
    public String videoStatePerparing() {
        return "videoStatePerparing";
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdConstants
    public String videoStatePrepared() {
        return "videoStatePrepared";
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdConstants
    public String videoStatePlaying() {
        return "videoStatePlaying";
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdConstants
    public String videoStatePause() {
        return "videoStatePause";
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdConstants
    public String videoStatePlaybackCompleted() {
        return "videoStatePlaybackCompleted";
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdConstants
    public String resourceRequestStateIdel() {
        return "resourceRequestStateIdel";
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdConstants
    public String resourceRequestStateRequesting() {
        return "resourceRequestStateRequesting";
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdConstants
    public String resourceRequestStateSuccess() {
        return "resourceRequestStateSuccess";
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdConstants
    public String resourceRequestStateFailed() {
        return "resourceRequestStateFailed";
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdConstants
    public String deviceNetworkTypeWifi() {
        return "deviceNetworkTypeWifi";
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdConstants
    public String deviceNetworkTypeUnknown() {
        return "deviceNetworkTypeUnknown";
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdConstants
    public String deviceNetworkTypeGprs() {
        return "deviceNetworkTypeGprs";
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdConstants
    public String deviceNetworkTypeEdge() {
        return "deviceNetworkTypeEdge";
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdConstants
    public String deviceNetworkTypeUmts() {
        return "deviceNetworkTypeUmts";
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdConstants
    public String deviceNetworkTypeCdma() {
        return "deviceNetworkTypeCdma";
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdConstants
    public String deviceNetworkTypeEvdo0() {
        return "deviceNetworkTypeEvdo0";
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdConstants
    public String deviceNetworkTypeEvdoA() {
        return "deviceNetworkTypeEvdoA";
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdConstants
    public String deviceNetworkTypeLxRtt() {
        return "deviceNetworkTypeLxRtt";
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdConstants
    public String deviceNetworkTypeHsdpa() {
        return "deviceNetworkTypeHsdpa";
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdConstants
    public String deviceNetworkTypeHsupa() {
        return "deviceNetworkTypeHsupa";
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdConstants
    public String deviceNetworkTypeHspa() {
        return "deviceNetworkTypeHspa";
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdConstants
    public String deviceNetworkTypeIden() {
        return "deviceNetworkTypeIden";
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdConstants
    public String deviceNetworkTypeEvdoB() {
        return "deviceNetworkTypeEvdoB";
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdConstants
    public String deviceNetworkTypeLte() {
        return "deviceNetworkTypeLte";
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdConstants
    public String deviceNetworkTypeEhrpd() {
        return "deviceNetworkTypeEhrpd";
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdConstants
    public String deviceNetworkTypeHspaPlus() {
        return "deviceNetworkTypeHspaPlus";
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdConstants
    public String mraidNetworkTypeWifi() {
        return "mraidNetworkTypeWifi";
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdConstants
    public String mraidNetworkTypeCell() {
        return "mraidNetworkTypeCell";
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdConstants
    public String mraidNetworkTypeOffline() {
        return "mraidNetworkTypeOffline";
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdConstants
    public String mraidNetworkTypeUnknown() {
        return "mraidNetworkTypeUnknown";
    }
}
