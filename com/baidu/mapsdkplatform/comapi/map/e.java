package com.baidu.mapsdkplatform.comapi.map;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.view.Display;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.UIMsg;
import com.baidu.mapapi.common.EnvironmentUtilities;
import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapBaseIndoorMapInfo;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.mapapi.model.ParcelItem;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.mapsdkplatform.comapi.map.j;
import com.baidu.mapsdkplatform.comjni.map.basemap.BaseMapCallback;
import com.baidu.mapsdkplatform.comjni.map.basemap.JNIBaseMap;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@SuppressLint({"NewApi"})
/* loaded from: classes10.dex */
public class e implements com.baidu.mapsdkplatform.comjni.map.basemap.b {
    public static /* synthetic */ Interceptable $ic;
    public static int N;
    public static int O;
    public static List<JNIBaseMap> ar;

    /* renamed from: d  reason: collision with root package name */
    public static float f35858d;
    public static long m;
    public static final String r;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public aj B;
    public ai C;
    public Context D;
    public List<d> E;
    public x F;
    public g G;
    public ae H;
    public ah I;
    public n J;
    public com.baidu.mapsdkplatform.comapi.map.a K;
    public o L;
    public af M;
    public int P;
    public int Q;
    public int R;
    public j.a S;
    public VelocityTracker T;
    public long U;
    public long V;
    public long W;
    public long X;
    public int Y;
    public float Z;
    public float a;
    public float aa;
    public boolean ab;
    public long ac;
    public long ad;
    public boolean ae;
    public boolean af;
    public float ag;
    public float ah;
    public float ai;
    public float aj;
    public long ak;
    public long al;
    public f am;
    public String an;
    public int ao;
    public b ap;
    public c aq;
    public boolean as;
    public Queue<a> at;
    public boolean au;
    public boolean av;

    /* renamed from: b  reason: collision with root package name */
    public float f35859b;

    /* renamed from: c  reason: collision with root package name */
    public float f35860c;

    /* renamed from: e  reason: collision with root package name */
    public boolean f35861e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f35862f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f35863g;

    /* renamed from: h  reason: collision with root package name */
    public List<l> f35864h;

    /* renamed from: i  reason: collision with root package name */
    public com.baidu.mapsdkplatform.comjni.map.basemap.a f35865i;

    /* renamed from: j  reason: collision with root package name */
    public long f35866j;
    public boolean k;
    public int l;
    public boolean n;
    public boolean o;
    public boolean p;
    public MapStatusUpdate q;
    public boolean s;
    public boolean t;
    public boolean u;
    public boolean v;
    public boolean w;
    public boolean x;
    public boolean y;
    public boolean z;

    /* loaded from: classes10.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;

        /* renamed from: b  reason: collision with root package name */
        public int f35867b;

        /* renamed from: c  reason: collision with root package name */
        public int f35868c;

        /* renamed from: d  reason: collision with root package name */
        public int f35869d;

        /* renamed from: e  reason: collision with root package name */
        public Bundle f35870e;

