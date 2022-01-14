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
    public int f35817b;

    /* renamed from: c  reason: collision with root package name */
    public int f35818c;

    /* renamed from: d  reason: collision with root package name */
    public double f35819d;

    /* renamed from: e  reason: collision with root package name */
    public double f35820e;

    /* renamed from: f  reason: collision with root package name */
    public int f35821f;

    /* renamed from: g  reason: collision with root package name */
    public int f35822g;

    /* renamed from: h  reason: collision with root package name */
    public long f35823h;

    /* renamed from: i  reason: collision with root package name */
    public long f35824i;

    /* renamed from: j  reason: collision with root package name */
    public WinRound f35825j;
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
        public long f35826b;

        /* renamed from: c  reason: collision with root package name */
        public long f35827c;

        /* renamed from: d  reason: collision with root package name */
        public long f35828d;

        /* renamed from: e  reason: collision with root package name */
        public Point f35829e;

        /* renamed from: f  reason: collision with root package name */
        public Point f35830f;

        /* renamed from: g  reason: collision with root package name */
        public Point f35831g;

        /* renamed from: h  reason: collision with root package name */
        public Point f35832h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ ab f35833i;

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
            this.f35833i = abVar;
            this.a = 0L;
            this.f35826b = 0L;
            this.f35827c = 0L;
            this.f35828d = 0L;
            this.f35829e = new Point(0, 0);
            this.f35830f = new Point(0, 0);
            this.f35831g = new Point(0, 0);
            this.f35832h = new Point(0, 0);
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
        this.f35817b = 0;
        this.f35818c = 0;
        this.f35819d = 1.2958162E7d;
        this.f35820e = 4825907.0d;
        this.f35823h = 0L;
        this.f35824i = 0L;
        this.f35821f = -1;
        this.f35822g = -1;
        this.f35825j = new WinRound();
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
            float f3 = eVar.f35859b;
            if (f2 < f3) {
                this.a = f3;
            }
            float f4 = this.a;
            float f5 = eVar.a;
            if (f4 > f5) {
                if (f4 == 1096.0f || e.f35858d == 26.0f) {
                    this.a = 26.0f;
                    e.f35858d = 26.0f;
                } else {
                    this.a = f5;
                }
            }
            while (true) {
                i2 = this.f35817b;
                if (i2 >= 0) {
                    break;
                }
                this.f35817b = i2 + 360;
            }
            this.f35817b = i2 % 360;
            if (this.f35818c > 0) {
                this.f35818c = 0;
            }
            if (this.f35818c < -45) {
                this.f35818c = -45;
            }
            Bundle bundle = new Bundle();
            bundle.putDouble("level", this.a);
            bundle.putDouble("rotation", this.f35817b);
            bundle.putDouble("overlooking", this.f35818c);
            bundle.putDouble("centerptx", this.f35819d);
            bundle.putDouble("centerpty", this.f35820e);
            bundle.putInt("left", this.f35825j.left);
            bundle.putInt("right", this.f35825j.right);
            bundle.putInt("top", this.f35825j.top);
            bundle.putInt("bottom", this.f35825j.bottom);
            int i6 = this.f35821f;
            if (i6 >= 0 && (i3 = this.f35822g) >= 0 && i6 <= (i4 = (winRound = this.f35825j).right) && i3 <= (i5 = winRound.bottom) && i4 > 0 && i5 > 0) {
                long j2 = i6 - ((i4 - winRound.left) / 2);
                this.f35823h = j2;
                this.f35824i = -(i3 - ((i5 - winRound.top) / 2));
                bundle.putLong("xoffset", j2);
                bundle.putLong("yoffset", this.f35824i);
            }
            bundle.putInt("lbx", this.k.f35829e.x);
            bundle.putInt("lby", this.k.f35829e.y);
            bundle.putInt("ltx", this.k.f35830f.x);
            bundle.putInt("lty", this.k.f35830f.y);
            bundle.putInt("rtx", this.k.f35831g.x);
            bundle.putInt("rty", this.k.f35831g.y);
            bundle.putInt("rbx", this.k.f35832h.x);
            bundle.putInt("rby", this.k.f35832h.y);
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
            this.f35817b = (int) bundle.getDouble("rotation");
            this.f35818c = (int) bundle.getDouble("overlooking");
            this.f35819d = bundle.getDouble("centerptx");
            this.f35820e = bundle.getDouble("centerpty");
            this.f35825j.left = bundle.getInt("left");
            this.f35825j.right = bundle.getInt("right");
            this.f35825j.top = bundle.getInt("top");
            this.f35825j.bottom = bundle.getInt("bottom");
            this.f35823h = bundle.getLong("xoffset");
            long j2 = bundle.getLong("yoffset");
            this.f35824i = j2;
            WinRound winRound = this.f35825j;
            int i3 = winRound.right;
            if (i3 != 0 && (i2 = winRound.bottom) != 0) {
                this.f35821f = ((int) this.f35823h) + ((i3 - winRound.left) / 2);
                this.f35822g = ((int) (-j2)) + ((i2 - winRound.top) / 2);
            }
            this.k.a = bundle.getLong("gleft");
            this.k.f35826b = bundle.getLong("gright");
            this.k.f35827c = bundle.getLong("gtop");
            this.k.f35828d = bundle.getLong("gbottom");
            a aVar = this.k;
            if (aVar.a <= -20037508) {
                aVar.a = -20037508L;
            }
            a aVar2 = this.k;
            if (aVar2.f35826b >= 20037508) {
                aVar2.f35826b = 20037508L;
            }
            a aVar3 = this.k;
            if (aVar3.f35827c >= 20037508) {
                aVar3.f35827c = 20037508L;
            }
            a aVar4 = this.k;
            if (aVar4.f35828d <= -20037508) {
                aVar4.f35828d = -20037508L;
            }
            this.k.f35829e.x = bundle.getInt("lbx");
            this.k.f35829e.y = bundle.getInt("lby");
            this.k.f35830f.x = bundle.getInt("ltx");
            this.k.f35830f.y = bundle.getInt("lty");
            this.k.f35831g.x = bundle.getInt("rtx");
            this.k.f35831g.y = bundle.getInt("rty");
            this.k.f35832h.x = bundle.getInt("rbx");
            this.k.f35832h.y = bundle.getInt("rby");
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
