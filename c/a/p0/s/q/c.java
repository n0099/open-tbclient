package c.a.p0.s.q;

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
    public boolean f14155a;

    /* renamed from: b  reason: collision with root package name */
    public String f14156b;

    /* renamed from: c  reason: collision with root package name */
    public String f14157c;

    /* renamed from: d  reason: collision with root package name */
    public String f14158d;

    /* renamed from: e  reason: collision with root package name */
    public float f14159e;

    /* renamed from: f  reason: collision with root package name */
    public String f14160f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    public b f14161g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public a f14162h;

    /* renamed from: i  reason: collision with root package name */
    public String f14163i;

    /* renamed from: j  reason: collision with root package name */
    public String f14164j;

    /* loaded from: classes3.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f14165a;

        /* renamed from: b  reason: collision with root package name */
        public String f14166b;

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
                aVar.f14165a = jSONObject.optString("desc", DisplayInfoView.AUTH_TEXT);
                String optString = jSONObject.optString("url");
                aVar.f14166b = optString;
                if (TextUtils.isEmpty(optString)) {
                    aVar.f14166b = jSONObject.optString("cmd");
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
        public String f14167a;

        /* renamed from: b  reason: collision with root package name */
        public String f14168b;

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
                bVar.f14167a = jSONObject.optString("desc", DisplayInfoView.PRI_TEXT);
                String optString = jSONObject.optString("url");
                bVar.f14168b = optString;
                if (TextUtils.isEmpty(optString)) {
                    bVar.f14168b = jSONObject.optString("cmd");
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
        this.f14159e = -1.0f;
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
            return (TextUtils.isEmpty(cVar.f14160f) && TextUtils.isEmpty(cVar.f14158d) && ((bVar = cVar.f14161g) == null || TextUtils.isEmpty(bVar.f14167a)) && ((aVar = cVar.f14162h) == null || TextUtils.isEmpty(aVar.f14165a))) ? false : true;
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
            cVar.f14155a = TextUtils.equals(jSONObject.optString("strict_mode", "1"), "1");
            cVar.f14156b = jSONObject.optString("app_icon");
            cVar.f14157c = jSONObject.optString("app_name");
            cVar.f14158d = jSONObject.optString("developer_name");
            cVar.f14160f = jSONObject.optString("version");
            cVar.f14161g = b.a(jSONObject.optJSONObject("privacy"));
            cVar.f14162h = a.a(jSONObject.optJSONObject("permission"));
            cVar.f14163i = jSONObject.optString("apk_size");
            cVar.f14164j = jSONObject.optString("apk_url");
            try {
                float parseFloat = Float.parseFloat(jSONObject.optString("score"));
                if (parseFloat <= 5.0f && parseFloat >= 0.0f) {
                    cVar.f14159e = parseFloat;
                } else {
                    cVar.f14159e = -1.0f;
                }
            } catch (NumberFormatException unused) {
                cVar.f14159e = -1.0f;
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
            if (cVar != null && cVar.f14155a) {
                return (TextUtils.isEmpty(cVar.f14160f) || TextUtils.isEmpty(cVar.f14158d) || (bVar = cVar.f14161g) == null || TextUtils.isEmpty(bVar.f14168b) || (aVar = cVar.f14162h) == null || TextUtils.isEmpty(aVar.f14166b)) ? false : true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
