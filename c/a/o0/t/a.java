package c.a.o0.t;

import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.t;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
import tbclient.Advertisement;
/* loaded from: classes2.dex */
public class a implements Comparable<a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;

    /* renamed from: b  reason: collision with root package name */
    public String f11439b;

    /* renamed from: c  reason: collision with root package name */
    public String f11440c;

    /* renamed from: d  reason: collision with root package name */
    public String f11441d;

    /* renamed from: e  reason: collision with root package name */
    public String f11442e;

    /* renamed from: f  reason: collision with root package name */
    public int f11443f;

    /* renamed from: g  reason: collision with root package name */
    public String f11444g;

    /* renamed from: h  reason: collision with root package name */
    public String f11445h;
    public String i;
    public String j;
    public String k;
    public String l;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) ? k() > aVar.k() ? -1 : 1 : invokeL.intValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f11442e : (String) invokeV.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f11445h : (String) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.i : (String) invokeV.objValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f11443f : invokeV.intValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.k : (String) invokeV.objValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.j : (String) invokeV.objValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f11441d : (String) invokeV.objValue;
    }

    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f11439b : (String) invokeV.objValue;
    }

    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f11440c : (String) invokeV.objValue;
    }

    public long k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.a : invokeV.longValue;
    }

    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f11444g : (String) invokeV.objValue;
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            if (StringUtils.isNull(this.f11444g) && StringUtils.isNull(this.f11445h)) {
                return;
            }
            String c2 = t.c(TbadkApplication.getInst().getAndroidId());
            String lastCachedOid = PermissionUtil.getLastCachedOid(TbadkCoreApplication.getInst());
            StringBuilder sb = new StringBuilder();
            sb.append("&ANDROIDID=");
            sb.append(c2 == null ? "" : c2.toLowerCase());
            sb.append("&OAID=");
            sb.append(lastCachedOid != null ? lastCachedOid.toUpperCase() : "");
            String sb2 = sb.toString();
            if (!StringUtils.isNull(this.f11444g) && !this.f11444g.contains("ANDROIDID") && !this.f11444g.contains("OAID")) {
                this.f11444g += sb2;
            }
            if (StringUtils.isNull(this.f11445h) || this.f11445h.contains("ANDROIDID") || this.f11445h.contains("OAID")) {
                return;
            }
            this.f11445h += sb2;
        }
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? !"0".equals(this.l) : invokeV.booleanValue;
    }

    public void o(Advertisement advertisement) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, advertisement) == null) {
            this.a = advertisement.time.longValue();
            this.f11439b = advertisement.pic;
            this.f11440c = advertisement.pic_click;
            this.f11441d = advertisement.jump_link;
            this.f11442e = advertisement.advertisement_id;
            this.f11444g = advertisement.view_statistics_url;
            this.f11445h = advertisement.click_statistics_url;
            this.i = advertisement.floating_text;
            this.j = advertisement.scheme;
            this.k = advertisement.package_name;
            this.l = advertisement.display_ad_icon;
            m();
        }
    }

    public void p(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, jSONObject) == null) {
            this.f11439b = jSONObject.optString("pic");
            this.f11440c = jSONObject.optString("pic_click");
            this.f11441d = jSONObject.optString("jump_link");
            this.f11442e = jSONObject.optString("advertisement_id");
            this.f11444g = jSONObject.optString("view_statistics_url");
            this.f11445h = jSONObject.optString("click_statistics_url");
            this.i = jSONObject.optString("floating_text");
            this.j = jSONObject.optString("scheme");
            this.k = jSONObject.optString("package_name");
            this.l = jSONObject.optString("display_ad_icon");
            m();
        }
    }

    public void q(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            this.f11443f = i;
        }
    }
}
