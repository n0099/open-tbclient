package b.a.p0.a.a0.a.j;

import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.gesture.GestureAR;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f3918a;

    /* renamed from: b  reason: collision with root package name */
    public int f3919b;

    /* renamed from: c  reason: collision with root package name */
    public Shader f3920c;

    public i(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONArray};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f3918a = "";
        e(jSONArray);
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f3919b : invokeV.intValue;
    }

    public Shader b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f3920c : (Shader) invokeV.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? TextUtils.equals(this.f3918a, "linearGradient") || TextUtils.equals(this.f3918a, "circularGradient") : invokeV.booleanValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? !TextUtils.isEmpty(this.f3918a) : invokeV.booleanValue;
    }

    public void e(JSONArray jSONArray) {
        float[] fArr;
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, jSONArray) == null) {
            int i2 = 0;
            try {
                String optString = jSONArray.optString(0);
                int i3 = 4;
                int i4 = 1;
                if (TextUtils.equals(optString, "normal")) {
                    JSONArray optJSONArray = jSONArray.optJSONArray(1);
                    if (optJSONArray.length() == 4) {
                        this.f3919b = Color.argb(optJSONArray.optInt(3), optJSONArray.optInt(0), optJSONArray.optInt(1), optJSONArray.optInt(2));
                        this.f3918a = "normal";
                    }
                } else if (TextUtils.equals(optString, "linearGradient") || TextUtils.equals(optString, "circularGradient")) {
                    JSONArray optJSONArray2 = jSONArray.optJSONArray(1);
                    int[] iArr = null;
                    if (optJSONArray2 == null || (length = optJSONArray2.length()) <= 0) {
                        fArr = null;
                    } else {
                        iArr = new int[length];
                        fArr = new float[length];
                        int i5 = 0;
                        while (i5 < length) {
                            JSONObject optJSONObject = optJSONArray2.optJSONObject(i5);
                            JSONArray optJSONArray3 = optJSONObject.optJSONArray("color");
                            if (optJSONArray3.length() == i3) {
                                iArr[i5] = Color.argb(optJSONArray3.optInt(3), optJSONArray3.optInt(i2), optJSONArray3.optInt(i4), optJSONArray3.optInt(2));
                            }
                            fArr[i5] = (float) optJSONObject.optDouble(IntentConfig.STOP);
                            i5++;
                            i2 = 0;
                            i3 = 4;
                            i4 = 1;
                        }
                    }
                    if (iArr != null && fArr != null && iArr.length >= 2 && iArr.length == fArr.length) {
                        JSONObject optJSONObject2 = jSONArray.optJSONObject(2);
                        if (TextUtils.equals(optString, "linearGradient")) {
                            this.f3920c = new LinearGradient(b.a.p0.a.z2.n0.g(optJSONObject2.optInt("x0")), b.a.p0.a.z2.n0.g(optJSONObject2.optInt("y0")), b.a.p0.a.z2.n0.g(optJSONObject2.optInt(GestureAR.SDK_TO_LUA_GESTURE_RESULT_X1)), b.a.p0.a.z2.n0.g(optJSONObject2.optInt(GestureAR.SDK_TO_LUA_GESTURE_RESULT_Y1)), iArr, fArr, Shader.TileMode.CLAMP);
                            this.f3918a = "linearGradient";
                            return;
                        }
                        this.f3920c = new RadialGradient(b.a.p0.a.z2.n0.g(optJSONObject2.optInt("x")), b.a.p0.a.z2.n0.g(optJSONObject2.optInt("y")), b.a.p0.a.z2.n0.g(optJSONObject2.optInt(com.baidu.mapsdkplatform.comapi.map.r.f41000a)), iArr, fArr, Shader.TileMode.CLAMP);
                        this.f3918a = "circularGradient";
                    }
                }
            } catch (Exception e2) {
                if (b.a.p0.a.k.f6863a) {
                    e2.printStackTrace();
                }
            }
        }
    }
}
