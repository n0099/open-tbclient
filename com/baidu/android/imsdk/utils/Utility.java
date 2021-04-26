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
import com.baidu.android.imsdk.ChatObjectCache;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.chatmessage.BindStateManager;
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
import com.baidu.webkit.sdk.VideoCloudSetting;
import d.a.r.a;
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
/* loaded from: classes.dex */
public final class Utility {
    public static final String ALGORITHM_NAME = "AES";
    public static final String API_KEY = "BD_IM_API_KEY";
    public static final String APPID = "BD_IM_APPID";
    public static final String TAG = "Utility";
    public static final String TRANSFORMATION = "AES/CBC/PKCS5Padding";
    public static char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public static String mDeviceId;
    public static int mDisableRestapi;

    /* loaded from: classes.dex */
    public interface DeleteItem {
        void deleteItem(Context context, Long l);
    }

    public static boolean availableNotificationPaType(int i2) {
        return 32 <= i2 && 56 >= i2;
    }

    public static String byte2Hex(byte[] bArr) {
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

    public static void clear(Context context) {
        context.getSharedPreferences(Constants.PREF_COMMON_DATA, 0).edit().clear().commit();
    }

    public static boolean clearAccessToken(Context context) {
        return context.getSharedPreferences(Constants.PREF_COMMON_DATA, 0).edit().remove("access_token").commit();
    }

    public static void clearCache(Context context) {
        SyncAllMessage.getInstance(context).reset();
        ChatObjectCache.getInstance().removeAll();
        SyncGroupMessageService.getInstance().clear();
        ConversationManagerImpl.getInstance(context).clear();
        ConversationStudioManImpl.getInstance(context).clear();
    }

    public static void clearExpiredMsg(Context context) {
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

    public static void clearFileCache(Context context) {
        String str;
        if (Environment.getExternalStorageState().equals("mounted")) {
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
        Intent intent = new Intent(Constants.ACTION_METHOD);
        intent.addFlags(32);
        return intent;
    }

    public static Intent creatMethodIntent(Context context, int i2) {
        Intent intent = new Intent(context, a.class);
        intent.putExtra("method", i2);
        intent.putExtra("service_id", 2);
        intent.setPackage(context.getPackageName());
        return intent;
    }

    public static Intent createMcastMethodIntent(Context context, int i2) {
        Intent intent = new Intent(context, a.class);
        intent.putExtra("method", i2);
        intent.putExtra("service_id", 3);
        intent.setPackage(context.getPackageName());
        return intent;
    }

    public static byte[] decrypt(String str, String str2, byte[] bArr) throws Exception {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || bArr == null) {
            return null;
        }
        SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(2, secretKeySpec, new IvParameterSpec(str.getBytes()));
        return cipher.doFinal(bArr);
    }

    public static void delChatRecord(Context context, long j, long j2) {
        Intent creatMethodIntent = creatMethodIntent(context, 57);
        creatMethodIntent.putExtra("contacter", j2);
        creatMethodIntent.putExtra("category", j);
        try {
            a.e(context).d(context, creatMethodIntent);
        } catch (Exception e2) {
            LogUtils.e("Utility", "Exception ", e2);
            new IMTrack.CrashBuilder(context).exception(Log.getStackTraceString(e2)).build();
        }
    }

    public static void deleteFolderFile(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
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
        SharedPreferences.Editor edit = context.getSharedPreferences(Constants.PREF_COMMON_DATA, 0).edit();
        SharedPreferences.Editor remove = edit.remove(Constants.KEY_PUSH_CHANNEL_ID + AccountManager.getUid(context));
        SharedPreferences.Editor remove2 = remove.remove(Constants.KEY_PUSH_USER_ID + AccountManager.getUid(context));
        return remove2.remove(Constants.KEY_PUSH_APP_ID + AccountManager.getUid(context)).commit();
    }

    public static byte[] encrypt(String str, String str2, byte[] bArr) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(1, secretKeySpec, new IvParameterSpec(str.getBytes()));
        return cipher.doFinal(bArr);
    }

    public static String getAccessToken(Context context) {
        return context.getSharedPreferences(Constants.PREF_COMMON_DATA, 0).getString("access_token", "");
    }

    public static String getApiKey(Context context) {
        Object metadata = getMetadata(context, API_KEY);
        return metadata != null ? String.valueOf(metadata) : "";
    }

    public static long getAppId(Context context) {
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

    public static String getAppVersionName(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e2) {
            LogUtils.e(Utils.TAG, "getAppVersionName NameNotFoundException", e2);
            return null;
        }
    }

    public static boolean getBdDnsEnable(Context context) {
        return false;
    }

    public static int getBindPushCUIDStatus(Context context) {
        return context.getSharedPreferences(Constants.PREF_COMMON_DATA, 0).getInt(Constants.KEY_PUSH_BIND_STATUS, -1);
    }

    public static long getBuid(Context context) {
        return readLongData(context, "buid", 0L);
    }

    public static int getBusinessType(int i2, int i3) {
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
            return i2 == 25 ? 20 : 3;
        }
        return 3;
    }

