package com.baidu.searchbox.ng.ai.apps.storage;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsFileUtils;
/* loaded from: classes2.dex */
public class URIUtil {
    private static final String TAG = "URIUtil";

    public static String getFilePathByUri(Context context, Uri uri) {
        Cursor cursor;
        int columnIndex;
        String string;
        Cursor cursor2 = null;
        if (uri == null) {
            return null;
        }
        String scheme = uri.getScheme();
        if (TextUtils.isEmpty(scheme)) {
            return uri.getPath();
        }
        if (TextUtils.equals("file", scheme)) {
            return uri.getPath();
        }
        if (!TextUtils.equals("content", scheme)) {
            return null;
        }
        try {
            Cursor query = context.getContentResolver().query(uri, new String[]{"_data"}, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst() && (columnIndex = query.getColumnIndex("_data")) > -1) {
                        string = query.getString(columnIndex);
                        AiAppsFileUtils.closeSafely(query);
                        return string;
                    }
                } catch (Exception e) {
                    cursor = query;
                    AiAppsFileUtils.closeSafely(cursor);
                    return null;
                } catch (Throwable th) {
                    th = th;
                    cursor2 = query;
                    AiAppsFileUtils.closeSafely(cursor2);
                    throw th;
                }
            }
            string = null;
            AiAppsFileUtils.closeSafely(query);
            return string;
        } catch (Exception e2) {
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
