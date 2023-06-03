package com.baidu.searchbox.schemedispatch.forbid;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.collection.ArrayMap;
import com.baidu.android.common.others.url.UrlUtil;
import com.baidu.android.util.io.Closeables;
import com.baidu.android.util.io.FileUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.schemedispatch.SchemeStatisticField;
import com.baidu.searchbox.util.BaiduIdentityManager;
import com.baidu.searchbox.utils.SchemeSpUtil;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@Deprecated
/* loaded from: classes4.dex */
public final class SchemeForbidCheckUtils {
    public static final String AD_INVOKE_FLAG_DISABLE = "0";
    public static final String DATA_TAG_FROM_LIST = "from_wlist";
    public static final String DATA_TAG_LIGHT_BROWSE_LIST = "feed_wlist";
    public static final String DATA_TAG_LIGHT_BROWSE_TYPE = "feed_opt";
    public static final String DATA_TAG_LIST = "white_list";
    public static final String DATA_TAG_NO_ALERT_LIST = "noalert_list";
    public static final String DATA_TAG_TYPE = "type";
    public static final String SCHEME_ALWAYS_ALLOW_LIST_FILENAME = "scheme_always_allow_list";
    public static final String SCHEME_FEED_WHITE_LIST_FILENAME = "scheme_feed_white_list";
    public static final String SCHEME_FORBID_FEED_TYPE_SPKEY = "scheme_forbid_feed_opt_key";
    public static final String SCHEME_FORBID_TYPE_DISABLE = "0";
    public static final String SCHEME_FORBID_TYPE_SPKEY = "scheme_forbid_type_key";
    public static final String SCHEME_FROM_WHITE_LIST_FILENAME = "scheme_from_white_list";
    public static final String SCHEME_NO_ALERT_LIST_FILENAME = "scheme_no_alert_list";
    public static final String SCHEME_WHITE_LIST_FILENAME = "scheme_white_list";
    public static final boolean DEBUG = AppConfig.isDebug();
    public static final String TAG = SchemeForbidCheckUtils.class.getSimpleName();
    public static boolean sLoadCache = false;
    public static List<String> sWhiteList = new ArrayList();
    public static List<String> sDefaultList = new ArrayList();
    public static List<String> sFeedWhiteList = new ArrayList();
    public static ArrayMap<String, List<String>> sFromWhiteMap = new ArrayMap<>();
    public static ArrayList<String> sFromWhiteKeyList = new ArrayList<>();
    public static List<String> sNoAlertList = new ArrayList();

    static {
        sDefaultList.add("http");
        sDefaultList.add("https");
        sDefaultList.add("rtsp");
        sDefaultList.add("ftp");
        sDefaultList.add("search");
        sDefaultList.add("addwidget");
        sDefaultList.add(BaiduIdentityManager.PARAM_SERVICE);
        sDefaultList.add(BaiduIdentityManager.VALUE_OSNAME);
        sDefaultList.add("widgetid");
        sDefaultList.add("scenetype");
        sDefaultList.add("package");
        sDefaultList.add("baidupush");
        sDefaultList.add("content");
        sDefaultList.add("file");
        loadWhiteListAsync();
        loadFeedWhiteListAsync();
        loadFromWhiteListAsync();
        loadNoAlertListAsync();
    }

    public static List<String> getAlwaysAllowSchema() {
        return readCache("scheme_always_allow_list");
    }

    public static ArrayList<String> getFromKeyList() {
        return sFromWhiteKeyList;
    }

    public static synchronized void loadFeedWhiteList() {
        synchronized (SchemeForbidCheckUtils.class) {
            sFeedWhiteList.clear();
            sFeedWhiteList.addAll(readCache(SCHEME_FEED_WHITE_LIST_FILENAME));
        }
    }

