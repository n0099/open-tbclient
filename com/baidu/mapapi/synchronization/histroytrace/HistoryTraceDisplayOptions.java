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
    public BitmapDescriptor f7434a = BitmapDescriptorFactory.fromAssetWithDpi("SDK_Default_Icon_Start.png");

    /* renamed from: b  reason: collision with root package name */
    public BitmapDescriptor f7435b = BitmapDescriptorFactory.fromAssetWithDpi("SDK_Default_Icon_End.png");

    /* renamed from: c  reason: collision with root package name */
    public BitmapDescriptor f7436c = BitmapDescriptorFactory.fromAssetWithDpi("SDK_Default_Icon_Car.png");

    /* renamed from: d  reason: collision with root package name */
    public BitmapDescriptor f7437d = BitmapDescriptorFactory.fromAsset("SDK_Default_Route_Texture_Gray_Arrow.png");

    /* renamed from: e  reason: collision with root package name */
    public int f7438e = 22;

    /* renamed from: f  reason: collision with root package name */
    public boolean f7439f = true;

    /* renamed from: g  reason: collision with root package name */
    public boolean f7440g = true;

    /* renamed from: h  reason: collision with root package name */
    public boolean f7441h = false;

    /* renamed from: i  reason: collision with root package name */
    public boolean f7442i = true;

    public BitmapDescriptor getCarIcon() {
        return this.f7436c;
    }

    public BitmapDescriptor getEndPositionIcon() {
        return this.f7435b;
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
        return this.f7437d;
    }

    public int getRouteLineWidth() {
        return this.f7438e;
    }

    public BitmapDescriptor getStartPositionIcon() {
        return this.f7434a;
    }

    public boolean isRouteLineRenderBySubSection() {
        return this.j;
    }

    public boolean isShowCarIcon() {
        return this.f7441h;
    }

    public boolean isShowEndPositionIcon() {
        return this.f7440g;
    }

    public boolean isShowRoutePlan() {
        return this.f7442i;
    }

    public boolean isShowStartPositionIcon() {
        return this.f7439f;
    }

    public HistoryTraceDisplayOptions setCarIcon(BitmapDescriptor bitmapDescriptor) {
        this.f7436c = bitmapDescriptor;
        return this;
    }

    public HistoryTraceDisplayOptions setEndPositionIcon(BitmapDescriptor bitmapDescriptor) {
        this.f7435b = bitmapDescriptor;
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
        this.f7437d = bitmapDescriptor;
        return this;
    }

    public HistoryTraceDisplayOptions setRouteLineWidth(int i2) {
        int i3 = 5;
        if (i2 >= 5) {
            i3 = 40;
            if (i2 <= 40) {
                this.f7438e = i2;
                return this;
            }
        }
        this.f7438e = i3;
        return this;
    }

    public HistoryTraceDisplayOptions setShowCarIcon(boolean z) {
        this.f7441h = z;
        return this;
    }

    public HistoryTraceDisplayOptions setShowEndPositionIcon(boolean z) {
        this.f7440g = z;
        return this;
    }

    public HistoryTraceDisplayOptions setShowRoutePlan(boolean z) {
        this.f7442i = z;
        return this;
    }

    public HistoryTraceDisplayOptions setShowStartPositionIcon(boolean z) {
        this.f7439f = z;
        return this;
    }

    public HistoryTraceDisplayOptions setStartPositionIcon(BitmapDescriptor bitmapDescriptor) {
        this.f7434a = bitmapDescriptor;
        return this;
    }
}
