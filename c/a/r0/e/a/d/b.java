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
    public int f10298b;

    /* renamed from: c  reason: collision with root package name */
    public int f10299c;

    /* renamed from: d  reason: collision with root package name */
    public int f10300d;

    /* renamed from: e  reason: collision with root package name */
    public int f10301e;

    /* renamed from: f  reason: collision with root package name */
    public int f10302f;

    /* renamed from: g  reason: collision with root package name */
    public int f10303g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f10304h;

    /* renamed from: i  reason: collision with root package name */
    public a f10305i;

    /* renamed from: j  reason: collision with root package name */
    public a f10306j;
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
        this.f10298b = -1;
        this.f10299c = -1;
        this.f10300d = -1;
        this.f10301e = -1;
        this.f10302f = -1;
        this.f10303g = -1;
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (!this.f10304h) {
                return b(this.l);
            }
            a aVar = this.k;
            if (aVar != null) {
                return aVar.f10297g;
            }
            a aVar2 = this.f10305i;
            if (aVar2 != null) {
                return aVar2.f10297g;
            }
            a aVar3 = this.f10306j;
            if (aVar3 != null) {
                return aVar3.f10297g;
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
                return aVar.f10297g;
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
                return aVar.f10296f;
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f10303g != -1 : invokeV.booleanValue;
    }

    @NonNull
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("cores", this.a);
                jSONObject.put("is_biglittle", this.f10304h);
                if (this.f10304h) {
                    jSONObject.put("little_freq_min", c(this.f10306j));
                    jSONObject.put("little_freq_max", b(this.f10306j));
                    jSONObject.put("big_freq_min", c(this.f10305i));
                    jSONObject.put("big_freq_max", b(this.f10305i));
                    jSONObject.put("little_cores", this.f10298b);
                    jSONObject.put("big_cores", this.f10300d);
                    jSONObject.put("little_index", this.f10299c);
                    jSONObject.put("big_index", this.f10301e);
                    if (this.f10303g != -1) {
                        jSONObject.put("super_freq_min", c(this.k));
                        jSONObject.put("super_freq_max", b(this.k));
                        jSONObject.put("super_cores", this.f10302f);
                        jSONObject.put("super_index", this.f10303g);
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
