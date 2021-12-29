package c.a.s0.s.q;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public String f13625b;

    /* renamed from: c  reason: collision with root package name */
    public String f13626c;

    /* renamed from: d  reason: collision with root package name */
    public String f13627d;

    /* renamed from: e  reason: collision with root package name */
    public float f13628e;

    /* renamed from: f  reason: collision with root package name */
    public String f13629f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    public b f13630g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public a f13631h;

    /* renamed from: i  reason: collision with root package name */
    public String f13632i;

    /* renamed from: j  reason: collision with root package name */
    public String f13633j;

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f13634b;

        /* renamed from: c  reason: collision with root package name */
        public String f13635c;

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
                aVar.f13634b = optString;
                if (TextUtils.isEmpty(optString)) {
                    aVar.f13634b = jSONObject.optString("cmd");
                }
                aVar.f13635c = jSONObject.optString("cmd");
                return aVar;
            }
            return (a) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f13636b;

        /* renamed from: c  reason: collision with root package name */
        public String f13637c;

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
                bVar.f13636b = optString;
                if (TextUtils.isEmpty(optString)) {
                    bVar.f13636b = jSONObject.optString("cmd");
                }
                bVar.f13637c = jSONObject.optString("cmd");
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
        this.f13628e = -1.0f;
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
            return (TextUtils.isEmpty(cVar.f13629f) && TextUtils.isEmpty(cVar.f13627d) && ((bVar = cVar.f13630g) == null || TextUtils.isEmpty(bVar.a)) && ((aVar = cVar.f13631h) == null || TextUtils.isEmpty(aVar.a))) ? false : true;
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
            cVar.f13625b = jSONObject.optString("app_icon");
            cVar.f13626c = jSONObject.optString("app_name");
            cVar.f13627d = jSONObject.optString("developer_name");
            cVar.f13629f = jSONObject.optString("version");
            cVar.f13630g = b.a(jSONObject.optJSONObject("privacy"));
            cVar.f13631h = a.a(jSONObject.optJSONObject("permission"));
            cVar.f13632i = jSONObject.optString("apk_size");
            cVar.f13633j = jSONObject.optString("apk_url");
            try {
                float parseFloat = Float.parseFloat(jSONObject.optString("score"));
                if (parseFloat <= 5.0f && parseFloat >= 0.0f) {
                    cVar.f13628e = parseFloat;
                } else {
                    cVar.f13628e = -1.0f;
                }
            } catch (NumberFormatException unused) {
                cVar.f13628e = -1.0f;
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
                return (TextUtils.isEmpty(cVar.f13629f) || TextUtils.isEmpty(cVar.f13627d) || (bVar = cVar.f13630g) == null || TextUtils.isEmpty(bVar.f13636b) || (aVar = cVar.f13631h) == null || TextUtils.isEmpty(aVar.f13634b)) ? false : true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
