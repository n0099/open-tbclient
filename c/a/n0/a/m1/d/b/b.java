package c.a.n0.a.m1.d.b;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f5447b;

    /* renamed from: c  reason: collision with root package name */
    public String f5448c;

    /* renamed from: d  reason: collision with root package name */
    public String f5449d;

    /* renamed from: e  reason: collision with root package name */
    public String f5450e;

    /* renamed from: f  reason: collision with root package name */
    public String f5451f;

    /* renamed from: g  reason: collision with root package name */
    public JSONObject f5452g;

    /* renamed from: h  reason: collision with root package name */
    public String f5453h;
    public c.a.n0.a.k.h.b i;

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (TextUtils.isEmpty(this.a) || TextUtils.isEmpty(this.f5448c) || TextUtils.isEmpty(this.f5449d) || TextUtils.isEmpty(this.f5451f) || TextUtils.isEmpty(this.f5450e)) ? false : true : invokeV.booleanValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            c.a.n0.a.k.h.b bVar = this.i;
            return (bVar == null || bVar.isSuccess()) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("SwanPluginFunPageModel{providerAppKey='");
            sb.append(this.a);
            sb.append('\'');
            sb.append(", providerRootPath='");
            sb.append(this.f5448c);
            sb.append('\'');
            sb.append(", providerVersion='");
            sb.append(this.f5449d);
            sb.append('\'');
            sb.append(", componentId='");
            sb.append(this.f5451f);
            sb.append('\'');
            sb.append(", cb='");
            sb.append(this.f5453h);
            sb.append('\'');
            sb.append(", pageParams=");
            sb.append(this.f5452g);
            sb.append(", swanApiResult=");
            c.a.n0.a.k.h.b bVar = this.i;
            sb.append(bVar == null ? null : bVar.a());
            sb.append('}');
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
