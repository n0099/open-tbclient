package c.a.d0.s;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.model.AdOperator;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class r {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f3109b;

    /* renamed from: c  reason: collision with root package name */
    public String f3110c;

    /* renamed from: d  reason: collision with root package name */
    public String f3111d;

    /* renamed from: e  reason: collision with root package name */
    public final String f3112e;

    /* renamed from: f  reason: collision with root package name */
    public final int f3113f;

    /* renamed from: g  reason: collision with root package name */
    public String f3114g;

    /* renamed from: h  reason: collision with root package name */
    public String f3115h;

    /* renamed from: i  reason: collision with root package name */
    public final String f3116i;

    /* renamed from: j  reason: collision with root package name */
    public String f3117j;
    public String k;
    public String l;
    public c m;
    public String n;
    public boolean o;
    public boolean p;
    public boolean q;
    public String r;
    public String s;
    public String t;

    public r(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONObject};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = true;
        this.q = false;
        jSONObject.optString("style");
        this.a = jSONObject.optString("user_name");
        this.f3109b = jSONObject.optString("user_portrait");
        this.f3110c = jSONObject.optString("scheme");
        this.f3111d = jSONObject.optString("button_scheme");
        this.f3112e = jSONObject.optString(GameGuideConfigInfo.KEY_BUTTON_TEXT);
        this.f3113f = jSONObject.optInt("duration") * 1000;
        this.f3114g = jSONObject.optString("trade");
        jSONObject.optString("score");
        this.f3115h = jSONObject.optString("title");
        jSONObject.optString("sub_title");
        this.f3116i = jSONObject.optString("popularity_text");
        this.f3117j = jSONObject.optString("cover_url");
        this.s = jSONObject.optString("bottom_button_text");
        this.r = jSONObject.optString("bottom_button_icon");
        this.t = jSONObject.optString("bottom_button_scheme");
    }

    @Nullable
    public static r a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            return new r(jSONObject);
        }
        return (r) invokeL.objValue;
    }

    public r b(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            this.f3111d = c.a.d0.g0.b.a(this.f3111d, str, "__BTN_SCHEME__");
            return this;
        }
        return (r) invokeL.objValue;
    }

    public r c(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            this.f3117j = str;
            return this;
        }
        return (r) invokeL.objValue;
    }

    public void d(@NonNull AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, adBaseModel) == null) {
            p pVar = adBaseModel.f37262j;
            if (pVar != null && !TextUtils.isEmpty(pVar.f3103c)) {
                c(adBaseModel.f37262j.f3103c);
            }
            if (!TextUtils.isEmpty(adBaseModel.f37258f.f3093d)) {
                f(adBaseModel.f37258f.f3093d);
            }
            c cVar = adBaseModel.l;
            if (cVar != null) {
                e(cVar);
            }
            if (!TextUtils.isEmpty(adBaseModel.f37258f.f3092c)) {
                g(adBaseModel.f37258f.f3092c);
            }
            AdOperator adOperator = adBaseModel.f37260h;
            if (adOperator != null && !TextUtils.isEmpty(adOperator.f37265d)) {
                b(adBaseModel.f37260h.f37265d);
            }
            if (adBaseModel.f37258f != null) {
                if (TextUtils.isEmpty(this.f3115h)) {
                    this.f3115h = adBaseModel.f37258f.f3096g;
                }
                if (TextUtils.isEmpty(this.f3114g)) {
                    this.f3114g = adBaseModel.f37258f.f3097h;
                }
            }
        }
    }

    public r e(@NonNull c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, cVar)) == null) {
            this.m = cVar;
            return this;
        }
        return (r) invokeL.objValue;
    }

    public r f(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            this.l = str;
            return this;
        }
        return (r) invokeL.objValue;
    }

    public r g(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            this.f3110c = c.a.d0.g0.b.a(this.f3110c, str, "__SCHEME__");
            return this;
        }
        return (r) invokeL.objValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            c cVar = this.m;
            return cVar != null && cVar.f3078e;
        }
        return invokeV.booleanValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? h() || !TextUtils.isEmpty(this.f3110c) : invokeV.booleanValue;
    }
}
