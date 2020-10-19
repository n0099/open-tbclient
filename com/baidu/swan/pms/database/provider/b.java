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
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.pms.d;
import com.baidu.webkit.internal.ETAG;
/* loaded from: classes15.dex */
public class b {
    private Context mContext;
    public static final String dvL = AppRuntime.getAppContext().getPackageName() + ".aiapp.pms";
    public static final Uri dTi = Uri.parse("content://" + dvL + "/framework");
    public static final Uri dTj = Uri.parse("content://" + dvL + "/swan_app");
    public static final Uri dTk = Uri.parse("content://" + dvL + "/pkg_main");
    public static final Uri dTl = Uri.parse("content://" + dvL + "/pkg_sub");
    public static final Uri dTm = Uri.parse("content://" + dvL + "/" + ETAG.KEY_EXTENSION);
    public static final Uri dTn = Uri.parse("content://" + dvL + "/swan_plugin");
    public static final Uri dTo = Uri.parse("content://" + dvL + "/so_lib");
    public static final Uri dTp = Uri.parse("content://" + dvL + "/swan_mini_pkg");
    private static UriMatcher dTq = new UriMatcher(-1);

    static {
        dTq.addURI(dvL, "framework", 2);
        dTq.addURI(dvL, "pkg_main", 0);
        dTq.addURI(dvL, "pkg_sub", 1);
        dTq.addURI(dvL, ETAG.KEY_EXTENSION, 3);
        dTq.addURI(dvL, "swan_app", 4);
        dTq.addURI(dvL, "swan_plugin", 5);
        dTq.addURI(dvL, "swan_mini_pkg", 6);
        dTq.addURI(dvL, "so_lib", 7);
    }

    public b(Context context) {
        this.mContext = context;
    }

    private String o(Uri uri) {
        switch (dTq.match(uri)) {
            case 0:
                return "pkg_main";
            case 1:
                return "pkg_sub";
            case 2:
                return "framework";
            case 3:
                return ETAG.KEY_EXTENSION;
            case 4:
                return "swan_app";
            case 5:
                return "swan_plugin";
            case 6:
                return "swan_mini_pkg";
            case 7:
                return "so_lib";
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
        String o = o(uri);
        if (!TextUtils.isEmpty(o)) {
            if (d.DEBUG) {
                Log.e("PMSDBProvider", "query");
            }
            try {
                return aof().getReadableDatabase().query(o, strArr, str, strArr2, null, null, str2, null);
            } catch (SQLException e) {
                if (d.DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    @Nullable
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        Log.e("PMSDBProvider", "name:" + Thread.currentThread().getName());
        String o = o(uri);
        if (!TextUtils.isEmpty(o) && contentValues != null) {
            if (d.DEBUG) {
                Log.e("PMSDBProvider", "insert:" + contentValues.toString());
            }
            try {
                long insertWithOnConflict = aof().getWritableDatabase().insertWithOnConflict(o, null, contentValues, 5);
                if (insertWithOnConflict > 0) {
                    Uri withAppendedId = ContentUris.withAppendedId(uri, insertWithOnConflict);
                    this.mContext.getContentResolver().notifyChange(withAppendedId, null);
                    return withAppendedId;
                }
                return uri;
            } catch (SQLException e) {
                if (d.DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public int delete(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        String o = o(uri);
        if (!TextUtils.isEmpty(o)) {
            if (d.DEBUG) {
                Log.e("PMSDBProvider", "delete");
            }
            try {
                int delete = aof().getWritableDatabase().delete(o, str, strArr);
                if (delete > 0) {
                    this.mContext.getContentResolver().notifyChange(uri, null);
                    return delete;
                }
                return delete;
            } catch (SQLException e) {
                if (d.DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        return 0;
    }

    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        String o = o(uri);
        if (!TextUtils.isEmpty(o)) {
            if (d.DEBUG) {
                Log.e("PMSDBProvider", IMTrack.DbBuilder.ACTION_UPDATE);
            }
            try {
                int update = aof().getWritableDatabase().update(o, contentValues, str, strArr);
                if (update > 0) {
                    this.mContext.getContentResolver().notifyChange(uri, null);
                    return update;
                }
                return update;
            } catch (SQLException e) {
                if (d.DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SQLiteOpenHelper aof() {
        return a.aWV();
    }
}
