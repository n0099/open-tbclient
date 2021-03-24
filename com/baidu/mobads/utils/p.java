package com.baidu.mobads.utils;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import com.baidu.mobads.MobadsPermissionSettings;
import com.baidu.mobads.interfaces.utils.IXAdIOUtils;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
/* loaded from: classes2.dex */
public class p implements IXAdIOUtils {
    public static String a(Context context) {
        if (!r.a(context)) {
            return a(context, IXAdIOUtils.DEFAULT_SD_CARD_PATH);
        }
        if (r.c(context)) {
            return a(context, IXAdIOUtils.DEFAULT_SD_CARD_PATH);
        }
        return a(context.getExternalFilesDir(null).getPath());
    }

    public static File b(Context context) {
        try {
            if (Build.VERSION.SDK_INT > 28) {
                return context.getExternalFilesDir(null);
            }
            if ("mounted".equals(Environment.getExternalStorageState())) {
                if (h.b(context, StorageUtils.EXTERNAL_STORAGE_PERMISSION) && MobadsPermissionSettings.hasPermissionGranted("permission_storage")) {
                    return a();
                }
                if (Build.VERSION.SDK_INT >= 19) {
                    return context.getExternalFilesDir(null);
                }
                return context.getFilesDir();
            }
            return context.getFilesDir();
        } catch (Exception e2) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().e("XAdIOUtils", e2.getMessage());
            return null;
        }
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdIOUtils
    public void copyFileFromAssetsTo(Context context, String str, String str2) {
        try {
            XAdSDKFoundationFacade.getInstance().getIoUtils().copyFileInputStream(context.getAssets().open(str), str2);
        } catch (Exception e2) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().d(e2);
        }
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdIOUtils
    public void copyFileInputStream(InputStream inputStream, String str) {
        FileOutputStream fileOutputStream = null;
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(str);
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    fileOutputStream2.write(bArr, 0, read);
                }
                inputStream.close();
                fileOutputStream2.close();
                if (inputStream != null) {
                    inputStream.close();
                }
                fileOutputStream2.close();
            } catch (Throwable th) {
                th = th;
                fileOutputStream = fileOutputStream2;
                if (inputStream != null) {
                    inputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdIOUtils
    public File deleteFileRecursive(File file) {
        try {
            if (file.isDirectory()) {
                for (File file2 : file.listFiles()) {
                    File deleteFileRecursive = deleteFileRecursive(file2);
                    if (deleteFileRecursive != null) {
                        return deleteFileRecursive;
                    }
                }
            }
            if (file.delete()) {
                return null;
            }
            return file;
        } catch (Exception unused) {
            if (file.delete()) {
                return null;
            }
            return file;
        }
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdIOUtils
    public File getExternalFilesDir(Context context) {
        return b(context);
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdIOUtils
    @Deprecated
    public String getStoreagePath(Context context, String str, String str2) {
        try {
            return getExternalFilesDir(context).getPath() + str2;
        } catch (Exception unused) {
            return str + str2;
        }
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdIOUtils
    public boolean renameFile(String str, String str2) {
        try {
            File file = new File(str);
            File file2 = new File(str2);
            if (file.exists()) {
                return file.renameTo(file2);
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdIOUtils
    public String getStoreagePath(Context context) {
        return a(context, IXAdIOUtils.DEFAULT_SD_CARD_PATH);
    }

    public static String a(Context context, String str) {
        try {
            return a(b(context).getPath());
        } catch (Exception unused) {
            return a(str);
        }
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdIOUtils
    public File deleteFileRecursive(String str) {
        return deleteFileRecursive(new File(str));
    }

    public static String a(String str) {
        return str + IXAdIOUtils.DEFAULT_CACHE_PATH;
    }

    public static File a() {
        return Environment.getExternalStorageDirectory();
    }

    public static boolean a(File file) {
        if (file != null) {
            try {
                if (file.exists() && file.canRead()) {
                    return file.length() > 0;
                }
                return false;
            } catch (Exception unused) {
                return false;
            }
        }
        return false;
    }

    public static boolean b(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            File file = new File(str);
            if (file.exists() && file.canRead()) {
                return file.length() > 0;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }
}
