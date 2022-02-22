package c.a.s0.h.i.i;

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
import c.a.s0.h.i.g;
import c.a.s0.h.i.s.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.game.ad.component.AdImageVIew;
import com.baidu.swan.game.ad.entity.AdElementInfo;
import com.baidu.swan.game.ad.jsbridge.CommandType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public AdElementInfo f10665b;

    /* renamed from: c  reason: collision with root package name */
    public View f10666c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f10667d;

    /* renamed from: e  reason: collision with root package name */
    public int f10668e;

    /* renamed from: f  reason: collision with root package name */
    public int f10669f;

    /* renamed from: g  reason: collision with root package name */
    public AdImageVIew f10670g;

    /* renamed from: h  reason: collision with root package name */
    public AdImageVIew f10671h;

    /* renamed from: i  reason: collision with root package name */
    public RelativeLayout f10672i;

    /* renamed from: j  reason: collision with root package name */
    public RelativeLayout f10673j;
    public RelativeLayout k;
    public TextView l;
    public TextView m;
    public Button n;
    public ImageView o;
    public boolean p;
    public c.a.s0.h.i.m.a q;
    public c.a.s0.h.i.m.e r;
    public e s;
    public boolean t;
    public Runnable u;
    public View.OnClickListener v;
    public View.OnClickListener w;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f10674e;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10674e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f10674e.g();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f10675e;

        public b(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10675e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.s0.h.i.s.d.b(this.f10675e.u);
                if (this.f10675e.s != null) {
                    this.f10675e.s.b();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f10676e;

        public c(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10676e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f10676e.q == null) {
                return;
            }
            this.f10676e.q.b(CommandType.BANNER_VIEW, null);
        }
    }

    /* renamed from: c.a.s0.h.i.i.d$d  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class View$OnClickListenerC0713d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f10677e;

        public View$OnClickListenerC0713d(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10677e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f10677e.r == null) {
                return;
            }
            this.f10677e.r.f(view);
        }
    }

    /* loaded from: classes6.dex */
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.u = new a(this);
        this.v = new c(this);
        this.w = new View$OnClickListenerC0713d(this);
        this.a = context;
        this.f10665b = adElementInfo;
        this.p = c.a.s0.h.i.n.a.a().j();
        this.t = z;
        h();
    }

    public void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            int a2 = h.a(i2);
            this.f10668e = a2;
            this.f10669f = (int) (a2 / c.a.s0.h.i.i.e.a);
            this.f10666c.setLayoutParams(new RelativeLayout.LayoutParams(this.f10668e, this.f10669f));
            this.f10667d.setLayoutParams(new RelativeLayout.LayoutParams(this.f10668e, this.f10669f));
            int i3 = (int) (this.f10669f * c.a.s0.h.i.i.e.f10678b);
            this.f10673j.setLayoutParams(new LinearLayout.LayoutParams(i3, this.f10669f));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (i3 * c.a.s0.h.i.i.e.m), (int) (this.f10669f * c.a.s0.h.i.i.e.n));
            layoutParams.addRule(12);
            layoutParams.addRule(9);
            layoutParams.setMarginStart(0);
            this.f10671h.setLayoutParams(layoutParams);
            int i4 = this.f10668e - i3;
            this.f10672i.setLayoutParams(new LinearLayout.LayoutParams(i4, this.f10669f));
            int i5 = this.f10669f;
            float f2 = i4;
            int i6 = (int) (c.a.s0.h.i.i.e.f10684h * f2);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams2.addRule(9);
            layoutParams2.topMargin = (int) (i5 * c.a.s0.h.i.i.e.f10679c);
            layoutParams2.leftMargin = i6;
            layoutParams2.rightMargin = i6;
            this.l.setLayoutParams(layoutParams2);
            this.l.setTextSize(0, (int) (i5 * c.a.s0.h.i.i.e.f10681e));
            this.l.setLineSpacing((int) (i5 * c.a.s0.h.i.i.e.f10680d), 1.0f);
            int i7 = this.f10669f;
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, (int) (i7 * c.a.s0.h.i.i.e.f10683g));
            layoutParams3.addRule(12);
            layoutParams3.bottomMargin = (int) (i7 * c.a.s0.h.i.i.e.f10682f);
            layoutParams3.leftMargin = i6;
            layoutParams3.rightMargin = i6;
            this.k.setLayoutParams(layoutParams3);
            int i8 = (int) (this.f10669f * c.a.s0.h.i.i.e.k);
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams((int) (f2 * c.a.s0.h.i.i.e.f10685i), -1);
            layoutParams4.addRule(9);
            float f3 = (int) (c.a.s0.h.i.i.e.l * i8);
            this.m.setTextSize(0, f3);
            layoutParams4.addRule(15);
            this.m.setLayoutParams(layoutParams4);
            RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams((int) (c.a.s0.h.i.i.e.f10686j * f2), i8);
            layoutParams5.addRule(12);
            layoutParams5.addRule(11);
            this.n.setTextSize(0, f3);
            this.n.setLayoutParams(layoutParams5);
            if (this.o != null) {
                int i9 = (int) (this.f10669f * c.a.s0.h.i.i.e.o);
                RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(i9, i9);
                layoutParams6.addRule(10);
                layoutParams6.addRule(11);
                this.o.setLayoutParams(layoutParams6);
            }
        }
    }

    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f10666c : (View) invokeV.objValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            View view = this.f10666c;
            if (view != null && view.getVisibility() == 0) {
                this.f10666c.setVisibility(4);
            }
            c.a.s0.h.i.s.d.b(this.u);
        }
    }

    @SuppressLint({"InflateParams"})
    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            Resources resources = this.a.getResources();
            View inflate = LayoutInflater.from(this.a).inflate(c.a.s0.h.i.f.ng_game_banner_ad, (ViewGroup) null);
            this.f10666c = inflate;
            this.f10667d = (LinearLayout) inflate.findViewById(c.a.s0.h.i.e.banner_view);
            this.f10673j = (RelativeLayout) this.f10666c.findViewById(c.a.s0.h.i.e.banner_ad_left);
            AdImageVIew adImageVIew = (AdImageVIew) this.f10666c.findViewById(c.a.s0.h.i.e.banner_w_pic);
            this.f10670g = adImageVIew;
            AdElementInfo adElementInfo = this.f10665b;
            if (adElementInfo != null) {
                adImageVIew.setImageUrl(adElementInfo.getPictureUrl());
            }
            AdImageVIew adImageVIew2 = (AdImageVIew) this.f10666c.findViewById(c.a.s0.h.i.e.ad_text);
            this.f10671h = adImageVIew2;
            adImageVIew2.setImageUrl("https://cpro.baidustatic.com/cpro/ui/noexpire/css/2.1.4/img/mob-adIcon_2x.png");
            this.f10672i = (RelativeLayout) this.f10666c.findViewById(c.a.s0.h.i.e.banner_ad_right);
            this.k = (RelativeLayout) this.f10666c.findViewById(c.a.s0.h.i.e.banner_right_bottom);
            this.l = (TextView) this.f10666c.findViewById(c.a.s0.h.i.e.banner_title);
            this.m = (TextView) this.f10666c.findViewById(c.a.s0.h.i.e.banner_app_name);
            AdElementInfo adElementInfo2 = this.f10665b;
            if (adElementInfo2 != null) {
                this.l.setText(adElementInfo2.getTitle());
                this.m.setText(this.f10665b.getAppName());
            }
            Button button = (Button) this.f10666c.findViewById(c.a.s0.h.i.e.banner_ad_act);
            this.n = button;
            button.setVisibility(8);
            AdElementInfo adElementInfo3 = this.f10665b;
            if (adElementInfo3 != null && adElementInfo3.getActionType() == 1) {
                this.n.setVisibility(0);
                this.n.setText(resources.getString(g.see_detail));
            }
            AdElementInfo adElementInfo4 = this.f10665b;
            if (adElementInfo4 != null && adElementInfo4.getActionType() == 2) {
                this.n.setVisibility(0);
                this.n.setText(resources.getString(g.swanapp_ad_download_button));
            }
            if (this.f10665b == null) {
                this.f10673j.setVisibility(8);
                this.f10672i.setVisibility(8);
                this.f10666c.findViewById(c.a.s0.h.i.e.no_ad_tips).setVisibility(0);
                return;
            }
            this.f10673j.setVisibility(0);
            this.f10672i.setVisibility(0);
            this.f10666c.findViewById(c.a.s0.h.i.e.no_ad_tips).setVisibility(8);
            if (this.t) {
                this.n.setOnClickListener(this.w);
                this.f10667d.setOnClickListener(this.w);
            } else {
                this.n.setOnClickListener(this.v);
                this.f10667d.setOnClickListener(this.v);
            }
            this.f10666c.setVisibility(4);
            if (this.p) {
                ImageView imageView = (ImageView) this.f10666c.findViewById(c.a.s0.h.i.e.close_ad_btn);
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

    public void j(c.a.s0.h.i.m.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            this.q = aVar;
        }
    }

    public void k(c.a.s0.h.i.m.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, eVar) == null) {
            this.r = eVar;
        }
    }

    public void l() {
        View view;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (view = this.f10666c) != null && view.getVisibility() == 4) {
            this.f10666c.setAnimation(AnimationUtils.loadAnimation(this.a, c.a.s0.h.i.a.ng_game_ad_open));
            this.f10666c.setVisibility(0);
            c.a.s0.h.i.s.d.a(this.u, c.a.s0.h.i.n.a.a().a());
        }
    }

    public d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.u = new a(this);
        this.v = new c(this);
        this.w = new View$OnClickListenerC0713d(this);
        this.a = context;
        h();
    }
}
