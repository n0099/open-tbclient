package com.baidu.swan.apps.ab;

import android.annotation.TargetApi;
import android.app.Activity;
import android.support.annotation.NonNull;
import android.util.Log;
import android.util.SparseArray;
import com.baidu.swan.apps.b;
import java.util.Arrays;
/* loaded from: classes2.dex */
public final class a {
    private static final boolean DEBUG = b.DEBUG;
    private SparseArray<InterfaceC0106a> aGZ = new SparseArray<>();

    /* renamed from: com.baidu.swan.apps.ab.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0106a {
        void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr);
    }

    @TargetApi(23)
    public void a(Activity activity, int i, @NonNull String[] strArr, InterfaceC0106a interfaceC0106a) {
        if (interfaceC0106a != null) {
            this.aGZ.put(i, interfaceC0106a);
            activity.requestPermissions(strArr, i);
            if (DEBUG) {
                Log.d("SwanAppPermission", "requestPermissions activity: " + activity + " requestCode: " + i + " permissions: " + Arrays.toString(strArr));
            }
        }
    }

    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        InterfaceC0106a interfaceC0106a = this.aGZ.get(i);
        if (interfaceC0106a != null) {
            interfaceC0106a.onRequestPermissionsResult(i, strArr, iArr);
            this.aGZ.remove(i);
        }
        if (DEBUG) {
            Log.d("SwanAppPermission", "onRequestPermissionsResult requestCode: " + i + " permissions: " + Arrays.toString(strArr));
            Log.d("SwanAppPermission", "onRequestPermissionsResult grantResults: " + Arrays.toString(iArr));
        }
    }
}
