package b.a.e0.p;

import android.text.TextUtils;
import b.a.e0.r.h;
import b.a.e0.r.j;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f2661a;

    /* renamed from: b  reason: collision with root package name */
    public long f2662b;

    /* renamed from: c  reason: collision with root package name */
    public String f2663c;

    /* renamed from: d  reason: collision with root package name */
    public String f2664d;

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f2665e;

    public c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f2665e = new JSONObject();
        this.f2661a = str;
        this.f2662b = System.currentTimeMillis();
        this.f2663c = j.c();
    }

    public c a(String str, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, obj)) == null) {
            try {
                this.f2665e.put(str, obj);
            } catch (JSONException unused) {
            }
            return this;
        }
        return (c) invokeLL.objValue;
    }

    public c b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            this.f2664d = str;
            return this;
        }
        return (c) invokeL.objValue;
    }

    public c c(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject)) == null) {
            this.f2665e = jSONObject;
            return this;
        }
        return (c) invokeL.objValue;
    }

    public JSONObject d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (TextUtils.isEmpty(this.f2661a)) {
                h.d("statistics action can not null");
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("a", this.f2661a);
                jSONObject.put("t", this.f2662b);
                jSONObject.put("ct", this.f2663c);
                if (this.f2665e != null) {
                    jSONObject.put(AdvanceSetting.CLEAR_NOTIFICATION, this.f2665e);
                } else if (!TextUtils.isEmpty(this.f2664d)) {
                    try {
                        jSONObject.put(AdvanceSetting.CLEAR_NOTIFICATION, new JSONObject(this.f2664d));
                    } catch (JSONException unused) {
                        jSONObject.put(AdvanceSetting.CLEAR_NOTIFICATION, this.f2664d);
                    }
                }
            } catch (JSONException e2) {
                if (h.f2696d) {
                    e2.printStackTrace();
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
