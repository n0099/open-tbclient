package c.a.o0.r.r;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.sapi2.stat.ShareLoginStat;
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
    public String f10811b;

    /* renamed from: c  reason: collision with root package name */
    public String f10812c;

    /* renamed from: d  reason: collision with root package name */
    public String f10813d;

    /* renamed from: e  reason: collision with root package name */
    public float f10814e;

    /* renamed from: f  reason: collision with root package name */
    public String f10815f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    public b f10816g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public a f10817h;
    public String i;
    public String j;

    /* loaded from: classes2.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f10818b;

        /* renamed from: c  reason: collision with root package name */
        public String f10819c;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                aVar.f10818b = optString;
                if (TextUtils.isEmpty(optString)) {
                    aVar.f10818b = jSONObject.optString("cmd");
                }
                aVar.f10819c = jSONObject.optString("cmd");
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
        public String f10820b;

        /* renamed from: c  reason: collision with root package name */
        public String f10821c;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                bVar.f10820b = optString;
                if (TextUtils.isEmpty(optString)) {
                    bVar.f10820b = jSONObject.optString("cmd");
                }
                bVar.f10821c = jSONObject.optString("cmd");
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f10814e = -1.0f;
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
            return (TextUtils.isEmpty(cVar.f10815f) && TextUtils.isEmpty(cVar.f10813d) && ((bVar = cVar.f10816g) == null || TextUtils.isEmpty(bVar.a)) && ((aVar = cVar.f10817h) == null || TextUtils.isEmpty(aVar.a))) ? false : true;
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
            cVar.f10811b = jSONObject.optString("app_icon");
            cVar.f10812c = jSONObject.optString("app_name");
            cVar.f10813d = jSONObject.optString("developer_name");
            cVar.f10815f = jSONObject.optString("version");
            cVar.f10816g = b.a(jSONObject.optJSONObject("privacy"));
            cVar.f10817h = a.a(jSONObject.optJSONObject(ShareLoginStat.GetShareListStat.KEY_PERMISSION));
            cVar.i = jSONObject.optString("apk_size");
            cVar.j = jSONObject.optString("apk_url");
            try {
                float parseFloat = Float.parseFloat(jSONObject.optString("score"));
                if (parseFloat <= 5.0f && parseFloat >= 0.0f) {
                    cVar.f10814e = parseFloat;
                } else {
                    cVar.f10814e = -1.0f;
                }
            } catch (NumberFormatException unused) {
                cVar.f10814e = -1.0f;
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
                return (TextUtils.isEmpty(cVar.f10815f) || TextUtils.isEmpty(cVar.f10813d) || (bVar = cVar.f10816g) == null || TextUtils.isEmpty(bVar.f10820b) || (aVar = cVar.f10817h) == null || TextUtils.isEmpty(aVar.f10818b)) ? false : true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
