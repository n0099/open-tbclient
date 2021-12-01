package c.a.p0.a.q;

import c.a.p0.a.k;
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
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f7526b;

    /* renamed from: c  reason: collision with root package name */
    public String f7527c;

    /* renamed from: d  reason: collision with root package name */
    public int f7528d;

    /* renamed from: e  reason: collision with root package name */
    public int f7529e;

    /* renamed from: f  reason: collision with root package name */
    public int f7530f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f7531g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1358784980, "Lc/a/p0/a/q/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1358784980, "Lc/a/p0/a/q/d;");
                return;
            }
        }
        boolean z = k.a;
    }

    public d(String str, String str2, String str3, int i2, int i3, int i4, boolean z) {
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
        this.a = str;
        this.f7526b = str2;
        this.f7527c = str3;
        this.f7528d = i2;
        this.f7529e = i3;
        this.f7530f = i4;
        this.f7531g = z;
    }

    public c.a.p0.a.j1.g.c a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("showMuteBtn", true);
                jSONObject.put("showCenterPlayBtn", true);
                c.a.p0.a.j1.g.c cVar = new c.a.p0.a.j1.g.c();
                cVar.n = "SwanAdPlayer";
                cVar.f4377f = "SwanAdPlayer";
                cVar.s = true;
                cVar.o = false;
                cVar.B = !this.f7531g;
                cVar.M = false;
                cVar.p = this.a;
                cVar.C = this.f7526b;
                cVar.f4378g = this.f7527c;
                c.a.p0.a.m1.e.a.a aVar = new c.a.p0.a.m1.e.a.a(0, 0, this.f7528d, this.f7529e);
                cVar.l = aVar;
                aVar.j(true);
                cVar.q = this.f7530f;
                if (this.f7531g) {
                    cVar.u = AlaLiveRoomActivityConfig.SDK_LIVE_COVER_KEY;
                }
                return c.a.p0.a.j1.g.c.i(jSONObject, cVar);
            } catch (JSONException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (c.a.p0.a.j1.g.c) invokeV.objValue;
    }
}
