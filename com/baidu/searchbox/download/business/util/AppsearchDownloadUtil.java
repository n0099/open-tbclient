package com.baidu.searchbox.download.business.util;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.android.util.io.Closeables;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.developer.DebugException;
import com.baidu.searchbox.download.callback.AppDownloadListener;
import com.baidu.searchbox.download.callback.IAppDownloadListener;
import com.baidu.searchbox.download.manager.DownloadManagerExt;
import com.baidu.searchbox.download.model.Downloads;
import com.baidu.tbadk.core.data.SmallTailInfo;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class AppsearchDownloadUtil {
    public static final boolean DEBUG = AppConfig.isDebug();
    public static final String[] PROJECTIONS_FILTER_BY_TYPE = {"_id", "title", "uri", "mimetype", "total_bytes", "status", "current_bytes", "visibility", "hint", "_data", "extra_info"};

    public static boolean isFileExist(String str) {
        boolean z = false;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Cursor cursor = null;
        try {
            try {
                cursor = AppRuntime.getAppContext().getContentResolver().query(Downloads.Impl.CONTENT_URI, new String[]{"_id"}, "uri =?", new String[]{str}, null);
                if (cursor != null) {
                    if (cursor.getCount() > 0) {
                        z = true;
                    }
                }
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                    throw new DebugException("FileDownloader.isFileExist() got error!", e);
                }
            }
            return z;
        } finally {
            Closeables.closeSafely(cursor);
        }
    }

    public static String queryDownloadPathByDownloadID(String str) {
        Cursor cursor;
        Throwable th;
        String[] strArr = {str};
        String str2 = null;
        try {
            cursor = AppRuntime.getAppContext().getContentResolver().query(Downloads.Impl.CONTENT_URI, new String[]{"_data"}, "_id= ?", strArr, null);
            if (cursor != null) {
                try {
                    try {
                        if (cursor.moveToFirst()) {
                            str2 = cursor.getString(cursor.getColumnIndex("_data"));
                        }
                    } catch (Exception e) {
                        e = e;
                        if (DEBUG) {
                            e.printStackTrace();
                        }
                        Closeables.closeSafely(cursor);
                        return str2;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    Closeables.closeSafely(cursor);
                    throw th;
                }
            }
        } catch (Exception e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th3) {
            cursor = null;
            th = th3;
            Closeables.closeSafely(cursor);
            throw th;
        }
        Closeables.closeSafely(cursor);
        return str2;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:29:0x00db
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public static java.util.List<com.baidu.searchbox.download.model.AppDownloadInfo> queryAllDownloadedApp(java.lang.String r23) {
        /*
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.lang.String r5 = "deleted!= ?"
            r0 = 1
            java.lang.String[] r6 = new java.lang.String[r0]
            java.lang.String r0 = java.lang.String.valueOf(r0)
            r8 = 0
            r6[r8] = r0
            java.lang.String r7 = "lastmod DESC"
            r9 = 0
            android.content.Context r0 = com.baidu.searchbox.common.runtime.AppRuntime.getAppContext()     // Catch: java.lang.Throwable -> L180 java.lang.Exception -> L182
            android.content.ContentResolver r2 = r0.getContentResolver()     // Catch: java.lang.Throwable -> L180 java.lang.Exception -> L182
            android.net.Uri r3 = com.baidu.searchbox.download.model.Downloads.Impl.CONTENT_URI     // Catch: java.lang.Throwable -> L180 java.lang.Exception -> L182
            java.lang.String[] r4 = com.baidu.searchbox.download.business.util.AppsearchDownloadUtil.PROJECTIONS_FILTER_BY_TYPE     // Catch: java.lang.Throwable -> L180 java.lang.Exception -> L182
            android.database.Cursor r9 = r2.query(r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L180 java.lang.Exception -> L182
            if (r9 == 0) goto L18a
            int r0 = r9.getCount()     // Catch: java.lang.Throwable -> L180 java.lang.Exception -> L182
            if (r0 <= 0) goto L18a
            java.lang.String r0 = "uri"
            int r2 = r9.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L180 java.lang.Exception -> L182
            java.lang.String r0 = "_id"
            int r3 = r9.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L180 java.lang.Exception -> L182
            java.lang.String r0 = "mimetype"
            int r4 = r9.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L180 java.lang.Exception -> L182
            java.lang.String r0 = "current_bytes"
            int r5 = r9.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L180 java.lang.Exception -> L182
            java.lang.String r0 = "total_bytes"
            int r6 = r9.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L180 java.lang.Exception -> L182
            java.lang.String r0 = "_data"
            int r7 = r9.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L180 java.lang.Exception -> L182
            java.lang.String r0 = "title"
            int r10 = r9.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L180 java.lang.Exception -> L182
            java.lang.String r0 = "status"
            int r11 = r9.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L180 java.lang.Exception -> L182
            java.lang.String r0 = "hint"
            int r12 = r9.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L180 java.lang.Exception -> L182
            java.lang.String r0 = "visibility"
            int r13 = r9.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L180 java.lang.Exception -> L182
            java.lang.String r0 = "extra_info"
            int r14 = r9.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L180 java.lang.Exception -> L182
            r9.moveToFirst()     // Catch: java.lang.Throwable -> L180 java.lang.Exception -> L182
        L76:
            java.lang.String r15 = r9.getString(r4)     // Catch: java.lang.Throwable -> L180 java.lang.Exception -> L182
            java.lang.String r8 = r9.getString(r10)     // Catch: java.lang.Throwable -> L180 java.lang.Exception -> L182
            java.lang.String r0 = com.baidu.searchbox.download.util.FileClassifyHelper.getFileSuffix(r8)     // Catch: java.lang.Throwable -> L180 java.lang.Exception -> L182
            int r0 = com.baidu.searchbox.download.util.FileClassifyHelper.getCategory(r0, r15)     // Catch: java.lang.Throwable -> L180 java.lang.Exception -> L182
            r17 = r4
            r4 = 3
            if (r4 != r0) goto L16a
            java.lang.String r0 = r9.getString(r14)     // Catch: java.lang.Throwable -> L180 java.lang.Exception -> L182
            boolean r4 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L180 java.lang.Exception -> L182
            r18 = r10
            java.lang.String r10 = ""
            if (r4 != 0) goto Led
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch: java.lang.Exception -> Ldf java.lang.Throwable -> L180
            r4.<init>(r0)     // Catch: java.lang.Exception -> Ldf java.lang.Throwable -> L180
            java.lang.String r0 = "package"
            java.lang.String r0 = r4.optString(r0, r10)     // Catch: java.lang.Exception -> Ldf java.lang.Throwable -> L180
            r19 = r14
            java.lang.String r14 = "versioncode"
            r20 = r1
            r1 = 0
            int r14 = r4.optInt(r14, r1)     // Catch: java.lang.Exception -> Ld9 java.lang.Throwable -> L180
            boolean r16 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Exception -> Ld9 java.lang.Throwable -> L180
            if (r16 != 0) goto Lce
            if (r14 <= 0) goto Lce
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Ld9 java.lang.Throwable -> L180
            r1.<init>()     // Catch: java.lang.Exception -> Ld9 java.lang.Throwable -> L180
            r1.append(r0)     // Catch: java.lang.Exception -> Ld9 java.lang.Throwable -> L180
            java.lang.String r0 = "@"
            r1.append(r0)     // Catch: java.lang.Exception -> Ld9 java.lang.Throwable -> L180
            r1.append(r14)     // Catch: java.lang.Exception -> Ld9 java.lang.Throwable -> L180
            java.lang.String r0 = r1.toString()     // Catch: java.lang.Exception -> Ld9 java.lang.Throwable -> L180
            r1 = r0
            goto Lcf
        Lce:
            r1 = r10
        Lcf:
            java.lang.String r0 = "source"
            java.lang.String r10 = r4.optString(r0, r10)     // Catch: java.lang.Exception -> Ld7 java.lang.Throwable -> L180
            goto Lf2
        Ld7:
            r0 = move-exception
            goto Le5
        Ld9:
            r0 = move-exception
            goto Le4
        Ldb:
            r0 = move-exception
            r20 = r1
            goto Le4
        Ldf:
            r0 = move-exception
            r20 = r1
            r19 = r14
        Le4:
            r1 = r10
        Le5:
            boolean r4 = com.baidu.searchbox.download.business.util.AppsearchDownloadUtil.DEBUG     // Catch: java.lang.Exception -> L166 java.lang.Throwable -> L180
            if (r4 == 0) goto Lf2
            r0.printStackTrace()     // Catch: java.lang.Exception -> L166 java.lang.Throwable -> L180
            goto Lf2
        Led:
            r20 = r1
            r19 = r14
            r1 = r10
        Lf2:
            boolean r0 = android.text.TextUtils.isEmpty(r10)     // Catch: java.lang.Exception -> L166 java.lang.Throwable -> L180
            if (r0 != 0) goto L161
            r4 = r23
            boolean r0 = android.text.TextUtils.equals(r10, r4)     // Catch: java.lang.Exception -> L166 java.lang.Throwable -> L180
            if (r0 != 0) goto L101
            goto L163
        L101:
            com.baidu.searchbox.download.model.AppDownloadInfo r0 = new com.baidu.searchbox.download.model.AppDownloadInfo     // Catch: java.lang.Exception -> L166 java.lang.Throwable -> L180
            r0.<init>()     // Catch: java.lang.Exception -> L166 java.lang.Throwable -> L180
            java.lang.String r10 = r9.getString(r2)     // Catch: java.lang.Exception -> L166 java.lang.Throwable -> L180
            r0.setUri(r10)     // Catch: java.lang.Exception -> L166 java.lang.Throwable -> L180
            long r21 = r9.getLong(r3)     // Catch: java.lang.Exception -> L166 java.lang.Throwable -> L180
            java.lang.Long r10 = java.lang.Long.valueOf(r21)     // Catch: java.lang.Exception -> L166 java.lang.Throwable -> L180
            r0.setId(r10)     // Catch: java.lang.Exception -> L166 java.lang.Throwable -> L180
            long r21 = r9.getLong(r6)     // Catch: java.lang.Exception -> L166 java.lang.Throwable -> L180
            java.lang.Long r10 = java.lang.Long.valueOf(r21)     // Catch: java.lang.Exception -> L166 java.lang.Throwable -> L180
            r0.setTotalBytes(r10)     // Catch: java.lang.Exception -> L166 java.lang.Throwable -> L180
            long r21 = r9.getLong(r5)     // Catch: java.lang.Exception -> L166 java.lang.Throwable -> L180
            java.lang.Long r10 = java.lang.Long.valueOf(r21)     // Catch: java.lang.Exception -> L166 java.lang.Throwable -> L180
            r0.setCurrentBytes(r10)     // Catch: java.lang.Exception -> L166 java.lang.Throwable -> L180
            r0.setData(r8)     // Catch: java.lang.Exception -> L166 java.lang.Throwable -> L180
            java.lang.String r8 = r9.getString(r12)     // Catch: java.lang.Exception -> L166 java.lang.Throwable -> L180
            r0.setFilename(r8)     // Catch: java.lang.Exception -> L166 java.lang.Throwable -> L180
            r0.setMimetype(r15)     // Catch: java.lang.Exception -> L166 java.lang.Throwable -> L180
            java.lang.String r8 = r9.getString(r7)     // Catch: java.lang.Exception -> L166 java.lang.Throwable -> L180
            r0.setSavedPathForUser(r8)     // Catch: java.lang.Exception -> L166 java.lang.Throwable -> L180
            int r8 = r9.getInt(r11)     // Catch: java.lang.Exception -> L166 java.lang.Throwable -> L180
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch: java.lang.Exception -> L166 java.lang.Throwable -> L180
            r0.setStatus(r8)     // Catch: java.lang.Exception -> L166 java.lang.Throwable -> L180
            int r8 = r9.getInt(r13)     // Catch: java.lang.Exception -> L166 java.lang.Throwable -> L180
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch: java.lang.Exception -> L166 java.lang.Throwable -> L180
            r0.setVisibility(r8)     // Catch: java.lang.Exception -> L166 java.lang.Throwable -> L180
            r0.setSavedSourceKeyUser(r1)     // Catch: java.lang.Exception -> L166 java.lang.Throwable -> L180
            r1 = r20
            r1.add(r0)     // Catch: java.lang.Throwable -> L180 java.lang.Exception -> L182
            goto L170
        L161:
            r4 = r23
        L163:
            r1 = r20
            goto L170
        L166:
            r0 = move-exception
            r1 = r20
            goto L183
        L16a:
            r4 = r23
            r18 = r10
            r19 = r14
        L170:
            boolean r0 = r9.moveToNext()     // Catch: java.lang.Throwable -> L180 java.lang.Exception -> L182
            if (r0 != 0) goto L177
            goto L18a
        L177:
            r4 = r17
            r10 = r18
            r14 = r19
            r8 = 0
            goto L76
        L180:
            r0 = move-exception
            goto L18e
        L182:
            r0 = move-exception
        L183:
            boolean r2 = com.baidu.searchbox.download.business.util.AppsearchDownloadUtil.DEBUG     // Catch: java.lang.Throwable -> L180
            if (r2 == 0) goto L18a
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L180
        L18a:
            com.baidu.android.util.io.Closeables.closeSafely(r9)
            return r1
        L18e:
            com.baidu.android.util.io.Closeables.closeSafely(r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.download.business.util.AppsearchDownloadUtil.queryAllDownloadedApp(java.lang.String):java.util.List");
    }

    public static List<String> queryDownloadPathByDownloadID(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < strArr.length; i++) {
            arrayList.add("?");
        }
        String str = "_id in (" + TextUtils.join(",", arrayList) + SmallTailInfo.EMOTION_SUFFIX;
        Cursor cursor = null;
        ArrayList arrayList2 = new ArrayList();
        try {
            try {
                cursor = AppRuntime.getAppContext().getContentResolver().query(Downloads.Impl.CONTENT_URI, new String[]{"_data"}, str, strArr, null);
                if (cursor != null && cursor.moveToFirst()) {
                    int columnIndex = cursor.getColumnIndex("_data");
                    do {
                        arrayList2.add(cursor.getString(columnIndex));
                    } while (cursor.moveToNext());
                }
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
            return arrayList2;
        } finally {
            Closeables.closeSafely(cursor);
        }
    }

    public static void registerAppDownloadListener(Uri uri, IAppDownloadListener iAppDownloadListener) {
        DownloadManagerExt.getInstance().registerObserver(AppRuntime.getAppContext(), uri, new AppDownloadListener(AppRuntime.getAppContext(), uri, iAppDownloadListener));
    }

    public static void updateDownloadVisibility(long j, int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("visibility", Integer.valueOf(i));
        AppRuntime.getAppContext().getContentResolver().update(Downloads.Impl.CONTENT_URI, contentValues, "_id = ?", new String[]{String.valueOf(j)});
    }

    public static void unregisterAppDownloadListener(Uri uri) {
        DownloadManagerExt.getInstance().unregisterObserver(AppRuntime.getAppContext(), uri);
    }
}
