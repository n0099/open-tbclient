package com.baidu.searchbox.common.security;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.util.io.StreamUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
/* loaded from: classes3.dex */
public final class PermissionCheckUtils {
    public static boolean DEBUG = SecurityConfig.DEBUG;
    public static final String PRESET_WHITE_LIST_FILE_PATH = "preset/security/activity_white_list.json";
    public static final String TAG = "PermissionCheckUtils";
    public static final String WHITE_LIST_CACHE_FILE_NAME = "activity_white_list.json";
    public static String sActivityWhiteList;

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0018 -> B:31:0x0031). Please submit an issue!!! */
    public static boolean cache(Context context, String str, byte[] bArr, int i) {
        boolean z = false;
        if (bArr == null) {
            bArr = new byte[0];
        }
        FileOutputStream fileOutputStream = null;
        try {
            try {
                try {
                    try {
                        fileOutputStream = context.openFileOutput(str, i);
                        fileOutputStream.write(bArr);
                        fileOutputStream.flush();
                        z = true;
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } catch (FileNotFoundException e2) {
                    e2.printStackTrace();
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                }
            } catch (IOException e3) {
                e3.printStackTrace();
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            }
            return z;
        } catch (Throwable th) {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
            throw th;
        }
    }

    public static boolean checkActivityPermission(Context context, Intent intent) {
        return checkActivityPermission(context, intent, false);
    }

    public static boolean checkActivityWhiteList(String str, Context context) {
        if (sActivityWhiteList == null) {
            loadActivityWhiteList(context);
        }
        if (TextUtils.isEmpty(sActivityWhiteList) || !sActivityWhiteList.contains(str)) {
            return false;
        }
        return true;
    }

    public static boolean isCacheFileExist(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                return new File(context.getFilesDir(), str).exists();
            } catch (SecurityException unused) {
            }
        }
        return false;
    }

    public static void saveActivityWhiteList(Context context, String str) {
        if (DEBUG) {
            Log.d(TAG, "save white list data to cache. data = " + str);
        }
        cache(context, WHITE_LIST_CACHE_FILE_NAME, str.getBytes(), 0);
        sActivityWhiteList = str;
    }

    @SuppressLint({"QueryPermissionsNeeded"})
    public static boolean checkActivityPermission(Context context, Intent intent, boolean z) {
        ResolveInfo resolveActivity;
        if (context != null && intent != null && (resolveActivity = context.getPackageManager().resolveActivity(intent, 65536)) != null) {
            if (DEBUG) {
                Log.i(TAG, "checkActivityPermission resolveInfo packageName:" + resolveActivity.activityInfo.packageName);
            }
            if (z) {
                try {
                    List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 64);
                    if (queryIntentActivities != null && queryIntentActivities.size() > 0) {
                        boolean z2 = false;
                        for (ResolveInfo resolveInfo : queryIntentActivities) {
                            if (TextUtils.equals(resolveInfo.activityInfo.packageName, AppRuntime.getAppContext().getPackageName())) {
                                if (queryIntentActivities.size() > 1) {
                                    intent.setPackage(context.getPackageName());
                                }
                                z2 = true;
                            }
                        }
                        if (!z2) {
                            new JsHttpSecureStatistic().setJsType("4").setCmd(intent.toString()).setPackageName(resolveActivity.activityInfo.packageName).statisticCmd();
                            return false;
                        }
                    }
                } catch (Exception e) {
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
            ActivityInfo activityInfo = resolveActivity.activityInfo;
            if (activityInfo.exported || checkActivityWhiteList(activityInfo.name, context)) {
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:24:0x0032 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0035 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r3v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.io.InputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getActivityPresetList(Context context) {
        Throwable th;
        InputStream inputStream;
        try {
            try {
                inputStream = context.getAssets().open(PRESET_WHITE_LIST_FILE_PATH);
                try {
                    String streamToString = StreamUtils.streamToString(inputStream);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    return streamToString;
                } catch (IOException e2) {
                    e = e2;
                    e.printStackTrace();
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    return null;
                }
            } catch (Throwable th2) {
                th = th2;
                if (context != 0) {
                    try {
                        context.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (IOException e5) {
            e = e5;
            inputStream = null;
        } catch (Throwable th3) {
            th = th3;
            context = 0;
            if (context != 0) {
            }
            throw th;
        }
    }

    public static void loadActivityWhiteList(Context context) {
        if (!isCacheFileExist(context, WHITE_LIST_CACHE_FILE_NAME)) {
            if (DEBUG) {
                Log.d(TAG, "get preset data.");
            }
            sActivityWhiteList = getActivityPresetList(context);
            return;
        }
        if (DEBUG) {
            Log.d(TAG, "get cache data.");
        }
        sActivityWhiteList = readCacheData(context, WHITE_LIST_CACHE_FILE_NAME);
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, MOVE_EXCEPTION, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    public static String readCacheData(Context context, String str) {
        StringBuilder sb = new StringBuilder();
        FileInputStream fileInputStream = null;
        try {
            try {
                fileInputStream = context.openFileInput(str);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb.append(readLine);
                }
                String sb2 = sb.toString();
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                return sb2;
            } catch (FileNotFoundException e2) {
                e2.printStackTrace();
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
                return "";
            } catch (IOException e4) {
                e4.printStackTrace();
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                }
                return "";
            }
        } catch (Throwable th) {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e6) {
                    e6.printStackTrace();
                }
            }
            throw th;
        }
    }
}
