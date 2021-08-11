package c.a.o0.s.q;

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
    public boolean f13851a;

    /* renamed from: b  reason: collision with root package name */
    public String f13852b;

    /* renamed from: c  reason: collision with root package name */
    public String f13853c;

    /* renamed from: d  reason: collision with root package name */
    public String f13854d;

    /* renamed from: e  reason: collision with root package name */
    public float f13855e;

    /* renamed from: f  reason: collision with root package name */
    public String f13856f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    public b f13857g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public a f13858h;

    /* renamed from: i  reason: collision with root package name */
    public String f13859i;

    /* renamed from: j  reason: collision with root package name */
    public String f13860j;

    /* loaded from: classes3.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f13861a;

        /* renamed from: b  reason: collision with root package name */
        public String f13862b;

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
                aVar.f13861a = jSONObject.optString("desc", DisplayInfoView.AUTH_TEXT);
                String optString = jSONObject.optString("url");
                aVar.f13862b = optString;
                if (TextUtils.isEmpty(optString)) {
                    aVar.f13862b = jSONObject.optString("cmd");
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
        public String f13863a;

        /* renamed from: b  reason: collision with root package name */
        public String f13864b;

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
                bVar.f13863a = jSONObject.optString("desc", DisplayInfoView.PRI_TEXT);
                String optString = jSONObject.optString("url");
                bVar.f13864b = optString;
                if (TextUtils.isEmpty(optString)) {
                    bVar.f13864b = jSONObject.optString("cmd");
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
        this.f13855e = -1.0f;
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
            return (TextUtils.isEmpty(cVar.f13856f) && TextUtils.isEmpty(cVar.f13854d) && ((bVar = cVar.f13857g) == null || TextUtils.isEmpty(bVar.f13863a)) && ((aVar = cVar.f13858h) == null || TextUtils.isEmpty(aVar.f13861a))) ? false : true;
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
            cVar.f13851a = TextUtils.equals(jSONObject.optString("strict_mode", "1"), "1");
            cVar.f13852b = jSONObject.optString("app_icon");
            cVar.f13853c = jSONObject.optString("app_name");
            cVar.f13854d = jSONObject.optString("developer_name");
            cVar.f13856f = jSONObject.optString("version");
            cVar.f13857g = b.a(jSONObject.optJSONObject("privacy"));
            cVar.f13858h = a.a(jSONObject.optJSONObject("permission"));
            cVar.f13859i = jSONObject.optString("apk_size");
            cVar.f13860j = jSONObject.optString("apk_url");
            try {
                float parseFloat = Float.parseFloat(jSONObject.optString("score"));
                if (parseFloat <= 5.0f && parseFloat >= 0.0f) {
                    cVar.f13855e = parseFloat;
                } else {
                    cVar.f13855e = -1.0f;
                }
            } catch (NumberFormatException unused) {
                cVar.f13855e = -1.0f;
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
            if (cVar != null && cVar.f13851a) {
                return (TextUtils.isEmpty(cVar.f13856f) || TextUtils.isEmpty(cVar.f13854d) || (bVar = cVar.f13857g) == null || TextUtils.isEmpty(bVar.f13864b) || (aVar = cVar.f13858h) == null || TextUtils.isEmpty(aVar.f13862b)) ? false : true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
