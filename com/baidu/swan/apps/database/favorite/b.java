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
    private UriMatcher cYV = new UriMatcher(-1);
    public static final String cYU = AppRuntime.getApplication().getPackageName() + ".swan.favorite";
    public static final Uri CONTENT_URI = Uri.parse("content://" + cYU);

    /* JADX INFO: Access modifiers changed from: package-private */
    public b() {
        this.cYV.addURI(cYU, "favorite", 0);
        this.cYV.addURI(cYU, "favorite_and_aps", 1);
        this.cYV.addURI(cYU, "history", 2);
        this.cYV.addURI(cYU, "history_with_app", 3);
        this.cYV.addURI(cYU, "favorite_with_aps_pms", 4);
        this.cYV.addURI(cYU, "history_with_aps_pms", 5);
        this.cYV.addURI(cYU, "user_behavior", 6);
    }

    @Nullable
    public Cursor query(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        int match = this.cYV.match(uri);
        switch (match) {
            case 0:
                Cursor a2 = SwanAppDbControl.cP(AppRuntime.getAppContext()).a(strArr, str, strArr2, str2);
                a2.setNotificationUri(AppRuntime.getAppContext().getContentResolver(), uri);
                return a2;
            case 1:
                Cursor b2 = SwanAppDbControl.cP(AppRuntime.getAppContext()).b(strArr, str, strArr2, str2);
                b2.setNotificationUri(AppRuntime.getAppContext().getContentResolver(), uri);
                return b2;
            case 2:
                return SwanAppDbControl.cP(AppRuntime.getAppContext()).c(strArr, str, strArr2, str2);
            case 3:
                Cursor d = SwanAppDbControl.cP(AppRuntime.getAppContext()).d(strArr, str, strArr2, str2);
                d.setNotificationUri(AppRuntime.getAppContext().getContentResolver(), uri);
                return d;
            case 4:
                Cursor atm = a.atm();
                atm.setNotificationUri(AppRuntime.getAppContext().getContentResolver(), uri);
                return atm;
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
                Cursor V = com.baidu.swan.apps.database.a.b.V(queryParameter, i);
                V.setNotificationUri(AppRuntime.getAppContext().getContentResolver(), uri);
                return V;
            case 6:
                SQLiteDatabase ata = SwanAppDbControl.cP(AppRuntime.getAppContext()).ata();
                if (ata != null) {
                    return ata.query(hd(match), strArr, str, strArr2, null, null, str2);
                }
                return null;
            default:
                return null;
        }
    }

    @Nullable
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        int match = this.cYV.match(uri);
        switch (match) {
            case 0:
                long b2 = SwanAppDbControl.cP(AppRuntime.getAppContext()).b(contentValues);
                if (b2 < 0) {
                    return null;
                }
                return ContentUris.withAppendedId(CONTENT_URI.buildUpon().build(), b2);
            case 2:
                long c = SwanAppDbControl.cP(AppRuntime.getAppContext()).c(contentValues);
                if (c < 0) {
                    return null;
                }
                atq();
                return ContentUris.withAppendedId(CONTENT_URI.buildUpon().build(), c);
            case 6:
                SQLiteDatabase ata = SwanAppDbControl.cP(AppRuntime.getAppContext()).ata();
                if (ata != null) {
                    ata.insertWithOnConflict(hd(match), null, contentValues, 5);
                    return uri;
                }
                return null;
            default:
                return null;
        }
    }

    public int delete(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        int match = this.cYV.match(uri);
        switch (match) {
            case 0:
                return SwanAppDbControl.cP(AppRuntime.getAppContext()).c(str, strArr);
            case 2:
                int d = SwanAppDbControl.cP(AppRuntime.getAppContext()).d(str, strArr);
                if (d > 0) {
                    atq();
                    return d;
                }
                return d;
            case 6:
                SQLiteDatabase ata = SwanAppDbControl.cP(AppRuntime.getAppContext()).ata();
                if (ata != null) {
                    return ata.delete(hd(match), str, strArr);
                }
                return 0;
            default:
                return 0;
        }
    }

    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        int match = this.cYV.match(uri);
        switch (match) {
            case 0:
                return SwanAppDbControl.cP(AppRuntime.getAppContext()).a(contentValues, str, strArr);
            case 2:
                int b2 = SwanAppDbControl.cP(AppRuntime.getAppContext()).b(contentValues, str, strArr);
                if (b2 > 0) {
                    atq();
                    return b2;
                }
                return b2;
            case 6:
                SQLiteDatabase ata = SwanAppDbControl.cP(AppRuntime.getAppContext()).ata();
                if (ata != null) {
                    return ata.update(hd(match), contentValues, str, strArr);
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
    private String hd(int i) {
        switch (i) {
            case 6:
                return "user_behavior";
            default:
                throw new NullPointerException("tableName must not Null");
        }
    }

    private static void atq() {
        AppRuntime.getAppContext().getContentResolver().notifyChange(com.baidu.swan.apps.database.a.a.ats(), (ContentObserver) null, false);
        AppRuntime.getAppContext().getContentResolver().notifyChange(com.baidu.swan.apps.database.a.a.att(), (ContentObserver) null, false);
    }
}
