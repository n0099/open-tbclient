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
/* loaded from: classes11.dex */
public class b {
    private Context mContext;
    public static final String cfG = AppRuntime.getAppContext().getPackageName() + ".aiapp.pms";
    public static final Uri cAP = Uri.parse("content://" + cfG + "/framework");
    public static final Uri cAQ = Uri.parse("content://" + cfG + "/swan_app");
    public static final Uri cAR = Uri.parse("content://" + cfG + "/pkg_main");
    public static final Uri cAS = Uri.parse("content://" + cfG + "/pkg_sub");
    public static final Uri cAT = Uri.parse("content://" + cfG + "/" + ETAG.KEY_EXTENSION);
    public static final Uri cAU = Uri.parse("content://" + cfG + "/swan_plugin");
    public static final Uri cAV = Uri.parse("content://" + cfG + "/swan_mini_pkg");
    private static UriMatcher cAW = new UriMatcher(-1);

    static {
        cAW.addURI(cfG, "framework", 2);
        cAW.addURI(cfG, "pkg_main", 0);
        cAW.addURI(cfG, "pkg_sub", 1);
        cAW.addURI(cfG, ETAG.KEY_EXTENSION, 3);
        cAW.addURI(cfG, "swan_app", 4);
        cAW.addURI(cfG, "swan_plugin", 5);
        cAW.addURI(cfG, "swan_mini_pkg", 6);
    }

    public b(Context context) {
        this.mContext = context;
    }

    private String m(Uri uri) {
        switch (cAW.match(uri)) {
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
        String m = m(uri);
        if (!TextUtils.isEmpty(m)) {
            if (d.DEBUG) {
                Log.e("PMSDBProvider", "query");
            }
            try {
                return QY().getReadableDatabase().query(m, strArr, str, strArr2, null, null, str2, null);
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
        String m = m(uri);
        if (!TextUtils.isEmpty(m) && contentValues != null) {
            if (d.DEBUG) {
                Log.e("PMSDBProvider", "insert:" + contentValues.toString());
            }
            try {
                long insertWithOnConflict = QY().getWritableDatabase().insertWithOnConflict(m, null, contentValues, 5);
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
        String m = m(uri);
        if (!TextUtils.isEmpty(m)) {
            if (d.DEBUG) {
                Log.e("PMSDBProvider", "delete");
            }
            try {
                int delete = QY().getWritableDatabase().delete(m, str, strArr);
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
        String m = m(uri);
        if (!TextUtils.isEmpty(m)) {
            if (d.DEBUG) {
                Log.e("PMSDBProvider", IMTrack.DbBuilder.ACTION_UPDATE);
            }
            try {
                int update = QY().getWritableDatabase().update(m, contentValues, str, strArr);
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
    public SQLiteOpenHelper QY() {
        return a.atC();
    }
}
