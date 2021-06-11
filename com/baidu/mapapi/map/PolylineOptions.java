package com.baidu.mapapi.map;

import android.os.Bundle;
import android.util.Log;
import com.baidu.mapapi.model.LatLng;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public final class PolylineOptions extends OverlayOptions {

    /* renamed from: a  reason: collision with root package name */
    public int f7025a;

    /* renamed from: c  reason: collision with root package name */
    public Bundle f7027c;

    /* renamed from: e  reason: collision with root package name */
    public List<LatLng> f7029e;

    /* renamed from: f  reason: collision with root package name */
    public List<Integer> f7030f;

    /* renamed from: g  reason: collision with root package name */
    public List<Integer> f7031g;

    /* renamed from: i  reason: collision with root package name */
    public BitmapDescriptor f7033i;
    public List<BitmapDescriptor> j;

    /* renamed from: d  reason: collision with root package name */
    public int f7028d = -16777216;

    /* renamed from: h  reason: collision with root package name */
    public int f7032h = 5;
    public boolean k = true;
    public boolean l = false;

    /* renamed from: b  reason: collision with root package name */
    public boolean f7026b = true;
    public boolean m = false;

    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay a() {
        Polyline polyline = new Polyline();
        polyline.A = this.f7026b;
        polyline.f7021f = this.m;
        polyline.z = this.f7025a;
        polyline.B = this.f7027c;
        List<LatLng> list = this.f7029e;
        if (list == null || list.size() < 2) {
            throw new IllegalStateException("BDMapSDKException: when you add polyline, you must at least supply 2 points");
        }
        polyline.f7017b = this.f7029e;
        polyline.f7016a = this.f7028d;
        polyline.f7020e = this.f7032h;
        polyline.f7024i = this.f7033i;
        polyline.j = this.j;
        polyline.f7022g = this.k;
        polyline.f7023h = this.l;
        List<Integer> list2 = this.f7030f;
        if (list2 != null && list2.size() < this.f7029e.size() - 1) {
            ArrayList arrayList = new ArrayList((this.f7029e.size() - 1) - this.f7030f.size());
            List<Integer> list3 = this.f7030f;
            list3.addAll(list3.size(), arrayList);
        }
        List<Integer> list4 = this.f7030f;
        int i2 = 0;
        if (list4 != null && list4.size() > 0) {
            int[] iArr = new int[this.f7030f.size()];
            int i3 = 0;
            for (Integer num : this.f7030f) {
                iArr[i3] = num.intValue();
                i3++;
            }
            polyline.f7018c = iArr;
        }
        List<Integer> list5 = this.f7031g;
        if (list5 != null && list5.size() < this.f7029e.size() - 1) {
            ArrayList arrayList2 = new ArrayList((this.f7029e.size() - 1) - this.f7031g.size());
            List<Integer> list6 = this.f7031g;
            list6.addAll(list6.size(), arrayList2);
        }
        List<Integer> list7 = this.f7031g;
        if (list7 != null && list7.size() > 0) {
            int[] iArr2 = new int[this.f7031g.size()];
            for (Integer num2 : this.f7031g) {
                iArr2[i2] = num2.intValue();
                i2++;
            }
            polyline.f7019d = iArr2;
        }
        return polyline;
    }

    public PolylineOptions color(int i2) {
        this.f7028d = i2;
        return this;
    }

    public PolylineOptions colorsValues(List<Integer> list) {
        if (list != null) {
            if (list.contains(null)) {
                throw new IllegalArgumentException("BDMapSDKException: colors list can not contains null");
            }
            this.f7031g = list;
            return this;
        }
        throw new IllegalArgumentException("BDMapSDKException: colors list can not be null");
    }

    public PolylineOptions customTexture(BitmapDescriptor bitmapDescriptor) {
        this.f7033i = bitmapDescriptor;
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

    public PolylineOptions dottedLine(boolean z) {
        this.m = z;
        return this;
    }

    public PolylineOptions extraInfo(Bundle bundle) {
        this.f7027c = bundle;
        return this;
    }

    public PolylineOptions focus(boolean z) {
        this.k = z;
        return this;
    }

    public int getColor() {
        return this.f7028d;
    }

    public BitmapDescriptor getCustomTexture() {
        return this.f7033i;
    }

    public List<BitmapDescriptor> getCustomTextureList() {
        return this.j;
    }

    public Bundle getExtraInfo() {
        return this.f7027c;
    }

    public List<LatLng> getPoints() {
        return this.f7029e;
    }

    public List<Integer> getTextureIndexs() {
        return this.f7030f;
    }

    public int getWidth() {
        return this.f7032h;
    }

    public int getZIndex() {
        return this.f7025a;
    }

    public boolean isDottedLine() {
        return this.m;
    }

    public boolean isFocus() {
        return this.k;
    }

    public boolean isVisible() {
        return this.f7026b;
    }

    public PolylineOptions keepScale(boolean z) {
        this.l = z;
        return this;
    }

    public PolylineOptions points(List<LatLng> list) {
        if (list != null) {
            if (list.size() >= 2) {
                if (list.contains(null)) {
                    throw new IllegalArgumentException("BDMapSDKException: points list can not contains null");
                }
                this.f7029e = list;
                return this;
            }
            throw new IllegalArgumentException("BDMapSDKException: points count can not less than 2");
        }
        throw new IllegalArgumentException("BDMapSDKException: points list can not be null");
    }

    public PolylineOptions textureIndex(List<Integer> list) {
        if (list != null) {
            if (list.contains(null)) {
                throw new IllegalArgumentException("BDMapSDKException: index list can not contains null");
            }
            this.f7030f = list;
            return this;
        }
        throw new IllegalArgumentException("BDMapSDKException: indexs list can not be null");
    }

    public PolylineOptions visible(boolean z) {
        this.f7026b = z;
        return this;
    }

    public PolylineOptions width(int i2) {
        if (i2 > 0) {
            this.f7032h = i2;
        }
        return this;
    }

    public PolylineOptions zIndex(int i2) {
        this.f7025a = i2;
        return this;
    }
}
