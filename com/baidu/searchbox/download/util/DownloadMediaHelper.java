package com.baidu.searchbox.download.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.RecoverableSecurityException;
import android.content.ContentUris;
import android.content.Context;
import android.content.IntentSender;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import com.android.support.appcompat.storage.MediaFileProcessor;
import com.baidu.android.util.android.ActivityUtils;
import com.baidu.android.util.io.Closeables;
import com.baidu.searchbox.appframework.BdBoxActivityManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.developer.DebugException;
import com.baidu.searchbox.download.model.Constants;
import com.baidu.tieba.y;
import com.baidu.tieba.z;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class DownloadMediaHelper {
    public static final int REQUEST_DELETE_CODE = 1010;
    public static final String TAG = "DownloadMediaHelper";
    public static final boolean DEBUG = AppConfig.isDebug();
    public static ArrayList<String> mImagePath = new ArrayList<>();
    public static ArrayList<String> mVideoPath = new ArrayList<>();
    public static ArrayList<String> mAudioPath = new ArrayList<>();
    public static ArrayList<String> mDownloadPath = new ArrayList<>();

    /* loaded from: classes3.dex */
    public interface CallBack<T> {
        void callback(T t);
    }

    /* renamed from: com.baidu.searchbox.download.util.DownloadMediaHelper$3  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass3 {
        public static final /* synthetic */ int[] $SwitchMap$com$android$support$appcompat$storage$MediaFileProcessor$UriSource;

        static {
            int[] iArr = new int[MediaFileProcessor.UriSource.values().length];
            $SwitchMap$com$android$support$appcompat$storage$MediaFileProcessor$UriSource = iArr;
            try {
                iArr[MediaFileProcessor.UriSource.IMAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$android$support$appcompat$storage$MediaFileProcessor$UriSource[MediaFileProcessor.UriSource.AUDIO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$android$support$appcompat$storage$MediaFileProcessor$UriSource[MediaFileProcessor.UriSource.VIDEO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    static {
        mImagePath.add("Pictures");
        mImagePath.add("DCIM");
        mVideoPath.add("Movies");
        mVideoPath.add("DCIM");
        mAudioPath.add("Music");
        mAudioPath.add("Alarms");
        mAudioPath.add("Notifications");
        mAudioPath.add("Podcasts");
        mAudioPath.add("Ringtones");
        mDownloadPath.add("Download");
    }

    public static boolean isAndroid11Device() {
        if (Build.VERSION.SDK_INT >= 30) {
            return true;
        }
        return false;
    }

    public static boolean isNotSupportDeleteMoreItem() {
        if (Build.VERSION.SDK_INT != 29) {
            return false;
        }
        return !Environment.isExternalStorageLegacy();
    }

    @TargetApi(29)
    public static boolean checkDownloadSpecifiedDirectoryValid(String str) {
        int indexOf;
        if (!isOpenScopedStorage() || TextUtils.isEmpty(str) || DownloadHelper.isStoragePrivatePath(str)) {
            return true;
        }
        if (!str.contains(Environment.getExternalStorageDirectory().getPath())) {
            return false;
        }
        int indexOf2 = str.indexOf(Environment.getExternalStorageDirectory().getPath());
        String path = Environment.getExternalStorageDirectory().getPath();
        if (indexOf2 != -1 && path.length() + indexOf2 + 1 < str.length() && (indexOf = (path = str.substring(indexOf2 + path.length() + 1)).indexOf("/")) != -1) {
            path = path.substring(0, indexOf);
        }
        if (mImagePath.contains(path) || mAudioPath.contains(path) || mVideoPath.contains(path) || mDownloadPath.contains(path)) {
            return true;
        }
        return false;
    }

    public static Uri convertPathToMediaUri(Context context, String str) {
        if (isOpenScopedStorage() && !DownloadHelper.isStoragePrivatePath(str)) {
            if (context == null) {
                return null;
            }
            String fileSuffix = FileClassifyHelper.getFileSuffix(str);
            if (TextUtils.isEmpty(fileSuffix)) {
                return null;
            }
            String guessMimeTypeFromExtension = FileClassifyHelper.guessMimeTypeFromExtension(fileSuffix);
            if (TextUtils.isEmpty(guessMimeTypeFromExtension)) {
                return null;
            }
            return queryMediaFileUri(context.getApplicationContext(), str, guessMimeTypeFromExtension);
        }
        return pathFileUri(str);
    }

    public static Bundle createQueryArgsBundle(String str, String[] strArr, String str2, int i, int i2) {
        Bundle bundle = new Bundle();
        if (Build.VERSION.SDK_INT >= 30) {
            if (str != null) {
                bundle.putString("android:query-arg-sql-selection", str);
            }
            if (strArr != null) {
                bundle.putStringArray("android:query-arg-sql-selection-args", strArr);
            }
            if (str2 != null) {
                bundle.putString("android:query-arg-sql-sort-order", str2);
            }
            if (i > 0) {
                bundle.putInt("android:query-arg-limit", i);
            }
            if (i2 > 0) {
                bundle.putInt("android:query-arg-offset", i2);
            }
        }
        return bundle;
    }

    public static void deleteByUriList(Context context, List<Uri> list) {
        deleteByUriList(context, list, null, null);
    }

    public static String getMediaFileDefaultPathFromFile(String str, String str2) {
        return getMediaFileDefaultPath(getMediaFileUriSource(FileClassifyHelper.getCategory(FileClassifyHelper.getFileSuffix(str), str2)));
    }

    public static Uri getMediaFileUri(String str, String str2) {
        return MediaFileProcessor.a(getMediaFileUriSource(FileClassifyHelper.getCategory(FileClassifyHelper.getFileSuffix(str), str2)));
    }

    public static MediaFileProcessor.UriSource getMediaFileUriSource(String str, String str2) {
        return getMediaFileUriSource(FileClassifyHelper.getCategory(FileClassifyHelper.getFileSuffix(str), str2));
    }

    public static void deleteByUriList(Context context, List<Uri> list, CallBack<ArrayList<Uri>> callBack) {
        deleteByUriList(context, list, null, callBack);
    }

    public static void deleteByUriList(Context context, List<Uri> list, CallBack<Uri> callBack, CallBack<ArrayList<Uri>> callBack2) {
        Activity realTopActivity;
        if (context != null && list != null && !list.isEmpty()) {
            if (Build.VERSION.SDK_INT >= 30) {
                ArrayList<Uri> arrayList = new ArrayList<>();
                for (Uri uri : list) {
                    if (uri != null) {
                        try {
                            if (DEBUG) {
                                Log.w("DownloadManager", "deleteByUriList delete file " + uri);
                            }
                            context.getContentResolver().delete(uri, null, null);
                            if (callBack != null) {
                                callBack.callback(uri);
                            }
                        } catch (RecoverableSecurityException unused) {
                            if (DEBUG) {
                                Log.w("DownloadManager", "deleteByUriList delete file failed， need permission ");
                            }
                            arrayList.add(uri);
                        }
                    }
                }
                if (callBack2 != null) {
                    callBack2.callback(arrayList);
                }
                if (!arrayList.isEmpty()) {
                    if (context instanceof Activity) {
                        realTopActivity = (Activity) context;
                    } else {
                        realTopActivity = BdBoxActivityManager.getRealTopActivity();
                    }
                    Activity activity = realTopActivity;
                    try {
                        if (!ActivityUtils.isDestroyed(activity)) {
                            if (DEBUG) {
                                Log.w("DownloadManager", "deleteByUriList delete file fail, start use android R api ");
                            }
                            activity.startIntentSenderForResult(MediaStore.createDeleteRequest(context.getContentResolver(), arrayList).getIntentSender(), 1010, null, 0, 0, 0);
                        }
                    } catch (IntentSender.SendIntentException e) {
                        if (DEBUG) {
                            Log.w("DownloadManager", "deleteByUriList delete buy android R api fail " + e.getMessage());
                        }
                    }
                }
            }
        } else if (callBack2 != null) {
            callBack2.callback(new ArrayList<>());
        }
    }

    public static void deleteFromMediaProvider(Context context, Uri uri, String str, String[] strArr) {
        try {
            context.getContentResolver().delete(uri, str, strArr);
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public static boolean deleteMediaFile(Context context, long j, MediaFileProcessor.UriSource uriSource) {
        try {
            if (isOpenScopedStorage()) {
                if (DEBUG) {
                    Log.d(TAG, "deleteMediaFile: " + j);
                }
                if (MediaFileProcessor.delete(context, ContentUris.withAppendedId(MediaFileProcessor.a(uriSource), j), (String) null, (String[]) null, new z() { // from class: com.baidu.searchbox.download.util.DownloadMediaHelper.2
                    @Override // com.baidu.tieba.z
                    public void onFailed(int i) {
                    }

                    @Override // com.baidu.tieba.z
                    public void onPermitted(Object obj) {
                    }

                    @Override // com.baidu.tieba.z
                    public void onRefused() {
                    }
                }) <= 0) {
                    return false;
                }
                return true;
            }
        } catch (Exception e) {
            if (DEBUG) {
                throw new DebugException("deleteMediaFile" + e);
            }
        }
        return false;
    }

    @TargetApi(29)
    public static FileInputStream getFileInputStream(String str, String str2, z zVar) {
        try {
            if (isOpenScopedStorage() && !DownloadHelper.isStoragePrivatePath(str)) {
                ParcelFileDescriptor a = y.a(AppRuntime.getAppContext(), queryMediaFileUri(AppRuntime.getAppContext(), str, str2), "r", zVar);
                if (a != null) {
                    return new FileInputStream(a.getFileDescriptor());
                }
                return null;
            } else if (!TextUtils.isEmpty(str) && new File(str).exists()) {
                return new FileInputStream(str);
            } else {
                return null;
            }
        } catch (Exception e) {
            if (DEBUG) {
                Log.e(TAG, "文件找不到 " + e);
                return null;
            }
            return null;
        }
    }

    public static boolean deleteMediaFile(Context context, String str, String str2) {
        try {
            if (isOpenScopedStorage() && !DownloadHelper.isStoragePrivatePath(str)) {
                if (DEBUG) {
                    Log.d(TAG, "deleteMediaFile: " + str);
                }
                Uri queryMediaFileUri = queryMediaFileUri(context, str, str2);
                if (queryMediaFileUri != null) {
                    if (MediaFileProcessor.delete(context, queryMediaFileUri, (String) null, (String[]) null, str, new z() { // from class: com.baidu.searchbox.download.util.DownloadMediaHelper.1
                        @Override // com.baidu.tieba.z
                        public void onFailed(int i) {
                        }

                        @Override // com.baidu.tieba.z
                        public void onPermitted(Object obj) {
                        }

                        @Override // com.baidu.tieba.z
                        public void onRefused() {
                        }
                    }) <= 0) {
                        return false;
                    }
                    return true;
                }
            }
        } catch (Exception e) {
            if (DEBUG) {
                throw new DebugException("deleteMediaFile" + e);
            }
        }
        if (DownloadHelper.isExternalStorageAndNoPermission(str)) {
            return false;
        }
        File file = new File(str);
        if (file.exists()) {
            boolean delete = file.delete();
            if (!delete && DEBUG) {
                Log.w("DownloadManager", "deleteMediaFile delete file failed");
            }
            return delete;
        }
        return false;
    }

    public static boolean deleteMediaFile(Context context, String str, String str2, z zVar) {
        try {
            if (isOpenScopedStorage() && !DownloadHelper.isStoragePrivatePath(str)) {
                if (DEBUG) {
                    Log.d(TAG, "deleteMediaFile: " + str);
                }
                Uri queryMediaFileUri = queryMediaFileUri(context, str, str2);
                if (queryMediaFileUri != null) {
                    int delete = MediaFileProcessor.delete(context, queryMediaFileUri, (String) null, (String[]) null, str, zVar);
                    if (delete > 0 && zVar != null) {
                        zVar.onPermitted(Integer.valueOf(delete));
                    }
                    if (delete <= 0) {
                        return false;
                    }
                    return true;
                }
            }
            if (zVar != null) {
                zVar.onPermitted(Boolean.TRUE);
            }
        } catch (Exception e) {
            if (DEBUG) {
                throw new DebugException("deleteMediaFile" + e);
            }
        }
        if (DownloadHelper.isExternalStorageAndNoPermission(str)) {
            return false;
        }
        File file = new File(str);
        if (file.exists()) {
            boolean delete2 = file.delete();
            if (!delete2 && DEBUG) {
                Log.w("DownloadManager", "deleteMediaFile delete file failed");
            }
            return delete2;
        }
        return false;
    }

    public static String getMediaFileDefaultPath(MediaFileProcessor.UriSource uriSource) {
        if (DownloadHelper.isExternalMediaMounted() && Environment.getExternalStorageDirectory() != null) {
            File externalStorageDirectory = Environment.getExternalStorageDirectory();
            String str = externalStorageDirectory.getAbsolutePath() + "/";
            int i = AnonymousClass3.$SwitchMap$com$android$support$appcompat$storage$MediaFileProcessor$UriSource[uriSource.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return str + mDownloadPath.get(0);
                    }
                    return str + mVideoPath.get(0);
                }
                return str + mAudioPath.get(0);
            }
            return str + mImagePath.get(0);
        }
        return null;
    }

    public static MediaFileProcessor.UriSource getMediaFileUriSource(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    return MediaFileProcessor.UriSource.DOWNLOAD;
                }
                return MediaFileProcessor.UriSource.IMAGE;
            }
            return MediaFileProcessor.UriSource.AUDIO;
        }
        return MediaFileProcessor.UriSource.VIDEO;
    }

    public static String getName(String str) {
        int lastIndexOf;
        int i;
        if (TextUtils.isEmpty(str) || (lastIndexOf = str.lastIndexOf("/")) == -1 || (i = lastIndexOf + 1) >= str.length()) {
            return "";
        }
        return str.substring(i);
    }

    public static boolean isDownloadPathUncompliant(String str) {
        if (!isOpenScopedStorage()) {
            return DownloadHelper.isExternalStorageAndNoPermission(str);
        }
        boolean checkDownloadSpecifiedDirectoryValid = checkDownloadSpecifiedDirectoryValid(str);
        if (!checkDownloadSpecifiedDirectoryValid && DEBUG) {
            Log.e(TAG, "Download directory does not meet Android 10 partition storage specifications.");
        }
        return !checkDownloadSpecifiedDirectoryValid;
    }

    public static boolean needMediaFileProcessor(String str) {
        if (isOpenScopedStorage() && !DownloadHelper.isStoragePrivatePath(str) && checkDownloadSpecifiedDirectoryValid(str)) {
            return true;
        }
        return false;
    }

    public static boolean noNeedMediaFileProcessor(String str) {
        if (isOpenScopedStorage() && !DownloadHelper.isStoragePrivatePath(str) && checkDownloadSpecifiedDirectoryValid(str)) {
            return false;
        }
        return true;
    }

    public static Uri pathFileUri(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        if (!file.exists()) {
            return null;
        }
        return Uri.fromFile(file);
    }

    public static String getOpenScopedStorageDownloadFilePath() {
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        return (externalStorageDirectory.getAbsolutePath() + "/") + mDownloadPath.get(0) + Constants.DEFAULT_DL_SUBDIR;
    }

    @TargetApi(29)
    public static boolean isOpenScopedStorage() {
        boolean z = false;
        if (Build.VERSION.SDK_INT < 29) {
            if (DEBUG) {
                Log.d(TAG, "isOpenScopedStorage android 10 以下设备，无分区存储");
            }
            return false;
        }
        try {
            if (!Environment.isExternalStorageLegacy()) {
                z = true;
            }
            if (DEBUG) {
                Log.d(TAG, "isOpenScopedStorage " + z);
            }
        } catch (Exception unused) {
        }
        return z;
    }

    public static String getPathDir(String str) {
        if (TextUtils.isEmpty(str) || !str.contains(Environment.getExternalStorageDirectory().getPath())) {
            return "";
        }
        int indexOf = str.indexOf(Environment.getExternalStorageDirectory().getPath());
        int length = Environment.getExternalStorageDirectory().getPath().length();
        int lastIndexOf = str.lastIndexOf("/");
        int i = indexOf + length + 1;
        if (i >= lastIndexOf) {
            return "";
        }
        return str.substring(i, lastIndexOf);
    }

    public static Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2, int i) {
        return query(uri, strArr, str, strArr2, str2, i, -1);
    }

    public static Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2, int i, int i2) {
        if (Build.VERSION.SDK_INT >= 30) {
            return AppRuntime.getAppContext().getContentResolver().query(uri, strArr, createQueryArgsBundle(str, strArr2, str2, i, i2), null);
        }
        return AppRuntime.getAppContext().getContentResolver().query(uri, strArr, str, strArr2, str2);
    }

    public static Uri queryMediaFileUri(Context context, String str, String str2) {
        String str3;
        Cursor cursor;
        String pathDir = getPathDir(str);
        String name = getName(str);
        Cursor cursor2 = null;
        r4 = null;
        r4 = null;
        r4 = null;
        Uri uri = null;
        if (TextUtils.isEmpty(pathDir) && TextUtils.isEmpty(str)) {
            return null;
        }
        String[] strArr = {"_id"};
        if (Build.VERSION.SDK_INT >= 29) {
            str3 = "_display_name= ? AND relative_path= ?";
        } else {
            str3 = null;
        }
        try {
            cursor = MediaFileProcessor.query(context, getMediaFileUriSource(str, str2), strArr, str3, new String[]{name, pathDir + "/"}, (String) null);
        } catch (Exception e) {
            e = e;
            cursor = null;
        } catch (Throwable th) {
            th = th;
            Closeables.closeSafely(cursor2);
            throw th;
        }
        if (cursor != null) {
            try {
                try {
                } catch (Exception e2) {
                    e = e2;
                    if (DEBUG) {
                        Log.d(TAG, "queryMediaFileUri: 错误，" + e.toString());
                    }
                    Closeables.closeSafely(cursor);
                    return uri;
                }
                if (cursor.moveToNext()) {
                    uri = ContentUris.withAppendedId(getMediaFileUri(str, str2), cursor.getLong(cursor.getColumnIndex("_id")));
                    Closeables.closeSafely(cursor);
                    return uri;
                }
            } catch (Throwable th2) {
                th = th2;
                cursor2 = cursor;
                Closeables.closeSafely(cursor2);
                throw th;
            }
        }
        if (DEBUG) {
            Log.d(TAG, "queryMediaFileUri: 未查询到文件，" + str);
        }
        Closeables.closeSafely(cursor);
        return uri;
    }
}
