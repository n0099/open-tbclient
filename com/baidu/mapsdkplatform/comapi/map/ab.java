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
/* loaded from: classes5.dex */
public class ab {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String t = "ab";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public float f42240a;

    /* renamed from: b  reason: collision with root package name */
    public int f42241b;

    /* renamed from: c  reason: collision with root package name */
    public int f42242c;

    /* renamed from: d  reason: collision with root package name */
    public double f42243d;

    /* renamed from: e  reason: collision with root package name */
    public double f42244e;

    /* renamed from: f  reason: collision with root package name */
    public int f42245f;

    /* renamed from: g  reason: collision with root package name */
    public int f42246g;

    /* renamed from: h  reason: collision with root package name */
    public long f42247h;

    /* renamed from: i  reason: collision with root package name */
    public long f42248i;

    /* renamed from: j  reason: collision with root package name */
    public WinRound f42249j;
    public a k;
    public boolean l;
    public double m;
    public double n;
    public int o;
    public String p;
    public float q;
    public boolean r;
    public int s;

    /* loaded from: classes5.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f42250a;

        /* renamed from: b  reason: collision with root package name */
        public long f42251b;

        /* renamed from: c  reason: collision with root package name */
        public long f42252c;

        /* renamed from: d  reason: collision with root package name */
        public long f42253d;

        /* renamed from: e  reason: collision with root package name */
        public Point f42254e;

        /* renamed from: f  reason: collision with root package name */
        public Point f42255f;

        /* renamed from: g  reason: collision with root package name */
        public Point f42256g;

        /* renamed from: h  reason: collision with root package name */
        public Point f42257h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ ab f42258i;

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
            this.f42258i = abVar;
            this.f42250a = 0L;
            this.f42251b = 0L;
            this.f42252c = 0L;
            this.f42253d = 0L;
            this.f42254e = new Point(0, 0);
            this.f42255f = new Point(0, 0);
            this.f42256g = new Point(0, 0);
            this.f42257h = new Point(0, 0);
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
        this.f42240a = 12.0f;
        this.f42241b = 0;
        this.f42242c = 0;
        this.f42243d = 1.2958162E7d;
        this.f42244e = 4825907.0d;
        this.f42247h = 0L;
        this.f42248i = 0L;
        this.f42245f = -1;
        this.f42246g = -1;
        this.f42249j = new WinRound();
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
            float f2 = this.f42240a;
            float f3 = eVar.f42290b;
            if (f2 < f3) {
                this.f42240a = f3;
            }
            float f4 = this.f42240a;
            float f5 = eVar.f42289a;
            if (f4 > f5) {
                if (f4 == 1096.0f || e.f42288d == 26.0f) {
                    this.f42240a = 26.0f;
                    e.f42288d = 26.0f;
                } else {
                    this.f42240a = f5;
                }
            }
            while (true) {
                i2 = this.f42241b;
                if (i2 >= 0) {
                    break;
                }
                this.f42241b = i2 + 360;
            }
            this.f42241b = i2 % 360;
            if (this.f42242c > 0) {
                this.f42242c = 0;
            }
            if (this.f42242c < -45) {
                this.f42242c = -45;
            }
            Bundle bundle = new Bundle();
            bundle.putDouble("level", this.f42240a);
            bundle.putDouble("rotation", this.f42241b);
            bundle.putDouble("overlooking", this.f42242c);
            bundle.putDouble("centerptx", this.f42243d);
            bundle.putDouble("centerpty", this.f42244e);
            bundle.putInt("left", this.f42249j.left);
            bundle.putInt(HorizontalTranslateLayout.RIGHT, this.f42249j.right);
            bundle.putInt(VerticalTranslateLayout.TOP, this.f42249j.top);
            bundle.putInt("bottom", this.f42249j.bottom);
            int i6 = this.f42245f;
            if (i6 >= 0 && (i3 = this.f42246g) >= 0 && i6 <= (i4 = (winRound = this.f42249j).right) && i3 <= (i5 = winRound.bottom) && i4 > 0 && i5 > 0) {
                long j2 = i6 - ((i4 - winRound.left) / 2);
                this.f42247h = j2;
                this.f42248i = -(i3 - ((i5 - winRound.top) / 2));
                bundle.putLong("xoffset", j2);
                bundle.putLong("yoffset", this.f42248i);
            }
            bundle.putInt("lbx", this.k.f42254e.x);
            bundle.putInt("lby", this.k.f42254e.y);
            bundle.putInt("ltx", this.k.f42255f.x);
            bundle.putInt("lty", this.k.f42255f.y);
            bundle.putInt("rtx", this.k.f42256g.x);
            bundle.putInt("rty", this.k.f42256g.y);
            bundle.putInt("rbx", this.k.f42257h.x);
            bundle.putInt("rby", this.k.f42257h.y);
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
            this.f42240a = (float) bundle.getDouble("level");
            this.f42241b = (int) bundle.getDouble("rotation");
            this.f42242c = (int) bundle.getDouble("overlooking");
            this.f42243d = bundle.getDouble("centerptx");
            this.f42244e = bundle.getDouble("centerpty");
            this.f42249j.left = bundle.getInt("left");
            this.f42249j.right = bundle.getInt(HorizontalTranslateLayout.RIGHT);
            this.f42249j.top = bundle.getInt(VerticalTranslateLayout.TOP);
            this.f42249j.bottom = bundle.getInt("bottom");
            this.f42247h = bundle.getLong("xoffset");
            long j2 = bundle.getLong("yoffset");
            this.f42248i = j2;
            WinRound winRound = this.f42249j;
            int i3 = winRound.right;
            if (i3 != 0 && (i2 = winRound.bottom) != 0) {
                this.f42245f = ((int) this.f42247h) + ((i3 - winRound.left) / 2);
                this.f42246g = ((int) (-j2)) + ((i2 - winRound.top) / 2);
            }
            this.k.f42250a = bundle.getLong("gleft");
            this.k.f42251b = bundle.getLong("gright");
            this.k.f42252c = bundle.getLong("gtop");
            this.k.f42253d = bundle.getLong("gbottom");
            a aVar = this.k;
            if (aVar.f42250a <= -20037508) {
                aVar.f42250a = -20037508L;
            }
            a aVar2 = this.k;
            if (aVar2.f42251b >= 20037508) {
                aVar2.f42251b = 20037508L;
            }
            a aVar3 = this.k;
            if (aVar3.f42252c >= 20037508) {
                aVar3.f42252c = 20037508L;
            }
            a aVar4 = this.k;
            if (aVar4.f42253d <= -20037508) {
                aVar4.f42253d = -20037508L;
            }
            this.k.f42254e.x = bundle.getInt("lbx");
            this.k.f42254e.y = bundle.getInt("lby");
            this.k.f42255f.x = bundle.getInt("ltx");
            this.k.f42255f.y = bundle.getInt("lty");
            this.k.f42256g.x = bundle.getInt("rtx");
            this.k.f42256g.y = bundle.getInt("rty");
            this.k.f42257h.x = bundle.getInt("rbx");
            this.k.f42257h.y = bundle.getInt("rby");
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
