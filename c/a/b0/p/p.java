package c.a.b0.p;

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
    public final String f1811b;

    /* renamed from: c  reason: collision with root package name */
    public final String f1812c;

    /* renamed from: d  reason: collision with root package name */
    public final String f1813d;

    /* renamed from: e  reason: collision with root package name */
    public final double f1814e;

    /* renamed from: f  reason: collision with root package name */
    public final String f1815f;

    /* renamed from: g  reason: collision with root package name */
    public final b f1816g;

    /* renamed from: h  reason: collision with root package name */
    public final a f1817h;

    /* renamed from: i  reason: collision with root package name */
    public final String f1818i;

    /* renamed from: j  reason: collision with root package name */
    public final String f1819j;

    /* renamed from: k  reason: collision with root package name */
    public final boolean f1820k;

    /* loaded from: classes.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f1821b;

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
            this.f1821b = jSONObject.optString("cmd");
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
        public String f1822b;

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
            this.f1822b = jSONObject.optString("cmd");
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
        this.f1811b = jSONObject.optString("app_icon");
        this.f1812c = jSONObject.optString("app_name");
        this.f1813d = jSONObject.optString("developer_name");
        this.f1814e = jSONObject.optDouble("score", -1.0d);
        this.f1815f = jSONObject.optString("version");
        this.f1816g = b.a(jSONObject.optJSONObject("privacy"));
        this.f1817h = a.a(jSONObject.optJSONObject("permission"));
        jSONObject.optDouble("app_icon_scale");
        this.f1818i = jSONObject.optString("apk_size");
        this.f1819j = jSONObject.optString("apk_url");
        this.f1820k = a();
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (TextUtils.isEmpty(this.f1813d) || TextUtils.isEmpty(this.f1815f) || (bVar = this.f1816g) == null || TextUtils.isEmpty(bVar.f1822b) || TextUtils.isEmpty(this.f1816g.a) || (aVar = this.f1817h) == null || TextUtils.isEmpty(aVar.f1821b) || TextUtils.isEmpty(this.f1817h.a)) ? false : true : invokeV.booleanValue;
    }
}
