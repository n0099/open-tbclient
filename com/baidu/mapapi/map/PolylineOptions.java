package com.baidu.mapapi.map;

import android.os.Bundle;
import android.util.Log;
import com.baidu.mapapi.model.LatLng;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public final class PolylineOptions extends OverlayOptions {

    /* renamed from: a  reason: collision with root package name */
    public int f6983a;

    /* renamed from: d  reason: collision with root package name */
    public Bundle f6986d;

    /* renamed from: f  reason: collision with root package name */
    public List<LatLng> f6988f;

    /* renamed from: g  reason: collision with root package name */
    public List<Integer> f6989g;

    /* renamed from: h  reason: collision with root package name */
    public List<Integer> f6990h;
    public BitmapDescriptor j;
    public List<BitmapDescriptor> k;

    /* renamed from: e  reason: collision with root package name */
    public int f6987e = -16777216;
    public int i = 5;
    public boolean l = true;
    public boolean m = false;

    /* renamed from: b  reason: collision with root package name */
    public boolean f6984b = true;

    /* renamed from: c  reason: collision with root package name */
    public boolean f6985c = false;

    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay a() {
        Polyline polyline = new Polyline();
        polyline.x = this.f6984b;
        polyline.f6980f = this.f6985c;
        polyline.w = this.f6983a;
        polyline.y = this.f6986d;
        List<LatLng> list = this.f6988f;
        if (list == null || list.size() < 2) {
            throw new IllegalStateException("when you add polyline, you must at least supply 2 points");
        }
        polyline.f6976b = this.f6988f;
        polyline.f6975a = this.f6987e;
        polyline.f6979e = this.i;
        polyline.i = this.j;
        polyline.j = this.k;
        polyline.f6981g = this.l;
        polyline.f6982h = this.m;
        List<Integer> list2 = this.f6989g;
        if (list2 != null && list2.size() < this.f6988f.size() - 1) {
            ArrayList arrayList = new ArrayList((this.f6988f.size() - 1) - this.f6989g.size());
            List<Integer> list3 = this.f6989g;
            list3.addAll(list3.size(), arrayList);
        }
        List<Integer> list4 = this.f6989g;
        int i = 0;
        if (list4 != null && list4.size() > 0) {
            int[] iArr = new int[this.f6989g.size()];
            int i2 = 0;
            for (Integer num : this.f6989g) {
                iArr[i2] = num.intValue();
                i2++;
            }
            polyline.f6977c = iArr;
        }
        List<Integer> list5 = this.f6990h;
        if (list5 != null && list5.size() < this.f6988f.size() - 1) {
            ArrayList arrayList2 = new ArrayList((this.f6988f.size() - 1) - this.f6990h.size());
            List<Integer> list6 = this.f6990h;
            list6.addAll(list6.size(), arrayList2);
        }
        List<Integer> list7 = this.f6990h;
        if (list7 != null && list7.size() > 0) {
            int[] iArr2 = new int[this.f6990h.size()];
            for (Integer num2 : this.f6990h) {
                iArr2[i] = num2.intValue();
                i++;
            }
            polyline.f6978d = iArr2;
        }
        return polyline;
    }

    public PolylineOptions color(int i) {
        this.f6987e = i;
        return this;
    }

    public PolylineOptions colorsValues(List<Integer> list) {
        if (list != null) {
            if (list.contains(null)) {
                throw new IllegalArgumentException("colors list can not contains null");
            }
            this.f6990h = list;
            return this;
        }
        throw new IllegalArgumentException("colors list can not be null");
    }

    public PolylineOptions customTexture(BitmapDescriptor bitmapDescriptor) {
        this.j = bitmapDescriptor;
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
            this.k = list;
            return this;
        }
        throw new IllegalArgumentException("customTexture list can not be null");
    }

    public PolylineOptions dottedLine(boolean z) {
        this.f6985c = z;
        return this;
    }

    public PolylineOptions extraInfo(Bundle bundle) {
        this.f6986d = bundle;
        return this;
    }

    public PolylineOptions focus(boolean z) {
        this.l = z;
        return this;
    }

    public int getColor() {
        return this.f6987e;
    }

    public BitmapDescriptor getCustomTexture() {
        return this.j;
    }

    public List<BitmapDescriptor> getCustomTextureList() {
        return this.k;
    }

    public Bundle getExtraInfo() {
        return this.f6986d;
    }

    public List<LatLng> getPoints() {
        return this.f6988f;
    }

    public List<Integer> getTextureIndexs() {
        return this.f6989g;
    }

    public int getWidth() {
        return this.i;
    }

    public int getZIndex() {
        return this.f6983a;
    }

    public boolean isDottedLine() {
        return this.f6985c;
    }

    public boolean isFocus() {
        return this.l;
    }

    public boolean isVisible() {
        return this.f6984b;
    }

    public PolylineOptions keepScale(boolean z) {
        this.m = z;
        return this;
    }

    public PolylineOptions points(List<LatLng> list) {
        if (list != null) {
            if (list.size() >= 2) {
                if (list.contains(null)) {
                    throw new IllegalArgumentException("points list can not contains null");
                }
                this.f6988f = list;
                return this;
            }
            throw new IllegalArgumentException("points count can not less than 2");
        }
        throw new IllegalArgumentException("points list can not be null");
    }

    public PolylineOptions textureIndex(List<Integer> list) {
        if (list != null) {
            if (list.contains(null)) {
                throw new IllegalArgumentException("index list can not contains null");
            }
            this.f6989g = list;
            return this;
        }
        throw new IllegalArgumentException("indexs list can not be null");
    }

    public PolylineOptions visible(boolean z) {
        this.f6984b = z;
        return this;
    }

    public PolylineOptions width(int i) {
        if (i > 0) {
            this.i = i;
        }
        return this;
    }

    public PolylineOptions zIndex(int i) {
        this.f6983a = i;
        return this;
    }
}
