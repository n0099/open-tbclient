package com.baidu.swan.apps.ab;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes8.dex */
public final class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile c dtH;
    private SparseArray<a> dtF = new SparseArray<>();
    private Set<String> dtG = new HashSet();

    /* loaded from: classes8.dex */
    public interface a {
        void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr);
    }

    public static c aEO() {
        if (dtH == null) {
            synchronized (com.baidu.swan.games.audio.b.b.class) {
                if (dtH == null) {
                    dtH = new c();
                }
            }
        }
        return dtH;
    }

    @TargetApi(23)
    public void a(Activity activity, int i, @NonNull String[] strArr, a aVar) {
        if (aVar != null) {
            if (!C(strArr)) {
                this.dtF.put(i, aVar);
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

    private boolean C(@NonNull String[] strArr) {
        if (strArr.length <= 0) {
            return true;
        }
        for (String str : strArr) {
            if (!TextUtils.isEmpty(str) && this.dtG.contains(str)) {
                return true;
            }
        }
        return false;
    }

    public void b(Activity activity, int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (Build.VERSION.SDK_INT >= 23) {
            b(activity, strArr, iArr);
        }
        a aVar = this.dtF.get(i);
        if (aVar != null) {
            if (strArr.length > 0 && iArr.length > 0) {
                aVar.onRequestPermissionsResult(i, strArr, iArr);
            }
            this.dtF.remove(i);
        }
        if (DEBUG) {
            Log.d("SwanAppPermission", "onRequestPermissionsResult requestCode: " + i + " permissions: " + Arrays.toString(strArr));
            Log.d("SwanAppPermission", "onRequestPermissionsResult grantResults: " + Arrays.toString(iArr));
        }
    }

    @RequiresApi(api = 23)
    private void b(Activity activity, @NonNull String[] strArr, @NonNull int[] iArr) {
        int length;
        if (Build.VERSION.SDK_INT >= 23 && activity != null && (length = strArr.length) == iArr.length && length > 0) {
            for (int i = 0; i < length; i++) {
                int i2 = iArr[i];
                String str = strArr[i];
                if (!TextUtils.isEmpty(str) && i2 == -1 && !activity.shouldShowRequestPermissionRationale(str)) {
                    this.dtG.add(str);
                }
            }
        }
    }
}
