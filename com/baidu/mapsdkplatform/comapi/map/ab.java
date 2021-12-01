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
/* loaded from: classes8.dex */
public class ab {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String t = "ab";
    public transient /* synthetic */ FieldHolder $fh;
    public float a;

    /* renamed from: b  reason: collision with root package name */
    public int f36389b;

    /* renamed from: c  reason: collision with root package name */
    public int f36390c;

    /* renamed from: d  reason: collision with root package name */
    public double f36391d;

    /* renamed from: e  reason: collision with root package name */
    public double f36392e;

    /* renamed from: f  reason: collision with root package name */
    public int f36393f;

    /* renamed from: g  reason: collision with root package name */
    public int f36394g;

    /* renamed from: h  reason: collision with root package name */
    public long f36395h;

    /* renamed from: i  reason: collision with root package name */
    public long f36396i;

    /* renamed from: j  reason: collision with root package name */
    public WinRound f36397j;

    /* renamed from: k  reason: collision with root package name */
    public a f36398k;
    public boolean l;
    public double m;
    public double n;
    public int o;
    public String p;
    public float q;
    public boolean r;
    public int s;

    /* loaded from: classes8.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;

        /* renamed from: b  reason: collision with root package name */
        public long f36399b;

        /* renamed from: c  reason: collision with root package name */
        public long f36400c;

        /* renamed from: d  reason: collision with root package name */
        public long f36401d;

        /* renamed from: e  reason: collision with root package name */
        public Point f36402e;

        /* renamed from: f  reason: collision with root package name */
        public Point f36403f;

        /* renamed from: g  reason: collision with root package name */
        public Point f36404g;

        /* renamed from: h  reason: collision with root package name */
        public Point f36405h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ ab f36406i;

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
            this.f36406i = abVar;
            this.a = 0L;
            this.f36399b = 0L;
            this.f36400c = 0L;
            this.f36401d = 0L;
            this.f36402e = new Point(0, 0);
            this.f36403f = new Point(0, 0);
            this.f36404g = new Point(0, 0);
            this.f36405h = new Point(0, 0);
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
        this.f36389b = 0;
        this.f36390c = 0;
        this.f36391d = 1.2958162E7d;
        this.f36392e = 4825907.0d;
        this.f36395h = 0L;
        this.f36396i = 0L;
        this.f36393f = -1;
        this.f36394g = -1;
        this.f36397j = new WinRound();
        this.f36398k = new a(this);
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
            float f3 = eVar.f36433b;
            if (f2 < f3) {
                this.a = f3;
            }
            float f4 = this.a;
            float f5 = eVar.a;
            if (f4 > f5) {
                if (f4 == 1096.0f || e.f36432d == 26.0f) {
                    this.a = 26.0f;
                    e.f36432d = 26.0f;
                } else {
                    this.a = f5;
                }
            }
            while (true) {
                i2 = this.f36389b;
                if (i2 >= 0) {
                    break;
                }
                this.f36389b = i2 + 360;
            }
            this.f36389b = i2 % 360;
            if (this.f36390c > 0) {
                this.f36390c = 0;
            }
            if (this.f36390c < -45) {
                this.f36390c = -45;
            }
            Bundle bundle = new Bundle();
            bundle.putDouble("level", this.a);
            bundle.putDouble("rotation", this.f36389b);
            bundle.putDouble("overlooking", this.f36390c);
            bundle.putDouble("centerptx", this.f36391d);
            bundle.putDouble("centerpty", this.f36392e);
            bundle.putInt("left", this.f36397j.left);
            bundle.putInt("right", this.f36397j.right);
            bundle.putInt("top", this.f36397j.top);
            bundle.putInt("bottom", this.f36397j.bottom);
            int i6 = this.f36393f;
            if (i6 >= 0 && (i3 = this.f36394g) >= 0 && i6 <= (i4 = (winRound = this.f36397j).right) && i3 <= (i5 = winRound.bottom) && i4 > 0 && i5 > 0) {
                long j2 = i6 - ((i4 - winRound.left) / 2);
                this.f36395h = j2;
                this.f36396i = -(i3 - ((i5 - winRound.top) / 2));
                bundle.putLong("xoffset", j2);
                bundle.putLong("yoffset", this.f36396i);
            }
            bundle.putInt("lbx", this.f36398k.f36402e.x);
            bundle.putInt("lby", this.f36398k.f36402e.y);
            bundle.putInt("ltx", this.f36398k.f36403f.x);
            bundle.putInt("lty", this.f36398k.f36403f.y);
            bundle.putInt("rtx", this.f36398k.f36404g.x);
            bundle.putInt("rty", this.f36398k.f36404g.y);
            bundle.putInt("rbx", this.f36398k.f36405h.x);
            bundle.putInt("rby", this.f36398k.f36405h.y);
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
            this.f36389b = (int) bundle.getDouble("rotation");
            this.f36390c = (int) bundle.getDouble("overlooking");
            this.f36391d = bundle.getDouble("centerptx");
            this.f36392e = bundle.getDouble("centerpty");
            this.f36397j.left = bundle.getInt("left");
            this.f36397j.right = bundle.getInt("right");
            this.f36397j.top = bundle.getInt("top");
            this.f36397j.bottom = bundle.getInt("bottom");
            this.f36395h = bundle.getLong("xoffset");
            long j2 = bundle.getLong("yoffset");
            this.f36396i = j2;
            WinRound winRound = this.f36397j;
            int i3 = winRound.right;
            if (i3 != 0 && (i2 = winRound.bottom) != 0) {
                this.f36393f = ((int) this.f36395h) + ((i3 - winRound.left) / 2);
                this.f36394g = ((int) (-j2)) + ((i2 - winRound.top) / 2);
            }
            this.f36398k.a = bundle.getLong("gleft");
            this.f36398k.f36399b = bundle.getLong("gright");
            this.f36398k.f36400c = bundle.getLong("gtop");
            this.f36398k.f36401d = bundle.getLong("gbottom");
            a aVar = this.f36398k;
            if (aVar.a <= -20037508) {
                aVar.a = -20037508L;
            }
            a aVar2 = this.f36398k;
            if (aVar2.f36399b >= 20037508) {
                aVar2.f36399b = 20037508L;
            }
            a aVar3 = this.f36398k;
            if (aVar3.f36400c >= 20037508) {
                aVar3.f36400c = 20037508L;
            }
            a aVar4 = this.f36398k;
            if (aVar4.f36401d <= -20037508) {
                aVar4.f36401d = -20037508L;
            }
            this.f36398k.f36402e.x = bundle.getInt("lbx");
            this.f36398k.f36402e.y = bundle.getInt("lby");
            this.f36398k.f36403f.x = bundle.getInt("ltx");
            this.f36398k.f36403f.y = bundle.getInt("lty");
            this.f36398k.f36404g.x = bundle.getInt("rtx");
            this.f36398k.f36404g.y = bundle.getInt("rty");
            this.f36398k.f36405h.x = bundle.getInt("rbx");
            this.f36398k.f36405h.y = bundle.getInt("rby");
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
