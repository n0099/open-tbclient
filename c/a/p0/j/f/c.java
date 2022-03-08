package c.a.p0.j.f;

import androidx.annotation.NonNull;
import c.a.p0.a.p2.k;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c extends c.a.p0.a.e0.d.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public String f10438d;

    /* renamed from: e  reason: collision with root package name */
    public String f10439e;

    /* renamed from: f  reason: collision with root package name */
    public String f10440f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NonNull String str, String str2, String str3, String str4) {
        super(str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3, str4};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f10438d = str2;
        this.f10439e = str3;
        this.f10440f = str4;
    }

    public static c.a.p0.a.e0.d.c t(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, str2)) == null) ? new c("sconsole_console", "%s.message = { type:'log',logType:'%s',logs:[%s, %s] };", str, str2) : (c.a.p0.a.e0.d.c) invokeLL.objValue;
    }

    public static c.a.p0.a.e0.d.c u(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65538, null, z)) == null) {
            return new c("sconsole_entirety", "%s.message = { type:'act',act:'%s' };", null, z ? "show" : "hide");
        }
        return (c.a.p0.a.e0.d.c) invokeZ.objValue;
    }

    public static c.a.p0.a.e0.d.c v(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, str2)) == null) ? new c("sconsole_system", "%s.message = { type:'log',logType:'%s',logs:[%s] };", str, str2) : (c.a.p0.a.e0.d.c) invokeLL.objValue;
    }

    @Override // c.a.p0.a.e0.d.b
    public String o(String str) {
        InterceptResult invokeL;
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            String str2 = this.f10438d;
            int hashCode = str2.hashCode();
            if (hashCode == -2011830027) {
                if (str2.equals("%s.message = { type:'act',act:'%s' };")) {
                    c2 = 2;
                }
                c2 = 65535;
            } else if (hashCode != -774049378) {
                if (hashCode == 2080164540 && str2.equals("%s.message = { type:'log',logType:'%s',logs:[%s] };")) {
                    c2 = 1;
                }
                c2 = 65535;
            } else {
                if (str2.equals("%s.message = { type:'log',logType:'%s',logs:[%s, %s] };")) {
                    c2 = 0;
                }
                c2 = 65535;
            }
            if (c2 != 0) {
                return c2 != 1 ? c2 != 2 ? "" : String.format("%s.message = { type:'act',act:'%s' };", str, this.f10440f) : String.format("%s.message = { type:'log',logType:'%s',logs:[%s] };", str, this.f10439e, JSONObject.quote(this.f10440f));
            }
            return String.format("%s.message = { type:'log',logType:'%s',logs:[%s, %s] };", str, this.f10439e, JSONObject.quote(k.b(k.a(), "yyyy-MM-dd HH:mm:ss")), JSONObject.quote(this.f10440f));
        }
        return (String) invokeL.objValue;
    }
}
