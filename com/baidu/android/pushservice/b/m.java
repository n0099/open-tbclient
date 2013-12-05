package com.baidu.android.pushservice.b;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.baidu.android.common.net.ConnectManager;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
/* loaded from: classes.dex */
public class m {

    /* renamed from: a  reason: collision with root package name */
    public static double f705a = 0.5d;
    public static double b = 0.2d;
    public static double c = 0.2d;
    public static double d = 0.1d;

    public static n a() {
        String str;
        try {
            byte[] bArr = new byte[1024];
            new RandomAccessFile("/proc/cpuinfo", "r").read(bArr);
            str = new String(bArr);
            int indexOf = str.indexOf(0);
            if (indexOf != -1) {
                str = str.substring(0, indexOf);
            }
        } catch (IOException e) {
            str = "";
            e.printStackTrace();
        }
        n a2 = a(str);
        a2.e = e();
        return a2;
    }

    private static n a(String str) {
        String[] split;
        int indexOf;
        if (str == null || "".equals(str)) {
            return null;
        }
        n nVar = new n();
        nVar.f706a = 0;
        nVar.c = 0;
        nVar.b = 1;
        nVar.d = 0.0d;
        if (str.contains("ARMv5")) {
            nVar.f706a = 1;
        } else if (str.contains("ARMv6")) {
            nVar.f706a = 16;
        } else if (str.contains("ARMv7")) {
            nVar.f706a = 256;
        }
        if (str.contains("neon")) {
            nVar.c |= 256;
        }
        if (str.contains("vfpv3")) {
            nVar.c |= 16;
        }
        if (str.contains(" vfp")) {
            nVar.c |= 1;
        }
        for (String str2 : str.split("\n")) {
            if (str2.contains("CPU variant")) {
                int indexOf2 = str2.indexOf(": ");
                if (indexOf2 >= 0) {
                    try {
                        nVar.b = Integer.decode(str2.substring(indexOf2 + 2)).intValue();
                        nVar.b = nVar.b == 0 ? 1 : nVar.b;
                    } catch (NumberFormatException e) {
                        nVar.b = 1;
                    }
                }
            } else if (str2.contains("BogoMIPS") && (indexOf = str2.indexOf(": ")) >= 0) {
                str2.substring(indexOf + 2);
            }
        }
        return nVar;
    }

    public static String a(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder sb = new StringBuilder();
        while (true) {
            try {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        sb.append(readLine);
                    } else {
                        try {
                            break;
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            } finally {
                try {
                    inputStream.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
        }
        inputStream.close();
        return sb.toString();
    }

    public static int[] a(Context context) {
        int[] iArr = new int[3];
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager == null) {
            iArr[0] = 0;
            iArr[1] = 0;
            iArr[2] = 0;
            return iArr;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        int i = displayMetrics.widthPixels;
        int i2 = displayMetrics.heightPixels;
        if (i >= i2) {
            i2 = i;
            i = i2;
        }
        iArr[0] = i2;
        iArr[1] = i;
        iArr[2] = displayMetrics.densityDpi;
        return iArr;
    }

    public static long b() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
            String readLine = bufferedReader.readLine();
            long intValue = readLine != null ? Integer.valueOf(readLine.split("\\s+")[1]).intValue() / 1024 : 0L;
            bufferedReader.close();
            return intValue;
        } catch (IOException e) {
            return -1L;
        }
    }

    public static String b(Context context) {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            String str = null;
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement = inetAddresses.nextElement();
                    str = !nextElement.isLoopbackAddress() ? nextElement.getHostAddress().toString() : str;
                }
            }
            return str;
        } catch (SocketException e) {
            return null;
        }
    }

    public static String c() {
        n a2 = a();
        return (a2.f706a & 1) == 1 ? "armv5" : (a2.f706a & 16) == 16 ? "armv6" : (a2.f706a & 256) == 256 ? "armv7" : "unknown";
    }

    public static boolean c(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return false;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnectedOrConnecting()) {
            return false;
        }
        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
        return networkInfo != null && networkInfo.isConnectedOrConnecting();
    }

    public static String d() {
        n a2 = a();
        return (a2.c & 256) == 256 ? "neon" : (a2.c & 1) == 1 ? "vfp" : (a2.c & 16) == 16 ? "vfpv3" : "unknown";
    }

    public static String d(Context context) {
        String netType;
        return (ConnectManager.isNetworkConnected(context) && (netType = new ConnectManager(context).getNetType()) != null) ? netType : "connectionless";
    }

    /* JADX WARN: Removed duplicated region for block: B:68:0x006e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0069 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int e() {
        FileReader fileReader;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        bufferedReader2 = null;
        bufferedReader2 = null;
        bufferedReader2 = null;
        bufferedReader2 = null;
        FileReader fileReader2 = null;
        bufferedReader2 = null;
        bufferedReader2 = null;
        try {
            try {
                fileReader = new FileReader("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq");
                try {
                    bufferedReader = new BufferedReader(fileReader);
                } catch (FileNotFoundException e) {
                    e = e;
                    bufferedReader = null;
                    fileReader2 = fileReader;
                } catch (IOException e2) {
                    e = e2;
                }
            } catch (Throwable th) {
                th = th;
            }
        } catch (FileNotFoundException e3) {
            e = e3;
            bufferedReader = null;
        } catch (IOException e4) {
            e = e4;
            fileReader = null;
        } catch (Throwable th2) {
            th = th2;
            fileReader = null;
        }
        try {
            String readLine = bufferedReader.readLine();
            r0 = readLine != null ? Integer.parseInt(readLine.trim()) : 0;
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
            }
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e6) {
                    e6.printStackTrace();
                }
            }
        } catch (FileNotFoundException e7) {
            e = e7;
            fileReader2 = fileReader;
            try {
                e.printStackTrace();
                if (fileReader2 != null) {
                    try {
                        fileReader2.close();
                    } catch (IOException e8) {
                        e8.printStackTrace();
                    }
                }
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e9) {
                        e9.printStackTrace();
                    }
                }
                return r0;
            } catch (Throwable th3) {
                th = th3;
                fileReader = fileReader2;
                bufferedReader2 = bufferedReader;
                if (fileReader != null) {
                    try {
                        fileReader.close();
                    } catch (IOException e10) {
                        e10.printStackTrace();
                    }
                }
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException e11) {
                        e11.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (IOException e12) {
            e = e12;
            bufferedReader2 = bufferedReader;
            e.printStackTrace();
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e13) {
                    e13.printStackTrace();
                }
            }
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (IOException e14) {
                    e14.printStackTrace();
                }
            }
            return r0;
        } catch (Throwable th4) {
            th = th4;
            bufferedReader2 = bufferedReader;
            if (fileReader != null) {
            }
            if (bufferedReader2 != null) {
            }
            throw th;
        }
        return r0;
    }

    public static boolean e(Context context) {
        return ConnectManager.isNetworkConnected(context);
    }
}
