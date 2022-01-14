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
    public String f13309b;

    /* renamed from: c  reason: collision with root package name */
    public String f13310c;

    /* renamed from: d  reason: collision with root package name */
    public String f13311d;

    /* renamed from: e  reason: collision with root package name */
    public float f13312e;

    /* renamed from: f  reason: collision with root package name */
    public String f13313f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    public b f13314g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public a f13315h;

    /* renamed from: i  reason: collision with root package name */
    public String f13316i;

    /* renamed from: j  reason: collision with root package name */
    public String f13317j;

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f13318b;

        /* renamed from: c  reason: collision with root package name */
        public String f13319c;

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
                aVar.f13318b = optString;
                if (TextUtils.isEmpty(optString)) {
                    aVar.f13318b = jSONObject.optString("cmd");
                }
                aVar.f13319c = jSONObject.optString("cmd");
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
        public String f13320b;

        /* renamed from: c  reason: collision with root package name */
        public String f13321c;

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
                bVar.f13320b = optString;
                if (TextUtils.isEmpty(optString)) {
                    bVar.f13320b = jSONObject.optString("cmd");
                }
                bVar.f13321c = jSONObject.optString("cmd");
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
        this.f13312e = -1.0f;
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
            return (TextUtils.isEmpty(cVar.f13313f) && TextUtils.isEmpty(cVar.f13311d) && ((bVar = cVar.f13314g) == null || TextUtils.isEmpty(bVar.a)) && ((aVar = cVar.f13315h) == null || TextUtils.isEmpty(aVar.a))) ? false : true;
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
            cVar.f13309b = jSONObject.optString("app_icon");
            cVar.f13310c = jSONObject.optString("app_name");
            cVar.f13311d = jSONObject.optString("developer_name");
            cVar.f13313f = jSONObject.optString("version");
            cVar.f13314g = b.a(jSONObject.optJSONObject("privacy"));
            cVar.f13315h = a.a(jSONObject.optJSONObject("permission"));
            cVar.f13316i = jSONObject.optString("apk_size");
            cVar.f13317j = jSONObject.optString("apk_url");
            try {
                float parseFloat = Float.parseFloat(jSONObject.optString("score"));
                if (parseFloat <= 5.0f && parseFloat >= 0.0f) {
                    cVar.f13312e = parseFloat;
                } else {
                    cVar.f13312e = -1.0f;
                }
            } catch (NumberFormatException unused) {
                cVar.f13312e = -1.0f;
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
                return (TextUtils.isEmpty(cVar.f13313f) || TextUtils.isEmpty(cVar.f13311d) || (bVar = cVar.f13314g) == null || TextUtils.isEmpty(bVar.f13320b) || (aVar = cVar.f13315h) == null || TextUtils.isEmpty(aVar.f13318b)) ? false : true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
