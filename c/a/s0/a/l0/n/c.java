package c.a.s0.a.l0.n;

import android.text.TextUtils;
import c.a.s0.a.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;
/* loaded from: classes.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f7858e;
    public transient /* synthetic */ FieldHolder $fh;
    public HttpManager a;

    /* renamed from: b  reason: collision with root package name */
    public String f7859b;

    /* renamed from: c  reason: collision with root package name */
    public String f7860c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.s0.a.l0.n.a f7861d;

    /* loaded from: classes.dex */
    public class a implements Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, call, iOException) == null) {
                if (c.f7858e) {
                    String str = this.a.f7859b + " load failed";
                    iOException.printStackTrace();
                }
                if (this.a.f7861d != null) {
                    this.a.f7861d.fail(-1, this.a.f7859b);
                }
            }
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) {
            FileOutputStream fileOutputStream;
            File file;
            InputStream byteStream;
            String c2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, call, response) == null) {
                if (TextUtils.isEmpty(this.a.f7860c)) {
                    boolean z = k.a;
                    return;
                }
                byte[] bArr = new byte[2048];
                InputStream inputStream = null;
                try {
                    byteStream = response.body().byteStream();
                    try {
                        try {
                            c2 = c.a.s0.a.c1.b.f().c(this.a.f7859b);
                        } catch (Exception unused) {
                            file = null;
                            fileOutputStream = null;
                        }
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = null;
                    }
                } catch (Exception unused2) {
                    file = null;
                    fileOutputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = null;
                }
                if (TextUtils.isEmpty(c2)) {
                    boolean z2 = k.a;
                    c.a.s0.w.d.d(byteStream);
                    c.a.s0.w.d.d(null);
                    c.a.s0.w.d.d(response);
                    return;
                }
                String str = this.a.f7860c + c2.substring(0, c2.lastIndexOf("/"));
                File file2 = new File(str);
                if (!file2.exists() || !file2.isDirectory()) {
                    file2.mkdirs();
                }
                String substring = c2.substring(c2.lastIndexOf("/") + 1);
                file = new File(str, substring + ".bddownload");
                try {
                    fileOutputStream = new FileOutputStream(file);
                    while (true) {
                        try {
                            int read = byteStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            fileOutputStream.write(bArr, 0, read);
                        } catch (Exception unused3) {
                            inputStream = byteStream;
                            try {
                                if (c.f7858e) {
                                    String str2 = this.a.f7859b + " load failed";
                                }
                                if (file != null) {
                                    file.delete();
                                }
                                if (this.a.f7861d != null) {
                                    this.a.f7861d.fail(-1, this.a.f7859b);
                                }
                                c.a.s0.w.d.d(inputStream);
                                c.a.s0.w.d.d(fileOutputStream);
                                c.a.s0.w.d.d(response);
                            } catch (Throwable th3) {
                                th = th3;
                                c.a.s0.w.d.d(inputStream);
                                c.a.s0.w.d.d(fileOutputStream);
                                c.a.s0.w.d.d(response);
                                throw th;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            inputStream = byteStream;
                            c.a.s0.w.d.d(inputStream);
                            c.a.s0.w.d.d(fileOutputStream);
                            c.a.s0.w.d.d(response);
                            throw th;
                        }
                    }
                    fileOutputStream.flush();
                    File file3 = new File(str, substring);
                    if (file3.exists() && !file3.isDirectory()) {
                        file3.delete();
                    }
                    String absolutePath = file3.getAbsolutePath();
                    if (file.renameTo(file3)) {
                        if (c.f7858e) {
                            String str3 = this.a.f7859b + " load rename success path = " + absolutePath;
                        }
                        if (this.a.f7861d != null) {
                            this.a.f7861d.a(this.a.f7859b, absolutePath);
                        }
                    } else {
                        if (c.f7858e) {
                            String str4 = this.a.f7859b + " load rename error path = " + absolutePath;
                        }
                        file.delete();
                        if (this.a.f7861d != null) {
                            this.a.f7861d.fail(-1, absolutePath);
                        }
                    }
                    c.a.s0.w.d.d(byteStream);
                } catch (Exception unused4) {
                    fileOutputStream = null;
                }
                c.a.s0.w.d.d(fileOutputStream);
                c.a.s0.w.d.d(response);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(729372842, "Lc/a/s0/a/l0/n/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(729372842, "Lc/a/s0/a/l0/n/c;");
                return;
            }
        }
        f7858e = k.a;
    }

    public c(HttpManager httpManager, String str, String str2, c.a.s0.a.l0.n.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {httpManager, str, str2, aVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f7859b = "";
        this.f7860c = "";
        this.a = httpManager;
        this.f7860c = str;
        this.f7859b = str2;
        this.f7861d = aVar;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            c.a.s0.a.c1.b.l().call(this.a, new Request.Builder().url(this.f7859b).build(), new a(this));
        }
    }
}
