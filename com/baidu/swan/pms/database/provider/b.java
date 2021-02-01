package com.baidu.swan.pms.database.provider;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.pms.d;
import com.baidu.webkit.internal.ETAG;
/* loaded from: classes3.dex */
public class b {
    public static final String dVG = AppRuntime.getAppContext().getPackageName() + ".aiapp.pms";
    public static final Uri etS = Uri.parse("content://" + dVG + "/framework");
    public static final Uri etT = Uri.parse("content://" + dVG + "/swan_app");
    public static final Uri etU = Uri.parse("content://" + dVG + "/pkg_main");
    public static final Uri etV = Uri.parse("content://" + dVG + "/pkg_sub");
    public static final Uri etW = Uri.parse("content://" + dVG + "/" + ETAG.KEY_EXTENSION);
    public static final Uri etX = Uri.parse("content://" + dVG + "/swan_plugin");
    public static final Uri etY = Uri.parse("content://" + dVG + "/so_lib");
    public static final Uri etZ = Uri.parse("content://" + dVG + "/swan_mini_pkg");
    private static UriMatcher eua = new UriMatcher(-1);
    private Context mContext;

    static {
        eua.addURI(dVG, "framework", 2);
        eua.addURI(dVG, "pkg_main", 0);
        eua.addURI(dVG, "pkg_sub", 1);
        eua.addURI(dVG, ETAG.KEY_EXTENSION, 3);
        eua.addURI(dVG, "swan_app", 4);
        eua.addURI(dVG, "swan_plugin", 5);
        eua.addURI(dVG, "swan_mini_pkg", 6);
        eua.addURI(dVG, "so_lib", 7);
    }

    public b(Context context) {
        this.mContext = context;
    }

    private String q(Uri uri) {
        switch (eua.match(uri)) {
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
        String q = q(uri);
        if (!TextUtils.isEmpty(q)) {
            if (d.DEBUG) {
                Log.e("PMSDBProvider", "query");
            }
            try {
                return asY().getReadableDatabase().query(q, strArr, str, strArr2, null, null, str2, null);
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
        String q = q(uri);
        if (!TextUtils.isEmpty(q) && contentValues != null) {
            if (d.DEBUG) {
                Log.e("PMSDBProvider", "insert:" + contentValues.toString());
            }
            try {
                long insertWithOnConflict = asY().getWritableDatabase().insertWithOnConflict(q, null, contentValues, 5);
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
        String q = q(uri);
        if (!TextUtils.isEmpty(q)) {
            if (d.DEBUG) {
                Log.e("PMSDBProvider", "delete");
            }
            try {
                int delete = asY().getWritableDatabase().delete(q, str, strArr);
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
        String q = q(uri);
        if (!TextUtils.isEmpty(q)) {
            if (d.DEBUG) {
                Log.e("PMSDBProvider", IMTrack.DbBuilder.ACTION_UPDATE);
            }
            try {
                int update = asY().getWritableDatabase().update(q, contentValues, str, strArr);
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
    public SQLiteOpenHelper asY() {
        return a.bcC();
    }
}
