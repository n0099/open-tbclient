package com.baidu.adp.lib.g;

import android.util.Log;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
/* loaded from: classes.dex */
public class e {
    private static String a = null;
    private static ArrayList<String> b = new ArrayList<>();

    public static boolean a() {
        return com.baidu.adp.a.b.a().b();
    }

    public static void a(String str, String str2, String str3) {
        String a2 = a(true, str, str2, str3);
        if (a2 != null) {
            Log.i("BaiduLog", a2);
        }
    }

    public static void b(String str, String str2, String str3) {
        String a2 = a(false, str, str2, str3);
        if (a2 != null) {
            f(a2);
            Log.e("BaiduLog", a2);
        }
    }

    public static void a(String str, String str2, Throwable th) {
        String a2 = a(false, str, str2, th.getMessage());
        if (a2 != null) {
            f(a2);
            Log.e("BaiduLog", a2);
        }
    }

    public static void c(String str, String str2, String str3) {
        String a2 = a(false, str, str2, str3);
        if (a2 != null) {
            Log.w("BaiduLog", a2);
        }
    }

    public static void d(String str, String str2, String str3) {
        String a2 = a(true, str, str2, str3);
        if (a2 != null) {
            Log.v("BaiduLog", a2);
        }
    }

    public static void e(String str, String str2, String str3) {
        String a2 = a(true, str, str2, str3);
        if (a2 != null) {
            Log.d("BaiduLog", a2);
        }
    }

    public static void a(Class<?> cls, String str, String str2) {
        e(cls.getName(), str, str2);
    }

    public static void a(Class<?> cls, String str, Throwable th) {
        b(cls.getName(), str, th.getMessage());
    }

    private static String a(boolean z, String str, String str2, String str3) {
        if (com.baidu.adp.a.b.a().b()) {
            if (a == null || str3.startsWith(a)) {
                if (!z || e(str)) {
                    StringBuffer stringBuffer = new StringBuffer(100);
                    stringBuffer.append(str);
                    stringBuffer.append(":");
                    stringBuffer.append(str2);
                    stringBuffer.append(":");
                    stringBuffer.append(str3);
                    return stringBuffer.toString();
                }
                return null;
            }
            return null;
        }
        return null;
    }

    public static int a(int i, String str) {
        if (com.baidu.adp.a.b.a().b()) {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            if (stackTrace.length < 5) {
                return -1;
            }
            StackTraceElement stackTraceElement = stackTrace[4];
            String methodName = stackTraceElement.getMethodName();
            String className = stackTraceElement.getClassName();
            if (i <= 1 || e(className)) {
                if (i == 0) {
                    b(className, methodName, str);
                } else if (i == 1) {
                    c(className, methodName, str);
                } else if (i == 2) {
                    a(className, methodName, str);
                } else if (i == 3) {
                    e(className, methodName, str);
                } else {
                    d(className, methodName, str);
                }
                return 0;
            }
            return -1;
        }
        return -1;
    }

    private static boolean e(String str) {
        boolean z = false;
        if (b.size() == 0) {
            return false;
        }
        Iterator<String> it = b.iterator();
        while (true) {
            boolean z2 = z;
            if (!it.hasNext()) {
                return z2;
            }
            z = str.startsWith(it.next()) ? true : z2;
        }
    }

    public static int a(String str) {
        return a(0, str);
    }

    public static int b(String str) {
        return a(1, str);
    }

    public static int c(String str) {
        return a(2, str);
    }

    public static int d(String str) {
        return a(3, str);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0097 A[Catch: Exception -> 0x009b, TRY_LEAVE, TryCatch #2 {Exception -> 0x009b, blocks: (B:27:0x0092, B:29:0x0097), top: B:44:0x0092 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0092 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void f(String str) {
        BufferedWriter bufferedWriter;
        FileWriter fileWriter;
        FileWriter fileWriter2 = null;
        long currentTimeMillis = System.currentTimeMillis();
        File d = b.d("log_" + f.a(new Date()));
        if (d != null) {
            try {
                fileWriter = new FileWriter(d, true);
                try {
                    bufferedWriter = new BufferedWriter(fileWriter);
                } catch (Exception e) {
                    e = e;
                    bufferedWriter = null;
                    fileWriter2 = fileWriter;
                } catch (Throwable th) {
                    th = th;
                    bufferedWriter = null;
                }
            } catch (Exception e2) {
                e = e2;
                bufferedWriter = null;
            } catch (Throwable th2) {
                th = th2;
                bufferedWriter = null;
                fileWriter = null;
            }
            try {
                bufferedWriter.write(f.a(currentTimeMillis) + "\t\t" + str);
                bufferedWriter.newLine();
                bufferedWriter.flush();
            } catch (Exception e3) {
                e = e3;
                fileWriter2 = fileWriter;
                try {
                    Log.d("BaiduLog", e.getMessage());
                    if (fileWriter2 != null) {
                        try {
                            fileWriter2.close();
                        } catch (Exception e4) {
                            Log.d("BaiduLog", e4.getMessage());
                            return;
                        }
                    }
                    if (bufferedWriter != null) {
                        bufferedWriter.close();
                        return;
                    }
                    return;
                } catch (Throwable th3) {
                    th = th3;
                    fileWriter = fileWriter2;
                    if (fileWriter != null) {
                        try {
                            fileWriter.close();
                        } catch (Exception e5) {
                            Log.d("BaiduLog", e5.getMessage());
                            throw th;
                        }
                    }
                    if (bufferedWriter != null) {
                        bufferedWriter.close();
                    }
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                if (fileWriter != null) {
                }
                if (bufferedWriter != null) {
                }
                throw th;
            }
        } else {
            bufferedWriter = null;
            fileWriter = null;
        }
        if (fileWriter != null) {
            try {
                fileWriter.close();
            } catch (Exception e6) {
                Log.d("BaiduLog", e6.getMessage());
                return;
            }
        }
        if (bufferedWriter != null) {
            bufferedWriter.close();
        }
    }
}
