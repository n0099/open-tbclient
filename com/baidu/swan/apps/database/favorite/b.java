package com.baidu.swan.apps.database.favorite;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.database.SwanAppDbControl;
/* loaded from: classes10.dex */
public class b {
    private UriMatcher bpl = new UriMatcher(-1);
    public static final String bpk = AppRuntime.getApplication().getPackageName() + ".swan.favorite";
    public static final Uri CONTENT_URI = Uri.parse("content://" + bpk);

    /* JADX INFO: Access modifiers changed from: package-private */
    public b() {
        this.bpl.addURI(bpk, "favorite", 0);
        this.bpl.addURI(bpk, "favorite_and_aps", 1);
        this.bpl.addURI(bpk, "history", 2);
        this.bpl.addURI(bpk, "history_with_app", 3);
        this.bpl.addURI(bpk, "favorite_with_aps_pms", 4);
        this.bpl.addURI(bpk, "history_with_aps_pms", 5);
    }

    @Nullable
    public Cursor query(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        switch (this.bpl.match(uri)) {
            case 0:
                Cursor a = SwanAppDbControl.bX(AppRuntime.getAppContext()).a(strArr, str, strArr2, str2);
                a.setNotificationUri(AppRuntime.getAppContext().getContentResolver(), uri);
                return a;
            case 1:
                Cursor b = SwanAppDbControl.bX(AppRuntime.getAppContext()).b(strArr, str, strArr2, str2);
                b.setNotificationUri(AppRuntime.getAppContext().getContentResolver(), uri);
                return b;
            case 2:
                return SwanAppDbControl.bX(AppRuntime.getAppContext()).c(strArr, str, strArr2, str2);
            case 3:
                Cursor d = SwanAppDbControl.bX(AppRuntime.getAppContext()).d(strArr, str, strArr2, str2);
                d.setNotificationUri(AppRuntime.getAppContext().getContentResolver(), uri);
                return d;
            case 4:
                Cursor OW = a.OW();
                OW.setNotificationUri(AppRuntime.getAppContext().getContentResolver(), uri);
                return OW;
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
                Cursor B = com.baidu.swan.apps.database.a.b.B(queryParameter, i);
                B.setNotificationUri(AppRuntime.getAppContext().getContentResolver(), uri);
                return B;
            default:
                return null;
        }
    }

    @Nullable
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        switch (this.bpl.match(uri)) {
            case 0:
                long b = SwanAppDbControl.bX(AppRuntime.getAppContext()).b(contentValues);
                if (b >= 0) {
                    return ContentUris.withAppendedId(CONTENT_URI.buildUpon().build(), b);
                }
                return null;
            case 1:
            default:
                return null;
            case 2:
                long c = SwanAppDbControl.bX(AppRuntime.getAppContext()).c(contentValues);
                if (c >= 0) {
                    Pa();
                    return ContentUris.withAppendedId(CONTENT_URI.buildUpon().build(), c);
                }
                return null;
        }
    }

    public int delete(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        switch (this.bpl.match(uri)) {
            case 0:
                return SwanAppDbControl.bX(AppRuntime.getAppContext()).b(str, strArr);
            case 1:
            default:
                return 0;
            case 2:
                int c = SwanAppDbControl.bX(AppRuntime.getAppContext()).c(str, strArr);
                if (c > 0) {
                    Pa();
                    return c;
                }
                return c;
        }
    }

    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        switch (this.bpl.match(uri)) {
            case 0:
                return SwanAppDbControl.bX(AppRuntime.getAppContext()).a(contentValues, str, strArr);
            case 1:
            default:
                return 0;
            case 2:
                int b = SwanAppDbControl.bX(AppRuntime.getAppContext()).b(contentValues, str, strArr);
                if (b > 0) {
                    Pa();
                    return b;
                }
                return b;
        }
    }

    @Nullable
    public String getType(@NonNull Uri uri) {
        return null;
    }

    private static void Pa() {
        AppRuntime.getAppContext().getContentResolver().notifyChange(com.baidu.swan.apps.database.a.a.Pb(), (ContentObserver) null, false);
        AppRuntime.getAppContext().getContentResolver().notifyChange(com.baidu.swan.apps.database.a.a.Pc(), (ContentObserver) null, false);
    }
}
