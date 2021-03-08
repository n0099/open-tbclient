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
    private Context mContext;
    public static final String dXh = AppRuntime.getAppContext().getPackageName() + ".aiapp.pms";
    public static final Uri evt = Uri.parse("content://" + dXh + "/framework");
    public static final Uri evu = Uri.parse("content://" + dXh + "/swan_app");
    public static final Uri evv = Uri.parse("content://" + dXh + "/pkg_main");
    public static final Uri evw = Uri.parse("content://" + dXh + "/pkg_sub");
    public static final Uri evx = Uri.parse("content://" + dXh + "/" + ETAG.KEY_EXTENSION);
    public static final Uri evy = Uri.parse("content://" + dXh + "/swan_plugin");
    public static final Uri evz = Uri.parse("content://" + dXh + "/so_lib");
    public static final Uri evA = Uri.parse("content://" + dXh + "/swan_mini_pkg");
    private static UriMatcher evB = new UriMatcher(-1);

    static {
        evB.addURI(dXh, "framework", 2);
        evB.addURI(dXh, "pkg_main", 0);
        evB.addURI(dXh, "pkg_sub", 1);
        evB.addURI(dXh, ETAG.KEY_EXTENSION, 3);
        evB.addURI(dXh, "swan_app", 4);
        evB.addURI(dXh, "swan_plugin", 5);
        evB.addURI(dXh, "swan_mini_pkg", 6);
        evB.addURI(dXh, "so_lib", 7);
    }

    public b(Context context) {
        this.mContext = context;
    }

    private String q(Uri uri) {
        switch (evB.match(uri)) {
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
                return atb().getReadableDatabase().query(q, strArr, str, strArr2, null, null, str2, null);
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
                long insertWithOnConflict = atb().getWritableDatabase().insertWithOnConflict(q, null, contentValues, 5);
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
                int delete = atb().getWritableDatabase().delete(q, str, strArr);
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
                int update = atb().getWritableDatabase().update(q, contentValues, str, strArr);
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
    public SQLiteOpenHelper atb() {
        return a.bcE();
    }
}
