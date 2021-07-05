package com.baidu.mapsdkplatform.comapi.map;

import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.map.WinRound;
import com.baidu.mapapi.model.inner.Point;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.config.item.TipsConfigItem;
/* loaded from: classes3.dex */
public class ab {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String t = "ab";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public float f7644a;

    /* renamed from: b  reason: collision with root package name */
    public int f7645b;

    /* renamed from: c  reason: collision with root package name */
    public int f7646c;

    /* renamed from: d  reason: collision with root package name */
    public double f7647d;

    /* renamed from: e  reason: collision with root package name */
    public double f7648e;

    /* renamed from: f  reason: collision with root package name */
    public int f7649f;

    /* renamed from: g  reason: collision with root package name */
    public int f7650g;

    /* renamed from: h  reason: collision with root package name */
    public long f7651h;

    /* renamed from: i  reason: collision with root package name */
    public long f7652i;
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

    /* loaded from: classes3.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f7653a;

        /* renamed from: b  reason: collision with root package name */
        public long f7654b;

        /* renamed from: c  reason: collision with root package name */
        public long f7655c;

        /* renamed from: d  reason: collision with root package name */
        public long f7656d;

        /* renamed from: e  reason: collision with root package name */
        public Point f7657e;

        /* renamed from: f  reason: collision with root package name */
        public Point f7658f;

        /* renamed from: g  reason: collision with root package name */
        public Point f7659g;

        /* renamed from: h  reason: collision with root package name */
        public Point f7660h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ ab f7661i;

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
            this.f7661i = abVar;
            this.f7653a = 0L;
            this.f7654b = 0L;
            this.f7655c = 0L;
            this.f7656d = 0L;
            this.f7657e = new Point(0, 0);
            this.f7658f = new Point(0, 0);
            this.f7659g = new Point(0, 0);
            this.f7660h = new Point(0, 0);
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
        this.f7644a = 12.0f;
        this.f7645b = 0;
        this.f7646c = 0;
        this.f7647d = 1.2958162E7d;
        this.f7648e = 4825907.0d;
        this.f7651h = 0L;
        this.f7652i = 0L;
        this.f7649f = -1;
        this.f7650g = -1;
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
            float f2 = this.f7644a;
            float f3 = eVar.f7692b;
            if (f2 < f3) {
                this.f7644a = f3;
            }
            float f4 = this.f7644a;
            float f5 = eVar.f7691a;
            if (f4 > f5) {
                if (f4 == 1096.0f || e.f7690d == 26.0f) {
                    this.f7644a = 26.0f;
                    e.f7690d = 26.0f;
                } else {
                    this.f7644a = f5;
                }
            }
            while (true) {
                i2 = this.f7645b;
                if (i2 >= 0) {
                    break;
                }
                this.f7645b = i2 + 360;
            }
            this.f7645b = i2 % 360;
            if (this.f7646c > 0) {
                this.f7646c = 0;
            }
            if (this.f7646c < -45) {
                this.f7646c = -45;
            }
            Bundle bundle = new Bundle();
            bundle.putDouble("level", this.f7644a);
            bundle.putDouble("rotation", this.f7645b);
            bundle.putDouble("overlooking", this.f7646c);
            bundle.putDouble("centerptx", this.f7647d);
            bundle.putDouble("centerpty", this.f7648e);
            bundle.putInt(CustomDialogData.POS_LEFT, this.j.left);
            bundle.putInt("right", this.j.right);
            bundle.putInt("top", this.j.top);
            bundle.putInt(TipsConfigItem.TipConfigData.BOTTOM, this.j.bottom);
            int i6 = this.f7649f;
            if (i6 >= 0 && (i3 = this.f7650g) >= 0 && i6 <= (i4 = (winRound = this.j).right) && i3 <= (i5 = winRound.bottom) && i4 > 0 && i5 > 0) {
                long j = i6 - ((i4 - winRound.left) / 2);
                this.f7651h = j;
                this.f7652i = -(i3 - ((i5 - winRound.top) / 2));
                bundle.putLong("xoffset", j);
                bundle.putLong("yoffset", this.f7652i);
            }
            bundle.putInt("lbx", this.k.f7657e.x);
            bundle.putInt("lby", this.k.f7657e.y);
            bundle.putInt("ltx", this.k.f7658f.x);
            bundle.putInt("lty", this.k.f7658f.y);
            bundle.putInt("rtx", this.k.f7659g.x);
            bundle.putInt("rty", this.k.f7659g.y);
            bundle.putInt("rbx", this.k.f7660h.x);
            bundle.putInt("rby", this.k.f7660h.y);
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
            this.f7644a = (float) bundle.getDouble("level");
            this.f7645b = (int) bundle.getDouble("rotation");
            this.f7646c = (int) bundle.getDouble("overlooking");
            this.f7647d = bundle.getDouble("centerptx");
            this.f7648e = bundle.getDouble("centerpty");
            this.j.left = bundle.getInt(CustomDialogData.POS_LEFT);
            this.j.right = bundle.getInt("right");
            this.j.top = bundle.getInt("top");
            this.j.bottom = bundle.getInt(TipsConfigItem.TipConfigData.BOTTOM);
            this.f7651h = bundle.getLong("xoffset");
            long j = bundle.getLong("yoffset");
            this.f7652i = j;
            WinRound winRound = this.j;
            int i3 = winRound.right;
            if (i3 != 0 && (i2 = winRound.bottom) != 0) {
                this.f7649f = ((int) this.f7651h) + ((i3 - winRound.left) / 2);
                this.f7650g = ((int) (-j)) + ((i2 - winRound.top) / 2);
            }
            this.k.f7653a = bundle.getLong("gleft");
            this.k.f7654b = bundle.getLong("gright");
            this.k.f7655c = bundle.getLong("gtop");
            this.k.f7656d = bundle.getLong("gbottom");
            a aVar = this.k;
            if (aVar.f7653a <= -20037508) {
                aVar.f7653a = -20037508L;
            }
            a aVar2 = this.k;
            if (aVar2.f7654b >= 20037508) {
                aVar2.f7654b = 20037508L;
            }
            a aVar3 = this.k;
            if (aVar3.f7655c >= 20037508) {
                aVar3.f7655c = 20037508L;
            }
            a aVar4 = this.k;
            if (aVar4.f7656d <= -20037508) {
                aVar4.f7656d = -20037508L;
            }
            this.k.f7657e.x = bundle.getInt("lbx");
            this.k.f7657e.y = bundle.getInt("lby");
            this.k.f7658f.x = bundle.getInt("ltx");
            this.k.f7658f.y = bundle.getInt("lty");
            this.k.f7659g.x = bundle.getInt("rtx");
            this.k.f7659g.y = bundle.getInt("rty");
            this.k.f7660h.x = bundle.getInt("rbx");
            this.k.f7660h.y = bundle.getInt("rby");
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
