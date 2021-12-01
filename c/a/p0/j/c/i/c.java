package c.a.p0.j.c.i;

import c.a.p0.a.k;
import c.a.p0.j.c.f;
import c.a.p0.w.d;
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
/* loaded from: classes5.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f10068e;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.p0.j.z.b a;

    /* renamed from: b  reason: collision with root package name */
    public String f10069b;

    /* renamed from: c  reason: collision with root package name */
    public String f10070c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.p0.j.c.i.a f10071d;

    /* loaded from: classes5.dex */
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
                if (c.f10068e) {
                    String str = this.a.f10069b + " load failed";
                    iOException.printStackTrace();
                }
                if (this.a.f10071d != null) {
                    this.a.f10071d.fail(-1, this.a.f10069b);
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
                            String d2 = f.d(this.a.f10069b);
                            String str = this.a.f10070c + d2.substring(0, d2.lastIndexOf("/"));
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
                                            if (c.f10068e) {
                                                String str2 = this.a.f10069b + " load failed";
                                            }
                                            if (file != null) {
                                                file.delete();
                                            }
                                            if (this.a.f10071d != null) {
                                                this.a.f10071d.fail(-1, this.a.f10069b);
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
                                    if (c.f10068e) {
                                        String str3 = this.a.f10069b + " load rename success path = " + absolutePath;
                                    }
                                    if (this.a.f10071d != null) {
                                        this.a.f10071d.a(this.a.f10069b, absolutePath);
                                    }
                                } else {
                                    if (c.f10068e) {
                                        String str4 = this.a.f10069b + " load rename error path = " + absolutePath;
                                    }
                                    file.delete();
                                    if (this.a.f10071d != null) {
                                        this.a.f10071d.fail(-1, absolutePath);
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2017551528, "Lc/a/p0/j/c/i/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2017551528, "Lc/a/p0/j/c/i/c;");
                return;
            }
        }
        f10068e = k.a;
    }

    public c(c.a.p0.j.z.b bVar, String str, String str2, c.a.p0.j.c.i.a aVar) {
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
        this.f10069b = "";
        this.f10070c = "";
        this.a = bVar;
        this.f10070c = str;
        this.f10069b = str2;
        this.f10071d = aVar;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.call(new Request.Builder().url(this.f10069b).build(), new a(this));
        }
    }
}
