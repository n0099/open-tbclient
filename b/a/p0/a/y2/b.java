package b.a.p0.a.y2;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import b.a.p0.a.g1.f;
import b.a.p0.a.k;
import b.a.p0.a.u.c.d;
import b.a.p0.a.y2.a;
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
public class b extends d implements a.InterfaceC0490a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f9518h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public String f9519f;

    /* renamed from: g  reason: collision with root package name */
    public String f9520g;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.k1.e.a f9521e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f9522f;

        public a(b bVar, b.a.p0.a.k1.e.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9522f = bVar;
            this.f9521e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (b.a.p0.a.c1.a.h().a(this.f9522f.f9519f, this.f9521e)) {
                    this.f9522f.A(this.f9521e);
                    return;
                }
                b bVar = this.f9522f;
                bVar.d(bVar.f9520g, new b.a.p0.a.u.h.b(2003, "upload fail"));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1340325081, "Lb/a/p0/a/y2/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1340325081, "Lb/a/p0/a/y2/b;");
                return;
            }
        }
        f9518h = k.f6863a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NonNull b.a.p0.a.u.c.b bVar) {
        super(bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((b.a.p0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public final void A(b.a.p0.a.k1.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("bosUrl", aVar.f6903e);
                d(this.f9520g, new b.a.p0.a.u.h.b(0, jSONObject));
            } catch (JSONException e2) {
                if (f9518h) {
                    e2.printStackTrace();
                }
                d(this.f9520g, new b.a.p0.a.u.h.b(2003, "upload fail"));
            }
        }
    }

    public final boolean B(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, file)) == null) ? file.length() > 52428800 : invokeL.booleanValue;
    }

    public b.a.p0.a.u.h.b C(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#uploadBosFile", false);
            if (f9518h) {
                String str2 = "#uploadBosFile params=" + str;
            }
            Pair<b.a.p0.a.u.h.b, JSONObject> s = s(str);
            b.a.p0.a.u.h.b bVar = (b.a.p0.a.u.h.b) s.first;
            if (bVar.isSuccess()) {
                JSONObject jSONObject = (JSONObject) s.second;
                String optString = jSONObject.optString("cb");
                this.f9520g = optString;
                if (TextUtils.isEmpty(optString)) {
                    return new b.a.p0.a.u.h.b(202);
                }
                String optString2 = jSONObject.optString("filePath");
                if (TextUtils.isEmpty(optString2)) {
                    return new b.a.p0.a.u.h.b(202);
                }
                f U = f.U();
                String i2 = U.G().i(optString2);
                this.f9519f = i2;
                if (TextUtils.isEmpty(i2)) {
                    return new b.a.p0.a.u.h.b(2001, "file not found");
                }
                File file = new File(this.f9519f);
                if (file.exists() && file.isFile()) {
                    if (B(file)) {
                        return new b.a.p0.a.u.h.b(2002, "file over size");
                    }
                    if (!b.a.p0.a.d2.d.J().r().M().e(U.getActivity())) {
                        return new b.a.p0.a.u.h.b(10004, "user not logged in");
                    }
                    b.a.p0.a.c1.a.h().b(U.getActivity(), this.f9519f, this);
                    return b.a.p0.a.u.h.b.f();
                }
                return new b.a.p0.a.u.h.b(2001, "file not found");
            }
            return bVar;
        }
        return (b.a.p0.a.u.h.b) invokeL.objValue;
    }

    @Override // b.a.p0.a.y2.a.InterfaceC0490a
    public void c(JSONObject jSONObject, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, jSONObject, str) == null) {
            if (jSONObject == null) {
                d(this.f9520g, new b.a.p0.a.u.h.b(2003, "upload fail"));
                return;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject == null) {
                d(this.f9520g, new b.a.p0.a.u.h.b(2003, "upload fail"));
                return;
            }
            String optString = jSONObject.optString("errno");
            if (!TextUtils.isEmpty(optString) && TextUtils.equals(optString, "0")) {
                b.a.p0.a.k1.e.a a2 = b.a.p0.a.k1.e.a.a(optJSONObject, str);
                if (TextUtils.isEmpty(a2.f6903e)) {
                    d(this.f9520g, new b.a.p0.a.u.h.b(2003, "upload fail"));
                    return;
                } else {
                    ExecutorUtilsExt.postOnElastic(new a(this, a2), "doBosUpload", 2);
                    return;
                }
            }
            d(this.f9520g, new b.a.p0.a.u.h.b(2003, "upload fail"));
        }
    }

    @Override // b.a.p0.a.u.c.d
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "PrivateFile" : (String) invokeV.objValue;
    }

    @Override // b.a.p0.a.u.c.d
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? "UploadBosApi" : (String) invokeV.objValue;
    }
}
