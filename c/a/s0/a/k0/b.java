package c.a.s0.a.k0;

import c.a.s0.a.a1.d;
import c.a.s0.a.z2.q0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import okhttp3.Response;
import okhttp3.ResponseBody;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a extends ResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d.c a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ File f7799b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f7800c;

        public a(b bVar, d.c cVar, File file) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, cVar, file};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7800c = bVar;
            this.a = cVar;
            this.f7799b = file;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                this.f7800c.c(this.a, 1, 0);
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, i2) == null) {
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i2) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, response, i2)) == null) {
                this.f7800c.d(response, this.a, this.f7799b);
                return response;
            }
            return invokeLI.objValue;
        }
    }

    /* renamed from: c.a.s0.a.k0.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0468b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.c f7801e;

        public RunnableC0468b(b bVar, d.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7801e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f7801e.onSuccess();
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.c f7802e;

        public c(b bVar, d.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7802e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f7802e.onFailed();
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.c f7803e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f7804f;

        public d(b bVar, d.c cVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, cVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7803e = cVar;
            this.f7804f = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f7803e.onProgressChanged(this.f7804f);
            }
        }
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public final void c(d.c cVar, int i2, int i3) {
        Runnable runnableC0468b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(1048576, this, cVar, i2, i3) == null) || cVar == null) {
            return;
        }
        if (i2 == 0) {
            runnableC0468b = new RunnableC0468b(this, cVar);
        } else if (i2 != 2) {
            runnableC0468b = new c(this, cVar);
        } else {
            runnableC0468b = new d(this, cVar, i3);
        }
        q0.e0(runnableC0468b);
    }

    public final void d(Response response, d.c cVar, File file) throws IOException {
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, response, cVar, file) == null) {
            ResponseBody body = response.body();
            if (body == null) {
                c(cVar, 1, 0);
                return;
            }
            byte[] bArr = new byte[2048];
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            if (file.exists()) {
                file.delete();
                file.createNewFile();
            }
            InputStream inputStream = null;
            try {
                InputStream byteStream = body.byteStream();
                try {
                    long contentLength = body.contentLength();
                    fileOutputStream = new FileOutputStream(file);
                    long j2 = 0;
                    while (true) {
                        try {
                            int read = byteStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            fileOutputStream.write(bArr, 0, read);
                            j2 += read;
                            c(cVar, 2, contentLength <= 0 ? 0 : (int) (((((float) j2) * 1.0f) / ((float) contentLength)) * 100.0f));
                        } catch (Exception unused) {
                            inputStream = byteStream;
                            try {
                                c(cVar, 1, 0);
                                c.a.s0.w.d.d(inputStream);
                                c.a.s0.w.d.d(fileOutputStream);
                            } catch (Throwable th) {
                                th = th;
                                c.a.s0.w.d.d(inputStream);
                                c.a.s0.w.d.d(fileOutputStream);
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            inputStream = byteStream;
                            c.a.s0.w.d.d(inputStream);
                            c.a.s0.w.d.d(fileOutputStream);
                            throw th;
                        }
                    }
                    fileOutputStream.flush();
                    c(cVar, 0, 100);
                    c.a.s0.w.d.d(byteStream);
                } catch (Exception unused2) {
                    fileOutputStream = null;
                } catch (Throwable th3) {
                    th = th3;
                    fileOutputStream = null;
                }
            } catch (Exception unused3) {
                fileOutputStream = null;
            } catch (Throwable th4) {
                th = th4;
                fileOutputStream = null;
            }
            c.a.s0.w.d.d(fileOutputStream);
        }
    }

    public void e(d.C0280d c0280d, String str, d.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, c0280d, str, cVar) == null) {
            c.a.s0.p.d.a aVar = new c.a.s0.p.d.a(c0280d.a, new a(this, cVar, new File(str)));
            aVar.f11695f = false;
            aVar.f11696g = false;
            aVar.f11697h = false;
            c.a.s0.p.e.a.g().d(aVar);
        }
    }
}
