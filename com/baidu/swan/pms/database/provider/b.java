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
import com.baidu.swan.pms.e;
/* loaded from: classes2.dex */
public class b {
    private Context mContext;
    public static final String aPs = AppRuntime.getAppContext().getPackageName() + ".aiapp.pms";
    public static final Uri bLK = Uri.parse("content://" + aPs + "/framework");
    public static final Uri bLL = Uri.parse("content://" + aPs + "/swan_app");
    public static final Uri bLM = Uri.parse("content://" + aPs + "/pkg_main");
    public static final Uri aPt = Uri.parse("content://" + aPs + "/pkg_sub");
    public static final Uri bLN = Uri.parse("content://" + aPs + "/extension");
    private static UriMatcher aPu = new UriMatcher(-1);

    static {
        aPu.addURI(aPs, "framework", 2);
        aPu.addURI(aPs, "pkg_main", 0);
        aPu.addURI(aPs, "pkg_sub", 1);
        aPu.addURI(aPs, "extension", 3);
        aPu.addURI(aPs, "swan_app", 4);
    }

    public b(Context context) {
        this.mContext = context;
    }

    private String c(Uri uri) {
        switch (aPu.match(uri)) {
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
        String c = c(uri);
        if (!TextUtils.isEmpty(c)) {
            if (e.DEBUG) {
                Log.e("PMSDBProvider", "query");
            }
            try {
                return Hn().getReadableDatabase().query(c, strArr, str, strArr2, null, null, str2, null);
            } catch (SQLException e) {
                if (e.DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    @Nullable
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        Log.e("PMSDBProvider", "name:" + Thread.currentThread().getName());
        String c = c(uri);
        if (!TextUtils.isEmpty(c) && contentValues != null) {
            if (e.DEBUG) {
                Log.e("PMSDBProvider", "insert:" + contentValues.toString());
            }
            try {
                long insertWithOnConflict = Hn().getWritableDatabase().insertWithOnConflict(c, null, contentValues, 5);
                if (insertWithOnConflict > 0) {
                    Uri withAppendedId = ContentUris.withAppendedId(uri, insertWithOnConflict);
                    this.mContext.getContentResolver().notifyChange(withAppendedId, null);
                    return withAppendedId;
                }
                return uri;
            } catch (SQLException e) {
                if (e.DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public int delete(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        String c = c(uri);
        if (!TextUtils.isEmpty(c)) {
            if (e.DEBUG) {
                Log.e("PMSDBProvider", "delete");
            }
            try {
                int delete = Hn().getWritableDatabase().delete(c, str, strArr);
                if (delete > 0) {
                    this.mContext.getContentResolver().notifyChange(uri, null);
                    return delete;
                }
                return delete;
            } catch (SQLException e) {
                if (e.DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        return 0;
    }

    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        String c = c(uri);
        if (!TextUtils.isEmpty(c)) {
            if (e.DEBUG) {
                Log.e("PMSDBProvider", IMTrack.DbBuilder.ACTION_UPDATE);
            }
            try {
                int update = Hn().getWritableDatabase().update(c, contentValues, str, strArr);
                if (update > 0) {
                    this.mContext.getContentResolver().notifyChange(uri, null);
                    return update;
                }
                return update;
            } catch (SQLException e) {
                if (e.DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SQLiteOpenHelper Hn() {
        return a.abd();
    }
}
