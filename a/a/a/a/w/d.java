package a.a.a.a.w;

import com.baidu.down.loopj.android.http.AsyncHttpClient;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.zip.GZIPInputStream;
/* loaded from: classes.dex */
public abstract class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f1356a;

    /* renamed from: b  reason: collision with root package name */
    public String f1357b;

    /* renamed from: c  reason: collision with root package name */
    public String f1358c;

    /* renamed from: d  reason: collision with root package name */
    public byte[] f1359d;

    public d(String str, e eVar) {
        StringBuilder sb;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, eVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (str == null) {
            throw new IllegalArgumentException("url is null");
        }
        this.f1356a = str;
        if (eVar != null) {
            String str2 = "?";
            if (str.contains("?")) {
                sb = new StringBuilder();
                sb.append(this.f1356a);
                str2 = "&";
            } else {
                sb = new StringBuilder();
                sb.append(this.f1356a);
            }
            sb.append(str2);
            sb.append(eVar.b());
            this.f1356a = sb.toString();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x00ff A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0106 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0078 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public f a() {
        InterceptResult invokeV;
        OutputStream outputStream;
        InputStream inputStream;
        Throwable th;
        OutputStream outputStream2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048576, this)) != null) {
            return (f) invokeV.objValue;
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.f1356a).openConnection();
        InputStream inputStream2 = null;
        try {
            httpURLConnection.setConnectTimeout(30000);
            httpURLConnection.setReadTimeout(8000);
            httpURLConnection.setRequestMethod(this.f1357b);
            httpURLConnection.setDoOutput("POST".equals(this.f1357b) && this.f1359d != null);
            if (this.f1358c != null) {
                httpURLConnection.setRequestProperty("Content-Type", this.f1358c);
            }
            httpURLConnection.setRequestProperty("Accept-Charset", "UTF-8");
            try {
                httpURLConnection.setRequestProperty("user-agent", System.getProperty("http.agent"));
                httpURLConnection.setRequestProperty("Accept-Encoding", "gzip,deflate");
                try {
                    httpURLConnection.connect();
                    if (httpURLConnection.getDoOutput()) {
                        outputStream2 = httpURLConnection.getOutputStream();
                        if (outputStream2 != null) {
                            try {
                                outputStream2.write(this.f1359d);
                                outputStream2.close();
                            } catch (Exception e2) {
                                e = e2;
                                throw new IOException(e);
                            }
                        }
                        inputStream = httpURLConnection.getInputStream();
                        if (inputStream != null) {
                            httpURLConnection.disconnect();
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception unused) {
                                }
                            }
                            if (outputStream2 != null) {
                                try {
                                    outputStream2.close();
                                } catch (Exception unused2) {
                                }
                            }
                            return null;
                        }
                        try {
                            String contentEncoding = httpURLConnection.getContentEncoding();
                            if (contentEncoding != null && AsyncHttpClient.ENCODING_GZIP.equals(contentEncoding.toLowerCase())) {
                                inputStream = new GZIPInputStream(inputStream);
                            }
                            try {
                                byte[] bArr = new byte[16384];
                                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                while (true) {
                                    try {
                                        int read = inputStream.read(bArr);
                                        if (read == -1) {
                                            break;
                                        }
                                        byteArrayOutputStream.write(bArr, 0, read);
                                    } catch (Exception e3) {
                                        throw new IOException(e3);
                                    }
                                }
                                inputStream.close();
                                f fVar = new f(httpURLConnection.getResponseCode(), httpURLConnection.getContentType(), byteArrayOutputStream.toString());
                                httpURLConnection.disconnect();
                                try {
                                    inputStream.close();
                                } catch (Exception unused3) {
                                }
                                if (outputStream2 != null) {
                                    try {
                                        outputStream2.close();
                                    } catch (Exception unused4) {
                                    }
                                }
                                return fVar;
                            } catch (Throwable th2) {
                                th = th2;
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                }
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception unused5) {
                                    }
                                }
                                if (outputStream2 != null) {
                                    try {
                                        outputStream2.close();
                                    } catch (Exception unused6) {
                                    }
                                }
                                throw th;
                            }
                        } catch (Throwable th3) {
                            outputStream = outputStream2;
                            th = th3;
                            inputStream2 = inputStream;
                            inputStream = inputStream2;
                            th = th;
                            outputStream2 = outputStream;
                            if (httpURLConnection != null) {
                            }
                            if (inputStream != null) {
                            }
                            if (outputStream2 != null) {
                            }
                            throw th;
                        }
                    }
                    outputStream2 = null;
                    inputStream = httpURLConnection.getInputStream();
                    if (inputStream != null) {
                    }
                } catch (Exception e4) {
                    e = e4;
                }
            } catch (Throwable th4) {
                outputStream = "user-agent";
                th = th4;
            }
        } catch (Throwable th5) {
            th = th5;
            outputStream = null;
        }
    }
}
