package com.baidu.ar.plugin.helper;

import android.app.ActivityManager;
import android.content.Context;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class Utils {
    public static final String ALGORITHM = "MD5";
    public static final Pattern ANDROID_DATA_PATTERN = Pattern.compile("(\\p{javaJavaIdentifierStart}\\p{javaJavaIdentifierPart}*\\.)*\\p{javaJavaIdentifierStart}\\p{javaJavaIdentifierPart}*");
    public static final char[] HEX = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    public static final String VALID_JAVA_IDENTIFIER = "(\\p{javaJavaIdentifierStart}\\p{javaJavaIdentifierPart}*\\.)*\\p{javaJavaIdentifierStart}\\p{javaJavaIdentifierPart}*";

    public static void copyFile(String str, String str2, boolean z, Context context) throws IOException {
        BufferedOutputStream bufferedOutputStream;
        BufferedInputStream bufferedInputStream;
        BufferedOutputStream bufferedOutputStream2;
        BufferedInputStream bufferedInputStream2 = null;
        try {
            if (z) {
                bufferedInputStream = new BufferedInputStream(context.getAssets().open(str));
            } else {
                bufferedInputStream = new BufferedInputStream(new FileInputStream(str));
            }
            try {
                bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(str2));
            } catch (Throwable th) {
                th = th;
                bufferedOutputStream = null;
                bufferedInputStream2 = bufferedInputStream;
            }
        } catch (Throwable th2) {
            th = th2;
            bufferedOutputStream = null;
        }
        try {
            byte[] bArr = new byte[8192];
            while (true) {
                int read = bufferedInputStream.read(bArr);
                if (read != -1) {
                    bufferedOutputStream2.write(bArr, 0, read);
                } else {
                    try {
                        break;
                    } catch (Exception unused) {
                    }
                }
            }
            bufferedInputStream.close();
            try {
                bufferedOutputStream2.close();
            } catch (Exception unused2) {
            }
        } catch (Throwable th3) {
            bufferedInputStream2 = bufferedInputStream;
            bufferedOutputStream = bufferedOutputStream2;
            th = th3;
            if (bufferedInputStream2 != null) {
                try {
                    bufferedInputStream2.close();
                } catch (Exception unused3) {
                }
            }
            if (bufferedOutputStream != null) {
                try {
                    bufferedOutputStream.close();
                } catch (Exception unused4) {
                }
            }
            throw th;
        }
    }

    public static void deleteDir(String str) {
        deleteFile(new File(str));
    }

    public static void deleteFile(File file) {
        if (file.isDirectory()) {
            for (File file2 : file.listFiles()) {
                deleteFile(file2);
            }
        }
        file.delete();
    }

    public static String getProcessName(Context context, int i) {
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
            if (runningAppProcessInfo != null && runningAppProcessInfo.pid == i) {
                return runningAppProcessInfo.processName;
            }
        }
        return null;
    }

    public static String md5(byte[] bArr) {
        try {
            return toHex(MessageDigest.getInstance("MD5").digest(bArr));
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    public static byte[] readFromFile(File file) throws IOException {
        FileInputStream fileInputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                byte[] bArr = new byte[8192];
                while (true) {
                    int read = fileInputStream2.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                try {
                    fileInputStream2.close();
                } catch (IOException unused) {
                }
                return byteArray;
            } catch (Throwable th) {
                th = th;
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException unused2) {
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String toHex(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b2 : bArr) {
            sb.append(HEX[(b2 & 240) >> 4]);
            sb.append(HEX[b2 & 15]);
        }
        return sb.toString();
    }

    public static boolean validateJavaIdentifier(String str) {
        return ANDROID_DATA_PATTERN.matcher(str).matches();
    }

    public static void writeToFile(File file, byte[] bArr) throws IOException {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            fileOutputStream = new FileOutputStream(file);
        } catch (Throwable th) {
            th = th;
        }
        try {
            fileOutputStream.write(bArr);
            try {
                fileOutputStream.close();
            } catch (IOException unused) {
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException unused2) {
                }
            }
            throw th;
        }
    }
}
