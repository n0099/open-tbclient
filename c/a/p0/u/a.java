package c.a.p0.u;

import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.q;
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
/* loaded from: classes3.dex */
public class a implements Comparable<a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public long f15008e;

    /* renamed from: f  reason: collision with root package name */
    public String f15009f;

    /* renamed from: g  reason: collision with root package name */
    public String f15010g;

    /* renamed from: h  reason: collision with root package name */
    public String f15011h;

    /* renamed from: i  reason: collision with root package name */
    public String f15012i;

    /* renamed from: j  reason: collision with root package name */
    public int f15013j;
    public String k;
    public String l;

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
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) ? h() > aVar.h() ? -1 : 1 : invokeL.intValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f15012i : (String) invokeV.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.l : (String) invokeV.objValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f15013j : invokeV.intValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f15011h : (String) invokeV.objValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f15009f : (String) invokeV.objValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f15010g : (String) invokeV.objValue;
    }

    public long h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f15008e : invokeV.longValue;
    }

    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.k : (String) invokeV.objValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (StringUtils.isNull(this.k) && StringUtils.isNull(this.l)) {
                return;
            }
            String c2 = q.c(TbadkApplication.getInst().getAndroidId());
            String lastCachedOid = PermissionUtil.getLastCachedOid(TbadkCoreApplication.getInst());
            StringBuilder sb = new StringBuilder();
            sb.append("&ANDROIDID=");
            sb.append(c2 == null ? "" : c2.toLowerCase());
            sb.append("&OAID=");
            sb.append(lastCachedOid != null ? lastCachedOid.toUpperCase() : "");
            String sb2 = sb.toString();
            if (!StringUtils.isNull(this.k) && !this.k.contains("ANDROIDID") && !this.k.contains("OAID")) {
                this.k += sb2;
            }
            if (StringUtils.isNull(this.l) || this.l.contains("ANDROIDID") || this.l.contains("OAID")) {
                return;
            }
            this.l += sb2;
        }
    }

    public void k(Advertisement advertisement) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, advertisement) == null) {
            this.f15008e = advertisement.time.longValue();
            this.f15009f = advertisement.pic;
            this.f15010g = advertisement.pic_click;
            this.f15011h = advertisement.jump_link;
            this.f15012i = advertisement.advertisement_id;
            this.k = advertisement.view_statistics_url;
            this.l = advertisement.click_statistics_url;
            j();
        }
    }

    public void l(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, jSONObject) == null) {
            this.f15009f = jSONObject.optString("pic");
            this.f15010g = jSONObject.optString("pic_click");
            this.f15011h = jSONObject.optString("jump_link");
            this.f15012i = jSONObject.optString("advertisement_id");
            this.k = jSONObject.optString("view_statistics_url");
            this.l = jSONObject.optString("click_statistics_url");
            j();
        }
    }

    public void m(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.f15013j = i2;
        }
    }
}
