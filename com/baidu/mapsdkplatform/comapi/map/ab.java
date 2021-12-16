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
    public int f36878b;

    /* renamed from: c  reason: collision with root package name */
    public int f36879c;

    /* renamed from: d  reason: collision with root package name */
    public double f36880d;

    /* renamed from: e  reason: collision with root package name */
    public double f36881e;

    /* renamed from: f  reason: collision with root package name */
    public int f36882f;

    /* renamed from: g  reason: collision with root package name */
    public int f36883g;

    /* renamed from: h  reason: collision with root package name */
    public long f36884h;

    /* renamed from: i  reason: collision with root package name */
    public long f36885i;

    /* renamed from: j  reason: collision with root package name */
    public WinRound f36886j;

    /* renamed from: k  reason: collision with root package name */
    public a f36887k;
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
        public long f36888b;

        /* renamed from: c  reason: collision with root package name */
        public long f36889c;

        /* renamed from: d  reason: collision with root package name */
        public long f36890d;

        /* renamed from: e  reason: collision with root package name */
        public Point f36891e;

        /* renamed from: f  reason: collision with root package name */
        public Point f36892f;

        /* renamed from: g  reason: collision with root package name */
        public Point f36893g;

        /* renamed from: h  reason: collision with root package name */
        public Point f36894h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ ab f36895i;

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
            this.f36895i = abVar;
            this.a = 0L;
            this.f36888b = 0L;
            this.f36889c = 0L;
            this.f36890d = 0L;
            this.f36891e = new Point(0, 0);
            this.f36892f = new Point(0, 0);
            this.f36893g = new Point(0, 0);
            this.f36894h = new Point(0, 0);
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
        this.f36878b = 0;
        this.f36879c = 0;
        this.f36880d = 1.2958162E7d;
        this.f36881e = 4825907.0d;
        this.f36884h = 0L;
        this.f36885i = 0L;
        this.f36882f = -1;
        this.f36883g = -1;
        this.f36886j = new WinRound();
        this.f36887k = new a(this);
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
            float f3 = eVar.f36922b;
            if (f2 < f3) {
                this.a = f3;
            }
            float f4 = this.a;
            float f5 = eVar.a;
            if (f4 > f5) {
                if (f4 == 1096.0f || e.f36921d == 26.0f) {
                    this.a = 26.0f;
                    e.f36921d = 26.0f;
                } else {
                    this.a = f5;
                }
            }
            while (true) {
                i2 = this.f36878b;
                if (i2 >= 0) {
                    break;
                }
                this.f36878b = i2 + 360;
            }
            this.f36878b = i2 % 360;
            if (this.f36879c > 0) {
                this.f36879c = 0;
            }
            if (this.f36879c < -45) {
                this.f36879c = -45;
            }
            Bundle bundle = new Bundle();
            bundle.putDouble("level", this.a);
            bundle.putDouble("rotation", this.f36878b);
            bundle.putDouble("overlooking", this.f36879c);
            bundle.putDouble("centerptx", this.f36880d);
            bundle.putDouble("centerpty", this.f36881e);
            bundle.putInt("left", this.f36886j.left);
            bundle.putInt("right", this.f36886j.right);
            bundle.putInt("top", this.f36886j.top);
            bundle.putInt("bottom", this.f36886j.bottom);
            int i6 = this.f36882f;
            if (i6 >= 0 && (i3 = this.f36883g) >= 0 && i6 <= (i4 = (winRound = this.f36886j).right) && i3 <= (i5 = winRound.bottom) && i4 > 0 && i5 > 0) {
                long j2 = i6 - ((i4 - winRound.left) / 2);
                this.f36884h = j2;
                this.f36885i = -(i3 - ((i5 - winRound.top) / 2));
                bundle.putLong("xoffset", j2);
                bundle.putLong("yoffset", this.f36885i);
            }
            bundle.putInt("lbx", this.f36887k.f36891e.x);
            bundle.putInt("lby", this.f36887k.f36891e.y);
            bundle.putInt("ltx", this.f36887k.f36892f.x);
            bundle.putInt("lty", this.f36887k.f36892f.y);
            bundle.putInt("rtx", this.f36887k.f36893g.x);
            bundle.putInt("rty", this.f36887k.f36893g.y);
            bundle.putInt("rbx", this.f36887k.f36894h.x);
            bundle.putInt("rby", this.f36887k.f36894h.y);
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
            this.f36878b = (int) bundle.getDouble("rotation");
            this.f36879c = (int) bundle.getDouble("overlooking");
            this.f36880d = bundle.getDouble("centerptx");
            this.f36881e = bundle.getDouble("centerpty");
            this.f36886j.left = bundle.getInt("left");
            this.f36886j.right = bundle.getInt("right");
            this.f36886j.top = bundle.getInt("top");
            this.f36886j.bottom = bundle.getInt("bottom");
            this.f36884h = bundle.getLong("xoffset");
            long j2 = bundle.getLong("yoffset");
            this.f36885i = j2;
            WinRound winRound = this.f36886j;
            int i3 = winRound.right;
            if (i3 != 0 && (i2 = winRound.bottom) != 0) {
                this.f36882f = ((int) this.f36884h) + ((i3 - winRound.left) / 2);
                this.f36883g = ((int) (-j2)) + ((i2 - winRound.top) / 2);
            }
            this.f36887k.a = bundle.getLong("gleft");
            this.f36887k.f36888b = bundle.getLong("gright");
            this.f36887k.f36889c = bundle.getLong("gtop");
            this.f36887k.f36890d = bundle.getLong("gbottom");
            a aVar = this.f36887k;
            if (aVar.a <= -20037508) {
                aVar.a = -20037508L;
            }
            a aVar2 = this.f36887k;
            if (aVar2.f36888b >= 20037508) {
                aVar2.f36888b = 20037508L;
            }
            a aVar3 = this.f36887k;
            if (aVar3.f36889c >= 20037508) {
                aVar3.f36889c = 20037508L;
            }
            a aVar4 = this.f36887k;
            if (aVar4.f36890d <= -20037508) {
                aVar4.f36890d = -20037508L;
            }
            this.f36887k.f36891e.x = bundle.getInt("lbx");
            this.f36887k.f36891e.y = bundle.getInt("lby");
            this.f36887k.f36892f.x = bundle.getInt("ltx");
            this.f36887k.f36892f.y = bundle.getInt("lty");
            this.f36887k.f36893g.x = bundle.getInt("rtx");
            this.f36887k.f36893g.y = bundle.getInt("rty");
            this.f36887k.f36894h.x = bundle.getInt("rbx");
            this.f36887k.f36894h.y = bundle.getInt("rby");
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
