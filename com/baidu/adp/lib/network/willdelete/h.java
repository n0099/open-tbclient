package com.baidu.adp.lib.network.willdelete;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class h {
    public static boolean dZ() {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) e.dY().getContext().getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                if (activeNetworkInfo.getType() == 0) {
                    return true;
                }
            }
        } catch (Exception e) {
        }
        return false;
    }

    public static int ea() {
        if (dZ()) {
            try {
                return F(((ConnectivityManager) e.dY().getContext().getSystemService("connectivity")).getActiveNetworkInfo().getSubtype());
            } catch (Exception e) {
                return 0;
            }
        }
        return 0;
    }

    public static boolean eb() {
        return 1 == ea();
    }

    public static int F(int i) {
        switch (i) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return 1;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case DealIntentService.CLASS_TYPE_GROUP_EVENT /* 14 */:
            case 15:
                return 2;
            case 13:
                return 3;
            default:
                return 0;
        }
    }

    public static boolean Y(String str) {
        return str != null && str.contains("vnd.wap.wml");
    }

    public static String Z(String str) {
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [297=4] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:32:0x0048 */
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
                        com.baidu.adp.lib.g.a.a(randomAccessFile);
                        exists = randomAccessFile;
                    } catch (FileNotFoundException e2) {
                        e = e2;
                        e.printStackTrace();
                        com.baidu.adp.lib.g.a.a(randomAccessFile);
                        exists = randomAccessFile;
                        return true;
                    } catch (IOException e3) {
                        e = e3;
                        closeable = randomAccessFile;
                        e.printStackTrace();
                        com.baidu.adp.lib.g.a.a(closeable);
                        return true;
                    }
                } catch (Throwable th) {
                    th = th;
                    closeable = exists;
                    com.baidu.adp.lib.g.a.a(closeable);
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

    public static byte[] c(ArrayList<byte[]> arrayList) {
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

    public static int ec() {
        return j.fi() ? 500000 : 200000;
    }
}
