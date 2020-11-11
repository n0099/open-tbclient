package com.baidu.swan.apps.database.favorite;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.database.SwanAppDbControl;
/* loaded from: classes10.dex */
public class b {
    private UriMatcher cRt = new UriMatcher(-1);
    public static final String cRs = AppRuntime.getApplication().getPackageName() + ".swan.favorite";
    public static final Uri CONTENT_URI = Uri.parse("content://" + cRs);

    /* JADX INFO: Access modifiers changed from: package-private */
    public b() {
        this.cRt.addURI(cRs, "favorite", 0);
        this.cRt.addURI(cRs, "favorite_and_aps", 1);
        this.cRt.addURI(cRs, "history", 2);
        this.cRt.addURI(cRs, "history_with_app", 3);
        this.cRt.addURI(cRs, "favorite_with_aps_pms", 4);
        this.cRt.addURI(cRs, "history_with_aps_pms", 5);
        this.cRt.addURI(cRs, "user_behavior", 6);
    }

    @Nullable
    public Cursor query(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        int match = this.cRt.match(uri);
        switch (match) {
            case 0:
                Cursor a2 = SwanAppDbControl.cd(AppRuntime.getAppContext()).a(strArr, str, strArr2, str2);
                a2.setNotificationUri(AppRuntime.getAppContext().getContentResolver(), uri);
                return a2;
            case 1:
                Cursor b = SwanAppDbControl.cd(AppRuntime.getAppContext()).b(strArr, str, strArr2, str2);
                b.setNotificationUri(AppRuntime.getAppContext().getContentResolver(), uri);
                return b;
            case 2:
                return SwanAppDbControl.cd(AppRuntime.getAppContext()).c(strArr, str, strArr2, str2);
            case 3:
                Cursor d = SwanAppDbControl.cd(AppRuntime.getAppContext()).d(strArr, str, strArr2, str2);
                d.setNotificationUri(AppRuntime.getAppContext().getContentResolver(), uri);
                return d;
            case 4:
                Cursor asP = a.asP();
                asP.setNotificationUri(AppRuntime.getAppContext().getContentResolver(), uri);
                return asP;
            case 5:
                int i = -1;
                try {
                    i = Integer.valueOf(uri.getQueryParameter("query_limit")).intValue();
                } catch (Exception e) {
                    if (com.baidu.swan.apps.b.DEBUG) {
                        e.printStackTrace();
                    }
                }
                String queryParameter = uri.getQueryParameter("query_word");
                if (queryParameter == null) {
                    queryParameter = "";
                }
                Cursor Q = com.baidu.swan.apps.database.a.b.Q(queryParameter, i);
                Q.setNotificationUri(AppRuntime.getAppContext().getContentResolver(), uri);
                return Q;
            case 6:
                SQLiteDatabase asD = SwanAppDbControl.cd(AppRuntime.getAppContext()).asD();
                if (asD != null) {
                    return asD.query(ir(match), strArr, str, strArr2, null, null, str2);
                }
                return null;
            default:
                return null;
        }
    }

    @Nullable
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        int match = this.cRt.match(uri);
        switch (match) {
            case 0:
                long b = SwanAppDbControl.cd(AppRuntime.getAppContext()).b(contentValues);
                if (b < 0) {
                    return null;
                }
                return ContentUris.withAppendedId(CONTENT_URI.buildUpon().build(), b);
            case 2:
                long c = SwanAppDbControl.cd(AppRuntime.getAppContext()).c(contentValues);
                if (c < 0) {
                    return null;
                }
                asT();
                return ContentUris.withAppendedId(CONTENT_URI.buildUpon().build(), c);
            case 6:
                SQLiteDatabase asD = SwanAppDbControl.cd(AppRuntime.getAppContext()).asD();
                if (asD != null) {
                    asD.insertWithOnConflict(ir(match), null, contentValues, 5);
                    return uri;
                }
                return null;
            default:
                return null;
        }
    }

    public int delete(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        int match = this.cRt.match(uri);
        switch (match) {
            case 0:
                return SwanAppDbControl.cd(AppRuntime.getAppContext()).b(str, strArr);
            case 2:
                int c = SwanAppDbControl.cd(AppRuntime.getAppContext()).c(str, strArr);
                if (c > 0) {
                    asT();
                    return c;
                }
                return c;
            case 6:
                SQLiteDatabase asD = SwanAppDbControl.cd(AppRuntime.getAppContext()).asD();
                if (asD != null) {
                    return asD.delete(ir(match), str, strArr);
                }
                return 0;
            default:
                return 0;
        }
    }

    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        int match = this.cRt.match(uri);
        switch (match) {
            case 0:
                return SwanAppDbControl.cd(AppRuntime.getAppContext()).a(contentValues, str, strArr);
            case 2:
                int b = SwanAppDbControl.cd(AppRuntime.getAppContext()).b(contentValues, str, strArr);
                if (b > 0) {
                    asT();
                    return b;
                }
                return b;
            case 6:
                SQLiteDatabase asD = SwanAppDbControl.cd(AppRuntime.getAppContext()).asD();
                if (asD != null) {
                    return asD.update(ir(match), contentValues, str, strArr);
                }
                return 0;
            default:
                return 0;
        }
    }

    @Nullable
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @NonNull
    private String ir(int i) {
        switch (i) {
            case 6:
                return "user_behavior";
            default:
                throw new NullPointerException("tableName must not Null");
        }
    }

    private static void asT() {
        AppRuntime.getAppContext().getContentResolver().notifyChange(com.baidu.swan.apps.database.a.a.asV(), (ContentObserver) null, false);
        AppRuntime.getAppContext().getContentResolver().notifyChange(com.baidu.swan.apps.database.a.a.asW(), (ContentObserver) null, false);
    }
}
