package com.baidu.searchbox.ng.ai.apps.ioc;

import android.app.Application;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.ng.ai.apps.barcode.IAiAppScanCodeIoc;
import com.baidu.searchbox.ng.ai.apps.invoice.IAiAppChooseInvoiceIoc;
import com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppAbTestIoc;
import com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppAccountIoc;
import com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppChooseAddressIoc;
import com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppConfigIoc;
import com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppDebugIoc;
import com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppDownloadIoc;
import com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppExtentSchemeIoc;
import com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppFeedbackIoc;
import com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppHistoryIoc;
import com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppIMIoc;
import com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppImageIoc;
import com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppLiveIoc;
import com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppLocationIoc;
import com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppMapIoc;
import com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppNightModeIoc;
import com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppPaymentIoc;
import com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppPluginIoc;
import com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppPolymerPay;
import com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppTTSIoc;
import com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppVideoIoc;
import com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppsBlinkAbTestIoc;
import com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppsSocialShareIoc;
/* loaded from: classes2.dex */
public final class AiAppsRuntime {
    static IAiAppsSocialShareIoc sAiAppsSocialShareIoc = null;
    static IAiAppAbTestIoc sAiAppAbTestIoc = null;
    static IAiAppAccountIoc sAiAppAccountIoc = null;
    static IAiAppChooseAddressIoc sAiAppChooseAddressIoc = null;
    static IAiAppChooseInvoiceIoc sAiAppChooseInvoiceIoc = null;
    static IAiAppScanCodeIoc sAiAppScanCodeIoc = null;
    static IAiAppFeedbackIoc sAiAppFeedbackIoc = null;
    static IAiAppDownloadIoc sAiAppDownloadIoc = null;
    static IAiAppMapIoc sAiAppMapIoc = null;
    static IAiAppConfigIoc sAiAppConfigIoc = null;
    static IAiAppVideoIoc sAiAppVideoIoc = null;
    static IAiAppLiveIoc sAiAppLiveIoc = null;
    static IAiAppImageIoc sAiAppImageIoc = null;
    static IAiAppTTSIoc sAiAppTTSIoc = null;
    static IAiAppPaymentIoc sAiAppPaymentIoc = null;
    static IAiAppPolymerPay sAiAppPolymerPay = null;
    static IAiAppPluginIoc sAiAppPluginIoc = null;
    static IAiAppIMIoc sAiAppIMIoc = null;
    static IAiAppLocationIoc sAiAppLocationIoc = null;
    static IAiAppHistoryIoc sAiAppHistoryIoc = null;
    static IAiAppNightModeIoc sAiAppNightModeIoc = null;
    static IAiAppsBlinkAbTestIoc sAiAppsBlinkAbTestIoc = null;
    static IAiAppDebugIoc sIAiAppDebugIoc = null;
    static IAiAppExtentSchemeIoc sAiAppExtentSchemeIoc = null;
    private static Application sApplication = AppRuntime.getApplication();

    public static Application getAppContext() {
        return sApplication;
    }

    public static IAiAppsSocialShareIoc getSocialShareRuntime() {
        return sAiAppsSocialShareIoc;
    }

    public static IAiAppAbTestIoc getAiAppAbTestRuntime() {
        return sAiAppAbTestIoc;
    }

    public static IAiAppAccountIoc getAiAppAccountRuntime() {
        return sAiAppAccountIoc;
    }

    public static IAiAppChooseAddressIoc getAiAppChooseAddressRuntime() {
        return sAiAppChooseAddressIoc;
    }

    public static IAiAppChooseInvoiceIoc getAiAppChooseInvoiceRuntime() {
        return sAiAppChooseInvoiceIoc;
    }

    public static IAiAppScanCodeIoc getScanCodeRuntime() {
        return sAiAppScanCodeIoc;
    }

    public static IAiAppFeedbackIoc getFeedbackRuntime() {
        return sAiAppFeedbackIoc;
    }

    public static IAiAppDownloadIoc getAppDownloadRuntime() {
        return sAiAppDownloadIoc;
    }

    public static IAiAppMapIoc getMapRuntime() {
        return sAiAppMapIoc;
    }

    public static IAiAppConfigIoc getConfigRuntime() {
        return sAiAppConfigIoc;
    }

    public static IAiAppVideoIoc getVideoRuntime() {
        return sAiAppVideoIoc;
    }

    public static IAiAppLiveIoc getLiveRuntime() {
        return sAiAppLiveIoc;
    }

    public static IAiAppImageIoc getImageRuntime() {
        return sAiAppImageIoc;
    }

    public static IAiAppTTSIoc getTTSRuntime() {
        return sAiAppTTSIoc;
    }

    public static IAiAppPaymentIoc getPaymentRuntime() {
        return sAiAppPaymentIoc;
    }

    public static IAiAppPolymerPay getPolymerPayRuntime() {
        return sAiAppPolymerPay;
    }

    public static IAiAppPluginIoc getPluginRuntime() {
        return sAiAppPluginIoc;
    }

    public static IAiAppIMIoc getIMRuntime() {
        return sAiAppIMIoc;
    }

    public static IAiAppLocationIoc getLocationRuntime() {
        return sAiAppLocationIoc;
    }

    public static IAiAppHistoryIoc getHistoryRuntime() {
        return sAiAppHistoryIoc;
    }

    public static IAiAppNightModeIoc getNightModeRuntime() {
        return sAiAppNightModeIoc;
    }

    public static IAiAppsBlinkAbTestIoc getBlinkAbTestRuntime() {
        return sAiAppsBlinkAbTestIoc;
    }

    public static IAiAppDebugIoc getDebugRuntime() {
        return sIAiAppDebugIoc;
    }

    public static IAiAppExtentSchemeIoc getAiAppExtentSchemeRuntime() {
        return sAiAppExtentSchemeIoc;
    }
}
