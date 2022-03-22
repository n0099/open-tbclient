package c.a.n0.a.o2;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import c.a.n0.a.k.c.d;
import c.a.n0.a.o2.a;
import c.a.n0.a.w0.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b extends d implements a.InterfaceC0404a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f5643h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public String f5644f;

    /* renamed from: g  reason: collision with root package name */
    public String f5645g;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.n0.a.a1.e.a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f5646b;

        public a(b bVar, c.a.n0.a.a1.e.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5646b = bVar;
            this.a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (c.a.n0.a.s0.a.h().a(this.f5646b.f5644f, this.a)) {
                    this.f5646b.A(this.a);
                    return;
                }
                b bVar = this.f5646b;
                bVar.d(bVar.f5645g, new c.a.n0.a.k.h.b(2003, "upload fail"));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1218558256, "Lc/a/n0/a/o2/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1218558256, "Lc/a/n0/a/o2/b;");
                return;
            }
        }
        f5643h = c.a.n0.a.a.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NonNull c.a.n0.a.k.c.b bVar) {
        super(bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((c.a.n0.a.k.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public final void A(c.a.n0.a.a1.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("bosUrl", aVar.f3870e);
                d(this.f5645g, new c.a.n0.a.k.h.b(0, jSONObject));
            } catch (JSONException e2) {
                if (f5643h) {
                    e2.printStackTrace();
                }
                d(this.f5645g, new c.a.n0.a.k.h.b(2003, "upload fail"));
            }
        }
    }

    public final boolean B(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, file)) == null) ? file.length() > 52428800 : invokeL.booleanValue;
    }

    public c.a.n0.a.k.h.b C(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#uploadBosFile", false);
            if (f5643h) {
                Log.d("UploadBosApi", "#uploadBosFile params=" + str);
            }
            Pair<c.a.n0.a.k.h.b, JSONObject> s = s(str);
            c.a.n0.a.k.h.b bVar = (c.a.n0.a.k.h.b) s.first;
            if (bVar.isSuccess()) {
                JSONObject jSONObject = (JSONObject) s.second;
                String optString = jSONObject.optString("cb");
                this.f5645g = optString;
                if (TextUtils.isEmpty(optString)) {
                    return new c.a.n0.a.k.h.b(202);
                }
                String optString2 = jSONObject.optString("filePath");
                if (TextUtils.isEmpty(optString2)) {
                    return new c.a.n0.a.k.h.b(202);
                }
                f U = f.U();
                String i = U.G().i(optString2);
                this.f5644f = i;
                if (TextUtils.isEmpty(i)) {
                    return new c.a.n0.a.k.h.b(2001, "file not found");
                }
                File file = new File(this.f5644f);
                if (file.exists() && file.isFile()) {
                    if (B(file)) {
                        return new c.a.n0.a.k.h.b(2002, "file over size");
                    }
                    if (!c.a.n0.a.t1.d.J().r().M().e(U.getActivity())) {
                        return new c.a.n0.a.k.h.b(10004, "user not logged in");
                    }
                    c.a.n0.a.s0.a.h().b(U.getActivity(), this.f5644f, this);
                    return c.a.n0.a.k.h.b.f();
                }
                return new c.a.n0.a.k.h.b(2001, "file not found");
            }
            return bVar;
        }
        return (c.a.n0.a.k.h.b) invokeL.objValue;
    }

    @Override // c.a.n0.a.o2.a.InterfaceC0404a
    public void c(JSONObject jSONObject, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, jSONObject, str) == null) {
            if (jSONObject == null) {
                d(this.f5645g, new c.a.n0.a.k.h.b(2003, "upload fail"));
                return;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject == null) {
                d(this.f5645g, new c.a.n0.a.k.h.b(2003, "upload fail"));
                return;
            }
            String optString = jSONObject.optString("errno");
            if (!TextUtils.isEmpty(optString) && TextUtils.equals(optString, "0")) {
                c.a.n0.a.a1.e.a a2 = c.a.n0.a.a1.e.a.a(optJSONObject, str);
                if (TextUtils.isEmpty(a2.f3870e)) {
                    d(this.f5645g, new c.a.n0.a.k.h.b(2003, "upload fail"));
                    return;
                } else {
                    ExecutorUtilsExt.postOnElastic(new a(this, a2), "doBosUpload", 2);
                    return;
                }
            }
            d(this.f5645g, new c.a.n0.a.k.h.b(2003, "upload fail"));
        }
    }

    @Override // c.a.n0.a.k.c.d
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "PrivateFile" : (String) invokeV.objValue;
    }

    @Override // c.a.n0.a.k.c.d
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? "UploadBosApi" : (String) invokeV.objValue;
    }
}
