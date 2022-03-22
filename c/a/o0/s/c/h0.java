package c.a.o0.s.c;

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
    public static final Map<ShareDialogConfig.From, Integer> f11208f;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f11209b;

    /* renamed from: c  reason: collision with root package name */
    public String f11210c;

    /* renamed from: d  reason: collision with root package name */
    public int f11211d;

    /* renamed from: e  reason: collision with root package name */
    public List<Integer> f11212e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-193876573, "Lc/a/o0/s/c/h0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-193876573, "Lc/a/o0/s/c/h0;");
                return;
            }
        }
        HashMap hashMap = new HashMap();
        f11208f = hashMap;
        hashMap.put(ShareDialogConfig.From.Recommend, 1);
        f11208f.put(ShareDialogConfig.From.Concern, 2);
        f11208f.put(ShareDialogConfig.From.PB, 3);
        f11208f.put(ShareDialogConfig.From.FRS, 4);
        f11208f.put(ShareDialogConfig.From.PersonPolymeric, 5);
        f11208f.put(ShareDialogConfig.From.VideoMiddlePageHorizontal, 6);
        f11208f.put(ShareDialogConfig.From.VideoMiddlePageVertical, 7);
        f11208f.put(ShareDialogConfig.From.HomeVideoTab, 8);
        f11208f.put(ShareDialogConfig.From.HomeGameTab, 9);
    }

    public h0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f11211d : invokeV.intValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f11210c : (String) invokeV.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? System.currentTimeMillis() / 1000 >= ((long) this.a) && System.currentTimeMillis() / 1000 <= ((long) this.f11209b) : invokeV.booleanValue;
    }

    public boolean d(ShareDialogConfig.From from) {
        InterceptResult invokeL;
        Integer num;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, from)) == null) ? (this.f11212e == null || (num = f11208f.get(from)) == null || !this.f11212e.contains(num)) ? false : true : invokeL.booleanValue;
    }

    public void e(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.a = jSONObject.optInt("begin_time");
        this.f11209b = jSONObject.optInt("end_time");
        this.f11210c = jSONObject.optString("text");
        this.f11211d = jSONObject.optInt("icon_exp");
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
                if (this.f11212e == null) {
                    this.f11212e = new ArrayList();
                }
                this.f11212e.add(Integer.valueOf(e2));
            }
        }
    }
}
