package com.baidu.mapapi.map;

import android.os.Bundle;
import android.util.Log;
import com.baidu.mapapi.model.LatLng;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public final class PolylineOptions extends OverlayOptions {

    /* renamed from: a  reason: collision with root package name */
    public int f7266a;

    /* renamed from: d  reason: collision with root package name */
    public Bundle f7269d;

    /* renamed from: f  reason: collision with root package name */
    public List<LatLng> f7271f;

    /* renamed from: g  reason: collision with root package name */
    public List<Integer> f7272g;

    /* renamed from: h  reason: collision with root package name */
    public List<Integer> f7273h;
    public BitmapDescriptor j;
    public List<BitmapDescriptor> k;

    /* renamed from: e  reason: collision with root package name */
    public int f7270e = -16777216;

    /* renamed from: i  reason: collision with root package name */
    public int f7274i = 5;
    public boolean l = true;
    public boolean m = false;

    /* renamed from: b  reason: collision with root package name */
    public boolean f7267b = true;

    /* renamed from: c  reason: collision with root package name */
    public boolean f7268c = false;

    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay a() {
        Polyline polyline = new Polyline();
        polyline.x = this.f7267b;
        polyline.f7262f = this.f7268c;
        polyline.w = this.f7266a;
        polyline.y = this.f7269d;
        List<LatLng> list = this.f7271f;
        if (list == null || list.size() < 2) {
            throw new IllegalStateException("when you add polyline, you must at least supply 2 points");
        }
        polyline.f7258b = this.f7271f;
        polyline.f7257a = this.f7270e;
        polyline.f7261e = this.f7274i;
        polyline.f7265i = this.j;
        polyline.j = this.k;
        polyline.f7263g = this.l;
        polyline.f7264h = this.m;
        List<Integer> list2 = this.f7272g;
        if (list2 != null && list2.size() < this.f7271f.size() - 1) {
            ArrayList arrayList = new ArrayList((this.f7271f.size() - 1) - this.f7272g.size());
            List<Integer> list3 = this.f7272g;
            list3.addAll(list3.size(), arrayList);
        }
        List<Integer> list4 = this.f7272g;
        int i2 = 0;
        if (list4 != null && list4.size() > 0) {
            int[] iArr = new int[this.f7272g.size()];
            int i3 = 0;
            for (Integer num : this.f7272g) {
                iArr[i3] = num.intValue();
                i3++;
            }
            polyline.f7259c = iArr;
        }
        List<Integer> list5 = this.f7273h;
        if (list5 != null && list5.size() < this.f7271f.size() - 1) {
            ArrayList arrayList2 = new ArrayList((this.f7271f.size() - 1) - this.f7273h.size());
            List<Integer> list6 = this.f7273h;
            list6.addAll(list6.size(), arrayList2);
        }
        List<Integer> list7 = this.f7273h;
        if (list7 != null && list7.size() > 0) {
            int[] iArr2 = new int[this.f7273h.size()];
            for (Integer num2 : this.f7273h) {
                iArr2[i2] = num2.intValue();
                i2++;
            }
            polyline.f7260d = iArr2;
        }
        return polyline;
    }

    public PolylineOptions color(int i2) {
        this.f7270e = i2;
        return this;
    }

    public PolylineOptions colorsValues(List<Integer> list) {
        if (list != null) {
            if (list.contains(null)) {
                throw new IllegalArgumentException("colors list can not contains null");
            }
            this.f7273h = list;
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
        this.f7268c = z;
        return this;
    }

    public PolylineOptions extraInfo(Bundle bundle) {
        this.f7269d = bundle;
        return this;
    }

    public PolylineOptions focus(boolean z) {
        this.l = z;
        return this;
    }

    public int getColor() {
        return this.f7270e;
    }

    public BitmapDescriptor getCustomTexture() {
        return this.j;
    }

    public List<BitmapDescriptor> getCustomTextureList() {
        return this.k;
    }

    public Bundle getExtraInfo() {
        return this.f7269d;
    }

    public List<LatLng> getPoints() {
        return this.f7271f;
    }

    public List<Integer> getTextureIndexs() {
        return this.f7272g;
    }

    public int getWidth() {
        return this.f7274i;
    }

    public int getZIndex() {
        return this.f7266a;
    }

    public boolean isDottedLine() {
        return this.f7268c;
    }

    public boolean isFocus() {
        return this.l;
    }

    public boolean isVisible() {
        return this.f7267b;
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
                this.f7271f = list;
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
            this.f7272g = list;
            return this;
        }
        throw new IllegalArgumentException("indexs list can not be null");
    }

    public PolylineOptions visible(boolean z) {
        this.f7267b = z;
        return this;
    }

    public PolylineOptions width(int i2) {
        if (i2 > 0) {
            this.f7274i = i2;
        }
        return this;
    }

    public PolylineOptions zIndex(int i2) {
        this.f7266a = i2;
        return this;
    }
}
