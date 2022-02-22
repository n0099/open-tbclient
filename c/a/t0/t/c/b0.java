package c.a.t0.t.c;

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
/* loaded from: classes6.dex */
public class b0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public String f14211b;

    /* renamed from: c  reason: collision with root package name */
    public String f14212c;

    /* renamed from: d  reason: collision with root package name */
    public String f14213d;

    /* renamed from: e  reason: collision with root package name */
    public String f14214e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f14215f;

    /* renamed from: g  reason: collision with root package name */
    public String f14216g;

    /* renamed from: h  reason: collision with root package name */
    public String f14217h;

    /* renamed from: i  reason: collision with root package name */
    public int f14218i;

    /* renamed from: j  reason: collision with root package name */
    public int f14219j;

    public b0() {
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
    public static b0 a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (!TextUtils.isEmpty(str) && str.startsWith("[pic-tab]")) {
                String[] split = str.split(" ");
                if (split.length != 5) {
                    return null;
                }
                try {
                    b0 b0Var = new b0();
                    b0Var.f14216g = split[1];
                    b0Var.f14217h = split[2];
                    b0Var.f14218i = Integer.parseInt(split[3]);
                    b0Var.f14219j = Integer.parseInt(split[4]);
                    return b0Var;
                } catch (Exception unused) {
                    return null;
                }
            }
            return null;
        }
        return (b0) invokeL.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (d()) {
                return "[pic-tab] " + this.f14216g + " " + this.f14217h + " " + this.f14218i + " " + this.f14219j;
            }
            return this.f14211b;
        }
        return (String) invokeV.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? TextUtils.isEmpty(this.f14211b) || this.a <= 0 : invokeV.booleanValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? !TextUtils.isEmpty(this.f14216g) && !TextUtils.isEmpty(this.f14217h) && this.f14218i > 0 && this.f14219j > 0 : invokeV.booleanValue;
    }

    public void e(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.a = jSONObject.optInt("tab_type");
        this.f14211b = jSONObject.optString("tab_name");
        this.f14212c = jSONObject.optString("tab_code");
        this.f14213d = jSONObject.optString(TabWebFragment.TAB_URL);
        this.f14214e = jSONObject.optString("tab_version");
        this.f14216g = jSONObject.optString("selected_pic_url");
        this.f14217h = jSONObject.optString("unselected_pic_url");
        this.f14218i = jSONObject.optInt(VrPlayerActivityConfig.PIC_WIDTH);
        this.f14219j = jSONObject.optInt(VrPlayerActivityConfig.PIC_HEIGHT);
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj == null || b0.class != obj.getClass()) {
                return false;
            }
            b0 b0Var = (b0) obj;
            return this.a == b0Var.a && this.f14215f == b0Var.f14215f && this.f14218i == b0Var.f14218i && this.f14219j == b0Var.f14219j && Objects.equals(this.f14211b, b0Var.f14211b) && Objects.equals(this.f14212c, b0Var.f14212c) && Objects.equals(this.f14213d, b0Var.f14213d) && Objects.equals(this.f14214e, b0Var.f14214e) && Objects.equals(this.f14216g, b0Var.f14216g) && Objects.equals(this.f14217h, b0Var.f14217h);
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? Objects.hash(Integer.valueOf(this.a), this.f14211b, this.f14212c, this.f14213d, this.f14214e, Boolean.valueOf(this.f14215f), this.f14216g, this.f14217h, Integer.valueOf(this.f14218i), Integer.valueOf(this.f14219j)) : invokeV.intValue;
    }
}
