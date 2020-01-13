package com.baidu.mapapi.map;

import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.util.Log;
import com.baidu.mapapi.model.LatLng;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public final class PolylineOptions extends OverlayOptions {
    int a;
    Bundle d;
    private List<LatLng> f;
    private List<Integer> g;
    private List<Integer> h;
    private BitmapDescriptor j;
    private List<BitmapDescriptor> k;
    private int e = ViewCompat.MEASURED_STATE_MASK;
    private int i = 5;
    private boolean l = true;
    private boolean m = false;
    boolean b = true;
    boolean c = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay a() {
        int i = 0;
        Polyline polyline = new Polyline();
        polyline.x = this.b;
        polyline.f = this.c;
        polyline.w = this.a;
        polyline.y = this.d;
        if (this.f == null || this.f.size() < 2) {
            throw new IllegalStateException("when you add polyline, you must at least supply 2 points");
        }
        polyline.b = this.f;
        polyline.a = this.e;
        polyline.e = this.i;
        polyline.i = this.j;
        polyline.j = this.k;
        polyline.g = this.l;
        polyline.h = this.m;
        if (this.g != null && this.g.size() < this.f.size() - 1) {
            this.g.addAll(this.g.size(), new ArrayList((this.f.size() - 1) - this.g.size()));
        }
        if (this.g != null && this.g.size() > 0) {
            int[] iArr = new int[this.g.size()];
            int i2 = 0;
            for (Integer num : this.g) {
                iArr[i2] = num.intValue();
                i2++;
            }
            polyline.c = iArr;
        }
        if (this.h != null && this.h.size() < this.f.size() - 1) {
            this.h.addAll(this.h.size(), new ArrayList((this.f.size() - 1) - this.h.size()));
        }
        if (this.h != null && this.h.size() > 0) {
            int[] iArr2 = new int[this.h.size()];
            for (Integer num2 : this.h) {
                iArr2[i] = num2.intValue();
                i++;
            }
            polyline.d = iArr2;
        }
        return polyline;
    }

    public PolylineOptions color(int i) {
        this.e = i;
        return this;
    }

    public PolylineOptions colorsValues(List<Integer> list) {
        if (list == null) {
            throw new IllegalArgumentException("colors list can not be null");
        }
        if (list.contains(null)) {
            throw new IllegalArgumentException("colors list can not contains null");
        }
        this.h = list;
        return this;
    }

    public PolylineOptions customTexture(BitmapDescriptor bitmapDescriptor) {
        this.j = bitmapDescriptor;
        return this;
    }

    public PolylineOptions customTextureList(List<BitmapDescriptor> list) {
        if (list == null) {
            throw new IllegalArgumentException("customTexture list can not be null");
        }
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

    public PolylineOptions dottedLine(boolean z) {
        this.c = z;
        return this;
    }

    public PolylineOptions extraInfo(Bundle bundle) {
        this.d = bundle;
        return this;
    }

    public PolylineOptions focus(boolean z) {
        this.l = z;
        return this;
    }

    public int getColor() {
        return this.e;
    }

    public BitmapDescriptor getCustomTexture() {
        return this.j;
    }

    public List<BitmapDescriptor> getCustomTextureList() {
        return this.k;
    }

    public Bundle getExtraInfo() {
        return this.d;
    }

    public List<LatLng> getPoints() {
        return this.f;
    }

    public List<Integer> getTextureIndexs() {
        return this.g;
    }

    public int getWidth() {
        return this.i;
    }

    public int getZIndex() {
        return this.a;
    }

    public boolean isDottedLine() {
        return this.c;
    }

    public boolean isFocus() {
        return this.l;
    }

    public boolean isVisible() {
        return this.b;
    }

    public PolylineOptions keepScale(boolean z) {
        this.m = z;
        return this;
    }

    public PolylineOptions points(List<LatLng> list) {
        if (list == null) {
            throw new IllegalArgumentException("points list can not be null");
        }
        if (list.size() < 2) {
            throw new IllegalArgumentException("points count can not less than 2");
        }
        if (list.contains(null)) {
            throw new IllegalArgumentException("points list can not contains null");
        }
        this.f = list;
        return this;
    }

    public PolylineOptions textureIndex(List<Integer> list) {
        if (list == null) {
            throw new IllegalArgumentException("indexs list can not be null");
        }
        if (list.contains(null)) {
            throw new IllegalArgumentException("index list can not contains null");
        }
        this.g = list;
        return this;
    }

    public PolylineOptions visible(boolean z) {
        this.b = z;
        return this;
    }

    public PolylineOptions width(int i) {
        if (i > 0) {
            this.i = i;
        }
        return this;
    }

    public PolylineOptions zIndex(int i) {
        this.a = i;
        return this;
    }
}
