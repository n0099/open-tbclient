package com.baidu.mapapi.synchronization;

import android.view.View;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapsdkplatform.comapi.synchronization.d.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public final class DisplayOptions {
    private static final String a = DisplayOptions.class.getSimpleName();
    private boolean c;
    private boolean d;
    private boolean f;
    private boolean g;
    private boolean i;
    private boolean j;
    private boolean l;
    private boolean m;
    private boolean n;
    private boolean o;
    private int u;
    private View v;
    private View w;
    private View x;
    private boolean y = true;
    private boolean z = true;
    private boolean A = true;
    private boolean B = true;
    private boolean C = true;
    private boolean D = true;
    private int E = 50;
    private int F = 50;
    private int G = 50;
    private int H = 50;
    private BitmapDescriptor b = BitmapDescriptorFactory.fromAssetWithDpi("SDK_Default_Icon_Start.png");
    private BitmapDescriptor e = BitmapDescriptorFactory.fromAssetWithDpi("SDK_Default_Icon_End.png");
    private BitmapDescriptor h = BitmapDescriptorFactory.fromAssetWithDpi("SDK_Default_Icon_Car.png");
    private BitmapDescriptor k = BitmapDescriptorFactory.fromAssetWithDpi("SDK_Default_Icon_Passenger.png");
    private BitmapDescriptor p = BitmapDescriptorFactory.fromAsset("SDK_Default_Traffic_Texture_Smooth.png");
    private BitmapDescriptor q = BitmapDescriptorFactory.fromAsset("SDK_Default_Traffic_Texture_Slow.png");
    private BitmapDescriptor r = BitmapDescriptorFactory.fromAsset("SDK_Default_Traffic_Texture_Congestion.png");
    private BitmapDescriptor s = BitmapDescriptorFactory.fromAsset("SDK_Default_Traffic_Texture_SevereCongestion.png");
    private BitmapDescriptor t = BitmapDescriptorFactory.fromAsset("SDK_Default_Route_Texture_Bule_Arrow.png");

    public DisplayOptions() {
        this.c = true;
        this.d = true;
        this.f = true;
        this.g = true;
        this.i = true;
        this.j = true;
        this.l = true;
        this.m = true;
        this.n = true;
        this.o = true;
        this.u = 20;
        this.c = true;
        this.d = true;
        this.f = true;
        this.g = true;
        this.i = true;
        this.j = true;
        this.l = true;
        this.m = true;
        this.n = true;
        this.o = true;
        this.u = 20;
    }

    public BitmapDescriptor getCarIcon() {
        return this.h;
    }

    public View getCarInfoWindowView() {
        return this.v;
    }

    public BitmapDescriptor getEndPositionIcon() {
        return this.e;
    }

    public View getEndPositionInfoWindowView() {
        return this.x;
    }

    public int getPaddingBottom() {
        return this.H;
    }

    public int getPaddingLeft() {
        return this.E;
    }

    public int getPaddingRight() {
        return this.F;
    }

    public int getPaddingTop() {
        return this.G;
    }

    public BitmapDescriptor getPassengerIcon() {
        return this.k;
    }

    public int getRouteLineWidth() {
        return this.u;
    }

    public BitmapDescriptor getStartPositionIcon() {
        return this.b;
    }

    public View getStartPositionInfoWindowView() {
        return this.w;
    }

    public List<BitmapDescriptor> getTrafficTextureList() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.t);
        arrayList.add(this.p);
        arrayList.add(this.q);
        arrayList.add(this.r);
        arrayList.add(this.s);
        return arrayList;
    }

    public boolean isShowCarInfoWindow() {
        return this.C;
    }

    public boolean isShowCarMarker() {
        return this.i;
    }

    public boolean isShowCarMarkerInSpan() {
        return this.j;
    }

    public boolean isShowEndPositionInfoWindow() {
        return this.A;
    }

    public boolean isShowEndPositionMarker() {
        return this.f;
    }

    public boolean isShowEndPositionMarkerInSpan() {
        return this.g;
    }

    public boolean isShowPassengerIcon() {
        return this.l;
    }

    public boolean isShowPassengerIconInSpan() {
        return this.m;
    }

    public boolean isShowRoutePlan() {
        return this.n;
    }

    public boolean isShowRoutePlanInSpan() {
        return this.o;
    }

    public boolean isShowStartPositionInfoWindow() {
        return this.y;
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
        this.h = bitmapDescriptor;
        return this;
    }

    public DisplayOptions setCarInfoWindowView(View view) {
        this.v = view;
        return this;
    }

    public DisplayOptions setCongestionTrafficTexture(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor == null) {
            throw new IllegalArgumentException("CongestionTrafficTexture descriptor is null");
        }
        this.r = bitmapDescriptor;
        return this;
    }

    public DisplayOptions setEndPositionIcon(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor == null) {
            throw new IllegalArgumentException("EndPositionIcon descriptor is null");
        }
        this.e = bitmapDescriptor;
        return this;
    }

    public DisplayOptions setEndPositionInfoWindowView(View view) {
        this.x = view;
        return this;
    }

    public DisplayOptions setMapViewPadding(int i, int i2, int i3, int i4) {
        if (i < 0 || i3 < 0 || i2 < 0 || i4 < 0) {
            a.b(a, "Padding param is invalid. paddingLeft = " + i + "; paddingRight = " + i3 + "; paddingTop = " + i2 + "; paddingBottom = " + i4);
        }
        if (i < 0) {
            i = 30;
        }
        this.E = i;
        if (i2 < 0) {
            i2 = 30;
        }
        this.G = i2;
        this.F = i3 >= 0 ? i3 : 30;
        if (i4 < 0) {
            i4 = 50;
        }
        this.H = i4;
        return this;
    }

    public DisplayOptions setPassengerIcon(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor == null) {
            throw new IllegalArgumentException("PassengerIcon descriptor is null");
        }
        this.k = bitmapDescriptor;
        return this;
    }

    public DisplayOptions setRouteLineWidth(int i) {
        if (i < 5) {
            this.u = 5;
        } else if (i > 40) {
            this.u = 40;
        } else {
            this.u = i;
        }
        return this;
    }

    public DisplayOptions setSevereCongestionTrafficTexture(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor == null) {
            throw new IllegalArgumentException("SevereCongestionTrafficTexture descriptor is null");
        }
        this.s = bitmapDescriptor;
        return this;
    }

    public DisplayOptions setSlowTrafficTexture(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor == null) {
            throw new IllegalArgumentException("SlowTrafficTexture descriptor is null");
        }
        this.q = bitmapDescriptor;
        return this;
    }

    public DisplayOptions setSmoothTrafficTexture(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor == null) {
            throw new IllegalArgumentException("SmoothTrafficTexture descriptor is null");
        }
        this.p = bitmapDescriptor;
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
        this.w = view;
        return this;
    }

    public DisplayOptions setUnknownTrafficTexture(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor == null) {
            throw new IllegalArgumentException("UnknownTrafficTexture descriptor is null");
        }
        this.t = bitmapDescriptor;
        return this;
    }

    public DisplayOptions showCarIcon(boolean z) {
        this.i = z;
        return this;
    }

    public DisplayOptions showCarIconInSpan(boolean z) {
        this.j = z;
        return this;
    }

    public DisplayOptions showCarInfoWindow(boolean z) {
        this.C = z;
        return this;
    }

    public DisplayOptions showCarInfoWindowInSpan(boolean z) {
        this.D = z;
        return this;
    }

    public DisplayOptions showEndPositionIcon(boolean z) {
        this.f = z;
        return this;
    }

    public DisplayOptions showEndPositionIconInSpan(boolean z) {
        this.g = z;
        return this;
    }

    public DisplayOptions showEndPositionInfoWindow(boolean z) {
        this.A = z;
        return this;
    }

    public DisplayOptions showEndPositionInfoWindowInSpan(boolean z) {
        this.B = z;
        return this;
    }

    public DisplayOptions showPassengereIcon(boolean z) {
        this.l = z;
        return this;
    }

    public DisplayOptions showPassengereIconInSpan(boolean z) {
        this.m = z;
        return this;
    }

    public DisplayOptions showRoutePlan(boolean z) {
        this.n = z;
        return this;
    }

    public DisplayOptions showRoutePlanInSpan(boolean z) {
        this.o = z;
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
        this.y = z;
        return this;
    }

    public DisplayOptions showStartPositionInfoWindowInSpan(boolean z) {
        this.z = z;
        return this;
    }
}
