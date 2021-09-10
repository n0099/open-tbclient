package c.a.q0.a;

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
/* loaded from: classes3.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public static final String l;
    public static final String m;
    public static final String n;
    public static final String o;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f12612a;

    /* renamed from: b  reason: collision with root package name */
    public String f12613b;

    /* renamed from: c  reason: collision with root package name */
    public String f12614c;

    /* renamed from: d  reason: collision with root package name */
    public String f12615d;

    /* renamed from: e  reason: collision with root package name */
    public String f12616e;

    /* renamed from: f  reason: collision with root package name */
    public String f12617f;

    /* renamed from: g  reason: collision with root package name */
    public String f12618g;

    /* renamed from: h  reason: collision with root package name */
    public String f12619h;

    /* renamed from: i  reason: collision with root package name */
    public int f12620i;

    /* renamed from: j  reason: collision with root package name */
    public String f12621j;
    public Integer k;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1522846389, "Lc/a/q0/a/h;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1522846389, "Lc/a/q0/a/h;");
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
        this.f12612a = "";
        this.f12613b = "";
        this.f12614c = "";
        this.f12615d = "";
        this.f12616e = "";
        this.f12617f = "";
        this.f12618g = "";
        this.f12619h = "";
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f12617f : (String) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f12616e : (String) invokeV.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f12613b : (String) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f12614c : (String) invokeV.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f12612a : (String) invokeV.objValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f12615d : (String) invokeV.objValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f12620i : invokeV.intValue;
    }

    public void h(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, dataRes) == null) {
            int intValue = dataRes.type.intValue();
            this.f12620i = intValue;
            if (intValue != 0 && intValue != 1) {
                if (intValue == 2) {
                    this.f12612a = dataRes.title;
                    this.f12615d = dataRes.url;
                    return;
                } else if (intValue != 4 && intValue == 3) {
                    this.f12615d = dataRes.url;
                    this.f12612a = dataRes.title;
                    this.f12613b = dataRes.img;
                    this.f12614c = dataRes.tips;
                    this.f12616e = dataRes.btn_sure;
                    this.f12617f = dataRes.btn_cancel;
                    return;
                } else {
                    return;
                }
            }
            this.f12612a = StringUtils.isNull(dataRes.title) ? l : dataRes.title;
            this.f12613b = dataRes.img;
            this.f12614c = StringUtils.isNull(dataRes.tips) ? m : dataRes.tips;
            if (!StringUtils.isNull(dataRes.url)) {
                try {
                    JSONObject jSONObject = new JSONObject(dataRes.url);
                    this.f12618g = jSONObject.optString("appid");
                    this.f12619h = jSONObject.optString("appname");
                    String optString = jSONObject.optString("url");
                    Integer valueOf = Integer.valueOf(jSONObject.optInt("is_game"));
                    this.k = valueOf;
                    this.f12615d = c.a.r0.u.a.a(this.f12618g, optString, "9104", valueOf);
                    this.f12621j = jSONObject.optString("swan_app_id");
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            this.f12616e = StringUtils.isNull(dataRes.btn_sure) ? o : dataRes.btn_sure;
            this.f12617f = StringUtils.isNull(dataRes.btn_cancel) ? n : dataRes.btn_cancel;
        }
    }
}
