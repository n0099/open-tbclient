package com.baidu.android.pushservice;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteException;
import android.os.Build;
import android.util.Log;
import com.baidu.android.pushservice.util.Internal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class PushManager {
    private static final String TAG = "PushManager";
    private static int INFO_MAX_NUM = 50;
    private static HashMap mStatisticsMap = new HashMap();

    public static void activityStarted(Activity activity) {
        Intent intent;
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        String str = "" + intent.getIntExtra(PushConstants.EXTRA_OPENTYPE, 0);
        String stringExtra = activity.getIntent().getStringExtra(PushConstants.EXTRA_MSGID);
        int hashCode = activity.hashCode();
        if (b.a()) {
            Log.d(TAG, "Collect Activity start feedback info , package:" + activity.getPackageName() + " timeStamp:" + currentTimeMillis + " openType: " + str + " msgid: " + stringExtra + " hashCode: " + hashCode);
        }
        insertAppStartInfo(activity.getPackageName(), hashCode, str, stringExtra, currentTimeMillis + "");
    }

    public static void activityStoped(Activity activity) {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        int hashCode = activity.hashCode();
        if (b.a()) {
            Log.d(TAG, "Collect Activity stop feedback info , package:" + activity.getPackageName() + " timeStamp:" + currentTimeMillis + " hashCode: " + hashCode);
        }
        insertAppStopInfo(activity, activity.getPackageName(), hashCode, "" + currentTimeMillis);
    }

    public static void bind(Context context, int i) {
        if (isNullContext(context)) {
            return;
        }
        Intent createMethodIntent = createMethodIntent(context);
        createMethodIntent.putExtra(PushConstants.EXTRA_METHOD, PushConstants.METHOD_BIND);
        createMethodIntent.putExtra(PushConstants.EXTRA_BIND_NAME, Build.MODEL);
        createMethodIntent.putExtra(PushConstants.EXTRA_BIND_STATUS, i);
        createMethodIntent.putExtra(PushConstants.EXTRA_PUSH_SDK_VERSION, 11);
        createMethodIntent.setFlags(createMethodIntent.getFlags() | 32);
        context.sendBroadcast(createMethodIntent);
    }

    public static void bindGroup(Context context, String str) {
        if (isNullContext(context)) {
            return;
        }
        Intent createMethodIntent = createMethodIntent(context);
        createMethodIntent.putExtra(PushConstants.EXTRA_METHOD, PushConstants.METHOD_GBIND);
        createMethodIntent.putExtra(PushConstants.EXTRA_GID, str);
        createMethodIntent.setFlags(createMethodIntent.getFlags() | 32);
        context.sendBroadcast(createMethodIntent);
    }

    private static Intent createMethodIntent(Context context) {
        if (isNullContext(context)) {
            return null;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences(context.getPackageName(), 1);
        int i = sharedPreferences.getInt("com.baidu.android.pushservice.PushManager.LOGIN_TYPE", 0);
        String string = sharedPreferences.getString("com.baidu.android.pushservice.PushManager.LONGIN_VALUE", "");
        if (i == 2) {
            Intent createBdussInent = Internal.createBdussInent(context);
            createBdussInent.putExtra("appid", string);
            String rsaEncrypt = PushConstants.rsaEncrypt(sharedPreferences.getString("com.baidu.android.pushservice.PushManager.BDUSS", ""));
            createBdussInent.putExtra("bduss", rsaEncrypt);
            if (b.a()) {
                Log.d(TAG, "RSA Bduss:" + rsaEncrypt);
                return createBdussInent;
            }
            return createBdussInent;
        }
        Intent createMethodIntent = PushConstants.createMethodIntent(context);
        if (i != 1) {
            createMethodIntent.putExtra(PushConstants.EXTRA_API_KEY, string);
            if (b.a()) {
                Log.d(TAG, "Api Key:" + string.substring(0, 5));
                return createMethodIntent;
            }
            return createMethodIntent;
        }
        String rsaEncrypt2 = PushConstants.rsaEncrypt(string);
        createMethodIntent.putExtra(PushConstants.EXTRA_ACCESS_TOKEN, rsaEncrypt2);
        if (b.a()) {
            Log.d(TAG, "RSA Access Token:" + rsaEncrypt2);
            return createMethodIntent;
        }
        return createMethodIntent;
    }

    public static void delTags(Context context, List list) {
        Iterator it;
        if (isNullContext(context)) {
            return;
        }
        if (list == null || list.size() == 0) {
            Log.w(TAG, "No tags specified, do nothing.");
            return;
        }
        String str = "[";
        while (true) {
            String str2 = str;
            if (!list.iterator().hasNext()) {
                String str3 = str2.substring(0, str2.length() - 1) + "]";
                Intent createMethodIntent = createMethodIntent(context);
                createMethodIntent.putExtra(PushConstants.EXTRA_METHOD, PushConstants.METHOD_DEL_TAGS);
                createMethodIntent.putExtra(PushConstants.EXTRA_TAGS, str3);
                context.sendBroadcast(createMethodIntent);
                return;
            }
            str = ((str2 + "\"") + ((String) it.next())) + "\",";
        }
    }

    public static void deleteMessages(Context context, String[] strArr) {
        if (isNullContext(context) || strArr == null) {
            return;
        }
        Intent createMethodIntent = createMethodIntent(context);
        createMethodIntent.putExtra(PushConstants.EXTRA_METHOD, PushConstants.METHOD_DELETE);
        createMethodIntent.putExtra(PushConstants.EXTRA_MSG_IDS, strArr);
        context.sendBroadcast(createMethodIntent);
    }

    public static void fetchGroupMessages(Context context, String str, int i, int i2) {
        if (isNullContext(context)) {
            return;
        }
        Intent createMethodIntent = createMethodIntent(context);
        createMethodIntent.putExtra(PushConstants.EXTRA_METHOD, PushConstants.METHOD_FETCHGMSG);
        createMethodIntent.putExtra(PushConstants.EXTRA_GID, str);
        createMethodIntent.putExtra(PushConstants.EXTRA_GROUP_FETCH_TYPE, i);
        createMethodIntent.putExtra(PushConstants.EXTRA_GROUP_FETCH_NUM, i2);
        context.sendBroadcast(createMethodIntent);
    }

    public static void fetchMessages(Context context, int i, int i2) {
        if (isNullContext(context)) {
            return;
        }
        Intent createMethodIntent = createMethodIntent(context);
        createMethodIntent.putExtra(PushConstants.EXTRA_METHOD, PushConstants.METHOD_FETCH);
        createMethodIntent.putExtra(PushConstants.EXTRA_FETCH_TYPE, i);
        createMethodIntent.putExtra(PushConstants.EXTRA_FETCH_NUM, i2);
        context.sendBroadcast(createMethodIntent);
    }

    public static void getGroupInfo(Context context, String str) {
        if (isNullContext(context)) {
            return;
        }
        Intent createMethodIntent = createMethodIntent(context);
        createMethodIntent.putExtra(PushConstants.EXTRA_METHOD, PushConstants.METHOD_GINFO);
        createMethodIntent.putExtra(PushConstants.EXTRA_GID, str);
        context.sendBroadcast(createMethodIntent);
    }

    public static void getGroupList(Context context) {
        if (isNullContext(context)) {
            return;
        }
        Intent createMethodIntent = createMethodIntent(context);
        createMethodIntent.putExtra(PushConstants.EXTRA_METHOD, PushConstants.METHOD_GLIST);
        context.sendBroadcast(createMethodIntent);
    }

    public static void getGroupMessageCounts(Context context, String str) {
        if (isNullContext(context)) {
            return;
        }
        Intent createMethodIntent = createMethodIntent(context);
        createMethodIntent.putExtra(PushConstants.EXTRA_METHOD, PushConstants.METHOD_COUNTGMSG);
        createMethodIntent.putExtra(PushConstants.EXTRA_GID, str);
        context.sendBroadcast(createMethodIntent);
    }

    public static void getMessageCounts(Context context) {
        if (isNullContext(context)) {
            return;
        }
        Intent createMethodIntent = createMethodIntent(context);
        createMethodIntent.putExtra(PushConstants.EXTRA_METHOD, PushConstants.METHOD_COUNT);
        context.sendBroadcast(createMethodIntent);
    }

    public static void init(Context context, String str) {
        if (isNullContext(context)) {
            return;
        }
        SharedPreferences.Editor edit = context.getSharedPreferences(context.getPackageName(), 1).edit();
        edit.putInt("com.baidu.android.pushservice.PushManager.LOGIN_TYPE", 1);
        edit.putString("com.baidu.android.pushservice.PushManager.LONGIN_VALUE", str);
        edit.commit();
        PushSettings.a(context.getApplicationContext());
        com.baidu.android.pushservice.util.n.j(context);
    }

    public static void init(Context context, String str, String str2) {
        if (isNullContext(context)) {
            return;
        }
        SharedPreferences.Editor edit = context.getSharedPreferences(context.getPackageName(), 1).edit();
        edit.putInt("com.baidu.android.pushservice.PushManager.LOGIN_TYPE", 2);
        edit.putString("com.baidu.android.pushservice.PushManager.LONGIN_VALUE", str);
        edit.putString("com.baidu.android.pushservice.PushManager.BDUSS", str2);
        edit.commit();
        PushSettings.a(context.getApplicationContext());
        com.baidu.android.pushservice.util.n.j(context);
    }

    public static void initFromAKSK(Context context, String str) {
        if (isNullContext(context)) {
            return;
        }
        SharedPreferences.Editor edit = context.getSharedPreferences(context.getPackageName(), 1).edit();
        edit.putInt("com.baidu.android.pushservice.PushManager.LOGIN_TYPE", 0);
        edit.putString("com.baidu.android.pushservice.PushManager.LONGIN_VALUE", str);
        edit.commit();
        PushSettings.a(context);
        com.baidu.android.pushservice.util.n.j(context);
    }

    private static void insertAppStartInfo(String str, int i, String str2, String str3, String str4) {
        if (mStatisticsMap.size() < INFO_MAX_NUM) {
            com.baidu.android.pushservice.util.l lVar = new com.baidu.android.pushservice.util.l();
            lVar.f631a = i;
            lVar.b = str;
            lVar.c = str2;
            lVar.d = str3;
            lVar.e = str4;
            mStatisticsMap.put(Integer.valueOf(lVar.f631a), lVar);
        }
    }

    private static void insertAppStopInfo(Context context, String str, int i, String str2) {
        if (isNullContext(context) || mStatisticsMap == null) {
            return;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences(context.getPackageName() + "pst", 1);
        String string = sharedPreferences.getString("cache_when_exception", "");
        if (!string.equals("")) {
            com.baidu.android.pushservice.util.l lVar = new com.baidu.android.pushservice.util.l();
            String[] split = string.split("#");
            if (split.length == 5 || split.length == 6) {
                lVar.b = split[0];
                lVar.c = split[1];
                lVar.d = split[2];
                lVar.e = split[3];
                lVar.g = split[4];
                if (split.length == 6) {
                    try {
                        lVar.h = new JSONObject(split[5]);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                com.baidu.android.pushservice.util.e.a(com.baidu.android.pushservice.util.e.a(context), lVar);
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putString("cache_when_exception", "");
                edit.commit();
            }
        }
        com.baidu.android.pushservice.util.l lVar2 = (com.baidu.android.pushservice.util.l) mStatisticsMap.remove(Integer.valueOf(i));
        if (lVar2 != null) {
            lVar2.f = str2;
            lVar2.g = "" + (Long.parseLong(lVar2.f) - Long.parseLong(lVar2.e));
            try {
                com.baidu.android.pushservice.util.e.a(com.baidu.android.pushservice.util.e.a(context), lVar2);
                Log.i(TAG, "insert into db " + context.getPackageName());
            } catch (SQLiteException e2) {
                Log.e(TAG, "inset into db exception");
                SharedPreferences.Editor edit2 = sharedPreferences.edit();
                edit2.putString("cache_when_exception", lVar2.b + "#" + lVar2.c + "#" + lVar2.d + "#" + lVar2.e + "#" + lVar2.f + "#" + lVar2.g);
                edit2.commit();
            }
        }
    }

    public static boolean isConnected(Context context) {
        if (isNullContext(context)) {
            return false;
        }
        boolean z = true;
        if (!com.baidu.android.pushservice.util.n.o(context) || !PushSettings.b(context)) {
            z = false;
        }
        return z;
    }

    private static boolean isNullContext(Context context) {
        if (context == null) {
            Log.e(TAG, "Context is null!");
            return true;
        }
        return false;
    }

    public static boolean isPushEnabled(Context context) {
        return (isNullContext(context) || com.baidu.android.pushservice.util.n.c(context)) ? false : true;
    }

    public static void resumeWork(Context context) {
        if (isNullContext(context)) {
            return;
        }
        b.b(context, true);
        com.baidu.android.pushservice.util.n.c(context, true);
        b.a(context, true);
        com.baidu.android.pushservice.util.n.j(context);
        bind(context, 0);
    }

    public static void sendMsgToServer(Context context, String str, String str2, String str3) {
        if (isNullContext(context)) {
            return;
        }
        Intent createMethodIntent = createMethodIntent(context);
        createMethodIntent.putExtra(PushConstants.EXTRA_METHOD, PushConstants.METHOD_SEND_MSG_TO_SERVER);
        createMethodIntent.putExtra(PushConstants.EXTRA_APP_ID, str);
        createMethodIntent.putExtra(PushConstants.EXTRA_CB_URL, str2);
        createMethodIntent.putExtra(PushConstants.EXTRA_MSG, str3);
        context.sendBroadcast(createMethodIntent);
    }

    public static void sendMsgToUser(Context context, String str, String str2, String str3, String str4) {
        if (isNullContext(context)) {
            return;
        }
        Intent createMethodIntent = createMethodIntent(context);
        createMethodIntent.putExtra(PushConstants.EXTRA_METHOD, PushConstants.METHOD_SEND_MSG_TO_USER);
        createMethodIntent.putExtra(PushConstants.EXTRA_APP_ID, str);
        createMethodIntent.putExtra(PushConstants.EXTRA_USER_ID, str2);
        createMethodIntent.putExtra(PushConstants.EXTRA_MSG_KEY, str3);
        createMethodIntent.putExtra(PushConstants.EXTRA_MSG, str4);
        context.sendBroadcast(createMethodIntent);
    }

    public static void setAccessToken(Context context, String str) {
        if (isNullContext(context)) {
            return;
        }
        SharedPreferences.Editor edit = context.getSharedPreferences(context.getPackageName(), 1).edit();
        edit.putInt("com.baidu.android.pushservice.PushManager.LOGIN_TYPE", 1);
        edit.putString("com.baidu.android.pushservice.PushManager.LONGIN_VALUE", str);
        edit.commit();
    }

    public static void setApiKey(Context context, String str) {
        if (isNullContext(context)) {
            return;
        }
        SharedPreferences.Editor edit = context.getSharedPreferences(context.getPackageName(), 1).edit();
        edit.putInt("com.baidu.android.pushservice.PushManager.LOGIN_TYPE", 0);
        edit.putString("com.baidu.android.pushservice.PushManager.LONGIN_VALUE", str);
        edit.commit();
    }

    public static void setBduss(Context context, String str) {
        if (isNullContext(context)) {
            return;
        }
        SharedPreferences.Editor edit = context.getSharedPreferences(context.getPackageName(), 1).edit();
        edit.putInt("com.baidu.android.pushservice.PushManager.LOGIN_TYPE", 2);
        edit.putString("com.baidu.android.pushservice.PushManager.BDUSS", str);
        edit.commit();
    }

    public static void setDefaultNotificationBuilder(Context context, PushNotificationBuilder pushNotificationBuilder) {
        if (isNullContext(context)) {
            return;
        }
        c.a(context, pushNotificationBuilder);
    }

    public static void setMediaNotificationBuilder(Context context, PushNotificationBuilder pushNotificationBuilder) {
        if (isNullContext(context)) {
            return;
        }
        c.b(context, pushNotificationBuilder);
    }

    public static void setNotificationBuilder(Context context, int i, PushNotificationBuilder pushNotificationBuilder) {
        if (isNullContext(context)) {
            return;
        }
        if (i < 1 || i > 1000) {
            Log.e(TAG, "set notification builder error, id is illegal !");
        } else {
            c.a(context, i, pushNotificationBuilder);
        }
    }

    public static void setTags(Context context, List list) {
        Iterator it;
        if (isNullContext(context)) {
            return;
        }
        if (list == null || list.size() == 0) {
            Log.w(TAG, "No tags specified, do nothing.");
            return;
        }
        String str = "[";
        while (true) {
            String str2 = str;
            if (!list.iterator().hasNext()) {
                String str3 = str2.substring(0, str2.length() - 1) + "]";
                Intent createMethodIntent = createMethodIntent(context);
                createMethodIntent.putExtra(PushConstants.EXTRA_METHOD, PushConstants.METHOD_SET_TAGS);
                createMethodIntent.putExtra(PushConstants.EXTRA_TAGS, str3);
                context.sendBroadcast(createMethodIntent);
                return;
            }
            str = ((str2 + "\"") + ((String) it.next())) + "\",";
        }
    }

    public static void startWork(Context context, int i, String str) {
        if (isNullContext(context)) {
            return;
        }
        b.b(context, true);
        SharedPreferences.Editor edit = context.getSharedPreferences(context.getPackageName(), 1).edit();
        if (i == 1) {
            edit.putInt("com.baidu.android.pushservice.PushManager.LOGIN_TYPE", 1);
            edit.putString("com.baidu.android.pushservice.PushManager.LONGIN_VALUE", str);
        } else if (i != 0) {
            Log.e(TAG, "Wrong login type, please check!");
            return;
        } else {
            edit.putInt("com.baidu.android.pushservice.PushManager.LOGIN_TYPE", 0);
            edit.putString("com.baidu.android.pushservice.PushManager.LONGIN_VALUE", str);
        }
        edit.commit();
        PushSettings.a(context);
        com.baidu.android.pushservice.util.n.j(context);
        bind(context, 0);
    }

    public static void startWork(Context context, String str, String str2) {
        if (isNullContext(context)) {
            return;
        }
        b.b(context, true);
        SharedPreferences.Editor edit = context.getSharedPreferences(context.getPackageName(), 1).edit();
        edit.putInt("com.baidu.android.pushservice.PushManager.LOGIN_TYPE", 2);
        edit.putString("com.baidu.android.pushservice.PushManager.LONGIN_VALUE", str);
        edit.putString("com.baidu.android.pushservice.PushManager.BDUSS", str2);
        edit.commit();
        PushSettings.a(context);
        com.baidu.android.pushservice.util.n.j(context);
        bind(context, 0);
    }

    public static void stopWork(Context context) {
        if (isNullContext(context)) {
            return;
        }
        b.b(context, false);
        com.baidu.android.pushservice.util.n.c(context, true);
        unbind(context);
        b.a(context, true);
        com.baidu.android.pushservice.util.n.j(context);
    }

    public static void tryConnect(Context context) {
        if (isNullContext(context)) {
            return;
        }
        context.sendBroadcast(createMethodIntent(context));
    }

    public static void unbind(Context context) {
        if (isNullContext(context)) {
            return;
        }
        Intent createMethodIntent = createMethodIntent(context);
        createMethodIntent.putExtra(PushConstants.EXTRA_METHOD, PushConstants.METHOD_UNBIND);
        context.sendBroadcast(createMethodIntent);
    }

    public static void unbindGroup(Context context, String str) {
        if (isNullContext(context)) {
            return;
        }
        Intent createMethodIntent = createMethodIntent(context);
        createMethodIntent.putExtra(PushConstants.EXTRA_METHOD, PushConstants.METHOD_GUNBIND);
        createMethodIntent.putExtra(PushConstants.EXTRA_GID, str);
        context.sendBroadcast(createMethodIntent);
    }
}
