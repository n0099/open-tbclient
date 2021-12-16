package c.a.r0.u;

import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.r;
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
/* loaded from: classes6.dex */
public class a implements Comparable<a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public long f13968e;

    /* renamed from: f  reason: collision with root package name */
    public String f13969f;

    /* renamed from: g  reason: collision with root package name */
    public String f13970g;

    /* renamed from: h  reason: collision with root package name */
    public String f13971h;

    /* renamed from: i  reason: collision with root package name */
    public String f13972i;

    /* renamed from: j  reason: collision with root package name */
    public int f13973j;

    /* renamed from: k  reason: collision with root package name */
    public String f13974k;
    public String l;
    public String m;
    public String n;
    public String o;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f13972i : (String) invokeV.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.l : (String) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.m : (String) invokeV.objValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f13973j : invokeV.intValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.o : (String) invokeV.objValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.n : (String) invokeV.objValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f13971h : (String) invokeV.objValue;
    }

    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f13969f : (String) invokeV.objValue;
    }

    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f13970g : (String) invokeV.objValue;
    }

    public long k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f13968e : invokeV.longValue;
    }

    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f13974k : (String) invokeV.objValue;
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            if (StringUtils.isNull(this.f13974k) && StringUtils.isNull(this.l)) {
                return;
            }
            String c2 = r.c(TbadkApplication.getInst().getAndroidId());
            String lastCachedOid = PermissionUtil.getLastCachedOid(TbadkCoreApplication.getInst());
            StringBuilder sb = new StringBuilder();
            sb.append("&ANDROIDID=");
            sb.append(c2 == null ? "" : c2.toLowerCase());
            sb.append("&OAID=");
            sb.append(lastCachedOid != null ? lastCachedOid.toUpperCase() : "");
            String sb2 = sb.toString();
            if (!StringUtils.isNull(this.f13974k) && !this.f13974k.contains("ANDROIDID") && !this.f13974k.contains("OAID")) {
                this.f13974k += sb2;
            }
            if (StringUtils.isNull(this.l) || this.l.contains("ANDROIDID") || this.l.contains("OAID")) {
                return;
            }
            this.l += sb2;
        }
    }

    public void n(Advertisement advertisement) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, advertisement) == null) {
            this.f13968e = advertisement.time.longValue();
            this.f13969f = advertisement.pic;
            this.f13970g = advertisement.pic_click;
            this.f13971h = advertisement.jump_link;
            this.f13972i = advertisement.advertisement_id;
            this.f13974k = advertisement.view_statistics_url;
            this.l = advertisement.click_statistics_url;
            this.m = advertisement.floating_text;
            this.n = advertisement.scheme;
            this.o = advertisement.package_name;
            m();
        }
    }

    public void o(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, jSONObject) == null) {
            this.f13969f = jSONObject.optString("pic");
            this.f13970g = jSONObject.optString("pic_click");
            this.f13971h = jSONObject.optString("jump_link");
            this.f13972i = jSONObject.optString("advertisement_id");
            this.f13974k = jSONObject.optString("view_statistics_url");
            this.l = jSONObject.optString("click_statistics_url");
            this.m = jSONObject.optString("floating_text");
            this.n = jSONObject.optString("scheme");
            this.o = jSONObject.optString("package_name");
            m();
        }
    }

    public void p(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            this.f13973j = i2;
        }
    }
}
