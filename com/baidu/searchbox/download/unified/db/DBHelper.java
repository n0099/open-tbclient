package com.baidu.searchbox.download.unified.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.android.util.io.Closeables;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.download.ioc.IDownloadApp;
import com.baidu.searchbox.download.manager.DownloadManager;
import com.baidu.searchbox.download.model.Downloads;
import com.baidu.searchbox.download.statistics.ApkCloudStatisticsUtils;
import com.baidu.searchbox.download.unified.DestinationControlUtil;
import com.baidu.searchbox.download.unified.DownloadInfoData;
import com.baidu.searchbox.download.unified.DownloadParams;
import com.baidu.searchbox.download.util.DownloadHelper;
import com.baidu.searchbox.download.util.FileClassifyHelper;
import com.baidu.searchbox.ng.browser.explore.model.WebAddress;
import com.baidu.tieba.px;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class DBHelper {
    public static final boolean DEBUG = AppConfig.isDebug();

    public static Uri doDownload(String str, DownloadParams downloadParams) {
        try {
            WebAddress webAddress = new WebAddress(downloadParams.getUrl());
            ContentValues contentValues = new ContentValues();
            contentValues.put("uri", webAddress.toString());
            contentValues.put("notificationpackage", AppRuntime.getAppContext().getPackageName());
            contentValues.put("notificationclass", IDownloadApp.Impl.get().getOpenDownloadReceiverCanonicalName());
            contentValues.put("no_integrity", Boolean.TRUE);
            contentValues.put("description", webAddress.mHost);
            contentValues.put("title", downloadParams.getTitle());
            contentValues.put(Downloads.Impl.COLUMN_IS_VISIBLE_IN_DOWNLOADS_UI, Boolean.valueOf(downloadParams.isVisibleInDownloadsUI()));
            contentValues.put("visibility", Integer.valueOf(downloadParams.getVisibleInNotification()));
            contentValues.put("extra_info", downloadParams.getExtraInfo());
            contentValues.put("referer", downloadParams.getReferer());
            contentValues.put("useragent", downloadParams.getUserAgent());
            contentValues.put("mimetype", downloadParams.getMimeType());
            contentValues.put("source", str);
            Map<String, String> headers = downloadParams.getHeaders();
            if (headers != null && headers.size() > 0) {
                int i = 0;
                for (Map.Entry<String, String> entry : headers.entrySet()) {
                    contentValues.put(Downloads.Impl.RequestHeaders.INSERT_KEY_PREFIX + i, entry.getKey() + ":" + entry.getValue());
                    i++;
                }
            }
            if (downloadParams.getDestination() == 4 && !TextUtils.isEmpty(downloadParams.getFilePathHint()) && downloadParams.getFilePathHint().startsWith("file://")) {
                contentValues.put("destination", (Integer) 4);
                contentValues.put("hint", downloadParams.getFilePathHint());
            } else if (DestinationControlUtil.isSdcardPublic(str)) {
                contentValues.put("destination", (Integer) 5);
            } else {
                contentValues.put("destination", (Integer) 0);
            }
            Uri insert = AppRuntime.getAppContext().getContentResolver().insert(Downloads.Impl.CONTENT_URI, contentValues);
            IDownloadApp.Impl.get().processUnRead(true, insert);
            IDownloadApp.Impl.get().doDownloadStartStatics("", downloadParams.getMimeType(), downloadParams.getExtraInfo());
            return insert;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static int doResumeDownload(List<Long> list) {
        if (list == null || list.size() == 0) {
            return 0;
        }
        Cursor cursor = null;
        try {
            try {
                DownloadManager downloadManager = new DownloadManager(AppRuntime.getAppContext().getContentResolver(), AppRuntime.getAppContext().getPackageName());
                cursor = downloadManager.query(new DownloadManager.Query().setFilterById(DownloadHelper.listToArrayForLong(list)));
                cursor.moveToFirst();
                while (!cursor.isAfterLast()) {
                    int i = cursor.getInt(cursor.getColumnIndex("status"));
                    long j = cursor.getInt(cursor.getColumnIndex("_id"));
                    if (i == 8) {
                        list.remove(Long.valueOf(j));
                    } else {
                        if (ApkCloudStatisticsUtils.enableAppsearchCloudStatic()) {
                            downloadManager.doCloudResumeStatisticJob(j);
                        }
                        px.d(j);
                    }
                    cursor.moveToNext();
                }
            } catch (Exception e) {
                if (AppConfig.isDebug()) {
                    e.printStackTrace();
                }
            }
            Closeables.closeSafely(cursor);
            if (list.size() == 0) {
                return 0;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("status", (Integer) 190);
            contentValues.put("control", (Integer) 0);
            int update = AppRuntime.getAppContext().getContentResolver().update(Downloads.Impl.CONTENT_URI, contentValues, DownloadHelper.buildWhereClauseForIds(list), DownloadHelper.buildWhereArgsForIds(list));
            px.q(DownloadHelper.listToArrayForLong(list));
            return update;
        } catch (Throwable th) {
            Closeables.closeSafely(cursor);
            throw th;
        }
    }

    public static int doResumeDownloadForUri(Uri uri) {
        if (uri == null) {
            return 0;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(uri);
        return doResumeDownloadForUris(arrayList);
    }

    public static int doResumeDownloadForUris(List<Uri> list) {
        if (list != null && list.size() != 0) {
            ArrayList arrayList = new ArrayList();
            for (Uri uri : list) {
                arrayList.add(Long.valueOf(DownloadHelper.getIdFromUri(uri)));
            }
            return doResumeDownload(arrayList);
        }
        return 0;
    }

    public static String getDownloadPath(Uri uri) {
        return getDownloadPath(String.valueOf(DownloadHelper.getIdFromUri(uri)));
    }

    public static DownloadInfoData queryDownloadInfoData(Uri uri) {
        if (uri == null) {
            return null;
        }
        return queryDownloadInfoData(DownloadHelper.getIdFromUri(uri));
    }

    public static String getDownloadPath(String str) {
        Throwable th;
        Cursor cursor;
        Cursor cursor2 = null;
        try {
            try {
                cursor = AppRuntime.getAppContext().getContentResolver().query(Downloads.Impl.CONTENT_URI, new String[]{"_data"}, "_id= ?", new String[]{str}, null);
                if (cursor != null) {
                    try {
                        if (cursor.moveToFirst()) {
                            String string = cursor.getString(cursor.getColumnIndex("_data"));
                            Closeables.closeSafely(cursor);
                            return string;
                        }
                    } catch (Exception e) {
                        e = e;
                        if (DEBUG) {
                            e.printStackTrace();
                        }
                        Closeables.closeSafely(cursor);
                        return null;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                Closeables.closeSafely(cursor2);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th3) {
            cursor2 = null;
            th = th3;
            Closeables.closeSafely(cursor2);
            throw th;
        }
        Closeables.closeSafely(cursor);
        return null;
    }

    public static DownloadInfoData queryDownloadInfoData(long j) {
        Cursor cursor;
        Cursor cursor2 = null;
        try {
            try {
                boolean z = true;
                cursor = new DownloadManager(AppRuntime.getAppContext().getContentResolver(), AppRuntime.getAppContext().getPackageName()).query(new DownloadManager.Query().setFilterById(j));
                if (cursor != null) {
                    try {
                        if (cursor.moveToFirst()) {
                            DownloadInfoData downloadInfoData = new DownloadInfoData();
                            downloadInfoData.setId(cursor.getLong(cursor.getColumnIndex("_id")));
                            downloadInfoData.setMimeType(cursor.getString(cursor.getColumnIndex(DownloadManager.COLUMN_MEDIA_TYPE)));
                            downloadInfoData.setCategory(FileClassifyHelper.getCategory("", downloadInfoData.getMimeType()));
                            downloadInfoData.setCurrentSize(cursor.getLong(cursor.getColumnIndex(DownloadManager.COLUMN_BYTES_DOWNLOADED_SO_FAR)));
                            downloadInfoData.setErrorReason(cursor.getInt(cursor.getColumnIndexOrThrow(DownloadManager.COLUMN_BYTES_DOWNLOADED_SO_FAR)));
                            downloadInfoData.setFileName(cursor.getString(cursor.getColumnIndex("title")));
                            downloadInfoData.setFilePath(cursor.getString(cursor.getColumnIndex("_data")));
                            downloadInfoData.setStatus(cursor.getInt(cursor.getColumnIndexOrThrow("status")));
                            downloadInfoData.setTotalSize(cursor.getLong(cursor.getColumnIndex("total_bytes")));
                            downloadInfoData.setTimeStampLastModification(cursor.getLong(cursor.getColumnIndex("lastmod")));
                            if (cursor.getInt(cursor.getColumnIndex(Downloads.Impl.COLUMN_IS_VISIBLE_IN_DOWNLOADS_UI)) != 1) {
                                z = false;
                            }
                            downloadInfoData.setVisibleInDownloadsUI(z);
                            downloadInfoData.setSource(cursor.getString(cursor.getColumnIndex("source")));
                            downloadInfoData.setUrl(cursor.getString(cursor.getColumnIndex("uri")));
                            downloadInfoData.setExtraInfo(cursor.getString(cursor.getColumnIndex("extra_info")));
                            downloadInfoData.setCreateTime(cursor.getLong(cursor.getColumnIndex("create_time")));
                            int columnIndex = cursor.getColumnIndex("business_type");
                            if (columnIndex >= 0) {
                                downloadInfoData.setBusinessType(cursor.getInt(columnIndex));
                            }
                            Closeables.closeSafely(cursor);
                            return downloadInfoData;
                        }
                    } catch (Exception e) {
                        e = e;
                        if (DEBUG) {
                            e.printStackTrace();
                        }
                        Closeables.closeSafely(cursor);
                        return null;
                    }
                }
            } catch (Throwable th) {
                th = th;
                cursor2 = j;
                Closeables.closeSafely(cursor2);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            Closeables.closeSafely(cursor2);
            throw th;
        }
        Closeables.closeSafely(cursor);
        return null;
    }
}
