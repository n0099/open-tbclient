package com.baidu.searchbox.download.util;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.baidu.android.ext.widget.dialog.BdAlertDialog;
import com.baidu.android.ext.widget.dialog.BoxAlertDialog;
import com.baidu.android.util.io.Closeables;
import com.baidu.searchbox.appframework.BdBoxActivityManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.download.model.Downloads;
import com.baidu.searchbox.download.unified.DialogClickCallback;
import com.baidu.tieba.R;
import com.baidubce.http.Headers;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class DuplicateHelper {
    public static final String TAG = "DuplicateHelper";
    public static final boolean DEBUG = AppConfig.isDebug();
    public static String HEAD_HTTP = "http";
    public static String HEAD_HTTPS = "https";
    public static int HEAD_HTTP_LENGTH = 4;
    public static int HEAD_HTTPS_LENGTH = 5;
    public static final String[] PROJECTIONS_FILTER_FOR_ETAG = {"title", "uri", "mimetype", "status", "visibility", "hint", "extra_info"};

    public static void checkDuplicateDownload(final Context context, final DuplicateDownloadCallback duplicateDownloadCallback) {
        if (duplicateDownloadCallback == null) {
            return;
        }
        if (context == null) {
            duplicateDownloadCallback.onNotDuplicate();
            return;
        }
        new DuplicateDownloadCallback(duplicateDownloadCallback.getDownloadUrl()) { // from class: com.baidu.searchbox.download.util.DuplicateHelper.3
            @Override // com.baidu.searchbox.download.util.DuplicateDownloadCallback
            public void onDuplicate() {
                DuplicateHelper.showDuplicateDialog(context, duplicateDownloadCallback);
            }

            @Override // com.baidu.searchbox.download.util.DuplicateDownloadCallback
            public void onNotDuplicate() {
                duplicateDownloadCallback.onNotDuplicate();
            }
        };
        if (!isDuplicateUrl(context, duplicateDownloadCallback.getDownloadUrl(), duplicateDownloadCallback)) {
            duplicateDownloadCallback.onNotDuplicate();
        } else {
            showDuplicateDialog(context, duplicateDownloadCallback);
        }
    }

    public static void checkDuplicateEtag(Context context, String str, DuplicateDownloadCallback duplicateDownloadCallback) {
        if (duplicateDownloadCallback == null) {
            return;
        }
        if (isNetWorkEnabled(context) && !TextUtils.isEmpty(str)) {
            Cursor cursor = null;
            try {
                try {
                    cursor = AppRuntime.getAppContext().getContentResolver().query(Downloads.Impl.CONTENT_URI, PROJECTIONS_FILTER_FOR_ETAG, "is_visible_in_downloads_ui = ?  AND deleted != ? ", new String[]{String.valueOf(1), String.valueOf(1)}, null);
                    if (cursor != null && cursor.getCount() > 0) {
                        int columnIndex = cursor.getColumnIndex("mimetype");
                        int columnIndex2 = cursor.getColumnIndex("title");
                        int columnIndex3 = cursor.getColumnIndex("extra_info");
                        cursor.moveToFirst();
                        do {
                            FileClassifyHelper.getCategory(FileClassifyHelper.getFileSuffix(cursor.getString(columnIndex2)), cursor.getString(columnIndex));
                            String string = cursor.getString(columnIndex3);
                            if (TextUtils.isEmpty(string)) {
                                duplicateDownloadCallback.onNotDuplicate();
                                return;
                            }
                            try {
                                if (TextUtils.equals(str, new JSONObject(string).optString("etag"))) {
                                    duplicateDownloadCallback.onDuplicate();
                                    return;
                                }
                            } catch (Exception e) {
                                if (DEBUG) {
                                    e.printStackTrace();
                                }
                            }
                        } while (cursor.moveToNext());
                        duplicateDownloadCallback.onNotDuplicate();
                    }
                } catch (Exception e2) {
                    if (DEBUG) {
                        e2.printStackTrace();
                    }
                    duplicateDownloadCallback.onDuplicate();
                }
                return;
            } finally {
                Closeables.closeSafely((Cursor) null);
            }
        }
        duplicateDownloadCallback.onNotDuplicate();
    }

    public static void executeSafeAsyncTask(final Runnable runnable) {
        if (runnable == null) {
            return;
        }
        try {
            AsyncTask.THREAD_POOL_EXECUTOR.execute(new Runnable() { // from class: com.baidu.searchbox.download.util.DuplicateHelper.6
                @Override // java.lang.Runnable
                public void run() {
                    boolean z;
                    try {
                        runnable.run();
                    } finally {
                        if (!z) {
                        }
                    }
                }

                public String toString() {
                    return runnable.toString();
                }
            });
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public static String getDisplayString(Object obj) {
        if (obj != null && !TextUtils.isEmpty(obj.toString())) {
            return obj.toString();
        }
        return "null.";
    }

    public static NetworkInfo[] getNetworkInfoSafely(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
        if (connectivityManager == null) {
            return null;
        }
        try {
            return connectivityManager.getAllNetworkInfo();
        } catch (Exception e) {
            if (!DEBUG) {
                return null;
            }
            e.printStackTrace();
            return null;
        }
    }

    public static boolean isNetWorkEnabled(Context context) {
        NetworkInfo[] networkInfoSafely = getNetworkInfoSafely(context);
        if (networkInfoSafely == null) {
            return false;
        }
        for (NetworkInfo networkInfo : networkInfoSafely) {
            if (networkInfo != null && networkInfo.isConnectedOrConnecting()) {
                return true;
            }
        }
        return false;
    }

    public static String getHttpUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        if (str.startsWith(HEAD_HTTPS)) {
            str = str.substring(HEAD_HTTPS_LENGTH);
        } else if (str.startsWith(HEAD_HTTP)) {
            str = str.substring(HEAD_HTTP_LENGTH);
        }
        return HEAD_HTTP + str;
    }

    public static String getHttpsUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        if (str.startsWith(HEAD_HTTPS)) {
            str = str.substring(HEAD_HTTPS_LENGTH);
        } else if (str.startsWith(HEAD_HTTP)) {
            str = str.substring(HEAD_HTTP_LENGTH);
        }
        return HEAD_HTTPS + str;
    }

    public static boolean isDuplicateUrl(Context context, String str, DuplicateDownloadCallback duplicateDownloadCallback) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String[] strArr = {getHttpUrl(str), getHttpsUrl(str), String.valueOf(1), String.valueOf(1)};
        if (DEBUG) {
            Log.d(TAG, " isDuplicateUrl() : \n context = " + getDisplayString(context) + "\n url = " + getDisplayString(str) + "\n getHttpUrl(url) = " + getDisplayString(getHttpUrl(str)) + "\n getHttpsUrl(url) = " + getDisplayString(getHttpsUrl(str)) + "\n callback = " + getDisplayString(duplicateDownloadCallback) + "\n selection = " + getDisplayString("(uri = ?  OR uri = ? ) AND is_visible_in_downloads_ui = ?  AND deleted != ? ") + "\n selectionArgs = " + getDisplayString(strArr));
        }
        Cursor cursor = null;
        try {
            cursor = context.getContentResolver().query(Downloads.Impl.CONTENT_URI, new String[]{"uri"}, "(uri = ?  OR uri = ? ) AND is_visible_in_downloads_ui = ?  AND deleted != ? ", strArr, null);
            if (cursor == null || !cursor.moveToFirst()) {
                return false;
            }
            if (DEBUG) {
                Log.d(TAG, " isDuplicateUrl() : \n context = " + getDisplayString(context) + "\n url = " + getDisplayString(str) + "\n cursor != null && cursor.moveToFirst() = \n return true ");
            }
            return true;
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            return false;
        } finally {
            Closeables.closeSafely(cursor);
        }
    }

    public static void requestETag(Context context, DuplicateDownloadCallback duplicateDownloadCallback, int i, long j) {
        HttpURLConnection httpURLConnection;
        if (i <= 5 && System.currentTimeMillis() - j < 2000 && isNetWorkEnabled(context)) {
            int currentTimeMillis = (int) (2000 - (System.currentTimeMillis() - j));
            HttpURLConnection httpURLConnection2 = null;
            try {
                httpURLConnection = (HttpURLConnection) new URL(duplicateDownloadCallback.getDownloadUrl()).openConnection();
            } catch (Throwable th) {
                th = th;
            }
            try {
                httpURLConnection.setConnectTimeout(currentTimeMillis);
                httpURLConnection.setReadTimeout(currentTimeMillis);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setRequestMethod("HEAD");
                httpURLConnection.connect();
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode == 200) {
                    String url = httpURLConnection.getURL().toString();
                    if (DEBUG) {
                        Log.d(TAG, "timeOut " + currentTimeMillis + "  code " + responseCode + " etag " + httpURLConnection.getHeaderField(Headers.ETAG) + " location " + url + " downloadurl : " + duplicateDownloadCallback.getDownloadUrl());
                    }
                    if (httpURLConnection.getHeaderField(Headers.ETAG) != null) {
                        checkDuplicateEtag(context, httpURLConnection.getHeaderField(Headers.ETAG), duplicateDownloadCallback);
                    } else {
                        duplicateDownloadCallback.onNotDuplicate();
                    }
                } else if (responseCode == 302) {
                    String headerField = httpURLConnection.getHeaderField("Location");
                    duplicateDownloadCallback.setDownloadUrl(headerField);
                    requestETag(context, duplicateDownloadCallback, i + 1, j);
                    if (DEBUG) {
                        Log.d(TAG, " timeOut " + currentTimeMillis + " code " + responseCode + " location " + headerField + " count " + i + " downloadurl : " + duplicateDownloadCallback.getDownloadUrl());
                    }
                } else {
                    duplicateDownloadCallback.onNotDuplicate();
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                    return;
                }
                return;
            } catch (Throwable th2) {
                th = th2;
                httpURLConnection2 = httpURLConnection;
                try {
                    if (DEBUG) {
                        th.printStackTrace();
                    }
                    duplicateDownloadCallback.onNotDuplicate();
                    if (httpURLConnection2 != null) {
                        return;
                    }
                    return;
                } finally {
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                }
            }
        }
        if (DEBUG) {
            Log.d(TAG, "requestETag() : " + context + " = context; " + duplicateDownloadCallback + " callback; " + i + " count; " + j + " startTime;  downloadurl : " + duplicateDownloadCallback.getDownloadUrl());
        }
        duplicateDownloadCallback.onNotDuplicate();
    }

    public static void showDuplicateDialog(Context context, final DialogClickCallback dialogClickCallback) {
        Activity realTopActivity;
        if (context != null && (context instanceof Activity)) {
            realTopActivity = (Activity) context;
        } else {
            realTopActivity = BdBoxActivityManager.getRealTopActivity();
        }
        new BdAlertDialog.Builder(realTopActivity).setTitle(R.string.downloaded_duplicate_title).setMessage(R.string.downloaded_duplicate_message).setButton(new BdAlertDialog.ButtonItem(realTopActivity.getResources().getString(R.string.downloading_duplicate_cancel), new BdAlertDialog.OnItemClickListener() { // from class: com.baidu.searchbox.download.util.DuplicateHelper.2
            @Override // com.baidu.android.ext.widget.dialog.BdAlertDialog.OnItemClickListener
            public void onItemClick(View view2) {
                DialogClickCallback dialogClickCallback2 = DialogClickCallback.this;
                if (dialogClickCallback2 != null) {
                    dialogClickCallback2.callback(false);
                }
                DownloadStatisticUtil.duplicateDialogCancel();
            }
        })).setButton(new BdAlertDialog.ButtonItem(realTopActivity.getResources().getString(R.string.downloaded_duplicate_continue), new BdAlertDialog.OnItemClickListener() { // from class: com.baidu.searchbox.download.util.DuplicateHelper.1
            @Override // com.baidu.android.ext.widget.dialog.BdAlertDialog.OnItemClickListener
            public void onItemClick(View view2) {
                DialogClickCallback dialogClickCallback2 = DialogClickCallback.this;
                if (dialogClickCallback2 != null) {
                    dialogClickCallback2.callback(true);
                }
                DownloadStatisticUtil.duplicateDialogConfirm();
            }
        })).create().show();
        DownloadStatisticUtil.duplicateDialogShow();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0013 A[Catch: Exception -> 0x0046, TRY_LEAVE, TryCatch #0 {Exception -> 0x0046, blocks: (B:3:0x0002, B:5:0x0006, B:8:0x000f, B:10:0x0013, B:6:0x0009), top: B:18:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x000f A[Catch: Exception -> 0x0046, TryCatch #0 {Exception -> 0x0046, blocks: (B:3:0x0002, B:5:0x0006, B:8:0x000f, B:10:0x0013, B:6:0x0009), top: B:18:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void showDuplicateDialog(Context context, final DuplicateDownloadCallback duplicateDownloadCallback) {
        Activity activity;
        if (context != null) {
            try {
                if (context instanceof Activity) {
                    activity = (Activity) context;
                    if (activity != null) {
                        duplicateDownloadCallback.onNotDuplicate();
                        return;
                    }
                    new BoxAlertDialog.Builder(activity).setTitle(R.string.downloaded_duplicate_title).setMessage(R.string.downloaded_duplicate_message).setPositiveButton(R.string.downloaded_duplicate_continue, new DialogInterface.OnClickListener() { // from class: com.baidu.searchbox.download.util.DuplicateHelper.5
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            DuplicateDownloadCallback.this.onNotDuplicate();
                            DownloadStatisticUtil.duplicateDialogConfirm();
                        }
                    }).setNegativeButton(R.string.downloading_duplicate_cancel, new DialogInterface.OnClickListener() { // from class: com.baidu.searchbox.download.util.DuplicateHelper.4
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            DuplicateDownloadCallback.this.onDuplicate();
                            DownloadStatisticUtil.duplicateDialogCancel();
                        }
                    }).show(true);
                    DownloadStatisticUtil.duplicateDialogShow();
                    return;
                }
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
                duplicateDownloadCallback.onNotDuplicate();
                return;
            }
        }
        activity = BdBoxActivityManager.getTopActivity();
        if (activity != null) {
        }
    }
}
