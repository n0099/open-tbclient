package com.baidu.mobstat.dxmpay;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.dxmpay.m;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes10.dex */
public class LogSender {
    public static /* synthetic */ Interceptable $ic;
    public static LogSender a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public boolean f37020b;

    /* renamed from: c  reason: collision with root package name */
    public int f37021c;

    /* renamed from: d  reason: collision with root package name */
    public int f37022d;

    /* renamed from: e  reason: collision with root package name */
    public SendStrategyEnum f37023e;

    /* renamed from: f  reason: collision with root package name */
    public Timer f37024f;

    /* renamed from: g  reason: collision with root package name */
    public Handler f37025g;

    /* loaded from: classes10.dex */
    public class a implements Callable<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LogSender a;

        /* renamed from: b  reason: collision with root package name */
        public Context f37034b;

        /* renamed from: c  reason: collision with root package name */
        public String f37035c;

        /* renamed from: d  reason: collision with root package name */
        public String f37036d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f37037e;

        public a(LogSender logSender, Context context, String str, String str2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {logSender, context, str, str2, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = logSender;
            this.f37034b = context;
            this.f37036d = str;
            this.f37035c = str2;
            this.f37037e = z;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            InterceptResult invokeV;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.a.a(this.f37034b, this.f37035c, this.f37037e)) {
                    o.b(this.f37034b, this.f37036d);
                    z = true;
                } else {
                    LogSender.b(this.f37034b, this.f37036d, this.f37035c);
                    z = false;
                }
                return Boolean.valueOf(z);
            }
            return invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1895732217, "Lcom/baidu/mobstat/dxmpay/LogSender;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1895732217, "Lcom/baidu/mobstat/dxmpay/LogSender;");
                return;
            }
        }
        a = new LogSender();
    }

    public LogSender() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f37020b = false;
        this.f37021c = 0;
        this.f37022d = 1;
        this.f37023e = SendStrategyEnum.APP_START;
        HandlerThread handlerThread = new HandlerThread("LogSenderThread");
        handlerThread.start();
        this.f37025g = new Handler(handlerThread.getLooper());
    }

    private String e(Context context, String str, String str2) throws Exception {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65561, this, context, str, str2)) == null) {
            HttpURLConnection d2 = o.d(context, str);
            d2.setDoOutput(true);
            d2.setInstanceFollowRedirects(false);
            d2.setUseCaches(false);
            d2.setRequestProperty("Content-Type", "gzip");
            byte[] a2 = m.a.a();
            byte[] b2 = m.a.b();
            d2.setRequestProperty("key", v.a(a2));
            d2.setRequestProperty("iv", v.a(b2));
            byte[] a3 = m.a.a(a2, b2, str2.getBytes("utf-8"));
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
        return (String) invokeLLL.objValue;
    }

    public static LogSender instance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65562, null)) == null) ? a : (LogSender) invokeV.objValue;
    }

    public void onSend(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            if (context != null) {
                context = context.getApplicationContext();
            }
            if (context == null) {
                return;
            }
            this.f37025g.post(new Runnable(this, context) { // from class: com.baidu.mobstat.dxmpay.LogSender.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Context a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ LogSender f37026b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, context};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f37026b = this;
                    this.a = context;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (this.f37026b.f37024f != null) {
                            this.f37026b.f37024f.cancel();
                            this.f37026b.f37024f = null;
                        }
                        this.f37026b.f37023e = SendStrategyEnum.values()[q.a().b(this.a)];
                        this.f37026b.f37022d = q.a().c(this.a);
                        this.f37026b.f37020b = q.a().d(this.a);
                        if (!this.f37026b.f37023e.equals(SendStrategyEnum.SET_TIME_INTERVAL)) {
                            if (this.f37026b.f37023e.equals(SendStrategyEnum.ONCE_A_DAY)) {
                                this.f37026b.setSendingLogTimer(this.a);
                            }
                        } else {
                            this.f37026b.setSendingLogTimer(this.a);
                        }
                        this.f37026b.f37025g.postDelayed(new Runnable(this) { // from class: com.baidu.mobstat.dxmpay.LogSender.1.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AnonymousClass1 a;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.a = this;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    AnonymousClass1 anonymousClass1 = this.a;
                                    anonymousClass1.f37026b.a(anonymousClass1.a);
                                }
                            }
                        }, this.f37026b.f37021c * 1000);
                    }
                }
            });
        }
    }

    public void saveLogData(Context context, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str, z) == null) {
            String str2 = z ? Config.PREFIX_SEND_DATA_FULL : Config.PREFIX_SEND_DATA;
            o.a(context, str2 + System.currentTimeMillis(), str, false);
            if (z) {
                a(context, 10485760L, Config.PREFIX_SEND_DATA_FULL);
            }
        }
    }

    public void sendEmptyLogData(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, str) == null) {
            this.f37025g.post(new Runnable(this, context.getApplicationContext(), str) { // from class: com.baidu.mobstat.dxmpay.LogSender.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Context a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ String f37032b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ LogSender f37033c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r7, str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f37033c = this;
                    this.a = r7;
                    this.f37032b = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        String constructLogWithEmptyBody = DataCore.instance().constructLogWithEmptyBody(this.a, this.f37032b);
                        if (TextUtils.isEmpty(constructLogWithEmptyBody)) {
                            return;
                        }
                        this.f37033c.c(this.a, constructLogWithEmptyBody);
                    }
                }
            });
        }
    }

    public void sendLogData(Context context, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(1048579, this, context, str, z) == null) || context == null || TextUtils.isEmpty(str)) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        if (z) {
            b(applicationContext, str);
        } else {
            this.f37025g.post(new Runnable(this, applicationContext, str) { // from class: com.baidu.mobstat.dxmpay.LogSender.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Context a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ String f37030b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ LogSender f37031c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, applicationContext, str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f37031c = this;
                    this.a = applicationContext;
                    this.f37030b = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f37031c.b(this.a, this.f37030b);
                    }
                }
            });
        }
    }

    public void setLogSenderDelayed(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048580, this, i2) == null) || i2 < 0 || i2 > 30) {
            return;
        }
        this.f37021c = i2;
    }

    public void setSendLogStrategy(Context context, SendStrategyEnum sendStrategyEnum, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{context, sendStrategyEnum, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            if (!sendStrategyEnum.equals(SendStrategyEnum.SET_TIME_INTERVAL)) {
                this.f37023e = sendStrategyEnum;
                q.a().a(context, this.f37023e.ordinal());
                if (sendStrategyEnum.equals(SendStrategyEnum.ONCE_A_DAY)) {
                    q.a().b(context, 24);
                }
            } else if (i2 > 0 && i2 <= 24) {
                this.f37022d = i2;
                this.f37023e = SendStrategyEnum.SET_TIME_INTERVAL;
                q.a().a(context, this.f37023e.ordinal());
                q.a().b(context, this.f37022d);
            }
            this.f37020b = z;
            q.a().a(context, this.f37020b);
        }
    }

    public void setSendingLogTimer(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, context) == null) {
            Context applicationContext = context.getApplicationContext();
            long j2 = this.f37022d * 3600000;
            try {
                Timer timer = new Timer();
                this.f37024f = timer;
                timer.schedule(new TimerTask(this, applicationContext) { // from class: com.baidu.mobstat.dxmpay.LogSender.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ Context a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ LogSender f37027b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, applicationContext};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f37027b = this;
                        this.a = applicationContext;
                    }

                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.f37027b.a(this.a);
                        }
                    }
                }, j2, j2);
            } catch (Exception unused) {
            }
        }
    }

    public void snedLogDataWithSyn(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, context) == null) {
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
            for (int i2 = 0; i2 < size; i2++) {
                arrayList2.add(newFixedThreadPool.submit(new a(this, context, (String) arrayList.get(i2), o.a(context, (String) arrayList.get(i2)), ((String) arrayList.get(i2)).contains(Config.PREFIX_SEND_DATA_FULL))));
            }
            newFixedThreadPool.shutdown();
            for (Future future : arrayList2) {
                try {
                    future.get();
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                } catch (ExecutionException e3) {
                    e3.printStackTrace();
                }
            }
        }
    }

    private String d(Context context, String str, String str2) throws IOException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65560, this, context, str, str2)) == null) {
            HttpURLConnection d2 = o.d(context, str);
            d2.setDoOutput(true);
            d2.setInstanceFollowRedirects(false);
            d2.setUseCaches(false);
            d2.setRequestProperty("Content-Type", "gzip");
            try {
                JSONObject jSONObject = new JSONObject(str2).getJSONObject("he");
                d2.setRequestProperty("mtj_appkey", jSONObject.getString("k"));
                d2.setRequestProperty("mtj_appversion", jSONObject.getString("n"));
                d2.setRequestProperty("mtj_os", jSONObject.getString("o"));
                d2.setRequestProperty("mtj_pn", jSONObject.getString("pn"));
                d2.setRequestProperty("mtj_tg", jSONObject.getString("tg"));
                d2.setRequestProperty("mtj_ii", jSONObject.getString("ii"));
                d2.setRequestProperty("from", jSONObject.getString("from"));
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
        return (String) invokeLLL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65552, this, context, str) == null) {
            String str2 = Config.PREFIX_SEND_DATA + System.currentTimeMillis();
            o.a(context, str2, str, false);
            if (c(context, str)) {
                o.b(context, str2);
            } else {
                b(context, str2, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65557, this, context, str)) == null) ? a(context, str, false) : invokeLL.booleanValue;
    }

    private String c(Context context, String str, String str2) throws Exception {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65556, this, context, str, str2)) == null) {
            if (!str.startsWith("https://")) {
                return e(context, str, str2);
            }
            return d(context, str, str2);
        }
        return (String) invokeLLL.objValue;
    }

    public static void b(Context context, String str, String str2) {
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65553, null, context, str, str2) == null) {
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
                jSONObject2.put("failed_cnt", jSONObject2.getLong("failed_cnt") + 1);
            } catch (Exception unused2) {
            }
            o.a(context, str, jSONObject.toString(), false);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002f, code lost:
        if (r4 == null) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0031, code lost:
        r4.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0024, code lost:
        if (r4 != null) goto L19;
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0040 A[LOOP:1: B:23:0x003e->B:24:0x0040, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(Context context, long j2, String str) {
        int size;
        long j3;
        FileInputStream fileInputStream;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65545, this, new Object[]{context, Long.valueOf(j2), str}) == null) {
            ArrayList<String> a2 = a(context, str);
            size = a2.size() - 1;
            j3 = 0;
            fileInputStream = null;
            while (size >= 0) {
                try {
                    fileInputStream = context.openFileInput(a2.get(size));
                    j3 += fileInputStream.available();
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
            for (i2 = 0; i2 <= size; i2++) {
                o.b(context, a2.get(i2));
            }
            return;
        }
        return;
        fileInputStream = null;
        if (j3 > j2) {
            while (i2 <= size) {
            }
            return;
        }
        size--;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<String> a(Context context, String str) {
        InterceptResult invokeLL;
        File filesDir;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, context, str)) == null) {
            ArrayList<String> arrayList = new ArrayList<>();
            if (context != null && (filesDir = context.getFilesDir()) != null && filesDir.exists()) {
                FilenameFilter filenameFilter = new FilenameFilter(this, str) { // from class: com.baidu.mobstat.dxmpay.LogSender.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ String a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ LogSender f37028b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, str};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f37028b = this;
                        this.a = str;
                    }

                    @Override // java.io.FilenameFilter
                    public boolean accept(File file, String str2) {
                        InterceptResult invokeLL2;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeLL2 = interceptable2.invokeLL(1048576, this, file, str2)) == null) ? str2.startsWith(this.a) : invokeLL2.booleanValue;
                    }
                };
                String[] strArr = null;
                try {
                    strArr = filesDir.list(filenameFilter);
                } catch (Exception unused) {
                }
                if (strArr != null && strArr.length != 0) {
                    try {
                        Arrays.sort(strArr, new Comparator<String>(this) { // from class: com.baidu.mobstat.dxmpay.LogSender.4
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ LogSender a;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.a = this;
                            }

                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // java.util.Comparator
                            /* renamed from: a */
                            public int compare(String str2, String str3) {
                                InterceptResult invokeLL2;
                                Interceptable interceptable2 = $ic;
                                return (interceptable2 == null || (invokeLL2 = interceptable2.invokeLL(1048576, this, str2, str3)) == null) ? str2.compareTo(str3) : invokeLL2.intValue;
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
        return (ArrayList) invokeLL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, context) == null) {
            if (!this.f37020b || w.h(context)) {
                this.f37025g.post(new Runnable(this, context) { // from class: com.baidu.mobstat.dxmpay.LogSender.5
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ Context a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ LogSender f37029b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, context};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f37029b = this;
                        this.a = context;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        String str;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null && interceptable2.invokeV(1048576, this) != null) {
                            return;
                        }
                        try {
                            ArrayList arrayList = new ArrayList();
                            arrayList.addAll(this.f37029b.a(this.a, Config.PREFIX_SEND_DATA));
                            arrayList.addAll(this.f37029b.a(this.a, Config.PREFIX_SEND_DATA_FULL));
                            Iterator it = arrayList.iterator();
                            while (true) {
                                int i2 = 0;
                                while (it.hasNext()) {
                                    str = (String) it.next();
                                    String a2 = o.a(this.a, str);
                                    if (TextUtils.isEmpty(a2)) {
                                        o.b(this.a, str);
                                    } else {
                                        if (this.f37029b.a(this.a, a2, str.contains(Config.PREFIX_SEND_DATA_FULL))) {
                                            break;
                                        }
                                        LogSender.b(this.a, str, a2);
                                        i2++;
                                        if (i2 >= 5) {
                                            return;
                                        }
                                    }
                                }
                                return;
                                o.b(this.a, str);
                            }
                        } catch (Exception unused) {
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(Context context, String str, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65548, this, context, str, z)) == null) {
            if (!z) {
                h.c().a("Start send log \n" + str);
            }
            boolean z2 = false;
            if (this.f37020b && !w.h(context)) {
                h.c().a("[WARNING] wifi not available, log will be cached, next time will try to resend");
                return false;
            }
            String str2 = Config.LOG_SEND_URL;
            if (z) {
                str2 = "https://hmma.baidu.com/auto.gif";
            }
            try {
                c(context, str2, str);
                z2 = true;
            } catch (Exception e2) {
                h.c().a(e2);
            }
            if (!z) {
                String str3 = z2 ? "success" : com.alipay.sdk.util.f.f31162j;
                h.c().a("Send log " + str3);
            }
            return z2;
        }
        return invokeLLZ.booleanValue;
    }
}
