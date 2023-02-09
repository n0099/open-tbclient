package com.baidu.searchbox.common.security;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.devices.DeviceUtils;
import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.searchbox.common.security.DeviceInfoManager;
import com.baidu.searchbox.common.security.IDeviceInfoAppHost;
import com.baidu.searchbox.common.security.IDeviceInfoService;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tieba.cx8;
import com.baidu.tieba.dk1;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.zip.GZIPOutputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.FilesKt__FileReadWriteKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Charsets;
import org.json.JSONObject;
@Autowired
@Metadata(d1 = {"\u0000\u0091\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0005\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0006\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001xB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010@\u001a\u00020\u00042\b\u0010A\u001a\u0004\u0018\u00010BH\u0002J\u0012\u0010C\u001a\u0004\u0018\u00010D2\u0006\u0010E\u001a\u00020DH\u0002J\u001e\u0010F\u001a\u00020\u001d2\u0006\u0010G\u001a\u00020\u001b2\u0006\u0010H\u001a\u00020\u001c2\u0006\u0010I\u001a\u00020\u001cJ\b\u0010J\u001a\u00020KH\u0003J\r\u0010L\u001a\u00020\u001bH\u0000¢\u0006\u0002\bMJ&\u0010N\u001a\u0002022\u0006\u0010G\u001a\u00020\u001b2\u0006\u0010H\u001a\u00020\u001c2\u0006\u0010I\u001a\u00020\u001c2\u0006\u0010O\u001a\u00020\nJ0\u0010N\u001a\u0002022\u0006\u0010G\u001a\u00020\u001b2\u0006\u0010H\u001a\u00020\u001c2\u0006\u0010I\u001a\u00020\u001c2\u0006\u0010O\u001a\u00020\n2\b\b\u0002\u0010P\u001a\u00020\u0004J\u0010\u0010Q\u001a\u00020\u001c2\u0006\u0010R\u001a\u00020\u001cH\u0002J\u001e\u0010S\u001a\u00020\u001d2\u0006\u0010G\u001a\u00020\u001b2\u0006\u0010H\u001a\u00020\u001c2\u0006\u0010I\u001a\u00020\u001cJ\u001e\u0010T\u001a\u00020\u001d2\u0006\u0010G\u001a\u00020\u001b2\u0006\u0010H\u001a\u00020\u001c2\u0006\u0010I\u001a\u00020\u001cJ(\u0010T\u001a\u00020\u001d2\u0006\u0010G\u001a\u00020\u001b2\u0006\u0010H\u001a\u00020\u001c2\u0006\u0010I\u001a\u00020\u001c2\b\b\u0002\u0010P\u001a\u00020\u0004J\u0010\u0010U\u001a\u00020V2\u0006\u0010G\u001a\u00020\u001bH\u0002J\u001e\u0010W\u001a\u00020\u001d2\u0006\u0010G\u001a\u00020\u001b2\u0006\u0010H\u001a\u00020\u001c2\u0006\u0010I\u001a\u00020\u001cJ\u0016\u0010X\u001a\u00020\u001d2\u0006\u0010H\u001a\u00020\u001c2\u0006\u0010I\u001a\u00020\u001cJ\u0016\u0010Y\u001a\u00020\u001d2\u0006\u0010H\u001a\u00020\u001c2\u0006\u0010I\u001a\u00020\u001cJ\u0016\u0010Z\u001a\u00020\u001d2\u0006\u0010H\u001a\u00020\u001c2\u0006\u0010I\u001a\u00020\u001cJ\u001e\u0010[\u001a\u00020\u001d2\u0006\u0010G\u001a\u00020\u001b2\u0006\u0010H\u001a\u00020\u001c2\u0006\u0010I\u001a\u00020\u001cJ(\u0010[\u001a\u00020\u001d2\u0006\u0010G\u001a\u00020\u001b2\u0006\u0010H\u001a\u00020\u001c2\u0006\u0010I\u001a\u00020\u001c2\b\b\u0002\u0010P\u001a\u00020\u0004J\u0016\u0010\\\u001a\u00020\u001d2\u0006\u0010H\u001a\u00020\u001c2\u0006\u0010I\u001a\u00020\u001cJ\u000e\u0010]\u001a\u00020\u00042\u0006\u0010G\u001a\u00020\u001bJ\u0010\u0010^\u001a\u00020_2\b\b\u0002\u0010O\u001a\u00020\nJ\u0012\u0010`\u001a\u00020\u00042\b\u0010a\u001a\u0004\u0018\u00010:H\u0002J\u0010\u0010b\u001a\u00020_2\u0006\u0010O\u001a\u00020\nH\u0002J\u0016\u0010c\u001a\u00020_2\u0006\u0010d\u001a\u00020\u001b2\u0006\u0010e\u001a\u00020\u0004J \u0010f\u001a\u00020\u001d2\u0006\u0010G\u001a\u00020\u001b2\u0006\u0010H\u001a\u00020\u001c2\u0006\u0010I\u001a\u00020\u001cH\u0002J \u0010g\u001a\u00020\u001d2\u0006\u0010G\u001a\u00020\u001b2\u0006\u0010H\u001a\u00020\u001c2\u0006\u0010I\u001a\u00020\u001cH\u0002J \u0010h\u001a\u00020\u001d2\u0006\u0010G\u001a\u00020\u001b2\u0006\u0010H\u001a\u00020\u001c2\u0006\u0010I\u001a\u00020\u001cH\u0002J \u0010i\u001a\u00020\u001d2\u0006\u0010G\u001a\u00020\u001b2\u0006\u0010H\u001a\u00020\u001c2\u0006\u0010I\u001a\u00020\u001cH\u0002J\u0018\u0010j\u001a\u00020\u001d2\u0006\u0010H\u001a\u00020\u001c2\u0006\u0010I\u001a\u00020\u001cH\u0002J\u000e\u0010k\u001a\u00020_2\u0006\u0010G\u001a\u00020\u001bJ\u0018\u0010l\u001a\u00020\u001d2\u0006\u0010H\u001a\u00020\u001c2\u0006\u0010I\u001a\u00020\u001cH\u0002J\u0018\u0010m\u001a\u00020\u001d2\u0006\u0010H\u001a\u00020\u001c2\u0006\u0010I\u001a\u00020\u001cH\u0002J \u0010n\u001a\u00020\u001d2\u0006\u0010G\u001a\u00020\u001b2\u0006\u0010H\u001a\u00020\u001c2\u0006\u0010I\u001a\u00020\u001cH\u0002J\u0018\u0010o\u001a\u00020\u001d2\u0006\u0010H\u001a\u00020\u001c2\u0006\u0010I\u001a\u00020\u001cH\u0002J\u0010\u0010p\u001a\u00020_2\u0006\u0010G\u001a\u00020\u001bH\u0002J\u0010\u0010q\u001a\u00020_2\u0006\u0010G\u001a\u00020\u001bH\u0002J\u0016\u0010r\u001a\u00020_2\u0006\u0010d\u001a\u00020\u001b2\u0006\u0010e\u001a\u00020\u0004J\u0010\u0010s\u001a\u00020\u00042\u0006\u0010t\u001a\u00020uH\u0002J\u0010\u0010v\u001a\u00020\u00042\u0006\u0010O\u001a\u00020\nH\u0002J\b\u0010w\u001a\u00020_H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0018\u0010\u0005\u001a\u00020\u00068\u0002X\u0083\u0004¢\u0006\n\n\u0002\u0010\b\u0012\u0004\b\u0007\u0010\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R4\u0010\u0018\u001a \u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001a0\u00198\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001e\u0010\u0002R\u000e\u0010\u001f\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001cX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u001cX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020#X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u001cX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u001cX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u001cX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u001cX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u001cX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u001cX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u001cX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u001cX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u001cX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u001cX\u0082T¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u001bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u000104X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u000206X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00109\u001a\u0004\u0018\u00010:X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020<X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006y"}, d2 = {"Lcom/baidu/searchbox/common/security/DeviceInfoManager;", "", "()V", "DEBUG", "", "DEFAULT_APP_HOST", "com/baidu/searchbox/common/security/DeviceInfoManager$DEFAULT_APP_HOST$1", "getDEFAULT_APP_HOST$annotations", "Lcom/baidu/searchbox/common/security/DeviceInfoManager$DEFAULT_APP_HOST$1;", "DEFAULT_PHONE_TYPE", "", "DEVICE_ALL", "DEVICE_ANDROID_ID", "DEVICE_FLAG_BIT_NUM", "DEVICE_HARMONY_VERSION", "DEVICE_IMEI", "DEVICE_MAC", "DEVICE_MANUFACTURER", "DEVICE_MODEL", "DEVICE_NONE", "DEVICE_NON_SENSITIVE", "DEVICE_OAID", "DEVICE_OPERATOR", "DEVICE_OS_VERSION", "DEVICE_READ_FUNC_MAP", "Landroid/util/SparseArray;", "Lkotlin/Function3;", "Landroid/content/Context;", "", "Lcom/baidu/searchbox/common/security/DeviceIdBag;", "getDEVICE_READ_FUNC_MAP$annotations", "DEVICE_VALUABLE", "ERRNO", "ERRNO_SUCCESS", "GZIP_HEAD_1", "", "GZIP_HEAD_2", "HTTP_STATUS_OK", "MAPPING_CACHE_FILE", "MAPPING_URL", "PURPOSE_LAUNCH_SYNC", "SCENE_LAUNCH", "SDK_DIR", "SP_FILE", "SP_KEY_FORCE_SYNC_CACHE_TIME", "SP_KEY_LAUNCH_SYNC_DONE", "SYNC_JSON_KEY_TIME", "TAG", "mContext", "mDeviceInfoMap", "Lcom/baidu/searchbox/common/security/DeviceIdBagMap;", "mHandler", "Landroid/os/Handler;", "mHandlerThread", "Landroid/os/HandlerThread;", "mInit", "mLaunchSyncStarted", "mMappingCache", "Lcom/baidu/searchbox/common/security/CacheDeviceInfo;", "mMappingCacheFile", "Ljava/io/File;", "mPhoneTypeWhenReadIMEI", "mPhoneTypeWhenReadOperator", "mSyncingDeviceFlag", "checkIPCService", "ipcService", "Lcom/baidu/searchbox/common/security/IDeviceInfoService;", "gZip", "", "data", "getAndroidId", "context", "scene", "purpose", "getAppHost", "Lcom/baidu/searchbox/common/security/IDeviceInfoAppHost;", "getContext", "getContext$lib_security_framework_release", CommonTbJsBridge.GET_DEVICE_INFO, "deviceFlag", "forceApi", "getEncodeValue", "value", "getHarmonyVersion", "getIMEI", "getLastForceSyncCacheTime", "", "getMacAddress", "getManufacturer", "getModel", "getOAID", "getOperator", "getOsVersion", "hasLaunchMappingDone", "init", "", "isCuidChanged", "cacheDeviceInfo", "postSyncTask", "preInit", "appContext", "needSupportMultiProcess", "readAndroidId", "readHarmonyVersion", "readIMEI", "readMac", "readManufacturer", "readMappingCache", "readModel", "readOAID", "readOperator", "readOsVersion", "saveForceSyncCacheTime", "saveLaunchMappingDone", "setContextAndIPC", "syncMapping", "infoJson", "Lorg/json/JSONObject;", "syncMappingOfFixedDeviceFlag", "writeMappingCache", "SyncTask", "lib-security-framework_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DeviceInfoManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final DeviceInfoManager$DEFAULT_APP_HOST$1 DEFAULT_APP_HOST;
    public static final int DEFAULT_PHONE_TYPE = 0;
    public static final int DEVICE_ALL = 511;
    public static final int DEVICE_ANDROID_ID = 4;
    public static final int DEVICE_FLAG_BIT_NUM = 9;
    public static final int DEVICE_HARMONY_VERSION = 128;
    public static final int DEVICE_IMEI = 2;
    public static final int DEVICE_MAC = 1;
    public static final int DEVICE_MANUFACTURER = 256;
    public static final int DEVICE_MODEL = 16;
    public static final int DEVICE_NONE = 0;
    public static final int DEVICE_NON_SENSITIVE = 496;
    public static final int DEVICE_OAID = 8;
    public static final int DEVICE_OPERATOR = 64;
    public static final int DEVICE_OS_VERSION = 32;
    public static final SparseArray<Function3<Context, String, String, DeviceIdBag>> DEVICE_READ_FUNC_MAP;
    public static final int DEVICE_VALUABLE = 66;
    public static final String ERRNO = "errno";
    public static final String ERRNO_SUCCESS = "0";
    public static final byte GZIP_HEAD_1 = 117;
    public static final byte GZIP_HEAD_2 = 123;
    public static final int HTTP_STATUS_OK = 200;
    public static final DeviceInfoManager INSTANCE;
    public static final String MAPPING_CACHE_FILE = "device_info_sdk/sync_mapping";
    public static final String MAPPING_URL = "https://mbd.baidu.com/mapping/update";
    public static final String PURPOSE_LAUNCH_SYNC = "launch_sync";
    public static final String SCENE_LAUNCH = "launch";
    public static final String SDK_DIR = "device_info_sdk";
    public static final String SP_FILE = "device_info_sdk";
    public static final String SP_KEY_FORCE_SYNC_CACHE_TIME = "force_sync_cache_time";
    public static final String SP_KEY_LAUNCH_SYNC_DONE = "launch_sync_done";
    public static final String SYNC_JSON_KEY_TIME = "j";
    public static final String TAG = "DeviceInfoManager";
    public static Context mContext;
    public static DeviceIdBagMap mDeviceInfoMap;
    public static Handler mHandler;
    public static final HandlerThread mHandlerThread;
    public static boolean mInit;
    public static boolean mLaunchSyncStarted;
    public static CacheDeviceInfo mMappingCache;
    public static File mMappingCacheFile;
    public static int mPhoneTypeWhenReadIMEI;
    public static int mPhoneTypeWhenReadOperator;
    public static int mSyncingDeviceFlag;
    public transient /* synthetic */ FieldHolder $fh;

    @JvmStatic
    public static /* synthetic */ void getDEFAULT_APP_HOST$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getDEVICE_READ_FUNC_MAP$annotations() {
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/baidu/searchbox/common/security/DeviceInfoManager$SyncTask;", "Ljava/lang/Runnable;", "deviceFlag", "", "(I)V", "getDeviceFlag", "()I", "run", "", "lib-security-framework_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class SyncTask implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int deviceFlag;

        public SyncTask(int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.deviceFlag = i;
        }

        public final int getDeviceFlag() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.deviceFlag;
            }
            return invokeV.intValue;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || !DeviceInfoManager.mLaunchSyncStarted) {
                return;
            }
            DeviceInfoManager deviceInfoManager = DeviceInfoManager.INSTANCE;
            DeviceInfoManager.mSyncingDeviceFlag = this.deviceFlag;
            try {
                DeviceInfoManager.INSTANCE.syncMappingOfFixedDeviceFlag(this.deviceFlag);
            } catch (Exception unused) {
            } catch (Throwable th) {
                DeviceInfoManager deviceInfoManager2 = DeviceInfoManager.INSTANCE;
                DeviceInfoManager.mSyncingDeviceFlag = 0;
                throw th;
            }
            DeviceInfoManager deviceInfoManager3 = DeviceInfoManager.INSTANCE;
            DeviceInfoManager.mSyncingDeviceFlag = 0;
        }
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [com.baidu.searchbox.common.security.DeviceInfoManager$DEFAULT_APP_HOST$1] */
    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-107786217, "Lcom/baidu/searchbox/common/security/DeviceInfoManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-107786217, "Lcom/baidu/searchbox/common/security/DeviceInfoManager;");
                return;
            }
        }
        INSTANCE = new DeviceInfoManager();
        SparseArray<Function3<Context, String, String, DeviceIdBag>> sparseArray = new SparseArray<>();
        sparseArray.put(1, DeviceInfoManager$DEVICE_READ_FUNC_MAP$1$1.INSTANCE);
        sparseArray.put(2, DeviceInfoManager$DEVICE_READ_FUNC_MAP$1$2.INSTANCE);
        sparseArray.put(4, DeviceInfoManager$DEVICE_READ_FUNC_MAP$1$3.INSTANCE);
        sparseArray.put(8, DeviceInfoManager$DEVICE_READ_FUNC_MAP$1$4.INSTANCE);
        sparseArray.put(16, DeviceInfoManager$DEVICE_READ_FUNC_MAP$1$5.INSTANCE);
        sparseArray.put(32, DeviceInfoManager$DEVICE_READ_FUNC_MAP$1$6.INSTANCE);
        sparseArray.put(64, DeviceInfoManager$DEVICE_READ_FUNC_MAP$1$7.INSTANCE);
        sparseArray.put(128, DeviceInfoManager$DEVICE_READ_FUNC_MAP$1$8.INSTANCE);
        sparseArray.put(256, DeviceInfoManager$DEVICE_READ_FUNC_MAP$1$9.INSTANCE);
        DEVICE_READ_FUNC_MAP = sparseArray;
        mDeviceInfoMap = new DeviceIdBagMap();
        mHandlerThread = new HandlerThread(TAG);
        DEFAULT_APP_HOST = new IDeviceInfoAppHost() { // from class: com.baidu.searchbox.common.security.DeviceInfoManager$DEFAULT_APP_HOST$1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.baidu.searchbox.common.security.IDeviceInfoAppHost
            public String getAppName() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return IDeviceInfoAppHost.DefaultImpls.getAppName(this);
                }
                return (String) invokeV.objValue;
            }

            @Override // com.baidu.searchbox.common.security.IDeviceInfoAppHost
            public String getEnUid() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    return IDeviceInfoAppHost.DefaultImpls.getEnUid(this);
                }
                return (String) invokeV.objValue;
            }

            @Override // com.baidu.searchbox.common.security.IDeviceInfoAppHost
            public long getForceMappingCacheInterval() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                    return IDeviceInfoAppHost.DefaultImpls.getForceMappingCacheInterval(this);
                }
                return invokeV.longValue;
            }

            @Override // com.baidu.searchbox.common.security.IDeviceInfoAppHost
            public IDeviceInfoAppHost.OAIDResult getOAID() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048579, this)) == null) {
                    return IDeviceInfoAppHost.DefaultImpls.getOAID(this);
                }
                return (IDeviceInfoAppHost.OAIDResult) invokeV.objValue;
            }

            @Override // com.baidu.searchbox.common.security.IDeviceInfoAppHost
            public String getUA() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) {
                    return IDeviceInfoAppHost.DefaultImpls.getUA(this);
                }
                return (String) invokeV.objValue;
            }

            @Override // com.baidu.searchbox.common.security.IDeviceInfoAppHost
            public boolean useMapping() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                    return IDeviceInfoAppHost.DefaultImpls.useMapping(this);
                }
                return invokeV.booleanValue;
            }
        };
    }

    public DeviceInfoManager() {
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

    @Inject(force = false)
    private final IDeviceInfoAppHost getAppHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65556, this)) == null) {
            return cx8.a();
        }
        return (IDeviceInfoAppHost) invokeV.objValue;
    }

    public final Context getContext$lib_security_framework_release() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Context context = mContext;
            if (context == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
                return null;
            }
            return context;
        }
        return (Context) invokeV.objValue;
    }

    public static /* synthetic */ void init$default(DeviceInfoManager deviceInfoManager, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 511;
        }
        deviceInfoManager.init(i);
    }

    public final DeviceIdBagMap getDeviceInfo(Context context, String scene, String purpose, int i) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(Constants.METHOD_SEND_USER_MSG, this, context, scene, purpose, i)) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(scene, "scene");
            Intrinsics.checkNotNullParameter(purpose, "purpose");
            return getDeviceInfo(context, scene, purpose, i, false);
        }
        return (DeviceIdBagMap) invokeLLLI.objValue;
    }

    public final DeviceIdBag getIMEI(Context context, String scene, String purpose) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, context, scene, purpose)) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(scene, "scene");
            Intrinsics.checkNotNullParameter(purpose, "purpose");
            return getIMEI(context, scene, purpose, false);
        }
        return (DeviceIdBag) invokeLLL.objValue;
    }

    public final DeviceIdBag getOperator(Context context, String scene, String purpose) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048587, this, context, scene, purpose)) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(scene, "scene");
            Intrinsics.checkNotNullParameter(purpose, "purpose");
            return getOperator(context, scene, purpose, false);
        }
        return (DeviceIdBag) invokeLLL.objValue;
    }

    private final boolean checkIPCService(IDeviceInfoService iDeviceInfoService) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, this, iDeviceInfoService)) == null) {
            if (iDeviceInfoService != null && !(iDeviceInfoService instanceof IDeviceInfoService.Stub)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    private final String getEncodeValue(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65560, this, str)) == null) {
            try {
                String encode = URLEncoder.encode(str, IMAudioTransRequest.CHARSET);
                Intrinsics.checkNotNullExpressionValue(encode, "encode(value, \"utf-8\")");
                return encode;
            } catch (UnsupportedEncodingException unused) {
                return str;
            }
        }
        return (String) invokeL.objValue;
    }

    private final long getLastForceSyncCacheTime(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65562, this, context)) == null) {
            return context.getSharedPreferences("device_info_sdk", 0).getLong(SP_KEY_FORCE_SYNC_CACHE_TIME, Long.MIN_VALUE);
        }
        return invokeL.longValue;
    }

    private final boolean isCuidChanged(CacheDeviceInfo cacheDeviceInfo) {
        InterceptResult invokeL;
        IDeviceInfoAppHost appHost;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65566, this, cacheDeviceInfo)) == null) {
            if (cacheDeviceInfo == null || (appHost = getAppHost()) == DEFAULT_APP_HOST) {
                return false;
            }
            return !Intrinsics.areEqual(cacheDeviceInfo.getEnUid(), appHost.getEnUid());
        }
        return invokeL.booleanValue;
    }

    private final void postSyncTask(int i) {
        Handler handler;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(65567, this, i) == null) && ((~mSyncingDeviceFlag) & i) != 0 && (handler = mHandler) != null) {
            handler.post(new SyncTask(i));
        }
    }

    private final void saveForceSyncCacheTime(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65577, this, context) == null) {
            context.getSharedPreferences("device_info_sdk", 0).edit().putLong(SP_KEY_FORCE_SYNC_CACHE_TIME, System.currentTimeMillis()).apply();
        }
    }

    private final void saveLaunchMappingDone(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65578, this, context) == null) {
            context.getSharedPreferences("device_info_sdk", 0).edit().putBoolean(SP_KEY_LAUNCH_SYNC_DONE, true).apply();
        }
    }

    public final boolean hasLaunchMappingDone(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, context)) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            return context.getSharedPreferences("device_info_sdk", 0).getBoolean(SP_KEY_LAUNCH_SYNC_DONE, false);
        }
        return invokeL.booleanValue;
    }

    public final void setContextAndIPC(Context appContext, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048594, this, appContext, z) == null) {
            Intrinsics.checkNotNullParameter(appContext, "appContext");
            mContext = appContext;
            if (dk1.g() && z) {
                DeviceInfoIPCServiceManager.Companion.addIPCService();
            }
        }
    }

    private final byte[] gZip(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, this, bArr)) == null) {
            byte[] bArr2 = null;
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                gZIPOutputStream.write(bArr);
                gZIPOutputStream.finish();
                gZIPOutputStream.close();
                bArr2 = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                return bArr2;
            } catch (Exception e) {
                e.printStackTrace();
                return bArr2;
            }
        }
        return (byte[]) invokeL.objValue;
    }

    public final void init(final int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048591, this, i) == null) && !mInit && getAppHost().useMapping()) {
            mInit = true;
            mHandlerThread.start();
            Handler handler = new Handler(mHandlerThread.getLooper());
            mHandler = handler;
            Intrinsics.checkNotNull(handler);
            handler.post(new Runnable() { // from class: com.baidu.tieba.jm1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        DeviceInfoManager.m41init$lambda1(i);
                    }
                }
            });
        }
    }

    public static /* synthetic */ DeviceIdBagMap getDeviceInfo$default(DeviceInfoManager deviceInfoManager, Context context, String str, String str2, int i, boolean z, int i2, Object obj) {
        boolean z2;
        if ((i2 & 16) != 0) {
            z2 = false;
        } else {
            z2 = z;
        }
        return deviceInfoManager.getDeviceInfo(context, str, str2, i, z2);
    }

    public static /* synthetic */ DeviceIdBag getIMEI$default(DeviceInfoManager deviceInfoManager, Context context, String str, String str2, boolean z, int i, Object obj) {
        if ((i & 8) != 0) {
            z = false;
        }
        return deviceInfoManager.getIMEI(context, str, str2, z);
    }

    public static /* synthetic */ DeviceIdBag getOperator$default(DeviceInfoManager deviceInfoManager, Context context, String str, String str2, boolean z, int i, Object obj) {
        if ((i & 8) != 0) {
            z = false;
        }
        return deviceInfoManager.getOperator(context, str, str2, z);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0097  */
    /* renamed from: init$lambda-1  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m41init$lambda1(int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65565, null, i) == null) {
            final Ref.IntRef intRef = new Ref.IntRef();
            intRef.element = i;
            Context context = null;
            if (mMappingCache != null) {
                long currentTimeMillis = System.currentTimeMillis();
                DeviceInfoManager deviceInfoManager = INSTANCE;
                Context context2 = mContext;
                if (context2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mContext");
                    context2 = null;
                }
                if (Math.abs(currentTimeMillis - deviceInfoManager.getLastForceSyncCacheTime(context2)) > INSTANCE.getAppHost().getForceMappingCacheInterval()) {
                    intRef.element = 511;
                } else if (INSTANCE.isCuidChanged(mMappingCache)) {
                    mMappingCache = null;
                    intRef.element = 511;
                }
                z = true;
                final Ref.IntRef intRef2 = new Ref.IntRef();
                DeviceInfoUtilKt.forEachDevice(new Function1<Integer, Unit>(intRef, intRef2) { // from class: com.baidu.searchbox.common.security.DeviceInfoManager$init$1$1
                    public static /* synthetic */ Interceptable $ic;
                    public final /* synthetic */ Ref.IntRef $diffFlag;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ Ref.IntRef $finalDeviceFlag;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {intRef, intRef2};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                super(((Integer) newInitContext.callArgs[0]).intValue());
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.$finalDeviceFlag = intRef;
                        this.$diffFlag = intRef2;
                    }

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                        invoke(num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(int i2) {
                        DeviceIdBagMap deviceIdBagMap;
                        CacheDeviceInfo cacheDeviceInfo;
                        SparseArray sparseArray;
                        Context context3;
                        DeviceIdBagMap deviceIdBagMap2;
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) && (this.$finalDeviceFlag.element & i2) != 0) {
                            deviceIdBagMap = DeviceInfoManager.mDeviceInfoMap;
                            DeviceIdBag deviceIdBag = (DeviceIdBag) deviceIdBagMap.get((Object) Integer.valueOf(i2));
                            if (deviceIdBag == null) {
                                sparseArray = DeviceInfoManager.DEVICE_READ_FUNC_MAP;
                                Function3 function3 = (Function3) sparseArray.get(i2);
                                context3 = DeviceInfoManager.mContext;
                                if (context3 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("mContext");
                                    context3 = null;
                                }
                                function3.invoke(context3, "launch", DeviceInfoManager.PURPOSE_LAUNCH_SYNC);
                                deviceIdBagMap2 = DeviceInfoManager.mDeviceInfoMap;
                                deviceIdBag = (DeviceIdBag) deviceIdBagMap2.get((Object) Integer.valueOf(i2));
                            } else {
                                cacheDeviceInfo = DeviceInfoManager.mMappingCache;
                                if (DeviceInfoUtilKt.isDeviceInfoSyncMapping(cacheDeviceInfo, i2, deviceIdBag.deviceId)) {
                                    deviceIdBag.errorCode = 3;
                                }
                            }
                            if (deviceIdBag != null && deviceIdBag.errorCode != 3 && !TextUtils.isEmpty(deviceIdBag.deviceId)) {
                                Ref.IntRef intRef3 = this.$diffFlag;
                                intRef3.element = i2 | intRef3.element;
                            }
                        }
                    }
                });
                DeviceInfoManager deviceInfoManager2 = INSTANCE;
                mLaunchSyncStarted = true;
                if (mMappingCache != null) {
                    if (deviceInfoManager2.syncMappingOfFixedDeviceFlag(intRef2.element)) {
                        DeviceInfoManager deviceInfoManager3 = INSTANCE;
                        Context context3 = mContext;
                        if (context3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mContext");
                            context3 = null;
                        }
                        deviceInfoManager3.saveForceSyncCacheTime(context3);
                        DeviceInfoManager deviceInfoManager4 = INSTANCE;
                        Context context4 = mContext;
                        if (context4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mContext");
                            context4 = null;
                        }
                        if (!deviceInfoManager4.hasLaunchMappingDone(context4)) {
                            DeviceInfoManager deviceInfoManager5 = INSTANCE;
                            Context context5 = mContext;
                            if (context5 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("mContext");
                            } else {
                                context = context5;
                            }
                            deviceInfoManager5.saveLaunchMappingDone(context);
                            return;
                        }
                        return;
                    }
                    return;
                } else if (z) {
                    if (deviceInfoManager2.syncMappingOfFixedDeviceFlag(511)) {
                        DeviceInfoManager deviceInfoManager6 = INSTANCE;
                        Context context6 = mContext;
                        if (context6 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mContext");
                            context6 = null;
                        }
                        deviceInfoManager6.saveForceSyncCacheTime(context6);
                        DeviceInfoManager deviceInfoManager7 = INSTANCE;
                        Context context7 = mContext;
                        if (context7 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mContext");
                            context7 = null;
                        }
                        if (!deviceInfoManager7.hasLaunchMappingDone(context7)) {
                            DeviceInfoManager deviceInfoManager8 = INSTANCE;
                            Context context8 = mContext;
                            if (context8 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("mContext");
                            } else {
                                context = context8;
                            }
                            deviceInfoManager8.saveLaunchMappingDone(context);
                            return;
                        }
                        return;
                    }
                    return;
                } else {
                    int i2 = intRef2.element;
                    if (i2 != 0 && deviceInfoManager2.syncMappingOfFixedDeviceFlag(i2)) {
                        DeviceInfoManager deviceInfoManager9 = INSTANCE;
                        Context context9 = mContext;
                        if (context9 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mContext");
                            context9 = null;
                        }
                        if (!deviceInfoManager9.hasLaunchMappingDone(context9)) {
                            DeviceInfoManager deviceInfoManager10 = INSTANCE;
                            Context context10 = mContext;
                            if (context10 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("mContext");
                            } else {
                                context = context10;
                            }
                            deviceInfoManager10.saveLaunchMappingDone(context);
                            return;
                        }
                        return;
                    }
                    return;
                }
            }
            z = false;
            final Ref.IntRef intRef22 = new Ref.IntRef();
            DeviceInfoUtilKt.forEachDevice(new Function1<Integer, Unit>(intRef, intRef22) { // from class: com.baidu.searchbox.common.security.DeviceInfoManager$init$1$1
                public static /* synthetic */ Interceptable $ic;
                public final /* synthetic */ Ref.IntRef $diffFlag;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Ref.IntRef $finalDeviceFlag;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = objArr;
                        Object[] objArr = {intRef, intRef22};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i22 = newInitContext.flag;
                        if ((i22 & 1) != 0) {
                            int i3 = i22 & 2;
                            super(((Integer) newInitContext.callArgs[0]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.$finalDeviceFlag = intRef;
                    this.$diffFlag = intRef22;
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                    invoke(num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(int i22) {
                    DeviceIdBagMap deviceIdBagMap;
                    CacheDeviceInfo cacheDeviceInfo;
                    SparseArray sparseArray;
                    Context context32;
                    DeviceIdBagMap deviceIdBagMap2;
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i22) == null) && (this.$finalDeviceFlag.element & i22) != 0) {
                        deviceIdBagMap = DeviceInfoManager.mDeviceInfoMap;
                        DeviceIdBag deviceIdBag = (DeviceIdBag) deviceIdBagMap.get((Object) Integer.valueOf(i22));
                        if (deviceIdBag == null) {
                            sparseArray = DeviceInfoManager.DEVICE_READ_FUNC_MAP;
                            Function3 function3 = (Function3) sparseArray.get(i22);
                            context32 = DeviceInfoManager.mContext;
                            if (context32 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("mContext");
                                context32 = null;
                            }
                            function3.invoke(context32, "launch", DeviceInfoManager.PURPOSE_LAUNCH_SYNC);
                            deviceIdBagMap2 = DeviceInfoManager.mDeviceInfoMap;
                            deviceIdBag = (DeviceIdBag) deviceIdBagMap2.get((Object) Integer.valueOf(i22));
                        } else {
                            cacheDeviceInfo = DeviceInfoManager.mMappingCache;
                            if (DeviceInfoUtilKt.isDeviceInfoSyncMapping(cacheDeviceInfo, i22, deviceIdBag.deviceId)) {
                                deviceIdBag.errorCode = 3;
                            }
                        }
                        if (deviceIdBag != null && deviceIdBag.errorCode != 3 && !TextUtils.isEmpty(deviceIdBag.deviceId)) {
                            Ref.IntRef intRef3 = this.$diffFlag;
                            intRef3.element = i22 | intRef3.element;
                        }
                    }
                }
            });
            DeviceInfoManager deviceInfoManager22 = INSTANCE;
            mLaunchSyncStarted = true;
            if (mMappingCache != null) {
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x00f7, code lost:
        if (r2 != null) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00f9, code lost:
        r2.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x010c, code lost:
        if (0 != 0) goto L35;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean syncMapping(JSONObject jSONObject) {
        InterceptResult invokeL;
        IDeviceInfoAppHost appHost;
        BufferedInputStream bufferedInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65579, this, jSONObject)) == null) {
            if (jSONObject.length() == 0 || (appHost = getAppHost()) == DEFAULT_APP_HOST) {
                return false;
            }
            String str = "https://mbd.baidu.com/mapping/update?appname=" + getEncodeValue(appHost.getAppName()) + "&ua=" + getEncodeValue(appHost.getUA()) + "&uid=" + getEncodeValue(appHost.getEnUid());
            jSONObject.put("j", String.valueOf(System.currentTimeMillis()));
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "infoJson.toString()");
            byte[] bytes = jSONObject2.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            byte[] gZip = gZip(bytes);
            if (gZip != null && gZip.length >= 2) {
                gZip[0] = 117;
                gZip[1] = 123;
                OutputStream outputStream = null;
                try {
                    URLConnection openConnection = new URL(str).openConnection();
                    if (openConnection != null) {
                        HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
                        httpURLConnection.setRequestMethod("POST");
                        httpURLConnection.setDoOutput(true);
                        httpURLConnection.setDoInput(true);
                        httpURLConnection.setUseCaches(false);
                        outputStream = httpURLConnection.getOutputStream();
                        outputStream.write(gZip);
                        outputStream.flush();
                        if (httpURLConnection.getResponseCode() == 200) {
                            InputStream inputStream = httpURLConnection.getInputStream();
                            Intrinsics.checkNotNullExpressionValue(inputStream, "connection.inputStream");
                            if (inputStream instanceof BufferedInputStream) {
                                bufferedInputStream = (BufferedInputStream) inputStream;
                            } else {
                                bufferedInputStream = new BufferedInputStream(inputStream, 8192);
                            }
                            String readText = TextStreamsKt.readText(new InputStreamReader(bufferedInputStream, Charsets.UTF_8));
                            if (!TextUtils.isEmpty(readText) && Intrinsics.areEqual(new JSONObject(readText).optString("errno", ""), "0")) {
                                if (outputStream != null) {
                                    try {
                                        outputStream.close();
                                    } catch (Exception unused) {
                                    }
                                }
                                return true;
                            }
                        }
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type java.net.HttpURLConnection");
                    }
                } catch (Exception unused2) {
                } catch (Throwable th) {
                    if (0 != 0) {
                        try {
                            outputStream.close();
                        } catch (Exception unused3) {
                        }
                    }
                    throw th;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DeviceIdBag readAndroidId(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65568, this, context, str, str2)) == null) {
            DeviceIdBag androidId = AndroidIDProxy.getAndroidId(context);
            int i = androidId.errorCode;
            if (i != -3 && i != -1) {
                DeviceIdBagMap deviceIdBagMap = mDeviceInfoMap;
                Intrinsics.checkNotNullExpressionValue(androidId, "this");
                deviceIdBagMap.put((DeviceIdBagMap) 4, (int) androidId);
                if (INSTANCE.getAppHost().useMapping() && DeviceInfoUtilKt.isDeviceInfoSyncMapping(mMappingCache, 4, androidId.deviceId)) {
                    androidId.errorCode = 3;
                }
            }
            Intrinsics.checkNotNullExpressionValue(androidId, "getAndroidId(context).ap…}\n            }\n        }");
            return androidId;
        }
        return (DeviceIdBag) invokeLLL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DeviceIdBag readHarmonyVersion(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65569, this, context, str, str2)) == null) {
            DeviceIdBag deviceIdBag = new DeviceIdBag();
            mDeviceInfoMap.put((DeviceIdBagMap) 128, (int) deviceIdBag);
            int i = 2;
            if (DeviceUtils.isHarmonyOS(context)) {
                String harmonyVersion = DeviceUtils.getHarmonyVersion();
                deviceIdBag.deviceId = harmonyVersion;
                if (!TextUtils.isEmpty(harmonyVersion)) {
                    if (INSTANCE.getAppHost().useMapping() && DeviceInfoUtilKt.isDeviceInfoSyncMapping(mMappingCache, 128, deviceIdBag.deviceId)) {
                        i = 3;
                    } else {
                        i = 0;
                    }
                }
                deviceIdBag.errorCode = i;
            } else {
                deviceIdBag.errorCode = 2;
            }
            return deviceIdBag;
        }
        return (DeviceIdBag) invokeLLL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DeviceIdBag readMac(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65571, this, context, str, str2)) == null) {
            DeviceIdBag hardwareAddress = HardwareProxy.getHardwareAddress(context);
            int i = hardwareAddress.errorCode;
            if (i != -3 && i != -1) {
                DeviceIdBagMap deviceIdBagMap = mDeviceInfoMap;
                Intrinsics.checkNotNullExpressionValue(hardwareAddress, "this");
                deviceIdBagMap.put((DeviceIdBagMap) 1, (int) hardwareAddress);
                if (INSTANCE.getAppHost().useMapping() && DeviceInfoUtilKt.isDeviceInfoSyncMapping(mMappingCache, 1, hardwareAddress.deviceId)) {
                    hardwareAddress.errorCode = 3;
                }
            }
            Intrinsics.checkNotNullExpressionValue(hardwareAddress, "getHardwareAddress(conte…}\n            }\n        }");
            return hardwareAddress;
        }
        return (DeviceIdBag) invokeLLL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DeviceIdBag readIMEI(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65570, this, context, str, str2)) == null) {
            DeviceIdBag imei = DeviceInfoProxy.getImei(context, false, true);
            int i = imei.errorCode;
            if (i != -3 && i != -2 && i != -1) {
                DeviceIdBagMap deviceIdBagMap = mDeviceInfoMap;
                Intrinsics.checkNotNullExpressionValue(imei, "this");
                deviceIdBagMap.put((DeviceIdBagMap) 2, (int) imei);
                if (INSTANCE.getAppHost().useMapping() && DeviceInfoUtilKt.isDeviceInfoSyncMapping(mMappingCache, 2, imei.deviceId)) {
                    imei.errorCode = 3;
                }
                try {
                    Object systemService = context.getSystemService("phone");
                    if (systemService != null) {
                        mPhoneTypeWhenReadIMEI = ((TelephonyManager) systemService).getPhoneType();
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type android.telephony.TelephonyManager");
                    }
                } catch (Exception unused) {
                }
            }
            Intrinsics.checkNotNullExpressionValue(imei, "getImei(context, false, …}\n            }\n        }");
            return imei;
        }
        return (DeviceIdBag) invokeLLL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DeviceIdBag readOperator(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        int i;
        Object systemService;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65575, this, context, str, str2)) == null) {
            DeviceIdBag deviceIdBag = new DeviceIdBag();
            try {
                systemService = context.getSystemService("phone");
            } catch (Exception unused) {
            }
            if (systemService != null) {
                TelephonyManager telephonyManager = (TelephonyManager) systemService;
                deviceIdBag.deviceId = telephonyManager.getSimOperator();
                mDeviceInfoMap.put((DeviceIdBagMap) 64, (int) deviceIdBag);
                mPhoneTypeWhenReadOperator = telephonyManager.getPhoneType();
                if (TextUtils.isEmpty(deviceIdBag.deviceId)) {
                    i = 2;
                } else if (INSTANCE.getAppHost().useMapping() && DeviceInfoUtilKt.isDeviceInfoSyncMapping(mMappingCache, 64, deviceIdBag.deviceId)) {
                    i = 3;
                } else {
                    i = 0;
                }
                deviceIdBag.errorCode = i;
                return deviceIdBag;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.telephony.TelephonyManager");
        }
        return (DeviceIdBag) invokeLLL.objValue;
    }

    public final DeviceIdBag getAndroidId(Context context, String scene, String purpose) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, context, scene, purpose)) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(scene, "scene");
            Intrinsics.checkNotNullParameter(purpose, "purpose");
            if (!dk1.g()) {
                IDeviceInfoService iPCService = DeviceInfoIPCServiceManager.Companion.getIPCService();
                if (checkIPCService(iPCService)) {
                    try {
                        Intrinsics.checkNotNull(iPCService);
                        DeviceIdBag androidId = iPCService.getAndroidId(scene, purpose);
                        Intrinsics.checkNotNullExpressionValue(androidId, "ipcService!!.getAndroidId(scene, purpose)");
                        return androidId;
                    } catch (Exception unused) {
                    }
                }
                DeviceIdBag deviceIdBag = (DeviceIdBag) mDeviceInfoMap.get((Object) 4);
                if (deviceIdBag == null) {
                    return readAndroidId(context, scene, purpose);
                }
                return deviceIdBag;
            }
            DeviceIdBag deviceIdBag2 = (DeviceIdBag) mDeviceInfoMap.get((Object) 4);
            if (deviceIdBag2 == null) {
                deviceIdBag2 = readAndroidId(context, scene, purpose);
            }
            Intrinsics.checkNotNullExpressionValue(deviceIdBag2, "mDeviceInfoMap[DEVICE_AN…(context, scene, purpose)");
            if (getAppHost().useMapping() && deviceIdBag2.errorCode != 3 && !TextUtils.isEmpty(deviceIdBag2.deviceId)) {
                postSyncTask(4);
            }
            return deviceIdBag2;
        }
        return (DeviceIdBag) invokeLLL.objValue;
    }

    public final DeviceIdBag getHarmonyVersion(Context context, String scene, String purpose) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, context, scene, purpose)) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(scene, "scene");
            Intrinsics.checkNotNullParameter(purpose, "purpose");
            if (!dk1.g()) {
                IDeviceInfoService iPCService = DeviceInfoIPCServiceManager.Companion.getIPCService();
                if (checkIPCService(iPCService)) {
                    try {
                        Intrinsics.checkNotNull(iPCService);
                        DeviceIdBag harmonyVersion = iPCService.getHarmonyVersion(scene, purpose);
                        Intrinsics.checkNotNullExpressionValue(harmonyVersion, "ipcService!!.getHarmonyVersion(scene, purpose)");
                        return harmonyVersion;
                    } catch (Exception unused) {
                    }
                }
                DeviceIdBag deviceIdBag = (DeviceIdBag) mDeviceInfoMap.get((Object) 128);
                if (deviceIdBag == null) {
                    return readHarmonyVersion(context, scene, purpose);
                }
                return deviceIdBag;
            }
            DeviceIdBag deviceIdBag2 = (DeviceIdBag) mDeviceInfoMap.get((Object) 128);
            if (deviceIdBag2 == null) {
                deviceIdBag2 = readHarmonyVersion(context, scene, purpose);
            }
            Intrinsics.checkNotNullExpressionValue(deviceIdBag2, "mDeviceInfoMap[DEVICE_HA…(context, scene, purpose)");
            if (deviceIdBag2.errorCode == 0) {
                postSyncTask(128);
            }
            return deviceIdBag2;
        }
        return (DeviceIdBag) invokeLLL.objValue;
    }

    public final DeviceIdBag getMacAddress(Context context, String scene, String purpose) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048583, this, context, scene, purpose)) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(scene, "scene");
            Intrinsics.checkNotNullParameter(purpose, "purpose");
            if (!dk1.g()) {
                IDeviceInfoService iPCService = DeviceInfoIPCServiceManager.Companion.getIPCService();
                if (checkIPCService(iPCService)) {
                    try {
                        Intrinsics.checkNotNull(iPCService);
                        DeviceIdBag macAddress = iPCService.getMacAddress(scene, purpose);
                        Intrinsics.checkNotNullExpressionValue(macAddress, "ipcService!!.getMacAddress(scene, purpose)");
                        return macAddress;
                    } catch (Exception unused) {
                    }
                }
                DeviceIdBag deviceIdBag = (DeviceIdBag) mDeviceInfoMap.get((Object) 1);
                if (deviceIdBag == null) {
                    return readMac(context, scene, purpose);
                }
                return deviceIdBag;
            }
            DeviceIdBag deviceIdBag2 = (DeviceIdBag) mDeviceInfoMap.get((Object) 1);
            if (deviceIdBag2 == null) {
                deviceIdBag2 = readMac(context, scene, purpose);
            }
            Intrinsics.checkNotNullExpressionValue(deviceIdBag2, "mDeviceInfoMap[DEVICE_MA…(context, scene, purpose)");
            if (getAppHost().useMapping() && deviceIdBag2.errorCode != 3 && !TextUtils.isEmpty(deviceIdBag2.deviceId)) {
                postSyncTask(1);
            }
            return deviceIdBag2;
        }
        return (DeviceIdBag) invokeLLL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DeviceIdBag readManufacturer(String str, String str2) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65572, this, str, str2)) == null) {
            DeviceIdBag deviceIdBag = new DeviceIdBag();
            mDeviceInfoMap.put((DeviceIdBagMap) 256, (int) deviceIdBag);
            String str3 = Build.MANUFACTURER;
            deviceIdBag.deviceId = str3;
            if (TextUtils.isEmpty(str3)) {
                i = 2;
            } else if (INSTANCE.getAppHost().useMapping() && DeviceInfoUtilKt.isDeviceInfoSyncMapping(mMappingCache, 256, deviceIdBag.deviceId)) {
                i = 3;
            } else {
                i = 0;
            }
            deviceIdBag.errorCode = i;
            return deviceIdBag;
        }
        return (DeviceIdBag) invokeLL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DeviceIdBag readModel(String str, String str2) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65573, this, str, str2)) == null) {
            DeviceIdBag deviceIdBag = new DeviceIdBag();
            mDeviceInfoMap.put((DeviceIdBagMap) 16, (int) deviceIdBag);
            String str3 = Build.MODEL;
            deviceIdBag.deviceId = str3;
            if (TextUtils.isEmpty(str3)) {
                i = 2;
            } else if (INSTANCE.getAppHost().useMapping() && DeviceInfoUtilKt.isDeviceInfoSyncMapping(mMappingCache, 16, deviceIdBag.deviceId)) {
                i = 3;
            } else {
                i = 0;
            }
            deviceIdBag.errorCode = i;
            return deviceIdBag;
        }
        return (DeviceIdBag) invokeLL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DeviceIdBag readOsVersion(String str, String str2) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65576, this, str, str2)) == null) {
            DeviceIdBag deviceIdBag = new DeviceIdBag();
            mDeviceInfoMap.put((DeviceIdBagMap) 32, (int) deviceIdBag);
            String str3 = Build.VERSION.RELEASE;
            deviceIdBag.deviceId = str3;
            if (TextUtils.isEmpty(str3)) {
                i = 2;
            } else if (INSTANCE.getAppHost().useMapping() && DeviceInfoUtilKt.isDeviceInfoSyncMapping(mMappingCache, 32, deviceIdBag.deviceId)) {
                i = 3;
            } else {
                i = 0;
            }
            deviceIdBag.errorCode = i;
            return deviceIdBag;
        }
        return (DeviceIdBag) invokeLL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DeviceIdBag readOAID(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65574, this, str, str2)) == null) {
            DeviceIdBag deviceIdBag = new DeviceIdBag();
            IDeviceInfoAppHost.OAIDResult oaid = INSTANCE.getAppHost().getOAID();
            int i = 2;
            if (oaid.getHasInit()) {
                mDeviceInfoMap.put((DeviceIdBagMap) 8, (int) deviceIdBag);
                deviceIdBag.deviceId = oaid.getOaid();
                deviceIdBag.encodedDeviceId = oaid.getEncodedOAID();
                if (!TextUtils.isEmpty(deviceIdBag.deviceId)) {
                    if (INSTANCE.getAppHost().useMapping() && DeviceInfoUtilKt.isDeviceInfoSyncMapping(mMappingCache, 8, deviceIdBag.deviceId)) {
                        i = 3;
                    } else {
                        i = 0;
                    }
                }
                deviceIdBag.errorCode = i;
            } else {
                deviceIdBag.errorCode = 2;
            }
            return deviceIdBag;
        }
        return (DeviceIdBag) invokeLL.objValue;
    }

    public final DeviceIdBag getManufacturer(String scene, String purpose) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, scene, purpose)) == null) {
            Intrinsics.checkNotNullParameter(scene, "scene");
            Intrinsics.checkNotNullParameter(purpose, "purpose");
            if (!dk1.g()) {
                IDeviceInfoService iPCService = DeviceInfoIPCServiceManager.Companion.getIPCService();
                if (checkIPCService(iPCService)) {
                    try {
                        Intrinsics.checkNotNull(iPCService);
                        DeviceIdBag manufacturer = iPCService.getManufacturer(scene, purpose);
                        Intrinsics.checkNotNullExpressionValue(manufacturer, "ipcService!!.getManufacturer(scene, purpose)");
                        return manufacturer;
                    } catch (Exception unused) {
                    }
                }
                DeviceIdBag deviceIdBag = (DeviceIdBag) mDeviceInfoMap.get((Object) 256);
                if (deviceIdBag == null) {
                    return readManufacturer(scene, purpose);
                }
                return deviceIdBag;
            }
            DeviceIdBag deviceIdBag2 = (DeviceIdBag) mDeviceInfoMap.get((Object) 256);
            if (deviceIdBag2 == null) {
                deviceIdBag2 = readManufacturer(scene, purpose);
            }
            Intrinsics.checkNotNullExpressionValue(deviceIdBag2, "mDeviceInfoMap[DEVICE_MA…ufacturer(scene, purpose)");
            if (deviceIdBag2.errorCode == 0) {
                postSyncTask(256);
            }
            return deviceIdBag2;
        }
        return (DeviceIdBag) invokeLL.objValue;
    }

    public final DeviceIdBag getModel(String scene, String purpose) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, scene, purpose)) == null) {
            Intrinsics.checkNotNullParameter(scene, "scene");
            Intrinsics.checkNotNullParameter(purpose, "purpose");
            if (!dk1.g()) {
                IDeviceInfoService iPCService = DeviceInfoIPCServiceManager.Companion.getIPCService();
                if (checkIPCService(iPCService)) {
                    try {
                        Intrinsics.checkNotNull(iPCService);
                        DeviceIdBag model = iPCService.getModel(scene, purpose);
                        Intrinsics.checkNotNullExpressionValue(model, "ipcService!!.getModel(scene, purpose)");
                        return model;
                    } catch (Exception unused) {
                    }
                }
                DeviceIdBag deviceIdBag = (DeviceIdBag) mDeviceInfoMap.get((Object) 16);
                if (deviceIdBag == null) {
                    return readModel(scene, purpose);
                }
                return deviceIdBag;
            }
            DeviceIdBag deviceIdBag2 = (DeviceIdBag) mDeviceInfoMap.get((Object) 16);
            if (deviceIdBag2 == null) {
                deviceIdBag2 = readModel(scene, purpose);
            }
            Intrinsics.checkNotNullExpressionValue(deviceIdBag2, "mDeviceInfoMap[DEVICE_MO…readModel(scene, purpose)");
            if (deviceIdBag2.errorCode == 0) {
                postSyncTask(16);
            }
            return deviceIdBag2;
        }
        return (DeviceIdBag) invokeLL.objValue;
    }

    public final DeviceIdBag getOAID(String scene, String purpose) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, scene, purpose)) == null) {
            Intrinsics.checkNotNullParameter(scene, "scene");
            Intrinsics.checkNotNullParameter(purpose, "purpose");
            if (!dk1.g()) {
                IDeviceInfoService iPCService = DeviceInfoIPCServiceManager.Companion.getIPCService();
                if (checkIPCService(iPCService)) {
                    try {
                        Intrinsics.checkNotNull(iPCService);
                        DeviceIdBag oaid = iPCService.getOAID(scene, purpose);
                        Intrinsics.checkNotNullExpressionValue(oaid, "ipcService!!.getOAID(scene, purpose)");
                        return oaid;
                    } catch (Exception unused) {
                    }
                }
                DeviceIdBag deviceIdBag = (DeviceIdBag) mDeviceInfoMap.get((Object) 8);
                if (deviceIdBag == null) {
                    return readOAID(scene, purpose);
                }
                return deviceIdBag;
            }
            DeviceIdBag deviceIdBag2 = (DeviceIdBag) mDeviceInfoMap.get((Object) 8);
            if (deviceIdBag2 == null) {
                deviceIdBag2 = readOAID(scene, purpose);
            }
            Intrinsics.checkNotNullExpressionValue(deviceIdBag2, "mDeviceInfoMap[DEVICE_OA… readOAID(scene, purpose)");
            if (deviceIdBag2.errorCode == 0) {
                postSyncTask(8);
            }
            return deviceIdBag2;
        }
        return (DeviceIdBag) invokeLL.objValue;
    }

    public final DeviceIdBag getOsVersion(String scene, String purpose) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, scene, purpose)) == null) {
            Intrinsics.checkNotNullParameter(scene, "scene");
            Intrinsics.checkNotNullParameter(purpose, "purpose");
            if (!dk1.g()) {
                IDeviceInfoService iPCService = DeviceInfoIPCServiceManager.Companion.getIPCService();
                if (checkIPCService(iPCService)) {
                    try {
                        Intrinsics.checkNotNull(iPCService);
                        DeviceIdBag osVersion = iPCService.getOsVersion(scene, purpose);
                        Intrinsics.checkNotNullExpressionValue(osVersion, "ipcService!!.getOsVersion(scene, purpose)");
                        return osVersion;
                    } catch (Exception unused) {
                    }
                }
                DeviceIdBag deviceIdBag = (DeviceIdBag) mDeviceInfoMap.get((Object) 32);
                if (deviceIdBag == null) {
                    return readOsVersion(scene, purpose);
                }
                return deviceIdBag;
            }
            DeviceIdBag deviceIdBag2 = (DeviceIdBag) mDeviceInfoMap.get((Object) 32);
            if (deviceIdBag2 == null) {
                deviceIdBag2 = readOsVersion(scene, purpose);
            }
            Intrinsics.checkNotNullExpressionValue(deviceIdBag2, "mDeviceInfoMap[DEVICE_OS…OsVersion(scene, purpose)");
            if (deviceIdBag2.errorCode == 0) {
                postSyncTask(32);
            }
            return deviceIdBag2;
        }
        return (DeviceIdBag) invokeLL.objValue;
    }

    public final void preInit(Context appContext, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048592, this, appContext, z) == null) {
            Intrinsics.checkNotNullParameter(appContext, "appContext");
            mContext = appContext;
            if (!dk1.g()) {
                return;
            }
            if (z) {
                DeviceInfoIPCServiceManager.Companion.addIPCService();
            }
            if (getAppHost().useMapping()) {
                Context context = mContext;
                if (context == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mContext");
                    context = null;
                }
                File file = new File(context.getFilesDir(), MAPPING_CACHE_FILE);
                mMappingCacheFile = file;
                if (file == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mMappingCacheFile");
                    file = null;
                }
                if (!file.getParentFile().exists()) {
                    File file2 = mMappingCacheFile;
                    if (file2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mMappingCacheFile");
                        file2 = null;
                    }
                    file2.getParentFile().mkdirs();
                }
                File file3 = mMappingCacheFile;
                if (file3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mMappingCacheFile");
                    file3 = null;
                }
                if (file3.exists()) {
                    try {
                        File file4 = mMappingCacheFile;
                        if (file4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mMappingCacheFile");
                            file4 = null;
                        }
                        mMappingCache = new CacheDeviceInfo(FilesKt__FileReadWriteKt.readText$default(file4, null, 1, null));
                    } catch (Exception unused) {
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean syncMappingOfFixedDeviceFlag(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65580, this, i)) == null) {
            if (mSyncingDeviceFlag == 0 && mLaunchSyncStarted && i != 0) {
                try {
                    ArrayList<Number> arrayList = new ArrayList();
                    if (syncMapping(DeviceInfoUtilKt.toJson(mDeviceInfoMap, i, arrayList))) {
                        if (mMappingCache == null) {
                            CacheDeviceInfo cacheDeviceInfo = new CacheDeviceInfo();
                            mMappingCache = cacheDeviceInfo;
                            Intrinsics.checkNotNull(cacheDeviceInfo);
                            cacheDeviceInfo.setEnUid(getAppHost().getEnUid());
                        }
                        int i2 = 0;
                        for (Number number : arrayList) {
                            int intValue = number.intValue();
                            i2 |= intValue;
                            DeviceIdBag deviceIdBag = (DeviceIdBag) mDeviceInfoMap.get((Object) Integer.valueOf(intValue));
                            if (deviceIdBag != null) {
                                deviceIdBag.errorCode = 3;
                            }
                        }
                        DeviceIdBagMap deviceIdBagMap = mDeviceInfoMap;
                        CacheDeviceInfo cacheDeviceInfo2 = mMappingCache;
                        Intrinsics.checkNotNull(cacheDeviceInfo2);
                        DeviceInfoUtilKt.copyFixedInfo(deviceIdBagMap, cacheDeviceInfo2, i2);
                        writeMappingCache();
                        return true;
                    }
                } catch (Exception unused) {
                }
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public final void readMappingCache(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, context) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            mContext = context;
            if (dk1.g() && getAppHost().useMapping()) {
                Context context2 = mContext;
                if (context2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mContext");
                    context2 = null;
                }
                File file = new File(context2.getFilesDir(), MAPPING_CACHE_FILE);
                mMappingCacheFile = file;
                if (file == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mMappingCacheFile");
                    file = null;
                }
                if (!file.getParentFile().exists()) {
                    File file2 = mMappingCacheFile;
                    if (file2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mMappingCacheFile");
                        file2 = null;
                    }
                    file2.getParentFile().mkdirs();
                }
                File file3 = mMappingCacheFile;
                if (file3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mMappingCacheFile");
                    file3 = null;
                }
                if (file3.exists()) {
                    try {
                        File file4 = mMappingCacheFile;
                        if (file4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mMappingCacheFile");
                            file4 = null;
                        }
                        mMappingCache = new CacheDeviceInfo(FilesKt__FileReadWriteKt.readText$default(file4, null, 1, null));
                        DeviceInfoUtilKt.forEachDevice(DeviceInfoManager$readMappingCache$1.INSTANCE);
                    } catch (Exception unused) {
                    }
                }
            }
        }
    }

    private final void writeMappingCache() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65581, this) == null) {
            File file = mMappingCacheFile;
            if (file == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMappingCacheFile");
                file = null;
            }
            if (file.exists()) {
                File file2 = mMappingCacheFile;
                if (file2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mMappingCacheFile");
                    file2 = null;
                }
                file2.delete();
            }
            File file3 = mMappingCacheFile;
            if (file3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMappingCacheFile");
                file3 = null;
            }
            file3.createNewFile();
            File file4 = mMappingCacheFile;
            if (file4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMappingCacheFile");
                file4 = null;
            }
            FilesKt__FileReadWriteKt.writeText$default(file4, String.valueOf(mMappingCache), null, 2, null);
        }
    }

    public final DeviceIdBagMap getDeviceInfo(final Context context, final String scene, final String purpose, final int i, final boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{context, scene, purpose, Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(scene, "scene");
            Intrinsics.checkNotNullParameter(purpose, "purpose");
            if (!dk1.g()) {
                IDeviceInfoService iPCService = DeviceInfoIPCServiceManager.Companion.getIPCService();
                if (checkIPCService(iPCService)) {
                    try {
                        Intrinsics.checkNotNull(iPCService);
                        try {
                            DeviceIdBagMap deviceInfos = iPCService.getDeviceInfos(scene, purpose, i, z);
                            Intrinsics.checkNotNullExpressionValue(deviceInfos, "ipcService!!.getDeviceIn…se, deviceFlag, forceApi)");
                            return deviceInfos;
                        } catch (Exception unused) {
                        }
                    } catch (Exception unused2) {
                    }
                }
                final DeviceIdBagMap deviceIdBagMap = new DeviceIdBagMap();
                DeviceInfoUtilKt.forEachDevice(new Function1<Integer, Unit>(i, z, deviceIdBagMap, context, scene, purpose) { // from class: com.baidu.searchbox.common.security.DeviceInfoManager$getDeviceInfo$1$1
                    public static /* synthetic */ Interceptable $ic;
                    public final /* synthetic */ Context $context;
                    public final /* synthetic */ int $deviceFlag;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ boolean $forceApi;
                    public final /* synthetic */ String $purpose;
                    public final /* synthetic */ String $scene;
                    public final /* synthetic */ DeviceIdBagMap $this_apply;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {Integer.valueOf(i), Boolean.valueOf(z), deviceIdBagMap, context, scene, purpose};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                super(((Integer) newInitContext.callArgs[0]).intValue());
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.$deviceFlag = i;
                        this.$forceApi = z;
                        this.$this_apply = deviceIdBagMap;
                        this.$context = context;
                        this.$scene = scene;
                        this.$purpose = purpose;
                    }

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                        invoke(num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(int i2) {
                        boolean z2;
                        DeviceIdBagMap deviceIdBagMap2;
                        SparseArray sparseArray;
                        DeviceIdBagMap deviceIdBagMap3;
                        SparseArray sparseArray2;
                        SparseArray sparseArray3;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                            boolean z3 = true;
                            if ((this.$deviceFlag & i2) != 0) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            if ((i2 & 66) == 0) {
                                z3 = false;
                            }
                            if (z2 && z3) {
                                if (this.$forceApi) {
                                    DeviceIdBagMap deviceIdBagMap4 = this.$this_apply;
                                    sparseArray3 = DeviceInfoManager.DEVICE_READ_FUNC_MAP;
                                    deviceIdBagMap4.put(i2, (DeviceIdBag) ((Function3) sparseArray3.get(i2)).invoke(this.$context, this.$scene, this.$purpose));
                                    return;
                                }
                                DeviceIdBagMap deviceIdBagMap5 = this.$this_apply;
                                deviceIdBagMap3 = DeviceInfoManager.mDeviceInfoMap;
                                DeviceIdBag deviceIdBag = (DeviceIdBag) deviceIdBagMap3.get((Object) Integer.valueOf(i2));
                                if (deviceIdBag == null) {
                                    sparseArray2 = DeviceInfoManager.DEVICE_READ_FUNC_MAP;
                                    deviceIdBag = (DeviceIdBag) ((Function3) sparseArray2.get(i2)).invoke(this.$context, this.$scene, this.$purpose);
                                }
                                Intrinsics.checkNotNullExpressionValue(deviceIdBag, "mDeviceInfoMap[iterateDe…(context, scene, purpose)");
                                deviceIdBagMap5.put(i2, deviceIdBag);
                            } else if (z2) {
                                DeviceIdBagMap deviceIdBagMap6 = this.$this_apply;
                                deviceIdBagMap2 = DeviceInfoManager.mDeviceInfoMap;
                                DeviceIdBag deviceIdBag2 = (DeviceIdBag) deviceIdBagMap2.get((Object) Integer.valueOf(i2));
                                if (deviceIdBag2 == null) {
                                    sparseArray = DeviceInfoManager.DEVICE_READ_FUNC_MAP;
                                    deviceIdBag2 = (DeviceIdBag) ((Function3) sparseArray.get(i2)).invoke(this.$context, this.$scene, this.$purpose);
                                }
                                Intrinsics.checkNotNullExpressionValue(deviceIdBag2, "mDeviceInfoMap[iterateDe…(context, scene, purpose)");
                                deviceIdBagMap6.put(i2, deviceIdBag2);
                            }
                        }
                    }
                });
                return deviceIdBagMap;
            }
            final boolean useMapping = getAppHost().useMapping();
            final DeviceIdBagMap deviceIdBagMap2 = new DeviceIdBagMap();
            final Ref.IntRef intRef = new Ref.IntRef();
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            DeviceInfoUtilKt.forEachDevice(new Function1<Integer, Unit>(i, objectRef, z, context, scene, purpose, useMapping, intRef, deviceIdBagMap2) { // from class: com.baidu.searchbox.common.security.DeviceInfoManager$getDeviceInfo$result$1$1
                public static /* synthetic */ Interceptable $ic;
                public final /* synthetic */ Context $context;
                public final /* synthetic */ int $deviceFlag;
                public final /* synthetic */ Ref.ObjectRef<DeviceIdBag> $deviceInfo;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ boolean $forceApi;
                public final /* synthetic */ Ref.IntRef $needSyncDeviceFlag;
                public final /* synthetic */ String $purpose;
                public final /* synthetic */ String $scene;
                public final /* synthetic */ DeviceIdBagMap $this_apply;
                public final /* synthetic */ boolean $useMapping;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {Integer.valueOf(i), objectRef, Boolean.valueOf(z), context, scene, purpose, Boolean.valueOf(useMapping), intRef, deviceIdBagMap2};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            super(((Integer) newInitContext.callArgs[0]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.$deviceFlag = i;
                    this.$deviceInfo = objectRef;
                    this.$forceApi = z;
                    this.$context = context;
                    this.$scene = scene;
                    this.$purpose = purpose;
                    this.$useMapping = useMapping;
                    this.$needSyncDeviceFlag = intRef;
                    this.$this_apply = deviceIdBagMap2;
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                    invoke(num.intValue());
                    return Unit.INSTANCE;
                }

                /* JADX DEBUG: Multi-variable search result rejected for r1v29, resolved type: T */
                /* JADX DEBUG: Multi-variable search result rejected for r1v44, resolved type: T */
                /* JADX DEBUG: Multi-variable search result rejected for r1v45, resolved type: T */
                /* JADX DEBUG: Multi-variable search result rejected for r1v48, resolved type: T */
                /* JADX DEBUG: Multi-variable search result rejected for r1v49, resolved type: T */
                /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: T */
                /* JADX WARN: Multi-variable type inference failed */
                public final void invoke(int i2) {
                    boolean z2;
                    DeviceIdBagMap deviceIdBagMap3;
                    SparseArray sparseArray;
                    DeviceIdBagMap deviceIdBagMap4;
                    SparseArray sparseArray2;
                    T t;
                    SparseArray sparseArray3;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                        boolean z3 = true;
                        if ((this.$deviceFlag & i2) != 0) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if ((i2 & 66) == 0) {
                            z3 = false;
                        }
                        if (z2 && z3) {
                            Ref.ObjectRef<DeviceIdBag> objectRef2 = this.$deviceInfo;
                            if (this.$forceApi) {
                                sparseArray3 = DeviceInfoManager.DEVICE_READ_FUNC_MAP;
                                t = (DeviceIdBag) ((Function3) sparseArray3.get(i2)).invoke(this.$context, this.$scene, this.$purpose);
                            } else {
                                deviceIdBagMap4 = DeviceInfoManager.mDeviceInfoMap;
                                DeviceIdBag deviceIdBag = (DeviceIdBag) deviceIdBagMap4.get((Object) Integer.valueOf(i2));
                                DeviceIdBag deviceIdBag2 = deviceIdBag;
                                if (deviceIdBag == null) {
                                    sparseArray2 = DeviceInfoManager.DEVICE_READ_FUNC_MAP;
                                    deviceIdBag2 = (DeviceIdBag) ((Function3) sparseArray2.get(i2)).invoke(this.$context, this.$scene, this.$purpose);
                                }
                                Intrinsics.checkNotNullExpressionValue(deviceIdBag2, "{\n                      …se)\n                    }");
                                t = deviceIdBag2;
                            }
                            objectRef2.element = t;
                            if (this.$useMapping) {
                                DeviceIdBag deviceIdBag3 = this.$deviceInfo.element;
                                if (deviceIdBag3.errorCode != 3 && !TextUtils.isEmpty(deviceIdBag3.deviceId)) {
                                    this.$needSyncDeviceFlag.element |= i2;
                                }
                            }
                            this.$this_apply.put(i2, this.$deviceInfo.element);
                        } else if (z2) {
                            Ref.ObjectRef<DeviceIdBag> objectRef3 = this.$deviceInfo;
                            deviceIdBagMap3 = DeviceInfoManager.mDeviceInfoMap;
                            DeviceIdBag deviceIdBag4 = (DeviceIdBag) deviceIdBagMap3.get((Object) Integer.valueOf(i2));
                            T t2 = deviceIdBag4;
                            if (deviceIdBag4 == null) {
                                sparseArray = DeviceInfoManager.DEVICE_READ_FUNC_MAP;
                                t2 = (DeviceIdBag) ((Function3) sparseArray.get(i2)).invoke(this.$context, this.$scene, this.$purpose);
                            }
                            objectRef3.element = t2;
                            if (this.$useMapping) {
                                DeviceIdBag deviceIdBag5 = this.$deviceInfo.element;
                                if (deviceIdBag5.errorCode != 3 && !TextUtils.isEmpty(deviceIdBag5.deviceId)) {
                                    this.$needSyncDeviceFlag.element |= i2;
                                }
                            }
                            this.$this_apply.put(i2, this.$deviceInfo.element);
                        }
                    }
                }
            });
            int i2 = intRef.element;
            if (i2 != 0) {
                INSTANCE.postSyncTask(i2);
            }
            return deviceIdBagMap2;
        }
        return (DeviceIdBagMap) invokeCommon.objValue;
    }

    public final DeviceIdBag getIMEI(Context context, String scene, String purpose, boolean z) {
        InterceptResult invokeCommon;
        Object systemService;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{context, scene, purpose, Boolean.valueOf(z)})) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(scene, "scene");
            Intrinsics.checkNotNullParameter(purpose, "purpose");
            if (!dk1.g()) {
                IDeviceInfoService iPCService = DeviceInfoIPCServiceManager.Companion.getIPCService();
                if (checkIPCService(iPCService)) {
                    try {
                        Intrinsics.checkNotNull(iPCService);
                        DeviceIdBag imei = iPCService.getIMEI(scene, purpose, z);
                        Intrinsics.checkNotNullExpressionValue(imei, "ipcService!!.getIMEI(scene, purpose, forceApi)");
                        return imei;
                    } catch (Exception unused) {
                    }
                }
                DeviceIdBag deviceIdBag = (DeviceIdBag) mDeviceInfoMap.get((Object) 2);
                if (z || deviceIdBag == null) {
                    return readIMEI(context, scene, purpose);
                }
                return deviceIdBag;
            }
            DeviceIdBag deviceIdBag2 = (DeviceIdBag) mDeviceInfoMap.get((Object) 2);
            int i = 0;
            try {
                systemService = context.getSystemService("phone");
            } catch (Exception unused2) {
            }
            if (systemService != null) {
                i = ((TelephonyManager) systemService).getPhoneType();
                if (z || deviceIdBag2 == null || mPhoneTypeWhenReadIMEI != i) {
                    deviceIdBag2 = readIMEI(context, scene, purpose);
                }
                if (getAppHost().useMapping() && deviceIdBag2.errorCode != 3 && !TextUtils.isEmpty(deviceIdBag2.deviceId)) {
                    postSyncTask(2);
                }
                return deviceIdBag2;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.telephony.TelephonyManager");
        }
        return (DeviceIdBag) invokeCommon.objValue;
    }

    public final DeviceIdBag getOperator(Context context, String scene, String purpose, boolean z) {
        InterceptResult invokeCommon;
        Object systemService;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{context, scene, purpose, Boolean.valueOf(z)})) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(scene, "scene");
            Intrinsics.checkNotNullParameter(purpose, "purpose");
            if (!dk1.g()) {
                IDeviceInfoService iPCService = DeviceInfoIPCServiceManager.Companion.getIPCService();
                if (checkIPCService(iPCService)) {
                    try {
                        Intrinsics.checkNotNull(iPCService);
                        DeviceIdBag operator = iPCService.getOperator(scene, purpose, z);
                        Intrinsics.checkNotNullExpressionValue(operator, "ipcService!!.getOperator(scene, purpose, forceApi)");
                        return operator;
                    } catch (Exception unused) {
                    }
                }
                DeviceIdBag deviceIdBag = (DeviceIdBag) mDeviceInfoMap.get((Object) 64);
                if (z || deviceIdBag == null) {
                    return readOperator(context, scene, purpose);
                }
                return deviceIdBag;
            }
            DeviceIdBag deviceIdBag2 = (DeviceIdBag) mDeviceInfoMap.get((Object) 64);
            int i = 0;
            try {
                systemService = context.getSystemService("phone");
            } catch (Exception unused2) {
            }
            if (systemService != null) {
                i = ((TelephonyManager) systemService).getPhoneType();
                if (z || deviceIdBag2 == null || mPhoneTypeWhenReadOperator != i) {
                    deviceIdBag2 = readOperator(context, scene, purpose);
                }
                if (deviceIdBag2.errorCode == 0) {
                    postSyncTask(64);
                }
                return deviceIdBag2;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.telephony.TelephonyManager");
        }
        return (DeviceIdBag) invokeCommon.objValue;
    }
}
