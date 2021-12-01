package c.a.r0.q3.f;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.frs.itemtab.gamecode.GameCodeGetResponseMsg;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Date;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public abstract class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public int f22616b;

    public a() {
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

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f22616b : invokeV.intValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : (String) invokeV.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a != null : invokeV.booleanValue;
    }

    public abstract void d(JSONObject jSONObject) throws Exception;

    public void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            try {
                f(new JSONObject(str));
            } catch (Exception e2) {
                g("网络不给力呀");
                e2.printStackTrace();
            }
        }
    }

    public void f(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, jSONObject) == null) {
            try {
                int optInt = jSONObject.optInt("error_code", 0);
                this.f22616b = optInt;
                if (optInt != 0) {
                    g(jSONObject.optString(GameCodeGetResponseMsg.PARAM_ERROR_MSG, "网络不给力呀"));
                    return;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("error");
                if (optJSONObject != null) {
                    int optInt2 = optJSONObject.optInt("errno", 0);
                    this.f22616b = optInt2;
                    if (optInt2 != 0) {
                        g(optJSONObject.optString(VideoFinishResult.KEY_ERROR_USER_MSG, "网络不给力呀"));
                        return;
                    }
                }
                long optLong = jSONObject.optLong("ctime", 0L);
                if (optLong > 0) {
                    new Date(optLong * 1000);
                }
                d(jSONObject);
            } catch (Exception e2) {
                g("网络不给力呀");
                e2.printStackTrace();
            }
        }
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.a = str;
        }
    }
}