    public static int getClickState(ChatMsg chatMsg) {
        return (chatMsg.getMsgType() != 2 || chatMsg.isClicked()) ? 1 : 0;
    }

    public static String getConfigMsgIds(Context context) {
        return readStringData(context, Constants.KEY_CONFIG_IDS, "");
    }

    public static String getCuidAccessToken(Context context) {
        return readStringData(context, Constants.KEY_CUID_GENERATE_TOKEN, "");
    }

    public static int getCuidAuthority(Context context) {
        return readIntData(context, Constants.KEY_CUID_AUTHORITY, -1);
    }

    public static String getDeviceId(Context context) {
        String str = mDeviceId;
        if (str != null) {
            return str;
        }
        String string = context.getSharedPreferences(Constants.PREF_COMMON_DATA, 0).getString(Constants.KEY_DEVICE_ID, Constants.KEY_DEVICE_ID);
        mDeviceId = string;
        return string;
    }

    public static void getGroupProfile(String str, Context context, long j) {
        Intent creatMethodIntent = creatMethodIntent(context, 61);
        creatMethodIntent.putExtra("group_id", j);
        if (!TextUtils.isEmpty(str)) {
            creatMethodIntent.putExtra(Constants.EXTRA_LISTENER_ID, str);
        }
        try {
            a.e(context).d(context, creatMethodIntent);
        } catch (Exception e2) {
            ListenerManager.getInstance().removeListener(str);
            LogUtils.e("Utility", "Exception ", e2);
            new IMTrack.CrashBuilder(context).exception(Log.getStackTraceString(e2)).build();
        }
    }

    public static String getIMDeviceId(Context context) {
        if (context == null) {
            return "android_";
        }
        return "android_" + getDeviceId(context);
    }

    public static int getIMTrackFailCount(Context context) {
        return readIntData(context, Constants.IM_TRACK_FAIL_COUNT, 1);
    }

    public static long getImTrackDbSize(Context context) {
        File databasePath = context.getDatabasePath(IMTrackDatabase.DB_NAME);
        if (databasePath != null && databasePath.exists() && databasePath.isFile()) {
            LogUtils.d("Utility", "IMTrack db path = " + databasePath.getAbsolutePath());
            return databasePath.length();
        }
        return 0L;
    }

    public static String getJumpToRecentKey(Context context) {
        if (context == null) {
            return "";
        }
        return Constants.KEY_JUMP_TO_RECENT_MSG + AccountManager.getAppid(context) + AccountManager.getUid(context);
    }

    public static long getLastSyncPushTime(Context context) {
        return readLongData(context, Constants.KEY_SYNC_PUSH_TIME, 0L);
    }

    public static String getLocalIp() {
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

    public static String getLoginCFrom(Context context) {
        return context.getSharedPreferences(Constants.PREF_COMMON_DATA, 0).getString(Constants.EXTRA_LOGIN_CFROM, "");
    }

    public static long getLoginCallTime(Context context) {
        return readLongData(context, Constants.KEY_LOGIN_CALL_TIME, 0L);
    }

    public static String getLoginCookie(Context context) {
        return readStringData(context, Constants.KEY_LOGIN_COOKIE, "");
    }

    public static String[] getLoginFlag(Context context) {
        return readStringData(context, Constants.KEY_LOGIN_FLAG, "0:1Y").split(":");
    }

    public static String getLoginFlagExt(Context context) {
        return readStringData(context, Constants.KEY_LOGIN_FLAG_EXT, "");
    }

    public static String getLoginFrom(Context context) {
        return context.getSharedPreferences(Constants.PREF_COMMON_DATA, 0).getString(Constants.EXTRA_LOGIN_FROM, "");
    }

    public static int getLoginOpenType(Context context) {
        return readIntData(context, Constants.KEY_LOGIN_OPEN_TYPE, -1);
    }

    public static int getLoginRole(Context context) {
        return readIntData(context, Constants.KEY_LOGIN_ROLE, 0);
    }

    public static String getMd5(String str) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.update(str.getBytes());
        return byte2Hex(messageDigest.digest());
    }

