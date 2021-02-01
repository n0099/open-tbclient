package com.baidu.minivideo.arface.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.text.TextUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes3.dex */
public class c {
    private Context mContext;

    public c(Context context) {
        this.mContext = context;
    }

    public boolean assetToSD(String str, File file) {
        boolean doAssetToSDcard = doAssetToSDcard(str, file);
        if (file.isDirectory()) {
            File file2 = new File(file, ".nomedia");
            if (!file2.exists()) {
                try {
                    file2.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return doAssetToSDcard;
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x00c6 A[Catch: IOException -> 0x00d4, TRY_LEAVE, TryCatch #3 {IOException -> 0x00d4, blocks: (B:60:0x00c1, B:62:0x00c6), top: B:82:0x00c1 }] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00c1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean doAssetToSDcard(String str, File file) {
        Throwable th;
        InputStream inputStream;
        FileOutputStream fileOutputStream;
        Exception exc;
        InputStream open;
        FileOutputStream fileOutputStream2;
        AssetManager assets = this.mContext.getAssets();
        try {
            String[] list = assets.list(str);
            if (list.length > 0) {
                if (!file.isDirectory() && file.exists()) {
                    file.delete();
                }
                if (file.isDirectory() && !file.exists()) {
                    file.mkdirs();
                }
                for (String str2 : list) {
                    if (!TextUtils.isEmpty(str2)) {
                        doAssetToSDcard(str + File.separator + str2, new File(file, str2));
                    }
                }
                open = null;
                fileOutputStream2 = null;
            } else {
                File parentFile = file.getParentFile();
                if (parentFile != null && !parentFile.exists()) {
                    parentFile.mkdirs();
                }
                if (file.exists()) {
                    file.delete();
                }
                file.createNewFile();
                open = assets.open(str);
                try {
                    fileOutputStream2 = new FileOutputStream(file);
                } catch (Exception e) {
                    exc = e;
                    inputStream = open;
                    fileOutputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    inputStream = open;
                    fileOutputStream = null;
                }
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = open.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream2.write(bArr, 0, read);
                    }
                    fileOutputStream2.flush();
                } catch (Exception e2) {
                    exc = e2;
                    inputStream = open;
                    fileOutputStream = fileOutputStream2;
                    try {
                        exc.printStackTrace();
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                                return false;
                            }
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        return false;
                    } catch (Throwable th3) {
                        th = th3;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                                throw th;
                            }
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    inputStream = open;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                    }
                    if (inputStream != null) {
                    }
                    throw th;
                }
            }
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
            }
            if (open != null) {
                open.close();
            }
            return true;
        } catch (Exception e6) {
            exc = e6;
            inputStream = null;
            fileOutputStream = null;
        } catch (Throwable th5) {
            th = th5;
            inputStream = null;
            fileOutputStream = null;
        }
    }
}
