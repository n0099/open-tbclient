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
    public boolean f14105a;

    /* renamed from: b  reason: collision with root package name */
    public String f14106b;

    /* renamed from: c  reason: collision with root package name */
    public String f14107c;

    /* renamed from: d  reason: collision with root package name */
    public String f14108d;

    /* renamed from: e  reason: collision with root package name */
    public float f14109e;

    /* renamed from: f  reason: collision with root package name */
    public String f14110f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    public b f14111g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public a f14112h;

    /* renamed from: i  reason: collision with root package name */
    public String f14113i;

    /* renamed from: j  reason: collision with root package name */
    public String f14114j;

    /* loaded from: classes3.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f14115a;

        /* renamed from: b  reason: collision with root package name */
        public String f14116b;

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
                aVar.f14115a = jSONObject.optString("desc", DisplayInfoView.AUTH_TEXT);
                String optString = jSONObject.optString("url");
                aVar.f14116b = optString;
                if (TextUtils.isEmpty(optString)) {
                    aVar.f14116b = jSONObject.optString("cmd");
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
        public String f14117a;

        /* renamed from: b  reason: collision with root package name */
        public String f14118b;

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
                bVar.f14117a = jSONObject.optString("desc", DisplayInfoView.PRI_TEXT);
                String optString = jSONObject.optString("url");
                bVar.f14118b = optString;
                if (TextUtils.isEmpty(optString)) {
                    bVar.f14118b = jSONObject.optString("cmd");
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
        this.f14109e = -1.0f;
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
            return (TextUtils.isEmpty(cVar.f14110f) && TextUtils.isEmpty(cVar.f14108d) && ((bVar = cVar.f14111g) == null || TextUtils.isEmpty(bVar.f14117a)) && ((aVar = cVar.f14112h) == null || TextUtils.isEmpty(aVar.f14115a))) ? false : true;
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
            cVar.f14105a = TextUtils.equals(jSONObject.optString("strict_mode", "1"), "1");
            cVar.f14106b = jSONObject.optString("app_icon");
            cVar.f14107c = jSONObject.optString("app_name");
            cVar.f14108d = jSONObject.optString("developer_name");
            cVar.f14110f = jSONObject.optString("version");
            cVar.f14111g = b.a(jSONObject.optJSONObject("privacy"));
            cVar.f14112h = a.a(jSONObject.optJSONObject("permission"));
            cVar.f14113i = jSONObject.optString("apk_size");
            cVar.f14114j = jSONObject.optString("apk_url");
            try {
                float parseFloat = Float.parseFloat(jSONObject.optString("score"));
                if (parseFloat <= 5.0f && parseFloat >= 0.0f) {
                    cVar.f14109e = parseFloat;
                } else {
                    cVar.f14109e = -1.0f;
                }
            } catch (NumberFormatException unused) {
                cVar.f14109e = -1.0f;
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
            if (cVar != null && cVar.f14105a) {
                return (TextUtils.isEmpty(cVar.f14110f) || TextUtils.isEmpty(cVar.f14108d) || (bVar = cVar.f14111g) == null || TextUtils.isEmpty(bVar.f14118b) || (aVar = cVar.f14112h) == null || TextUtils.isEmpty(aVar.f14116b)) ? false : true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
