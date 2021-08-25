package c.a.o0.f.i.i;

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
import c.a.o0.f.i.g;
import c.a.o0.f.i.r.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.game.ad.component.AdImageVIew;
import com.baidu.swan.game.ad.entity.AdElementInfo;
import com.baidu.swan.game.ad.jsbridge.CommandType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f10495a;

    /* renamed from: b  reason: collision with root package name */
    public AdElementInfo f10496b;

    /* renamed from: c  reason: collision with root package name */
    public View f10497c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f10498d;

    /* renamed from: e  reason: collision with root package name */
    public int f10499e;

    /* renamed from: f  reason: collision with root package name */
    public int f10500f;

    /* renamed from: g  reason: collision with root package name */
    public AdImageVIew f10501g;

    /* renamed from: h  reason: collision with root package name */
    public AdImageVIew f10502h;

    /* renamed from: i  reason: collision with root package name */
    public RelativeLayout f10503i;

    /* renamed from: j  reason: collision with root package name */
    public RelativeLayout f10504j;
    public RelativeLayout k;
    public TextView l;
    public TextView m;
    public Button n;
    public ImageView o;
    public boolean p;
    public c.a.o0.f.i.l.a q;
    public c.a.o0.f.i.l.d r;
    public e s;
    public boolean t;
    public Runnable u;
    public View.OnClickListener v;
    public View.OnClickListener w;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f10505e;

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
            this.f10505e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f10505e.g();
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f10506e;

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
            this.f10506e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.o0.f.i.r.d.b(this.f10506e.u);
                if (this.f10506e.s != null) {
                    this.f10506e.s.b();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f10507e;

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
            this.f10507e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f10507e.q == null) {
                return;
            }
            this.f10507e.q.b(CommandType.BANNER_VIEW, null);
        }
    }

    /* renamed from: c.a.o0.f.i.i.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0521d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f10508e;

        public View$OnClickListenerC0521d(d dVar) {
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
            this.f10508e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f10508e.r == null) {
                return;
            }
            this.f10508e.r.f(view);
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
        this.w = new View$OnClickListenerC0521d(this);
        this.f10495a = context;
        this.f10496b = adElementInfo;
        this.p = c.a.o0.f.i.m.a.a().j();
        this.t = z;
        h();
    }

    public void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            int a2 = h.a(i2);
            this.f10499e = a2;
            this.f10500f = (int) (a2 / c.a.o0.f.i.i.e.f10509a);
            this.f10497c.setLayoutParams(new RelativeLayout.LayoutParams(this.f10499e, this.f10500f));
            this.f10498d.setLayoutParams(new RelativeLayout.LayoutParams(this.f10499e, this.f10500f));
            int i3 = (int) (this.f10500f * c.a.o0.f.i.i.e.f10510b);
            this.f10504j.setLayoutParams(new LinearLayout.LayoutParams(i3, this.f10500f));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (i3 * c.a.o0.f.i.i.e.m), (int) (this.f10500f * c.a.o0.f.i.i.e.n));
            layoutParams.addRule(12);
            layoutParams.addRule(9);
            layoutParams.setMarginStart(0);
            this.f10502h.setLayoutParams(layoutParams);
            int i4 = this.f10499e - i3;
            this.f10503i.setLayoutParams(new LinearLayout.LayoutParams(i4, this.f10500f));
            int i5 = this.f10500f;
            float f2 = i4;
            int i6 = (int) (c.a.o0.f.i.i.e.f10516h * f2);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams2.addRule(9);
            layoutParams2.topMargin = (int) (i5 * c.a.o0.f.i.i.e.f10511c);
            layoutParams2.leftMargin = i6;
            layoutParams2.rightMargin = i6;
            this.l.setLayoutParams(layoutParams2);
            this.l.setTextSize(0, (int) (i5 * c.a.o0.f.i.i.e.f10513e));
            this.l.setLineSpacing((int) (i5 * c.a.o0.f.i.i.e.f10512d), 1.0f);
            int i7 = this.f10500f;
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, (int) (i7 * c.a.o0.f.i.i.e.f10515g));
            layoutParams3.addRule(12);
            layoutParams3.bottomMargin = (int) (i7 * c.a.o0.f.i.i.e.f10514f);
            layoutParams3.leftMargin = i6;
            layoutParams3.rightMargin = i6;
            this.k.setLayoutParams(layoutParams3);
            int i8 = (int) (this.f10500f * c.a.o0.f.i.i.e.k);
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams((int) (f2 * c.a.o0.f.i.i.e.f10517i), -1);
            layoutParams4.addRule(9);
            float f3 = (int) (c.a.o0.f.i.i.e.l * i8);
            this.m.setTextSize(0, f3);
            layoutParams4.addRule(15);
            this.m.setLayoutParams(layoutParams4);
            RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams((int) (c.a.o0.f.i.i.e.f10518j * f2), i8);
            layoutParams5.addRule(12);
            layoutParams5.addRule(11);
            this.n.setTextSize(0, f3);
            this.n.setLayoutParams(layoutParams5);
            if (this.o != null) {
                int i9 = (int) (this.f10500f * c.a.o0.f.i.i.e.o);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f10497c : (View) invokeV.objValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            View view = this.f10497c;
            if (view != null && view.getVisibility() == 0) {
                this.f10497c.setVisibility(4);
            }
            c.a.o0.f.i.r.d.b(this.u);
        }
    }

    @SuppressLint({"InflateParams"})
    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            Resources resources = this.f10495a.getResources();
            View inflate = LayoutInflater.from(this.f10495a).inflate(c.a.o0.f.i.f.ng_game_banner_ad, (ViewGroup) null);
            this.f10497c = inflate;
            this.f10498d = (LinearLayout) inflate.findViewById(c.a.o0.f.i.e.banner_view);
            this.f10504j = (RelativeLayout) this.f10497c.findViewById(c.a.o0.f.i.e.banner_ad_left);
            AdImageVIew adImageVIew = (AdImageVIew) this.f10497c.findViewById(c.a.o0.f.i.e.banner_w_pic);
            this.f10501g = adImageVIew;
            AdElementInfo adElementInfo = this.f10496b;
            if (adElementInfo != null) {
                adImageVIew.setImageUrl(adElementInfo.getPictureUrl());
            }
            AdImageVIew adImageVIew2 = (AdImageVIew) this.f10497c.findViewById(c.a.o0.f.i.e.ad_text);
            this.f10502h = adImageVIew2;
            adImageVIew2.setImageUrl("https://cpro.baidustatic.com/cpro/ui/noexpire/css/2.1.4/img/mob-adIcon_2x.png");
            this.f10503i = (RelativeLayout) this.f10497c.findViewById(c.a.o0.f.i.e.banner_ad_right);
            this.k = (RelativeLayout) this.f10497c.findViewById(c.a.o0.f.i.e.banner_right_bottom);
            this.l = (TextView) this.f10497c.findViewById(c.a.o0.f.i.e.banner_title);
            this.m = (TextView) this.f10497c.findViewById(c.a.o0.f.i.e.banner_app_name);
            AdElementInfo adElementInfo2 = this.f10496b;
            if (adElementInfo2 != null) {
                this.l.setText(adElementInfo2.getTitle());
                this.m.setText(this.f10496b.getAppName());
            }
            Button button = (Button) this.f10497c.findViewById(c.a.o0.f.i.e.banner_ad_act);
            this.n = button;
            button.setVisibility(8);
            AdElementInfo adElementInfo3 = this.f10496b;
            if (adElementInfo3 != null && adElementInfo3.getActionType() == 1) {
                this.n.setVisibility(0);
                this.n.setText(resources.getString(g.see_detail));
            }
            AdElementInfo adElementInfo4 = this.f10496b;
            if (adElementInfo4 != null && adElementInfo4.getActionType() == 2) {
                this.n.setVisibility(0);
                this.n.setText(resources.getString(g.swanapp_ad_download_button));
            }
            if (this.f10496b == null) {
                this.f10504j.setVisibility(8);
                this.f10503i.setVisibility(8);
                this.f10497c.findViewById(c.a.o0.f.i.e.no_ad_tips).setVisibility(0);
                return;
            }
            this.f10504j.setVisibility(0);
            this.f10503i.setVisibility(0);
            this.f10497c.findViewById(c.a.o0.f.i.e.no_ad_tips).setVisibility(8);
            if (this.t) {
                this.n.setOnClickListener(this.w);
                this.f10498d.setOnClickListener(this.w);
            } else {
                this.n.setOnClickListener(this.v);
                this.f10498d.setOnClickListener(this.v);
            }
            this.f10497c.setVisibility(4);
            if (this.p) {
                ImageView imageView = (ImageView) this.f10497c.findViewById(c.a.o0.f.i.e.close_ad_btn);
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

    public void j(c.a.o0.f.i.l.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            this.q = aVar;
        }
    }

    public void k(c.a.o0.f.i.l.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, dVar) == null) {
            this.r = dVar;
        }
    }

    public void l() {
        View view;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (view = this.f10497c) != null && view.getVisibility() == 4) {
            this.f10497c.setAnimation(AnimationUtils.loadAnimation(this.f10495a, c.a.o0.f.i.a.ng_game_ad_open));
            this.f10497c.setVisibility(0);
            c.a.o0.f.i.r.d.a(this.u, c.a.o0.f.i.m.a.a().a());
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
        this.w = new View$OnClickListenerC0521d(this);
        this.f10495a = context;
        h();
    }
}
