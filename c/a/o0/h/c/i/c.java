package c.a.o0.h.c.i;

import c.a.o0.a.k;
import c.a.o0.h.c.f;
import c.a.o0.t.d;
import com.baidu.android.imsdk.internal.Constants;
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
/* loaded from: classes3.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f11041e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c.a.o0.h.y.b f11042a;

    /* renamed from: b  reason: collision with root package name */
    public String f11043b;

    /* renamed from: c  reason: collision with root package name */
    public String f11044c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.o0.h.c.i.a f11045d;

    /* loaded from: classes3.dex */
    public class a implements Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f11046a;

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
            this.f11046a = cVar;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, call, iOException) == null) {
                if (c.f11041e) {
                    String str = this.f11046a.f11043b + " load failed";
                    iOException.printStackTrace();
                }
                if (this.f11046a.f11045d != null) {
                    this.f11046a.f11045d.fail(-1, this.f11046a.f11043b);
                }
            }
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) {
            FileOutputStream fileOutputStream;
            File file;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, call, response) == null) {
                byte[] bArr = new byte[2048];
                InputStream inputStream = null;
                try {
                    InputStream byteStream = response.body().byteStream();
                    try {
                        try {
                            String d2 = f.d(this.f11046a.f11043b);
                            String str = this.f11046a.f11044c + d2.substring(0, d2.lastIndexOf("/"));
                            File file2 = new File(str);
                            if (!file2.exists() || !file2.isDirectory()) {
                                file2.mkdirs();
                            }
                            String substring = d2.substring(d2.lastIndexOf("/") + 1);
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
                                    } catch (Exception unused) {
                                        inputStream = byteStream;
                                        try {
                                            if (c.f11041e) {
                                                String str2 = this.f11046a.f11043b + " load failed";
                                            }
                                            if (file != null) {
                                                file.delete();
                                            }
                                            if (this.f11046a.f11045d != null) {
                                                this.f11046a.f11045d.fail(-1, this.f11046a.f11043b);
                                            }
                                            d.d(inputStream);
                                            d.d(fileOutputStream);
                                            d.d(response);
                                        } catch (Throwable th) {
                                            th = th;
                                            d.d(inputStream);
                                            d.d(fileOutputStream);
                                            d.d(response);
                                            throw th;
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        inputStream = byteStream;
                                        d.d(inputStream);
                                        d.d(fileOutputStream);
                                        d.d(response);
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
                                    if (c.f11041e) {
                                        String str3 = this.f11046a.f11043b + " load rename success path = " + absolutePath;
                                    }
                                    if (this.f11046a.f11045d != null) {
                                        this.f11046a.f11045d.a(this.f11046a.f11043b, absolutePath);
                                    }
                                } else {
                                    if (c.f11041e) {
                                        String str4 = this.f11046a.f11043b + " load rename error path = " + absolutePath;
                                    }
                                    file.delete();
                                    if (this.f11046a.f11045d != null) {
                                        this.f11046a.f11045d.fail(-1, absolutePath);
                                    }
                                }
                                d.d(byteStream);
                            } catch (Exception unused2) {
                                fileOutputStream = null;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            fileOutputStream = null;
                        }
                    } catch (Exception unused3) {
                        file = null;
                        fileOutputStream = null;
                    }
                } catch (Exception unused4) {
                    file = null;
                    fileOutputStream = null;
                } catch (Throwable th4) {
                    th = th4;
                    fileOutputStream = null;
                }
                d.d(fileOutputStream);
                d.d(response);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(588746457, "Lc/a/o0/h/c/i/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(588746457, "Lc/a/o0/h/c/i/c;");
                return;
            }
        }
        f11041e = k.f7049a;
    }

    public c(c.a.o0.h.y.b bVar, String str, String str2, c.a.o0.h.c.i.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, str, str2, aVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f11043b = "";
        this.f11044c = "";
        this.f11042a = bVar;
        this.f11044c = str;
        this.f11043b = str2;
        this.f11045d = aVar;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f11042a.b(new Request.Builder().url(this.f11043b).build(), new a(this));
        }
    }
}
