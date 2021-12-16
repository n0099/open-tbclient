package com.baidu.mobstat;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobstat.bm;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes10.dex */
public class s {
    public static /* synthetic */ Interceptable $ic;
    public static String a;

    /* renamed from: b  reason: collision with root package name */
    public static s f37995b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public Handler f37996c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1366709679, "Lcom/baidu/mobstat/s;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1366709679, "Lcom/baidu/mobstat/s;");
                return;
            }
        }
        a = Build.VERSION.SDK_INT < 9 ? "http://openrcv.baidu.com/1010/bplus.gif" : "https://openrcv.baidu.com/1010/bplus.gif";
    }

    public s() {
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
        HandlerThread handlerThread = new HandlerThread(com.baidu.fsg.base.statistics.n.a);
        handlerThread.start();
        this.f37996c = new Handler(handlerThread.getLooper());
    }

    private boolean b(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, this, context, str)) == null) {
            if (context != null && !TextUtils.isEmpty(str)) {
                if (!bw.c().booleanValue()) {
                    return true;
                }
                try {
                    a(context, a, str);
                    return true;
                } catch (Exception e2) {
                    bb.c().c(e2);
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static s a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f37995b == null) {
                synchronized (s.class) {
                    if (f37995b == null) {
                        f37995b = new s();
                    }
                }
            }
            return f37995b;
        }
        return (s) invokeV.objValue;
    }

    public void a(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, str) == null) {
            bb c2 = bb.c();
            c2.a("data = " + str);
            if (str == null || "".equals(str)) {
                return;
            }
            this.f37996c.post(new Runnable(this, str, context) { // from class: com.baidu.mobstat.s.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ String a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ Context f37997b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ s f37998c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str, context};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f37998c = this;
                    this.a = str;
                    this.f37997b = context;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            this.f37998c.a(this.a);
                            if (this.f37997b == null) {
                                return;
                            }
                            this.f37998c.a(this.f37997b.getApplicationContext());
                        } catch (Throwable th) {
                            bb.c().b(th);
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, str) == null) {
            bo.a("backups/system" + File.separator + "__send_log_data_" + System.currentTimeMillis(), str, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context) {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, context) == null) && "mounted".equals(bo.a())) {
            File file = new File(Environment.getExternalStorageDirectory(), "backups/system");
            if (!file.exists() || (listFiles = file.listFiles()) == null || listFiles.length == 0) {
                return;
            }
            try {
                Arrays.sort(listFiles, new Comparator<File>(this) { // from class: com.baidu.mobstat.s.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ s a;

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
                    public int compare(File file2, File file3) {
                        InterceptResult invokeLL;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, file2, file3)) == null) ? (int) (file3.lastModified() - file2.lastModified()) : invokeLL.intValue;
                    }
                });
            } catch (Exception e2) {
                bb.c().b(e2);
            }
            int i2 = 0;
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    String name = file2.getName();
                    if (!TextUtils.isEmpty(name) && name.startsWith("__send_log_data_")) {
                        String str = "backups/system" + File.separator + name;
                        String b2 = bo.b(str);
                        if (b(context, b2)) {
                            bo.c(str);
                            i2 = 0;
                        } else {
                            a(b2, str);
                            i2++;
                            if (i2 >= 5) {
                                return;
                            }
                        }
                    }
                }
            }
        }
    }

    private void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65544, this, str, str2) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        JSONObject jSONObject = null;
        try {
            jSONObject = new JSONObject(str);
        } catch (Exception unused) {
        }
        JSONObject a2 = h.a(jSONObject);
        if (a2 != null) {
            h.b(a2);
            bo.a(str2, jSONObject.toString(), false);
        }
    }

    private String a(Context context, String str, String str2) throws IOException {
        InterceptResult invokeLLL;
        byte[] bytes;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLL = interceptable.invokeLLL(65539, this, context, str, str2)) != null) {
            return (String) invokeLLL.objValue;
        }
        boolean z = !str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_HTTPS);
        HttpURLConnection d2 = bo.d(context, str);
        d2.setDoOutput(true);
        d2.setInstanceFollowRedirects(false);
        d2.setUseCaches(false);
        d2.setRequestProperty("Content-Encoding", "gzip");
        try {
            JSONObject jSONObject = new JSONObject(str2).getJSONArray("payload").getJSONObject(0).getJSONObject("he");
            d2.setRequestProperty("Content-Type", "gzip");
            d2.setRequestProperty("mtj_appversion", jSONObject.getString("n"));
            d2.setRequestProperty("mtj_os", "Android");
            d2.setRequestProperty("mtj_pn", jSONObject.getString("pn"));
            d2.setRequestProperty("mtj_tg", "1");
            d2.setRequestProperty("mtj_ii", jSONObject.getString("ii"));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        d2.connect();
        try {
            try {
                OutputStream outputStream = d2.getOutputStream();
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
                int responseCode = d2.getResponseCode();
                int contentLength = d2.getContentLength();
                bb.c().c("code: " + responseCode + "; len: " + contentLength);
                if (responseCode == 200 && contentLength == 0) {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(d2.getInputStream()));
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            return sb.toString();
                        }
                        sb.append(readLine);
                    }
                } else {
                    throw new IOException("Response code = " + d2.getResponseCode());
                }
            } catch (Exception e3) {
                bb.c().b(e3);
                d2.disconnect();
                return "";
            }
        } finally {
            d2.disconnect();
        }
    }

    public static byte[] a(long j2, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{Long.valueOf(j2), Integer.valueOf(i2)})) == null) {
            byte[] bArr = new byte[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                bArr[(i2 - i3) - 1] = (byte) (255 & j2);
                j2 >>= 8;
            }
            return bArr;
        }
        return (byte[]) invokeCommon.objValue;
    }
}
