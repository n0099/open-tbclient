package c.a.p0.s.q;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.LinkThreadContent;
import tbclient.LinkThreadInfo;
/* loaded from: classes3.dex */
public class r0 {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: g  reason: collision with root package name */
    public static int f14328g = 1;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f14329a;

    /* renamed from: b  reason: collision with root package name */
    public String f14330b;

    /* renamed from: c  reason: collision with root package name */
    public String f14331c;

    /* renamed from: d  reason: collision with root package name */
    public String f14332d;

    /* renamed from: e  reason: collision with root package name */
    public int f14333e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f14334f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-377451174, "Lc/a/p0/s/q/r0;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-377451174, "Lc/a/p0/s/q/r0;");
        }
    }

    public r0() {
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
        this.f14333e = 0;
        this.f14334f = false;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f14331c : (String) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f14332d : (String) invokeV.objValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f14333e : invokeV.intValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f14330b : (String) invokeV.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f14329a : (String) invokeV.objValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f14334f : invokeV.booleanValue;
    }

    public void g(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.f14329a = jSONObject.optString("link_url");
        JSONArray optJSONArray = jSONObject.optJSONArray("link_content");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            try {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(0);
                if (jSONObject2 != null) {
                    this.f14330b = jSONObject2.optString("link_title");
                    this.f14331c = jSONObject2.optString("link_abstract");
                    this.f14332d = jSONObject2.optString("link_head_small_pic");
                    this.f14333e = jSONObject2.optInt("link_type");
                    if (c.a.e.e.p.k.isEmpty(this.f14330b) && c.a.e.e.p.k.isEmpty(this.f14331c)) {
                        this.f14334f = true;
                    }
                } else {
                    this.f14334f = true;
                }
                return;
            } catch (JSONException unused) {
                this.f14334f = true;
                return;
            }
        }
        this.f14334f = true;
    }

    public void h(LinkThreadInfo linkThreadInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, linkThreadInfo) == null) || linkThreadInfo == null) {
            return;
        }
        this.f14329a = linkThreadInfo.link_url;
        LinkThreadContent linkThreadContent = (LinkThreadContent) ListUtils.getItem(linkThreadInfo.link_content, 0);
        if (linkThreadContent != null) {
            this.f14330b = linkThreadContent.link_title;
            this.f14331c = linkThreadContent.link_abstract;
            this.f14332d = linkThreadContent.link_head_small_pic;
            this.f14333e = linkThreadContent.link_type.intValue();
            if (c.a.e.e.p.k.isEmpty(this.f14330b) && c.a.e.e.p.k.isEmpty(this.f14331c)) {
                this.f14334f = true;
                return;
            }
            return;
        }
        this.f14334f = true;
    }
}
