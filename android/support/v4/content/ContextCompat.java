package android.support.v4.content;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import java.io.File;
/* loaded from: classes.dex */
public class ContextCompat {
    private static final String DIR_ANDROID = "Android";
    private static final String DIR_CACHE = "cache";
    private static final String DIR_DATA = "data";
    private static final String DIR_FILES = "files";
    private static final String DIR_OBB = "obb";

    public static boolean startActivities(Context context, Intent[] intentArr) {
        return startActivities(context, intentArr, null);
    }

    public static boolean startActivities(Context context, Intent[] intentArr, Bundle bundle) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 16) {
            ContextCompatJellybean.startActivities(context, intentArr, bundle);
            return true;
        } else if (i >= 11) {
            ContextCompatHoneycomb.startActivities(context, intentArr);
            return true;
        } else {
            return false;
        }
    }

    public static File[] getObbDirs(Context context) {
        File buildPath;
        int i = Build.VERSION.SDK_INT;
        if (i >= 19) {
            return ContextCompatKitKat.getObbDirs(context);
        }
        if (i >= 11) {
            buildPath = ContextCompatHoneycomb.getObbDir(context);
        } else {
            buildPath = buildPath(Environment.getExternalStorageDirectory(), DIR_ANDROID, DIR_OBB, context.getPackageName());
        }
        return new File[]{buildPath};
    }

    public static File[] getExternalFilesDirs(Context context, String str) {
        File buildPath;
        int i = Build.VERSION.SDK_INT;
        if (i >= 19) {
            return ContextCompatKitKat.getExternalFilesDirs(context, str);
        }
        if (i >= 8) {
            buildPath = ContextCompatFroyo.getExternalFilesDir(context, str);
        } else {
            buildPath = buildPath(Environment.getExternalStorageDirectory(), DIR_ANDROID, "data", context.getPackageName(), DIR_FILES, str);
        }
        return new File[]{buildPath};
    }

    public static File[] getExternalCacheDirs(Context context) {
        File buildPath;
        int i = Build.VERSION.SDK_INT;
        if (i >= 19) {
            return ContextCompatKitKat.getExternalCacheDirs(context);
        }
        if (i >= 8) {
            buildPath = ContextCompatFroyo.getExternalCacheDir(context);
        } else {
            buildPath = buildPath(Environment.getExternalStorageDirectory(), DIR_ANDROID, "data", context.getPackageName(), DIR_CACHE);
        }
        return new File[]{buildPath};
    }

    private static File buildPath(File file, String... strArr) {
        File file2;
        int length = strArr.length;
        int i = 0;
        File file3 = file;
        while (i < length) {
            String str = strArr[i];
            if (file3 == null) {
                file2 = new File(str);
            } else {
                file2 = str != null ? new File(file3, str) : file3;
            }
            i++;
            file3 = file2;
        }
        return file3;
    }
}
