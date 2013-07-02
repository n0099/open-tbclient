package com.baidu.mapapi;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import com.baidu.zeus.Headers;
import com.baidu.zeus.NotificationProxy;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
/* loaded from: classes.dex */
public class s {
    static s b;
    static boolean c = false;
    private String e;
    ArrayList a = new ArrayList();
    private boolean d = false;
    private Handler f = new t(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends Thread {
        File a;

        public a(File file) {
            this.a = file;
            Log.d("kal", "upload file:" + this.a.getAbsolutePath());
        }

        public void a() {
            if (!this.a.exists()) {
                s.this.a.remove(this.a);
            }
            s.a().c();
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                if (s.c) {
                    Log.d("kal", "UploadWorker:begin uploading.");
                }
                HashMap hashMap = new HashMap();
                hashMap.put("ver", "2");
                hashMap.put("pd", "mapsdk");
                hashMap.put("im", Mj.k);
                hashMap.put("os", "android");
                String uuid = UUID.randomUUID().toString();
                HttpURLConnection a = d.a("http://ulog.imap.baidu.com/up");
                if (s.c) {
                    Log.d("kal", "UploadWorker:begin get connection ok.");
                }
                a.setReadTimeout(5000);
                a.setDoInput(true);
                a.setDoOutput(true);
                a.setUseCaches(false);
                a.setRequestMethod("POST");
                a.setRequestProperty(Headers.CONN_DIRECTIVE, "keep-alive");
                a.setRequestProperty("Charsert", "UTF-8");
                a.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + uuid);
                StringBuilder sb = new StringBuilder();
                for (Map.Entry entry : hashMap.entrySet()) {
                    sb.append("--");
                    sb.append(uuid);
                    sb.append("\r\n");
                    sb.append("Content-Disposition: form-data; name=\"" + ((String) entry.getKey()) + "\"\r\n");
                    sb.append("Content-Type: text/plain; charset=UTF-8\r\n");
                    sb.append("Content-Transfer-Encoding: 8bit\r\n");
                    sb.append("\r\n");
                    sb.append((String) entry.getValue());
                    sb.append("\r\n");
                }
                DataOutputStream dataOutputStream = new DataOutputStream(a.getOutputStream());
                dataOutputStream.write(sb.toString().getBytes());
                if (s.c) {
                    Log.d("kal", "UploadWorker:write header is ok.");
                }
                if (this.a != null) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("--");
                    sb2.append(uuid);
                    sb2.append("\r\n");
                    sb2.append("Content-Disposition: form-data; name=\"datafile\"; filename=\"" + this.a.getName() + "\"\r\n");
                    sb2.append("Content-Type: application/octet-stream; charset=UTF-8\r\n");
                    sb2.append("\r\n");
                    dataOutputStream.write(sb2.toString().getBytes());
                    FileInputStream fileInputStream = new FileInputStream(this.a);
                    byte[] bArr = new byte[NotificationProxy.MAX_URL_LENGTH];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        dataOutputStream.write(bArr, 0, read);
                    }
                    fileInputStream.close();
                    dataOutputStream.write("\r\n".getBytes());
                    if (s.c) {
                        Log.d("kal", "UploadWorker: write data is ok.");
                    }
                }
                dataOutputStream.write(("--" + uuid + "--\r\n").getBytes());
                dataOutputStream.flush();
                int responseCode = a.getResponseCode();
                dataOutputStream.close();
                a.disconnect();
                if (responseCode != 200) {
                    synchronized (s.this.a) {
                        s.this.d = false;
                        if (s.this.a.size() > 0) {
                            s.this.f.sendMessageDelayed(s.this.f.obtainMessage(1), 2000L);
                        } else {
                            s.this.f.sendEmptyMessage(2);
                        }
                    }
                    return;
                }
                synchronized (s.this.a) {
                    s.this.d = false;
                    if (s.c) {
                        Log.d("kal", "remove file:" + this.a.getAbsolutePath());
                    }
                    s.this.a.remove(this.a);
                    if (s.c) {
                        Log.d("kal", "updateList size: " + s.this.a.size());
                    }
                    this.a.delete();
                    if (s.this.a.size() > 0) {
                        s.this.f.sendMessageDelayed(s.this.f.obtainMessage(1), 2000L);
                    } else {
                        s.this.f.sendEmptyMessage(2);
                    }
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
                a();
            } catch (IOException e2) {
                e2.printStackTrace();
                a();
            }
        }
    }

    public static s a() {
        if (b == null) {
            b = new s();
        }
        return b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.a.size() > 0) {
            if (c) {
                Log.d("kal", "started.");
            }
            this.d = true;
            new a((File) this.a.get(0)).start();
        }
    }

    private void b(File file) {
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles.length > 0) {
                for (File file2 : listFiles) {
                    if (!file2.getName().contains("udclog") && !this.a.contains(file2)) {
                        this.a.add(file2);
                    }
                }
                b();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (c) {
            Log.d("kal", "stoped.");
        }
        this.d = false;
        if (this.e != null) {
            b(new File(this.e));
        }
    }

    public String a(String str, String str2) {
        String AppendRecord = Mj.AppendRecord(str, str2);
        if (AppendRecord != null && !"".equals(AppendRecord)) {
            a(new File(AppendRecord));
        }
        return AppendRecord;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Context context) {
        b(new File(context.getFilesDir(), "udc/"));
    }

    public void a(File file) {
        synchronized (this.a) {
            if (!this.a.contains(file)) {
                this.a.add(file);
                this.e = file.getParent();
                if (!this.d) {
                    b();
                }
            }
        }
    }
}
