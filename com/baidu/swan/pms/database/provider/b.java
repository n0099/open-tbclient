package com.baidu.swan.pms.database.provider;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.pms.e;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
/* loaded from: classes2.dex */
public class b {
    private Context mContext;
    public static final String AUTHORITY = AppRuntime.getAppContext().getPackageName() + ".aiapp.pms";
    public static final Uri blH = Uri.parse("content://" + AUTHORITY + "/framework");
    public static final Uri blI = Uri.parse("content://" + AUTHORITY + "/swan_app");
    public static final Uri blJ = Uri.parse("content://" + AUTHORITY + "/pkg_main");
    public static final Uri auG = Uri.parse("content://" + AUTHORITY + "/pkg_sub");
    public static final Uri blK = Uri.parse("content://" + AUTHORITY + "/extension");
    private static UriMatcher auH = new UriMatcher(-1);

    static {
        auH.addURI(AUTHORITY, "framework", 2);
        auH.addURI(AUTHORITY, "pkg_main", 0);
        auH.addURI(AUTHORITY, "pkg_sub", 1);
        auH.addURI(AUTHORITY, "extension", 3);
        auH.addURI(AUTHORITY, "swan_app", 4);
    }

    public b(Context context) {
        this.mContext = context;
    }

    private String e(Uri uri) {
        switch (auH.match(uri)) {
            case 0:
                return "pkg_main";
            case 1:
                return "pkg_sub";
            case 2:
                return "framework";
            case 3:
                return "extension";
            case 4:
                return "swan_app";
            default:
                return null;
        }
    }

    @Nullable
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    public Cursor query(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        String e = e(uri);
        if (!TextUtils.isEmpty(e)) {
            if (e.DEBUG) {
                Log.e("PMSDBProvider", "query");
            }
            try {
                return AA().getReadableDatabase().query(e, strArr, str, strArr2, null, null, str2, null);
            } catch (SQLException e2) {
                if (e.DEBUG) {
                    e2.printStackTrace();
                }
            }
        }
        return null;
    }

    @Nullable
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        Log.e("PMSDBProvider", "name:" + Thread.currentThread().getName());
        String e = e(uri);
        if (!TextUtils.isEmpty(e) && contentValues != null) {
            if (e.DEBUG) {
                Log.e("PMSDBProvider", "insert:" + contentValues.toString());
            }
            try {
                long insertWithOnConflict = AA().getWritableDatabase().insertWithOnConflict(e, null, contentValues, 5);
                if (insertWithOnConflict > 0) {
                    Uri withAppendedId = ContentUris.withAppendedId(uri, insertWithOnConflict);
                    this.mContext.getContentResolver().notifyChange(withAppendedId, null);
                    return withAppendedId;
                }
                return uri;
            } catch (SQLException e2) {
                if (e.DEBUG) {
                    e2.printStackTrace();
                }
            }
        }
        return null;
    }

    public int delete(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        String e = e(uri);
        if (!TextUtils.isEmpty(e)) {
            if (e.DEBUG) {
                Log.e("PMSDBProvider", WriteImageActivityConfig.DELET_FLAG);
            }
            try {
                int delete = AA().getWritableDatabase().delete(e, str, strArr);
                if (delete > 0) {
                    this.mContext.getContentResolver().notifyChange(uri, null);
                    return delete;
                }
                return delete;
            } catch (SQLException e2) {
                if (e.DEBUG) {
                    e2.printStackTrace();
                }
            }
        }
        return 0;
    }

    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        String e = e(uri);
        if (!TextUtils.isEmpty(e)) {
            if (e.DEBUG) {
                Log.e("PMSDBProvider", "update");
            }
            try {
                int update = AA().getWritableDatabase().update(e, contentValues, str, strArr);
                if (update > 0) {
                    this.mContext.getContentResolver().notifyChange(uri, null);
                    return update;
                }
                return update;
            } catch (SQLException e2) {
                if (e.DEBUG) {
                    e2.printStackTrace();
                }
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SQLiteOpenHelper AA() {
        return a.RG();
    }
}
