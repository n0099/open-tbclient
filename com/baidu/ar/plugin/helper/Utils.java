package com.baidu.ar.plugin.helper;

import android.app.ActivityManager;
import android.content.Context;
import com.meizu.cloud.pushsdk.constants.PushConstants;
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
/* loaded from: classes20.dex */
public class Utils {
    private static final String ALGORITHM = "MD5";
    private static final String VALID_JAVA_IDENTIFIER = "(\\p{javaJavaIdentifierStart}\\p{javaJavaIdentifierPart}*\\.)*\\p{javaJavaIdentifierStart}\\p{javaJavaIdentifierPart}*";
    private static final Pattern ANDROID_DATA_PATTERN = Pattern.compile(VALID_JAVA_IDENTIFIER);
    private static final char[] HEX = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static boolean validateJavaIdentifier(String str) {
        return ANDROID_DATA_PATTERN.matcher(str).matches();
    }

    public static void copyFile(String str, String str2, boolean z, Context context) throws IOException {
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2;
        BufferedOutputStream bufferedOutputStream;
        BufferedOutputStream bufferedOutputStream2 = null;
        try {
            if (z) {
                bufferedInputStream2 = new BufferedInputStream(context.getAssets().open(str));
            } else {
                bufferedInputStream2 = new BufferedInputStream(new FileInputStream(str));
            }
            try {
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str2));
            } catch (Throwable th) {
                th = th;
                bufferedInputStream = bufferedInputStream2;
            }
        } catch (Throwable th2) {
            th = th2;
            bufferedInputStream = null;
        }
        try {
            byte[] bArr = new byte[8192];
            while (true) {
                int read = bufferedInputStream2.read(bArr);
                if (read == -1) {
                    break;
                }
                bufferedOutputStream.write(bArr, 0, read);
            }
            if (bufferedInputStream2 != null) {
                try {
                    bufferedInputStream2.close();
                } catch (Exception e) {
                }
            }
            if (bufferedOutputStream != null) {
                try {
                    bufferedOutputStream.close();
                } catch (Exception e2) {
                }
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedOutputStream2 = bufferedOutputStream;
            bufferedInputStream = bufferedInputStream2;
            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (Exception e3) {
                }
            }
            if (bufferedOutputStream2 != null) {
                try {
                    bufferedOutputStream2.close();
                } catch (Exception e4) {
                }
            }
            throw th;
        }
    }

    public static void deleteDir(String str) {
        deleteFile(new File(str));
    }

    private static void deleteFile(File file) {
        if (file.isDirectory()) {
            for (File file2 : file.listFiles()) {
                deleteFile(file2);
            }
        }
        file.delete();
    }

    public static void writeToFile(File file, byte[] bArr) throws IOException {
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(file);
            try {
                fileOutputStream.write(bArr);
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e) {
                    }
                }
            } catch (Throwable th) {
                th = th;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e2) {
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
        }
    }

    public static byte[] readFromFile(File file) throws IOException {
        FileInputStream fileInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            fileInputStream = new FileInputStream(file);
        } catch (Throwable th) {
            th = th;
            fileInputStream = null;
        }
        try {
            byte[] bArr = new byte[8192];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                }
            }
            return byteArray;
        } catch (Throwable th2) {
            th = th2;
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e2) {
                }
            }
            throw th;
        }
    }

    public static String md5(byte[] bArr) {
        try {
            return toHex(MessageDigest.getInstance("MD5").digest(bArr));
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    private static String toHex(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            sb.append(HEX[(b & 240) >> 4]);
            sb.append(HEX[b & 15]);
        }
        return sb.toString();
    }

    public static String getProcessName(Context context, int i) {
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningAppProcesses()) {
            if (runningAppProcessInfo != null && runningAppProcessInfo.pid == i) {
                return runningAppProcessInfo.processName;
            }
        }
        return null;
    }
}
