package c.a.q0.s.c;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.VrPlayerActivityConfig;
import com.baidu.tieba.homepage.tabfeed.h5.TabWebFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Objects;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class z {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public String f13729b;

    /* renamed from: c  reason: collision with root package name */
    public String f13730c;

    /* renamed from: d  reason: collision with root package name */
    public String f13731d;

    /* renamed from: e  reason: collision with root package name */
    public String f13732e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f13733f;

    /* renamed from: g  reason: collision with root package name */
    public String f13734g;

    /* renamed from: h  reason: collision with root package name */
    public String f13735h;

    /* renamed from: i  reason: collision with root package name */
    public int f13736i;

    /* renamed from: j  reason: collision with root package name */
    public int f13737j;

    public z() {
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

    @Nullable
    public static z a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (!TextUtils.isEmpty(str) && str.startsWith("[pic-tab]")) {
                String[] split = str.split(" ");
                if (split.length != 5) {
                    return null;
                }
                try {
                    z zVar = new z();
                    zVar.f13734g = split[1];
                    zVar.f13735h = split[2];
                    zVar.f13736i = Integer.parseInt(split[3]);
                    zVar.f13737j = Integer.parseInt(split[4]);
                    return zVar;
                } catch (Exception unused) {
                    return null;
                }
            }
            return null;
        }
        return (z) invokeL.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (d()) {
                return "[pic-tab] " + this.f13734g + " " + this.f13735h + " " + this.f13736i + " " + this.f13737j;
            }
            return this.f13729b;
        }
        return (String) invokeV.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? TextUtils.isEmpty(this.f13729b) || this.a <= 0 : invokeV.booleanValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? !TextUtils.isEmpty(this.f13734g) && !TextUtils.isEmpty(this.f13735h) && this.f13736i > 0 && this.f13737j > 0 : invokeV.booleanValue;
    }

    public void e(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.a = jSONObject.optInt("tab_type");
        this.f13729b = jSONObject.optString("tab_name");
        this.f13730c = jSONObject.optString("tab_code");
        this.f13731d = jSONObject.optString(TabWebFragment.TAB_URL);
        this.f13732e = jSONObject.optString("tab_version");
        this.f13734g = jSONObject.optString("selected_pic_url");
        this.f13735h = jSONObject.optString("unselected_pic_url");
        this.f13736i = jSONObject.optInt(VrPlayerActivityConfig.PIC_WIDTH);
        this.f13737j = jSONObject.optInt(VrPlayerActivityConfig.PIC_HEIGHT);
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj == null || z.class != obj.getClass()) {
                return false;
            }
            z zVar = (z) obj;
            return this.a == zVar.a && this.f13733f == zVar.f13733f && this.f13736i == zVar.f13736i && this.f13737j == zVar.f13737j && Objects.equals(this.f13729b, zVar.f13729b) && Objects.equals(this.f13730c, zVar.f13730c) && Objects.equals(this.f13731d, zVar.f13731d) && Objects.equals(this.f13732e, zVar.f13732e) && Objects.equals(this.f13734g, zVar.f13734g) && Objects.equals(this.f13735h, zVar.f13735h);
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? Objects.hash(Integer.valueOf(this.a), this.f13729b, this.f13730c, this.f13731d, this.f13732e, Boolean.valueOf(this.f13733f), this.f13734g, this.f13735h, Integer.valueOf(this.f13736i), Integer.valueOf(this.f13737j)) : invokeV.intValue;
    }
}
