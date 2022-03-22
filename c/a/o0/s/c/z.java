package c.a.o0.s.c;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.VrPlayerActivityConfig;
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
    public String f11280b;

    /* renamed from: c  reason: collision with root package name */
    public String f11281c;

    /* renamed from: d  reason: collision with root package name */
    public String f11282d;

    /* renamed from: e  reason: collision with root package name */
    public String f11283e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f11284f;

    /* renamed from: g  reason: collision with root package name */
    public String f11285g;

    /* renamed from: h  reason: collision with root package name */
    public String f11286h;
    public int i;
    public int j;

    public z() {
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
                    zVar.f11285g = split[1];
                    zVar.f11286h = split[2];
                    zVar.i = Integer.parseInt(split[3]);
                    zVar.j = Integer.parseInt(split[4]);
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
                return "[pic-tab] " + this.f11285g + " " + this.f11286h + " " + this.i + " " + this.j;
            }
            return this.f11280b;
        }
        return (String) invokeV.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? TextUtils.isEmpty(this.f11280b) || this.a <= 0 : invokeV.booleanValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? !TextUtils.isEmpty(this.f11285g) && !TextUtils.isEmpty(this.f11286h) && this.i > 0 && this.j > 0 : invokeV.booleanValue;
    }

    public void e(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.a = jSONObject.optInt("tab_type");
        this.f11280b = jSONObject.optString("tab_name");
        this.f11281c = jSONObject.optString("tab_code");
        this.f11282d = jSONObject.optString("tab_url");
        this.f11283e = jSONObject.optString("tab_version");
        this.f11285g = jSONObject.optString("selected_pic_url");
        this.f11286h = jSONObject.optString("unselected_pic_url");
        this.i = jSONObject.optInt(VrPlayerActivityConfig.PIC_WIDTH);
        this.j = jSONObject.optInt(VrPlayerActivityConfig.PIC_HEIGHT);
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
            return this.a == zVar.a && this.f11284f == zVar.f11284f && this.i == zVar.i && this.j == zVar.j && Objects.equals(this.f11280b, zVar.f11280b) && Objects.equals(this.f11281c, zVar.f11281c) && Objects.equals(this.f11282d, zVar.f11282d) && Objects.equals(this.f11283e, zVar.f11283e) && Objects.equals(this.f11285g, zVar.f11285g) && Objects.equals(this.f11286h, zVar.f11286h);
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? Objects.hash(Integer.valueOf(this.a), this.f11280b, this.f11281c, this.f11282d, this.f11283e, Boolean.valueOf(this.f11284f), this.f11285g, this.f11286h, Integer.valueOf(this.i), Integer.valueOf(this.j)) : invokeV.intValue;
    }
}
