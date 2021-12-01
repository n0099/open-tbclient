package c.a.q0.s.q;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public String f12869b;

    /* renamed from: c  reason: collision with root package name */
    public String f12870c;

    /* renamed from: d  reason: collision with root package name */
    public String f12871d;

    /* renamed from: e  reason: collision with root package name */
    public float f12872e;

    /* renamed from: f  reason: collision with root package name */
    public String f12873f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    public b f12874g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public a f12875h;

    /* renamed from: i  reason: collision with root package name */
    public String f12876i;

    /* renamed from: j  reason: collision with root package name */
    public String f12877j;

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f12878b;

        /* renamed from: c  reason: collision with root package name */
        public String f12879c;

        public a() {
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
        public static a a(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
                if (jSONObject == null) {
                    return null;
                }
                a aVar = new a();
                aVar.a = jSONObject.optString("desc", "权限");
                String optString = jSONObject.optString("url");
                aVar.f12878b = optString;
                if (TextUtils.isEmpty(optString)) {
                    aVar.f12878b = jSONObject.optString("cmd");
                }
                aVar.f12879c = jSONObject.optString("cmd");
                return aVar;
            }
            return (a) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f12880b;

        /* renamed from: c  reason: collision with root package name */
        public String f12881c;

        public b() {
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
        public static b a(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
                if (jSONObject == null) {
                    return null;
                }
                b bVar = new b();
                bVar.a = jSONObject.optString("desc", "隐私");
                String optString = jSONObject.optString("url");
                bVar.f12880b = optString;
                if (TextUtils.isEmpty(optString)) {
                    bVar.f12880b = jSONObject.optString("cmd");
                }
                bVar.f12881c = jSONObject.optString("cmd");
                return bVar;
            }
            return (b) invokeL.objValue;
        }
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f12872e = -1.0f;
    }

    public static boolean a(c cVar) {
        InterceptResult invokeL;
        b bVar;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, cVar)) == null) {
            if (cVar == null) {
                return false;
            }
            return (TextUtils.isEmpty(cVar.f12873f) && TextUtils.isEmpty(cVar.f12871d) && ((bVar = cVar.f12874g) == null || TextUtils.isEmpty(bVar.a)) && ((aVar = cVar.f12875h) == null || TextUtils.isEmpty(aVar.a))) ? false : true;
        }
        return invokeL.booleanValue;
    }

    @Nullable
    public static c b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            c cVar = new c();
            cVar.a = TextUtils.equals(jSONObject.optString("strict_mode", "1"), "1");
            cVar.f12869b = jSONObject.optString("app_icon");
            cVar.f12870c = jSONObject.optString("app_name");
            cVar.f12871d = jSONObject.optString("developer_name");
            cVar.f12873f = jSONObject.optString("version");
            cVar.f12874g = b.a(jSONObject.optJSONObject("privacy"));
            cVar.f12875h = a.a(jSONObject.optJSONObject("permission"));
            cVar.f12876i = jSONObject.optString("apk_size");
            cVar.f12877j = jSONObject.optString("apk_url");
            try {
                float parseFloat = Float.parseFloat(jSONObject.optString("score"));
                if (parseFloat <= 5.0f && parseFloat >= 0.0f) {
                    cVar.f12872e = parseFloat;
                } else {
                    cVar.f12872e = -1.0f;
                }
            } catch (NumberFormatException unused) {
                cVar.f12872e = -1.0f;
            }
            return cVar;
        }
        return (c) invokeL.objValue;
    }

    public static boolean c(c cVar) {
        InterceptResult invokeL;
        b bVar;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, cVar)) == null) {
            if (cVar != null && cVar.a) {
                return (TextUtils.isEmpty(cVar.f12873f) || TextUtils.isEmpty(cVar.f12871d) || (bVar = cVar.f12874g) == null || TextUtils.isEmpty(bVar.f12880b) || (aVar = cVar.f12875h) == null || TextUtils.isEmpty(aVar.f12878b)) ? false : true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
