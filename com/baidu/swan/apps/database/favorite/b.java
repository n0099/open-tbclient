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
/* loaded from: classes8.dex */
public class b {
    private UriMatcher cWJ = new UriMatcher(-1);
    public static final String cWI = AppRuntime.getApplication().getPackageName() + ".swan.favorite";
    public static final Uri CONTENT_URI = Uri.parse("content://" + cWI);

    /* JADX INFO: Access modifiers changed from: package-private */
    public b() {
        this.cWJ.addURI(cWI, "favorite", 0);
        this.cWJ.addURI(cWI, "favorite_and_aps", 1);
        this.cWJ.addURI(cWI, "history", 2);
        this.cWJ.addURI(cWI, "history_with_app", 3);
        this.cWJ.addURI(cWI, "favorite_with_aps_pms", 4);
        this.cWJ.addURI(cWI, "history_with_aps_pms", 5);
        this.cWJ.addURI(cWI, "user_behavior", 6);
    }

    @Nullable
    public Cursor query(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        int match = this.cWJ.match(uri);
        switch (match) {
            case 0:
                Cursor a2 = SwanAppDbControl.cQ(AppRuntime.getAppContext()).a(strArr, str, strArr2, str2);
                a2.setNotificationUri(AppRuntime.getAppContext().getContentResolver(), uri);
                return a2;
            case 1:
                Cursor b2 = SwanAppDbControl.cQ(AppRuntime.getAppContext()).b(strArr, str, strArr2, str2);
                b2.setNotificationUri(AppRuntime.getAppContext().getContentResolver(), uri);
                return b2;
            case 2:
                return SwanAppDbControl.cQ(AppRuntime.getAppContext()).c(strArr, str, strArr2, str2);
            case 3:
                Cursor d = SwanAppDbControl.cQ(AppRuntime.getAppContext()).d(strArr, str, strArr2, str2);
                d.setNotificationUri(AppRuntime.getAppContext().getContentResolver(), uri);
                return d;
            case 4:
                Cursor asO = a.asO();
                asO.setNotificationUri(AppRuntime.getAppContext().getContentResolver(), uri);
                return asO;
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
                SQLiteDatabase asC = SwanAppDbControl.cQ(AppRuntime.getAppContext()).asC();
                if (asC != null) {
                    return asC.query(ha(match), strArr, str, strArr2, null, null, str2);
                }
                return null;
            default:
                return null;
        }
    }

    @Nullable
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        int match = this.cWJ.match(uri);
        switch (match) {
            case 0:
                long b2 = SwanAppDbControl.cQ(AppRuntime.getAppContext()).b(contentValues);
                if (b2 < 0) {
                    return null;
                }
                return ContentUris.withAppendedId(CONTENT_URI.buildUpon().build(), b2);
            case 2:
                long c = SwanAppDbControl.cQ(AppRuntime.getAppContext()).c(contentValues);
                if (c < 0) {
                    return null;
                }
                asS();
                return ContentUris.withAppendedId(CONTENT_URI.buildUpon().build(), c);
            case 6:
                SQLiteDatabase asC = SwanAppDbControl.cQ(AppRuntime.getAppContext()).asC();
                if (asC != null) {
                    asC.insertWithOnConflict(ha(match), null, contentValues, 5);
                    return uri;
                }
                return null;
            default:
                return null;
        }
    }

    public int delete(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        int match = this.cWJ.match(uri);
        switch (match) {
            case 0:
                return SwanAppDbControl.cQ(AppRuntime.getAppContext()).c(str, strArr);
            case 2:
                int d = SwanAppDbControl.cQ(AppRuntime.getAppContext()).d(str, strArr);
                if (d > 0) {
                    asS();
                    return d;
                }
                return d;
            case 6:
                SQLiteDatabase asC = SwanAppDbControl.cQ(AppRuntime.getAppContext()).asC();
                if (asC != null) {
                    return asC.delete(ha(match), str, strArr);
                }
                return 0;
            default:
                return 0;
        }
    }

    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        int match = this.cWJ.match(uri);
        switch (match) {
            case 0:
                return SwanAppDbControl.cQ(AppRuntime.getAppContext()).a(contentValues, str, strArr);
            case 2:
                int b2 = SwanAppDbControl.cQ(AppRuntime.getAppContext()).b(contentValues, str, strArr);
                if (b2 > 0) {
                    asS();
                    return b2;
                }
                return b2;
            case 6:
                SQLiteDatabase asC = SwanAppDbControl.cQ(AppRuntime.getAppContext()).asC();
                if (asC != null) {
                    return asC.update(ha(match), contentValues, str, strArr);
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
    private String ha(int i) {
        switch (i) {
            case 6:
                return "user_behavior";
            default:
                throw new NullPointerException("tableName must not Null");
        }
    }

    private static void asS() {
        AppRuntime.getAppContext().getContentResolver().notifyChange(com.baidu.swan.apps.database.a.a.asU(), (ContentObserver) null, false);
        AppRuntime.getAppContext().getContentResolver().notifyChange(com.baidu.swan.apps.database.a.a.asV(), (ContentObserver) null, false);
    }
}
