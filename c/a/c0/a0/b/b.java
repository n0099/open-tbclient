package c.a.c0.a0.b;

import c.a.c0.a0.c.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ClogBuilder.LogType a;

    /* renamed from: b  reason: collision with root package name */
    public String f1724b;

    /* renamed from: c  reason: collision with root package name */
    public String f1725c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f1726d;

    public b(ClogBuilder.LogType logType, String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {logType, str, str2, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f1725c = "";
        this.a = logType;
        this.f1724b = str;
        this.f1725c = str2;
        this.f1726d = z;
    }

    public e a(int i2, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i2, str)) == null) ? b(i2, str, "normal") : (e) invokeIL.objValue;
    }

    public e b(int i2, String str, String str2) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str, str2)) == null) {
            e eVar = new e();
            try {
                eVar.f("1030").g(this.f1725c).a("f1", this.a.type).a("f2", str2).a("f3", URLEncoder.encode(this.f1724b, "utf-8")).a("f4", String.valueOf(i2)).a("f5", str);
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
            return eVar;
        }
        return (e) invokeILL.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f1726d : invokeV.booleanValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f1724b : (String) invokeV.objValue;
    }
}
