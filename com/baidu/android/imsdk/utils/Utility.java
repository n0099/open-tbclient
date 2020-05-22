package com.baidu.android.imsdk.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.os.Looper;
import android.support.v4.app.ActivityCompat;
import android.telephony.TelephonyManager;
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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMSDK;
import com.baidu.android.imsdk.internal.ListenerManager;
import com.baidu.android.imsdk.task.TaskManager;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.imsdk.IMService;
import com.baidu.live.adp.lib.cache.BdKVCache;
import java.io.File;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes3.dex */
public final class Utility {
    private static final String ALGORITHM_NAME = "AES";
    private static final String API_KEY = "BD_IM_API_KEY";
    private static final String APPID = "BD_IM_APPID";
    private static final String TAG = "Utility";
    private static final String TRANSFORMATION = "AES/CBC/PKCS5Padding";
    private static String mDeviceId = null;
    private static int mDisableRestapi = 0;
    private static char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* loaded from: classes3.dex */
    public interface DeleteItem {
        void deleteItem(Context context, Long l);
    }

    public static boolean syncUserProfileTime(Context context, String str, String str2) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - readLongData(context, str + BaseUtils.getMd5(str2), -1L) >= BdKVCache.MILLS_1Hour * Constants.SYNC_USERS_PROFILE_RANDTIME) {
            return writeLongData(context, str + BaseUtils.getMd5(str2), currentTimeMillis);
        }
        return false;
    }

    public static boolean isPeakTime() {
        try {
            return ((Boolean) Class.forName("com.baidu.searchbox.interfere.NetworkInterfereHelper").getMethod("isPeakTime", new Class[0]).invoke(null, new Object[0])).booleanValue();
        } catch (Throwable th) {
            LogUtils.e(TAG, "isPeakTime ClassNotFoundException NetworkInterfereHelper...");
            return false;
        }
    }

    public static int getPeakDelayTime() {
        int i;
        Class<?> cls;
        try {
            cls = Class.forName("com.baidu.searchbox.interfere.NetworkInterfereHelper");
        } catch (Exception e) {
            LogUtils.e(TAG, "Utility.getPeakDelayTime java.lang.ClassNotFoundException: com.baidu.searchbox.interfere.NetworkInterfereHelper");
        }
        if (((Boolean) cls.getMethod("isPeakTime", new Class[0]).invoke(null, new Object[0])).booleanValue()) {
            i = ((Integer) cls.getMethod("getDelayTime", new Class[0]).invoke(null, new Object[0])).intValue();
            return i * 1000;
        }
        i = 0;
        return i * 1000;
    }

    public static void setIMTrackTime(Context context) {
        writeLongData(context, Constants.IM_TRACK_TIME, System.currentTimeMillis());
    }

    public static boolean needIMTrack(Context context) {
        long readLongData = readLongData(context, Constants.IM_TRACK_TIME, -1L);
        if (readLongData > 0) {
            return System.currentTimeMillis() - readLongData >= 21600000;
        }
        setIMTrackTime(context);
        return false;
    }

    public static void setIMTrackFailCount(Context context, int i) {
        writeIntData(context, Constants.IM_TRACK_FAIL_COUNT, i);
    }

    public static int getIMTrackFailCount(Context context) {
        return readIntData(context, Constants.IM_TRACK_FAIL_COUNT, 1);
    }

    public static void setUploadIMTrack(Context context, int i) {
        writeIntData(context, Constants.IM_TRACK_UPLOAD, i);
    }

    public static boolean isUploadIMTrack(Context context) {
        return readIntData(context, Constants.IM_TRACK_UPLOAD, 1) == 1;
    }

    public static void setUploadIMInitTrack(Context context, int i) {
        writeIntData(context, Constants.IM_INIT_TRACK_UPLOAD, i);
    }

    public static boolean isUploadIMInitTrack(Context context) {
        return readIntData(context, Constants.IM_INIT_TRACK_UPLOAD, 0) != 0;
    }

    public static boolean setCuidAuthority(Context context, int i) {
        return writeIntData(context, Constants.KEY_CUID_AUTHORITY, i);
    }

    public static int getCuidAuthority(Context context) {
        return readIntData(context, Constants.KEY_CUID_AUTHORITY, -1);
    }

    public static boolean setZhidaAppid(Context context, long j) {
        return writeLongData(context, Constants.KEY_CURRENT_ZHIDAID, j);
    }

    public static long getZhidaAppid(Context context) {
        return readLongData(context, Constants.KEY_CURRENT_ZHIDAID, -1L);
    }

    public static long getPaid(Context context) {
        return readLongData(context, Constants.KEY_CURRENT_PAID, -1L);
    }

    public static boolean setPaid(Context context, long j) {
        return writeLongData(context, Constants.KEY_CURRENT_PAID, j);
    }

    public static boolean setNotifyPaid(Context context, long j) {
        return writeLongData(context, Constants.KEY_NOTIFY_PAID, j);
    }

    public static long getNotifyPaid(Context context) {
        return readLongData(context, Constants.KEY_NOTIFY_PAID, -1L);
    }

    public static boolean clearAccessToken(Context context) {
        return context.getSharedPreferences(Constants.PREF_COMMON_DATA, 0).edit().remove("access_token").commit();
    }

    public static boolean writeAccessToken(Context context, String str) {
        return writeStringData(context, "access_token", str);
    }

    public static boolean writeLoginFrom(Context context, String str) {
        return writeStringData(context, Constants.EXTRA_LOGIN_FROM, str);
    }

    public static boolean writeLoginCFrom(Context context, String str) {
        return writeStringData(context, Constants.EXTRA_LOGIN_CFROM, str);
    }

    public static boolean writeStringData(Context context, String str, String str2) {
        return context.getSharedPreferences(Constants.PREF_COMMON_DATA, 0).edit().putString(str, str2).commit();
    }

    public static void clear(Context context) {
        context.getSharedPreferences(Constants.PREF_COMMON_DATA, 0).edit().clear().commit();
    }

    public static String getAccessToken(Context context) {
        return context.getSharedPreferences(Constants.PREF_COMMON_DATA, 0).getString("access_token", "");
    }

    public static String getLoginFrom(Context context) {
        return context.getSharedPreferences(Constants.PREF_COMMON_DATA, 0).getString(Constants.EXTRA_LOGIN_FROM, "");
    }

    public static String getLoginCFrom(Context context) {
        return context.getSharedPreferences(Constants.PREF_COMMON_DATA, 0).getString(Constants.EXTRA_LOGIN_CFROM, "");
    }

    public static void writeUK(Context context, long j) {
        writeLongData(context, "uk", j);
    }

    public static boolean writeLongData(Context context, String str, long j) {
        return context.getSharedPreferences(Constants.PREF_COMMON_DATA, 0).edit().putLong(str, j).commit();
    }

    public static boolean writeIntData(Context context, String str, int i) {
        return context.getSharedPreferences(Constants.PREF_COMMON_DATA, 0).edit().putInt(str, i).commit();
    }

    public static void writeBooleanData(Context context, String str, boolean z) {
        context.getSharedPreferences(Constants.PREF_COMMON_DATA, 0).edit().putBoolean(str, z).apply();
    }

    public static void writeUid(Context context, String str) {
        writeStringData(context, Constants.KEY_PASSPORT_UID, str);
    }

    public static void writeLoginType(Context context, int i) {
        writeIntData(context, Constants.KEY_LOGIN_TYPE, i);
    }

    public static int readLoginType(Context context) {
        return readIntData(context, Constants.KEY_LOGIN_TYPE, -1);
    }

    public static void writeCuid(Context context, String str) {
        writeStringData(context, Constants.KEY_LOGIN_CUID, str);
    }

    public static void writeConfigMsgIds(Context context, String str) {
        writeStringData(context, Constants.KEY_CONFIG_IDS, str);
    }

    public static String getConfigMsgIds(Context context) {
        return readStringData(context, Constants.KEY_CONFIG_IDS, "");
    }

    public static String readCuid(Context context) {
        return readStringData(context, Constants.KEY_LOGIN_CUID, null);
    }

    public static void removeCuid(Context context) {
        removeKey(context, Constants.KEY_LOGIN_CUID);
    }

    public static void removeLoginType(Context context) {
        removeKey(context, Constants.KEY_LOGIN_TYPE);
    }

    public static void writeAppId(Context context, long j) {
        writeLongData(context, "appid", j);
    }

    public static long readAppId(Context context) {
        return readLongData(context, "appid", -1L);
    }

    public static void writeZid(Context context, String str) {
        writeStringData(context, Constants.KEY_ZID, str);
    }

    public static void writeVersionCode(Context context, String str) {
        writeStringData(context, Constants.KEY_VCODE, str);
    }

    public static String readUid(Context context) {
        return readStringData(context, Constants.KEY_PASSPORT_UID, "");
    }

    public static String readStringData(Context context, String str, String str2) {
        return context.getSharedPreferences(Constants.PREF_COMMON_DATA, 0).getString(str, str2);
    }

    public static long readLongData(Context context, String str, long j) {
        return context.getSharedPreferences(Constants.PREF_COMMON_DATA, 0).getLong(str, j);
    }

    public static int readIntData(Context context, String str, int i) {
        return context.getSharedPreferences(Constants.PREF_COMMON_DATA, 0).getInt(str, i);
    }

    public static boolean readBooleanData(Context context, String str, boolean z) {
        return context.getSharedPreferences(Constants.PREF_COMMON_DATA, 0).getBoolean(str, z);
    }

    public static long getLastSyncPushTime(Context context) {
        return readLongData(context, Constants.KEY_SYNC_PUSH_TIME, 0L);
    }

    public static void setLastSyncPushTime(Context context, long j) {
        writeLongData(context, Constants.KEY_SYNC_PUSH_TIME, j);
    }

    public static long getUK(Context context) {
        return readLongData(context, "uk", 0L);
    }

    public static long getBuid(Context context) {
        return readLongData(context, "buid", 0L);
    }

    public static void writeTriggerId(Context context, long j) {
        writeLongData(context, Constants.KEY_TRIGGER_ID, j);
    }

    public static long getTriggerId(Context context) {
        return readLongData(context, Constants.KEY_TRIGGER_ID, 0L);
    }

    public static void removeTriggerId(Context context) {
        removeKey(context, Constants.KEY_TRIGGER_ID);
    }

    public static void removeUk(Context context) {
        removeKey(context, "uk");
    }

    public static boolean removeKey(Context context, String str) {
        return context.getSharedPreferences(Constants.PREF_COMMON_DATA, 0).edit().remove(str).commit();
    }

    public static boolean isInitiativeDisconnect(Context context) {
        return context.getSharedPreferences(Constants.PREF_COMMON_DATA, 0).getBoolean(Constants.KEY_ISINITIALTIVEDISCONNECT, false);
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
            LogUtils.e(TAG, th.getMessage());
        }
    }

    public static void startIMService(Context context) {
        LogUtils.i(TAG, "--- Start IM Service ---");
        try {
            IMService.enqueueWork(context, new Intent(context, IMService.class));
        } catch (Exception e) {
            LogUtils.e(TAG, "Exception ", e);
        }
    }

    public static Intent creatEmptyMethodIntent(Context context) {
        Intent intent = new Intent(Constants.ACTION_METHOD);
        intent.addFlags(32);
        return intent;
    }

    public static Intent creatMethodIntent(Context context, int i) {
        Intent intent = new Intent(context, IMService.class);
        intent.putExtra("method", i);
        intent.putExtra(Constants.EXTRA_SERVICE, 2);
        intent.setPackage(context.getPackageName());
        return intent;
    }

    public static Intent createMcastMethodIntent(Context context, int i) {
        Intent intent = new Intent(context, IMService.class);
        intent.putExtra("method", i);
        intent.putExtra(Constants.EXTRA_SERVICE, 3);
        intent.setPackage(context.getPackageName());
        return intent;
    }

    public static void delChatRecord(Context context, long j, long j2) {
        Intent creatMethodIntent = creatMethodIntent(context, 57);
        creatMethodIntent.putExtra("contacter", j2);
        creatMethodIntent.putExtra("category", j);
        try {
            IMService.enqueueWork(context, creatMethodIntent);
        } catch (Exception e) {
            LogUtils.e(TAG, "Exception ", e);
            new IMTrack.CrashBuilder(context).exception(Log.getStackTraceString(e)).build();
        }
    }

    public static long getAppId(Context context) {
        try {
            Object metadata = getMetadata(context, APPID);
            if (metadata == null) {
                return -1L;
            }
            return Long.parseLong(metadata.toString());
        } catch (Exception e) {
            LogUtils.e(LogUtils.TAG, "getAppId:", e);
            new IMTrack.CrashBuilder(context).exception(Log.getStackTraceString(e)).build();
            return -1L;
        }
    }

    public static String getIMDeviceId(Context context) {
        return context == null ? "android_" : "android_" + getDeviceId(context);
    }

    public static String getDeviceId(Context context) {
        if (mDeviceId != null) {
            return mDeviceId;
        }
        mDeviceId = context.getSharedPreferences(Constants.PREF_COMMON_DATA, 0).getString("device_id", "device_id");
        return mDeviceId;
    }

    public static void setDeviceId(Context context, String str) {
        mDeviceId = str;
        LogUtils.d(TAG, "set device id as " + str);
        writeStringData(context, "device_id", str);
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
        } catch (SocketException e) {
            LogUtils.e(LogUtils.TAG, e.toString());
        }
        return "";
    }

    public static String getApiKey(Context context) {
        Object metadata = getMetadata(context, API_KEY);
        return metadata != null ? String.valueOf(metadata) : "";
    }

    private static Object getMetadata(Context context, String str) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null || applicationInfo.metaData == null) {
                return null;
            }
            return applicationInfo.metaData.get(str);
        } catch (PackageManager.NameNotFoundException e) {
            LogUtils.e(TAG, "Exception ", e);
            return null;
        }
    }

    public static void getGroupProfile(String str, Context context, long j) {
        Intent creatMethodIntent = creatMethodIntent(context, 61);
        creatMethodIntent.putExtra("group_id", j);
        if (!TextUtils.isEmpty(str)) {
            creatMethodIntent.putExtra(Constants.EXTRA_LISTENER_ID, str);
        }
        try {
            IMService.enqueueWork(context, creatMethodIntent);
        } catch (Exception e) {
            ListenerManager.getInstance().removeListener(str);
            LogUtils.e(TAG, "Exception ", e);
            new IMTrack.CrashBuilder(context).exception(Log.getStackTraceString(e)).build();
        }
    }

    public static void logout(Context context, String str) {
        BindStateManager.removeBindPush(context);
        IMSDK.getInstance(context).setUk(0L);
        removeUk(context);
        removeTriggerId(context);
        removeCuid(context);
        AccountManager.clearToken(context, str);
    }

    public static boolean isCategoryCorrect(int i) {
        return i > -1 && i < 3;
    }

    public static boolean isContacterCorrect(long j) {
        return j >= 0;
    }

    public static boolean isNetConnected(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isAvailable();
    }

    public static void sync(Context context, List<Long> list, List<Long> list2, DeleteItem deleteItem) {
        ArrayList<Long> arrayList = new ArrayList();
        if (list != null && list.size() != 0) {
            Collections.sort(list);
            Collections.sort(list2);
            int i = 0;
            int i2 = 0;
            while (i2 < list.size() && i < list2.size()) {
                if (list.get(i2).equals(list2.get(i))) {
                    i2++;
                    i++;
                } else if (list.get(i2).longValue() < list2.get(i).longValue()) {
                    arrayList.add(list.get(i2));
                    i2++;
                } else {
                    i++;
                }
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

    public static boolean savePushCUID(Context context, String str, String str2, String str3) {
        if (TextUtils.isEmpty(AccountManager.getUid(context)) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return false;
        }
        return context.getSharedPreferences(Constants.PREF_COMMON_DATA, 0).edit().putString(Constants.KEY_PUSH_CHANNEL_ID + AccountManager.getUid(context), str).putString(Constants.KEY_PUSH_USER_ID + AccountManager.getUid(context), str2).putString(Constants.KEY_PUSH_APP_ID + AccountManager.getUid(context), str3).commit();
    }

    public static boolean deletePushCUID(Context context) {
        return context.getSharedPreferences(Constants.PREF_COMMON_DATA, 0).edit().remove(Constants.KEY_PUSH_CHANNEL_ID + AccountManager.getUid(context)).remove(Constants.KEY_PUSH_USER_ID + AccountManager.getUid(context)).remove(Constants.KEY_PUSH_APP_ID + AccountManager.getUid(context)).commit();
    }

    public static String getPushChannelId(Context context) {
        return readStringData(context, Constants.KEY_PUSH_CHANNEL_ID + AccountManager.getUid(context), null);
    }

    public static String getPushUserId(Context context) {
        return readStringData(context, Constants.KEY_PUSH_USER_ID + AccountManager.getUid(context), null);
    }

    public static String getPushAppId(Context context) {
        return readStringData(context, Constants.KEY_PUSH_APP_ID + AccountManager.getUid(context), null);
    }

    public static boolean updateBindPushCUIDStatus(Context context, int i) {
        return context.getSharedPreferences(Constants.PREF_COMMON_DATA, 0).edit().putInt(Constants.KEY_PUSH_BIND_STATUS, i).commit();
    }

    public static int getBindPushCUIDStatus(Context context) {
        return context.getSharedPreferences(Constants.PREF_COMMON_DATA, 0).getInt(Constants.KEY_PUSH_BIND_STATUS, -1);
    }

    public static int getClickState(ChatMsg chatMsg) {
        if (chatMsg.getMsgType() != 2 || chatMsg.isClicked()) {
            return 1;
        }
        return 0;
    }

    public static void clearCache(Context context) {
        SyncAllMessage.getInstance(context).reset();
        ChatObjectCache.getInstance().removeAll();
        SyncGroupMessageService.getInstance().clear();
        ConversationManagerImpl.getInstance(context).clear();
    }

    public static long getPaSyncDelay() {
        return 172800000L;
    }

    public static boolean isNeedSync(Context context, String str) {
        long readLongData = readLongData(context, str, -1L);
        return readLongData <= 0 || readLongData <= System.currentTimeMillis();
    }

    public static String getJumpToRecentKey(Context context) {
        return context == null ? "" : Constants.KEY_JUMP_TO_RECENT_MSG + AccountManager.getAppid(context) + AccountManager.getUid(context);
    }

    public static String byte2Hex(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            char c = hexDigits[(b & 240) >> 4];
            char c2 = hexDigits[b & 15];
            sb.append(c);
            sb.append(c2);
        }
        return sb.toString();
    }

    public static void sendConnectionStateBroadCast(Context context, int i) {
        try {
            Intent intent = new Intent(IMConstants.LONG_CONNECTION_STATE);
            intent.setPackage(context.getPackageName());
            intent.putExtra("lcs", i);
            context.sendBroadcast(intent);
        } catch (Exception e) {
            LogUtils.e(TAG, "Exception ", e);
        }
    }

    public static void writePrivate(Context context, int i) {
        writeIntData(context, Constants.KEY_ACCOUNT_PRIVATE, i);
    }

    public static int readPrivate(Context context) {
        return readIntData(context, Constants.KEY_ACCOUNT_PRIVATE, 0);
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

    private static long sumFolderSize(File file) {
        long length;
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
            LogUtils.e(TAG, "Exception ", e);
        }
        return j;
    }

    public static void clearFileCache(Context context) {
        String str;
        if (Environment.getExternalStorageState().equals("mounted")) {
            if (isAndroidQAndAbove()) {
                str = context.getExternalFilesDir("imcache").getAbsolutePath();
            } else {
                str = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "baidu/implugin";
            }
            deleteFolderFile(str, false);
        }
    }

    private static void deleteFolderFile(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
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
                LogUtils.e(TAG, "Exception ", e);
            }
        }
    }

    public static String getAppVersionName(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            LogUtils.e("Utils", "getAppVersionName NameNotFoundException", e);
            return null;
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0025 -> B:9:0x001e). Please submit an issue!!! */
    @SuppressLint({"HardwareIds"})
    public static String getImei(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                if (Build.VERSION.SDK_INT >= 26 && ActivityCompat.checkSelfPermission(context, "android.permission.READ_PHONE_STATE") == 0) {
                    return telephonyManager.getImei();
                }
                return telephonyManager.getDeviceId();
            }
        } catch (Exception e) {
        }
        return "";
    }

    public static String getLoginCookie(Context context) {
        return readStringData(context, Constants.KEY_LOGIN_COOKIE, "");
    }

    public static void writeLoginCookie(Context context, String str) {
        writeStringData(context, Constants.KEY_LOGIN_COOKIE, str);
    }

    public static boolean getRestApiDisable() {
        return mDisableRestapi != 0;
    }

    public static void writeRestApiDisable(int i) {
        mDisableRestapi = i;
    }

    public static void setBdDnsEnable(Context context, int i) {
        writeIntData(context, Constants.KEY_BDDNS_TYPE, i);
    }

    public static boolean getBdDnsEnable(Context context) {
        return false;
    }

    public static boolean isCreateTlsSocket(Context context) {
        return readIntData(context, Constants.KEY_CONN_TYPE, 0) == 0;
    }

    public static void setConnType(Context context, int i) {
        writeIntData(context, Constants.KEY_CONN_TYPE, i);
    }

    public static void writeCuidAccessToken(Context context, String str) {
        writeStringData(context, Constants.KEY_CUID_GENERATE_TOKEN, str);
    }

    public static String getCuidAccessToken(Context context) {
        return readStringData(context, Constants.KEY_CUID_GENERATE_TOKEN, "");
    }

    public static void writeLoginFlag(final Context context, final String str, final String str2) {
        if (isUploadIMTrack(context)) {
            try {
                if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                    TaskManager.getInstance(context).submitForNetWork(new Runnable() { // from class: com.baidu.android.imsdk.utils.Utility.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (Utility.writeStringData(context, Constants.KEY_LOGIN_FLAG, System.currentTimeMillis() + ":" + str)) {
                                Utility.writeStringData(context, Constants.KEY_LOGIN_FLAG_EXT, str2);
                            }
                        }
                    });
                } else if (writeStringData(context, Constants.KEY_LOGIN_FLAG, System.currentTimeMillis() + ":" + str)) {
                    writeStringData(context, Constants.KEY_LOGIN_FLAG_EXT, str2);
                }
            } catch (Throwable th) {
                LogUtils.e(TAG, th.getMessage());
            }
        }
    }

    public static String[] getLoginFlag(Context context) {
        return readStringData(context, Constants.KEY_LOGIN_FLAG, "0:1Y").split(":");
    }

    public static String getLoginFlagExt(Context context) {
        return readStringData(context, Constants.KEY_LOGIN_FLAG_EXT, "");
    }

    public static long getLoginCallTime(Context context) {
        return readLongData(context, Constants.KEY_LOGIN_CALL_TIME, 0L);
    }

    public static void writeLoginCallTime(Context context) {
        writeLongData(context, Constants.KEY_LOGIN_CALL_TIME, System.currentTimeMillis());
    }

    public static int getLoginOpenType(Context context) {
        return readIntData(context, Constants.KEY_LOGIN_OPEN_TYPE, -1);
    }

    public static void writeLoginOpenType(Context context, int i) {
        writeIntData(context, Constants.KEY_LOGIN_OPEN_TYPE, i);
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

    public static String transBDUK(String str) {
        try {
            byte[] decode = android.util.Base64.decode(str, 9);
            if (decode != null) {
                return new String(decrypt("2011121211143000", "AFD311832EDEEAEF", decode));
            }
        } catch (Exception e) {
            LogUtils.e(TAG, "transBDUK AES java exception");
        }
        return "";
    }

    public static String transBDUID(String str) {
        try {
            byte[] encrypt = encrypt("2011121211143000", "AFD311832EDEEAEF", str.getBytes());
            if (encrypt != null) {
                return android.util.Base64.encodeToString(encrypt, 11);
            }
        } catch (Exception e) {
            LogUtils.e(TAG, "AES java exception");
        }
        return "";
    }

    public static byte[] encrypt(String str, String str2, byte[] bArr) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(1, secretKeySpec, new IvParameterSpec(str.getBytes()));
        return cipher.doFinal(bArr);
    }

    public static boolean isIpv4(String str) {
        return (str == null || str.isEmpty() || !str.matches("^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$")) ? false : true;
    }

    public static boolean isIpv4Reachable() {
        try {
            return InetAddress.getByName("180.76.76.76").isReachable(1000);
        } catch (Exception e) {
            LogUtils.e(TAG, "isIpv4Reachable", e);
            return true;
        }
    }

    public static int getLoginRole(Context context) {
        return readIntData(context, Constants.KEY_LOGIN_ROLE, 0);
    }

    public static void writeLoginRole(Context context, int i) {
        writeIntData(context, Constants.KEY_LOGIN_ROLE, i);
    }

    public static boolean isAndroidQAndAbove() {
        return Build.VERSION.SDK_INT >= 29;
    }

    public static int getBusinessType(int i, int i2) {
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
            if (i == 19) {
                return 10;
            }
            return i == 25 ? 20 : 3;
        }
        return 3;
    }

    public static void setStudioHostSendMsg(Context context, boolean z) {
        writeBooleanData(context, Constants.KEY_STUDIO_IS_HOST_SEND_MSG, z);
    }

    public static boolean isStudioHostSendMsg(Context context) {
        return readBooleanData(context, Constants.KEY_STUDIO_IS_HOST_SEND_MSG, false);
    }
}
