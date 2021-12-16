package c.g;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
/* loaded from: classes9.dex */
public abstract class l0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f29263b;

    /* renamed from: c  reason: collision with root package name */
    public String f29264c;

    /* renamed from: d  reason: collision with root package name */
    public String f29265d;

    /* renamed from: e  reason: collision with root package name */
    public byte[] f29266e;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public l0(String str, n0 n0Var) {
        this(str, n0Var, false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, n0Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((String) objArr2[0], (n0) objArr2[1], ((Boolean) objArr2[2]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public l0(String str, n0 n0Var, boolean z) {
        StringBuilder sb;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, n0Var, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (str == null) {
            throw new IllegalArgumentException("url is null");
        }
        this.a = str;
        this.f29263b = z;
        if (n0Var != null) {
            String str2 = "?";
            if (str.contains("?")) {
                sb = new StringBuilder();
                sb.append(this.a);
                str2 = "&";
            } else {
                sb = new StringBuilder();
                sb.append(this.a);
            }
            sb.append(str2);
            sb.append(n0Var.b());
            this.a = sb.toString();
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:(14:21|(4:72|73|(3:75|76|77)|78)|23|(2:28|29)|37|38|39|(2:40|(1:42)(1:43))|44|45|46|47|(2:50|51)|49)|38|39|(3:40|(0)(0)|42)|44|45|46|47|(0)|49) */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00dd A[Catch: all -> 0x0100, Exception -> 0x0102, LOOP:0: B:40:0x00d6->B:42:0x00dd, LOOP_END, TryCatch #10 {Exception -> 0x0102, all -> 0x0100, blocks: (B:39:0x00cf, B:40:0x00d6, B:42:0x00dd, B:43:0x00e1), top: B:93:0x00cf }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x012c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00fc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0125 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x00e1 A[EDGE_INSN: B:96:0x00e1->B:43:0x00e1 ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public p0 a() {
        InterceptResult invokeV;
        OutputStream outputStream;
        OutputStream outputStream2;
        Throwable th;
        OutputStream outputStream3;
        Exception e2;
        String contentEncoding;
        byte[] bArr;
        ByteArrayOutputStream byteArrayOutputStream;
        int read;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048576, this)) != null) {
            return (p0) invokeV.objValue;
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.a).openConnection();
        InputStream inputStream = null;
        try {
            try {
                httpURLConnection.setConnectTimeout(30000);
                httpURLConnection.setReadTimeout(8000);
                httpURLConnection.setRequestMethod(this.f29264c);
                httpURLConnection.setDoOutput("POST".equals(this.f29264c) && this.f29266e != null);
                String str = this.f29265d;
                if (str != null) {
                    httpURLConnection.setRequestProperty("Content-Type", str);
                }
                if (this.f29263b) {
                    httpURLConnection.setRequestProperty("Content-Encoding", "application/gzip");
                }
                httpURLConnection.setRequestProperty("Accept-Charset", "UTF-8");
                httpURLConnection.setRequestProperty("User-agent", System.getProperty("http.agent"));
                httpURLConnection.setRequestProperty("Accept-Encoding", "gzip,deflate");
                httpURLConnection.connect();
            } catch (Throwable th2) {
                outputStream = 30000;
                th = th2;
                OutputStream outputStream4 = outputStream;
                th = th;
                outputStream3 = outputStream4;
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception unused) {
                    }
                }
                if (outputStream3 != null) {
                    try {
                        outputStream3.close();
                    } catch (Exception unused2) {
                    }
                }
                throw th;
            }
            try {
                if (httpURLConnection.getDoOutput()) {
                    outputStream3 = httpURLConnection.getOutputStream();
                    if (outputStream3 != null) {
                        try {
                            byte[] bArr2 = this.f29266e;
                            if (this.f29263b) {
                                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream2);
                                gZIPOutputStream.write(bArr2);
                                gZIPOutputStream.flush();
                                gZIPOutputStream.close();
                                byte[] byteArray = byteArrayOutputStream2.toByteArray();
                                LogPrinter.v("origin:%d gzip:%d", Integer.valueOf(bArr2.length), Integer.valueOf(byteArray.length));
                                bArr2 = byteArray;
                            }
                            outputStream3.write(bArr2);
                            outputStream3.flush();
                            outputStream3.close();
                        } catch (Exception e3) {
                            outputStream2 = outputStream3;
                            e = e3;
                            e2 = e;
                            throw new IOException(e2);
                        }
                    }
                    inputStream = httpURLConnection.getInputStream();
                    contentEncoding = httpURLConnection.getContentEncoding();
                    if (contentEncoding != null && "gzip".equals(contentEncoding.toLowerCase())) {
                        inputStream = new GZIPInputStream(inputStream);
                    }
                    bArr = new byte[16384];
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    while (true) {
                        read = inputStream.read(bArr);
                        if (read != -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                    p0 p0Var = new p0(httpURLConnection.getResponseCode(), httpURLConnection.getContentType(), byteArrayOutputStream.toString());
                    httpURLConnection.disconnect();
                    inputStream.close();
                    if (outputStream3 != null) {
                        try {
                            outputStream3.close();
                        } catch (Exception unused3) {
                        }
                    }
                    return p0Var;
                }
                bArr = new byte[16384];
                byteArrayOutputStream = new ByteArrayOutputStream();
                while (true) {
                    read = inputStream.read(bArr);
                    if (read != -1) {
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                p0 p0Var2 = new p0(httpURLConnection.getResponseCode(), httpURLConnection.getContentType(), byteArrayOutputStream.toString());
                httpURLConnection.disconnect();
                inputStream.close();
                if (outputStream3 != null) {
                }
                return p0Var2;
            } catch (Exception e4) {
                e2 = e4;
                throw new IOException(e2);
            } catch (Throwable th3) {
                th = th3;
                if (httpURLConnection != null) {
                }
                if (inputStream != null) {
                }
                if (outputStream3 != null) {
                }
                throw th;
            }
            outputStream3 = null;
            inputStream = httpURLConnection.getInputStream();
            contentEncoding = httpURLConnection.getContentEncoding();
            if (contentEncoding != null) {
                inputStream = new GZIPInputStream(inputStream);
            }
        } catch (Exception e5) {
            e = e5;
            outputStream2 = null;
        } catch (Throwable th4) {
            th = th4;
            outputStream = null;
            OutputStream outputStream42 = outputStream;
            th = th;
            outputStream3 = outputStream42;
            if (httpURLConnection != null) {
            }
            if (inputStream != null) {
            }
            if (outputStream3 != null) {
            }
            throw th;
        }
    }
}
