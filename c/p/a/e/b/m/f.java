package c.p.a.e.b.m;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.List;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
/* loaded from: classes4.dex */
public class f implements c.p.a.e.b.o.j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public class a implements c.p.a.e.b.o.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Response f35344a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Call f35345b;

        public a(f fVar, Response response, Call call) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, response, call};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f35344a = response;
            this.f35345b = call;
        }

        @Override // c.p.a.e.b.o.i
        public String a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? this.f35344a.header(str) : (String) invokeL.objValue;
        }

        @Override // c.p.a.e.b.o.i
        public int b() throws IOException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f35344a.code() : invokeV.intValue;
        }

        @Override // c.p.a.e.b.o.i
        public void c() {
            Call call;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (call = this.f35345b) == null || call.isCanceled()) {
                return;
            }
            this.f35345b.cancel();
        }
    }

    public f() {
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

    @Override // c.p.a.e.b.o.j
    public c.p.a.e.b.o.i a(String str, List<com.ss.android.socialbase.downloader.model.c> list) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, list)) == null) {
            OkHttpClient H0 = c.p.a.e.b.g.e.H0();
            if (H0 != null) {
                Request.Builder head = new Request.Builder().url(str).head();
                if (list != null && list.size() > 0) {
                    for (com.ss.android.socialbase.downloader.model.c cVar : list) {
                        head.addHeader(cVar.a(), c.p.a.e.b.l.f.R0(cVar.b()));
                    }
                }
                Call newCall = H0.newCall(head.build());
                Response execute = newCall.execute();
                if (execute != null) {
                    if (c.p.a.e.b.l.a.a(2097152)) {
                        execute.close();
                    }
                    return new a(this, execute, newCall);
                }
                throw new IOException("can't get response");
            }
            throw new IOException("can't get httpClient");
        }
        return (c.p.a.e.b.o.i) invokeLL.objValue;
    }
}
