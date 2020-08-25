package com.baidu.mobstat;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.baidu.mobstat.bm;
import com.baidu.sapi2.utils.SapiUtils;
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
/* loaded from: classes11.dex */
public class LogSender {
    private static LogSender a = new LogSender();
    private boolean b = false;
    private int c = 0;
    private int d = 1;
    private SendStrategyEnum e = SendStrategyEnum.APP_START;
    private Timer f;
    private Handler g;

    public static LogSender instance() {
        return a;
    }

    private LogSender() {
        HandlerThread handlerThread = new HandlerThread("LogSenderThread");
        handlerThread.start();
        this.g = new Handler(handlerThread.getLooper());
    }

    public void setLogSenderDelayed(int i) {
        if (i >= 0 && i <= 30) {
            this.c = i;
        }
    }

    public void setSendLogStrategy(Context context, SendStrategyEnum sendStrategyEnum, int i, boolean z) {
        if (sendStrategyEnum.equals(SendStrategyEnum.SET_TIME_INTERVAL)) {
            if (i > 0 && i <= 24) {
                this.d = i;
                this.e = SendStrategyEnum.SET_TIME_INTERVAL;
                bq.a().a(context, this.e.ordinal());
                bq.a().b(context, this.d);
            }
        } else {
            this.e = sendStrategyEnum;
            bq.a().a(context, this.e.ordinal());
            if (sendStrategyEnum.equals(SendStrategyEnum.ONCE_A_DAY)) {
                bq.a().b(context, 24);
            }
        }
        this.b = z;
        bq.a().a(context, this.b);
    }

