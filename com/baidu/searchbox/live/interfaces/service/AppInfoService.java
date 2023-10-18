package com.baidu.searchbox.live.interfaces.service;

import android.app.Application;
import android.content.Context;
import android.webkit.WebView;
import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.searchbox.launch.utils.SpeedStatsUtils;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\bf\u0018\u0000 \"2\u00020\u0001:\u0001\"J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\r\u0010\tJ\u000f\u0010\u000e\u001a\u00020\u0007H&¢\u0006\u0004\b\u000e\u0010\tJ\u000f\u0010\u000f\u001a\u00020\u0007H&¢\u0006\u0004\b\u000f\u0010\tJ\u000f\u0010\u0010\u001a\u00020\u0007H&¢\u0006\u0004\b\u0010\u0010\tJ\u000f\u0010\u0011\u001a\u00020\u0007H&¢\u0006\u0004\b\u0011\u0010\tJ\u000f\u0010\u0012\u001a\u00020\u0007H&¢\u0006\u0004\b\u0012\u0010\tJ\u000f\u0010\u0013\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0013\u0010\tJ\u000f\u0010\u0014\u001a\u00020\u0007H&¢\u0006\u0004\b\u0014\u0010\tJ\u0019\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H&¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0007H&¢\u0006\u0004\b\u001a\u0010\tJ\u000f\u0010\u001b\u001a\u00020\u0007H&¢\u0006\u0004\b\u001b\u0010\tJ\u000f\u0010\u001c\u001a\u00020\u0007H&¢\u0006\u0004\b\u001c\u0010\tJ\u000f\u0010\u001d\u001a\u00020\u0007H&¢\u0006\u0004\b\u001d\u0010\tJ\u000f\u0010\u001f\u001a\u00020\u001eH&¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u001eH&¢\u0006\u0004\b!\u0010 ¨\u0006#"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/service/AppInfoService;", "Lkotlin/Any;", "Landroid/webkit/WebView;", AlbumActivityConfig.FROM_WEB_VIEW, "", "addHostJavascriptInterface", "(Landroid/webkit/WebView;)V", "", "getAppName", "()Ljava/lang/String;", "Landroid/app/Application;", "getApplication", "()Landroid/app/Application;", "getCloudControlUrl", "getCuid", "getFFmpegPath", "getImAppId", "getLiveAppId", "getPackageName", "getProtocol", "getSid", "Landroid/content/Context;", "context", "", "getStaticDeviceScore", "(Landroid/content/Context;)F", "getUA", "getVersionCode", "getVersionName", CommonTbJsBridge.GET_ZID, "", "isDebug", "()Z", SpeedStatsUtils.IS_NIGHT_MODE, "Companion", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes4.dex */
public interface AppInfoService {
    public static final Companion Companion = Companion.$$INSTANCE;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 1, 16}, pn = "", xi = 0, xs = "")
    /* loaded from: classes4.dex */
    public static final class DefaultImpls {
        public static void addHostJavascriptInterface(AppInfoService appInfoService, WebView webView) {
        }

        public static String getCloudControlUrl(AppInfoService appInfoService) {
            return "";
        }

        public static String getProtocol(AppInfoService appInfoService) {
            return "";
        }
    }

    void addHostJavascriptInterface(WebView webView);

    String getAppName();

    Application getApplication();

    String getCloudControlUrl();

    String getCuid();

    String getFFmpegPath();

    String getImAppId();

    String getLiveAppId();

    String getPackageName();

    String getProtocol();

    String getSid();

    float getStaticDeviceScore(Context context);

    String getUA();

    String getVersionCode();

    String getVersionName();

    String getZid();

    boolean isDebug();

    boolean isNightMode();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0019\u0010\u0002\u001a\u00020\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/service/AppInfoService$Companion;", "Lcom/baidu/pyramid/runtime/service/ServiceReference;", "SERVICE_REFERENCE", "Lcom/baidu/pyramid/runtime/service/ServiceReference;", "getSERVICE_REFERENCE", "()Lcom/baidu/pyramid/runtime/service/ServiceReference;", "<init>", "()V", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes4.dex */
    public static final class Companion {
        public static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final ServiceReference SERVICE_REFERENCE = DI.INSTANCE.getServiceRef(DI.APP_INFO_NAME);

        public final ServiceReference getSERVICE_REFERENCE() {
            return SERVICE_REFERENCE;
        }
    }
}
