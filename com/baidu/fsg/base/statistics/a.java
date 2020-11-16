package com.baidu.fsg.base.statistics;

import android.app.ActivityManager;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.format.Formatter;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f1486a = "utf-8";
    private static final String b = "c82c403505338808201aad86f8194734";

    a() {
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [41=4] */
    public static void a(Context context, String str, String str2, boolean z) {
        FileOutputStream fileOutputStream;
        Throwable th;
        if (context == null) {
            return;
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                FileOutputStream openFileOutput = context.openFileOutput(str, z ? 32768 : 0);
                if (openFileOutput != null) {
                    try {
                        openFileOutput.write(str2.getBytes(f1486a));
                    } catch (Throwable th2) {
                        fileOutputStream = openFileOutput;
                        th = th2;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Exception e) {
                            }
                        }
                        throw th;
                    }
                }
                if (openFileOutput != null) {
                    try {
                        openFileOutput.close();
                    } catch (Exception e2) {
                    }
                }
            } catch (Throwable th3) {
                fileOutputStream = null;
                th = th3;
            }
        } catch (Exception e3) {
            if (0 != 0) {
                try {
                    fileOutputStream2.close();
                } catch (Exception e4) {
                }
            }
        }
    }

    public static String a(Context context, String str) {
        if (context == null) {
            return null;
        }
        try {
            byte[] b2 = b(context, str);
            if (b2 == null) {
                return "";
            }
            return new String(b2, f1486a);
        } catch (Exception e) {
            return "";
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [86=4, 87=4] */
    static byte[] b(Context context, String str) {
        FileInputStream fileInputStream;
        Throwable th;
        byte[] bArr = null;
        try {
            fileInputStream = context.openFileInput(str);
            if (fileInputStream != null) {
                try {
                    bArr = new byte[fileInputStream.available()];
                    fileInputStream.read(bArr);
                } catch (FileNotFoundException e) {
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e2) {
                        }
                    }
                    return bArr;
                } catch (IOException e3) {
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e4) {
                        }
                    }
                    return bArr;
                } catch (Throwable th2) {
                    th = th2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e5) {
                        }
                    }
                    throw th;
                }
            }
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e6) {
                }
            }
        } catch (FileNotFoundException e7) {
            fileInputStream = null;
        } catch (IOException e8) {
            fileInputStream = null;
        } catch (Throwable th3) {
            fileInputStream = null;
            th = th3;
        }
        return bArr;
    }

    public static boolean c(Context context, String str) {
        if (context == null) {
            return false;
        }
        return context.getFileStreamPath(str).exists();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(byte[] bArr, boolean z) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(bArr);
            return a(messageDigest.digest(), "", z);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    static String a(byte[] bArr, String str, boolean z) {
        StringBuilder sb = new StringBuilder();
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & 255);
            if (z) {
                hexString = hexString.toUpperCase();
            }
            if (hexString.length() == 1) {
                sb.append("0");
            }
            sb.append(hexString).append(str);
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(Context context) {
        ConnectivityManager connectivityManager;
        if (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null) {
            return false;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isAvailable();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a() {
        String str;
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) RimStatisticsUtil.getAppContext().getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return "";
            }
            String typeName = activeNetworkInfo.getTypeName();
            try {
                if (!typeName.equals("WIFI") && activeNetworkInfo.getSubtypeName() != null) {
                    return activeNetworkInfo.getSubtypeName();
                }
                return typeName;
            } catch (Exception e) {
                return str;
            }
        } catch (Exception e2) {
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String b(Context context) {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getMemoryInfo(memoryInfo);
        return Formatter.formatFileSize(context, memoryInfo.availMem) + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + memoryInfo.lowMemory + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + Formatter.formatFileSize(context, memoryInfo.threshold);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String c(Context context) {
        long j = 0;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
            j = Long.valueOf(bufferedReader.readLine().split("\\s+")[1]).longValue() * 1024;
            bufferedReader.close();
        } catch (IOException e) {
        }
        return Formatter.formatFileSize(context, j);
    }
}
