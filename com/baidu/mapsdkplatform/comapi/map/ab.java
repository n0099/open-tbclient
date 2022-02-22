package com.baidu.mapsdkplatform.comapi.map;

import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.map.WinRound;
import com.baidu.mapapi.model.inner.Point;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class ab {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String t = "ab";
    public transient /* synthetic */ FieldHolder $fh;
    public float a;

    /* renamed from: b  reason: collision with root package name */
    public int f36051b;

    /* renamed from: c  reason: collision with root package name */
    public int f36052c;

    /* renamed from: d  reason: collision with root package name */
    public double f36053d;

    /* renamed from: e  reason: collision with root package name */
    public double f36054e;

    /* renamed from: f  reason: collision with root package name */
    public int f36055f;

    /* renamed from: g  reason: collision with root package name */
    public int f36056g;

    /* renamed from: h  reason: collision with root package name */
    public long f36057h;

    /* renamed from: i  reason: collision with root package name */
    public long f36058i;

    /* renamed from: j  reason: collision with root package name */
    public WinRound f36059j;
    public a k;
    public boolean l;
    public double m;
    public double n;
    public int o;
    public String p;
    public float q;
    public boolean r;
    public int s;

    /* loaded from: classes10.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;

        /* renamed from: b  reason: collision with root package name */
        public long f36060b;

        /* renamed from: c  reason: collision with root package name */
        public long f36061c;

        /* renamed from: d  reason: collision with root package name */
        public long f36062d;

        /* renamed from: e  reason: collision with root package name */
        public Point f36063e;

        /* renamed from: f  reason: collision with root package name */
        public Point f36064f;

        /* renamed from: g  reason: collision with root package name */
        public Point f36065g;

        /* renamed from: h  reason: collision with root package name */
        public Point f36066h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ ab f36067i;

        public a(ab abVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {abVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f36067i = abVar;
            this.a = 0L;
            this.f36060b = 0L;
            this.f36061c = 0L;
            this.f36062d = 0L;
            this.f36063e = new Point(0, 0);
            this.f36064f = new Point(0, 0);
            this.f36065g = new Point(0, 0);
            this.f36066h = new Point(0, 0);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(993406881, "Lcom/baidu/mapsdkplatform/comapi/map/ab;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(993406881, "Lcom/baidu/mapsdkplatform/comapi/map/ab;");
        }
    }

    public ab() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = 12.0f;
        this.f36051b = 0;
        this.f36052c = 0;
        this.f36053d = 1.2958162E7d;
        this.f36054e = 4825907.0d;
        this.f36057h = 0L;
        this.f36058i = 0L;
        this.f36055f = -1;
        this.f36056g = -1;
        this.f36059j = new WinRound();
        this.k = new a(this);
        this.l = false;
    }

    public Bundle a(e eVar) {
        InterceptResult invokeL;
        int i2;
        int i3;
        WinRound winRound;
        int i4;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, eVar)) == null) {
            float f2 = this.a;
            float f3 = eVar.f36093b;
            if (f2 < f3) {
                this.a = f3;
            }
            float f4 = this.a;
            float f5 = eVar.a;
            if (f4 > f5) {
                if (f4 == 1096.0f || e.f36092d == 26.0f) {
                    this.a = 26.0f;
                    e.f36092d = 26.0f;
                } else {
                    this.a = f5;
                }
            }
            while (true) {
                i2 = this.f36051b;
                if (i2 >= 0) {
                    break;
                }
                this.f36051b = i2 + 360;
            }
            this.f36051b = i2 % 360;
            if (this.f36052c > 0) {
                this.f36052c = 0;
            }
            if (this.f36052c < -45) {
                this.f36052c = -45;
            }
            Bundle bundle = new Bundle();
            bundle.putDouble("level", this.a);
            bundle.putDouble("rotation", this.f36051b);
            bundle.putDouble("overlooking", this.f36052c);
            bundle.putDouble("centerptx", this.f36053d);
            bundle.putDouble("centerpty", this.f36054e);
            bundle.putInt("left", this.f36059j.left);
            bundle.putInt("right", this.f36059j.right);
            bundle.putInt("top", this.f36059j.top);
            bundle.putInt("bottom", this.f36059j.bottom);
            int i6 = this.f36055f;
            if (i6 >= 0 && (i3 = this.f36056g) >= 0 && i6 <= (i4 = (winRound = this.f36059j).right) && i3 <= (i5 = winRound.bottom) && i4 > 0 && i5 > 0) {
                long j2 = i6 - ((i4 - winRound.left) / 2);
                this.f36057h = j2;
                this.f36058i = -(i3 - ((i5 - winRound.top) / 2));
                bundle.putLong("xoffset", j2);
                bundle.putLong("yoffset", this.f36058i);
            }
            bundle.putInt("lbx", this.k.f36063e.x);
            bundle.putInt("lby", this.k.f36063e.y);
            bundle.putInt("ltx", this.k.f36064f.x);
            bundle.putInt("lty", this.k.f36064f.y);
            bundle.putInt("rtx", this.k.f36065g.x);
            bundle.putInt("rty", this.k.f36065g.y);
            bundle.putInt("rbx", this.k.f36066h.x);
            bundle.putInt("rby", this.k.f36066h.y);
            bundle.putInt("bfpp", this.l ? 1 : 0);
            bundle.putInt("animation", 1);
            bundle.putInt("animatime", this.o);
            bundle.putString("panoid", this.p);
            bundle.putInt("autolink", 0);
            bundle.putFloat("siangle", this.q);
            bundle.putInt("isbirdeye", this.r ? 1 : 0);
            bundle.putInt("ssext", this.s);
            return bundle;
        }
        return (Bundle) invokeL.objValue;
    }

    public void a(Bundle bundle) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            this.a = (float) bundle.getDouble("level");
            this.f36051b = (int) bundle.getDouble("rotation");
            this.f36052c = (int) bundle.getDouble("overlooking");
            this.f36053d = bundle.getDouble("centerptx");
            this.f36054e = bundle.getDouble("centerpty");
            this.f36059j.left = bundle.getInt("left");
            this.f36059j.right = bundle.getInt("right");
            this.f36059j.top = bundle.getInt("top");
            this.f36059j.bottom = bundle.getInt("bottom");
            this.f36057h = bundle.getLong("xoffset");
            long j2 = bundle.getLong("yoffset");
            this.f36058i = j2;
            WinRound winRound = this.f36059j;
            int i3 = winRound.right;
            if (i3 != 0 && (i2 = winRound.bottom) != 0) {
                this.f36055f = ((int) this.f36057h) + ((i3 - winRound.left) / 2);
                this.f36056g = ((int) (-j2)) + ((i2 - winRound.top) / 2);
            }
            this.k.a = bundle.getLong("gleft");
            this.k.f36060b = bundle.getLong("gright");
            this.k.f36061c = bundle.getLong("gtop");
            this.k.f36062d = bundle.getLong("gbottom");
            a aVar = this.k;
            if (aVar.a <= -20037508) {
                aVar.a = -20037508L;
            }
            a aVar2 = this.k;
            if (aVar2.f36060b >= 20037508) {
                aVar2.f36060b = 20037508L;
            }
            a aVar3 = this.k;
            if (aVar3.f36061c >= 20037508) {
                aVar3.f36061c = 20037508L;
            }
            a aVar4 = this.k;
            if (aVar4.f36062d <= -20037508) {
                aVar4.f36062d = -20037508L;
            }
            this.k.f36063e.x = bundle.getInt("lbx");
            this.k.f36063e.y = bundle.getInt("lby");
            this.k.f36064f.x = bundle.getInt("ltx");
            this.k.f36064f.y = bundle.getInt("lty");
            this.k.f36065g.x = bundle.getInt("rtx");
            this.k.f36065g.y = bundle.getInt("rty");
            this.k.f36066h.x = bundle.getInt("rbx");
            this.k.f36066h.y = bundle.getInt("rby");
            this.l = bundle.getInt("bfpp") == 1;
            this.m = bundle.getDouble("adapterzoomunit");
            this.n = bundle.getDouble("zoomunit");
            this.p = bundle.getString("panoid");
            this.q = bundle.getFloat("siangle");
            this.r = bundle.getInt("isbirdeye") != 0;
            this.s = bundle.getInt("ssext");
        }
    }
}
