package com.baidu.b.a.h;

import android.content.Context;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
/* loaded from: classes2.dex */
public final class h {
    private static String sCacheDir = null;
    public static int INVALID_INDEX = -1;
    public static int ONE_INCREAMENT = 1;

    public static boolean deleteFile(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        if (file.exists()) {
            return deleteFile(file);
        }
        return false;
    }

    public static boolean deleteFile(File file) {
        if (file == null) {
            return false;
        }
        boolean z = true;
        if (file.exists()) {
            if (file.isFile()) {
                z = true & file.delete();
            } else if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    for (File file2 : listFiles) {
                        z &= deleteFile(file2);
                    }
                }
                z &= file.delete();
            }
        }
        return z;
    }

    public static boolean cache(Context context, String str, String str2, int i) {
        return cache(context, str, str2.getBytes(), i);
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, MOVE_EXCEPTION, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [640=4, 641=4, 637=4, 639=4] */
    public static boolean cache(Context context, String str, byte[] bArr, int i) {
        boolean z = false;
        if (bArr == null) {
            bArr = new byte[0];
        }
        FileOutputStream fileOutputStream = null;
        try {
            try {
                try {
                    fileOutputStream = context.openFileOutput(str, i);
                    fileOutputStream.write(bArr);
                    fileOutputStream.flush();
                    z = true;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (FileNotFoundException e2) {
                    e2.printStackTrace();
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                }
            } catch (IOException e4) {
                e4.printStackTrace();
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                }
            }
            return z;
        } catch (Throwable th) {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e6) {
                    e6.printStackTrace();
                }
            }
            throw th;
        }
    }

    public static String readCacheData(Context context, String str) {
        try {
            return readInputStream(context.openFileInput(str));
        } catch (FileNotFoundException e) {
            return "";
        }
    }

    private static String readInputStream(FileInputStream fileInputStream) {
        if (fileInputStream == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        try {
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        sb.append(readLine);
                    } else {
                        String sb2 = sb.toString();
                        try {
                            fileInputStream.close();
                            return sb2;
                        } catch (IOException e) {
                            e.printStackTrace();
                            return sb2;
                        }
                    }
                }
            } catch (IOException e2) {
                e2.printStackTrace();
                try {
                    fileInputStream.close();
                    return "";
                } catch (IOException e3) {
                    e3.printStackTrace();
                    return "";
                }
            }
        } catch (Throwable th) {
            try {
                fileInputStream.close();
            } catch (IOException e4) {
                e4.printStackTrace();
            }
            throw th;
        }
    }
}
