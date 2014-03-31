package com.baidu.adp.lib.network.willdelete;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public final class h {
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

    public static int b() {
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [233=4] */
    public static boolean a(String str, long j, byte[] bArr, int i, int i2) {
        RandomAccessFile randomAccessFile;
        if (str == null || bArr == null || bArr.length <= 0) {
            return false;
        }
        RandomAccessFile randomAccessFile2 = null;
        try {
            try {
                try {
                    randomAccessFile = new RandomAccessFile(str, "rw");
                    try {
                        randomAccessFile.seek(j);
                        randomAccessFile.write(bArr, i, i2);
                        com.baidu.adp.lib.f.a.a(randomAccessFile);
                    } catch (FileNotFoundException e) {
                        e = e;
                        e.printStackTrace();
                        com.baidu.adp.lib.f.a.a(randomAccessFile);
                        return true;
                    } catch (IOException e2) {
                        e = e2;
                        randomAccessFile2 = randomAccessFile;
                        e.printStackTrace();
                        com.baidu.adp.lib.f.a.a(randomAccessFile2);
                        return true;
                    }
                } catch (Throwable th) {
                    th = th;
                    randomAccessFile2 = randomAccessFile;
                    com.baidu.adp.lib.f.a.a(randomAccessFile2);
                    throw th;
                }
            } catch (FileNotFoundException e3) {
                e = e3;
                randomAccessFile = null;
            } catch (IOException e4) {
                e = e4;
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
}
