package com.baidu.mapapi.map;

import android.graphics.Point;
import android.view.ViewGroup;
import com.baidu.mapapi.model.LatLng;
/* loaded from: classes2.dex */
public final class MapViewLayoutParams extends ViewGroup.LayoutParams {
    public static final int ALIGN_BOTTOM = 16;
    public static final int ALIGN_CENTER_HORIZONTAL = 4;
    public static final int ALIGN_CENTER_VERTICAL = 32;
    public static final int ALIGN_LEFT = 1;
    public static final int ALIGN_RIGHT = 2;
    public static final int ALIGN_TOP = 8;
    public LatLng a;
    public Point b;
    public ELayoutMode c;
    public float d;
    public float e;
    public int f;

    /* loaded from: classes2.dex */
    public enum ELayoutMode {
        mapMode,
        absoluteMode
    }

    public MapViewLayoutParams(int i, int i2, LatLng latLng, Point point, ELayoutMode eLayoutMode, int i3, int i4, int i5) {
        super(i, i2);
        this.a = latLng;
        this.b = point;
        this.c = eLayoutMode;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 4) {
                    this.d = 0.5f;
                } else {
                    this.d = 0.5f;
                }
            } else {
                this.d = 1.0f;
            }
        } else {
            this.d = 0.0f;
        }
        if (i4 != 8) {
            if (i4 != 16) {
                if (i4 != 32) {
                    this.e = 1.0f;
                } else {
                    this.e = 0.5f;
                }
            } else {
                this.e = 1.0f;
            }
        } else {
            this.e = 0.0f;
        }
        this.f = i5;
    }

    /* loaded from: classes2.dex */
    public static final class Builder {
        public int a;
        public int b;
        public LatLng c;
        public Point d;
        public ELayoutMode e = ELayoutMode.absoluteMode;
        public int f = 4;
        public int g = 16;
        public int h;

        public Builder align(int i, int i2) {
            if (i == 1 || i == 2 || i == 4) {
                this.f = i;
            }
            if (i2 == 8 || i2 == 16 || i2 == 32) {
                this.g = i2;
            }
            return this;
        }

        public MapViewLayoutParams build() {
            ELayoutMode eLayoutMode = this.e;
            boolean z = true;
            if (eLayoutMode != ELayoutMode.mapMode ? eLayoutMode != ELayoutMode.absoluteMode || this.d != null : this.c != null) {
                z = false;
            }
            if (!z) {
                return new MapViewLayoutParams(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h);
            }
            throw new IllegalStateException("BDMapSDKException: if it is map mode, you must supply position info; else if it is absolute mode, you must supply the point info");
        }

        public Builder height(int i) {
            this.b = i;
            return this;
        }

        public Builder layoutMode(ELayoutMode eLayoutMode) {
            this.e = eLayoutMode;
            return this;
        }

        public Builder point(Point point) {
            this.d = point;
            return this;
        }

        public Builder position(LatLng latLng) {
            this.c = latLng;
            return this;
        }

        public Builder width(int i) {
            this.a = i;
            return this;
        }

        public Builder yOffset(int i) {
            this.h = i;
            return this;
        }
    }
}
