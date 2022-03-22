package c.a.o0.a;

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
/* loaded from: classes2.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public static final String l;
    public static final String m;
    public static final String n;
    public static final String o;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f9674b;

    /* renamed from: c  reason: collision with root package name */
    public String f9675c;

    /* renamed from: d  reason: collision with root package name */
    public String f9676d;

    /* renamed from: e  reason: collision with root package name */
    public String f9677e;

    /* renamed from: f  reason: collision with root package name */
    public String f9678f;

    /* renamed from: g  reason: collision with root package name */
    public String f9679g;

    /* renamed from: h  reason: collision with root package name */
    public String f9680h;
    public int i;
    public String j;
    public Integer k;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(997113545, "Lc/a/o0/a/h;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(997113545, "Lc/a/o0/a/h;");
                return;
            }
        }
        l = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1368);
        m = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1347);
        n = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f036c);
        o = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f03ac);
    }

    public h() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = "";
        this.f9674b = "";
        this.f9675c = "";
        this.f9676d = "";
        this.f9677e = "";
        this.f9678f = "";
        this.f9679g = "";
        this.f9680h = "";
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f9678f : (String) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f9677e : (String) invokeV.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f9674b : (String) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f9675c : (String) invokeV.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a : (String) invokeV.objValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f9676d : (String) invokeV.objValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.i : invokeV.intValue;
    }

    public void h(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, dataRes) == null) {
            int intValue = dataRes.type.intValue();
            this.i = intValue;
            if (intValue != 0 && intValue != 1) {
                if (intValue == 2) {
                    this.a = dataRes.title;
                    this.f9676d = dataRes.url;
                    return;
                } else if (intValue != 4 && intValue == 3) {
                    this.f9676d = dataRes.url;
                    this.a = dataRes.title;
                    this.f9674b = dataRes.img;
                    this.f9675c = dataRes.tips;
                    this.f9677e = dataRes.btn_sure;
                    this.f9678f = dataRes.btn_cancel;
                    return;
                } else {
                    return;
                }
            }
            this.a = StringUtils.isNull(dataRes.title) ? l : dataRes.title;
            this.f9674b = dataRes.img;
            this.f9675c = StringUtils.isNull(dataRes.tips) ? m : dataRes.tips;
            if (!StringUtils.isNull(dataRes.url)) {
                try {
                    JSONObject jSONObject = new JSONObject(dataRes.url);
                    this.f9679g = jSONObject.optString("appid");
                    this.f9680h = jSONObject.optString("appname");
                    String optString = jSONObject.optString("url");
                    Integer valueOf = Integer.valueOf(jSONObject.optInt("is_game"));
                    this.k = valueOf;
                    this.f9676d = c.a.p0.b0.a.a(this.f9679g, optString, "9104", valueOf);
                    this.j = jSONObject.optString("swan_app_id");
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            this.f9677e = StringUtils.isNull(dataRes.btn_sure) ? o : dataRes.btn_sure;
            this.f9678f = StringUtils.isNull(dataRes.btn_cancel) ? n : dataRes.btn_cancel;
        }
    }
}
