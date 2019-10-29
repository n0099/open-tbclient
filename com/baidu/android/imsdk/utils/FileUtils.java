package com.baidu.android.imsdk.utils;

import android.os.Environment;
import android.text.TextUtils;
import com.baidu.android.imsdk.IMConstants;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
/* loaded from: classes6.dex */
public class FileUtils {
    public static String getFileName(String str) {
        if (str.length() > str.lastIndexOf(47) + 1) {
            return str.substring(str.lastIndexOf(47) + 1);
        }
        return null;
    }

    public static String getContentType(String str) {
        if (str.endsWith(".jpg")) {
            return "image/jpeg";
        }
        if (str.endsWith(".amr")) {
            return "audio/amr";
        }
        return "binary/octet-stream";
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [56=5, 58=4] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x002c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] readDataFromFile(String str) {
        Exception exc;
        byte[] bArr;
        IOException iOException;
        File file;
        FileInputStream fileInputStream = null;
        try {
            if (Environment.getExternalStorageState().equals("mounted")) {
                try {
                    file = new File(str);
                } catch (IOException e) {
                    iOException = e;
                    bArr = null;
                } catch (Exception e2) {
                    exc = e2;
                    bArr = null;
                }
                if (file.exists()) {
                    FileInputStream fileInputStream2 = new FileInputStream(file);
                    try {
                        try {
                            byte[] bArr2 = new byte[(int) file.length()];
                            try {
                                fileInputStream2.read(bArr2);
                                bArr = bArr2;
                                fileInputStream = fileInputStream2;
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (IOException e3) {
                                    }
                                }
                            } catch (IOException e4) {
                                bArr = bArr2;
                                fileInputStream = fileInputStream2;
                                iOException = e4;
                                LogUtils.e("FileUtils", "readDataFromFile:", iOException);
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (IOException e5) {
                                    }
                                }
                                return bArr;
                            } catch (Exception e6) {
                                bArr = bArr2;
                                fileInputStream = fileInputStream2;
                                exc = e6;
                                LogUtils.e("FileUtils", "readDataFromFile:", exc);
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (IOException e7) {
                                    }
                                }
                                return bArr;
                            }
                        } catch (Throwable th) {
                            th = th;
                            fileInputStream = fileInputStream2;
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e8) {
                                }
                            }
                            throw th;
                        }
                    } catch (IOException e9) {
                        bArr = null;
                        fileInputStream = fileInputStream2;
                        iOException = e9;
                    } catch (Exception e10) {
                        bArr = null;
                        fileInputStream = fileInputStream2;
                        exc = e10;
                    }
                    return bArr;
                }
            }
            bArr = null;
            if (fileInputStream != null) {
            }
            return bArr;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [87=5, 89=4] */
    public static void saveDataToFile(String str, byte[] bArr) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        if (Environment.getExternalStorageState().equals("mounted")) {
            try {
                if (bArr != null) {
                    try {
                        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + IMConstants.IM_ICON_DIR);
                        if (!file.exists()) {
                            file.mkdirs();
                        }
                        fileOutputStream = new FileOutputStream(new File(str));
                    } catch (IOException e) {
                        e = e;
                    } catch (Exception e2) {
                        e = e2;
                    }
                    try {
                        fileOutputStream.write(bArr);
                        fileOutputStream.flush();
                        fileOutputStream2 = fileOutputStream;
                    } catch (IOException e3) {
                        e = e3;
                        fileOutputStream2 = fileOutputStream;
                        LogUtils.e("FileUtils", "saveDataToFile:", e);
                        if (fileOutputStream2 != null) {
                            try {
                                fileOutputStream2.close();
                                return;
                            } catch (IOException e4) {
                                return;
                            }
                        }
                        return;
                    } catch (Exception e5) {
                        e = e5;
                        fileOutputStream2 = fileOutputStream;
                        LogUtils.e("FileUtils", "saveDataToFile:", e);
                        if (fileOutputStream2 != null) {
                            try {
                                fileOutputStream2.close();
                                return;
                            } catch (IOException e6) {
                                return;
                            }
                        }
                        return;
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream2 = fileOutputStream;
                        if (fileOutputStream2 != null) {
                            try {
                                fileOutputStream2.close();
                            } catch (IOException e7) {
                            }
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        if (fileOutputStream2 != null) {
            try {
                fileOutputStream2.close();
            } catch (IOException e8) {
            }
        }
    }

    public static String getIconFilePath(String str) {
        if (!Environment.getExternalStorageState().equals("mounted") || TextUtils.isEmpty(str)) {
            return null;
        }
        return Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + IMConstants.IM_ICON_DIR + File.separator + str + ".png";
    }
}
