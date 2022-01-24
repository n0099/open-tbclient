package c.a.r0.a.n0.l;

import android.text.TextUtils;
import c.a.r0.a.n0.l.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a implements b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;

    /* renamed from: b  reason: collision with root package name */
    public JSONObject f7965b;

    public a(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        JSONObject jSONObject = new JSONObject();
        this.f7965b = jSONObject;
        this.a = str;
        try {
            jSONObject.put(IntentConfig.PKG_ID, str);
            if (z) {
                update();
            }
        } catch (JSONException e2) {
            if (b.m0) {
                e2.printStackTrace();
            }
        }
    }

    public static a query(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) ? new a(str, true) : (a) invokeL.objValue;
    }

    private void update() throws JSONException {
        PMSAppInfo u;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65538, this) == null) && isValid() && (u = c.a.r0.q.g.a.i().u(this.a)) != null) {
            this.f7965b.put("app_name", u.appName);
            this.f7965b.put("pkg_vername", u.versionName);
            this.f7965b.put("pkg_vercode", u.versionCode);
            this.f7965b.put("create_time", u.createTime);
            this.f7965b.put("last_launch_time", u.getLastLaunchTime());
            this.f7965b.put("launch_count", u.getLaunchCount());
            this.f7965b.put("install_src", u.getInstallSrc());
        }
    }

    @Override // c.a.r0.a.n0.l.b.a
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (String) invokeV.objValue;
    }

    @Override // c.a.r0.a.n0.l.b.a
    public JSONObject b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f7965b : (JSONObject) invokeV.objValue;
    }

    @Override // c.a.r0.a.n0.l.b.a
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? !TextUtils.isEmpty(this.a) : invokeV.booleanValue;
    }
}
