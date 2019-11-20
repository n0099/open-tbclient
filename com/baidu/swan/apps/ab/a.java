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
    private SparseArray<InterfaceC0152a> bat = new SparseArray<>();

    /* renamed from: com.baidu.swan.apps.ab.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0152a {
        void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr);
    }

    @TargetApi(23)
    public void a(Activity activity, int i, @NonNull String[] strArr, InterfaceC0152a interfaceC0152a) {
        if (interfaceC0152a != null) {
            this.bat.put(i, interfaceC0152a);
            activity.requestPermissions(strArr, i);
            if (DEBUG) {
                Log.d("SwanAppPermission", "requestPermissions activity: " + activity + " requestCode: " + i + " permissions: " + Arrays.toString(strArr));
            }
        }
    }

    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        InterfaceC0152a interfaceC0152a = this.bat.get(i);
        if (interfaceC0152a != null) {
            interfaceC0152a.onRequestPermissionsResult(i, strArr, iArr);
            this.bat.remove(i);
        }
        if (DEBUG) {
            Log.d("SwanAppPermission", "onRequestPermissionsResult requestCode: " + i + " permissions: " + Arrays.toString(strArr));
            Log.d("SwanAppPermission", "onRequestPermissionsResult grantResults: " + Arrays.toString(iArr));
        }
    }
}
