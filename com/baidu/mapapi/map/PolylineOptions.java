package com.baidu.mapapi.map;

import android.os.Bundle;
import android.util.Log;
import androidx.core.view.ViewCompat;
import com.baidu.mapapi.model.LatLng;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes15.dex */
public final class PolylineOptions extends OverlayOptions {

    /* renamed from: a  reason: collision with root package name */
    int f2868a;
    Bundle c;
    private List<LatLng> e;
    private List<Integer> f;
    private List<Integer> g;
    private BitmapDescriptor i;
    private List<BitmapDescriptor> j;
    private int d = ViewCompat.MEASURED_STATE_MASK;
    private int h = 5;
    private boolean k = true;
    private boolean l = false;

    /* renamed from: b  reason: collision with root package name */
    boolean f2869b = true;
    private boolean m = false;
    private boolean n = true;
    private int o = 0;
    private LineJoinType p = LineJoinType.LineJoinRound;
    private LineCapType q = LineCapType.LineCapButt;
    private boolean r = true;

    /* loaded from: classes15.dex */
    public enum LineCapType {
        LineCapButt,
        LineCapRound
    }

    /* loaded from: classes15.dex */
    public enum LineJoinType {
        LineJoinBevel,
        LineJoinMiter,
        LineJoinRound,
        LineJoinBerzier
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay a() {
        int i = 0;
        Polyline polyline = new Polyline();
        polyline.B = this.f2869b;
        polyline.f = this.m;
        polyline.A = this.f2868a;
        polyline.C = this.c;
        if (this.e == null || this.e.size() < 2) {
            throw new IllegalStateException("BDMapSDKException: when you add polyline, you must at least supply 2 points");
        }
        polyline.f2866b = this.e;
        polyline.f2865a = this.d;
        polyline.e = this.h;
        polyline.j = this.i;
        polyline.k = this.j;
        polyline.g = this.k;
        polyline.h = this.l;
        polyline.i = this.n;
        polyline.m = this.r;
        polyline.l = this.o;
        polyline.o = this.p;
        polyline.n = this.q;
        if (this.f != null && this.f.size() < this.e.size() - 1) {
            this.f.addAll(this.f.size(), new ArrayList((this.e.size() - 1) - this.f.size()));
        }
        if (this.f != null && this.f.size() > 0) {
            int[] iArr = new int[this.f.size()];
            int i2 = 0;
            for (Integer num : this.f) {
                iArr[i2] = num.intValue();
                i2++;
            }
            polyline.c = iArr;
        }
        if (this.g != null && this.g.size() < this.e.size() - 1) {
            this.g.addAll(this.g.size(), new ArrayList((this.e.size() - 1) - this.g.size()));
        }
        if (this.g != null && this.g.size() > 0) {
            int[] iArr2 = new int[this.g.size()];
            for (Integer num2 : this.g) {
                iArr2[i] = num2.intValue();
                i++;
            }
            polyline.d = iArr2;
        }
        return polyline;
    }

    public PolylineOptions clickable(boolean z) {
        this.n = z;
        return this;
    }

    public PolylineOptions color(int i) {
        this.d = i;
        return this;
    }

    public PolylineOptions colorsValues(List<Integer> list) {
        if (list == null) {
            throw new IllegalArgumentException("BDMapSDKException: colors list can not be null");
        }
        if (list.contains(null)) {
            throw new IllegalArgumentException("BDMapSDKException: colors list can not contains null");
        }
        this.g = list;
        return this;
    }

    public PolylineOptions customTexture(BitmapDescriptor bitmapDescriptor) {
        this.i = bitmapDescriptor;
        return this;
    }

    public PolylineOptions customTextureList(List<BitmapDescriptor> list) {
        if (list == null) {
            throw new IllegalArgumentException("BDMapSDKException: customTexture list can not be null");
        }
        if (list.size() == 0) {
            Log.e("baidumapsdk", "custom texture list is empty,the texture will not work");
        }
        for (BitmapDescriptor bitmapDescriptor : list) {
            if (bitmapDescriptor == null) {
                Log.e("baidumapsdk", "the custom texture item is null,it will be discard");
            }
        }
        this.j = list;
        return this;
    }

    public PolylineOptions dottedLine(boolean z) {
        this.m = z;
        return this;
    }

    public PolylineOptions dottedLineType(PolylineDottedLineType polylineDottedLineType) {
        this.o = polylineDottedLineType.ordinal();
        return this;
    }

    public PolylineOptions extraInfo(Bundle bundle) {
        this.c = bundle;
        return this;
    }

    public PolylineOptions focus(boolean z) {
        this.k = z;
        return this;
    }

    public int getColor() {
        return this.d;
    }

    public BitmapDescriptor getCustomTexture() {
        return this.i;
    }

    public List<BitmapDescriptor> getCustomTextureList() {
        return this.j;
    }

    public Bundle getExtraInfo() {
        return this.c;
    }

    public List<LatLng> getPoints() {
        return this.e;
    }

    public List<Integer> getTextureIndexs() {
        return this.f;
    }

    public int getWidth() {
        return this.h;
    }

    public int getZIndex() {
        return this.f2868a;
    }

    public boolean isDottedLine() {
        return this.m;
    }

    public boolean isFocus() {
        return this.k;
    }

    public PolylineOptions isThined(boolean z) {
        this.r = z;
        return this;
    }

    public boolean isVisible() {
        return this.f2869b;
    }

    public PolylineOptions keepScale(boolean z) {
        this.l = z;
        return this;
    }

    public PolylineOptions lineCapType(LineCapType lineCapType) {
        this.q = lineCapType;
        return this;
    }

    public PolylineOptions lineJoinType(LineJoinType lineJoinType) {
        this.p = lineJoinType;
        return this;
    }

    public PolylineOptions points(List<LatLng> list) {
        if (list == null) {
            throw new IllegalArgumentException("BDMapSDKException: points list can not be null");
        }
        if (list.size() < 2) {
            throw new IllegalArgumentException("BDMapSDKException: points count can not less than 2");
        }
        if (list.contains(null)) {
            throw new IllegalArgumentException("BDMapSDKException: points list can not contains null");
        }
        this.e = list;
        return this;
    }

    public PolylineOptions textureIndex(List<Integer> list) {
        if (list == null) {
            throw new IllegalArgumentException("BDMapSDKException: indexs list can not be null");
        }
        if (list.contains(null)) {
            throw new IllegalArgumentException("BDMapSDKException: index list can not contains null");
        }
        this.f = list;
        return this;
    }

    public PolylineOptions visible(boolean z) {
        this.f2869b = z;
        return this;
    }

    public PolylineOptions width(int i) {
        if (i > 0) {
            this.h = i;
        }
        return this;
    }

    public PolylineOptions zIndex(int i) {
        this.f2868a = i;
        return this;
    }
}
