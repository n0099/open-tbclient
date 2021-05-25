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
    public BitmapDescriptor f7391a = BitmapDescriptorFactory.fromAssetWithDpi("SDK_Default_Icon_Start.png");

    /* renamed from: b  reason: collision with root package name */
    public BitmapDescriptor f7392b = BitmapDescriptorFactory.fromAssetWithDpi("SDK_Default_Icon_End.png");

    /* renamed from: c  reason: collision with root package name */
    public BitmapDescriptor f7393c = BitmapDescriptorFactory.fromAssetWithDpi("SDK_Default_Icon_Car.png");

    /* renamed from: d  reason: collision with root package name */
    public BitmapDescriptor f7394d = BitmapDescriptorFactory.fromAsset("SDK_Default_Route_Texture_Gray_Arrow.png");

    /* renamed from: e  reason: collision with root package name */
    public int f7395e = 22;

    /* renamed from: f  reason: collision with root package name */
    public boolean f7396f = true;

    /* renamed from: g  reason: collision with root package name */
    public boolean f7397g = true;

    /* renamed from: h  reason: collision with root package name */
    public boolean f7398h = false;

    /* renamed from: i  reason: collision with root package name */
    public boolean f7399i = true;

    public BitmapDescriptor getCarIcon() {
        return this.f7393c;
    }

    public BitmapDescriptor getEndPositionIcon() {
        return this.f7392b;
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
        return this.f7394d;
    }

    public int getRouteLineWidth() {
        return this.f7395e;
    }

    public BitmapDescriptor getStartPositionIcon() {
        return this.f7391a;
    }

    public boolean isRouteLineRenderBySubSection() {
        return this.j;
    }

    public boolean isShowCarIcon() {
        return this.f7398h;
    }

    public boolean isShowEndPositionIcon() {
        return this.f7397g;
    }

    public boolean isShowRoutePlan() {
        return this.f7399i;
    }

    public boolean isShowStartPositionIcon() {
        return this.f7396f;
    }

    public HistoryTraceDisplayOptions setCarIcon(BitmapDescriptor bitmapDescriptor) {
        this.f7393c = bitmapDescriptor;
        return this;
    }

    public HistoryTraceDisplayOptions setEndPositionIcon(BitmapDescriptor bitmapDescriptor) {
        this.f7392b = bitmapDescriptor;
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
        this.f7394d = bitmapDescriptor;
        return this;
    }

    public HistoryTraceDisplayOptions setRouteLineWidth(int i2) {
        int i3 = 5;
        if (i2 >= 5) {
            i3 = 40;
            if (i2 <= 40) {
                this.f7395e = i2;
                return this;
            }
        }
        this.f7395e = i3;
        return this;
    }

    public HistoryTraceDisplayOptions setShowCarIcon(boolean z) {
        this.f7398h = z;
        return this;
    }

    public HistoryTraceDisplayOptions setShowEndPositionIcon(boolean z) {
        this.f7397g = z;
        return this;
    }

    public HistoryTraceDisplayOptions setShowRoutePlan(boolean z) {
        this.f7399i = z;
        return this;
    }

    public HistoryTraceDisplayOptions setShowStartPositionIcon(boolean z) {
        this.f7396f = z;
        return this;
    }

    public HistoryTraceDisplayOptions setStartPositionIcon(BitmapDescriptor bitmapDescriptor) {
        this.f7391a = bitmapDescriptor;
        return this;
    }
}
