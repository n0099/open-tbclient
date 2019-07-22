package com.baidu.swan.apps.database.subpackage;

import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.database.SwanAppDbControl;
import com.baidu.swan.apps.database.subpackage.SubPackageTable;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
/* loaded from: classes2.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static final String avF = AppRuntime.getAppContext().getPackageName() + ".swan.subpackage";
    public static final Uri avG = Uri.parse("content://" + avF + "/" + SubPackageTable.Table.TABLE_NAME);
    private static UriMatcher avH = new UriMatcher(-1);
    private SQLiteOpenHelper avI;
    private Context mContext;

    static {
        avH.addURI(avF, SubPackageTable.Table.TABLE_NAME, 0);
    }

    public b(Context context) {
        this.mContext = context;
    }

    private String e(Uri uri) {
        switch (avH.match(uri)) {
            case 0:
                return SubPackageTable.Table.TABLE_NAME;
            default:
                return null;
        }
    }

    @Nullable
    public Cursor query(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        String e = e(uri);
        if (TextUtils.isEmpty(e)) {
            return null;
        }
        if (DEBUG) {
            Log.e("SubPackageProvider", "query");
        }
        return Cp().getReadableDatabase().query(e, strArr, str, strArr2, null, null, str2, null);
    }

    @Nullable
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        String e = e(uri);
        if (TextUtils.isEmpty(e) || contentValues == null) {
            return null;
        }
        if (DEBUG) {
            Log.e("SubPackageProvider", "insert:" + contentValues.toString());
        }
        Cp().getWritableDatabase().insertWithOnConflict(e, null, contentValues, 5);
        this.mContext.getContentResolver().notifyChange(uri, null);
        return uri;
    }

    public int delete(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        String e = e(uri);
        if (TextUtils.isEmpty(e)) {
            return 0;
        }
        if (DEBUG) {
            Log.e("SubPackageProvider", WriteImageActivityConfig.DELET_FLAG);
        }
        int delete = Cp().getWritableDatabase().delete(e, str, strArr);
        if (delete > 0) {
            this.mContext.getContentResolver().notifyChange(uri, null);
            return delete;
        }
        return delete;
    }

    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        String e = e(uri);
        if (TextUtils.isEmpty(e)) {
            return 0;
        }
        if (DEBUG) {
            Log.e("SubPackageProvider", "update");
        }
        int update = Cp().getWritableDatabase().update(e, contentValues, str, strArr);
        if (update > 0) {
            this.mContext.getContentResolver().notifyChange(uri, null);
            return update;
        }
        return update;
    }

    private SQLiteOpenHelper Cp() {
        if (this.avI == null) {
            this.avI = SwanAppDbControl.aX(this.mContext).Cp();
        }
        return this.avI;
    }
}
