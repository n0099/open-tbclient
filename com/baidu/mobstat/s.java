package com.baidu.mobstat;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import com.baidu.mobstat.bm;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.Arrays;
import java.util.Comparator;
import java.util.zip.GZIPOutputStream;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes17.dex */
public class s {

    /* renamed from: a  reason: collision with root package name */
    private static String f2624a;
    private static s b;
    private Handler c;

    static {
        f2624a = Build.VERSION.SDK_INT < 9 ? "http://openrcv.baidu.com/1010/bplus.gif" : "https://openrcv.baidu.com/1010/bplus.gif";
    }

    private s() {
        HandlerThread handlerThread = new HandlerThread("LogSender");
        handlerThread.start();
        this.c = new Handler(handlerThread.getLooper());
    }

    public static s a() {
        if (b == null) {
            synchronized (s.class) {
                if (b == null) {
                    b = new s();
                }
            }
        }
        return b;
    }

    public void a(final Context context, final String str) {
        bb.c().a("data = " + str);
        if (str != null && !"".equals(str)) {
            this.c.post(new Runnable() { // from class: com.baidu.mobstat.s.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        s.this.a(str);
                        if (context != null) {
                            s.this.a(context.getApplicationContext());
                        }
                    } catch (Throwable th) {
                        bb.c().b(th);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        bo.a("backups/system" + File.separator + "__send_log_data_" + System.currentTimeMillis(), str, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context) {
        File[] listFiles;
        if ("mounted".equals(bo.a())) {
            File file = new File(Environment.getExternalStorageDirectory(), "backups/system");
            if (file.exists() && (listFiles = file.listFiles()) != null && listFiles.length != 0) {
                try {
                    Arrays.sort(listFiles, new Comparator<File>() { // from class: com.baidu.mobstat.s.2
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // java.util.Comparator
                        /* renamed from: a */
                        public int compare(File file2, File file3) {
                            return (int) (file3.lastModified() - file2.lastModified());
                        }
                    });
                } catch (Exception e) {
                    bb.c().b(e);
                }
                int i = 0;
                for (File file2 : listFiles) {
                    if (file2.isFile()) {
                        String name = file2.getName();
                        if (!TextUtils.isEmpty(name) && name.startsWith("__send_log_data_")) {
                            String str = "backups/system" + File.separator + name;
                            String b2 = bo.b(str);
                            if (b(context, b2)) {
                                bo.c(str);
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
            JSONObject a2 = h.a(jSONObject);
            if (a2 != null) {
                h.b(a2);
                bo.a(str2, jSONObject.toString(), false);
            }
        }
    }

    private boolean b(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        if (bw.c().booleanValue()) {
            try {
                a(context, f2624a, str);
                return true;
            } catch (Exception e) {
                bb.c().c(e);
                return false;
            }
        }
        return true;
    }

    private String a(Context context, String str, String str2) throws IOException {
        byte[] bytes;
        boolean z = !str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_HTTPS);
        HttpURLConnection d = bo.d(context, str);
        d.setDoOutput(true);
        d.setInstanceFollowRedirects(false);
        d.setUseCaches(false);
        d.setRequestProperty("Content-Encoding", "gzip");
        try {
            JSONObject jSONObject = new JSONObject(str2).getJSONArray("payload").getJSONObject(0).getJSONObject(Config.HEADER_PART);
            d.setRequestProperty("Content-Type", "gzip");
            d.setRequestProperty("mtj_appversion", jSONObject.getString("n"));
            d.setRequestProperty("mtj_os", "Android");
            d.setRequestProperty("mtj_pn", jSONObject.getString(Config.PACKAGE_NAME));
            d.setRequestProperty("mtj_tg", "1");
            d.setRequestProperty("mtj_ii", jSONObject.getString(Config.CUID_SEC));
        } catch (JSONException e) {
            e.printStackTrace();
        }
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
                    byte[] a2 = bm.a.a();
                    byte[] a3 = bv.a(false, br.a(), a2);
                    gZIPOutputStream.write(a(a3.length, 4));
                    gZIPOutputStream.write(a3);
                    bytes = bm.a.a(a2, new byte[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, str2.getBytes("utf-8"));
                    gZIPOutputStream.write(a(bytes.length, 2));
                } else {
                    bytes = str2.getBytes("utf-8");
                }
                gZIPOutputStream.write(bytes);
                gZIPOutputStream.close();
                outputStream.close();
                int responseCode = d.getResponseCode();
                int contentLength = d.getContentLength();
                bb.c().c("code: " + responseCode + "; len: " + contentLength);
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
            } catch (Exception e2) {
                bb.c().b(e2);
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
