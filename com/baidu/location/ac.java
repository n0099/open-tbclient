package com.baidu.location;

import android.os.Environment;
import android.os.Process;
import com.baidu.tbadk.TbConfig;
import java.io.File;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.io.StringWriter;
import java.lang.Thread;
import java.util.ArrayList;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class ac implements a0, n, Thread.UncaughtExceptionHandler {
    private static ac gN = null;

    private ac() {
    }

    public static ac bo() {
        if (gN == null) {
            gN = new ac();
        }
        return gN;
    }

    /* renamed from: if  reason: not valid java name */
    private String m129if(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        printWriter.close();
        return stringWriter.toString();
    }

    public void bp() {
        String str;
        String str2 = null;
        try {
            File file = new File((Environment.getExternalStorageDirectory().getPath() + "/traces") + "/error_fs.dat");
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
                    if (m131new(str, str2)) {
                        randomAccessFile.seek(280L);
                        randomAccessFile.writeInt(12346);
                    }
                }
                randomAccessFile.close();
            }
        } catch (Exception e) {
        }
    }

    /* renamed from: if  reason: not valid java name */
    public void m130if(File file, String str, String str2) {
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
            if (!m131new(str, str2)) {
                randomAccessFile.seek(280L);
                randomAccessFile.writeInt(1326);
            }
            randomAccessFile.close();
        } catch (Exception e) {
        }
    }

    /* renamed from: new  reason: not valid java name */
    boolean m131new(String str, String str2) {
        if (au.ca()) {
            try {
                HttpPost httpPost = new HttpPost(c.aU);
                ArrayList arrayList = new ArrayList();
                arrayList.add(new BasicNameValuePair("e0", str));
                arrayList.add(new BasicNameValuePair("e1", str2));
                httpPost.setEntity(new UrlEncodedFormEntity(arrayList, "utf-8"));
                DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
                defaultHttpClient.getParams().setParameter("http.connection.timeout", Integer.valueOf((int) a0.F));
                defaultHttpClient.getParams().setParameter("http.socket.timeout", Integer.valueOf((int) a0.F));
                return defaultHttpClient.execute(httpPost).getStatusLine().getStatusCode() == 200;
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00db A[Catch: Exception -> 0x0124, TryCatch #2 {Exception -> 0x0124, blocks: (B:21:0x00a2, B:23:0x00db, B:25:0x00e6, B:26:0x00e9, B:28:0x00ef, B:33:0x0100, B:35:0x011d, B:36:0x0120), top: B:48:0x00a2 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0100 A[Catch: Exception -> 0x0124, TRY_ENTER, TryCatch #2 {Exception -> 0x0124, blocks: (B:21:0x00a2, B:23:0x00db, B:25:0x00e6, B:26:0x00e9, B:28:0x00ef, B:33:0x0100, B:35:0x011d, B:36:0x0120), top: B:48:0x00a2 }] */
    @Override // java.lang.Thread.UncaughtExceptionHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void uncaughtException(Thread thread, Throwable th) {
        String str;
        String str2;
        String str3;
        File file;
        if (System.currentTimeMillis() - ad.bq() < 10000 && 5.01f > f.getFrameVersion()) {
            if (System.currentTimeMillis() - e.m284if().a() < 40000) {
                File file2 = new File(c.m276long() + File.separator + f.getJarFileName());
                if (file2.exists()) {
                    file2.delete();
                }
            } else {
                e.m284if().m288if(System.currentTimeMillis());
            }
        }
        if (!aa.gi) {
            Process.killProcess(Process.myPid());
            return;
        }
        try {
            str2 = m129if(th);
        } catch (Exception e) {
            str = null;
        }
        try {
            String str4 = a2.cC().m78char(false) + k.q().p();
            str3 = str4 != null ? Jni.j(str4) : null;
        } catch (Exception e2) {
            str = str2;
            str2 = str;
            str3 = null;
            String str5 = Environment.getExternalStorageDirectory().getPath() + "/traces";
            file = new File(str5 + "/error_fs.dat");
            if (file.exists()) {
            }
            Process.killProcess(Process.myPid());
        }
        try {
            String str52 = Environment.getExternalStorageDirectory().getPath() + "/traces";
            file = new File(str52 + "/error_fs.dat");
            if (file.exists()) {
                File file3 = new File(str52);
                if (!file3.exists()) {
                    file3.mkdirs();
                }
                m130if(file.createNewFile() ? file : null, str3, str2);
            } else {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                randomAccessFile.seek(300L);
                if (System.currentTimeMillis() - randomAccessFile.readLong() > TbConfig.APP_OVERDUR_DRAFT_BOX) {
                    m130if(file, str3, str2);
                }
                randomAccessFile.close();
            }
        } catch (Exception e3) {
        }
        Process.killProcess(Process.myPid());
    }
}
