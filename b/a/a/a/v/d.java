package b.a.a.a.v;

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
import java.util.zip.GZIPOutputStream;
/* loaded from: classes.dex */
public abstract class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f1467a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f1468b;

    /* renamed from: c  reason: collision with root package name */
    public String f1469c;

    /* renamed from: d  reason: collision with root package name */
    public String f1470d;

    /* renamed from: e  reason: collision with root package name */
    public byte[] f1471e;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public d(String str, e eVar) {
        this(str, eVar, false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, eVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((String) objArr2[0], (e) objArr2[1], ((Boolean) objArr2[2]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public d(String str, e eVar, boolean z) {
        StringBuilder sb;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, eVar, Boolean.valueOf(z)};
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
        this.f1467a = str;
        this.f1468b = z;
        if (eVar != null) {
            String str2 = "?";
            if (str.contains("?")) {
                sb = new StringBuilder();
                sb.append(this.f1467a);
                str2 = "&";
            } else {
                sb = new StringBuilder();
                sb.append(this.f1467a);
            }
            sb.append(str2);
            sb.append(eVar.b());
            this.f1467a = sb.toString();
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:(14:21|(4:72|73|(3:75|76|77)|78)|23|(2:28|29)|37|38|39|(2:40|(1:42)(1:43))|44|45|46|47|(2:50|51)|49)|38|39|(3:40|(0)(0)|42)|44|45|46|47|(0)|49) */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00dc A[Catch: all -> 0x00ff, Exception -> 0x0101, LOOP:0: B:40:0x00d5->B:42:0x00dc, LOOP_END, TryCatch #9 {Exception -> 0x0101, all -> 0x00ff, blocks: (B:39:0x00ce, B:40:0x00d5, B:42:0x00dc, B:43:0x00e0), top: B:94:0x00ce }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x012b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00fb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0124 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x00e0 A[EDGE_INSN: B:96:0x00e0->B:43:0x00e0 ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public f a() {
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
            return (f) invokeV.objValue;
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.f1467a).openConnection();
        InputStream inputStream = null;
        try {
            try {
                httpURLConnection.setConnectTimeout(30000);
                httpURLConnection.setReadTimeout(8000);
                httpURLConnection.setRequestMethod(this.f1469c);
                httpURLConnection.setDoOutput("POST".equals(this.f1469c) && this.f1471e != null);
                if (this.f1470d != null) {
                    httpURLConnection.setRequestProperty("Content-Type", this.f1470d);
                }
                if (this.f1468b) {
                    httpURLConnection.setRequestProperty("Content-Encoding", "application/gzip");
                }
                httpURLConnection.setRequestProperty("Accept-Charset", "UTF-8");
                httpURLConnection.setRequestProperty("User-agent", System.getProperty("http.agent"));
                httpURLConnection.setRequestProperty("Accept-Encoding", "gzip,deflate");
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
        } catch (Exception e3) {
            e = e3;
            outputStream2 = null;
        } catch (Throwable th3) {
            th = th3;
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
        try {
            if (httpURLConnection.getDoOutput()) {
                outputStream3 = httpURLConnection.getOutputStream();
                if (outputStream3 != null) {
                    try {
                        byte[] bArr2 = this.f1471e;
                        if (this.f1468b) {
                            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream2);
                            gZIPOutputStream.write(bArr2);
                            gZIPOutputStream.flush();
                            gZIPOutputStream.close();
                            byte[] byteArray = byteArrayOutputStream2.toByteArray();
                            b.a.a.a.x.d.g("origin:%d gzip:%d", Integer.valueOf(bArr2.length), Integer.valueOf(byteArray.length));
                            bArr2 = byteArray;
                        }
                        outputStream3.write(bArr2);
                        outputStream3.flush();
                        outputStream3.close();
                    } catch (Exception e4) {
                        outputStream2 = outputStream3;
                        e = e4;
                        e2 = e;
                        throw new IOException(e2);
                    }
                }
                inputStream = httpURLConnection.getInputStream();
                contentEncoding = httpURLConnection.getContentEncoding();
                if (contentEncoding != null && AsyncHttpClient.ENCODING_GZIP.equals(contentEncoding.toLowerCase())) {
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
                f fVar = new f(httpURLConnection.getResponseCode(), httpURLConnection.getContentType(), byteArrayOutputStream.toString());
                httpURLConnection.disconnect();
                inputStream.close();
                if (outputStream3 != null) {
                    try {
                        outputStream3.close();
                    } catch (Exception unused3) {
                    }
                }
                return fVar;
            }
            bArr = new byte[16384];
            byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                read = inputStream.read(bArr);
                if (read != -1) {
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            f fVar2 = new f(httpURLConnection.getResponseCode(), httpURLConnection.getContentType(), byteArrayOutputStream.toString());
            httpURLConnection.disconnect();
            inputStream.close();
            if (outputStream3 != null) {
            }
            return fVar2;
        } catch (Exception e5) {
            e2 = e5;
            throw new IOException(e2);
        } catch (Throwable th4) {
            th = th4;
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
    }
}
