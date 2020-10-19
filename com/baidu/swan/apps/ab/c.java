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
/* loaded from: classes10.dex */
public final class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile c cVV;
    private SparseArray<a> cVT = new SparseArray<>();
    private Set<String> cVU = new HashSet();

    /* loaded from: classes10.dex */
    public interface a {
        void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr);
    }

    public static c azW() {
        if (cVV == null) {
            synchronized (com.baidu.swan.games.audio.b.b.class) {
                if (cVV == null) {
                    cVV = new c();
                }
            }
        }
        return cVV;
    }

    @TargetApi(23)
    public void a(Activity activity, int i, @NonNull String[] strArr, a aVar) {
        if (aVar != null) {
            if (!u(strArr)) {
                this.cVT.put(i, aVar);
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

    private boolean u(@NonNull String[] strArr) {
        if (strArr.length <= 0) {
            return true;
        }
        for (String str : strArr) {
            if (!TextUtils.isEmpty(str) && this.cVU.contains(str)) {
                return true;
            }
        }
        return false;
    }

    public void a(Activity activity, int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (Build.VERSION.SDK_INT >= 23) {
            a(activity, strArr, iArr);
        }
        a aVar = this.cVT.get(i);
        if (aVar != null) {
            if (strArr.length > 0 && iArr.length > 0) {
                aVar.onRequestPermissionsResult(i, strArr, iArr);
            }
            this.cVT.remove(i);
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
                    this.cVU.add(str);
                }
            }
        }
    }
}
