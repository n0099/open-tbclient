package com.baidu.searchbox.download.center.clearcache;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.devices.StorageUtils;
import com.baidu.android.util.sp.SharedPrefsWrapper;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.download.center.clearcache.DiskManager;
import com.baidu.searchbox.download.center.clearcache.util.ClearCacheUtils;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes2.dex */
public final class DiskManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DEBUG_DISK_LEVEL_KEY = "debug_disk_level_key";
    public static final String DEBUG_DISK_OPEN_KEY = "debug_disk_open_key";
    public static final String DISK_LEVEL_VERSION_KEY = "disk_level_version_pref_key";
    public static final String DISK_MARK_PREF_KEY = "disk_mark_pref_key";
    public static final DiskManager INSTANCE;
    public static int MEMORY_BASE_UNIT = 0;
    public static final String MONITOR_TYPE_CLEAN_CONFIRM = "2";
    public static final String MONITOR_TYPE_COLD_START = "0";
    public static final String MONITOR_TYPE_DISK_LEVEL_CHANGE = "1";
    public static final String MONITOR_TYPE_EXCEPTION = "3";
    public static final String TAG = "DiskManager";
    public static final List<BDDiskUsageLevelChangedCallback> diskUsageLevelChangedObservers;
    public static boolean firstStart;
    public static final Handler handler;
    public static long lastNotifyTime;
    public static JSONObject quotaDataJson;
    public static final Runnable startCheckRunnable;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\u00020\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/baidu/searchbox/download/center/clearcache/DiskManager$DiskLevel;", "Ljava/lang/Enum;", "", "desc", "Ljava/lang/String;", "getDesc", "()Ljava/lang/String;", "", "value", "I", "getValue", "()I", "<init>", "(Ljava/lang/String;ILjava/lang/String;I)V", "NORMAL", "WARNING", "CRITICAL", "lib-clearcache-base_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static final class DiskLevel {
        public static final /* synthetic */ DiskLevel[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final DiskLevel CRITICAL;
        public static final DiskLevel NORMAL;
        public static final DiskLevel WARNING;
        public transient /* synthetic */ FieldHolder $fh;
        public final String desc;
        public final int value;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1396399115, "Lcom/baidu/searchbox/download/center/clearcache/DiskManager$DiskLevel;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1396399115, "Lcom/baidu/searchbox/download/center/clearcache/DiskManager$DiskLevel;");
                    return;
                }
            }
            DiskLevel diskLevel = new DiskLevel("NORMAL", 0, "充足", 0);
            NORMAL = diskLevel;
            DiskLevel diskLevel2 = new DiskLevel("WARNING", 1, "不足", 1);
            WARNING = diskLevel2;
            DiskLevel diskLevel3 = new DiskLevel("CRITICAL", 2, "严重不足", 2);
            CRITICAL = diskLevel3;
            $VALUES = new DiskLevel[]{diskLevel, diskLevel2, diskLevel3};
        }

        public DiskLevel(String str, int i, String str2, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i), str2, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str3 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.desc = str2;
            this.value = i2;
        }

        public static DiskLevel valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (DiskLevel) Enum.valueOf(DiskLevel.class, str) : (DiskLevel) invokeL.objValue;
        }

        public static DiskLevel[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (DiskLevel[]) $VALUES.clone() : (DiskLevel[]) invokeV.objValue;
        }

        public final String getDesc() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.desc : (String) invokeV.objValue;
        }

        public final int getValue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.value : invokeV.intValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/download/center/clearcache/DiskManager$NotifyLevel;", "Ljava/lang/Enum;", "<init>", "(Ljava/lang/String;I)V", "StateNotify", "ForceNotify", "UpgradeNotify", "DebugNotify", "lib-clearcache-base_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static final class NotifyLevel {
        public static final /* synthetic */ NotifyLevel[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final NotifyLevel DebugNotify;
        public static final NotifyLevel ForceNotify;
        public static final NotifyLevel StateNotify;
        public static final NotifyLevel UpgradeNotify;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1955753887, "Lcom/baidu/searchbox/download/center/clearcache/DiskManager$NotifyLevel;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1955753887, "Lcom/baidu/searchbox/download/center/clearcache/DiskManager$NotifyLevel;");
                    return;
                }
            }
            NotifyLevel notifyLevel = new NotifyLevel("StateNotify", 0);
            StateNotify = notifyLevel;
            NotifyLevel notifyLevel2 = new NotifyLevel("ForceNotify", 1);
            ForceNotify = notifyLevel2;
            NotifyLevel notifyLevel3 = new NotifyLevel("UpgradeNotify", 2);
            UpgradeNotify = notifyLevel3;
            NotifyLevel notifyLevel4 = new NotifyLevel("DebugNotify", 3);
            DebugNotify = notifyLevel4;
            $VALUES = new NotifyLevel[]{notifyLevel, notifyLevel2, notifyLevel3, notifyLevel4};
        }

        public NotifyLevel(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static NotifyLevel valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (NotifyLevel) Enum.valueOf(NotifyLevel.class, str) : (NotifyLevel) invokeL.objValue;
        }

        public static NotifyLevel[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (NotifyLevel[]) $VALUES.clone() : (NotifyLevel[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0013\b\u0086\u0001\u0018\u00002\u00020\u0001B!\b\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006j\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0015"}, d2 = {"Lcom/baidu/searchbox/download/center/clearcache/DiskManager$QuotaBusiness;", "Ljava/lang/Enum;", "", "critical", "J", "getCritical", "()J", "normal", "getNormal", "warning", "getWarning", "<init>", "(Ljava/lang/String;IJJJ)V", "MNP", "LIVE", "LIVEVIP", "AR", "PLAYKERNEL", "BROWSERKERNEL", "SPLASH", "NOVEL", "lib-clearcache-base_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static final class QuotaBusiness {
        public static final /* synthetic */ QuotaBusiness[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final QuotaBusiness AR;
        public static final QuotaBusiness BROWSERKERNEL;
        public static final QuotaBusiness LIVE;
        public static final QuotaBusiness LIVEVIP;
        public static final QuotaBusiness MNP;
        public static final QuotaBusiness NOVEL;
        public static final QuotaBusiness PLAYKERNEL;
        public static final QuotaBusiness SPLASH;
        public transient /* synthetic */ FieldHolder $fh;
        public final long critical;
        public final long normal;
        public final long warning;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1272719580, "Lcom/baidu/searchbox/download/center/clearcache/DiskManager$QuotaBusiness;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1272719580, "Lcom/baidu/searchbox/download/center/clearcache/DiskManager$QuotaBusiness;");
                    return;
                }
            }
            QuotaBusiness quotaBusiness = new QuotaBusiness("MNP", 0, 500L, 400L, 300L);
            MNP = quotaBusiness;
            QuotaBusiness quotaBusiness2 = new QuotaBusiness("LIVE", 1, 300L, 270L, 240L);
            LIVE = quotaBusiness2;
            QuotaBusiness quotaBusiness3 = new QuotaBusiness("LIVEVIP", 2, 700L, 600L, 500L);
            LIVEVIP = quotaBusiness3;
            QuotaBusiness quotaBusiness4 = new QuotaBusiness("AR", 3, 170L, 130L, 100L);
            AR = quotaBusiness4;
            QuotaBusiness quotaBusiness5 = new QuotaBusiness("PLAYKERNEL", 4, 100L, 100L, 100L);
            PLAYKERNEL = quotaBusiness5;
            QuotaBusiness quotaBusiness6 = new QuotaBusiness("BROWSERKERNEL", 5, 170L, 130L, 100L);
            BROWSERKERNEL = quotaBusiness6;
            QuotaBusiness quotaBusiness7 = new QuotaBusiness("SPLASH", 6, 80L, 65L, 50L);
            SPLASH = quotaBusiness7;
            QuotaBusiness quotaBusiness8 = new QuotaBusiness("NOVEL", 7, 80L, 65L, 50L);
            NOVEL = quotaBusiness8;
            $VALUES = new QuotaBusiness[]{quotaBusiness, quotaBusiness2, quotaBusiness3, quotaBusiness4, quotaBusiness5, quotaBusiness6, quotaBusiness7, quotaBusiness8};
        }

        public QuotaBusiness(String str, int i, long j, long j2, long j3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.normal = j;
            this.warning = j2;
            this.critical = j3;
        }

        public static QuotaBusiness valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (QuotaBusiness) Enum.valueOf(QuotaBusiness.class, str) : (QuotaBusiness) invokeL.objValue;
        }

        public static QuotaBusiness[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (QuotaBusiness[]) $VALUES.clone() : (QuotaBusiness[]) invokeV.objValue;
        }

        public final long getCritical() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.critical : invokeV.longValue;
        }

        public final long getNormal() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.normal : invokeV.longValue;
        }

        public final long getWarning() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.warning : invokeV.longValue;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(242485240, "Lcom/baidu/searchbox/download/center/clearcache/DiskManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(242485240, "Lcom/baidu/searchbox/download/center/clearcache/DiskManager;");
                return;
            }
        }
        INSTANCE = new DiskManager();
        MEMORY_BASE_UNIT = 1000;
        firstStart = true;
        diskUsageLevelChangedObservers = new ArrayList();
        handler = new Handler(Looper.getMainLooper());
        ClearCacheRuntime.getClearCacheContext().registerDiskUsageLevelChangedObserver();
        startCheckRunnable = DiskManager$startCheckRunnable$1.INSTANCE;
    }

    public DiskManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DiskLevel getCurrentAppLevel(DiskLevel diskLevel, long j) {
        InterceptResult invokeLJ;
        DiskLevel diskLevel2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65547, this, diskLevel, j)) == null) {
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
                    return i2 != 1 ? i2 != 2 ? (i2 == 3 && j4 < j3 + j) ? DiskLevel.NORMAL : diskLevel2 : (j4 < j3 - j || j4 > j2 + j) ? diskLevel2 : DiskLevel.WARNING : j4 > j2 - j ? DiskLevel.CRITICAL : diskLevel2;
                }
                return diskLevel2;
            }
            return DiskLevel.NORMAL;
        }
        return (DiskLevel) invokeLJ.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DiskLevel getCurrentDiskLevel(DiskLevel diskLevel, long j) {
        InterceptResult invokeLJ;
        DiskLevel diskLevel2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65548, this, diskLevel, j)) == null) {
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
                return i != 1 ? i != 2 ? (i == 3 && diskAvailSizeByM >= j3 - j) ? DiskLevel.NORMAL : diskLevel2 : (diskAvailSizeByM < j2 - j || diskAvailSizeByM > j3 + j) ? diskLevel2 : DiskLevel.WARNING : diskAvailSizeByM <= j2 + j ? DiskLevel.CRITICAL : diskLevel2;
            }
            return diskLevel2;
        }
        return (DiskLevel) invokeLJ.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized long getLastNotifyTime() {
        InterceptResult invokeV;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, this)) == null) {
            synchronized (this) {
                j = lastNotifyTime;
            }
            return j;
        }
        return invokeV.longValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean notifyDiskLevelChanged(final NotifyLevel notifyLevel, final DiskLevel diskLevel, final DiskLevel diskLevel2, final AllCompletionCallback allCompletionCallback) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65550, this, notifyLevel, diskLevel, diskLevel2, allCompletionCallback)) == null) {
            if (!(notifyLevel == NotifyLevel.StateNotify && diskLevel == diskLevel2) && diskUsageLevelChangedObservers.size() > 0) {
                final long j = DiskManagerSharedPrefsUtils.INSTANCE.getLong(DiskManagerSharedPrefsUtils.SP_KEY_CLEANUP_TIMEOUT, 10L);
                if (AppConfig.isDebug()) {
                    Log.i(TAG, "notify --------->lastState=" + diskLevel.name() + " currentState=" + diskLevel2.name());
                }
                ExecutorUtilsExt.postOnSerial(new Runnable(diskLevel, diskLevel2, j, allCompletionCallback, notifyLevel) { // from class: com.baidu.searchbox.download.center.clearcache.DiskManager$notifyDiskLevelChanged$1
                    public static /* synthetic */ Interceptable $ic;
                    public final /* synthetic */ AllCompletionCallback $callback;
                    public final /* synthetic */ DiskManager.DiskLevel $currentState;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ DiskManager.DiskLevel $lastState;
                    public final /* synthetic */ DiskManager.NotifyLevel $notifyLevel;
                    public final /* synthetic */ long $timeOutTime;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {diskLevel, diskLevel2, Long.valueOf(j), allCompletionCallback, notifyLevel};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.$lastState = diskLevel;
                        this.$currentState = diskLevel2;
                        this.$timeOutTime = j;
                        this.$callback = allCompletionCallback;
                        this.$notifyLevel = notifyLevel;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        List<BDDiskUsageLevelChangedCallback> list;
                        Handler handler2;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            DiskManager diskManager = DiskManager.INSTANCE;
                            list = DiskManager.diskUsageLevelChangedObservers;
                            for (BDDiskUsageLevelChangedCallback bDDiskUsageLevelChangedCallback : list) {
                                CountDownLatch countDownLatch = new CountDownLatch(1);
                                long currentTimeMillis = System.currentTimeMillis();
                                bDDiskUsageLevelChangedCallback.onChange(this.$lastState, this.$currentState, new NotifyCompletionBack(countDownLatch) { // from class: com.baidu.searchbox.download.center.clearcache.DiskManager$notifyDiskLevelChanged$1.1
                                    public static /* synthetic */ Interceptable $ic;
                                    public final /* synthetic */ CountDownLatch $countDownLatch;
                                    public transient /* synthetic */ FieldHolder $fh;

                                    {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 != null) {
                                            InitContext newInitContext = TitanRuntime.newInitContext();
                                            newInitContext.initArgs = r2;
                                            Object[] objArr = {countDownLatch};
                                            interceptable3.invokeUnInit(65536, newInitContext);
                                            int i = newInitContext.flag;
                                            if ((i & 1) != 0) {
                                                int i2 = i & 2;
                                                newInitContext.thisArg = this;
                                                interceptable3.invokeInitBody(65536, newInitContext);
                                                return;
                                            }
                                        }
                                        this.$countDownLatch = countDownLatch;
                                    }

                                    @Override // com.baidu.searchbox.download.center.clearcache.NotifyCompletionBack
                                    public void notifyCompletion() {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                            this.$countDownLatch.countDown();
                                        }
                                    }
                                });
                                long currentTimeMillis2 = (System.currentTimeMillis() - currentTimeMillis) / 1000;
                                try {
                                    countDownLatch.await(this.$timeOutTime - currentTimeMillis2, TimeUnit.SECONDS);
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
                            handler2.post(new Runnable(this) { // from class: com.baidu.searchbox.download.center.clearcache.DiskManager$notifyDiskLevelChanged$1.2
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ DiskManager$notifyDiskLevelChanged$1 this$0;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i = newInitContext.flag;
                                        if ((i & 1) != 0) {
                                            int i2 = i & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.this$0 = this;
                                }

                                @Override // java.lang.Runnable
                                public final void run() {
                                    AllCompletionCallback allCompletionCallback2;
                                    Interceptable interceptable3 = $ic;
                                    if (!(interceptable3 == null || interceptable3.invokeV(1048576, this) == null) || (allCompletionCallback2 = this.this$0.$callback) == null) {
                                        return;
                                    }
                                    allCompletionCallback2.success();
                                }
                            });
                            if (this.$currentState != DiskManager.DiskLevel.NORMAL) {
                                ClearCacheRuntime.getClearCacheContext().notifyDiskLevelChanged(this.$notifyLevel, this.$lastState, this.$currentState);
                            }
                        }
                    }
                }, "notify_diskUsageLevelChanged");
                return true;
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void setLastNotifyTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65551, this, j) == null) {
            synchronized (this) {
                lastNotifyTime = j;
            }
        }
    }

    public final void forceCheckDiskAndNotify(AllCompletionCallback callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, callback) == null) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            updateDiskLevelAndNotify(NotifyLevel.ForceNotify, callback);
        }
    }

    public final long getDiskAllSizeByG() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? StorageUtils.getTotalExternalMemorySize() / 1000000000 : invokeV.longValue;
    }

    public final long getDiskAvailSizeByM() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? StorageUtils.getAvailableExternalMemorySize() / 1000000 : invokeV.longValue;
    }

    public final DiskLevel getDiskLevel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
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
        return (DiskLevel) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x007d A[Catch: NumberFormatException -> 0x0079, TRY_LEAVE, TryCatch #1 {NumberFormatException -> 0x0079, blocks: (B:29:0x0070, B:33:0x007d), top: B:52:0x0070 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0070 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @SuppressLint({"DefaultLocale"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final long getQuota(QuotaBusiness bussinessId) {
        InterceptResult invokeL;
        String str;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048580, this, bussinessId)) != null) {
            return invokeL.longValue;
        }
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
            if (name == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
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

    public final boolean isMark() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? new SharedPrefsWrapper("").getBoolean(DISK_MARK_PREF_KEY, false) : invokeV.booleanValue;
    }

    public final void registerDiskUsageLevelChangedObserver(BDDiskUsageLevelChangedCallback callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, callback) == null) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            diskUsageLevelChangedObservers.add(callback);
        }
    }

    public final void setMark(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            new SharedPrefsWrapper("").putBoolean(DISK_MARK_PREF_KEY, z);
        }
    }

    public final void startCheckDiskStateAndNotify() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && firstStart) {
            long j = DiskManagerSharedPrefsUtils.INSTANCE.getLong(DiskManagerSharedPrefsUtils.SP_KEY_NOTIFY_DELAYAFTERSTART, 120L);
            handler.removeCallbacks(startCheckRunnable);
            handler.postDelayed(startCheckRunnable, j * 1000);
            if (AppConfig.isDebug()) {
                handler.postDelayed(DiskManager$startCheckDiskStateAndNotify$1.INSTANCE, 5000L);
            } else if (new Random().nextFloat() <= 0.01f) {
                handler.postDelayed(DiskManager$startCheckDiskStateAndNotify$2.INSTANCE, 600000L);
            }
        }
    }

    public final void unRegisterDiskUsageLevelChangedObserver(BDDiskUsageLevelChangedCallback callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, callback) == null) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            diskUsageLevelChangedObservers.remove(callback);
        }
    }

    public final void updateDiskLevelAndNotify(final NotifyLevel notifyLevel, final AllCompletionCallback allCompletionCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, notifyLevel, allCompletionCallback) == null) {
            Intrinsics.checkNotNullParameter(notifyLevel, "notifyLevel");
            if (notifyLevel == NotifyLevel.StateNotify) {
                if (Math.abs(System.currentTimeMillis() - getLastNotifyTime()) < DiskManagerSharedPrefsUtils.INSTANCE.getLong(DiskManagerSharedPrefsUtils.SP_KEY_DISK_CHECK_DURATION, DiskManagerSharedPrefsUtils.DISK_CHECK_DURATION_DEFAULT) * 1000) {
                    return;
                }
            }
            ExecutorUtilsExt.postOnElastic(new Runnable(notifyLevel, allCompletionCallback) { // from class: com.baidu.searchbox.download.center.clearcache.DiskManager$updateDiskLevelAndNotify$1
                public static /* synthetic */ Interceptable $ic;
                public final /* synthetic */ AllCompletionCallback $allCompletionCallback;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DiskManager.NotifyLevel $notifyLevel;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {notifyLevel, allCompletionCallback};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.$notifyLevel = notifyLevel;
                    this.$allCompletionCallback = allCompletionCallback;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    DiskManager.DiskLevel currentDiskLevel;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
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
                        } else if (this.$notifyLevel != DiskManager.NotifyLevel.ForceNotify) {
                            long j = DiskManagerSharedPrefsUtils.INSTANCE.getLong(DiskManagerSharedPrefsUtils.SP_KEY_DIFF, 0L);
                            currentDiskLevel = DiskManager.INSTANCE.getCurrentDiskLevel(diskLevel, j);
                            if (currentDiskLevel != DiskManager.DiskLevel.CRITICAL) {
                                diskLevel2 = DiskManager.INSTANCE.getCurrentAppLevel(diskLevel, j);
                            }
                            if (currentDiskLevel.getValue() > diskLevel2.getValue()) {
                                diskLevel2 = currentDiskLevel;
                            }
                        }
                        if (this.$notifyLevel == DiskManager.NotifyLevel.ForceNotify) {
                            diskLevel2 = DiskManager.DiskLevel.CRITICAL;
                        }
                        String appVersionName = ClearCacheUtils.getAppVersionName(AppRuntime.getAppContext());
                        DiskManager.INSTANCE.notifyDiskLevelChanged((this.$notifyLevel == DiskManager.NotifyLevel.StateNotify && (Intrinsics.areEqual(DiskManagerSharedPrefsUtils.INSTANCE.getString(DiskManager.DISK_LEVEL_VERSION_KEY, ""), appVersionName) ^ true)) ? DiskManager.NotifyLevel.UpgradeNotify : this.$notifyLevel, diskLevel, diskLevel2, this.$allCompletionCallback);
                        DiskManagerSharedPrefsUtils.INSTANCE.putString(DiskManager.DISK_LEVEL_VERSION_KEY, appVersionName);
                        DiskManagerSharedPrefsUtils.INSTANCE.putString(DiskManagerSharedPrefsUtils.SP_KEY_CURRENT_STATE, diskLevel2.name());
                        DiskManager.INSTANCE.setLastNotifyTime(System.currentTimeMillis());
                    }
                }
            }, "diskLevelUpdate", 3);
        }
    }
}
