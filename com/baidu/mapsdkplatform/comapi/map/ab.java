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
    public float f42236a;

    /* renamed from: b  reason: collision with root package name */
    public int f42237b;

    /* renamed from: c  reason: collision with root package name */
    public int f42238c;

    /* renamed from: d  reason: collision with root package name */
    public double f42239d;

    /* renamed from: e  reason: collision with root package name */
    public double f42240e;

    /* renamed from: f  reason: collision with root package name */
    public int f42241f;

    /* renamed from: g  reason: collision with root package name */
    public int f42242g;

    /* renamed from: h  reason: collision with root package name */
    public long f42243h;

    /* renamed from: i  reason: collision with root package name */
    public long f42244i;

    /* renamed from: j  reason: collision with root package name */
    public WinRound f42245j;
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
        public long f42246a;

        /* renamed from: b  reason: collision with root package name */
        public long f42247b;

        /* renamed from: c  reason: collision with root package name */
        public long f42248c;

        /* renamed from: d  reason: collision with root package name */
        public long f42249d;

        /* renamed from: e  reason: collision with root package name */
        public Point f42250e;

        /* renamed from: f  reason: collision with root package name */
        public Point f42251f;

        /* renamed from: g  reason: collision with root package name */
        public Point f42252g;

        /* renamed from: h  reason: collision with root package name */
        public Point f42253h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ ab f42254i;

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
            this.f42254i = abVar;
            this.f42246a = 0L;
            this.f42247b = 0L;
            this.f42248c = 0L;
            this.f42249d = 0L;
            this.f42250e = new Point(0, 0);
            this.f42251f = new Point(0, 0);
            this.f42252g = new Point(0, 0);
            this.f42253h = new Point(0, 0);
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
        this.f42236a = 12.0f;
        this.f42237b = 0;
        this.f42238c = 0;
        this.f42239d = 1.2958162E7d;
        this.f42240e = 4825907.0d;
        this.f42243h = 0L;
        this.f42244i = 0L;
        this.f42241f = -1;
        this.f42242g = -1;
        this.f42245j = new WinRound();
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
            float f2 = this.f42236a;
            float f3 = eVar.f42286b;
            if (f2 < f3) {
                this.f42236a = f3;
            }
            float f4 = this.f42236a;
            float f5 = eVar.f42285a;
            if (f4 > f5) {
                if (f4 == 1096.0f || e.f42284d == 26.0f) {
                    this.f42236a = 26.0f;
                    e.f42284d = 26.0f;
                } else {
                    this.f42236a = f5;
                }
            }
            while (true) {
                i2 = this.f42237b;
                if (i2 >= 0) {
                    break;
                }
                this.f42237b = i2 + 360;
            }
            this.f42237b = i2 % 360;
            if (this.f42238c > 0) {
                this.f42238c = 0;
            }
            if (this.f42238c < -45) {
                this.f42238c = -45;
            }
            Bundle bundle = new Bundle();
            bundle.putDouble("level", this.f42236a);
            bundle.putDouble("rotation", this.f42237b);
            bundle.putDouble("overlooking", this.f42238c);
            bundle.putDouble("centerptx", this.f42239d);
            bundle.putDouble("centerpty", this.f42240e);
            bundle.putInt("left", this.f42245j.left);
            bundle.putInt(HorizontalTranslateLayout.RIGHT, this.f42245j.right);
            bundle.putInt(VerticalTranslateLayout.TOP, this.f42245j.top);
            bundle.putInt("bottom", this.f42245j.bottom);
            int i6 = this.f42241f;
            if (i6 >= 0 && (i3 = this.f42242g) >= 0 && i6 <= (i4 = (winRound = this.f42245j).right) && i3 <= (i5 = winRound.bottom) && i4 > 0 && i5 > 0) {
                long j2 = i6 - ((i4 - winRound.left) / 2);
                this.f42243h = j2;
                this.f42244i = -(i3 - ((i5 - winRound.top) / 2));
                bundle.putLong("xoffset", j2);
                bundle.putLong("yoffset", this.f42244i);
            }
            bundle.putInt("lbx", this.k.f42250e.x);
            bundle.putInt("lby", this.k.f42250e.y);
            bundle.putInt("ltx", this.k.f42251f.x);
            bundle.putInt("lty", this.k.f42251f.y);
            bundle.putInt("rtx", this.k.f42252g.x);
            bundle.putInt("rty", this.k.f42252g.y);
            bundle.putInt("rbx", this.k.f42253h.x);
            bundle.putInt("rby", this.k.f42253h.y);
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
            this.f42236a = (float) bundle.getDouble("level");
            this.f42237b = (int) bundle.getDouble("rotation");
            this.f42238c = (int) bundle.getDouble("overlooking");
            this.f42239d = bundle.getDouble("centerptx");
            this.f42240e = bundle.getDouble("centerpty");
            this.f42245j.left = bundle.getInt("left");
            this.f42245j.right = bundle.getInt(HorizontalTranslateLayout.RIGHT);
            this.f42245j.top = bundle.getInt(VerticalTranslateLayout.TOP);
            this.f42245j.bottom = bundle.getInt("bottom");
            this.f42243h = bundle.getLong("xoffset");
            long j2 = bundle.getLong("yoffset");
            this.f42244i = j2;
            WinRound winRound = this.f42245j;
            int i3 = winRound.right;
            if (i3 != 0 && (i2 = winRound.bottom) != 0) {
                this.f42241f = ((int) this.f42243h) + ((i3 - winRound.left) / 2);
                this.f42242g = ((int) (-j2)) + ((i2 - winRound.top) / 2);
            }
            this.k.f42246a = bundle.getLong("gleft");
            this.k.f42247b = bundle.getLong("gright");
            this.k.f42248c = bundle.getLong("gtop");
            this.k.f42249d = bundle.getLong("gbottom");
            a aVar = this.k;
            if (aVar.f42246a <= -20037508) {
                aVar.f42246a = -20037508L;
            }
            a aVar2 = this.k;
            if (aVar2.f42247b >= 20037508) {
                aVar2.f42247b = 20037508L;
            }
            a aVar3 = this.k;
            if (aVar3.f42248c >= 20037508) {
                aVar3.f42248c = 20037508L;
            }
            a aVar4 = this.k;
            if (aVar4.f42249d <= -20037508) {
                aVar4.f42249d = -20037508L;
            }
            this.k.f42250e.x = bundle.getInt("lbx");
            this.k.f42250e.y = bundle.getInt("lby");
            this.k.f42251f.x = bundle.getInt("ltx");
            this.k.f42251f.y = bundle.getInt("lty");
            this.k.f42252g.x = bundle.getInt("rtx");
            this.k.f42252g.y = bundle.getInt("rty");
            this.k.f42253h.x = bundle.getInt("rbx");
            this.k.f42253h.y = bundle.getInt("rby");
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
