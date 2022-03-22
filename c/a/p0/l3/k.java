package c.a.p0.l3;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public int f16271b;

    /* renamed from: c  reason: collision with root package name */
    public int f16272c;

    /* renamed from: d  reason: collision with root package name */
    public int f16273d;

    /* renamed from: e  reason: collision with root package name */
    public int f16274e;

    public k() {
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
        this.f16271b = 0;
        this.f16272c = 0;
        this.f16273d = 0;
        this.f16274e = 0;
    }

    public void a(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (z2) {
                if (z) {
                    this.f16274e++;
                } else {
                    this.f16273d++;
                }
            } else if (z) {
                this.f16271b++;
            } else {
                this.f16272c++;
            }
        }
    }

    public int b(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) ? z2 ? z ? this.f16274e : this.f16273d : z ? this.f16271b : this.f16272c : invokeCommon.intValue;
    }

    public JSONObject c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("forum_name", this.a);
                jSONObject.put("refresh_count", this.f16271b);
                jSONObject.put("loadmore_count", this.f16272c);
                jSONObject.put("loadmore_count_pb", this.f16273d);
                jSONObject.put("refresh_count_pb", this.f16274e);
                return jSONObject;
            } catch (JSONException unused) {
                return null;
            }
        }
        return (JSONObject) invokeV.objValue;
    }

    public k(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONObject};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f16271b = 0;
        this.f16272c = 0;
        this.f16273d = 0;
        this.f16274e = 0;
        if (jSONObject != null) {
            this.a = jSONObject.optString("forum_name");
            this.f16271b = jSONObject.optInt("refresh_count");
            this.f16272c = jSONObject.optInt("loadmore_count");
            this.f16273d = jSONObject.optInt("loadmore_count_pb");
            this.f16274e = jSONObject.optInt("refresh_count_pb");
        }
    }
}
