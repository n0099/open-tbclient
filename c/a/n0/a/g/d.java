package c.a.n0.a.g;

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
    public String f4529b;

    /* renamed from: c  reason: collision with root package name */
    public String f4530c;

    /* renamed from: d  reason: collision with root package name */
    public int f4531d;

    /* renamed from: e  reason: collision with root package name */
    public int f4532e;

    /* renamed from: f  reason: collision with root package name */
    public int f4533f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f4534g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2039141260, "Lc/a/n0/a/g/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2039141260, "Lc/a/n0/a/g/d;");
                return;
            }
        }
        boolean z = c.a.n0.a.a.a;
    }

    public d(String str, String str2, String str3, int i, int i2, int i3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = str;
        this.f4529b = str2;
        this.f4530c = str3;
        this.f4531d = i;
        this.f4532e = i2;
        this.f4533f = i3;
        this.f4534g = z;
    }

    public c.a.n0.a.z0.g.c a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("showMuteBtn", true);
                jSONObject.put("showCenterPlayBtn", true);
                c.a.n0.a.z0.g.c cVar = new c.a.n0.a.z0.g.c();
                cVar.j = "SwanAdPlayer";
                cVar.f6096b = "SwanAdPlayer";
                cVar.o = true;
                cVar.k = false;
                cVar.x = !this.f4534g;
                cVar.I = false;
                cVar.l = this.a;
                cVar.y = this.f4529b;
                cVar.f6097c = this.f4530c;
                c.a.n0.a.c1.e.a.a aVar = new c.a.n0.a.c1.e.a.a(0, 0, this.f4531d, this.f4532e);
                cVar.f6102h = aVar;
                aVar.i(true);
                cVar.m = this.f4533f;
                if (this.f4534g) {
                    cVar.q = AlaLiveRoomActivityConfig.SDK_LIVE_COVER_KEY;
                }
                return c.a.n0.a.z0.g.c.h(jSONObject, cVar);
            } catch (JSONException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (c.a.n0.a.z0.g.c) invokeV.objValue;
    }
}
