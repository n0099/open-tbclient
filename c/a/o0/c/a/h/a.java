package c.a.o0.c.a.h;

import android.text.TextUtils;
import c.a.o0.c.a.f;
import c.a.o0.c.a.k.c;
import c.a.o0.n.i.e;
import c.a.o0.n.i.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.statistics.NetworkStatRecord;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import okhttp3.Response;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a extends e<String> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final g.a f10300e;

    public a(g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f10300e = aVar;
    }

    @Override // c.a.o0.n.i.g.a
    public void a(String str, String str2, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, jSONObject) == null) && c()) {
            this.f10300e.a(str, str2, jSONObject);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.callback.StatResponseCallback
    /* renamed from: b */
    public void onSuccess(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i2) == null) {
            if (c.a.o0.c.a.a.f10283a) {
                String str2 = "BdtlsPmsRequest onSuccess=" + str;
            }
            if (this.f10300e == null) {
                return;
            }
            c.a.o0.c.a.g l = c.a.o0.c.a.g.l();
            if (TextUtils.equals(str, "recovery")) {
                if (l.m().b()) {
                    l.m().a();
                    l.f10295d.i(true);
                    c cVar = l.f10295d;
                    if (cVar instanceof c.a.o0.c.a.k.a) {
                        ((c.a.o0.c.a.k.a) cVar).j();
                        return;
                    }
                    return;
                }
                this.f10300e.onFail(new Exception("Exceeded the limit of continuous downgrade"));
                return;
            }
            l.m().k();
            c cVar2 = l.f10295d;
            if (cVar2 instanceof c.a.o0.c.a.k.a) {
                c.a.o0.c.a.k.a aVar = (c.a.o0.c.a.k.a) cVar2;
                if (l.k()) {
                    if (l.f10295d.f10341b == 1) {
                        f.a("application");
                        this.f10300e.b(str, i2);
                        aVar.f10332h = 0;
                        return;
                    }
                    int i3 = aVar.f10332h;
                    aVar.f10332h = i3 + 1;
                    if (i3 < 3) {
                        aVar.j();
                        return;
                    }
                    this.f10300e.onFail(new IOException("request fail : " + str));
                    aVar.f10332h = 0;
                    return;
                }
                this.f10300e.b(str, i2);
                aVar.f10332h = 0;
            }
        }
    }

    public final boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f10300e != null : invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.callback.StatResponseCallback
    /* renamed from: d */
    public String parseResponse(Response response, int i2, NetworkStatRecord networkStatRecord) throws Exception {
        InterceptResult invokeLIL;
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048579, this, response, i2, networkStatRecord)) == null) {
            if (response == null || response.body() == null) {
                return "";
            }
            c.a.o0.c.a.g l = c.a.o0.c.a.g.l();
            if (TextUtils.equals(response.headers().get("Bdtls"), "recovery")) {
                l.m().s(0);
                return "recovery";
            }
            if (l.k()) {
                string = l.f10295d.g(response.body().bytes());
                if (c.a.o0.c.a.a.f10283a) {
                    String str = "BdtlsPmsRequest parseResponse=" + string;
                }
            } else {
                string = response.body().string();
            }
            a(String.valueOf(response.request().url()), string, networkStatRecord.toUBCJson());
            return string;
        }
        return (String) invokeLIL.objValue;
    }

    @Override // com.baidu.searchbox.http.callback.StatResponseCallback
    public void onFail(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, exc) == null) {
            if (c.a.o0.c.a.a.f10283a) {
                String str = "BdtlsPmsRequest onFail = " + exc.getMessage();
            }
            if (c()) {
                this.f10300e.onFail(exc);
            }
        }
    }

    @Override // c.a.o0.n.i.g.a
    public void onStart() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && c()) {
            this.f10300e.onStart();
        }
    }
}
