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
    public LatLng f6927a;

    /* renamed from: b  reason: collision with root package name */
    public Point f6928b;

    /* renamed from: c  reason: collision with root package name */
    public ELayoutMode f6929c;

    /* renamed from: d  reason: collision with root package name */
    public float f6930d;

    /* renamed from: e  reason: collision with root package name */
    public float f6931e;

    /* renamed from: f  reason: collision with root package name */
    public int f6932f;

    /* loaded from: classes2.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        public int f6933a;

        /* renamed from: b  reason: collision with root package name */
        public int f6934b;

        /* renamed from: c  reason: collision with root package name */
        public LatLng f6935c;

        /* renamed from: d  reason: collision with root package name */
        public Point f6936d;

        /* renamed from: e  reason: collision with root package name */
        public ELayoutMode f6937e = ELayoutMode.absoluteMode;

        /* renamed from: f  reason: collision with root package name */
        public int f6938f = 4;

        /* renamed from: g  reason: collision with root package name */
        public int f6939g = 16;

        /* renamed from: h  reason: collision with root package name */
        public int f6940h;

        public Builder align(int i, int i2) {
            if (i == 1 || i == 2 || i == 4) {
                this.f6938f = i;
            }
            if (i2 == 8 || i2 == 16 || i2 == 32) {
                this.f6939g = i2;
            }
            return this;
        }

        public MapViewLayoutParams build() {
            ELayoutMode eLayoutMode = this.f6937e;
            boolean z = true;
            if (eLayoutMode != ELayoutMode.mapMode ? eLayoutMode != ELayoutMode.absoluteMode || this.f6936d != null : this.f6935c != null) {
                z = false;
            }
            if (z) {
                throw new IllegalStateException("if it is map mode, you must supply position info; else if it is absolute mode, you must supply the point info");
            }
            return new MapViewLayoutParams(this.f6933a, this.f6934b, this.f6935c, this.f6936d, this.f6937e, this.f6938f, this.f6939g, this.f6940h);
        }

        public Builder height(int i) {
            this.f6934b = i;
            return this;
        }

        public Builder layoutMode(ELayoutMode eLayoutMode) {
            this.f6937e = eLayoutMode;
            return this;
        }

        public Builder point(Point point) {
            this.f6936d = point;
            return this;
        }

        public Builder position(LatLng latLng) {
            this.f6935c = latLng;
            return this;
        }

        public Builder width(int i) {
            this.f6933a = i;
            return this;
        }

        public Builder yOffset(int i) {
            this.f6940h = i;
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
        this.f6927a = latLng;
        this.f6928b = point;
        this.f6929c = eLayoutMode;
        if (i3 == 1) {
            this.f6930d = 0.0f;
        } else if (i3 != 2) {
            this.f6930d = 0.5f;
        } else {
            this.f6930d = 1.0f;
        }
        if (i4 == 8) {
            this.f6931e = 0.0f;
        } else if (i4 == 16 || i4 != 32) {
            this.f6931e = 1.0f;
        } else {
            this.f6931e = 0.5f;
        }
        this.f6932f = i5;
    }
}
