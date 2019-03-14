package com.baidu.mobstat;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.baidu.mobstat.bt;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.Arrays;
import java.util.Comparator;
import java.util.zip.GZIPOutputStream;
import org.apache.http.protocol.HTTP;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class z {
    private static String a;
    private static z b;
    private Handler c;

    static {
        a = Build.VERSION.SDK_INT < 9 ? "http://openrcv.baidu.com/1010/bplus.gif" : "https://openrcv.baidu.com/1010/bplus.gif";
    }

    private z() {
        HandlerThread handlerThread = new HandlerThread("LogSender");
        handlerThread.start();
        this.c = new Handler(handlerThread.getLooper());
    }

    public static z a() {
        if (b == null) {
            synchronized (z.class) {
                if (b == null) {
                    b = new z();
                }
            }
        }
        return b;
    }

    public void a(final Context context, final String str) {
        bi.c().a("data = " + str);
        if (str != null && !"".equals(str)) {
            this.c.post(new Runnable() { // from class: com.baidu.mobstat.z.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        z.this.a(str);
                        if (context != null) {
                            z.this.a(context.getApplicationContext());
                        }
                    } catch (Throwable th) {
                        bi.c().b(th);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        bv.a("backups/system" + File.separator + "__send_log_data_" + System.currentTimeMillis(), str, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context) {
        File[] listFiles;
        if ("mounted".equals(bv.a())) {
            File file = new File(Environment.getExternalStorageDirectory(), "backups/system");
            if (file.exists() && (listFiles = file.listFiles()) != null && listFiles.length != 0) {
                try {
                    Arrays.sort(listFiles, new Comparator<File>() { // from class: com.baidu.mobstat.z.2
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // java.util.Comparator
                        /* renamed from: a */
                        public int compare(File file2, File file3) {
                            return (int) (file3.lastModified() - file2.lastModified());
                        }
                    });
                } catch (Exception e) {
                    bi.c().b(e);
                }
                int i = 0;
                for (File file2 : listFiles) {
                    if (file2.isFile()) {
                        String name = file2.getName();
                        if (!TextUtils.isEmpty(name) && name.startsWith("__send_log_data_")) {
                            String str = "backups/system" + File.separator + name;
                            String b2 = bv.b(str);
                            if (b(context, b2)) {
                                bv.c(str);
                                i = 0;
                            } else {
                                a(b2, str);
                                i++;
                                if (i >= 5) {
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private void a(String str, String str2) {
        JSONObject jSONObject;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                jSONObject = new JSONObject(str);
            } catch (Exception e) {
                jSONObject = null;
            }
            JSONObject a2 = o.a(jSONObject);
            if (a2 != null) {
                o.b(a2);
                bv.a(str2, jSONObject.toString(), false);
            }
        }
    }

    private boolean b(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            a(context, a, str);
            return true;
        } catch (Exception e) {
            bi.c().c(e);
            return false;
        }
    }

    private String a(Context context, String str, String str2) throws IOException {
        byte[] bytes;
        boolean z = !str.startsWith("https:");
        HttpURLConnection d = bv.d(context, str);
        d.setDoOutput(true);
        d.setInstanceFollowRedirects(false);
        d.setUseCaches(false);
        d.setRequestProperty(HTTP.CONTENT_ENCODING, "gzip");
        d.connect();
        try {
            try {
                OutputStream outputStream = d.getOutputStream();
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
                gZIPOutputStream.write(new byte[]{72, 77, 48, 49});
                gZIPOutputStream.write(new byte[]{0, 0, 0, 1});
                gZIPOutputStream.write(new byte[]{0, 0, 3, -14});
                gZIPOutputStream.write(new byte[]{0, 0, 0, 0, 0, 0, 0, 0});
                gZIPOutputStream.write(new byte[]{0, 2});
                if (z) {
                    gZIPOutputStream.write(new byte[]{0, 1});
                } else {
                    gZIPOutputStream.write(new byte[]{0, 0});
                }
                gZIPOutputStream.write(new byte[]{72, 77, 48, 49});
                if (z) {
                    byte[] a2 = bt.a.a();
                    byte[] a3 = cb.a(false, bx.a(), a2);
                    gZIPOutputStream.write(a(a3.length, 4));
                    gZIPOutputStream.write(a3);
                    bytes = bt.a.a(a2, new byte[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, str2.getBytes("utf-8"));
                    gZIPOutputStream.write(a(bytes.length, 2));
                } else {
                    bytes = str2.getBytes("utf-8");
                }
                gZIPOutputStream.write(bytes);
                gZIPOutputStream.close();
                outputStream.close();
                int responseCode = d.getResponseCode();
                int contentLength = d.getContentLength();
                bi.c().c("code: " + responseCode + "; len: " + contentLength);
                if (responseCode != 200 || contentLength != 0) {
                    throw new IOException("Response code = " + d.getResponseCode());
                }
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(d.getInputStream()));
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        sb.append(readLine);
                    } else {
                        return sb.toString();
                    }
                }
            } catch (Exception e) {
                bi.c().b(e);
                d.disconnect();
                return "";
            }
        } finally {
            d.disconnect();
        }
    }

    private static byte[] a(long j, int i) {
        byte[] bArr = new byte[i];
        for (int i2 = 0; i2 < i; i2++) {
            bArr[(i - i2) - 1] = (byte) (255 & j);
            j >>= 8;
        }
        return bArr;
    }
}
