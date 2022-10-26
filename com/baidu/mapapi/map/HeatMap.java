package com.baidu.mapapi.map;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Point;
import android.util.SparseIntArray;
import androidx.collection.LongSparseArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.model.LatLng;
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
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
/* loaded from: classes2.dex */
public class HeatMap {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Gradient DEFAULT_GRADIENT;
    public static final double DEFAULT_OPACITY = 0.6d;
    public static final int DEFAULT_RADIUS = 12;
    public static final String b = "HeatMap";
    public static final SparseIntArray c;
    public static final int[] d;
    public static final float[] e;
    public static int r;
    public transient /* synthetic */ FieldHolder $fh;
    public BaiduMap a;
    public o f;
    public Collection g;
    public int h;
    public Gradient i;
    public double j;
    public h k;
    public int[] l;
    public double[] m;
    public double[] n;
    public HashMap o;
    public ExecutorService p;
    public HashSet q;

    /* loaded from: classes2.dex */
    public class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Collection a;
        public int b;
        public Gradient c;
        public double d;

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
            this.b = 12;
            this.c = HeatMap.DEFAULT_GRADIENT;
            this.d = 0.6d;
        }

        public HeatMap build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.a != null) {
                    return new HeatMap(this, null);
                }
                throw new IllegalStateException("BDMapSDKException: No input data: you must use either .data or .weightedData before building");
            }
            return (HeatMap) invokeV.objValue;
        }

        public Builder data(Collection collection) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, collection)) == null) {
                if (collection == null || collection.isEmpty()) {
                    throw new IllegalArgumentException("BDMapSDKException: No input points.");
                }
                if (collection.contains(null)) {
                    throw new IllegalArgumentException("BDMapSDKException: input points can not contain null.");
                }
                return weightedData(HeatMap.c(collection));
            }
            return (Builder) invokeL.objValue;
        }

        public Builder gradient(Gradient gradient) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, gradient)) == null) {
                if (gradient != null) {
                    this.c = gradient;
                    return this;
                }
                throw new IllegalArgumentException("BDMapSDKException: gradient can not be null");
            }
            return (Builder) invokeL.objValue;
        }

        public Builder opacity(double d) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Double.valueOf(d)})) == null) {
                this.d = d;
                if (d < 0.0d || d > 1.0d) {
                    throw new IllegalArgumentException("BDMapSDKException: Opacity must be in range [0, 1]");
                }
                return this;
            }
            return (Builder) invokeCommon.objValue;
        }

        public Builder radius(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
                this.b = i;
                if (i < 10 || i > 50) {
                    throw new IllegalArgumentException("BDMapSDKException: Radius not within bounds.");
                }
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder weightedData(Collection collection) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, collection)) == null) {
                if (collection == null || collection.isEmpty()) {
                    throw new IllegalArgumentException("BDMapSDKException: No input points.");
                }
                if (collection.contains(null)) {
                    throw new IllegalArgumentException("BDMapSDKException: input points can not contain null.");
                }
                ArrayList arrayList = new ArrayList();
                Iterator it = collection.iterator();
                while (it.hasNext()) {
                    WeightedLatLng weightedLatLng = (WeightedLatLng) it.next();
                    LatLng latLng = weightedLatLng.latLng;
                    double d = latLng.latitude;
                    if (d >= 0.37532d && d <= 54.562495d) {
                        double d2 = latLng.longitude;
                        if (d2 >= 72.508319d && d2 <= 135.942198d) {
                        }
                    }
                    arrayList.add(weightedLatLng);
                }
                collection.removeAll(arrayList);
                this.a = collection;
                return this;
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
        r = 0;
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
        this.o = new HashMap();
        this.p = Executors.newFixedThreadPool(1);
        this.q = new HashSet();
        this.g = builder.a;
        this.h = builder.b;
        this.i = builder.c;
        this.j = builder.d;
        int i3 = this.h;
        this.m = a(i3, i3 / 3.0d);
        a(this.i);
        b(this.g);
    }

    public /* synthetic */ HeatMap(Builder builder, j jVar) {
        this(builder);
    }

    public static double a(Collection collection, h hVar, int i, int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(65539, null, collection, hVar, i, i2)) == null) {
            double d2 = hVar.a;
            double d3 = hVar.c;
            double d4 = hVar.b;
            double d5 = d3 - d2;
            double d6 = hVar.d - d4;
            if (d5 <= d6) {
                d5 = d6;
            }
            double d7 = ((int) ((i2 / (i * 2)) + 0.5d)) / d5;
            LongSparseArray longSparseArray = new LongSparseArray();
            Iterator it = collection.iterator();
            double d8 = 0.0d;
            while (it.hasNext()) {
                WeightedLatLng weightedLatLng = (WeightedLatLng) it.next();
                int i3 = (int) ((weightedLatLng.a().y - d4) * d7);
                long j = (int) ((weightedLatLng.a().x - d2) * d7);
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
                    if (d3 == 0.0d) {
                        iArr2[i4] = 0;
                    } else if (i5 < iArr.length) {
                        iArr2[i4] = iArr[i5];
                    } else {
                        iArr2[i4] = i;
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, bitmap)) == null) {
            ByteBuffer allocate = ByteBuffer.allocate(bitmap.getWidth() * bitmap.getHeight() * 4);
            bitmap.copyPixelsToBuffer(allocate);
            return new Tile(256, 256, allocate.array());
        }
        return (Tile) invokeL.objValue;
    }

    private void a(Gradient gradient) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, gradient) == null) {
            this.i = gradient;
            this.l = gradient.a(this.j);
        }
    }

    private synchronized void a(String str, Tile tile) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, this, str, tile) == null) {
            synchronized (this) {
                this.o.put(str, tile);
            }
        }
    }

    private synchronized boolean a(String str) {
        InterceptResult invokeL;
        boolean contains;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, this, str)) == null) {
            synchronized (this) {
                contains = this.q.contains(str);
            }
            return contains;
        }
        return invokeL.booleanValue;
    }

    private double[] a(int i) {
        InterceptResult invokeI;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65547, this, i)) == null) {
            double[] dArr = new double[20];
            int i3 = 5;
            while (true) {
                if (i3 >= 11) {
                    break;
                }
                dArr[i3] = a(this.g, this.k, i, (int) (Math.pow(2.0d, i3 - 3) * 1280.0d));
                if (i3 == 5) {
                    for (int i4 = 0; i4 < i3; i4++) {
                        dArr[i4] = dArr[i3];
                    }
                }
                i3++;
            }
            for (i2 = 11; i2 < 20; i2++) {
                dArr[i2] = dArr[10];
            }
            return dArr;
        }
        return (double[]) invokeI.objValue;
    }

    public static double[] a(int i, double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{Integer.valueOf(i), Double.valueOf(d2)})) == null) {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, dArr, dArr2)) == null) {
            int floor = (int) Math.floor(dArr2.length / 2.0d);
            int length = dArr.length;
            int i = length - (floor * 2);
            int i2 = 1;
            int i3 = (floor + i) - 1;
            double[][] dArr3 = (double[][]) Array.newInstance(double.class, length, length);
            int i4 = 0;
            while (true) {
                double d2 = 0.0d;
                if (i4 >= length) {
                    break;
                }
                int i5 = 0;
                while (i5 < length) {
                    double d3 = dArr[i4][i5];
                    if (d3 != d2) {
                        int i6 = i4 + floor;
                        if (i3 < i6) {
                            i6 = i3;
                        }
                        int i7 = i6 + 1;
                        int i8 = i4 - floor;
                        for (int i9 = floor > i8 ? floor : i8; i9 < i7; i9++) {
                            double[] dArr4 = dArr3[i9];
                            dArr4[i5] = dArr4[i5] + (dArr2[i9 - i8] * d3);
                        }
                    }
                    i5++;
                    d2 = 0.0d;
                }
                i4++;
            }
            double[][] dArr5 = (double[][]) Array.newInstance(double.class, i, i);
            int i10 = floor;
            while (i10 < i3 + 1) {
                int i11 = 0;
                while (i11 < length) {
                    double d4 = dArr3[i10][i11];
                    if (d4 != 0.0d) {
                        int i12 = i11 + floor;
                        if (i3 < i12) {
                            i12 = i3;
                        }
                        int i13 = i12 + i2;
                        int i14 = i11 - floor;
                        for (int i15 = floor > i14 ? floor : i14; i15 < i13; i15++) {
                            double[] dArr6 = dArr5[i10 - floor];
                            int i16 = i15 - floor;
                            dArr6[i16] = dArr6[i16] + (dArr2[i15 - i14] * d4);
                        }
                    }
                    i11++;
                    i2 = 1;
                }
                i10++;
                i2 = 1;
            }
            return dArr5;
        }
        return (double[][]) invokeLL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2, int i3) {
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(65550, this, i, i2, i3) == null) {
            double d2 = c.get(i3);
            double d3 = (this.h * d2) / 256.0d;
            double d4 = ((2.0d * d3) + d2) / ((i4 * 2) + 256);
            if (i < 0 || i2 < 0) {
                return;
            }
            double d5 = (i * d2) - d3;
            double d6 = ((i + 1) * d2) + d3;
            double d7 = (i2 * d2) - d3;
            double d8 = ((i2 + 1) * d2) + d3;
            h hVar = new h(d5, d6, d7, d8);
            h hVar2 = this.k;
            if (hVar.a(new h(hVar2.a - d3, hVar2.c + d3, hVar2.b - d3, hVar2.d + d3))) {
                Collection<WeightedLatLng> a = this.f.a(hVar);
                if (a.isEmpty()) {
                    return;
                }
                int i5 = this.h;
                double[][] dArr = (double[][]) Array.newInstance(double.class, (i5 * 2) + 256, (i5 * 2) + 256);
                for (WeightedLatLng weightedLatLng : a) {
                    Point a2 = weightedLatLng.a();
                    int i6 = (int) ((a2.x - d5) / d4);
                    int i7 = (int) ((d8 - a2.y) / d4);
                    int i8 = this.h;
                    if (i6 >= (i8 * 2) + 256) {
                        i6 = ((i8 * 2) + 256) - 1;
                    }
                    int i9 = this.h;
                    if (i7 >= (i9 * 2) + 256) {
                        i7 = ((i9 * 2) + 256) - 1;
                    }
                    double[] dArr2 = dArr[i6];
                    dArr2[i7] = dArr2[i7] + weightedLatLng.intensity;
                    d8 = d8;
                }
                Bitmap a3 = a(a(dArr, this.m), this.l, this.n[i3 - 1]);
                Tile a4 = a(a3);
                a3.recycle();
                a(i + "_" + i2 + "_" + i3, a4);
                if (this.o.size() > r) {
                    a();
                }
                BaiduMap baiduMap = this.a;
                if (baiduMap != null) {
                    baiduMap.a();
                }
            }
        }
    }

    private synchronized void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, this, str) == null) {
            synchronized (this) {
                this.q.add(str);
            }
        }
    }

    private void b(Collection collection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, this, collection) == null) {
            this.g = collection;
            if (collection.isEmpty()) {
                throw new IllegalArgumentException("BDMapSDKException: No input points.");
            }
            h d2 = d(this.g);
            this.k = d2;
            this.f = new o(d2);
            for (WeightedLatLng weightedLatLng : this.g) {
                this.f.a(weightedLatLng);
            }
            this.n = a(this.h);
        }
    }

    private synchronized Tile c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, this, str)) == null) {
            synchronized (this) {
                if (this.o.containsKey(str)) {
                    Tile tile = (Tile) this.o.get(str);
                    this.o.remove(str);
                    return tile;
                }
                return null;
            }
        }
        return (Tile) invokeL.objValue;
    }

    public static Collection c(Collection collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, collection)) == null) {
            ArrayList arrayList = new ArrayList();
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                arrayList.add(new WeightedLatLng((LatLng) it.next()));
            }
            return arrayList;
        }
        return (Collection) invokeL.objValue;
    }

    public static h d(Collection collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, collection)) == null) {
            Iterator it = collection.iterator();
            WeightedLatLng weightedLatLng = (WeightedLatLng) it.next();
            double d2 = weightedLatLng.a().x;
            double d3 = weightedLatLng.a().x;
            double d4 = weightedLatLng.a().y;
            double d5 = weightedLatLng.a().y;
            while (it.hasNext()) {
                WeightedLatLng weightedLatLng2 = (WeightedLatLng) it.next();
                double d6 = weightedLatLng2.a().x;
                double d7 = weightedLatLng2.a().y;
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
            return new h(d2, d3, d4, d5);
        }
        return (h) invokeL.objValue;
    }

    private synchronized void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65556, this) == null) {
            synchronized (this) {
                this.o.clear();
            }
        }
    }

    public Tile a(int i, int i2, int i3) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(1048576, this, i, i2, i3)) == null) {
            String str = i + "_" + i2 + "_" + i3;
            Tile c2 = c(str);
            if (c2 != null) {
                return c2;
            }
            if (a(str)) {
                return null;
            }
            BaiduMap baiduMap = this.a;
            if (baiduMap != null && r == 0) {
                WinRound winRound = baiduMap.getMapStatus().a.j;
                r = (((winRound.right - winRound.left) / 256) + 2) * (((winRound.bottom - winRound.top) / 256) + 2) * 4;
            }
            if (this.o.size() > r) {
                a();
            }
            if (this.p.isShutdown()) {
                return null;
            }
            try {
                this.p.execute(new j(this, i, i2, i3));
                b(str);
                return null;
            } catch (RejectedExecutionException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (Tile) invokeIII.objValue;
    }

    public synchronized void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                this.q.clear();
                this.o.clear();
            }
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            d();
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.p.shutdownNow();
        }
    }

    public void removeHeatMap() {
        BaiduMap baiduMap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (baiduMap = this.a) == null) {
            return;
        }
        baiduMap.a(this);
    }
}
