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
import java.lang.Thread;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes5.dex */
public class b extends Handler {
    private static final String a = b.class.getSimpleName();
    private static RoleOptions d = null;
    private static DisplayOptions e = null;
    private static Marker f = null;
    private static volatile SyncResponseResult g = null;
    private static int h = 1000;
    private static volatile int p = 0;
    private static LatLng r = null;
    private boolean A;
    private Thread B;
    private boolean C;
    private int D;
    private int E;
    private LatLngBounds F;
    private e G;
    private volatile long H;
    private boolean I;
    private volatile boolean J;
    private volatile long K;
    private volatile int L;
    private List<LatLng> M;
    private List<BitmapDescriptor> N;
    private Polyline O;
    private List<Integer> P;
    private volatile boolean Q;
    private int R;
    private String S;
    private String T;
    private boolean U;
    private boolean V;
    private volatile int W;
    private volatile boolean X;
    private BaiduMap b;
    private com.baidu.mapsdkplatform.comapi.synchronization.render.d c;
    private Marker i;
    private Marker j;
    private Marker k;
    private Marker l;
    private Marker m;
    private Marker n;
    private List<LinkPointPolyLineInfo> o;
    private Thread q;
    private int s;
    private double t;
    private int u;
    private boolean v;
    private volatile boolean w;
    private Thread x;
    private boolean y;
    private boolean z;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class a implements Runnable {
        private a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            while (!b.this.C) {
                if (b.g != null && b.g.a() != null) {
                    if (!b.this.X) {
                        b.this.ak();
                        b.this.I = false;
                        b.this.a(b.this.F);
                    }
                    try {
                        b.this.K = System.currentTimeMillis();
                        if (b.this.H <= 0) {
                            b.this.H = 10000L;
                        }
                        Thread.sleep(b.this.H);
                    } catch (InterruptedException e) {
                        com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(b.a, "Sleep InterruptedException");
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.mapsdkplatform.comapi.synchronization.render.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class RunnableC0057b implements Runnable {
        private RunnableC0057b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            double a;
            while (!b.this.Q) {
                LatLng ac = b.this.ac();
                if (ac == null) {
                    com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(b.a, "Driver position is null, return");
                    return;
                }
                LatLng a2 = b.this.a(ac);
                if (a2 == null) {
                    com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(b.a, "Driver position not bind to route");
                    b.c(b.this);
                    if (!b.this.v || b.this.y) {
                        com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(b.a, "Driver position not bind to route times = " + b.this.W);
                        if (2 <= b.this.W) {
                            if (2 >= b.h) {
                                a = com.baidu.mapsdkplatform.comapi.synchronization.d.b.a(b.r, b.d.getStartPosition());
                            } else if (4 != b.h) {
                                b.this.W = 0;
                                return;
                            } else {
                                a = com.baidu.mapsdkplatform.comapi.synchronization.d.b.a(b.r, b.d.getEndPosition());
                            }
                            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(b.a, "Latest driver postion to end position distance = " + a);
                            if (300.0d >= a) {
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
                    b.this.t = b.this.ad();
                    if (b.this.t > 500.0d) {
                        b.this.b(a2);
                        b.this.ag();
                        b.this.c(a2);
                        b.this.e(b.p - 1);
                        b.this.L = b.p - 1;
                        return;
                    }
                    b.g.c().setPoint(null);
                    try {
                        b.this.ae();
                    } catch (Exception e) {
                        com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(b.a, "Catch exception when car moving", e);
                    }
                    if (b.p >= b.this.o.size()) {
                        b.this.Q = true;
                        b.this.af();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class c implements Runnable {
        private c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            BitmapDescriptor passengerIcon = b.e != null ? b.e.getPassengerIcon() : null;
            BitmapDescriptor passengerIcon2 = passengerIcon == null ? new DisplayOptions().getPassengerIcon() : passengerIcon;
            int passengerMarkerZIndex = b.e.getPassengerMarkerZIndex();
            while (!b.this.w) {
                MyLocationData locationData = b.this.b.getLocationData();
                if (locationData != null && b.this.a(locationData)) {
                    com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(b.a, "Get location data success");
                    LatLng latLng = new LatLng(locationData.latitude, locationData.longitude);
                    if (b.this.n == null) {
                        b.this.n = (Marker) b.this.b.addOverlay(new MarkerOptions().position(latLng).anchor(0.5f, 0.5f).rotate(locationData.direction).icon(passengerIcon2).zIndex(passengerMarkerZIndex));
                    } else {
                        b.this.n.setPosition(latLng);
                        b.this.n.setRotate(locationData.direction);
                    }
                }
                try {
                    Thread.sleep(b.this.R * 1000);
                } catch (InterruptedException e) {
                    com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(b.a, "Sleep interrupt");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public enum d {
        NO_NEED_RENDER,
        RENDER_NEW_LINE,
        UPDATE_TRAFFIC
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class e implements BaiduMap.OnSynchronizationListener {
        private int b = 1;
        private int c = 2;
        private int d = 3;

        e() {
        }

        @Override // com.baidu.mapapi.map.BaiduMap.OnSynchronizationListener
        public void onMapStatusChangeReason(int i) {
            if (this.b != i && this.c != i) {
                if (this.d != i) {
                    com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(b.a, "Undefined reason type: " + i);
                    return;
                }
                b.this.H = b.this.E * 1000;
                return;
            }
            long currentTimeMillis = System.currentTimeMillis() - b.this.K;
            if (currentTimeMillis <= 0) {
                b.this.H = b.this.D * 1000;
            } else {
                b.this.H = (b.this.D * 1000) - (b.this.H - currentTimeMillis);
            }
            b.this.J = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
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
        this.q = new Thread(new RunnableC0057b(), "Car moving");
        this.x = new Thread(new c(), "Passenger marker");
        this.B = new Thread(new a(), "Adjust visible span");
    }

    private void A() {
        if (this.k != null) {
            this.k.remove();
            this.k = null;
        }
        if (this.l != null) {
            this.l.remove();
            this.l = null;
        }
    }

    private void B() {
        if (this.i != null) {
            this.i.remove();
            this.i = null;
        }
        if (this.j != null) {
            this.j.remove();
            this.j = null;
        }
    }

    private void C() {
        if (this.n != null) {
            this.n.remove();
            this.n = null;
        }
    }

    private void D() {
        if (this.m != null) {
            this.m.remove();
            this.m = null;
        }
        if (f != null) {
            f.remove();
            f = null;
        }
    }

    private void E() {
        if (!this.v || this.A) {
            return;
        }
        if (this.O != null) {
            this.O.remove();
            this.o.clear();
            this.M.clear();
            this.N.clear();
            this.P.clear();
            g = null;
        }
        this.S = null;
        this.T = null;
    }

    private void F() {
        if (this.j != null) {
            this.j.remove();
            this.j = null;
        }
    }

    private void G() {
        if (f != null) {
            f.remove();
            f = null;
        }
    }

    private void H() {
        if (!this.v || this.y) {
            return;
        }
        this.Q = true;
    }

    private void I() {
        if (!e.isShowStartPositionMarker()) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(a, "User set start position marker not show");
            if (this.i != null) {
                this.i.remove();
                this.i = null;
            }
        } else if (this.i != null && !this.v) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(a, "Start position marker already render ok");
        } else {
            LatLng J = J();
            if (J == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "No startPosition");
                return;
            }
            BitmapDescriptor startPositionIcon = e.getStartPositionIcon();
            if (startPositionIcon == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "No startPositionIcon, use default");
                startPositionIcon = new DisplayOptions().getStartPositionIcon();
            }
            if (startPositionIcon == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "There is no startPositionIcon");
                return;
            }
            MarkerOptions zIndex = new MarkerOptions().position(J).icon(startPositionIcon).zIndex(e.getStartPositionMarkerZIndex());
            if (this.i == null) {
                this.i = (Marker) this.b.addOverlay(zIndex);
                return;
            }
            this.i.setIcon(startPositionIcon);
            this.i.setPosition(J);
        }
    }

    private LatLng J() {
        LatLng startPosition = d.getStartPosition();
        if (startPosition == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "The start position is null");
            if (this.c != null) {
                this.c.a(100001, "Start position is null");
            }
        }
        return startPosition;
    }

    private void K() {
        if (!e.isShowStartPositionInfoWindow()) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(a, "User set start position infoWindow not show");
            if (this.j != null) {
                this.j.remove();
                this.j = null;
                return;
            }
            return;
        }
        LatLng startPosition = d.getStartPosition();
        if (startPosition == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "No startPosition");
            return;
        }
        View startPositionInfoWindowView = e.getStartPositionInfoWindowView();
        if (startPositionInfoWindowView == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "Start position infoWindow view is null, cannot display");
            if (this.j != null) {
                this.j.remove();
                this.j = null;
                return;
            }
            return;
        }
        MarkerOptions alpha = new MarkerOptions().position(startPosition).icon(BitmapDescriptorFactory.fromView(startPositionInfoWindowView)).zIndex(e.getStartPositionInfoWindowZIndex()).alpha(0.9f);
        if (this.j == null) {
            this.j = (Marker) this.b.addOverlay(alpha);
            return;
        }
        this.j.setPosition(startPosition);
        this.j.setIcon(BitmapDescriptorFactory.fromView(startPositionInfoWindowView));
    }

    private void L() {
        if (!e.isShowEndPositionMarker()) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(a, "User set endPositionMarker not show");
            if (this.k != null) {
                this.k.remove();
                this.k = null;
            }
        } else if (this.k != null && !this.v) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "EndPositionMarker already render ok");
        } else {
            LatLng endPosition = d.getEndPosition();
            if (endPosition == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "End position coord is null");
                return;
            }
            BitmapDescriptor endPositionIcon = e.getEndPositionIcon();
            if (endPositionIcon == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "The end position icon is null");
                endPositionIcon = new DisplayOptions().getEndPositionIcon();
            }
            if (endPositionIcon == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "There is no endPositionIcon");
                return;
            }
            MarkerOptions zIndex = new MarkerOptions().position(endPosition).icon(endPositionIcon).zIndex(e.getEndPositionMarkerZIndex());
            if (this.k == null) {
                this.k = (Marker) this.b.addOverlay(zIndex);
                return;
            }
            this.k.setIcon(endPositionIcon);
            this.k.setPosition(endPosition);
        }
    }

    private void M() {
        if (!e.isShowEndPositionInfoWindow()) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(a, "User set end position infoWindow not show");
            if (this.l != null) {
                this.l.remove();
                this.l = null;
                return;
            }
            return;
        }
        LatLng endPosition = d.getEndPosition();
        if (endPosition == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "End position coord is null when render end position infoWindow");
            return;
        }
        View endPositionInfoWindowView = e.getEndPositionInfoWindowView();
        if (endPositionInfoWindowView == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "End position infoWindow view is null, cannot display");
            if (this.l != null) {
                this.l.remove();
                this.l = null;
                return;
            }
            return;
        }
        MarkerOptions zIndex = new MarkerOptions().position(endPosition).icon(BitmapDescriptorFactory.fromView(endPositionInfoWindowView)).anchor(0.5f, 1.0f).zIndex(e.getEndPositionInfoWindowZIndex());
        if (this.l == null) {
            this.l = (Marker) this.b.addOverlay(zIndex);
            return;
        }
        this.l.setPosition(endPosition);
        this.l.setIcon(BitmapDescriptorFactory.fromView(endPositionInfoWindowView));
    }

    private synchronized void N() {
        if (this.x != null) {
            this.w = false;
            if (Thread.State.NEW == this.x.getState()) {
                this.x.start();
            }
            if (this.v && Thread.State.TERMINATED == this.x.getState()) {
                this.x = null;
                this.x = new Thread(new c(), "Passenger marker");
                this.x.start();
            }
        }
    }

    private void O() {
        if (e.isShowPassengerIcon()) {
            N();
            return;
        }
        com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(a, "User set not show passenger icon");
        if (this.n != null) {
            this.n.remove();
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
        if (!e.isShowCarMarker()) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(a, "User set carMarker not show");
            if (this.m != null) {
                this.m.remove();
                this.m = null;
            }
        } else if (this.m != null && !this.v) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(a, "CarIcon already render ok");
        } else {
            LatLng T = T();
            if (T == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "The car(driver) position is null");
                return;
            }
            BitmapDescriptor carIcon = e.getCarIcon();
            if (carIcon == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "The car icon is null");
                carIcon = new DisplayOptions().getCarIcon();
            }
            if (carIcon == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "There is no car icon");
                return;
            }
            MarkerOptions anchor = new MarkerOptions().position(T).icon(carIcon).flat(true).rotate(0.0f).zIndex(e.getCarPositionMarkerZIndex()).anchor(0.5f, 0.5f);
            if (this.m == null) {
                this.m = (Marker) this.b.addOverlay(anchor);
                return;
            }
            this.m.setPosition(T);
            this.m.setIcon(carIcon);
        }
    }

    private void R() {
        if (!e.isShowCarInfoWindow()) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(a, "User set carInfoWindow not show");
            if (f != null) {
                f.remove();
                f = null;
                return;
            }
            return;
        }
        View carInfoWindowView = e.getCarInfoWindowView();
        if (carInfoWindowView == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "car position infoWindow view is null, cannot display");
            if (f != null) {
                f.remove();
                f = null;
                return;
            }
            return;
        }
        LatLng S = S();
        if (S == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "CarPosition is null");
            return;
        }
        MarkerOptions alpha = new MarkerOptions().position(S).icon(BitmapDescriptorFactory.fromView(carInfoWindowView)).zIndex(e.getCarPositionInfoWindowZIndex()).anchor(0.5f, 1.0f).alpha(0.9f);
        if (f == null) {
            f = (Marker) this.b.addOverlay(alpha);
            return;
        }
        f.setPosition(S);
        f.setIcon(BitmapDescriptorFactory.fromView(carInfoWindowView));
    }

    private LatLng S() {
        if (this.m != null || g == null) {
            if (this.m != null) {
                return this.m.getPosition();
            }
            return null;
        }
        return g.c().getPoint();
    }

    private LatLng T() {
        return r != null ? r : (g == null || g.c() == null || g.c().getPoint() == null) ? d.getDriverPosition() : g.c().getPoint();
    }

    private void U() {
        if (e == null) {
            return;
        }
        if (!e.isShowRoutePlan()) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(a, "User set route line not show");
            if (this.O != null) {
                this.O.remove();
                this.O = null;
            }
        } else if (g == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "No route line data");
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
                        com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(a, "Exception caught when renderRouteLine", e2);
                    }
                }
                p = 0;
                this.s = 0;
                this.L = 0;
                this.o.clear();
                this.M.clear();
                this.N.clear();
                this.P.clear();
                if (this.O != null) {
                    this.O.remove();
                    this.O = null;
                }
                X();
                if (this.o == null || this.o.isEmpty()) {
                    com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "LinkPointPolyline info is null");
                } else {
                    Y();
                }
            }
        }
    }

    private d V() {
        String a2 = g.a().a();
        String a3 = g.b().a();
        if (this.v && !this.A) {
            this.S = null;
            this.T = null;
        }
        if (a2 != null && (TextUtils.isEmpty(this.S) || !this.S.equals(a2) || this.O == null)) {
            this.S = a2;
            this.T = a3;
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "Route line or order state changed or no render, need render");
            return d.RENDER_NEW_LINE;
        } else if (a3 == null || this.O == null || (!TextUtils.isEmpty(this.T) && this.T.equals(a3))) {
            return d.NO_NEED_RENDER;
        } else {
            this.T = a3;
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "Route line only need update traffic");
            return d.UPDATE_TRAFFIC;
        }
    }

    private void W() {
        int[] iArr;
        ArrayList<Integer> b = g.b().b();
        if (b == null || b.isEmpty()) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "Traffic status data is null");
            return;
        }
        if (!this.Q) {
            this.Q = true;
        }
        if (p - this.s >= 0) {
            try {
                if (b.size() == this.o.size()) {
                    for (int i = p - this.s; i < this.o.size(); i++) {
                        this.P.set(i, b.get(i));
                    }
                } else {
                    for (int i2 = p - this.s; i2 < this.o.size(); i2++) {
                        this.P.set(i2, b.get((b.size() + i2) - this.o.size()));
                    }
                }
                iArr = new int[(this.P.size() - p) + this.s];
                for (int i3 = 0; i3 < (this.P.size() - p) + this.s; i3++) {
                    iArr[i3] = this.P.get((p + i3) - this.s).intValue();
                }
            } catch (Exception e2) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(a, "Exception caught when updateTrafficStatus", e2);
            }
            if (iArr.length > 0) {
                this.O.setIndexs(iArr);
                if (this.Q) {
                    this.Q = false;
                }
            }
        }
    }

    private void X() {
        if (g == null || g.a() == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "Route info or syncResponseResult is null");
            return;
        }
        List<RouteLineInfo.RouteSectionInfo> b = g.a().b();
        ArrayList<Integer> b2 = g.b().b();
        if (b == null || b.isEmpty()) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "route section info is null");
        } else if (!b.isEmpty() && b2 != null && !b2.isEmpty() && b2.size() != b.size()) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "route section info or traffic status info is invalid");
        } else {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= b.size()) {
                    this.M.add(b.get(b.size() - 1).b());
                    return;
                }
                if (b.get(i2) != null) {
                    LatLng a2 = b.get(i2).a();
                    LatLng b3 = b.get(i2).b();
                    int a3 = a(i2, b2);
                    LinkPointPolyLineInfo linkPointPolyLineInfo = new LinkPointPolyLineInfo();
                    linkPointPolyLineInfo.a(a2);
                    linkPointPolyLineInfo.b(b3);
                    linkPointPolyLineInfo.a(a3);
                    this.o.add(linkPointPolyLineInfo);
                    this.M.add(a2);
                }
                i = i2 + 1;
            }
        }
    }

    private void Y() {
        if (!this.Q) {
            this.Q = true;
        }
        LatLng point = (g == null || g.c() == null) ? null : g.c().getPoint();
        LatLng a2 = point != null ? a(point) : null;
        if (a2 != null) {
            this.s = 0;
            try {
                this.o = this.o.subList(p, this.o.size());
                this.M = this.M.subList(p, this.M.size());
            } catch (Exception e2) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(a, "Caught exception when renderRoutePolyLine", e2);
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
            this.N.addAll(e.getTrafficTextureList());
        }
        PolylineOptions zIndex = new PolylineOptions().points(this.M).dottedLine(true).width(e == null ? new DisplayOptions().getRouteLineWidth() : e.getRouteLineWidth()).customTextureList(this.N).textureIndex(this.P).zIndex(e.getRouteLineZIndex());
        if (!e.isShowRoutePlan()) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "User set route line not display");
            zIndex.visible(false);
        }
        this.O = (Polyline) this.b.addOverlay(zIndex);
        if (this.Q) {
            this.Q = false;
        }
    }

    private void Z() {
        if (this.m == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "CarMarker is null");
        } else if (r != null || this.o == null || this.o.isEmpty()) {
            aa();
        } else {
            r = this.o.get(0).a();
            b(r);
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
        return d3 == Double.MAX_VALUE ? d2 : Math.abs((d2 * d3) / Math.sqrt(1.0d + (d3 * d3)));
    }

    private double a(double d2, LatLng latLng) {
        return latLng.latitude - (latLng.longitude * d2);
    }

    private int a(int i, ArrayList<Integer> arrayList) {
        if (arrayList == null || arrayList.isEmpty() || i >= arrayList.size()) {
            return 0;
        }
        return arrayList.get(i).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public LatLng a(LatLng latLng) {
        if (3 == h) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(a, "WAIT_PASSENGER State, no need calculate");
            return null;
        } else if (this.o == null || this.o.isEmpty()) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "mLinkPolyLineInfos size = " + this.o.size());
            return null;
        } else {
            int i = p;
            while (true) {
                int i2 = i;
                if (i2 >= this.o.size()) {
                    return null;
                }
                LatLng a2 = this.o.get(i2).a();
                LatLng b = this.o.get(i2).b();
                if (a(latLng, a2)) {
                    this.s = d(i2);
                    return a2;
                } else if (a(latLng, b)) {
                    this.s = d(i2 + 1);
                    return b;
                } else {
                    boolean a3 = a(a2, b, latLng);
                    boolean b2 = b(a2, b, latLng);
                    if (a3 && b2) {
                        this.s = d(i2);
                        return a2;
                    }
                    i = i2 + 1;
                }
            }
        }
    }

    private void a(LatLngBounds.Builder builder) {
        if (e == null || e.isShowStartPositionMarkerInSpan()) {
            builder.include(J());
        } else {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "User set not show startPositionMarker in span");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(LatLngBounds latLngBounds) {
        int i;
        int i2;
        int i3;
        int i4 = 50;
        synchronized (this) {
            if (!this.J || this.X) {
                MapStatus mapStatus = this.b.getMapStatus();
                if (mapStatus == null) {
                    com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "Get map status failed");
                } else {
                    WinRound winRound = mapStatus.winRound;
                    int abs = Math.abs(winRound.right - winRound.left);
                    int abs2 = Math.abs(winRound.bottom - winRound.top);
                    if (e != null) {
                        i3 = e.getPaddingLeft();
                        i2 = e.getPaddingTop();
                        i = e.getPaddingRight();
                        i4 = e.getPaddingBottom();
                    } else {
                        i = 50;
                        i2 = 50;
                        i3 = 50;
                    }
                    int i5 = (abs - i3) - i;
                    int i6 = (abs2 - i2) - i4;
                    if (i5 < 0 || i6 < 0 || i5 > abs || i6 > abs2) {
                        com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "Invalid width and height，use default padding");
                        i5 = (abs - 50) - 50;
                        i6 = (abs2 - 50) - 50;
                    }
                    this.b.animateMapStatus(MapStatusUpdateFactory.newLatLngBounds(latLngBounds, i5, i6));
                }
            } else {
                this.J = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(MyLocationData myLocationData) {
        long j;
        long j2;
        long j3;
        try {
            j = Double.valueOf(myLocationData.latitude).longValue();
        } catch (NumberFormatException e2) {
            j = 0;
        }
        try {
            j2 = j;
            j3 = Double.valueOf(myLocationData.longitude).longValue();
        } catch (NumberFormatException e3) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "Trans latitude and longitude failed");
            j2 = j;
            j3 = 0;
            if (0 == j2) {
            }
        }
        return (0 == j2 || 0 != j3) && j2 >= -90 && j2 <= 90 && j3 >= -180 && j3 <= 180;
    }

    private boolean a(LatLng latLng, LatLng latLng2) {
        return (latLng == null || latLng2 == null) ? latLng == null && latLng2 == null : Math.abs(latLng.latitude - latLng2.latitude) < 1.0E-4d && Math.abs(latLng.longitude - latLng2.longitude) < 1.0E-4d;
    }

    private boolean a(LatLng latLng, LatLng latLng2, double d2) {
        boolean z = latLng.latitude > latLng2.latitude;
        double a2 = a(d2, latLng);
        double f2 = f(latLng, latLng2);
        double a3 = z ? a(f2, d2) : a(f2, d2) * (-1.0d);
        double a4 = a(a3);
        double d3 = latLng.latitude;
        while (true) {
            if ((d3 > latLng2.latitude) != z) {
                return true;
            }
            if (this.Q) {
                return false;
            }
            LatLng latLng3 = Double.MAX_VALUE == d2 ? new LatLng(d3, latLng.longitude) : new LatLng(d3, (d3 - a2) / d2);
            b(latLng3);
            c(latLng3);
            if (!b(a4)) {
                return false;
            }
            d3 -= a3;
        }
    }

    private boolean a(LatLng latLng, LatLng latLng2, LatLng latLng3) {
        double d2 = latLng.latitude;
        double d3 = latLng.longitude;
        double d4 = latLng2.latitude;
        return Math.abs(((latLng2.longitude - d3) * (latLng3.latitude - d2)) - ((d4 - d2) * (latLng3.longitude - d3))) < 1.0E-4d;
    }

    private synchronized void aa() {
        if (this.q != null) {
            this.Q = false;
            if (Thread.State.NEW == this.q.getState()) {
                this.q.start();
            } else if (Thread.State.TERMINATED == this.q.getState()) {
                this.q = null;
                this.q = new Thread(new RunnableC0057b(), "Car moving");
                this.q.start();
            }
        }
    }

    private synchronized void ab() {
        this.Q = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public LatLng ac() {
        if (g == null || g.c() == null || g.c().getPoint() == null || this.V) {
            return null;
        }
        return g.c().getPoint();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public double ad() {
        if (this.o == null || this.o.isEmpty() || p > this.o.size()) {
            return 1.0d;
        }
        double d2 = 0.0d;
        int i = p - this.s;
        while (true) {
            int i2 = i;
            if (i2 >= p) {
                return d2;
            }
            d2 += f(this.o.get(i2).a(), this.o.get(i2).b());
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ae() {
        if (p == 0) {
            return;
        }
        int i = p - this.s;
        while (true) {
            int i2 = i;
            if (i2 >= p) {
                return;
            }
            LatLng a2 = this.o.get(i2).a();
            LatLng b = this.o.get(i2).b();
            double f2 = f(a2, b) / 2.0d;
            double d2 = (b.latitude - a2.latitude) / f2;
            double d3 = (b.longitude - a2.longitude) / f2;
            double e2 = e(a2, b);
            int i3 = 1;
            LatLng latLng = a2;
            while (i3 <= f2) {
                double d4 = latLng.longitude;
                double d5 = latLng.latitude;
                if (0.0d == e2) {
                    d4 = latLng.longitude + d3;
                } else if (Double.MAX_VALUE == e2) {
                    d5 = latLng.latitude + d2;
                } else {
                    d4 = latLng.longitude + d3;
                    d5 = latLng.latitude + d2;
                }
                LatLng latLng2 = new LatLng(d5, d4);
                if (this.M != null && !this.M.isEmpty()) {
                    if (this.z) {
                        this.Q = true;
                        return;
                    }
                    this.M.set(i2, latLng2);
                }
                if (this.P != null && !this.P.isEmpty()) {
                    this.P.set(i2, Integer.valueOf(this.o.get(i2).c()));
                }
                if (!b(latLng, latLng2)) {
                    return;
                }
                this.L = i2;
                e(i2);
                i3++;
                latLng = latLng2;
            }
            i = i2 + 1;
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
            f2 = Double.valueOf(360.0d - g.c().getAngle()).floatValue();
        } catch (NumberFormatException e2) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(a, "Get DriverPosition Angle failed", e2);
        }
        this.m.setRotate(f2);
    }

    private synchronized void ah() {
        this.C = true;
    }

    private synchronized void ai() {
        if (this.B != null) {
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
                this.B = new Thread(new a(), "Adjust visible span");
                this.B.start();
            }
        }
    }

    private void aj() {
        this.b.setOnSynchronizationListener(this.G);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ak() {
        switch (h) {
            case 0:
            case 5:
                ah();
                return;
            case 1:
                al();
                return;
            case 2:
                am();
                return;
            case 3:
                an();
                return;
            case 4:
                ao();
                return;
            default:
                return;
        }
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
        } else if (0.0d == d2) {
            return latLng2.longitude > latLng.longitude ? 270.0d : 90.0d;
        } else {
            return (((latLng2.latitude - latLng.latitude) * d2 < 0.0d ? 180.0d : 0.0d) + (180.0d * (Math.atan(d2) / 3.141592653589793d))) - 90.0d;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(LatLng latLng) {
        if (this.m != null) {
            this.m.setPosition(latLng);
        }
    }

    private void b(LatLngBounds.Builder builder) {
        if (e == null || e.isShowEndPositionMarkerInSpan()) {
            builder.include(d.getEndPosition());
        } else {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "User set not show endPositionMarker in span");
        }
    }

    private boolean b(double d2) {
        try {
            Thread.sleep(Double.valueOf((1000.0d * d2) + 50.0d).longValue());
            return true;
        } catch (InterruptedException e2) {
            return false;
        } catch (NumberFormatException e3) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(a, "Calc sleep interval failed", e3);
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
        float b = (float) b(latLng, latLng2, e2);
        if (this.m != null) {
            this.m.setRotate(b);
        }
        boolean c2 = 0.0d == e2 ? c(latLng, latLng2) : a(latLng, latLng2, e2);
        if (c2) {
            r = latLng2;
            return c2;
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

    static /* synthetic */ int c(b bVar) {
        int i = bVar.W;
        bVar.W = i + 1;
        return i;
    }

    private void c(int i) {
        this.y = 1000 == h;
        this.A = (1 == h && 2 == i) || (1 == i && 2 == h);
        if (h == i) {
            this.v = false;
            return;
        }
        h = i;
        this.v = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(LatLng latLng) {
        if (f != null) {
            f.setPosition(latLng);
        }
    }

    private void c(LatLngBounds.Builder builder) {
        if (e == null || e.isShowCarMarkerInSpan()) {
            builder.include((this.m == null || this.I) ? T() : this.m.getPosition());
        } else {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "User set not show carMarker in span");
        }
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
        if (e != null && !e.isShowPassengerIconInSpan()) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "User set not show passengerMarker in span");
            return;
        }
        if (this.n == null) {
            MyLocationData locationData = this.b.getLocationData();
            if (locationData == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "No passenger location data");
                return;
            } else if (!a(locationData)) {
                return;
            } else {
                position = new LatLng(locationData.latitude, locationData.longitude);
            }
        } else {
            position = this.n.getPosition();
        }
        builder.include(position);
    }

    private double e(LatLng latLng, LatLng latLng2) {
        if (latLng2.longitude == latLng.longitude) {
            return Double.MAX_VALUE;
        }
        return (latLng2.latitude - latLng.latitude) / (latLng2.longitude - latLng.longitude);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(int i) {
        int[] iArr;
        if (this.M == null || this.M.isEmpty()) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "Route polyline points is null when remove");
        } else if (this.M.size() <= 2 || i >= this.M.size() - 2) {
            if (this.O != null) {
                this.O.remove();
            }
        } else if (this.P == null || this.P.isEmpty()) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "No need removeTravelledPolyLine");
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
            if (this.O == null || this.Q) {
                return;
            }
            this.O.setIndexs(iArr);
            try {
                this.O.setPoints(this.M.subList(i, this.M.size()));
            } catch (Exception e3) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(a, "Get subList of PolyLinePointList failed", e3);
            }
        }
    }

    private void e(LatLngBounds.Builder builder) {
        if (e != null && !e.isShowRoutePlanInSpan()) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "User set not show routeLine in span");
        } else if (this.o == null || this.o.isEmpty()) {
            g(builder);
        } else {
            f(builder);
        }
    }

    private double f(LatLng latLng, LatLng latLng2) {
        return com.baidu.mapsdkplatform.comapi.synchronization.d.b.a(latLng, latLng2);
    }

    private void f(LatLngBounds.Builder builder) {
        int i = this.L;
        while (true) {
            int i2 = i;
            if (i2 >= this.o.size()) {
                builder.include(this.o.get(this.o.size() - 1).b());
                return;
            } else {
                builder.include(this.o.get(i2).a());
                i = i2 + 1;
            }
        }
    }

    private void g(LatLngBounds.Builder builder) {
        if (g == null || g.a() == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "There no routeLine info, no need show in span");
            return;
        }
        List<RouteLineInfo.RouteSectionInfo> b = g.a().b();
        if (b == null || b.isEmpty()) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "There no routeLine position, no need show in span");
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= b.size()) {
                builder.include(b.get(b.size() - 1).b());
                return;
            } else {
                builder.include(b.get(i2).a());
                i = i2 + 1;
            }
        }
    }

    private LatLngBounds h(LatLngBounds.Builder builder) {
        return builder.build();
    }

    private void o() {
        if (e == null) {
            return;
        }
        if (f != null) {
            f.remove();
            f = null;
        }
        if (this.m != null) {
            this.m.remove();
            this.m = null;
        }
        if (this.i != null) {
            this.i.remove();
            this.i = null;
        }
        if (this.j != null) {
            this.j.remove();
            this.j = null;
        }
        if (this.l != null) {
            this.l.remove();
            this.l = null;
        }
        e.getStartPositionIcon().recycle();
        e.getCarIcon().recycle();
        if (e.getEndPositionIcon() != null) {
            e.getEndPositionIcon().recycle();
        }
        e = null;
    }

    private void p() {
        p = 0;
        this.u = 0;
        this.Q = true;
        if (this.q != null) {
            try {
                this.q.join();
            } catch (InterruptedException e2) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "InterruptedException when release CarMoveThread");
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
        int i = 0;
        d = null;
        g = null;
        h = 1000;
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
        if (this.O != null) {
            this.O.remove();
            this.O = null;
        }
        while (true) {
            int i2 = i;
            if (i2 >= this.N.size()) {
                this.N.clear();
                this.b.clear();
                return;
            }
            this.N.get(i2).recycle();
            i = i2 + 1;
        }
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
        if (this.b != null) {
            this.b.clear();
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
        if (this.b != null) {
            this.b.clear();
        }
    }

    private boolean z() {
        if (d == null || e == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "No render data");
            if (this.c != null) {
                this.c.a(100001, "Get render data failed");
                return false;
            }
            return false;
        } else if (this.b == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "BaiduMap is null");
            if (this.c != null) {
                this.c.a(100002, "BaiduMap instance is null.");
                return false;
            }
            return false;
        } else {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Marker a() {
        return this.i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i) {
        this.D = i;
    }

    public void a(BaiduMap baiduMap, RoleOptions roleOptions, DisplayOptions displayOptions) {
        this.b = baiduMap;
        d = roleOptions;
        e = displayOptions;
        this.G = new e();
        aj();
        r = null;
        this.b.getUiSettings().setRotateGesturesEnabled(false);
        this.b.getUiSettings().setCompassEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a(RoleOptions roleOptions, DisplayOptions displayOptions, SyncResponseResult syncResponseResult, int i) {
        d = roleOptions;
        e = displayOptions;
        if (e == null) {
            e = new DisplayOptions();
        }
        g = syncResponseResult;
        this.u = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.baidu.mapsdkplatform.comapi.synchronization.render.d dVar) {
        this.c = dVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Marker b() {
        return this.k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(int i) {
        this.E = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g() {
        this.X = true;
        ak();
        a(this.F);
        this.X = false;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        com.baidu.mapsdkplatform.comapi.synchronization.d.a.c(a, "The orderState in message is: " + message.what);
        c(message.what);
        switch (message.what) {
            case 0:
                t();
                return;
            case 1:
                u();
                return;
            case 2:
                v();
                return;
            case 3:
                w();
                return;
            case 4:
                x();
                return;
            case 5:
                y();
                return;
            default:
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.c(a, "Undefined Message type: " + message.what);
                return;
        }
    }
}
