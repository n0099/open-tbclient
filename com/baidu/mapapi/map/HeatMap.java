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
    public static final String f6905b = "HeatMap";

    /* renamed from: c  reason: collision with root package name */
    public static final SparseIntArray f6906c;

    /* renamed from: d  reason: collision with root package name */
    public static final int[] f6907d;

    /* renamed from: e  reason: collision with root package name */
    public static final float[] f6908e;
    public static int r;

    /* renamed from: a  reason: collision with root package name */
    public BaiduMap f6909a;

    /* renamed from: f  reason: collision with root package name */
    public n<WeightedLatLng> f6910f;

    /* renamed from: g  reason: collision with root package name */
    public Collection<WeightedLatLng> f6911g;

    /* renamed from: h  reason: collision with root package name */
    public int f6912h;
    public Gradient i;
    public double j;
    public g k;
    public int[] l;
    public double[] m;
    public double[] n;
    public HashMap<String, Tile> o;
    public ExecutorService p;
    public HashSet<String> q;

    /* loaded from: classes2.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        public Collection<WeightedLatLng> f6913a;

        /* renamed from: b  reason: collision with root package name */
        public int f6914b = 12;

        /* renamed from: c  reason: collision with root package name */
        public Gradient f6915c = HeatMap.DEFAULT_GRADIENT;

        /* renamed from: d  reason: collision with root package name */
        public double f6916d = 0.6d;

        public HeatMap build() {
            if (this.f6913a != null) {
                return new HeatMap(this, null);
            }
            throw new IllegalStateException("No input data: you must use either .data or .weightedData before building");
        }

        public Builder data(Collection<LatLng> collection) {
            if (collection == null || collection.isEmpty()) {
                throw new IllegalArgumentException("No input points.");
            }
            if (collection.contains(null)) {
                throw new IllegalArgumentException("input points can not contain null.");
            }
            return weightedData(HeatMap.c(collection));
        }

        public Builder gradient(Gradient gradient) {
            if (gradient != null) {
                this.f6915c = gradient;
                return this;
            }
            throw new IllegalArgumentException("gradient can not be null");
        }

        public Builder opacity(double d2) {
            this.f6916d = d2;
            if (d2 < 0.0d || d2 > 1.0d) {
                throw new IllegalArgumentException("Opacity must be in range [0, 1]");
            }
            return this;
        }

        public Builder radius(int i) {
            this.f6914b = i;
            if (i < 10 || i > 50) {
                throw new IllegalArgumentException("Radius not within bounds.");
            }
            return this;
        }

        public Builder weightedData(Collection<WeightedLatLng> collection) {
            if (collection == null || collection.isEmpty()) {
                throw new IllegalArgumentException("No input points.");
            }
            if (collection.contains(null)) {
                throw new IllegalArgumentException("input points can not contain null.");
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
            this.f6913a = collection;
            return this;
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f6906c = sparseIntArray;
        sparseIntArray.put(3, 8388608);
        f6906c.put(4, 4194304);
        f6906c.put(5, 2097152);
        f6906c.put(6, 1048576);
        f6906c.put(7, 524288);
        f6906c.put(8, 262144);
        f6906c.put(9, 131072);
        f6906c.put(10, 65536);
        f6906c.put(11, 32768);
        f6906c.put(12, 16384);
        f6906c.put(13, 8192);
        f6906c.put(14, 4096);
        f6906c.put(15, 2048);
        f6906c.put(16, 1024);
        f6906c.put(17, 512);
        f6906c.put(18, 256);
        f6906c.put(19, 128);
        f6906c.put(20, 64);
        int[] iArr = {Color.rgb(0, 0, 200), Color.rgb(0, 225, 0), Color.rgb(255, 0, 0)};
        f6907d = iArr;
        float[] fArr = {0.08f, 0.4f, 1.0f};
        f6908e = fArr;
        DEFAULT_GRADIENT = new Gradient(iArr, fArr);
        r = 0;
    }

    public HeatMap(Builder builder) {
        this.o = new HashMap<>();
        this.p = Executors.newFixedThreadPool(1);
        this.q = new HashSet<>();
        this.f6911g = builder.f6913a;
        this.f6912h = builder.f6914b;
        this.i = builder.f6915c;
        this.j = builder.f6916d;
        int i = this.f6912h;
        this.m = a(i, i / 3.0d);
        a(this.i);
        b(this.f6911g);
    }

    public /* synthetic */ HeatMap(Builder builder, i iVar) {
        this(builder);
    }

    public static double a(Collection<WeightedLatLng> collection, g gVar, int i, int i2) {
        double d2 = gVar.f7104a;
        double d3 = gVar.f7106c;
        double d4 = gVar.f7105b;
        double d5 = d3 - d2;
        double d6 = gVar.f7107d - d4;
        if (d5 <= d6) {
            d5 = d6;
        }
        double d7 = ((int) ((i2 / (i * 2)) + 0.5d)) / d5;
        LongSparseArray longSparseArray = new LongSparseArray();
        double d8 = 0.0d;
        for (WeightedLatLng weightedLatLng : collection) {
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

    public static Bitmap a(double[][] dArr, int[] iArr, double d2) {
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

    public static Tile a(Bitmap bitmap) {
        ByteBuffer allocate = ByteBuffer.allocate(bitmap.getWidth() * bitmap.getHeight() * 4);
        bitmap.copyPixelsToBuffer(allocate);
        return new Tile(256, 256, allocate.array());
    }

    private void a(Gradient gradient) {
        this.i = gradient;
        this.l = gradient.a(this.j);
    }

    private synchronized void a(String str, Tile tile) {
        this.o.put(str, tile);
    }

    private synchronized boolean a(String str) {
        return this.q.contains(str);
    }

    private double[] a(int i) {
        int i2;
        double[] dArr = new double[20];
        int i3 = 5;
        while (true) {
            if (i3 >= 11) {
                break;
            }
            dArr[i3] = a(this.f6911g, this.k, i, (int) (Math.pow(2.0d, i3 - 3) * 1280.0d));
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

    public static double[] a(int i, double d2) {
        double[] dArr = new double[(i * 2) + 1];
        for (int i2 = -i; i2 <= i; i2++) {
            dArr[i2 + i] = Math.exp(((-i2) * i2) / ((2.0d * d2) * d2));
        }
        return dArr;
    }

    public static double[][] a(double[][] dArr, double[] dArr2) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2, int i3) {
        int i4;
        double d2 = f6906c.get(i3);
        double d3 = (this.f6912h * d2) / 256.0d;
        double d4 = ((2.0d * d3) + d2) / ((i4 * 2) + 256);
        if (i < 0 || i2 < 0) {
            return;
        }
        double d5 = (i * d2) - d3;
        double d6 = ((i + 1) * d2) + d3;
        double d7 = (i2 * d2) - d3;
        double d8 = ((i2 + 1) * d2) + d3;
        g gVar = new g(d5, d6, d7, d8);
        g gVar2 = this.k;
        if (gVar.a(new g(gVar2.f7104a - d3, gVar2.f7106c + d3, gVar2.f7105b - d3, gVar2.f7107d + d3))) {
            Collection<WeightedLatLng> a2 = this.f6910f.a(gVar);
            if (a2.isEmpty()) {
                return;
            }
            int i5 = this.f6912h;
            double[][] dArr = (double[][]) Array.newInstance(double.class, (i5 * 2) + 256, (i5 * 2) + 256);
            for (WeightedLatLng weightedLatLng : a2) {
                Point a3 = weightedLatLng.a();
                int i6 = (int) ((a3.x - d5) / d4);
                int i7 = (int) ((d8 - a3.y) / d4);
                int i8 = this.f6912h;
                if (i6 >= (i8 * 2) + 256) {
                    i6 = ((i8 * 2) + 256) - 1;
                }
                int i9 = this.f6912h;
                if (i7 >= (i9 * 2) + 256) {
                    i7 = ((i9 * 2) + 256) - 1;
                }
                double[] dArr2 = dArr[i6];
                dArr2[i7] = dArr2[i7] + weightedLatLng.intensity;
                d8 = d8;
            }
            Bitmap a4 = a(a(dArr, this.m), this.l, this.n[i3 - 1]);
            Tile a5 = a(a4);
            a4.recycle();
            a(i + "_" + i2 + "_" + i3, a5);
            if (this.o.size() > r) {
                a();
            }
            BaiduMap baiduMap = this.f6909a;
            if (baiduMap != null) {
                baiduMap.a();
            }
        }
    }

    private synchronized void b(String str) {
        this.q.add(str);
    }

    private void b(Collection<WeightedLatLng> collection) {
        this.f6911g = collection;
        if (collection.isEmpty()) {
            throw new IllegalArgumentException("No input points.");
        }
        g d2 = d(this.f6911g);
        this.k = d2;
        this.f6910f = new n<>(d2);
        for (WeightedLatLng weightedLatLng : this.f6911g) {
            this.f6910f.a((n<WeightedLatLng>) weightedLatLng);
        }
        this.n = a(this.f6912h);
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

    public static g d(Collection<WeightedLatLng> collection) {
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
        return new g(d2, d3, d4, d5);
    }

    private synchronized void d() {
        this.o.clear();
    }

    public Tile a(int i, int i2, int i3) {
        String str = i + "_" + i2 + "_" + i3;
        Tile c2 = c(str);
        if (c2 != null) {
            return c2;
        }
        if (a(str)) {
            return null;
        }
        BaiduMap baiduMap = this.f6909a;
        if (baiduMap != null && r == 0) {
            WinRound winRound = baiduMap.getMapStatus().f6936a.j;
            r = (((winRound.right - winRound.left) / 256) + 2) * (((winRound.bottom - winRound.top) / 256) + 2) * 4;
        }
        if (this.o.size() > r) {
            a();
        }
        if (this.p.isShutdown()) {
            return null;
        }
        try {
            this.p.execute(new i(this, i, i2, i3));
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
        BaiduMap baiduMap = this.f6909a;
        if (baiduMap != null) {
            baiduMap.a(this);
        }
    }
}
