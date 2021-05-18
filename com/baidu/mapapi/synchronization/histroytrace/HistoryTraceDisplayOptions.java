package com.baidu.mapapi.synchronization.histroytrace;

import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
/* loaded from: classes2.dex */
public class HistoryTraceDisplayOptions {
    public boolean j = true;
    public int k = 30;
    public int l = 30;
    public int m = 30;
    public int n = 30;

    /* renamed from: a  reason: collision with root package name */
    public BitmapDescriptor f7491a = BitmapDescriptorFactory.fromAssetWithDpi("SDK_Default_Icon_Start.png");

    /* renamed from: b  reason: collision with root package name */
    public BitmapDescriptor f7492b = BitmapDescriptorFactory.fromAssetWithDpi("SDK_Default_Icon_End.png");

    /* renamed from: c  reason: collision with root package name */
    public BitmapDescriptor f7493c = BitmapDescriptorFactory.fromAssetWithDpi("SDK_Default_Icon_Car.png");

    /* renamed from: d  reason: collision with root package name */
    public BitmapDescriptor f7494d = BitmapDescriptorFactory.fromAsset("SDK_Default_Route_Texture_Gray_Arrow.png");

    /* renamed from: e  reason: collision with root package name */
    public int f7495e = 22;

    /* renamed from: f  reason: collision with root package name */
    public boolean f7496f = true;

    /* renamed from: g  reason: collision with root package name */
    public boolean f7497g = true;

    /* renamed from: h  reason: collision with root package name */
    public boolean f7498h = false;

    /* renamed from: i  reason: collision with root package name */
    public boolean f7499i = true;

    public BitmapDescriptor getCarIcon() {
        return this.f7493c;
    }

    public BitmapDescriptor getEndPositionIcon() {
        return this.f7492b;
    }

    public int getPaddingBottom() {
        return this.n;
    }

    public int getPaddingLeft() {
        return this.k;
    }

    public int getPaddingRight() {
        return this.l;
    }

    public int getPaddingTop() {
        return this.m;
    }

    public BitmapDescriptor getRouteLineTexture() {
        return this.f7494d;
    }

    public int getRouteLineWidth() {
        return this.f7495e;
    }

    public BitmapDescriptor getStartPositionIcon() {
        return this.f7491a;
    }

    public boolean isRouteLineRenderBySubSection() {
        return this.j;
    }

    public boolean isShowCarIcon() {
        return this.f7498h;
    }

    public boolean isShowEndPositionIcon() {
        return this.f7497g;
    }

    public boolean isShowRoutePlan() {
        return this.f7499i;
    }

    public boolean isShowStartPositionIcon() {
        return this.f7496f;
    }

    public HistoryTraceDisplayOptions setCarIcon(BitmapDescriptor bitmapDescriptor) {
        this.f7493c = bitmapDescriptor;
        return this;
    }

    public HistoryTraceDisplayOptions setEndPositionIcon(BitmapDescriptor bitmapDescriptor) {
        this.f7492b = bitmapDescriptor;
        return this;
    }

    public HistoryTraceDisplayOptions setPaddingBottom(int i2) {
        this.n = i2;
        return this;
    }

    public HistoryTraceDisplayOptions setPaddingLeft(int i2) {
        this.k = i2;
        return this;
    }

    public HistoryTraceDisplayOptions setPaddingRight(int i2) {
        this.l = i2;
        return this;
    }

    public HistoryTraceDisplayOptions setPaddingTop(int i2) {
        this.m = i2;
        return this;
    }

    public void setRouteLineRenderBySubSection(boolean z) {
        this.j = z;
    }

    public HistoryTraceDisplayOptions setRouteLineTexture(BitmapDescriptor bitmapDescriptor) {
        this.f7494d = bitmapDescriptor;
        return this;
    }

    public HistoryTraceDisplayOptions setRouteLineWidth(int i2) {
        int i3 = 5;
        if (i2 >= 5) {
            i3 = 40;
            if (i2 <= 40) {
                this.f7495e = i2;
                return this;
            }
        }
        this.f7495e = i3;
        return this;
    }

    public HistoryTraceDisplayOptions setShowCarIcon(boolean z) {
        this.f7498h = z;
        return this;
    }

    public HistoryTraceDisplayOptions setShowEndPositionIcon(boolean z) {
        this.f7497g = z;
        return this;
    }

    public HistoryTraceDisplayOptions setShowRoutePlan(boolean z) {
        this.f7499i = z;
        return this;
    }

    public HistoryTraceDisplayOptions setShowStartPositionIcon(boolean z) {
        this.f7496f = z;
        return this;
    }

    public HistoryTraceDisplayOptions setStartPositionIcon(BitmapDescriptor bitmapDescriptor) {
        this.f7491a = bitmapDescriptor;
        return this;
    }
}
