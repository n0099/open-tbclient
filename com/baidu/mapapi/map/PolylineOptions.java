package com.baidu.mapapi.map;

import android.os.Bundle;
import android.util.Log;
import com.baidu.mapapi.model.LatLng;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public final class PolylineOptions extends OverlayOptions {
    public int a;
    public Bundle c;
    public List<LatLng> e;
    public List<Integer> f;
    public List<Integer> g;
    public BitmapDescriptor i;
    public List<BitmapDescriptor> j;
    public int d = -16777216;
    public int h = 5;
    public boolean k = true;
    public boolean l = false;
    public boolean b = true;
    public boolean m = false;
    public boolean n = true;
    public int o = 0;
    public LineJoinType p = LineJoinType.LineJoinRound;
    public LineCapType q = LineCapType.LineCapButt;
    public boolean r = true;
    public boolean s = false;
    public boolean t = false;
    public LineDirectionCross180 u = LineDirectionCross180.NONE;

    /* loaded from: classes2.dex */
    public enum LineCapType {
        LineCapButt,
        LineCapRound
    }

    /* loaded from: classes2.dex */
    public enum LineDirectionCross180 {
        NONE,
        FROM_EAST_TO_WEST,
        FROM_WEST_TO_EAST
    }

    /* loaded from: classes2.dex */
    public enum LineJoinType {
        LineJoinBevel,
        LineJoinMiter,
        LineJoinRound,
        LineJoinBerzier
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
        return this.a;
    }

    public boolean isDottedLine() {
        return this.m;
    }

    public boolean isFocus() {
        return this.k;
    }

    public boolean isVisible() {
        return this.b;
    }

    private Polyline a(Polyline polyline) {
        polyline.H = this.b;
        polyline.r = this.u;
        polyline.b = this.e;
        polyline.o = this.t;
        List<Integer> list = this.g;
        if (list != null && list.size() != 0) {
            int[] iArr = new int[this.g.size()];
            int i = 0;
            for (Integer num : this.g) {
                iArr[i] = num.intValue();
                i++;
            }
            polyline.d = iArr;
            return polyline;
        }
        throw new IllegalStateException("BDMapSDKException: colors array can not be null");
    }

    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay a() {
        Polyline polyline = new Polyline();
        List<LatLng> list = this.e;
        if (list != null && list.size() >= 2) {
            boolean z = this.t;
            if (z) {
                polyline.type = com.baidu.mapsdkplatform.comapi.map.i.n;
                return a(polyline);
            }
            polyline.H = this.b;
            polyline.f = this.m;
            polyline.G = this.a;
            polyline.I = this.c;
            polyline.b = this.e;
            polyline.a = this.d;
            polyline.e = this.h;
            polyline.j = this.i;
            polyline.k = this.j;
            polyline.g = this.k;
            polyline.h = this.l;
            polyline.i = this.n;
            polyline.m = this.r;
            polyline.n = this.s;
            polyline.o = z;
            polyline.l = this.o;
            polyline.q = this.p;
            polyline.p = this.q;
            polyline.r = this.u;
            List<Integer> list2 = this.f;
            if (list2 != null && list2.size() < this.e.size() - 1) {
                ArrayList arrayList = new ArrayList((this.e.size() - 1) - this.f.size());
                List<Integer> list3 = this.f;
                list3.addAll(list3.size(), arrayList);
            }
            List<Integer> list4 = this.f;
            int i = 0;
            if (list4 != null && list4.size() > 0) {
                int[] iArr = new int[this.f.size()];
                int i2 = 0;
                for (Integer num : this.f) {
                    iArr[i2] = num.intValue();
                    i2++;
                }
                polyline.c = iArr;
            }
            List<Integer> list5 = this.g;
            if (list5 != null && list5.size() < this.e.size() - 1) {
                ArrayList arrayList2 = new ArrayList((this.e.size() - 1) - this.g.size());
                List<Integer> list6 = this.g;
                list6.addAll(list6.size(), arrayList2);
            }
            List<Integer> list7 = this.g;
            if (list7 != null && list7.size() > 0) {
                int[] iArr2 = new int[this.g.size()];
                for (Integer num2 : this.g) {
                    iArr2[i] = num2.intValue();
                    i++;
                }
                polyline.d = iArr2;
            }
            return polyline;
        }
        throw new IllegalStateException("BDMapSDKException: when you add polyline, you must at least supply 2 points");
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
        if (list != null) {
            if (!list.contains(null)) {
                this.g = list;
                return this;
            }
            throw new IllegalArgumentException("BDMapSDKException: colors list can not contains null");
        }
        throw new IllegalArgumentException("BDMapSDKException: colors list can not be null");
    }

    public PolylineOptions customTexture(BitmapDescriptor bitmapDescriptor) {
        this.i = bitmapDescriptor;
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

    public PolylineOptions isGeodesic(boolean z) {
        this.s = z;
        return this;
    }

    public PolylineOptions isGradient(boolean z) {
        this.t = z;
        return this;
    }

    public PolylineOptions isThined(boolean z) {
        this.r = z;
        return this;
    }

    public PolylineOptions keepScale(boolean z) {
        this.l = z;
        return this;
    }

    public PolylineOptions lineCapType(LineCapType lineCapType) {
        this.q = lineCapType;
        return this;
    }

    public PolylineOptions lineDirectionCross180(LineDirectionCross180 lineDirectionCross180) {
        this.u = lineDirectionCross180;
        return this;
    }

    public PolylineOptions lineJoinType(LineJoinType lineJoinType) {
        this.p = lineJoinType;
        return this;
    }

    public PolylineOptions points(List<LatLng> list) {
        if (list != null) {
            if (list.size() >= 2) {
                if (!list.contains(null)) {
                    this.e = list;
                    return this;
                }
                throw new IllegalArgumentException("BDMapSDKException: points list can not contains null");
            }
            throw new IllegalArgumentException("BDMapSDKException: points count can not less than 2");
        }
        throw new IllegalArgumentException("BDMapSDKException: points list can not be null");
    }

    public PolylineOptions textureIndex(List<Integer> list) {
        if (list != null) {
            if (!list.contains(null)) {
                this.f = list;
                return this;
            }
            throw new IllegalArgumentException("BDMapSDKException: index list can not contains null");
        }
        throw new IllegalArgumentException("BDMapSDKException: indexs list can not be null");
    }

    public PolylineOptions visible(boolean z) {
        this.b = z;
        return this;
    }

    public PolylineOptions width(int i) {
        if (i > 0) {
            this.h = i;
        }
        return this;
    }

    public PolylineOptions zIndex(int i) {
        this.a = i;
        return this;
    }

    public PolylineOptions customTextureList(List<BitmapDescriptor> list) {
        if (list != null) {
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
        throw new IllegalArgumentException("BDMapSDKException: customTexture list can not be null");
    }
}
