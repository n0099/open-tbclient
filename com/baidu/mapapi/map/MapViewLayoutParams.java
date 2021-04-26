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
    public LatLng f7208a;

    /* renamed from: b  reason: collision with root package name */
    public Point f7209b;

    /* renamed from: c  reason: collision with root package name */
    public ELayoutMode f7210c;

    /* renamed from: d  reason: collision with root package name */
    public float f7211d;

    /* renamed from: e  reason: collision with root package name */
    public float f7212e;

    /* renamed from: f  reason: collision with root package name */
    public int f7213f;

    /* loaded from: classes2.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        public int f7214a;

        /* renamed from: b  reason: collision with root package name */
        public int f7215b;

        /* renamed from: c  reason: collision with root package name */
        public LatLng f7216c;

        /* renamed from: d  reason: collision with root package name */
        public Point f7217d;

        /* renamed from: e  reason: collision with root package name */
        public ELayoutMode f7218e = ELayoutMode.absoluteMode;

        /* renamed from: f  reason: collision with root package name */
        public int f7219f = 4;

        /* renamed from: g  reason: collision with root package name */
        public int f7220g = 16;

        /* renamed from: h  reason: collision with root package name */
        public int f7221h;

        public Builder align(int i2, int i3) {
            if (i2 == 1 || i2 == 2 || i2 == 4) {
                this.f7219f = i2;
            }
            if (i3 == 8 || i3 == 16 || i3 == 32) {
                this.f7220g = i3;
            }
            return this;
        }

        public MapViewLayoutParams build() {
            ELayoutMode eLayoutMode = this.f7218e;
            boolean z = true;
            if (eLayoutMode != ELayoutMode.mapMode ? eLayoutMode != ELayoutMode.absoluteMode || this.f7217d != null : this.f7216c != null) {
                z = false;
            }
            if (z) {
                throw new IllegalStateException("if it is map mode, you must supply position info; else if it is absolute mode, you must supply the point info");
            }
            return new MapViewLayoutParams(this.f7214a, this.f7215b, this.f7216c, this.f7217d, this.f7218e, this.f7219f, this.f7220g, this.f7221h);
        }

        public Builder height(int i2) {
            this.f7215b = i2;
            return this;
        }

        public Builder layoutMode(ELayoutMode eLayoutMode) {
            this.f7218e = eLayoutMode;
            return this;
        }

        public Builder point(Point point) {
            this.f7217d = point;
            return this;
        }

        public Builder position(LatLng latLng) {
            this.f7216c = latLng;
            return this;
        }

        public Builder width(int i2) {
            this.f7214a = i2;
            return this;
        }

        public Builder yOffset(int i2) {
            this.f7221h = i2;
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
        this.f7208a = latLng;
        this.f7209b = point;
        this.f7210c = eLayoutMode;
        if (i4 == 1) {
            this.f7211d = 0.0f;
        } else if (i4 != 2) {
            this.f7211d = 0.5f;
        } else {
            this.f7211d = 1.0f;
        }
        if (i5 == 8) {
            this.f7212e = 0.0f;
        } else if (i5 == 16 || i5 != 32) {
            this.f7212e = 1.0f;
        } else {
            this.f7212e = 0.5f;
        }
        this.f7213f = i6;
    }
}
