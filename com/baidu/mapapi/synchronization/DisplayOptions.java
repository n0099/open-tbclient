package com.baidu.mapapi.synchronization;

import android.view.View;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public final class DisplayOptions {
    private static final String a = DisplayOptions.class.getSimpleName();
    private View A;
    private View B;
    private View C;
    private boolean k;
    private boolean l;
    private int e = 6;
    private int i = 7;
    private int m = 8;
    private int q = 10;
    private int t = 5;
    private boolean D = true;
    private boolean E = true;
    private int F = 6;
    private boolean G = true;
    private boolean H = true;
    private int I = 7;
    private boolean J = true;
    private boolean K = true;
    private int L = 8;
    private int M = 50;
    private int N = 50;
    private int O = 50;
    private int P = 50;
    private BitmapDescriptor b = BitmapDescriptorFactory.fromAssetWithDpi("SDK_Default_Icon_Start.png");
    private boolean c = true;
    private boolean d = true;
    private BitmapDescriptor f = BitmapDescriptorFactory.fromAssetWithDpi("SDK_Default_Icon_End.png");
    private boolean g = true;
    private boolean h = true;
    private BitmapDescriptor j = BitmapDescriptorFactory.fromAssetWithDpi("SDK_Default_Icon_Car.png");
    private BitmapDescriptor n = BitmapDescriptorFactory.fromAssetWithDpi("SDK_Default_Icon_Passenger.png");
    private boolean o = true;
    private boolean p = true;
    private boolean r = true;
    private boolean s = true;
    private BitmapDescriptor u = BitmapDescriptorFactory.fromAsset("SDK_Default_Traffic_Texture_Smooth.png");
    private BitmapDescriptor v = BitmapDescriptorFactory.fromAsset("SDK_Default_Traffic_Texture_Slow.png");
    private BitmapDescriptor w = BitmapDescriptorFactory.fromAsset("SDK_Default_Traffic_Texture_Congestion.png");
    private BitmapDescriptor x = BitmapDescriptorFactory.fromAsset("SDK_Default_Traffic_Texture_SevereCongestion.png");
    private BitmapDescriptor y = BitmapDescriptorFactory.fromAsset("SDK_Default_Route_Texture_Bule_Arrow.png");
    private int z = 22;

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
        return this.f;
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
        return this.b;
    }

    public View getStartPositionInfoWindowView() {
        return this.B;
    }

    public int getStartPositionInfoWindowZIndex() {
        return this.F;
    }

    public int getStartPositionMarkerZIndex() {
        return this.e;
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
        return this.g;
    }

    public boolean isShowEndPositionMarkerInSpan() {
        return this.h;
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
        return this.c;
    }

    public boolean isShowStartPositionMarkerInSpan() {
        return this.d;
    }

    public DisplayOptions setCarIcon(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor == null) {
            throw new IllegalArgumentException("CarIcon descriptor is null");
        }
        this.j = bitmapDescriptor;
        return this;
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
        if (bitmapDescriptor == null) {
            throw new IllegalArgumentException("CongestionTrafficTexture descriptor is null");
        }
        this.w = bitmapDescriptor;
        return this;
    }

    public DisplayOptions setEndPositionIcon(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor == null) {
            throw new IllegalArgumentException("EndPositionIcon descriptor is null");
        }
        this.f = bitmapDescriptor;
        return this;
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
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "Padding param is invalid. paddingLeft = " + i + "; paddingRight = " + i3 + "; paddingTop = " + i2 + "; paddingBottom = " + i4);
        }
        if (i < 0) {
            i = 30;
        }
        this.M = i;
        if (i2 < 0) {
            i2 = 30;
        }
        this.O = i2;
        this.N = i3 >= 0 ? i3 : 30;
        if (i4 < 0) {
            i4 = 50;
        }
        this.P = i4;
        return this;
    }

    public DisplayOptions setPassengerIcon(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor == null) {
            throw new IllegalArgumentException("PassengerIcon descriptor is null");
        }
        this.n = bitmapDescriptor;
        return this;
    }

    public DisplayOptions setPassengerMarkerZIndex(int i) {
        if (i <= 1) {
            i = 2;
        }
        this.q = i;
        return this;
    }

    public DisplayOptions setRouteLineWidth(int i) {
        if (i < 5) {
            this.z = 5;
        } else if (i > 40) {
            this.z = 40;
        } else {
            this.z = i;
        }
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
        if (bitmapDescriptor == null) {
            throw new IllegalArgumentException("SevereCongestionTrafficTexture descriptor is null");
        }
        this.x = bitmapDescriptor;
        return this;
    }

    public DisplayOptions setSlowTrafficTexture(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor == null) {
            throw new IllegalArgumentException("SlowTrafficTexture descriptor is null");
        }
        this.v = bitmapDescriptor;
        return this;
    }

    public DisplayOptions setSmoothTrafficTexture(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor == null) {
            throw new IllegalArgumentException("SmoothTrafficTexture descriptor is null");
        }
        this.u = bitmapDescriptor;
        return this;
    }

    public DisplayOptions setStartPositionIcon(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor == null) {
            throw new IllegalArgumentException("StartPositionIcon descriptor is null");
        }
        this.b = bitmapDescriptor;
        return this;
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
        this.e = i;
        return this;
    }

    public DisplayOptions setUnknownTrafficTexture(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor == null) {
            throw new IllegalArgumentException("UnknownTrafficTexture descriptor is null");
        }
        this.y = bitmapDescriptor;
        return this;
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
        this.g = z;
        return this;
    }

    public DisplayOptions showEndPositionIconInSpan(boolean z) {
        this.h = z;
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
        this.c = z;
        return this;
    }

    public DisplayOptions showStartPositionIconInSpan(boolean z) {
        this.d = z;
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
