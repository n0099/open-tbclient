package com.baidu.searchbox.schemedispatch.monitor;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.schemedispatch.SchemeStatisticField;
import com.baidu.searchbox.schemedispatch.monitor.bean.SchemeCheckInfo;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class OpenAppManager {
    public static final String SCHEME_NAME_FILENAME = "scheme_name_filename";
    public static List<OpenAppBaseCheck> mWhiteCheckList = new ArrayList();
    public static IGlobalCheck mGlobalCheck = new OpenAppGlobalCheck();
    public static IFeedCheck mFeedCheck = new OpenAppFeedCheck();
    public static IFromCheck mFromCheck = new OpenAppFromCheck();
    public static INoAlertCheck mNoAlertCheck = new OpenAppNoAlertCheck();
    public static IDeepLinkCheck mDeepLinkCheck = new OpenAppDeepLinkCheck();

    static {
        mWhiteCheckList.add((OpenAppBaseCheck) mGlobalCheck);
        mWhiteCheckList.add((OpenAppBaseCheck) mFeedCheck);
        mWhiteCheckList.add((OpenAppBaseCheck) mFromCheck);
        mWhiteCheckList.add((OpenAppBaseCheck) mNoAlertCheck);
        mWhiteCheckList.add((OpenAppBaseCheck) mDeepLinkCheck);
        init();
    }

    public static List<String> getAlwaysAllowSchema() {
        return mNoAlertCheck.getAlwaysAllowSchema();
    }

    public static ArrayList<String> getFromKeyList() {
        return mFromCheck.getFromKeyList();
    }

    public static void init() {
        for (OpenAppBaseCheck openAppBaseCheck : mWhiteCheckList) {
            openAppBaseCheck.loadWhiteListAsync();
        }
    }

    public static boolean adCheckSchemeInFeedWhiteList(String str, String str2, SchemeStatisticField schemeStatisticField) {
        return OpenAppBaseCheck.canInvoke(mFeedCheck.adCheckSchemeInFeedWhiteList(str, str2, schemeStatisticField));
    }

    public static boolean adCheckSchemeInGlobalWhiteList(String str, String str2, SchemeStatisticField schemeStatisticField) {
        return OpenAppBaseCheck.canInvoke(getadCheckSchemeInGlobalWhiteList(str, str2, schemeStatisticField, true));
    }

    public static SchemeCheckInfo checkSchemeInFeedWhiteList(String str, String str2, String str3) {
        return mFeedCheck.checkSchemeInFeedWhiteList(str, str2, str3);
    }

    public static SchemeCheckInfo checkSchemeInFromWhiteList(String str, String str2, String str3) {
        return mFromCheck.checkSchemeInFromWhiteList(str, str2, str3);
    }

    public static SchemeCheckInfo getAdCheckSchemeInFeedWhiteList(String str, String str2, SchemeStatisticField schemeStatisticField) {
        return mFeedCheck.adCheckSchemeInFeedWhiteList(str, str2, schemeStatisticField);
    }

    public static void addAlwaysAllowSchema(String str) {
        mNoAlertCheck.addAlwaysAllowSchema(str);
    }

    public static String getSchemeName(SchemeCheckInfo schemeCheckInfo) {
        if (TextUtils.isEmpty(schemeCheckInfo.getTitle())) {
            return AppRuntime.getAppContext().getString(R.string.third_party_visit_dialog_app_default_name);
        }
        return schemeCheckInfo.getTitle();
    }

    public static boolean isNoAlertSwitchOn(String str) {
        return TextUtils.equals("1", mNoAlertCheck.getNoAlertSwitch(str));
    }

    public static boolean saveWhiteList(String str) {
        boolean z = false;
        for (OpenAppBaseCheck openAppBaseCheck : mWhiteCheckList) {
            if (openAppBaseCheck.saveWhiteList(str)) {
                z = true;
            }
        }
        return z;
    }

    public static SchemeCheckInfo checkSchemeInDeepLinkWhiteList(String str, SchemeStatisticField schemeStatisticField) {
        return mDeepLinkCheck.checkSchemeInDeepLinkWhiteList(str, schemeStatisticField);
    }

    public static SchemeCheckInfo checkSchemeInFeedWhiteList(String str, String str2) {
        return mFeedCheck.checkSchemeInFeedWhiteList(str, str, str2);
    }

    public static boolean isInNoAlertList(String str, List<String> list) {
        return mNoAlertCheck.isInNoAlertList(str, list);
    }

    public static SchemeCheckInfo getSchemeInGlobalWhiteList(Context context, String str, String str2, String str3, SchemeStatisticField schemeStatisticField, boolean z) {
        SchemeCheckInfo checkSchemeInGlobalWhiteList = mGlobalCheck.checkSchemeInGlobalWhiteList(context, str, str2, str3, schemeStatisticField);
        if (z) {
            return OpenAppBaseCheck.checkTypeClose(checkSchemeInGlobalWhiteList, str2);
        }
        return checkSchemeInGlobalWhiteList;
    }

    public static SchemeCheckInfo getadCheckSchemeInGlobalWhiteList(String str, String str2, SchemeStatisticField schemeStatisticField, boolean z) {
        SchemeCheckInfo adCheckSchemeInGlobalWhiteList = mGlobalCheck.adCheckSchemeInGlobalWhiteList(str, str2, schemeStatisticField);
        if (z) {
            return OpenAppBaseCheck.checkTypeClose(adCheckSchemeInGlobalWhiteList, str);
        }
        return adCheckSchemeInGlobalWhiteList;
    }
}
