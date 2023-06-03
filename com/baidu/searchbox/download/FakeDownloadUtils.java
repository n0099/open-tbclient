package com.baidu.searchbox.download;

import android.content.ContentUris;
import android.content.ContentValues;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.developer.DebugException;
import com.baidu.searchbox.download.ioc.IDownloadApp;
import com.baidu.searchbox.download.model.Downloads;
import com.baidu.searchbox.download.table.SearchBoxDownloadTable;
/* loaded from: classes3.dex */
public class FakeDownloadUtils {
    public static final boolean DEBUG = AppConfig.isDebug();

    public static ContentValues buildDownloadedData(String str, String str2, boolean z, String str3, String str4, int i, String str5, String str6) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4)) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("uri", str);
            contentValues.put("title", str2);
            contentValues.put("hint", str2);
            contentValues.put(Downloads.Impl.COLUMN_IS_VISIBLE_IN_DOWNLOADS_UI, Boolean.valueOf(z));
            contentValues.put("destination", (Integer) 0);
            contentValues.put("total_bytes", str5);
            contentValues.put("current_bytes", str6);
            contentValues.put("_data", str3);
            contentValues.put("mimetype", str4);
            contentValues.put("status", (Integer) 200);
            contentValues.put("visibility", Integer.valueOf(i));
            return contentValues;
        }
        return null;
    }

    public static Uri fakeInsertDownload(ContentValues contentValues) {
        Uri uri;
        try {
            uri = AppRuntime.getApplication().getContentResolver().insert(Downloads.Impl.CONTENT_URI, contentValues);
        } catch (Exception e) {
            if (!DEBUG) {
                uri = null;
            } else {
                e.printStackTrace();
                throw new DebugException("FakeDownloadUtils.fakeInsertDownload()", e);
            }
        }
        if (uri != null) {
            long parseId = ContentUris.parseId(uri);
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put(SearchBoxDownloadTable.download_id.name(), Long.valueOf(parseId));
            contentValues2.put(SearchBoxDownloadTable.is_read.name(), (Integer) 1);
            contentValues2.put(SearchBoxDownloadTable.operatetime.name(), Long.valueOf(System.currentTimeMillis()));
            IDownloadApp.Impl.get().doSearchBoxDownloadControlAddJob(contentValues2);
        }
        return uri;
    }
}
