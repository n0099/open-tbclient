package com.baidu.mapapi.map;

import android.graphics.Color;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class Gradient {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final int f39329a;

    /* renamed from: b  reason: collision with root package name */
    public final int[] f39330b;

    /* renamed from: c  reason: collision with root package name */
    public final float[] f39331c;

    /* loaded from: classes7.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Gradient f39332a;

        /* renamed from: b  reason: collision with root package name */
        public final int f39333b;

        /* renamed from: c  reason: collision with root package name */
        public final int f39334c;

        /* renamed from: d  reason: collision with root package name */
        public final float f39335d;

        public a(Gradient gradient, int i2, int i3, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gradient, Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f39332a = gradient;
            this.f39333b = i2;
            this.f39334c = i3;
            this.f39335d = f2;
        }

        public /* synthetic */ a(Gradient gradient, int i2, int i3, float f2, i iVar) {
            this(gradient, i2, i3, f2);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((int[]) objArr2[0], (float[]) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public Gradient(int[] iArr, float[] fArr, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iArr, fArr, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
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
        for (int i5 = 1; i5 < fArr.length; i5++) {
            if (fArr[i5] <= fArr[i5 - 1]) {
                throw new IllegalArgumentException("BDMapSDKException: startPoints should be in increasing order");
            }
        }
        this.f39329a = i2;
        int[] iArr2 = new int[iArr.length];
        this.f39330b = iArr2;
        this.f39331c = new float[fArr.length];
        System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
        System.arraycopy(fArr, 0, this.f39331c, 0, fArr.length);
    }

    public static int a(int i2, int i3, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f2)})) == null) {
            int alpha = (int) (((Color.alpha(i3) - Color.alpha(i2)) * f2) + Color.alpha(i2));
            float[] fArr = new float[3];
            Color.RGBToHSV(Color.red(i2), Color.green(i2), Color.blue(i2), fArr);
            float[] fArr2 = new float[3];
            Color.RGBToHSV(Color.red(i3), Color.green(i3), Color.blue(i3), fArr2);
            if (fArr[0] - fArr2[0] > 180.0f) {
                fArr2[0] = fArr2[0] + 360.0f;
            } else if (fArr2[0] - fArr[0] > 180.0f) {
                fArr[0] = fArr[0] + 360.0f;
            }
            float[] fArr3 = new float[3];
            for (int i4 = 0; i4 < 3; i4++) {
                fArr3[i4] = ((fArr2[i4] - fArr[i4]) * f2) + fArr[i4];
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
            if (this.f39331c[0] != 0.0f) {
                hashMap.put(0, new a(this, Color.argb(0, Color.red(this.f39330b[0]), Color.green(this.f39330b[0]), Color.blue(this.f39330b[0])), this.f39330b[0], this.f39329a * this.f39331c[0], null));
            }
            for (int i2 = 1; i2 < this.f39330b.length; i2++) {
                int i3 = i2 - 1;
                Integer valueOf = Integer.valueOf((int) (this.f39329a * this.f39331c[i3]));
                int[] iArr = this.f39330b;
                int i4 = iArr[i3];
                int i5 = iArr[i2];
                float[] fArr = this.f39331c;
                hashMap.put(valueOf, new a(this, i4, i5, (fArr[i2] - fArr[i3]) * this.f39329a, null));
            }
            float[] fArr2 = this.f39331c;
            if (fArr2[fArr2.length - 1] != 1.0f) {
                int length = fArr2.length - 1;
                Integer valueOf2 = Integer.valueOf((int) (this.f39329a * fArr2[length]));
                int[] iArr2 = this.f39330b;
                hashMap.put(valueOf2, new a(this, iArr2[length], iArr2[length], this.f39329a * (1.0f - this.f39331c[length]), null));
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
            int[] iArr = new int[this.f39329a];
            a aVar = a2.get(0);
            int i2 = 0;
            for (int i3 = 0; i3 < this.f39329a; i3++) {
                if (a2.containsKey(Integer.valueOf(i3))) {
                    aVar = a2.get(Integer.valueOf(i3));
                    i2 = i3;
                }
                iArr[i3] = a(aVar.f39333b, aVar.f39334c, (i3 - i2) / aVar.f39335d);
            }
            if (d2 != 1.0d) {
                for (int i4 = 0; i4 < this.f39329a; i4++) {
                    int i5 = iArr[i4];
                    iArr[i4] = Color.argb((int) (Color.alpha(i5) * d2), Color.red(i5), Color.green(i5), Color.blue(i5));
                }
            }
            return iArr;
        }
        return (int[]) invokeCommon.objValue;
    }
}
