package com.baidu.swan.apps.database.favorite;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.database.SwanAppDbControl;
/* loaded from: classes9.dex */
public class b {
    private UriMatcher dbx = new UriMatcher(-1);
    public static final String dbw = AppRuntime.getApplication().getPackageName() + ".swan.favorite";
    public static final Uri CONTENT_URI = Uri.parse("content://" + dbw);

    /* JADX INFO: Access modifiers changed from: package-private */
    public b() {
        this.dbx.addURI(dbw, "favorite", 0);
        this.dbx.addURI(dbw, "favorite_and_aps", 1);
        this.dbx.addURI(dbw, "history", 2);
        this.dbx.addURI(dbw, "history_with_app", 3);
        this.dbx.addURI(dbw, "favorite_with_aps_pms", 4);
        this.dbx.addURI(dbw, "history_with_aps_pms", 5);
        this.dbx.addURI(dbw, "user_behavior", 6);
    }

    @Nullable
    public Cursor query(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        int match = this.dbx.match(uri);
        switch (match) {
            case 0:
                Cursor a2 = SwanAppDbControl.cR(AppRuntime.getAppContext()).a(strArr, str, strArr2, str2);
                a2.setNotificationUri(AppRuntime.getAppContext().getContentResolver(), uri);
                return a2;
            case 1:
                Cursor b2 = SwanAppDbControl.cR(AppRuntime.getAppContext()).b(strArr, str, strArr2, str2);
                b2.setNotificationUri(AppRuntime.getAppContext().getContentResolver(), uri);
                return b2;
            case 2:
                return SwanAppDbControl.cR(AppRuntime.getAppContext()).c(strArr, str, strArr2, str2);
            case 3:
                Cursor d = SwanAppDbControl.cR(AppRuntime.getAppContext()).d(strArr, str, strArr2, str2);
                d.setNotificationUri(AppRuntime.getAppContext().getContentResolver(), uri);
                return d;
            case 4:
                Cursor awI = a.awI();
                awI.setNotificationUri(AppRuntime.getAppContext().getContentResolver(), uri);
                return awI;
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
                Cursor T = com.baidu.swan.apps.database.a.b.T(queryParameter, i);
                T.setNotificationUri(AppRuntime.getAppContext().getContentResolver(), uri);
                return T;
            case 6:
                SQLiteDatabase aww = SwanAppDbControl.cR(AppRuntime.getAppContext()).aww();
                if (aww != null) {
                    return aww.query(iG(match), strArr, str, strArr2, null, null, str2);
                }
                return null;
            default:
                return null;
        }
    }

    @Nullable
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        int match = this.dbx.match(uri);
        switch (match) {
            case 0:
                long b2 = SwanAppDbControl.cR(AppRuntime.getAppContext()).b(contentValues);
                if (b2 < 0) {
                    return null;
                }
                return ContentUris.withAppendedId(CONTENT_URI.buildUpon().build(), b2);
            case 2:
                long c = SwanAppDbControl.cR(AppRuntime.getAppContext()).c(contentValues);
                if (c < 0) {
                    return null;
                }
                awM();
                return ContentUris.withAppendedId(CONTENT_URI.buildUpon().build(), c);
            case 6:
                SQLiteDatabase aww = SwanAppDbControl.cR(AppRuntime.getAppContext()).aww();
                if (aww != null) {
                    aww.insertWithOnConflict(iG(match), null, contentValues, 5);
                    return uri;
                }
                return null;
            default:
                return null;
        }
    }

    public int delete(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        int match = this.dbx.match(uri);
        switch (match) {
            case 0:
                return SwanAppDbControl.cR(AppRuntime.getAppContext()).c(str, strArr);
            case 2:
                int d = SwanAppDbControl.cR(AppRuntime.getAppContext()).d(str, strArr);
                if (d > 0) {
                    awM();
                    return d;
                }
                return d;
            case 6:
                SQLiteDatabase aww = SwanAppDbControl.cR(AppRuntime.getAppContext()).aww();
                if (aww != null) {
                    return aww.delete(iG(match), str, strArr);
                }
                return 0;
            default:
                return 0;
        }
    }

    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        int match = this.dbx.match(uri);
        switch (match) {
            case 0:
                return SwanAppDbControl.cR(AppRuntime.getAppContext()).a(contentValues, str, strArr);
            case 2:
                int b2 = SwanAppDbControl.cR(AppRuntime.getAppContext()).b(contentValues, str, strArr);
                if (b2 > 0) {
                    awM();
                    return b2;
                }
                return b2;
            case 6:
                SQLiteDatabase aww = SwanAppDbControl.cR(AppRuntime.getAppContext()).aww();
                if (aww != null) {
                    return aww.update(iG(match), contentValues, str, strArr);
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
    private String iG(int i) {
        switch (i) {
            case 6:
                return "user_behavior";
            default:
                throw new NullPointerException("tableName must not Null");
        }
    }

    private static void awM() {
        AppRuntime.getAppContext().getContentResolver().notifyChange(com.baidu.swan.apps.database.a.a.awO(), (ContentObserver) null, false);
        AppRuntime.getAppContext().getContentResolver().notifyChange(com.baidu.swan.apps.database.a.a.awP(), (ContentObserver) null, false);
    }
}
