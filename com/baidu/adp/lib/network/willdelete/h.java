package com.baidu.adp.lib.network.willdelete;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.telephony.TelephonyManager;
import com.baidu.adp.lib.util.BdLog;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class h {
    public static boolean a(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static boolean a() {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) e.a().b().getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                if (activeNetworkInfo.getType() == 1) {
                    return true;
                }
            }
        } catch (Exception e) {
        }
        return false;
    }

    public static boolean b() {
        try {
            NetworkInfo[] allNetworkInfo = ((ConnectivityManager) e.a().b().getSystemService("connectivity")).getAllNetworkInfo();
            if (allNetworkInfo != null) {
                boolean z = false;
                for (int i = 0; i < allNetworkInfo.length; i++) {
                    if (allNetworkInfo[i].isConnected() && allNetworkInfo[i].isAvailable()) {
                        z = true;
                    }
                }
                return z;
            }
            return false;
        } catch (Exception e) {
            BdLog.e(e);
            return true;
        }
    }

    public static boolean b(String str) {
        if (Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.(172|200)$", 8).matcher(str).find()) {
            return true;
        }
        return false;
    }

    public static boolean c(String str) {
        return str != null && str.contains("vnd.wap.wml");
    }

    public static String d(String str) {
        String[] split;
        if (str == null) {
            return "utf-8";
        }
        for (String str2 : str.split(";")) {
            if (str2.contains("charset")) {
                String[] split2 = str2.split("=");
                if (split2.length <= 1) {
                    return "utf-8";
                }
                return split2[1].trim();
            }
        }
        return "utf-8";
    }

    public static boolean c() {
        return (a() || d() == 1 || a(Proxy.getDefaultHost())) ? false : true;
    }

    public static int d() {
        int i;
        String networkOperator = ((TelephonyManager) e.a().b().getSystemService("phone")).getNetworkOperator();
        if (a(networkOperator)) {
            return 0;
        }
        String substring = networkOperator.substring(0, 3);
        if (substring == null || !substring.equals("460")) {
            return 0;
        }
        try {
            i = Integer.parseInt(networkOperator.substring(3));
        } catch (NumberFormatException e) {
            i = 0;
        }
        switch (i) {
            case 0:
            case 2:
            case 7:
                return 1;
            case 1:
            case 6:
                return 2;
            case 3:
            case 5:
                return 3;
            case 4:
            default:
                return 0;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [245=4] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:32:0x0049 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:35:0x0018 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    public static boolean a(String str, long j, byte[] bArr, int i, int i2) {
        RandomAccessFile randomAccessFile;
        if (str == null || bArr == null || bArr.length <= 0) {
            return false;
        }
        File file = new File(str);
        ?? exists = file.exists();
        if (exists == 0) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                return false;
            }
        }
        Closeable closeable = null;
        try {
            try {
                try {
                    randomAccessFile = new RandomAccessFile(file, "rw");
                    try {
                        randomAccessFile.seek(j);
                        randomAccessFile.write(bArr, i, i2);
                        com.baidu.adp.lib.e.a.a(randomAccessFile);
                        exists = randomAccessFile;
                    } catch (FileNotFoundException e2) {
                        e = e2;
                        e.printStackTrace();
                        com.baidu.adp.lib.e.a.a(randomAccessFile);
                        exists = randomAccessFile;
                        return true;
                    } catch (IOException e3) {
                        e = e3;
                        closeable = randomAccessFile;
                        e.printStackTrace();
                        com.baidu.adp.lib.e.a.a(closeable);
                        return true;
                    }
                } catch (Throwable th) {
                    th = th;
                    closeable = exists;
                    com.baidu.adp.lib.e.a.a(closeable);
                    throw th;
                }
            } catch (FileNotFoundException e4) {
                e = e4;
                randomAccessFile = null;
            } catch (IOException e5) {
                e = e5;
            }
            return true;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static byte[] a(ArrayList<byte[]> arrayList) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            Iterator<byte[]> it = arrayList.iterator();
            while (it.hasNext()) {
                byteArrayOutputStream.write(it.next());
            }
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static int e() {
        return a() ? 500000 : 200000;
    }
}
