package com.baidu.swan.apps.ab;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes25.dex */
public final class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile c dpJ;
    private SparseArray<a> dpH = new SparseArray<>();
    private Set<String> dpI = new HashSet();

    /* loaded from: classes25.dex */
    public interface a {
        void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr);
    }

    public static c aGQ() {
        if (dpJ == null) {
            synchronized (com.baidu.swan.games.audio.b.b.class) {
                if (dpJ == null) {
                    dpJ = new c();
                }
            }
        }
        return dpJ;
    }

    @TargetApi(23)
    public void a(Activity activity, int i, @NonNull String[] strArr, a aVar) {
        if (aVar != null) {
            if (!v(strArr)) {
                this.dpH.put(i, aVar);
                activity.requestPermissions(strArr, i);
                if (DEBUG) {
                    Log.d("SwanAppPermission", "requestPermissions activity: " + activity + " requestCode: " + i + " permissions: " + Arrays.toString(strArr));
                    return;
                }
                return;
            }
            aVar.onRequestPermissionsResult(i, strArr, new int[]{-1});
        }
    }

    private boolean v(@NonNull String[] strArr) {
        if (strArr.length <= 0) {
            return true;
        }
        for (String str : strArr) {
            if (!TextUtils.isEmpty(str) && this.dpI.contains(str)) {
                return true;
            }
        }
        return false;
    }

    public void a(Activity activity, int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (Build.VERSION.SDK_INT >= 23) {
            a(activity, strArr, iArr);
        }
        a aVar = this.dpH.get(i);
        if (aVar != null) {
            if (strArr.length > 0 && iArr.length > 0) {
                aVar.onRequestPermissionsResult(i, strArr, iArr);
            }
            this.dpH.remove(i);
        }
        if (DEBUG) {
            Log.d("SwanAppPermission", "onRequestPermissionsResult requestCode: " + i + " permissions: " + Arrays.toString(strArr));
            Log.d("SwanAppPermission", "onRequestPermissionsResult grantResults: " + Arrays.toString(iArr));
        }
    }

    @RequiresApi(api = 23)
    private void a(Activity activity, @NonNull String[] strArr, @NonNull int[] iArr) {
        int length;
        if (Build.VERSION.SDK_INT >= 23 && activity != null && (length = strArr.length) == iArr.length && length > 0) {
            for (int i = 0; i < length; i++) {
                int i2 = iArr[i];
                String str = strArr[i];
                if (!TextUtils.isEmpty(str) && i2 == -1 && !activity.shouldShowRequestPermissionRationale(str)) {
                    this.dpI.add(str);
                }
            }
        }
    }
}
