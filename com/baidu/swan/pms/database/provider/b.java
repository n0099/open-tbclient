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
    public static final String cfH = AppRuntime.getAppContext().getPackageName() + ".aiapp.pms";
    public static final Uri cAQ = Uri.parse("content://" + cfH + "/framework");
    public static final Uri cAR = Uri.parse("content://" + cfH + "/swan_app");
    public static final Uri cAS = Uri.parse("content://" + cfH + "/pkg_main");
    public static final Uri cAT = Uri.parse("content://" + cfH + "/pkg_sub");
    public static final Uri cAU = Uri.parse("content://" + cfH + "/" + ETAG.KEY_EXTENSION);
    public static final Uri cAV = Uri.parse("content://" + cfH + "/swan_plugin");
    public static final Uri cAW = Uri.parse("content://" + cfH + "/swan_mini_pkg");
    private static UriMatcher cAX = new UriMatcher(-1);

    static {
        cAX.addURI(cfH, "framework", 2);
        cAX.addURI(cfH, "pkg_main", 0);
        cAX.addURI(cfH, "pkg_sub", 1);
        cAX.addURI(cfH, ETAG.KEY_EXTENSION, 3);
        cAX.addURI(cfH, "swan_app", 4);
        cAX.addURI(cfH, "swan_plugin", 5);
        cAX.addURI(cfH, "swan_mini_pkg", 6);
    }

    public b(Context context) {
        this.mContext = context;
    }

    private String m(Uri uri) {
        switch (cAX.match(uri)) {
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
