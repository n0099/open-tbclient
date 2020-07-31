package com.baidu.mapapi.map;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Point;
import android.support.v4.util.LongSparseArray;
import android.util.SparseIntArray;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
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
/* loaded from: classes10.dex */
public class HeatMap {
    public static final Gradient DEFAULT_GRADIENT;
    public static final double DEFAULT_OPACITY = 0.6d;
    public static final int DEFAULT_RADIUS = 12;
    private static final String b = HeatMap.class.getSimpleName();
    private static final SparseIntArray c = new SparseIntArray();
    private static final int[] d;
    private static final float[] e;
    private static int r;
    BaiduMap a;
    private n<WeightedLatLng> f;
    private Collection<WeightedLatLng> g;
    private int h;
    private Gradient i;
    private double j;
    private g k;
    private int[] l;
    private double[] m;
    private double[] n;
    private HashMap<String, Tile> o;
    private ExecutorService p;
    private HashSet<String> q;

    /* loaded from: classes10.dex */
    public static class Builder {
        private Collection<WeightedLatLng> a;
        private int b = 12;
        private Gradient c = HeatMap.DEFAULT_GRADIENT;
        private double d = 0.6d;

        public HeatMap build() {
            if (this.a == null) {
                throw new IllegalStateException("No input data: you must use either .data or .weightedData before building");
            }
            return new HeatMap(this, null);
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
            if (gradient == null) {
                throw new IllegalArgumentException("gradient can not be null");
            }
            this.c = gradient;
            return this;
        }

        public Builder opacity(double d) {
            this.d = d;
            if (this.d < 0.0d || this.d > 1.0d) {
                throw new IllegalArgumentException("Opacity must be in range [0, 1]");
            }
            return this;
        }

        public Builder radius(int i) {
            this.b = i;
            if (this.b < 10 || this.b > 50) {
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
                if (latLng.latitude < 0.37532d || latLng.latitude > 54.562495d || latLng.longitude < 72.508319d || latLng.longitude > 135.942198d) {
                    arrayList.add(weightedLatLng);
                }
            }
            collection.removeAll(arrayList);
            this.a = collection;
            return this;
        }
    }

    static {
        c.put(3, 8388608);
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
        d = new int[]{Color.rgb(0, 0, 200), Color.rgb(0, 225, 0), Color.rgb(255, 0, 0)};
        e = new float[]{0.08f, 0.4f, 1.0f};
        DEFAULT_GRADIENT = new Gradient(d, e);
        r = 0;
    }

    private HeatMap(Builder builder) {
        this.o = new HashMap<>();
        this.p = Executors.newFixedThreadPool(1);
        this.q = new HashSet<>();
        this.g = builder.a;
        this.h = builder.b;
        this.i = builder.c;
        this.j = builder.d;
        this.m = a(this.h, this.h / 3.0d);
        a(this.i);
        b(this.g);
    }

    /* synthetic */ HeatMap(Builder builder, i iVar) {
        this(builder);
    }

    private static double a(Collection<WeightedLatLng> collection, g gVar, int i, int i2) {
        LongSparseArray longSparseArray;
        double d2 = gVar.a;
        double d3 = gVar.c;
        double d4 = gVar.b;
        double d5 = gVar.d;
        double d6 = ((int) ((i2 / (i * 2)) + 0.5d)) / (d3 - d2 > d5 - d4 ? d3 - d2 : d5 - d4);
        LongSparseArray longSparseArray2 = new LongSparseArray();
        double d7 = 0.0d;
        Iterator<WeightedLatLng> it = collection.iterator();
        while (true) {
            double d8 = d7;
            if (!it.hasNext()) {
                return d8;
            }
            WeightedLatLng next = it.next();
            int i3 = (int) ((next.a().x - d2) * d6);
            int i4 = (int) ((next.a().y - d4) * d6);
            LongSparseArray longSparseArray3 = (LongSparseArray) longSparseArray2.get(i3);
            if (longSparseArray3 == null) {
                LongSparseArray longSparseArray4 = new LongSparseArray();
                longSparseArray2.put(i3, longSparseArray4);
                longSparseArray = longSparseArray4;
            } else {
                longSparseArray = longSparseArray3;
            }
            Double d9 = (Double) longSparseArray.get(i4);
            if (d9 == null) {
                d9 = Double.valueOf(0.0d);
            }
            Double valueOf = Double.valueOf(next.intensity + d9.doubleValue());
            longSparseArray.put(i4, valueOf);
            d7 = valueOf.doubleValue() > d8 ? valueOf.doubleValue() : d8;
        }
    }

