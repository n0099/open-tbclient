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
/* loaded from: classes4.dex */
public class ab {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String t = "ab";
    public transient /* synthetic */ FieldHolder $fh;
    public float a;

    /* renamed from: b  reason: collision with root package name */
    public int f34454b;

    /* renamed from: c  reason: collision with root package name */
    public int f34455c;

    /* renamed from: d  reason: collision with root package name */
    public double f34456d;

    /* renamed from: e  reason: collision with root package name */
    public double f34457e;

    /* renamed from: f  reason: collision with root package name */
    public int f34458f;

    /* renamed from: g  reason: collision with root package name */
    public int f34459g;

    /* renamed from: h  reason: collision with root package name */
    public long f34460h;

    /* renamed from: i  reason: collision with root package name */
    public long f34461i;

    /* renamed from: j  reason: collision with root package name */
    public WinRound f34462j;
    public a k;
    public boolean l;
    public double m;
    public double n;
    public int o;
    public String p;
    public float q;
    public boolean r;
    public int s;

    /* loaded from: classes4.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;

        /* renamed from: b  reason: collision with root package name */
        public long f34463b;

        /* renamed from: c  reason: collision with root package name */
        public long f34464c;

        /* renamed from: d  reason: collision with root package name */
        public long f34465d;

        /* renamed from: e  reason: collision with root package name */
        public Point f34466e;

        /* renamed from: f  reason: collision with root package name */
        public Point f34467f;

        /* renamed from: g  reason: collision with root package name */
        public Point f34468g;

        /* renamed from: h  reason: collision with root package name */
        public Point f34469h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ ab f34470i;

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
            this.f34470i = abVar;
            this.a = 0L;
            this.f34463b = 0L;
            this.f34464c = 0L;
            this.f34465d = 0L;
            this.f34466e = new Point(0, 0);
            this.f34467f = new Point(0, 0);
            this.f34468g = new Point(0, 0);
            this.f34469h = new Point(0, 0);
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
        this.f34454b = 0;
        this.f34455c = 0;
        this.f34456d = 1.2958162E7d;
        this.f34457e = 4825907.0d;
        this.f34460h = 0L;
        this.f34461i = 0L;
        this.f34458f = -1;
        this.f34459g = -1;
        this.f34462j = new WinRound();
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
            float f3 = eVar.f34496b;
            if (f2 < f3) {
                this.a = f3;
            }
            float f4 = this.a;
            float f5 = eVar.a;
            if (f4 > f5) {
                if (f4 == 1096.0f || e.f34495d == 26.0f) {
                    this.a = 26.0f;
                    e.f34495d = 26.0f;
                } else {
                    this.a = f5;
                }
            }
            while (true) {
                i2 = this.f34454b;
                if (i2 >= 0) {
                    break;
                }
                this.f34454b = i2 + 360;
            }
            this.f34454b = i2 % 360;
            if (this.f34455c > 0) {
                this.f34455c = 0;
            }
            if (this.f34455c < -45) {
                this.f34455c = -45;
            }
            Bundle bundle = new Bundle();
            bundle.putDouble("level", this.a);
            bundle.putDouble("rotation", this.f34454b);
            bundle.putDouble("overlooking", this.f34455c);
            bundle.putDouble("centerptx", this.f34456d);
            bundle.putDouble("centerpty", this.f34457e);
            bundle.putInt("left", this.f34462j.left);
            bundle.putInt("right", this.f34462j.right);
            bundle.putInt("top", this.f34462j.top);
            bundle.putInt("bottom", this.f34462j.bottom);
            int i6 = this.f34458f;
            if (i6 >= 0 && (i3 = this.f34459g) >= 0 && i6 <= (i4 = (winRound = this.f34462j).right) && i3 <= (i5 = winRound.bottom) && i4 > 0 && i5 > 0) {
                long j2 = i6 - ((i4 - winRound.left) / 2);
                this.f34460h = j2;
                this.f34461i = -(i3 - ((i5 - winRound.top) / 2));
                bundle.putLong("xoffset", j2);
                bundle.putLong("yoffset", this.f34461i);
            }
            bundle.putInt("lbx", this.k.f34466e.x);
            bundle.putInt("lby", this.k.f34466e.y);
            bundle.putInt("ltx", this.k.f34467f.x);
            bundle.putInt("lty", this.k.f34467f.y);
            bundle.putInt("rtx", this.k.f34468g.x);
            bundle.putInt("rty", this.k.f34468g.y);
            bundle.putInt("rbx", this.k.f34469h.x);
            bundle.putInt("rby", this.k.f34469h.y);
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
            this.f34454b = (int) bundle.getDouble("rotation");
            this.f34455c = (int) bundle.getDouble("overlooking");
            this.f34456d = bundle.getDouble("centerptx");
            this.f34457e = bundle.getDouble("centerpty");
            this.f34462j.left = bundle.getInt("left");
            this.f34462j.right = bundle.getInt("right");
            this.f34462j.top = bundle.getInt("top");
            this.f34462j.bottom = bundle.getInt("bottom");
            this.f34460h = bundle.getLong("xoffset");
            long j2 = bundle.getLong("yoffset");
            this.f34461i = j2;
            WinRound winRound = this.f34462j;
            int i3 = winRound.right;
            if (i3 != 0 && (i2 = winRound.bottom) != 0) {
                this.f34458f = ((int) this.f34460h) + ((i3 - winRound.left) / 2);
                this.f34459g = ((int) (-j2)) + ((i2 - winRound.top) / 2);
            }
            this.k.a = bundle.getLong("gleft");
            this.k.f34463b = bundle.getLong("gright");
            this.k.f34464c = bundle.getLong("gtop");
            this.k.f34465d = bundle.getLong("gbottom");
            a aVar = this.k;
            if (aVar.a <= -20037508) {
                aVar.a = -20037508L;
            }
            a aVar2 = this.k;
            if (aVar2.f34463b >= 20037508) {
                aVar2.f34463b = 20037508L;
            }
            a aVar3 = this.k;
            if (aVar3.f34464c >= 20037508) {
                aVar3.f34464c = 20037508L;
            }
            a aVar4 = this.k;
            if (aVar4.f34465d <= -20037508) {
                aVar4.f34465d = -20037508L;
            }
            this.k.f34466e.x = bundle.getInt("lbx");
            this.k.f34466e.y = bundle.getInt("lby");
            this.k.f34467f.x = bundle.getInt("ltx");
            this.k.f34467f.y = bundle.getInt("lty");
            this.k.f34468g.x = bundle.getInt("rtx");
            this.k.f34468g.y = bundle.getInt("rty");
            this.k.f34469h.x = bundle.getInt("rbx");
            this.k.f34469h.y = bundle.getInt("rby");
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
