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
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f8040a;

    /* renamed from: b  reason: collision with root package name */
    public String f8041b;

    /* renamed from: c  reason: collision with root package name */
    public String f8042c;

    /* renamed from: d  reason: collision with root package name */
    public int f8043d;

    /* renamed from: e  reason: collision with root package name */
    public int f8044e;

    /* renamed from: f  reason: collision with root package name */
    public int f8045f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f8046g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1358785011, "Lc/a/p0/a/q/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1358785011, "Lc/a/p0/a/q/c;");
                return;
            }
        }
        boolean z = k.f7085a;
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
        this.f8040a = str;
        this.f8041b = str2;
        this.f8042c = str3;
        this.f8043d = i2;
        this.f8044e = i3;
        this.f8045f = i4;
        this.f8046g = z;
    }

    public c.a.p0.a.i1.g.c a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("showMuteBtn", true);
                jSONObject.put("showCenterPlayBtn", true);
                c.a.p0.a.i1.g.c cVar = new c.a.p0.a.i1.g.c();
                cVar.n = "SwanAdPlayer";
                cVar.f4665f = "SwanAdPlayer";
                cVar.s = true;
                cVar.o = false;
                cVar.B = !this.f8046g;
                cVar.M = false;
                cVar.p = this.f8040a;
                cVar.C = this.f8041b;
                cVar.f4666g = this.f8042c;
                c.a.p0.a.l1.e.a.a aVar = new c.a.p0.a.l1.e.a.a(0, 0, this.f8043d, this.f8044e);
                cVar.l = aVar;
                aVar.l(true);
                cVar.q = this.f8045f;
                if (this.f8046g) {
                    cVar.u = AlaLiveRoomActivityConfig.SDK_LIVE_COVER_KEY;
                }
                return c.a.p0.a.i1.g.c.j(jSONObject, cVar);
            } catch (JSONException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (c.a.p0.a.i1.g.c) invokeV.objValue;
    }
}
