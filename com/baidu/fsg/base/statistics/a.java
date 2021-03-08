package com.baidu.fsg.base.statistics;

import android.app.ActivityManager;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.format.Formatter;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.minivideo.plugin.capture.utils.EncryptUtils;
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
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f1526a = "utf-8";
    private static final String b = "c82c403505338808201aad86f8194734";

    a() {
    }

    public static void a(Context context, String str, String str2, boolean z) {
        if (context != null) {
            FileOutputStream fileOutputStream = null;
            try {
                fileOutputStream = context.openFileOutput(str, z ? 32768 : 0);
                if (fileOutputStream != null) {
                    fileOutputStream.write(str2.getBytes(f1526a));
                }
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Exception e) {
                    }
                }
            } catch (Exception e2) {
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Exception e3) {
                    }
                }
            } catch (Throwable th) {
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Exception e4) {
                    }
                }
                throw th;
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
            return new String(b2, f1526a);
        } catch (Exception e) {
            return "";
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [86=4, 87=4] */
    static byte[] b(Context context, String str) {
        FileInputStream fileInputStream;
        byte[] bArr;
        byte[] bArr2;
        try {
            fileInputStream = context.openFileInput(str);
            if (fileInputStream != null) {
                try {
                    try {
                        bArr2 = new byte[fileInputStream.available()];
                    } catch (Throwable th) {
                        th = th;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e) {
                            }
                        }
                        throw th;
                    }
                } catch (FileNotFoundException e2) {
                    bArr = null;
                } catch (IOException e3) {
                    bArr = null;
                }
                try {
                    fileInputStream.read(bArr2);
                    bArr = bArr2;
                } catch (FileNotFoundException e4) {
                    bArr = bArr2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e5) {
                        }
                    }
                    return bArr;
                } catch (IOException e6) {
                    bArr = bArr2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e7) {
                        }
                    }
                    return bArr;
                }
            } else {
                bArr = null;
            }
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e8) {
                }
            }
        } catch (FileNotFoundException e9) {
            fileInputStream = null;
            bArr = null;
        } catch (IOException e10) {
            fileInputStream = null;
            bArr = null;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
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
            MessageDigest messageDigest = MessageDigest.getInstance(EncryptUtils.ENCRYPT_MD5);
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
