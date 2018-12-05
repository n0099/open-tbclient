package com.baidu.searchbox.ng.ai.apps.ioc;

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
public class AiAppsRuntimeInit {
    public static void setAiAppsSocialShareImpl(IAiAppsSocialShareIoc iAiAppsSocialShareIoc) {
        AiAppsRuntime.sAiAppsSocialShareIoc = iAiAppsSocialShareIoc;
    }

    public static void setAiAppAbTestImpl(IAiAppAbTestIoc iAiAppAbTestIoc) {
        AiAppsRuntime.sAiAppAbTestIoc = iAiAppAbTestIoc;
    }

    public static void setAiAppAccountImpl(IAiAppAccountIoc iAiAppAccountIoc) {
        AiAppsRuntime.sAiAppAccountIoc = iAiAppAccountIoc;
    }

    public static void setAiAppChooseAddressImpl(IAiAppChooseAddressIoc iAiAppChooseAddressIoc) {
        AiAppsRuntime.sAiAppChooseAddressIoc = iAiAppChooseAddressIoc;
    }

    public static void setAiAppChooseInvoiceImpl(IAiAppChooseInvoiceIoc iAiAppChooseInvoiceIoc) {
        AiAppsRuntime.sAiAppChooseInvoiceIoc = iAiAppChooseInvoiceIoc;
    }

    public static void setAiAppScanCodeImpl(IAiAppScanCodeIoc iAiAppScanCodeIoc) {
        AiAppsRuntime.sAiAppScanCodeIoc = iAiAppScanCodeIoc;
    }

    public static void setAiAppFeedbackImpl(IAiAppFeedbackIoc iAiAppFeedbackIoc) {
        AiAppsRuntime.sAiAppFeedbackIoc = iAiAppFeedbackIoc;
    }

    public static void setAiAppDownloadImpl(IAiAppDownloadIoc iAiAppDownloadIoc) {
        AiAppsRuntime.sAiAppDownloadIoc = iAiAppDownloadIoc;
    }

    public static void setAiAppMapImpl(IAiAppMapIoc iAiAppMapIoc) {
        AiAppsRuntime.sAiAppMapIoc = iAiAppMapIoc;
    }

    public static void setAiAppConfigImpl(IAiAppConfigIoc iAiAppConfigIoc) {
        AiAppsRuntime.sAiAppConfigIoc = iAiAppConfigIoc;
    }

    public static void setAiAppVideoImpl(IAiAppVideoIoc iAiAppVideoIoc) {
        AiAppsRuntime.sAiAppVideoIoc = iAiAppVideoIoc;
    }

    public static void setAiAppLiveImpl(IAiAppLiveIoc iAiAppLiveIoc) {
        AiAppsRuntime.sAiAppLiveIoc = iAiAppLiveIoc;
    }

    public static void setAiAppImageImpl(IAiAppImageIoc iAiAppImageIoc) {
        AiAppsRuntime.sAiAppImageIoc = iAiAppImageIoc;
    }

    public static void setAiAppTTSImpl(IAiAppTTSIoc iAiAppTTSIoc) {
        AiAppsRuntime.sAiAppTTSIoc = iAiAppTTSIoc;
    }

    public static void setAiAppPaymentImpl(IAiAppPaymentIoc iAiAppPaymentIoc) {
        AiAppsRuntime.sAiAppPaymentIoc = iAiAppPaymentIoc;
    }

    public static void setAiAppPolymerPayImpl(IAiAppPolymerPay iAiAppPolymerPay) {
        AiAppsRuntime.sAiAppPolymerPay = iAiAppPolymerPay;
    }

    public static void setAiAppPluginImpl(IAiAppPluginIoc iAiAppPluginIoc) {
        AiAppsRuntime.sAiAppPluginIoc = iAiAppPluginIoc;
    }

    public static void setAiAppIMImpl(IAiAppIMIoc iAiAppIMIoc) {
        AiAppsRuntime.sAiAppIMIoc = iAiAppIMIoc;
    }

    public static void setAiAppLocationImpl(IAiAppLocationIoc iAiAppLocationIoc) {
        AiAppsRuntime.sAiAppLocationIoc = iAiAppLocationIoc;
    }

    public static void setAiAppHistoryImpl(IAiAppHistoryIoc iAiAppHistoryIoc) {
        AiAppsRuntime.sAiAppHistoryIoc = iAiAppHistoryIoc;
    }

    public static void setAiAppNightModeImpl(IAiAppNightModeIoc iAiAppNightModeIoc) {
        AiAppsRuntime.sAiAppNightModeIoc = iAiAppNightModeIoc;
    }

    public static void setAiAppsBlinkAbTestImpl(IAiAppsBlinkAbTestIoc iAiAppsBlinkAbTestIoc) {
        AiAppsRuntime.sAiAppsBlinkAbTestIoc = iAiAppsBlinkAbTestIoc;
    }

    public static void setAiAppDebugImpl(IAiAppDebugIoc iAiAppDebugIoc) {
        AiAppsRuntime.sIAiAppDebugIoc = iAiAppDebugIoc;
    }

    public static void setAiAppExtendSchemeImpl(IAiAppExtentSchemeIoc iAiAppExtentSchemeIoc) {
        AiAppsRuntime.sAiAppExtentSchemeIoc = iAiAppExtentSchemeIoc;
    }
}
