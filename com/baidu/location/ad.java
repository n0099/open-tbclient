package com.baidu.location;

import android.content.Context;
import android.os.Environment;
import android.os.Process;
import com.baidu.browser.core.util.BdUtil;
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
public class ad implements Thread.UncaughtExceptionHandler {
    final /* synthetic */ f a;
    private Context b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(f fVar, Context context) {
        this.a = fVar;
        this.b = context;
        a();
    }

    private String a(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        printWriter.close();
        return stringWriter.toString();
    }

    public void a() {
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
                        ap.a("baidu_location_service", "A" + readInt);
                        byte[] bArr = new byte[readInt];
                        randomAccessFile.read(bArr, 0, readInt);
                        str = new String(bArr, 0, readInt);
                    }
                    randomAccessFile.seek(600L);
                    int readInt2 = randomAccessFile.readInt();
                    if (readInt2 > 0 && readInt2 < 2048) {
                        ap.a("baidu_location_service", "A" + readInt2);
                        byte[] bArr2 = new byte[readInt2];
                        randomAccessFile.read(bArr2, 0, readInt2);
                        str2 = new String(bArr2, 0, readInt2);
                    }
                    ap.a("baidu_location_service", str + str2);
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

    public void a(File file, String str, String str2) {
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

    boolean a(String str, String str2) {
        if (ah.a(this.b)) {
            try {
                HttpPost httpPost = new HttpPost(ap.g);
                ArrayList arrayList = new ArrayList();
                arrayList.add(new BasicNameValuePair("e0", str));
                arrayList.add(new BasicNameValuePair("e1", str2));
                httpPost.setEntity(new UrlEncodedFormEntity(arrayList, BdUtil.UTF8));
                DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
                defaultHttpClient.getParams().setParameter("http.connection.timeout", 12000);
                defaultHttpClient.getParams().setParameter("http.socket.timeout", 12000);
                ap.a("baidu_location_service", "send begin ...");
                if (defaultHttpClient.execute(httpPost).getStatusLine().getStatusCode() == 200) {
                    ap.a("baidu_location_service", "send ok....");
                    return true;
                }
                return false;
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0077 A[Catch: Exception -> 0x00bc, TryCatch #1 {Exception -> 0x00bc, blocks: (B:10:0x003e, B:12:0x0077, B:14:0x0082, B:15:0x0085, B:17:0x008b, B:23:0x009b, B:25:0x00b8), top: B:35:0x003e }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x009b A[Catch: Exception -> 0x00bc, TRY_ENTER, TryCatch #1 {Exception -> 0x00bc, blocks: (B:10:0x003e, B:12:0x0077, B:14:0x0082, B:15:0x0085, B:17:0x008b, B:23:0x009b, B:25:0x00b8), top: B:35:0x003e }] */
    @Override // java.lang.Thread.UncaughtExceptionHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void uncaughtException(Thread thread, Throwable th) {
        String str;
        String str2;
        String str3;
        File file;
        k kVar;
        k kVar2;
        t unused;
        try {
            str2 = a(th);
            try {
                ap.a("baidu_location_service", str2);
                unused = this.a.h;
                String a = t.a(false);
                kVar = this.a.k;
                if (kVar != null) {
                    StringBuilder append = new StringBuilder().append(a);
                    kVar2 = this.a.k;
                    a = append.append(kVar2.b()).toString();
                }
                str3 = a != null ? Jni.a(a) : null;
            } catch (Exception e) {
                str = str2;
                str2 = str;
                str3 = null;
                String str4 = Environment.getExternalStorageDirectory().getPath() + "/traces";
                file = new File(str4 + "/error_fs.dat");
                if (file.exists()) {
                }
                Process.killProcess(Process.myPid());
            }
        } catch (Exception e2) {
            str = null;
        }
        try {
            String str42 = Environment.getExternalStorageDirectory().getPath() + "/traces";
            file = new File(str42 + "/error_fs.dat");
            if (file.exists()) {
                File file2 = new File(str42);
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                a(file.createNewFile() ? file : null, str3, str2);
            } else {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                randomAccessFile.seek(300L);
                if (System.currentTimeMillis() - randomAccessFile.readLong() > 604800000) {
                    a(file, str3, str2);
                }
            }
        } catch (Exception e3) {
        }
        Process.killProcess(Process.myPid());
    }
}
