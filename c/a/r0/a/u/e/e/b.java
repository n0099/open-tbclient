package c.a.r0.a.u.e.e;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import c.a.r0.a.d2.e;
import c.a.r0.a.e0.d;
import c.a.r0.a.z2.q;
import c.a.r0.a.z2.u;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.storage.PathType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b extends c.a.r0.a.u.e.e.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ File f9118e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f9119f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f9120g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ e f9121h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ b f9122i;

        public a(b bVar, File file, int i2, String str, e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, file, Integer.valueOf(i2), str, eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9122i = bVar;
            this.f9118e = file;
            this.f9119f = i2;
            this.f9120g = str;
            this.f9121h = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                File k = u.k(this.f9118e.getName());
                if (!u.b(this.f9118e, k, this.f9119f)) {
                    d.c("ImageApi", "compress image failed");
                    this.f9122i.d(this.f9120g, new c.a.r0.a.u.h.b(1001, "compress image failed"));
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("tempFilePath", c.a.r0.a.o2.b.J(k.getAbsolutePath(), this.f9121h.f5679f));
                } catch (JSONException e2) {
                    d.c("ImageApi", e2.toString());
                }
                this.f9122i.d(this.f9120g, new c.a.r0.a.u.h.b(0, jSONObject));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NonNull c.a.r0.a.u.c.b bVar) {
        super(bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((c.a.r0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.r0.a.u.c.d
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "ImageApi" : (String) invokeV.objValue;
    }

    public c.a.r0.a.u.h.b x(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#compressImage", false);
            Pair<c.a.r0.a.u.h.b, JSONObject> s = s(str);
            c.a.r0.a.u.h.b bVar = (c.a.r0.a.u.h.b) s.first;
            if (bVar.isSuccess()) {
                JSONObject jSONObject = (JSONObject) s.second;
                String optString = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    d.c("ImageApi", "cb is empty");
                    return new c.a.r0.a.u.h.b(202, "cb is empty");
                }
                return y(optString, jSONObject.optString("src"), jSONObject.optInt("quality", 80));
            }
            return bVar;
        }
        return (c.a.r0.a.u.h.b) invokeL.objValue;
    }

    public final c.a.r0.a.u.h.b y(String str, String str2, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, str, str2, i2)) == null) {
            e a0 = e.a0();
            if (a0 == null) {
                return new c.a.r0.a.u.h.b(1001, "swan app is null");
            }
            int i3 = (i2 < 0 || i2 > 100) ? 80 : i2;
            if (TextUtils.isEmpty(str2)) {
                d.c("ImageApi", "src is null");
                return new c.a.r0.a.u.h.b(202, "src is null");
            }
            PathType s = c.a.r0.a.o2.b.s(str2);
            String str3 = null;
            if (s == PathType.BD_FILE) {
                str3 = c.a.r0.a.o2.b.M(str2, a0.f5679f);
            } else if (s == PathType.RELATIVE) {
                str3 = c.a.r0.a.o2.b.L(str2, a0, a0.j0());
            }
            if (TextUtils.isEmpty(str3)) {
                d.c("ImageApi", "file path error");
                return new c.a.r0.a.u.h.b(2001, "file path error");
            }
            File file = new File(str3);
            if (!file.exists()) {
                d.c("ImageApi", "file does not exist");
                return new c.a.r0.a.u.h.b(2001, "file does not exist");
            }
            q.k(new a(this, file, i3, str, a0), "compressImage");
            return c.a.r0.a.u.h.b.f();
        }
        return (c.a.r0.a.u.h.b) invokeLLI.objValue;
    }
}
