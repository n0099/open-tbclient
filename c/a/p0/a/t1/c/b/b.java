package c.a.p0.a.t1.c.b;

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
    public String f8674a;

    /* renamed from: b  reason: collision with root package name */
    public String f8675b;

    /* renamed from: c  reason: collision with root package name */
    public String f8676c;

    /* renamed from: d  reason: collision with root package name */
    public String f8677d;

    /* renamed from: e  reason: collision with root package name */
    public String f8678e;

    /* renamed from: f  reason: collision with root package name */
    public String f8679f;

    /* renamed from: g  reason: collision with root package name */
    public JSONObject f8680g;

    /* renamed from: h  reason: collision with root package name */
    public String f8681h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.p0.a.u.h.b f8682i;

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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (TextUtils.isEmpty(this.f8674a) || TextUtils.isEmpty(this.f8676c) || TextUtils.isEmpty(this.f8677d) || TextUtils.isEmpty(this.f8679f) || TextUtils.isEmpty(this.f8678e)) ? false : true : invokeV.booleanValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            c.a.p0.a.u.h.b bVar = this.f8682i;
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
            sb.append(this.f8674a);
            sb.append(ExtendedMessageFormat.QUOTE);
            sb.append(", providerRootPath='");
            sb.append(this.f8676c);
            sb.append(ExtendedMessageFormat.QUOTE);
            sb.append(", providerVersion='");
            sb.append(this.f8677d);
            sb.append(ExtendedMessageFormat.QUOTE);
            sb.append(", componentId='");
            sb.append(this.f8679f);
            sb.append(ExtendedMessageFormat.QUOTE);
            sb.append(", cb='");
            sb.append(this.f8681h);
            sb.append(ExtendedMessageFormat.QUOTE);
            sb.append(", pageParams=");
            sb.append(this.f8680g);
            sb.append(", swanApiResult=");
            c.a.p0.a.u.h.b bVar = this.f8682i;
            sb.append(bVar == null ? null : bVar.a());
            sb.append(ExtendedMessageFormat.END_FE);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
