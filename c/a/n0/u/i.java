package c.a.n0.u;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f9452b;

    /* renamed from: c  reason: collision with root package name */
    public int f9453c;

    /* renamed from: d  reason: collision with root package name */
    public String f9454d;

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f9455e;

    /* renamed from: f  reason: collision with root package name */
    public long f9456f;

    /* renamed from: g  reason: collision with root package name */
    public int f9457g;

    /* renamed from: h  reason: collision with root package name */
    public String f9458h;
    public String i;
    public boolean j;
    public String k;

    public i(String str, String str2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f9454d = "";
        this.j = false;
        this.k = "";
        this.a = str;
        this.f9452b = str;
        this.f9453c = -1;
        this.f9454d = str2;
        this.f9457g = i;
        if ((i & 2) == 0) {
            this.f9456f = System.currentTimeMillis();
        }
        try {
            this.f9455e = new JSONObject(this.f9454d);
        } catch (JSONException unused) {
        }
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = this.f9455e;
            return jSONObject != null ? jSONObject.optString("bizId") : "";
        }
        return (String) invokeV.objValue;
    }

    public void b() {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (str = this.a) != null && str.equals(this.f9452b) && d.g().a(this.a)) {
            this.f9458h = e.g().h();
        }
    }

    public i(String str, JSONObject jSONObject, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, jSONObject, Integer.valueOf(i)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.f9454d = "";
        this.j = false;
        this.k = "";
        this.a = str;
        this.f9452b = str;
        this.f9453c = -1;
        this.f9455e = jSONObject;
        this.f9457g = i;
        if ((i & 2) == 0) {
            this.f9456f = System.currentTimeMillis();
        }
    }

    public i(String str, String str2, int i, String str3, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, Integer.valueOf(i), str3, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f9454d = "";
        this.j = false;
        this.k = "";
        this.a = str2;
        this.f9452b = str;
        this.f9453c = i;
        this.f9454d = str3;
        this.f9457g = i2;
        if ((i2 & 2) == 0) {
            this.f9456f = System.currentTimeMillis();
        }
        try {
            this.f9455e = new JSONObject(this.f9454d);
        } catch (JSONException unused) {
        }
    }

    public i(String str, String str2, int i, String str3, long j, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, Integer.valueOf(i), str3, Long.valueOf(j), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f9454d = "";
        this.j = false;
        this.k = "";
        this.a = str2;
        this.f9452b = str;
        this.f9453c = i;
        this.f9454d = str3;
        this.f9457g = i2;
        if ((i2 & 2) == 0) {
            if (j > 0) {
                this.f9456f = j;
            } else {
                this.f9456f = System.currentTimeMillis();
            }
        }
        if (TextUtils.isEmpty(this.f9454d)) {
            return;
        }
        try {
            this.f9455e = new JSONObject(this.f9454d);
        } catch (JSONException unused) {
        }
    }
}
