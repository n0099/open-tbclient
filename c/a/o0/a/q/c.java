package c.a.o0.a.q;

import c.a.o0.a.k;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f8004a;

    /* renamed from: b  reason: collision with root package name */
    public String f8005b;

    /* renamed from: c  reason: collision with root package name */
    public String f8006c;

    /* renamed from: d  reason: collision with root package name */
    public int f8007d;

    /* renamed from: e  reason: collision with root package name */
    public int f8008e;

    /* renamed from: f  reason: collision with root package name */
    public int f8009f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f8010g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(448669452, "Lc/a/o0/a/q/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(448669452, "Lc/a/o0/a/q/c;");
                return;
            }
        }
        boolean z = k.f7049a;
    }

    public c(String str, String str2, String str3, int i2, int i3, int i4, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f8004a = str;
        this.f8005b = str2;
        this.f8006c = str3;
        this.f8007d = i2;
        this.f8008e = i3;
        this.f8009f = i4;
        this.f8010g = z;
    }

    public c.a.o0.a.i1.g.c a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("showMuteBtn", true);
                jSONObject.put("showCenterPlayBtn", true);
                c.a.o0.a.i1.g.c cVar = new c.a.o0.a.i1.g.c();
                cVar.n = "SwanAdPlayer";
                cVar.f4629f = "SwanAdPlayer";
                cVar.s = true;
                cVar.o = false;
                cVar.B = !this.f8010g;
                cVar.M = false;
                cVar.p = this.f8004a;
                cVar.C = this.f8005b;
                cVar.f4630g = this.f8006c;
                c.a.o0.a.l1.e.a.a aVar = new c.a.o0.a.l1.e.a.a(0, 0, this.f8007d, this.f8008e);
                cVar.l = aVar;
                aVar.l(true);
                cVar.q = this.f8009f;
                if (this.f8010g) {
                    cVar.u = AlaLiveRoomActivityConfig.SDK_LIVE_COVER_KEY;
                }
                return c.a.o0.a.i1.g.c.j(jSONObject, cVar);
            } catch (JSONException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (c.a.o0.a.i1.g.c) invokeV.objValue;
    }
}
