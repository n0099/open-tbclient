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
    public float f41956a;

    /* renamed from: b  reason: collision with root package name */
    public int f41957b;

    /* renamed from: c  reason: collision with root package name */
    public int f41958c;

    /* renamed from: d  reason: collision with root package name */
    public double f41959d;

    /* renamed from: e  reason: collision with root package name */
    public double f41960e;

    /* renamed from: f  reason: collision with root package name */
    public int f41961f;

    /* renamed from: g  reason: collision with root package name */
    public int f41962g;

    /* renamed from: h  reason: collision with root package name */
    public long f41963h;

    /* renamed from: i  reason: collision with root package name */
    public long f41964i;

    /* renamed from: j  reason: collision with root package name */
    public WinRound f41965j;
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
        public long f41966a;

        /* renamed from: b  reason: collision with root package name */
        public long f41967b;

        /* renamed from: c  reason: collision with root package name */
        public long f41968c;

        /* renamed from: d  reason: collision with root package name */
        public long f41969d;

        /* renamed from: e  reason: collision with root package name */
        public Point f41970e;

        /* renamed from: f  reason: collision with root package name */
        public Point f41971f;

        /* renamed from: g  reason: collision with root package name */
        public Point f41972g;

        /* renamed from: h  reason: collision with root package name */
        public Point f41973h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ ab f41974i;

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
            this.f41974i = abVar;
            this.f41966a = 0L;
            this.f41967b = 0L;
            this.f41968c = 0L;
            this.f41969d = 0L;
            this.f41970e = new Point(0, 0);
            this.f41971f = new Point(0, 0);
            this.f41972g = new Point(0, 0);
            this.f41973h = new Point(0, 0);
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
        this.f41956a = 12.0f;
        this.f41957b = 0;
        this.f41958c = 0;
        this.f41959d = 1.2958162E7d;
        this.f41960e = 4825907.0d;
        this.f41963h = 0L;
        this.f41964i = 0L;
        this.f41961f = -1;
        this.f41962g = -1;
        this.f41965j = new WinRound();
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
            float f2 = this.f41956a;
            float f3 = eVar.f42006b;
            if (f2 < f3) {
                this.f41956a = f3;
            }
            float f4 = this.f41956a;
            float f5 = eVar.f42005a;
            if (f4 > f5) {
                if (f4 == 1096.0f || e.f42004d == 26.0f) {
                    this.f41956a = 26.0f;
                    e.f42004d = 26.0f;
                } else {
                    this.f41956a = f5;
                }
            }
            while (true) {
                i2 = this.f41957b;
                if (i2 >= 0) {
                    break;
                }
                this.f41957b = i2 + 360;
            }
            this.f41957b = i2 % 360;
            if (this.f41958c > 0) {
                this.f41958c = 0;
            }
            if (this.f41958c < -45) {
                this.f41958c = -45;
            }
            Bundle bundle = new Bundle();
            bundle.putDouble("level", this.f41956a);
            bundle.putDouble("rotation", this.f41957b);
            bundle.putDouble("overlooking", this.f41958c);
            bundle.putDouble("centerptx", this.f41959d);
            bundle.putDouble("centerpty", this.f41960e);
            bundle.putInt("left", this.f41965j.left);
            bundle.putInt(HorizontalTranslateLayout.RIGHT, this.f41965j.right);
            bundle.putInt(VerticalTranslateLayout.TOP, this.f41965j.top);
            bundle.putInt("bottom", this.f41965j.bottom);
            int i6 = this.f41961f;
            if (i6 >= 0 && (i3 = this.f41962g) >= 0 && i6 <= (i4 = (winRound = this.f41965j).right) && i3 <= (i5 = winRound.bottom) && i4 > 0 && i5 > 0) {
                long j2 = i6 - ((i4 - winRound.left) / 2);
                this.f41963h = j2;
                this.f41964i = -(i3 - ((i5 - winRound.top) / 2));
                bundle.putLong("xoffset", j2);
                bundle.putLong("yoffset", this.f41964i);
            }
            bundle.putInt("lbx", this.k.f41970e.x);
            bundle.putInt("lby", this.k.f41970e.y);
            bundle.putInt("ltx", this.k.f41971f.x);
            bundle.putInt("lty", this.k.f41971f.y);
            bundle.putInt("rtx", this.k.f41972g.x);
            bundle.putInt("rty", this.k.f41972g.y);
            bundle.putInt("rbx", this.k.f41973h.x);
            bundle.putInt("rby", this.k.f41973h.y);
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
            this.f41956a = (float) bundle.getDouble("level");
            this.f41957b = (int) bundle.getDouble("rotation");
            this.f41958c = (int) bundle.getDouble("overlooking");
            this.f41959d = bundle.getDouble("centerptx");
            this.f41960e = bundle.getDouble("centerpty");
            this.f41965j.left = bundle.getInt("left");
            this.f41965j.right = bundle.getInt(HorizontalTranslateLayout.RIGHT);
            this.f41965j.top = bundle.getInt(VerticalTranslateLayout.TOP);
            this.f41965j.bottom = bundle.getInt("bottom");
            this.f41963h = bundle.getLong("xoffset");
            long j2 = bundle.getLong("yoffset");
            this.f41964i = j2;
            WinRound winRound = this.f41965j;
            int i3 = winRound.right;
            if (i3 != 0 && (i2 = winRound.bottom) != 0) {
                this.f41961f = ((int) this.f41963h) + ((i3 - winRound.left) / 2);
                this.f41962g = ((int) (-j2)) + ((i2 - winRound.top) / 2);
            }
            this.k.f41966a = bundle.getLong("gleft");
            this.k.f41967b = bundle.getLong("gright");
            this.k.f41968c = bundle.getLong("gtop");
            this.k.f41969d = bundle.getLong("gbottom");
            a aVar = this.k;
            if (aVar.f41966a <= -20037508) {
                aVar.f41966a = -20037508L;
            }
            a aVar2 = this.k;
            if (aVar2.f41967b >= 20037508) {
                aVar2.f41967b = 20037508L;
            }
            a aVar3 = this.k;
            if (aVar3.f41968c >= 20037508) {
                aVar3.f41968c = 20037508L;
            }
            a aVar4 = this.k;
            if (aVar4.f41969d <= -20037508) {
                aVar4.f41969d = -20037508L;
            }
            this.k.f41970e.x = bundle.getInt("lbx");
            this.k.f41970e.y = bundle.getInt("lby");
            this.k.f41971f.x = bundle.getInt("ltx");
            this.k.f41971f.y = bundle.getInt("lty");
            this.k.f41972g.x = bundle.getInt("rtx");
            this.k.f41972g.y = bundle.getInt("rty");
            this.k.f41973h.x = bundle.getInt("rbx");
            this.k.f41973h.y = bundle.getInt("rby");
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
