package com.baidu.mapapi.map;

import android.os.Bundle;
import android.util.Log;
import com.baidu.mapapi.model.LatLng;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public final class PolylineOptions extends OverlayOptions {

    /* renamed from: a  reason: collision with root package name */
    public int f6982a;

    /* renamed from: d  reason: collision with root package name */
    public Bundle f6985d;

    /* renamed from: f  reason: collision with root package name */
    public List<LatLng> f6987f;

    /* renamed from: g  reason: collision with root package name */
    public List<Integer> f6988g;

    /* renamed from: h  reason: collision with root package name */
    public List<Integer> f6989h;
    public BitmapDescriptor j;
    public List<BitmapDescriptor> k;

    /* renamed from: e  reason: collision with root package name */
    public int f6986e = -16777216;
    public int i = 5;
    public boolean l = true;
    public boolean m = false;

    /* renamed from: b  reason: collision with root package name */
    public boolean f6983b = true;

    /* renamed from: c  reason: collision with root package name */
    public boolean f6984c = false;

    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay a() {
        Polyline polyline = new Polyline();
        polyline.x = this.f6983b;
        polyline.f6979f = this.f6984c;
        polyline.w = this.f6982a;
        polyline.y = this.f6985d;
        List<LatLng> list = this.f6987f;
        if (list == null || list.size() < 2) {
            throw new IllegalStateException("when you add polyline, you must at least supply 2 points");
        }
        polyline.f6975b = this.f6987f;
        polyline.f6974a = this.f6986e;
        polyline.f6978e = this.i;
        polyline.i = this.j;
        polyline.j = this.k;
        polyline.f6980g = this.l;
        polyline.f6981h = this.m;
        List<Integer> list2 = this.f6988g;
        if (list2 != null && list2.size() < this.f6987f.size() - 1) {
            ArrayList arrayList = new ArrayList((this.f6987f.size() - 1) - this.f6988g.size());
            List<Integer> list3 = this.f6988g;
            list3.addAll(list3.size(), arrayList);
        }
        List<Integer> list4 = this.f6988g;
        int i = 0;
        if (list4 != null && list4.size() > 0) {
            int[] iArr = new int[this.f6988g.size()];
            int i2 = 0;
            for (Integer num : this.f6988g) {
                iArr[i2] = num.intValue();
                i2++;
            }
            polyline.f6976c = iArr;
        }
        List<Integer> list5 = this.f6989h;
        if (list5 != null && list5.size() < this.f6987f.size() - 1) {
            ArrayList arrayList2 = new ArrayList((this.f6987f.size() - 1) - this.f6989h.size());
            List<Integer> list6 = this.f6989h;
            list6.addAll(list6.size(), arrayList2);
        }
        List<Integer> list7 = this.f6989h;
        if (list7 != null && list7.size() > 0) {
            int[] iArr2 = new int[this.f6989h.size()];
            for (Integer num2 : this.f6989h) {
                iArr2[i] = num2.intValue();
                i++;
            }
            polyline.f6977d = iArr2;
        }
        return polyline;
    }

    public PolylineOptions color(int i) {
        this.f6986e = i;
        return this;
    }

    public PolylineOptions colorsValues(List<Integer> list) {
        if (list != null) {
            if (list.contains(null)) {
                throw new IllegalArgumentException("colors list can not contains null");
            }
            this.f6989h = list;
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
        this.f6984c = z;
        return this;
    }

    public PolylineOptions extraInfo(Bundle bundle) {
        this.f6985d = bundle;
        return this;
    }

    public PolylineOptions focus(boolean z) {
        this.l = z;
        return this;
    }

    public int getColor() {
        return this.f6986e;
    }

    public BitmapDescriptor getCustomTexture() {
        return this.j;
    }

    public List<BitmapDescriptor> getCustomTextureList() {
        return this.k;
    }

    public Bundle getExtraInfo() {
        return this.f6985d;
    }

    public List<LatLng> getPoints() {
        return this.f6987f;
    }

    public List<Integer> getTextureIndexs() {
        return this.f6988g;
    }

    public int getWidth() {
        return this.i;
    }

    public int getZIndex() {
        return this.f6982a;
    }

    public boolean isDottedLine() {
        return this.f6984c;
    }

    public boolean isFocus() {
        return this.l;
    }

    public boolean isVisible() {
        return this.f6983b;
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
                this.f6987f = list;
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
            this.f6988g = list;
            return this;
        }
        throw new IllegalArgumentException("indexs list can not be null");
    }

    public PolylineOptions visible(boolean z) {
        this.f6983b = z;
        return this;
    }

    public PolylineOptions width(int i) {
        if (i > 0) {
            this.i = i;
        }
        return this;
    }

    public PolylineOptions zIndex(int i) {
        this.f6982a = i;
        return this;
    }
}
