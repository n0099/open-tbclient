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
/* loaded from: classes10.dex */
public class HeatMap {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Gradient DEFAULT_GRADIENT;
    public static final double DEFAULT_OPACITY = 0.6d;
    public static final int DEFAULT_RADIUS = 12;

    /* renamed from: b  reason: collision with root package name */
    public static final String f35506b = "HeatMap";

    /* renamed from: c  reason: collision with root package name */
    public static final SparseIntArray f35507c;

    /* renamed from: d  reason: collision with root package name */
    public static final int[] f35508d;

    /* renamed from: e  reason: collision with root package name */
    public static final float[] f35509e;
    public static int r;
    public transient /* synthetic */ FieldHolder $fh;
    public BaiduMap a;

    /* renamed from: f  reason: collision with root package name */
    public o<WeightedLatLng> f35510f;

    /* renamed from: g  reason: collision with root package name */
    public Collection<WeightedLatLng> f35511g;

    /* renamed from: h  reason: collision with root package name */
    public int f35512h;

    /* renamed from: i  reason: collision with root package name */
    public Gradient f35513i;

    /* renamed from: j  reason: collision with root package name */
    public double f35514j;
    public h k;
    public int[] l;
    public double[] m;
    public double[] n;
    public HashMap<String, Tile> o;
    public ExecutorService p;
    public HashSet<String> q;

    /* loaded from: classes10.dex */
    public static class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Collection<WeightedLatLng> a;

        /* renamed from: b  reason: collision with root package name */
        public int f35515b;

        /* renamed from: c  reason: collision with root package name */
        public Gradient f35516c;

        /* renamed from: d  reason: collision with root package name */
        public double f35517d;

