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

    /* renamed from: c  reason: collision with root package name */
    public Bundle f6984c;

    /* renamed from: e  reason: collision with root package name */
    public List<LatLng> f6986e;

    /* renamed from: f  reason: collision with root package name */
    public List<Integer> f6987f;

    /* renamed from: g  reason: collision with root package name */
    public List<Integer> f6988g;

    /* renamed from: i  reason: collision with root package name */
    public BitmapDescriptor f6990i;
    public List<BitmapDescriptor> j;

    /* renamed from: d  reason: collision with root package name */
    public int f6985d = -16777216;

    /* renamed from: h  reason: collision with root package name */
    public int f6989h = 5;
    public boolean k = true;
    public boolean l = false;

    /* renamed from: b  reason: collision with root package name */
    public boolean f6983b = true;
    public boolean m = false;

    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay a() {
        Polyline polyline = new Polyline();
        polyline.A = this.f6983b;
        polyline.f6978f = this.m;
        polyline.z = this.f6982a;
        polyline.B = this.f6984c;
        List<LatLng> list = this.f6986e;
        if (list == null || list.size() < 2) {
            throw new IllegalStateException("BDMapSDKException: when you add polyline, you must at least supply 2 points");
        }
        polyline.f6974b = this.f6986e;
        polyline.f6973a = this.f6985d;
        polyline.f6977e = this.f6989h;
        polyline.f6981i = this.f6990i;
        polyline.j = this.j;
        polyline.f6979g = this.k;
        polyline.f6980h = this.l;
        List<Integer> list2 = this.f6987f;
        if (list2 != null && list2.size() < this.f6986e.size() - 1) {
            ArrayList arrayList = new ArrayList((this.f6986e.size() - 1) - this.f6987f.size());
            List<Integer> list3 = this.f6987f;
            list3.addAll(list3.size(), arrayList);
        }
        List<Integer> list4 = this.f6987f;
        int i2 = 0;
        if (list4 != null && list4.size() > 0) {
            int[] iArr = new int[this.f6987f.size()];
            int i3 = 0;
            for (Integer num : this.f6987f) {
                iArr[i3] = num.intValue();
                i3++;
            }
            polyline.f6975c = iArr;
        }
        List<Integer> list5 = this.f6988g;
        if (list5 != null && list5.size() < this.f6986e.size() - 1) {
            ArrayList arrayList2 = new ArrayList((this.f6986e.size() - 1) - this.f6988g.size());
            List<Integer> list6 = this.f6988g;
            list6.addAll(list6.size(), arrayList2);
        }
        List<Integer> list7 = this.f6988g;
        if (list7 != null && list7.size() > 0) {
            int[] iArr2 = new int[this.f6988g.size()];
            for (Integer num2 : this.f6988g) {
                iArr2[i2] = num2.intValue();
                i2++;
            }
            polyline.f6976d = iArr2;
        }
        return polyline;
    }

    public PolylineOptions color(int i2) {
        this.f6985d = i2;
        return this;
    }

    public PolylineOptions colorsValues(List<Integer> list) {
        if (list != null) {
            if (list.contains(null)) {
                throw new IllegalArgumentException("BDMapSDKException: colors list can not contains null");
            }
            this.f6988g = list;
            return this;
        }
        throw new IllegalArgumentException("BDMapSDKException: colors list can not be null");
    }

    public PolylineOptions customTexture(BitmapDescriptor bitmapDescriptor) {
        this.f6990i = bitmapDescriptor;
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
        this.f6984c = bundle;
        return this;
    }

    public PolylineOptions focus(boolean z) {
        this.k = z;
        return this;
    }

    public int getColor() {
        return this.f6985d;
    }

    public BitmapDescriptor getCustomTexture() {
        return this.f6990i;
    }

    public List<BitmapDescriptor> getCustomTextureList() {
        return this.j;
    }

    public Bundle getExtraInfo() {
        return this.f6984c;
    }

    public List<LatLng> getPoints() {
        return this.f6986e;
    }

    public List<Integer> getTextureIndexs() {
        return this.f6987f;
    }

    public int getWidth() {
        return this.f6989h;
    }

    public int getZIndex() {
        return this.f6982a;
    }

    public boolean isDottedLine() {
        return this.m;
    }

    public boolean isFocus() {
        return this.k;
    }

    public boolean isVisible() {
        return this.f6983b;
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
                this.f6986e = list;
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
            this.f6987f = list;
            return this;
        }
        throw new IllegalArgumentException("BDMapSDKException: indexs list can not be null");
    }

    public PolylineOptions visible(boolean z) {
        this.f6983b = z;
        return this;
    }

    public PolylineOptions width(int i2) {
        if (i2 > 0) {
            this.f6989h = i2;
        }
        return this;
    }

    public PolylineOptions zIndex(int i2) {
        this.f6982a = i2;
        return this;
    }
}
