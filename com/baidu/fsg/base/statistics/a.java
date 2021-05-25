package com.baidu.fsg.base.statistics;

import android.app.ActivityManager;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.format.Formatter;
import com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f5190a = "utf-8";

    /* renamed from: b  reason: collision with root package name */
    public static final String f5191b = "c82c403505338808201aad86f8194734";

    public static void a(Context context, String str, String str2, boolean z) {
        if (context == null) {
            return;
        }
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = context.openFileOutput(str, z ? 32768 : 0);
            if (fileOutputStream != null) {
                fileOutputStream.write(str2.getBytes("utf-8"));
            }
            if (fileOutputStream == null) {
                return;
            }
        } catch (Exception unused) {
            if (fileOutputStream == null) {
                return;
            }
        } catch (Throwable th) {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (Exception unused2) {
                }
            }
            throw th;
        }
        try {
            fileOutputStream.close();
        } catch (Exception unused3) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x002a, code lost:
        if (r0 == null) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x002e, code lost:
        if (r0 == null) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0030, code lost:
        r0.close();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] b(Context context, String str) {
        byte[] bArr;
        FileInputStream fileInputStream = null;
        r0 = null;
        r0 = null;
        byte[] bArr2 = null;
        r0 = null;
        FileInputStream fileInputStream2 = null;
        try {
            FileInputStream openFileInput = context.openFileInput(str);
            if (openFileInput != null) {
                try {
                    bArr2 = new byte[openFileInput.available()];
                    openFileInput.read(bArr2);
                } catch (FileNotFoundException unused) {
                    byte[] bArr3 = bArr2;
                    fileInputStream2 = openFileInput;
                    bArr = bArr3;
                } catch (IOException unused2) {
                    byte[] bArr4 = bArr2;
                    fileInputStream2 = openFileInput;
                    bArr = bArr4;
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = openFileInput;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused3) {
                        }
                    }
                    throw th;
                }
            }
            if (openFileInput != null) {
                try {
                    openFileInput.close();
                    return bArr2;
                } catch (IOException unused4) {
                    return bArr2;
                }
            }
            return bArr2;
        } catch (FileNotFoundException unused5) {
            bArr = null;
        } catch (IOException unused6) {
            bArr = null;
        } catch (Throwable th2) {
            th = th2;
        }
        return bArr;
    }

    public static boolean c(Context context, String str) {
        if (context == null) {
            return false;
        }
        return context.getFileStreamPath(str).exists();
    }

    public static String c(Context context) {
        long j = 0;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
            j = Long.valueOf(bufferedReader.readLine().split("\\s+")[1]).longValue() * 1024;
            bufferedReader.close();
        } catch (IOException unused) {
        }
        return Formatter.formatFileSize(context, j);
    }

    public static String a(Context context, String str) {
        if (context == null) {
            return null;
        }
        try {
            byte[] b2 = b(context, str);
            return b2 != null ? new String(b2, "utf-8") : "";
        } catch (Exception unused) {
            return "";
        }
    }

    public static String a(byte[] bArr, boolean z) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(bArr);
            return a(messageDigest.digest(), "", z);
        } catch (NoSuchAlgorithmException e2) {
            throw new RuntimeException(e2);
        }
    }

    public static String b(Context context) {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
        return Formatter.formatFileSize(context, memoryInfo.availMem) + "_" + memoryInfo.lowMemory + "_" + Formatter.formatFileSize(context, memoryInfo.threshold);
    }

    public static String a(byte[] bArr, String str, boolean z) {
        StringBuilder sb = new StringBuilder();
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & 255);
            if (z) {
                hexString = hexString.toUpperCase();
            }
            if (hexString.length() == 1) {
                sb.append("0");
            }
            sb.append(hexString);
            sb.append(str);
        }
        return sb.toString();
    }

    public static boolean a(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        return (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isAvailable()) ? false : true;
    }

    public static String a() {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) RimStatisticsUtil.getAppContext().getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                String typeName = activeNetworkInfo.getTypeName();
                return (typeName.equals(CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING) || activeNetworkInfo.getSubtypeName() == null) ? typeName : activeNetworkInfo.getSubtypeName();
            }
            return "";
        } catch (Exception unused) {
            return "";
        }
    }
}
