package com.baidu.adp.lib.network;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.telephony.TelephonyManager;
import com.baidu.browser.core.util.BdUtil;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class g {
    public static boolean a(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static boolean a() {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) d.a().b().getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                if (activeNetworkInfo.getType() == 1) {
                    return true;
                }
            }
        } catch (Exception e) {
        }
        return false;
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
            return BdUtil.UTF8;
        }
        for (String str2 : str.split(";")) {
            if (str2.contains("charset")) {
                String[] split2 = str2.split("=");
                if (split2.length <= 1) {
                    return BdUtil.UTF8;
                }
                return split2[1].trim();
            }
        }
        return BdUtil.UTF8;
    }

    public static boolean b() {
        return (a() || c() == 1 || a(Proxy.getDefaultHost())) ? false : true;
    }

    public static int c() {
        int i;
        String networkOperator = ((TelephonyManager) d.a().b().getSystemService("phone")).getNetworkOperator();
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

    public static boolean a(String str, byte[] bArr, long j) {
        if (str == null || bArr == null || bArr.length <= 0) {
            return false;
        }
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(str, "rw");
            randomAccessFile.seek(j);
            randomAccessFile.write(bArr);
            randomAccessFile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        return true;
    }

    public static byte[] a(ArrayList arrayList) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                byteArrayOutputStream.write((byte[]) it.next());
            }
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static int d() {
        return a() ? 500000 : 200000;
    }
}
