package c.a.b0.s;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.recapp.activity.AdWebVideoActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class p {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;

    /* renamed from: b  reason: collision with root package name */
    public final int f1932b;

    /* renamed from: c  reason: collision with root package name */
    public final String f1933c;

    /* renamed from: d  reason: collision with root package name */
    public String f1934d;

    /* renamed from: e  reason: collision with root package name */
    public String f1935e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public final r f1936f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public String f1937g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public final HashMap<String, String> f1938h;

    public p(@NonNull JSONObject jSONObject, boolean z) {
        Object opt;
        Object opt2;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONObject, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f1938h = new HashMap<>();
        this.f1937g = jSONObject.toString();
        if (z) {
            this.a = jSONObject.optString(TiebaStatic.Params.VID);
            jSONObject.optString("video_id");
            jSONObject.optString("video_url");
            this.f1934d = jSONObject.optString("title");
            this.f1932b = jSONObject.optInt("duration");
            jSONObject.optInt("width");
            jSONObject.optInt("height");
            jSONObject.optDouble("whRatio", 0.0d);
            this.f1933c = jSONObject.optString("poster_image");
            this.f1936f = r.a(jSONObject.optJSONObject(AdWebVideoActivityConfig.KEY_TAIL_FRAME));
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!TextUtils.isEmpty(next) && (opt2 = jSONObject.opt(next)) != null && !(opt2 instanceof JSONObject) && !(opt2 instanceof JSONArray)) {
                    this.f1938h.put(next, jSONObject.optString(next));
                }
            }
            return;
        }
        this.a = jSONObject.optString(TiebaStatic.Params.VID);
        jSONObject.optString("videoId");
        jSONObject.optString("videoUrl");
        this.f1934d = jSONObject.optString("title");
        this.f1932b = jSONObject.optInt("duration");
        jSONObject.optInt("width");
        jSONObject.optInt("height");
        this.f1933c = jSONObject.optString("posterImage");
        jSONObject.optDouble("whRatio", 0.0d);
        this.f1936f = r.a(jSONObject.optJSONObject(AdWebVideoActivityConfig.KEY_TAIL_FRAME));
        Iterator<String> keys2 = jSONObject.keys();
        while (keys2.hasNext()) {
            String next2 = keys2.next();
            if (!TextUtils.isEmpty(next2) && (opt = jSONObject.opt(next2)) != null && !(opt instanceof JSONObject) && !(opt instanceof JSONArray)) {
                this.f1938h.put(next2, jSONObject.optString(next2));
            }
        }
    }

    @Nullable
    public static p a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            return new p(jSONObject, false);
        }
        return (p) invokeL.objValue;
    }

    public void b(@NonNull AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, adBaseModel) == null) {
            if (TextUtils.isEmpty(this.f1934d) && !TextUtils.isEmpty(adBaseModel.f35661f.f1926g)) {
                String str = adBaseModel.f35661f.f1926g;
                this.f1934d = str;
                this.f1938h.put("title", str);
            }
            if (TextUtils.isEmpty(this.f1935e)) {
                this.f1935e = adBaseModel.f35661f.f1923d;
            }
            c();
            r rVar = this.f1936f;
            if (rVar != null) {
                rVar.d(adBaseModel);
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || TextUtils.isEmpty(this.f1937g)) {
            return;
        }
        JSONObject b2 = c.a.b0.x.b.b(this.f1937g);
        if (!TextUtils.isEmpty(this.f1934d) && TextUtils.isEmpty(b2.optString("title"))) {
            c.a.b0.x.b.e(b2, "title", this.f1934d);
        }
        JSONObject optJSONObject = b2.optJSONObject("ext_log");
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
        }
        if (TextUtils.isEmpty(optJSONObject.optString("curVid"))) {
            c.a.b0.x.b.e(optJSONObject, "curVid", this.a);
        }
        if (!optJSONObject.has("mt")) {
            c.a.b0.x.b.c(optJSONObject, "mt", 2);
        }
        if (!optJSONObject.has("vType")) {
            c.a.b0.x.b.c(optJSONObject, "vType", 2);
        }
        if (!TextUtils.isEmpty(this.f1935e) && TextUtils.isEmpty(optJSONObject.optString("ad_extra_param"))) {
            c.a.b0.x.b.e(optJSONObject, "ad_extra_param", this.f1935e);
        }
        c.a.b0.x.b.e(b2, "ext_log", optJSONObject);
        this.f1937g = b2.toString();
    }
}
