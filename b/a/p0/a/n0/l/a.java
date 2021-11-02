package b.a.p0.a.n0.l;

import android.text.TextUtils;
import b.a.p0.a.n0.l.b;
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

    /* renamed from: a  reason: collision with root package name */
    public final String f6876a;

    /* renamed from: b  reason: collision with root package name */
    public JSONObject f6877b;

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
        this.f6877b = jSONObject;
        this.f6876a = str;
        try {
            jSONObject.put(IntentConfig.PKG_ID, str);
            if (z) {
                update();
            }
        } catch (JSONException e2) {
            if (b.e0) {
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
        PMSAppInfo s;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65538, this) == null) && isValid() && (s = b.a.p0.n.g.a.h().s(this.f6876a)) != null) {
            this.f6877b.put("app_name", s.appName);
            this.f6877b.put("pkg_vername", s.versionName);
            this.f6877b.put("pkg_vercode", s.versionCode);
            this.f6877b.put("create_time", s.createTime);
            this.f6877b.put("last_launch_time", s.getLastLaunchTime());
            this.f6877b.put("launch_count", s.getLaunchCount());
            this.f6877b.put("install_src", s.getInstallSrc());
        }
    }

    @Override // b.a.p0.a.n0.l.b.a
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f6876a : (String) invokeV.objValue;
    }

    @Override // b.a.p0.a.n0.l.b.a
    public JSONObject b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f6877b : (JSONObject) invokeV.objValue;
    }

    @Override // b.a.p0.a.n0.l.b.a
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? !TextUtils.isEmpty(this.f6876a) : invokeV.booleanValue;
    }
}