    public static void loadFeedWhiteListAsync() {
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.searchbox.schemedispatch.forbid.SchemeForbidCheckUtils.3
            @Override // java.lang.Runnable
            public void run() {
                SchemeForbidCheckUtils.loadFeedWhiteList();
            }
        }, "SchemeFeedWhiteListLoad", 2);
    }

    public static synchronized void loadFromWhiteList() {
        synchronized (SchemeForbidCheckUtils.class) {
            try {
                saveFromDataToCache(new JSONObject(FileUtils.readCacheData(AppRuntime.getAppContext(), SCHEME_FROM_WHITE_LIST_FILENAME)));
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void loadFromWhiteListAsync() {
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.searchbox.schemedispatch.forbid.SchemeForbidCheckUtils.2
            @Override // java.lang.Runnable
            public void run() {
                SchemeForbidCheckUtils.loadFromWhiteList();
            }
        }, "SchemeFromWhiteListLoad", 2);
    }

    public static synchronized void loadNoAlertList() {
        synchronized (SchemeForbidCheckUtils.class) {
            sNoAlertList.clear();
            sNoAlertList.addAll(readCache("scheme_no_alert_list"));
        }
    }

    public static void loadNoAlertListAsync() {
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.searchbox.schemedispatch.forbid.SchemeForbidCheckUtils.4
            @Override // java.lang.Runnable
            public void run() {
                SchemeForbidCheckUtils.loadNoAlertList();
            }
        }, "NoAlertList", 2);
    }

    public static void loadWhiteListAsync() {
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.searchbox.schemedispatch.forbid.SchemeForbidCheckUtils.1
            @Override // java.lang.Runnable
            public void run() {
                SchemeForbidCheckUtils.loadWhiteList();
            }
        }, "SchemeWhiteListLoad", 2);
    }

    public static boolean adCheckSchemeInFeedWhiteList(String str, String str2, String str3, String str4, String str5, String str6) {
        boolean z;
        if (TextUtils.isEmpty(str3)) {
            return false;
        }
        if (TextUtils.equals(SchemeSpUtil.getInstance().getString("scheme_forbid_feed_opt_key", "0"), "0")) {
            SchemeForbidStatisticUtils.onEvent(str2, str3, false, true, "feed", str4, str, str6);
            return false;
        }
        if (!TextUtils.equals(str5, "0")) {
            z = isInWhiteList(str3, sFeedWhiteList);
        } else {
            z = false;
        }
        SchemeForbidStatisticUtils.onEvent(str2, str3, true, z, "feed", str4, str, str6);
        return z;
    }

    public static boolean adCheckSchemeInGlobalWhiteList(String str, String str2, String str3, String str4, String str5, String str6) {
        boolean z;
        long currentTimeMillis = System.currentTimeMillis();
        if (TextUtils.isEmpty(str3)) {
            return false;
        }
        if (checkSchemeInDefault(str3)) {
            return true;
        }
        if (TextUtils.equals(SchemeSpUtil.getInstance().getString("scheme_forbid_type_key", "0"), "0")) {
            if (DEBUG) {
                Log.d(TAG, "Scheme White List Check: Enabe=false");
            }
            SchemeForbidStatisticUtils.onEvent(str2, str3, false, true, "global", str4, str, str6);
            return true;
        }
        if (!TextUtils.equals(str5, "0")) {
            if (!sLoadCache) {
                loadWhiteList();
            }
            z = isInWhiteList(str3, sWhiteList);
        } else {
            z = false;
        }
        SchemeForbidStatisticUtils.onEvent(str2, str3, true, z, "global", str4, str, str6);
        long currentTimeMillis2 = System.currentTimeMillis();
        if (DEBUG) {
            String str7 = TAG;
            Log.d(str7, "Check Scheme Cost: " + (currentTimeMillis2 - currentTimeMillis) + "\n In whitelist: " + z);
        }
        return z;
    }

    public static void addAlwaysAllowSchema(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        List<String> alwaysAllowSchema = getAlwaysAllowSchema();
        if (alwaysAllowSchema != null && alwaysAllowSchema.size() > 0) {
            arrayList.addAll(alwaysAllowSchema);
        }
        updateAlwaysAllowSchema(arrayList);
    }

    public static boolean checkSchemeInNoAlertList(String str) {
        if (TextUtils.isEmpty(str) || TextUtils.equals(SchemeSpUtil.getInstance().getString("scheme_forbid_feed_opt_key", "0"), "0")) {
            return false;
        }
        return isInWhiteList(str, sNoAlertList);
    }

    public static boolean handleFromData(JSONObject jSONObject) throws JSONException {
        boolean cache = FileUtils.cache(AppRuntime.getAppContext(), SCHEME_FROM_WHITE_LIST_FILENAME, jSONObject.toString(), 0);
        if (cache) {
            saveFromDataToCache(jSONObject);
        }
        return cache;
    }

    public static void saveFromDataToCache(JSONObject jSONObject) throws JSONException {
        sFromWhiteMap.clear();
        sFromWhiteKeyList.clear();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            JSONArray optJSONArray = jSONObject.optJSONArray(next);
            if (optJSONArray != null) {
                generateItem(next, optJSONArray);
                sFromWhiteKeyList.add(next);
            }
        }
    }

    public static void updateAlwaysAllowSchema(List<String> list) {
        writeCache(list, "scheme_always_allow_list");
    }

    public static boolean checkSchemeInDefault(String str) {
        Uri parse;
        if (str.indexOf(32) >= 0 || str.indexOf(10) >= 0 || (parse = Uri.parse(str)) == null || parse.getScheme() == null || (parse.getAuthority() == null && parse.getPath() == null)) {
            return true;
        }
        for (String str2 : sDefaultList) {
            if (str.toLowerCase(Locale.getDefault()).startsWith(str2)) {
                return true;
            }
        }
        if (UrlUtil.isUrl(str)) {
            return true;
        }
        return false;
    }

    public static boolean checkSchemeInFeedWhiteList(String str, String str2) {
        return checkSchemeInFeedWhiteList(str, str, str2);
    }

    public static void generateItem(String str, JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            arrayList.add(jSONArray.getString(i));
        }
        sFromWhiteMap.put(str, arrayList);
    }

    public static boolean isInNoAlertList(String str, List<String> list) {
        return isInWhiteList(str, list);
    }

    public static boolean saveData(JSONArray jSONArray, String str) throws JSONException {
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            arrayList.add(jSONArray.getString(i));
        }
        if (!writeCache(arrayList, str)) {
            return false;
        }
        sNoAlertList.clear();
        sNoAlertList.addAll(arrayList);
        return true;
    }

    public static boolean checkSchemeInFeedWhiteList(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (TextUtils.equals(SchemeSpUtil.getInstance().getString("scheme_forbid_feed_opt_key", "0"), "0")) {
            SchemeForbidStatisticUtils.onEvent(str2, str, false, true, "feed", str3);
            return false;
        }
        boolean isInWhiteList = isInWhiteList(str, sFeedWhiteList);
        SchemeForbidStatisticUtils.onEvent(str2, str, true, isInWhiteList, "feed", str3);
        return isInWhiteList;
    }

    public static boolean checkSchemeInFromWhiteList(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || sFromWhiteMap.get(str2) == null) {
            return false;
        }
        boolean isInWhiteList = isInWhiteList(str, sFromWhiteMap.get(str2));
        SchemeForbidStatisticUtils.onEvent(str, str, true, isInWhiteList, "from", str3);
        return isInWhiteList;
    }

    public static boolean checkSchemeInGlobalWhiteList(Context context, String str, String str2, String str3) {
        return checkSchemeInGlobalWhiteList(context, str, str2, str3, null);
    }

    public static boolean checkSchemeInGlobalWhiteList(Context context, String str, String str2, String str3, SchemeStatisticField schemeStatisticField) {
        long currentTimeMillis = System.currentTimeMillis();
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        if (checkSchemeInDefault(str2)) {
            return true;
        }
        if (TextUtils.equals(SchemeSpUtil.getInstance().getString("scheme_forbid_type_key", "0"), "0")) {
            if (DEBUG) {
                Log.d(TAG, "Scheme White List Check: Enabe=false");
            }
            SchemeForbidStatisticUtils.doSchemeForbidStatistic(str, str2, false, true, str3, schemeStatisticField);
            return true;
        }
        if (!sLoadCache) {
            loadWhiteList();
        }
        boolean isInWhiteList = isInWhiteList(str2, sWhiteList);
        SchemeForbidStatisticUtils.doSchemeForbidStatistic(str, str2, true, isInWhiteList, str3, schemeStatisticField);
        long currentTimeMillis2 = System.currentTimeMillis();
        if (DEBUG) {
            String str4 = TAG;
            Log.d(str4, "Check Scheme Cost: " + (currentTimeMillis2 - currentTimeMillis) + "\n In whitelist: " + isInWhiteList);
        }
        return isInWhiteList;
    }

    public static boolean compare(String[] strArr, String[] strArr2) {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        hashSet.addAll(Arrays.asList(strArr));
        hashSet2.addAll(Arrays.asList(strArr2));
        if (hashSet.size() != hashSet2.size()) {
            return false;
        }
        int size = hashSet.size();
        hashSet.addAll(Arrays.asList(strArr2));
        if (size != hashSet.size()) {
            return false;
        }
        return true;
    }

    public static boolean handleAndSaveData(String str, JSONArray jSONArray, boolean z) throws JSONException {
        String str2;
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            arrayList.add(jSONArray.getString(i));
        }
        if (z) {
            str2 = SCHEME_WHITE_LIST_FILENAME;
        } else {
            str2 = SCHEME_FEED_WHITE_LIST_FILENAME;
        }
        if (!writeCache(arrayList, str2)) {
            return false;
        }
        if (z) {
            SchemeSpUtil.getInstance().putString("scheme_forbid_type_key", str);
            sWhiteList.clear();
            sWhiteList.addAll(arrayList);
            return true;
        }
        SchemeSpUtil.getInstance().putString("scheme_forbid_feed_opt_key", str);
        sFeedWhiteList.clear();
        sFeedWhiteList.addAll(arrayList);
        return true;
    }

    public static boolean isInWhiteList(String str, List<String> list) {
        String str2;
        String str3;
        String str4;
        String str5;
        int indexOf = str.indexOf("?");
        int indexOf2 = str.indexOf("#");
        if (indexOf >= str.length()) {
            indexOf = 0;
        }
        if (indexOf2 >= str.length()) {
            indexOf2 = 0;
        }
        if (indexOf2 > 0 && indexOf2 < indexOf) {
            indexOf = 0;
        }
        if (indexOf > 0) {
            String substring = str.substring(0, indexOf);
            if (indexOf2 > 0) {
                String substring2 = str.substring(indexOf + 1, indexOf2);
                String substring3 = str.substring(indexOf2 + 1);
                str3 = substring2;
                str2 = substring3;
            } else {
                str3 = str.substring(indexOf + 1);
                str2 = null;
            }
            str = substring;
        } else if (indexOf2 > 0) {
            String substring4 = str.substring(0, indexOf2);
            String substring5 = str.substring(indexOf2 + 1);
            str3 = null;
            str2 = substring5;
            str = substring4;
        } else {
            str2 = null;
            str3 = null;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String next = it.next();
            int indexOf3 = next.indexOf("?");
            int indexOf4 = next.indexOf("#");
            if (indexOf3 >= next.length()) {
                indexOf3 = 0;
            }
            if (indexOf4 >= next.length()) {
                indexOf4 = 0;
            }
            if (indexOf4 > 0 && indexOf4 < indexOf3) {
                indexOf3 = 0;
            }
            if (indexOf3 > 0) {
                String substring6 = next.substring(0, indexOf3);
                if (indexOf4 > 0) {
                    String substring7 = next.substring(indexOf3 + 1, indexOf4);
                    String substring8 = next.substring(indexOf4 + 1);
                    str5 = substring7;
                    str4 = substring8;
                    next = substring6;
                } else {
                    str5 = next.substring(indexOf3 + 1);
                    next = substring6;
                    str4 = null;
                }
            } else if (indexOf4 > 0) {
                String substring9 = next.substring(0, indexOf4);
                String substring10 = next.substring(indexOf4 + 1);
                str5 = null;
                str4 = substring10;
                next = substring9;
            } else {
                str4 = null;
                str5 = null;
            }
            if (str.startsWith(next)) {
                if (TextUtils.isEmpty(str5) && TextUtils.isEmpty(str4)) {
                    return true;
                }
                if (TextUtils.isEmpty(str5) || (!TextUtils.isEmpty(str3) && compare(str3.split("&"), str5.split("&")))) {
                    if (TextUtils.equals(str2, str4)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static synchronized void loadWhiteList() {
        synchronized (SchemeForbidCheckUtils.class) {
            long currentTimeMillis = System.currentTimeMillis();
            sWhiteList.clear();
            sWhiteList.addAll(readCache(SCHEME_WHITE_LIST_FILENAME));
            sLoadCache = true;
            long currentTimeMillis2 = System.currentTimeMillis();
            if (DEBUG) {
                String str = TAG;
                Log.d(str, "Load Scheme White List Cost: " + (currentTimeMillis2 - currentTimeMillis));
            }
        }
    }

    public static List<String> readCache(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        FileInputStream fileInputStream = null;
        try {
            try {
                try {
                    fileInputStream = AppRuntime.getAppContext().openFileInput(str);
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
                    for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                        if (!TextUtils.isEmpty(readLine)) {
                            arrayList.add(readLine);
                        }
                    }
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (FileNotFoundException e2) {
                e2.printStackTrace();
            }
            Closeables.closeSafely(fileInputStream);
            long currentTimeMillis2 = System.currentTimeMillis();
            if (DEBUG) {
                String str2 = TAG;
                Log.d(str2, "Read WhiteScheme Cache: " + (currentTimeMillis2 - currentTimeMillis));
            }
            return arrayList;
        } catch (Throwable th) {
            Closeables.closeSafely(fileInputStream);
            throw th;
        }
    }

    public static synchronized boolean saveWhiteList(String str) {
        boolean z;
        synchronized (SchemeForbidCheckUtils.class) {
            if (TextUtils.isEmpty(str)) {
                if (DEBUG) {
                    Log.d(TAG, "No data send");
                }
                return false;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                String string = jSONObject.getString("type");
                JSONArray jSONArray = jSONObject.getJSONArray("white_list");
                JSONObject optJSONObject = jSONObject.optJSONObject("from_wlist");
                String optString = jSONObject.optString("feed_opt");
                JSONArray optJSONArray = jSONObject.optJSONArray("feed_wlist");
                JSONArray optJSONArray2 = jSONObject.optJSONArray(DATA_TAG_NO_ALERT_LIST);
                if (TextUtils.isEmpty(string)) {
                    if (DEBUG) {
                        Log.d(TAG, "Type or whitelist is empty");
                    }
                    return false;
                }
                if (jSONArray != null) {
                    if (DEBUG) {
                        String str2 = TAG;
                        Log.d(str2, "Type=" + string + "; List=" + jSONArray.toString());
                    }
                    z = handleAndSaveData(string, jSONArray, true);
                } else {
                    z = false;
                }
                if (optJSONObject != null) {
                    z |= handleFromData(optJSONObject);
                }
                if (!TextUtils.isEmpty(optString) && optJSONArray != null) {
                    z |= handleAndSaveData(optString, optJSONArray, false);
                }
                if (optJSONArray2 != null) {
                    z |= saveData(optJSONArray2, "scheme_no_alert_list");
                }
                return z;
            } catch (JSONException e) {
                e.printStackTrace();
                if (DEBUG) {
                    Log.e(TAG, "Data parse exception");
                }
                return false;
            }
        }
    }

    public static boolean writeCache(List<String> list, String str) {
        try {
            try {
                try {
                    FileOutputStream openFileOutput = AppRuntime.getAppContext().openFileOutput(str, 0);
                    if (list.size() == 0) {
                        openFileOutput.write(new byte[0]);
                        Closeables.closeSafely(openFileOutput);
                        return true;
                    }
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(openFileOutput));
                    for (String str2 : list) {
                        bufferedWriter.write(str2);
                        bufferedWriter.newLine();
                    }
                    bufferedWriter.close();
                    Closeables.closeSafely(openFileOutput);
                    return true;
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            } catch (FileNotFoundException e2) {
                e2.printStackTrace();
                return false;
            }
        } finally {
            Closeables.closeSafely((Closeable) null);
        }
    }
}
