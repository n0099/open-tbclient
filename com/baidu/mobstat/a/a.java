package com.baidu.mobstat.a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;
import android.util.Log;
import com.baidu.loginshare.e;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
/* loaded from: classes.dex */
public final class a {
    private static final Proxy a = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(e.h, 80));
    private static final Proxy b = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("10.0.0.200", 80));

    public static String a(Context context, String str) {
        b.a("AdUtil.read", str);
        try {
            byte[] b2 = b(context, str);
            if (b2 != null) {
                return new String(b2, "utf-8");
            }
        } catch (Exception e) {
            Log.w("Mobads SDK", "AdUtil.read", e);
        }
        return "";
    }

    public static String a(boolean z, Context context, String str) {
        return z ? b(str) : a(context, str);
    }

    public static HttpURLConnection a(Context context, String str, int i, int i2) {
        HttpURLConnection httpURLConnection;
        URL url = new URL(str);
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(0);
        NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(1);
        if (networkInfo2 != null && networkInfo2.isAvailable()) {
            b.a("", "WIFI is available");
            httpURLConnection = (HttpURLConnection) url.openConnection();
        } else if (networkInfo == null || !networkInfo.isAvailable()) {
            b.a("", "getConnection:not wifi and mobile");
            httpURLConnection = (HttpURLConnection) url.openConnection();
        } else {
            String extraInfo = networkInfo.getExtraInfo();
            String lowerCase = extraInfo != null ? extraInfo.toLowerCase() : "";
            b.a("current APN", lowerCase);
            httpURLConnection = (lowerCase.startsWith("cmwap") || lowerCase.startsWith("uniwap") || lowerCase.startsWith("3gwap")) ? (HttpURLConnection) url.openConnection(a) : lowerCase.startsWith("ctwap") ? (HttpURLConnection) url.openConnection(b) : (HttpURLConnection) url.openConnection();
        }
        httpURLConnection.setConnectTimeout(i);
        httpURLConnection.setReadTimeout(i2);
        return httpURLConnection;
    }

    public static void a(Context context, String str, String str2, boolean z) {
        FileOutputStream fileOutputStream = null;
        try {
            try {
                FileOutputStream openFileOutput = context.openFileOutput(str, z ? 32768 : 0);
                if (openFileOutput != null) {
                    openFileOutput.write(str2.getBytes("utf-8"));
                } else {
                    Log.w("Mobads SDK", "AdUtil.write fout is null:" + (openFileOutput == null));
                }
                if (openFileOutput != null) {
                    try {
                        openFileOutput.close();
                    } catch (Exception e) {
                        Log.w("Mobads SDK", "AdUtil.write", e);
                    }
                }
            } catch (Exception e2) {
                Log.w("Mobads SDK", "AdUtil.write", e2);
                if (0 != 0) {
                    try {
                        fileOutputStream.close();
                    } catch (Exception e3) {
                        Log.w("Mobads SDK", "AdUtil.write", e3);
                    }
                }
            }
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    fileOutputStream.close();
                } catch (Exception e4) {
                    Log.w("Mobads SDK", "AdUtil.write", e4);
                }
            }
            throw th;
        }
    }

    public static void a(String str, String str2, boolean z) {
        FileOutputStream fileOutputStream;
        if ("mounted".equals(Environment.getExternalStorageState())) {
            FileOutputStream fileOutputStream2 = null;
            try {
                try {
                    File file = new File(Environment.getExternalStorageDirectory() + File.separator + str);
                    if (!file.exists()) {
                        file.getParentFile().mkdirs();
                        file.createNewFile();
                    }
                    fileOutputStream = new FileOutputStream(file, z);
                } catch (Throwable th) {
                    th = th;
                }
            } catch (FileNotFoundException e) {
                e = e;
            } catch (IOException e2) {
                e = e2;
            }
            try {
                fileOutputStream.write(str2.getBytes("utf-8"));
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e3) {
                        Log.w("Mobads SDK", "AdUtil.writeExt", e3);
                    }
                }
            } catch (FileNotFoundException e4) {
                e = e4;
                fileOutputStream2 = fileOutputStream;
                Log.e("Mobads SDK", "AdUtil.writeExt", e);
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e5) {
                        Log.w("Mobads SDK", "AdUtil.writeExt", e5);
                    }
                }
            } catch (IOException e6) {
                e = e6;
                fileOutputStream2 = fileOutputStream;
                Log.e("Mobads SDK", "AdUtil.writeExt", e);
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e7) {
                        Log.w("Mobads SDK", "AdUtil.writeExt", e7);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e8) {
                        Log.w("Mobads SDK", "AdUtil.writeExt", e8);
                    }
                }
                throw th;
            }
        }
    }

    public static void a(boolean z, Context context, String str, String str2, boolean z2) {
        if (z) {
            a(str, str2, z2);
        } else {
            a(context, str, str2, z2);
        }
    }

    public static boolean a(String str) {
        b.a("AdUtil.deleteExt", str);
        if ("mounted".equals(Environment.getExternalStorageState())) {
            File file = new File(Environment.getExternalStorageDirectory() + File.separator + str);
            if (file.exists()) {
                return file.delete();
            }
            return false;
        }
        return false;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:41:0x00af */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:43:0x00b1 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:45:0x00b3 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00a2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v12, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v9, types: [java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String b(String str) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        String str2;
        b.a("AdUtil.readExt", str);
        String externalStorageState = Environment.getExternalStorageState();
        if ("mounted".equals(externalStorageState) || "mounted_ro".equals(externalStorageState)) {
            File file = new File(Environment.getExternalStorageDirectory() + File.separator + str);
            if (file.exists()) {
                try {
                    try {
                        fileInputStream2 = new FileInputStream(file);
                        try {
                            byte[] bArr = new byte[fileInputStream2.available()];
                            fileInputStream2.read(bArr);
                            str2 = new String(bArr, "utf-8");
                            fileInputStream = fileInputStream2;
                            if (fileInputStream2 != null) {
                                try {
                                    fileInputStream2.close();
                                    fileInputStream = fileInputStream2;
                                } catch (IOException e) {
                                    Log.w("Mobads SDK", "AdUtil.readExt", e);
                                    fileInputStream = "Mobads SDK";
                                }
                            }
                        } catch (FileNotFoundException e2) {
                            e = e2;
                            Log.e("Mobads SDK", "AdUtil.readExt", e);
                            if (fileInputStream2 != null) {
                                try {
                                    fileInputStream2.close();
                                } catch (IOException e3) {
                                    Log.w("Mobads SDK", "AdUtil.readExt", e3);
                                    str2 = "";
                                    fileInputStream = "Mobads SDK";
                                }
                            }
                            str2 = "";
                            fileInputStream = fileInputStream2;
                            return str2;
                        } catch (IOException e4) {
                            e = e4;
                            Log.e("Mobads SDK", "AdUtil.readExt", e);
                            if (fileInputStream2 != null) {
                                try {
                                    fileInputStream2.close();
                                } catch (IOException e5) {
                                    Log.w("Mobads SDK", "AdUtil.readExt", e5);
                                    str2 = "";
                                    fileInputStream = "Mobads SDK";
                                }
                            }
                            str2 = "";
                            fileInputStream = fileInputStream2;
                            return str2;
                        }
                    } catch (Throwable th) {
                        th = th;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e6) {
                                Log.w("Mobads SDK", "AdUtil.readExt", e6);
                            }
                        }
                        throw th;
                    }
                } catch (FileNotFoundException e7) {
                    e = e7;
                    fileInputStream2 = null;
                } catch (IOException e8) {
                    e = e8;
                    fileInputStream2 = null;
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = null;
                    if (fileInputStream != null) {
                    }
                    throw th;
                }
                return str2;
            }
            return "";
        }
        return "";
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:54:0x0001 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:8:0x0011 */
    /* JADX DEBUG: Multi-variable search result rejected for r2v8, resolved type: java.io.FileInputStream */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.lang.String] */
    static byte[] b(Context context, String str) {
        IOException iOException;
        byte[] bArr;
        FileNotFoundException fileNotFoundException;
        byte[] bArr2;
        FileInputStream fileInputStream = null;
        fileInputStream = 0;
        fileInputStream = 0;
        fileInputStream = 0;
        try {
            try {
                FileInputStream openFileInput = context.openFileInput(str);
                if (openFileInput != null) {
                    try {
                        try {
                            bArr2 = new byte[openFileInput.available()];
                        } catch (Throwable th) {
                            th = th;
                            fileInputStream = openFileInput;
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e) {
                                    Log.e("Mobads SDK", "AdUtil.readBinary", e);
                                }
                            }
                            throw th;
                        }
                    } catch (FileNotFoundException e2) {
                        bArr = null;
                        fileInputStream = openFileInput;
                        fileNotFoundException = e2;
                    } catch (IOException e3) {
                        bArr = null;
                        fileInputStream = openFileInput;
                        iOException = e3;
                    }
                    try {
                        openFileInput.read(bArr2);
                        bArr = bArr2;
                        fileInputStream = bArr2;
                    } catch (FileNotFoundException e4) {
                        bArr = bArr2;
                        fileInputStream = openFileInput;
                        fileNotFoundException = e4;
                        Log.e("Mobads SDK", "AdUtil.readBinary", fileNotFoundException);
                        if (fileInputStream != 0) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e5) {
                                fileInputStream = "Mobads SDK";
                                Log.e("Mobads SDK", "AdUtil.readBinary", e5);
                            }
                        }
                        return bArr;
                    } catch (IOException e6) {
                        bArr = bArr2;
                        fileInputStream = openFileInput;
                        iOException = e6;
                        Log.e("Mobads SDK", "AdUtil.readBinary", iOException);
                        if (fileInputStream != 0) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e7) {
                                fileInputStream = "Mobads SDK";
                                Log.e("Mobads SDK", "AdUtil.readBinary", e7);
                            }
                        }
                        return bArr;
                    }
                } else {
                    bArr = null;
                }
                if (openFileInput != null) {
                    try {
                        openFileInput.close();
                    } catch (IOException e8) {
                        fileInputStream = "Mobads SDK";
                        Log.e("Mobads SDK", "AdUtil.readBinary", e8);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (FileNotFoundException e9) {
            fileNotFoundException = e9;
            bArr = null;
        } catch (IOException e10) {
            iOException = e10;
            bArr = null;
        }
        return bArr;
    }

    public static void c(String str) {
        b.b("BaiduMobAds SDK", str);
        throw new SecurityException(str);
    }

    public static boolean c(Context context, String str) {
        boolean exists = context.getFileStreamPath(str).exists();
        b.a("AdUtil.exists", exists + " " + str);
        return exists;
    }

    public static void d(Context context, String str) {
        if (e(context, str)) {
            return;
        }
        c("You need the " + str + " permission. Open AndroidManifest.xml and just before the final </manifest> tag add:  <uses-permission android:name=\"" + str + "\" />");
    }

    public static boolean e(Context context, String str) {
        boolean z = context.checkCallingOrSelfPermission(str) != -1;
        b.a("hasPermission ", z + " | " + str);
        return z;
    }
}
