package c.a.r0.h3;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public int f17801b;

    /* renamed from: c  reason: collision with root package name */
    public int f17802c;

    /* renamed from: d  reason: collision with root package name */
    public int f17803d;

    /* renamed from: e  reason: collision with root package name */
    public int f17804e;

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
        this.f17801b = 0;
        this.f17802c = 0;
        this.f17803d = 0;
        this.f17804e = 0;
    }

    public void a(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (z2) {
                if (z) {
                    this.f17804e++;
                } else {
                    this.f17803d++;
                }
            } else if (z) {
                this.f17801b++;
            } else {
                this.f17802c++;
            }
        }
    }

    public int b(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) ? z2 ? z ? this.f17804e : this.f17803d : z ? this.f17801b : this.f17802c : invokeCommon.intValue;
    }

    public JSONObject c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("forum_name", this.a);
                jSONObject.put("refresh_count", this.f17801b);
                jSONObject.put("loadmore_count", this.f17802c);
                jSONObject.put("loadmore_count_pb", this.f17803d);
                jSONObject.put("refresh_count_pb", this.f17804e);
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
        this.f17801b = 0;
        this.f17802c = 0;
        this.f17803d = 0;
        this.f17804e = 0;
        if (jSONObject != null) {
            this.a = jSONObject.optString("forum_name");
            this.f17801b = jSONObject.optInt("refresh_count");
            this.f17802c = jSONObject.optInt("loadmore_count");
            this.f17803d = jSONObject.optInt("loadmore_count_pb");
            this.f17804e = jSONObject.optInt("refresh_count_pb");
        }
    }
}
