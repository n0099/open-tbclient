package com.baidu.location.b;

import android.os.Environment;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.location.Jni;
import com.baidu.location.g.g;
import com.baidu.searchbox.ng.ai.apps.trace.ErrDef;
import com.baidu.webkit.internal.ETAG;
import java.io.File;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.io.StringWriter;
import java.lang.Thread;
import java.net.HttpURLConnection;
import java.net.URL;
/* loaded from: classes6.dex */
public class e implements Thread.UncaughtExceptionHandler {
    private static e aev = null;
    private int b = 0;

    private e() {
    }

    private String a(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        printWriter.close();
        return stringWriter.toString();
    }

    private void a(File file, String str, String str2) {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            randomAccessFile.seek(280L);
            randomAccessFile.writeInt(12346);
            randomAccessFile.seek(300L);
            randomAccessFile.writeLong(System.currentTimeMillis());
            byte[] bytes = str.getBytes();
            randomAccessFile.writeInt(bytes.length);
            randomAccessFile.write(bytes, 0, bytes.length);
            randomAccessFile.seek(600L);
            byte[] bytes2 = str2.getBytes();
            randomAccessFile.writeInt(bytes2.length);
            randomAccessFile.write(bytes2, 0, bytes2.length);
            if (!a(str, str2)) {
                randomAccessFile.seek(280L);
                randomAccessFile.writeInt(1326);
            }
            randomAccessFile.close();
        } catch (Exception e) {
        }
    }

    private boolean a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        if (com.baidu.location.e.f.j()) {
            try {
                URL url = new URL(g.e);
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("e0");
                stringBuffer.append(ETAG.EQUAL);
                stringBuffer.append(str);
                stringBuffer.append(ETAG.ITEM_SEPARATOR);
                stringBuffer.append("e1");
                stringBuffer.append(ETAG.EQUAL);
                stringBuffer.append(str2);
                stringBuffer.append(ETAG.ITEM_SEPARATOR);
                if (stringBuffer.length() > 0) {
                    stringBuffer.deleteCharAt(stringBuffer.length() - 1);
                }
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setConnectTimeout(com.baidu.location.g.a.b);
                httpURLConnection.setReadTimeout(com.baidu.location.g.a.b);
                httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
                httpURLConnection.setRequestProperty("Accept-Charset", "UTF-8");
                OutputStream outputStream = httpURLConnection.getOutputStream();
                outputStream.write(stringBuffer.toString().getBytes());
                outputStream.flush();
                outputStream.close();
                return httpURLConnection.getResponseCode() == 200;
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }

    public static e ty() {
        if (aev == null) {
            aev = new e();
        }
        return aev;
    }

    public void b() {
        String str;
        String str2 = null;
        try {
            File file = new File((Environment.getExternalStorageDirectory().getPath() + "/traces") + "/error_fs2.dat");
            if (file.exists()) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                randomAccessFile.seek(280L);
                if (1326 == randomAccessFile.readInt()) {
                    randomAccessFile.seek(308L);
                    int readInt = randomAccessFile.readInt();
                    if (readInt <= 0 || readInt >= 2048) {
                        str = null;
                    } else {
                        byte[] bArr = new byte[readInt];
                        randomAccessFile.read(bArr, 0, readInt);
                        str = new String(bArr, 0, readInt);
                    }
                    randomAccessFile.seek(600L);
                    int readInt2 = randomAccessFile.readInt();
                    if (readInt2 > 0 && readInt2 < 2048) {
                        byte[] bArr2 = new byte[readInt2];
                        randomAccessFile.read(bArr2, 0, readInt2);
                        str2 = new String(bArr2, 0, readInt2);
                    }
                    if (a(str, str2)) {
                        randomAccessFile.seek(280L);
                        randomAccessFile.writeInt(12346);
                    }
                }
                randomAccessFile.close();
            }
        } catch (Exception e) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00a5 A[Catch: Exception -> 0x0143, TRY_LEAVE, TryCatch #1 {Exception -> 0x0143, blocks: (B:17:0x0077, B:20:0x0081, B:22:0x00a5), top: B:52:0x0077 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00ae A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.lang.Thread.UncaughtExceptionHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void uncaughtException(Thread thread, Throwable th) {
        String str;
        String str2;
        String str3;
        boolean z;
        boolean z2;
        this.b++;
        if (this.b > 2) {
            Process.killProcess(Process.myPid());
            return;
        }
        if (System.currentTimeMillis() - com.baidu.location.f.a.a() < ErrDef.Feature.WEIGHT && 7.8f > com.baidu.location.f.getFrameVersion()) {
            if (System.currentTimeMillis() - com.baidu.location.g.c.tX().c() < 40000) {
                File file = new File(g.h() + File.separator + com.baidu.location.f.getJarFileName());
                if (file.exists()) {
                    file.delete();
                }
            } else {
                com.baidu.location.g.c.tX().b(System.currentTimeMillis());
            }
        }
        try {
            str2 = a(th);
        } catch (Exception e) {
            str = null;
        }
        if (str2 != null) {
            try {
            } catch (Exception e2) {
                str = str2;
                str2 = str;
                str3 = null;
                z = false;
                if (z) {
                }
                Process.killProcess(Process.myPid());
            }
            if (str2.contains("com.baidu.location")) {
                z2 = true;
                String str4 = com.baidu.location.g.b.tW().a(false) + com.baidu.location.a.a.tc().c();
                boolean z3 = z2;
                str3 = str4 == null ? Jni.encode(str4) : null;
                z = z3;
                if (z) {
                    try {
                        String str5 = Environment.getExternalStorageDirectory().getPath() + "/traces";
                        File file2 = new File(str5 + "/error_fs2.dat");
                        if (file2.exists()) {
                            RandomAccessFile randomAccessFile = new RandomAccessFile(file2, "rw");
                            randomAccessFile.seek(300L);
                            if (System.currentTimeMillis() - randomAccessFile.readLong() > 86400000) {
                                a(file2, str3, str2);
                            }
                            randomAccessFile.close();
                        } else {
                            File file3 = new File(str5);
                            if (!file3.exists()) {
                                file3.mkdirs();
                            }
                            a(file2.createNewFile() ? file2 : null, str3, str2);
                        }
                    } catch (Exception e3) {
                    }
                }
                Process.killProcess(Process.myPid());
            }
        }
        z2 = false;
        String str42 = com.baidu.location.g.b.tW().a(false) + com.baidu.location.a.a.tc().c();
        boolean z32 = z2;
        str3 = str42 == null ? Jni.encode(str42) : null;
        z = z32;
        if (z) {
        }
        Process.killProcess(Process.myPid());
    }
}
