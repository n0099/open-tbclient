package com.baidu.mapsdkplatform.comapi.synchronization.render;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.mapapi.synchronization.SynchronizationConstants;
import com.baidu.mapsdkplatform.comapi.synchronization.data.RouteLineInfo;
import com.baidu.mapsdkplatform.comapi.synchronization.data.SyncResponseResult;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.widget.CustomerServiceMenu;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes5.dex */
public class b extends Handler {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final String f42237a;

    /* renamed from: d  reason: collision with root package name */
    public static RoleOptions f42238d;

    /* renamed from: e  reason: collision with root package name */
    public static DisplayOptions f42239e;

    /* renamed from: f  reason: collision with root package name */
    public static Marker f42240f;

    /* renamed from: g  reason: collision with root package name */
    public static volatile SyncResponseResult f42241g;

    /* renamed from: h  reason: collision with root package name */
    public static int f42242h;
    public static volatile int p;
    public static LatLng r;
    public transient /* synthetic */ FieldHolder $fh;
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
    public double Y;

    /* renamed from: b  reason: collision with root package name */
    public BaiduMap f42243b;

    /* renamed from: c  reason: collision with root package name */
    public com.baidu.mapsdkplatform.comapi.synchronization.render.d f42244c;

    /* renamed from: i  reason: collision with root package name */
    public Marker f42245i;

