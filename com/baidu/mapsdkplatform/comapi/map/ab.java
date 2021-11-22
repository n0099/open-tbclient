package com.baidu.mapsdkplatform.comapi.map;

import android.os.Bundle;
import com.baidu.adp.widget.HorizontalTranslateLayout;
import com.baidu.adp.widget.VerticalTranslateLayout;
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
/* loaded from: classes7.dex */
public class ab {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String t = "ab";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public float f40899a;

    /* renamed from: b  reason: collision with root package name */
    public int f40900b;

    /* renamed from: c  reason: collision with root package name */
    public int f40901c;

    /* renamed from: d  reason: collision with root package name */
    public double f40902d;

    /* renamed from: e  reason: collision with root package name */
    public double f40903e;

    /* renamed from: f  reason: collision with root package name */
    public int f40904f;

    /* renamed from: g  reason: collision with root package name */
    public int f40905g;

    /* renamed from: h  reason: collision with root package name */
    public long f40906h;

    /* renamed from: i  reason: collision with root package name */
    public long f40907i;
    public WinRound j;
    public a k;
    public boolean l;
    public double m;
    public double n;
    public int o;
    public String p;
    public float q;
    public boolean r;
    public int s;

    /* loaded from: classes7.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f40908a;

        /* renamed from: b  reason: collision with root package name */
        public long f40909b;

        /* renamed from: c  reason: collision with root package name */
        public long f40910c;

        /* renamed from: d  reason: collision with root package name */
        public long f40911d;

        /* renamed from: e  reason: collision with root package name */
        public Point f40912e;

        /* renamed from: f  reason: collision with root package name */
        public Point f40913f;

        /* renamed from: g  reason: collision with root package name */
        public Point f40914g;

        /* renamed from: h  reason: collision with root package name */
        public Point f40915h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ ab f40916i;

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
            this.f40916i = abVar;
            this.f40908a = 0L;
            this.f40909b = 0L;
            this.f40910c = 0L;
            this.f40911d = 0L;
            this.f40912e = new Point(0, 0);
            this.f40913f = new Point(0, 0);
            this.f40914g = new Point(0, 0);
            this.f40915h = new Point(0, 0);
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
        this.f40899a = 12.0f;
        this.f40900b = 0;
        this.f40901c = 0;
        this.f40902d = 1.2958162E7d;
        this.f40903e = 4825907.0d;
        this.f40906h = 0L;
        this.f40907i = 0L;
        this.f40904f = -1;
        this.f40905g = -1;
        this.j = new WinRound();
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
            float f2 = this.f40899a;
            float f3 = eVar.f40947b;
            if (f2 < f3) {
                this.f40899a = f3;
            }
            float f4 = this.f40899a;
            float f5 = eVar.f40946a;
            if (f4 > f5) {
                if (f4 == 1096.0f || e.f40945d == 26.0f) {
                    this.f40899a = 26.0f;
                    e.f40945d = 26.0f;
                } else {
                    this.f40899a = f5;
                }
            }
            while (true) {
                i2 = this.f40900b;
                if (i2 >= 0) {
                    break;
                }
                this.f40900b = i2 + 360;
            }
            this.f40900b = i2 % 360;
            if (this.f40901c > 0) {
                this.f40901c = 0;
            }
            if (this.f40901c < -45) {
                this.f40901c = -45;
            }
            Bundle bundle = new Bundle();
            bundle.putDouble("level", this.f40899a);
            bundle.putDouble("rotation", this.f40900b);
            bundle.putDouble("overlooking", this.f40901c);
            bundle.putDouble("centerptx", this.f40902d);
            bundle.putDouble("centerpty", this.f40903e);
            bundle.putInt("left", this.j.left);
            bundle.putInt(HorizontalTranslateLayout.RIGHT, this.j.right);
            bundle.putInt(VerticalTranslateLayout.TOP, this.j.top);
            bundle.putInt("bottom", this.j.bottom);
            int i6 = this.f40904f;
            if (i6 >= 0 && (i3 = this.f40905g) >= 0 && i6 <= (i4 = (winRound = this.j).right) && i3 <= (i5 = winRound.bottom) && i4 > 0 && i5 > 0) {
                long j = i6 - ((i4 - winRound.left) / 2);
                this.f40906h = j;
                this.f40907i = -(i3 - ((i5 - winRound.top) / 2));
                bundle.putLong("xoffset", j);
                bundle.putLong("yoffset", this.f40907i);
            }
            bundle.putInt("lbx", this.k.f40912e.x);
            bundle.putInt("lby", this.k.f40912e.y);
            bundle.putInt("ltx", this.k.f40913f.x);
            bundle.putInt("lty", this.k.f40913f.y);
            bundle.putInt("rtx", this.k.f40914g.x);
            bundle.putInt("rty", this.k.f40914g.y);
            bundle.putInt("rbx", this.k.f40915h.x);
            bundle.putInt("rby", this.k.f40915h.y);
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
            this.f40899a = (float) bundle.getDouble("level");
            this.f40900b = (int) bundle.getDouble("rotation");
            this.f40901c = (int) bundle.getDouble("overlooking");
            this.f40902d = bundle.getDouble("centerptx");
            this.f40903e = bundle.getDouble("centerpty");
            this.j.left = bundle.getInt("left");
            this.j.right = bundle.getInt(HorizontalTranslateLayout.RIGHT);
            this.j.top = bundle.getInt(VerticalTranslateLayout.TOP);
            this.j.bottom = bundle.getInt("bottom");
            this.f40906h = bundle.getLong("xoffset");
            long j = bundle.getLong("yoffset");
            this.f40907i = j;
            WinRound winRound = this.j;
            int i3 = winRound.right;
            if (i3 != 0 && (i2 = winRound.bottom) != 0) {
                this.f40904f = ((int) this.f40906h) + ((i3 - winRound.left) / 2);
                this.f40905g = ((int) (-j)) + ((i2 - winRound.top) / 2);
            }
            this.k.f40908a = bundle.getLong("gleft");
            this.k.f40909b = bundle.getLong("gright");
            this.k.f40910c = bundle.getLong("gtop");
            this.k.f40911d = bundle.getLong("gbottom");
            a aVar = this.k;
            if (aVar.f40908a <= -20037508) {
                aVar.f40908a = -20037508L;
            }
            a aVar2 = this.k;
            if (aVar2.f40909b >= 20037508) {
                aVar2.f40909b = 20037508L;
            }
            a aVar3 = this.k;
            if (aVar3.f40910c >= 20037508) {
                aVar3.f40910c = 20037508L;
            }
            a aVar4 = this.k;
            if (aVar4.f40911d <= -20037508) {
                aVar4.f40911d = -20037508L;
            }
            this.k.f40912e.x = bundle.getInt("lbx");
            this.k.f40912e.y = bundle.getInt("lby");
            this.k.f40913f.x = bundle.getInt("ltx");
            this.k.f40913f.y = bundle.getInt("lty");
            this.k.f40914g.x = bundle.getInt("rtx");
            this.k.f40914g.y = bundle.getInt("rty");
            this.k.f40915h.x = bundle.getInt("rbx");
            this.k.f40915h.y = bundle.getInt("rby");
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
