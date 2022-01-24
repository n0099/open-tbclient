package c.a.r0.a.q;

import c.a.r0.a.k;
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
    public String f8528b;

    /* renamed from: c  reason: collision with root package name */
    public String f8529c;

    /* renamed from: d  reason: collision with root package name */
    public int f8530d;

    /* renamed from: e  reason: collision with root package name */
    public int f8531e;

    /* renamed from: f  reason: collision with root package name */
    public int f8532f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f8533g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-678726610, "Lc/a/r0/a/q/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-678726610, "Lc/a/r0/a/q/d;");
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
        this.f8528b = str2;
        this.f8529c = str3;
        this.f8530d = i2;
        this.f8531e = i3;
        this.f8532f = i4;
        this.f8533g = z;
    }

    public c.a.r0.a.j1.g.c a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("showMuteBtn", true);
                jSONObject.put("showCenterPlayBtn", true);
                c.a.r0.a.j1.g.c cVar = new c.a.r0.a.j1.g.c();
                cVar.n = "SwanAdPlayer";
                cVar.f5450f = "SwanAdPlayer";
                cVar.s = true;
                cVar.o = false;
                cVar.B = !this.f8533g;
                cVar.M = false;
                cVar.p = this.a;
                cVar.C = this.f8528b;
                cVar.f5451g = this.f8529c;
                c.a.r0.a.m1.e.a.a aVar = new c.a.r0.a.m1.e.a.a(0, 0, this.f8530d, this.f8531e);
                cVar.l = aVar;
                aVar.j(true);
                cVar.q = this.f8532f;
                if (this.f8533g) {
                    cVar.u = AlaLiveRoomActivityConfig.SDK_LIVE_COVER_KEY;
                }
                return c.a.r0.a.j1.g.c.i(jSONObject, cVar);
            } catch (JSONException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (c.a.r0.a.j1.g.c) invokeV.objValue;
    }
}