    /* renamed from: j  reason: collision with root package name */
    public Marker f42246j;
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

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f42247a;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42247a = bVar;
        }

        public /* synthetic */ a(b bVar, com.baidu.mapsdkplatform.comapi.synchronization.render.c cVar) {
            this(bVar);
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                while (!this.f42247a.C) {
                    if (b.f42241g != null && b.f42241g.a() != null) {
                        if (!this.f42247a.X) {
                            this.f42247a.ak();
                            this.f42247a.I = false;
                            b bVar = this.f42247a;
                            bVar.a(bVar.F);
                        }
                        this.f42247a.X = false;
                        try {
                            this.f42247a.K = System.currentTimeMillis();
                            if (this.f42247a.H <= 0) {
                                this.f42247a.H = 10000L;
                            }
                            Thread.sleep(this.f42247a.H);
                        } catch (InterruptedException unused) {
                            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(b.f42237a, "Sleep InterruptedException");
                        }
                    }
                }
            }
        }
    }

    /* renamed from: com.baidu.mapsdkplatform.comapi.synchronization.render.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class RunnableC1668b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f42248a;

        public RunnableC1668b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42248a = bVar;
        }

        public /* synthetic */ RunnableC1668b(b bVar, com.baidu.mapsdkplatform.comapi.synchronization.render.c cVar) {
            this(bVar);
        }

        @Override // java.lang.Runnable
        public void run() {
            LatLng latLng;
            LatLng endPosition;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                while (!this.f42248a.Q) {
                    LatLng ac = this.f42248a.ac();
                    if (ac == null) {
                        com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(b.f42237a, "Driver position is null, return");
                        return;
                    }
                    LatLng a2 = this.f42248a.a(ac);
                    if (a2 == null) {
                        com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(b.f42237a, "Driver position not bind to route");
                        b.c(this.f42248a);
                        if (!this.f42248a.v || this.f42248a.y) {
                            String str = b.f42237a;
                            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(str, "Driver position not bind to route times = " + this.f42248a.W);
                            if (2 <= this.f42248a.W) {
                                if (2 >= b.f42242h) {
                                    latLng = b.r;
                                    endPosition = b.f42238d.getStartPosition();
                                } else if (4 != b.f42242h) {
                                    this.f42248a.W = 0;
                                    return;
                                } else {
                                    latLng = b.r;
                                    endPosition = b.f42238d.getEndPosition();
                                }
                                double a3 = com.baidu.mapsdkplatform.comapi.synchronization.d.b.a(latLng, endPosition);
                                String str2 = b.f42237a;
                                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(str2, "Latest driver postion to end position distance = " + a3);
                                if (300.0d >= a3) {
                                    if (this.f42248a.O != null) {
                                        this.f42248a.O.remove();
                                    }
                                    this.f42248a.Q = true;
                                    this.f42248a.af();
                                }
                                this.f42248a.W = 0;
                            }
                            this.f42248a.b(ac);
                            this.f42248a.ag();
                            this.f42248a.c(ac);
                            return;
                        }
                        return;
                    } else if (this.f42248a.s == 0) {
                        return;
                    } else {
                        b bVar = this.f42248a;
                        bVar.t = bVar.ad();
                        if (this.f42248a.t > 500.0d) {
                            this.f42248a.b(a2);
                            this.f42248a.ag();
                            this.f42248a.c(a2);
                            this.f42248a.e(b.p - 1);
                            this.f42248a.L = b.p - 1;
                            return;
                        }
                        if (b.f42241g != null && b.f42241g.c() != null) {
                            b.f42241g.c().setPoint(null);
                        }
                        try {
                            this.f42248a.ae();
                        } catch (Exception e2) {
                            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(b.f42237a, "Catch exception when car moving", e2);
                        }
                        if (b.p >= this.f42248a.o.size()) {
                            this.f42248a.Q = true;
                            this.f42248a.af();
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f42249a;

        public c(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42249a = bVar;
        }

        public /* synthetic */ c(b bVar, com.baidu.mapsdkplatform.comapi.synchronization.render.c cVar) {
            this(bVar);
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                BitmapDescriptor passengerIcon = b.f42239e != null ? b.f42239e.getPassengerIcon() : null;
                if (passengerIcon == null) {
                    passengerIcon = new DisplayOptions().getPassengerIcon();
                }
                int passengerMarkerZIndex = b.f42239e != null ? b.f42239e.getPassengerMarkerZIndex() : 10;
                while (!this.f42249a.w) {
                    MyLocationData locationData = this.f42249a.f42243b.getLocationData();
                    if (locationData != null && this.f42249a.a(locationData)) {
                        com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(b.f42237a, "Get location data success");
                        LatLng latLng = new LatLng(locationData.latitude, locationData.longitude);
                        if (this.f42249a.n == null) {
                            MarkerOptions zIndex = new MarkerOptions().position(latLng).anchor(0.5f, 0.5f).rotate(locationData.direction).icon(passengerIcon).zIndex(passengerMarkerZIndex);
                            b bVar = this.f42249a;
                            bVar.n = (Marker) bVar.f42243b.addOverlay(zIndex);
                        } else {
                            this.f42249a.n.setPosition(latLng);
                            this.f42249a.n.setRotate(locationData.direction);
                        }
                    }
                    try {
                        Thread.sleep(this.f42249a.R * 1000);
                    } catch (InterruptedException unused) {
                        com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(b.f42237a, "Sleep interrupt");
                    }
                }
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes5.dex */
    public static final class d {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final d f42250a;

        /* renamed from: b  reason: collision with root package name */
        public static final d f42251b;

        /* renamed from: c  reason: collision with root package name */
        public static final d f42252c;

        /* renamed from: d  reason: collision with root package name */
        public static final /* synthetic */ d[] f42253d;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-750457571, "Lcom/baidu/mapsdkplatform/comapi/synchronization/render/b$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-750457571, "Lcom/baidu/mapsdkplatform/comapi/synchronization/render/b$d;");
                    return;
                }
            }
            f42250a = new d("NO_NEED_RENDER", 0);
            f42251b = new d("RENDER_NEW_LINE", 1);
            d dVar = new d("UPDATE_TRAFFIC", 2);
            f42252c = dVar;
            f42253d = new d[]{f42250a, f42251b, dVar};
        }

        public d(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static d valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (d) Enum.valueOf(d.class, str) : (d) invokeL.objValue;
        }

        public static d[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (d[]) f42253d.clone() : (d[]) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class e implements BaiduMap.OnSynchronizationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f42254a;

        /* renamed from: b  reason: collision with root package name */
        public int f42255b;

        /* renamed from: c  reason: collision with root package name */
        public int f42256c;

        /* renamed from: d  reason: collision with root package name */
        public int f42257d;

        public e(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42254a = bVar;
            this.f42255b = 1;
            this.f42256c = 2;
            this.f42257d = 3;
        }

        @Override // com.baidu.mapapi.map.BaiduMap.OnSynchronizationListener
        public void onMapStatusChangeReason(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (this.f42255b == i2 || this.f42256c == i2) {
                    long currentTimeMillis = System.currentTimeMillis() - this.f42254a.K;
                    if (currentTimeMillis <= 0) {
                        b bVar = this.f42254a;
                        bVar.H = bVar.D * 1000;
                    } else {
                        b bVar2 = this.f42254a;
                        bVar2.H = (bVar2.D * 1000) - (this.f42254a.H - currentTimeMillis);
                    }
                    this.f42254a.J = true;
                } else if (this.f42257d == i2) {
                    b bVar3 = this.f42254a;
                    bVar3.H = bVar3.E * 1000;
                } else {
                    String str = b.f42237a;
                    com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(str, "Undefined reason type: " + i2);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1502455203, "Lcom/baidu/mapsdkplatform/comapi/synchronization/render/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1502455203, "Lcom/baidu/mapsdkplatform/comapi/synchronization/render/b;");
                return;
            }
        }
        f42237a = b.class.getSimpleName();
        f42238d = null;
        f42239e = null;
        f42240f = null;
        f42241g = null;
        f42242h = 1000;
        p = 0;
        r = null;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Looper looper) {
        super(looper);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {looper};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Looper) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f42245i = null;
        this.f42246j = null;
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
        this.Y = 0.0d;
        this.q = new Thread(new RunnableC1668b(this, null), "Car moving");
        this.x = new Thread(new c(this, null), "Passenger marker");
        this.B = new Thread(new a(this, null), "Adjust visible span");
    }

    private void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
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
    }

    private void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            Marker marker = this.f42245i;
            if (marker != null) {
                marker.remove();
                this.f42245i = null;
            }
            Marker marker2 = this.f42246j;
            if (marker2 != null) {
                marker2.remove();
                this.f42246j = null;
            }
        }
    }

    private void C() {
        Marker marker;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) || (marker = this.n) == null) {
            return;
        }
        marker.remove();
        this.n = null;
    }

    private void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            Marker marker = this.m;
            if (marker != null) {
                marker.remove();
                this.m = null;
            }
            Marker marker2 = f42240f;
            if (marker2 != null) {
                marker2.remove();
                f42240f = null;
            }
        }
    }

    private void E() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) && this.v && !this.A) {
            Polyline polyline = this.O;
            if (polyline != null) {
                polyline.remove();
                this.o.clear();
                this.M.clear();
                this.N.clear();
                this.P.clear();
                f42241g = null;
            }
            this.S = null;
            this.T = null;
        }
    }

    private void F() {
        Marker marker;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65543, this) == null) || (marker = this.f42246j) == null) {
            return;
        }
        marker.remove();
        this.f42246j = null;
    }

    private void G() {
        Marker marker;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65544, this) == null) || (marker = f42240f) == null) {
            return;
        }
        marker.remove();
        f42240f = null;
    }

    private void H() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65545, this) == null) && this.v && !this.y) {
            this.Q = true;
        }
    }

    private void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            DisplayOptions displayOptions = f42239e;
            if (displayOptions == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f42237a, "renderStartPositionMarker DisplayOptions is null");
            } else if (!displayOptions.isShowStartPositionMarker()) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f42237a, "User set start position marker not show");
                Marker marker = this.f42245i;
                if (marker != null) {
                    marker.remove();
                    this.f42245i = null;
                }
            } else if (this.f42245i != null && !this.v) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f42237a, "Start position marker already render ok");
            } else {
                LatLng J = J();
                if (J == null) {
                    com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f42237a, "No startPosition");
                    return;
                }
                BitmapDescriptor startPositionIcon = f42239e.getStartPositionIcon();
                if (startPositionIcon == null) {
                    com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f42237a, "No startPositionIcon, use default");
                    startPositionIcon = new DisplayOptions().getStartPositionIcon();
                }
                if (startPositionIcon == null) {
                    com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f42237a, "There is no startPositionIcon");
                    return;
                }
                MarkerOptions perspective = new MarkerOptions().position(J).icon(startPositionIcon).zIndex(f42239e.getStartPositionMarkerZIndex()).perspective(false);
                Marker marker2 = this.f42245i;
                if (marker2 == null) {
                    this.f42245i = (Marker) this.f42243b.addOverlay(perspective);
                    return;
                }
                marker2.setIcon(startPositionIcon);
                this.f42245i.setPosition(J);
            }
        }
    }

    private LatLng J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) {
            LatLng startPosition = f42238d.getStartPosition();
            if (startPosition == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f42237a, "The start position is null");
                com.baidu.mapsdkplatform.comapi.synchronization.render.d dVar = this.f42244c;
                if (dVar != null) {
                    dVar.a(CustomerServiceMenu.TRANSFER_RECORD, "Start position is null");
                }
            }
            return startPosition;
        }
        return (LatLng) invokeV.objValue;
    }

    private void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            DisplayOptions displayOptions = f42239e;
            if (displayOptions == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f42237a, "renderStartPositionInfoWindow DisplayOptions is null");
            } else if (!displayOptions.isShowStartPositionInfoWindow()) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f42237a, "User set start position infoWindow not show");
                Marker marker = this.f42246j;
                if (marker != null) {
                    marker.remove();
                    this.f42246j = null;
                }
            } else {
                LatLng startPosition = f42238d.getStartPosition();
                if (startPosition == null) {
                    com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f42237a, "No startPosition");
                    return;
                }
                View startPositionInfoWindowView = f42239e.getStartPositionInfoWindowView();
                if (startPositionInfoWindowView == null) {
                    com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f42237a, "Start position infoWindow view is null, cannot display");
                    Marker marker2 = this.f42246j;
                    if (marker2 != null) {
                        marker2.remove();
                        this.f42246j = null;
                        return;
                    }
                    return;
                }
                MarkerOptions perspective = new MarkerOptions().position(startPosition).icon(BitmapDescriptorFactory.fromView(startPositionInfoWindowView)).zIndex(f42239e.getStartPositionInfoWindowZIndex()).alpha(0.9f).perspective(false);
                Marker marker3 = this.f42246j;
                if (marker3 == null) {
                    this.f42246j = (Marker) this.f42243b.addOverlay(perspective);
                    return;
                }
                marker3.setPosition(startPosition);
                this.f42246j.setIcon(BitmapDescriptorFactory.fromView(startPositionInfoWindowView));
            }
        }
    }

    private void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            DisplayOptions displayOptions = f42239e;
            if (displayOptions == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f42237a, "renderEndPositionMarker DisplayOptions is null");
            } else if (!displayOptions.isShowEndPositionMarker()) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f42237a, "User set endPositionMarker not show");
                Marker marker = this.k;
                if (marker != null) {
                    marker.remove();
                    this.k = null;
                }
            } else if (this.k != null && !this.v) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f42237a, "EndPositionMarker already render ok");
            } else {
                LatLng endPosition = f42238d.getEndPosition();
                if (endPosition == null) {
                    com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f42237a, "End position coord is null");
                    return;
                }
                BitmapDescriptor endPositionIcon = f42239e.getEndPositionIcon();
                if (endPositionIcon == null) {
                    com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f42237a, "The end position icon is null");
                    endPositionIcon = new DisplayOptions().getEndPositionIcon();
                }
                if (endPositionIcon == null) {
                    com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f42237a, "There is no endPositionIcon");
                    return;
                }
                MarkerOptions perspective = new MarkerOptions().position(endPosition).icon(endPositionIcon).zIndex(f42239e.getEndPositionMarkerZIndex()).perspective(false);
                Marker marker2 = this.k;
                if (marker2 == null) {
                    this.k = (Marker) this.f42243b.addOverlay(perspective);
                    return;
                }
                marker2.setIcon(endPositionIcon);
                this.k.setPosition(endPosition);
            }
        }
    }

    private void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            DisplayOptions displayOptions = f42239e;
            if (displayOptions == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f42237a, "renderEndPositionInfoWindow DisplayOptions is null");
            } else if (!displayOptions.isShowEndPositionInfoWindow()) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f42237a, "User set end position infoWindow not show");
                Marker marker = this.l;
                if (marker != null) {
                    marker.remove();
                    this.l = null;
                }
            } else {
                LatLng endPosition = f42238d.getEndPosition();
                if (endPosition == null) {
                    com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f42237a, "End position coord is null when render end position infoWindow");
                    return;
                }
                View endPositionInfoWindowView = f42239e.getEndPositionInfoWindowView();
                if (endPositionInfoWindowView == null) {
                    com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f42237a, "End position infoWindow view is null, cannot display");
                    Marker marker2 = this.l;
                    if (marker2 != null) {
                        marker2.remove();
                        this.l = null;
                        return;
                    }
                    return;
                }
                MarkerOptions perspective = new MarkerOptions().position(endPosition).icon(BitmapDescriptorFactory.fromView(endPositionInfoWindowView)).anchor(0.5f, 1.0f).zIndex(f42239e.getEndPositionInfoWindowZIndex()).perspective(false);
                Marker marker3 = this.l;
                if (marker3 == null) {
                    this.l = (Marker) this.f42243b.addOverlay(perspective);
                    return;
                }
                marker3.setPosition(endPosition);
                this.l.setIcon(BitmapDescriptorFactory.fromView(endPositionInfoWindowView));
            }
        }
    }

    private synchronized void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
            synchronized (this) {
                if (this.x == null) {
                    return;
                }
                if (f42239e != null && f42239e.isShowPassengerIcon()) {
                    this.w = false;
                    if (Thread.State.NEW == this.x.getState()) {
                        this.x.start();
                    }
                    if (this.v && Thread.State.TERMINATED == this.x.getState()) {
                        this.x = null;
                        Thread thread = new Thread(new c(this, null), "Passenger marker");
                        this.x = thread;
                        thread.start();
                    }
                }
            }
        }
    }

    private void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, this) == null) {
            DisplayOptions displayOptions = f42239e;
            if (displayOptions == null || displayOptions.isShowPassengerIcon()) {
                N();
                return;
            }
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f42237a, "User set not show passenger icon");
            Marker marker = this.n;
            if (marker != null) {
                marker.remove();
                this.n = null;
            }
        }
    }

    private synchronized void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            synchronized (this) {
                this.w = true;
            }
        }
    }

    private void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, this) == null) {
            DisplayOptions displayOptions = f42239e;
            if (displayOptions == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f42237a, "renderCarMarker DisplayOptions is null");
            } else if (!displayOptions.isShowCarMarker()) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f42237a, "User set carMarker not show");
                Marker marker = this.m;
                if (marker != null) {
                    marker.remove();
                    this.m = null;
                }
            } else if (this.m != null && !this.v) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f42237a, "CarIcon already render ok");
            } else {
                LatLng T = T();
                if (T == null) {
                    com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f42237a, "The car(driver) position is null");
                    this.f42244c.a(2004, SynchronizationConstants.LBS_STATUS_MESSAGE_QUERY_TRACK_DRIVER_POSITION_FAILED);
                    return;
                }
                BitmapDescriptor carIcon = (!f42239e.get3DCarMarkerEnable() || f42239e.get3DCarMarkerIconList() == null || f42239e.get3DCarMarkerIconList().isEmpty()) ? f42239e.getCarIcon() : f42239e.get3DCarMarkerIconList().get(0);
                if (carIcon == null) {
                    com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f42237a, "The car icon is null, use default 2D car icon");
                    carIcon = new DisplayOptions().getCarIcon();
                }
                if (carIcon == null) {
                    com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f42237a, "There is no car icon");
                    return;
                }
                MarkerOptions perspective = new MarkerOptions().position(T).icon(carIcon).flat(false).rotate(0.0f).zIndex(f42239e.getCarPositionMarkerZIndex()).anchor(0.5f, 0.5f).perspective(false);
                Marker marker2 = this.m;
                if (marker2 == null) {
                    this.m = (Marker) this.f42243b.addOverlay(perspective);
                    return;
                }
                marker2.setPosition(T);
                this.m.setIcon(carIcon);
            }
        }
    }

    private void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65555, this) == null) {
            DisplayOptions displayOptions = f42239e;
            if (displayOptions == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f42237a, "renderCarInfoWindow DisplayOptions is null");
            } else if (!displayOptions.isShowCarInfoWindow()) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f42237a, "User set carInfoWindow not show");
                Marker marker = f42240f;
                if (marker != null) {
                    marker.remove();
                    f42240f = null;
                }
            } else {
                View carInfoWindowView = f42239e.getCarInfoWindowView();
                if (carInfoWindowView == null) {
                    com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f42237a, "car position infoWindow view is null, cannot display");
                    Marker marker2 = f42240f;
                    if (marker2 != null) {
                        marker2.remove();
                        f42240f = null;
                        return;
                    }
                    return;
                }
                LatLng S = S();
                if (S == null) {
                    com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f42237a, "CarPosition is null");
                    return;
                }
                MarkerOptions alpha = new MarkerOptions().position(S).icon(BitmapDescriptorFactory.fromView(carInfoWindowView)).zIndex(f42239e.getCarPositionInfoWindowZIndex()).anchor(0.5f, 1.0f).alpha(0.9f);
                Marker marker3 = f42240f;
                if (marker3 == null) {
                    f42240f = (Marker) this.f42243b.addOverlay(alpha);
                    return;
                }
                marker3.setPosition(S);
                f42240f.setIcon(BitmapDescriptorFactory.fromView(carInfoWindowView));
            }
        }
    }

    private LatLng S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65556, this)) == null) {
            if (this.m != null || f42241g == null) {
                Marker marker = this.m;
                if (marker != null) {
                    return marker.getPosition();
                }
                return null;
            }
            return f42241g.c().getPoint();
        }
        return (LatLng) invokeV.objValue;
    }

    private LatLng T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65557, this)) == null) {
            LatLng latLng = r;
            return latLng != null ? latLng : (f42241g == null || f42241g.c() == null || f42241g.c().getPoint() == null) ? f42238d.getDriverPosition() : f42241g.c().getPoint();
        }
        return (LatLng) invokeV.objValue;
    }

    private void U() {
        DisplayOptions displayOptions;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65558, this) == null) || (displayOptions = f42239e) == null) {
            return;
        }
        if (!displayOptions.isShowRoutePlan()) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f42237a, "User set route line not show");
            Polyline polyline = this.O;
            if (polyline != null) {
                polyline.remove();
                this.O = null;
            }
        } else if (f42241g == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f42237a, "No route line data");
        } else {
            d V = V();
            if (d.f42250a == V) {
                this.z = false;
            } else if (d.f42252c == V) {
                this.z = false;
                W();
            } else {
                this.z = true;
                if (!this.Q) {
                    this.Q = true;
                    try {
                        Thread.sleep(100L);
                    } catch (Exception e2) {
                        com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f42237a, "Exception caught when renderRouteLine", e2);
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
                    com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f42237a, "LinkPointPolyline info is null");
                } else {
                    Y();
                }
            }
        }
    }

    private d V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65559, this)) == null) {
            String a2 = f42241g.a().a();
            String a3 = f42241g.b().a();
            if (this.v && !this.A) {
                this.S = null;
                this.T = null;
            }
            if (a2 != null && (TextUtils.isEmpty(this.S) || !this.S.equals(a2) || this.O == null)) {
                this.S = a2;
                this.T = a3;
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f42237a, "Route line or order state changed or no render, need render");
                return d.f42251b;
            } else if (a3 == null || this.O == null || (!TextUtils.isEmpty(this.T) && this.T.equals(a3))) {
                return d.f42250a;
            } else {
                this.T = a3;
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f42237a, "Route line only need update traffic");
                return d.f42252c;
            }
        }
        return (d) invokeV.objValue;
    }

    private void W() {
        int size;
        int[] iArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65560, this) == null) {
            ArrayList<Integer> b2 = f42241g.b().b();
            if (b2 == null || b2.isEmpty()) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f42237a, "Traffic status data is null");
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
                    for (int i2 = p - this.s; i2 < this.o.size(); i2++) {
                        this.P.set(i2, b2.get(i2));
                    }
                } else {
                    for (int i3 = p - this.s; i3 < this.o.size(); i3++) {
                        this.P.set(i3, b2.get((b2.size() + i3) - this.o.size()));
                    }
                }
                size = (this.P.size() - p) + this.s;
                iArr = new int[size];
                for (int i4 = 0; i4 < (this.P.size() - p) + this.s; i4++) {
                    iArr[i4] = this.P.get((p + i4) - this.s).intValue();
                }
            } catch (Exception e2) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f42237a, "Exception caught when updateTrafficStatus", e2);
            }
            if (size <= 0) {
                return;
            }
            this.O.setIndexs(iArr);
            if (this.Q) {
                this.Q = false;
            }
        }
    }

    private void X() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65561, this) == null) {
            if (f42241g == null || f42241g.a() == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f42237a, "Route info or syncResponseResult is null");
                return;
            }
            List<RouteLineInfo.RouteSectionInfo> b2 = f42241g.a().b();
            ArrayList<Integer> b3 = f42241g.b().b();
            if (b2 == null || b2.isEmpty()) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f42237a, "route section info is null");
                this.f42244c.a(2001, SynchronizationConstants.LBS_STATUS_MESSAGE_ROUTE_PLAN_FAILED);
            } else if (b2.isEmpty() || b3 == null || b3.isEmpty() || b3.size() == b2.size()) {
                for (int i2 = 0; i2 < b2.size(); i2++) {
                    if (b2.get(i2) != null) {
                        LatLng a2 = b2.get(i2).a();
                        LatLng b4 = b2.get(i2).b();
                        int a3 = a(i2, b3);
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
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f42237a, "route section info or traffic status info is invalid");
            }
        }
    }

    private void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65562, this) == null) {
            if (!this.Q) {
                this.Q = true;
            }
            LatLng point = (f42241g == null || f42241g.c() == null) ? null : f42241g.c().getPoint();
            LatLng a2 = point != null ? a(point) : null;
            if (a2 != null) {
                this.s = 0;
                try {
                    this.o = this.o.subList(p, this.o.size());
                    this.M = this.M.subList(p, this.M.size());
                } catch (Exception e2) {
                    com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f42237a, "Caught exception when renderRoutePolyLine", e2);
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
            for (int i2 = 0; i2 < size - 1; i2++) {
                if (this.M.get(i2) != null) {
                    this.P.add(Integer.valueOf(this.o.get(i2).c()));
                }
            }
            if (f42239e == null) {
                f42239e = new DisplayOptions();
            }
            if (this.N.isEmpty()) {
                this.N.addAll(f42239e.getTrafficTextureList());
            }
            DisplayOptions displayOptions = f42239e;
            if (displayOptions == null) {
                displayOptions = new DisplayOptions();
            }
            PolylineOptions zIndex = new PolylineOptions().points(this.M).dottedLine(true).width(displayOptions.getRouteLineWidth()).customTextureList(this.N).textureIndex(this.P).zIndex(f42239e.getRouteLineZIndex());
            if (!f42239e.isShowRoutePlan()) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f42237a, "User set route line not display");
                zIndex.visible(false);
            }
            this.O = (Polyline) this.f42243b.addOverlay(zIndex);
            if (this.Q) {
                this.Q = false;
            }
        }
    }

    private void Z() {
        List<LinkPointPolyLineInfo> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65563, this) == null) {
            if (this.m == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f42237a, "CarMarker is null");
            } else if (r != null || (list = this.o) == null || list.isEmpty()) {
                aa();
            } else {
                LatLng a2 = this.o.get(0).a();
                r = a2;
                b(a2);
                c(r);
            }
        }
    }

    private double a(double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65564, this, new Object[]{Double.valueOf(d2)})) == null) {
            if (this.u == 0) {
                this.u = 5;
            }
            return (Math.abs(d2) * this.u) / this.t;
        }
        return invokeCommon.doubleValue;
    }

    private double a(double d2, double d3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65565, this, new Object[]{Double.valueOf(d2), Double.valueOf(d3)})) == null) ? d3 == Double.MAX_VALUE ? d2 : Math.abs((d2 * d3) / Math.sqrt((d3 * d3) + 1.0d)) : invokeCommon.doubleValue;
    }

    private double a(double d2, LatLng latLng) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65566, this, new Object[]{Double.valueOf(d2), latLng})) == null) ? latLng.latitude - (d2 * latLng.longitude) : invokeCommon.doubleValue;
    }

    private int a(int i2, ArrayList<Integer> arrayList) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65568, this, i2, arrayList)) == null) {
            if (arrayList == null || arrayList.isEmpty() || i2 >= arrayList.size()) {
                return 0;
            }
            return arrayList.get(i2).intValue();
        }
        return invokeIL.intValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public LatLng a(LatLng latLng) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65572, this, latLng)) == null) {
            if (3 == f42242h) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f42237a, "WAIT_PASSENGER State, no need calculate");
                return null;
            }
            List<LinkPointPolyLineInfo> list = this.o;
            if (list == null || list.isEmpty()) {
                String str = f42237a;
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(str, "mLinkPolyLineInfos size = " + this.o.size());
                return null;
            }
            for (int i2 = p; i2 < this.o.size(); i2++) {
                LatLng a2 = this.o.get(i2).a();
                LatLng b2 = this.o.get(i2).b();
                if (!a(latLng, a2)) {
                    if (a(latLng, b2)) {
                        this.s = d(i2 + 1);
                        return b2;
                    }
                    boolean a3 = a(a2, b2, latLng);
                    boolean b3 = b(a2, b2, latLng);
                    if (!a3 || !b3) {
                    }
                }
                this.s = d(i2);
                return a2;
            }
            return null;
        }
        return (LatLng) invokeL.objValue;
    }

    private void a(float f2, LatLng latLng, LatLng latLng2) {
        DisplayOptions displayOptions;
        Marker marker;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65574, this, new Object[]{Float.valueOf(f2), latLng, latLng2}) == null) {
            DisplayOptions displayOptions2 = f42239e;
            if (displayOptions2 == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f42237a, "User not set DisplayOptions, use default 2D marker");
                displayOptions = new DisplayOptions();
            } else {
                List<BitmapDescriptor> list = displayOptions2.get3DCarMarkerIconList();
                if (list != null && !list.isEmpty()) {
                    double atan2 = (Math.atan2(latLng2.latitude - latLng.latitude, latLng2.longitude - latLng.longitude) / 3.141592653589793d) * 180.0d;
                    if (atan2 < 0.0d) {
                        atan2 += 360.0d;
                    }
                    if (atan2 == this.Y) {
                        return;
                    }
                    this.Y = atan2;
                    int size = list.size();
                    int i2 = 360 / size;
                    int i3 = (int) (atan2 / i2);
                    if (size == i3) {
                        i3 = 0;
                    }
                    BitmapDescriptor bitmapDescriptor = list.get(i3);
                    if (bitmapDescriptor == null || (marker = this.m) == null) {
                        return;
                    }
                    marker.setIcon(bitmapDescriptor);
                    this.m.setRotate(((float) (atan2 - (i3 * i2))) - 1.0f);
                    return;
                }
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f42237a, "User not set 3D car marker list, use default 2D marker");
                displayOptions = new DisplayOptions();
            }
            this.m.setIcon(displayOptions.getCarIcon());
            this.m.setRotate(f2);
        }
    }

    private void a(LatLngBounds.Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65575, this, builder) == null) {
            DisplayOptions displayOptions = f42239e;
            if (displayOptions == null || displayOptions.isShowStartPositionMarkerInSpan()) {
                builder.include(J());
            } else {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f42237a, "User set not show startPositionMarker in span");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(LatLngBounds latLngBounds) {
        int i2;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65576, this, latLngBounds) == null) {
            synchronized (this) {
                if (this.J && !this.X) {
                    this.J = false;
                    return;
                }
                MapStatus mapStatus = this.f42243b.getMapStatus();
                if (mapStatus == null) {
                    com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f42237a, "Get map status failed");
                    return;
                }
                WinRound winRound = mapStatus.winRound;
                int abs = Math.abs(winRound.right - winRound.left);
                int abs2 = Math.abs(winRound.bottom - winRound.top);
                int i5 = 50;
                if (f42239e != null) {
                    i5 = f42239e.getPaddingLeft();
                    i2 = f42239e.getPaddingTop();
                    i3 = f42239e.getPaddingRight();
                    i4 = f42239e.getPaddingBottom();
                } else {
                    i2 = 50;
                    i3 = 50;
                    i4 = 50;
                }
                int i6 = (abs - i5) - i3;
                int i7 = (abs2 - i2) - i4;
                if (i6 < 0 || i7 < 0 || i6 > abs || i7 > abs2) {
                    com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f42237a, "Invalid padding，use default padding");
                }
                this.f42243b.animateMapStatus(MapStatusUpdateFactory.newLatLngBounds(latLngBounds, i5, i2, i3, i4));
            }
        }
    }

    private synchronized void a(LatLngBounds latLngBounds, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65577, this, new Object[]{latLngBounds, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            synchronized (this) {
                if (f42239e == null) {
                    f42239e = new DisplayOptions();
                }
                f42239e.setMapViewPadding(i2, i3, i4, i5);
                this.f42243b.animateMapStatus(MapStatusUpdateFactory.newLatLngBounds(latLngBounds, i2, i3, i4, i5));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(MyLocationData myLocationData) {
        InterceptResult invokeL;
        long j2;
        long j3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65579, this, myLocationData)) == null) {
            try {
                j2 = Double.valueOf(myLocationData.latitude).longValue();
            } catch (NumberFormatException unused) {
                j2 = 0;
            }
            try {
                j3 = Double.valueOf(myLocationData.longitude).longValue();
            } catch (NumberFormatException unused2) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f42237a, "Trans latitude and longitude failed");
                j3 = 0;
                if (0 == j2) {
                }
            }
            return (0 == j2 || 0 != j3) && j2 >= -90 && j2 <= 90 && j3 >= -180 && j3 <= 180;
        }
        return invokeL.booleanValue;
    }

    private boolean a(LatLng latLng, LatLng latLng2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65580, this, latLng, latLng2)) == null) ? (latLng == null || latLng2 == null) ? latLng == null && latLng2 == null : Math.abs(latLng.latitude - latLng2.latitude) < 1.0E-4d && Math.abs(latLng.longitude - latLng2.longitude) < 1.0E-4d : invokeLL.booleanValue;
    }

    private boolean a(LatLng latLng, LatLng latLng2, double d2) {
        InterceptResult invokeCommon;
        double d3;
        LatLng latLng3;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(65581, this, new Object[]{latLng, latLng2, Double.valueOf(d2)})) != null) {
            return invokeCommon.booleanValue;
        }
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
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65582, this, latLng, latLng2, latLng3)) == null) {
            double d2 = latLng.latitude;
            double d3 = latLng.longitude;
            return Math.abs(((latLng3.latitude - d2) * (latLng2.longitude - d3)) - ((latLng2.latitude - d2) * (latLng3.longitude - d3))) < 1.0E-4d;
        }
        return invokeLLL.booleanValue;
    }

    private synchronized void aa() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65586, this) == null) {
            synchronized (this) {
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
                    Thread thread = new Thread(new RunnableC1668b(this, null), "Car moving");
                    this.q = thread;
                    thread.start();
                }
            }
        }
    }

    private synchronized void ab() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65587, this) == null) {
            synchronized (this) {
                this.Q = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public LatLng ac() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65588, this)) == null) {
            if (f42241g == null || f42241g.c() == null || f42241g.c().getPoint() == null || this.V) {
                return null;
            }
            return f42241g.c().getPoint();
        }
        return (LatLng) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public double ad() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65589, this)) == null) {
            List<LinkPointPolyLineInfo> list = this.o;
            if (list == null || list.isEmpty() || p > this.o.size()) {
                return 1.0d;
            }
            double d2 = 0.0d;
            for (int i2 = p - this.s; i2 < p; i2++) {
                d2 += f(this.o.get(i2).a(), this.o.get(i2).b());
            }
            return d2;
        }
        return invokeV.doubleValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ae() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65590, this) == null) || p == 0) {
            return;
        }
        for (int i2 = p - this.s; i2 < p; i2++) {
            LatLng a2 = this.o.get(i2).a();
            LatLng b2 = this.o.get(i2).b();
            double f2 = f(a2, b2) / 2.0d;
            double d2 = (b2.latitude - a2.latitude) / f2;
            double d3 = (b2.longitude - a2.longitude) / f2;
            double e2 = e(a2, b2);
            int i3 = 1;
            while (i3 <= f2) {
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
                    this.M.set(i2, latLng);
                }
                List<Integer> list2 = this.P;
                if (list2 != null && !list2.isEmpty()) {
                    this.P.set(i2, Integer.valueOf(this.o.get(i2).c()));
                }
                if (!b(a2, latLng)) {
                    return;
                }
                this.L = i2;
                e(i2);
                i3++;
                a2 = latLng;
                f2 = d5;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void af() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65591, this) == null) {
            p = 0;
            this.s = 0;
            this.o.clear();
            this.M.clear();
            this.P.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ag() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65592, this) == null) || this.m == null) {
            return;
        }
        float f2 = 0.0f;
        try {
            f2 = Double.valueOf(360.0d - f42241g.c().getAngle()).floatValue();
        } catch (NumberFormatException e2) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f42237a, "Get DriverPosition Angle failed", e2);
        }
        this.m.setRotate(f2);
    }

    private synchronized void ah() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65593, this) == null) {
            synchronized (this) {
                this.C = true;
            }
        }
    }

    private synchronized void ai() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65594, this) == null) {
            synchronized (this) {
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
                    Thread thread = new Thread(new a(this, null), "Adjust visible span");
                    this.B = thread;
                    thread.start();
                }
            }
        }
    }

    private void aj() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65595, this) == null) {
            this.f42243b.setOnSynchronizationListener(this.G);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ak() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65596, this) == null) {
            int i2 = f42242h;
            if (i2 != 0) {
                if (i2 == 1) {
                    al();
                    return;
                } else if (i2 == 2) {
                    am();
                    return;
                } else if (i2 == 3) {
                    an();
                    return;
                } else if (i2 == 4) {
                    ao();
                    return;
                } else if (i2 != 5) {
                    return;
                }
            }
            ah();
        }
    }

    private void al() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65597, this) == null) {
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            a(builder);
            d(builder);
            c(builder);
            e(builder);
            this.F = h(builder);
        }
    }

    private void am() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65598, this) == null) {
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            a(builder);
            c(builder);
            d(builder);
            e(builder);
            this.F = h(builder);
        }
    }

    private void an() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65599, this) == null) {
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            a(builder);
            c(builder);
            d(builder);
            this.F = h(builder);
        }
    }

    private void ao() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65600, this) == null) {
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            b(builder);
            c(builder);
            e(builder);
            this.F = h(builder);
        }
    }

    private double b(LatLng latLng, LatLng latLng2, double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65601, this, new Object[]{latLng, latLng2, Double.valueOf(d2)})) == null) {
            if (Double.MAX_VALUE == d2) {
                return latLng2.latitude > latLng.latitude ? 360.0d : 180.0d;
            }
            if (0.0d == d2) {
                return latLng2.longitude > latLng.longitude ? 270.0d : 90.0d;
            }
            return (((Math.atan(d2) / 3.141592653589793d) * 180.0d) + ((latLng2.latitude - latLng.latitude) * d2 < 0.0d ? 180.0d : 0.0d)) - 90.0d;
        }
        return invokeCommon.doubleValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(LatLng latLng) {
        Marker marker;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65604, this, latLng) == null) || (marker = this.m) == null) {
            return;
        }
        marker.setPosition(latLng);
    }

    private void b(LatLngBounds.Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65605, this, builder) == null) {
            DisplayOptions displayOptions = f42239e;
            if (displayOptions == null || displayOptions.isShowEndPositionMarkerInSpan()) {
                builder.include(f42238d.getEndPosition());
            } else {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f42237a, "User set not show endPositionMarker in span");
            }
        }
    }

    private boolean b(double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65608, this, new Object[]{Double.valueOf(d2)})) == null) {
            try {
                Thread.sleep(Double.valueOf((d2 * 1000.0d) + 50.0d).longValue());
                return true;
            } catch (InterruptedException unused) {
                return false;
            } catch (NumberFormatException e2) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f42237a, "Calc sleep interval failed", e2);
                return false;
            }
        }
        return invokeCommon.booleanValue;
    }

    private boolean b(LatLng latLng, LatLng latLng2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65609, this, latLng, latLng2)) == null) {
            if (this.Q) {
                return false;
            }
            b(latLng);
            c(latLng);
            double e2 = e(latLng, latLng2);
            float b2 = (float) b(latLng, latLng2, e2);
            if (this.m != null) {
                DisplayOptions displayOptions = f42239e;
                if (displayOptions == null || !displayOptions.get3DCarMarkerEnable()) {
                    this.m.setRotate(b2);
                } else {
                    a(b2, latLng, latLng2);
                }
            }
            boolean c2 = 0.0d == e2 ? c(latLng, latLng2) : a(latLng, latLng2, e2);
            if (c2) {
                r = latLng2;
            }
            return c2;
        }
        return invokeLL.booleanValue;
    }

    private boolean b(LatLng latLng, LatLng latLng2, LatLng latLng3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65610, this, latLng, latLng2, latLng3)) == null) {
            double d2 = latLng.latitude;
            double d3 = latLng.longitude;
            double d4 = latLng2.latitude;
            double d5 = latLng2.longitude;
            double d6 = latLng3.latitude;
            double d7 = latLng3.longitude;
            return Math.min(d2, d4) - 1.0E-4d <= d6 && d6 <= Math.max(d2, d4) + 1.0E-4d && Math.min(d3, d5) - 1.0E-4d <= d7 && d7 <= Math.max(d3, d5) + 1.0E-4d;
        }
        return invokeLLL.booleanValue;
    }

    public static /* synthetic */ int c(b bVar) {
        int i2 = bVar.W;
        bVar.W = i2 + 1;
        return i2;
    }

    private void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65614, this, i2) == null) {
            this.y = 1000 == f42242h;
            this.A = (1 == f42242h && 2 == i2) || (1 == i2 && 2 == f42242h);
            if (f42242h == i2) {
                this.v = false;
                return;
            }
            f42242h = i2;
            this.v = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(LatLng latLng) {
        Marker marker;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65615, this, latLng) == null) || (marker = f42240f) == null) {
            return;
        }
        marker.setPosition(latLng);
    }

    private void c(LatLngBounds.Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65616, this, builder) == null) {
            DisplayOptions displayOptions = f42239e;
            if (displayOptions != null && !displayOptions.isShowCarMarkerInSpan()) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f42237a, "User set not show carMarker in span");
                return;
            }
            Marker marker = this.m;
            builder.include((marker == null || this.I) ? T() : marker.getPosition());
        }
    }

    private boolean c(LatLng latLng, LatLng latLng2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65618, this, latLng, latLng2)) == null) {
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
        return invokeLL.booleanValue;
    }

    private double d(LatLng latLng, LatLng latLng2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65620, this, latLng, latLng2)) == null) ? com.baidu.mapsdkplatform.comapi.synchronization.d.b.a(latLng, latLng2) : invokeLL.doubleValue;
    }

    private synchronized int d(int i2) {
        InterceptResult invokeI;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65621, this, i2)) == null) {
            synchronized (this) {
                i3 = i2 - p;
                p = i2;
            }
            return i3;
        }
        return invokeI.intValue;
    }

    private void d(LatLngBounds.Builder builder) {
        LatLng position;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65622, this, builder) == null) {
            DisplayOptions displayOptions = f42239e;
            if (displayOptions == null || displayOptions.isShowPassengerIconInSpan()) {
                Marker marker = this.n;
                if (marker == null) {
                    MyLocationData locationData = this.f42243b.getLocationData();
                    if (locationData == null) {
                        str = f42237a;
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
            str = f42237a;
            str2 = "User set not show passengerMarker in span";
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(str, str2);
        }
    }

    private double e(LatLng latLng, LatLng latLng2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65625, this, latLng, latLng2)) == null) {
            double d2 = latLng2.longitude;
            double d3 = latLng.longitude;
            if (d2 == d3) {
                return Double.MAX_VALUE;
            }
            return (latLng2.latitude - latLng.latitude) / (d2 - d3);
        }
        return invokeLL.doubleValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(int i2) {
        int[] iArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65626, this, i2) == null) {
            List<LatLng> list = this.M;
            if (list == null || list.isEmpty()) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f42237a, "Route polyline points is null when remove");
            } else if (this.M.size() <= 2 || i2 >= this.M.size() - 2) {
                Polyline polyline = this.O;
                if (polyline != null) {
                    polyline.remove();
                }
            } else {
                List<Integer> list2 = this.P;
                if (list2 == null || list2.isEmpty()) {
                    com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f42237a, "No need removeTravelledPolyLine");
                } else if (!this.z) {
                    try {
                        List<Integer> subList = this.P.subList(i2, this.P.size());
                        iArr = new int[subList.size()];
                        for (int i3 = 0; i3 < subList.size(); i3++) {
                            iArr[i3] = subList.get(i3).intValue();
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    if (this.O != null && !this.Q) {
                        this.O.setIndexs(iArr);
                        try {
                            this.O.setPoints(this.M.subList(i2, this.M.size()));
                        } catch (Exception e3) {
                            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f42237a, "Get subList of PolyLinePointList failed", e3);
                        }
                    }
                }
            }
        }
    }

    private void e(LatLngBounds.Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65627, this, builder) == null) {
            DisplayOptions displayOptions = f42239e;
            if (displayOptions != null && !displayOptions.isShowRoutePlanInSpan()) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f42237a, "User set not show routeLine in span");
                return;
            }
            List<LinkPointPolyLineInfo> list = this.o;
            if (list == null || list.isEmpty()) {
                g(builder);
            } else {
                f(builder);
            }
        }
    }

    private double f(LatLng latLng, LatLng latLng2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65629, this, latLng, latLng2)) == null) ? com.baidu.mapsdkplatform.comapi.synchronization.d.b.a(latLng, latLng2) : invokeLL.doubleValue;
    }

    private void f(LatLngBounds.Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65631, this, builder) == null) {
            for (int i2 = this.L; i2 < this.o.size(); i2++) {
                builder.include(this.o.get(i2).a());
            }
            List<LinkPointPolyLineInfo> list = this.o;
            builder.include(list.get(list.size() - 1).b());
        }
    }

    private void g(LatLngBounds.Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65633, this, builder) == null) {
            if (f42241g == null || f42241g.a() == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f42237a, "There no routeLine info, no need show in span");
                return;
            }
            List<RouteLineInfo.RouteSectionInfo> b2 = f42241g.a().b();
            if (b2 == null || b2.isEmpty()) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f42237a, "There no routeLine position, no need show in span");
                return;
            }
            for (int i2 = 0; i2 < b2.size(); i2++) {
                builder.include(b2.get(i2).a());
            }
            builder.include(b2.get(b2.size() - 1).b());
        }
    }

    private LatLngBounds h(LatLngBounds.Builder builder) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65634, this, builder)) == null) ? builder.build() : (LatLngBounds) invokeL.objValue;
    }

    private void o() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65649, this) == null) || f42239e == null) {
            return;
        }
        Marker marker = f42240f;
        if (marker != null) {
            marker.remove();
            f42240f = null;
        }
        Marker marker2 = this.m;
        if (marker2 != null) {
            marker2.remove();
            this.m = null;
        }
        Marker marker3 = this.f42245i;
        if (marker3 != null) {
            marker3.remove();
            this.f42245i = null;
        }
        Marker marker4 = this.f42246j;
        if (marker4 != null) {
            marker4.remove();
            this.f42246j = null;
        }
        Marker marker5 = this.l;
        if (marker5 != null) {
            marker5.remove();
            this.l = null;
        }
        f42239e.getStartPositionIcon().recycle();
        f42239e.getCarIcon().recycle();
        if (f42239e.getEndPositionIcon() != null) {
            f42239e.getEndPositionIcon().recycle();
        }
        f42239e = null;
    }

    private void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65652, this) == null) {
            p = 0;
            this.u = 0;
            this.Q = true;
            Thread thread = this.q;
            if (thread != null) {
                try {
                    thread.join();
                } catch (InterruptedException unused) {
                    com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f42237a, "InterruptedException when release CarMoveThread");
                }
                this.q = null;
            }
        }
    }

    private void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65654, this) == null) {
            this.w = true;
            if (this.x != null) {
                this.x = null;
            }
        }
    }

    private void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65656, this) == null) {
            this.C = true;
            if (this.B != null) {
                this.B = null;
            }
        }
    }

    private void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65657, this) == null) {
            f42238d = null;
            f42241g = null;
            f42242h = 1000;
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
            for (int i2 = 0; i2 < this.N.size(); i2++) {
                this.N.get(i2).recycle();
            }
            this.N.clear();
        }
    }

    private void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65659, this) == null) {
            P();
            H();
            ah();
            E();
            A();
            B();
            C();
            D();
            BaiduMap baiduMap = this.f42243b;
            if (baiduMap != null) {
                baiduMap.clear();
            }
        }
    }

    private void u() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65661, this) == null) && z()) {
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
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65664, this) == null) && z()) {
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
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65666, this) == null) && z()) {
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
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65668, this) == null) && z()) {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65670, this) == null) {
            P();
            H();
            ah();
            A();
            B();
            C();
            D();
        }
    }

    private boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65672, this)) == null) {
            if (f42238d == null || f42239e == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f42237a, "No render data");
                com.baidu.mapsdkplatform.comapi.synchronization.render.d dVar = this.f42244c;
                if (dVar != null) {
                    dVar.a(CustomerServiceMenu.TRANSFER_RECORD, "Get render data failed");
                }
                return false;
            } else if (this.f42243b == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f42237a, "BaiduMap is null");
                com.baidu.mapsdkplatform.comapi.synchronization.render.d dVar2 = this.f42244c;
                if (dVar2 != null) {
                    dVar2.a(CustomerServiceMenu.TRANSFER_SERVICE, "BaiduMap instance is null.");
                }
                return false;
            } else {
                return true;
            }
        }
        return invokeV.booleanValue;
    }

    public Marker a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f42245i : (Marker) invokeV.objValue;
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.D = i2;
        }
    }

    public void a(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(Constants.METHOD_SEND_USER_MSG, this, i2, i3, i4, i5) == null) {
            this.X = true;
            ak();
            a(this.F, i2, i3, i4, i5);
        }
    }

    public void a(BaiduMap baiduMap, RoleOptions roleOptions, DisplayOptions displayOptions) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, baiduMap, roleOptions, displayOptions) == null) {
            this.f42243b = baiduMap;
            f42238d = roleOptions;
            f42239e = displayOptions;
            this.G = new e(this);
            aj();
            r = null;
            this.f42243b.getUiSettings().setRotateGesturesEnabled(false);
            this.f42243b.getUiSettings().setCompassEnabled(false);
        }
    }

    public synchronized void a(RoleOptions roleOptions, DisplayOptions displayOptions, SyncResponseResult syncResponseResult, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(1048580, this, roleOptions, displayOptions, syncResponseResult, i2) == null) {
            synchronized (this) {
                f42238d = roleOptions;
                f42239e = displayOptions;
                if (displayOptions == null) {
                    f42239e = new DisplayOptions();
                }
                f42241g = syncResponseResult;
                this.u = i2;
            }
        }
    }

    public void a(com.baidu.mapsdkplatform.comapi.synchronization.render.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, dVar) == null) {
            this.f42244c = dVar;
        }
    }

    public Marker b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.k : (Marker) invokeV.objValue;
    }

    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.E = i2;
        }
    }

    public Marker c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.m : (Marker) invokeV.objValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.V = false;
            if (this.U) {
                this.U = false;
                return;
            }
            N();
            ai();
            aa();
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.V = true;
            ab();
            P();
            ah();
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            p();
            q();
            r();
            o();
            s();
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.X = true;
            ak();
            a(this.F);
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, message) == null) {
            String str = f42237a;
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.c(str, "The orderState in message is: " + message.what);
            c(message.what);
            int i2 = message.what;
            if (i2 == 0) {
                t();
            } else if (i2 == 1) {
                u();
            } else if (i2 == 2) {
                v();
            } else if (i2 == 3) {
                w();
            } else if (i2 == 4) {
                x();
            } else if (i2 == 5) {
                y();
            } else {
                String str2 = f42237a;
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.c(str2, "Undefined Message type: " + message.what);
            }
        }
    }
}
