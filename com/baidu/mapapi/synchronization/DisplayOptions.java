package com.baidu.mapapi.synchronization;

import android.view.View;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public final class DisplayOptions {

    /* renamed from: a  reason: collision with root package name */
    public static final String f7340a = "DisplayOptions";
    public View A;
    public View B;
    public View C;
    public boolean k;
    public boolean l;

    /* renamed from: e  reason: collision with root package name */
    public int f7344e = 6;
    public int i = 7;
    public int m = 8;
    public int q = 10;
    public int t = 5;
    public boolean D = true;
    public boolean E = true;
    public int F = 6;
    public boolean G = true;
    public boolean H = true;
    public int I = 7;
    public boolean J = true;
    public boolean K = true;
    public int L = 8;
    public int M = 50;
    public int N = 50;
    public int O = 50;
    public int P = 50;

    /* renamed from: b  reason: collision with root package name */
    public BitmapDescriptor f7341b = BitmapDescriptorFactory.fromAssetWithDpi("SDK_Default_Icon_Start.png");

    /* renamed from: c  reason: collision with root package name */
    public boolean f7342c = true;

    /* renamed from: d  reason: collision with root package name */
    public boolean f7343d = true;

    /* renamed from: f  reason: collision with root package name */
    public BitmapDescriptor f7345f = BitmapDescriptorFactory.fromAssetWithDpi("SDK_Default_Icon_End.png");

    /* renamed from: g  reason: collision with root package name */
    public boolean f7346g = true;

    /* renamed from: h  reason: collision with root package name */
    public boolean f7347h = true;
    public BitmapDescriptor j = BitmapDescriptorFactory.fromAssetWithDpi("SDK_Default_Icon_Car.png");
    public BitmapDescriptor n = BitmapDescriptorFactory.fromAssetWithDpi("SDK_Default_Icon_Passenger.png");
    public boolean o = true;
    public boolean p = true;
    public boolean r = true;
    public boolean s = true;
    public BitmapDescriptor u = BitmapDescriptorFactory.fromAsset("SDK_Default_Traffic_Texture_Smooth.png");
    public BitmapDescriptor v = BitmapDescriptorFactory.fromAsset("SDK_Default_Traffic_Texture_Slow.png");
    public BitmapDescriptor w = BitmapDescriptorFactory.fromAsset("SDK_Default_Traffic_Texture_Congestion.png");
    public BitmapDescriptor x = BitmapDescriptorFactory.fromAsset("SDK_Default_Traffic_Texture_SevereCongestion.png");
    public BitmapDescriptor y = BitmapDescriptorFactory.fromAsset("SDK_Default_Route_Texture_Bule_Arrow.png");
    public int z = 22;

    public DisplayOptions() {
        this.k = true;
        this.l = true;
        this.k = true;
        this.l = true;
    }

    public BitmapDescriptor getCarIcon() {
        return this.j;
    }

    public View getCarInfoWindowView() {
        return this.A;
    }

    public int getCarPositionInfoWindowZIndex() {
        return this.L;
    }

    public int getCarPositionMarkerZIndex() {
        return this.m;
    }

    public BitmapDescriptor getEndPositionIcon() {
        return this.f7345f;
    }

    public View getEndPositionInfoWindowView() {
        return this.C;
    }

    public int getEndPositionInfoWindowZIndex() {
        return this.I;
    }

    public int getEndPositionMarkerZIndex() {
        return this.i;
    }

    public int getPaddingBottom() {
        return this.P;
    }

    public int getPaddingLeft() {
        return this.M;
    }

    public int getPaddingRight() {
        return this.N;
    }

    public int getPaddingTop() {
        return this.O;
    }

    public BitmapDescriptor getPassengerIcon() {
        return this.n;
    }

    public int getPassengerMarkerZIndex() {
        return this.q;
    }

    public int getRouteLineWidth() {
        return this.z;
    }

    public int getRouteLineZIndex() {
        return this.t;
    }

    public BitmapDescriptor getStartPositionIcon() {
        return this.f7341b;
    }

    public View getStartPositionInfoWindowView() {
        return this.B;
    }

    public int getStartPositionInfoWindowZIndex() {
        return this.F;
    }

    public int getStartPositionMarkerZIndex() {
        return this.f7344e;
    }

    public List<BitmapDescriptor> getTrafficTextureList() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.y);
        arrayList.add(this.u);
        arrayList.add(this.v);
        arrayList.add(this.w);
        arrayList.add(this.x);
        return arrayList;
    }

    public boolean isShowCarInfoWindow() {
        return this.J;
    }

    public boolean isShowCarMarker() {
        return this.k;
    }

    public boolean isShowCarMarkerInSpan() {
        return this.l;
    }

    public boolean isShowEndPositionInfoWindow() {
        return this.G;
    }

    public boolean isShowEndPositionMarker() {
        return this.f7346g;
    }

    public boolean isShowEndPositionMarkerInSpan() {
        return this.f7347h;
    }

    public boolean isShowPassengerIcon() {
        return this.o;
    }

    public boolean isShowPassengerIconInSpan() {
        return this.p;
    }

    public boolean isShowRoutePlan() {
        return this.r;
    }

    public boolean isShowRoutePlanInSpan() {
        return this.s;
    }

    public boolean isShowStartPositionInfoWindow() {
        return this.D;
    }

    public boolean isShowStartPositionMarker() {
        return this.f7342c;
    }

    public boolean isShowStartPositionMarkerInSpan() {
        return this.f7343d;
    }

    public DisplayOptions setCarIcon(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor != null) {
            this.j = bitmapDescriptor;
            return this;
        }
        throw new IllegalArgumentException("CarIcon descriptor is null");
    }

    public DisplayOptions setCarInfoWindowView(View view) {
        this.A = view;
        return this;
    }

    public DisplayOptions setCarPositionInfoWindowZIndex(int i) {
        if (i <= 1) {
            i = 2;
        }
        this.L = i;
        return this;
    }

    public DisplayOptions setCarPositionMarkerZIndex(int i) {
        if (i <= 1) {
            i = 2;
        }
        this.m = i;
        return this;
    }

    public DisplayOptions setCongestionTrafficTexture(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor != null) {
            this.w = bitmapDescriptor;
            return this;
        }
        throw new IllegalArgumentException("CongestionTrafficTexture descriptor is null");
    }

    public DisplayOptions setEndPositionIcon(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor != null) {
            this.f7345f = bitmapDescriptor;
            return this;
        }
        throw new IllegalArgumentException("EndPositionIcon descriptor is null");
    }

    public DisplayOptions setEndPositionInfoWindowView(View view) {
        this.C = view;
        return this;
    }

    public DisplayOptions setEndPositionInfoWindowZIndex(int i) {
        if (i <= 1) {
            i = 2;
        }
        this.I = i;
        return this;
    }

    public DisplayOptions setEndPositionMarkerZIndex(int i) {
        if (i <= 1) {
            i = 2;
        }
        this.i = i;
        return this;
    }

    public DisplayOptions setMapViewPadding(int i, int i2, int i3, int i4) {
        if (i < 0 || i3 < 0 || i2 < 0 || i4 < 0) {
            String str = f7340a;
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(str, "Padding param is invalid. paddingLeft = " + i + "; paddingRight = " + i3 + "; paddingTop = " + i2 + "; paddingBottom = " + i4);
        }
        if (i < 0) {
            i = 30;
        }
        this.M = i;
        if (i2 < 0) {
            i2 = 30;
        }
        this.O = i2;
        if (i3 < 0) {
            i3 = 30;
        }
        this.N = i3;
        if (i4 < 0) {
            i4 = 50;
        }
        this.P = i4;
        return this;
    }

    public DisplayOptions setPassengerIcon(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor != null) {
            this.n = bitmapDescriptor;
            return this;
        }
        throw new IllegalArgumentException("PassengerIcon descriptor is null");
    }

    public DisplayOptions setPassengerMarkerZIndex(int i) {
        if (i <= 1) {
            i = 2;
        }
        this.q = i;
        return this;
    }

    public DisplayOptions setRouteLineWidth(int i) {
        int i2 = 5;
        if (i >= 5) {
            i2 = 40;
            if (i <= 40) {
                this.z = i;
                return this;
            }
        }
        this.z = i2;
        return this;
    }

    public DisplayOptions setRouteLineZIndex(int i) {
        if (i <= 1) {
            i = 2;
        }
        this.t = i;
        return this;
    }

    public DisplayOptions setSevereCongestionTrafficTexture(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor != null) {
            this.x = bitmapDescriptor;
            return this;
        }
        throw new IllegalArgumentException("SevereCongestionTrafficTexture descriptor is null");
    }

    public DisplayOptions setSlowTrafficTexture(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor != null) {
            this.v = bitmapDescriptor;
            return this;
        }
        throw new IllegalArgumentException("SlowTrafficTexture descriptor is null");
    }

    public DisplayOptions setSmoothTrafficTexture(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor != null) {
            this.u = bitmapDescriptor;
            return this;
        }
        throw new IllegalArgumentException("SmoothTrafficTexture descriptor is null");
    }

    public DisplayOptions setStartPositionIcon(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor != null) {
            this.f7341b = bitmapDescriptor;
            return this;
        }
        throw new IllegalArgumentException("StartPositionIcon descriptor is null");
    }

    public DisplayOptions setStartPositionInfoWindowView(View view) {
        this.B = view;
        return this;
    }

    public DisplayOptions setStartPositionInfoWindowZIndex(int i) {
        if (i <= 1) {
            i = 2;
        }
        this.F = i;
        return this;
    }

    public DisplayOptions setStartPositionMarkerZIndex(int i) {
        if (i <= 1) {
            i = 2;
        }
        this.f7344e = i;
        return this;
    }

    public DisplayOptions setUnknownTrafficTexture(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor != null) {
            this.y = bitmapDescriptor;
            return this;
        }
        throw new IllegalArgumentException("UnknownTrafficTexture descriptor is null");
    }

    public DisplayOptions showCarIcon(boolean z) {
        this.k = z;
        return this;
    }

    public DisplayOptions showCarIconInSpan(boolean z) {
        this.l = z;
        return this;
    }

    public DisplayOptions showCarInfoWindow(boolean z) {
        this.J = z;
        return this;
    }

    public DisplayOptions showCarInfoWindowInSpan(boolean z) {
        this.K = z;
        return this;
    }

    public DisplayOptions showEndPositionIcon(boolean z) {
        this.f7346g = z;
        return this;
    }

    public DisplayOptions showEndPositionIconInSpan(boolean z) {
        this.f7347h = z;
        return this;
    }

    public DisplayOptions showEndPositionInfoWindow(boolean z) {
        this.G = z;
        return this;
    }

    public DisplayOptions showEndPositionInfoWindowInSpan(boolean z) {
        this.H = z;
        return this;
    }

    public DisplayOptions showPassengereIcon(boolean z) {
        this.o = z;
        return this;
    }

    public DisplayOptions showPassengereIconInSpan(boolean z) {
        this.p = z;
        return this;
    }

    public DisplayOptions showRoutePlan(boolean z) {
        this.r = z;
        return this;
    }

    public DisplayOptions showRoutePlanInSpan(boolean z) {
        this.s = z;
        return this;
    }

    public DisplayOptions showStartPositionIcon(boolean z) {
        this.f7342c = z;
        return this;
    }

    public DisplayOptions showStartPositionIconInSpan(boolean z) {
        this.f7343d = z;
        return this;
    }

    public DisplayOptions showStartPositionInfoWindow(boolean z) {
        this.D = z;
        return this;
    }

    public DisplayOptions showStartPositionInfoWindowInSpan(boolean z) {
        this.E = z;
        return this;
    }
}
