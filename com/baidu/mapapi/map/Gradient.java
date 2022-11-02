package com.baidu.mapapi.map;

import android.graphics.Color;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class Gradient {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public float[] a;
    public final int b;
    public final int[] c;
    public final float[] d;

    /* loaded from: classes2.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Gradient a;
        public final int b;
        public final int c;
        public final float d;

        public a(Gradient gradient, int i, int i2, float f) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gradient, Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gradient;
            this.b = i;
            this.c = i2;
            this.d = f;
        }

        public /* synthetic */ a(Gradient gradient, int i, int i2, float f, n nVar) {
            this(gradient, i, i2, f);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Gradient(int[] iArr, float[] fArr) {
        this(iArr, fArr, 1000);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iArr, fArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((int[]) objArr2[0], (float[]) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public Gradient(int[] iArr, float[] fArr, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iArr, fArr, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        int[] a2 = com.baidu.platform.comapi.util.e.a(iArr);
        if (a2 != null && fArr != null) {
            if (a2.length == fArr.length) {
                if (a2.length != 0) {
                    for (int i4 = 1; i4 < fArr.length; i4++) {
                        if (fArr[i4] <= fArr[i4 - 1]) {
                            throw new IllegalArgumentException("BDMapSDKException: startPoints should be in increasing order");
                        }
                    }
                    this.b = i;
                    int[] iArr2 = new int[a2.length];
                    this.c = iArr2;
                    this.d = new float[fArr.length];
                    System.arraycopy(a2, 0, iArr2, 0, a2.length);
                    System.arraycopy(fArr, 0, this.d, 0, fArr.length);
                    return;
                }
                throw new IllegalArgumentException("BDMapSDKException: No colors have been defined");
            }
            throw new IllegalArgumentException("BDMapSDKException: colors and startPoints should be same length");
        }
        throw new IllegalArgumentException("BDMapSDKException: colors and startPoints should not be null");
    }

    public static int a(int i, int i2, float f) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f)})) == null) {
            int alpha = (int) (((Color.alpha(i2) - Color.alpha(i)) * f) + Color.alpha(i));
            float[] fArr = new float[3];
            Color.RGBToHSV(Color.red(i), Color.green(i), Color.blue(i), fArr);
            float[] fArr2 = new float[3];
            Color.RGBToHSV(Color.red(i2), Color.green(i2), Color.blue(i2), fArr2);
            if (fArr[0] - fArr2[0] > 180.0f) {
                fArr2[0] = fArr2[0] + 360.0f;
            } else if (fArr2[0] - fArr[0] > 180.0f) {
                fArr[0] = fArr[0] + 360.0f;
            }
            float[] fArr3 = new float[3];
            for (int i3 = 0; i3 < 3; i3++) {
                fArr3[i3] = ((fArr2[i3] - fArr[i3]) * f) + fArr[i3];
            }
            return Color.HSVToColor(alpha, fArr3);
        }
        return invokeCommon.intValue;
    }

    private HashMap<Integer, a> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            HashMap<Integer, a> hashMap = new HashMap<>();
            if (this.d[0] != 0.0f) {
                hashMap.put(0, new a(this, Color.argb(0, Color.red(this.c[0]), Color.green(this.c[0]), Color.blue(this.c[0])), this.c[0], this.b * this.d[0], null));
            }
            for (int i = 1; i < this.c.length; i++) {
                int i2 = i - 1;
                Integer valueOf = Integer.valueOf((int) (this.b * this.d[i2]));
                int[] iArr = this.c;
                int i3 = iArr[i2];
                int i4 = iArr[i];
                float[] fArr = this.d;
                hashMap.put(valueOf, new a(this, i3, i4, (fArr[i] - fArr[i2]) * this.b, null));
            }
            float[] fArr2 = this.d;
            if (fArr2[fArr2.length - 1] != 1.0f) {
                int length = fArr2.length - 1;
                Integer valueOf2 = Integer.valueOf((int) (this.b * fArr2[length]));
                int[] iArr2 = this.c;
                hashMap.put(valueOf2, new a(this, iArr2[length], iArr2[length], this.b * (1.0f - this.d[length]), null));
            }
            return hashMap;
        }
        return (HashMap) invokeV.objValue;
    }

    public float[] a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            float[] fArr = this.a;
            if (fArr == null) {
                this.a = new float[this.b];
                int i = 0;
                while (i < this.b) {
                    int i2 = i + 1;
                    this.a[i] = i2 * 0.001f;
                    i = i2;
                }
                return this.a;
            }
            return fArr;
        }
        return (float[]) invokeV.objValue;
    }

    public int[] getColors() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.c;
        }
        return (int[]) invokeV.objValue;
    }

    public float[] getStartPoints() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.d;
        }
        return (float[]) invokeV.objValue;
    }

    public int[] a(double d) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Double.valueOf(d)})) == null) {
            HashMap<Integer, a> b = b();
            int[] iArr = new int[this.b];
            a aVar = b.get(0);
            int i = 0;
            for (int i2 = 0; i2 < this.b; i2++) {
                if (b.containsKey(Integer.valueOf(i2))) {
                    aVar = b.get(Integer.valueOf(i2));
                    i = i2;
                }
                iArr[i2] = a(aVar.b, aVar.c, (i2 - i) / aVar.d);
            }
            if (d != 1.0d) {
                for (int i3 = 0; i3 < this.b; i3++) {
                    int i4 = iArr[i3];
                    iArr[i3] = Color.argb((int) (Color.alpha(i4) * d), Color.red(i4), Color.green(i4), Color.blue(i4));
                }
            }
            return iArr;
        }
        return (int[]) invokeCommon.objValue;
    }
}
