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
    public LatLng f6928a;

    /* renamed from: b  reason: collision with root package name */
    public Point f6929b;

    /* renamed from: c  reason: collision with root package name */
    public ELayoutMode f6930c;

    /* renamed from: d  reason: collision with root package name */
    public float f6931d;

    /* renamed from: e  reason: collision with root package name */
    public float f6932e;

    /* renamed from: f  reason: collision with root package name */
    public int f6933f;

    /* loaded from: classes2.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        public int f6934a;

        /* renamed from: b  reason: collision with root package name */
        public int f6935b;

        /* renamed from: c  reason: collision with root package name */
        public LatLng f6936c;

        /* renamed from: d  reason: collision with root package name */
        public Point f6937d;

        /* renamed from: e  reason: collision with root package name */
        public ELayoutMode f6938e = ELayoutMode.absoluteMode;

        /* renamed from: f  reason: collision with root package name */
        public int f6939f = 4;

        /* renamed from: g  reason: collision with root package name */
        public int f6940g = 16;

        /* renamed from: h  reason: collision with root package name */
        public int f6941h;

        public Builder align(int i, int i2) {
            if (i == 1 || i == 2 || i == 4) {
                this.f6939f = i;
            }
            if (i2 == 8 || i2 == 16 || i2 == 32) {
                this.f6940g = i2;
            }
            return this;
        }

        public MapViewLayoutParams build() {
            ELayoutMode eLayoutMode = this.f6938e;
            boolean z = true;
            if (eLayoutMode != ELayoutMode.mapMode ? eLayoutMode != ELayoutMode.absoluteMode || this.f6937d != null : this.f6936c != null) {
                z = false;
            }
            if (z) {
                throw new IllegalStateException("if it is map mode, you must supply position info; else if it is absolute mode, you must supply the point info");
            }
            return new MapViewLayoutParams(this.f6934a, this.f6935b, this.f6936c, this.f6937d, this.f6938e, this.f6939f, this.f6940g, this.f6941h);
        }

        public Builder height(int i) {
            this.f6935b = i;
            return this;
        }

        public Builder layoutMode(ELayoutMode eLayoutMode) {
            this.f6938e = eLayoutMode;
            return this;
        }

        public Builder point(Point point) {
            this.f6937d = point;
            return this;
        }

        public Builder position(LatLng latLng) {
            this.f6936c = latLng;
            return this;
        }

        public Builder width(int i) {
            this.f6934a = i;
            return this;
        }

        public Builder yOffset(int i) {
            this.f6941h = i;
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
        this.f6928a = latLng;
        this.f6929b = point;
        this.f6930c = eLayoutMode;
        if (i3 == 1) {
            this.f6931d = 0.0f;
        } else if (i3 != 2) {
            this.f6931d = 0.5f;
        } else {
            this.f6931d = 1.0f;
        }
        if (i4 == 8) {
            this.f6932e = 0.0f;
        } else if (i4 == 16 || i4 != 32) {
            this.f6932e = 1.0f;
        } else {
            this.f6932e = 0.5f;
        }
        this.f6933f = i5;
    }
}
