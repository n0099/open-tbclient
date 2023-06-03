package com.baidu.searchbox.download.center.clearcache;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.util.devices.StorageUtils;
import com.baidu.android.util.sp.SharedPrefsWrapper;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.download.center.clearcache.DiskManager;
import com.baidu.searchbox.download.center.clearcache.util.ClearCacheUtils;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.webkit.sdk.WebChromeClient;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u0000:\u0003MNOB\t\b\u0002¢\u0006\u0004\bL\u0010%J\u0015\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\f\u0010\u000bJ\r\u0010\r\u001a\u00020\b¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\b¢\u0006\u0004\b\u000f\u0010\u000eJ\r\u0010\u0010\u001a\u00020\u0006¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0012H\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0017\u0010\u0018J1\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00062\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0015\u0010 \u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u001f¢\u0006\u0004\b \u0010!J\u0015\u0010\"\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\"\u0010#J\r\u0010$\u001a\u00020\u0003¢\u0006\u0004\b$\u0010%J\u0015\u0010&\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u001f¢\u0006\u0004\b&\u0010!J\u001f\u0010(\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010'\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b(\u0010)R\u0016\u0010+\u001a\u00020*8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010-\u001a\u00020*8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b-\u0010,R\u0016\u0010.\u001a\u00020*8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b.\u0010,R\u0016\u0010/\u001a\u00020*8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b/\u0010,R\u0016\u00101\u001a\u0002008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00103\u001a\u00020*8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b3\u0010,R\u0016\u00104\u001a\u00020*8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b4\u0010,R\u0016\u00105\u001a\u00020*8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b5\u0010,R\u0016\u00106\u001a\u00020*8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b6\u0010,R\u0016\u00107\u001a\u00020*8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b7\u0010,R\u001c\u00109\u001a\b\u0012\u0004\u0012\u00020\u001f088\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010;\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010>\u001a\u00020=8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010?R*\u0010A\u001a\u00020\b2\u0006\u0010@\u001a\u00020\b8B@BX\u0082\u000e¢\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010\u000e\"\u0004\bD\u0010ER\u0018\u0010G\u001a\u0004\u0018\u00010F8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010J\u001a\u00020I8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bJ\u0010K¨\u0006P"}, d2 = {"Lcom/baidu/searchbox/download/center/clearcache/DiskManager;", "Lcom/baidu/searchbox/download/center/clearcache/AllCompletionCallback;", WebChromeClient.KEY_ARG_CALLBACK, "", "forceCheckDiskAndNotify", "(Lcom/baidu/searchbox/download/center/clearcache/AllCompletionCallback;)V", "Lcom/baidu/searchbox/download/center/clearcache/DiskManager$DiskLevel;", "lastLevel", "", "diffSize", "getCurrentAppLevel", "(Lcom/baidu/searchbox/download/center/clearcache/DiskManager$DiskLevel;J)Lcom/baidu/searchbox/download/center/clearcache/DiskManager$DiskLevel;", "getCurrentDiskLevel", "getDiskAllSizeByG", "()J", "getDiskAvailSizeByM", "getDiskLevel", "()Lcom/baidu/searchbox/download/center/clearcache/DiskManager$DiskLevel;", "Lcom/baidu/searchbox/download/center/clearcache/DiskManager$QuotaBusiness;", "bussinessId", "getQuota", "(Lcom/baidu/searchbox/download/center/clearcache/DiskManager$QuotaBusiness;)J", "", "isMark", "()Z", "Lcom/baidu/searchbox/download/center/clearcache/DiskManager$NotifyLevel;", "notifyLevel", "lastState", "currentState", "notifyDiskLevelChanged", "(Lcom/baidu/searchbox/download/center/clearcache/DiskManager$NotifyLevel;Lcom/baidu/searchbox/download/center/clearcache/DiskManager$DiskLevel;Lcom/baidu/searchbox/download/center/clearcache/DiskManager$DiskLevel;Lcom/baidu/searchbox/download/center/clearcache/AllCompletionCallback;)Z", "Lcom/baidu/searchbox/download/center/clearcache/BDDiskUsageLevelChangedCallback;", "registerDiskUsageLevelChangedObserver", "(Lcom/baidu/searchbox/download/center/clearcache/BDDiskUsageLevelChangedCallback;)V", "setMark", "(Z)V", "startCheckDiskStateAndNotify", "()V", "unRegisterDiskUsageLevelChangedObserver", "allCompletionCallback", "updateDiskLevelAndNotify", "(Lcom/baidu/searchbox/download/center/clearcache/DiskManager$NotifyLevel;Lcom/baidu/searchbox/download/center/clearcache/AllCompletionCallback;)V", "", "DEBUG_DISK_LEVEL_KEY", "Ljava/lang/String;", "DEBUG_DISK_OPEN_KEY", "DISK_LEVEL_VERSION_KEY", "DISK_MARK_PREF_KEY", "", "MEMORY_BASE_UNIT", "I", "MONITOR_TYPE_CLEAN_CONFIRM", "MONITOR_TYPE_COLD_START", "MONITOR_TYPE_DISK_LEVEL_CHANGE", "MONITOR_TYPE_EXCEPTION", "TAG", "", "diskUsageLevelChangedObservers", "Ljava/util/List;", "firstStart", "Z", "Landroid/os/Handler;", "handler", "Landroid/os/Handler;", "value", "lastNotifyTime", "J", "getLastNotifyTime", "setLastNotifyTime", "(J)V", "Lorg/json/JSONObject;", "quotaDataJson", "Lorg/json/JSONObject;", "Ljava/lang/Runnable;", "startCheckRunnable", "Ljava/lang/Runnable;", "<init>", "DiskLevel", "NotifyLevel", "QuotaBusiness", "lib-clearcache-base_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class DiskManager {
    public static final String DEBUG_DISK_LEVEL_KEY = "debug_disk_level_key";
    public static final String DEBUG_DISK_OPEN_KEY = "debug_disk_open_key";
    public static final String DISK_LEVEL_VERSION_KEY = "disk_level_version_pref_key";
    public static final String DISK_MARK_PREF_KEY = "disk_mark_pref_key";
    public static final String MONITOR_TYPE_CLEAN_CONFIRM = "2";
    public static final String MONITOR_TYPE_COLD_START = "0";
    public static final String MONITOR_TYPE_DISK_LEVEL_CHANGE = "1";
    public static final String MONITOR_TYPE_EXCEPTION = "3";
    public static final String TAG = "DiskManager";
    public static long lastNotifyTime;
    public static JSONObject quotaDataJson;
    public static final Runnable startCheckRunnable;
    public static final DiskManager INSTANCE = new DiskManager();
    public static int MEMORY_BASE_UNIT = 1000;
    public static boolean firstStart = true;
    public static final List<BDDiskUsageLevelChangedCallback> diskUsageLevelChangedObservers = new ArrayList();
    public static final Handler handler = new Handler(Looper.getMainLooper());

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/download/center/clearcache/DiskManager$NotifyLevel;", "Ljava/lang/Enum;", "<init>", "(Ljava/lang/String;I)V", "StateNotify", "ForceNotify", "UpgradeNotify", "DebugNotify", "lib-clearcache-base_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes3.dex */
    public enum NotifyLevel {
        StateNotify,
        ForceNotify,
        UpgradeNotify,
        DebugNotify
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0}, pn = "", xi = 0, xs = "")
    /* loaded from: classes3.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            int[] iArr = new int[DiskLevel.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[DiskLevel.CRITICAL.ordinal()] = 1;
            $EnumSwitchMapping$0[DiskLevel.WARNING.ordinal()] = 2;
            $EnumSwitchMapping$0[DiskLevel.NORMAL.ordinal()] = 3;
            int[] iArr2 = new int[DiskLevel.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[DiskLevel.CRITICAL.ordinal()] = 1;
            $EnumSwitchMapping$1[DiskLevel.WARNING.ordinal()] = 2;
            $EnumSwitchMapping$1[DiskLevel.NORMAL.ordinal()] = 3;
            int[] iArr3 = new int[DiskLevel.values().length];
            $EnumSwitchMapping$2 = iArr3;
            iArr3[DiskLevel.CRITICAL.ordinal()] = 1;
            $EnumSwitchMapping$2[DiskLevel.WARNING.ordinal()] = 2;
        }
    }

    static {
        ClearCacheRuntime.getClearCacheContext().registerDiskUsageLevelChangedObserver();
        startCheckRunnable = new Runnable() { // from class: com.baidu.searchbox.download.center.clearcache.DiskManager$startCheckRunnable$1
            @Override // java.lang.Runnable
            public final void run() {
                DiskManager diskManager = DiskManager.INSTANCE;
                DiskManager.firstStart = false;
                DiskManager.INSTANCE.updateDiskLevelAndNotify(DiskManager.NotifyLevel.StateNotify, null);
                ClearCacheRuntime.getClearCacheContext().registerBackForegroundEvent();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized long getLastNotifyTime() {
        return lastNotifyTime;
    }

    public final long getDiskAllSizeByG() {
        return StorageUtils.getTotalExternalMemorySize() / 1000000000;
    }

    public final long getDiskAvailSizeByM() {
        return StorageUtils.getAvailableExternalMemorySize() / 1000000;
    }

    public final DiskLevel getDiskLevel() {
        DiskLevelUpdateDataUtils.INSTANCE.saveDefaultDate();
        String string = DiskManagerSharedPrefsUtils.INSTANCE.getString(DiskManagerSharedPrefsUtils.SP_KEY_CURRENT_STATE, "");
        if (Intrinsics.areEqual(string, DiskLevel.CRITICAL.name())) {
            return DiskLevel.CRITICAL;
        }
        if (Intrinsics.areEqual(string, DiskLevel.WARNING.name())) {
            return DiskLevel.WARNING;
        }
        return DiskLevel.NORMAL;
    }

    public final boolean isMark() {
        return new SharedPrefsWrapper("").getBoolean(DISK_MARK_PREF_KEY, false);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\u00020\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/baidu/searchbox/download/center/clearcache/DiskManager$DiskLevel;", "Ljava/lang/Enum;", "", "desc", "Ljava/lang/String;", "getDesc", "()Ljava/lang/String;", "", "value", "I", "getValue", "()I", "<init>", "(Ljava/lang/String;ILjava/lang/String;I)V", "NORMAL", "WARNING", "CRITICAL", "lib-clearcache-base_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes3.dex */
    public enum DiskLevel {
        NORMAL("充足", 0),
        WARNING("不足", 1),
        CRITICAL("严重不足", 2);
        
        public final String desc;
        public final int value;

        DiskLevel(String str, int i) {
            this.desc = str;
            this.value = i;
        }

        public final String getDesc() {
            return this.desc;
        }

        public final int getValue() {
            return this.value;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0013\b\u0086\u0001\u0018\u00002\u00020\u0001B!\b\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006j\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0015"}, d2 = {"Lcom/baidu/searchbox/download/center/clearcache/DiskManager$QuotaBusiness;", "Ljava/lang/Enum;", "", "critical", "J", "getCritical", "()J", "normal", "getNormal", "warning", "getWarning", "<init>", "(Ljava/lang/String;IJJJ)V", "MNP", "LIVE", "LIVEVIP", "AR", "PLAYKERNEL", "BROWSERKERNEL", "SPLASH", "NOVEL", "lib-clearcache-base_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes3.dex */
    public enum QuotaBusiness {
        MNP(500, 400, 300),
        LIVE(300, 270, 240),
        LIVEVIP(700, 600, 500),
        AR(170, 130, 100),
        PLAYKERNEL(100, 100, 100),
        BROWSERKERNEL(170, 130, 100),
        SPLASH(80, 65, 50),
        NOVEL(80, 65, 50);
        
        public final long critical;
        public final long normal;
        public final long warning;

        QuotaBusiness(long j, long j2, long j3) {
            this.normal = j;
            this.warning = j2;
            this.critical = j3;
        }

        public final long getCritical() {
            return this.critical;
        }

        public final long getNormal() {
            return this.normal;
        }

        public final long getWarning() {
            return this.warning;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void setLastNotifyTime(long j) {
        lastNotifyTime = j;
    }

    public final void forceCheckDiskAndNotify(AllCompletionCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        updateDiskLevelAndNotify(NotifyLevel.ForceNotify, callback);
    }

    public final void registerDiskUsageLevelChangedObserver(BDDiskUsageLevelChangedCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        diskUsageLevelChangedObservers.add(callback);
    }

    public final void setMark(boolean z) {
        new SharedPrefsWrapper("").putBoolean(DISK_MARK_PREF_KEY, z);
    }

    public final void unRegisterDiskUsageLevelChangedObserver(BDDiskUsageLevelChangedCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        diskUsageLevelChangedObservers.remove(callback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DiskLevel getCurrentAppLevel(DiskLevel diskLevel, long j) {
        DiskLevel diskLevel2;
        if (!Intrinsics.areEqual("1", DiskManagerSharedPrefsUtils.INSTANCE.getString(DiskManagerSharedPrefsUtils.SP_KEY_APP_LIMIT_SWITCH, "0"))) {
            return DiskLevel.NORMAL;
        }
        long j2 = DiskManagerSharedPrefsUtils.INSTANCE.getLong(DiskManagerSharedPrefsUtils.SP_KEY_APP_CRITICAL_LIMIT, 0L);
        long j3 = DiskManagerSharedPrefsUtils.INSTANCE.getLong(DiskManagerSharedPrefsUtils.SP_KEY_APP_WARING_LIMIT, 0L);
        if (j2 != 0 && j3 != 0) {
            IClearCacheContext clearCacheContext = ClearCacheRuntime.getClearCacheContext();
            Intrinsics.checkNotNullExpressionValue(clearCacheContext, "ClearCacheRuntime.getClearCacheContext()");
            List<File> appFileList = clearCacheContext.getAppFileList();
            Intrinsics.checkNotNullExpressionValue(appFileList, "ClearCacheRuntime.getCle…acheContext().appFileList");
            IClearCacheContext clearCacheContext2 = ClearCacheRuntime.getClearCacheContext();
            Intrinsics.checkNotNullExpressionValue(clearCacheContext2, "ClearCacheRuntime.getClearCacheContext()");
            long calculateFileListSize = DiskUtilKt.calculateFileListSize(appFileList, clearCacheContext2.getUserAssetFileList(), null);
            int i = MEMORY_BASE_UNIT;
            long j4 = (calculateFileListSize / i) / i;
            if (j4 <= 0) {
                return DiskLevel.NORMAL;
            }
            if (j4 >= j2) {
                diskLevel2 = DiskLevel.CRITICAL;
            } else if (j3 <= j4 && j2 >= j4) {
                diskLevel2 = DiskLevel.WARNING;
            } else {
                diskLevel2 = DiskLevel.NORMAL;
            }
            if (diskLevel != diskLevel2) {
                int i2 = WhenMappings.$EnumSwitchMapping$1[diskLevel.ordinal()];
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 == 3 && j4 < j3 + j) {
                            return DiskLevel.NORMAL;
                        }
                        return diskLevel2;
                    } else if (j4 >= j3 - j && j4 <= j2 + j) {
                        return DiskLevel.WARNING;
                    } else {
                        return diskLevel2;
                    }
                } else if (j4 > j2 - j) {
                    return DiskLevel.CRITICAL;
                } else {
                    return diskLevel2;
                }
            }
            return diskLevel2;
        }
        return DiskLevel.NORMAL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DiskLevel getCurrentDiskLevel(DiskLevel diskLevel, long j) {
        DiskLevel diskLevel2;
        long j2 = DiskManagerSharedPrefsUtils.INSTANCE.getLong(DiskManagerSharedPrefsUtils.SP_KEY_CRITICAL_LIMIT, 0L);
        long j3 = DiskManagerSharedPrefsUtils.INSTANCE.getLong(DiskManagerSharedPrefsUtils.SP_KEY_WARING_LIMIT, 0L);
        long diskAvailSizeByM = getDiskAvailSizeByM();
        if (diskAvailSizeByM <= j2) {
            diskLevel2 = DiskLevel.CRITICAL;
        } else if (j2 <= diskAvailSizeByM && j3 >= diskAvailSizeByM) {
            diskLevel2 = DiskLevel.WARNING;
        } else {
            diskLevel2 = DiskLevel.NORMAL;
        }
        if (diskLevel != diskLevel2) {
            int i = WhenMappings.$EnumSwitchMapping$0[diskLevel.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i == 3 && diskAvailSizeByM >= j3 - j) {
                        return DiskLevel.NORMAL;
                    }
                    return diskLevel2;
                } else if (diskAvailSizeByM >= j2 - j && diskAvailSizeByM <= j3 + j) {
                    return DiskLevel.WARNING;
                } else {
                    return diskLevel2;
                }
            } else if (diskAvailSizeByM <= j2 + j) {
                return DiskLevel.CRITICAL;
            } else {
                return diskLevel2;
            }
        }
        return diskLevel2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean notifyDiskLevelChanged(final NotifyLevel notifyLevel, final DiskLevel diskLevel, final DiskLevel diskLevel2, final AllCompletionCallback allCompletionCallback) {
        if ((notifyLevel == NotifyLevel.StateNotify && diskLevel == diskLevel2) || diskUsageLevelChangedObservers.size() <= 0) {
            return false;
        }
        final long j = DiskManagerSharedPrefsUtils.INSTANCE.getLong(DiskManagerSharedPrefsUtils.SP_KEY_CLEANUP_TIMEOUT, 10L);
        if (AppConfig.isDebug()) {
            Log.i(TAG, "notify --------->lastState=" + diskLevel.name() + " currentState=" + diskLevel2.name());
        }
        ExecutorUtilsExt.postOnSerial(new Runnable() { // from class: com.baidu.searchbox.download.center.clearcache.DiskManager$notifyDiskLevelChanged$1
            @Override // java.lang.Runnable
            public final void run() {
                List<BDDiskUsageLevelChangedCallback> list;
                Handler handler2;
                DiskManager diskManager = DiskManager.INSTANCE;
                list = DiskManager.diskUsageLevelChangedObservers;
                for (BDDiskUsageLevelChangedCallback bDDiskUsageLevelChangedCallback : list) {
                    final CountDownLatch countDownLatch = new CountDownLatch(1);
                    long currentTimeMillis = System.currentTimeMillis();
                    bDDiskUsageLevelChangedCallback.onChange(DiskManager.DiskLevel.this, diskLevel2, new NotifyCompletionBack() { // from class: com.baidu.searchbox.download.center.clearcache.DiskManager$notifyDiskLevelChanged$1.1
                        @Override // com.baidu.searchbox.download.center.clearcache.NotifyCompletionBack
                        public void notifyCompletion() {
                            countDownLatch.countDown();
                        }
                    });
                    long currentTimeMillis2 = (System.currentTimeMillis() - currentTimeMillis) / 1000;
                    try {
                        countDownLatch.await(j - currentTimeMillis2, TimeUnit.SECONDS);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (AppConfig.isDebug()) {
                        Log.i(DiskManager.TAG, "notify item--------->,time=" + currentTimeMillis2);
                    }
                }
                DiskManager.INSTANCE.setLastNotifyTime(System.currentTimeMillis());
                DiskManager diskManager2 = DiskManager.INSTANCE;
                handler2 = DiskManager.handler;
                handler2.post(new Runnable() { // from class: com.baidu.searchbox.download.center.clearcache.DiskManager$notifyDiskLevelChanged$1.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        AllCompletionCallback allCompletionCallback2 = allCompletionCallback;
                        if (allCompletionCallback2 != null) {
                            allCompletionCallback2.success();
                        }
                    }
                });
                if (diskLevel2 != DiskManager.DiskLevel.NORMAL) {
                    ClearCacheRuntime.getClearCacheContext().notifyDiskLevelChanged(notifyLevel, DiskManager.DiskLevel.this, diskLevel2);
                }
            }
        }, "notify_diskUsageLevelChanged");
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x007a A[Catch: NumberFormatException -> 0x0076, TRY_LEAVE, TryCatch #0 {NumberFormatException -> 0x0076, blocks: (B:27:0x006d, B:31:0x007a), top: B:44:0x006d }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x006d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @SuppressLint({"DefaultLocale"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final long getQuota(QuotaBusiness bussinessId) {
        String str;
        int i;
        Intrinsics.checkNotNullParameter(bussinessId, "bussinessId");
        DiskLevel diskLevel = getDiskLevel();
        if (quotaDataJson == null) {
            String string = DiskManagerSharedPrefsUtils.INSTANCE.getString(DiskManagerSharedPrefsUtils.SP_KEY_QUOTA_DATA, "");
            if (!TextUtils.isEmpty(string)) {
                try {
                    quotaDataJson = new JSONObject(string);
                } catch (JSONException e) {
                    if (AppConfig.isDebug()) {
                        e.printStackTrace();
                    }
                }
            }
        }
        JSONObject jSONObject = quotaDataJson;
        Long l = null;
        if (jSONObject != null) {
            String name = bussinessId.name();
            if (name != null) {
                String lowerCase = name.toLowerCase();
                Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
                JSONObject optJSONObject = jSONObject.optJSONObject(lowerCase);
                if (optJSONObject != null) {
                    String name2 = diskLevel.name();
                    if (name2 != null) {
                        String lowerCase2 = name2.toLowerCase();
                        Intrinsics.checkNotNullExpressionValue(lowerCase2, "(this as java.lang.String).toLowerCase()");
                        str = optJSONObject.optString(lowerCase2);
                        if (str != null) {
                            try {
                                l = Long.valueOf(Long.parseLong(str));
                            } catch (NumberFormatException e2) {
                                if (AppConfig.isDebug()) {
                                    e2.printStackTrace();
                                }
                            }
                        }
                        if (l != null) {
                            return l.longValue();
                        }
                        i = WhenMappings.$EnumSwitchMapping$2[diskLevel.ordinal()];
                        if (i == 1) {
                            if (i != 2) {
                                return bussinessId.getNormal();
                            }
                            return bussinessId.getWarning();
                        }
                        return bussinessId.getCritical();
                    }
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
            } else {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
        }
        str = null;
        if (str != null) {
        }
        if (l != null) {
        }
        i = WhenMappings.$EnumSwitchMapping$2[diskLevel.ordinal()];
        if (i == 1) {
        }
    }

    public final void startCheckDiskStateAndNotify() {
        if (firstStart) {
            long j = DiskManagerSharedPrefsUtils.INSTANCE.getLong(DiskManagerSharedPrefsUtils.SP_KEY_NOTIFY_DELAYAFTERSTART, 120L);
            handler.removeCallbacks(startCheckRunnable);
            handler.postDelayed(startCheckRunnable, j * 1000);
            if (AppConfig.isDebug()) {
                handler.postDelayed(new Runnable() { // from class: com.baidu.searchbox.download.center.clearcache.DiskManager$startCheckDiskStateAndNotify$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        ClearCacheRuntime.getClearCacheContext().cleanCacheMonitorUBC("0");
                    }
                }, 5000L);
            } else if (new Random().nextFloat() <= 0.01f) {
                handler.postDelayed(new Runnable() { // from class: com.baidu.searchbox.download.center.clearcache.DiskManager$startCheckDiskStateAndNotify$2
                    @Override // java.lang.Runnable
                    public final void run() {
                        ClearCacheRuntime.getClearCacheContext().cleanCacheMonitorUBC("0");
                    }
                }, 600000L);
            }
        }
    }

    public final void updateDiskLevelAndNotify(final NotifyLevel notifyLevel, final AllCompletionCallback allCompletionCallback) {
        Intrinsics.checkNotNullParameter(notifyLevel, "notifyLevel");
        if (notifyLevel == NotifyLevel.StateNotify) {
            if (Math.abs(System.currentTimeMillis() - getLastNotifyTime()) < DiskManagerSharedPrefsUtils.INSTANCE.getLong(DiskManagerSharedPrefsUtils.SP_KEY_DISK_CHECK_DURATION, DiskManagerSharedPrefsUtils.DISK_CHECK_DURATION_DEFAULT) * 1000) {
                return;
            }
        }
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.searchbox.download.center.clearcache.DiskManager$updateDiskLevelAndNotify$1
            @Override // java.lang.Runnable
            public final void run() {
                DiskManager.DiskLevel currentDiskLevel;
                DiskManager.NotifyLevel notifyLevel2;
                ClearCacheRuntime.getClearCacheContext().clearHistoryFile();
                DiskManager.DiskLevel diskLevel = DiskManager.INSTANCE.getDiskLevel();
                DiskManager.DiskLevel diskLevel2 = DiskManager.DiskLevel.NORMAL;
                if (AppConfig.isDebug() && new SharedPrefsWrapper("").getBoolean(DiskManager.DEBUG_DISK_OPEN_KEY, false)) {
                    String string = new SharedPrefsWrapper("").getString(DiskManager.DEBUG_DISK_LEVEL_KEY, "");
                    Log.i(DiskManager.TAG, "use-debug_state ---------------------> " + string + WebvttCueParser.CHAR_SPACE);
                    if (TextUtils.equals(string, DiskManager.DiskLevel.WARNING.getDesc())) {
                        diskLevel2 = DiskManager.DiskLevel.WARNING;
                    } else if (TextUtils.equals(string, DiskManager.DiskLevel.CRITICAL.getDesc())) {
                        diskLevel2 = DiskManager.DiskLevel.CRITICAL;
                    } else {
                        diskLevel2 = DiskManager.DiskLevel.NORMAL;
                    }
                } else if (DiskManager.NotifyLevel.this != DiskManager.NotifyLevel.ForceNotify) {
                    long j = DiskManagerSharedPrefsUtils.INSTANCE.getLong(DiskManagerSharedPrefsUtils.SP_KEY_DIFF, 0L);
                    currentDiskLevel = DiskManager.INSTANCE.getCurrentDiskLevel(diskLevel, j);
                    if (currentDiskLevel != DiskManager.DiskLevel.CRITICAL) {
                        diskLevel2 = DiskManager.INSTANCE.getCurrentAppLevel(diskLevel, j);
                    }
                    if (currentDiskLevel.getValue() > diskLevel2.getValue()) {
                        diskLevel2 = currentDiskLevel;
                    }
                }
                if (DiskManager.NotifyLevel.this == DiskManager.NotifyLevel.ForceNotify) {
                    diskLevel2 = DiskManager.DiskLevel.CRITICAL;
                }
                String appVersionName = ClearCacheUtils.getAppVersionName(AppRuntime.getAppContext());
                String string2 = DiskManagerSharedPrefsUtils.INSTANCE.getString(DiskManager.DISK_LEVEL_VERSION_KEY, "");
                DiskManager diskManager = DiskManager.INSTANCE;
                if (DiskManager.NotifyLevel.this == DiskManager.NotifyLevel.StateNotify && (!Intrinsics.areEqual(string2, appVersionName))) {
                    notifyLevel2 = DiskManager.NotifyLevel.UpgradeNotify;
                } else {
                    notifyLevel2 = DiskManager.NotifyLevel.this;
                }
                diskManager.notifyDiskLevelChanged(notifyLevel2, diskLevel, diskLevel2, allCompletionCallback);
                DiskManagerSharedPrefsUtils.INSTANCE.putString(DiskManager.DISK_LEVEL_VERSION_KEY, appVersionName);
                DiskManagerSharedPrefsUtils.INSTANCE.putString(DiskManagerSharedPrefsUtils.SP_KEY_CURRENT_STATE, diskLevel2.name());
                DiskManager.INSTANCE.setLastNotifyTime(System.currentTimeMillis());
            }
        }, "diskLevelUpdate", 3);
    }
}
