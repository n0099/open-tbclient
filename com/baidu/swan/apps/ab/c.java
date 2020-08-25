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
/* loaded from: classes8.dex */
public final class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile c cHO;
    private SparseArray<a> cHM = new SparseArray<>();
    private Set<String> cHN = new HashSet();

    /* loaded from: classes8.dex */
    public interface a {
        void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr);
    }

    public static c awC() {
        if (cHO == null) {
            synchronized (com.baidu.swan.games.audio.b.b.class) {
                if (cHO == null) {
                    cHO = new c();
                }
            }
        }
        return cHO;
    }

    @TargetApi(23)
    public void a(Activity activity, int i, @NonNull String[] strArr, a aVar) {
        if (aVar != null) {
            if (!t(strArr)) {
                this.cHM.put(i, aVar);
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

    private boolean t(@NonNull String[] strArr) {
        if (strArr.length <= 0) {
            return true;
        }
        for (String str : strArr) {
            if (!TextUtils.isEmpty(str) && this.cHN.contains(str)) {
                return true;
            }
        }
        return false;
    }

    public void a(Activity activity, int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (Build.VERSION.SDK_INT >= 23) {
            a(activity, strArr, iArr);
        }
        a aVar = this.cHM.get(i);
        if (aVar != null) {
            if (strArr.length > 0 && iArr.length > 0) {
                aVar.onRequestPermissionsResult(i, strArr, iArr);
            }
            this.cHM.remove(i);
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
                    this.cHN.add(str);
                }
            }
        }
    }
}
