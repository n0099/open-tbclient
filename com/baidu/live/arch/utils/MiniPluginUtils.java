package com.baidu.live.arch.utils;

import android.util.SparseArray;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.live.interfaces.service.yy.YYPluginManageService;
import com.baidu.searchbox.live.interfaces.yy.plugin.YYPluginBundleInfo;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0006\u001a\u00020\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\b\u001a\u00020\u0001¢\u0006\u0004\b\b\u0010\u0007R\u0016\u0010\t\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\nR%\u0010\u0012\u001a\n \r*\u0004\u0018\u00010\f0\f8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/baidu/live/arch/utils/MiniPluginUtils;", "", "pkg", "", "getComponentInstalledVersion", "(Ljava/lang/String;)I", "getPluginVerPostParamKey", "()Ljava/lang/String;", "getPluginVerPostParamValue", "MEDIA_TOP_PLUGIN_PKG_NAME", "Ljava/lang/String;", "MIX_PLUGIN_VER_PARAM_KEY", "Lcom/baidu/searchbox/live/interfaces/service/yy/YYPluginManageService;", "kotlin.jvm.PlatformType", "pluginService$delegate", "Lkotlin/Lazy;", "getPluginService", "()Lcom/baidu/searchbox/live/interfaces/service/yy/YYPluginManageService;", "pluginService", "<init>", "()V", "lib-live-mini-arch_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class MiniPluginUtils {
    public static final String MEDIA_TOP_PLUGIN_PKG_NAME = "com.baidu.searchbox.livenps";
    public static final String MIX_PLUGIN_VER_PARAM_KEY = "npslist";
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(MiniPluginUtils.class), "pluginService", "getPluginService()Lcom/baidu/searchbox/live/interfaces/service/yy/YYPluginManageService;"))};
    public static final MiniPluginUtils INSTANCE = new MiniPluginUtils();
    public static final Lazy pluginService$delegate = LazyKt__LazyJVMKt.lazy(new Function0<YYPluginManageService>() { // from class: com.baidu.live.arch.utils.MiniPluginUtils$pluginService$2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final YYPluginManageService invoke() {
            return (YYPluginManageService) ServiceManager.getService(YYPluginManageService.Companion.getSERVICE_REFERENCE());
        }
    });

    private final YYPluginManageService getPluginService() {
        Lazy lazy = pluginService$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return (YYPluginManageService) lazy.getValue();
    }

    public final String getPluginVerPostParamKey() {
        return MIX_PLUGIN_VER_PARAM_KEY;
    }

    public final String getPluginVerPostParamValue() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("com.baidu.searchbox.livenps", String.valueOf(getComponentInstalledVersion("com.baidu.searchbox.livenps")));
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkExpressionValueIsNotNull(jSONObject2, "json.toString()");
        return jSONObject2;
    }

    public final int getComponentInstalledVersion(String str) {
        SparseArray<YYPluginBundleInfo> pluginBundleInfo;
        YYPluginBundleInfo yYPluginBundleInfo;
        YYPluginManageService pluginService = getPluginService();
        if (pluginService != null && (pluginBundleInfo = pluginService.getPluginBundleInfo(str)) != null && (yYPluginBundleInfo = pluginBundleInfo.get(3)) != null) {
            return yYPluginBundleInfo.getVersionCode();
        }
        return 0;
    }
}
