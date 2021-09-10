package c.a.r0.y2;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f29560a;

    /* renamed from: b  reason: collision with root package name */
    public int f29561b;

    /* renamed from: c  reason: collision with root package name */
    public int f29562c;

    /* renamed from: d  reason: collision with root package name */
    public int f29563d;

    /* renamed from: e  reason: collision with root package name */
    public int f29564e;

    public k() {
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
        this.f29561b = 0;
        this.f29562c = 0;
        this.f29563d = 0;
        this.f29564e = 0;
    }

    public void a(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (z2) {
                if (z) {
                    this.f29564e++;
                } else {
                    this.f29563d++;
                }
            } else if (z) {
                this.f29561b++;
            } else {
                this.f29562c++;
            }
        }
    }

    public int b(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) ? z2 ? z ? this.f29564e : this.f29563d : z ? this.f29561b : this.f29562c : invokeCommon.intValue;
    }

    public JSONObject c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("forum_name", this.f29560a);
                jSONObject.put("refresh_count", this.f29561b);
                jSONObject.put("loadmore_count", this.f29562c);
                jSONObject.put("loadmore_count_pb", this.f29563d);
                jSONObject.put("refresh_count_pb", this.f29564e);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f29561b = 0;
        this.f29562c = 0;
        this.f29563d = 0;
        this.f29564e = 0;
        if (jSONObject != null) {
            this.f29560a = jSONObject.optString("forum_name");
            this.f29561b = jSONObject.optInt("refresh_count");
            this.f29562c = jSONObject.optInt("loadmore_count");
            this.f29563d = jSONObject.optInt("loadmore_count_pb");
            this.f29564e = jSONObject.optInt("refresh_count_pb");
        }
    }
}
