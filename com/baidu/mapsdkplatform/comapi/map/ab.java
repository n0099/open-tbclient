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
    public float f42063a;

    /* renamed from: b  reason: collision with root package name */
    public int f42064b;

    /* renamed from: c  reason: collision with root package name */
    public int f42065c;

    /* renamed from: d  reason: collision with root package name */
    public double f42066d;

    /* renamed from: e  reason: collision with root package name */
    public double f42067e;

    /* renamed from: f  reason: collision with root package name */
    public int f42068f;

    /* renamed from: g  reason: collision with root package name */
    public int f42069g;

    /* renamed from: h  reason: collision with root package name */
    public long f42070h;

    /* renamed from: i  reason: collision with root package name */
    public long f42071i;

    /* renamed from: j  reason: collision with root package name */
    public WinRound f42072j;
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
        public long f42073a;

        /* renamed from: b  reason: collision with root package name */
        public long f42074b;

        /* renamed from: c  reason: collision with root package name */
        public long f42075c;

        /* renamed from: d  reason: collision with root package name */
        public long f42076d;

        /* renamed from: e  reason: collision with root package name */
        public Point f42077e;

        /* renamed from: f  reason: collision with root package name */
        public Point f42078f;

        /* renamed from: g  reason: collision with root package name */
        public Point f42079g;

        /* renamed from: h  reason: collision with root package name */
        public Point f42080h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ ab f42081i;

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
            this.f42081i = abVar;
            this.f42073a = 0L;
            this.f42074b = 0L;
            this.f42075c = 0L;
            this.f42076d = 0L;
            this.f42077e = new Point(0, 0);
            this.f42078f = new Point(0, 0);
            this.f42079g = new Point(0, 0);
            this.f42080h = new Point(0, 0);
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
        this.f42063a = 12.0f;
        this.f42064b = 0;
        this.f42065c = 0;
        this.f42066d = 1.2958162E7d;
        this.f42067e = 4825907.0d;
        this.f42070h = 0L;
        this.f42071i = 0L;
        this.f42068f = -1;
        this.f42069g = -1;
        this.f42072j = new WinRound();
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
            float f2 = this.f42063a;
            float f3 = eVar.f42113b;
            if (f2 < f3) {
                this.f42063a = f3;
            }
            float f4 = this.f42063a;
            float f5 = eVar.f42112a;
            if (f4 > f5) {
                if (f4 == 1096.0f || e.f42111d == 26.0f) {
                    this.f42063a = 26.0f;
                    e.f42111d = 26.0f;
                } else {
                    this.f42063a = f5;
                }
            }
            while (true) {
                i2 = this.f42064b;
                if (i2 >= 0) {
                    break;
                }
                this.f42064b = i2 + 360;
            }
            this.f42064b = i2 % 360;
            if (this.f42065c > 0) {
                this.f42065c = 0;
            }
            if (this.f42065c < -45) {
                this.f42065c = -45;
            }
            Bundle bundle = new Bundle();
            bundle.putDouble("level", this.f42063a);
            bundle.putDouble("rotation", this.f42064b);
            bundle.putDouble("overlooking", this.f42065c);
            bundle.putDouble("centerptx", this.f42066d);
            bundle.putDouble("centerpty", this.f42067e);
            bundle.putInt("left", this.f42072j.left);
            bundle.putInt(HorizontalTranslateLayout.RIGHT, this.f42072j.right);
            bundle.putInt(VerticalTranslateLayout.TOP, this.f42072j.top);
            bundle.putInt("bottom", this.f42072j.bottom);
            int i6 = this.f42068f;
            if (i6 >= 0 && (i3 = this.f42069g) >= 0 && i6 <= (i4 = (winRound = this.f42072j).right) && i3 <= (i5 = winRound.bottom) && i4 > 0 && i5 > 0) {
                long j2 = i6 - ((i4 - winRound.left) / 2);
                this.f42070h = j2;
                this.f42071i = -(i3 - ((i5 - winRound.top) / 2));
                bundle.putLong("xoffset", j2);
                bundle.putLong("yoffset", this.f42071i);
            }
            bundle.putInt("lbx", this.k.f42077e.x);
            bundle.putInt("lby", this.k.f42077e.y);
            bundle.putInt("ltx", this.k.f42078f.x);
            bundle.putInt("lty", this.k.f42078f.y);
            bundle.putInt("rtx", this.k.f42079g.x);
            bundle.putInt("rty", this.k.f42079g.y);
            bundle.putInt("rbx", this.k.f42080h.x);
            bundle.putInt("rby", this.k.f42080h.y);
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
            this.f42063a = (float) bundle.getDouble("level");
            this.f42064b = (int) bundle.getDouble("rotation");
            this.f42065c = (int) bundle.getDouble("overlooking");
            this.f42066d = bundle.getDouble("centerptx");
            this.f42067e = bundle.getDouble("centerpty");
            this.f42072j.left = bundle.getInt("left");
            this.f42072j.right = bundle.getInt(HorizontalTranslateLayout.RIGHT);
            this.f42072j.top = bundle.getInt(VerticalTranslateLayout.TOP);
            this.f42072j.bottom = bundle.getInt("bottom");
            this.f42070h = bundle.getLong("xoffset");
            long j2 = bundle.getLong("yoffset");
            this.f42071i = j2;
            WinRound winRound = this.f42072j;
            int i3 = winRound.right;
            if (i3 != 0 && (i2 = winRound.bottom) != 0) {
                this.f42068f = ((int) this.f42070h) + ((i3 - winRound.left) / 2);
                this.f42069g = ((int) (-j2)) + ((i2 - winRound.top) / 2);
            }
            this.k.f42073a = bundle.getLong("gleft");
            this.k.f42074b = bundle.getLong("gright");
            this.k.f42075c = bundle.getLong("gtop");
            this.k.f42076d = bundle.getLong("gbottom");
            a aVar = this.k;
            if (aVar.f42073a <= -20037508) {
                aVar.f42073a = -20037508L;
            }
            a aVar2 = this.k;
            if (aVar2.f42074b >= 20037508) {
                aVar2.f42074b = 20037508L;
            }
            a aVar3 = this.k;
            if (aVar3.f42075c >= 20037508) {
                aVar3.f42075c = 20037508L;
            }
            a aVar4 = this.k;
            if (aVar4.f42076d <= -20037508) {
                aVar4.f42076d = -20037508L;
            }
            this.k.f42077e.x = bundle.getInt("lbx");
            this.k.f42077e.y = bundle.getInt("lby");
            this.k.f42078f.x = bundle.getInt("ltx");
            this.k.f42078f.y = bundle.getInt("lty");
            this.k.f42079g.x = bundle.getInt("rtx");
            this.k.f42079g.y = bundle.getInt("rty");
            this.k.f42080h.x = bundle.getInt("rbx");
            this.k.f42080h.y = bundle.getInt("rby");
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
