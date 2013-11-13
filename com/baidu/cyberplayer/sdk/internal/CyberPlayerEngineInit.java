package com.baidu.cyberplayer.sdk.internal;

import android.content.Context;
import android.os.Looper;
import com.baidu.cyberplayer.sdk.BCyberPlayerFactory;
import com.baidu.cyberplayer.sdk.internal.ReflectUtilsCyberPlayer;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
/* loaded from: classes.dex */
public class CyberPlayerEngineInit {

    /* renamed from: a  reason: collision with root package name */
    private static int f884a = 0;

    /* renamed from: a  reason: collision with other field name */
    private static ICyberPlayerEngineInitBridge f2a = null;

    /* renamed from: a  reason: collision with other field name */
    private static boolean f3a = false;

    public static synchronized boolean initCyberPlayer(Context context) {
        boolean z = true;
        synchronized (CyberPlayerEngineInit.class) {
            if (!f3a && (z = a(context, ReflectUtilsCyberPlayer.a.LOAD_FROM_APK))) {
            }
            if (z) {
                if (f3a && f884a == 0) {
                    a(context);
                } else {
                    f3a = true;
                }
                f884a++;
            }
        }
        return z;
    }

    private static boolean a(Context context, ReflectUtilsCyberPlayer.a aVar) {
        BCyberPlayerFactory.resetProxyFactory();
        ReflectUtilsCyberPlayer.a(context, aVar);
        try {
            m1a();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (f2a == null) {
            return false;
        }
        return a().init(context);
    }

    public static void setAKSK(String str, String str2) {
        a().setAKSK(str, str2);
    }

    static ICyberPlayerEngineInitBridge a() {
        if (f2a == null) {
            m1a();
        }
        return f2a;
    }

    /* renamed from: a  reason: collision with other method in class */
    static void m1a() {
        try {
            f2a = BCyberPlayerFactory.getProxyFactory().createCyberPlayerEngineInitProxy();
        } catch (Exception e) {
        }
    }

    public static synchronized void destroyCyberPlayerEngine(Context context) {
        synchronized (CyberPlayerEngineInit.class) {
            f884a--;
            if (f884a == 0) {
                b(context);
                if (Looper.myLooper() == Looper.getMainLooper()) {
                }
            } else if (f884a < 0) {
                f884a = 0;
            }
        }
    }

    private static void a(Context context) {
    }

    private static void b(Context context) {
    }

    public static boolean checkCpuInfo(String str) {
        return a("/proc/cpuinfo", str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [180=4, 182=4] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0042 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean a(String str, String str2) {
        BufferedReader bufferedReader;
        boolean z = false;
        File file = new File(str);
        ?? exists = file.exists();
        if (exists != 0) {
            BufferedReader bufferedReader2 = null;
            try {
                try {
                    bufferedReader = new BufferedReader(new FileReader(file));
                    while (true) {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine != null) {
                                if (readLine.contains(str2)) {
                                    z = true;
                                    break;
                                }
                            } else {
                                break;
                            }
                        } catch (IOException e) {
                            e = e;
                            e.printStackTrace();
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (IOException e2) {
                                    e2.printStackTrace();
                                }
                            }
                            return z;
                        }
                    }
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    bufferedReader2 = exists;
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (IOException e5) {
                e = e5;
                bufferedReader = null;
            } catch (Throwable th2) {
                th = th2;
                if (bufferedReader2 != null) {
                }
                throw th;
            }
        }
        return z;
    }
}
