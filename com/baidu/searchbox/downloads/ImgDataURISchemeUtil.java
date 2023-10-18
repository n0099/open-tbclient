package com.baidu.searchbox.downloads;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import androidx.annotation.Nullable;
import com.android.support.appcompat.storage.MediaFileProcessor;
import com.baidu.android.common.logging.Log;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.android.util.io.FileUtils;
import com.baidu.android.util.io.PathUtils;
import com.baidu.android.util.media.ImageScanner;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.developer.DebugException;
import com.baidu.searchbox.download.ioc.IDownloadApp;
import com.baidu.searchbox.download.model.Downloads;
import com.baidu.searchbox.download.util.DownloadHelper;
import com.baidu.searchbox.download.util.DownloadMediaHelper;
import com.baidu.searchbox.download.util.DownloadStatisticUtil;
import com.baidu.searchbox.download.util.ExternalStorageCallBack;
import com.baidu.searchbox.downloads.manage.SearchBoxDownloadManager;
import com.baidu.tieba.R;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.regex.Pattern;
/* loaded from: classes3.dex */
public class ImgDataURISchemeUtil {
    public static final String DATA_URI_SCHEME_FOR_IMAGE_PATTERN = "^data:image/*";
    public static final String DATA_URL_SCHEME_BASE64_FLAG = "base64,";
    public static final String DATA_URL_SCHEME_DATA_FILE_NAME = "barcode";
    public static final boolean DEBUG = AppConfig.isDebug();
    public static final String FILE_SCHEMA = "file://";
    public static final String IMAGE_CUSTOM_KEY = "image_custom_key";
    public static final String IMAGE_DEFAULT_SUFFIX = ".jpg";
    public static final String IMAGE_JPEG_VALUE = "image/jpeg";
    public static final String IMAGE_LOCAL_PATH = "image_local_path";
    public static final String KEY_DOWNLOADCENTER_PATH = "downloadcenter_path";
    public static final String TAG = "ImgDataURISchemeUtil";

    public static Bitmap base64ToBitmap(String str) {
        byte[] decode = Base64.decode(str, 0);
        return BitmapFactory.decodeByteArray(decode, 0, decode.length);
    }

    public static boolean isBase64Data(String str) {
        if (TextUtils.isEmpty(str) || str.length() <= 7 || !str.startsWith("file://")) {
            return false;
        }
        return true;
    }

