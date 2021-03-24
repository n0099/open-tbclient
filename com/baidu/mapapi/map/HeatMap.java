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
    public static final String f6869b = "HeatMap";

    /* renamed from: c  reason: collision with root package name */
    public static final SparseIntArray f6870c;

    /* renamed from: d  reason: collision with root package name */
    public static final int[] f6871d;

    /* renamed from: e  reason: collision with root package name */
    public static final float[] f6872e;
    public static int r;

    /* renamed from: a  reason: collision with root package name */
    public BaiduMap f6873a;

    /* renamed from: f  reason: collision with root package name */
    public n<WeightedLatLng> f6874f;

    /* renamed from: g  reason: collision with root package name */
    public Collection<WeightedLatLng> f6875g;

    /* renamed from: h  reason: collision with root package name */
    public int f6876h;
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
        public Collection<WeightedLatLng> f6877a;

        /* renamed from: b  reason: collision with root package name */
        public int f6878b = 12;

        /* renamed from: c  reason: collision with root package name */
        public Gradient f6879c = HeatMap.DEFAULT_GRADIENT;

        /* renamed from: d  reason: collision with root package name */
        public double f6880d = 0.6d;

        public HeatMap build() {
            if (this.f6877a != null) {
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
                this.f6879c = gradient;
                return this;
            }
            throw new IllegalArgumentException("gradient can not be null");
        }

        public Builder opacity(double d2) {
            this.f6880d = d2;
            if (d2 < 0.0d || d2 > 1.0d) {
                throw new IllegalArgumentException("Opacity must be in range [0, 1]");
            }
            return this;
        }

        public Builder radius(int i) {
            this.f6878b = i;
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
            this.f6877a = collection;
            return this;
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f6870c = sparseIntArray;
        sparseIntArray.put(3, 8388608);
        f6870c.put(4, 4194304);
        f6870c.put(5, 2097152);
        f6870c.put(6, 1048576);
        f6870c.put(7, 524288);
        f6870c.put(8, 262144);
        f6870c.put(9, 131072);
        f6870c.put(10, 65536);
        f6870c.put(11, 32768);
        f6870c.put(12, 16384);
        f6870c.put(13, 8192);
        f6870c.put(14, 4096);
        f6870c.put(15, 2048);
        f6870c.put(16, 1024);
        f6870c.put(17, 512);
        f6870c.put(18, 256);
        f6870c.put(19, 128);
        f6870c.put(20, 64);
        int[] iArr = {Color.rgb(0, 0, 200), Color.rgb(0, 225, 0), Color.rgb(255, 0, 0)};
        f6871d = iArr;
        float[] fArr = {0.08f, 0.4f, 1.0f};
        f6872e = fArr;
        DEFAULT_GRADIENT = new Gradient(iArr, fArr);
        r = 0;
    }

    public HeatMap(Builder builder) {
        this.o = new HashMap<>();
        this.p = Executors.newFixedThreadPool(1);
        this.q = new HashSet<>();
        this.f6875g = builder.f6877a;
        this.f6876h = builder.f6878b;
        this.i = builder.f6879c;
        this.j = builder.f6880d;
        int i = this.f6876h;
        double d2 = i;
        Double.isNaN(d2);
        this.m = a(i, d2 / 3.0d);
        a(this.i);
        b(this.f6875g);
    }

    public /* synthetic */ HeatMap(Builder builder, i iVar) {
        this(builder);
    }

    public static double a(Collection<WeightedLatLng> collection, g gVar, int i, int i2) {
        double d2 = gVar.f7068a;
        double d3 = gVar.f7070c;
        double d4 = gVar.f7069b;
        double d5 = d3 - d2;
        double d6 = gVar.f7071d - d4;
        if (d5 <= d6) {
            d5 = d6;
        }
        double d7 = i2 / (i * 2);
        Double.isNaN(d7);
        double d8 = (int) (d7 + 0.5d);
        Double.isNaN(d8);
        double d9 = d8 / d5;
        LongSparseArray longSparseArray = new LongSparseArray();
        double d10 = 0.0d;
        for (WeightedLatLng weightedLatLng : collection) {
            double d11 = weightedLatLng.a().x;
            double d12 = weightedLatLng.a().y;
            Double.isNaN(d11);
            Double.isNaN(d12);
            int i3 = (int) ((d12 - d4) * d9);
            long j = (int) ((d11 - d2) * d9);
            LongSparseArray longSparseArray2 = (LongSparseArray) longSparseArray.get(j);
            if (longSparseArray2 == null) {
                longSparseArray2 = new LongSparseArray();
                longSparseArray.put(j, longSparseArray2);
            }
            long j2 = i3;
            Double d13 = (Double) longSparseArray2.get(j2);
            if (d13 == null) {
                d13 = Double.valueOf(0.0d);
            }
            LongSparseArray longSparseArray3 = longSparseArray;
            double d14 = d2;
            Double valueOf = Double.valueOf(d13.doubleValue() + weightedLatLng.intensity);
            longSparseArray2.put(j2, valueOf);
            if (valueOf.doubleValue() > d10) {
                d10 = valueOf.doubleValue();
            }
            longSparseArray = longSparseArray3;
            d2 = d14;
        }
        return d10;
    }

    public static Bitmap a(double[][] dArr, int[] iArr, double d2) {
        int i = iArr[iArr.length - 1];
        double length = iArr.length - 1;
        Double.isNaN(length);
        double d3 = length / d2;
        int length2 = dArr.length;
        int[] iArr2 = new int[length2 * length2];
        for (int i2 = 0; i2 < length2; i2++) {
            for (int i3 = 0; i3 < length2; i3++) {
                double d4 = dArr[i3][i2];
                int i4 = (i2 * length2) + i3;
                int i5 = (int) (d4 * d3);
                if (d4 == 0.0d) {
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
            dArr[i3] = a(this.f6875g, this.k, i, (int) (Math.pow(2.0d, i3 - 3) * 1280.0d));
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
            double d3 = (-i2) * i2;
            Double.isNaN(d3);
            dArr[i2 + i] = Math.exp(d3 / ((2.0d * d2) * d2));
        }
        return dArr;
    }

    public static double[][] a(double[][] dArr, double[] dArr2) {
        double length = dArr2.length;
        Double.isNaN(length);
        int floor = (int) Math.floor(length / 2.0d);
        int length2 = dArr.length;
        int i = length2 - (floor * 2);
        int i2 = 1;
        int i3 = (floor + i) - 1;
        double[][] dArr3 = (double[][]) Array.newInstance(double.class, length2, length2);
        int i4 = 0;
        while (true) {
            double d2 = 0.0d;
            if (i4 >= length2) {
                break;
            }
            int i5 = 0;
            while (i5 < length2) {
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
            while (i11 < length2) {
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
        double d2 = f6870c.get(i3);
        int i4 = this.f6876h;
        double d3 = i4;
        Double.isNaN(d2);
        Double.isNaN(d3);
        double d4 = (d3 * d2) / 256.0d;
        Double.isNaN(d2);
        double d5 = (i4 * 2) + 256;
        Double.isNaN(d5);
        double d6 = ((2.0d * d4) + d2) / d5;
        if (i < 0 || i2 < 0) {
            return;
        }
        double d7 = i;
        Double.isNaN(d7);
        Double.isNaN(d2);
        double d8 = (d7 * d2) - d4;
        double d9 = i + 1;
        Double.isNaN(d9);
        Double.isNaN(d2);
        double d10 = (d9 * d2) + d4;
        double d11 = i2;
        Double.isNaN(d11);
        Double.isNaN(d2);
        double d12 = (d11 * d2) - d4;
        double d13 = i2 + 1;
        Double.isNaN(d13);
        Double.isNaN(d2);
        double d14 = (d13 * d2) + d4;
        g gVar = new g(d8, d10, d12, d14);
        g gVar2 = this.k;
        if (gVar.a(new g(gVar2.f7068a - d4, gVar2.f7070c + d4, gVar2.f7069b - d4, gVar2.f7071d + d4))) {
            Collection<WeightedLatLng> a2 = this.f6874f.a(gVar);
            if (a2.isEmpty()) {
                return;
            }
            int i5 = this.f6876h;
            double[][] dArr = (double[][]) Array.newInstance(double.class, (i5 * 2) + 256, (i5 * 2) + 256);
            for (WeightedLatLng weightedLatLng : a2) {
                Point a3 = weightedLatLng.a();
                double d15 = a3.x;
                Double.isNaN(d15);
                int i6 = (int) ((d15 - d8) / d6);
                double d16 = a3.y;
                Double.isNaN(d16);
                int i7 = (int) ((d14 - d16) / d6);
                int i8 = this.f6876h;
                if (i6 >= (i8 * 2) + 256) {
                    i6 = ((i8 * 2) + 256) - 1;
                }
                int i9 = this.f6876h;
                if (i7 >= (i9 * 2) + 256) {
                    i7 = ((i9 * 2) + 256) - 1;
                }
                double[] dArr2 = dArr[i6];
                dArr2[i7] = dArr2[i7] + weightedLatLng.intensity;
                d14 = d14;
            }
            Bitmap a4 = a(a(dArr, this.m), this.l, this.n[i3 - 1]);
            Tile a5 = a(a4);
            a4.recycle();
            a(i + "_" + i2 + "_" + i3, a5);
            if (this.o.size() > r) {
                a();
            }
            BaiduMap baiduMap = this.f6873a;
            if (baiduMap != null) {
                baiduMap.a();
            }
        }
    }

    private synchronized void b(String str) {
        this.q.add(str);
    }

    private void b(Collection<WeightedLatLng> collection) {
        this.f6875g = collection;
        if (collection.isEmpty()) {
            throw new IllegalArgumentException("No input points.");
        }
        g d2 = d(this.f6875g);
        this.k = d2;
        this.f6874f = new n<>(d2);
        for (WeightedLatLng weightedLatLng : this.f6875g) {
            this.f6874f.a((n<WeightedLatLng>) weightedLatLng);
        }
        this.n = a(this.f6876h);
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
        BaiduMap baiduMap = this.f6873a;
        if (baiduMap != null && r == 0) {
            WinRound winRound = baiduMap.getMapStatus().f6900a.j;
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
        BaiduMap baiduMap = this.f6873a;
        if (baiduMap != null) {
            baiduMap.a(this);
        }
    }
}
