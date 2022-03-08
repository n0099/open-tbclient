package c.a.q0.s.c;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class h0 {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final Map<ShareDialogConfig.From, Integer> f13652f;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f13653b;

    /* renamed from: c  reason: collision with root package name */
    public String f13654c;

    /* renamed from: d  reason: collision with root package name */
    public int f13655d;

    /* renamed from: e  reason: collision with root package name */
    public List<Integer> f13656e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-586903583, "Lc/a/q0/s/c/h0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-586903583, "Lc/a/q0/s/c/h0;");
                return;
            }
        }
        HashMap hashMap = new HashMap();
        f13652f = hashMap;
        hashMap.put(ShareDialogConfig.From.Recommend, 1);
        f13652f.put(ShareDialogConfig.From.Concern, 2);
        f13652f.put(ShareDialogConfig.From.PB, 3);
        f13652f.put(ShareDialogConfig.From.FRS, 4);
        f13652f.put(ShareDialogConfig.From.PersonPolymeric, 5);
        f13652f.put(ShareDialogConfig.From.VideoMiddlePageHorizontal, 6);
        f13652f.put(ShareDialogConfig.From.VideoMiddlePageVertical, 7);
        f13652f.put(ShareDialogConfig.From.HomeVideoTab, 8);
        f13652f.put(ShareDialogConfig.From.HomeGameTab, 9);
    }

    public h0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f13655d : invokeV.intValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f13654c : (String) invokeV.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? System.currentTimeMillis() / 1000 >= ((long) this.a) && System.currentTimeMillis() / 1000 <= ((long) this.f13653b) : invokeV.booleanValue;
    }

    public boolean d(ShareDialogConfig.From from) {
        InterceptResult invokeL;
        Integer num;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, from)) == null) ? (this.f13656e == null || (num = f13652f.get(from)) == null || !this.f13656e.contains(num)) ? false : true : invokeL.booleanValue;
    }

    public void e(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.a = jSONObject.optInt("begin_time");
        this.f13653b = jSONObject.optInt("end_time");
        this.f13654c = jSONObject.optString("text");
        this.f13655d = jSONObject.optInt("icon_exp");
        f(jSONObject.optString("page_list"));
    }

    public final void f(String str) {
        String[] split;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, str) == null) || c.a.d.f.p.m.isEmpty(str) || (split = str.split(",")) == null) {
            return;
        }
        for (String str2 : split) {
            int e2 = c.a.d.f.m.b.e(str2, -1);
            if (e2 != -1) {
                if (this.f13656e == null) {
                    this.f13656e = new ArrayList();
                }
                this.f13656e.add(Integer.valueOf(e2));
            }
        }
    }
}
