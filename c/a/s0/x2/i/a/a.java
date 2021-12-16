package c.a.s0.x2.i.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.d.f.p.m;
import c.a.s0.y2.c;
import c.a.s0.y2.d;
import c.a.s0.y2.e;
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
    public c.a.r0.s.t.a f25777b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f25778c;

    /* renamed from: d  reason: collision with root package name */
    public View f25779d;

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f25780e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f25781f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f25782g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f25783h;

    /* renamed from: i  reason: collision with root package name */
    public final View.OnClickListener f25784i;

    /* renamed from: c.a.s0.x2.i.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class View$OnClickListenerC1493a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f25785e;

        public View$OnClickListenerC1493a(a aVar) {
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
            this.f25785e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f25785e.f25777b == null) {
                return;
            }
            this.f25785e.f25777b.dismiss();
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
        this.f25784i = new View$OnClickListenerC1493a(this);
        this.a = tbPageContext;
        this.f25778c = c.a.r0.s.g0.b.j().g("key_person_dynamic_tab_guide_has_shown", false);
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            View inflate = LayoutInflater.from(this.a.getPageActivity()).inflate(e.person_center_dynamic_tab_guide, (ViewGroup) null);
            this.f25779d = inflate;
            TbImageView tbImageView = (TbImageView) inflate.findViewById(d.id_person_center_dynamic_tab_guide_img);
            this.f25780e = tbImageView;
            e(tbImageView);
            this.f25780e.setAutoChangeStyle(true);
            this.f25780e.setRadius(m.f(this.a.getPageActivity(), c.a.s0.y2.b.tbds24));
            this.f25780e.setConrers(3);
            this.f25780e.setIsBitmapPic(true);
            this.f25781f = (TextView) this.f25779d.findViewById(d.id_person_center_dynamic_tab_guide_tip);
            this.f25782g = (TextView) this.f25779d.findViewById(d.id_person_center_dynamic_tab_guide_title);
            TextView textView = (TextView) this.f25779d.findViewById(d.id_person_center_dynamic_tab_guide_close);
            this.f25783h = textView;
            textView.setOnClickListener(this.f25784i);
            d();
        }
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f25778c : invokeV.booleanValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SkinManager.setImageResource(this.f25780e, c.pic_person_center_dynamic_guide);
            SkinManager.setViewTextColor(this.f25781f, c.a.s0.y2.a.CAM_X0107);
            SkinManager.setViewTextColor(this.f25782g, c.a.s0.y2.a.CAM_X0105);
            SkinManager.setViewTextColor(this.f25783h, c.a.s0.y2.a.CAM_X0302);
        }
    }

    public final void e(TbImageView tbImageView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, tbImageView) == null) || tbImageView == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) tbImageView.getLayoutParams();
        int k2 = m.k(this.a.getPageActivity()) - (m.f(this.a.getPageActivity(), c.a.s0.y2.b.ds40) * 2);
        layoutParams.width = k2;
        layoutParams.height = (k2 * w0.c0) / 380;
        tbImageView.setLayoutParams(layoutParams);
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.f25778c) {
            return;
        }
        this.f25778c = true;
        c.a.r0.s.g0.b.j().t("key_person_dynamic_tab_guide_has_shown", true);
        b();
        c.a.r0.s.t.a aVar = new c.a.r0.s.t.a(this.a.getPageActivity());
        this.f25777b = aVar;
        aVar.setContentViewSize(1);
        this.f25777b.setCancelable(true);
        this.f25777b.setCanceledOnTouchOutside(false);
        this.f25777b.setContentView(this.f25779d);
        this.f25777b.create(this.a).show();
    }
}