        public a(long j2, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j2), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j2;
            this.f35867b = i2;
            this.f35868c = i3;
            this.f35869d = i4;
        }

        public a(Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bundle};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f35870e = bundle;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(724782127, "Lcom/baidu/mapsdkplatform/comapi/map/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(724782127, "Lcom/baidu/mapsdkplatform/comapi/map/e;");
                return;
            }
        }
        r = j.class.getSimpleName();
        f35858d = 1096.0f;
        m = 0L;
    }

    public e(Context context, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = 21.0f;
        this.f35859b = 4.0f;
        this.f35860c = 21.0f;
        this.u = true;
        this.v = false;
        this.w = false;
        this.x = false;
        this.y = true;
        this.f35861e = true;
        this.f35862f = true;
        this.f35863g = false;
        this.z = true;
        this.A = false;
        this.S = new j.a();
        this.ae = false;
        this.af = false;
        this.ak = 0L;
        this.al = 0L;
        this.as = false;
        this.at = new LinkedList();
        this.q = null;
        this.au = false;
        this.av = false;
        this.D = context;
        this.f35864h = new ArrayList();
        this.an = str;
        this.ao = i2;
    }

    private void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            if (!this.w && !this.t && !this.s && !this.x) {
                this.a = this.f35860c;
                return;
            }
            if (this.a > 20.0f) {
                this.a = 20.0f;
            }
            if (E().a > 20.0f) {
                ab E = E();
                E.a = 20.0f;
                a(E);
            }
        }
    }

    private void S() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65539, this) == null) || this.n) {
            return;
        }
        this.n = true;
        this.o = false;
        List<l> list = this.f35864h;
        if (list != null) {
            for (l lVar : list) {
                if (lVar != null) {
                    lVar.a(E());
                }
            }
        }
    }

    private boolean T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            if (this.f35865i == null || !this.k) {
                return true;
            }
            this.af = false;
            if (this.f35861e) {
                float f2 = (float) (this.al - this.ak);
                float abs = (Math.abs(this.ai - this.ag) * 1000.0f) / f2;
                float abs2 = (Math.abs(this.aj - this.ah) * 1000.0f) / f2;
                float sqrt = (float) Math.sqrt((abs * abs) + (abs2 * abs2));
                if (sqrt <= 500.0f) {
                    return false;
                }
                A();
                a(34, (int) (sqrt * 0.6f), (((int) this.aj) << 16) | ((int) this.ai));
                M();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    private Activity a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, context)) == null) {
            if (context == null) {
                return null;
            }
            if (context instanceof Activity) {
                return (Activity) context;
            }
            if (context instanceof ContextWrapper) {
                return a(((ContextWrapper) context).getBaseContext());
            }
            return null;
        }
        return (Activity) invokeL.objValue;
    }

    private void a(d dVar) {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65542, this, dVar) == null) || (aVar = this.f35865i) == null) {
            return;
        }
        dVar.a = aVar.a(dVar.f35856c, dVar.f35857d, dVar.f35855b);
        this.E.add(dVar);
    }

    private void a(String str, String str2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, this, new Object[]{str, str2, Long.valueOf(j2)}) == null) {
            try {
                Class<?> cls = Class.forName(str);
                cls.getMethod(str2, Long.TYPE).invoke(cls.newInstance(), Long.valueOf(j2));
            } catch (Exception unused) {
            }
        }
    }

    private void b(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65544, this, motionEvent) == null) || this.S.f35890e) {
            return;
        }
        long downTime = motionEvent.getDownTime();
        this.ad = downTime;
        if (downTime - this.ac < 400) {
            downTime = (Math.abs(motionEvent.getX() - this.Z) >= 120.0f || Math.abs(motionEvent.getY() - this.aa) >= 120.0f) ? this.ad : 0L;
        }
        this.ac = downTime;
        this.Z = motionEvent.getX();
        this.aa = motionEvent.getY();
        a(4, 0, (((int) motionEvent.getY()) << 16) | ((int) motionEvent.getX()));
        this.ab = true;
    }

    private void b(String str, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65545, this, str, bundle) == null) || this.f35865i == null) {
            return;
        }
        this.G.a(str);
        this.G.a(bundle);
        this.f35865i.b(this.G.a);
    }

    private boolean c(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, this, motionEvent)) == null) {
            if (!this.S.f35890e && System.currentTimeMillis() - m >= 300) {
                if (this.p) {
                    List<l> list = this.f35864h;
                    if (list != null) {
                        for (l lVar : list) {
                            GeoPoint b2 = b((int) motionEvent.getX(), (int) motionEvent.getY());
                            if (lVar != null) {
                                lVar.d(b2);
                            }
                        }
                    }
                    return true;
                }
                float abs = Math.abs(motionEvent.getX() - this.Z);
                float abs2 = Math.abs(motionEvent.getY() - this.aa);
                int i2 = (SysOSUtil.getDensity() > 1.5d ? 1 : (SysOSUtil.getDensity() == 1.5d ? 0 : -1));
                double density = SysOSUtil.getDensity();
                if (i2 > 0) {
                    density *= 1.5d;
                }
                float f2 = (float) density;
                if (!this.ab || abs / f2 > 3.0f || abs2 / f2 > 3.0f) {
                    this.ab = false;
                    int x = (int) motionEvent.getX();
                    int y = (int) motionEvent.getY();
                    if (x < 0) {
                        x = 0;
                    }
                    if (y < 0) {
                        y = 0;
                    }
                    if (this.f35861e) {
                        BaiduMap.mapStatusReason = 1 | BaiduMap.mapStatusReason;
                        S();
                        a(3, 0, (y << 16) | x);
                    }
                    return false;
                }
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    private boolean d(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, this, motionEvent)) == null) {
            if (this.p) {
                List<l> list = this.f35864h;
                if (list != null) {
                    for (l lVar : list) {
                        GeoPoint b2 = b((int) motionEvent.getX(), (int) motionEvent.getY());
                        if (lVar != null) {
                            lVar.e(b2);
                        }
                    }
                }
                this.p = false;
                return true;
            }
            boolean z = !this.S.f35890e && motionEvent.getEventTime() - this.ad < 400 && Math.abs(motionEvent.getX() - this.Z) < 10.0f && Math.abs(motionEvent.getY() - this.aa) < 10.0f;
            M();
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (z) {
                return false;
            }
            if (x < 0) {
                x = 0;
            }
            if (y < 0) {
                y = 0;
            }
            a(5, 0, (y << 16) | x);
            return true;
        }
        return invokeL.booleanValue;
    }

    private boolean e(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            if (this.f35865i == null || !this.k) {
                return true;
            }
            this.ae = false;
            GeoPoint b2 = b((int) f2, (int) f3);
            if (b2 != null) {
                List<l> list = this.f35864h;
                if (list != null) {
                    for (l lVar : list) {
                        if (lVar != null) {
                            lVar.b(b2);
                        }
                    }
                }
                if (this.f35862f) {
                    ab E = E();
                    E.a += 1.0f;
                    E.f35819d = b2.getLongitudeE6();
                    E.f35820e = b2.getLatitudeE6();
                    a(E, 300);
                    m = System.currentTimeMillis();
                    return true;
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    private boolean e(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, this, bundle)) == null) {
            com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.f35865i;
            if (aVar == null) {
                return false;
            }
            return aVar.e(bundle);
        }
        return invokeL.booleanValue;
    }

    private boolean f(Bundle bundle) {
        InterceptResult invokeL;
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, this, bundle)) == null) {
            if (bundle == null || (aVar = this.f35865i) == null) {
                return false;
            }
            boolean d2 = aVar.d(bundle);
            if (d2) {
                f(d2);
                this.f35865i.b(this.B.a);
            }
            return d2;
        }
        return invokeL.booleanValue;
    }

    private void g(Bundle bundle) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, this, bundle) == null) {
            if (bundle.get("param") == null ? (i2 = bundle.getInt("type")) != h.f35873d.ordinal() && i2 < h.f35875f.ordinal() : (i3 = (bundle = (Bundle) bundle.get("param")).getInt("type")) != h.f35873d.ordinal() && i3 < h.f35875f.ordinal()) {
                h.f35871b.ordinal();
            }
            bundle.putLong("layer_addr", this.I.a);
        }
    }

    public static void m(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65552, null, z) == null) {
            List<JNIBaseMap> b2 = com.baidu.mapsdkplatform.comjni.map.basemap.a.b();
            ar = b2;
            if (b2 == null || b2.size() == 0) {
                com.baidu.mapsdkplatform.comjni.map.basemap.a.b(0L, z);
                return;
            }
            com.baidu.mapsdkplatform.comjni.map.basemap.a.b(ar.get(0).a, z);
            for (JNIBaseMap jNIBaseMap : ar) {
                if (jNIBaseMap != null) {
                    jNIBaseMap.ClearLayer(jNIBaseMap.a, -1L);
                }
            }
        }
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.n || this.o) {
            return;
        }
        this.o = true;
        List<l> list = this.f35864h;
        if (list == null) {
            return;
        }
        for (l lVar : list) {
            if (lVar != null) {
                lVar.a(E());
            }
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.o = false;
            this.n = false;
            List<l> list = this.f35864h;
            if (list == null) {
                return;
            }
            for (l lVar : list) {
                if (lVar != null) {
                    lVar.c(E());
                }
            }
        }
    }

    public boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.f35865i;
            if (aVar != null) {
                return aVar.a(this.H.a);
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.f35865i;
            if (aVar != null) {
                return aVar.a(this.aq.a);
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public ab E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.f35865i;
            if (aVar == null) {
                return null;
            }
            Bundle h2 = aVar.h();
            ab abVar = new ab();
            abVar.a(h2);
            return abVar;
        }
        return (ab) invokeV.objValue;
    }

    public LatLngBounds F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.f35865i;
            if (aVar == null) {
                return null;
            }
            Bundle i2 = aVar.i();
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            builder.include(CoordUtil.mc2ll(new GeoPoint(i2.getInt("minCoory"), i2.getInt("maxCoorx")))).include(CoordUtil.mc2ll(new GeoPoint(i2.getInt("maxCoory"), i2.getInt("minCoorx"))));
            return builder.build();
        }
        return (LatLngBounds) invokeV.objValue;
    }

    public MapStatusUpdate G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.q : (MapStatusUpdate) invokeV.objValue;
    }

    public int H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.P : invokeV.intValue;
    }

    public int I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.Q : invokeV.intValue;
    }

    public ab J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.f35865i;
            if (aVar == null) {
                return null;
            }
            Bundle j2 = aVar.j();
            ab abVar = new ab();
            abVar.a(j2);
            return abVar;
        }
        return (ab) invokeV.objValue;
    }

    public double K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? E().m : invokeV.doubleValue;
    }

    public void L() {
        List<l> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.n = false;
            if (this.o || (list = this.f35864h) == null) {
                return;
            }
            for (l lVar : list) {
                if (lVar != null) {
                    lVar.c(E());
                }
            }
        }
    }

    public void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.R = 0;
            j.a aVar = this.S;
            aVar.f35890e = false;
            aVar.f35893h = 0.0d;
        }
    }

    public float[] N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.f35865i;
            if (aVar == null) {
                return null;
            }
            return aVar.u();
        }
        return (float[]) invokeV.objValue;
    }

    public float[] O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.f35865i;
            if (aVar == null) {
                return null;
            }
            return aVar.v();
        }
        return (float[]) invokeV.objValue;
    }

    public Queue<a> P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.at : (Queue) invokeV.objValue;
    }

    public void Q() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || this.at.isEmpty()) {
            return;
        }
        a poll = this.at.poll();
        if (poll.f35870e == null) {
            com.baidu.mapsdkplatform.comjni.map.basemap.a.a(poll.a, poll.f35867b, poll.f35868c, poll.f35869d);
        } else if (this.f35865i != null) {
            A();
            this.f35865i.a(poll.f35870e);
        }
    }

    public float a(int i2, int i3, int i4, int i5, int i6, int i7) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048593, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7)})) == null) {
            if (this.k) {
                if (this.f35865i == null) {
                    return 0.0f;
                }
                Bundle bundle = new Bundle();
                bundle.putInt("left", i2);
                bundle.putInt("right", i4);
                bundle.putInt("bottom", i5);
                bundle.putInt("top", i3);
                bundle.putInt("hasHW", 1);
                bundle.putInt("width", i6);
                bundle.putInt("height", i7);
                return this.f35865i.c(bundle);
            }
            return 12.0f;
        }
        return invokeCommon.floatValue;
    }

    public int a(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(1048594, this, i2, i3, i4)) == null) {
            if (this.as) {
                this.at.add(new a(this.f35866j, i2, i3, i4));
                return 0;
            }
            return com.baidu.mapsdkplatform.comjni.map.basemap.a.a(this.f35866j, i2, i3, i4);
        }
        return invokeIII.intValue;
    }

    @Override // com.baidu.mapsdkplatform.comjni.map.basemap.b
    public int a(Bundle bundle, long j2, int i2, Bundle bundle2) {
        InterceptResult invokeCommon;
        ag agVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048595, this, new Object[]{bundle, Long.valueOf(j2), Integer.valueOf(i2), bundle2})) == null) {
            g gVar = this.G;
            if (j2 == gVar.a) {
                bundle.putString("jsondata", gVar.a());
                bundle.putBundle("param", this.G.b());
                agVar = this.G;
            } else {
                x xVar = this.F;
                if (j2 == xVar.a) {
                    bundle.putString("jsondata", xVar.a());
                    bundle.putBundle("param", this.F.b());
                    agVar = this.F;
                } else if (j2 == this.J.a) {
                    bundle.putBundle("param", this.L.a(bundle2.getInt("x"), bundle2.getInt("y"), bundle2.getInt("zoom")));
                    agVar = this.J;
                } else if (j2 != this.B.a) {
                    return 0;
                } else {
                    bundle.putBundle("param", this.C.a(bundle2.getInt("x"), bundle2.getInt("y"), bundle2.getInt("zoom"), this.D));
                    agVar = this.B;
                }
            }
            return agVar.f35845g;
        }
        return invokeCommon.intValue;
    }

    public Point a(GeoPoint geoPoint) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, geoPoint)) == null) ? this.M.a(geoPoint) : (Point) invokeL.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.E = new ArrayList();
            f fVar = new f();
            this.am = fVar;
            a(fVar);
            b bVar = new b();
            this.ap = bVar;
            a(bVar);
            n nVar = new n();
            this.J = nVar;
            a(nVar);
            com.baidu.mapsdkplatform.comapi.map.a aVar = new com.baidu.mapsdkplatform.comapi.map.a();
            this.K = aVar;
            a(aVar);
            a(new p());
            ae aeVar = new ae();
            this.H = aeVar;
            a(aeVar);
            c cVar = new c();
            this.aq = cVar;
            a(cVar);
            com.baidu.mapsdkplatform.comjni.map.basemap.a aVar2 = this.f35865i;
            if (aVar2 != null) {
                aVar2.e(false);
            }
            ah ahVar = new ah();
            this.I = ahVar;
            a(ahVar);
            g gVar = new g();
            this.G = gVar;
            a(gVar);
            x xVar = new x();
            this.F = xVar;
            a(xVar);
        }
    }

    public void a(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            this.a = f2;
            this.f35860c = f2;
            this.f35859b = f3;
        }
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i2) == null) {
            com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = new com.baidu.mapsdkplatform.comjni.map.basemap.a();
            this.f35865i = aVar;
            aVar.a(i2);
            long a2 = this.f35865i.a();
            this.f35866j = a2;
            a("com.baidu.platform.comapi.wnplatform.walkmap.WNaviBaiduMap", "setId", a2);
            this.l = SysOSUtil.getDensityDpi() < 180 ? 18 : SysOSUtil.getDensityDpi() < 240 ? 25 : SysOSUtil.getDensityDpi() < 320 ? 37 : 50;
            String moduleFileName = SysOSUtil.getModuleFileName();
            String appSDCardPath = EnvironmentUtilities.getAppSDCardPath();
            String appCachePath = EnvironmentUtilities.getAppCachePath();
            String appSecondCachePath = EnvironmentUtilities.getAppSecondCachePath();
            int mapTmpStgMax = EnvironmentUtilities.getMapTmpStgMax();
            int domTmpStgMax = EnvironmentUtilities.getDomTmpStgMax();
            int itsTmpStgMax = EnvironmentUtilities.getItsTmpStgMax();
            String str = SysOSUtil.getDensityDpi() >= 180 ? "/h/" : "/l/";
            String str2 = moduleFileName + "/cfg";
            String str3 = appSDCardPath + "/vmp";
            String str4 = str2 + "/a/";
            String str5 = str2 + "/a/";
            String str6 = str2 + "/idrres/";
            String str7 = str3 + str;
            String str8 = str3 + str;
            String str9 = appCachePath + "/tmp/";
            String str10 = appSecondCachePath + "/tmp/";
            Activity a3 = a(this.D);
            if (a3 == null) {
                throw new RuntimeException("BDMapSDKException: Please give the right context.");
            }
            Display defaultDisplay = a3.getWindowManager().getDefaultDisplay();
            this.f35865i.a(str4, str7, str9, str10, str8, str5, this.an, this.ao, str6, defaultDisplay.getWidth(), defaultDisplay.getHeight(), SysOSUtil.getDensityDpi(), mapTmpStgMax, domTmpStgMax, itsTmpStgMax, 0);
        }
    }

    public void a(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048600, this, i2, i3) == null) {
            this.P = i2;
            this.Q = i3;
        }
    }

    public void a(long j2, long j3, long j4, long j5, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048601, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5), Boolean.valueOf(z)}) == null) {
            this.f35865i.a(j2, j3, j4, j5, z);
        }
    }

    public void a(Bitmap bitmap) {
        Bundle bundle;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048602, this, bitmap) == null) || this.f35865i == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put("type", 0);
            jSONObject2.put("x", N);
            jSONObject2.put("y", O);
            jSONObject2.put("hidetime", 1000);
            jSONArray.put(jSONObject2);
            jSONObject.put("data", jSONArray);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        if (bitmap == null) {
            bundle = null;
        } else {
            Bundle bundle2 = new Bundle();
            ArrayList arrayList = new ArrayList();
            ParcelItem parcelItem = new ParcelItem();
            Bundle bundle3 = new Bundle();
            ByteBuffer allocate = ByteBuffer.allocate(bitmap.getWidth() * bitmap.getHeight() * 4);
            bitmap.copyPixelsToBuffer(allocate);
            bundle3.putByteArray("imgdata", allocate.array());
            bundle3.putInt("imgindex", bitmap.hashCode());
            bundle3.putInt("imgH", bitmap.getHeight());
            bundle3.putInt("imgW", bitmap.getWidth());
            bundle3.putInt("hasIcon", 1);
            parcelItem.setBundle(bundle3);
            arrayList.add(parcelItem);
            if (arrayList.size() > 0) {
                ParcelItem[] parcelItemArr = new ParcelItem[arrayList.size()];
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    parcelItemArr[i2] = (ParcelItem) arrayList.get(i2);
                }
                bundle2.putParcelableArray("icondata", parcelItemArr);
            }
            bundle = bundle2;
        }
        b(jSONObject.toString(), bundle);
        this.f35865i.b(this.G.a);
    }

    public void a(Handler handler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, handler) == null) {
            MessageCenter.registMessage(4000, handler);
            MessageCenter.registMessage(39, handler);
            MessageCenter.registMessage(41, handler);
            MessageCenter.registMessage(49, handler);
            MessageCenter.registMessage(65289, handler);
            MessageCenter.registMessage(50, handler);
            MessageCenter.registMessage(999, handler);
            BaseMapCallback.addLayerDataInterface(this.f35866j, this);
        }
    }

    public void a(MapStatusUpdate mapStatusUpdate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, mapStatusUpdate) == null) {
            this.q = mapStatusUpdate;
        }
    }

    public void a(LatLngBounds latLngBounds) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048605, this, latLngBounds) == null) || latLngBounds == null || this.f35865i == null) {
            return;
        }
        LatLng latLng = latLngBounds.northeast;
        LatLng latLng2 = latLngBounds.southwest;
        GeoPoint ll2mc = CoordUtil.ll2mc(latLng);
        GeoPoint ll2mc2 = CoordUtil.ll2mc(latLng2);
        int longitudeE6 = (int) ll2mc2.getLongitudeE6();
        int latitudeE6 = (int) ll2mc.getLatitudeE6();
        Bundle bundle = new Bundle();
        bundle.putInt("maxCoorx", (int) ll2mc.getLongitudeE6());
        bundle.putInt("minCoory", (int) ll2mc2.getLatitudeE6());
        bundle.putInt("minCoorx", longitudeE6);
        bundle.putInt("maxCoory", latitudeE6);
        this.f35865i.b(bundle);
    }

    public void a(ab abVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048606, this, abVar) == null) || this.f35865i == null || abVar == null) {
            return;
        }
        Bundle a2 = abVar.a(this);
        a2.putInt("animation", 0);
        a2.putInt("animatime", 0);
        this.f35865i.a(a2);
    }

    public void a(ab abVar, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048607, this, abVar, i2) == null) || this.f35865i == null || abVar == null) {
            return;
        }
        Bundle a2 = abVar.a(this);
        a2.putInt("animation", 1);
        a2.putInt("animatime", i2);
        if (this.as) {
            this.at.add(new a(a2));
            return;
        }
        A();
        this.f35865i.a(a2);
    }

    public void a(ai aiVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, aiVar) == null) {
            this.C = aiVar;
        }
    }

    public void a(l lVar) {
        List<l> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048609, this, lVar) == null) || lVar == null || (list = this.f35864h) == null) {
            return;
        }
        list.add(lVar);
    }

    public void a(o oVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, oVar) == null) {
            this.L = oVar;
        }
    }

    public void a(z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, zVar) == null) {
            new ab();
            if (zVar == null) {
                zVar = new z();
            }
            ab abVar = zVar.a;
            this.y = zVar.f35929f;
            this.z = zVar.f35927d;
            this.f35861e = zVar.f35928e;
            this.f35862f = zVar.f35930g;
            this.f35865i.a(abVar.a(this));
            this.f35865i.c(y.a.ordinal());
            boolean z = zVar.f35925b;
            this.u = z;
            if (z) {
                N = (int) (SysOSUtil.getDensity() * 40.0f);
                O = (int) (SysOSUtil.getDensity() * 40.0f);
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("x", N);
                    jSONObject2.put("y", O);
                    jSONObject2.put("hidetime", 1000);
                    jSONArray.put(jSONObject2);
                    jSONObject.put("data", jSONArray);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                this.G.a(jSONObject.toString());
                this.f35865i.a(this.G.a, true);
            } else {
                this.f35865i.a(this.G.a, false);
            }
            int i2 = zVar.f35926c;
            if (i2 == 2) {
                a(true);
            }
            if (i2 == 3) {
                this.f35865i.a(this.am.a, false);
                this.f35865i.a(this.aq.a, false);
                this.f35865i.a(this.H.a, false);
                this.f35865i.e(false);
            }
        }
    }

    public void a(String str, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048612, this, str, bundle) == null) || this.f35865i == null) {
            return;
        }
        this.F.a(str);
        this.F.a(bundle);
        this.f35865i.b(this.F.a);
    }

    public void a(List<Bundle> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048613, this, list) == null) || this.f35865i == null || list == null) {
            return;
        }
        int size = list.size();
        Bundle[] bundleArr = new Bundle[list.size()];
        for (int i2 = 0; i2 < size; i2++) {
            g(list.get(i2));
            bundleArr[i2] = list.get(i2);
        }
        this.f35865i.a(bundleArr);
    }

    public void a(boolean z) {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048614, this, z) == null) || (aVar = this.f35865i) == null) {
            return;
        }
        if (!aVar.a(this.am.a)) {
            this.f35865i.a(this.am.a, true);
        }
        this.t = z;
        R();
        this.f35865i.a(this.t);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00b2 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:98:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(float f2, float f3, float f4, float f5) {
        InterceptResult invokeCommon;
        float f6;
        j.a aVar;
        boolean z;
        float f7;
        float f8;
        int i2;
        int i3;
        float f9;
        float f10;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(1048615, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)})) != null) {
            return invokeCommon.booleanValue;
        }
        int i4 = this.Q;
        float f11 = i4 - f3;
        float f12 = i4 - f5;
        j.a aVar2 = this.S;
        if (aVar2.f35890e) {
            if (this.R == 0) {
                if (aVar2.f35888c - f11 <= 0.0f || aVar2.f35889d - f12 <= 0.0f) {
                    j.a aVar3 = this.S;
                    if (aVar3.f35888c - f11 >= 0.0f || aVar3.f35889d - f12 >= 0.0f) {
                        z = true;
                        this.R = 2;
                        if (this.R == 0) {
                            return z;
                        }
                    }
                }
                double atan2 = Math.atan2(f12 - f11, f4 - f2);
                j.a aVar4 = this.S;
                double atan22 = atan2 - Math.atan2(aVar4.f35889d - aVar4.f35888c, aVar4.f35887b - aVar4.a);
                double sqrt = Math.sqrt((f10 * f10) + (f9 * f9)) / this.S.f35893h;
                int log = (int) ((Math.log(sqrt) / Math.log(2.0d)) * 10000.0d);
                int i5 = (int) ((atan22 * 180.0d) / 3.1416d);
                if ((sqrt <= 0.0d || (log <= 3000 && log >= -3000)) && Math.abs(i5) < 10) {
                    z = true;
                    this.R = 1;
                } else {
                    this.R = 2;
                    z = true;
                }
                if (this.R == 0) {
                }
            } else {
                z = true;
            }
            if (this.R == z && this.y) {
                j.a aVar5 = this.S;
                if (aVar5.f35888c - f11 <= 0.0f || aVar5.f35889d - f12 <= 0.0f) {
                    j.a aVar6 = this.S;
                    if (aVar6.f35888c - f11 < 0.0f && aVar6.f35889d - f12 < 0.0f) {
                        S();
                        i3 = 87;
                    }
                } else {
                    S();
                    i3 = 83;
                }
                a(1, i3, 0);
            } else {
                int i6 = this.R;
                if (i6 == 2 || i6 == 4 || i6 == 3) {
                    double atan23 = Math.atan2(f12 - f11, f4 - f2);
                    j.a aVar7 = this.S;
                    double atan24 = atan23 - Math.atan2(aVar7.f35889d - aVar7.f35888c, aVar7.f35887b - aVar7.a);
                    double sqrt2 = Math.sqrt((f8 * f8) + (f7 * f7)) / this.S.f35893h;
                    int log2 = (int) ((Math.log(sqrt2) / Math.log(2.0d)) * 10000.0d);
                    j.a aVar8 = this.S;
                    double atan25 = Math.atan2(aVar8.f35892g - aVar8.f35888c, aVar8.f35891f - aVar8.a);
                    j.a aVar9 = this.S;
                    float f13 = aVar9.f35891f;
                    float f14 = aVar9.a;
                    float f15 = (f13 - f14) * (f13 - f14);
                    float f16 = aVar9.f35892g;
                    float f17 = aVar9.f35888c;
                    double sqrt3 = Math.sqrt(f15 + ((f16 - f17) * (f16 - f17)));
                    double d2 = atan25 + atan24;
                    f6 = f12;
                    float cos = (float) ((Math.cos(d2) * sqrt3 * sqrt2) + f2);
                    float sin = (float) ((sqrt3 * Math.sin(d2) * sqrt2) + f11);
                    int i7 = (int) ((atan24 * 180.0d) / 3.1416d);
                    if (sqrt2 > 0.0d && (3 == this.R || (Math.abs(log2) > 2000 && 2 == this.R))) {
                        this.R = 3;
                        float f18 = E().a;
                        if (this.f35862f) {
                            if (sqrt2 <= 1.0d) {
                                i2 = 3;
                                if (f18 <= this.f35859b) {
                                    return false;
                                }
                                S();
                            } else if (f18 >= this.a) {
                                return false;
                            } else {
                                S();
                                i2 = 3;
                            }
                            a(UIMsg.k_event.V_WM_ROTATE, i2, log2);
                        }
                    } else if (i7 != 0 && (4 == this.R || (Math.abs(i7) > 10 && 2 == this.R))) {
                        this.R = 4;
                        if (this.z) {
                            BaiduMap.mapStatusReason |= 1;
                            S();
                            a(UIMsg.k_event.V_WM_ROTATE, 1, i7);
                        }
                    }
                    j.a aVar10 = this.S;
                    aVar10.f35891f = cos;
                    aVar10.f35892g = sin;
                    if (2 != this.R) {
                        j.a aVar11 = this.S;
                        aVar11.f35888c = f11;
                        aVar11.f35889d = f6;
                        aVar11.a = f2;
                        aVar11.f35887b = f4;
                    }
                    aVar = this.S;
                    if (aVar.f35890e) {
                        aVar.f35891f = this.P / 2;
                        aVar.f35892g = this.Q / 2;
                        aVar.f35890e = true;
                        if (0.0d == aVar.f35893h) {
                            float f19 = aVar.f35887b;
                            float f20 = aVar.a;
                            float f21 = (f19 - f20) * (f19 - f20);
                            float f22 = aVar.f35889d;
                            float f23 = aVar.f35888c;
                            this.S.f35893h = Math.sqrt(f21 + ((f22 - f23) * (f22 - f23)));
                            return true;
                        }
                        return true;
                    }
                    return true;
                }
            }
        }
        f6 = f12;
        if (2 != this.R) {
        }
        aVar = this.S;
        if (aVar.f35890e) {
        }
    }

    @Override // com.baidu.mapsdkplatform.comjni.map.basemap.b
    public boolean a(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048616, this, j2)) == null) {
            Iterator<d> it = this.E.iterator();
            while (it.hasNext()) {
                if (it.next().a == j2) {
                    return true;
                }
            }
            return false;
        }
        return invokeJ.booleanValue;
    }

    public boolean a(Point point) {
        InterceptResult invokeL;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048617, this, point)) == null) {
            if (point != null && this.f35865i != null && (i2 = point.x) >= 0 && (i3 = point.y) >= 0) {
                N = i2;
                O = i3;
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("x", N);
                    jSONObject2.put("y", O);
                    jSONObject2.put("hidetime", 1000);
                    jSONArray.put(jSONObject2);
                    jSONObject.put("data", jSONArray);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                this.G.a(jSONObject.toString());
                this.f35865i.b(this.G.a);
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean a(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048618, this, bundle)) == null) {
            if (this.f35865i == null) {
                return false;
            }
            aj ajVar = new aj();
            this.B = ajVar;
            long a2 = this.f35865i.a(ajVar.f35856c, ajVar.f35857d, ajVar.f35855b);
            if (a2 != 0) {
                aj ajVar2 = this.B;
                ajVar2.a = a2;
                this.E.add(ajVar2);
                bundle.putLong("sdktileaddr", a2);
                if (e(bundle) && f(bundle)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:142:0x032d  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x033f  */
    /* JADX WARN: Removed duplicated region for block: B:166:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01c3 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(MotionEvent motionEvent) {
        InterceptResult invokeL;
        int i2;
        float xVelocity;
        float f2;
        j.a aVar;
        float f3;
        boolean z;
        float f4;
        float f5;
        e eVar;
        int i3;
        int i4;
        int i5;
        int i6;
        float f6;
        float f7;
        j.a aVar2;
        ab E;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048619, this, motionEvent)) != null) {
            return invokeL.booleanValue;
        }
        int pointerCount = motionEvent.getPointerCount();
        if (pointerCount == 2 && (!c((int) motionEvent.getX(0), (int) motionEvent.getY(0)) || !c((int) motionEvent.getX(1), (int) motionEvent.getY(1)))) {
            pointerCount = 1;
        }
        if (pointerCount != 2) {
            int action = motionEvent.getAction();
            if (action == 0) {
                b(motionEvent);
            } else if (action == 1) {
                return d(motionEvent);
            } else {
                if (action != 2) {
                    return false;
                }
                c(motionEvent);
            }
            return true;
        }
        float y = this.Q - motionEvent.getY(0);
        float y2 = this.Q - motionEvent.getY(1);
        float x = motionEvent.getX(0);
        float x2 = motionEvent.getX(1);
        int action2 = motionEvent.getAction();
        if (action2 != 5) {
            if (action2 == 6) {
                this.X = motionEvent.getEventTime();
            } else if (action2 != 261) {
                if (action2 == 262) {
                    this.W = motionEvent.getEventTime();
                }
                if (this.T == null) {
                    this.T = VelocityTracker.obtain();
                }
                this.T.addMovement(motionEvent);
                int minimumFlingVelocity = ViewConfiguration.getMinimumFlingVelocity();
                this.T.computeCurrentVelocity(1000, ViewConfiguration.getMaximumFlingVelocity());
                xVelocity = this.T.getXVelocity(1);
                float yVelocity = this.T.getYVelocity(1);
                float xVelocity2 = this.T.getXVelocity(2);
                float yVelocity2 = this.T.getYVelocity(2);
                f2 = minimumFlingVelocity;
                if (Math.abs(xVelocity) <= f2 || Math.abs(yVelocity) > f2 || Math.abs(xVelocity2) > f2 || Math.abs(yVelocity2) > f2) {
                    aVar = this.S;
                    if (aVar.f35890e) {
                        if (this.R == 0) {
                            if (aVar.f35888c - y <= 0.0f || aVar.f35889d - y2 <= 0.0f) {
                                j.a aVar3 = this.S;
                                if (aVar3.f35888c - y >= 0.0f || aVar3.f35889d - y2 >= 0.0f) {
                                    f3 = y2;
                                    z = true;
                                    this.R = 2;
                                    if (this.R == 0) {
                                        return z;
                                    }
                                }
                            }
                            f3 = y2;
                            double atan2 = Math.atan2(y2 - y, x2 - x);
                            j.a aVar4 = this.S;
                            double atan22 = atan2 - Math.atan2(aVar4.f35889d - aVar4.f35888c, aVar4.f35887b - aVar4.a);
                            double sqrt = Math.sqrt((f7 * f7) + (f6 * f6)) / this.S.f35893h;
                            int log = (int) ((Math.log(sqrt) / Math.log(2.0d)) * 10000.0d);
                            int i7 = (int) ((atan22 * 180.0d) / 3.1416d);
                            if ((sqrt <= 0.0d || (log <= 3000 && log >= -3000)) && Math.abs(i7) < 10) {
                                z = true;
                                this.R = 1;
                            } else {
                                this.R = 2;
                                z = true;
                            }
                            if (this.R == 0) {
                            }
                        } else {
                            f3 = y2;
                            z = true;
                        }
                        if (this.R == z && this.y) {
                            j.a aVar5 = this.S;
                            if (aVar5.f35888c - y <= 0.0f || aVar5.f35889d - f3 <= 0.0f) {
                                j.a aVar6 = this.S;
                                if (aVar6.f35888c - y < 0.0f && aVar6.f35889d - f3 < 0.0f) {
                                    i5 = 1;
                                    BaiduMap.mapStatusReason |= 1;
                                    S();
                                    i6 = 87;
                                }
                            } else {
                                i5 = 1;
                                BaiduMap.mapStatusReason |= 1;
                                S();
                                i6 = 83;
                            }
                            a(i5, i6, 0);
                        } else {
                            int i8 = this.R;
                            if (i8 == 2 || i8 == 4 || i8 == 3) {
                                double atan23 = Math.atan2(f3 - y, x2 - x);
                                j.a aVar7 = this.S;
                                double atan24 = atan23 - Math.atan2(aVar7.f35889d - aVar7.f35888c, aVar7.f35887b - aVar7.a);
                                double sqrt2 = Math.sqrt((f5 * f5) + (f4 * f4)) / this.S.f35893h;
                                int log2 = (int) ((Math.log(sqrt2) / Math.log(2.0d)) * 10000.0d);
                                j.a aVar8 = this.S;
                                double atan25 = Math.atan2(aVar8.f35892g - aVar8.f35888c, aVar8.f35891f - aVar8.a);
                                j.a aVar9 = this.S;
                                float f8 = aVar9.f35891f;
                                float f9 = aVar9.a;
                                float f10 = aVar9.f35892g;
                                float f11 = aVar9.f35888c;
                                double sqrt3 = Math.sqrt(((f8 - f9) * (f8 - f9)) + ((f10 - f11) * (f10 - f11)));
                                double d2 = atan25 + atan24;
                                float cos = (float) ((Math.cos(d2) * sqrt3 * sqrt2) + x);
                                float sin = (float) ((sqrt3 * Math.sin(d2) * sqrt2) + y);
                                int i9 = (int) ((atan24 * 180.0d) / 3.1416d);
                                eVar = this;
                                if (sqrt2 > 0.0d && (3 == eVar.R || (Math.abs(log2) > 2000 && 2 == eVar.R))) {
                                    eVar.R = 3;
                                    float f12 = E().a;
                                    if (eVar.f35862f) {
                                        if (sqrt2 <= 1.0d) {
                                            i3 = log2;
                                            i4 = 3;
                                            if (f12 <= eVar.f35859b) {
                                                return false;
                                            }
                                            BaiduMap.mapStatusReason |= 1;
                                            S();
                                        } else if (f12 >= eVar.a) {
                                            return false;
                                        } else {
                                            BaiduMap.mapStatusReason |= 1;
                                            S();
                                            i3 = log2;
                                            i4 = 3;
                                        }
                                        eVar.a(UIMsg.k_event.V_WM_ROTATE, i4, i3);
                                    }
                                } else if (i9 != 0 && (4 == eVar.R || (Math.abs(i9) > 10 && 2 == eVar.R))) {
                                    eVar.R = 4;
                                    if (eVar.z) {
                                        S();
                                        eVar.a(UIMsg.k_event.V_WM_ROTATE, 1, i9);
                                    }
                                }
                                j.a aVar10 = eVar.S;
                                aVar10.f35891f = cos;
                                aVar10.f35892g = sin;
                                if (2 != eVar.R) {
                                    j.a aVar11 = eVar.S;
                                    aVar11.f35888c = y;
                                    aVar11.f35889d = f3;
                                    aVar11.a = x;
                                    aVar11.f35887b = x2;
                                }
                                aVar2 = eVar.S;
                                if (aVar2.f35890e) {
                                    return true;
                                }
                                aVar2.f35891f = eVar.P / 2;
                                aVar2.f35892g = eVar.Q / 2;
                                aVar2.f35890e = true;
                                if (0.0d == aVar2.f35893h) {
                                    float f13 = aVar2.f35887b;
                                    float f14 = aVar2.a;
                                    float f15 = (f13 - f14) * (f13 - f14);
                                    float f16 = aVar2.f35889d;
                                    float f17 = aVar2.f35888c;
                                    eVar.S.f35893h = Math.sqrt(f15 + ((f16 - f17) * (f16 - f17)));
                                    return true;
                                }
                                return true;
                            }
                        }
                        eVar = this;
                        if (2 != eVar.R) {
                        }
                        aVar2 = eVar.S;
                        if (aVar2.f35890e) {
                        }
                    }
                } else if (this.R == 0 && this.Y == 0) {
                    long j2 = this.W;
                    long j3 = this.X;
                    if (j2 <= j3) {
                        j2 = j3;
                    }
                    this.W = j2;
                    long j4 = this.U;
                    long j5 = this.V;
                    if (j4 < j5) {
                        j4 = j5;
                    }
                    this.U = j4;
                    if (this.W - j4 < 200 && this.f35862f && (E = E()) != null) {
                        E.a -= 1.0f;
                        BaiduMap.mapStatusReason |= 1;
                        a(E, 300);
                    }
                }
                eVar = this;
                f3 = y2;
                if (2 != eVar.R) {
                }
                aVar2 = eVar.S;
                if (aVar2.f35890e) {
                }
            } else {
                this.U = motionEvent.getEventTime();
            }
            i2 = this.Y + 1;
            this.Y = i2;
            if (this.T == null) {
            }
            this.T.addMovement(motionEvent);
            int minimumFlingVelocity2 = ViewConfiguration.getMinimumFlingVelocity();
            this.T.computeCurrentVelocity(1000, ViewConfiguration.getMaximumFlingVelocity());
            xVelocity = this.T.getXVelocity(1);
            float yVelocity3 = this.T.getYVelocity(1);
            float xVelocity22 = this.T.getXVelocity(2);
            float yVelocity22 = this.T.getYVelocity(2);
            f2 = minimumFlingVelocity2;
            if (Math.abs(xVelocity) <= f2) {
            }
            aVar = this.S;
            if (aVar.f35890e) {
            }
            eVar = this;
            f3 = y2;
            if (2 != eVar.R) {
            }
            aVar2 = eVar.S;
            if (aVar2.f35890e) {
            }
        } else {
            this.V = motionEvent.getEventTime();
        }
        i2 = this.Y - 1;
        this.Y = i2;
        if (this.T == null) {
        }
        this.T.addMovement(motionEvent);
        int minimumFlingVelocity22 = ViewConfiguration.getMinimumFlingVelocity();
        this.T.computeCurrentVelocity(1000, ViewConfiguration.getMaximumFlingVelocity());
        xVelocity = this.T.getXVelocity(1);
        float yVelocity32 = this.T.getYVelocity(1);
        float xVelocity222 = this.T.getXVelocity(2);
        float yVelocity222 = this.T.getYVelocity(2);
        f2 = minimumFlingVelocity22;
        if (Math.abs(xVelocity) <= f2) {
        }
        aVar = this.S;
        if (aVar.f35890e) {
        }
        eVar = this;
        f3 = y2;
        if (2 != eVar.R) {
        }
        aVar2 = eVar.S;
        if (aVar2.f35890e) {
        }
    }

    public boolean a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048620, this, str, str2)) == null) ? this.f35865i.a(str, str2) : invokeLL.booleanValue;
    }

    public GeoPoint b(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048621, this, i2, i3)) == null) ? this.M.a(i2, i3) : (GeoPoint) invokeII.objValue;
    }

    public void b(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048622, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) || this.S.f35890e) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.ad = currentTimeMillis;
        if (currentTimeMillis - this.ac < 400) {
            if (Math.abs(f2 - this.Z) < 120.0f && Math.abs(f3 - this.aa) < 120.0f) {
                this.ac = 0L;
                this.ae = true;
                this.Z = f2;
                this.aa = f3;
                a(4, 0, ((int) f2) | (((int) f3) << 16));
                this.ab = true;
            }
            currentTimeMillis = this.ad;
        }
        this.ac = currentTimeMillis;
        this.Z = f2;
        this.aa = f3;
        a(4, 0, ((int) f2) | (((int) f3) << 16));
        this.ab = true;
    }

    public void b(int i2) {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048623, this, i2) == null) || (aVar = this.f35865i) == null) {
            return;
        }
        aVar.b(i2);
        this.f35865i = null;
    }

    public void b(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048624, this, bundle) == null) || this.f35865i == null) {
            return;
        }
        g(bundle);
        this.f35865i.f(bundle);
    }

    public void b(Handler handler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, handler) == null) {
            MessageCenter.unregistMessage(4000, handler);
            MessageCenter.unregistMessage(41, handler);
            MessageCenter.unregistMessage(49, handler);
            MessageCenter.unregistMessage(39, handler);
            MessageCenter.unregistMessage(65289, handler);
            MessageCenter.unregistMessage(50, handler);
            MessageCenter.unregistMessage(999, handler);
            BaseMapCallback.removeLayerDataInterface(this.f35866j);
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048626, this, z) == null) {
            this.A = z;
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) ? this.A : invokeV.booleanValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048628, this) == null) || this.f35865i == null) {
            return;
        }
        for (d dVar : this.E) {
            this.f35865i.a(dVar.a, false);
        }
    }

    public void c(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048629, this, bundle) == null) || this.f35865i == null) {
            return;
        }
        g(bundle);
        this.f35865i.g(bundle);
    }

    public void c(boolean z) {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar;
        boolean z2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048630, this, z) == null) || (aVar = this.f35865i) == null) {
            return;
        }
        if (z) {
            if (this.au) {
                return;
            }
            aVar.a(this.ap.a, this.I.a);
            z2 = true;
        } else if (!this.au) {
            return;
        } else {
            aVar.a(this.I.a, this.ap.a);
            z2 = false;
        }
        this.au = z2;
    }

    public boolean c(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048631, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            if (!this.S.f35890e && System.currentTimeMillis() - m >= 300) {
                if (this.p) {
                    List<l> list = this.f35864h;
                    if (list != null) {
                        for (l lVar : list) {
                            GeoPoint b2 = b((int) f2, (int) f3);
                            if (lVar != null) {
                                lVar.d(b2);
                            }
                        }
                    }
                    return true;
                }
                float abs = Math.abs(f2 - this.Z);
                float abs2 = Math.abs(f3 - this.aa);
                int i2 = (SysOSUtil.getDensity() > 1.5d ? 1 : (SysOSUtil.getDensity() == 1.5d ? 0 : -1));
                double density = SysOSUtil.getDensity();
                if (i2 > 0) {
                    density *= 1.5d;
                }
                float f4 = (float) density;
                if (!this.ab || abs / f4 > 3.0f || abs2 / f4 > 3.0f) {
                    this.ab = false;
                    int i3 = (int) f2;
                    int i4 = (int) f3;
                    if (i3 < 0) {
                        i3 = 0;
                    }
                    if (i4 < 0) {
                        i4 = 0;
                    }
                    if (this.f35861e) {
                        this.ag = this.ai;
                        this.ah = this.aj;
                        this.ai = f2;
                        this.aj = f3;
                        this.ak = this.al;
                        this.al = System.currentTimeMillis();
                        this.af = true;
                        S();
                        a(3, 0, (i4 << 16) | i3);
                    }
                    return false;
                }
                return true;
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public boolean c(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048632, this, i2, i3)) == null) ? i2 >= 0 && i2 <= this.P + 0 && i3 >= 0 && i3 <= this.Q + 0 : invokeII.booleanValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048633, this) == null) || this.f35865i == null) {
            return;
        }
        for (d dVar : this.E) {
            if ((dVar instanceof x) || (dVar instanceof com.baidu.mapsdkplatform.comapi.map.a) || (dVar instanceof n)) {
                this.f35865i.a(dVar.a, false);
            } else {
                this.f35865i.a(dVar.a, true);
            }
        }
        this.f35865i.c(false);
    }

    public void d(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048634, this, bundle) == null) || this.f35865i == null) {
            return;
        }
        g(bundle);
        this.f35865i.h(bundle);
    }

    public void d(boolean z) {
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048635, this, z) == null) {
            if (z) {
                if (this.av) {
                    return;
                }
                this.f35865i.a(this.I.a, this.F.a);
                z2 = true;
            } else if (!this.av) {
                return;
            } else {
                this.f35865i.a(this.F.a, this.I.a);
                z2 = false;
            }
            this.av = z2;
        }
    }

    public boolean d(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048636, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            if (this.p) {
                List<l> list = this.f35864h;
                if (list != null) {
                    for (l lVar : list) {
                        GeoPoint b2 = b((int) f2, (int) f3);
                        if (lVar != null) {
                            lVar.e(b2);
                        }
                    }
                }
                this.p = false;
                return true;
            }
            if (!this.S.f35890e) {
                if (this.ae) {
                    return e(f2, f3);
                }
                if (this.af) {
                    return T();
                }
                if (System.currentTimeMillis() - this.ad < 400 && Math.abs(f2 - this.Z) < 10.0f && Math.abs(f3 - this.aa) < 10.0f) {
                    M();
                    return true;
                }
            }
            M();
            int i2 = (int) f2;
            int i3 = (int) f3;
            if (i2 < 0) {
                i2 = 0;
            }
            if (i3 < 0) {
                i3 = 0;
            }
            a(5, 0, i2 | (i3 << 16));
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public void e(boolean z) {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048637, this, z) == null) || (aVar = this.f35865i) == null) {
            return;
        }
        aVar.a(this.G.a, z);
    }

    public boolean e() {
        InterceptResult invokeV;
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) {
            aj ajVar = this.B;
            if (ajVar == null || (aVar = this.f35865i) == null) {
                return false;
            }
            return aVar.c(ajVar.a);
        }
        return invokeV.booleanValue;
    }

    public void f() {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048639, this) == null) || (aVar = this.f35865i) == null) {
            return;
        }
        this.M = new af(aVar);
    }

    public void f(boolean z) {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048640, this, z) == null) || (aVar = this.f35865i) == null) {
            return;
        }
        aVar.a(this.B.a, z);
    }

    public void g(boolean z) {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048641, this, z) == null) || (aVar = this.f35865i) == null) {
            return;
        }
        aVar.a(this.am.a, z);
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) ? this.s : invokeV.booleanValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) {
            com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.f35865i;
            if (aVar == null) {
                return null;
            }
            return aVar.e(this.G.a);
        }
        return (String) invokeV.objValue;
    }

    public void h(boolean z) {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048644, this, z) == null) || (aVar = this.f35865i) == null) {
            return;
        }
        this.x = z;
        aVar.b(z);
    }

    public void i(boolean z) {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048645, this, z) == null) || (aVar = this.f35865i) == null) {
            return;
        }
        this.s = z;
        aVar.c(z);
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) ? this.x : invokeV.booleanValue;
    }

    public void j(boolean z) {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048647, this, z) == null) || (aVar = this.f35865i) == null) {
            return;
        }
        aVar.d(z);
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048648, this)) == null) {
            com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.f35865i;
            if (aVar == null) {
                return false;
            }
            return aVar.k();
        }
        return invokeV.booleanValue;
    }

    public void k(boolean z) {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048649, this, z) == null) || (aVar = this.f35865i) == null) {
            return;
        }
        this.u = z;
        aVar.a(this.G.a, z);
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048650, this)) == null) ? this.t : invokeV.booleanValue;
    }

    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048651, this, z) == null) {
            float f2 = z ? 22.0f : 21.0f;
            this.a = f2;
            this.f35860c = f2;
            this.f35865i.e(z);
            this.f35865i.d(this.ap.a);
            this.f35865i.d(this.aq.a);
        }
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) ? this.f35865i.a(this.am.a) : invokeV.booleanValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048653, this)) == null) {
            com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.f35865i;
            if (aVar == null) {
                return false;
            }
            return aVar.o();
        }
        return invokeV.booleanValue;
    }

    public void n() {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048654, this) == null) || (aVar = this.f35865i) == null) {
            return;
        }
        aVar.d(this.I.a);
    }

    public void n(boolean z) {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048655, this, z) == null) || (aVar = this.f35865i) == null) {
            return;
        }
        this.v = z;
        aVar.a(this.F.a, z);
    }

    public void o() {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048656, this) == null) || (aVar = this.f35865i) == null) {
            return;
        }
        aVar.p();
        this.f35865i.b(this.J.a);
    }

    public void o(boolean z) {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048657, this, z) == null) || (aVar = this.f35865i) == null) {
            return;
        }
        this.w = z;
        aVar.a(this.J.a, z);
    }

    public MapBaseIndoorMapInfo p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048658, this)) == null) ? this.f35865i.q() : (MapBaseIndoorMapInfo) invokeV.objValue;
    }

    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048659, this, z) == null) {
            this.f35861e = z;
        }
    }

    public void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048660, this, z) == null) {
            this.f35862f = z;
        }
    }

    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048661, this)) == null) ? this.f35865i.r() : invokeV.booleanValue;
    }

    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048662, this, z) == null) {
            this.f35863g = z;
        }
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048663, this)) == null) ? this.u : invokeV.booleanValue;
    }

    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048664, this, z) == null) {
            this.z = z;
        }
    }

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048665, this)) == null) ? this.v : invokeV.booleanValue;
    }

    public void t() {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048666, this) == null) || (aVar = this.f35865i) == null) {
            return;
        }
        aVar.b(this.J.a);
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048667, this, z) == null) {
            this.y = z;
        }
    }

    public void u() {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048668, this) == null) || (aVar = this.f35865i) == null) {
            return;
        }
        aVar.e();
    }

    public void u(boolean z) {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048669, this, z) == null) || (aVar = this.f35865i) == null) {
            return;
        }
        aVar.a(this.H.a, z);
    }

    public void v() {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048670, this) == null) || (aVar = this.f35865i) == null) {
            return;
        }
        aVar.f();
    }

    public void v(boolean z) {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048671, this, z) == null) || (aVar = this.f35865i) == null) {
            return;
        }
        aVar.a(this.aq.a, z);
    }

    public void w(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048672, this, z) == null) {
            this.as = z;
        }
    }

    public boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048673, this)) == null) ? this.f35861e : invokeV.booleanValue;
    }

    public boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048674, this)) == null) ? this.f35862f : invokeV.booleanValue;
    }

    public boolean y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048675, this)) == null) ? this.z : invokeV.booleanValue;
    }

    public boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048676, this)) == null) ? this.y : invokeV.booleanValue;
    }
}
