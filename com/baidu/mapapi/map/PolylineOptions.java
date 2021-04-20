package com.baidu.mapapi.map;

import android.os.Bundle;
import android.util.Log;
import com.baidu.mapapi.model.LatLng;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public final class PolylineOptions extends OverlayOptions {

    /* renamed from: a  reason: collision with root package name */
    public int f7018a;

    /* renamed from: d  reason: collision with root package name */
    public Bundle f7021d;

    /* renamed from: f  reason: collision with root package name */
    public List<LatLng> f7023f;

    /* renamed from: g  reason: collision with root package name */
    public List<Integer> f7024g;

    /* renamed from: h  reason: collision with root package name */
    public List<Integer> f7025h;
    public BitmapDescriptor j;
    public List<BitmapDescriptor> k;

    /* renamed from: e  reason: collision with root package name */
    public int f7022e = -16777216;
    public int i = 5;
    public boolean l = true;
    public boolean m = false;

    /* renamed from: b  reason: collision with root package name */
    public boolean f7019b = true;

    /* renamed from: c  reason: collision with root package name */
    public boolean f7020c = false;

    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay a() {
        Polyline polyline = new Polyline();
        polyline.x = this.f7019b;
        polyline.f7015f = this.f7020c;
        polyline.w = this.f7018a;
        polyline.y = this.f7021d;
        List<LatLng> list = this.f7023f;
        if (list == null || list.size() < 2) {
            throw new IllegalStateException("when you add polyline, you must at least supply 2 points");
        }
        polyline.f7011b = this.f7023f;
        polyline.f7010a = this.f7022e;
        polyline.f7014e = this.i;
        polyline.i = this.j;
        polyline.j = this.k;
        polyline.f7016g = this.l;
        polyline.f7017h = this.m;
        List<Integer> list2 = this.f7024g;
        if (list2 != null && list2.size() < this.f7023f.size() - 1) {
            ArrayList arrayList = new ArrayList((this.f7023f.size() - 1) - this.f7024g.size());
            List<Integer> list3 = this.f7024g;
            list3.addAll(list3.size(), arrayList);
        }
        List<Integer> list4 = this.f7024g;
        int i = 0;
        if (list4 != null && list4.size() > 0) {
            int[] iArr = new int[this.f7024g.size()];
            int i2 = 0;
            for (Integer num : this.f7024g) {
                iArr[i2] = num.intValue();
                i2++;
            }
            polyline.f7012c = iArr;
        }
        List<Integer> list5 = this.f7025h;
        if (list5 != null && list5.size() < this.f7023f.size() - 1) {
            ArrayList arrayList2 = new ArrayList((this.f7023f.size() - 1) - this.f7025h.size());
            List<Integer> list6 = this.f7025h;
            list6.addAll(list6.size(), arrayList2);
        }
        List<Integer> list7 = this.f7025h;
        if (list7 != null && list7.size() > 0) {
            int[] iArr2 = new int[this.f7025h.size()];
            for (Integer num2 : this.f7025h) {
                iArr2[i] = num2.intValue();
                i++;
            }
            polyline.f7013d = iArr2;
        }
        return polyline;
    }

    public PolylineOptions color(int i) {
        this.f7022e = i;
        return this;
    }

    public PolylineOptions colorsValues(List<Integer> list) {
        if (list != null) {
            if (list.contains(null)) {
                throw new IllegalArgumentException("colors list can not contains null");
            }
            this.f7025h = list;
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
        this.f7020c = z;
        return this;
    }

    public PolylineOptions extraInfo(Bundle bundle) {
        this.f7021d = bundle;
        return this;
    }

    public PolylineOptions focus(boolean z) {
        this.l = z;
        return this;
    }

    public int getColor() {
        return this.f7022e;
    }

    public BitmapDescriptor getCustomTexture() {
        return this.j;
    }

    public List<BitmapDescriptor> getCustomTextureList() {
        return this.k;
    }

    public Bundle getExtraInfo() {
        return this.f7021d;
    }

    public List<LatLng> getPoints() {
        return this.f7023f;
    }

    public List<Integer> getTextureIndexs() {
        return this.f7024g;
    }

    public int getWidth() {
        return this.i;
    }

    public int getZIndex() {
        return this.f7018a;
    }

    public boolean isDottedLine() {
        return this.f7020c;
    }

    public boolean isFocus() {
        return this.l;
    }

    public boolean isVisible() {
        return this.f7019b;
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
                this.f7023f = list;
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
            this.f7024g = list;
            return this;
        }
        throw new IllegalArgumentException("indexs list can not be null");
    }

    public PolylineOptions visible(boolean z) {
        this.f7019b = z;
        return this;
    }

    public PolylineOptions width(int i) {
        if (i > 0) {
            this.i = i;
        }
        return this;
    }

    public PolylineOptions zIndex(int i) {
        this.f7018a = i;
        return this;
    }
}
