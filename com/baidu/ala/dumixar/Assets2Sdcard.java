package com.baidu.ala.dumixar;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Environment;
import android.text.TextUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes15.dex */
public class Assets2Sdcard {
    private Context mContext;

    public Assets2Sdcard(Context context) {
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

    /* JADX WARN: Removed duplicated region for block: B:60:0x00c0 A[Catch: IOException -> 0x00ce, TRY_LEAVE, TryCatch #8 {IOException -> 0x00ce, blocks: (B:58:0x00bb, B:60:0x00c0), top: B:82:0x00bb }] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00bb A[EXC_TOP_SPLITTER, SYNTHETIC] */
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
                    } catch (Exception e) {
                        exc = e;
                        inputStream = open;
                        fileOutputStream = fileOutputStream2;
                        try {
                            exc.printStackTrace();
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e2) {
                                    e2.printStackTrace();
                                    return false;
                                }
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            return false;
                        } catch (Throwable th2) {
                            th = th2;
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e3) {
                                    e3.printStackTrace();
                                    throw th;
                                }
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        inputStream = open;
                        fileOutputStream = fileOutputStream2;
                        if (fileOutputStream != null) {
                        }
                        if (inputStream != null) {
                        }
                        throw th;
                    }
                } catch (Exception e4) {
                    exc = e4;
                    inputStream = open;
                    fileOutputStream = null;
                } catch (Throwable th4) {
                    th = th4;
                    inputStream = open;
                    fileOutputStream = null;
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

    private void getDirectory(String str) {
        String[] split = str.split("/");
        String file = Environment.getExternalStorageDirectory().toString();
        for (int i = 0; i < split.length; i++) {
            file = file + "/" + split[i];
            File file2 = new File(file);
            if (!file2.exists()) {
                file2.mkdir();
            }
        }
    }
}
