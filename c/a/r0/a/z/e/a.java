package c.a.r0.a.z.e;

import android.text.TextUtils;
import c.a.r0.a.e0.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlinx.coroutines.DebugKt;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a extends c.a.r0.a.c0.b.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String n;
    public String o;

    /* renamed from: c.a.r0.a.z.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0644a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static String a(String str) {
            InterceptResult invokeL;
            char c2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
                int hashCode = str.hashCode();
                if (hashCode == 3551) {
                    if (str.equals(DebugKt.DEBUG_PROPERTY_VALUE_ON)) {
                        c2 = 2;
                    }
                    c2 = 65535;
                } else if (hashCode != 109935) {
                    if (hashCode == 3005871 && str.equals("auto")) {
                        c2 = 0;
                    }
                    c2 = 65535;
                } else {
                    if (str.equals(DebugKt.DEBUG_PROPERTY_VALUE_OFF)) {
                        c2 = 1;
                    }
                    c2 = 65535;
                }
                return (c2 == 0 || c2 == 1 || c2 == 2) ? str : "auto";
            }
            return (String) invokeL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(String str) {
        super("camera", "cameraId");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((String) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        try {
            a(new JSONObject(str));
        } catch (JSONException e2) {
            d.d("Camera", "parsing CameraAttrModel occurs exception", e2);
        }
    }

    @Override // c.a.r0.a.c0.b.b, c.a.r0.a.m1.a
    public void a(JSONObject jSONObject) throws JSONException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
            super.a(jSONObject);
            this.n = jSONObject.optString("devicePosition", com.alipay.sdk.widget.d.u);
            this.o = jSONObject.optString("flash", "auto");
        }
    }

    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? C0644a.a(this.o) : (String) invokeV.objValue;
    }

    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            c.a.r0.a.m1.e.a.a aVar = this.l;
            if (aVar == null) {
                return 0;
            }
            return aVar.c();
        }
        return invokeV.intValue;
    }

    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            c.a.r0.a.m1.e.a.a aVar = this.l;
            if (aVar == null) {
                return 0;
            }
            return aVar.g();
        }
        return invokeV.intValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? TextUtils.equals(this.n, "front") : invokeV.booleanValue;
    }
}
