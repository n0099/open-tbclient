package c.a.r0.e.a.d;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f10440b;

    /* renamed from: c  reason: collision with root package name */
    public int f10441c;

    /* renamed from: d  reason: collision with root package name */
    public int f10442d;

    /* renamed from: e  reason: collision with root package name */
    public int f10443e;

    /* renamed from: f  reason: collision with root package name */
    public int f10444f;

    /* renamed from: g  reason: collision with root package name */
    public int f10445g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f10446h;

    /* renamed from: i  reason: collision with root package name */
    public a f10447i;

    /* renamed from: j  reason: collision with root package name */
    public a f10448j;
    public a k;
    public a l;

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
                return;
            }
        }
        this.a = -1;
        this.f10440b = -1;
        this.f10441c = -1;
        this.f10442d = -1;
        this.f10443e = -1;
        this.f10444f = -1;
        this.f10445g = -1;
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (!this.f10446h) {
                return b(this.l);
            }
            a aVar = this.k;
            if (aVar != null) {
                return aVar.f10439g;
            }
            a aVar2 = this.f10447i;
            if (aVar2 != null) {
                return aVar2.f10439g;
            }
            a aVar3 = this.f10448j;
            if (aVar3 != null) {
                return aVar3.f10439g;
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public final int b(a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) {
            if (aVar != null) {
                return aVar.f10439g;
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public final int c(a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar)) == null) {
            if (aVar != null) {
                return aVar.f10438f;
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f10445g != -1 : invokeV.booleanValue;
    }

    @NonNull
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("cores", this.a);
                jSONObject.put("is_biglittle", this.f10446h);
                if (this.f10446h) {
                    jSONObject.put("little_freq_min", c(this.f10448j));
                    jSONObject.put("little_freq_max", b(this.f10448j));
                    jSONObject.put("big_freq_min", c(this.f10447i));
                    jSONObject.put("big_freq_max", b(this.f10447i));
                    jSONObject.put("little_cores", this.f10440b);
                    jSONObject.put("big_cores", this.f10442d);
                    jSONObject.put("little_index", this.f10441c);
                    jSONObject.put("big_index", this.f10443e);
                    if (this.f10445g != -1) {
                        jSONObject.put("super_freq_min", c(this.k));
                        jSONObject.put("super_freq_max", b(this.k));
                        jSONObject.put("super_cores", this.f10444f);
                        jSONObject.put("super_index", this.f10445g);
                    }
                } else {
                    jSONObject.put("freq_min", c(this.l));
                    jSONObject.put("freq_max", b(this.l));
                }
                return jSONObject.toString();
            } catch (JSONException unused) {
                return "";
            }
        }
        return (String) invokeV.objValue;
    }
}
