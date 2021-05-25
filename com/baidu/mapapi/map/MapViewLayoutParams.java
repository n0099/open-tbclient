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
    public LatLng f6924a;

    /* renamed from: b  reason: collision with root package name */
    public Point f6925b;

    /* renamed from: c  reason: collision with root package name */
    public ELayoutMode f6926c;

    /* renamed from: d  reason: collision with root package name */
    public float f6927d;

    /* renamed from: e  reason: collision with root package name */
    public float f6928e;

    /* renamed from: f  reason: collision with root package name */
    public int f6929f;

    /* loaded from: classes2.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        public int f6930a;

        /* renamed from: b  reason: collision with root package name */
        public int f6931b;

        /* renamed from: c  reason: collision with root package name */
        public LatLng f6932c;

        /* renamed from: d  reason: collision with root package name */
        public Point f6933d;

        /* renamed from: e  reason: collision with root package name */
        public ELayoutMode f6934e = ELayoutMode.absoluteMode;

        /* renamed from: f  reason: collision with root package name */
        public int f6935f = 4;

        /* renamed from: g  reason: collision with root package name */
        public int f6936g = 16;

        /* renamed from: h  reason: collision with root package name */
        public int f6937h;

        public Builder align(int i2, int i3) {
            if (i2 == 1 || i2 == 2 || i2 == 4) {
                this.f6935f = i2;
            }
            if (i3 == 8 || i3 == 16 || i3 == 32) {
                this.f6936g = i3;
            }
            return this;
        }

        public MapViewLayoutParams build() {
            ELayoutMode eLayoutMode = this.f6934e;
            boolean z = true;
            if (eLayoutMode != ELayoutMode.mapMode ? eLayoutMode != ELayoutMode.absoluteMode || this.f6933d != null : this.f6932c != null) {
                z = false;
            }
            if (z) {
                throw new IllegalStateException("BDMapSDKException: if it is map mode, you must supply position info; else if it is absolute mode, you must supply the point info");
            }
            return new MapViewLayoutParams(this.f6930a, this.f6931b, this.f6932c, this.f6933d, this.f6934e, this.f6935f, this.f6936g, this.f6937h);
        }

        public Builder height(int i2) {
            this.f6931b = i2;
            return this;
        }

        public Builder layoutMode(ELayoutMode eLayoutMode) {
            this.f6934e = eLayoutMode;
            return this;
        }

        public Builder point(Point point) {
            this.f6933d = point;
            return this;
        }

        public Builder position(LatLng latLng) {
            this.f6932c = latLng;
            return this;
        }

        public Builder width(int i2) {
            this.f6930a = i2;
            return this;
        }

        public Builder yOffset(int i2) {
            this.f6937h = i2;
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
        this.f6924a = latLng;
        this.f6925b = point;
        this.f6926c = eLayoutMode;
        if (i4 == 1) {
            this.f6927d = 0.0f;
        } else if (i4 != 2) {
            this.f6927d = 0.5f;
        } else {
            this.f6927d = 1.0f;
        }
        if (i5 == 8) {
            this.f6928e = 0.0f;
        } else if (i5 == 16 || i5 != 32) {
            this.f6928e = 1.0f;
        } else {
            this.f6928e = 0.5f;
        }
        this.f6929f = i6;
    }
}
