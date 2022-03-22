package c.a.a0.s;

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
    public final int f1556b;

    /* renamed from: c  reason: collision with root package name */
    public final String f1557c;

    /* renamed from: d  reason: collision with root package name */
    public String f1558d;

    /* renamed from: e  reason: collision with root package name */
    public String f1559e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public final r f1560f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public String f1561g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public final HashMap<String, String> f1562h;

    public p(@NonNull JSONObject jSONObject, boolean z) {
        Object opt;
        Object opt2;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONObject, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f1562h = new HashMap<>();
        this.f1561g = jSONObject.toString();
        if (z) {
            this.a = jSONObject.optString(TiebaStatic.Params.VID);
            jSONObject.optString("video_id");
            jSONObject.optString("video_url");
            this.f1558d = jSONObject.optString("title");
            this.f1556b = jSONObject.optInt("duration");
            jSONObject.optInt("width");
            jSONObject.optInt("height");
            jSONObject.optDouble("whRatio", 0.0d);
            this.f1557c = jSONObject.optString("poster_image");
            this.f1560f = r.a(jSONObject.optJSONObject(AdWebVideoActivityConfig.KEY_TAIL_FRAME));
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!TextUtils.isEmpty(next) && (opt2 = jSONObject.opt(next)) != null && !(opt2 instanceof JSONObject) && !(opt2 instanceof JSONArray)) {
                    this.f1562h.put(next, jSONObject.optString(next));
                }
            }
            return;
        }
        this.a = jSONObject.optString(TiebaStatic.Params.VID);
        jSONObject.optString("videoId");
        jSONObject.optString("videoUrl");
        this.f1558d = jSONObject.optString("title");
        this.f1556b = jSONObject.optInt("duration");
        jSONObject.optInt("width");
        jSONObject.optInt("height");
        this.f1557c = jSONObject.optString("posterImage");
        jSONObject.optDouble("whRatio", 0.0d);
        this.f1560f = r.a(jSONObject.optJSONObject(AdWebVideoActivityConfig.KEY_TAIL_FRAME));
        Iterator<String> keys2 = jSONObject.keys();
        while (keys2.hasNext()) {
            String next2 = keys2.next();
            if (!TextUtils.isEmpty(next2) && (opt = jSONObject.opt(next2)) != null && !(opt instanceof JSONObject) && !(opt instanceof JSONArray)) {
                this.f1562h.put(next2, jSONObject.optString(next2));
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
            if (TextUtils.isEmpty(this.f1558d) && !TextUtils.isEmpty(adBaseModel.f27543f.f1552g)) {
                String str = adBaseModel.f27543f.f1552g;
                this.f1558d = str;
                this.f1562h.put("title", str);
            }
            if (TextUtils.isEmpty(this.f1559e)) {
                this.f1559e = adBaseModel.f27543f.f1549d;
            }
            c();
            r rVar = this.f1560f;
            if (rVar != null) {
                rVar.d(adBaseModel);
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || TextUtils.isEmpty(this.f1561g)) {
            return;
        }
        JSONObject b2 = c.a.a0.x.b.b(this.f1561g);
        if (!TextUtils.isEmpty(this.f1558d) && TextUtils.isEmpty(b2.optString("title"))) {
            c.a.a0.x.b.e(b2, "title", this.f1558d);
        }
        JSONObject optJSONObject = b2.optJSONObject("ext_log");
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
        }
        if (TextUtils.isEmpty(optJSONObject.optString("curVid"))) {
            c.a.a0.x.b.e(optJSONObject, "curVid", this.a);
        }
        if (!optJSONObject.has("mt")) {
            c.a.a0.x.b.c(optJSONObject, "mt", 2);
        }
        if (!optJSONObject.has("vType")) {
            c.a.a0.x.b.c(optJSONObject, "vType", 2);
        }
        if (!TextUtils.isEmpty(this.f1559e) && TextUtils.isEmpty(optJSONObject.optString("ad_extra_param"))) {
            c.a.a0.x.b.e(optJSONObject, "ad_extra_param", this.f1559e);
        }
        c.a.a0.x.b.e(b2, "ext_log", optJSONObject);
        this.f1561g = b2.toString();
    }
}
