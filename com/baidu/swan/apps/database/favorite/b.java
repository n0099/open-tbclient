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
    private UriMatcher cbL = new UriMatcher(-1);
    public static final String cbK = AppRuntime.getApplication().getPackageName() + ".swan.favorite";
    public static final Uri CONTENT_URI = Uri.parse("content://" + cbK);

    /* JADX INFO: Access modifiers changed from: package-private */
    public b() {
        this.cbL.addURI(cbK, "favorite", 0);
        this.cbL.addURI(cbK, "favorite_and_aps", 1);
        this.cbL.addURI(cbK, "history", 2);
        this.cbL.addURI(cbK, "history_with_app", 3);
        this.cbL.addURI(cbK, "favorite_with_aps_pms", 4);
        this.cbL.addURI(cbK, "history_with_aps_pms", 5);
    }

    @Nullable
    public Cursor query(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        switch (this.cbL.match(uri)) {
            case 0:
                Cursor a = SwanAppDbControl.bN(AppRuntime.getAppContext()).a(strArr, str, strArr2, str2);
                a.setNotificationUri(AppRuntime.getAppContext().getContentResolver(), uri);
                return a;
            case 1:
                Cursor b = SwanAppDbControl.bN(AppRuntime.getAppContext()).b(strArr, str, strArr2, str2);
                b.setNotificationUri(AppRuntime.getAppContext().getContentResolver(), uri);
                return b;
            case 2:
                return SwanAppDbControl.bN(AppRuntime.getAppContext()).c(strArr, str, strArr2, str2);
            case 3:
                Cursor d = SwanAppDbControl.bN(AppRuntime.getAppContext()).d(strArr, str, strArr2, str2);
                d.setNotificationUri(AppRuntime.getAppContext().getContentResolver(), uri);
                return d;
            case 4:
                Cursor ace = a.ace();
                ace.setNotificationUri(AppRuntime.getAppContext().getContentResolver(), uri);
                return ace;
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
                Cursor L = com.baidu.swan.apps.database.a.b.L(queryParameter, i);
                L.setNotificationUri(AppRuntime.getAppContext().getContentResolver(), uri);
                return L;
            default:
                return null;
        }
    }

    @Nullable
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        switch (this.cbL.match(uri)) {
            case 0:
                long b = SwanAppDbControl.bN(AppRuntime.getAppContext()).b(contentValues);
                if (b >= 0) {
                    return ContentUris.withAppendedId(CONTENT_URI.buildUpon().build(), b);
                }
                return null;
            case 1:
            default:
                return null;
            case 2:
                long c = SwanAppDbControl.bN(AppRuntime.getAppContext()).c(contentValues);
                if (c >= 0) {
                    aci();
                    return ContentUris.withAppendedId(CONTENT_URI.buildUpon().build(), c);
                }
                return null;
        }
    }

    public int delete(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        switch (this.cbL.match(uri)) {
            case 0:
                return SwanAppDbControl.bN(AppRuntime.getAppContext()).b(str, strArr);
            case 1:
            default:
                return 0;
            case 2:
                int c = SwanAppDbControl.bN(AppRuntime.getAppContext()).c(str, strArr);
                if (c > 0) {
                    aci();
                    return c;
                }
                return c;
        }
    }

    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        switch (this.cbL.match(uri)) {
            case 0:
                return SwanAppDbControl.bN(AppRuntime.getAppContext()).a(contentValues, str, strArr);
            case 1:
            default:
                return 0;
            case 2:
                int b = SwanAppDbControl.bN(AppRuntime.getAppContext()).b(contentValues, str, strArr);
                if (b > 0) {
                    aci();
                    return b;
                }
                return b;
        }
    }

    @Nullable
    public String getType(@NonNull Uri uri) {
        return null;
    }

    private static void aci() {
        AppRuntime.getAppContext().getContentResolver().notifyChange(com.baidu.swan.apps.database.a.a.acj(), (ContentObserver) null, false);
        AppRuntime.getAppContext().getContentResolver().notifyChange(com.baidu.swan.apps.database.a.a.ack(), (ContentObserver) null, false);
    }
}
