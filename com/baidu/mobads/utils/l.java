package com.baidu.mobads.utils;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import com.baidu.mobads.interfaces.utils.IXAdIOUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
/* loaded from: classes3.dex */
public class l implements IXAdIOUtils {
    public static String a(Context context) {
        String str;
        if (!n.a(context)) {
            return a(context, IXAdIOUtils.DEFAULT_SD_CARD_PATH);
        }
        if (n.c(context)) {
            return a(context, IXAdIOUtils.DEFAULT_SD_CARD_PATH);
        }
        File externalFilesDir = context.getExternalFilesDir(null);
        if (externalFilesDir == null) {
            externalFilesDir = b(context);
        }
        if (externalFilesDir == null) {
            str = "";
        } else {
            str = externalFilesDir.getPath();
        }
        return a(str);
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdIOUtils
    @Deprecated
    public String getStoreagePath(Context context, String str, String str2) {
        try {
            return getExternalFilesDir(context).getPath() + str2;
        } catch (Exception e) {
            return str + str2;
        }
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdIOUtils
    public String getStoreagePath(Context context) {
        return a(context, IXAdIOUtils.DEFAULT_SD_CARD_PATH);
    }

    public static String a(Context context, String str) {
        try {
            return a(b(context).getPath());
        } catch (Exception e) {
            return a(str);
        }
    }

    public static String a(String str) {
        return str + IXAdIOUtils.DEFAULT_CACHE_PATH;
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdIOUtils
    public File getExternalFilesDir(Context context) {
        return b(context);
    }

    public static File b(Context context) {
        File file = null;
        try {
            if ("mounted".equals(Environment.getExternalStorageState())) {
                if (e.b(context, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                    file = a();
                } else if (Build.VERSION.SDK_INT >= 19) {
                    file = context.getExternalFilesDir(null);
                } else {
                    file = context.getFilesDir();
                }
            } else {
                file = context.getFilesDir();
            }
        } catch (Exception e) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().e("XAdIOUtils", e.getMessage());
        }
        return file;
    }

    private static File a() {
        return Environment.getExternalStorageDirectory();
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
        } catch (Exception e) {
            return file.delete() ? null : file;
        }
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdIOUtils
    public File deleteFileRecursive(String str) {
        return deleteFileRecursive(new File(str));
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdIOUtils
    public boolean renameFile(String str, String str2) {
        try {
            File file = new File(str);
            File file2 = new File(str2);
            if (file == null || !file.exists()) {
                return false;
            }
            return file.renameTo(file2);
        } catch (Exception e) {
            return false;
        }
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdIOUtils
    public void copyFileInputStream(InputStream inputStream, String str) {
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(str);
        } catch (Throwable th) {
            th = th;
            fileOutputStream = null;
        }
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read <= 0) {
                    break;
                }
                fileOutputStream.write(bArr, 0, read);
            }
            inputStream.close();
            fileOutputStream.close();
            if (inputStream != null) {
                inputStream.close();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
        } catch (Throwable th2) {
            th = th2;
            if (inputStream != null) {
                inputStream.close();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            throw th;
        }
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdIOUtils
    public void copyFileFromAssetsTo(Context context, String str, String str2) {
        try {
            XAdSDKFoundationFacade.getInstance().getIoUtils().copyFileInputStream(context.getAssets().open(str), str2);
        } catch (Exception e) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().d(e);
        }
    }

    public static boolean a(File file) {
        if (file != null) {
            try {
                if (file.exists() && file.canRead()) {
                    return file.length() > 0;
                }
                return false;
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }

    public static boolean b(String str) {
        File file;
        try {
            if (!TextUtils.isEmpty(str) && (file = new File(str)) != null && file.exists() && file.canRead()) {
                return file.length() > 0;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }
}
