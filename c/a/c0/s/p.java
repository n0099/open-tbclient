package c.a.c0.s;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.model.ParseError;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class p {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;

    /* renamed from: b  reason: collision with root package name */
    public final String f2266b;

    /* renamed from: c  reason: collision with root package name */
    public final String f2267c;

    /* renamed from: d  reason: collision with root package name */
    public final String f2268d;

    /* renamed from: e  reason: collision with root package name */
    public final double f2269e;

    /* renamed from: f  reason: collision with root package name */
    public final String f2270f;

    /* renamed from: g  reason: collision with root package name */
    public final b f2271g;

    /* renamed from: h  reason: collision with root package name */
    public final a f2272h;

    /* renamed from: i  reason: collision with root package name */
    public final String f2273i;

    /* renamed from: j  reason: collision with root package name */
    public final String f2274j;
    public final boolean k;

    /* loaded from: classes.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f2275b;

        public a(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            if (jSONObject == null) {
                return;
            }
            this.a = jSONObject.optString("desc");
            this.f2275b = jSONObject.optString("cmd");
        }

        public static a a(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) ? new a(jSONObject) : (a) invokeL.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f2276b;

        public b(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            if (jSONObject == null) {
                return;
            }
            this.a = jSONObject.optString("desc");
            this.f2276b = jSONObject.optString("cmd");
        }

        public static b a(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) ? new b(jSONObject) : (b) invokeL.objValue;
        }
    }

    public p(@NonNull JSONObject jSONObject) throws ParseError {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONObject};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = jSONObject.optString("strict_mode");
        this.f2266b = jSONObject.optString("app_icon");
        this.f2267c = jSONObject.optString("app_name");
        this.f2268d = jSONObject.optString("developer_name");
        this.f2269e = jSONObject.optDouble("score", -1.0d);
        this.f2270f = jSONObject.optString("version");
        this.f2271g = b.a(jSONObject.optJSONObject("privacy"));
        this.f2272h = a.a(jSONObject.optJSONObject("permission"));
        jSONObject.optDouble("app_icon_scale");
        this.f2273i = jSONObject.optString("apk_size");
        this.f2274j = jSONObject.optString("apk_url");
        this.k = a();
    }

    public static p c(JSONObject jSONObject) throws ParseError {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) ? new p(jSONObject) : (p) invokeL.objValue;
    }

    public final boolean a() throws ParseError {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (TextUtils.equals("0", this.a)) {
                return b();
            }
            if (b()) {
                return true;
            }
            throw ParseError.contentError(8, "");
        }
        return invokeV.booleanValue;
    }

    public final boolean b() {
        InterceptResult invokeV;
        b bVar;
        a aVar;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (TextUtils.isEmpty(this.f2268d) || TextUtils.isEmpty(this.f2270f) || (bVar = this.f2271g) == null || TextUtils.isEmpty(bVar.f2276b) || TextUtils.isEmpty(this.f2271g.a) || (aVar = this.f2272h) == null || TextUtils.isEmpty(aVar.f2275b) || TextUtils.isEmpty(this.f2272h.a)) ? false : true : invokeV.booleanValue;
    }
}