    private static Bitmap a(double[][] dArr, int[] iArr, double d2) {
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

    private static Tile a(Bitmap bitmap) {
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
        double[] dArr = new double[20];
        for (int i2 = 5; i2 < 11; i2++) {
            dArr[i2] = a(this.g, this.k, i, (int) (1280.0d * Math.pow(2.0d, i2 - 3)));
            if (i2 == 5) {
                for (int i3 = 0; i3 < i2; i3++) {
                    dArr[i3] = dArr[i2];
                }
            }
        }
        for (int i4 = 11; i4 < 20; i4++) {
            dArr[i4] = dArr[10];
        }
        return dArr;
    }

    private static double[] a(int i, double d2) {
        double[] dArr = new double[(i * 2) + 1];
        for (int i2 = -i; i2 <= i; i2++) {
            dArr[i2 + i] = Math.exp(((-i2) * i2) / ((2.0d * d2) * d2));
        }
        return dArr;
    }

    private static double[][] a(double[][] dArr, double[] dArr2) {
        int floor = (int) Math.floor(dArr2.length / 2.0d);
        int length = dArr.length;
        int i = length - (floor * 2);
        int i2 = (floor + i) - 1;
        double[][] dArr3 = (double[][]) Array.newInstance(Double.TYPE, length, length);
        for (int i3 = 0; i3 < length; i3++) {
            for (int i4 = 0; i4 < length; i4++) {
                double d2 = dArr[i3][i4];
                if (d2 != 0.0d) {
                    int i5 = (i2 < i3 + floor ? i2 : i3 + floor) + 1;
                    for (int i6 = floor > i3 - floor ? floor : i3 - floor; i6 < i5; i6++) {
                        double[] dArr4 = dArr3[i6];
                        dArr4[i4] = dArr4[i4] + (dArr2[i6 - (i3 - floor)] * d2);
                    }
                }
            }
        }
        double[][] dArr5 = (double[][]) Array.newInstance(Double.TYPE, i, i);
        for (int i7 = floor; i7 < i2 + 1; i7++) {
            for (int i8 = 0; i8 < length; i8++) {
                double d3 = dArr3[i7][i8];
                if (d3 != 0.0d) {
                    int i9 = (i2 < i8 + floor ? i2 : i8 + floor) + 1;
                    for (int i10 = floor > i8 - floor ? floor : i8 - floor; i10 < i9; i10++) {
                        double[] dArr6 = dArr5[i7 - floor];
                        int i11 = i10 - floor;
                        dArr6[i11] = dArr6[i11] + (dArr2[i10 - (i8 - floor)] * d3);
                    }
                }
            }
        }
        return dArr5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2, int i3) {
        double d2 = c.get(i3);
        double d3 = (this.h * d2) / 256.0d;
        double d4 = ((2.0d * d3) + d2) / ((this.h * 2) + 256);
        if (i < 0 || i2 < 0) {
            return;
        }
        double d5 = (i * d2) - d3;
        double d6 = (d2 * (i2 + 1)) + d3;
        g gVar = new g(d5, ((i + 1) * d2) + d3, (i2 * d2) - d3, d6);
        if (gVar.a(new g(this.k.a - d3, this.k.c + d3, this.k.b - d3, d3 + this.k.d))) {
            Collection<WeightedLatLng> a = this.f.a(gVar);
            if (a.isEmpty()) {
                return;
            }
            double[][] dArr = (double[][]) Array.newInstance(Double.TYPE, (this.h * 2) + 256, (this.h * 2) + 256);
            for (WeightedLatLng weightedLatLng : a) {
                Point a2 = weightedLatLng.a();
                int i4 = (int) ((a2.x - d5) / d4);
                int i5 = (int) ((d6 - a2.y) / d4);
                if (i4 >= (this.h * 2) + 256) {
                    i4 = ((this.h * 2) + 256) - 1;
                }
                if (i5 >= (this.h * 2) + 256) {
                    i5 = ((this.h * 2) + 256) - 1;
                }
                double[] dArr2 = dArr[i4];
                dArr2[i5] = dArr2[i5] + weightedLatLng.intensity;
            }
            Bitmap a3 = a(a(dArr, this.m), this.l, this.n[i3 - 1]);
            Tile a4 = a(a3);
            a3.recycle();
            a(i + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + i2 + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + i3, a4);
            if (this.o.size() > r) {
                a();
            }
            if (this.a != null) {
                this.a.a();
            }
        }
    }

    private synchronized void b(String str) {
        this.q.add(str);
    }

    private void b(Collection<WeightedLatLng> collection) {
        this.g = collection;
        if (this.g.isEmpty()) {
            throw new IllegalArgumentException("No input points.");
        }
        this.k = d(this.g);
        this.f = new n<>(this.k);
        for (WeightedLatLng weightedLatLng : this.g) {
            this.f.a((n<WeightedLatLng>) weightedLatLng);
        }
        this.n = a(this.h);
    }

    private synchronized Tile c(String str) {
        Tile tile;
        if (this.o.containsKey(str)) {
            tile = this.o.get(str);
            this.o.remove(str);
        } else {
            tile = null;
        }
        return tile;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Collection<WeightedLatLng> c(Collection<LatLng> collection) {
        ArrayList arrayList = new ArrayList();
        for (LatLng latLng : collection) {
            arrayList.add(new WeightedLatLng(latLng));
        }
        return arrayList;
    }

    private static g d(Collection<WeightedLatLng> collection) {
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public Tile a(int i, int i2, int i3) {
        String str = i + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + i2 + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + i3;
        Tile c2 = c(str);
        if (c2 != null) {
            return c2;
        }
        if (!a(str)) {
            if (this.a != null && r == 0) {
                MapStatus mapStatus = this.a.getMapStatus();
                r = (((mapStatus.a.j.bottom - mapStatus.a.j.top) / 256) + 2) * (((mapStatus.a.j.right - mapStatus.a.j.left) / 256) + 2) * 4;
            }
            if (this.o.size() > r) {
                a();
            }
            if (!this.p.isShutdown()) {
                try {
                    this.p.execute(new i(this, i, i2, i3));
                    b(str);
                } catch (RejectedExecutionException e2) {
                    e2.printStackTrace();
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a() {
        this.q.clear();
        this.o.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        this.p.shutdownNow();
    }

    public void removeHeatMap() {
        if (this.a != null) {
            this.a.a(this);
        }
    }
}
