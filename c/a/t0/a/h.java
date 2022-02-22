package c.a.t0.a;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
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
/* loaded from: classes6.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public static final String l;
    public static final String m;
    public static final String n;
    public static final String o;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f12371b;

    /* renamed from: c  reason: collision with root package name */
    public String f12372c;

    /* renamed from: d  reason: collision with root package name */
    public String f12373d;

    /* renamed from: e  reason: collision with root package name */
    public String f12374e;

    /* renamed from: f  reason: collision with root package name */
    public String f12375f;

    /* renamed from: g  reason: collision with root package name */
    public String f12376g;

    /* renamed from: h  reason: collision with root package name */
    public String f12377h;

    /* renamed from: i  reason: collision with root package name */
    public int f12378i;

    /* renamed from: j  reason: collision with root package name */
    public String f12379j;
    public Integer k;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1139664654, "Lc/a/t0/a/h;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1139664654, "Lc/a/t0/a/h;");
                return;
            }
        }
        l = TbadkCoreApplication.getInst().getString(c.a.u0.a4.j.tb_token);
        m = TbadkCoreApplication.getInst().getString(c.a.u0.a4.j.tb_ai_apps_tips);
        n = TbadkCoreApplication.getInst().getString(c.a.u0.a4.j.cancel);
        o = TbadkCoreApplication.getInst().getString(c.a.u0.a4.j.check_immediately);
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
        this.a = "";
        this.f12371b = "";
        this.f12372c = "";
        this.f12373d = "";
        this.f12374e = "";
        this.f12375f = "";
        this.f12376g = "";
        this.f12377h = "";
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f12375f : (String) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f12374e : (String) invokeV.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f12371b : (String) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f12372c : (String) invokeV.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a : (String) invokeV.objValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f12373d : (String) invokeV.objValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f12378i : invokeV.intValue;
    }

    public void h(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, dataRes) == null) {
            int intValue = dataRes.type.intValue();
            this.f12378i = intValue;
            if (intValue != 0 && intValue != 1) {
                if (intValue == 2) {
                    this.a = dataRes.title;
                    this.f12373d = dataRes.url;
                    return;
                } else if (intValue != 4 && intValue == 3) {
                    this.f12373d = dataRes.url;
                    this.a = dataRes.title;
                    this.f12371b = dataRes.img;
                    this.f12372c = dataRes.tips;
                    this.f12374e = dataRes.btn_sure;
                    this.f12375f = dataRes.btn_cancel;
                    return;
                } else {
                    return;
                }
            }
            this.a = StringUtils.isNull(dataRes.title) ? l : dataRes.title;
            this.f12371b = dataRes.img;
            this.f12372c = StringUtils.isNull(dataRes.tips) ? m : dataRes.tips;
            if (!StringUtils.isNull(dataRes.url)) {
                try {
                    JSONObject jSONObject = new JSONObject(dataRes.url);
                    this.f12376g = jSONObject.optString("appid");
                    this.f12377h = jSONObject.optString("appname");
                    String optString = jSONObject.optString("url");
                    Integer valueOf = Integer.valueOf(jSONObject.optInt("is_game"));
                    this.k = valueOf;
                    this.f12373d = c.a.u0.z.a.a(this.f12376g, optString, "9104", valueOf);
                    this.f12379j = jSONObject.optString("swan_app_id");
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            this.f12374e = StringUtils.isNull(dataRes.btn_sure) ? o : dataRes.btn_sure;
            this.f12375f = StringUtils.isNull(dataRes.btn_cancel) ? n : dataRes.btn_cancel;
        }
    }
}
