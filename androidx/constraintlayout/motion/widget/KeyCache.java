package androidx.constraintlayout.motion.widget;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import java.util.HashMap;
/* loaded from: classes.dex */
public class KeyCache {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<Object, HashMap<String, float[]>> map;

    public KeyCache() {
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
        this.map = new HashMap<>();
    }

    public float getFloatValue(Object obj, String str, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048576, this, obj, str, i2)) == null) {
            if (this.map.containsKey(obj)) {
                HashMap<String, float[]> hashMap = this.map.get(obj);
                if (hashMap.containsKey(str)) {
                    float[] fArr = hashMap.get(str);
                    if (fArr.length > i2) {
                        return fArr[i2];
                    }
                    return Float.NaN;
                }
                return Float.NaN;
            }
            return Float.NaN;
        }
        return invokeLLI.floatValue;
    }

    public void setFloatValue(Object obj, String str, int i2, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{obj, str, Integer.valueOf(i2), Float.valueOf(f2)}) == null) {
            if (!this.map.containsKey(obj)) {
                HashMap<String, float[]> hashMap = new HashMap<>();
                float[] fArr = new float[i2 + 1];
                fArr[i2] = f2;
                hashMap.put(str, fArr);
                this.map.put(obj, hashMap);
                return;
            }
            HashMap<String, float[]> hashMap2 = this.map.get(obj);
            if (!hashMap2.containsKey(str)) {
                float[] fArr2 = new float[i2 + 1];
                fArr2[i2] = f2;
                hashMap2.put(str, fArr2);
                this.map.put(obj, hashMap2);
                return;
            }
            float[] fArr3 = hashMap2.get(str);
            if (fArr3.length <= i2) {
                fArr3 = Arrays.copyOf(fArr3, i2 + 1);
            }
            fArr3[i2] = f2;
            hashMap2.put(str, fArr3);
        }
    }
}
