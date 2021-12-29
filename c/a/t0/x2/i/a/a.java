package c.a.t0.x2.i.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.d.f.p.n;
import c.a.t0.y2.c;
import c.a.t0.y2.d;
import c.a.t0.y2.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.un.w0;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.s0.s.s.a f26265b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f26266c;

    /* renamed from: d  reason: collision with root package name */
    public View f26267d;

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f26268e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f26269f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f26270g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f26271h;

    /* renamed from: i  reason: collision with root package name */
    public final View.OnClickListener f26272i;

    /* renamed from: c.a.t0.x2.i.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class View$OnClickListenerC1516a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f26273e;

        public View$OnClickListenerC1516a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26273e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f26273e.f26265b == null) {
                return;
            }
            this.f26273e.f26265b.dismiss();
        }
    }

    public a(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f26272i = new View$OnClickListenerC1516a(this);
        this.a = tbPageContext;
        this.f26266c = c.a.s0.s.g0.b.j().g("key_person_dynamic_tab_guide_has_shown", false);
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            View inflate = LayoutInflater.from(this.a.getPageActivity()).inflate(e.person_center_dynamic_tab_guide, (ViewGroup) null);
            this.f26267d = inflate;
            TbImageView tbImageView = (TbImageView) inflate.findViewById(d.id_person_center_dynamic_tab_guide_img);
            this.f26268e = tbImageView;
            e(tbImageView);
            this.f26268e.setAutoChangeStyle(true);
            this.f26268e.setRadius(n.f(this.a.getPageActivity(), c.a.t0.y2.b.tbds24));
            this.f26268e.setConrers(3);
            this.f26268e.setIsBitmapPic(true);
            this.f26269f = (TextView) this.f26267d.findViewById(d.id_person_center_dynamic_tab_guide_tip);
            this.f26270g = (TextView) this.f26267d.findViewById(d.id_person_center_dynamic_tab_guide_title);
            TextView textView = (TextView) this.f26267d.findViewById(d.id_person_center_dynamic_tab_guide_close);
            this.f26271h = textView;
            textView.setOnClickListener(this.f26272i);
            d();
        }
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f26266c : invokeV.booleanValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SkinManager.setImageResource(this.f26268e, c.pic_person_center_dynamic_guide);
            SkinManager.setViewTextColor(this.f26269f, c.a.t0.y2.a.CAM_X0107);
            SkinManager.setViewTextColor(this.f26270g, c.a.t0.y2.a.CAM_X0105);
            SkinManager.setViewTextColor(this.f26271h, c.a.t0.y2.a.CAM_X0302);
        }
    }

    public final void e(TbImageView tbImageView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, tbImageView) == null) || tbImageView == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) tbImageView.getLayoutParams();
        int k2 = n.k(this.a.getPageActivity()) - (n.f(this.a.getPageActivity(), c.a.t0.y2.b.ds40) * 2);
        layoutParams.width = k2;
        layoutParams.height = (k2 * w0.c0) / 380;
        tbImageView.setLayoutParams(layoutParams);
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.f26266c) {
            return;
        }
        this.f26266c = true;
        c.a.s0.s.g0.b.j().t("key_person_dynamic_tab_guide_has_shown", true);
        b();
        c.a.s0.s.s.a aVar = new c.a.s0.s.s.a(this.a.getPageActivity());
        this.f26265b = aVar;
        aVar.setContentViewSize(1);
        this.f26265b.setCancelable(true);
        this.f26265b.setCanceledOnTouchOutside(false);
        this.f26265b.setContentView(this.f26267d);
        this.f26265b.create(this.a).show();
    }
}
