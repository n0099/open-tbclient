package com.baidu.browser.sailor.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.StatFs;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.baidu.searchbox.ng.ai.apps.util.AiAppEncryptUtils;
import com.baidu.webkit.sdk.Log;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;
/* loaded from: classes2.dex */
public final class c {
    private static SimpleDateFormat WU = null;
    private static final String a;
    private static final Pattern b;
    private static Handler c;

    static {
        String str = "(((?<=[\\.])|^)((([a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef][a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef\\-]*)*[a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef]\\.)(" + f.a + "\\.)*" + f.a + ")|^" + f.f + ")$";
        a = str;
        b = Pattern.compile(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0044 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(String str) {
        DataInputStream dataInputStream;
        DataInputStream dataInputStream2 = null;
        try {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(AiAppEncryptUtils.ENCRYPT_MD5);
                dataInputStream = new DataInputStream(new FileInputStream(str));
                try {
                    byte[] bArr = new byte[131072];
                    while (true) {
                        int read = dataInputStream.read(bArr);
                        if (read == -1) {
                            String a2 = a(messageDigest.digest(), "");
                            try {
                                dataInputStream.close();
                                return a2;
                            } catch (Exception e) {
                                return a2;
                            }
                        }
                        messageDigest.update(bArr, 0, read);
                    }
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    if (dataInputStream != null) {
                        try {
                            dataInputStream.close();
                        } catch (Exception e3) {
                        }
                    }
                    return "";
                }
            } catch (Throwable th) {
                th = th;
                if (0 != 0) {
                    try {
                        dataInputStream2.close();
                    } catch (Exception e4) {
                    }
                }
                throw th;
            }
        } catch (Exception e5) {
            e = e5;
            dataInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            if (0 != 0) {
            }
            throw th;
        }
    }

    public static String a(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            if (str2.startsWith("/")) {
                str2 = str2.substring(1);
            }
            str = str + str2;
            File parentFile = new File(str).getParentFile();
            if (parentFile != null && !parentFile.exists()) {
                parentFile.mkdirs();
            }
        }
        return str;
    }

    private static String a(byte[] bArr, String str) {
        StringBuilder sb = new StringBuilder();
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & 255);
            if (hexString.length() == 1) {
                sb.append("0");
            }
            sb.append(hexString).append(str);
        }
        return sb.toString();
    }

    public static void a(Runnable runnable) {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            ra().post(runnable);
        } else {
            runnable.run();
        }
    }

    public static void a(Runnable runnable, long j) {
        ra().postDelayed(runnable, j);
    }

    public static boolean a() {
        boolean z = false;
        long currentTimeMillis = System.currentTimeMillis();
        if (TextUtils.equals("mounted", Environment.getExternalStorageState())) {
            File externalStorageDirectory = Environment.getExternalStorageDirectory();
            if (externalStorageDirectory.exists() && externalStorageDirectory.canWrite()) {
                File file = new File(externalStorageDirectory, ".696E5309-E4A7-27C0-A787-0B2CEBF1F1AB");
                if (file.exists()) {
                    z = true;
                } else {
                    try {
                        z = file.createNewFile();
                    } catch (IOException e) {
                        Log.w("CommonUtils", "isExternalStorageWriteable() can't create test file.");
                    }
                }
            }
        }
        Log.i("CommonUtils", "Utility.isExternalStorageWriteable(" + z + ") cost " + (System.currentTimeMillis() - currentTimeMillis) + "ms.");
        return z;
    }

    public static boolean a(Context context) {
        NetworkInfo activeNetworkInfo;
        if (context == null) {
            return false;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null) {
            int type = activeNetworkInfo.getType();
            if (activeNetworkInfo.isAvailable()) {
                return 1 == type;
            }
        }
        return false;
    }

    public static boolean a(View view) {
        ViewParent parent;
        if (view != null && (parent = view.getParent()) != null && view.getVisibility() == 0) {
            ViewGroup viewGroup = (ViewGroup) parent;
            int indexOfChild = viewGroup.indexOfChild(view);
            int childCount = viewGroup.getChildCount();
            if (indexOfChild == childCount - 1) {
                return true;
            }
            for (int i = indexOfChild + 1; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt.getVisibility() == 0 && childAt.getHeight() > 0 && childAt.getWidth() > 0 && view.getHeight() > 0 && view.getWidth() > 0 && childAt.getWidth() >= view.getWidth() && childAt.getHeight() >= view.getHeight()) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public static boolean a(File file) {
        if (!file.exists()) {
            try {
                file.mkdirs();
            } catch (SecurityException e) {
                return false;
            }
        }
        return true;
    }

    public static boolean a(String str, File file) {
        return file.getAbsolutePath().startsWith(str);
    }

    public static String b(String str) {
        try {
            return URLEncoder.encode(new String(b.a(str.getBytes())), "UTF-8");
        } catch (Exception e) {
            Log.printStackTrace(e);
            return "";
        }
    }

    public static boolean b() {
        if (Environment.getExternalStorageDirectory() != null && "mounted".equals(Environment.getExternalStorageState())) {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            long blockSize = statFs.getBlockSize();
            long availableBlocks = statFs.getAvailableBlocks();
            Log.d("CommonUtils", "Available size:" + (blockSize * availableBlocks));
            if (availableBlocks * blockSize > 10485760) {
                return true;
            }
        }
        return false;
    }

    private static Handler ra() {
        synchronized (c.class) {
            if (c == null) {
                c = new Handler(Looper.getMainLooper());
            }
        }
        return c;
    }
}
