package c.p.a;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HttpsURLConnection;
/* loaded from: classes7.dex */
public class t1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public URL a;

    /* renamed from: b  reason: collision with root package name */
    public byte[] f30927b;

    /* renamed from: c  reason: collision with root package name */
    public Map f30928c;

    /* renamed from: d  reason: collision with root package name */
    public Map f30929d;

    /* renamed from: e  reason: collision with root package name */
    public String f30930e;

    /* renamed from: f  reason: collision with root package name */
    public int f30931f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f30932g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f30933h;

    /* renamed from: i  reason: collision with root package name */
    public int f30934i;

    /* renamed from: j  reason: collision with root package name */
    public int f30935j;

    public t1(String str, String str2, Map map) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, map};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f30930e = "GET";
        this.f30931f = -1;
        this.f30932g = false;
        this.f30933h = true;
        this.a = new URL(str);
        this.f30930e = str2;
        this.f30928c = map;
        this.f30934i = 20000;
        this.f30935j = 20000;
    }

    public w1 a() {
        InterceptResult invokeV;
        HttpURLConnection httpURLConnection;
        InputStream errorStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            String url = this.a.toString();
            if (!TextUtils.isEmpty(url) ? url.startsWith("http") : false) {
                httpURLConnection = (HttpURLConnection) this.a.openConnection();
            } else {
                httpURLConnection = (HttpsURLConnection) this.a.openConnection();
            }
            httpURLConnection.setRequestMethod(this.f30930e);
            httpURLConnection.setInstanceFollowRedirects(this.f30933h);
            httpURLConnection.setReadTimeout(this.f30935j);
            httpURLConnection.setConnectTimeout(this.f30934i);
            httpURLConnection.setDoInput(true);
            Map map = this.f30928c;
            if (map != null && map.size() > 0) {
                for (Map.Entry entry : map.entrySet()) {
                    String str = (String) entry.getKey();
                    for (String str2 : (List) entry.getValue()) {
                        String str3 = "header:" + str + "=" + str2;
                        httpURLConnection.setRequestProperty(str, str2);
                    }
                }
            }
            if (this.f30930e.equals("POST")) {
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                PrintWriter printWriter = null;
                PrintWriter printWriter2 = null;
                try {
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    byte[] bArr = this.f30927b;
                    if (bArr == null) {
                        PrintWriter printWriter3 = new PrintWriter((Writer) new OutputStreamWriter(outputStream, "UTF-8"), true);
                        try {
                            URL url2 = this.a;
                            printWriter3.print(url2 != null ? url2.getQuery() : null);
                            printWriter3.flush();
                            printWriter2 = printWriter3;
                        } catch (Throwable th) {
                            th = th;
                            printWriter = printWriter3;
                            if (printWriter != null) {
                                printWriter.close();
                            }
                            throw th;
                        }
                    } else {
                        outputStream.write(bArr);
                        outputStream.flush();
                    }
                    if (printWriter2 != null) {
                        printWriter2.close();
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            this.f30931f = httpURLConnection.getResponseCode();
            httpURLConnection.getContentLength();
            if (httpURLConnection.getHeaderFields() != null) {
                this.f30929d = httpURLConnection.getHeaderFields();
            }
            try {
                String contentEncoding = httpURLConnection.getContentEncoding();
                errorStream = (contentEncoding == null || !contentEncoding.contains("gzip")) ? httpURLConnection.getInputStream() : new GZIPInputStream(httpURLConnection.getInputStream());
            } catch (IOException e2) {
                errorStream = httpURLConnection.getErrorStream();
                if (errorStream == null) {
                    throw new RuntimeException("InputStream is error: " + e2.getMessage());
                }
            }
            BufferedInputStream bufferedInputStream = new BufferedInputStream(errorStream);
            byte[] bArr2 = new byte[4096];
            int i2 = 0;
            while (!this.f30932g && i2 != -1) {
                i2 = bufferedInputStream.read(bArr2);
                if (i2 > 0) {
                    byteArrayOutputStream.write(bArr2, 0, i2);
                }
            }
            httpURLConnection.disconnect();
            byteArrayOutputStream.flush();
            errorStream.close();
            return new w1(this.f30931f, byteArrayOutputStream.toByteArray(), this.f30929d);
        }
        return (w1) invokeV.objValue;
    }
}
