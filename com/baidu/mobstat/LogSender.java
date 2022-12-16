package com.baidu.mobstat;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.bl;
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
/* loaded from: classes2.dex */
public class LogSender {
    public static /* synthetic */ Interceptable $ic;
    public static LogSender a;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean b;
    public int c;
    public int d;
    public SendStrategyEnum e;
    public Timer f;
    public Handler g;

    /* loaded from: classes2.dex */
    public class a implements Callable<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LogSender a;
        public Context b;
        public String c;
        public String d;
        public boolean e;

        public a(LogSender logSender, Context context, String str, String str2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {logSender, context, str, str2, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = logSender;
            this.b = context;
            this.d = str;
            this.c = str2;
            this.e = z;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            InterceptResult invokeV;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.a.a(this.b, this.c, this.e)) {
                    bn.b(this.b, this.d);
                    z = true;
                } else {
                    LogSender.b(this.b, this.d, this.c);
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-59642869, "Lcom/baidu/mobstat/LogSender;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-59642869, "Lcom/baidu/mobstat/LogSender;");
                return;
            }
        }
        a = new LogSender();
    }

    public static LogSender instance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65562, null)) == null) {
            return a;
        }
        return (LogSender) invokeV.objValue;
    }

    public LogSender() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = false;
        this.c = 0;
        this.d = 1;
        this.e = SendStrategyEnum.APP_START;
        HandlerThread handlerThread = new HandlerThread("LogSenderThread");
        handlerThread.start();
        this.g = new Handler(handlerThread.getLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65557, this, context, str)) == null) {
            return a(context, str, false);
        }
        return invokeLL.booleanValue;
    }

    public void sendEmptyLogData(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, str) == null) {
            this.g.post(new Runnable(this, context.getApplicationContext(), str) { // from class: com.baidu.mobstat.LogSender.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Context a;
                public final /* synthetic */ String b;
                public final /* synthetic */ LogSender c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r7, str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.c = this;
                    this.a = r7;
                    this.b = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        String constructLogWithEmptyBody = DataCore.instance().constructLogWithEmptyBody(this.a, this.b);
                        if (TextUtils.isEmpty(constructLogWithEmptyBody)) {
                            return;
                        }
                        this.c.c(this.a, constructLogWithEmptyBody);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<String> a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, context, str)) == null) {
            ArrayList<String> arrayList = new ArrayList<>();
            if (context == null) {
                return arrayList;
            }
            File filesDir = context.getFilesDir();
            if (filesDir != null && filesDir.exists()) {
                FilenameFilter filenameFilter = new FilenameFilter(this, str) { // from class: com.baidu.mobstat.LogSender.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ String a;
                    public final /* synthetic */ LogSender b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, str};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.b = this;
                        this.a = str;
                    }

                    @Override // java.io.FilenameFilter
                    public boolean accept(File file, String str2) {
                        InterceptResult invokeLL2;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeLL2 = interceptable2.invokeLL(1048576, this, file, str2)) == null) {
                            if (str2.startsWith(this.a)) {
                                return true;
                            }
                            return false;
                        }
                        return invokeLL2.booleanValue;
                    }
                };
                String[] strArr = null;
                try {
                    strArr = filesDir.list(filenameFilter);
                } catch (Exception unused) {
                }
                if (strArr != null && strArr.length != 0) {
                    try {
                        Arrays.sort(strArr, new Comparator<String>(this) { // from class: com.baidu.mobstat.LogSender.4
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
                                    int i = newInitContext.flag;
                                    if ((i & 1) != 0) {
                                        int i2 = i & 2;
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
                                if (interceptable2 == null || (invokeLL2 = interceptable2.invokeLL(1048576, this, str2, str3)) == null) {
                                    return str2.compareTo(str3);
                                }
                                return invokeLL2.intValue;
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

    public void sendLogData(Context context, String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLZ(1048579, this, context, str, z) == null) && context != null && !TextUtils.isEmpty(str)) {
            Context applicationContext = context.getApplicationContext();
            if (z) {
                b(applicationContext, str);
            } else {
                this.g.post(new Runnable(this, applicationContext, str) { // from class: com.baidu.mobstat.LogSender.6
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ Context a;
                    public final /* synthetic */ String b;
                    public final /* synthetic */ LogSender c;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, applicationContext, str};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.c = this;
                        this.a = applicationContext;
                        this.b = str;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null && interceptable2.invokeV(1048576, this) != null) {
                            return;
                        }
                        this.c.b(this.a, this.b);
                    }
                });
            }
        }
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
            this.g.post(new Runnable(this, context) { // from class: com.baidu.mobstat.LogSender.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Context a;
                public final /* synthetic */ LogSender b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, context};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.b = this;
                    this.a = context;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (this.b.f != null) {
                            this.b.f.cancel();
                            this.b.f = null;
                        }
                        this.b.e = SendStrategyEnum.values()[bp.a().b(this.a)];
                        this.b.d = bp.a().c(this.a);
                        this.b.b = bp.a().d(this.a);
                        if (this.b.e.equals(SendStrategyEnum.SET_TIME_INTERVAL)) {
                            this.b.setSendingLogTimer(this.a);
                        } else if (this.b.e.equals(SendStrategyEnum.ONCE_A_DAY)) {
                            this.b.setSendingLogTimer(this.a);
                        }
                        this.b.g.postDelayed(new Runnable(this) { // from class: com.baidu.mobstat.LogSender.1.1
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
                                    int i = newInitContext.flag;
                                    if ((i & 1) != 0) {
                                        int i2 = i & 2;
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
                                    anonymousClass1.b.a(anonymousClass1.a);
                                }
                            }
                        }, this.b.c * 1000);
                    }
                }
            });
        }
    }

    public void setLogSenderDelayed(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048581, this, i) == null) && i >= 0 && i <= 30) {
            this.c = i;
        }
    }

    public void setSendingLogTimer(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, context) == null) {
            Context applicationContext = context.getApplicationContext();
            long j = this.d * 3600000;
            try {
                Timer timer = new Timer();
                this.f = timer;
                timer.schedule(new TimerTask(this, applicationContext) { // from class: com.baidu.mobstat.LogSender.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ Context a;
                    public final /* synthetic */ LogSender b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, applicationContext};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.b = this;
                        this.a = applicationContext;
                    }

                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null && interceptable2.invokeV(1048576, this) != null) {
                            return;
                        }
                        this.b.a(this.a);
                    }
                }, j, j);
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, context) == null) {
            if (this.b && !bw.o(context)) {
                return;
            }
            this.g.post(new Runnable(this, context) { // from class: com.baidu.mobstat.LogSender.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Context a;
                public final /* synthetic */ LogSender b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, context};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.b = this;
                    this.a = context;
                }

                @Override // java.lang.Runnable
                public void run() {
                    String str;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            ArrayList arrayList = new ArrayList();
                            arrayList.addAll(this.b.a(this.a, Config.PREFIX_SEND_DATA));
                            arrayList.addAll(this.b.a(this.a, Config.PREFIX_SEND_DATA_FULL));
                            Iterator it = arrayList.iterator();
                            while (true) {
                                int i = 0;
                                while (it.hasNext()) {
                                    str = (String) it.next();
                                    String a2 = bn.a(this.a, str);
                                    if (TextUtils.isEmpty(a2)) {
                                        bn.b(this.a, str);
                                    } else {
                                        if (this.b.a(this.a, a2, str.contains(Config.PREFIX_SEND_DATA_FULL))) {
                                            break;
                                        }
                                        LogSender.b(this.a, str, a2);
                                        i++;
                                        if (i >= 5) {
                                            return;
                                        }
                                    }
                                }
                                return;
                                bn.b(this.a, str);
                            }
                        } catch (Exception unused) {
                        }
                    }
                }
            });
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
    private void a(Context context, long j, String str) {
        int size;
        long j2;
        FileInputStream fileInputStream;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65545, this, new Object[]{context, Long.valueOf(j), str}) == null) {
            ArrayList<String> a2 = a(context, str);
            size = a2.size() - 1;
            j2 = 0;
            fileInputStream = null;
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
            for (i = 0; i <= size; i++) {
                bn.b(context, a2.get(i));
            }
        }
        return;
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
        InterceptResult invokeLLZ;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65548, this, context, str, z)) == null) {
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
                    str2 = com.alipay.sdk.util.f.j;
                }
                bb.c().a("Send log " + str2);
            }
            return z2;
        }
        return invokeLLZ.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65552, this, context, str) == null) {
            String str2 = Config.PREFIX_SEND_DATA + System.currentTimeMillis();
            bn.a(context, str2, str, false);
            if (c(context, str)) {
                bn.b(context, str2);
            } else {
                b(context, str2, str);
            }
        }
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
                JSONObject jSONObject2 = (JSONObject) jSONObject.get(Config.TRACE_PART);
                jSONObject2.put(Config.TRACE_FAILED_CNT, jSONObject2.getLong(Config.TRACE_FAILED_CNT) + 1);
            } catch (Exception unused2) {
            }
            bn.a(context, str, jSONObject.toString(), false);
        }
    }

    public void saveLogData(Context context, String str, boolean z) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str, z) == null) {
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
    }

    private String d(Context context, String str, String str2) throws IOException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65560, this, context, str, str2)) == null) {
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
        return (String) invokeLLL.objValue;
    }

    private String e(Context context, String str, String str2) throws Exception {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65561, this, context, str, str2)) == null) {
            HttpURLConnection d = bn.d(context, str);
            d.setDoOutput(true);
            d.setInstanceFollowRedirects(false);
            d.setUseCaches(false);
            d.setRequestProperty("Content-Type", "gzip");
            byte[] a2 = bl.a.a();
            byte[] b = bl.a.b();
            d.setRequestProperty("key", bv.a(a2));
            d.setRequestProperty("iv", bv.a(b));
            byte[] a3 = bl.a.a(a2, b, str2.getBytes(IMAudioTransRequest.CHARSET));
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
        return (String) invokeLLL.objValue;
    }

    public void sendLogDataWithSyn(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, context) == null) {
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
                arrayList2.add(newFixedThreadPool.submit(new a(this, context, (String) arrayList.get(i), bn.a(context, (String) arrayList.get(i)), ((String) arrayList.get(i)).contains(Config.PREFIX_SEND_DATA_FULL))));
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
    }

    public void setSendLogStrategy(Context context, SendStrategyEnum sendStrategyEnum, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{context, sendStrategyEnum, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
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
}
