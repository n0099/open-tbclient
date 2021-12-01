package c.a.p0.u;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f11074b;

    /* renamed from: c  reason: collision with root package name */
    public int f11075c;

    /* renamed from: d  reason: collision with root package name */
    public String f11076d;

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f11077e;

    /* renamed from: f  reason: collision with root package name */
    public long f11078f;

    /* renamed from: g  reason: collision with root package name */
    public int f11079g;

    /* renamed from: h  reason: collision with root package name */
    public String f11080h;

    /* renamed from: i  reason: collision with root package name */
    public String f11081i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f11082j;

    /* renamed from: k  reason: collision with root package name */
    public String f11083k;

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
        this.f11076d = "";
        this.f11082j = false;
        this.f11083k = "";
        this.a = str;
        this.f11074b = str;
        this.f11075c = -1;
        this.f11076d = str2;
        this.f11079g = i2;
        if ((i2 & 2) == 0) {
            this.f11078f = System.currentTimeMillis();
        }
        try {
            this.f11077e = new JSONObject(this.f11076d);
        } catch (JSONException unused) {
        }
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = this.f11077e;
            return jSONObject != null ? jSONObject.optString("bizId") : "";
        }
        return (String) invokeV.objValue;
    }

    public void b() {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (str = this.a) != null && str.equals(this.f11074b) && d.g().a(this.a)) {
            this.f11080h = e.g().h();
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
        this.f11076d = "";
        this.f11082j = false;
        this.f11083k = "";
        this.a = str;
        this.f11074b = str;
        this.f11075c = -1;
        this.f11077e = jSONObject;
        this.f11079g = i2;
        if ((i2 & 2) == 0) {
            this.f11078f = System.currentTimeMillis();
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
        this.f11076d = "";
        this.f11082j = false;
        this.f11083k = "";
        this.a = str2;
        this.f11074b = str;
        this.f11075c = i2;
        this.f11076d = str3;
        this.f11079g = i3;
        if ((i3 & 2) == 0) {
            this.f11078f = System.currentTimeMillis();
        }
        try {
            this.f11077e = new JSONObject(this.f11076d);
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
        this.f11076d = "";
        this.f11082j = false;
        this.f11083k = "";
        this.a = str2;
        this.f11074b = str;
        this.f11075c = i2;
        this.f11076d = str3;
        this.f11079g = i3;
        if ((i3 & 2) == 0) {
            if (j2 > 0) {
                this.f11078f = j2;
            } else {
                this.f11078f = System.currentTimeMillis();
            }
        }
        if (TextUtils.isEmpty(this.f11076d)) {
            return;
        }
        try {
            this.f11077e = new JSONObject(this.f11076d);
        } catch (JSONException unused) {
        }
    }
}
