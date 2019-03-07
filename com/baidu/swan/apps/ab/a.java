package com.baidu.swan.apps.ab;

import android.annotation.TargetApi;
import android.app.Activity;
import android.support.annotation.NonNull;
import android.util.Log;
import android.util.SparseArray;
import com.baidu.swan.apps.c;
import java.util.Arrays;
/* loaded from: classes2.dex */
public final class a {
    private static final boolean DEBUG = c.DEBUG;
    private SparseArray<InterfaceC0078a> aEu = new SparseArray<>();

    /* renamed from: com.baidu.swan.apps.ab.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0078a {
        void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr);
    }

    @TargetApi(23)
    public void a(Activity activity, int i, @NonNull String[] strArr, InterfaceC0078a interfaceC0078a) {
        if (interfaceC0078a != null) {
            this.aEu.put(i, interfaceC0078a);
            activity.requestPermissions(strArr, i);
            if (DEBUG) {
                Log.d("SwanAppPermission", "requestPermissions activity: " + activity + " requestCode: " + i + " permissions: " + Arrays.toString(strArr));
            }
        }
    }

    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        InterfaceC0078a interfaceC0078a = this.aEu.get(i);
        if (interfaceC0078a != null) {
            interfaceC0078a.onRequestPermissionsResult(i, strArr, iArr);
            this.aEu.remove(i);
        }
        if (DEBUG) {
            Log.d("SwanAppPermission", "onRequestPermissionsResult requestCode: " + i + " permissions: " + Arrays.toString(strArr));
            Log.d("SwanAppPermission", "onRequestPermissionsResult grantResults: " + Arrays.toString(iArr));
        }
    }
}
