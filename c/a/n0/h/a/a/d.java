package c.a.n0.h.a.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.n0.h.a.k.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.game.ad.component.AdImageVIew;
import com.baidu.swan.game.ad.entity.AdElementInfo;
import com.baidu.swan.game.ad.jsbridge.CommandType;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public AdElementInfo f8276b;

    /* renamed from: c  reason: collision with root package name */
    public View f8277c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f8278d;

    /* renamed from: e  reason: collision with root package name */
    public int f8279e;

    /* renamed from: f  reason: collision with root package name */
    public int f8280f;

    /* renamed from: g  reason: collision with root package name */
    public AdImageVIew f8281g;

    /* renamed from: h  reason: collision with root package name */
    public AdImageVIew f8282h;
    public RelativeLayout i;
    public RelativeLayout j;
    public RelativeLayout k;
    public TextView l;
    public TextView m;
    public Button n;
    public ImageView o;
    public boolean p;
    public c.a.n0.h.a.e.a q;
    public c.a.n0.h.a.e.e r;
    public e s;
    public boolean t;
    public Runnable u;
    public View.OnClickListener v;
    public View.OnClickListener w;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.g();
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public b(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.n0.h.a.k.d.b(this.a.u);
                if (this.a.s != null) {
                    this.a.s.b();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public c(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.a.q == null) {
                return;
            }
            this.a.q.b(CommandType.BANNER_VIEW, null);
        }
    }

    /* renamed from: c.a.n0.h.a.a.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0650d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public View$OnClickListenerC0650d(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.a.r == null) {
                return;
            }
            this.a.r.f(view);
        }
    }

    /* loaded from: classes.dex */
    public interface e {
        void b();
    }

    public d(Context context, AdElementInfo adElementInfo, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, adElementInfo, str, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.u = new a(this);
        this.v = new c(this);
        this.w = new View$OnClickListenerC0650d(this);
        this.a = context;
        this.f8276b = adElementInfo;
        this.p = c.a.n0.h.a.f.a.a().j();
        this.t = z;
        h();
    }

    public void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            int a2 = h.a(i);
            this.f8279e = a2;
            this.f8280f = (int) (a2 / c.a.n0.h.a.a.e.a);
            this.f8277c.setLayoutParams(new RelativeLayout.LayoutParams(this.f8279e, this.f8280f));
            this.f8278d.setLayoutParams(new RelativeLayout.LayoutParams(this.f8279e, this.f8280f));
            int i2 = (int) (this.f8280f * c.a.n0.h.a.a.e.f8283b);
            this.j.setLayoutParams(new LinearLayout.LayoutParams(i2, this.f8280f));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (i2 * c.a.n0.h.a.a.e.m), (int) (this.f8280f * c.a.n0.h.a.a.e.n));
            layoutParams.addRule(12);
            layoutParams.addRule(9);
            layoutParams.setMarginStart(0);
            this.f8282h.setLayoutParams(layoutParams);
            int i3 = this.f8279e - i2;
            this.i.setLayoutParams(new LinearLayout.LayoutParams(i3, this.f8280f));
            int i4 = this.f8280f;
            float f2 = i3;
            int i5 = (int) (c.a.n0.h.a.a.e.f8289h * f2);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams2.addRule(9);
            layoutParams2.topMargin = (int) (i4 * c.a.n0.h.a.a.e.f8284c);
            layoutParams2.leftMargin = i5;
            layoutParams2.rightMargin = i5;
            this.l.setLayoutParams(layoutParams2);
            this.l.setTextSize(0, (int) (i4 * c.a.n0.h.a.a.e.f8286e));
            this.l.setLineSpacing((int) (i4 * c.a.n0.h.a.a.e.f8285d), 1.0f);
            int i6 = this.f8280f;
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, (int) (i6 * c.a.n0.h.a.a.e.f8288g));
            layoutParams3.addRule(12);
            layoutParams3.bottomMargin = (int) (i6 * c.a.n0.h.a.a.e.f8287f);
            layoutParams3.leftMargin = i5;
            layoutParams3.rightMargin = i5;
            this.k.setLayoutParams(layoutParams3);
            int i7 = (int) (this.f8280f * c.a.n0.h.a.a.e.k);
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams((int) (f2 * c.a.n0.h.a.a.e.i), -1);
            layoutParams4.addRule(9);
            float f3 = (int) (c.a.n0.h.a.a.e.l * i7);
            this.m.setTextSize(0, f3);
            layoutParams4.addRule(15);
            this.m.setLayoutParams(layoutParams4);
            RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams((int) (c.a.n0.h.a.a.e.j * f2), i7);
            layoutParams5.addRule(12);
            layoutParams5.addRule(11);
            this.n.setTextSize(0, f3);
            this.n.setLayoutParams(layoutParams5);
            if (this.o != null) {
                int i8 = (int) (this.f8280f * c.a.n0.h.a.a.e.o);
                RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(i8, i8);
                layoutParams6.addRule(10);
                layoutParams6.addRule(11);
                this.o.setLayoutParams(layoutParams6);
            }
        }
    }

    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f8277c : (View) invokeV.objValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            View view = this.f8277c;
            if (view != null && view.getVisibility() == 0) {
                this.f8277c.setVisibility(4);
            }
            c.a.n0.h.a.k.d.b(this.u);
        }
    }

    @SuppressLint({"InflateParams"})
    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            Resources resources = this.a.getResources();
            View inflate = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d0617, (ViewGroup) null);
            this.f8277c = inflate;
            this.f8278d = (LinearLayout) inflate.findViewById(R.id.obfuscated_res_0x7f090306);
            this.j = (RelativeLayout) this.f8277c.findViewById(R.id.obfuscated_res_0x7f0902f8);
            AdImageVIew adImageVIew = (AdImageVIew) this.f8277c.findViewById(R.id.obfuscated_res_0x7f090308);
            this.f8281g = adImageVIew;
            AdElementInfo adElementInfo = this.f8276b;
            if (adElementInfo != null) {
                adImageVIew.setImageUrl(adElementInfo.getPictureUrl());
            }
            AdImageVIew adImageVIew2 = (AdImageVIew) this.f8277c.findViewById(R.id.obfuscated_res_0x7f0900f2);
            this.f8282h = adImageVIew2;
            adImageVIew2.setImageUrl("https://cpro.baidustatic.com/cpro/ui/noexpire/css/2.1.4/img/mob-adIcon_2x.png");
            this.i = (RelativeLayout) this.f8277c.findViewById(R.id.obfuscated_res_0x7f0902f9);
            this.k = (RelativeLayout) this.f8277c.findViewById(R.id.obfuscated_res_0x7f090303);
            this.l = (TextView) this.f8277c.findViewById(R.id.obfuscated_res_0x7f090304);
            this.m = (TextView) this.f8277c.findViewById(R.id.obfuscated_res_0x7f0902fb);
            AdElementInfo adElementInfo2 = this.f8276b;
            if (adElementInfo2 != null) {
                this.l.setText(adElementInfo2.getTitle());
                this.m.setText(this.f8276b.getAppName());
            }
            Button button = (Button) this.f8277c.findViewById(R.id.obfuscated_res_0x7f0902f7);
            this.n = button;
            button.setVisibility(8);
            AdElementInfo adElementInfo3 = this.f8276b;
            if (adElementInfo3 != null && adElementInfo3.getActionType() == 1) {
                this.n.setVisibility(0);
                this.n.setText(resources.getString(R.string.obfuscated_res_0x7f0f10b8));
            }
            AdElementInfo adElementInfo4 = this.f8276b;
            if (adElementInfo4 != null && adElementInfo4.getActionType() == 2) {
                this.n.setVisibility(0);
                this.n.setText(resources.getString(R.string.obfuscated_res_0x7f0f1249));
            }
            if (this.f8276b == null) {
                this.j.setVisibility(8);
                this.i.setVisibility(8);
                this.f8277c.findViewById(R.id.obfuscated_res_0x7f091580).setVisibility(0);
                return;
            }
            this.j.setVisibility(0);
            this.i.setVisibility(0);
            this.f8277c.findViewById(R.id.obfuscated_res_0x7f091580).setVisibility(8);
            if (this.t) {
                this.n.setOnClickListener(this.w);
                this.f8278d.setOnClickListener(this.w);
            } else {
                this.n.setOnClickListener(this.v);
                this.f8278d.setOnClickListener(this.v);
            }
            this.f8277c.setVisibility(4);
            if (this.p) {
                ImageView imageView = (ImageView) this.f8277c.findViewById(R.id.obfuscated_res_0x7f090664);
                this.o = imageView;
                imageView.setVisibility(0);
                this.o.setOnClickListener(new b(this));
            }
        }
    }

    public void i(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, eVar) == null) {
            this.s = eVar;
        }
    }

    public void j(c.a.n0.h.a.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            this.q = aVar;
        }
    }

    public void k(c.a.n0.h.a.e.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, eVar) == null) {
            this.r = eVar;
        }
    }

    public void l() {
        View view;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (view = this.f8277c) != null && view.getVisibility() == 4) {
            this.f8277c.setAnimation(AnimationUtils.loadAnimation(this.a, R.anim.obfuscated_res_0x7f0100aa));
            this.f8277c.setVisibility(0);
            c.a.n0.h.a.k.d.a(this.u, c.a.n0.h.a.f.a.a().a());
        }
    }

    public d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.u = new a(this);
        this.v = new c(this);
        this.w = new View$OnClickListenerC0650d(this);
        this.a = context;
        h();
    }
}