        public Builder() {
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
            this.f35515b = 12;
            this.f35516c = HeatMap.DEFAULT_GRADIENT;
            this.f35517d = 0.6d;
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

        public Builder data(Collection<LatLng> collection) {
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
                    this.f35516c = gradient;
                    return this;
                }
                throw new IllegalArgumentException("BDMapSDKException: gradient can not be null");
            }
            return (Builder) invokeL.objValue;
        }

        public Builder opacity(double d2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Double.valueOf(d2)})) == null) {
                this.f35517d = d2;
                if (d2 < 0.0d || d2 > 1.0d) {
                    throw new IllegalArgumentException("BDMapSDKException: Opacity must be in range [0, 1]");
                }
                return this;
            }
            return (Builder) invokeCommon.objValue;
        }

        public Builder radius(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
                this.f35515b = i2;
                if (i2 < 10 || i2 > 50) {
                    throw new IllegalArgumentException("BDMapSDKException: Radius not within bounds.");
                }
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder weightedData(Collection<WeightedLatLng> collection) {
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
                for (WeightedLatLng weightedLatLng : collection) {
                    LatLng latLng = weightedLatLng.latLng;
                    double d2 = latLng.latitude;
                    if (d2 >= 0.37532d && d2 <= 54.562495d) {
                        double d3 = latLng.longitude;
                        if (d3 >= 72.508319d && d3 <= 135.942198d) {
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
        f35507c = sparseIntArray;
        sparseIntArray.put(3, 8388608);
        f35507c.put(4, 4194304);
        f35507c.put(5, 2097152);
        f35507c.put(6, 1048576);
        f35507c.put(7, 524288);
        f35507c.put(8, 262144);
        f35507c.put(9, 131072);
        f35507c.put(10, 65536);
        f35507c.put(11, 32768);
        f35507c.put(12, 16384);
        f35507c.put(13, 8192);
        f35507c.put(14, 4096);
        f35507c.put(15, 2048);
        f35507c.put(16, 1024);
        f35507c.put(17, 512);
        f35507c.put(18, 256);
        f35507c.put(19, 128);
        f35507c.put(20, 64);
        int[] iArr = {Color.rgb(0, 0, 200), Color.rgb(0, 225, 0), Color.rgb(255, 0, 0)};
        f35508d = iArr;
        float[] fArr = {0.08f, 0.4f, 1.0f};
        f35509e = fArr;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.o = new HashMap<>();
        this.p = Executors.newFixedThreadPool(1);
        this.q = new HashSet<>();
        this.f35511g = builder.a;
        this.f35512h = builder.f35515b;
        this.f35513i = builder.f35516c;
        this.f35514j = builder.f35517d;
        int i4 = this.f35512h;
        this.m = a(i4, i4 / 3.0d);
        a(this.f35513i);
        b(this.f35511g);
    }

    public /* synthetic */ HeatMap(Builder builder, j jVar) {
        this(builder);
    }

    public static double a(Collection<WeightedLatLng> collection, h hVar, int i2, int i3) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(65539, null, collection, hVar, i2, i3)) == null) {
            double d2 = hVar.a;
            double d3 = hVar.f35693c;
            double d4 = hVar.f35692b;
            double d5 = d3 - d2;
            double d6 = hVar.f35694d - d4;
            if (d5 <= d6) {
                d5 = d6;
            }
            double d7 = ((int) ((i3 / (i2 * 2)) + 0.5d)) / d5;
            LongSparseArray longSparseArray = new LongSparseArray();
            double d8 = 0.0d;
            for (WeightedLatLng weightedLatLng : collection) {
                int i4 = (int) ((weightedLatLng.a().y - d4) * d7);
                long j2 = (int) ((weightedLatLng.a().x - d2) * d7);
                LongSparseArray longSparseArray2 = (LongSparseArray) longSparseArray.get(j2);
                if (longSparseArray2 == null) {
                    longSparseArray2 = new LongSparseArray();
                    longSparseArray.put(j2, longSparseArray2);
                }
                long j3 = i4;
                Double d9 = (Double) longSparseArray2.get(j3);
                if (d9 == null) {
                    d9 = Double.valueOf(0.0d);
                }
                LongSparseArray longSparseArray3 = longSparseArray;
                double d10 = d2;
                Double valueOf = Double.valueOf(d9.doubleValue() + weightedLatLng.intensity);
                longSparseArray2.put(j3, valueOf);
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
            int i2 = iArr[iArr.length - 1];
            double length = (iArr.length - 1) / d2;
            int length2 = dArr.length;
            int[] iArr2 = new int[length2 * length2];
            for (int i3 = 0; i3 < length2; i3++) {
                for (int i4 = 0; i4 < length2; i4++) {
                    double d3 = dArr[i4][i3];
                    int i5 = (i3 * length2) + i4;
                    int i6 = (int) (d3 * length);
                    if (d3 == 0.0d) {
                        iArr2[i5] = 0;
                    } else if (i6 < iArr.length) {
                        iArr2[i5] = iArr[i6];
                    } else {
                        iArr2[i5] = i2;
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
            this.f35513i = gradient;
            this.l = gradient.a(this.f35514j);
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

    private double[] a(int i2) {
        InterceptResult invokeI;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65547, this, i2)) == null) {
            double[] dArr = new double[20];
            int i4 = 5;
            while (true) {
                if (i4 >= 11) {
                    break;
                }
                dArr[i4] = a(this.f35511g, this.k, i2, (int) (Math.pow(2.0d, i4 - 3) * 1280.0d));
                if (i4 == 5) {
                    for (int i5 = 0; i5 < i4; i5++) {
                        dArr[i5] = dArr[i4];
                    }
                }
                i4++;
            }
            for (i3 = 11; i3 < 20; i3++) {
                dArr[i3] = dArr[10];
            }
            return dArr;
        }
        return (double[]) invokeI.objValue;
    }

    public static double[] a(int i2, double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{Integer.valueOf(i2), Double.valueOf(d2)})) == null) {
            double[] dArr = new double[(i2 * 2) + 1];
            for (int i3 = -i2; i3 <= i2; i3++) {
                dArr[i3 + i2] = Math.exp(((-i3) * i3) / ((2.0d * d2) * d2));
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
            int i2 = length - (floor * 2);
            int i3 = 1;
            int i4 = (floor + i2) - 1;
            double[][] dArr3 = (double[][]) Array.newInstance(double.class, length, length);
            int i5 = 0;
            while (true) {
                double d2 = 0.0d;
                if (i5 >= length) {
                    break;
                }
                int i6 = 0;
                while (i6 < length) {
                    double d3 = dArr[i5][i6];
                    if (d3 != d2) {
                        int i7 = i5 + floor;
                        if (i4 < i7) {
                            i7 = i4;
                        }
                        int i8 = i7 + 1;
                        int i9 = i5 - floor;
                        for (int i10 = floor > i9 ? floor : i9; i10 < i8; i10++) {
                            double[] dArr4 = dArr3[i10];
                            dArr4[i6] = dArr4[i6] + (dArr2[i10 - i9] * d3);
                        }
                    }
                    i6++;
                    d2 = 0.0d;
                }
                i5++;
            }
            double[][] dArr5 = (double[][]) Array.newInstance(double.class, i2, i2);
            int i11 = floor;
            while (i11 < i4 + 1) {
                int i12 = 0;
                while (i12 < length) {
                    double d4 = dArr3[i11][i12];
                    if (d4 != 0.0d) {
                        int i13 = i12 + floor;
                        if (i4 < i13) {
                            i13 = i4;
                        }
                        int i14 = i13 + i3;
                        int i15 = i12 - floor;
                        for (int i16 = floor > i15 ? floor : i15; i16 < i14; i16++) {
                            double[] dArr6 = dArr5[i11 - floor];
                            int i17 = i16 - floor;
                            dArr6[i17] = dArr6[i17] + (dArr2[i16 - i15] * d4);
                        }
                    }
                    i12++;
                    i3 = 1;
                }
                i11++;
                i3 = 1;
            }
            return dArr5;
        }
        return (double[][]) invokeLL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i2, int i3, int i4) {
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(65550, this, i2, i3, i4) == null) {
            double d2 = f35507c.get(i4);
            double d3 = (this.f35512h * d2) / 256.0d;
            double d4 = ((2.0d * d3) + d2) / ((i5 * 2) + 256);
            if (i2 < 0 || i3 < 0) {
                return;
            }
            double d5 = (i2 * d2) - d3;
            double d6 = ((i2 + 1) * d2) + d3;
            double d7 = (i3 * d2) - d3;
            double d8 = ((i3 + 1) * d2) + d3;
            h hVar = new h(d5, d6, d7, d8);
            h hVar2 = this.k;
            if (hVar.a(new h(hVar2.a - d3, hVar2.f35693c + d3, hVar2.f35692b - d3, hVar2.f35694d + d3))) {
                Collection<WeightedLatLng> a = this.f35510f.a(hVar);
                if (a.isEmpty()) {
                    return;
                }
                int i6 = this.f35512h;
                double[][] dArr = (double[][]) Array.newInstance(double.class, (i6 * 2) + 256, (i6 * 2) + 256);
                for (WeightedLatLng weightedLatLng : a) {
                    Point a2 = weightedLatLng.a();
                    int i7 = (int) ((a2.x - d5) / d4);
                    int i8 = (int) ((d8 - a2.y) / d4);
                    int i9 = this.f35512h;
                    if (i7 >= (i9 * 2) + 256) {
                        i7 = ((i9 * 2) + 256) - 1;
                    }
                    int i10 = this.f35512h;
                    if (i8 >= (i10 * 2) + 256) {
                        i8 = ((i10 * 2) + 256) - 1;
                    }
                    double[] dArr2 = dArr[i7];
                    dArr2[i8] = dArr2[i8] + weightedLatLng.intensity;
                    d8 = d8;
                }
                Bitmap a3 = a(a(dArr, this.m), this.l, this.n[i4 - 1]);
                Tile a4 = a(a3);
                a3.recycle();
                a(i2 + "_" + i3 + "_" + i4, a4);
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

    private void b(Collection<WeightedLatLng> collection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, this, collection) == null) {
            this.f35511g = collection;
            if (collection.isEmpty()) {
                throw new IllegalArgumentException("BDMapSDKException: No input points.");
            }
            h d2 = d(this.f35511g);
            this.k = d2;
            this.f35510f = new o<>(d2);
            for (WeightedLatLng weightedLatLng : this.f35511g) {
                this.f35510f.a((o<WeightedLatLng>) weightedLatLng);
            }
            this.n = a(this.f35512h);
        }
    }

    private synchronized Tile c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, this, str)) == null) {
            synchronized (this) {
                if (this.o.containsKey(str)) {
                    Tile tile = this.o.get(str);
                    this.o.remove(str);
                    return tile;
                }
                return null;
            }
        }
        return (Tile) invokeL.objValue;
    }

    public static Collection<WeightedLatLng> c(Collection<LatLng> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, collection)) == null) {
            ArrayList arrayList = new ArrayList();
            for (LatLng latLng : collection) {
                arrayList.add(new WeightedLatLng(latLng));
            }
            return arrayList;
        }
        return (Collection) invokeL.objValue;
    }

    public static h d(Collection<WeightedLatLng> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, collection)) == null) {
            Iterator<WeightedLatLng> it = collection.iterator();
            WeightedLatLng next = it.next();
            double d2 = next.a().x;
            double d3 = next.a().x;
            double d4 = next.a().y;
            double d5 = next.a().y;
            while (it.hasNext()) {
                WeightedLatLng next2 = it.next();
                double d6 = next2.a().x;
                double d7 = next2.a().y;
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

    public Tile a(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(1048576, this, i2, i3, i4)) == null) {
            String str = i2 + "_" + i3 + "_" + i4;
            Tile c2 = c(str);
            if (c2 != null) {
                return c2;
            }
            if (a(str)) {
                return null;
            }
            BaiduMap baiduMap = this.a;
            if (baiduMap != null && r == 0) {
                WinRound winRound = baiduMap.getMapStatus().a.f36059j;
                r = (((winRound.right - winRound.left) / 256) + 2) * (((winRound.bottom - winRound.top) / 256) + 2) * 4;
            }
            if (this.o.size() > r) {
                a();
            }
            if (this.p.isShutdown()) {
                return null;
            }
            try {
                this.p.execute(new j(this, i2, i3, i4));
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
