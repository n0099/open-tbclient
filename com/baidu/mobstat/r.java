package com.baidu.mobstat;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.mobstat.bl;
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
/* loaded from: classes2.dex */
public class r {
    public static /* synthetic */ Interceptable $ic;
    public static String a;
    public static r b;
    public transient /* synthetic */ FieldHolder $fh;
    public Handler c;

    static {
        InterceptResult invokeClinit;
        String str;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1366709710, "Lcom/baidu/mobstat/r;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1366709710, "Lcom/baidu/mobstat/r;");
                return;
            }
        }
        if (Build.VERSION.SDK_INT < 9) {
            str = "http://openrcv.baidu.com/1010/bplus.gif";
        } else {
            str = "https://openrcv.baidu.com/1010/bplus.gif";
        }
        a = str;
    }

    public static r a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (b == null) {
                synchronized (r.class) {
                    if (b == null) {
                        b = new r();
                    }
                }
            }
            return b;
        }
        return (r) invokeV.objValue;
    }

    public r() {
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
        HandlerThread handlerThread = new HandlerThread("LogSender");
        handlerThread.start();
        this.c = new Handler(handlerThread.getLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context) {
        String next;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, context) == null) {
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
    }

    private void a(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, this, context, str, str2) == null) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, this, context, str) == null) {
            bn.a(context, y.f + System.currentTimeMillis(), str, false);
        }
    }

    public static byte[] a(long j, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{Long.valueOf(j), Integer.valueOf(i)})) == null) {
            byte[] bArr = new byte[i];
            for (int i2 = 0; i2 < i; i2++) {
                bArr[(i - i2) - 1] = (byte) (255 & j);
                j >>= 8;
            }
            return bArr;
        }
        return (byte[]) invokeCommon.objValue;
    }

    private boolean d(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, this, context, str)) == null) {
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
        return invokeLL.booleanValue;
    }

    private String b(Context context, String str, String str2) throws IOException {
        InterceptResult invokeLLL;
        byte[] bytes;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65544, this, context, str, str2)) == null) {
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
                } catch (Exception e2) {
                    ba.c().b(e2);
                    d.disconnect();
                    return "";
                }
            } finally {
                d.disconnect();
            }
        } else {
            return (String) invokeLLL.objValue;
        }
    }

    private ArrayList<String> c(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, this, context, str)) == null) {
            ArrayList<String> arrayList = new ArrayList<>();
            if (context == null) {
                return arrayList;
            }
            File filesDir = context.getFilesDir();
            if (filesDir != null && filesDir.exists()) {
                FilenameFilter filenameFilter = new FilenameFilter(this, str) { // from class: com.baidu.mobstat.r.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ String a;
                    public final /* synthetic */ r b;

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
                        Arrays.sort(strArr, new Comparator<String>(this) { // from class: com.baidu.mobstat.r.3
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ r a;

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

    public void a(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, str) == null) {
            ba c = ba.c();
            c.a("data = " + str);
            if (str != null && !"".equals(str)) {
                this.c.post(new Runnable(this, context, str) { // from class: com.baidu.mobstat.r.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ Context a;
                    public final /* synthetic */ String b;
                    public final /* synthetic */ r c;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, context, str};
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
                        this.a = context;
                        this.b = str;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            try {
                                if (this.a == null) {
                                    return;
                                }
                                this.c.b(this.a, this.b);
                                this.c.a(this.a.getApplicationContext());
                            } catch (Throwable th) {
                                ba.c().b(th);
                            }
                        }
                    }
                });
            }
        }
    }
}
