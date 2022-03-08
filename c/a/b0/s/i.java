package c.a.b0.s;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.model.ParseError;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tachikoma.core.component.TKBase;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final AdBaseModel.STYLE a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final String f1921b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public String f1922c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final String f1923d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final String f1924e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final String f1925f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final String f1926g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public final String f1927h;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    public final String f1928i;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    public final List<String> f1929j;
    @NonNull
    public final List<d> k;

    public i(@NonNull AdBaseModel.STYLE style, @NonNull String str, int i2, @NonNull JSONObject jSONObject, @NonNull JSONObject jSONObject2, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {style, str, Integer.valueOf(i2), jSONObject, jSONObject2, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = style;
        this.f1921b = jSONObject2.optString("id");
        this.f1922c = jSONObject2.optString("scheme");
        if (!TextUtils.isEmpty(str2)) {
            this.f1923d = str2;
        } else {
            this.f1923d = jSONObject2.optString("ext_info");
        }
        this.f1924e = jSONObject2.optString("user_name");
        this.f1925f = jSONObject2.optString("user_portrait");
        this.f1926g = jSONObject2.optString("title");
        if (jSONObject2.optInt("title_lines", 0) > 0) {
        }
        this.f1927h = jSONObject2.optString("tag", "广告");
        this.f1928i = jSONObject2.optString("recommend_reason");
        this.f1929j = new ArrayList();
        JSONArray optJSONArray = jSONObject2.optJSONArray("recommend_reason");
        int length = optJSONArray == null ? 0 : optJSONArray.length();
        for (int i5 = 0; i5 < length; i5++) {
            String optString = optJSONArray.optString(i5);
            if (!TextUtils.isEmpty(optString)) {
                c.a.b0.x.a.b(this.f1929j, optString);
            }
        }
        this.k = new ArrayList();
        JSONArray optJSONArray2 = jSONObject2.optJSONArray("pic_list");
        int length2 = optJSONArray2 == null ? 0 : optJSONArray2.length();
        for (int i6 = 0; i6 < length2; i6++) {
            JSONObject optJSONObject = optJSONArray2.optJSONObject(i6);
            if (optJSONObject != null) {
                c.a.b0.x.a.b(this.k, d.a(optJSONObject));
            }
        }
        v.a(jSONObject2.optJSONArray("lottie_list"));
    }

    public static i a(String str, int i2, JSONObject jSONObject, JSONObject jSONObject2, String str2) throws ParseError {
        InterceptResult invokeCommon;
        AdBaseModel.STYLE style;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{str, Integer.valueOf(i2), jSONObject, jSONObject2, str2})) == null) {
            try {
                style = AdBaseModel.STYLE.from(jSONObject2.optString("ad_style", TKBase.VISIBILITY_HIDDEN));
            } catch (Throwable unused) {
                style = null;
            }
            AdBaseModel.STYLE style2 = style;
            if (style2 != null) {
                return new i(style2, str, i2, jSONObject, jSONObject2, str2);
            }
            throw ParseError.contentError(24, jSONObject2.optString("ad_style"));
        }
        return (i) invokeCommon.objValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            for (d dVar : this.k) {
                dVar.b();
            }
        }
    }
}
