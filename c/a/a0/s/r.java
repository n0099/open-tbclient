package c.a.a0.s;

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
    public String f1563b;

    /* renamed from: c  reason: collision with root package name */
    public String f1564c;

    /* renamed from: d  reason: collision with root package name */
    public String f1565d;

    /* renamed from: e  reason: collision with root package name */
    public final String f1566e;

    /* renamed from: f  reason: collision with root package name */
    public final int f1567f;

    /* renamed from: g  reason: collision with root package name */
    public String f1568g;

    /* renamed from: h  reason: collision with root package name */
    public String f1569h;
    public final String i;
    public String j;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = true;
        this.q = false;
        jSONObject.optString("style");
        this.a = jSONObject.optString("user_name");
        this.f1563b = jSONObject.optString("user_portrait");
        this.f1564c = jSONObject.optString("scheme");
        this.f1565d = jSONObject.optString("button_scheme");
        this.f1566e = jSONObject.optString(GameGuideConfigInfo.KEY_BUTTON_TEXT);
        this.f1567f = jSONObject.optInt("duration") * 1000;
        this.f1568g = jSONObject.optString("trade");
        jSONObject.optString("score");
        this.f1569h = jSONObject.optString("title");
        jSONObject.optString("sub_title");
        this.i = jSONObject.optString("popularity_text");
        this.j = jSONObject.optString("cover_url");
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
            this.f1565d = c.a.a0.g0.b.a(this.f1565d, str, "__BTN_SCHEME__");
            return this;
        }
        return (r) invokeL.objValue;
    }

    public r c(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            this.j = str;
            return this;
        }
        return (r) invokeL.objValue;
    }

    public void d(@NonNull AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, adBaseModel) == null) {
            p pVar = adBaseModel.j;
            if (pVar != null && !TextUtils.isEmpty(pVar.f1557c)) {
                c(adBaseModel.j.f1557c);
            }
            if (!TextUtils.isEmpty(adBaseModel.f27543f.f1549d)) {
                f(adBaseModel.f27543f.f1549d);
            }
            c cVar = adBaseModel.l;
            if (cVar != null) {
                e(cVar);
            }
            if (!TextUtils.isEmpty(adBaseModel.f27543f.f1548c)) {
                g(adBaseModel.f27543f.f1548c);
            }
            AdOperator adOperator = adBaseModel.f27545h;
            if (adOperator != null && !TextUtils.isEmpty(adOperator.f27548d)) {
                b(adBaseModel.f27545h.f27548d);
            }
            if (adBaseModel.f27543f != null) {
                if (TextUtils.isEmpty(this.f1569h)) {
                    this.f1569h = adBaseModel.f27543f.f1552g;
                }
                if (TextUtils.isEmpty(this.f1568g)) {
                    this.f1568g = adBaseModel.f27543f.f1553h;
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
            this.f1564c = c.a.a0.g0.b.a(this.f1564c, str, "__SCHEME__");
            return this;
        }
        return (r) invokeL.objValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            c cVar = this.m;
            return cVar != null && cVar.f1535e;
        }
        return invokeV.booleanValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? h() || !TextUtils.isEmpty(this.f1564c) : invokeV.booleanValue;
    }
}
