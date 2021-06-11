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
    public LatLng f6967a;

    /* renamed from: b  reason: collision with root package name */
    public Point f6968b;

    /* renamed from: c  reason: collision with root package name */
    public ELayoutMode f6969c;

    /* renamed from: d  reason: collision with root package name */
    public float f6970d;

    /* renamed from: e  reason: collision with root package name */
    public float f6971e;

    /* renamed from: f  reason: collision with root package name */
    public int f6972f;

    /* loaded from: classes2.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        public int f6973a;

        /* renamed from: b  reason: collision with root package name */
        public int f6974b;

        /* renamed from: c  reason: collision with root package name */
        public LatLng f6975c;

        /* renamed from: d  reason: collision with root package name */
        public Point f6976d;

        /* renamed from: e  reason: collision with root package name */
        public ELayoutMode f6977e = ELayoutMode.absoluteMode;

        /* renamed from: f  reason: collision with root package name */
        public int f6978f = 4;

        /* renamed from: g  reason: collision with root package name */
        public int f6979g = 16;

        /* renamed from: h  reason: collision with root package name */
        public int f6980h;

        public Builder align(int i2, int i3) {
            if (i2 == 1 || i2 == 2 || i2 == 4) {
                this.f6978f = i2;
            }
            if (i3 == 8 || i3 == 16 || i3 == 32) {
                this.f6979g = i3;
            }
            return this;
        }

        public MapViewLayoutParams build() {
            ELayoutMode eLayoutMode = this.f6977e;
            boolean z = true;
            if (eLayoutMode != ELayoutMode.mapMode ? eLayoutMode != ELayoutMode.absoluteMode || this.f6976d != null : this.f6975c != null) {
                z = false;
            }
            if (z) {
                throw new IllegalStateException("BDMapSDKException: if it is map mode, you must supply position info; else if it is absolute mode, you must supply the point info");
            }
            return new MapViewLayoutParams(this.f6973a, this.f6974b, this.f6975c, this.f6976d, this.f6977e, this.f6978f, this.f6979g, this.f6980h);
        }

        public Builder height(int i2) {
            this.f6974b = i2;
            return this;
        }

        public Builder layoutMode(ELayoutMode eLayoutMode) {
            this.f6977e = eLayoutMode;
            return this;
        }

        public Builder point(Point point) {
            this.f6976d = point;
            return this;
        }

        public Builder position(LatLng latLng) {
            this.f6975c = latLng;
            return this;
        }

        public Builder width(int i2) {
            this.f6973a = i2;
            return this;
        }

        public Builder yOffset(int i2) {
            this.f6980h = i2;
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
        this.f6967a = latLng;
        this.f6968b = point;
        this.f6969c = eLayoutMode;
        if (i4 == 1) {
            this.f6970d = 0.0f;
        } else if (i4 != 2) {
            this.f6970d = 0.5f;
        } else {
            this.f6970d = 1.0f;
        }
        if (i5 == 8) {
            this.f6971e = 0.0f;
        } else if (i5 == 16 || i5 != 32) {
            this.f6971e = 1.0f;
        } else {
            this.f6971e = 0.5f;
        }
        this.f6972f = i6;
    }
}
