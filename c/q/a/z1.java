package c.q.a;

import android.content.Context;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import org.apache.http.protocol.HTTP;
/* loaded from: classes9.dex */
public class z1 extends Thread {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f30535e;

    /* renamed from: f  reason: collision with root package name */
    public List f30536f;

    /* renamed from: g  reason: collision with root package name */
    public f2 f30537g;

    /* renamed from: h  reason: collision with root package name */
    public Context f30538h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f30539i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z1(Context context, String str, List list, f2 f2Var) {
        super("resc");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, list, f2Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f30538h = context;
        this.f30535e = str;
        this.f30536f = list;
        this.f30537g = f2Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0063 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:101:0x00c2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0011 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00f6 A[Catch: Exception -> 0x00fa, TRY_ENTER, TryCatch #4 {Exception -> 0x00fa, blocks: (B:36:0x00c2, B:35:0x00bc, B:59:0x00f6, B:62:0x00ff), top: B:86:0x00bc }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00ff A[Catch: Exception -> 0x00fa, TRY_LEAVE, TryCatch #4 {Exception -> 0x00fa, blocks: (B:36:0x00c2, B:35:0x00bc, B:59:0x00f6, B:62:0x00ff), top: B:86:0x00bc }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x010d A[Catch: Exception -> 0x0115, TryCatch #8 {Exception -> 0x0115, blocks: (B:67:0x0108, B:69:0x010d, B:71:0x0112), top: B:90:0x0108 }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0112 A[Catch: Exception -> 0x0115, TRY_LEAVE, TryCatch #8 {Exception -> 0x0115, blocks: (B:67:0x0108, B:69:0x010d, B:71:0x0112), top: B:90:0x0108 }] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0108 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0064 A[SYNTHETIC] */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        HttpURLConnection httpURLConnection;
        InputStream inputStream;
        Exception e2;
        File file;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.run();
            long currentTimeMillis = System.currentTimeMillis();
            for (String str : this.f30536f) {
                String str2 = this.f30535e;
                FileOutputStream fileOutputStream = null;
                r6 = null;
                InputStream inputStream2 = null;
                fileOutputStream = null;
                try {
                    File file2 = new File(str2);
                    if (!file2.exists()) {
                        file2.mkdirs();
                    }
                    file = new File(str2, String.valueOf(str.hashCode()));
                } catch (Exception e3) {
                    e = e3;
                    httpURLConnection = null;
                } catch (Throwable th) {
                    th = th;
                    httpURLConnection = null;
                }
                if (file.exists() && file.isFile()) {
                    if (file.length() == c2.b(this.f30538h).a(str)) {
                        z = true;
                        if (z) {
                            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                            try {
                                httpURLConnection.setConnectTimeout(3000);
                                httpURLConnection.setRequestProperty(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
                                httpURLConnection.setReadTimeout(3000);
                                httpURLConnection.connect();
                                long contentLength = httpURLConnection.getContentLength();
                                if (contentLength > 0) {
                                    c2.b(this.f30538h).c(str, contentLength);
                                    FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                                    try {
                                        inputStream2 = httpURLConnection.getInputStream();
                                        byte[] bArr = new byte[4096];
                                        while (true) {
                                            int read = inputStream2.read(bArr);
                                            if (read != -1) {
                                                fileOutputStream2.write(bArr, 0, read);
                                            } else {
                                                try {
                                                    break;
                                                } catch (Exception unused) {
                                                }
                                            }
                                        }
                                        fileOutputStream2.close();
                                        inputStream2.close();
                                    } catch (Exception e4) {
                                        e2 = e4;
                                        InputStream inputStream3 = inputStream2;
                                        fileOutputStream = fileOutputStream2;
                                        inputStream = inputStream3;
                                        try {
                                            if (this.f30537g != null) {
                                            }
                                            if (fileOutputStream != null) {
                                            }
                                            if (inputStream != null) {
                                            }
                                            if (httpURLConnection == null) {
                                            }
                                        } catch (Throwable th2) {
                                            th = th2;
                                            if (fileOutputStream != null) {
                                                try {
                                                    fileOutputStream.close();
                                                } catch (Exception unused2) {
                                                    throw th;
                                                }
                                            }
                                            if (inputStream != null) {
                                                inputStream.close();
                                            }
                                            if (httpURLConnection != null) {
                                                httpURLConnection.disconnect();
                                            }
                                            throw th;
                                        }
                                    } catch (Throwable th3) {
                                        th = th3;
                                        InputStream inputStream4 = inputStream2;
                                        fileOutputStream = fileOutputStream2;
                                        inputStream = inputStream4;
                                        if (fileOutputStream != null) {
                                        }
                                        if (inputStream != null) {
                                        }
                                        if (httpURLConnection != null) {
                                        }
                                        throw th;
                                    }
                                } else if (this.f30537g != null) {
                                    this.f30539i = true;
                                    this.f30537g.a(950, str);
                                }
                            } catch (Exception e5) {
                                e = e5;
                                e2 = e;
                                inputStream = null;
                                if (this.f30537g != null) {
                                    int i2 = CyberPlayerManager.MEDIA_INFO_VIDEO_FRAMERATE;
                                    if (httpURLConnection != null) {
                                        try {
                                            i2 = httpURLConnection.getResponseCode();
                                        } catch (Exception unused3) {
                                        }
                                    }
                                    this.f30539i = true;
                                    this.f30537g.a(i2, e2.getMessage());
                                }
                                if (fileOutputStream != null) {
                                    fileOutputStream.close();
                                }
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                if (httpURLConnection == null) {
                                    httpURLConnection.disconnect();
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                inputStream = null;
                                if (fileOutputStream != null) {
                                }
                                if (inputStream != null) {
                                }
                                if (httpURLConnection != null) {
                                }
                                throw th;
                            }
                            httpURLConnection.disconnect();
                        }
                    } else {
                        r0.q(file);
                    }
                }
                z = false;
                if (z) {
                }
            }
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            f2 f2Var = this.f30537g;
            if (f2Var == null || this.f30539i) {
                return;
            }
            y2 a = c3.a(f2Var.a);
            a.c(new g3(f2Var.f30318b), 200);
            a.k("dr", currentTimeMillis2);
            a.m();
        }
    }
}
