package com.baidu.searchbox.ng.ai.apps.ioc.interfaces;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.baidu.browser.BrowserType;
import com.baidu.searchbox.ng.ai.apps.account.AiAppAccountStatusChangedListener;
import com.baidu.searchbox.ng.ai.apps.account.OnAiAppLoginResultListener;
import com.baidu.searchbox.ng.ai.apps.util.typedbox.TypedCallback;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public interface IAiAppAccountIoc {

    /* loaded from: classes2.dex */
    public interface CheckDeveloperCallback {
        void onCheckFail(Exception exc);

        void onCheckSuccess(boolean z);
    }

    void addLoginStatusChangedListener(AiAppAccountStatusChangedListener aiAppAccountStatusChangedListener);

    String buildBDUSSCookie(String str, String str2);

    void developerAuthentication(CheckDeveloperCallback checkDeveloperCallback);

    void developerAuthentication(String str, CheckDeveloperCallback checkDeveloperCallback);

    boolean enableHttpAndPort(Context context);

    String getAccountCookieStr(String str, String str2, String str3, long j);

    String getAndroidId();

    List<String> getAuthorizedDomains(Context context);

    String getBduss(Context context);

    String getCuid(Context context);

    String getDeviceInfo();

    String getEnCuid();

    String getHostApiKey();

    String getIMEI();

    Bundle getLoginInfo(Context context, ArrayList<String> arrayList);

    String getManufacturer();

    String getModel();

    String getPortraitUrl();

    String getSession(Context context, String str, String str2);

    Map<String, String> getSessions(Context context, @NonNull Map<String, String> map);

    void getTplStoken(Activity activity, TypedCallback<Bundle> typedCallback, @Nullable String... strArr);

    String getUid(Context context);

    Bundle getUserInfo(Context context, String str);

    String getWifiInfo();

    boolean isLogin(Context context);

    void login(Activity activity, OnAiAppLoginResultListener onAiAppLoginResultListener);

    void login(Activity activity, String str, OnAiAppLoginResultListener onAiAppLoginResultListener);

    void login(Activity activity, String str, boolean z, OnAiAppLoginResultListener onAiAppLoginResultListener);

    String processUrl(String str);

    String processUserAgent(String str, BrowserType browserType);

    void setCookieManualWithBdussOperate(String str, String str2, boolean z, String str3);

    void thirdLogin(Activity activity, int i, String str, OnAiAppLoginResultListener onAiAppLoginResultListener);
}
