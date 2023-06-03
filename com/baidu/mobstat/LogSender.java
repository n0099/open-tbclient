package com.baidu.mobstat;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.baidu.mobstat.bl;
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
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.zip.GZIPOutputStream;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class LogSender {
    public static LogSender a = new LogSender();
    public boolean b = false;
    public int c = 0;
    public int d = 1;
    public SendStrategyEnum e = SendStrategyEnum.APP_START;
    public Timer f;
    public Handler g;

    /* loaded from: classes3.dex */
    public class a implements Callable<Object> {
        public Context b;
        public String c;
        public String d;
        public boolean e;

        public a(Context context, String str, String str2, boolean z) {
            this.b = context;
            this.d = str;
            this.c = str2;
            this.e = z;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            boolean z;
            if (LogSender.this.a(this.b, this.c, this.e)) {
                bn.b(this.b, this.d);
                z = true;
            } else {
                LogSender.b(this.b, this.d, this.c);
                z = false;
            }
            return Boolean.valueOf(z);
        }
    }

    public LogSender() {
        HandlerThread handlerThread = new HandlerThread("LogSenderThread");
        handlerThread.start();
        this.g = new Handler(handlerThread.getLooper());
    }

    public static LogSender instance() {
        return a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context, String str) {
        String str2 = Config.PREFIX_SEND_DATA + System.currentTimeMillis();
        bn.a(context, str2, str, false);
        if (c(context, str)) {
            bn.b(context, str2);
        } else {
            b(context, str2, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(Context context, String str) {
        return a(context, str, false);
    }

    public void sendEmptyLogData(Context context, final String str) {
        final Context applicationContext = context.getApplicationContext();
        this.g.post(new Runnable() { // from class: com.baidu.mobstat.LogSender.7
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

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<String> a(Context context, final String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        if (context == null) {
            return arrayList;
        }
        File filesDir = context.getFilesDir();
        if (filesDir != null && filesDir.exists()) {
            FilenameFilter filenameFilter = new FilenameFilter() { // from class: com.baidu.mobstat.LogSender.3
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
            JSONObject jSONObject2 = (JSONObject) jSONObject.get("trace");
            jSONObject2.put(Config.TRACE_FAILED_CNT, jSONObject2.getLong(Config.TRACE_FAILED_CNT) + 1);
        } catch (Exception unused2) {
        }
        bn.a(context, str, jSONObject.toString(), false);
    }

    private String c(Context context, String str, String str2) throws Exception {
        if (!str.startsWith("https://")) {
            return e(context, str, str2);
        }
        return d(context, str, str2);
    }

    public void saveLogData(Context context, String str, boolean z) {
        String str2;
        if (z) {
            str2 = Config.PREFIX_SEND_DATA_FULL;
        } else {
            str2 = Config.PREFIX_SEND_DATA;
        }
        bn.a(context, str2 + System.currentTimeMillis(), str, false);
        if (z) {
            a(context, Config.FULL_TRACE_LOG_LIMIT, Config.PREFIX_SEND_DATA_FULL);
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

    public void onSend(final Context context) {
        if (context != null) {
            context = context.getApplicationContext();
        }
        if (context == null) {
            return;
        }
        this.g.post(new Runnable() { // from class: com.baidu.mobstat.LogSender.1
            @Override // java.lang.Runnable
            public void run() {
                if (LogSender.this.f != null) {
                    LogSender.this.f.cancel();
                    LogSender.this.f = null;
                }
                LogSender.this.e = SendStrategyEnum.values()[bp.a().b(context)];
                LogSender.this.d = bp.a().c(context);
                LogSender.this.b = bp.a().d(context);
                if (LogSender.this.e.equals(SendStrategyEnum.SET_TIME_INTERVAL)) {
                    LogSender.this.setSendingLogTimer(context);
                } else if (LogSender.this.e.equals(SendStrategyEnum.ONCE_A_DAY)) {
                    LogSender.this.setSendingLogTimer(context);
                }
                LogSender.this.g.postDelayed(new Runnable() { // from class: com.baidu.mobstat.LogSender.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        LogSender.this.a(context);
                    }
                }, LogSender.this.c * 1000);
            }
        });
    }

    public void setLogSenderDelayed(int i) {
        if (i >= 0 && i <= 30) {
            this.c = i;
        }
    }

    public void setSendingLogTimer(Context context) {
        final Context applicationContext = context.getApplicationContext();
        long j = this.d * 3600000;
        try {
            Timer timer = new Timer();
            this.f = timer;
            timer.schedule(new TimerTask() { // from class: com.baidu.mobstat.LogSender.2
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    LogSender.this.a(applicationContext);
                }
            }, j, j);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final Context context) {
        if (this.b && !bw.o(context)) {
            return;
        }
        this.g.post(new Runnable() { // from class: com.baidu.mobstat.LogSender.5
            @Override // java.lang.Runnable
            public void run() {
                String str;
                try {
                    ArrayList arrayList = new ArrayList();
                    arrayList.addAll(LogSender.this.a(context, Config.PREFIX_SEND_DATA));
                    arrayList.addAll(LogSender.this.a(context, Config.PREFIX_SEND_DATA_FULL));
                    Iterator it = arrayList.iterator();
                    while (true) {
                        int i = 0;
                        while (it.hasNext()) {
                            str = (String) it.next();
                            String a2 = bn.a(context, str);
                            if (TextUtils.isEmpty(a2)) {
                                bn.b(context, str);
                            } else {
                                if (LogSender.this.a(context, a2, str.contains(Config.PREFIX_SEND_DATA_FULL))) {
                                    break;
                                }
                                LogSender.b(context, str, a2);
                                i++;
                                if (i >= 5) {
                                    return;
                                }
                            }
                        }
                        return;
                        bn.b(context, str);
                    }
                } catch (Exception unused) {
                }
            }
        });
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
        for (int i = 0; i <= size; i++) {
            bn.b(context, a2.get(i));
        }
        fileInputStream = null;
        if (j2 <= j) {
            size--;
        } else {
            while (i <= size) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(Context context, String str, boolean z) {
        String str2;
        if (!z) {
            bb.c().a("Start send log \n" + str);
        }
        boolean z2 = false;
        if (this.b && !bw.o(context)) {
            bb.c().a("[WARNING] wifi not available, log will be cached, next time will try to resend");
            return false;
        }
        String str3 = Config.LOG_SEND_URL;
        if (z) {
            str3 = Config.LOG_FULL_SEND_URL;
        }
        try {
            c(context, str3, str);
            z2 = true;
        } catch (Exception e) {
            bb.c().c(e);
        }
        if (!z) {
            if (z2) {
                str2 = "success";
            } else {
                str2 = "failed";
            }
            bb.c().a("Send log " + str2);
        }
        return z2;
    }

    private String d(Context context, String str, String str2) throws IOException {
        HttpURLConnection d = bn.d(context, str);
        d.setDoOutput(true);
        d.setInstanceFollowRedirects(false);
        d.setUseCaches(false);
        d.setRequestProperty("Content-Type", "gzip");
        try {
            JSONObject jSONObject = new JSONObject(str2).getJSONObject(Config.HEADER_PART);
            d.setRequestProperty("mtj_appkey", jSONObject.getString("k"));
            d.setRequestProperty("mtj_appversion", jSONObject.getString("n"));
            d.setRequestProperty("mtj_os", jSONObject.getString("o"));
            d.setRequestProperty("mtj_pn", jSONObject.getString("pn"));
            d.setRequestProperty("mtj_tg", jSONObject.getString(Config.SDK_TAG));
            d.setRequestProperty("mtj_ii", jSONObject.getString(Config.CUID_SEC));
            d.setRequestProperty("from", jSONObject.getString("from"));
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
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
            }
            int contentLength = d.getContentLength();
            if (d.getResponseCode() == 200 && contentLength == 0) {
                return sb.toString();
            }
            throw new IOException("http code = " + d.getResponseCode() + "; contentResponse = " + ((Object) sb));
        } finally {
            d.disconnect();
        }
    }

    private String e(Context context, String str, String str2) throws Exception {
        HttpURLConnection d = bn.d(context, str);
        d.setDoOutput(true);
        d.setInstanceFollowRedirects(false);
        d.setUseCaches(false);
        d.setRequestProperty("Content-Type", "gzip");
        byte[] a2 = bl.a.a();
        byte[] b = bl.a.b();
        d.setRequestProperty("key", bv.a(a2));
        d.setRequestProperty("iv", bv.a(b));
        byte[] a3 = bl.a.a(a2, b, str2.getBytes("utf-8"));
        d.connect();
        try {
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(d.getOutputStream());
            gZIPOutputStream.write(a3);
            gZIPOutputStream.flush();
            gZIPOutputStream.close();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(d.getInputStream()));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
            }
            int contentLength = d.getContentLength();
            if (d.getResponseCode() == 200 && contentLength == 0) {
                return sb.toString();
            }
            throw new IOException("http code = " + d.getResponseCode() + "; contentResponse = " + ((Object) sb));
        } finally {
            d.disconnect();
        }
    }

    public void sendLogDataWithSyn(Context context) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(a(context, Config.PREFIX_SEND_DATA));
        int size = arrayList.size();
        if (size == 0) {
            return;
        }
        if (size > 20) {
            size = 20;
        }
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(size);
        ArrayList<Future> arrayList2 = new ArrayList();
        for (int i = 0; i < size; i++) {
            arrayList2.add(newFixedThreadPool.submit(new a(context, (String) arrayList.get(i), bn.a(context, (String) arrayList.get(i)), ((String) arrayList.get(i)).contains(Config.PREFIX_SEND_DATA_FULL))));
        }
        newFixedThreadPool.shutdown();
        for (Future future : arrayList2) {
            try {
                future.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void setSendLogStrategy(Context context, SendStrategyEnum sendStrategyEnum, int i, boolean z) {
        if (sendStrategyEnum.equals(SendStrategyEnum.SET_TIME_INTERVAL)) {
            if (i > 0 && i <= 24) {
                this.d = i;
                this.e = SendStrategyEnum.SET_TIME_INTERVAL;
                bp.a().a(context, this.e.ordinal());
                bp.a().b(context, this.d);
            }
        } else {
            this.e = sendStrategyEnum;
            bp.a().a(context, this.e.ordinal());
            if (sendStrategyEnum.equals(SendStrategyEnum.ONCE_A_DAY)) {
                bp.a().b(context, 24);
            }
        }
        this.b = z;
        bp.a().a(context, this.b);
    }
}
