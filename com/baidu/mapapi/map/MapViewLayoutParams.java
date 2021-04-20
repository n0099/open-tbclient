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
    public LatLng f6963a;

    /* renamed from: b  reason: collision with root package name */
    public Point f6964b;

    /* renamed from: c  reason: collision with root package name */
    public ELayoutMode f6965c;

    /* renamed from: d  reason: collision with root package name */
    public float f6966d;

    /* renamed from: e  reason: collision with root package name */
    public float f6967e;

    /* renamed from: f  reason: collision with root package name */
    public int f6968f;

    /* loaded from: classes2.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        public int f6969a;

        /* renamed from: b  reason: collision with root package name */
        public int f6970b;

        /* renamed from: c  reason: collision with root package name */
        public LatLng f6971c;

        /* renamed from: d  reason: collision with root package name */
        public Point f6972d;

        /* renamed from: e  reason: collision with root package name */
        public ELayoutMode f6973e = ELayoutMode.absoluteMode;

        /* renamed from: f  reason: collision with root package name */
        public int f6974f = 4;

        /* renamed from: g  reason: collision with root package name */
        public int f6975g = 16;

        /* renamed from: h  reason: collision with root package name */
        public int f6976h;

        public Builder align(int i, int i2) {
            if (i == 1 || i == 2 || i == 4) {
                this.f6974f = i;
            }
            if (i2 == 8 || i2 == 16 || i2 == 32) {
                this.f6975g = i2;
            }
            return this;
        }

        public MapViewLayoutParams build() {
            ELayoutMode eLayoutMode = this.f6973e;
            boolean z = true;
            if (eLayoutMode != ELayoutMode.mapMode ? eLayoutMode != ELayoutMode.absoluteMode || this.f6972d != null : this.f6971c != null) {
                z = false;
            }
            if (z) {
                throw new IllegalStateException("if it is map mode, you must supply position info; else if it is absolute mode, you must supply the point info");
            }
            return new MapViewLayoutParams(this.f6969a, this.f6970b, this.f6971c, this.f6972d, this.f6973e, this.f6974f, this.f6975g, this.f6976h);
        }

        public Builder height(int i) {
            this.f6970b = i;
            return this;
        }

        public Builder layoutMode(ELayoutMode eLayoutMode) {
            this.f6973e = eLayoutMode;
            return this;
        }

        public Builder point(Point point) {
            this.f6972d = point;
            return this;
        }

        public Builder position(LatLng latLng) {
            this.f6971c = latLng;
            return this;
        }

        public Builder width(int i) {
            this.f6969a = i;
            return this;
        }

        public Builder yOffset(int i) {
            this.f6976h = i;
            return this;
        }
    }

    /* loaded from: classes2.dex */
    public enum ELayoutMode {
        mapMode,
        absoluteMode
    }

    public MapViewLayoutParams(int i, int i2, LatLng latLng, Point point, ELayoutMode eLayoutMode, int i3, int i4, int i5) {
        super(i, i2);
        this.f6963a = latLng;
        this.f6964b = point;
        this.f6965c = eLayoutMode;
        if (i3 == 1) {
            this.f6966d = 0.0f;
        } else if (i3 != 2) {
            this.f6966d = 0.5f;
        } else {
            this.f6966d = 1.0f;
        }
        if (i4 == 8) {
            this.f6967e = 0.0f;
        } else if (i4 == 16 || i4 != 32) {
            this.f6967e = 1.0f;
        } else {
            this.f6967e = 0.5f;
        }
        this.f6968f = i5;
    }
}
