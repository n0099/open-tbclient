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
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.database.SwanAppDbControl;
import com.baidu.swan.apps.database.subpackage.SubPackageTable;
/* loaded from: classes2.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static final String aPs = AppRuntime.getAppContext().getPackageName() + ".swan.subpackage";
    public static final Uri aPt = Uri.parse("content://" + aPs + "/" + SubPackageTable.Table.TABLE_NAME);
    private static UriMatcher aPu = new UriMatcher(-1);
    private SQLiteOpenHelper aPv;
    private Context mContext;

    static {
        aPu.addURI(aPs, SubPackageTable.Table.TABLE_NAME, 0);
    }

    public b(Context context) {
        this.mContext = context;
    }

    private String c(Uri uri) {
        switch (aPu.match(uri)) {
            case 0:
                return SubPackageTable.Table.TABLE_NAME;
            default:
                return null;
        }
    }

    @Nullable
    public Cursor query(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        String c = c(uri);
        if (TextUtils.isEmpty(c)) {
            return null;
        }
        if (DEBUG) {
            Log.e("SubPackageProvider", "query");
        }
        return Hn().getReadableDatabase().query(c, strArr, str, strArr2, null, null, str2, null);
    }

    @Nullable
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        String c = c(uri);
        if (TextUtils.isEmpty(c) || contentValues == null) {
            return null;
        }
        if (DEBUG) {
            Log.e("SubPackageProvider", "insert:" + contentValues.toString());
        }
        Hn().getWritableDatabase().insertWithOnConflict(c, null, contentValues, 5);
        this.mContext.getContentResolver().notifyChange(uri, null);
        return uri;
    }

    public int delete(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        String c = c(uri);
        if (TextUtils.isEmpty(c)) {
            return 0;
        }
        if (DEBUG) {
            Log.e("SubPackageProvider", "delete");
        }
        int delete = Hn().getWritableDatabase().delete(c, str, strArr);
        if (delete > 0) {
            this.mContext.getContentResolver().notifyChange(uri, null);
            return delete;
        }
        return delete;
    }

    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        String c = c(uri);
        if (TextUtils.isEmpty(c)) {
            return 0;
        }
        if (DEBUG) {
            Log.e("SubPackageProvider", IMTrack.DbBuilder.ACTION_UPDATE);
        }
        int update = Hn().getWritableDatabase().update(c, contentValues, str, strArr);
        if (update > 0) {
            this.mContext.getContentResolver().notifyChange(uri, null);
            return update;
        }
        return update;
    }

    private SQLiteOpenHelper Hn() {
        if (this.aPv == null) {
            this.aPv = SwanAppDbControl.aZ(this.mContext).Hn();
        }
        return this.aPv;
    }
}
