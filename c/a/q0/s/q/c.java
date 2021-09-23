package c.a.q0.s.q;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.mobads.container.widget.DisplayInfoView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f14102a;

    /* renamed from: b  reason: collision with root package name */
    public String f14103b;

    /* renamed from: c  reason: collision with root package name */
    public String f14104c;

    /* renamed from: d  reason: collision with root package name */
    public String f14105d;

    /* renamed from: e  reason: collision with root package name */
    public float f14106e;

    /* renamed from: f  reason: collision with root package name */
    public String f14107f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    public b f14108g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public a f14109h;

    /* renamed from: i  reason: collision with root package name */
    public String f14110i;

    /* renamed from: j  reason: collision with root package name */
    public String f14111j;

    /* loaded from: classes3.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f14112a;

        /* renamed from: b  reason: collision with root package name */
        public String f14113b;

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
                aVar.f14112a = jSONObject.optString("desc", DisplayInfoView.AUTH_TEXT);
                String optString = jSONObject.optString("url");
                aVar.f14113b = optString;
                if (TextUtils.isEmpty(optString)) {
                    aVar.f14113b = jSONObject.optString("cmd");
                }
                return aVar;
            }
            return (a) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f14114a;

        /* renamed from: b  reason: collision with root package name */
        public String f14115b;

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
                bVar.f14114a = jSONObject.optString("desc", DisplayInfoView.PRI_TEXT);
                String optString = jSONObject.optString("url");
                bVar.f14115b = optString;
                if (TextUtils.isEmpty(optString)) {
                    bVar.f14115b = jSONObject.optString("cmd");
                }
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
        this.f14106e = -1.0f;
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
            return (TextUtils.isEmpty(cVar.f14107f) && TextUtils.isEmpty(cVar.f14105d) && ((bVar = cVar.f14108g) == null || TextUtils.isEmpty(bVar.f14114a)) && ((aVar = cVar.f14109h) == null || TextUtils.isEmpty(aVar.f14112a))) ? false : true;
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
            cVar.f14102a = TextUtils.equals(jSONObject.optString("strict_mode", "1"), "1");
            cVar.f14103b = jSONObject.optString("app_icon");
            cVar.f14104c = jSONObject.optString("app_name");
            cVar.f14105d = jSONObject.optString("developer_name");
            cVar.f14107f = jSONObject.optString("version");
            cVar.f14108g = b.a(jSONObject.optJSONObject("privacy"));
            cVar.f14109h = a.a(jSONObject.optJSONObject("permission"));
            cVar.f14110i = jSONObject.optString("apk_size");
            cVar.f14111j = jSONObject.optString("apk_url");
            try {
                float parseFloat = Float.parseFloat(jSONObject.optString("score"));
                if (parseFloat <= 5.0f && parseFloat >= 0.0f) {
                    cVar.f14106e = parseFloat;
                } else {
                    cVar.f14106e = -1.0f;
                }
            } catch (NumberFormatException unused) {
                cVar.f14106e = -1.0f;
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
            if (cVar != null && cVar.f14102a) {
                return (TextUtils.isEmpty(cVar.f14107f) || TextUtils.isEmpty(cVar.f14105d) || (bVar = cVar.f14108g) == null || TextUtils.isEmpty(bVar.f14115b) || (aVar = cVar.f14109h) == null || TextUtils.isEmpty(aVar.f14113b)) ? false : true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
