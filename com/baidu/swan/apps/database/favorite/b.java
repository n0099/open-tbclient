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
/* loaded from: classes8.dex */
public class b {
    private UriMatcher coN = new UriMatcher(-1);
    public static final String coM = AppRuntime.getApplication().getPackageName() + ".swan.favorite";
    public static final Uri CONTENT_URI = Uri.parse("content://" + coM);

    /* JADX INFO: Access modifiers changed from: package-private */
    public b() {
        this.coN.addURI(coM, "favorite", 0);
        this.coN.addURI(coM, "favorite_and_aps", 1);
        this.coN.addURI(coM, "history", 2);
        this.coN.addURI(coM, "history_with_app", 3);
        this.coN.addURI(coM, "favorite_with_aps_pms", 4);
        this.coN.addURI(coM, "history_with_aps_pms", 5);
        this.coN.addURI(coM, "user_behavior", 6);
    }

    @Nullable
    public Cursor query(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        int match = this.coN.match(uri);
        switch (match) {
            case 0:
                Cursor a = SwanAppDbControl.bY(AppRuntime.getAppContext()).a(strArr, str, strArr2, str2);
                a.setNotificationUri(AppRuntime.getAppContext().getContentResolver(), uri);
                return a;
            case 1:
                Cursor b = SwanAppDbControl.bY(AppRuntime.getAppContext()).b(strArr, str, strArr2, str2);
                b.setNotificationUri(AppRuntime.getAppContext().getContentResolver(), uri);
                return b;
            case 2:
                return SwanAppDbControl.bY(AppRuntime.getAppContext()).c(strArr, str, strArr2, str2);
            case 3:
                Cursor d = SwanAppDbControl.bY(AppRuntime.getAppContext()).d(strArr, str, strArr2, str2);
                d.setNotificationUri(AppRuntime.getAppContext().getContentResolver(), uri);
                return d;
            case 4:
                Cursor akY = a.akY();
                akY.setNotificationUri(AppRuntime.getAppContext().getContentResolver(), uri);
                return akY;
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
                Cursor N = com.baidu.swan.apps.database.a.b.N(queryParameter, i);
                N.setNotificationUri(AppRuntime.getAppContext().getContentResolver(), uri);
                return N;
            case 6:
                SQLiteDatabase akM = SwanAppDbControl.bY(AppRuntime.getAppContext()).akM();
                if (akM != null) {
                    return akM.query(hq(match), strArr, str, strArr2, null, null, str2);
                }
                return null;
            default:
                return null;
        }
    }

    @Nullable
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        int match = this.coN.match(uri);
        switch (match) {
            case 0:
                long b = SwanAppDbControl.bY(AppRuntime.getAppContext()).b(contentValues);
                if (b < 0) {
                    return null;
                }
                return ContentUris.withAppendedId(CONTENT_URI.buildUpon().build(), b);
            case 2:
                long c = SwanAppDbControl.bY(AppRuntime.getAppContext()).c(contentValues);
                if (c < 0) {
                    return null;
                }
                alc();
                return ContentUris.withAppendedId(CONTENT_URI.buildUpon().build(), c);
            case 6:
                SQLiteDatabase akM = SwanAppDbControl.bY(AppRuntime.getAppContext()).akM();
                if (akM != null) {
                    akM.insertWithOnConflict(hq(match), null, contentValues, 5);
                    return uri;
                }
                return null;
            default:
                return null;
        }
    }

    public int delete(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        int match = this.coN.match(uri);
        switch (match) {
            case 0:
                return SwanAppDbControl.bY(AppRuntime.getAppContext()).b(str, strArr);
            case 2:
                int c = SwanAppDbControl.bY(AppRuntime.getAppContext()).c(str, strArr);
                if (c > 0) {
                    alc();
                    return c;
                }
                return c;
            case 6:
                SQLiteDatabase akM = SwanAppDbControl.bY(AppRuntime.getAppContext()).akM();
                if (akM != null) {
                    return akM.delete(hq(match), str, strArr);
                }
                return 0;
            default:
                return 0;
        }
    }

    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        int match = this.coN.match(uri);
        switch (match) {
            case 0:
                return SwanAppDbControl.bY(AppRuntime.getAppContext()).a(contentValues, str, strArr);
            case 2:
                int b = SwanAppDbControl.bY(AppRuntime.getAppContext()).b(contentValues, str, strArr);
                if (b > 0) {
                    alc();
                    return b;
                }
                return b;
            case 6:
                SQLiteDatabase akM = SwanAppDbControl.bY(AppRuntime.getAppContext()).akM();
                if (akM != null) {
                    return akM.update(hq(match), contentValues, str, strArr);
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
    private String hq(int i) {
        switch (i) {
            case 6:
                return "user_behavior";
            default:
                throw new NullPointerException("tableName must not Null");
        }
    }

    private static void alc() {
        AppRuntime.getAppContext().getContentResolver().notifyChange(com.baidu.swan.apps.database.a.a.ale(), (ContentObserver) null, false);
        AppRuntime.getAppContext().getContentResolver().notifyChange(com.baidu.swan.apps.database.a.a.alf(), (ContentObserver) null, false);
    }
}
