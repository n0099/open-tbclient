package com.baidu.sofire.utility;

import android.accounts.NetworkErrorException;
import android.content.Context;
import com.baidu.searchbox.config.AppConfig;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.apache.http.conn.ssl.SSLSocketFactory;
/* loaded from: classes2.dex */
public class q {

    /* renamed from: b  reason: collision with root package name */
    public static final byte[] f10436b = new byte[1024];

    /* renamed from: c  reason: collision with root package name */
    public static OkHttpClient f10437c;

    /* renamed from: a  reason: collision with root package name */
    public Context f10438a;

    public q(Context context) {
        this.f10438a = context;
    }

    private OkHttpClient a() {
        if (f10437c == null) {
            synchronized (q.class) {
                if (f10437c == null) {
                    OkHttpClient.Builder builder = new OkHttpClient.Builder();
                    builder.hostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
                    builder.connectTimeout(AppConfig.TIMESTAMP_AVAILABLE_DURATION, TimeUnit.MILLISECONDS);
                    builder.addInterceptor(new Interceptor() { // from class: com.baidu.sofire.utility.q.1
                        @Override // okhttp3.Interceptor
                        public final Response intercept(Interceptor.Chain chain) throws IOException {
                            System.currentTimeMillis();
                            Response proceed = chain.proceed(chain.request());
                            System.currentTimeMillis();
                            return proceed;
                        }
                    });
                    f10437c = builder.build();
                }
            }
        }
        return f10437c;
    }

    private Request b(String str, byte[] bArr) {
        try {
            MediaType parse = MediaType.parse("application/x-www-form-urlencoded; charset=utf-8");
            String str2 = c.g(this.f10438a)[0];
            Request.Builder url = new Request.Builder().url(str);
            if (bArr != null) {
                url.post(RequestBody.create(parse, bArr));
            }
            Request.Builder addHeader = url.addHeader("User-Agent", "eos/" + str2 + "/" + z.a(this.f10438a) + "/3.5.8.6").addHeader("Pragma", "no-cache").addHeader("Accept", "*/*");
            return addHeader.addHeader("Accept-Language", Locale.getDefault().getLanguage() + "-" + Locale.getDefault().getCountry()).addHeader("x-device-id", o.a(e.b(this.f10438a))).build();
        } catch (Throwable unused) {
            c.a();
            return null;
        }
    }

    public final String a(String str, byte[] bArr) {
        try {
            if (s.m(this.f10438a)) {
                Response execute = a().newCall(b(str, bArr)).execute();
                int code = execute.code();
                if (code == 200) {
                    return execute.body().string();
                }
                throw new NetworkErrorException(String.valueOf(code));
            }
            throw new NetworkErrorException("Not allow background connect.");
        } catch (Throwable unused) {
            c.a();
            return "";
        }
    }

    public final boolean a(String str, File file) {
        try {
            if (s.m(this.f10438a)) {
                Response execute = a().newCall(new Request.Builder().url(str).build()).execute();
                int code = execute.code();
                if (code == 200) {
                    InputStream byteStream = execute.body().byteStream();
                    boolean a2 = a(byteStream, file);
                    byteStream.close();
                    return a2;
                }
                throw new NetworkErrorException(String.valueOf(code));
            }
            throw new NetworkErrorException("Not allow background connect.");
        } catch (Throwable unused) {
            c.a();
            return false;
        }
    }

    public static boolean a(InputStream inputStream, File file) {
        if (inputStream == null) {
            return false;
        }
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
            while (true) {
                int read = inputStream.read(f10436b);
                if (read != -1) {
                    bufferedOutputStream.write(f10436b, 0, read);
                    bufferedOutputStream.flush();
                } else {
                    bufferedOutputStream.flush();
                    bufferedOutputStream.close();
                    return true;
                }
            }
        } catch (Throwable unused) {
            c.a();
            return false;
        }
    }

    public static boolean a(Context context) {
        return context.getPackageName().contains("com.baidu.searchbox");
    }
}
