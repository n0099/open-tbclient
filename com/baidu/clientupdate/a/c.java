package com.baidu.clientupdate.a;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.util.LogUtil;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c extends Thread {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ b a;

    /* renamed from: b  reason: collision with root package name */
    public final CharSequence f31972b;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f31973c;

    public c(b bVar, CharSequence charSequence, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, charSequence, bArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = bVar;
        this.f31973c = null;
        this.f31972b = charSequence;
        this.f31973c = bArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        Throwable th;
        HttpURLConnection httpURLConnection;
        Exception e2;
        com.baidu.clientupdate.download.a aVar;
        com.baidu.clientupdate.download.a aVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            HttpURLConnection httpURLConnection2 = null;
            try {
                try {
                    httpURLConnection = (HttpURLConnection) new URL(this.f31972b.toString()).openConnection();
                    try {
                        httpURLConnection.setConnectTimeout(5000);
                        httpURLConnection.setRequestMethod("POST");
                        httpURLConnection.setDoInput(true);
                        httpURLConnection.setDoOutput(true);
                        httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                        httpURLConnection.setRequestProperty("Content-Length", String.valueOf(this.f31973c.length));
                        OutputStream outputStream = httpURLConnection.getOutputStream();
                        outputStream.write(this.f31973c, 0, this.f31973c.length);
                        outputStream.close();
                    } catch (Exception e3) {
                        e2 = e3;
                        e2.printStackTrace();
                        if (httpURLConnection == null) {
                            return;
                        }
                        httpURLConnection.disconnect();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (0 != 0) {
                        httpURLConnection2.disconnect();
                    }
                    throw th;
                }
            } catch (Exception e4) {
                httpURLConnection = null;
                e2 = e4;
            } catch (Throwable th3) {
                th = th3;
                if (0 != 0) {
                }
                throw th;
            }
            if (httpURLConnection.getResponseCode() == 200) {
                InputStream inputStream = httpURLConnection.getInputStream();
                StringBuilder sb = new StringBuilder();
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    sb.append(new String(bArr, 0, read, "utf-8"));
                }
                inputStream.close();
                LogUtil.logE("LogRequest", "**********strResult:" + sb.toString());
                if (new JSONObject(sb.toString()).getString("retcode").equals("1")) {
                    aVar2 = this.a.f31971c;
                    aVar2.c();
                    if (httpURLConnection == null) {
                        return;
                    }
                    httpURLConnection.disconnect();
                }
                aVar = this.a.f31971c;
            } else {
                LogUtil.logE("LogRequest", "request failed  " + httpURLConnection.getResponseCode());
                aVar = this.a.f31971c;
            }
            aVar.e();
            if (httpURLConnection == null) {
            }
            httpURLConnection.disconnect();
        }
    }
}
