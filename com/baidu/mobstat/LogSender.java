package com.baidu.mobstat;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.baidu.down.loopj.android.http.AsyncHttpClient;
import com.baidu.mobstat.bm;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;
import java.util.zip.GZIPOutputStream;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class LogSender {

    /* renamed from: a  reason: collision with root package name */
    public static LogSender f8462a = new LogSender();

    /* renamed from: b  reason: collision with root package name */
    public boolean f8463b = false;

    /* renamed from: c  reason: collision with root package name */
    public int f8464c = 0;

    /* renamed from: d  reason: collision with root package name */
    public int f8465d = 1;

    /* renamed from: e  reason: collision with root package name */
    public SendStrategyEnum f8466e = SendStrategyEnum.APP_START;

    /* renamed from: f  reason: collision with root package name */
    public Timer f8467f;

    /* renamed from: g  reason: collision with root package name */
    public Handler f8468g;

    public LogSender() {
        HandlerThread handlerThread = new HandlerThread("LogSenderThread");
        handlerThread.start();
        this.f8468g = new Handler(handlerThread.getLooper());
    }

    private String e(Context context, String str, String str2) throws Exception {
        HttpURLConnection d2 = bo.d(context, str);
        d2.setDoOutput(true);
        d2.setInstanceFollowRedirects(false);
        d2.setUseCaches(false);
        d2.setRequestProperty("Content-Type", AsyncHttpClient.ENCODING_GZIP);
        byte[] a2 = bm.a.a();
        byte[] b2 = bm.a.b();
        d2.setRequestProperty("key", bv.a(a2));
        d2.setRequestProperty("iv", bv.a(b2));
        byte[] a3 = bm.a.a(a2, b2, str2.getBytes("utf-8"));
        d2.connect();
        try {
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(d2.getOutputStream());
            gZIPOutputStream.write(a3);
            gZIPOutputStream.flush();
            gZIPOutputStream.close();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(d2.getInputStream()));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
            }
            int contentLength = d2.getContentLength();
            if (d2.getResponseCode() == 200 && contentLength == 0) {
                return sb.toString();
            }
            throw new IOException("http code = " + d2.getResponseCode() + "; contentResponse = " + ((Object) sb));
        } finally {
            d2.disconnect();
        }
    }

    public static LogSender instance() {
        return f8462a;
    }

    public void onSend(final Context context) {
        if (context != null) {
            context = context.getApplicationContext();
        }
        if (context == null) {
            return;
        }
        this.f8468g.post(new Runnable() { // from class: com.baidu.mobstat.LogSender.1
            @Override // java.lang.Runnable
            public void run() {
                if (LogSender.this.f8467f != null) {
                    LogSender.this.f8467f.cancel();
                    LogSender.this.f8467f = null;
                }
                LogSender.this.f8466e = SendStrategyEnum.values()[bq.a().b(context)];
                LogSender.this.f8465d = bq.a().c(context);
                LogSender.this.f8463b = bq.a().d(context);
                if (!LogSender.this.f8466e.equals(SendStrategyEnum.SET_TIME_INTERVAL)) {
                    if (LogSender.this.f8466e.equals(SendStrategyEnum.ONCE_A_DAY)) {
                        LogSender.this.setSendingLogTimer(context);
                    }
                } else {
                    LogSender.this.setSendingLogTimer(context);
                }
                LogSender.this.f8468g.postDelayed(new Runnable() { // from class: com.baidu.mobstat.LogSender.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        LogSender.this.a(context);
                    }
                }, LogSender.this.f8464c * 1000);
            }
        });
    }

    public void saveLogData(Context context, String str, boolean z) {
        String str2 = z ? Config.PREFIX_SEND_DATA_FULL : Config.PREFIX_SEND_DATA;
        bo.a(context, str2 + System.currentTimeMillis(), str, false);
        if (z) {
            a(context, Config.FULL_TRACE_LOG_LIMIT, Config.PREFIX_SEND_DATA_FULL);
        }
    }

    public void sendEmptyLogData(Context context, final String str) {
        final Context applicationContext = context.getApplicationContext();
        this.f8468g.post(new Runnable() { // from class: com.baidu.mobstat.LogSender.7
            @Override // java.lang.Runnable
            public void run() {
                String constructLogWithEmptyBody = DataCore.instance().constructLogWithEmptyBody(applicationContext, str);
                if (TextUtils.isEmpty(constructLogWithEmptyBody)) {
                    return;
                }
                LogSender.this.c(applicationContext, constructLogWithEmptyBody);
            }
        });
    }

    public void sendLogData(Context context, final String str, boolean z) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        final Context applicationContext = context.getApplicationContext();
        if (z) {
            b(applicationContext, str);
        } else {
            this.f8468g.post(new Runnable() { // from class: com.baidu.mobstat.LogSender.6
                @Override // java.lang.Runnable
                public void run() {
                    LogSender.this.b(applicationContext, str);
                }
            });
        }
    }

    public void setLogSenderDelayed(int i2) {
        if (i2 < 0 || i2 > 30) {
            return;
        }
        this.f8464c = i2;
    }

    public void setSendLogStrategy(Context context, SendStrategyEnum sendStrategyEnum, int i2, boolean z) {
        if (!sendStrategyEnum.equals(SendStrategyEnum.SET_TIME_INTERVAL)) {
            this.f8466e = sendStrategyEnum;
            bq.a().a(context, this.f8466e.ordinal());
            if (sendStrategyEnum.equals(SendStrategyEnum.ONCE_A_DAY)) {
                bq.a().b(context, 24);
            }
        } else if (i2 > 0 && i2 <= 24) {
            this.f8465d = i2;
            this.f8466e = SendStrategyEnum.SET_TIME_INTERVAL;
            bq.a().a(context, this.f8466e.ordinal());
            bq.a().b(context, this.f8465d);
        }
        this.f8463b = z;
        bq.a().a(context, this.f8463b);
    }

    public void setSendingLogTimer(Context context) {
        final Context applicationContext = context.getApplicationContext();
        long j = this.f8465d * 3600000;
        try {
            Timer timer = new Timer();
            this.f8467f = timer;
            timer.schedule(new TimerTask() { // from class: com.baidu.mobstat.LogSender.2
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    LogSender.this.a(applicationContext);
                }
            }, j, j);
        } catch (Exception unused) {
        }
    }

    private String d(Context context, String str, String str2) throws IOException {
        HttpURLConnection d2 = bo.d(context, str);
        d2.setDoOutput(true);
        d2.setInstanceFollowRedirects(false);
        d2.setUseCaches(false);
        d2.setRequestProperty("Content-Type", AsyncHttpClient.ENCODING_GZIP);
        try {
            JSONObject jSONObject = new JSONObject(str2).getJSONObject(Config.HEADER_PART);
            d2.setRequestProperty("mtj_appkey", jSONObject.getString(Config.APP_KEY));
            d2.setRequestProperty("mtj_appversion", jSONObject.getString("n"));
            d2.setRequestProperty("mtj_os", jSONObject.getString(Config.OS));
            d2.setRequestProperty("mtj_pn", jSONObject.getString(Config.PACKAGE_NAME));
            d2.setRequestProperty("mtj_tg", jSONObject.getString(Config.SDK_TAG));
            d2.setRequestProperty("mtj_ii", jSONObject.getString(Config.CUID_SEC));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        d2.connect();
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new GZIPOutputStream(d2.getOutputStream())));
            bufferedWriter.write(str2);
            bufferedWriter.flush();
            bufferedWriter.close();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(d2.getInputStream()));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
            }
            int contentLength = d2.getContentLength();
            if (d2.getResponseCode() == 200 && contentLength == 0) {
                return sb.toString();
            }
            throw new IOException("http code = " + d2.getResponseCode() + "; contentResponse = " + ((Object) sb));
        } finally {
            d2.disconnect();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context, String str) {
        String str2 = Config.PREFIX_SEND_DATA + System.currentTimeMillis();
        bo.a(context, str2, str, false);
        if (c(context, str)) {
            bo.b(context, str2);
        } else {
            b(context, str2, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(Context context, String str) {
        return a(context, str, false);
    }

    private String c(Context context, String str, String str2) throws Exception {
        if (!str.startsWith("https://")) {
            return e(context, str, str2);
        }
        return d(context, str, str2);
    }

    public static void b(Context context, String str, String str2) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(str2);
        } catch (Exception unused) {
            jSONObject = null;
        }
        if (jSONObject == null) {
            return;
        }
        try {
            JSONObject jSONObject2 = (JSONObject) jSONObject.get(Config.TRACE_PART);
            jSONObject2.put(Config.TRACE_FAILED_CNT, jSONObject2.getLong(Config.TRACE_FAILED_CNT) + 1);
        } catch (Exception unused2) {
        }
        bo.a(context, str, jSONObject.toString(), false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x002b, code lost:
        if (r4 == null) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x002d, code lost:
        r4.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0020, code lost:
        if (r4 != null) goto L17;
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x003c A[LOOP:1: B:21:0x003a->B:22:0x003c, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(Context context, long j, String str) {
        ArrayList<String> a2 = a(context, str);
        int size = a2.size() - 1;
        long j2 = 0;
        FileInputStream fileInputStream = null;
        while (size >= 0) {
            try {
                fileInputStream = context.openFileInput(a2.get(size));
                j2 += fileInputStream.available();
            } catch (Exception unused) {
            } catch (Throwable th) {
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception unused2) {
                    }
                }
                throw th;
            }
        }
        for (int i2 = 0; i2 <= size; i2++) {
            bo.b(context, a2.get(i2));
        }
        return;
        fileInputStream = null;
        if (j2 > j) {
            while (i2 <= size) {
            }
            return;
        }
        size--;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<String> a(Context context, final String str) {
        File filesDir;
        ArrayList<String> arrayList = new ArrayList<>();
        if (context != null && (filesDir = context.getFilesDir()) != null && filesDir.exists()) {
            FilenameFilter filenameFilter = new FilenameFilter() { // from class: com.baidu.mobstat.LogSender.3
                @Override // java.io.FilenameFilter
                public boolean accept(File file, String str2) {
                    return str2.startsWith(str);
                }
            };
            String[] strArr = null;
            try {
                strArr = filesDir.list(filenameFilter);
            } catch (Exception unused) {
            }
            if (strArr != null && strArr.length != 0) {
                try {
                    Arrays.sort(strArr, new Comparator<String>() { // from class: com.baidu.mobstat.LogSender.4
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

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final Context context) {
        if (!this.f8463b || bw.q(context)) {
            this.f8468g.post(new Runnable() { // from class: com.baidu.mobstat.LogSender.5
                @Override // java.lang.Runnable
                public void run() {
                    String str;
                    try {
                        ArrayList arrayList = new ArrayList();
                        arrayList.addAll(LogSender.this.a(context, Config.PREFIX_SEND_DATA));
                        arrayList.addAll(LogSender.this.a(context, Config.PREFIX_SEND_DATA_FULL));
                        Iterator it = arrayList.iterator();
                        while (true) {
                            int i2 = 0;
                            while (it.hasNext()) {
                                str = (String) it.next();
                                String a2 = bo.a(context, str);
                                if (TextUtils.isEmpty(a2)) {
                                    bo.b(context, str);
                                } else {
                                    if (LogSender.this.a(context, a2, str.contains(Config.PREFIX_SEND_DATA_FULL))) {
                                        break;
                                    }
                                    LogSender.b(context, str, a2);
                                    i2++;
                                    if (i2 >= 5) {
                                        return;
                                    }
                                }
                            }
                            return;
                            bo.b(context, str);
                        }
                    } catch (Exception unused) {
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(Context context, String str, boolean z) {
        if (!z) {
            bc.c().a("Start send log \n" + str);
        }
        boolean z2 = false;
        if (this.f8463b && !bw.q(context)) {
            bc.c().a("[WARNING] wifi not available, log will be cached, next time will try to resend");
            return false;
        }
        String str2 = Config.LOG_SEND_URL;
        if (z) {
            str2 = Config.LOG_FULL_SEND_URL;
        }
        try {
            c(context, str2, str);
            z2 = true;
        } catch (Exception e2) {
            bc.c().c(e2);
        }
        if (!z) {
            String str3 = z2 ? "success" : com.alipay.sdk.util.e.f1963a;
            bc.c().a("Send log " + str3);
        }
        return z2;
    }
}
