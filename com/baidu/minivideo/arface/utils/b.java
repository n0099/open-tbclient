package com.baidu.minivideo.arface.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.text.TextUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes6.dex */
public class b {
    private Context mContext;

    public b(Context context) {
        this.mContext = context;
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x00cc A[Catch: IOException -> 0x00d0, TRY_LEAVE, TryCatch #7 {IOException -> 0x00d0, blocks: (B:60:0x00c7, B:62:0x00cc), top: B:77:0x00c7 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00c7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean b(String str, File file) {
        FileOutputStream fileOutputStream;
        Throwable th;
        InputStream inputStream;
        Exception e;
        FileOutputStream fileOutputStream2;
        InputStream inputStream2 = null;
        AssetManager assets = this.mContext.getAssets();
        try {
            String[] list = assets.list(str);
            if (list.length > 0) {
                if (file.isDirectory() && !file.exists()) {
                    file.mkdirs();
                }
                for (String str2 : list) {
                    if (!TextUtils.isEmpty(str2)) {
                        b(str + File.separator + str2, new File(file, str2));
                    }
                }
                fileOutputStream2 = null;
            } else {
                str.substring(0, str.lastIndexOf("/"));
                File parentFile = file.getParentFile();
                if (parentFile != null && !parentFile.exists()) {
                    parentFile.mkdirs();
                }
                if (file.exists()) {
                    file.delete();
                }
                file.createNewFile();
                inputStream = assets.open(str);
                try {
                    fileOutputStream = new FileOutputStream(file);
                    try {
                        try {
                            byte[] bArr = new byte[1024];
                            while (true) {
                                int read = inputStream.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                fileOutputStream.write(bArr, 0, read);
                            }
                            fileOutputStream.flush();
                            inputStream2 = inputStream;
                            fileOutputStream2 = fileOutputStream;
                        } catch (Exception e2) {
                            e = e2;
                            e.printStackTrace();
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
                        }
                    } catch (Throwable th2) {
                        th = th2;
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
                } catch (Exception e5) {
                    fileOutputStream = null;
                    e = e5;
                } catch (Throwable th3) {
                    fileOutputStream = null;
                    th = th3;
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
                } catch (IOException e6) {
                    e6.printStackTrace();
                }
            }
            if (inputStream2 != null) {
                inputStream2.close();
            }
            return true;
        } catch (Exception e7) {
            fileOutputStream = null;
            e = e7;
            inputStream = null;
        } catch (Throwable th4) {
            fileOutputStream = null;
            th = th4;
            inputStream = null;
        }
    }
}
