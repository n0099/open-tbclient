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
    private UriMatcher aOP = new UriMatcher(-1);
    public static final String aOO = AppRuntime.getApplication().getPackageName() + ".swan.favorite";
    public static final Uri CONTENT_URI = Uri.parse("content://" + aOO);

    /* JADX INFO: Access modifiers changed from: package-private */
    public b() {
        this.aOP.addURI(aOO, "favorite", 0);
        this.aOP.addURI(aOO, "favorite_and_aps", 1);
        this.aOP.addURI(aOO, "history", 2);
        this.aOP.addURI(aOO, "history_with_app", 3);
        this.aOP.addURI(aOO, "favorite_with_aps_pms", 4);
        this.aOP.addURI(aOO, "history_with_aps_pms", 5);
    }

    @Nullable
    public Cursor query(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        switch (this.aOP.match(uri)) {
            case 0:
                return SwanAppDbControl.aZ(AppRuntime.getAppContext()).a(strArr, str, strArr2, str2);
            case 1:
                Cursor b = SwanAppDbControl.aZ(AppRuntime.getAppContext()).b(strArr, str, strArr2, str2);
                b.setNotificationUri(AppRuntime.getAppContext().getContentResolver(), uri);
                return b;
            case 2:
                return SwanAppDbControl.aZ(AppRuntime.getAppContext()).c(strArr, str, strArr2, str2);
            case 3:
                Cursor d = SwanAppDbControl.aZ(AppRuntime.getAppContext()).d(strArr, str, strArr2, str2);
                d.setNotificationUri(AppRuntime.getAppContext().getContentResolver(), uri);
                return d;
            case 4:
                Cursor HB = a.HB();
                HB.setNotificationUri(AppRuntime.getAppContext().getContentResolver(), uri);
                return HB;
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
                Cursor v = com.baidu.swan.apps.database.a.b.v(queryParameter, i);
                v.setNotificationUri(AppRuntime.getAppContext().getContentResolver(), uri);
                return v;
            default:
                return null;
        }
    }

    @Nullable
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        switch (this.aOP.match(uri)) {
            case 0:
                long b = SwanAppDbControl.aZ(AppRuntime.getAppContext()).b(contentValues);
                if (b >= 0) {
                    return ContentUris.withAppendedId(CONTENT_URI.buildUpon().build(), b);
                }
                return null;
            case 1:
            default:
                return null;
            case 2:
                long c = SwanAppDbControl.aZ(AppRuntime.getAppContext()).c(contentValues);
                if (c >= 0) {
                    HE();
                    return ContentUris.withAppendedId(CONTENT_URI.buildUpon().build(), c);
                }
                return null;
        }
    }

    public int delete(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        switch (this.aOP.match(uri)) {
            case 0:
                return SwanAppDbControl.aZ(AppRuntime.getAppContext()).b(str, strArr);
            case 1:
            default:
                return 0;
            case 2:
                int c = SwanAppDbControl.aZ(AppRuntime.getAppContext()).c(str, strArr);
                if (c > 0) {
                    HE();
                    return c;
                }
                return c;
        }
    }

    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        switch (this.aOP.match(uri)) {
            case 0:
                return SwanAppDbControl.aZ(AppRuntime.getAppContext()).a(contentValues, str, strArr);
            case 1:
            default:
                return 0;
            case 2:
                int b = SwanAppDbControl.aZ(AppRuntime.getAppContext()).b(contentValues, str, strArr);
                if (b > 0) {
                    HE();
                    return b;
                }
                return b;
        }
    }

    @Nullable
    public String getType(@NonNull Uri uri) {
        return null;
    }

    private static void HE() {
        AppRuntime.getAppContext().getContentResolver().notifyChange(com.baidu.swan.apps.database.a.a.HF(), (ContentObserver) null, false);
        AppRuntime.getAppContext().getContentResolver().notifyChange(com.baidu.swan.apps.database.a.a.HG(), (ContentObserver) null, false);
    }
}
