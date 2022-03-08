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
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import c.a.t.a;
import com.baidu.android.imsdk.ChatObjectCache;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.chatmessage.BindStateManager;
import com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.chatmessage.sync.SyncAllMessage;
import com.baidu.android.imsdk.chatmessage.sync.SyncGroupMessageService;
import com.baidu.android.imsdk.conversation.ConversationManagerImpl;
import com.baidu.android.imsdk.conversation.ConversationStudioManImpl;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMSDK;
import com.baidu.android.imsdk.internal.ListenerManager;
import com.baidu.android.imsdk.task.TaskManager;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.upload.action.IMTrackDatabase;
import com.baidu.down.utils.Utils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class Utility {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ALGORITHM_NAME = "AES";
    public static final String API_KEY = "BD_IM_API_KEY";
    public static final String APPID = "BD_IM_APPID";
    public static final String TAG = "Utility";
    public static final String TRANSFORMATION = "AES/CBC/PKCS5Padding";
    public static char[] hexDigits;
    public static String mDeviceId;
    public static int mDisableRestapi;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public interface DeleteItem {
        void deleteItem(Context context, Long l);
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
        hexDigits = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    }

    public Utility() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static boolean availableNotificationPaType(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) ? 32 <= i2 && 56 >= i2 : invokeI.booleanValue;
    }

    public static String byte2Hex(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bArr)) == null) {
            if (bArr == null) {
                return Constants.ERROR_MSG_MD5_NULL;
            }
            StringBuilder sb = new StringBuilder();
            for (byte b2 : bArr) {
                char[] cArr = hexDigits;
                char c2 = cArr[(b2 & 240) >> 4];
                char c3 = cArr[b2 & 15];
                sb.append(c2);
                sb.append(c3);
            }
            return !TextUtils.isEmpty(sb.toString()) ? sb.toString() : Constants.ERROR_MSG_MD5_EMPTY;
        }
        return (String) invokeL.objValue;
    }

    public static void clear(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context) == null) {
            context.getSharedPreferences(Constants.PREF_COMMON_DATA, 0).edit().clear().commit();
        }
    }

    public static boolean clearAccessToken(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) ? context.getSharedPreferences(Constants.PREF_COMMON_DATA, 0).edit().remove("access_token").commit() : invokeL.booleanValue;
    }

    public static void clearCache(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, context) == null) {
            SyncAllMessage.getInstance(context).reset();
            ChatObjectCache.getInstance().removeAll();
            SyncGroupMessageService.getInstance().clear();
            ConversationManagerImpl.getInstance(context).clear();
            ConversationStudioManImpl.getInstance(context).clear();
        }
    }

    public static void clearExpiredMsg(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, context) == null) {
            try {
                JSONArray reliableMaxMsg = getReliableMaxMsg(context);
                if (reliableMaxMsg != null && reliableMaxMsg.length() > 0) {
                    int length = reliableMaxMsg.length();
                    JSONArray jSONArray = new JSONArray();
                    for (int i2 = 0; i2 <= length; i2++) {
                        JSONObject optJSONObject = reliableMaxMsg.optJSONObject(i2);
                        if (optJSONObject != null && System.currentTimeMillis() - optJSONObject.optLong(Constants.RELIABLE_UPDATTIME) < Constants.EXPIRED_TIME.longValue()) {
                            jSONArray.put(optJSONObject);
                        }
                    }
                    LogUtils.d("Utility", "sp reliableMaxMsg，sp 清理后，回写回的msg：" + jSONArray);
                    writeReliableMaxMsg(context, jSONArray);
                    return;
                }
                LogUtils.d("Utility", "sp reliableMaxMsg，sp 清理后，回写回的msg：NULL");
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void clearFileCache(Context context) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65544, null, context) == null) && Environment.getExternalStorageState().equals("mounted")) {
            if (isAndroidQAndAbove()) {
                File externalFilesDir = context.getExternalFilesDir("imcache");
                str = externalFilesDir != null ? externalFilesDir.getAbsolutePath() : null;
            } else {
                str = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "baidu/implugin";
            }
            deleteFolderFile(str, false);
        }
    }

    public static Intent creatEmptyMethodIntent(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) {
            Intent intent = new Intent(Constants.ACTION_METHOD);
            intent.addFlags(32);
            return intent;
        }
        return (Intent) invokeL.objValue;
    }

    public static Intent creatMethodIntent(Context context, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65546, null, context, i2)) == null) {
            Intent intent = new Intent(context, a.class);
            intent.putExtra("method", i2);
            intent.putExtra("service_id", 2);
            intent.setPackage(context.getPackageName());
            return intent;
        }
        return (Intent) invokeLI.objValue;
    }

    public static Intent createMcastMethodIntent(Context context, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65547, null, context, i2)) == null) {
            Intent intent = new Intent(context, a.class);
            intent.putExtra("method", i2);
            intent.putExtra("service_id", 3);
            intent.setPackage(context.getPackageName());
            return intent;
        }
        return (Intent) invokeLI.objValue;
    }

    public static byte[] decrypt(String str, String str2, byte[] bArr) throws Exception {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65548, null, str, str2, bArr)) == null) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || bArr == null) {
                return null;
            }
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(2, secretKeySpec, new IvParameterSpec(str.getBytes()));
            return cipher.doFinal(bArr);
        }
        return (byte[]) invokeLLL.objValue;
    }

    public static void deleteFolderFile(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(65549, null, str, z) == null) || TextUtils.isEmpty(str)) {
            return;
        }
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
        } catch (Exception e2) {
            LogUtils.e("Utility", "Exception ", e2);
        }
    }

    public static boolean deletePushCUID(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, context)) == null) {
            SharedPreferences.Editor edit = context.getSharedPreferences(Constants.PREF_COMMON_DATA, 0).edit();
            SharedPreferences.Editor remove = edit.remove(Constants.KEY_PUSH_CHANNEL_ID + AccountManager.getUid(context));
            SharedPreferences.Editor remove2 = remove.remove(Constants.KEY_PUSH_USER_ID + AccountManager.getUid(context));
            return remove2.remove(Constants.KEY_PUSH_APP_ID + AccountManager.getUid(context)).commit();
        }
        return invokeL.booleanValue;
    }

    public static byte[] encrypt(String str, String str2, byte[] bArr) throws Exception {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65551, null, str, str2, bArr)) == null) {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(1, secretKeySpec, new IvParameterSpec(str.getBytes()));
            return cipher.doFinal(bArr);
        }
        return (byte[]) invokeLLL.objValue;
    }

    public static String getAccessToken(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65552, null, context)) == null) ? context.getSharedPreferences(Constants.PREF_COMMON_DATA, 0).getString("access_token", "") : (String) invokeL.objValue;
    }

    public static String getApiKey(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, context)) == null) {
            Object metadata = getMetadata(context, API_KEY);
            return metadata != null ? String.valueOf(metadata) : "";
        }
        return (String) invokeL.objValue;
    }

    public static long getAppId(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, context)) == null) {
            try {
                Object metadata = getMetadata(context, APPID);
                if (metadata == null) {
                    return -1L;
                }
                return Long.parseLong(metadata.toString());
            } catch (Exception e2) {
                LogUtils.e(LogUtils.TAG, "getAppId:", e2);
                new IMTrack.CrashBuilder(context).exception(Log.getStackTraceString(e2)).build();
                return -1L;
            }
        }
        return invokeL.longValue;
    }

    public static String getAppVersionName(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, context)) == null) {
            try {
                return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            } catch (PackageManager.NameNotFoundException e2) {
                LogUtils.e(Utils.TAG, "getAppVersionName NameNotFoundException", e2);
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public static boolean getBdDnsEnable(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, null, context)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    public static int getBindPushCUIDStatus(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65557, null, context)) == null) ? context.getSharedPreferences(Constants.PREF_COMMON_DATA, 0).getInt(Constants.KEY_PUSH_BIND_STATUS, -1) : invokeL.intValue;
    }

    public static long getBuid(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65558, null, context)) == null) ? readLongData(context, "buid", 0L) : invokeL.longValue;
    }

    public static int getBusinessType(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65559, null, i2, i3)) == null) {
            if (i2 == 7 && i3 == 16) {
                return 4;
            }
            if (i2 == 7 && i3 == 21) {
                return 6;
            }
            if (i2 != 7 || i3 > 0) {
                if (i2 == 17) {
                    return 7;
                }
                if (i2 == 1 || i2 == 5) {
                    return 8;
                }
                if (i2 == 23) {
                    return 9;
                }
                if (i2 == 19 || i2 == 29) {
                    return 10;
                }
                if (i2 == 25) {
                    return 20;
                }
                if (i2 == 0) {
                    return 1;
                }
            }
            return 3;
        }
        return invokeII.intValue;
    }

    public static int getClickState(ChatMsg chatMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65560, null, chatMsg)) == null) ? (chatMsg.getMsgType() != 2 || chatMsg.isClicked()) ? 1 : 0 : invokeL.intValue;
    }

    public static String getConfigMsgIds(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65561, null, context)) == null) ? readStringData(context, Constants.KEY_CONFIG_IDS, "") : (String) invokeL.objValue;
    }

    public static String getCuidAccessToken(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65562, null, context)) == null) ? readStringData(context, Constants.KEY_CUID_GENERATE_TOKEN, "") : (String) invokeL.objValue;
    }

    public static int getCuidAuthority(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65563, null, context)) == null) ? readIntData(context, Constants.KEY_CUID_AUTHORITY, -1) : invokeL.intValue;
    }

    public static String getDeviceId(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65564, null, context)) == null) {
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

    public static void getGroupProfile(String str, Context context, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65565, null, new Object[]{str, context, Long.valueOf(j2)}) == null) {
            Intent creatMethodIntent = creatMethodIntent(context, 61);
            creatMethodIntent.putExtra("group_id", j2);
            if (!TextUtils.isEmpty(str)) {
                creatMethodIntent.putExtra(Constants.EXTRA_LISTENER_ID, str);
            }
            try {
                a.g(context).f(context, creatMethodIntent);
            } catch (Exception e2) {
                ListenerManager.getInstance().removeListener(str);
                LogUtils.e("Utility", "Exception ", e2);
                new IMTrack.CrashBuilder(context).exception(Log.getStackTraceString(e2)).build();
            }
        }
    }

    public static String getIMDeviceId(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65566, null, context)) == null) {
            if (context == null) {
                return "android_";
            }
            return "android_" + getDeviceId(context);
        }
        return (String) invokeL.objValue;
    }

    public static int getIMTrackFailCount(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65567, null, context)) == null) ? readIntData(context, Constants.IM_TRACK_FAIL_COUNT, 1) : invokeL.intValue;
    }

    public static long getImTrackDbSize(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65568, null, context)) == null) {
            File databasePath = context.getDatabasePath(IMTrackDatabase.DB_NAME);
            if (databasePath != null && databasePath.exists() && databasePath.isFile()) {
                LogUtils.d("Utility", "IMTrack db path = " + databasePath.getAbsolutePath());
                return databasePath.length();
            }
            return 0L;
        }
        return invokeL.longValue;
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

    public static long getLastSyncPushTime(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65570, null, context)) == null) ? readLongData(context, Constants.KEY_SYNC_PUSH_TIME, 0L) : invokeL.longValue;
    }

    public static String getLocalIp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65571, null)) == null) {
            try {
                Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
                while (networkInterfaces.hasMoreElements()) {
                    Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                    while (inetAddresses.hasMoreElements()) {
                        InetAddress nextElement = inetAddresses.nextElement();
                        if (!nextElement.isLoopbackAddress()) {
                            return nextElement.getHostAddress().toString();
                        }
                    }
                }
                return "";
            } catch (SocketException e2) {
                LogUtils.e(LogUtils.TAG, e2.toString());
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public static String getLoginCFrom(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65572, null, context)) == null) ? context.getSharedPreferences(Constants.PREF_COMMON_DATA, 0).getString(Constants.EXTRA_LOGIN_CFROM, "") : (String) invokeL.objValue;
    }

    public static long getLoginCallTime(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65573, null, context)) == null) ? readLongData(context, Constants.KEY_LOGIN_CALL_TIME, 0L) : invokeL.longValue;
    }

    public static String getLoginCookie(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65574, null, context)) == null) ? readStringData(context, Constants.KEY_LOGIN_COOKIE, "") : (String) invokeL.objValue;
    }

    public static String[] getLoginFlag(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65575, null, context)) == null) ? readStringData(context, Constants.KEY_LOGIN_FLAG, "0:1Y").split(":") : (String[]) invokeL.objValue;
    }

    public static String getLoginFlagExt(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65576, null, context)) == null) ? readStringData(context, Constants.KEY_LOGIN_FLAG_EXT, "") : (String) invokeL.objValue;
    }

    public static String getLoginFrom(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65577, null, context)) == null) ? context.getSharedPreferences(Constants.PREF_COMMON_DATA, 0).getString(Constants.EXTRA_LOGIN_FROM, "") : (String) invokeL.objValue;
    }

    public static int getLoginOpenType(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65578, null, context)) == null) ? readIntData(context, Constants.KEY_LOGIN_OPEN_TYPE, -1) : invokeL.intValue;
    }

    public static int getLoginRole(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65579, null, context)) == null) ? readIntData(context, Constants.KEY_LOGIN_ROLE, 0) : invokeL.intValue;
    }

    public static long getLongByString(String str, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65580, null, str, j2)) == null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    return Long.parseLong(str);
                }
            } catch (NumberFormatException unused) {
                LogUtils.e("Utility", "getLongByString exception");
            }
            return j2;
        }
        return invokeLJ.longValue;
    }

    public static String getMd5(String str) throws NoSuchAlgorithmException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65581, null, str)) == null) {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            return byte2Hex(messageDigest.digest());
        }
        return (String) invokeL.objValue;
    }

    public static Object getMetadata(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65582, null, context, str)) == null) {
            try {
                ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                if (applicationInfo == null || applicationInfo.metaData == null) {
                    return null;
                }
                return applicationInfo.metaData.get(str);
            } catch (PackageManager.NameNotFoundException e2) {
                LogUtils.e("Utility", "Exception ", e2);
                return null;
            }
        }
        return invokeLL.objValue;
    }

    public static int getMsgInfoIndex(JSONArray jSONArray, String str, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65583, null, new Object[]{jSONArray, str, Long.valueOf(j2)})) == null) {
            if (jSONArray != null) {
                try {
                    if (jSONArray.length() > 0) {
                        int length = jSONArray.length();
                        for (int i2 = 0; i2 < length; i2++) {
                            JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                            if (optJSONObject != null && optJSONObject.optLong(str) == j2) {
                                return i2;
                            }
                        }
                        return -1;
                    }
                    return -1;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return -1;
                }
            }
            return -1;
        }
        return invokeCommon.intValue;
    }

    public static long getNotifyPaid(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65584, null, context)) == null) ? readLongData(context, Constants.KEY_NOTIFY_PAID, -1L) : invokeL.longValue;
    }

    public static long getPaSyncDelay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65585, null)) == null) {
            return 172800000L;
        }
        return invokeV.longValue;
    }

    public static long getPaid(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65586, null, context)) == null) ? readLongData(context, Constants.KEY_CURRENT_PAID, -1L) : invokeL.longValue;
    }

    public static int getPeakDelayTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65587, null)) == null) {
            int i2 = 0;
            try {
                Class<?> cls = Class.forName("com.baidu.searchbox.interfere.NetworkInterfereHelper");
                if (((Boolean) cls.getMethod("isPeakTime", new Class[0]).invoke(null, new Object[0])).booleanValue()) {
                    i2 = ((Integer) cls.getMethod("getDelayTime", new Class[0]).invoke(null, new Object[0])).intValue();
                }
            } catch (Exception unused) {
                LogUtils.e("Utility", "Utility.getPeakDelayTime java.lang.ClassNotFoundException: com.baidu.searchbox.interfere.NetworkInterfereHelper");
            }
            return i2 * 1000;
        }
        return invokeV.intValue;
    }

    public static String getPushAppId(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65588, null, context)) == null) {
            return readStringData(context, Constants.KEY_PUSH_APP_ID + AccountManager.getUid(context), null);
        }
        return (String) invokeL.objValue;
    }

    public static String getPushChannelId(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65589, null, context)) == null) {
            return readStringData(context, Constants.KEY_PUSH_CHANNEL_ID + AccountManager.getUid(context), null);
        }
        return (String) invokeL.objValue;
    }

    public static String getPushUserId(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65590, null, context)) == null) {
            return readStringData(context, Constants.KEY_PUSH_USER_ID + AccountManager.getUid(context), null);
        }
        return (String) invokeL.objValue;
    }

    public static JSONArray getReliableMaxMsg(Context context) throws JSONException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65591, null, context)) == null) {
            String string = context.getSharedPreferences(Constants.PREF_RELIABLE_MSG_DATA, 0).getString(Constants.RELIABLE_MAX_MSGINFO_KEY, "");
            if (TextUtils.isEmpty(string)) {
                return new JSONArray();
            }
            return new JSONArray(string);
        }
        return (JSONArray) invokeL.objValue;
    }

    public static Long getReliableMaxMsgId(Context context, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65592, null, context, j2)) == null) {
            long j3 = 0;
            Long l = 0L;
            try {
                JSONArray reliableMaxMsg = getReliableMaxMsg(context);
                int msgInfoIndex = getMsgInfoIndex(reliableMaxMsg, Constants.RELIABLE_CASTID, j2);
                if (msgInfoIndex >= 0) {
                    JSONObject optJSONObject = reliableMaxMsg.optJSONObject(msgInfoIndex);
                    if (optJSONObject != null) {
                        j3 = optJSONObject.optLong(Constants.RELIABLE_MSGID);
                    }
                    l = Long.valueOf(j3);
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            LogUtils.d("Utility", "sp reliableMaxMsg， getReliableMaxMsgId:" + l);
            return l;
        }
        return (Long) invokeLJ.objValue;
    }

    public static boolean getRestApiDisable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65593, null)) == null) ? mDisableRestapi != 0 : invokeV.booleanValue;
    }

    public static long getTriggerId(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65594, null, context)) == null) ? readLongData(context, Constants.KEY_TRIGGER_ID, 0L) : invokeL.longValue;
    }

    public static long getUK(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65595, null, context)) == null) ? readLongData(context, "uk", 0L) : invokeL.longValue;
    }

    public static long getZhidaAppid(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65596, null, context)) == null) ? readLongData(context, Constants.KEY_CURRENT_ZHIDAID, -1L) : invokeL.longValue;
    }

    public static boolean isAndroidQAndAbove() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65597, null)) == null) ? Build.VERSION.SDK_INT >= 29 : invokeV.booleanValue;
    }

    public static boolean isCategoryCorrect(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65598, null, i2)) == null) ? i2 > -1 && i2 < 3 : invokeI.booleanValue;
    }

    public static boolean isContacterCorrect(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65599, null, j2)) == null) ? j2 >= 0 : invokeJ.booleanValue;
    }

    public static boolean isCreateTlsSocket(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65600, null, context)) == null) ? readIntData(context, Constants.KEY_CONN_TYPE, 0) == 0 : invokeL.booleanValue;
    }

    public static boolean isInitiativeDisconnect(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65601, null, context)) == null) ? context.getSharedPreferences(Constants.PREF_COMMON_DATA, 0).getBoolean(Constants.KEY_ISINITIALTIVEDISCONNECT, false) : invokeL.booleanValue;
    }

    public static boolean isIpv4(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65602, null, str)) == null) ? (str == null || str.isEmpty() || !str.matches("^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$")) ? false : true : invokeL.booleanValue;
    }

    public static boolean isIpv4Reachable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65603, null)) == null) {
            try {
                return InetAddress.getByName("180.76.76.76").isReachable(1000);
            } catch (Exception e2) {
                LogUtils.e("Utility", "isIpv4Reachable", e2);
                return true;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean isMediaUri(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65604, null, str)) == null) ? !TextUtils.isEmpty(str) && str.startsWith("content://") : invokeL.booleanValue;
    }

    public static boolean isNeedSync(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65605, null, context, str)) == null) {
            long readLongData = readLongData(context, str, -1L);
            return readLongData <= 0 || readLongData <= System.currentTimeMillis();
        }
        return invokeLL.booleanValue;
    }

    public static boolean isNetConnected(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65606, null, context)) == null) {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isAvailable();
        }
        return invokeL.booleanValue;
    }

    public static boolean isPeakTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65607, null)) == null) {
            try {
                return ((Boolean) Class.forName("com.baidu.searchbox.interfere.NetworkInterfereHelper").getMethod("isPeakTime", new Class[0]).invoke(null, new Object[0])).booleanValue();
            } catch (Throwable unused) {
                LogUtils.e("Utility", "isPeakTime ClassNotFoundException NetworkInterfereHelper...");
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean isStudioHostSendMsg(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65608, null, context)) == null) ? readBooleanData(context, Constants.KEY_STUDIO_IS_HOST_SEND_MSG, false) : invokeL.booleanValue;
    }

    public static boolean isUploadIMInitTrack(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65609, null, context)) == null) ? readIntData(context, Constants.IM_INIT_TRACK_UPLOAD, 0) != 0 : invokeL.booleanValue;
    }

    public static boolean isUploadIMTrack(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65610, null, context)) == null) ? readIntData(context, Constants.IM_TRACK_UPLOAD, 1) == 1 : invokeL.booleanValue;
    }

    public static void logout(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65611, null, context, str) == null) {
            BindStateManager.removeBindPush(context);
            IMSDK.getInstance(context).setUk(0L);
            removeUk(context);
            removeTriggerId(context);
            removeCuid(context);
            AccountManager.clearToken(context, str);
        }
    }

    public static boolean needIMTrack(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65612, null, context)) == null) {
            long readLongData = readLongData(context, Constants.IM_TRACK_TIME, -1L);
            if (readLongData > 0) {
                return System.currentTimeMillis() - readLongData >= 21600000;
            }
            setIMTrackTime(context);
            return false;
        }
        return invokeL.booleanValue;
    }

    public static long readAppId(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65613, null, context)) == null) ? readLongData(context, "appid", -1L) : invokeL.longValue;
    }

    public static boolean readBooleanData(Context context, String str, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65614, null, context, str, z)) == null) ? context.getSharedPreferences(Constants.PREF_COMMON_DATA, 0).getBoolean(str, z) : invokeLLZ.booleanValue;
    }

    public static String readCuid(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65615, null, context)) == null) ? readStringData(context, Constants.KEY_LOGIN_CUID, null) : (String) invokeL.objValue;
    }

    public static int readIntData(Context context, String str, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLI = interceptable.invokeLLI(65616, null, context, str, i2)) == null) ? context.getSharedPreferences(Constants.PREF_COMMON_DATA, 0).getInt(str, i2) : invokeLLI.intValue;
    }

    public static int readLoginType(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65617, null, context)) == null) ? readIntData(context, "login_type", -1) : invokeL.intValue;
    }

    public static long readLongData(Context context, String str, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65618, null, new Object[]{context, str, Long.valueOf(j2)})) == null) ? context.getSharedPreferences(Constants.PREF_COMMON_DATA, 0).getLong(str, j2) : invokeCommon.longValue;
    }

    public static int readPrivate(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65619, null, context)) == null) ? readIntData(context, Constants.KEY_ACCOUNT_PRIVATE, 0) : invokeL.intValue;
    }

    public static String readStringData(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65620, null, context, str, str2)) == null) ? context.getSharedPreferences(Constants.PREF_COMMON_DATA, 0).getString(str, str2) : (String) invokeLLL.objValue;
    }

    public static String readUid(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65621, null, context)) == null) ? readStringData(context, Constants.KEY_PASSPORT_UID, "") : (String) invokeL.objValue;
    }

    public static void removeCuid(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65622, null, context) == null) {
            removeKey(context, Constants.KEY_LOGIN_CUID);
        }
    }

    public static boolean removeKey(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65623, null, context, str)) == null) ? context.getSharedPreferences(Constants.PREF_COMMON_DATA, 0).edit().remove(str).commit() : invokeLL.booleanValue;
    }

    public static void removeLoginType(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65624, null, context) == null) {
            removeKey(context, "login_type");
        }
    }

    public static void removeTriggerId(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65625, null, context) == null) {
            removeKey(context, Constants.KEY_TRIGGER_ID);
        }
    }

    public static void removeUk(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65626, null, context) == null) {
            removeKey(context, "uk");
        }
    }

    public static boolean savePushCUID(Context context, String str, String str2, String str3) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65627, null, context, str, str2, str3)) == null) {
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

    public static void sendConnectionStateBroadCast(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65628, null, context, i2) == null) {
            try {
                Intent intent = new Intent(IMConstants.LONG_CONNECTION_STATE);
                intent.setPackage(context.getPackageName());
                intent.putExtra("lcs", i2);
                context.sendBroadcast(intent);
            } catch (Exception e2) {
                LogUtils.e("Utility", "Exception ", e2);
            }
        }
    }

    public static void setBdDnsEnable(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65629, null, context, i2) == null) {
            writeIntData(context, Constants.KEY_BDDNS_TYPE, i2);
        }
    }

    public static void setConnType(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65630, null, context, i2) == null) {
            writeIntData(context, Constants.KEY_CONN_TYPE, i2);
        }
    }

    public static boolean setCuidAuthority(Context context, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65631, null, context, i2)) == null) {
            writeIntData(context, Constants.KEY_CUID_AUTHORITY, i2);
            return true;
        }
        return invokeLI.booleanValue;
    }

    public static void setDeviceId(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65632, null, context, str) == null) {
            mDeviceId = str;
            LogUtils.d("Utility", "set device id as " + str);
            writeStringData(context, "device_id", str);
        }
    }

    public static void setIMTrackFailCount(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65633, null, context, i2) == null) {
            writeIntData(context, Constants.IM_TRACK_FAIL_COUNT, i2);
        }
    }

    public static void setIMTrackTime(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65634, null, context) == null) {
            writeLongData(context, Constants.IM_TRACK_TIME, System.currentTimeMillis());
        }
    }

    public static void setInitiativeDisconnect(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65635, null, context, z) == null) {
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
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
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

    public static void setLastSyncPushTime(Context context, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65636, null, context, j2) == null) {
            writeLongData(context, Constants.KEY_SYNC_PUSH_TIME, j2);
        }
    }

    public static boolean setNotifyPaid(Context context, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65637, null, context, j2)) == null) {
            writeLongData(context, Constants.KEY_NOTIFY_PAID, j2);
            return true;
        }
        return invokeLJ.booleanValue;
    }

    public static boolean setPaid(Context context, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65638, null, context, j2)) == null) {
            writeLongData(context, Constants.KEY_CURRENT_PAID, j2);
            return true;
        }
        return invokeLJ.booleanValue;
    }

    public static void setReliableMaxMsg(Context context, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65639, null, context, jSONObject) == null) || jSONObject == null) {
            return;
        }
        try {
            if (jSONObject.length() <= 0) {
                return;
            }
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
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void setStudioHostSendMsg(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65640, null, context, z) == null) {
            writeBooleanData(context, Constants.KEY_STUDIO_IS_HOST_SEND_MSG, z);
        }
    }

    public static void setUploadIMInitTrack(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65641, null, context, i2) == null) {
            writeIntData(context, Constants.IM_INIT_TRACK_UPLOAD, i2);
        }
    }

    public static void setUploadIMTrack(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65642, null, context, i2) == null) {
            writeIntData(context, Constants.IM_TRACK_UPLOAD, i2);
        }
    }

    public static boolean setZhidaAppid(Context context, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65643, null, context, j2)) == null) {
            writeLongData(context, Constants.KEY_CURRENT_ZHIDAID, j2);
            return true;
        }
        return invokeLJ.booleanValue;
    }

    public static void startIMService(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65644, null, context) == null) {
            LogUtils.i("Utility", "--- Start IM Service ---");
            try {
                a.g(context).f(context, new Intent(context, a.class));
            } catch (Exception e2) {
                LogUtils.e("Utility", "Exception ", e2);
            }
        }
    }

    public static long sumCacheSize(Context context) {
        InterceptResult invokeL;
        File file;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65645, null, context)) == null) {
            if (Environment.getExternalStorageState().equals("mounted")) {
                if (isAndroidQAndAbove()) {
                    file = context.getExternalFilesDir("imcache");
                } else {
                    file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "baidu/implugin");
                }
                return sumFolderSize(file);
            }
            return 0L;
        }
        return invokeL.longValue;
    }

    public static long sumFolderSize(File file) {
        InterceptResult invokeL;
        long length;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65646, null, file)) == null) {
            long j2 = 0;
            try {
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    for (int i2 = 0; i2 < listFiles.length; i2++) {
                        if (listFiles[i2].isDirectory()) {
                            length = sumFolderSize(listFiles[i2]);
                        } else {
                            length = listFiles[i2].length();
                        }
                        j2 += length;
                    }
                }
            } catch (Exception e2) {
                LogUtils.e("Utility", "Exception ", e2);
            }
            return j2;
        }
        return invokeL.longValue;
    }

    public static void sync(Context context, List<Long> list, List<Long> list2, DeleteItem deleteItem) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65647, null, context, list, list2, deleteItem) == null) {
            ArrayList<Long> arrayList = new ArrayList();
            if (list == null || list.size() == 0) {
                return;
            }
            Collections.sort(list);
            Collections.sort(list2);
            int i2 = 0;
            int i3 = 0;
            while (i2 < list.size() && i3 < list2.size()) {
                if (list.get(i2).equals(list2.get(i3))) {
                    i2++;
                } else if (list.get(i2).longValue() < list2.get(i3).longValue()) {
                    arrayList.add(list.get(i2));
                    i2++;
                }
                i3++;
            }
            while (i2 < list.size()) {
                arrayList.add(list.get(i2));
                i2++;
            }
            for (Long l : arrayList) {
                deleteItem.deleteItem(context, l);
            }
        }
    }

    public static boolean syncUserProfileTime(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65648, null, context, str, str2)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - readLongData(context, str + BaseUtils.getMd5(str2), -1L) >= Constants.SYNC_USERS_PROFILE_RANDTIME * 3600000) {
                writeLongData(context, str + BaseUtils.getMd5(str2), currentTimeMillis);
                return true;
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public static String transBDUID(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65649, null, str)) == null) {
            try {
                byte[] encrypt = encrypt("2011121211143000", "AFD311832EDEEAEF", str.getBytes());
                return encrypt != null ? android.util.Base64.encodeToString(encrypt, 11) : "";
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65650, null, str)) == null) {
            try {
                byte[] decode = android.util.Base64.decode(str, 9);
                return decode != null ? new String(decrypt("2011121211143000", "AFD311832EDEEAEF", decode)) : "";
            } catch (Exception unused) {
                LogUtils.e("Utility", "transBDUK AES java exception");
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static void transformGroupMediaNotify(Context context, int i2, long j2, int i3, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65651, null, new Object[]{context, Integer.valueOf(i2), Long.valueOf(j2), Integer.valueOf(i3), Long.valueOf(j3)}) == null) {
            LogUtils.d("Utility", "transformGroupMediaNotify category = " + i2 + ", groupId = " + j2 + ", type = " + i3 + ", msgid = " + j3);
            if (AccountManager.getMediaRole(context) && i2 == 1) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("type", i3);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("contacter_type", 2);
                    jSONObject2.put("contacter_bduid", j2);
                    jSONObject2.put("msgid", j3);
                    jSONObject.put("content", jSONObject2);
                    ChatMsgManagerImpl.getInstance(context).handleMediaNotifyMessage(jSONObject);
                } catch (JSONException unused) {
                    LogUtils.e("Utility", "transformGroupMediaNotify exception");
                }
            }
        }
    }

    public static void transformMediaNotify(Context context, int i2, long j2, long j3, String str, int i3, long j4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65652, null, new Object[]{context, Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(j3), str, Integer.valueOf(i3), Long.valueOf(j4)}) == null) {
            LogUtils.d("Utility", "transformMediaNotify businessType = " + i2 + ", bduid = " + j2 + ", paid = " + j3 + ", thirdId = " + str + ", type = " + i3 + ", msgid = " + j4);
            if (AccountManager.getMediaRole(context)) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("type", i3);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("contacter_type", i2);
                    jSONObject2.put("contacter_bduid", j2);
                    jSONObject2.put("contacter_pauid", j3);
                    jSONObject2.put("contacter_third_id", str);
                    jSONObject2.put("msgid", j4);
                    jSONObject.put("content", jSONObject2);
                    ChatMsgManagerImpl.getInstance(context).handleMediaNotifyMessage(jSONObject);
                } catch (JSONException unused) {
                    LogUtils.e("Utility", "transformMediaNotify exception");
                }
            }
        }
    }

    public static void updateBindPushCUIDStatus(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65653, null, context, i2) == null) {
            context.getSharedPreferences(Constants.PREF_COMMON_DATA, 0).edit().putInt(Constants.KEY_PUSH_BIND_STATUS, i2).apply();
        }
    }

    public static boolean writeAccessToken(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65654, null, context, str)) == null) {
            writeStringData(context, "access_token", str);
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static void writeAppId(Context context, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65655, null, context, j2) == null) {
            writeLongData(context, "appid", j2);
        }
    }

    public static void writeBooleanData(Context context, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65656, null, context, str, z) == null) {
            context.getSharedPreferences(Constants.PREF_COMMON_DATA, 0).edit().putBoolean(str, z).apply();
        }
    }

    public static void writeConfigMsgIds(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65657, null, context, str) == null) {
            writeStringData(context, Constants.KEY_CONFIG_IDS, str);
        }
    }

    public static void writeCuid(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65658, null, context, str) == null) {
            writeStringData(context, Constants.KEY_LOGIN_CUID, str);
        }
    }

    public static void writeCuidAccessToken(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65659, null, context, str) == null) {
            writeStringData(context, Constants.KEY_CUID_GENERATE_TOKEN, str);
        }
    }

    public static void writeIntData(Context context, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65660, null, context, str, i2) == null) {
            context.getSharedPreferences(Constants.PREF_COMMON_DATA, 0).edit().putInt(str, i2).apply();
        }
    }

    public static boolean writeLoginCFrom(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65661, null, context, str)) == null) {
            writeStringData(context, Constants.EXTRA_LOGIN_CFROM, str);
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static void writeLoginCallTime(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65662, null, context) == null) {
            writeLongData(context, Constants.KEY_LOGIN_CALL_TIME, System.currentTimeMillis());
        }
    }

    public static void writeLoginCookie(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65663, null, context, str) == null) {
            writeStringData(context, Constants.KEY_LOGIN_COOKIE, str);
        }
    }

    public static void writeLoginFlag(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65664, null, context, str, str2) == null) && isUploadIMTrack(context)) {
            try {
                if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                    TaskManager.getInstance(context).submitForNetWork(new Runnable(context, str2) { // from class: com.baidu.android.imsdk.utils.Utility.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ Context val$context;
                        public final /* synthetic */ String val$ext;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {context, str2};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.val$context = context;
                            this.val$ext = str2;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                Utility.writeStringData(this.val$context, Constants.KEY_LOGIN_FLAG_EXT, this.val$ext);
                            }
                        }
                    });
                } else {
                    writeStringData(context, Constants.KEY_LOGIN_FLAG_EXT, str2);
                }
            } catch (Throwable th) {
                LogUtils.e("Utility", th.getMessage());
            }
        }
    }

    public static boolean writeLoginFrom(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65665, null, context, str)) == null) {
            writeStringData(context, Constants.EXTRA_LOGIN_FROM, str);
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static void writeLoginOpenType(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65666, null, context, i2) == null) {
            writeIntData(context, Constants.KEY_LOGIN_OPEN_TYPE, i2);
        }
    }

    public static void writeLoginRole(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65667, null, context, i2) == null) {
            writeIntData(context, Constants.KEY_LOGIN_ROLE, i2);
        }
    }

    public static void writeLoginType(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65668, null, context, i2) == null) {
            writeIntData(context, "login_type", i2);
        }
    }

    public static void writeLongData(Context context, String str, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65669, null, new Object[]{context, str, Long.valueOf(j2)}) == null) {
            context.getSharedPreferences(Constants.PREF_COMMON_DATA, 0).edit().putLong(str, j2).apply();
        }
    }

    public static void writePrivate(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65670, null, context, i2) == null) {
            writeIntData(context, Constants.KEY_ACCOUNT_PRIVATE, i2);
        }
    }

    public static void writeReliableMaxMsg(Context context, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65671, null, context, jSONArray) == null) || jSONArray == null || jSONArray.length() <= 0) {
            return;
        }
        context.getSharedPreferences(Constants.PREF_RELIABLE_MSG_DATA, 0).edit().putString(Constants.RELIABLE_MAX_MSGINFO_KEY, jSONArray.toString()).apply();
    }

    public static void writeRestApiDisable(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65672, null, i2) == null) {
            mDisableRestapi = i2;
        }
    }

    public static void writeStringData(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65673, null, context, str, str2) == null) {
            context.getSharedPreferences(Constants.PREF_COMMON_DATA, 0).edit().putString(str, str2).apply();
        }
    }

    public static void writeTriggerId(Context context, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65674, null, context, j2) == null) {
            writeLongData(context, Constants.KEY_TRIGGER_ID, j2);
        }
    }

    public static void writeUK(Context context, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65675, null, context, j2) == null) {
            writeLongData(context, "uk", j2);
        }
    }

    public static void writeUid(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65676, null, context, str) == null) {
            writeStringData(context, Constants.KEY_PASSPORT_UID, str);
        }
    }

    public static void writeVersionCode(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65677, null, context, str) == null) {
            writeStringData(context, Constants.KEY_VCODE, str);
        }
    }

    public static void writeZid(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65678, null, context, str) == null) {
            writeStringData(context, Constants.KEY_ZID, str);
        }
    }
}
