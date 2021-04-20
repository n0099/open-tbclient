package com.baidu.mapsdkplatform.comapi.synchronization.render;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.map.Polyline;
import com.baidu.mapapi.map.PolylineOptions;
import com.baidu.mapapi.map.WinRound;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.mapapi.synchronization.DisplayOptions;
import com.baidu.mapapi.synchronization.RoleOptions;
import com.baidu.mapsdkplatform.comapi.synchronization.data.RouteLineInfo;
import com.baidu.mapsdkplatform.comapi.synchronization.data.SyncResponseResult;
import com.baidu.wallet.base.widget.CustomerServiceMenu;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes2.dex */
public class b extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public static final String f7858a = b.class.getSimpleName();

    /* renamed from: d  reason: collision with root package name */
    public static RoleOptions f7859d = null;

    /* renamed from: e  reason: collision with root package name */
    public static DisplayOptions f7860e = null;

    /* renamed from: f  reason: collision with root package name */
    public static Marker f7861f = null;

    /* renamed from: g  reason: collision with root package name */
    public static volatile SyncResponseResult f7862g = null;

    /* renamed from: h  reason: collision with root package name */
    public static int f7863h = 1000;
    public static volatile int p = 0;
    public static LatLng r = null;
    public boolean A;
    public Thread B;
    public boolean C;
    public int D;
    public int E;
    public LatLngBounds F;
    public e G;
    public volatile long H;
    public boolean I;
    public volatile boolean J;
    public volatile long K;
    public volatile int L;
    public List<LatLng> M;
    public List<BitmapDescriptor> N;
    public Polyline O;
    public List<Integer> P;
    public volatile boolean Q;
    public int R;
    public String S;
    public String T;
    public boolean U;
    public boolean V;
    public volatile int W;
    public volatile boolean X;

    /* renamed from: b  reason: collision with root package name */
    public BaiduMap f7864b;

    /* renamed from: c  reason: collision with root package name */
    public com.baidu.mapsdkplatform.comapi.synchronization.render.d f7865c;
    public Marker i;
    public Marker j;
    public Marker k;
    public Marker l;
    public Marker m;
    public Marker n;
    public List<LinkPointPolyLineInfo> o;
    public Thread q;
    public int s;
    public double t;
    public int u;
    public boolean v;
    public volatile boolean w;
    public Thread x;
    public boolean y;
    public boolean z;

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            while (!b.this.C) {
                if (b.f7862g != null && b.f7862g.a() != null) {
                    if (!b.this.X) {
                        b.this.ak();
                        b.this.I = false;
                        b bVar = b.this;
                        bVar.a(bVar.F);
                    }
                    try {
                        b.this.K = System.currentTimeMillis();
                        if (b.this.H <= 0) {
                            b.this.H = 10000L;
                        }
                        Thread.sleep(b.this.H);
                    } catch (InterruptedException unused) {
                        com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(b.f7858a, "Sleep InterruptedException");
                    }
                }
            }
        }
    }

    /* renamed from: com.baidu.mapsdkplatform.comapi.synchronization.render.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0100b implements Runnable {
        public RunnableC0100b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            LatLng latLng;
            LatLng endPosition;
            while (!b.this.Q) {
                LatLng ac = b.this.ac();
                if (ac == null) {
                    com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(b.f7858a, "Driver position is null, return");
                    return;
                }
                LatLng a2 = b.this.a(ac);
                if (a2 == null) {
                    com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(b.f7858a, "Driver position not bind to route");
                    b.c(b.this);
                    if (!b.this.v || b.this.y) {
                        String str = b.f7858a;
                        com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(str, "Driver position not bind to route times = " + b.this.W);
                        if (2 <= b.this.W) {
                            if (2 >= b.f7863h) {
                                latLng = b.r;
                                endPosition = b.f7859d.getStartPosition();
                            } else if (4 != b.f7863h) {
                                b.this.W = 0;
                                return;
                            } else {
                                latLng = b.r;
                                endPosition = b.f7859d.getEndPosition();
                            }
                            double a3 = com.baidu.mapsdkplatform.comapi.synchronization.d.b.a(latLng, endPosition);
                            String str2 = b.f7858a;
                            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(str2, "Latest driver postion to end position distance = " + a3);
                            if (300.0d >= a3) {
                                if (b.this.O != null) {
                                    b.this.O.remove();
                                }
                                b.this.Q = true;
                                b.this.af();
                            }
                            b.this.W = 0;
                        }
                        b.this.b(ac);
                        b.this.ag();
                        b.this.c(ac);
                        return;
                    }
                    return;
                } else if (b.this.s == 0) {
                    return;
                } else {
                    b bVar = b.this;
                    bVar.t = bVar.ad();
                    if (b.this.t > 500.0d) {
                        b.this.b(a2);
                        b.this.ag();
                        b.this.c(a2);
                        b.this.e(b.p - 1);
                        b.this.L = b.p - 1;
                        return;
                    }
                    b.f7862g.c().setPoint(null);
                    try {
                        b.this.ae();
                    } catch (Exception e2) {
                        com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(b.f7858a, "Catch exception when car moving", e2);
                    }
                    if (b.p >= b.this.o.size()) {
                        b.this.Q = true;
                        b.this.af();
                    }
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            BitmapDescriptor passengerIcon = b.f7860e != null ? b.f7860e.getPassengerIcon() : null;
            if (passengerIcon == null) {
                passengerIcon = new DisplayOptions().getPassengerIcon();
            }
            int passengerMarkerZIndex = b.f7860e.getPassengerMarkerZIndex();
            while (!b.this.w) {
                MyLocationData locationData = b.this.f7864b.getLocationData();
                if (locationData != null && b.this.a(locationData)) {
                    com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(b.f7858a, "Get location data success");
                    LatLng latLng = new LatLng(locationData.latitude, locationData.longitude);
                    if (b.this.n == null) {
                        MarkerOptions zIndex = new MarkerOptions().position(latLng).anchor(0.5f, 0.5f).rotate(locationData.direction).icon(passengerIcon).zIndex(passengerMarkerZIndex);
                        b bVar = b.this;
                        bVar.n = (Marker) bVar.f7864b.addOverlay(zIndex);
                    } else {
                        b.this.n.setPosition(latLng);
                        b.this.n.setRotate(locationData.direction);
                    }
                }
                try {
                    Thread.sleep(b.this.R * 1000);
                } catch (InterruptedException unused) {
                    com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(b.f7858a, "Sleep interrupt");
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public enum d {
        NO_NEED_RENDER,
        RENDER_NEW_LINE,
        UPDATE_TRAFFIC
    }

    /* loaded from: classes2.dex */
    public class e implements BaiduMap.OnSynchronizationListener {

        /* renamed from: b  reason: collision with root package name */
        public int f7874b = 1;

        /* renamed from: c  reason: collision with root package name */
        public int f7875c = 2;

        /* renamed from: d  reason: collision with root package name */
        public int f7876d = 3;

        public e() {
        }

        @Override // com.baidu.mapapi.map.BaiduMap.OnSynchronizationListener
        public void onMapStatusChangeReason(int i) {
            if (this.f7874b == i || this.f7875c == i) {
                long currentTimeMillis = System.currentTimeMillis() - b.this.K;
                if (currentTimeMillis <= 0) {
                    b bVar = b.this;
                    bVar.H = bVar.D * 1000;
                } else {
                    b bVar2 = b.this;
                    bVar2.H = (bVar2.D * 1000) - (b.this.H - currentTimeMillis);
                }
                b.this.J = true;
            } else if (this.f7876d == i) {
                b bVar3 = b.this;
                bVar3.H = bVar3.E * 1000;
            } else {
                String str = b.f7858a;
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(str, "Undefined reason type: " + i);
            }
        }
    }

    public b(Looper looper) {
        super(looper);
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = new CopyOnWriteArrayList();
        this.s = 0;
        this.t = 0.0d;
        this.u = 5;
        this.v = false;
        this.w = false;
        this.y = false;
        this.z = true;
        this.A = false;
        this.C = true;
        this.D = 10;
        this.E = 10;
        this.F = null;
        this.H = 10000L;
        this.I = true;
        this.J = false;
        this.K = 0L;
        this.L = 0;
        this.M = new CopyOnWriteArrayList();
        this.N = new CopyOnWriteArrayList();
        this.O = null;
        this.P = new CopyOnWriteArrayList();
        this.Q = true;
        this.R = 5;
        this.S = null;
        this.T = null;
        this.U = true;
        this.V = false;
        this.W = 0;
        this.X = false;
        this.q = new Thread(new RunnableC0100b(), "Car moving");
        this.x = new Thread(new c(), "Passenger marker");
        this.B = new Thread(new a(), "Adjust visible span");
    }

    private void A() {
        Marker marker = this.k;
        if (marker != null) {
            marker.remove();
            this.k = null;
        }
        Marker marker2 = this.l;
        if (marker2 != null) {
            marker2.remove();
            this.l = null;
        }
    }

    private void B() {
        Marker marker = this.i;
        if (marker != null) {
            marker.remove();
            this.i = null;
        }
        Marker marker2 = this.j;
        if (marker2 != null) {
            marker2.remove();
            this.j = null;
        }
    }

    private void C() {
        Marker marker = this.n;
        if (marker != null) {
            marker.remove();
            this.n = null;
        }
    }

    private void D() {
        Marker marker = this.m;
        if (marker != null) {
            marker.remove();
            this.m = null;
        }
        Marker marker2 = f7861f;
        if (marker2 != null) {
            marker2.remove();
            f7861f = null;
        }
    }

    private void E() {
        if (!this.v || this.A) {
            return;
        }
        Polyline polyline = this.O;
        if (polyline != null) {
            polyline.remove();
            this.o.clear();
            this.M.clear();
            this.N.clear();
            this.P.clear();
            f7862g = null;
        }
        this.S = null;
        this.T = null;
    }

    private void F() {
        Marker marker = this.j;
        if (marker != null) {
            marker.remove();
            this.j = null;
        }
    }

    private void G() {
        Marker marker = f7861f;
        if (marker != null) {
            marker.remove();
            f7861f = null;
        }
    }

    private void H() {
        if (!this.v || this.y) {
            return;
        }
        this.Q = true;
    }

    private void I() {
        if (!f7860e.isShowStartPositionMarker()) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f7858a, "User set start position marker not show");
            Marker marker = this.i;
            if (marker != null) {
                marker.remove();
                this.i = null;
            }
        } else if (this.i != null && !this.v) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f7858a, "Start position marker already render ok");
        } else {
            LatLng J = J();
            if (J == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7858a, "No startPosition");
                return;
            }
            BitmapDescriptor startPositionIcon = f7860e.getStartPositionIcon();
            if (startPositionIcon == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7858a, "No startPositionIcon, use default");
                startPositionIcon = new DisplayOptions().getStartPositionIcon();
            }
            if (startPositionIcon == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7858a, "There is no startPositionIcon");
                return;
            }
            MarkerOptions zIndex = new MarkerOptions().position(J).icon(startPositionIcon).zIndex(f7860e.getStartPositionMarkerZIndex());
            Marker marker2 = this.i;
            if (marker2 == null) {
                this.i = (Marker) this.f7864b.addOverlay(zIndex);
                return;
            }
            marker2.setIcon(startPositionIcon);
            this.i.setPosition(J);
        }
    }

    private LatLng J() {
        LatLng startPosition = f7859d.getStartPosition();
        if (startPosition == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7858a, "The start position is null");
            com.baidu.mapsdkplatform.comapi.synchronization.render.d dVar = this.f7865c;
            if (dVar != null) {
                dVar.a(CustomerServiceMenu.TRANSFER_RECORD, "Start position is null");
            }
        }
        return startPosition;
    }

    private void K() {
        if (!f7860e.isShowStartPositionInfoWindow()) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f7858a, "User set start position infoWindow not show");
            Marker marker = this.j;
            if (marker != null) {
                marker.remove();
                this.j = null;
                return;
            }
            return;
        }
        LatLng startPosition = f7859d.getStartPosition();
        if (startPosition == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7858a, "No startPosition");
            return;
        }
        View startPositionInfoWindowView = f7860e.getStartPositionInfoWindowView();
        if (startPositionInfoWindowView == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7858a, "Start position infoWindow view is null, cannot display");
            Marker marker2 = this.j;
            if (marker2 != null) {
                marker2.remove();
                this.j = null;
                return;
            }
            return;
        }
        MarkerOptions alpha = new MarkerOptions().position(startPosition).icon(BitmapDescriptorFactory.fromView(startPositionInfoWindowView)).zIndex(f7860e.getStartPositionInfoWindowZIndex()).alpha(0.9f);
        Marker marker3 = this.j;
        if (marker3 == null) {
            this.j = (Marker) this.f7864b.addOverlay(alpha);
            return;
        }
        marker3.setPosition(startPosition);
        this.j.setIcon(BitmapDescriptorFactory.fromView(startPositionInfoWindowView));
    }

    private void L() {
        String str;
        String str2;
        if (!f7860e.isShowEndPositionMarker()) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f7858a, "User set endPositionMarker not show");
            Marker marker = this.k;
            if (marker != null) {
                marker.remove();
                this.k = null;
                return;
            }
            return;
        }
        if (this.k == null || this.v) {
            LatLng endPosition = f7859d.getEndPosition();
            if (endPosition == null) {
                str = f7858a;
                str2 = "End position coord is null";
            } else {
                BitmapDescriptor endPositionIcon = f7860e.getEndPositionIcon();
                if (endPositionIcon == null) {
                    com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7858a, "The end position icon is null");
                    endPositionIcon = new DisplayOptions().getEndPositionIcon();
                }
                if (endPositionIcon != null) {
                    MarkerOptions zIndex = new MarkerOptions().position(endPosition).icon(endPositionIcon).zIndex(f7860e.getEndPositionMarkerZIndex());
                    Marker marker2 = this.k;
                    if (marker2 == null) {
                        this.k = (Marker) this.f7864b.addOverlay(zIndex);
                        return;
                    }
                    marker2.setIcon(endPositionIcon);
                    this.k.setPosition(endPosition);
                    return;
                }
                str = f7858a;
                str2 = "There is no endPositionIcon";
            }
        } else {
            str = f7858a;
            str2 = "EndPositionMarker already render ok";
        }
        com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(str, str2);
    }

    private void M() {
        if (!f7860e.isShowEndPositionInfoWindow()) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f7858a, "User set end position infoWindow not show");
            Marker marker = this.l;
            if (marker != null) {
                marker.remove();
                this.l = null;
                return;
            }
            return;
        }
        LatLng endPosition = f7859d.getEndPosition();
        if (endPosition == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7858a, "End position coord is null when render end position infoWindow");
            return;
        }
        View endPositionInfoWindowView = f7860e.getEndPositionInfoWindowView();
        if (endPositionInfoWindowView == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7858a, "End position infoWindow view is null, cannot display");
            Marker marker2 = this.l;
            if (marker2 != null) {
                marker2.remove();
                this.l = null;
                return;
            }
            return;
        }
        MarkerOptions zIndex = new MarkerOptions().position(endPosition).icon(BitmapDescriptorFactory.fromView(endPositionInfoWindowView)).anchor(0.5f, 1.0f).zIndex(f7860e.getEndPositionInfoWindowZIndex());
        Marker marker3 = this.l;
        if (marker3 == null) {
            this.l = (Marker) this.f7864b.addOverlay(zIndex);
            return;
        }
        marker3.setPosition(endPosition);
        this.l.setIcon(BitmapDescriptorFactory.fromView(endPositionInfoWindowView));
    }

    private synchronized void N() {
        if (this.x == null) {
            return;
        }
        this.w = false;
        if (Thread.State.NEW == this.x.getState()) {
            this.x.start();
        }
        if (this.v && Thread.State.TERMINATED == this.x.getState()) {
            this.x = null;
            Thread thread = new Thread(new c(), "Passenger marker");
            this.x = thread;
            thread.start();
        }
    }

    private void O() {
        if (f7860e.isShowPassengerIcon()) {
            N();
            return;
        }
        com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f7858a, "User set not show passenger icon");
        Marker marker = this.n;
        if (marker != null) {
            marker.remove();
            this.n = null;
        }
    }

    private synchronized void P() {
        this.w = true;
        if (this.x != null && (Thread.State.NEW != this.x.getState() || Thread.State.TERMINATED != this.x.getState())) {
            this.x.interrupt();
        }
    }

    private void Q() {
        if (!f7860e.isShowCarMarker()) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f7858a, "User set carMarker not show");
            Marker marker = this.m;
            if (marker != null) {
                marker.remove();
                this.m = null;
            }
        } else if (this.m != null && !this.v) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f7858a, "CarIcon already render ok");
        } else {
            LatLng T = T();
            if (T == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7858a, "The car(driver) position is null");
                return;
            }
            BitmapDescriptor carIcon = f7860e.getCarIcon();
            if (carIcon == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7858a, "The car icon is null");
                carIcon = new DisplayOptions().getCarIcon();
            }
            if (carIcon == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7858a, "There is no car icon");
                return;
            }
            MarkerOptions anchor = new MarkerOptions().position(T).icon(carIcon).flat(true).rotate(0.0f).zIndex(f7860e.getCarPositionMarkerZIndex()).anchor(0.5f, 0.5f);
            Marker marker2 = this.m;
            if (marker2 == null) {
                this.m = (Marker) this.f7864b.addOverlay(anchor);
                return;
            }
            marker2.setPosition(T);
            this.m.setIcon(carIcon);
        }
    }

    private void R() {
        if (!f7860e.isShowCarInfoWindow()) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f7858a, "User set carInfoWindow not show");
            Marker marker = f7861f;
            if (marker != null) {
                marker.remove();
                f7861f = null;
                return;
            }
            return;
        }
        View carInfoWindowView = f7860e.getCarInfoWindowView();
        if (carInfoWindowView == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7858a, "car position infoWindow view is null, cannot display");
            Marker marker2 = f7861f;
            if (marker2 != null) {
                marker2.remove();
                f7861f = null;
                return;
            }
            return;
        }
        LatLng S = S();
        if (S == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7858a, "CarPosition is null");
            return;
        }
        MarkerOptions alpha = new MarkerOptions().position(S).icon(BitmapDescriptorFactory.fromView(carInfoWindowView)).zIndex(f7860e.getCarPositionInfoWindowZIndex()).anchor(0.5f, 1.0f).alpha(0.9f);
        Marker marker3 = f7861f;
        if (marker3 == null) {
            f7861f = (Marker) this.f7864b.addOverlay(alpha);
            return;
        }
        marker3.setPosition(S);
        f7861f.setIcon(BitmapDescriptorFactory.fromView(carInfoWindowView));
    }

    private LatLng S() {
        if (this.m != null || f7862g == null) {
            Marker marker = this.m;
            if (marker != null) {
                return marker.getPosition();
            }
            return null;
        }
        return f7862g.c().getPoint();
    }

    private LatLng T() {
        LatLng latLng = r;
        return latLng != null ? latLng : (f7862g == null || f7862g.c() == null || f7862g.c().getPoint() == null) ? f7859d.getDriverPosition() : f7862g.c().getPoint();
    }

    private void U() {
        DisplayOptions displayOptions = f7860e;
        if (displayOptions == null) {
            return;
        }
        if (!displayOptions.isShowRoutePlan()) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f7858a, "User set route line not show");
            Polyline polyline = this.O;
            if (polyline != null) {
                polyline.remove();
                this.O = null;
            }
        } else if (f7862g == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7858a, "No route line data");
        } else {
            d V = V();
            if (d.NO_NEED_RENDER == V) {
                this.z = false;
            } else if (d.UPDATE_TRAFFIC == V) {
                this.z = false;
                W();
            } else {
                this.z = true;
                if (!this.Q) {
                    this.Q = true;
                    try {
                        Thread.sleep(100L);
                    } catch (Exception e2) {
                        com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f7858a, "Exception caught when renderRouteLine", e2);
                    }
                }
                p = 0;
                this.s = 0;
                this.L = 0;
                this.o.clear();
                this.M.clear();
                this.N.clear();
                this.P.clear();
                Polyline polyline2 = this.O;
                if (polyline2 != null) {
                    polyline2.remove();
                    this.O = null;
                }
                X();
                List<LinkPointPolyLineInfo> list = this.o;
                if (list == null || list.isEmpty()) {
                    com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7858a, "LinkPointPolyline info is null");
                } else {
                    Y();
                }
            }
        }
    }

    private d V() {
        String a2 = f7862g.a().a();
        String a3 = f7862g.b().a();
        if (this.v && !this.A) {
            this.S = null;
            this.T = null;
        }
        if (a2 != null && (TextUtils.isEmpty(this.S) || !this.S.equals(a2) || this.O == null)) {
            this.S = a2;
            this.T = a3;
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7858a, "Route line or order state changed or no render, need render");
            return d.RENDER_NEW_LINE;
        } else if (a3 == null || this.O == null || (!TextUtils.isEmpty(this.T) && this.T.equals(a3))) {
            return d.NO_NEED_RENDER;
        } else {
            this.T = a3;
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7858a, "Route line only need update traffic");
            return d.UPDATE_TRAFFIC;
        }
    }

    private void W() {
        int size;
        int[] iArr;
        ArrayList<Integer> b2 = f7862g.b().b();
        if (b2 == null || b2.isEmpty()) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7858a, "Traffic status data is null");
            return;
        }
        if (!this.Q) {
            this.Q = true;
        }
        if (p - this.s < 0) {
            return;
        }
        try {
            if (b2.size() == this.o.size()) {
                for (int i = p - this.s; i < this.o.size(); i++) {
                    this.P.set(i, b2.get(i));
                }
            } else {
                for (int i2 = p - this.s; i2 < this.o.size(); i2++) {
                    this.P.set(i2, b2.get((b2.size() + i2) - this.o.size()));
                }
            }
            size = (this.P.size() - p) + this.s;
            iArr = new int[size];
            for (int i3 = 0; i3 < (this.P.size() - p) + this.s; i3++) {
                iArr[i3] = this.P.get((p + i3) - this.s).intValue();
            }
        } catch (Exception e2) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f7858a, "Exception caught when updateTrafficStatus", e2);
        }
        if (size <= 0) {
            return;
        }
        this.O.setIndexs(iArr);
        if (this.Q) {
            this.Q = false;
        }
    }

    private void X() {
        if (f7862g == null || f7862g.a() == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7858a, "Route info or syncResponseResult is null");
            return;
        }
        List<RouteLineInfo.RouteSectionInfo> b2 = f7862g.a().b();
        ArrayList<Integer> b3 = f7862g.b().b();
        if (b2 == null || b2.isEmpty()) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7858a, "route section info is null");
        } else if (b2.isEmpty() || b3 == null || b3.isEmpty() || b3.size() == b2.size()) {
            for (int i = 0; i < b2.size(); i++) {
                if (b2.get(i) != null) {
                    LatLng a2 = b2.get(i).a();
                    LatLng b4 = b2.get(i).b();
                    int a3 = a(i, b3);
                    LinkPointPolyLineInfo linkPointPolyLineInfo = new LinkPointPolyLineInfo();
                    linkPointPolyLineInfo.a(a2);
                    linkPointPolyLineInfo.b(b4);
                    linkPointPolyLineInfo.a(a3);
                    this.o.add(linkPointPolyLineInfo);
                    this.M.add(a2);
                }
            }
            this.M.add(b2.get(b2.size() - 1).b());
        } else {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7858a, "route section info or traffic status info is invalid");
        }
    }

    private void Y() {
        if (!this.Q) {
            this.Q = true;
        }
        LatLng point = (f7862g == null || f7862g.c() == null) ? null : f7862g.c().getPoint();
        LatLng a2 = point != null ? a(point) : null;
        if (a2 != null) {
            this.s = 0;
            try {
                this.o = this.o.subList(p, this.o.size());
                this.M = this.M.subList(p, this.M.size());
            } catch (Exception e2) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f7858a, "Caught exception when renderRoutePolyLine", e2);
            }
            b(a2);
            ag();
            c(a2);
            this.L = p;
        }
        p = 0;
        int size = this.M.size();
        if (size < 3) {
            return;
        }
        for (int i = 0; i < size - 1; i++) {
            if (this.M.get(i) != null) {
                this.P.add(Integer.valueOf(this.o.get(i).c()));
            }
        }
        if (this.N.isEmpty()) {
            this.N.addAll(f7860e.getTrafficTextureList());
        }
        DisplayOptions displayOptions = f7860e;
        if (displayOptions == null) {
            displayOptions = new DisplayOptions();
        }
        PolylineOptions zIndex = new PolylineOptions().points(this.M).dottedLine(true).width(displayOptions.getRouteLineWidth()).customTextureList(this.N).textureIndex(this.P).zIndex(f7860e.getRouteLineZIndex());
        if (!f7860e.isShowRoutePlan()) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7858a, "User set route line not display");
            zIndex.visible(false);
        }
        this.O = (Polyline) this.f7864b.addOverlay(zIndex);
        if (this.Q) {
            this.Q = false;
        }
    }

    private void Z() {
        List<LinkPointPolyLineInfo> list;
        if (this.m == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7858a, "CarMarker is null");
        } else if (r != null || (list = this.o) == null || list.isEmpty()) {
            aa();
        } else {
            LatLng a2 = this.o.get(0).a();
            r = a2;
            b(a2);
            c(r);
        }
    }

    private double a(double d2) {
        if (this.u == 0) {
            this.u = 5;
        }
        return (Math.abs(d2) * this.u) / this.t;
    }

    private double a(double d2, double d3) {
        return d3 == Double.MAX_VALUE ? d2 : Math.abs((d2 * d3) / Math.sqrt((d3 * d3) + 1.0d));
    }

    private double a(double d2, LatLng latLng) {
        return latLng.latitude - (d2 * latLng.longitude);
    }

    private int a(int i, ArrayList<Integer> arrayList) {
        if (arrayList == null || arrayList.isEmpty() || i >= arrayList.size()) {
            return 0;
        }
        return arrayList.get(i).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public LatLng a(LatLng latLng) {
        if (3 == f7863h) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f7858a, "WAIT_PASSENGER State, no need calculate");
            return null;
        }
        List<LinkPointPolyLineInfo> list = this.o;
        if (list == null || list.isEmpty()) {
            String str = f7858a;
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(str, "mLinkPolyLineInfos size = " + this.o.size());
            return null;
        }
        for (int i = p; i < this.o.size(); i++) {
            LatLng a2 = this.o.get(i).a();
            LatLng b2 = this.o.get(i).b();
            if (!a(latLng, a2)) {
                if (a(latLng, b2)) {
                    this.s = d(i + 1);
                    return b2;
                }
                boolean a3 = a(a2, b2, latLng);
                boolean b3 = b(a2, b2, latLng);
                if (!a3 || !b3) {
                }
            }
            this.s = d(i);
            return a2;
        }
        return null;
    }

    private void a(LatLngBounds.Builder builder) {
        DisplayOptions displayOptions = f7860e;
        if (displayOptions == null || displayOptions.isShowStartPositionMarkerInSpan()) {
            builder.include(J());
        } else {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7858a, "User set not show startPositionMarker in span");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(LatLngBounds latLngBounds) {
        int i;
        int i2;
        int i3;
        int i4;
        if (this.J && !this.X) {
            this.J = false;
            return;
        }
        MapStatus mapStatus = this.f7864b.getMapStatus();
        if (mapStatus == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7858a, "Get map status failed");
            return;
        }
        WinRound winRound = mapStatus.winRound;
        int abs = Math.abs(winRound.right - winRound.left);
        int abs2 = Math.abs(winRound.bottom - winRound.top);
        if (f7860e != null) {
            i = f7860e.getPaddingLeft();
            i2 = f7860e.getPaddingTop();
            i3 = f7860e.getPaddingRight();
            i4 = f7860e.getPaddingBottom();
        } else {
            i = 50;
            i2 = 50;
            i3 = 50;
            i4 = 50;
        }
        int i5 = (abs - i) - i3;
        int i6 = (abs2 - i2) - i4;
        if (i5 < 0 || i6 < 0 || i5 > abs || i6 > abs2) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7858a, "Invalid width and height，use default padding");
            i5 = (abs - 50) - 50;
            i6 = (abs2 - 50) - 50;
        }
        this.f7864b.animateMapStatus(MapStatusUpdateFactory.newLatLngBounds(latLngBounds, i5, i6));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(MyLocationData myLocationData) {
        long j;
        long j2;
        try {
            j = Double.valueOf(myLocationData.latitude).longValue();
        } catch (NumberFormatException unused) {
            j = 0;
        }
        try {
            j2 = Double.valueOf(myLocationData.longitude).longValue();
        } catch (NumberFormatException unused2) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7858a, "Trans latitude and longitude failed");
            j2 = 0;
            if (0 == j) {
            }
        }
        return (0 == j || 0 != j2) && j >= -90 && j <= 90 && j2 >= -180 && j2 <= 180;
    }

    private boolean a(LatLng latLng, LatLng latLng2) {
        return (latLng == null || latLng2 == null) ? latLng == null && latLng2 == null : Math.abs(latLng.latitude - latLng2.latitude) < 1.0E-4d && Math.abs(latLng.longitude - latLng2.longitude) < 1.0E-4d;
    }

    private boolean a(LatLng latLng, LatLng latLng2, double d2) {
        double d3;
        LatLng latLng3;
        boolean z = latLng.latitude > latLng2.latitude;
        double a2 = a(d2, latLng);
        double f2 = f(latLng, latLng2);
        double a3 = z ? a(f2, d2) : a(f2, d2) * (-1.0d);
        double a4 = a(a3);
        double d4 = latLng.latitude;
        double d5 = a3;
        while (true) {
            if ((d4 > latLng2.latitude) != z) {
                return true;
            }
            if (this.Q) {
                return false;
            }
            if (Double.MAX_VALUE == d2) {
                d3 = a4;
                latLng3 = new LatLng(d4, latLng.longitude);
            } else {
                d3 = a4;
                latLng3 = new LatLng(d4, (d4 - a2) / d2);
            }
            b(latLng3);
            c(latLng3);
            double d6 = d3;
            if (!b(d6)) {
                return false;
            }
            d4 -= d5;
            a4 = d6;
        }
    }

    private boolean a(LatLng latLng, LatLng latLng2, LatLng latLng3) {
        double d2 = latLng.latitude;
        double d3 = latLng.longitude;
        double d4 = latLng2.latitude;
        return Math.abs(((latLng3.latitude - d2) * (latLng2.longitude - d3)) - ((d4 - d2) * (latLng3.longitude - d3))) < 1.0E-4d;
    }

    private synchronized void aa() {
        if (this.q == null) {
            return;
        }
        this.Q = false;
        if (Thread.State.NEW == this.q.getState()) {
            this.q.start();
            return;
        }
        if (Thread.State.TERMINATED == this.q.getState()) {
            this.q = null;
            Thread thread = new Thread(new RunnableC0100b(), "Car moving");
            this.q = thread;
            thread.start();
        }
    }

    private synchronized void ab() {
        this.Q = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public LatLng ac() {
        if (f7862g == null || f7862g.c() == null || f7862g.c().getPoint() == null || this.V) {
            return null;
        }
        return f7862g.c().getPoint();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public double ad() {
        List<LinkPointPolyLineInfo> list = this.o;
        if (list == null || list.isEmpty() || p > this.o.size()) {
            return 1.0d;
        }
        double d2 = 0.0d;
        for (int i = p - this.s; i < p; i++) {
            d2 += f(this.o.get(i).a(), this.o.get(i).b());
        }
        return d2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ae() {
        if (p == 0) {
            return;
        }
        for (int i = p - this.s; i < p; i++) {
            LatLng a2 = this.o.get(i).a();
            LatLng b2 = this.o.get(i).b();
            double f2 = f(a2, b2) / 2.0d;
            double d2 = (b2.latitude - a2.latitude) / f2;
            double d3 = (b2.longitude - a2.longitude) / f2;
            double e2 = e(a2, b2);
            int i2 = 1;
            while (i2 <= f2) {
                double d4 = a2.longitude;
                double d5 = f2;
                double d6 = a2.latitude;
                if (0.0d == e2) {
                    d4 += d3;
                } else {
                    if (Double.MAX_VALUE != e2) {
                        d4 += d3;
                    }
                    d6 += d2;
                }
                LatLng latLng = new LatLng(d6, d4);
                List<LatLng> list = this.M;
                if (list != null && !list.isEmpty()) {
                    if (this.z) {
                        this.Q = true;
                        return;
                    }
                    this.M.set(i, latLng);
                }
                List<Integer> list2 = this.P;
                if (list2 != null && !list2.isEmpty()) {
                    this.P.set(i, Integer.valueOf(this.o.get(i).c()));
                }
                if (!b(a2, latLng)) {
                    return;
                }
                this.L = i;
                e(i);
                i2++;
                a2 = latLng;
                f2 = d5;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void af() {
        p = 0;
        this.s = 0;
        this.o.clear();
        this.M.clear();
        this.P.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ag() {
        if (this.m == null) {
            return;
        }
        float f2 = 0.0f;
        try {
            f2 = Double.valueOf(360.0d - f7862g.c().getAngle()).floatValue();
        } catch (NumberFormatException e2) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f7858a, "Get DriverPosition Angle failed", e2);
        }
        this.m.setRotate(f2);
    }

    private synchronized void ah() {
        this.C = true;
    }

    private synchronized void ai() {
        if (this.B == null) {
            return;
        }
        if (this.C) {
            this.C = false;
        }
        if (Thread.State.NEW == this.B.getState()) {
            this.I = true;
            this.B.start();
        }
        if (this.v && Thread.State.TIMED_WAITING == this.B.getState()) {
            this.B.interrupt();
            this.I = true;
        }
        if (Thread.State.TERMINATED == this.B.getState()) {
            this.B = null;
            this.I = true;
            Thread thread = new Thread(new a(), "Adjust visible span");
            this.B = thread;
            thread.start();
        }
    }

    private void aj() {
        this.f7864b.setOnSynchronizationListener(this.G);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ak() {
        int i = f7863h;
        if (i != 0) {
            if (i == 1) {
                al();
                return;
            } else if (i == 2) {
                am();
                return;
            } else if (i == 3) {
                an();
                return;
            } else if (i == 4) {
                ao();
                return;
            } else if (i != 5) {
                return;
            }
        }
        ah();
    }

    private void al() {
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        a(builder);
        d(builder);
        c(builder);
        e(builder);
        this.F = h(builder);
    }

    private void am() {
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        a(builder);
        c(builder);
        d(builder);
        e(builder);
        this.F = h(builder);
    }

    private void an() {
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        a(builder);
        c(builder);
        d(builder);
        this.F = h(builder);
    }

    private void ao() {
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        b(builder);
        c(builder);
        e(builder);
        this.F = h(builder);
    }

    private double b(LatLng latLng, LatLng latLng2, double d2) {
        if (Double.MAX_VALUE == d2) {
            return latLng2.latitude > latLng.latitude ? 360.0d : 180.0d;
        }
        if (0.0d == d2) {
            return latLng2.longitude > latLng.longitude ? 270.0d : 90.0d;
        }
        return (((Math.atan(d2) / 3.141592653589793d) * 180.0d) + ((latLng2.latitude - latLng.latitude) * d2 < 0.0d ? 180.0d : 0.0d)) - 90.0d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(LatLng latLng) {
        Marker marker = this.m;
        if (marker != null) {
            marker.setPosition(latLng);
        }
    }

    private void b(LatLngBounds.Builder builder) {
        DisplayOptions displayOptions = f7860e;
        if (displayOptions == null || displayOptions.isShowEndPositionMarkerInSpan()) {
            builder.include(f7859d.getEndPosition());
        } else {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7858a, "User set not show endPositionMarker in span");
        }
    }

    private boolean b(double d2) {
        try {
            Thread.sleep(Double.valueOf((d2 * 1000.0d) + 50.0d).longValue());
            return true;
        } catch (InterruptedException unused) {
            return false;
        } catch (NumberFormatException e2) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f7858a, "Calc sleep interval failed", e2);
            return false;
        }
    }

    private boolean b(LatLng latLng, LatLng latLng2) {
        if (this.Q) {
            return false;
        }
        b(latLng);
        c(latLng);
        double e2 = e(latLng, latLng2);
        float b2 = (float) b(latLng, latLng2, e2);
        Marker marker = this.m;
        if (marker != null) {
            marker.setRotate(b2);
        }
        boolean c2 = 0.0d == e2 ? c(latLng, latLng2) : a(latLng, latLng2, e2);
        if (c2) {
            r = latLng2;
        }
        return c2;
    }

    private boolean b(LatLng latLng, LatLng latLng2, LatLng latLng3) {
        double d2 = latLng.latitude;
        double d3 = latLng.longitude;
        double d4 = latLng2.latitude;
        double d5 = latLng2.longitude;
        double d6 = latLng3.latitude;
        double d7 = latLng3.longitude;
        return Math.min(d2, d4) - 1.0E-4d <= d6 && d6 <= Math.max(d2, d4) + 1.0E-4d && Math.min(d3, d5) - 1.0E-4d <= d7 && d7 <= Math.max(d3, d5) + 1.0E-4d;
    }

    public static /* synthetic */ int c(b bVar) {
        int i = bVar.W;
        bVar.W = i + 1;
        return i;
    }

    private void c(int i) {
        this.y = 1000 == f7863h;
        this.A = (1 == f7863h && 2 == i) || (1 == i && 2 == f7863h);
        if (f7863h == i) {
            this.v = false;
            return;
        }
        f7863h = i;
        this.v = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(LatLng latLng) {
        Marker marker = f7861f;
        if (marker != null) {
            marker.setPosition(latLng);
        }
    }

    private void c(LatLngBounds.Builder builder) {
        DisplayOptions displayOptions = f7860e;
        if (displayOptions != null && !displayOptions.isShowCarMarkerInSpan()) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7858a, "User set not show carMarker in span");
            return;
        }
        Marker marker = this.m;
        builder.include((marker == null || this.I) ? T() : marker.getPosition());
    }

    private boolean c(LatLng latLng, LatLng latLng2) {
        double d2 = d(latLng, latLng2);
        double a2 = a(d2);
        for (double d3 = latLng.longitude; d3 <= latLng2.longitude; d3 += d2) {
            if (this.Q) {
                return false;
            }
            LatLng latLng3 = new LatLng(latLng.latitude, d3);
            b(latLng3);
            c(latLng3);
            if (!b(a2)) {
                return false;
            }
        }
        return true;
    }

    private double d(LatLng latLng, LatLng latLng2) {
        return com.baidu.mapsdkplatform.comapi.synchronization.d.b.a(latLng, latLng2);
    }

    private synchronized int d(int i) {
        int i2;
        i2 = i - p;
        p = i;
        return i2;
    }

    private void d(LatLngBounds.Builder builder) {
        LatLng position;
        String str;
        String str2;
        DisplayOptions displayOptions = f7860e;
        if (displayOptions == null || displayOptions.isShowPassengerIconInSpan()) {
            Marker marker = this.n;
            if (marker == null) {
                MyLocationData locationData = this.f7864b.getLocationData();
                if (locationData == null) {
                    str = f7858a;
                    str2 = "No passenger location data";
                } else if (!a(locationData)) {
                    return;
                } else {
                    position = new LatLng(locationData.latitude, locationData.longitude);
                }
            } else {
                position = marker.getPosition();
            }
            builder.include(position);
            return;
        }
        str = f7858a;
        str2 = "User set not show passengerMarker in span";
        com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(str, str2);
    }

    private double e(LatLng latLng, LatLng latLng2) {
        double d2 = latLng2.longitude;
        double d3 = latLng.longitude;
        if (d2 == d3) {
            return Double.MAX_VALUE;
        }
        return (latLng2.latitude - latLng.latitude) / (d2 - d3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(int i) {
        int[] iArr;
        List<LatLng> list = this.M;
        if (list == null || list.isEmpty()) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7858a, "Route polyline points is null when remove");
        } else if (this.M.size() <= 2 || i >= this.M.size() - 2) {
            Polyline polyline = this.O;
            if (polyline != null) {
                polyline.remove();
            }
        } else {
            List<Integer> list2 = this.P;
            if (list2 == null || list2.isEmpty()) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7858a, "No need removeTravelledPolyLine");
            } else if (!this.z) {
                try {
                    List<Integer> subList = this.P.subList(i, this.P.size());
                    iArr = new int[subList.size()];
                    for (int i2 = 0; i2 < subList.size(); i2++) {
                        iArr[i2] = subList.get(i2).intValue();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                if (this.O != null && !this.Q) {
                    this.O.setIndexs(iArr);
                    try {
                        this.O.setPoints(this.M.subList(i, this.M.size()));
                    } catch (Exception e3) {
                        com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f7858a, "Get subList of PolyLinePointList failed", e3);
                    }
                }
            }
        }
    }

    private void e(LatLngBounds.Builder builder) {
        DisplayOptions displayOptions = f7860e;
        if (displayOptions != null && !displayOptions.isShowRoutePlanInSpan()) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7858a, "User set not show routeLine in span");
            return;
        }
        List<LinkPointPolyLineInfo> list = this.o;
        if (list == null || list.isEmpty()) {
            g(builder);
        } else {
            f(builder);
        }
    }

    private double f(LatLng latLng, LatLng latLng2) {
        return com.baidu.mapsdkplatform.comapi.synchronization.d.b.a(latLng, latLng2);
    }

    private void f(LatLngBounds.Builder builder) {
        for (int i = this.L; i < this.o.size(); i++) {
            builder.include(this.o.get(i).a());
        }
        List<LinkPointPolyLineInfo> list = this.o;
        builder.include(list.get(list.size() - 1).b());
    }

    private void g(LatLngBounds.Builder builder) {
        if (f7862g == null || f7862g.a() == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7858a, "There no routeLine info, no need show in span");
            return;
        }
        List<RouteLineInfo.RouteSectionInfo> b2 = f7862g.a().b();
        if (b2 == null || b2.isEmpty()) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7858a, "There no routeLine position, no need show in span");
            return;
        }
        for (int i = 0; i < b2.size(); i++) {
            builder.include(b2.get(i).a());
        }
        builder.include(b2.get(b2.size() - 1).b());
    }

    private LatLngBounds h(LatLngBounds.Builder builder) {
        return builder.build();
    }

    private void o() {
        if (f7860e == null) {
            return;
        }
        Marker marker = f7861f;
        if (marker != null) {
            marker.remove();
            f7861f = null;
        }
        Marker marker2 = this.m;
        if (marker2 != null) {
            marker2.remove();
            this.m = null;
        }
        Marker marker3 = this.i;
        if (marker3 != null) {
            marker3.remove();
            this.i = null;
        }
        Marker marker4 = this.j;
        if (marker4 != null) {
            marker4.remove();
            this.j = null;
        }
        Marker marker5 = this.l;
        if (marker5 != null) {
            marker5.remove();
            this.l = null;
        }
        f7860e.getStartPositionIcon().recycle();
        f7860e.getCarIcon().recycle();
        if (f7860e.getEndPositionIcon() != null) {
            f7860e.getEndPositionIcon().recycle();
        }
        f7860e = null;
    }

    private void p() {
        p = 0;
        this.u = 0;
        this.Q = true;
        Thread thread = this.q;
        if (thread != null) {
            try {
                thread.join();
            } catch (InterruptedException unused) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7858a, "InterruptedException when release CarMoveThread");
            }
            this.q = null;
        }
    }

    private void q() {
        this.w = true;
        if (this.x != null) {
            this.x = null;
        }
    }

    private void r() {
        this.C = true;
        if (this.B != null) {
            this.B = null;
        }
    }

    private void s() {
        f7859d = null;
        f7862g = null;
        f7863h = 1000;
        this.Q = false;
        this.U = true;
        this.V = false;
        this.o.clear();
        p = 0;
        r = null;
        this.s = 0;
        this.t = 0.0d;
        this.M.clear();
        this.P.clear();
        Polyline polyline = this.O;
        if (polyline != null) {
            polyline.remove();
            this.O = null;
        }
        for (int i = 0; i < this.N.size(); i++) {
            this.N.get(i).recycle();
        }
        this.N.clear();
        this.f7864b.clear();
    }

    private void t() {
        P();
        H();
        ah();
        E();
        A();
        B();
        C();
        D();
        BaiduMap baiduMap = this.f7864b;
        if (baiduMap != null) {
            baiduMap.clear();
        }
    }

    private void u() {
        if (z()) {
            E();
            H();
            ai();
            I();
            K();
            L();
            M();
            O();
            Q();
            R();
            U();
            Z();
        }
    }

    private void v() {
        if (z()) {
            E();
            H();
            ai();
            I();
            K();
            L();
            M();
            O();
            Q();
            R();
            U();
            Z();
        }
    }

    private void w() {
        if (z()) {
            E();
            G();
            F();
            H();
            ai();
            I();
            K();
            L();
            M();
            O();
            Q();
            R();
            Z();
        }
    }

    private void x() {
        if (z()) {
            P();
            E();
            B();
            C();
            H();
            ai();
            I();
            K();
            L();
            M();
            Q();
            R();
            U();
            Z();
        }
    }

    private void y() {
        P();
        H();
        ah();
        A();
        B();
        C();
        D();
        BaiduMap baiduMap = this.f7864b;
        if (baiduMap != null) {
            baiduMap.clear();
        }
    }

    private boolean z() {
        if (f7859d == null || f7860e == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7858a, "No render data");
            com.baidu.mapsdkplatform.comapi.synchronization.render.d dVar = this.f7865c;
            if (dVar != null) {
                dVar.a(CustomerServiceMenu.TRANSFER_RECORD, "Get render data failed");
            }
            return false;
        } else if (this.f7864b == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f7858a, "BaiduMap is null");
            com.baidu.mapsdkplatform.comapi.synchronization.render.d dVar2 = this.f7865c;
            if (dVar2 != null) {
                dVar2.a(CustomerServiceMenu.TRANSFER_SERVICE, "BaiduMap instance is null.");
            }
            return false;
        } else {
            return true;
        }
    }

    public Marker a() {
        return this.i;
    }

    public void a(int i) {
        this.D = i;
    }

    public void a(BaiduMap baiduMap, RoleOptions roleOptions, DisplayOptions displayOptions) {
        this.f7864b = baiduMap;
        f7859d = roleOptions;
        f7860e = displayOptions;
        this.G = new e();
        aj();
        r = null;
        this.f7864b.getUiSettings().setRotateGesturesEnabled(false);
        this.f7864b.getUiSettings().setCompassEnabled(false);
    }

    public synchronized void a(RoleOptions roleOptions, DisplayOptions displayOptions, SyncResponseResult syncResponseResult, int i) {
        f7859d = roleOptions;
        f7860e = displayOptions;
        if (displayOptions == null) {
            f7860e = new DisplayOptions();
        }
        f7862g = syncResponseResult;
        this.u = i;
    }

    public void a(com.baidu.mapsdkplatform.comapi.synchronization.render.d dVar) {
        this.f7865c = dVar;
    }

    public Marker b() {
        return this.k;
    }

    public void b(int i) {
        this.E = i;
    }

    public Marker c() {
        return this.m;
    }

    public void d() {
        this.V = false;
        if (this.U) {
            this.U = false;
            return;
        }
        N();
        ai();
        aa();
    }

    public void e() {
        this.V = true;
        ab();
        P();
        ah();
    }

    public void f() {
        p();
        q();
        r();
        o();
        s();
    }

    public void g() {
        this.X = true;
        ak();
        a(this.F);
        this.X = false;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        String str = f7858a;
        com.baidu.mapsdkplatform.comapi.synchronization.d.a.c(str, "The orderState in message is: " + message.what);
        c(message.what);
        int i = message.what;
        if (i == 0) {
            t();
        } else if (i == 1) {
            u();
        } else if (i == 2) {
            v();
        } else if (i == 3) {
            w();
        } else if (i == 4) {
            x();
        } else if (i == 5) {
            y();
        } else {
            String str2 = f7858a;
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.c(str2, "Undefined Message type: " + message.what);
        }
    }
}