    public void onSend(final Context context) {
        if (context != null) {
            context = context.getApplicationContext();
        }
        if (context != null) {
            this.g.post(new Runnable() { // from class: com.baidu.mobstat.LogSender.1
                @Override // java.lang.Runnable
                public void run() {
                    if (LogSender.this.f != null) {
                        LogSender.this.f.cancel();
                        LogSender.this.f = null;
                    }
                    LogSender.this.e = SendStrategyEnum.values()[bq.a().b(context)];
                    LogSender.this.d = bq.a().c(context);
                    LogSender.this.b = bq.a().d(context);
                    if (!LogSender.this.e.equals(SendStrategyEnum.SET_TIME_INTERVAL)) {
                        if (LogSender.this.e.equals(SendStrategyEnum.ONCE_A_DAY)) {
                            LogSender.this.setSendingLogTimer(context);
                        }
                    } else {
                        LogSender.this.setSendingLogTimer(context);
                    }
                    LogSender.this.g.postDelayed(new Runnable() { // from class: com.baidu.mobstat.LogSender.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            LogSender.this.a(context);
                        }
                    }, LogSender.this.c * 1000);
                }
            });
        }
    }

    public void setSendingLogTimer(Context context) {
        final Context applicationContext = context.getApplicationContext();
        long j = this.d * 3600000;
        try {
            this.f = new Timer();
            this.f.schedule(new TimerTask() { // from class: com.baidu.mobstat.LogSender.2
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    LogSender.this.a(applicationContext);
                }
            }, j, j);
        } catch (Exception e) {
        }
    }

    public void saveLogData(Context context, String str, boolean z) {
        bo.a(context, (z ? Config.PREFIX_SEND_DATA_FULL : Config.PREFIX_SEND_DATA) + System.currentTimeMillis(), str, false);
        if (z) {
            a(context, 10485760L, Config.PREFIX_SEND_DATA_FULL);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [181=4] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004f A[LOOP:0: B:3:0x0012->B:24:0x004f, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x002e A[EDGE_INSN: B:48:0x002e->B:12:0x002e ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(Context context, long j, String str) {
        FileInputStream fileInputStream;
        ArrayList<String> a2 = a(context, str);
        long j2 = 0;
        FileInputStream fileInputStream2 = null;
        int size = a2.size() - 1;
        while (size >= 0) {
            try {
                fileInputStream = context.openFileInput(a2.get(size));
                try {
                    j2 += fileInputStream.available();
                } catch (Exception e) {
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e2) {
                        }
                        fileInputStream2 = null;
                        if (j2 <= j) {
                        }
                    }
                    fileInputStream2 = fileInputStream;
                    if (j2 <= j) {
                    }
                } catch (Throwable th) {
                    fileInputStream2 = fileInputStream;
                    th = th;
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (Exception e3) {
                        }
                    }
                    throw th;
                }
            } catch (Exception e4) {
                fileInputStream = fileInputStream2;
            } catch (Throwable th2) {
                th = th2;
            }
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Exception e5) {
                }
                fileInputStream2 = null;
                if (j2 <= j) {
                    break;
                }
                size--;
            }
            fileInputStream2 = fileInputStream;
            if (j2 <= j) {
            }
        }
        for (int i = 0; i <= size; i++) {
            bo.b(context, a2.get(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<String> a(Context context, final String str) {
        File filesDir;
        String[] strArr;
        ArrayList<String> arrayList = new ArrayList<>();
        if (context != null && (filesDir = context.getFilesDir()) != null && filesDir.exists()) {
            try {
                strArr = filesDir.list(new FilenameFilter() { // from class: com.baidu.mobstat.LogSender.3
                    @Override // java.io.FilenameFilter
                    public boolean accept(File file, String str2) {
                        return str2.startsWith(str);
                    }
                });
            } catch (Exception e) {
                strArr = null;
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
                } catch (Exception e2) {
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
        if (!this.b || bw.q(context)) {
            this.g.post(new Runnable() { // from class: com.baidu.mobstat.LogSender.5
                @Override // java.lang.Runnable
                public void run() {
                    int i;
                    try {
                        ArrayList arrayList = new ArrayList();
                        arrayList.addAll(LogSender.this.a(context, Config.PREFIX_SEND_DATA));
                        arrayList.addAll(LogSender.this.a(context, Config.PREFIX_SEND_DATA_FULL));
                        Iterator it = arrayList.iterator();
                        int i2 = 0;
                        while (it.hasNext()) {
                            String str = (String) it.next();
                            String a2 = bo.a(context, str);
                            if (!TextUtils.isEmpty(a2)) {
                                if (!LogSender.this.a(context, a2, str.contains(Config.PREFIX_SEND_DATA_FULL))) {
                                    LogSender.b(context, str, a2);
                                    i = i2 + 1;
                                    if (i >= 5) {
                                        return;
                                    }
                                } else {
                                    bo.b(context, str);
                                    i = 0;
                                }
                                i2 = i;
                            } else {
                                bo.b(context, str);
                            }
                        }
                    } catch (Exception e) {
                    }
                }
            });
        }
    }

    public void sendLogData(Context context, final String str, boolean z) {
        if (context != null && !TextUtils.isEmpty(str)) {
            final Context applicationContext = context.getApplicationContext();
            if (z) {
                b(applicationContext, str);
            } else {
                this.g.post(new Runnable() { // from class: com.baidu.mobstat.LogSender.6
                    @Override // java.lang.Runnable
                    public void run() {
                        LogSender.this.b(applicationContext, str);
                    }
                });
            }
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
    public static void b(Context context, String str, String str2) {
        JSONObject jSONObject = null;
        try {
            jSONObject = new JSONObject(str2);
        } catch (Exception e) {
        }
        if (jSONObject != null) {
            try {
                JSONObject jSONObject2 = (JSONObject) jSONObject.get(Config.TRACE_PART);
                jSONObject2.put(Config.TRACE_FAILED_CNT, jSONObject2.getLong(Config.TRACE_FAILED_CNT) + 1);
            } catch (Exception e2) {
            }
            bo.a(context, str, jSONObject.toString(), false);
        }
    }

    public void sendEmptyLogData(Context context, final String str) {
        final Context applicationContext = context.getApplicationContext();
        this.g.post(new Runnable() { // from class: com.baidu.mobstat.LogSender.7
            @Override // java.lang.Runnable
            public void run() {
                String constructLogWithEmptyBody = DataCore.instance().constructLogWithEmptyBody(applicationContext, str);
                if (!TextUtils.isEmpty(constructLogWithEmptyBody)) {
                    LogSender.this.c(applicationContext, constructLogWithEmptyBody);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(Context context, String str) {
        return a(context, str, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(Context context, String str, boolean z) {
        boolean z2 = false;
        if (!z) {
            bc.c().a("Start send log \n" + str);
        }
        if (this.b && !bw.q(context)) {
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
        } catch (Exception e) {
            bc.c().c(e);
        }
        if (!z) {
            bc.c().a("Send log " + (z2 ? "success" : "failed"));
        }
        return z2;
    }

    private String c(Context context, String str, String str2) throws Exception {
        return !str.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX) ? e(context, str, str2) : d(context, str, str2);
    }

    private String d(Context context, String str, String str2) throws IOException {
        HttpURLConnection d = bo.d(context, str);
        d.setDoOutput(true);
        d.setInstanceFollowRedirects(false);
        d.setUseCaches(false);
        d.setRequestProperty("Content-Type", "gzip");
        try {
            JSONObject jSONObject = new JSONObject(str2).getJSONObject(Config.HEADER_PART);
            d.setRequestProperty("mtj_appkey", jSONObject.getString("k"));
            d.setRequestProperty("mtj_appversion", jSONObject.getString("n"));
            d.setRequestProperty("mtj_os", jSONObject.getString(Config.OS));
            d.setRequestProperty("mtj_pn", jSONObject.getString(Config.PACKAGE_NAME));
            d.setRequestProperty("mtj_tg", jSONObject.getString(Config.SDK_TAG));
            d.setRequestProperty("mtj_ii", jSONObject.getString(Config.CUID_SEC));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        d.connect();
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new GZIPOutputStream(d.getOutputStream())));
            bufferedWriter.write(str2);
            bufferedWriter.flush();
            bufferedWriter.close();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(d.getInputStream()));
            StringBuilder sb = new StringBuilder();
            for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                sb.append(readLine);
            }
            int contentLength = d.getContentLength();
            if (d.getResponseCode() != 200 || contentLength != 0) {
                throw new IOException("http code = " + d.getResponseCode() + "; contentResponse = " + ((Object) sb));
            }
            return sb.toString();
        } finally {
            d.disconnect();
        }
    }

    private String e(Context context, String str, String str2) throws Exception {
        HttpURLConnection d = bo.d(context, str);
        d.setDoOutput(true);
        d.setInstanceFollowRedirects(false);
        d.setUseCaches(false);
        d.setRequestProperty("Content-Type", "gzip");
        byte[] a2 = bm.a.a();
        byte[] b = bm.a.b();
        d.setRequestProperty("key", bv.a(a2));
        d.setRequestProperty("iv", bv.a(b));
        byte[] a3 = bm.a.a(a2, b, str2.getBytes("utf-8"));
        d.connect();
        try {
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(d.getOutputStream());
            gZIPOutputStream.write(a3);
            gZIPOutputStream.flush();
            gZIPOutputStream.close();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(d.getInputStream()));
            StringBuilder sb = new StringBuilder();
            for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                sb.append(readLine);
            }
            int contentLength = d.getContentLength();
            if (d.getResponseCode() != 200 || contentLength != 0) {
                throw new IOException("http code = " + d.getResponseCode() + "; contentResponse = " + ((Object) sb));
            }
            return sb.toString();
        } finally {
            d.disconnect();
        }
    }
}
