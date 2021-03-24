package com.baidu.swan.veloce;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.common.runtime.AppRuntime;
import d.b.g0.r.b;
/* loaded from: classes3.dex */
public class VeloceAppIpcProvider extends ContentProvider {
    public static final boolean DEBUG = false;
    public static final String IPC_APP_CALL_VELOCE_AUTHORITY = "com.baidu.searchbox.veloce.ipc";
    public static final String PARAMS_ACTION = "action";
    public static final String PARAMS_DATA = "data";
    public static final String PARAMS_PACKAGE = "package";
    public static final String TAG = "VeloceAppIpcProvider";
    public static final String AUTHORITY = AppRuntime.getAppContext().getPackageName() + ".veloce.ipc";
    public static final Uri SWAN_VELOCE_PROVIDER_URI = Uri.parse("content://" + AUTHORITY);
    public static final Uri VELOCE_IPC_AUTHORITY = Uri.parse("content://com.baidu.searchbox.veloce.ipc");
    public static String IPC_VELOCE_CALL_APP = "ipc_veloce_call_app";
    public static String IPC_APP_CALL_VELOCE = "ipc_app_call_veloce";

    private Bundle dispatchToSwan(String str, Bundle bundle) {
        if (TextUtils.isEmpty(str) || b.a() == null) {
            return null;
        }
        return b.a().a(str, bundle);
    }

    private Bundle dispatchVeloceCall(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        String string = bundle.getString("package");
        String string2 = bundle.getString("action");
        Bundle bundle2 = bundle.getBundle("data");
        if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2)) {
            return null;
        }
        return dispatchToSwan(string2, bundle2);
    }

    @Override // android.content.ContentProvider
    public Bundle call(String str, String str2, Bundle bundle) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (IPC_VELOCE_CALL_APP.equals(str)) {
            return dispatchVeloceCall(bundle);
        }
        if (IPC_APP_CALL_VELOCE.equals(str)) {
            return callVeloce(AppRuntime.getAppContext(), bundle);
        }
        return null;
    }

    public Bundle callVeloce(Context context, Bundle bundle) {
        if (bundle == null || TextUtils.isEmpty(bundle.getString("action"))) {
            return null;
        }
        String string = bundle.getString("action");
        Bundle bundle2 = bundle.getBundle("data");
        Bundle bundle3 = new Bundle();
        bundle3.putString("package", context.getPackageName());
        bundle3.putString("action", string);
        bundle3.putBundle("data", bundle2);
        try {
            return context.getContentResolver().call(VELOCE_IPC_AUTHORITY, IPC_APP_CALL_VELOCE, (String) null, bundle3);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // android.content.ContentProvider
    public int delete(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        return -1;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public String getType(@NonNull Uri uri) {
        return "";
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    @NonNull
    public Cursor query(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        return -1;
    }
}
