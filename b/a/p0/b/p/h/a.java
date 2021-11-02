package b.a.p0.b.p.h;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import androidx.transition.Transition;
import b.a.p0.a.a2.e;
import b.a.p0.a.f1.e.b;
import b.a.p0.a.k;
import b.a.p0.a.p.d.v0;
import b.a.p0.t.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.searchbox.common.runtime.AppRuntime;
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
@Singleton
@Service
/* loaded from: classes.dex */
public class a implements v0 {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f9496b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b.a.d0.a f9497a;

    /* renamed from: b.a.p0.b.p.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0500a extends b.a.e0.l.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ long f9498a;

        public C0500a(a aVar, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9498a = j;
        }

        @Override // b.a.e0.l.a
        public void a(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                if (a.f9496b) {
                    String str2 = "requestBatchRebateInfo onResult: " + i2 + " " + str;
                }
                d.i(a.e());
                d.M(String.valueOf(this.f9498a), a.e());
            }
        }
    }

    /* loaded from: classes.dex */
    public class b extends b.a.e0.l.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(a aVar) {
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
                }
            }
        }

        @Override // b.a.e0.l.a
        public void a(int i2, String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) && a.f9496b) {
                String str2 = "requestSingleRebateInfo onResult: " + i2 + " " + str;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(84432277, "Lb/a/p0/b/p/h/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(84432277, "Lb/a/p0/b/p/h/a;");
                return;
            }
        }
        f9496b = k.f6397a;
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f9497a = new b.a.d0.a();
    }

    public static File e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? new File(AppRuntime.getAppContext().getFilesDir().getPath(), "rebate_info_timestamp") : (File) invokeV.objValue;
    }

    @Override // b.a.p0.a.p.d.v0
    public boolean a(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        e P;
        b.a K;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, str, str2, str3)) == null) {
            if (!b.a.p0.a.d2.e.l() || (P = e.P()) == null || (K = P.K()) == null) {
                return false;
            }
            f(str, b.a.p0.r.e.g().v(AppRuntime.getAppContext()), b.a.p0.a.c1.a.a0().i(b.a.p0.a.c1.a.b()), b.a.p0.b.l.a.i(P.getApplicationContext()), str2, str3, b.a.p0.a.c1.a.m().a(), K.S());
            return true;
        }
        return invokeLLL.booleanValue;
    }

    @Override // b.a.p0.a.p.d.v0
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            String D = d.D(e());
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (!TextUtils.isEmpty(D)) {
                try {
                    if (currentTimeMillis - Long.parseLong(D) < 86400) {
                        boolean z = f9496b;
                        return;
                    }
                } catch (NumberFormatException e2) {
                    if (f9496b) {
                        e2.printStackTrace();
                        return;
                    }
                    return;
                }
            }
            this.f9497a.l(new C0500a(this, currentTimeMillis));
        }
    }

    public final void f(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, str2, str3, str4, str5, str6, str7, str8}) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("masterId", str);
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put("userPassId", str2);
                }
                jSONObject.put("cuid", str3);
                jSONObject.put("bduss", str4);
                jSONObject.put(Transition.MATCH_ITEM_ID_STR, str5);
                jSONObject.put("businessId", str6);
                jSONObject.put("naid", str7);
                jSONObject.put("scene", str8);
                this.f9497a.k(jSONObject, new b(this));
            } catch (JSONException e2) {
                if (f9496b) {
                    e2.printStackTrace();
                }
            }
        }
    }
}
