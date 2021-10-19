package c.a.q0.t.c;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class m0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f14722a;

    /* renamed from: b  reason: collision with root package name */
    public long f14723b;

    /* renamed from: c  reason: collision with root package name */
    public long f14724c;

    /* renamed from: d  reason: collision with root package name */
    public long f14725d;

    /* renamed from: e  reason: collision with root package name */
    public String f14726e;

    /* renamed from: f  reason: collision with root package name */
    public String f14727f;

    public m0() {
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

    public long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f14724c : invokeV.longValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f14727f : (String) invokeV.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f14726e : (String) invokeV.objValue;
    }

    public long d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f14725d : invokeV.longValue;
    }

    public long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f14723b : invokeV.longValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f14722a : (String) invokeV.objValue;
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || c.a.e.e.p.k.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f14722a = jSONObject.optString("splash_video_url");
            this.f14723b = jSONObject.optLong("splash_video_start_time") * 1000;
            this.f14724c = jSONObject.optLong("splash_video_end_time") * 1000;
            this.f14725d = jSONObject.optLong("splash_video_interval_time") * 1000;
            this.f14726e = jSONObject.optString("splash_video_h5_url");
            this.f14727f = jSONObject.optString("splash_video_h5_text");
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }
}
