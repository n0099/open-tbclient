package com.baidu.mapapi.map;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.util.SparseIntArray;
import androidx.collection.LongSparseArray;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.map.HeatMapAnimation;
import com.baidu.mapapi.model.LatLng;
import com.baidu.platform.comapi.util.SysOSUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes2.dex */
public class HeatMap {
    public static /* synthetic */ Interceptable $ic = null;
    public static int A = 0;
    public static final Gradient DEFAULT_GRADIENT;
    public static final int DEFAULT_MAX_HIGH = 0;
    public static final double DEFAULT_OPACITY = 0.6d;
    public static final int DEFAULT_RADIUS = 12;
    public static final String b = "HeatMap";
    public static final SparseIntArray c;
    public static final int[] d;
    public static final float[] e;
    public transient /* synthetic */ FieldHolder $fh;
    public BaiduMap a;
    public int f;
    public v<WeightedLatLng> g;
    public Collection<WeightedLatLng> h;
    public ArrayList<Collection<WeightedLatLng>> i;
    public float j;
    public float k;
    public HeatMapAnimation l;
    public HeatMapAnimation m;
    public boolean mIsSetMaxIntensity;
    public int n;
    public Gradient o;
    public double p;
    public m q;
    public int[] r;
    public float[] s;
    public double[] t;
    public double[] u;
    public List<double[]> v;
    public HashMap<String, Tile> w;
    public ExecutorService x;
    public HashSet<String> y;
    public int z;

    /* loaded from: classes2.dex */
    public static class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Collection<WeightedLatLng> a;
        public ArrayList<Collection<WeightedLatLng>> b;
        public int c;
        public Gradient d;
        public double e;
        public int f;
        public float g;
        public float h;
        public boolean i;
        public HeatMapAnimation j;
        public HeatMapAnimation k;

        public Builder() {
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
            this.c = 12;
            this.d = HeatMap.DEFAULT_GRADIENT;
            this.e = 0.6d;
            this.f = 0;
            this.g = 1.0f;
            this.h = 0.0f;
            this.i = false;
            this.j = new HeatMapAnimation(false, 100, HeatMapAnimation.AnimationType.Linear);
            this.k = new HeatMapAnimation(false, 100, HeatMapAnimation.AnimationType.Linear);
        }

