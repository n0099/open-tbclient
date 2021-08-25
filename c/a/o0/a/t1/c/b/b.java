package c.a.o0.a.t1.c.b;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f8638a;

    /* renamed from: b  reason: collision with root package name */
    public String f8639b;

    /* renamed from: c  reason: collision with root package name */
    public String f8640c;

    /* renamed from: d  reason: collision with root package name */
    public String f8641d;

    /* renamed from: e  reason: collision with root package name */
    public String f8642e;

    /* renamed from: f  reason: collision with root package name */
    public String f8643f;

    /* renamed from: g  reason: collision with root package name */
    public JSONObject f8644g;

    /* renamed from: h  reason: collision with root package name */
    public String f8645h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.o0.a.u.h.b f8646i;

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (TextUtils.isEmpty(this.f8638a) || TextUtils.isEmpty(this.f8640c) || TextUtils.isEmpty(this.f8641d) || TextUtils.isEmpty(this.f8643f) || TextUtils.isEmpty(this.f8642e)) ? false : true : invokeV.booleanValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            c.a.o0.a.u.h.b bVar = this.f8646i;
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
            sb.append(this.f8638a);
            sb.append(ExtendedMessageFormat.QUOTE);
            sb.append(", providerRootPath='");
            sb.append(this.f8640c);
            sb.append(ExtendedMessageFormat.QUOTE);
            sb.append(", providerVersion='");
            sb.append(this.f8641d);
            sb.append(ExtendedMessageFormat.QUOTE);
            sb.append(", componentId='");
            sb.append(this.f8643f);
            sb.append(ExtendedMessageFormat.QUOTE);
            sb.append(", cb='");
            sb.append(this.f8645h);
            sb.append(ExtendedMessageFormat.QUOTE);
            sb.append(", pageParams=");
            sb.append(this.f8644g);
            sb.append(", swanApiResult=");
            c.a.o0.a.u.h.b bVar = this.f8646i;
            sb.append(bVar == null ? null : bVar.a());
            sb.append(ExtendedMessageFormat.END_FE);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
