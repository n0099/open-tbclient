package com.baidu.searchbox.util;

import android.content.Context;
import com.baidu.browser.BrowserType;
import com.baidu.searchbox.http.cookie.CookieManager;
/* loaded from: classes2.dex */
public interface IBaiduIdentityContext {
    byte[] encryptByNativeBds(String str, String str2);

    String getAppMode();

    String getBDVCInfo();

    String getIid();

    boolean getJoinUserExperiencePreference(Context context);

    String getLocString(Context context, int i);

    String getLocationInfo(Context context);

    String getMatrixstyle();

    String getOEMChannel(Context context);

    String getOsBranch();

    String getPassUid(Context context);

    String getPkgName();

    boolean getPrivacySwitch(Context context);

    String[] getProcessUARegex(Context context);

    String getSearchBoxTypeId(Context context);

    String getTn(Context context);

    String getZid();

    boolean isAgreePrivacy();

    boolean isBlinkEnable();

    boolean isDataFlowPopDialog(Context context);

    boolean isPeakTime();

    boolean isSelfUpdateInstalled(Context context);

    CookieManager obtainCookieManager(boolean z, boolean z2);

    String processUrlExternal(String str, boolean z);

    String processUserAgentExternal(String str, BrowserType browserType);

    void setCookieManualNoBdussOperate(String str, String str2, boolean z);
}
