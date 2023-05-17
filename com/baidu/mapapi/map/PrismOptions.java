package com.baidu.mapapi.map;

import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.BuildingInfo;
import java.util.List;
/* loaded from: classes3.dex */
public class PrismOptions extends OverlayOptions {
    public float b;
    public List<LatLng> c;
    public BuildingInfo f;
    public BitmapDescriptor g;
    public boolean h;
    public int i;
    public boolean j;
    public int d = -16777216;
    public int e = -16777216;
    public boolean a = true;

    public BuildingInfo getBuildingInfo() {
        return this.f;
    }

    public BitmapDescriptor getCustomSideImage() {
        return this.g;
    }

    public float getHeight() {
        return this.b;
    }

    public List<LatLng> getPoints() {
        return this.c;
    }

    public int getShowLevel() {
        return this.i;
    }

    public int getSideFaceColor() {
        return this.e;
    }

    public int getTopFaceColor() {
        return this.d;
    }

    public boolean isAnimation() {
        return this.j;
    }

    public boolean isVisible() {
        return this.a;
    }

    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay a() {
        List<LatLng> list;
        Prism prism = new Prism();
        prism.H = this.a;
        prism.g = this.g;
        prism.a = this.b;
        prism.f = this.h;
        prism.i = this.j;
        prism.h = this.i;
        if (this.f == null && ((list = this.c) == null || list.size() <= 3)) {
            throw new IllegalStateException("BDMapSDKException: when you add prism, you must at least supply 4 points");
        }
        prism.b = this.c;
        prism.d = this.e;
        prism.c = this.d;
        prism.e = this.f;
        return prism;
    }

    public PrismOptions customSideImage(BitmapDescriptor bitmapDescriptor) {
        this.g = bitmapDescriptor;
        return this;
    }

    public PrismOptions setAnimation(boolean z) {
        this.j = z;
        return this;
    }

    public PrismOptions setBuildingInfo(BuildingInfo buildingInfo) {
        this.f = buildingInfo;
        return this;
    }

    public PrismOptions setHeight(float f) {
        this.b = f;
        return this;
    }

    public PrismOptions setPoints(List<LatLng> list) {
        this.c = list;
        return this;
    }

    public PrismOptions setShowLevel(int i) {
        this.i = i;
        return this;
    }

    public PrismOptions setSideFaceColor(int i) {
        this.e = i;
        return this;
    }

    public PrismOptions setTopFaceColor(int i) {
        this.d = i;
        return this;
    }

    public PrismOptions showMarker(boolean z) {
        this.h = z;
        return this;
    }

    public PrismOptions visible(boolean z) {
        this.a = z;
        return this;
    }
}
