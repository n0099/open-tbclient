package c.a.r0.t.c;

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
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public String f13635b;

    /* renamed from: c  reason: collision with root package name */
    public String f13636c;

    /* renamed from: d  reason: collision with root package name */
    public String f13637d;

    /* renamed from: e  reason: collision with root package name */
    public String f13638e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f13639f;

    /* renamed from: g  reason: collision with root package name */
    public String f13640g;

    /* renamed from: h  reason: collision with root package name */
    public String f13641h;

    /* renamed from: i  reason: collision with root package name */
    public int f13642i;

    /* renamed from: j  reason: collision with root package name */
    public int f13643j;

    public a0() {
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
    public static a0 a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (!TextUtils.isEmpty(str) && str.startsWith("[pic-tab]")) {
                String[] split = str.split(" ");
                if (split.length != 5) {
                    return null;
                }
                try {
                    a0 a0Var = new a0();
                    a0Var.f13640g = split[1];
                    a0Var.f13641h = split[2];
                    a0Var.f13642i = Integer.parseInt(split[3]);
                    a0Var.f13643j = Integer.parseInt(split[4]);
                    return a0Var;
                } catch (Exception unused) {
                    return null;
                }
            }
            return null;
        }
        return (a0) invokeL.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (d()) {
                return "[pic-tab] " + this.f13640g + " " + this.f13641h + " " + this.f13642i + " " + this.f13643j;
            }
            return this.f13635b;
        }
        return (String) invokeV.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? TextUtils.isEmpty(this.f13635b) || this.a <= 0 : invokeV.booleanValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? !TextUtils.isEmpty(this.f13640g) && !TextUtils.isEmpty(this.f13641h) && this.f13642i > 0 && this.f13643j > 0 : invokeV.booleanValue;
    }

    public void e(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.a = jSONObject.optInt("tab_type");
        this.f13635b = jSONObject.optString("tab_name");
        this.f13636c = jSONObject.optString("tab_code");
        this.f13637d = jSONObject.optString(TabWebFragment.TAB_URL);
        this.f13638e = jSONObject.optString("tab_version");
        this.f13640g = jSONObject.optString("selected_pic_url");
        this.f13641h = jSONObject.optString("unselected_pic_url");
        this.f13642i = jSONObject.optInt(VrPlayerActivityConfig.PIC_WIDTH);
        this.f13643j = jSONObject.optInt(VrPlayerActivityConfig.PIC_HEIGHT);
    }
}
