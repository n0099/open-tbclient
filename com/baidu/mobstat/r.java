package com.baidu.mobstat;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.mobstat.bl;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import java.io.BufferedReader;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.zip.GZIPOutputStream;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class r {
    public static String a;
    public static r b;
    public Handler c;

    static {
        String str;
        if (Build.VERSION.SDK_INT < 9) {
            str = "http://openrcv.baidu.com/1010/bplus.gif";
        } else {
            str = "https://openrcv.baidu.com/1010/bplus.gif";
        }
        a = str;
    }

    public r() {
        HandlerThread handlerThread = new HandlerThread("LogSender");
        handlerThread.start();
        this.c = new Handler(handlerThread.getLooper());
    }

    public static r a() {
        if (b == null) {
            synchronized (r.class) {
                if (b == null) {
                    b = new r();
                }
            }
        }
        return b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context) {
        String next;
        Iterator<String> it = c(context, y.f).iterator();
        while (true) {
            int i = 0;
            while (it.hasNext()) {
                next = it.next();
                String a2 = bn.a(context, next);
                if (TextUtils.isEmpty(a2)) {
                    bn.b(context, next);
                } else if (d(context, a2)) {
                    break;
                } else {
                    a(context, a2, next);
                    i++;
                    if (i >= 5) {
                        return;
                    }
                }
            }
            return;
            bn.b(context, next);
        }
    }

    private void a(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            JSONObject jSONObject = null;
            try {
                jSONObject = new JSONObject(str);
            } catch (Exception unused) {
            }
            JSONObject a2 = h.a(jSONObject);
            if (a2 != null) {
                h.b(a2);
                if (jSONObject != null) {
                    bn.a(context, str2, jSONObject.toString(), false);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context, String str) {
        bn.a(context, y.f + System.currentTimeMillis(), str, false);
    }

    private boolean d(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        if (!bw.c().booleanValue()) {
            return true;
        }
        try {
            b(context, a, str);
            return true;
        } catch (Exception e) {
            ba.c().c(e);
            return false;
        }
    }

    public static byte[] a(long j, int i) {
        byte[] bArr = new byte[i];
        for (int i2 = 0; i2 < i; i2++) {
            bArr[(i - i2) - 1] = (byte) (255 & j);
            j >>= 8;
        }
        return bArr;
    }

    private String b(Context context, String str, String str2) throws IOException {
        byte[] bytes;
        boolean z = !str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_HTTPS);
        HttpURLConnection d = bn.d(context, str);
        d.setDoOutput(true);
        d.setInstanceFollowRedirects(false);
        d.setUseCaches(false);
        d.setRequestProperty("Content-Encoding", "gzip");
        try {
            JSONObject jSONObject = new JSONObject(str2).getJSONArray("payload").getJSONObject(0).getJSONObject(Config.HEADER_PART);
            d.setRequestProperty("Content-Type", "gzip");
            d.setRequestProperty("mtj_appversion", jSONObject.getString("n"));
            d.setRequestProperty("mtj_os", "Android");
            d.setRequestProperty("mtj_pn", jSONObject.getString("pn"));
            d.setRequestProperty("mtj_tg", "2");
            d.setRequestProperty("mtj_ii", jSONObject.getString(Config.CUID_SEC));
            d.setRequestProperty("from", jSONObject.getString("from"));
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
                    byte[] a2 = bl.a.a();
                    byte[] a3 = bv.a(false, bq.a(), a2);
                    gZIPOutputStream.write(a(a3.length, 4));
                    gZIPOutputStream.write(a3);
                    bytes = bl.a.a(a2, new byte[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, str2.getBytes(IMAudioTransRequest.CHARSET));
                    gZIPOutputStream.write(a(bytes.length, 2));
                } else {
                    bytes = str2.getBytes(IMAudioTransRequest.CHARSET);
                }
                gZIPOutputStream.write(bytes);
                gZIPOutputStream.close();
                outputStream.close();
                int responseCode = d.getResponseCode();
                int contentLength = d.getContentLength();
                ba.c().c("code: " + responseCode + "; len: " + contentLength);
                if (responseCode == 200 && contentLength == 0) {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(d.getInputStream()));
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            return sb.toString();
                        }
                        sb.append(readLine);
                    }
                } else {
                    throw new IOException("Response code = " + d.getResponseCode());
                }
            } finally {
                d.disconnect();
            }
        } catch (Exception e2) {
            ba.c().b(e2);
            d.disconnect();
            return "";
        }
    }

    private ArrayList<String> c(Context context, final String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        if (context == null) {
            return arrayList;
        }
        File filesDir = context.getFilesDir();
        if (filesDir != null && filesDir.exists()) {
            FilenameFilter filenameFilter = new FilenameFilter() { // from class: com.baidu.mobstat.r.2
                @Override // java.io.FilenameFilter
                public boolean accept(File file, String str2) {
                    if (str2.startsWith(str)) {
                        return true;
                    }
                    return false;
                }
            };
            String[] strArr = null;
            try {
                strArr = filesDir.list(filenameFilter);
            } catch (Exception unused) {
            }
            if (strArr != null && strArr.length != 0) {
                try {
                    Arrays.sort(strArr, new Comparator<String>() { // from class: com.baidu.mobstat.r.3
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // java.util.Comparator
                        /* renamed from: a */
                        public int compare(String str2, String str3) {
                            return str2.compareTo(str3);
                        }
                    });
                } catch (Exception unused2) {
                }
                for (String str2 : strArr) {
                    arrayList.add(str2);
                }
            }
        }
        return arrayList;
    }

    public void a(final Context context, final String str) {
        ba c = ba.c();
        c.a("data = " + str);
        if (str != null && !"".equals(str)) {
            this.c.post(new Runnable() { // from class: com.baidu.mobstat.r.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (context == null) {
                            return;
                        }
                        r.this.b(context, str);
                        r.this.a(context.getApplicationContext());
                    } catch (Throwable th) {
                        ba.c().b(th);
                    }
                }
            });
        }
    }
}
