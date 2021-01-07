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
/* loaded from: classes6.dex */
public class VeloceAppIpcProvider extends ContentProvider {
    public static final String dYm = AppRuntime.getAppContext().getPackageName() + ".veloce.ipc";
    public static final Uri eCl = Uri.parse("content://" + dYm);
    public static final Uri eCm = Uri.parse("content://com.baidu.searchbox.veloce.ipc");
    public static String eCn = "ipc_veloce_call_app";
    public static String eCo = "ipc_app_call_veloce";

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    public Bundle call(String str, String str2, Bundle bundle) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (eCn.equals(str)) {
            return ad(bundle);
        }
        if (eCo.equals(str)) {
            return f(AppRuntime.getAppContext(), bundle);
        }
        return null;
    }

    private Bundle ad(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        String string = bundle.getString("package");
        String string2 = bundle.getString("action");
        Bundle bundle2 = bundle.getBundle("data");
        if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2)) {
            return null;
        }
        return h(string2, bundle2);
    }

    private Bundle h(String str, Bundle bundle) {
        if (TextUtils.isEmpty(str) || b.bjr() == null) {
            return null;
        }
        return b.bjr().g(str, bundle);
    }

    @Override // android.content.ContentProvider
    @NonNull
    public Cursor query(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        return null;
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
    public int delete(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        return -1;
    }

    @Override // android.content.ContentProvider
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        return -1;
    }

    public Bundle f(Context context, Bundle bundle) {
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
            return context.getContentResolver().call(eCm, eCo, (String) null, bundle3);
        } catch (Exception e) {
            return null;
        }
    }
}