    public static boolean copyFile(Context context, File file, File file2) {
        boolean z = false;
        FileInputStream fileInputStream = null;
        try {
            try {
                if (!DownloadMediaHelper.needMediaFileProcessor(file2.getAbsolutePath())) {
                    if (FileUtils.copyFile(file, file2) <= 0) {
                        return false;
                    }
                    return true;
                }
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    String pathDir = DownloadMediaHelper.getPathDir(file2.getPath());
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("_display_name", file2.getName());
                    contentValues.put("mime_type", "image/jpeg");
                    if (Build.VERSION.SDK_INT >= 29) {
                        contentValues.put("relative_path", pathDir);
                    }
                    if (MediaFileProcessor.d(context, fileInputStream2, MediaFileProcessor.UriSource.IMAGE, contentValues, file2.getAbsolutePath()) != null) {
                        z = true;
                    }
                    try {
                        fileInputStream2.close();
                    } catch (Exception unused) {
                    }
                    return z;
                } catch (Exception e) {
                    e = e;
                    fileInputStream = fileInputStream2;
                    if (!DEBUG) {
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception unused2) {
                            }
                        }
                        return false;
                    }
                    throw new DebugException("copyFile", e);
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception unused3) {
                        }
                    }
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void insertDownload(final String str, String str2, final Context context, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !isBase64Data(str2)) {
            return;
        }
        String substring = str2.substring(7);
        if (TextUtils.isEmpty(substring)) {
            return;
        }
        final File file = new File(substring);
        if (!file.exists()) {
            return;
        }
        final String str4 = System.currentTimeMillis() + ".jpg";
        if (TextUtils.isEmpty(str3) || !new File(str3).isDirectory()) {
            if (DEBUG && !TextUtils.isEmpty(str3)) {
                Log.e(TAG, "Download directory does not meet Android 10 partition storage specifications.");
            }
            File downloadPrivateFile = DownloadHelper.getDownloadPrivateFile();
            if (downloadPrivateFile != null) {
                str3 = downloadPrivateFile.getAbsolutePath();
            }
        }
        if (!DownloadMediaHelper.checkDownloadSpecifiedDirectoryValid(str3)) {
            str3 = DownloadHelper.getMediaFileDefaultPath(MediaFileProcessor.UriSource.IMAGE);
        }
        final String str5 = str3;
        DownloadHelper.checkExternalStorage(str3, true, new ExternalStorageCallBack() { // from class: com.baidu.searchbox.downloads.ImgDataURISchemeUtil.1
            @Override // com.baidu.searchbox.download.util.ExternalStorageCallBack
            public void onResult(boolean z) {
                if (z) {
                    try {
                        File file2 = new File(str5, str4);
                        if (ImgDataURISchemeUtil.copyFile(context, file, file2)) {
                            ImageScanner.scanFile(AppRuntime.getAppContext(), new String[]{file2.getAbsolutePath()}, null, null);
                        }
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("uri", str);
                        contentValues.put("title", str4);
                        contentValues.put("hint", str4);
                        contentValues.put(Downloads.Impl.COLUMN_IS_VISIBLE_IN_DOWNLOADS_UI, Boolean.TRUE);
                        contentValues.put("destination", (Integer) 0);
                        contentValues.put("mimetype", "image/jpeg");
                        contentValues.put("current_bytes", Long.valueOf(file2.length()));
                        contentValues.put("total_bytes", Long.valueOf(file2.length()));
                        contentValues.put("_data", file2.getAbsolutePath());
                        contentValues.put("status", (Integer) 200);
                        contentValues.put("visibility", (Integer) 0);
                        contentValues.put(ImgDataURISchemeUtil.IMAGE_CUSTOM_KEY, ImgDataURISchemeUtil.IMAGE_LOCAL_PATH);
                        SearchBoxDownloadManager.getInstance(AppRuntime.getAppContext()).beginDownload(contentValues);
                        IDownloadApp.Impl.get().postNewTipsSrcChangeMessage();
                    } catch (Exception e) {
                        if (ImgDataURISchemeUtil.DEBUG) {
                            throw new DebugException("insertDownload", e);
                        }
                    }
                }
            }
        }, true);
    }

    public static void insertImage(String str, String str2, Context context, boolean z) {
        insertImage(str, str2, context, z, "");
    }

    public static void insertImage(String str, String str2, Context context, boolean z, String str3) {
        saveImage(str, str2, context, z, str3);
    }

    public static String parseDataUriSchemeForImage(String str) {
        if (AppConfig.isDebug()) {
            Log.d(TAG, "dataUri = " + str);
        }
        String str2 = "";
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (Pattern.compile(DATA_URI_SCHEME_FOR_IMAGE_PATTERN).matcher(str).find()) {
            str2 = str.substring(str.indexOf(DATA_URL_SCHEME_BASE64_FLAG) + 7);
            if (AppConfig.isDebug()) {
                Log.d(TAG, "base64Data = " + str2);
            }
        }
        return str2;
    }

    @Nullable
    public static Uri preHandle(Context context, String str) {
        Uri uri = IDownloadApp.Impl.get().getUri(str);
        if (uri == null && !TextUtils.isEmpty(str)) {
            try {
                File saveBitmapFile = saveBitmapFile(base64ToBitmap(parseDataUriSchemeForImage(str)), PathUtils.getImageCacheDirectoryForOthers(context), IDownloadApp.Impl.get().getHashedString(DATA_URL_SCHEME_DATA_FILE_NAME));
                if (!AppConfig.isDebug() && saveBitmapFile == null) {
                    return uri;
                }
                return Uri.fromFile(saveBitmapFile);
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }
        return uri;
    }

    @Nullable
    public static File saveBitmapFile(Bitmap bitmap, String str, String str2) {
        if (bitmap != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            File file = new File(str, str2);
            try {
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bufferedOutputStream);
                bufferedOutputStream.flush();
                bufferedOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return file;
        } else if (!AppConfig.isDebug()) {
            return null;
        } else {
            throw new DebugException("ImgDataURISchemeUtil.saveBitmapFile() bitmap=" + bitmap + " filePath=" + str + " fileName=" + str2);
        }
    }

    public static boolean saveImage(String str, String str2, final Context context, boolean z, String str3) {
        if (DownloadHelper.checkTeenagerStyleAndTip() || TextUtils.isEmpty(str2) || context == null) {
            return false;
        }
        if (TextUtils.isEmpty(str)) {
            str = "file://";
        }
        insertDownload(str, str2, context, str3);
        if (z) {
            UniversalToast.makeText(context, context.getResources().getString(R.string.obfuscated_res_0x7f0f10e2)).showToast();
            return true;
        }
        UniversalToast.makeText(context, context.getString(R.string.obfuscated_res_0x7f0f05d9)).setLeftIcon(R.drawable.obfuscated_res_0x7f0805c6).setButtonText(context.getString(R.string.obfuscated_res_0x7f0f05da)).setDuration(3).setToastCallback(new UniversalToast.ToastCallback() { // from class: com.baidu.searchbox.downloads.ImgDataURISchemeUtil.2
            @Override // com.baidu.android.ext.widget.toast.UniversalToast.ToastCallback
            public void onToastClick() {
                Intent buildDownloadActivityIntent = IDownloadApp.Impl.get().buildDownloadActivityIntent(context);
                buildDownloadActivityIntent.putExtra("source", 4);
                context.startActivity(buildDownloadActivityIntent);
                DownloadStatisticUtil.toastClickDone("", "", "");
            }
        }).showClickableToastWithLeftIcon();
        return true;
    }
}