        public Builder frameAnimation(HeatMapAnimation heatMapAnimation) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, heatMapAnimation)) == null) {
                this.k = heatMapAnimation;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder gradient(Gradient gradient) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, gradient)) == null) {
                if (gradient != null) {
                    this.d = gradient;
                    return this;
                }
                throw new IllegalArgumentException("BDMapSDKException: gradient can not be null");
            }
            return (Builder) invokeL.objValue;
        }

        public Builder initAnimation(HeatMapAnimation heatMapAnimation) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, heatMapAnimation)) == null) {
                this.j = heatMapAnimation;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder maxHigh(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
                int i2 = this.f;
                if (i2 >= 0 && i2 <= 200) {
                    this.f = i;
                    return this;
                }
                throw new IllegalArgumentException("BDMapSDKException: max_high not within bounds.");
            }
            return (Builder) invokeI.objValue;
        }

        public Builder maxIntensity(float f) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(1048583, this, f)) == null) {
                this.g = f;
                this.i = true;
                return this;
            }
            return (Builder) invokeF.objValue;
        }

        public Builder minIntensity(float f) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(InputDeviceCompat.SOURCE_TOUCHPAD, this, f)) == null) {
                this.h = f;
                return this;
            }
            return (Builder) invokeF.objValue;
        }

        public Builder radius(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
                int i2 = this.c;
                if (i2 >= 10 && i2 <= 50) {
                    this.c = i;
                    return this;
                }
                throw new IllegalArgumentException("BDMapSDKException: Radius not within bounds.");
            }
            return (Builder) invokeI.objValue;
        }

        public HeatMap build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.a == null && this.b == null) {
                    throw new IllegalStateException("BDMapSDKException: No input data: you must use either .data or .weightedData before building");
                }
                return new HeatMap(this, null);
            }
            return (HeatMap) invokeV.objValue;
        }

        public Builder data(Collection<LatLng> collection) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, collection)) == null) {
                if (collection != null && !collection.isEmpty()) {
                    if (!collection.contains(null)) {
                        return weightedData(HeatMap.c(collection));
                    }
                    throw new IllegalArgumentException("BDMapSDKException: input points can not contain null.");
                }
                throw new IllegalArgumentException("BDMapSDKException: No input points.");
            }
            return (Builder) invokeL.objValue;
        }

        public Builder datas(List<List<LatLng>> list) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list)) == null) {
                if (list != null && !list.isEmpty()) {
                    if (!list.contains(null)) {
                        return weightedDatas(list);
                    }
                    throw new IllegalArgumentException("BDMapSDKException: input points can not contain null.");
                }
                throw new IllegalArgumentException("BDMapSDKException: No input datas.");
            }
            return (Builder) invokeL.objValue;
        }

        public Builder opacity(double d) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Double.valueOf(d)})) == null) {
                this.e = d;
                if (d >= 0.0d && d <= 1.0d) {
                    return this;
                }
                throw new IllegalArgumentException("BDMapSDKException: Opacity must be in range [0, 1]");
            }
            return (Builder) invokeCommon.objValue;
        }

        public Builder weightedData(Collection<WeightedLatLng> collection) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, collection)) == null) {
                if (collection != null && !collection.isEmpty()) {
                    if (!collection.contains(null)) {
                        this.a = collection;
                        return this;
                    }
                    throw new IllegalArgumentException("BDMapSDKException: input points can not contain null.");
                }
                throw new IllegalArgumentException("BDMapSDKException: No input points.");
            }
            return (Builder) invokeL.objValue;
        }

        public Builder weightedDatas(List<List<LatLng>> list) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, list)) == null) {
                if (list != null && !list.isEmpty()) {
                    if (!list.contains(null)) {
                        ArrayList<Collection<WeightedLatLng>> arrayList = new ArrayList<>();
                        for (List<LatLng> list2 : list) {
                            arrayList.add(HeatMap.c(list2));
                            this.b = arrayList;
                        }
                        return this;
                    }
                    throw new IllegalArgumentException("BDMapSDKException: input points can not contain null.");
                }
                throw new IllegalArgumentException("BDMapSDKException: No input points.");
            }
            return (Builder) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-904008379, "Lcom/baidu/mapapi/map/HeatMap;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-904008379, "Lcom/baidu/mapapi/map/HeatMap;");
                return;
            }
        }
        SparseIntArray sparseIntArray = new SparseIntArray();
        c = sparseIntArray;
        sparseIntArray.put(3, 8388608);
        c.put(4, 4194304);
        c.put(5, 2097152);
        c.put(6, 1048576);
        c.put(7, 524288);
        c.put(8, 262144);
        c.put(9, 131072);
        c.put(10, 65536);
        c.put(11, 32768);
        c.put(12, 16384);
        c.put(13, 8192);
        c.put(14, 4096);
        c.put(15, 2048);
        c.put(16, 1024);
        c.put(17, 512);
        c.put(18, 256);
        c.put(19, 128);
        c.put(20, 64);
        int[] iArr = {Color.rgb(0, 0, 200), Color.rgb(0, 225, 0), Color.rgb(255, 0, 0)};
        d = iArr;
        float[] fArr = {0.08f, 0.4f, 1.0f};
        e = fArr;
        DEFAULT_GRADIENT = new Gradient(iArr, fArr);
        A = 0;
    }

    public HeatMap(Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {builder};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f = 200;
        this.z = SysOSUtil.getInstance().getScreenWidth() / 2;
        this.w = new HashMap<>();
        this.x = Executors.newFixedThreadPool(1);
        this.y = new HashSet<>();
        this.i = builder.b;
        this.n = builder.c;
        boolean z = builder.i;
        this.mIsSetMaxIntensity = z;
        if (!z && this.i != null) {
            this.v = new ArrayList();
            for (int i3 = 0; i3 < this.i.size(); i3++) {
                Collection<WeightedLatLng> collection = this.i.get(i3);
                this.h = collection;
                this.q = d(collection);
                this.v.add(a(this.n));
            }
        }
        Collection<WeightedLatLng> collection2 = builder.a;
        this.h = collection2;
        if (!this.mIsSetMaxIntensity && collection2 != null) {
            b(collection2);
        }
        this.m = builder.j;
        this.l = builder.k;
        this.f = builder.f;
        this.j = builder.g;
        this.k = builder.h;
        this.o = builder.d;
        this.p = builder.e;
        int i4 = this.n;
        this.t = a(i4, i4 / 3.0d);
        a(this.o);
    }

    public /* synthetic */ HeatMap(Builder builder, o oVar) {
        this(builder);
    }

    private HeatMapData a(int i, int i2) {
        InterceptResult invokeII;
        float f;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65541, this, i, i2)) == null) {
            if (this.h == null) {
                return null;
            }
            double[] dArr = this.u;
            if (dArr != null) {
                f = (float) dArr[i2];
            } else {
                f = 0.0f;
            }
            return new HeatMapData(this.h, f);
        }
        return (HeatMapData) invokeII.objValue;
    }

    public static double a(Collection<WeightedLatLng> collection, m mVar, int i, int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(65539, null, collection, mVar, i, i2)) == null) {
            double d2 = mVar.a;
            double d3 = mVar.c;
            double d4 = mVar.b;
            double d5 = d3 - d2;
            double d6 = mVar.d - d4;
            if (d5 <= d6) {
                d5 = d6;
            }
            double d7 = ((int) ((i2 / (i * 2)) + 0.5d)) / d5;
            LongSparseArray longSparseArray = new LongSparseArray();
            double d8 = 0.0d;
            for (WeightedLatLng weightedLatLng : collection) {
                int i3 = (int) ((weightedLatLng.getPoint().y - d4) * d7);
                long j = (int) ((weightedLatLng.getPoint().x - d2) * d7);
                LongSparseArray longSparseArray2 = (LongSparseArray) longSparseArray.get(j);
                if (longSparseArray2 == null) {
                    longSparseArray2 = new LongSparseArray();
                    longSparseArray.put(j, longSparseArray2);
                }
                long j2 = i3;
                Double d9 = (Double) longSparseArray2.get(j2);
                if (d9 == null) {
                    d9 = Double.valueOf(0.0d);
                }
                LongSparseArray longSparseArray3 = longSparseArray;
                double d10 = d2;
                Double valueOf = Double.valueOf(d9.doubleValue() + weightedLatLng.intensity);
                longSparseArray2.put(j2, valueOf);
                if (valueOf.doubleValue() > d8) {
                    d8 = valueOf.doubleValue();
                }
                longSparseArray = longSparseArray3;
                d2 = d10;
            }
            return d8;
        }
        return invokeLLII.doubleValue;
    }

    public static Bitmap a(double[][] dArr, int[] iArr, double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{dArr, iArr, Double.valueOf(d2)})) == null) {
            int i = iArr[iArr.length - 1];
            double length = (iArr.length - 1) / d2;
            int length2 = dArr.length;
            int[] iArr2 = new int[length2 * length2];
            for (int i2 = 0; i2 < length2; i2++) {
                for (int i3 = 0; i3 < length2; i3++) {
                    double d3 = dArr[i3][i2];
                    int i4 = (i2 * length2) + i3;
                    int i5 = (int) (d3 * length);
                    if (d3 != 0.0d) {
                        if (i5 < iArr.length) {
                            iArr2[i4] = iArr[i5];
                        } else {
                            iArr2[i4] = i;
                        }
                    } else {
                        iArr2[i4] = 0;
                    }
                }
            }
            Bitmap createBitmap = Bitmap.createBitmap(length2, length2, Bitmap.Config.ARGB_8888);
            createBitmap.setPixels(iArr2, 0, length2, 0, 0, length2, length2);
            return createBitmap;
        }
        return (Bitmap) invokeCommon.objValue;
    }

    public static Tile a(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, bitmap)) == null) {
            ByteBuffer allocate = ByteBuffer.allocate(bitmap.getWidth() * bitmap.getHeight() * 4);
            bitmap.copyPixelsToBuffer(allocate);
            return new Tile(256, 256, allocate.array());
        }
        return (Tile) invokeL.objValue;
    }

    public static Collection<WeightedLatLng> c(Collection<LatLng> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, collection)) == null) {
            ArrayList arrayList = new ArrayList();
            for (LatLng latLng : collection) {
                arrayList.add(new WeightedLatLng(latLng));
            }
            return arrayList;
        }
        return (Collection) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, int i3) {
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(65544, this, i, i2, i3) == null) {
            double d2 = c.get(i3);
            double d3 = (this.n * d2) / 256.0d;
            double d4 = ((2.0d * d3) + d2) / ((i4 * 2) + 256);
            if (i >= 0 && i2 >= 0) {
                double d5 = (i * d2) - d3;
                double d6 = ((i + 1) * d2) + d3;
                double d7 = (i2 * d2) - d3;
                double d8 = ((i2 + 1) * d2) + d3;
                m mVar = new m(d5, d6, d7, d8);
                m mVar2 = this.q;
                if (!mVar.a(new m(mVar2.a - d3, mVar2.c + d3, mVar2.b - d3, mVar2.d + d3))) {
                    return;
                }
                Collection<WeightedLatLng> a = this.g.a(mVar);
                if (a.isEmpty()) {
                    return;
                }
                int i5 = this.n;
                double[][] dArr = (double[][]) Array.newInstance(double.class, (i5 * 2) + 256, (i5 * 2) + 256);
                for (WeightedLatLng weightedLatLng : a) {
                    Point point = weightedLatLng.getPoint();
                    int i6 = (int) ((point.x - d5) / d4);
                    int i7 = (int) ((d8 - point.y) / d4);
                    int i8 = this.n;
                    if (i6 >= (i8 * 2) + 256) {
                        i6 = ((i8 * 2) + 256) - 1;
                    }
                    int i9 = this.n;
                    if (i7 >= (i9 * 2) + 256) {
                        i7 = ((i9 * 2) + 256) - 1;
                    }
                    double[] dArr2 = dArr[i6];
                    dArr2[i7] = dArr2[i7] + weightedLatLng.intensity;
                    d8 = d8;
                }
                Bitmap a2 = a(a(dArr, this.t), this.r, this.u[i3 - 1]);
                Tile a3 = a(a2);
                a2.recycle();
                a(i + "_" + i2 + "_" + i3, a3);
                if (this.w.size() > A) {
                    a();
                }
                BaiduMap baiduMap = this.a;
                if (baiduMap != null) {
                    baiduMap.a();
                }
            }
        }
    }

    private void a(Gradient gradient) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, this, gradient) == null) {
            this.o = gradient;
            this.r = gradient.a(this.p);
            this.s = gradient.a();
        }
    }

    private synchronized void a(String str, Tile tile) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, this, str, tile) == null) {
            synchronized (this) {
                this.w.put(str, tile);
            }
        }
    }

    private double[] a(int i) {
        InterceptResult invokeI;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65548, this, i)) == null) {
            double[] dArr = new double[22];
            int i3 = 4;
            while (true) {
                if (i3 >= 11) {
                    break;
                }
                dArr[i3] = a(this.h, this.q, i, (int) (Math.pow(2.0d, i3 - 3) * 1280.0d));
                if (i3 == 4) {
                    for (int i4 = 0; i4 < i3; i4++) {
                        dArr[i4] = dArr[i3];
                    }
                }
                i3++;
            }
            for (i2 = 11; i2 < 22; i2++) {
                dArr[i2] = dArr[10];
            }
            return dArr;
        }
        return (double[]) invokeI.objValue;
    }

    private void b(Collection<WeightedLatLng> collection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, this, collection) == null) {
            this.h = collection;
            if (!collection.isEmpty()) {
                m d2 = d(this.h);
                this.q = d2;
                this.g = new v<>(d2);
                for (WeightedLatLng weightedLatLng : this.h) {
                    this.g.a((v<WeightedLatLng>) weightedLatLng);
                }
                this.u = a(this.n);
                return;
            }
            throw new IllegalArgumentException("BDMapSDKException: No input points.");
        }
    }

    public static double[] a(int i, double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65549, null, new Object[]{Integer.valueOf(i), Double.valueOf(d2)})) == null) {
            double[] dArr = new double[(i * 2) + 1];
            for (int i2 = -i; i2 <= i; i2++) {
                dArr[i2 + i] = Math.exp(((-i2) * i2) / ((2.0d * d2) * d2));
            }
            return dArr;
        }
        return (double[]) invokeCommon.objValue;
    }

    public static double[][] a(double[][] dArr, double[] dArr2) {
        InterceptResult invokeLL;
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, dArr, dArr2)) == null) {
            int floor = (int) Math.floor(dArr2.length / 2.0d);
            int length = dArr.length;
            int i3 = length - (floor * 2);
            int i4 = 1;
            int i5 = (floor + i3) - 1;
            double[][] dArr3 = (double[][]) Array.newInstance(double.class, length, length);
            int i6 = 0;
            while (true) {
                double d2 = 0.0d;
                if (i6 >= length) {
                    break;
                }
                int i7 = 0;
                while (i7 < length) {
                    double d3 = dArr[i6][i7];
                    if (d3 != d2) {
                        int i8 = i6 + floor;
                        if (i5 < i8) {
                            i8 = i5;
                        }
                        int i9 = i8 + 1;
                        int i10 = i6 - floor;
                        if (floor > i10) {
                            i2 = floor;
                        } else {
                            i2 = i10;
                        }
                        while (i2 < i9) {
                            double[] dArr4 = dArr3[i2];
                            dArr4[i7] = dArr4[i7] + (dArr2[i2 - i10] * d3);
                            i2++;
                        }
                    }
                    i7++;
                    d2 = 0.0d;
                }
                i6++;
            }
            double[][] dArr5 = (double[][]) Array.newInstance(double.class, i3, i3);
            int i11 = floor;
            while (i11 < i5 + 1) {
                int i12 = 0;
                while (i12 < length) {
                    double d4 = dArr3[i11][i12];
                    if (d4 != 0.0d) {
                        int i13 = i12 + floor;
                        if (i5 < i13) {
                            i13 = i5;
                        }
                        int i14 = i13 + i4;
                        int i15 = i12 - floor;
                        if (floor > i15) {
                            i = floor;
                        } else {
                            i = i15;
                        }
                        for (int i16 = i; i16 < i14; i16++) {
                            double[] dArr6 = dArr5[i11 - floor];
                            int i17 = i16 - floor;
                            dArr6[i17] = dArr6[i17] + (dArr2[i16 - i15] * d4);
                        }
                    }
                    i12++;
                    i4 = 1;
                }
                i11++;
                i4 = 1;
            }
            return dArr5;
        }
        return (double[][]) invokeLL.objValue;
    }

    private HeatMapData b(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65551, this, i, i2)) == null) {
            ArrayList<Collection<WeightedLatLng>> arrayList = this.i;
            if (arrayList == null || i >= arrayList.size()) {
                return null;
            }
            Collection<WeightedLatLng> collection = this.i.get(i);
            float f = 0.0f;
            List<double[]> list = this.v;
            if (list != null && list.size() > i) {
                f = (float) this.v.get(i)[i2];
            }
            return new HeatMapData(collection, f);
        }
        return (HeatMapData) invokeII.objValue;
    }

    public HeatMapData getData(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048579, this, i, i2)) == null) {
            if (i2 > 22 || i2 < 4 || (this.i == null && this.h == null)) {
                return null;
            }
            if (this.i != null) {
                return b(i, i2);
            }
            if (this.h != null) {
                return a(i, i2);
            }
            return null;
        }
        return (HeatMapData) invokeII.objValue;
    }

    public static m d(Collection<WeightedLatLng> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, collection)) == null) {
            Iterator<WeightedLatLng> it = collection.iterator();
            WeightedLatLng next = it.next();
            double d2 = next.getPoint().x;
            double d3 = next.getPoint().x;
            double d4 = next.getPoint().y;
            double d5 = next.getPoint().y;
            while (it.hasNext()) {
                WeightedLatLng next2 = it.next();
                double d6 = next2.getPoint().x;
                double d7 = next2.getPoint().y;
                if (d6 < d2) {
                    d2 = d6;
                }
                if (d6 > d3) {
                    d3 = d6;
                }
                if (d7 < d4) {
                    d4 = d7;
                }
                if (d7 > d5) {
                    d5 = d7;
                }
            }
            return new m(d2, d3, d4, d5);
        }
        return (m) invokeL.objValue;
    }

    private synchronized void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65555, this) == null) {
            synchronized (this) {
                this.w.clear();
            }
        }
    }

    public synchronized void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                this.y.clear();
                this.w.clear();
            }
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            d();
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.x.shutdownNow();
        }
    }

    public void removeHeatMap() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            BaiduMap baiduMap = this.a;
            if (baiduMap != null) {
                baiduMap.a(this);
            }
            ArrayList<Collection<WeightedLatLng>> arrayList = this.i;
            if (arrayList != null) {
                arrayList.clear();
            }
            Collection<WeightedLatLng> collection = this.h;
            if (collection != null) {
                collection.clear();
            }
        }
    }

    public Bundle toBundle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            Bundle bundle = new Bundle();
            bundle.putInt("grid_size", this.z);
            bundle.putFloat("point_size", this.n * 2);
            bundle.putFloat("max_hight", this.f);
            bundle.putFloat(Key.ALPHA, (float) this.p);
            ArrayList<Collection<WeightedLatLng>> arrayList = this.i;
            if (arrayList != null) {
                bundle.putInt("frame_count", arrayList.size());
            } else if (this.h != null) {
                bundle.putInt("frame_count", 1);
            }
            bundle.putIntArray("color_array", this.r);
            bundle.putFloatArray("color_start_points", this.s);
            bundle.putBoolean("is_need_init_animation", this.m.getIsAnimation());
            bundle.putBoolean("is_need_frame_animation", this.l.getIsAnimation());
            bundle.putInt("init_animation_duration", this.m.getDuration());
            bundle.putInt("init_animation_type", this.m.getAnimationType());
            bundle.putInt("frame_animation_duration", this.l.getDuration());
            bundle.putInt("frame_animation_type", this.l.getAnimationType());
            bundle.putFloat("max_intentity", this.j);
            bundle.putFloat("min_intentity", this.k);
            return bundle;
        }
        return (Bundle) invokeV.objValue;
    }
}
