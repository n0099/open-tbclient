package c.a.r0.a.a0.a.j;

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
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public int f5196b;

    /* renamed from: c  reason: collision with root package name */
    public Shader f5197c;

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
        this.a = "";
        e(jSONArray);
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f5196b : invokeV.intValue;
    }

    public Shader b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f5197c : (Shader) invokeV.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? TextUtils.equals(this.a, "linearGradient") || TextUtils.equals(this.a, "circularGradient") : invokeV.booleanValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? !TextUtils.isEmpty(this.a) : invokeV.booleanValue;
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
                        this.f5196b = Color.argb(optJSONArray.optInt(3), optJSONArray.optInt(0), optJSONArray.optInt(1), optJSONArray.optInt(2));
                        this.a = "normal";
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
                            this.f5197c = new LinearGradient(c.a.r0.a.z2.n0.g(optJSONObject2.optInt("x0")), c.a.r0.a.z2.n0.g(optJSONObject2.optInt("y0")), c.a.r0.a.z2.n0.g(optJSONObject2.optInt(GestureAR.SDK_TO_LUA_GESTURE_RESULT_X1)), c.a.r0.a.z2.n0.g(optJSONObject2.optInt(GestureAR.SDK_TO_LUA_GESTURE_RESULT_Y1)), iArr, fArr, Shader.TileMode.CLAMP);
                            this.a = "linearGradient";
                            return;
                        }
                        this.f5197c = new RadialGradient(c.a.r0.a.z2.n0.g(optJSONObject2.optInt("x")), c.a.r0.a.z2.n0.g(optJSONObject2.optInt("y")), c.a.r0.a.z2.n0.g(optJSONObject2.optInt("r")), iArr, fArr, Shader.TileMode.CLAMP);
                        this.a = "circularGradient";
                    }
                }
            } catch (Exception e2) {
                if (c.a.r0.a.k.a) {
                    e2.printStackTrace();
                }
            }
        }
    }
}
