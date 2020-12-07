package com.baidu.minivideo.arface.utils;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes8.dex */
public class b {
    private Context mContext;

    public b(Context context) {
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

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:72:0x00de */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.content.res.AssetManager] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.io.InputStream] */
    private boolean doAssetToSDcard(String str, File file) {
        FileOutputStream fileOutputStream;
        Throwable th;
        FileOutputStream fileOutputStream2;
        Exception e;
        InputStream inputStream;
        FileOutputStream fileOutputStream3;
        InputStream inputStream2 = null;
        ?? assets = this.mContext.getAssets();
        try {
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
                    fileOutputStream3 = null;
                } else {
                    File parentFile = file.getParentFile();
                    if (parentFile != null && !parentFile.exists()) {
                        parentFile.mkdirs();
                    }
                    if (file.exists()) {
                        file.delete();
                    }
                    file.createNewFile();
                    assets = assets.open(str);
                    try {
                        fileOutputStream2 = new FileOutputStream(file);
                        try {
                            byte[] bArr = new byte[1024];
                            while (true) {
                                int read = assets.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                fileOutputStream2.write(bArr, 0, read);
                            }
                            fileOutputStream2.flush();
                            inputStream2 = assets;
                            fileOutputStream3 = fileOutputStream2;
                        } catch (Exception e2) {
                            e = e2;
                            inputStream = assets;
                            e.printStackTrace();
                            if (fileOutputStream2 != null) {
                                try {
                                    fileOutputStream2.close();
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
                    } catch (Exception e4) {
                        fileOutputStream2 = null;
                        e = e4;
                        inputStream = assets;
                    } catch (Throwable th2) {
                        fileOutputStream = null;
                        th = th2;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e5) {
                                e5.printStackTrace();
                                throw th;
                            }
                        }
                        if (assets != 0) {
                            assets.close();
                        }
                        throw th;
                    }
                }
                if (fileOutputStream3 != null) {
                    try {
                        fileOutputStream3.close();
                    } catch (IOException e6) {
                        e6.printStackTrace();
                    }
                }
                if (inputStream2 != null) {
                    inputStream2.close();
                }
                return true;
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Exception e7) {
            fileOutputStream2 = null;
            e = e7;
            inputStream = null;
        } catch (Throwable th4) {
            fileOutputStream = null;
            th = th4;
            assets = 0;
        }
    }
}
