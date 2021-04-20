package com.baidu.mobads.container.components.statemachine;

import com.baidu.mobads.container.util.SDKLogTypeConstants;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes2.dex */
public enum AdStateCode {
    EVENT_REQUEST(101, "request"),
    EVENT_RESPONSE_OK(102, "responseOk"),
    EVENT_RESPONSE_NO_AD(103, "responseNoAd"),
    EVENT_RESPONSE_ERROR(104, "responseError"),
    EVENT_IMPRESSION(201, "impression"),
    EVENT_IMPRESSION_SUCCESS(202, "impressionSuccess"),
    EVENT_IMPRESSION_FAILED(203, "impressionFailed"),
    EVENT_CLICK(301, "adClick"),
    EVENT_CLICK_DL(302, "clickDl"),
    EVENT_CLICK_LP(303, "clickLp"),
    EVENT_CLICK_LP_DL(304, "clickLpDl"),
    EVENT_CLICK_APO(305, "clickApo"),
    EVENT_CLICK_PULL_SHOUBAI(306, "clickShoubai"),
    EVENT_APO_OPEN(501, "apoOpen"),
    EVENT_APO_FB(502, "apoFallback"),
    EVENT_LP_CREATE(601, "lpCreate"),
    EVENT_LP_PAGE_START(602, "lpPageStart"),
    EVENT_LP_PAGE_LOADED(603, "lpPageLoaded"),
    EVENT_LP_PAGE_FINISH(604, "lpPageFinish"),
    EVENT_LP_CLOSE(605, "lpClose"),
    EVENT_DL_INIT(801, "init"),
    EVENT_DL_START(802, IntentConfig.START),
    EVENT_DL_DOWNLOADING(SDKLogTypeConstants.TYPE_DOWNLOAD_DIALOG_LOG, "downloading"),
    EVENT_DL_RESUME(806, "resume"),
    EVENT_DL_CANCELLED(807, "cancelled"),
    EVENT_DL_WAIT_WIFI(808, "waitWifi"),
    EVENT_DL_COMPLETE(809, "completed"),
    EVENT_DL_ERROR(804, "error"),
    EVENT_DL_PAUSE(805, "pause"),
    EVENT_DL_INSTALL(831, "alreadyDownloadedInstall"),
    EVENT_DL_OPEN(832, "alreadyDownloadedOpen"),
    EVENT_AD_TIMEOUT(400, "adTimeout"),
    EVENT_REMOVE_AD_VIEW(700, "removeAdView"),
    EVENT_AD_STATE_END(0, "finish");
    
    public int code;
    public String msg;

    AdStateCode(int i, String str) {
        this.code = i;
        this.msg = str;
    }

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.msg;
    }
}
