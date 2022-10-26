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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.map = new HashMap<>();
    }

    public float getFloatValue(Object obj, String str, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048576, this, obj, str, i)) == null) {
            if (!this.map.containsKey(obj)) {
                return Float.NaN;
            }
            HashMap<String, float[]> hashMap = this.map.get(obj);
            if (!hashMap.containsKey(str)) {
                return Float.NaN;
            }
            float[] fArr = hashMap.get(str);
            if (fArr.length <= i) {
                return Float.NaN;
            }
            return fArr[i];
        }
        return invokeLLI.floatValue;
    }

    public void setFloatValue(Object obj, String str, int i, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{obj, str, Integer.valueOf(i), Float.valueOf(f)}) == null) {
            if (!this.map.containsKey(obj)) {
                HashMap<String, float[]> hashMap = new HashMap<>();
                float[] fArr = new float[i + 1];
                fArr[i] = f;
                hashMap.put(str, fArr);
                this.map.put(obj, hashMap);
                return;
            }
            HashMap<String, float[]> hashMap2 = this.map.get(obj);
            if (!hashMap2.containsKey(str)) {
                float[] fArr2 = new float[i + 1];
                fArr2[i] = f;
                hashMap2.put(str, fArr2);
                this.map.put(obj, hashMap2);
                return;
            }
            float[] fArr3 = hashMap2.get(str);
            if (fArr3.length <= i) {
                fArr3 = Arrays.copyOf(fArr3, i + 1);
            }
            fArr3[i] = f;
            hashMap2.put(str, fArr3);
        }
    }
}
