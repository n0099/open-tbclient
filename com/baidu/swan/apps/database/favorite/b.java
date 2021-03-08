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
    private UriMatcher daw = new UriMatcher(-1);
    public static final String dav = AppRuntime.getApplication().getPackageName() + ".swan.favorite";
    public static final Uri CONTENT_URI = Uri.parse("content://" + dav);

    /* JADX INFO: Access modifiers changed from: package-private */
    public b() {
        this.daw.addURI(dav, "favorite", 0);
        this.daw.addURI(dav, "favorite_and_aps", 1);
        this.daw.addURI(dav, "history", 2);
        this.daw.addURI(dav, "history_with_app", 3);
        this.daw.addURI(dav, "favorite_with_aps_pms", 4);
        this.daw.addURI(dav, "history_with_aps_pms", 5);
        this.daw.addURI(dav, "user_behavior", 6);
    }

    @Nullable
    public Cursor query(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        int match = this.daw.match(uri);
        switch (match) {
            case 0:
                Cursor a2 = SwanAppDbControl.cO(AppRuntime.getAppContext()).a(strArr, str, strArr2, str2);
                a2.setNotificationUri(AppRuntime.getAppContext().getContentResolver(), uri);
                return a2;
            case 1:
                Cursor b = SwanAppDbControl.cO(AppRuntime.getAppContext()).b(strArr, str, strArr2, str2);
                b.setNotificationUri(AppRuntime.getAppContext().getContentResolver(), uri);
                return b;
            case 2:
                return SwanAppDbControl.cO(AppRuntime.getAppContext()).c(strArr, str, strArr2, str2);
            case 3:
                Cursor d = SwanAppDbControl.cO(AppRuntime.getAppContext()).d(strArr, str, strArr2, str2);
                d.setNotificationUri(AppRuntime.getAppContext().getContentResolver(), uri);
                return d;
            case 4:
                Cursor atp = a.atp();
                atp.setNotificationUri(AppRuntime.getAppContext().getContentResolver(), uri);
                return atp;
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
                Cursor W = com.baidu.swan.apps.database.a.b.W(queryParameter, i);
                W.setNotificationUri(AppRuntime.getAppContext().getContentResolver(), uri);
                return W;
            case 6:
                SQLiteDatabase atd = SwanAppDbControl.cO(AppRuntime.getAppContext()).atd();
                if (atd != null) {
                    return atd.query(he(match), strArr, str, strArr2, null, null, str2);
                }
                return null;
            default:
                return null;
        }
    }

    @Nullable
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        int match = this.daw.match(uri);
        switch (match) {
            case 0:
                long b = SwanAppDbControl.cO(AppRuntime.getAppContext()).b(contentValues);
                if (b < 0) {
                    return null;
                }
                return ContentUris.withAppendedId(CONTENT_URI.buildUpon().build(), b);
            case 2:
                long c = SwanAppDbControl.cO(AppRuntime.getAppContext()).c(contentValues);
                if (c < 0) {
                    return null;
                }
                att();
                return ContentUris.withAppendedId(CONTENT_URI.buildUpon().build(), c);
            case 6:
                SQLiteDatabase atd = SwanAppDbControl.cO(AppRuntime.getAppContext()).atd();
                if (atd != null) {
                    atd.insertWithOnConflict(he(match), null, contentValues, 5);
                    return uri;
                }
                return null;
            default:
                return null;
        }
    }

    public int delete(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        int match = this.daw.match(uri);
        switch (match) {
            case 0:
                return SwanAppDbControl.cO(AppRuntime.getAppContext()).c(str, strArr);
            case 2:
                int d = SwanAppDbControl.cO(AppRuntime.getAppContext()).d(str, strArr);
                if (d > 0) {
                    att();
                    return d;
                }
                return d;
            case 6:
                SQLiteDatabase atd = SwanAppDbControl.cO(AppRuntime.getAppContext()).atd();
                if (atd != null) {
                    return atd.delete(he(match), str, strArr);
                }
                return 0;
            default:
                return 0;
        }
    }

    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        int match = this.daw.match(uri);
        switch (match) {
            case 0:
                return SwanAppDbControl.cO(AppRuntime.getAppContext()).a(contentValues, str, strArr);
            case 2:
                int b = SwanAppDbControl.cO(AppRuntime.getAppContext()).b(contentValues, str, strArr);
                if (b > 0) {
                    att();
                    return b;
                }
                return b;
            case 6:
                SQLiteDatabase atd = SwanAppDbControl.cO(AppRuntime.getAppContext()).atd();
                if (atd != null) {
                    return atd.update(he(match), contentValues, str, strArr);
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
    private String he(int i) {
        switch (i) {
            case 6:
                return "user_behavior";
            default:
                throw new NullPointerException("tableName must not Null");
        }
    }

    private static void att() {
        AppRuntime.getAppContext().getContentResolver().notifyChange(com.baidu.swan.apps.database.a.a.atv(), (ContentObserver) null, false);
        AppRuntime.getAppContext().getContentResolver().notifyChange(com.baidu.swan.apps.database.a.a.atw(), (ContentObserver) null, false);
    }
}
