package com.baidu.searchbox.download.center.clearcache;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.system.Os;
import android.util.Log;
import com.baidu.android.util.devices.StorageUtils;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.ubc.UBCManager;
import com.baidu.webkit.sdk.performance.ZeusPerformanceTiming;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\u001aA\u0010\b\u001a\u00020\u00072\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00002\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004¢\u0006\u0004\b\b\u0010\t\u001a\u0019\u0010\f\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0007¢\u0006\u0004\b\f\u0010\r\u001a\u0013\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0013\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000¢\u0006\u0004\b\u0010\u0010\u000f\"%\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0016\u0010\u0016\u001a\u00020\n8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017\"\u0016\u0010\u0019\u001a\u00020\u00188\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"", "Ljava/io/File;", "fileList", "excludeFileList", "Lkotlin/Function1;", "", "predicate", "", "calculateFileListSize", "(Ljava/util/List;Ljava/util/List;Lkotlin/Function1;)J", "", "monitorType", "cleanCacheMonitorUBC", "(Ljava/lang/String;)V", "getAppFileList", "()Ljava/util/List;", "getUserAssetFileList", "", "DIR_BUSINESS_MAP", "Ljava/util/Map;", "getDIR_BUSINESS_MAP", "()Ljava/util/Map;", "UBC_CLEAN_CACHE_MONITOR", "Ljava/lang/String;", "", "UBC_EXCEPTION_FILE_MAX", "I", "lib-clearcache-base_release"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class DiskUtilKt {
    public static final Map<String, String> DIR_BUSINESS_MAP = MapsKt__MapsKt.mapOf(TuplesKt.to("/files/gameCenter/", "小游戏"), TuplesKt.to("/files/swanAdDownload/", "小游戏"), TuplesKt.to("/cache/app_mario/", "小游戏"), TuplesKt.to("/files/aigames_folder/", "小游戏"), TuplesKt.to("/files/swangame/", "小游戏"), TuplesKt.to("/files/swan_prefs/", "小游戏"), TuplesKt.to("/files/live_sdk/", "直播"), TuplesKt.to("/files/enter_effect/", "直播"), TuplesKt.to("/files/tblive_mobilebaidu/", "直播"), TuplesKt.to("/files/nps_live_files/", "直播"), TuplesKt.to("/files/pms/", "PMS"), TuplesKt.to("/files/splash_source_new/", "开屏广告"), TuplesKt.to("/files/splash_cache/", "开屏广告"), TuplesKt.to("/files/aiapps_folder/", "小程序"), TuplesKt.to("/files/aiapps_zip/", "小程序"), TuplesKt.to("/files/rtc/", "小程序"), TuplesKt.to("/files/downloads/", "下载"), TuplesKt.to("/files/talos/", "Talos"), TuplesKt.to("/cache/v8_codecache_v76/", "Talos"), TuplesKt.to("/files/v8_codecache_v76/", "Talos"), TuplesKt.to("/files/reactnative/", "Talos"), TuplesKt.to("/files/talos_libs/", "Talos"), TuplesKt.to("/files/sticker/", "AR"), TuplesKt.to("/files/arlibs/", "AR"), TuplesKt.to("/cache/ar/", "AR"), TuplesKt.to("/files/feature/", "AR"), TuplesKt.to("/app_nps_download/", "插件"), TuplesKt.to("/app_nps/", "插件"), TuplesKt.to("/files/com.baidu.searchbox.godeye/", "图搜"), TuplesKt.to("/files/y/", "图搜"), TuplesKt.to("/cache/baidu/flyflow/", "播放内核"), TuplesKt.to("/cache/webview_baidu_media/", "播放内核"), TuplesKt.to("/files/cybermedia/", "播放内核"), TuplesKt.to("/files/cyberplayer/", "播放内核"), TuplesKt.to("/cache/webview_baidu_com.baidu.searchbox/", "浏览内核-主进程"), TuplesKt.to("/files/zeus/", "浏览内核-主进程"), TuplesKt.to("/app_webview_baidu_com.baidu.searchbox/", "浏览内核-主进程"), TuplesKt.to("/files/zeusupdate/", "浏览内核-主进程"), TuplesKt.to("/files/zeus_config/", "浏览内核-主进程"), TuplesKt.to("/app_webview_baidu/", "浏览内核-主进程"), TuplesKt.to("/cache/org.chromium.android_webview/", "浏览内核-主进程"), TuplesKt.to("/cache/hws_webview/", "浏览内核-主进程"), TuplesKt.to("/app_mario/", "浏览内核-主进程"), TuplesKt.to("/cache/webview_baidu_com.baidu.searchbox:swan", "浏览内核-小程序"), TuplesKt.to("/app_webview_baidu_com.baidu.searchbox:swan", "浏览内核-小程序"));
    public static final String UBC_CLEAN_CACHE_MONITOR = "2304";
    public static final int UBC_EXCEPTION_FILE_MAX = 10;

    public static final long calculateFileListSize(List<? extends File> fileList, List<? extends File> list, Function1<? super File, Unit> function1) {
        Intrinsics.checkNotNullParameter(fileList, "fileList");
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(fileList);
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (File file : list) {
                arrayList.add(file.getAbsolutePath());
            }
        }
        long j = 0;
        while (true) {
            File file2 = (File) linkedList.poll();
            if (file2 != null) {
                if (file2.exists()) {
                    if (arrayList.contains(file2.getAbsolutePath())) {
                        if (AppConfig.isDebug()) {
                            Log.d("ExcludeList", file2.getAbsolutePath());
                        }
                    } else {
                        File[] listFiles = file2.listFiles();
                        if (listFiles != null) {
                            for (File file3 : listFiles) {
                                if (file3 != null && file3.exists()) {
                                    linkedList.offer(file3);
                                }
                            }
                        } else {
                            if (function1 != null) {
                                function1.invoke(file2);
                            }
                            j += file2.length();
                        }
                    }
                }
            } else {
                return j;
            }
        }
    }

    @SuppressLint({"DefaultLocale"})
    public static final void cleanCacheMonitorUBC(final String str) {
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.searchbox.download.center.clearcache.DiskUtilKt$cleanCacheMonitorUBC$1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    final long totalExternalMemorySize = StorageUtils.getTotalExternalMemorySize();
                    long availableExternalMemorySize = StorageUtils.getAvailableExternalMemorySize();
                    final JSONArray jSONArray = new JSONArray();
                    final JSONObject jSONObject = new JSONObject();
                    long calculateFileListSize = DiskUtilKt.calculateFileListSize(DiskUtilKt.getAppFileList(), DiskUtilKt.getUserAssetFileList(), new Function1<File, Unit>() { // from class: com.baidu.searchbox.download.center.clearcache.DiskUtilKt$cleanCacheMonitorUBC$1$baidu$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(File file) {
                            invoke2(file);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2(File it) {
                            long j;
                            Intrinsics.checkNotNullParameter(it, "it");
                            if (jSONArray.length() < 10 && it.length() >= totalExternalMemorySize) {
                                JSONObject jSONObject2 = new JSONObject();
                                jSONObject2.put("path", it.getAbsolutePath());
                                jSONObject2.put("length", it.length());
                                jSONObject2.put("lastModified", it.lastModified());
                                if (Build.VERSION.SDK_INT >= 21) {
                                    j = Os.lstat(it.getAbsolutePath()).st_atime;
                                } else {
                                    j = 0;
                                }
                                jSONObject2.put("lastAccessTime", j);
                                jSONArray.put(jSONObject2);
                            }
                            String filePath = it.getAbsolutePath();
                            for (Map.Entry<String, String> entry : DiskUtilKt.getDIR_BUSINESS_MAP().entrySet()) {
                                String value = entry.getValue();
                                Intrinsics.checkNotNullExpressionValue(filePath, "filePath");
                                if (StringsKt__StringsKt.contains$default((CharSequence) filePath, (CharSequence) entry.getKey(), false, 2, (Object) null)) {
                                    JSONObject jSONObject3 = jSONObject;
                                    jSONObject3.put(value, jSONObject3.optLong(value) + it.length());
                                    return;
                                }
                            }
                        }
                    });
                    long calculateFileListSize2 = DiskUtilKt.calculateFileListSize(DiskUtilKt.getUserAssetFileList(), null, new Function1<File, Unit>() { // from class: com.baidu.searchbox.download.center.clearcache.DiskUtilKt$cleanCacheMonitorUBC$1$userAssets$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(File file) {
                            invoke2(file);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2(File it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            String filePath = it.getAbsolutePath();
                            for (Map.Entry<String, String> entry : DiskUtilKt.getDIR_BUSINESS_MAP().entrySet()) {
                                String value = entry.getValue();
                                Intrinsics.checkNotNullExpressionValue(filePath, "filePath");
                                if (StringsKt__StringsKt.contains$default((CharSequence) filePath, (CharSequence) entry.getKey(), false, 2, (Object) null)) {
                                    JSONObject jSONObject2 = jSONObject;
                                    jSONObject2.put(value, jSONObject2.optLong(value) + it.length());
                                    return;
                                }
                            }
                        }
                    });
                    JSONObject jSONObject2 = new JSONObject();
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put(PackageTable.TOTAL_SIZE, totalExternalMemorySize);
                    jSONObject3.put("free_size", availableExternalMemorySize);
                    jSONObject3.put("baidu_size", calculateFileListSize);
                    jSONObject3.put("userAssets", calculateFileListSize2);
                    String str2 = DiskManager.INSTANCE.getDiskLevel().toString();
                    if (str2 != null) {
                        String lowerCase = str2.toLowerCase();
                        Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
                        jSONObject3.put("diskLevel", lowerCase);
                        jSONObject3.put("list", jSONObject);
                        if (calculateFileListSize < totalExternalMemorySize) {
                            jSONObject2.put("type", str);
                            jSONObject2.put("ext", jSONObject3);
                        } else {
                            jSONObject2.put("type", "3");
                            jSONObject3.put("exceptionFiles", jSONArray);
                            JSONObject jSONObject4 = new JSONObject();
                            jSONObject4.put("exception", jSONObject3);
                            jSONObject2.put("ext", jSONObject4);
                        }
                        UBCManager uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
                        if (AppConfig.isDebug()) {
                            Log.d("cleanCacheMonitorUBC", jSONObject2.toString());
                            if (uBCManager == null) {
                                Log.d("cleanCacheMonitorUBC", "ubc is null!");
                            }
                        }
                        if (uBCManager != null) {
                            uBCManager.onEvent(DiskUtilKt.UBC_CLEAN_CACHE_MONITOR, jSONObject2);
                            return;
                        }
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                } catch (Exception e) {
                    if (AppConfig.isDebug()) {
                        e.printStackTrace();
                    }
                }
            }
        }, "cleanCacheMonitorUBC", 3);
    }

    public static final List<File> getAppFileList() {
        ArrayList arrayList = new ArrayList(2);
        Context appContext = AppRuntime.getAppContext();
        Intrinsics.checkNotNullExpressionValue(appContext, "AppRuntime.getAppContext()");
        File filesDir = appContext.getFilesDir();
        if (filesDir != null) {
            filesDir = filesDir.getParentFile();
        }
        if (filesDir != null && filesDir.exists()) {
            arrayList.add(filesDir);
        }
        File externalFilesDir = AppRuntime.getAppContext().getExternalFilesDir(null);
        if (externalFilesDir != null) {
            externalFilesDir = externalFilesDir.getParentFile();
        }
        if (externalFilesDir != null && externalFilesDir.exists()) {
            arrayList.add(externalFilesDir);
        }
        return arrayList;
    }

    public static final List<File> getUserAssetFileList() {
        ArrayList arrayList = new ArrayList(3);
        Context appContext = AppRuntime.getAppContext();
        Intrinsics.checkNotNullExpressionValue(appContext, "AppRuntime.getAppContext()");
        File filesDir = appContext.getFilesDir();
        if (filesDir != null) {
            arrayList.add(new File(filesDir, "downloads"));
        }
        File externalFilesDir = AppRuntime.getAppContext().getExternalFilesDir(null);
        if (externalFilesDir != null) {
            arrayList.add(new File(externalFilesDir, "downloads"));
            arrayList.add(new File(externalFilesDir, ZeusPerformanceTiming.KEY_UNZIP));
        }
        return arrayList;
    }

    public static final Map<String, String> getDIR_BUSINESS_MAP() {
        return DIR_BUSINESS_MAP;
    }
}
