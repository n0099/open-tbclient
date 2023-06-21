package com.baidu.searchbox.live.util;

import com.baidu.android.common.others.IStringUtil;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.live.interfaces.mix.PluginInvokeService;
import com.google.android.exoplayer2.extractor.ogg.DefaultOggSeeker;
import com.huawei.hms.framework.common.ExceptionCode;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000f\bÆ\u0002\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u00020\u00048\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\u000eR%\u0010\u0014\u001a\n \u0010*\u0004\u0018\u00010\u00010\u00018B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0003¨\u0006\u0017"}, d2 = {"Lcom/baidu/searchbox/live/util/MiniPluginInfoHelper;", "Lcom/baidu/searchbox/live/interfaces/mix/PluginInvokeService;", "getPluginInvokeService", "()Lcom/baidu/searchbox/live/interfaces/mix/PluginInvokeService;", "", "getSdkName", "()Ljava/lang/String;", "pkgName", "", "getVersionCode", "(Ljava/lang/String;)I", "getVersionName", "(Ljava/lang/String;)Ljava/lang/String;", "MEDIA_TOP_PLUGIN_PKG_NAME", "Ljava/lang/String;", "YY_TOP_PLUGIN_PKG_NAME", "kotlin.jvm.PlatformType", "pluginManagerService$delegate", "Lkotlin/Lazy;", "getPluginManagerService", "pluginManagerService", "<init>", "()V", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes4.dex */
public final class MiniPluginInfoHelper {
    public static final String MEDIA_TOP_PLUGIN_PKG_NAME = "com.baidu.searchbox.livenps";
    public static final String YY_TOP_PLUGIN_PKG_NAME = "com.baidu.searchbox.yylive.entrance";
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(MiniPluginInfoHelper.class), "pluginManagerService", "getPluginManagerService()Lcom/baidu/searchbox/live/interfaces/mix/PluginInvokeService;"))};
    public static final MiniPluginInfoHelper INSTANCE = new MiniPluginInfoHelper();
    public static final Lazy pluginManagerService$delegate = LazyKt__LazyJVMKt.lazy(new Function0<PluginInvokeService>() { // from class: com.baidu.searchbox.live.util.MiniPluginInfoHelper$pluginManagerService$2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final PluginInvokeService invoke() {
            return (PluginInvokeService) ServiceManager.getService(PluginInvokeService.Companion.getSERVICE_REFERENCE());
        }
    });

    private final PluginInvokeService getPluginManagerService() {
        Lazy lazy = pluginManagerService$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return (PluginInvokeService) lazy.getValue();
    }

    public final PluginInvokeService getPluginInvokeService() {
        return getPluginManagerService();
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r3v0 int), (wrap: char : ?: SGET   com.baidu.android.common.others.IStringUtil.EXTENSION_SEPARATOR char)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x002f: ARITH  (r4v0 int A[REMOVE]) = (r0v4 int) / (1000000 int)), (wrap: char : ?: SGET   com.baidu.android.common.others.IStringUtil.EXTENSION_SEPARATOR char)] */
    public final String getSdkName() {
        int versionCode = getVersionCode("com.baidu.searchbox.livenps") - 600000000;
        if (versionCode < 0) {
            versionCode = 0;
        }
        StringBuilder sb = new StringBuilder();
        int i = versionCode / ExceptionCode.CRASH_EXCEPTION;
        int i2 = versionCode % ExceptionCode.CRASH_EXCEPTION;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(i);
        sb2.append(IStringUtil.EXTENSION_SEPARATOR);
        sb.append(sb2.toString());
        StringBuilder sb3 = new StringBuilder();
        sb3.append(i2 / 1000000);
        sb3.append(IStringUtil.EXTENSION_SEPARATOR);
        sb.append(sb3.toString());
        sb.append(String.valueOf((i2 % 1000000) / DefaultOggSeeker.MATCH_BYTE_RANGE));
        String sb4 = sb.toString();
        Intrinsics.checkExpressionValueIsNotNull(sb4, "versionNameBuilder.toString()");
        return sb4;
    }

    public final int getVersionCode(String str) {
        PluginInvokeService pluginManagerService = getPluginManagerService();
        if (pluginManagerService != null) {
            return pluginManagerService.getPluginVersionCode(str);
        }
        return 0;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r2v0 int), (wrap: char : ?: SGET   com.baidu.android.common.others.IStringUtil.EXTENSION_SEPARATOR char)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r3v0 int), (wrap: char : ?: SGET   com.baidu.android.common.others.IStringUtil.EXTENSION_SEPARATOR char)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0054: ARITH  (r1v9 int A[REMOVE]) = (r5v6 int) / (1000 int)), (wrap: char : ?: SGET   com.baidu.android.common.others.IStringUtil.EXTENSION_SEPARATOR char)] */
    public final String getVersionName(String str) {
        int versionCode = getVersionCode(str) - 600000000;
        if (versionCode < 0) {
            versionCode = 0;
        }
        StringBuilder sb = new StringBuilder();
        int i = versionCode / ExceptionCode.CRASH_EXCEPTION;
        int i2 = versionCode % ExceptionCode.CRASH_EXCEPTION;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(i);
        sb2.append(IStringUtil.EXTENSION_SEPARATOR);
        sb.append(sb2.toString());
        int i3 = i2 / 1000000;
        int i4 = i2 % 1000000;
        StringBuilder sb3 = new StringBuilder();
        sb3.append(i3);
        sb3.append(IStringUtil.EXTENSION_SEPARATOR);
        sb.append(sb3.toString());
        int i5 = i4 / DefaultOggSeeker.MATCH_BYTE_RANGE;
        int i6 = i4 % DefaultOggSeeker.MATCH_BYTE_RANGE;
        sb.append(String.valueOf(i5));
        sb.append(".");
        StringBuilder sb4 = new StringBuilder();
        sb4.append(i6 / 1000);
        sb4.append(IStringUtil.EXTENSION_SEPARATOR);
        sb.append(sb4.toString());
        sb.append(i6 % 1000);
        String sb5 = sb.toString();
        Intrinsics.checkExpressionValueIsNotNull(sb5, "versionNameBuilder.toString()");
        return sb5;
    }
}
