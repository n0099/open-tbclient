package com.baidu.android.imsdk.utils;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.os.Looper;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.ChatObjectCache;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.account.AccountManagerImpl;
import com.baidu.android.imsdk.chatmessage.BindStateManager;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.chatmessage.sync.SyncAllMessage;
import com.baidu.android.imsdk.chatmessage.sync.SyncGroupMessageService;
import com.baidu.android.imsdk.conversation.ConversationManagerImpl;
import com.baidu.android.imsdk.conversation.ConversationStudioManImpl;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.ListenerManager;
import com.baidu.android.imsdk.task.TaskManager;
import com.baidu.android.imsdk.ubc.CaseUbc;
import com.baidu.android.imsdk.ubc.ScreenUbc;
import com.baidu.tieba.g70;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.heytap.mcssdk.constant.a;
import com.huawei.hms.common.internal.TransactionIdCreater;
import java.io.File;
import java.net.InetAddress;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class Utility {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ALGORITHM_NAME = "AES";
    public static final String APPID = "BD_IM_APPID";
    public static final String TAG = "Utility";
    public static final String TRANSFORMATION = "AES/CBC/PKCS5Padding";
    public static char[] hexDigits;
    public static String mDeviceId;
    public static int mDisableRestapi;
    public static Map<String, ScreenUbc.MethodInfo> mScreenMethodMap;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public interface DeleteItem {
        void deleteItem(Context context, Long l);
    }

    public static boolean availableNotificationPaType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65541, null, i)) == null) ? 32 <= i && 56 >= i : invokeI.booleanValue;
    }

    public static boolean getBdDnsEnable(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, null, context)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    public static int getBusinessType(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65561, null, i, i2)) == null) {
            if (i == 7 && i2 == 16) {
                return 4;
            }
            if (i == 7 && i2 == 21) {
                return 6;
            }
            if (i != 7 || i2 > 0) {
                if (i == 17) {
                    return 7;
                }
                if (i == 1 || i == 5) {
                    return 8;
                }
                if (i == 23) {
                    return 9;
                }
                if (i == 19 || i == 29) {
                    return 10;
                }
                if (i == 25) {
                    return 20;
                }
                if (i == 26) {
                    return i2 == 30 ? 24 : 22;
                } else if (i == 0) {
                    return 1;
                } else {
                    if (i == 60) {
                        return 29;
                    }
                    if (i == 58) {
                        return 27;
                    }
                    if (i == 32) {
                        return 26;
                    }
                }
            }
            return 3;
        }
        return invokeII.intValue;
    }

    public static String getLocalIp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65571, null)) == null) ? "" : (String) invokeV.objValue;
    }

    public static long getPaSyncDelay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65581, null)) == null) ? a.g : invokeV.longValue;
    }

    public static boolean isCategoryCorrect(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65595, null, i)) == null) ? i > -1 && i < 3 : invokeI.booleanValue;
    }

    public static boolean isContacterCorrect(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65596, null, j)) == null) ? j >= 0 : invokeJ.booleanValue;
    }

    public static boolean isValidAggSession(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65607, null, i, i2)) == null) ? i > 0 && (i2 == 1 || i2 == 2) : invokeII.booleanValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-791926700, "Lcom/baidu/android/imsdk/utils/Utility;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-791926700, "Lcom/baidu/android/imsdk/utils/Utility;");
                return;
            }
        }
        mScreenMethodMap = new HashMap();
        hexDigits = new char[]{TransactionIdCreater.FILL_BYTE, '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    }

    public static boolean isPeakTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65604, null)) == null) {
            try {
                return ((Boolean) Class.forName("com.baidu.searchbox.interfere.NetworkInterfereHelper").getMethod("isPeakTime", new Class[0]).invoke(null, new Object[0])).booleanValue();
            } catch (Throwable unused) {
                LogUtils.e("Utility", "isPeakTime ClassNotFoundException NetworkInterfereHelper...");
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public Utility() {
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

    public static boolean getRestApiDisable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65588, null)) == null) {
            if (mDisableRestapi != 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean isAndroidQAndAbove() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65594, null)) == null) {
            if (Build.VERSION.SDK_INT >= 29) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean isIpv4Reachable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65600, null)) == null) {
            try {
                return InetAddress.getByName("180.76.76.76").isReachable(1000);
            } catch (Exception e) {
                LogUtils.e("Utility", "isIpv4Reachable", e);
                return true;
            }
        }
        return invokeV.booleanValue;
    }

    public static void addEventList(JSONArray jSONArray, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, jSONArray, str) == null) {
            if (jSONArray == null) {
                jSONArray = new JSONArray();
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("timestamp_ms", "" + System.currentTimeMillis());
                jSONObject.put("id", str);
                jSONArray.put(jSONObject);
                LogUtils.d("Utility", "addEventList :" + jSONObject);
            } catch (JSONException unused) {
                LogUtils.e("Utility", "addEventList exception");
            }
        }
    }

    public static void addEventListMs(JSONArray jSONArray, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, jSONArray, str) == null) {
            if (jSONArray == null) {
                jSONArray = new JSONArray();
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("event", str);
                jSONObject.put("timestamp_ms", "" + System.currentTimeMillis());
                jSONArray.put(jSONObject);
            } catch (JSONException unused) {
                LogUtils.e("Utility", "addEventList exception");
            }
        }
    }

    public static void deleteFolderFile(String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(65552, null, str, z) == null) && !TextUtils.isEmpty(str)) {
            try {
                File file = new File(str);
                if (file.isDirectory()) {
                    for (File file2 : file.listFiles()) {
                        deleteFolderFile(file2.getAbsolutePath(), true);
                    }
                }
                if (z) {
                    if (!file.isDirectory()) {
                        file.delete();
                    } else if (file.listFiles().length == 0) {
                        file.delete();
                    }
                }
            } catch (Exception e) {
                LogUtils.e("Utility", "Exception ", e);
            }
        }
    }

    public static Long getReliableMaxMsgId(Context context, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65587, null, context, j)) == null) {
            long j2 = 0;
            Long l = 0L;
            try {
                JSONArray reliableMaxMsg = getReliableMaxMsg(context);
                int msgInfoIndex = getMsgInfoIndex(reliableMaxMsg, Constants.RELIABLE_CASTID, j);
                if (msgInfoIndex >= 0) {
                    JSONObject optJSONObject = reliableMaxMsg.optJSONObject(msgInfoIndex);
                    if (optJSONObject != null) {
                        j2 = optJSONObject.optLong(Constants.RELIABLE_MSGID);
                    }
                    l = Long.valueOf(j2);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            LogUtils.d("Utility", "sp reliableMaxMsg， getReliableMaxMsgId:" + l);
            return l;
        }
        return (Long) invokeLJ.objValue;
    }

    public static void setInitiativeDisconnect(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65630, null, context, z) == null) {
            try {
                if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                    TaskManager.getInstance(context).submitForNetWork(new Runnable(context, z) { // from class: com.baidu.android.imsdk.utils.Utility.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ Context val$context;
                        public final /* synthetic */ boolean val$value;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {context, Boolean.valueOf(z)};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.val$context = context;
                            this.val$value = z;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                this.val$context.getSharedPreferences(Constants.PREF_COMMON_DATA, 0).edit().putBoolean(Constants.KEY_ISINITIALTIVEDISCONNECT, this.val$value).commit();
                            }
                        }
                    });
                } else {
                    context.getSharedPreferences(Constants.PREF_COMMON_DATA, 0).edit().putBoolean(Constants.KEY_ISINITIALTIVEDISCONNECT, z).commit();
                }
            } catch (Throwable th) {
                LogUtils.e("Utility", th.getMessage());
            }
        }
    }

    public static String appendEventList(String str, String str2) {
        InterceptResult invokeLL;
        JSONArray jSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                if (!TextUtils.isEmpty(str)) {
                    jSONArray = new JSONObject(str).optJSONArray("event_list");
                } else {
                    jSONArray = null;
                }
                if (jSONArray == null) {
                    jSONArray = new JSONArray();
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("event", str2);
                jSONObject2.put("timestamp_ms", System.currentTimeMillis());
                jSONArray.put(jSONObject2);
                jSONObject.put("event_list", jSONArray);
            } catch (JSONException e) {
                LogUtils.i("Utility", "appendEventList JSONException:" + e.getMessage());
            }
            return jSONObject.toString();
        }
        return (String) invokeLL.objValue;
    }

    public static String getSeekUpdateMsgValueWithKey(ChatMsg chatMsg, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65590, null, chatMsg, str)) == null) {
            if (chatMsg == null || TextUtils.isEmpty(chatMsg.getMsgContent())) {
                return "";
            }
            try {
                String optString = new JSONObject(new JSONObject(chatMsg.getMsgContent()).optString("text")).optString("msg");
                if (TextUtils.isEmpty(optString)) {
                    return "";
                }
                String optString2 = new JSONObject(optString).optString("ext");
                if (TextUtils.isEmpty(optString2)) {
                    return "";
                }
                return new JSONObject(optString2).optString(str, "");
            } catch (JSONException e) {
                LogUtils.e("Utility", "getMsgTopicSource exception " + e.getMessage());
                return "";
            }
        }
        return (String) invokeLL.objValue;
    }

    public static void setReliableMaxMsg(Context context, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65632, null, context, jSONObject) == null) && jSONObject != null) {
            try {
                if (jSONObject.length() > 0) {
                    Long valueOf = Long.valueOf(jSONObject.optLong(Constants.RELIABLE_CASTID));
                    if (valueOf.longValue() <= 0) {
                        return;
                    }
                    JSONArray reliableMaxMsg = getReliableMaxMsg(context);
                    LogUtils.d("Utility", "sp reliableMaxMsg，get origin from sp msg：" + reliableMaxMsg);
                    int msgInfoIndex = getMsgInfoIndex(reliableMaxMsg, Constants.RELIABLE_CASTID, valueOf.longValue());
                    if (msgInfoIndex >= 0) {
                        JSONObject optJSONObject = reliableMaxMsg.optJSONObject(msgInfoIndex);
                        if (optJSONObject != null && jSONObject.optLong(Constants.RELIABLE_MSGID) > optJSONObject.optLong(Constants.RELIABLE_MSGID)) {
                            reliableMaxMsg.put(msgInfoIndex, jSONObject);
                        }
                    } else {
                        reliableMaxMsg.put(jSONObject);
                    }
                    LogUtils.d("Utility", "sp reliableMaxMsg， write to sp msg：" + reliableMaxMsg);
                    writeReliableMaxMsg(context, reliableMaxMsg);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static String byte2Hex(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, bArr)) == null) {
            if (bArr == null) {
                return Constants.ERROR_MSG_MD5_NULL;
            }
            StringBuilder sb = new StringBuilder();
            for (byte b : bArr) {
                char[] cArr = hexDigits;
                char c = cArr[(b & 240) >> 4];
                char c2 = cArr[b & 15];
                sb.append(c);
                sb.append(c2);
            }
            if (!TextUtils.isEmpty(sb.toString())) {
                return sb.toString();
            }
            return Constants.ERROR_MSG_MD5_EMPTY;
        }
        return (String) invokeL.objValue;
    }

    public static void clearFileCache(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, context) == null) {
            try {
                String str = null;
                if (Environment.getExternalStorageState().equals("mounted")) {
                    if (isAndroidQAndAbove()) {
                        File externalFilesDir = context.getExternalFilesDir("imcache");
                        if (externalFilesDir != null) {
                            str = externalFilesDir.getAbsolutePath();
                        }
                    } else {
                        str = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "baidu/implugin";
                    }
                    deleteFolderFile(str, false);
                }
            } catch (Exception e) {
                LogUtils.e("Utility", "clearFileCache Exception ", e);
            }
        }
    }

    public static long sumCacheSize(Context context) {
        File file;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65637, null, context)) == null) {
            try {
                if (Environment.getExternalStorageState().equals("mounted")) {
                    if (isAndroidQAndAbove()) {
                        file = context.getExternalFilesDir("imcache");
                    } else {
                        file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "baidu/implugin");
                    }
                    return sumFolderSize(file);
                }
                return 0L;
            } catch (Exception e) {
                LogUtils.e("Utility", "sumCacheSize Exception ", e);
                return 0L;
            }
        }
        return invokeL.longValue;
    }

    public static void clear(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, context) == null) {
            context.getSharedPreferences(Constants.PREF_COMMON_DATA, 0).edit().clear().commit();
        }
    }

    public static boolean clearAccessToken(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
            return context.getSharedPreferences(Constants.PREF_COMMON_DATA, 0).edit().remove("access_token").commit();
        }
        return invokeL.booleanValue;
    }

    public static Intent creatEmptyMethodIntent(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, context)) == null) {
            Intent intent = new Intent(Constants.ACTION_METHOD);
            intent.addFlags(32);
            return intent;
        }
        return (Intent) invokeL.objValue;
    }

    public static String getAccessToken(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, context)) == null) {
            return context.getSharedPreferences(Constants.PREF_COMMON_DATA, 0).getString("access_token", "");
        }
        return (String) invokeL.objValue;
    }

    public static long getAppId(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, null, context)) == null) {
            try {
                Object metadata = getMetadata(context, APPID);
                if (metadata == null) {
                    return -1L;
                }
                return Long.parseLong(metadata.toString());
            } catch (Exception e) {
                LogUtils.e(LogUtils.TAG, "getAppId:", e);
                return -1L;
            }
        }
        return invokeL.longValue;
    }

    public static String getAppVersionName(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, context)) == null) {
            try {
                return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            } catch (PackageManager.NameNotFoundException e) {
                LogUtils.e("Utils", "getAppVersionName NameNotFoundException", e);
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public static int getBindPushCUIDStatus(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65559, null, context)) == null) {
            return context.getSharedPreferences(Constants.PREF_COMMON_DATA, 0).getInt(Constants.KEY_PUSH_BIND_STATUS, -1);
        }
        return invokeL.intValue;
    }

    public static long getBuid(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65560, null, context)) == null) {
            return readLongData(context, "buid", 0L);
        }
        return invokeL.longValue;
    }

    public static int getClickState(ChatMsg chatMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65562, null, chatMsg)) == null) {
            if ((chatMsg.getMsgType() == 2 || chatMsg.getMsgType() == 82) && !chatMsg.isClicked()) {
                return 0;
            }
            return 1;
        }
        return invokeL.intValue;
    }

    public static String getConfigMsgIds(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65563, null, context)) == null) {
            return readStringData(context, Constants.KEY_CONFIG_IDS, "");
        }
        return (String) invokeL.objValue;
    }

    public static String getCuidAccessToken(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65564, null, context)) == null) {
            return readStringData(context, Constants.KEY_CUID_GENERATE_TOKEN, "");
        }
        return (String) invokeL.objValue;
    }

    public static int getCuidAuthority(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65565, null, context)) == null) {
            return readIntData(context, Constants.KEY_CUID_AUTHORITY, -1);
        }
        return invokeL.intValue;
    }

    public static String getDeviceId(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65566, null, context)) == null) {
            String str = mDeviceId;
            if (str != null) {
                return str;
            }
            String string = context.getSharedPreferences(Constants.PREF_COMMON_DATA, 0).getString("device_id", "device_id");
            mDeviceId = string;
            return string;
        }
        return (String) invokeL.objValue;
    }

    public static String getIMDeviceId(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65568, null, context)) == null) {
            if (context == null) {
                return "android_";
            }
            return "android_" + getDeviceId(context);
        }
        return (String) invokeL.objValue;
    }

    public static long getLastSyncPushTime(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65570, null, context)) == null) {
            return readLongData(context, Constants.KEY_SYNC_PUSH_TIME, 0L);
        }
        return invokeL.longValue;
    }

    public static String getLoginCFrom(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65572, null, context)) == null) {
            return context.getSharedPreferences(Constants.PREF_COMMON_DATA, 0).getString(Constants.EXTRA_LOGIN_CFROM, "");
        }
        return (String) invokeL.objValue;
    }

    public static String getLoginCookie(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65573, null, context)) == null) {
            return readStringData(context, Constants.KEY_LOGIN_COOKIE, "");
        }
        return (String) invokeL.objValue;
    }

    public static String getLoginFrom(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65574, null, context)) == null) {
            return context.getSharedPreferences(Constants.PREF_COMMON_DATA, 0).getString(Constants.EXTRA_LOGIN_FROM, "");
        }
        return (String) invokeL.objValue;
    }

    public static int getLoginRole(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65575, null, context)) == null) {
            return readIntData(context, Constants.KEY_LOGIN_ROLE, 0);
        }
        return invokeL.intValue;
    }

    public static String getMd5(String str) throws NoSuchAlgorithmException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65577, null, str)) == null) {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            return byte2Hex(messageDigest.digest());
        }
        return (String) invokeL.objValue;
    }

    public static String getPushAppId(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65583, null, context)) == null) {
            return readStringData(context, Constants.KEY_PUSH_APP_ID + AccountManager.getUid(context), null);
        }
        return (String) invokeL.objValue;
    }

    public static String getPushChannelId(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65584, null, context)) == null) {
            return readStringData(context, Constants.KEY_PUSH_CHANNEL_ID + AccountManager.getUid(context), null);
        }
        return (String) invokeL.objValue;
    }

    public static String getPushUserId(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65585, null, context)) == null) {
            return readStringData(context, Constants.KEY_PUSH_USER_ID + AccountManager.getUid(context), null);
        }
        return (String) invokeL.objValue;
    }

    public static ScreenUbc.MethodInfo getScreenMethodInfo(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65589, null, str)) == null) {
            if (mScreenMethodMap.containsKey(str)) {
                return mScreenMethodMap.get(str);
            }
            return new ScreenUbc.MethodInfo();
        }
        return (ScreenUbc.MethodInfo) invokeL.objValue;
    }

    public static String getTplSToken(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65591, null, context)) == null) {
            return readStringData(context, Constants.KEY_STOKEN, "");
        }
        return (String) invokeL.objValue;
    }

    public static long getTriggerId(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65592, null, context)) == null) {
            return readLongData(context, Constants.KEY_TRIGGER_ID, 0L);
        }
        return invokeL.longValue;
    }

    public static long getUK(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65593, null, context)) == null) {
            return readLongData(context, "uk", 0L);
        }
        return invokeL.longValue;
    }

    public static boolean isCreateTlsSocket(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65597, null, context)) == null) {
            if (readIntData(context, Constants.KEY_CONN_TYPE, 0) != 0) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean isInitiativeDisconnect(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65598, null, context)) == null) {
            return context.getSharedPreferences(Constants.PREF_COMMON_DATA, 0).getBoolean(Constants.KEY_ISINITIALTIVEDISCONNECT, false);
        }
        return invokeL.booleanValue;
    }

    public static boolean isIpv4(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65599, null, str)) == null) {
            if (str == null || str.isEmpty() || !str.matches("^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$")) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean isMediaUri(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65601, null, str)) == null) {
            if (!TextUtils.isEmpty(str) && str.startsWith("content://")) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean isNetConnected(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65603, null, context)) == null) {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean isStudioHostSendMsg(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65606, null, context)) == null) {
            return readBooleanData(context, Constants.KEY_STUDIO_IS_HOST_SEND_MSG, false);
        }
        return invokeL.booleanValue;
    }

    public static boolean readAccountMedia(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65609, null, context)) == null) {
            return readBooleanData(context, Constants.KEY_ACCOUNT_MEDIA + AccountManager.getUK(context), false);
        }
        return invokeL.booleanValue;
    }

    public static long readAppId(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65610, null, context)) == null) {
            return readLongData(context, "appid", -1L);
        }
        return invokeL.longValue;
    }

    public static String readCuid(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65612, null, context)) == null) {
            return readStringData(context, Constants.KEY_LOGIN_CUID, null);
        }
        return (String) invokeL.objValue;
    }

    public static int readLoginType(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65614, null, context)) == null) {
            return readIntData(context, "login_type", -1);
        }
        return invokeL.intValue;
    }

    public static int readPrivate(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65616, null, context)) == null) {
            return readIntData(context, Constants.KEY_ACCOUNT_PRIVATE, 0);
        }
        return invokeL.intValue;
    }

    public static String readUid(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65618, null, context)) == null) {
            return readStringData(context, Constants.KEY_PASSPORT_UID, "");
        }
        return (String) invokeL.objValue;
    }

    public static void removeCuid(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65619, null, context) == null) {
            removeKey(context, Constants.KEY_LOGIN_CUID);
        }
    }

    public static void removeLoginType(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65621, null, context) == null) {
            removeKey(context, "login_type");
        }
    }

    public static void removeTriggerId(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65622, null, context) == null) {
            removeKey(context, Constants.KEY_TRIGGER_ID);
        }
    }

    public static void removeUk(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65623, null, context) == null) {
            removeKey(context, "uk");
        }
    }

    public static void startIMService(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65636, null, context) == null) {
            LogUtils.i("Utility", "--- Start IM Service ---");
            try {
                g70.e(context).d(context, new Intent(context, g70.class));
            } catch (Exception e) {
                LogUtils.e("Utility", "Exception ", e);
            }
        }
    }

    public static void writeRestApiDisable(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65661, null, i) == null) {
            mDisableRestapi = i;
        }
    }

    public static void clearCache(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, context) == null) {
            SyncAllMessage.getInstance(context).reset();
            ChatObjectCache.getInstance().removeAll();
            SyncGroupMessageService.getInstance().clear();
            ConversationManagerImpl.getInstance(context).clear();
            ConversationStudioManImpl.getInstance(context).clear();
        }
    }

    public static String getJumpToRecentKey(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65569, null, context)) == null) {
            if (context == null) {
                return "";
            }
            return Constants.KEY_JUMP_TO_RECENT_MSG + AccountManager.getAppid(context) + AccountManager.getUid(context);
        }
        return (String) invokeL.objValue;
    }

    public static JSONArray getReliableMaxMsg(Context context) throws JSONException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65586, null, context)) == null) {
            String string = context.getSharedPreferences(Constants.PREF_RELIABLE_MSG_DATA, 0).getString(Constants.RELIABLE_MAX_MSGINFO_KEY, "");
            if (TextUtils.isEmpty(string)) {
                return new JSONArray();
            }
            return new JSONArray(string);
        }
        return (JSONArray) invokeL.objValue;
    }

    public static long sumFolderSize(File file) {
        InterceptResult invokeL;
        long length;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65638, null, file)) == null) {
            long j = 0;
            try {
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    for (int i = 0; i < listFiles.length; i++) {
                        if (listFiles[i].isDirectory()) {
                            length = sumFolderSize(listFiles[i]);
                        } else {
                            length = listFiles[i].length();
                        }
                        j += length;
                    }
                }
            } catch (Exception e) {
                LogUtils.e("Utility", "Exception ", e);
            }
            return j;
        }
        return invokeL.longValue;
    }

    public static String transBDUID(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65641, null, str)) == null) {
            try {
                byte[] encrypt = encrypt("2011121211143000", "AFD311832EDEEAEF", str.getBytes());
                if (encrypt != null) {
                    return android.util.Base64.encodeToString(encrypt, 11);
                }
                return "";
            } catch (Exception unused) {
                LogUtils.e("Utility", "AES java exception");
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String transBDUK(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65642, null, str)) == null) {
            try {
                byte[] decode = android.util.Base64.decode(str, 9);
                if (decode != null) {
                    return new String(decrypt("2011121211143000", "AFD311832EDEEAEF", decode));
                }
                return "";
            } catch (Exception unused) {
                LogUtils.e("Utility", "transBDUK AES java exception");
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static void clearExpiredMsg(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, context) == null) {
            try {
                JSONArray reliableMaxMsg = getReliableMaxMsg(context);
                if (reliableMaxMsg != null && reliableMaxMsg.length() > 0) {
                    int length = reliableMaxMsg.length();
                    JSONArray jSONArray = new JSONArray();
                    for (int i = 0; i <= length; i++) {
                        JSONObject optJSONObject = reliableMaxMsg.optJSONObject(i);
                        if (optJSONObject != null && System.currentTimeMillis() - optJSONObject.optLong(Constants.RELIABLE_UPDATTIME) < Constants.EXPIRED_TIME.longValue()) {
                            jSONArray.put(optJSONObject);
                        }
                    }
                    LogUtils.d("Utility", "sp reliableMaxMsg，sp 清理后，回写回的msg：" + jSONArray);
                    writeReliableMaxMsg(context, jSONArray);
                    return;
                }
                LogUtils.d("Utility", "sp reliableMaxMsg，sp 清理后，回写回的msg：NULL");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean deletePushCUID(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, context)) == null) {
            SharedPreferences.Editor edit = context.getSharedPreferences(Constants.PREF_COMMON_DATA, 0).edit();
            SharedPreferences.Editor remove = edit.remove(Constants.KEY_PUSH_CHANNEL_ID + AccountManager.getUid(context));
            SharedPreferences.Editor remove2 = remove.remove(Constants.KEY_PUSH_USER_ID + AccountManager.getUid(context));
            return remove2.remove(Constants.KEY_PUSH_APP_ID + AccountManager.getUid(context)).commit();
        }
        return invokeL.booleanValue;
    }

    public static Intent creatMethodIntent(Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65549, null, context, i)) == null) {
            Intent intent = new Intent(context, g70.class);
            intent.putExtra("method", i);
            intent.putExtra("service_id", 2);
            intent.setPackage(context.getPackageName());
            return intent;
        }
        return (Intent) invokeLI.objValue;
    }

    public static Intent createMcastMethodIntent(Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65550, null, context, i)) == null) {
            Intent intent = new Intent(context, g70.class);
            intent.putExtra("method", i);
            intent.putExtra("service_id", 3);
            intent.setPackage(context.getPackageName());
            return intent;
        }
        return (Intent) invokeLI.objValue;
    }

    public static long getLongByString(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65576, null, str, j)) == null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    return Long.parseLong(str);
                }
            } catch (NumberFormatException unused) {
                LogUtils.e("Utility", "getLongByString exception");
            }
            return j;
        }
        return invokeLJ.longValue;
    }

    public static String getNonEmptyString(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65580, null, str, str2)) == null) {
            if (TextUtils.isEmpty(str)) {
                return str2;
            }
            return str;
        }
        return (String) invokeLL.objValue;
    }

    public static boolean isNeedSync(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65602, null, context, str)) == null) {
            long readLongData = readLongData(context, str, -1L);
            if (readLongData > 0 && readLongData > System.currentTimeMillis()) {
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static boolean isScreenStatis(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65605, null, context, str)) == null) {
            if (!TextUtils.isEmpty(str) && AccountManagerImpl.getInstance(context).isScreenStatis()) {
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean removeKey(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65620, null, context, str)) == null) {
            return context.getSharedPreferences(Constants.PREF_COMMON_DATA, 0).edit().remove(str).commit();
        }
        return invokeLL.booleanValue;
    }

    public static void sendConnectionStateBroadCast(Context context, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65625, null, context, i) == null) {
            try {
                Intent intent = new Intent(IMConstants.LONG_CONNECTION_STATE);
                intent.setPackage(context.getPackageName());
                intent.putExtra("lcs", i);
                context.sendBroadcast(intent);
            } catch (Exception e) {
                LogUtils.e("Utility", "Exception ", e);
            }
        }
    }

    public static void setBdDnsEnable(Context context, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65626, null, context, i) == null) {
            writeIntData(context, Constants.KEY_BDDNS_TYPE, i);
        }
    }

    public static void setConnType(Context context, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65627, null, context, i) == null) {
            writeIntData(context, Constants.KEY_CONN_TYPE, i);
        }
    }

    public static boolean setCuidAuthority(Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65628, null, context, i)) == null) {
            writeIntData(context, Constants.KEY_CUID_AUTHORITY, i);
            return true;
        }
        return invokeLI.booleanValue;
    }

    public static void setDeviceId(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65629, null, context, str) == null) {
            mDeviceId = str;
            LogUtils.d("Utility", "set device id as " + str);
            writeStringData(context, "device_id", str);
        }
    }

    public static void setLastSyncPushTime(Context context, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65631, null, context, j) == null) {
            writeLongData(context, Constants.KEY_SYNC_PUSH_TIME, j);
        }
    }

    public static void setScreenMethodInfo(String str, ScreenUbc.MethodInfo methodInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65633, null, str, methodInfo) == null) {
            mScreenMethodMap.put(str, methodInfo);
        }
    }

    public static void setStudioHostSendMsg(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65634, null, context, z) == null) {
            writeBooleanData(context, Constants.KEY_STUDIO_IS_HOST_SEND_MSG, z);
        }
    }

    public static void setTplSToken(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65635, null, context, str) == null) {
            writeStringData(context, Constants.KEY_STOKEN, str);
        }
    }

    public static void updateBindPushCUIDStatus(Context context, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65643, null, context, i) == null) {
            context.getSharedPreferences(Constants.PREF_COMMON_DATA, 0).edit().putInt(Constants.KEY_PUSH_BIND_STATUS, i).apply();
        }
    }

    public static boolean writeAccessToken(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65645, null, context, str)) == null) {
            writeStringData(context, "access_token", str);
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static void writeAccountMedia(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65646, null, context, z) == null) {
            writeBooleanData(context, Constants.KEY_ACCOUNT_MEDIA + AccountManager.getUK(context), z);
        }
    }

    public static void writeAppId(Context context, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65647, null, context, j) == null) {
            writeLongData(context, "appid", j);
        }
    }

    public static void writeConfigMsgIds(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65649, null, context, str) == null) {
            writeStringData(context, Constants.KEY_CONFIG_IDS, str);
        }
    }

    public static void writeCuid(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65650, null, context, str) == null) {
            writeStringData(context, Constants.KEY_LOGIN_CUID, str);
        }
    }

    public static void writeCuidAccessToken(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65651, null, context, str) == null) {
            writeStringData(context, Constants.KEY_CUID_GENERATE_TOKEN, str);
        }
    }

    public static boolean writeLoginCFrom(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65653, null, context, str)) == null) {
            writeStringData(context, Constants.EXTRA_LOGIN_CFROM, str);
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static void writeLoginCookie(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65654, null, context, str) == null) {
            writeStringData(context, Constants.KEY_LOGIN_COOKIE, str);
        }
    }

    public static boolean writeLoginFrom(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65655, null, context, str)) == null) {
            writeStringData(context, Constants.EXTRA_LOGIN_FROM, str);
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static void writeLoginRole(Context context, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65656, null, context, i) == null) {
            writeIntData(context, Constants.KEY_LOGIN_ROLE, i);
        }
    }

    public static void writeLoginType(Context context, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65657, null, context, i) == null) {
            writeIntData(context, "login_type", i);
        }
    }

    public static void writePrivate(Context context, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65659, null, context, i) == null) {
            writeIntData(context, Constants.KEY_ACCOUNT_PRIVATE, i);
        }
    }

    public static void writeReliableMaxMsg(Context context, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65660, null, context, jSONArray) == null) && jSONArray != null && jSONArray.length() > 0) {
            context.getSharedPreferences(Constants.PREF_RELIABLE_MSG_DATA, 0).edit().putString(Constants.RELIABLE_MAX_MSGINFO_KEY, jSONArray.toString()).apply();
        }
    }

    public static void writeTriggerId(Context context, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65663, null, context, j) == null) {
            writeLongData(context, Constants.KEY_TRIGGER_ID, j);
        }
    }

    public static void writeUK(Context context, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65664, null, context, j) == null) {
            writeLongData(context, "uk", j);
        }
    }

    public static void writeUid(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65665, null, context, str) == null) {
            writeStringData(context, Constants.KEY_PASSPORT_UID, str);
        }
    }

    public static void writeVersionCode(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65666, null, context, str) == null) {
            writeStringData(context, Constants.KEY_VCODE, str);
        }
    }

    public static void writeZid(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65667, null, context, str) == null) {
            writeStringData(context, Constants.KEY_ZID, str);
        }
    }

    public static byte[] decrypt(String str, String str2, byte[] bArr) throws Exception {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65551, null, str, str2, bArr)) == null) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && bArr != null) {
                SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), "AES");
                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                cipher.init(2, secretKeySpec, new IvParameterSpec(str.getBytes()));
                return cipher.doFinal(bArr);
            }
            return null;
        }
        return (byte[]) invokeLLL.objValue;
    }

    public static void getGroupProfile(String str, Context context, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65567, null, new Object[]{str, context, Long.valueOf(j)}) == null) {
            Intent creatMethodIntent = creatMethodIntent(context, 61);
            creatMethodIntent.putExtra("group_id", j);
            if (!TextUtils.isEmpty(str)) {
                creatMethodIntent.putExtra(Constants.EXTRA_LISTENER_ID, str);
            }
            try {
                g70.e(context).d(context, creatMethodIntent);
            } catch (Exception e) {
                ListenerManager.getInstance().removeListener(str);
                LogUtils.e("Utility", "Exception ", e);
            }
        }
    }

    public static int getMsgInfoIndex(JSONArray jSONArray, String str, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65579, null, new Object[]{jSONArray, str, Long.valueOf(j)})) == null) {
            if (jSONArray == null) {
                return -1;
            }
            try {
                if (jSONArray.length() <= 0) {
                    return -1;
                }
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    if (optJSONObject != null && optJSONObject.optLong(str) == j) {
                        return i;
                    }
                }
                return -1;
            } catch (Exception e) {
                e.printStackTrace();
                return -1;
            }
        }
        return invokeCommon.intValue;
    }

    public static boolean syncUserProfileTime(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65640, null, context, str, str2)) == null) {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - readLongData(context, str + getMd5(str2), -1L) >= Constants.SYNC_USERS_PROFILE_RANDTIME * 3600000) {
                    writeLongData(context, str + getMd5(str2), currentTimeMillis);
                    return true;
                }
                return false;
            } catch (NoSuchAlgorithmException unused) {
                LogUtils.e("Utility", "syncUserProfileTime NoSuchAlgorithmException");
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }

    public static void uploadClearUkInfo(Context context, long j, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65644, null, new Object[]{context, Long.valueOf(j), str}) == null) {
            CaseUbc.DebugInfo debugInfo = new CaseUbc.DebugInfo();
            debugInfo.curClassName = "uploadClearUkInfo";
            debugInfo.extInfo = "clear uk :" + j;
            debugInfo.extInfo += ", reason : " + str;
            CaseUbc.debugUbc(context, "clear_uk", 0, "", debugInfo);
        }
    }

    public static byte[] encrypt(String str, String str2, byte[] bArr) throws Exception {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65554, null, str, str2, bArr)) == null) {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(1, secretKeySpec, new IvParameterSpec(str.getBytes()));
            return cipher.doFinal(bArr);
        }
        return (byte[]) invokeLLL.objValue;
    }

    public static void logout(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65608, null, context, str, str2) == null) {
            BindStateManager.removeBindPush(context);
            AccountManagerImpl.getInstance(context).setMediaRole(false);
            long uk = AccountManager.getUK(context);
            AccountManager.setUK(context, 0L);
            removeUk(context);
            removeTriggerId(context);
            removeCuid(context);
            AccountManager.clearToken(context, str);
            uploadClearUkInfo(context, uk, str2);
        }
    }

    public static void writeLongData(Context context, String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65658, null, new Object[]{context, str, Long.valueOf(j)}) == null) {
            context.getSharedPreferences(Constants.PREF_COMMON_DATA, 0).edit().putLong(str, j).apply();
        }
    }

    public static Object getMetadata(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65578, null, context, str)) == null) {
            try {
                ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                if (applicationInfo == null || applicationInfo.metaData == null) {
                    return null;
                }
                return applicationInfo.metaData.get(str);
            } catch (PackageManager.NameNotFoundException e) {
                LogUtils.e("Utility", "Exception ", e);
                return null;
            }
        }
        return invokeLL.objValue;
    }

    public static int getPeakDelayTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65582, null)) == null) {
            int i = 0;
            try {
                Class<?> cls = Class.forName("com.baidu.searchbox.interfere.NetworkInterfereHelper");
                if (((Boolean) cls.getMethod("isPeakTime", new Class[0]).invoke(null, new Object[0])).booleanValue()) {
                    i = ((Integer) cls.getMethod("getDelayTime", new Class[0]).invoke(null, new Object[0])).intValue();
                }
            } catch (Exception unused) {
                LogUtils.e("Utility", "Utility.getPeakDelayTime java.lang.ClassNotFoundException: com.baidu.searchbox.interfere.NetworkInterfereHelper");
            }
            return i * 1000;
        }
        return invokeV.intValue;
    }

    public static boolean readBooleanData(Context context, String str, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65611, null, context, str, z)) == null) {
            return context.getSharedPreferences(Constants.PREF_COMMON_DATA, 0).getBoolean(str, z);
        }
        return invokeLLZ.booleanValue;
    }

    public static int readIntData(Context context, String str, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65613, null, context, str, i)) == null) {
            return context.getSharedPreferences(Constants.PREF_COMMON_DATA, 0).getInt(str, i);
        }
        return invokeLLI.intValue;
    }

    public static long readLongData(Context context, String str, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65615, null, new Object[]{context, str, Long.valueOf(j)})) == null) {
            return context.getSharedPreferences(Constants.PREF_COMMON_DATA, 0).getLong(str, j);
        }
        return invokeCommon.longValue;
    }

    public static String readStringData(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65617, null, context, str, str2)) == null) {
            return context.getSharedPreferences(Constants.PREF_COMMON_DATA, 0).getString(str, str2);
        }
        return (String) invokeLLL.objValue;
    }

    public static void writeBooleanData(Context context, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65648, null, context, str, z) == null) {
            context.getSharedPreferences(Constants.PREF_COMMON_DATA, 0).edit().putBoolean(str, z).apply();
        }
    }

    public static void writeIntData(Context context, String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65652, null, context, str, i) == null) {
            context.getSharedPreferences(Constants.PREF_COMMON_DATA, 0).edit().putInt(str, i).apply();
        }
    }

    public static void writeStringData(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65662, null, context, str, str2) == null) {
            context.getSharedPreferences(Constants.PREF_COMMON_DATA, 0).edit().putString(str, str2).apply();
        }
    }

    public static boolean savePushCUID(Context context, String str, String str2, String str3) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65624, null, context, str, str2, str3)) == null) {
            if (TextUtils.isEmpty(AccountManager.getUid(context)) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
                return false;
            }
            SharedPreferences.Editor edit = context.getSharedPreferences(Constants.PREF_COMMON_DATA, 0).edit();
            SharedPreferences.Editor putString = edit.putString(Constants.KEY_PUSH_CHANNEL_ID + AccountManager.getUid(context), str);
            SharedPreferences.Editor putString2 = putString.putString(Constants.KEY_PUSH_USER_ID + AccountManager.getUid(context), str2);
            return putString2.putString(Constants.KEY_PUSH_APP_ID + AccountManager.getUid(context), str3).commit();
        }
        return invokeLLLL.booleanValue;
    }

    public static void sync(Context context, List<Long> list, List<Long> list2, DeleteItem deleteItem) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65639, null, context, list, list2, deleteItem) == null) {
            ArrayList<Long> arrayList = new ArrayList();
            if (list != null && list.size() != 0) {
                Collections.sort(list);
                Collections.sort(list2);
                int i = 0;
                int i2 = 0;
                while (i < list.size() && i2 < list2.size()) {
                    if (list.get(i).equals(list2.get(i2))) {
                        i++;
                    } else if (list.get(i).longValue() < list2.get(i2).longValue()) {
                        arrayList.add(list.get(i));
                        i++;
                    }
                    i2++;
                }
                while (i < list.size()) {
                    arrayList.add(list.get(i));
                    i++;
                }
                for (Long l : arrayList) {
                    deleteItem.deleteItem(context, l);
                }
            }
        }
    }
}
