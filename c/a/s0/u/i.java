package c.a.s0.u;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f12079b;

    /* renamed from: c  reason: collision with root package name */
    public int f12080c;

    /* renamed from: d  reason: collision with root package name */
    public String f12081d;

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f12082e;

    /* renamed from: f  reason: collision with root package name */
    public long f12083f;

    /* renamed from: g  reason: collision with root package name */
    public int f12084g;

    /* renamed from: h  reason: collision with root package name */
    public String f12085h;

    /* renamed from: i  reason: collision with root package name */
    public String f12086i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f12087j;
    public String k;

    public i(String str, String str2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f12081d = "";
        this.f12087j = false;
        this.k = "";
        this.a = str;
        this.f12079b = str;
        this.f12080c = -1;
        this.f12081d = str2;
        this.f12084g = i2;
        if ((i2 & 2) == 0) {
            this.f12083f = System.currentTimeMillis();
        }
        try {
            this.f12082e = new JSONObject(this.f12081d);
        } catch (JSONException unused) {
        }
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = this.f12082e;
            return jSONObject != null ? jSONObject.optString("bizId") : "";
        }
        return (String) invokeV.objValue;
    }

    public void b() {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (str = this.a) != null && str.equals(this.f12079b) && d.g().a(this.a)) {
            this.f12085h = e.g().h();
        }
    }

    public i(String str, JSONObject jSONObject, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, jSONObject, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.f12081d = "";
        this.f12087j = false;
        this.k = "";
        this.a = str;
        this.f12079b = str;
        this.f12080c = -1;
        this.f12082e = jSONObject;
        this.f12084g = i2;
        if ((i2 & 2) == 0) {
            this.f12083f = System.currentTimeMillis();
        }
    }

    public i(String str, String str2, int i2, String str3, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, Integer.valueOf(i2), str3, Integer.valueOf(i3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f12081d = "";
        this.f12087j = false;
        this.k = "";
        this.a = str2;
        this.f12079b = str;
        this.f12080c = i2;
        this.f12081d = str3;
        this.f12084g = i3;
        if ((i3 & 2) == 0) {
            this.f12083f = System.currentTimeMillis();
        }
        try {
            this.f12082e = new JSONObject(this.f12081d);
        } catch (JSONException unused) {
        }
    }

    public i(String str, String str2, int i2, String str3, long j2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, Integer.valueOf(i2), str3, Long.valueOf(j2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f12081d = "";
        this.f12087j = false;
        this.k = "";
        this.a = str2;
        this.f12079b = str;
        this.f12080c = i2;
        this.f12081d = str3;
        this.f12084g = i3;
        if ((i3 & 2) == 0) {
            if (j2 > 0) {
                this.f12083f = j2;
            } else {
                this.f12083f = System.currentTimeMillis();
            }
        }
        if (TextUtils.isEmpty(this.f12081d)) {
            return;
        }
        try {
            this.f12082e = new JSONObject(this.f12081d);
        } catch (JSONException unused) {
        }
    }
}