    public static Object getMetadata(Context context, String str) {
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

    public static int getMsgInfoIndex(JSONArray jSONArray, String str, long j) {
        if (jSONArray != null) {
            try {
                if (jSONArray.length() > 0) {
                    int length = jSONArray.length();
                    for (int i2 = 0; i2 < length; i2++) {
                        JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                        if (optJSONObject != null && optJSONObject.optLong(str) == j) {
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

    public static long getNotifyPaid(Context context) {
        return readLongData(context, Constants.KEY_NOTIFY_PAID, -1L);
    }

    public static long getPaSyncDelay() {
        return 172800000L;
    }

    public static long getPaid(Context context) {
        return readLongData(context, Constants.KEY_CURRENT_PAID, -1L);
    }

    public static int getPeakDelayTime() {
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

    public static String getPushAppId(Context context) {
        return readStringData(context, Constants.KEY_PUSH_APP_ID + AccountManager.getUid(context), null);
    }

    public static String getPushChannelId(Context context) {
        return readStringData(context, Constants.KEY_PUSH_CHANNEL_ID + AccountManager.getUid(context), null);
    }

    public static String getPushUserId(Context context) {
        return readStringData(context, Constants.KEY_PUSH_USER_ID + AccountManager.getUid(context), null);
    }

    public static JSONArray getReliableMaxMsg(Context context) throws JSONException {
        String string = context.getSharedPreferences(Constants.PREF_RELIABLE_MSG_DATA, 0).getString(Constants.RELIABLE_MAX_MSGINFO_KEY, "");
        if (TextUtils.isEmpty(string)) {
            return new JSONArray();
        }
        return new JSONArray(string);
    }

    public static Long getReliableMaxMsgId(Context context, long j) {
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
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        LogUtils.d("Utility", "sp reliableMaxMsg， getReliableMaxMsgId:" + l);
        return l;
    }

    public static boolean getRestApiDisable() {
        return mDisableRestapi != 0;
    }

    public static long getTriggerId(Context context) {
        return readLongData(context, Constants.KEY_TRIGGER_ID, 0L);
    }

    public static long getUK(Context context) {
        return readLongData(context, "uk", 0L);
    }

    public static long getZhidaAppid(Context context) {
        return readLongData(context, Constants.KEY_CURRENT_ZHIDAID, -1L);
    }

    public static boolean isAndroidQAndAbove() {
        return Build.VERSION.SDK_INT >= 29;
    }

    public static boolean isCategoryCorrect(int i2) {
        return i2 > -1 && i2 < 3;
    }

    public static boolean isContacterCorrect(long j) {
        return j >= 0;
    }

    public static boolean isCreateTlsSocket(Context context) {
        return readIntData(context, Constants.KEY_CONN_TYPE, 0) == 0;
    }

    public static boolean isInitiativeDisconnect(Context context) {
        return context.getSharedPreferences(Constants.PREF_COMMON_DATA, 0).getBoolean(Constants.KEY_ISINITIALTIVEDISCONNECT, false);
    }

    public static boolean isIpv4(String str) {
        return (str == null || str.isEmpty() || !str.matches("^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$")) ? false : true;
    }

    public static boolean isIpv4Reachable() {
        try {
            return InetAddress.getByName("180.76.76.76").isReachable(1000);
        } catch (Exception e2) {
            LogUtils.e("Utility", "isIpv4Reachable", e2);
            return true;
        }
    }

    public static boolean isMediaUri(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("content://");
    }

    public static boolean isNeedSync(Context context, String str) {
        long readLongData = readLongData(context, str, -1L);
        return readLongData <= 0 || readLongData <= System.currentTimeMillis();
    }

    public static boolean isNetConnected(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isAvailable();
    }

    public static boolean isPeakTime() {
        try {
            return ((Boolean) Class.forName("com.baidu.searchbox.interfere.NetworkInterfereHelper").getMethod("isPeakTime", new Class[0]).invoke(null, new Object[0])).booleanValue();
        } catch (Throwable unused) {
            LogUtils.e("Utility", "isPeakTime ClassNotFoundException NetworkInterfereHelper...");
            return false;
        }
    }

    public static boolean isStudioHostSendMsg(Context context) {
        return readBooleanData(context, Constants.KEY_STUDIO_IS_HOST_SEND_MSG, false);
    }

    public static boolean isUploadIMInitTrack(Context context) {
        return readIntData(context, Constants.IM_INIT_TRACK_UPLOAD, 0) != 0;
    }

    public static boolean isUploadIMTrack(Context context) {
        return readIntData(context, Constants.IM_TRACK_UPLOAD, 1) == 1;
    }

    public static void logout(Context context, String str) {
        BindStateManager.removeBindPush(context);
        IMSDK.getInstance(context).setUk(0L);
        removeUk(context);
        removeTriggerId(context);
        removeCuid(context);
        AccountManager.clearToken(context, str);
    }

    public static boolean needIMTrack(Context context) {
        long readLongData = readLongData(context, Constants.IM_TRACK_TIME, -1L);
        if (readLongData > 0) {
            return System.currentTimeMillis() - readLongData >= 21600000;
        }
        setIMTrackTime(context);
        return false;
    }

    public static long readAppId(Context context) {
        return readLongData(context, "appid", -1L);
    }

    public static boolean readBooleanData(Context context, String str, boolean z) {
        return context.getSharedPreferences(Constants.PREF_COMMON_DATA, 0).getBoolean(str, z);
    }

    public static String readCuid(Context context) {
        return readStringData(context, Constants.KEY_LOGIN_CUID, null);
    }

    public static int readIntData(Context context, String str, int i2) {
        return context.getSharedPreferences(Constants.PREF_COMMON_DATA, 0).getInt(str, i2);
    }

    public static int readLoginType(Context context) {
        return readIntData(context, "login_type", -1);
    }

    public static long readLongData(Context context, String str, long j) {
        return context.getSharedPreferences(Constants.PREF_COMMON_DATA, 0).getLong(str, j);
    }

    public static int readPrivate(Context context) {
        return readIntData(context, Constants.KEY_ACCOUNT_PRIVATE, 0);
    }

    public static String readStringData(Context context, String str, String str2) {
        return context.getSharedPreferences(Constants.PREF_COMMON_DATA, 0).getString(str, str2);
    }

    public static String readUid(Context context) {
        return readStringData(context, Constants.KEY_PASSPORT_UID, "");
    }

    public static void removeCuid(Context context) {
        removeKey(context, Constants.KEY_LOGIN_CUID);
    }

    public static boolean removeKey(Context context, String str) {
        return context.getSharedPreferences(Constants.PREF_COMMON_DATA, 0).edit().remove(str).commit();
    }

    public static void removeLoginType(Context context) {
        removeKey(context, "login_type");
    }

    public static void removeTriggerId(Context context) {
        removeKey(context, Constants.KEY_TRIGGER_ID);
    }

    public static void removeUk(Context context) {
        removeKey(context, "uk");
    }

    public static boolean savePushCUID(Context context, String str, String str2, String str3) {
        if (TextUtils.isEmpty(AccountManager.getUid(context)) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return false;
        }
        SharedPreferences.Editor edit = context.getSharedPreferences(Constants.PREF_COMMON_DATA, 0).edit();
        SharedPreferences.Editor putString = edit.putString(Constants.KEY_PUSH_CHANNEL_ID + AccountManager.getUid(context), str);
        SharedPreferences.Editor putString2 = putString.putString(Constants.KEY_PUSH_USER_ID + AccountManager.getUid(context), str2);
        return putString2.putString(Constants.KEY_PUSH_APP_ID + AccountManager.getUid(context), str3).commit();
    }

    public static void sendConnectionStateBroadCast(Context context, int i2) {
        try {
            Intent intent = new Intent(IMConstants.LONG_CONNECTION_STATE);
            intent.setPackage(context.getPackageName());
            intent.putExtra("lcs", i2);
            context.sendBroadcast(intent);
        } catch (Exception e2) {
            LogUtils.e("Utility", "Exception ", e2);
        }
    }

    public static void setBdDnsEnable(Context context, int i2) {
        writeIntData(context, Constants.KEY_BDDNS_TYPE, i2);
    }

    public static void setConnType(Context context, int i2) {
        writeIntData(context, Constants.KEY_CONN_TYPE, i2);
    }

    public static boolean setCuidAuthority(Context context, int i2) {
        writeIntData(context, Constants.KEY_CUID_AUTHORITY, i2);
        return true;
    }

    public static void setDeviceId(Context context, String str) {
        mDeviceId = str;
        LogUtils.d("Utility", "set device id as " + str);
        writeStringData(context, Constants.KEY_DEVICE_ID, str);
    }

    public static void setIMTrackFailCount(Context context, int i2) {
        writeIntData(context, Constants.IM_TRACK_FAIL_COUNT, i2);
    }

    public static void setIMTrackTime(Context context) {
        writeLongData(context, Constants.IM_TRACK_TIME, System.currentTimeMillis());
    }

    public static void setInitiativeDisconnect(final Context context, final boolean z) {
        try {
            if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                TaskManager.getInstance(context).submitForNetWork(new Runnable() { // from class: com.baidu.android.imsdk.utils.Utility.1
                    @Override // java.lang.Runnable
                    public void run() {
                        context.getSharedPreferences(Constants.PREF_COMMON_DATA, 0).edit().putBoolean(Constants.KEY_ISINITIALTIVEDISCONNECT, z).commit();
                    }
                });
            } else {
                context.getSharedPreferences(Constants.PREF_COMMON_DATA, 0).edit().putBoolean(Constants.KEY_ISINITIALTIVEDISCONNECT, z).commit();
            }
        } catch (Throwable th) {
            LogUtils.e("Utility", th.getMessage());
        }
    }

    public static void setLastSyncPushTime(Context context, long j) {
        writeLongData(context, Constants.KEY_SYNC_PUSH_TIME, j);
    }

    public static boolean setNotifyPaid(Context context, long j) {
        writeLongData(context, Constants.KEY_NOTIFY_PAID, j);
        return true;
    }

    public static boolean setPaid(Context context, long j) {
        writeLongData(context, Constants.KEY_CURRENT_PAID, j);
        return true;
    }

    public static void setReliableMaxMsg(Context context, JSONObject jSONObject) {
        if (jSONObject != null) {
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
    }

    public static void setStudioHostSendMsg(Context context, boolean z) {
        writeBooleanData(context, Constants.KEY_STUDIO_IS_HOST_SEND_MSG, z);
    }

    public static void setUploadIMInitTrack(Context context, int i2) {
        writeIntData(context, Constants.IM_INIT_TRACK_UPLOAD, i2);
    }

    public static void setUploadIMTrack(Context context, int i2) {
        writeIntData(context, Constants.IM_TRACK_UPLOAD, i2);
    }

    public static boolean setZhidaAppid(Context context, long j) {
        writeLongData(context, Constants.KEY_CURRENT_ZHIDAID, j);
        return true;
    }

    public static void startIMService(Context context) {
        LogUtils.i("Utility", "--- Start IM Service ---");
        try {
            a.e(context).d(context, new Intent(context, a.class));
        } catch (Exception e2) {
            LogUtils.e("Utility", "Exception ", e2);
        }
    }

    public static long sumCacheSize(Context context) {
        File file;
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

    public static long sumFolderSize(File file) {
        long length;
        long j = 0;
        try {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (int i2 = 0; i2 < listFiles.length; i2++) {
                    if (listFiles[i2].isDirectory()) {
                        length = sumFolderSize(listFiles[i2]);
                    } else {
                        length = listFiles[i2].length();
                    }
                    j += length;
                }
            }
        } catch (Exception e2) {
            LogUtils.e("Utility", "Exception ", e2);
        }
        return j;
    }

    public static void sync(Context context, List<Long> list, List<Long> list2, DeleteItem deleteItem) {
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

    public static boolean syncUserProfileTime(Context context, String str, String str2) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - readLongData(context, str + BaseUtils.getMd5(str2), -1L) >= Constants.SYNC_USERS_PROFILE_RANDTIME * VideoCloudSetting.HOUR_MILLISECOND) {
            writeLongData(context, str + BaseUtils.getMd5(str2), currentTimeMillis);
            return true;
        }
        return false;
    }

    public static String transBDUID(String str) {
        try {
            byte[] encrypt = encrypt("2011121211143000", "AFD311832EDEEAEF", str.getBytes());
            return encrypt != null ? android.util.Base64.encodeToString(encrypt, 11) : "";
        } catch (Exception unused) {
            LogUtils.e("Utility", "AES java exception");
            return "";
        }
    }

    public static String transBDUK(String str) {
        try {
            byte[] decode = android.util.Base64.decode(str, 9);
            return decode != null ? new String(decrypt("2011121211143000", "AFD311832EDEEAEF", decode)) : "";
        } catch (Exception unused) {
            LogUtils.e("Utility", "transBDUK AES java exception");
            return "";
        }
    }

    public static void updateBindPushCUIDStatus(Context context, int i2) {
        context.getSharedPreferences(Constants.PREF_COMMON_DATA, 0).edit().putInt(Constants.KEY_PUSH_BIND_STATUS, i2).apply();
    }

    public static boolean writeAccessToken(Context context, String str) {
        writeStringData(context, "access_token", str);
        return true;
    }

    public static void writeAppId(Context context, long j) {
        writeLongData(context, "appid", j);
    }

    public static void writeBooleanData(Context context, String str, boolean z) {
        context.getSharedPreferences(Constants.PREF_COMMON_DATA, 0).edit().putBoolean(str, z).apply();
    }

    public static void writeConfigMsgIds(Context context, String str) {
        writeStringData(context, Constants.KEY_CONFIG_IDS, str);
    }

    public static void writeCuid(Context context, String str) {
        writeStringData(context, Constants.KEY_LOGIN_CUID, str);
    }

    public static void writeCuidAccessToken(Context context, String str) {
        writeStringData(context, Constants.KEY_CUID_GENERATE_TOKEN, str);
    }

    public static void writeIntData(Context context, String str, int i2) {
        context.getSharedPreferences(Constants.PREF_COMMON_DATA, 0).edit().putInt(str, i2).apply();
    }

    public static boolean writeLoginCFrom(Context context, String str) {
        writeStringData(context, Constants.EXTRA_LOGIN_CFROM, str);
        return true;
    }

    public static void writeLoginCallTime(Context context) {
        writeLongData(context, Constants.KEY_LOGIN_CALL_TIME, System.currentTimeMillis());
    }

    public static void writeLoginCookie(Context context, String str) {
        writeStringData(context, Constants.KEY_LOGIN_COOKIE, str);
    }

    public static void writeLoginFlag(final Context context, String str, final String str2) {
        if (isUploadIMTrack(context)) {
            try {
                if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                    TaskManager.getInstance(context).submitForNetWork(new Runnable() { // from class: com.baidu.android.imsdk.utils.Utility.2
                        @Override // java.lang.Runnable
                        public void run() {
                            Utility.writeStringData(context, Constants.KEY_LOGIN_FLAG_EXT, str2);
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
        writeStringData(context, Constants.EXTRA_LOGIN_FROM, str);
        return true;
    }

    public static void writeLoginOpenType(Context context, int i2) {
        writeIntData(context, Constants.KEY_LOGIN_OPEN_TYPE, i2);
    }

    public static void writeLoginRole(Context context, int i2) {
        writeIntData(context, Constants.KEY_LOGIN_ROLE, i2);
    }

    public static void writeLoginType(Context context, int i2) {
        writeIntData(context, "login_type", i2);
    }

    public static void writeLongData(Context context, String str, long j) {
        context.getSharedPreferences(Constants.PREF_COMMON_DATA, 0).edit().putLong(str, j).apply();
    }

    public static void writePrivate(Context context, int i2) {
        writeIntData(context, Constants.KEY_ACCOUNT_PRIVATE, i2);
    }

    public static void writeReliableMaxMsg(Context context, JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return;
        }
        context.getSharedPreferences(Constants.PREF_RELIABLE_MSG_DATA, 0).edit().putString(Constants.RELIABLE_MAX_MSGINFO_KEY, jSONArray.toString()).apply();
    }

    public static void writeRestApiDisable(int i2) {
        mDisableRestapi = i2;
    }

    public static void writeStringData(Context context, String str, String str2) {
        context.getSharedPreferences(Constants.PREF_COMMON_DATA, 0).edit().putString(str, str2).apply();
    }

    public static void writeTriggerId(Context context, long j) {
        writeLongData(context, Constants.KEY_TRIGGER_ID, j);
    }

    public static void writeUK(Context context, long j) {
        writeLongData(context, "uk", j);
    }

    public static void writeUid(Context context, String str) {
        writeStringData(context, Constants.KEY_PASSPORT_UID, str);
    }

    public static void writeVersionCode(Context context, String str) {
        writeStringData(context, Constants.KEY_VCODE, str);
    }

    public static void writeZid(Context context, String str) {
        writeStringData(context, Constants.KEY_ZID, str);
    }
}
