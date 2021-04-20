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
    public BitmapDescriptor f7409a = BitmapDescriptorFactory.fromAssetWithDpi("SDK_Default_Icon_Start.png");

    /* renamed from: b  reason: collision with root package name */
    public BitmapDescriptor f7410b = BitmapDescriptorFactory.fromAssetWithDpi("SDK_Default_Icon_End.png");

    /* renamed from: c  reason: collision with root package name */
    public BitmapDescriptor f7411c = BitmapDescriptorFactory.fromAssetWithDpi("SDK_Default_Icon_Car.png");

    /* renamed from: d  reason: collision with root package name */
    public BitmapDescriptor f7412d = BitmapDescriptorFactory.fromAsset("SDK_Default_Route_Texture_Gray_Arrow.png");

    /* renamed from: e  reason: collision with root package name */
    public int f7413e = 22;

    /* renamed from: f  reason: collision with root package name */
    public boolean f7414f = true;

    /* renamed from: g  reason: collision with root package name */
    public boolean f7415g = true;

    /* renamed from: h  reason: collision with root package name */
    public boolean f7416h = false;
    public boolean i = true;

    public BitmapDescriptor getCarIcon() {
        return this.f7411c;
    }

    public BitmapDescriptor getEndPositionIcon() {
        return this.f7410b;
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
        return this.f7412d;
    }

    public int getRouteLineWidth() {
        return this.f7413e;
    }

    public BitmapDescriptor getStartPositionIcon() {
        return this.f7409a;
    }

    public boolean isRouteLineRenderBySubSection() {
        return this.j;
    }

    public boolean isShowCarIcon() {
        return this.f7416h;
    }

    public boolean isShowEndPositionIcon() {
        return this.f7415g;
    }

    public boolean isShowRoutePlan() {
        return this.i;
    }

    public boolean isShowStartPositionIcon() {
        return this.f7414f;
    }

    public HistoryTraceDisplayOptions setCarIcon(BitmapDescriptor bitmapDescriptor) {
        this.f7411c = bitmapDescriptor;
        return this;
    }

    public HistoryTraceDisplayOptions setEndPositionIcon(BitmapDescriptor bitmapDescriptor) {
        this.f7410b = bitmapDescriptor;
        return this;
    }

    public HistoryTraceDisplayOptions setPaddingBottom(int i) {
        this.n = i;
        return this;
    }

    public HistoryTraceDisplayOptions setPaddingLeft(int i) {
        this.k = i;
        return this;
    }

    public HistoryTraceDisplayOptions setPaddingRight(int i) {
        this.l = i;
        return this;
    }

    public HistoryTraceDisplayOptions setPaddingTop(int i) {
        this.m = i;
        return this;
    }

    public void setRouteLineRenderBySubSection(boolean z) {
        this.j = z;
    }

    public HistoryTraceDisplayOptions setRouteLineTexture(BitmapDescriptor bitmapDescriptor) {
        this.f7412d = bitmapDescriptor;
        return this;
    }

    public HistoryTraceDisplayOptions setRouteLineWidth(int i) {
        int i2 = 5;
        if (i >= 5) {
            i2 = 40;
            if (i <= 40) {
                this.f7413e = i;
                return this;
            }
        }
        this.f7413e = i2;
        return this;
    }

    public HistoryTraceDisplayOptions setShowCarIcon(boolean z) {
        this.f7416h = z;
        return this;
    }

    public HistoryTraceDisplayOptions setShowEndPositionIcon(boolean z) {
        this.f7415g = z;
        return this;
    }

    public HistoryTraceDisplayOptions setShowRoutePlan(boolean z) {
        this.i = z;
        return this;
    }

    public HistoryTraceDisplayOptions setShowStartPositionIcon(boolean z) {
        this.f7414f = z;
        return this;
    }

    public HistoryTraceDisplayOptions setStartPositionIcon(BitmapDescriptor bitmapDescriptor) {
        this.f7409a = bitmapDescriptor;
        return this;
    }
}
