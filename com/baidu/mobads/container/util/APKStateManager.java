package com.baidu.mobads.container.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.mobads.container.config.AppCommonConfig;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class APKStateManager {
    public static final long APK_INFO_TIMEOUT = TimeUnit.HOURS.toMillis(24);
    public static final String APK_LIST_FILE_NAME = "mobads_aplist_status";
    public static final String KEY_JSON_CONFIG_PKG_LIST = "pkglist";
    public static final String KEY_MTJ_SWITCH = "mtj_switch";
    public static final String KEY_MTJ_WEB_SWITCH = "mtj_web_switch";
    public static final String KEY_ORIGIN_ENCODE_PKGLIST = "n_origin_pkg_encode_";
    public static final String KEY_ORIGIN_INDEX_ARRAY = "n_iad_index_array";
    public static final String KEY_ORIGIN_SNIFF_IAD = "n_iad_sniff_result";
    public static final String KEY_ORIGIN_TIME_STAMP = "n_iad_time_stamp";
    public static final String KEY_SWITCH_LP_RELOAD = "lp_reload";
    public static final String SWITCH_MTJ_OPEN = "switch_mtj_open";
    public static final String TAG = "APKStateManager";
    public static APKStateManager sInstance;
    public String defaultList;
    public String defaultListSecond;
    public String mIadex;

    public APKStateManager() {
        RemoteXAdLogger.getInstance().d(TAG, "create APKStateManager Instance ~");
    }

    private String[] doubleCheckPkgArrays(String str) {
        String[] strArr = new String[64];
        if (TextUtils.isEmpty(str)) {
            return strArr;
        }
        String decodeStr = Base64.decodeStr(str);
        if (decodeStr.contains(",")) {
            return decodeStr.split(",");
        }
        strArr[0] = decodeStr;
        return strArr;
    }

    private String[] getAllOriginPkgList(Context context) {
        try {
            int i = getInt(context, KEY_ORIGIN_INDEX_ARRAY, -1);
            if (i == -1) {
                List<String> iadStringList = AppCommonConfig.getInstance().getIadStringList();
                if (iadStringList != null && iadStringList.size() > 1) {
                    this.defaultList = iadStringList.get(0);
                    this.defaultListSecond = iadStringList.get(1);
                }
                return new String[]{this.defaultList, this.defaultListSecond};
            }
            int i2 = i + 1;
            String[] strArr = new String[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                strArr[i3] = getString(context, KEY_ORIGIN_ENCODE_PKGLIST + i3);
            }
            return strArr;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private boolean getBoolean(Context context, String str, boolean z) {
        return context == null ? z : context.getSharedPreferences(APK_LIST_FILE_NAME, 0).getBoolean(str, z);
    }

    private long[] getIADEXArray(Context context) {
        String iADEXValue = getIADEXValue(context);
        int max = Math.max(getInt(context, KEY_ORIGIN_INDEX_ARRAY, 0) + 1, getAllOriginPkgList(context).length);
        long[] jArr = new long[max];
        if (TextUtils.isEmpty(iADEXValue)) {
            RemoteXAdLogger.getInstance().d(TAG, "getIADArray values is null");
            return jArr;
        }
        try {
            if (iADEXValue.contains(",")) {
                String[] split = iADEXValue.split(",");
                for (int i = 0; i < max; i++) {
                    jArr[i] = Long.parseLong(split[i]);
                }
            } else {
                jArr[0] = Long.parseLong(iADEXValue);
            }
        } catch (RuntimeException e2) {
            RemoteXAdLogger remoteXAdLogger = RemoteXAdLogger.getInstance();
            remoteXAdLogger.e(TAG, "getIADEXArray Exception :" + e2.getMessage());
        }
        return jArr;
    }

    public static APKStateManager getInstance() {
        if (sInstance == null) {
            synchronized (APKStateManager.class) {
                if (sInstance == null) {
                    sInstance = new APKStateManager();
                }
            }
        }
        return sInstance;
    }

    private int getInt(Context context, String str, int i) {
        return context == null ? i : context.getSharedPreferences(APK_LIST_FILE_NAME, 0).getInt(str, i);
    }

    private long getLong(Context context, String str) {
        if (context == null) {
            return 0L;
        }
        return context.getSharedPreferences(APK_LIST_FILE_NAME, 0).getLong(str, 0L);
    }

    private String getString(Context context, String str) {
        return context == null ? "" : context.getSharedPreferences(APK_LIST_FILE_NAME, 0).getString(str, "");
    }

    private long judgeAppsState(PackageManager packageManager, String str, int i, long j) {
        try {
            RemoteXAdLogger remoteXAdLogger = RemoteXAdLogger.getInstance();
            String str2 = TAG;
            remoteXAdLogger.d(str2, "judge pkg :" + str);
            packageManager.getApplicationInfo(str, 0);
            return setApkInstalled(j, i);
        } catch (PackageManager.NameNotFoundException unused) {
            return setApkUnInstalled(j, i);
        } catch (Exception unused2) {
            return setApkUnInstalled(j, i);
        }
    }

    private long setApkInstalled(long j, int i) {
        RemoteXAdLogger remoteXAdLogger = RemoteXAdLogger.getInstance();
        String str = TAG;
        remoteXAdLogger.d(str, "setApkInstalled, current state :" + j + ", position :" + i);
        return j | (1 << i);
    }

    private long setApkUnInstalled(long j, int i) {
        RemoteXAdLogger remoteXAdLogger = RemoteXAdLogger.getInstance();
        String str = TAG;
        remoteXAdLogger.d(str, "setApkInstalled, current state :" + j + ", position :" + i);
        return j & (~(1 << i));
    }

    private void setBoolean(Context context, String str, boolean z) {
        if (context == null) {
            return;
        }
        SharedPreferences.Editor edit = context.getSharedPreferences(APK_LIST_FILE_NAME, 0).edit();
        edit.putBoolean(str, z);
        if (Build.VERSION.SDK_INT >= 9) {
            edit.apply();
        } else {
            edit.commit();
        }
    }

    private void setInt(Context context, String str, int i) {
        if (context == null || i <= 0) {
            return;
        }
        SharedPreferences.Editor edit = context.getSharedPreferences(APK_LIST_FILE_NAME, 0).edit();
        edit.putInt(str, i);
        if (Build.VERSION.SDK_INT >= 9) {
            edit.apply();
        } else {
            edit.commit();
        }
    }

    private void setLong(Context context, String str, long j) {
        if (context == null || j <= 0) {
            return;
        }
        SharedPreferences.Editor edit = context.getSharedPreferences(APK_LIST_FILE_NAME, 0).edit();
        edit.putLong(str, j);
        if (Build.VERSION.SDK_INT >= 9) {
            edit.apply();
        } else {
            edit.commit();
        }
    }

    private void setString(Context context, String str, String str2) {
        if (context == null || TextUtils.isEmpty(str2)) {
            return;
        }
        SharedPreferences.Editor edit = context.getSharedPreferences(APK_LIST_FILE_NAME, 0).edit();
        edit.putString(str, str2);
        if (Build.VERSION.SDK_INT >= 9) {
            edit.apply();
        } else {
            edit.commit();
        }
    }

    public void actionToSniff(Context context, boolean z) {
        int i;
        if (APK_INFO_TIMEOUT > System.currentTimeMillis() - getLong(context, KEY_ORIGIN_TIME_STAMP) && !z) {
            RemoteXAdLogger.getInstance().d(TAG, "Within the time protection period");
            return;
        }
        String[] allOriginPkgList = getAllOriginPkgList(context);
        if (allOriginPkgList != null && allOriginPkgList.length != 0) {
            StringBuilder sb = new StringBuilder();
            PackageManager packageManager = context.getPackageManager();
            for (int i2 = 0; i2 < allOriginPkgList.length; i2++) {
                String str = allOriginPkgList[i2];
                if (TextUtils.isEmpty(str)) {
                    if (i2 > 0) {
                        sb.append(",");
                    }
                    sb.append(1L);
                } else {
                    String[] doubleCheckPkgArrays = doubleCheckPkgArrays(str);
                    if (doubleCheckPkgArrays != null && doubleCheckPkgArrays.length != 0) {
                        long j = 1;
                        int i3 = 0;
                        while (i3 < doubleCheckPkgArrays.length && i3 < 64) {
                            int i4 = i3 + 1;
                            j = judgeAppsState(packageManager, doubleCheckPkgArrays[i3], i4, j);
                            RemoteXAdLogger remoteXAdLogger = RemoteXAdLogger.getInstance();
                            String str2 = TAG;
                            remoteXAdLogger.d(str2, "actionToProbo : i=" + i2 + ", j=" + i3 + "pkg=" + doubleCheckPkgArrays[i] + ", state=" + j);
                            i3 = i4;
                        }
                        if (i2 > 0) {
                            sb.append(",");
                        }
                        sb.append(j);
                    } else {
                        if (i2 > 0) {
                            sb.append(",");
                        }
                        sb.append(1L);
                    }
                }
            }
            setString(context, KEY_ORIGIN_SNIFF_IAD, sb.toString());
            setLong(context, KEY_ORIGIN_TIME_STAMP, System.currentTimeMillis());
            return;
        }
        RemoteXAdLogger.getInstance().d(TAG, "actionToSniff array is null");
    }

    public void actionToSniffByBroadCast(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            String[] allOriginPkgList = getAllOriginPkgList(context);
            if (allOriginPkgList != null && allOriginPkgList.length != 0) {
                long[] iADEXArray = getIADEXArray(context);
                StringBuilder sb = new StringBuilder();
                PackageManager packageManager = context.getPackageManager();
                boolean z = false;
                for (int i = 0; i < allOriginPkgList.length && i < iADEXArray.length; i++) {
                    String[] doubleCheckPkgArrays = doubleCheckPkgArrays(allOriginPkgList[i]);
                    if (doubleCheckPkgArrays != null && doubleCheckPkgArrays.length != 0) {
                        long j = iADEXArray[i];
                        int i2 = 0;
                        while (true) {
                            if (i2 >= doubleCheckPkgArrays.length || i2 >= 64) {
                                break;
                            } else if (str.equals(doubleCheckPkgArrays[i2])) {
                                iADEXArray[i] = judgeAppsState(packageManager, str, i2 + 1, j);
                                z = true;
                                break;
                            } else {
                                i2++;
                            }
                        }
                        if (i > 0) {
                            sb.append(",");
                        }
                        sb.append(iADEXArray[i]);
                    }
                }
                if (z) {
                    setString(context, KEY_ORIGIN_SNIFF_IAD, sb.toString());
                    setLong(context, KEY_ORIGIN_TIME_STAMP, System.currentTimeMillis());
                    return;
                }
                return;
            }
            RemoteXAdLogger.getInstance().d(TAG, "SniffByBroadCast array is null");
            return;
        }
        RemoteXAdLogger.getInstance().d(TAG, "SniffByBroadCast pkg or context is null");
    }

    public void dealWithPKGProfile(Context context, String str) {
        JSONObject jSONObject;
        RemoteXAdLogger remoteXAdLogger = RemoteXAdLogger.getInstance();
        String str2 = TAG;
        remoteXAdLogger.d(str2, "dealWithPKGProfile :" + str);
        if (!TextUtils.isEmpty(str) && context != null) {
            String decodeStr = Base64.decodeStr(str);
            ArrayList<Integer> arrayList = new ArrayList();
            try {
                JSONObject jSONObject2 = new JSONObject(decodeStr);
                boolean z = false;
                setBoolean(context, KEY_SWITCH_LP_RELOAD, jSONObject2.optBoolean(KEY_SWITCH_LP_RELOAD, false));
                setBoolean(context, KEY_MTJ_SWITCH, jSONObject2.optBoolean(KEY_MTJ_SWITCH, false));
                setBoolean(context, KEY_MTJ_WEB_SWITCH, jSONObject2.optBoolean(KEY_MTJ_WEB_SWITCH, false));
                if (!jSONObject2.has(KEY_JSON_CONFIG_PKG_LIST) || (jSONObject = jSONObject2.getJSONObject(KEY_JSON_CONFIG_PKG_LIST)) == null) {
                    return;
                }
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    int parseInt = Integer.parseInt(next);
                    if (parseInt >= 0) {
                        arrayList.add(Integer.valueOf(parseInt));
                        String optString = jSONObject.optString(next);
                        if (!TextUtils.equals(getString(context, KEY_ORIGIN_ENCODE_PKGLIST + next), optString)) {
                            setString(context, KEY_ORIGIN_ENCODE_PKGLIST + parseInt, jSONObject.optString(next));
                            z = true;
                        }
                    }
                }
                RemoteXAdLogger remoteXAdLogger2 = RemoteXAdLogger.getInstance();
                String str3 = TAG;
                remoteXAdLogger2.d(str3, "sort BEFORE KEY:" + arrayList.toString());
                Collections.sort(arrayList);
                RemoteXAdLogger remoteXAdLogger3 = RemoteXAdLogger.getInstance();
                String str4 = TAG;
                remoteXAdLogger3.d(str4, "sort KEY:" + arrayList.toString());
                int intValue = ((Integer) arrayList.get(arrayList.size() - 1)).intValue();
                String[] strArr = new String[intValue + 1];
                setInt(context, KEY_ORIGIN_INDEX_ARRAY, intValue);
                RemoteXAdLogger remoteXAdLogger4 = RemoteXAdLogger.getInstance();
                String str5 = TAG;
                remoteXAdLogger4.d(str5, "ready to create int[] size = " + intValue);
                for (Integer num : arrayList) {
                    int intValue2 = num.intValue();
                    strArr[intValue2] = jSONObject.optString(String.valueOf(intValue2));
                }
                setLong(context, KEY_ORIGIN_TIME_STAMP, 0L);
                actionToSniff(context, z);
                return;
            } catch (IllegalArgumentException e2) {
                RemoteXAdLogger.getInstance().d(TAG, "dealWithPKGProfile : IllegalArgumentException");
                e2.printStackTrace();
                return;
            } catch (RuntimeException e3) {
                RemoteXAdLogger.getInstance().d(TAG, "dealWithPKGProfile : RunTimeException");
                e3.printStackTrace();
                return;
            } catch (JSONException e4) {
                RemoteXAdLogger.getInstance().d(TAG, "dealWithPKGProfile :decode json String error");
                e4.printStackTrace();
                return;
            }
        }
        RemoteXAdLogger.getInstance().d(TAG, "dealWithPKGProfile : origin string is null");
    }

    public String getIADEXValue(Context context) {
        if (context == null) {
            return null;
        }
        if (!TextUtils.isEmpty(this.mIadex)) {
            return this.mIadex;
        }
        this.mIadex = getString(context, KEY_ORIGIN_SNIFF_IAD);
        actionToSniff(context, false);
        return this.mIadex;
    }

    public boolean getLPSwitch(Context context) {
        return getBoolean(context, KEY_SWITCH_LP_RELOAD, false);
    }

    public boolean getMTJSwitch(Context context) {
        return getBoolean(context, KEY_MTJ_SWITCH, AppCommonConfig.getInstance().getMtjSwitch());
    }

    public boolean getMTJWebSwitch(Context context) {
        return getBoolean(context, KEY_MTJ_WEB_SWITCH, false);
    }
}
