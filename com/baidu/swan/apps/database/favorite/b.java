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
/* loaded from: classes11.dex */
public class b {
    private UriMatcher bRV = new UriMatcher(-1);
    public static final String bRU = AppRuntime.getApplication().getPackageName() + ".swan.favorite";
    public static final Uri CONTENT_URI = Uri.parse("content://" + bRU);

    /* JADX INFO: Access modifiers changed from: package-private */
    public b() {
        this.bRV.addURI(bRU, "favorite", 0);
        this.bRV.addURI(bRU, "favorite_and_aps", 1);
        this.bRV.addURI(bRU, "history", 2);
        this.bRV.addURI(bRU, "history_with_app", 3);
        this.bRV.addURI(bRU, "favorite_with_aps_pms", 4);
        this.bRV.addURI(bRU, "history_with_aps_pms", 5);
    }

    @Nullable
    public Cursor query(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        switch (this.bRV.match(uri)) {
            case 0:
                Cursor a = SwanAppDbControl.bC(AppRuntime.getAppContext()).a(strArr, str, strArr2, str2);
                a.setNotificationUri(AppRuntime.getAppContext().getContentResolver(), uri);
                return a;
            case 1:
                Cursor b = SwanAppDbControl.bC(AppRuntime.getAppContext()).b(strArr, str, strArr2, str2);
                b.setNotificationUri(AppRuntime.getAppContext().getContentResolver(), uri);
                return b;
            case 2:
                return SwanAppDbControl.bC(AppRuntime.getAppContext()).c(strArr, str, strArr2, str2);
            case 3:
                Cursor d = SwanAppDbControl.bC(AppRuntime.getAppContext()).d(strArr, str, strArr2, str2);
                d.setNotificationUri(AppRuntime.getAppContext().getContentResolver(), uri);
                return d;
            case 4:
                Cursor Zd = a.Zd();
                Zd.setNotificationUri(AppRuntime.getAppContext().getContentResolver(), uri);
                return Zd;
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
                Cursor H = com.baidu.swan.apps.database.a.b.H(queryParameter, i);
                H.setNotificationUri(AppRuntime.getAppContext().getContentResolver(), uri);
                return H;
            default:
                return null;
        }
    }

    @Nullable
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        switch (this.bRV.match(uri)) {
            case 0:
                long b = SwanAppDbControl.bC(AppRuntime.getAppContext()).b(contentValues);
                if (b >= 0) {
                    return ContentUris.withAppendedId(CONTENT_URI.buildUpon().build(), b);
                }
                return null;
            case 1:
            default:
                return null;
            case 2:
                long c = SwanAppDbControl.bC(AppRuntime.getAppContext()).c(contentValues);
                if (c >= 0) {
                    Zh();
                    return ContentUris.withAppendedId(CONTENT_URI.buildUpon().build(), c);
                }
                return null;
        }
    }

    public int delete(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        switch (this.bRV.match(uri)) {
            case 0:
                return SwanAppDbControl.bC(AppRuntime.getAppContext()).b(str, strArr);
            case 1:
            default:
                return 0;
            case 2:
                int c = SwanAppDbControl.bC(AppRuntime.getAppContext()).c(str, strArr);
                if (c > 0) {
                    Zh();
                    return c;
                }
                return c;
        }
    }

    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        switch (this.bRV.match(uri)) {
            case 0:
                return SwanAppDbControl.bC(AppRuntime.getAppContext()).a(contentValues, str, strArr);
            case 1:
            default:
                return 0;
            case 2:
                int b = SwanAppDbControl.bC(AppRuntime.getAppContext()).b(contentValues, str, strArr);
                if (b > 0) {
                    Zh();
                    return b;
                }
                return b;
        }
    }

    @Nullable
    public String getType(@NonNull Uri uri) {
        return null;
    }

    private static void Zh() {
        AppRuntime.getAppContext().getContentResolver().notifyChange(com.baidu.swan.apps.database.a.a.Zi(), (ContentObserver) null, false);
        AppRuntime.getAppContext().getContentResolver().notifyChange(com.baidu.swan.apps.database.a.a.Zj(), (ContentObserver) null, false);
    }
}
