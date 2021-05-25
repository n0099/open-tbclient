package com.baidu.mapapi.synchronization;

import android.view.View;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public final class DisplayOptions {

    /* renamed from: a  reason: collision with root package name */
    public static final String f7355a = "DisplayOptions";
    public View A;
    public View B;
    public View C;
    public boolean Q;
    public boolean k;
    public boolean l;

    /* renamed from: e  reason: collision with root package name */
    public int f7359e = 6;

    /* renamed from: i  reason: collision with root package name */
    public int f7363i = 7;
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
    public List<BitmapDescriptor> R = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public BitmapDescriptor f7356b = BitmapDescriptorFactory.fromAssetWithDpi("SDK_Default_Icon_Start.png");

    /* renamed from: c  reason: collision with root package name */
    public boolean f7357c = true;

    /* renamed from: d  reason: collision with root package name */
    public boolean f7358d = true;

    /* renamed from: f  reason: collision with root package name */
    public BitmapDescriptor f7360f = BitmapDescriptorFactory.fromAssetWithDpi("SDK_Default_Icon_End.png");

    /* renamed from: g  reason: collision with root package name */
    public boolean f7361g = true;

    /* renamed from: h  reason: collision with root package name */
    public boolean f7362h = true;
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

    public boolean get3DCarMarkerEnable() {
        return this.Q;
    }

    public List<BitmapDescriptor> get3DCarMarkerIconList() {
        return this.R;
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
        return this.f7360f;
    }

    public View getEndPositionInfoWindowView() {
        return this.C;
    }

    public int getEndPositionInfoWindowZIndex() {
        return this.I;
    }

    public int getEndPositionMarkerZIndex() {
        return this.f7363i;
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
        return this.f7356b;
    }

    public View getStartPositionInfoWindowView() {
        return this.B;
    }

    public int getStartPositionInfoWindowZIndex() {
        return this.F;
    }

    public int getStartPositionMarkerZIndex() {
        return this.f7359e;
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
        return this.f7361g;
    }

    public boolean isShowEndPositionMarkerInSpan() {
        return this.f7362h;
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
        return this.f7357c;
    }

    public boolean isShowStartPositionMarkerInSpan() {
        return this.f7358d;
    }

    public DisplayOptions set3DCarMarkerEnable(boolean z) {
        this.Q = z;
        return this;
    }

    public DisplayOptions set3DCarMarkerIconList(List<BitmapDescriptor> list) {
        if (list == null || list.isEmpty()) {
            this.R = null;
        } else {
            this.R.addAll(list);
        }
        return this;
    }

    public DisplayOptions setCarIcon(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor != null) {
            this.j = bitmapDescriptor;
            return this;
        }
        throw new IllegalArgumentException("BDMapSDKException: CarIcon descriptor is null");
    }

    public DisplayOptions setCarInfoWindowView(View view) {
        this.A = view;
        return this;
    }

    public DisplayOptions setCarPositionInfoWindowZIndex(int i2) {
        if (i2 <= 1) {
            i2 = 2;
        }
        this.L = i2;
        return this;
    }

    public DisplayOptions setCarPositionMarkerZIndex(int i2) {
        if (i2 <= 1) {
            i2 = 2;
        }
        this.m = i2;
        return this;
    }

    public DisplayOptions setCongestionTrafficTexture(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor != null) {
            this.w = bitmapDescriptor;
            return this;
        }
        throw new IllegalArgumentException("BDMapSDKException: CongestionTrafficTexture descriptor is null");
    }

    public DisplayOptions setEndPositionIcon(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor != null) {
            this.f7360f = bitmapDescriptor;
            return this;
        }
        throw new IllegalArgumentException("BDMapSDKException: EndPositionIcon descriptor is null");
    }

    public DisplayOptions setEndPositionInfoWindowView(View view) {
        this.C = view;
        return this;
    }

    public DisplayOptions setEndPositionInfoWindowZIndex(int i2) {
        if (i2 <= 1) {
            i2 = 2;
        }
        this.I = i2;
        return this;
    }

    public DisplayOptions setEndPositionMarkerZIndex(int i2) {
        if (i2 <= 1) {
            i2 = 2;
        }
        this.f7363i = i2;
        return this;
    }

    public DisplayOptions setMapViewPadding(int i2, int i3, int i4, int i5) {
        if (i2 < 0 || i4 < 0 || i3 < 0 || i5 < 0) {
            String str = f7355a;
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(str, "Padding param is invalid. paddingLeft = " + i2 + "; paddingRight = " + i4 + "; paddingTop = " + i3 + "; paddingBottom = " + i5);
        }
        if (i2 < 0) {
            i2 = 30;
        }
        this.M = i2;
        if (i3 < 0) {
            i3 = 30;
        }
        this.O = i3;
        if (i4 < 0) {
            i4 = 30;
        }
        this.N = i4;
        if (i5 < 0) {
            i5 = 50;
        }
        this.P = i5;
        return this;
    }

    public DisplayOptions setPassengerIcon(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor != null) {
            this.n = bitmapDescriptor;
            return this;
        }
        throw new IllegalArgumentException("BDMapSDKException: PassengerIcon descriptor is null");
    }

    public DisplayOptions setPassengerMarkerZIndex(int i2) {
        if (i2 <= 1) {
            i2 = 2;
        }
        this.q = i2;
        return this;
    }

    public DisplayOptions setRouteLineWidth(int i2) {
        int i3 = 5;
        if (i2 >= 5) {
            i3 = 40;
            if (i2 <= 40) {
                this.z = i2;
                return this;
            }
        }
        this.z = i3;
        return this;
    }

    public DisplayOptions setRouteLineZIndex(int i2) {
        if (i2 <= 1) {
            i2 = 2;
        }
        this.t = i2;
        return this;
    }

    public DisplayOptions setSevereCongestionTrafficTexture(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor != null) {
            this.x = bitmapDescriptor;
            return this;
        }
        throw new IllegalArgumentException("BDMapSDKException: SevereCongestionTrafficTexture descriptor is null");
    }

    public DisplayOptions setSlowTrafficTexture(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor != null) {
            this.v = bitmapDescriptor;
            return this;
        }
        throw new IllegalArgumentException("BDMapSDKException: SlowTrafficTexture descriptor is null");
    }

    public DisplayOptions setSmoothTrafficTexture(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor != null) {
            this.u = bitmapDescriptor;
            return this;
        }
        throw new IllegalArgumentException("BDMapSDKException: SmoothTrafficTexture descriptor is null");
    }

    public DisplayOptions setStartPositionIcon(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor != null) {
            this.f7356b = bitmapDescriptor;
            return this;
        }
        throw new IllegalArgumentException("BDMapSDKException: StartPositionIcon descriptor is null");
    }

    public DisplayOptions setStartPositionInfoWindowView(View view) {
        this.B = view;
        return this;
    }

    public DisplayOptions setStartPositionInfoWindowZIndex(int i2) {
        if (i2 <= 1) {
            i2 = 2;
        }
        this.F = i2;
        return this;
    }

    public DisplayOptions setStartPositionMarkerZIndex(int i2) {
        if (i2 <= 1) {
            i2 = 2;
        }
        this.f7359e = i2;
        return this;
    }

    public DisplayOptions setUnknownTrafficTexture(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor != null) {
            this.y = bitmapDescriptor;
            return this;
        }
        throw new IllegalArgumentException("BDMapSDKException: UnknownTrafficTexture descriptor is null");
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
        this.f7361g = z;
        return this;
    }

    public DisplayOptions showEndPositionIconInSpan(boolean z) {
        this.f7362h = z;
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
        this.f7357c = z;
        return this;
    }

    public DisplayOptions showStartPositionIconInSpan(boolean z) {
        this.f7358d = z;
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
