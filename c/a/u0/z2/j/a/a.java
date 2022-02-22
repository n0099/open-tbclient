package c.a.u0.z2.j.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.d.f.p.n;
import c.a.u0.a3.c;
import c.a.u0.a3.d;
import c.a.u0.a3.e;
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
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.t0.s.t.a f26071b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f26072c;

    /* renamed from: d  reason: collision with root package name */
    public View f26073d;

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f26074e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f26075f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f26076g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f26077h;

    /* renamed from: i  reason: collision with root package name */
    public final View.OnClickListener f26078i;

    /* renamed from: c.a.u0.z2.j.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class View$OnClickListenerC1577a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f26079e;

        public View$OnClickListenerC1577a(a aVar) {
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
            this.f26079e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f26079e.f26071b == null) {
                return;
            }
            this.f26079e.f26071b.dismiss();
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
        this.f26078i = new View$OnClickListenerC1577a(this);
        this.a = tbPageContext;
        this.f26072c = c.a.t0.s.j0.b.k().h("key_person_dynamic_tab_guide_has_shown", false);
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            View inflate = LayoutInflater.from(this.a.getPageActivity()).inflate(e.person_center_dynamic_tab_guide, (ViewGroup) null);
            this.f26073d = inflate;
            TbImageView tbImageView = (TbImageView) inflate.findViewById(d.id_person_center_dynamic_tab_guide_img);
            this.f26074e = tbImageView;
            e(tbImageView);
            this.f26074e.setAutoChangeStyle(true);
            this.f26074e.setRadius(n.f(this.a.getPageActivity(), c.a.u0.a3.b.tbds24));
            this.f26074e.setConrers(3);
            this.f26074e.setIsBitmapPic(true);
            this.f26075f = (TextView) this.f26073d.findViewById(d.id_person_center_dynamic_tab_guide_tip);
            this.f26076g = (TextView) this.f26073d.findViewById(d.id_person_center_dynamic_tab_guide_title);
            TextView textView = (TextView) this.f26073d.findViewById(d.id_person_center_dynamic_tab_guide_close);
            this.f26077h = textView;
            textView.setOnClickListener(this.f26078i);
            d();
        }
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f26072c : invokeV.booleanValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SkinManager.setImageResource(this.f26074e, c.pic_person_center_dynamic_guide);
            SkinManager.setViewTextColor(this.f26075f, c.a.u0.a3.a.CAM_X0107);
            SkinManager.setViewTextColor(this.f26076g, c.a.u0.a3.a.CAM_X0105);
            SkinManager.setViewTextColor(this.f26077h, c.a.u0.a3.a.CAM_X0302);
        }
    }

    public final void e(TbImageView tbImageView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, tbImageView) == null) || tbImageView == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) tbImageView.getLayoutParams();
        int k = n.k(this.a.getPageActivity()) - (n.f(this.a.getPageActivity(), c.a.u0.a3.b.ds40) * 2);
        layoutParams.width = k;
        layoutParams.height = (k * w0.c0) / 380;
        tbImageView.setLayoutParams(layoutParams);
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.f26072c) {
            return;
        }
        this.f26072c = true;
        c.a.t0.s.j0.b.k().u("key_person_dynamic_tab_guide_has_shown", true);
        b();
        c.a.t0.s.t.a aVar = new c.a.t0.s.t.a(this.a.getPageActivity());
        this.f26071b = aVar;
        aVar.setContentViewSize(1);
        this.f26071b.setCancelable(true);
        this.f26071b.setCanceledOnTouchOutside(false);
        this.f26071b.setContentView(this.f26073d);
        this.f26071b.create(this.a).show();
    }
}
