package c.a.b0.s;

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
    public String f1939b;

    /* renamed from: c  reason: collision with root package name */
    public String f1940c;

    /* renamed from: d  reason: collision with root package name */
    public String f1941d;

    /* renamed from: e  reason: collision with root package name */
    public final String f1942e;

    /* renamed from: f  reason: collision with root package name */
    public final int f1943f;

    /* renamed from: g  reason: collision with root package name */
    public String f1944g;

    /* renamed from: h  reason: collision with root package name */
    public String f1945h;

    /* renamed from: i  reason: collision with root package name */
    public final String f1946i;

    /* renamed from: j  reason: collision with root package name */
    public String f1947j;
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
        this.f1939b = jSONObject.optString("user_portrait");
        this.f1940c = jSONObject.optString("scheme");
        this.f1941d = jSONObject.optString("button_scheme");
        this.f1942e = jSONObject.optString(GameGuideConfigInfo.KEY_BUTTON_TEXT);
        this.f1943f = jSONObject.optInt("duration") * 1000;
        this.f1944g = jSONObject.optString("trade");
        jSONObject.optString("score");
        this.f1945h = jSONObject.optString("title");
        jSONObject.optString("sub_title");
        this.f1946i = jSONObject.optString("popularity_text");
        this.f1947j = jSONObject.optString("cover_url");
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
            this.f1941d = c.a.b0.g0.b.a(this.f1941d, str, "__BTN_SCHEME__");
            return this;
        }
        return (r) invokeL.objValue;
    }

    public r c(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            this.f1947j = str;
            return this;
        }
        return (r) invokeL.objValue;
    }

    public void d(@NonNull AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, adBaseModel) == null) {
            p pVar = adBaseModel.f35665j;
            if (pVar != null && !TextUtils.isEmpty(pVar.f1933c)) {
                c(adBaseModel.f35665j.f1933c);
            }
            if (!TextUtils.isEmpty(adBaseModel.f35661f.f1923d)) {
                f(adBaseModel.f35661f.f1923d);
            }
            c cVar = adBaseModel.l;
            if (cVar != null) {
                e(cVar);
            }
            if (!TextUtils.isEmpty(adBaseModel.f35661f.f1922c)) {
                g(adBaseModel.f35661f.f1922c);
            }
            AdOperator adOperator = adBaseModel.f35663h;
            if (adOperator != null && !TextUtils.isEmpty(adOperator.f35668d)) {
                b(adBaseModel.f35663h.f35668d);
            }
            if (adBaseModel.f35661f != null) {
                if (TextUtils.isEmpty(this.f1945h)) {
                    this.f1945h = adBaseModel.f35661f.f1926g;
                }
                if (TextUtils.isEmpty(this.f1944g)) {
                    this.f1944g = adBaseModel.f35661f.f1927h;
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
            this.f1940c = c.a.b0.g0.b.a(this.f1940c, str, "__SCHEME__");
            return this;
        }
        return (r) invokeL.objValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            c cVar = this.m;
            return cVar != null && cVar.f1908e;
        }
        return invokeV.booleanValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? h() || !TextUtils.isEmpty(this.f1940c) : invokeV.booleanValue;
    }
}
