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
/* loaded from: classes2.dex */
public class b {
    private UriMatcher auA = new UriMatcher(-1);
    public static final String auz = AppRuntime.getApplication().getPackageName() + ".swan.favorite";
    public static final Uri CONTENT_URI = Uri.parse("content://" + auz);

    /* JADX INFO: Access modifiers changed from: package-private */
    public b() {
        this.auA.addURI(auz, "favorite", 0);
        this.auA.addURI(auz, "favorite_and_aps", 1);
        this.auA.addURI(auz, "history", 2);
        this.auA.addURI(auz, "history_with_app", 3);
        this.auA.addURI(auz, "favorite_with_aps_pms", 4);
        this.auA.addURI(auz, "history_with_aps_pms", 5);
    }

    @Nullable
    public Cursor query(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        switch (this.auA.match(uri)) {
            case 0:
                return SwanAppDbControl.bE(AppRuntime.getAppContext()).a(strArr, str, strArr2, str2);
            case 1:
                Cursor b = SwanAppDbControl.bE(AppRuntime.getAppContext()).b(strArr, str, strArr2, str2);
                b.setNotificationUri(AppRuntime.getAppContext().getContentResolver(), uri);
                return b;
            case 2:
                return SwanAppDbControl.bE(AppRuntime.getAppContext()).c(strArr, str, strArr2, str2);
            case 3:
                Cursor d = SwanAppDbControl.bE(AppRuntime.getAppContext()).d(strArr, str, strArr2, str2);
                d.setNotificationUri(AppRuntime.getAppContext().getContentResolver(), uri);
                return d;
            case 4:
                Cursor AM = a.AM();
                AM.setNotificationUri(AppRuntime.getAppContext().getContentResolver(), uri);
                return AM;
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
                Cursor z = com.baidu.swan.apps.database.a.b.z(queryParameter, i);
                z.setNotificationUri(AppRuntime.getAppContext().getContentResolver(), uri);
                return z;
            default:
                return null;
        }
    }

    @Nullable
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        switch (this.auA.match(uri)) {
            case 0:
                long c = SwanAppDbControl.bE(AppRuntime.getAppContext()).c(contentValues);
                if (c >= 0) {
                    return ContentUris.withAppendedId(CONTENT_URI.buildUpon().build(), c);
                }
                return null;
            case 1:
            default:
                return null;
            case 2:
                long d = SwanAppDbControl.bE(AppRuntime.getAppContext()).d(contentValues);
                if (d >= 0) {
                    AP();
                    return ContentUris.withAppendedId(CONTENT_URI.buildUpon().build(), d);
                }
                return null;
        }
    }

    public int delete(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        switch (this.auA.match(uri)) {
            case 0:
                return SwanAppDbControl.bE(AppRuntime.getAppContext()).b(str, strArr);
            case 1:
            default:
                return 0;
            case 2:
                int c = SwanAppDbControl.bE(AppRuntime.getAppContext()).c(str, strArr);
                if (c > 0) {
                    AP();
                    return c;
                }
                return c;
        }
    }

    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        switch (this.auA.match(uri)) {
            case 0:
                return SwanAppDbControl.bE(AppRuntime.getAppContext()).a(contentValues, str, strArr);
            case 1:
            default:
                return 0;
            case 2:
                int b = SwanAppDbControl.bE(AppRuntime.getAppContext()).b(contentValues, str, strArr);
                if (b > 0) {
                    AP();
                    return b;
                }
                return b;
        }
    }

    @Nullable
    public String getType(@NonNull Uri uri) {
        return null;
    }

    private static void AP() {
        AppRuntime.getAppContext().getContentResolver().notifyChange(com.baidu.swan.apps.database.a.a.AQ(), (ContentObserver) null, false);
        AppRuntime.getAppContext().getContentResolver().notifyChange(com.baidu.swan.apps.database.a.a.AR(), (ContentObserver) null, false);
    }
}
