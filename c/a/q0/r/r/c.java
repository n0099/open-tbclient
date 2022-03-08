package c.a.q0.r.r;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public String f13195b;

    /* renamed from: c  reason: collision with root package name */
    public String f13196c;

    /* renamed from: d  reason: collision with root package name */
    public String f13197d;

    /* renamed from: e  reason: collision with root package name */
    public float f13198e;

    /* renamed from: f  reason: collision with root package name */
    public String f13199f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    public b f13200g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public a f13201h;

    /* renamed from: i  reason: collision with root package name */
    public String f13202i;

    /* renamed from: j  reason: collision with root package name */
    public String f13203j;

    /* loaded from: classes2.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f13204b;

        /* renamed from: c  reason: collision with root package name */
        public String f13205c;

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
                aVar.f13204b = optString;
                if (TextUtils.isEmpty(optString)) {
                    aVar.f13204b = jSONObject.optString("cmd");
                }
                aVar.f13205c = jSONObject.optString("cmd");
                return aVar;
            }
            return (a) invokeL.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f13206b;

        /* renamed from: c  reason: collision with root package name */
        public String f13207c;

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
                bVar.f13206b = optString;
                if (TextUtils.isEmpty(optString)) {
                    bVar.f13206b = jSONObject.optString("cmd");
                }
                bVar.f13207c = jSONObject.optString("cmd");
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
        this.f13198e = -1.0f;
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
            return (TextUtils.isEmpty(cVar.f13199f) && TextUtils.isEmpty(cVar.f13197d) && ((bVar = cVar.f13200g) == null || TextUtils.isEmpty(bVar.a)) && ((aVar = cVar.f13201h) == null || TextUtils.isEmpty(aVar.a))) ? false : true;
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
            cVar.f13195b = jSONObject.optString("app_icon");
            cVar.f13196c = jSONObject.optString("app_name");
            cVar.f13197d = jSONObject.optString("developer_name");
            cVar.f13199f = jSONObject.optString("version");
            cVar.f13200g = b.a(jSONObject.optJSONObject("privacy"));
            cVar.f13201h = a.a(jSONObject.optJSONObject("permission"));
            cVar.f13202i = jSONObject.optString("apk_size");
            cVar.f13203j = jSONObject.optString("apk_url");
            try {
                float parseFloat = Float.parseFloat(jSONObject.optString("score"));
                if (parseFloat <= 5.0f && parseFloat >= 0.0f) {
                    cVar.f13198e = parseFloat;
                } else {
                    cVar.f13198e = -1.0f;
                }
            } catch (NumberFormatException unused) {
                cVar.f13198e = -1.0f;
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
                return (TextUtils.isEmpty(cVar.f13199f) || TextUtils.isEmpty(cVar.f13197d) || (bVar = cVar.f13200g) == null || TextUtils.isEmpty(bVar.f13206b) || (aVar = cVar.f13201h) == null || TextUtils.isEmpty(aVar.f13204b)) ? false : true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
