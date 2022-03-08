package c.a.b0.s;

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
public class t {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;

    /* renamed from: b  reason: collision with root package name */
    public final String f1967b;

    /* renamed from: c  reason: collision with root package name */
    public final String f1968c;

    /* renamed from: d  reason: collision with root package name */
    public final String f1969d;

    /* renamed from: e  reason: collision with root package name */
    public final double f1970e;

    /* renamed from: f  reason: collision with root package name */
    public final String f1971f;

    /* renamed from: g  reason: collision with root package name */
    public final b f1972g;

    /* renamed from: h  reason: collision with root package name */
    public final a f1973h;

    /* renamed from: i  reason: collision with root package name */
    public final String f1974i;

    /* renamed from: j  reason: collision with root package name */
    public final String f1975j;
    public final boolean k;

    /* loaded from: classes.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f1976b;

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
            this.f1976b = jSONObject.optString("cmd");
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
        public String f1977b;

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
            this.f1977b = jSONObject.optString("cmd");
        }

        public static b a(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) ? new b(jSONObject) : (b) invokeL.objValue;
        }
    }

    public t(@NonNull JSONObject jSONObject) throws ParseError {
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
        this.f1967b = jSONObject.optString("app_icon");
        this.f1968c = jSONObject.optString("app_name");
        this.f1969d = jSONObject.optString("developer_name");
        this.f1970e = jSONObject.optDouble("score", -1.0d);
        this.f1971f = jSONObject.optString("version");
        this.f1972g = b.a(jSONObject.optJSONObject("privacy"));
        this.f1973h = a.a(jSONObject.optJSONObject("permission"));
        jSONObject.optDouble("app_icon_scale");
        this.f1974i = jSONObject.optString("apk_size");
        this.f1975j = jSONObject.optString("apk_url");
        this.k = a();
    }

    public static t c(JSONObject jSONObject) throws ParseError {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) ? new t(jSONObject) : (t) invokeL.objValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (TextUtils.isEmpty(this.f1969d) || TextUtils.isEmpty(this.f1971f) || (bVar = this.f1972g) == null || TextUtils.isEmpty(bVar.f1977b) || TextUtils.isEmpty(this.f1972g.a) || (aVar = this.f1973h) == null || TextUtils.isEmpty(aVar.f1976b) || TextUtils.isEmpty(this.f1973h.a)) ? false : true : invokeV.booleanValue;
    }
}
