package c.a.a0.s;

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
    public final String f1547b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public String f1548c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final String f1549d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final String f1550e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final String f1551f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final String f1552g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public final String f1553h;
    @NonNull
    public final String i;
    @NonNull
    public final List<String> j;
    @NonNull
    public final List<d> k;

    public i(@NonNull AdBaseModel.STYLE style, @NonNull String str, int i, @NonNull JSONObject jSONObject, @NonNull JSONObject jSONObject2, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {style, str, Integer.valueOf(i), jSONObject, jSONObject2, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = style;
        this.f1547b = jSONObject2.optString("id");
        this.f1548c = jSONObject2.optString("scheme");
        if (!TextUtils.isEmpty(str2)) {
            this.f1549d = str2;
        } else {
            this.f1549d = jSONObject2.optString("ext_info");
        }
        this.f1550e = jSONObject2.optString("user_name");
        this.f1551f = jSONObject2.optString("user_portrait");
        this.f1552g = jSONObject2.optString("title");
        if (jSONObject2.optInt("title_lines", 0) > 0) {
        }
        this.f1553h = jSONObject2.optString("tag", "广告");
        this.i = jSONObject2.optString("recommend_reason");
        this.j = new ArrayList();
        JSONArray optJSONArray = jSONObject2.optJSONArray("recommend_reason");
        int length = optJSONArray == null ? 0 : optJSONArray.length();
        for (int i4 = 0; i4 < length; i4++) {
            String optString = optJSONArray.optString(i4);
            if (!TextUtils.isEmpty(optString)) {
                c.a.a0.x.a.b(this.j, optString);
            }
        }
        this.k = new ArrayList();
        JSONArray optJSONArray2 = jSONObject2.optJSONArray("pic_list");
        int length2 = optJSONArray2 == null ? 0 : optJSONArray2.length();
        for (int i5 = 0; i5 < length2; i5++) {
            JSONObject optJSONObject = optJSONArray2.optJSONObject(i5);
            if (optJSONObject != null) {
                c.a.a0.x.a.b(this.k, d.a(optJSONObject));
            }
        }
        v.a(jSONObject2.optJSONArray("lottie_list"));
    }

    public static i a(String str, int i, JSONObject jSONObject, JSONObject jSONObject2, String str2) throws ParseError {
        InterceptResult invokeCommon;
        AdBaseModel.STYLE style;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{str, Integer.valueOf(i), jSONObject, jSONObject2, str2})) == null) {
            try {
                style = AdBaseModel.STYLE.from(jSONObject2.optString("ad_style", TKBase.VISIBILITY_HIDDEN));
            } catch (Throwable unused) {
                style = null;
            }
            AdBaseModel.STYLE style2 = style;
            if (style2 != null) {
                return new i(style2, str, i, jSONObject, jSONObject2, str2);
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
