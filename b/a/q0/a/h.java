package b.a.q0.a;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.DecryptCode.DataRes;
/* loaded from: classes4.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public static final String l;
    public static final String m;
    public static final String n;
    public static final String o;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f11787a;

    /* renamed from: b  reason: collision with root package name */
    public String f11788b;

    /* renamed from: c  reason: collision with root package name */
    public String f11789c;

    /* renamed from: d  reason: collision with root package name */
    public String f11790d;

    /* renamed from: e  reason: collision with root package name */
    public String f11791e;

    /* renamed from: f  reason: collision with root package name */
    public String f11792f;

    /* renamed from: g  reason: collision with root package name */
    public String f11793g;

    /* renamed from: h  reason: collision with root package name */
    public String f11794h;

    /* renamed from: i  reason: collision with root package name */
    public int f11795i;
    public String j;
    public Integer k;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(274104970, "Lb/a/q0/a/h;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(274104970, "Lb/a/q0/a/h;");
                return;
            }
        }
        l = TbadkCoreApplication.getInst().getString(R.string.tb_token);
        m = TbadkCoreApplication.getInst().getString(R.string.tb_ai_apps_tips);
        n = TbadkCoreApplication.getInst().getString(R.string.cancel);
        o = TbadkCoreApplication.getInst().getString(R.string.check_immediately);
    }

    public h() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f11787a = "";
        this.f11788b = "";
        this.f11789c = "";
        this.f11790d = "";
        this.f11791e = "";
        this.f11792f = "";
        this.f11793g = "";
        this.f11794h = "";
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f11792f : (String) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f11791e : (String) invokeV.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f11788b : (String) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f11789c : (String) invokeV.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f11787a : (String) invokeV.objValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f11790d : (String) invokeV.objValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f11795i : invokeV.intValue;
    }

    public void h(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, dataRes) == null) {
            int intValue = dataRes.type.intValue();
            this.f11795i = intValue;
            if (intValue != 0 && intValue != 1) {
                if (intValue == 2) {
                    this.f11787a = dataRes.title;
                    this.f11790d = dataRes.url;
                    return;
                } else if (intValue != 4 && intValue == 3) {
                    this.f11790d = dataRes.url;
                    this.f11787a = dataRes.title;
                    this.f11788b = dataRes.img;
                    this.f11789c = dataRes.tips;
                    this.f11791e = dataRes.btn_sure;
                    this.f11792f = dataRes.btn_cancel;
                    return;
                } else {
                    return;
                }
            }
            this.f11787a = StringUtils.isNull(dataRes.title) ? l : dataRes.title;
            this.f11788b = dataRes.img;
            this.f11789c = StringUtils.isNull(dataRes.tips) ? m : dataRes.tips;
            if (!StringUtils.isNull(dataRes.url)) {
                try {
                    JSONObject jSONObject = new JSONObject(dataRes.url);
                    this.f11793g = jSONObject.optString("appid");
                    this.f11794h = jSONObject.optString("appname");
                    String optString = jSONObject.optString("url");
                    Integer valueOf = Integer.valueOf(jSONObject.optInt("is_game"));
                    this.k = valueOf;
                    this.f11790d = b.a.r0.v.a.a(this.f11793g, optString, "9104", valueOf);
                    this.j = jSONObject.optString("swan_app_id");
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            this.f11791e = StringUtils.isNull(dataRes.btn_sure) ? o : dataRes.btn_sure;
            this.f11792f = StringUtils.isNull(dataRes.btn_cancel) ? n : dataRes.btn_cancel;
        }
    }
}
