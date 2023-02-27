package com.baidu.mapapi.map;

import java.util.List;
/* loaded from: classes2.dex */
public final class MultiPointOption extends OverlayOptions {
    public List<MultiPointItem> a;
    public BitmapDescriptor b;
    public int c;
    public int d;
    public float e = 0.5f;
    public float f = 0.5f;
    public boolean g = true;

    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay a() {
        MultiPoint multiPoint = new MultiPoint();
        multiPoint.b = this.b;
        List<MultiPointItem> list = this.a;
        if (list != null) {
            multiPoint.a = list;
            multiPoint.d = this.d;
            multiPoint.c = this.c;
            multiPoint.e = this.e;
            multiPoint.f = this.f;
            multiPoint.H = this.g;
            return multiPoint;
        }
        throw new IllegalStateException("BDMapSDKException: when you add mMultiPointItems, you must set the mMultiPointItems");
    }

    public float getAnchorX() {
        return this.e;
    }

    public float getAnchorY() {
        return this.f;
    }

    public BitmapDescriptor getIcon() {
        return this.b;
    }

    public List<MultiPointItem> getMultiPointItems() {
        return this.a;
    }

    public int getPointSizeHeight() {
        return this.d;
    }

    public int getPointSizeWidth() {
        return this.c;
    }

    public boolean isVisible() {
        return this.g;
    }

    public MultiPointOption setAnchor(float f, float f2) {
        if (f >= 0.0f && f <= 1.0f && f2 >= 0.0f && f2 <= 1.0f) {
            this.e = f;
            this.f = f2;
        }
        return this;
    }

    public MultiPointOption setPointSize(int i, int i2) {
        if (this.c > 0 && this.d > 0) {
            this.c = i;
            this.d = i2;
            return this;
        }
        throw new IllegalArgumentException("BDMapSDKException: MultiPoint setPointSize can not be 0 Or can't less than 0");
    }

    public MultiPointOption setIcon(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor != null) {
            if (this.c == 0) {
                this.c = bitmapDescriptor.getBitmap().getWidth();
            }
            if (this.d == 0) {
                this.d = bitmapDescriptor.getBitmap().getHeight();
            }
            this.b = bitmapDescriptor;
            return this;
        }
        throw new IllegalArgumentException("BDMapSDKException: MultiPoint icon can not be null");
    }

    public MultiPointOption setMultiPointItems(List<MultiPointItem> list) {
        if (list != null) {
            if (!list.contains(null)) {
                this.a = list;
                return this;
            }
            throw new IllegalArgumentException("BDMapSDKException: multiPointItems list can not contains null");
        }
        throw new IllegalArgumentException("BDMapSDKException: multiPointItems list can not be null");
    }

    public MultiPointOption visible(boolean z) {
        this.g = z;
        return this;
    }
}
