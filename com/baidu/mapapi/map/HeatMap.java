package com.baidu.mapapi.map;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Point;
import android.util.SparseIntArray;
import androidx.collection.LongSparseArray;
import com.baidu.mapapi.model.LatLng;
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
    public static final Gradient DEFAULT_GRADIENT;
    public static final double DEFAULT_OPACITY = 0.6d;
    public static final int DEFAULT_RADIUS = 12;

    /* renamed from: b  reason: collision with root package name */
    public static final String f6858b = "HeatMap";

    /* renamed from: c  reason: collision with root package name */
    public static final SparseIntArray f6859c;

    /* renamed from: d  reason: collision with root package name */
    public static final int[] f6860d;

    /* renamed from: e  reason: collision with root package name */
    public static final float[] f6861e;
    public static int r;

    /* renamed from: a  reason: collision with root package name */
    public BaiduMap f6862a;

    /* renamed from: f  reason: collision with root package name */
    public o<WeightedLatLng> f6863f;

    /* renamed from: g  reason: collision with root package name */
    public Collection<WeightedLatLng> f6864g;

    /* renamed from: h  reason: collision with root package name */
    public int f6865h;

    /* renamed from: i  reason: collision with root package name */
    public Gradient f6866i;
    public double j;
    public h k;
    public int[] l;
    public double[] m;
    public double[] n;
    public HashMap<String, Tile> o;
    public ExecutorService p;
    public HashSet<String> q;

    /* loaded from: classes2.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        public Collection<WeightedLatLng> f6867a;

        /* renamed from: b  reason: collision with root package name */
        public int f6868b = 12;

        /* renamed from: c  reason: collision with root package name */
        public Gradient f6869c = HeatMap.DEFAULT_GRADIENT;

        /* renamed from: d  reason: collision with root package name */
        public double f6870d = 0.6d;

        public HeatMap build() {
            if (this.f6867a != null) {
                return new HeatMap(this, null);
            }
            throw new IllegalStateException("BDMapSDKException: No input data: you must use either .data or .weightedData before building");
        }

        public Builder data(Collection<LatLng> collection) {
            if (collection == null || collection.isEmpty()) {
                throw new IllegalArgumentException("BDMapSDKException: No input points.");
            }
            if (collection.contains(null)) {
                throw new IllegalArgumentException("BDMapSDKException: input points can not contain null.");
            }
            return weightedData(HeatMap.c(collection));
        }

        public Builder gradient(Gradient gradient) {
            if (gradient != null) {
                this.f6869c = gradient;
                return this;
            }
            throw new IllegalArgumentException("BDMapSDKException: gradient can not be null");
        }

        public Builder opacity(double d2) {
            this.f6870d = d2;
            if (d2 < 0.0d || d2 > 1.0d) {
                throw new IllegalArgumentException("BDMapSDKException: Opacity must be in range [0, 1]");
            }
            return this;
        }

        public Builder radius(int i2) {
            this.f6868b = i2;
            if (i2 < 10 || i2 > 50) {
                throw new IllegalArgumentException("BDMapSDKException: Radius not within bounds.");
            }
            return this;
        }

        public Builder weightedData(Collection<WeightedLatLng> collection) {
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
            this.f6867a = collection;
            return this;
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f6859c = sparseIntArray;
        sparseIntArray.put(3, 8388608);
        f6859c.put(4, 4194304);
        f6859c.put(5, 2097152);
        f6859c.put(6, 1048576);
        f6859c.put(7, 524288);
        f6859c.put(8, 262144);
        f6859c.put(9, 131072);
        f6859c.put(10, 65536);
        f6859c.put(11, 32768);
        f6859c.put(12, 16384);
        f6859c.put(13, 8192);
        f6859c.put(14, 4096);
        f6859c.put(15, 2048);
        f6859c.put(16, 1024);
        f6859c.put(17, 512);
        f6859c.put(18, 256);
        f6859c.put(19, 128);
        f6859c.put(20, 64);
        int[] iArr = {Color.rgb(0, 0, 200), Color.rgb(0, 225, 0), Color.rgb(255, 0, 0)};
        f6860d = iArr;
        float[] fArr = {0.08f, 0.4f, 1.0f};
        f6861e = fArr;
        DEFAULT_GRADIENT = new Gradient(iArr, fArr);
        r = 0;
    }

    public HeatMap(Builder builder) {
        this.o = new HashMap<>();
        this.p = Executors.newFixedThreadPool(1);
        this.q = new HashSet<>();
        this.f6864g = builder.f6867a;
        this.f6865h = builder.f6868b;
        this.f6866i = builder.f6869c;
        this.j = builder.f6870d;
        int i2 = this.f6865h;
        this.m = a(i2, i2 / 3.0d);
        a(this.f6866i);
        b(this.f6864g);
    }

    public /* synthetic */ HeatMap(Builder builder, j jVar) {
        this(builder);
    }

    public static double a(Collection<WeightedLatLng> collection, h hVar, int i2, int i3) {
        double d2 = hVar.f7078a;
        double d3 = hVar.f7080c;
        double d4 = hVar.f7079b;
        double d5 = d3 - d2;
        double d6 = hVar.f7081d - d4;
        if (d5 <= d6) {
            d5 = d6;
        }
        double d7 = ((int) ((i3 / (i2 * 2)) + 0.5d)) / d5;
        LongSparseArray longSparseArray = new LongSparseArray();
        double d8 = 0.0d;
        for (WeightedLatLng weightedLatLng : collection) {
            int i4 = (int) ((weightedLatLng.a().y - d4) * d7);
            long j = (int) ((weightedLatLng.a().x - d2) * d7);
            LongSparseArray longSparseArray2 = (LongSparseArray) longSparseArray.get(j);
            if (longSparseArray2 == null) {
                longSparseArray2 = new LongSparseArray();
                longSparseArray.put(j, longSparseArray2);
            }
            long j2 = i4;
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

    public static Bitmap a(double[][] dArr, int[] iArr, double d2) {
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

    public static Tile a(Bitmap bitmap) {
        ByteBuffer allocate = ByteBuffer.allocate(bitmap.getWidth() * bitmap.getHeight() * 4);
        bitmap.copyPixelsToBuffer(allocate);
        return new Tile(256, 256, allocate.array());
    }

    private void a(Gradient gradient) {
        this.f6866i = gradient;
        this.l = gradient.a(this.j);
    }

    private synchronized void a(String str, Tile tile) {
        this.o.put(str, tile);
    }

    private synchronized boolean a(String str) {
        return this.q.contains(str);
    }

    private double[] a(int i2) {
        int i3;
        double[] dArr = new double[20];
        int i4 = 5;
        while (true) {
            if (i4 >= 11) {
                break;
            }
            dArr[i4] = a(this.f6864g, this.k, i2, (int) (Math.pow(2.0d, i4 - 3) * 1280.0d));
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

    public static double[] a(int i2, double d2) {
        double[] dArr = new double[(i2 * 2) + 1];
        for (int i3 = -i2; i3 <= i2; i3++) {
            dArr[i3 + i2] = Math.exp(((-i3) * i3) / ((2.0d * d2) * d2));
        }
        return dArr;
    }

    public static double[][] a(double[][] dArr, double[] dArr2) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i2, int i3, int i4) {
        int i5;
        double d2 = f6859c.get(i4);
        double d3 = (this.f6865h * d2) / 256.0d;
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
        if (hVar.a(new h(hVar2.f7078a - d3, hVar2.f7080c + d3, hVar2.f7079b - d3, hVar2.f7081d + d3))) {
            Collection<WeightedLatLng> a2 = this.f6863f.a(hVar);
            if (a2.isEmpty()) {
                return;
            }
            int i6 = this.f6865h;
            double[][] dArr = (double[][]) Array.newInstance(double.class, (i6 * 2) + 256, (i6 * 2) + 256);
            for (WeightedLatLng weightedLatLng : a2) {
                Point a3 = weightedLatLng.a();
                int i7 = (int) ((a3.x - d5) / d4);
                int i8 = (int) ((d8 - a3.y) / d4);
                int i9 = this.f6865h;
                if (i7 >= (i9 * 2) + 256) {
                    i7 = ((i9 * 2) + 256) - 1;
                }
                int i10 = this.f6865h;
                if (i8 >= (i10 * 2) + 256) {
                    i8 = ((i10 * 2) + 256) - 1;
                }
                double[] dArr2 = dArr[i7];
                dArr2[i8] = dArr2[i8] + weightedLatLng.intensity;
                d8 = d8;
            }
            Bitmap a4 = a(a(dArr, this.m), this.l, this.n[i4 - 1]);
            Tile a5 = a(a4);
            a4.recycle();
            a(i2 + "_" + i3 + "_" + i4, a5);
            if (this.o.size() > r) {
                a();
            }
            BaiduMap baiduMap = this.f6862a;
            if (baiduMap != null) {
                baiduMap.a();
            }
        }
    }

    private synchronized void b(String str) {
        this.q.add(str);
    }

    private void b(Collection<WeightedLatLng> collection) {
        this.f6864g = collection;
        if (collection.isEmpty()) {
            throw new IllegalArgumentException("BDMapSDKException: No input points.");
        }
        h d2 = d(this.f6864g);
        this.k = d2;
        this.f6863f = new o<>(d2);
        for (WeightedLatLng weightedLatLng : this.f6864g) {
            this.f6863f.a((o<WeightedLatLng>) weightedLatLng);
        }
        this.n = a(this.f6865h);
    }

    private synchronized Tile c(String str) {
        if (this.o.containsKey(str)) {
            Tile tile = this.o.get(str);
            this.o.remove(str);
            return tile;
        }
        return null;
    }

    public static Collection<WeightedLatLng> c(Collection<LatLng> collection) {
        ArrayList arrayList = new ArrayList();
        for (LatLng latLng : collection) {
            arrayList.add(new WeightedLatLng(latLng));
        }
        return arrayList;
    }

    public static h d(Collection<WeightedLatLng> collection) {
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

    private synchronized void d() {
        this.o.clear();
    }

    public Tile a(int i2, int i3, int i4) {
        String str = i2 + "_" + i3 + "_" + i4;
        Tile c2 = c(str);
        if (c2 != null) {
            return c2;
        }
        if (a(str)) {
            return null;
        }
        BaiduMap baiduMap = this.f6862a;
        if (baiduMap != null && r == 0) {
            WinRound winRound = baiduMap.getMapStatus().f6894a.j;
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

    public synchronized void a() {
        this.q.clear();
        this.o.clear();
    }

    public void b() {
        d();
    }

    public void c() {
        this.p.shutdownNow();
    }

    public void removeHeatMap() {
        BaiduMap baiduMap = this.f6862a;
        if (baiduMap != null) {
            baiduMap.a(this);
        }
    }
}
