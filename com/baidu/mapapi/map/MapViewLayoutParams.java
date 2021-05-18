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

    /* renamed from: a  reason: collision with root package name */
    public LatLng f7024a;

    /* renamed from: b  reason: collision with root package name */
    public Point f7025b;

    /* renamed from: c  reason: collision with root package name */
    public ELayoutMode f7026c;

    /* renamed from: d  reason: collision with root package name */
    public float f7027d;

    /* renamed from: e  reason: collision with root package name */
    public float f7028e;

    /* renamed from: f  reason: collision with root package name */
    public int f7029f;

    /* loaded from: classes2.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        public int f7030a;

        /* renamed from: b  reason: collision with root package name */
        public int f7031b;

        /* renamed from: c  reason: collision with root package name */
        public LatLng f7032c;

        /* renamed from: d  reason: collision with root package name */
        public Point f7033d;

        /* renamed from: e  reason: collision with root package name */
        public ELayoutMode f7034e = ELayoutMode.absoluteMode;

        /* renamed from: f  reason: collision with root package name */
        public int f7035f = 4;

        /* renamed from: g  reason: collision with root package name */
        public int f7036g = 16;

        /* renamed from: h  reason: collision with root package name */
        public int f7037h;

        public Builder align(int i2, int i3) {
            if (i2 == 1 || i2 == 2 || i2 == 4) {
                this.f7035f = i2;
            }
            if (i3 == 8 || i3 == 16 || i3 == 32) {
                this.f7036g = i3;
            }
            return this;
        }

        public MapViewLayoutParams build() {
            ELayoutMode eLayoutMode = this.f7034e;
            boolean z = true;
            if (eLayoutMode != ELayoutMode.mapMode ? eLayoutMode != ELayoutMode.absoluteMode || this.f7033d != null : this.f7032c != null) {
                z = false;
            }
            if (z) {
                throw new IllegalStateException("BDMapSDKException: if it is map mode, you must supply position info; else if it is absolute mode, you must supply the point info");
            }
            return new MapViewLayoutParams(this.f7030a, this.f7031b, this.f7032c, this.f7033d, this.f7034e, this.f7035f, this.f7036g, this.f7037h);
        }

        public Builder height(int i2) {
            this.f7031b = i2;
            return this;
        }

        public Builder layoutMode(ELayoutMode eLayoutMode) {
            this.f7034e = eLayoutMode;
            return this;
        }

        public Builder point(Point point) {
            this.f7033d = point;
            return this;
        }

        public Builder position(LatLng latLng) {
            this.f7032c = latLng;
            return this;
        }

        public Builder width(int i2) {
            this.f7030a = i2;
            return this;
        }

        public Builder yOffset(int i2) {
            this.f7037h = i2;
            return this;
        }
    }

    /* loaded from: classes2.dex */
    public enum ELayoutMode {
        mapMode,
        absoluteMode
    }

    public MapViewLayoutParams(int i2, int i3, LatLng latLng, Point point, ELayoutMode eLayoutMode, int i4, int i5, int i6) {
        super(i2, i3);
        this.f7024a = latLng;
        this.f7025b = point;
        this.f7026c = eLayoutMode;
        if (i4 == 1) {
            this.f7027d = 0.0f;
        } else if (i4 != 2) {
            this.f7027d = 0.5f;
        } else {
            this.f7027d = 1.0f;
        }
        if (i5 == 8) {
            this.f7028e = 0.0f;
        } else if (i5 == 16 || i5 != 32) {
            this.f7028e = 1.0f;
        } else {
            this.f7028e = 0.5f;
        }
        this.f7029f = i6;
    }
}
