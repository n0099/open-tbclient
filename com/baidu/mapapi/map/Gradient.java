package com.baidu.mapapi.map;

import android.graphics.Color;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class Gradient {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;

    /* renamed from: b  reason: collision with root package name */
    public final int[] f26155b;

    /* renamed from: c  reason: collision with root package name */
    public final float[] f26156c;

    /* loaded from: classes4.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Gradient a;

        /* renamed from: b  reason: collision with root package name */
        public final int f26157b;

        /* renamed from: c  reason: collision with root package name */
        public final int f26158c;

        /* renamed from: d  reason: collision with root package name */
        public final float f26159d;

        public a(Gradient gradient, int i, int i2, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gradient, Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f2)};
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
            this.f26157b = i;
            this.f26158c = i2;
            this.f26159d = f2;
        }

        public /* synthetic */ a(Gradient gradient, int i, int i2, float f2, i iVar) {
            this(gradient, i, i2, f2);
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
        if (iArr == null || fArr == null) {
            throw new IllegalArgumentException("BDMapSDKException: colors and startPoints should not be null");
        }
        if (iArr.length != fArr.length) {
            throw new IllegalArgumentException("BDMapSDKException: colors and startPoints should be same length");
        }
        if (iArr.length == 0) {
            throw new IllegalArgumentException("BDMapSDKException: No colors have been defined");
        }
        for (int i4 = 1; i4 < fArr.length; i4++) {
            if (fArr[i4] <= fArr[i4 - 1]) {
                throw new IllegalArgumentException("BDMapSDKException: startPoints should be in increasing order");
            }
        }
        this.a = i;
        int[] iArr2 = new int[iArr.length];
        this.f26155b = iArr2;
        this.f26156c = new float[fArr.length];
        System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
        System.arraycopy(fArr, 0, this.f26156c, 0, fArr.length);
    }

    public static int a(int i, int i2, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f2)})) == null) {
            int alpha = (int) (((Color.alpha(i2) - Color.alpha(i)) * f2) + Color.alpha(i));
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
                fArr3[i3] = ((fArr2[i3] - fArr[i3]) * f2) + fArr[i3];
            }
            return Color.HSVToColor(alpha, fArr3);
        }
        return invokeCommon.intValue;
    }

    private HashMap<Integer, a> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            HashMap<Integer, a> hashMap = new HashMap<>();
            if (this.f26156c[0] != 0.0f) {
                hashMap.put(0, new a(this, Color.argb(0, Color.red(this.f26155b[0]), Color.green(this.f26155b[0]), Color.blue(this.f26155b[0])), this.f26155b[0], this.a * this.f26156c[0], null));
            }
            for (int i = 1; i < this.f26155b.length; i++) {
                int i2 = i - 1;
                Integer valueOf = Integer.valueOf((int) (this.a * this.f26156c[i2]));
                int[] iArr = this.f26155b;
                int i3 = iArr[i2];
                int i4 = iArr[i];
                float[] fArr = this.f26156c;
                hashMap.put(valueOf, new a(this, i3, i4, (fArr[i] - fArr[i2]) * this.a, null));
            }
            float[] fArr2 = this.f26156c;
            if (fArr2[fArr2.length - 1] != 1.0f) {
                int length = fArr2.length - 1;
                Integer valueOf2 = Integer.valueOf((int) (this.a * fArr2[length]));
                int[] iArr2 = this.f26155b;
                hashMap.put(valueOf2, new a(this, iArr2[length], iArr2[length], this.a * (1.0f - this.f26156c[length]), null));
            }
            return hashMap;
        }
        return (HashMap) invokeV.objValue;
    }

    public int[] a(double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Double.valueOf(d2)})) == null) {
            HashMap<Integer, a> a2 = a();
            int[] iArr = new int[this.a];
            a aVar = a2.get(0);
            int i = 0;
            for (int i2 = 0; i2 < this.a; i2++) {
                if (a2.containsKey(Integer.valueOf(i2))) {
                    aVar = a2.get(Integer.valueOf(i2));
                    i = i2;
                }
                iArr[i2] = a(aVar.f26157b, aVar.f26158c, (i2 - i) / aVar.f26159d);
            }
            if (d2 != 1.0d) {
                for (int i3 = 0; i3 < this.a; i3++) {
                    int i4 = iArr[i3];
                    iArr[i3] = Color.argb((int) (Color.alpha(i4) * d2), Color.red(i4), Color.green(i4), Color.blue(i4));
                }
            }
            return iArr;
        }
        return (int[]) invokeCommon.objValue;
    }
}
