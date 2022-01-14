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
    public c.a.s0.s.s.a f25485b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f25486c;

    /* renamed from: d  reason: collision with root package name */
    public View f25487d;

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f25488e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f25489f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f25490g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f25491h;

    /* renamed from: i  reason: collision with root package name */
    public final View.OnClickListener f25492i;

    /* renamed from: c.a.t0.x2.i.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class View$OnClickListenerC1532a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f25493e;

        public View$OnClickListenerC1532a(a aVar) {
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
            this.f25493e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f25493e.f25485b == null) {
                return;
            }
            this.f25493e.f25485b.dismiss();
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
        this.f25492i = new View$OnClickListenerC1532a(this);
        this.a = tbPageContext;
        this.f25486c = c.a.s0.s.h0.b.k().h("key_person_dynamic_tab_guide_has_shown", false);
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            View inflate = LayoutInflater.from(this.a.getPageActivity()).inflate(e.person_center_dynamic_tab_guide, (ViewGroup) null);
            this.f25487d = inflate;
            TbImageView tbImageView = (TbImageView) inflate.findViewById(d.id_person_center_dynamic_tab_guide_img);
            this.f25488e = tbImageView;
            e(tbImageView);
            this.f25488e.setAutoChangeStyle(true);
            this.f25488e.setRadius(n.f(this.a.getPageActivity(), c.a.t0.y2.b.tbds24));
            this.f25488e.setConrers(3);
            this.f25488e.setIsBitmapPic(true);
            this.f25489f = (TextView) this.f25487d.findViewById(d.id_person_center_dynamic_tab_guide_tip);
            this.f25490g = (TextView) this.f25487d.findViewById(d.id_person_center_dynamic_tab_guide_title);
            TextView textView = (TextView) this.f25487d.findViewById(d.id_person_center_dynamic_tab_guide_close);
            this.f25491h = textView;
            textView.setOnClickListener(this.f25492i);
            d();
        }
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f25486c : invokeV.booleanValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SkinManager.setImageResource(this.f25488e, c.pic_person_center_dynamic_guide);
            SkinManager.setViewTextColor(this.f25489f, c.a.t0.y2.a.CAM_X0107);
            SkinManager.setViewTextColor(this.f25490g, c.a.t0.y2.a.CAM_X0105);
            SkinManager.setViewTextColor(this.f25491h, c.a.t0.y2.a.CAM_X0302);
        }
    }

    public final void e(TbImageView tbImageView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, tbImageView) == null) || tbImageView == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) tbImageView.getLayoutParams();
        int k = n.k(this.a.getPageActivity()) - (n.f(this.a.getPageActivity(), c.a.t0.y2.b.ds40) * 2);
        layoutParams.width = k;
        layoutParams.height = (k * w0.c0) / 380;
        tbImageView.setLayoutParams(layoutParams);
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.f25486c) {
            return;
        }
        this.f25486c = true;
        c.a.s0.s.h0.b.k().u("key_person_dynamic_tab_guide_has_shown", true);
        b();
        c.a.s0.s.s.a aVar = new c.a.s0.s.s.a(this.a.getPageActivity());
        this.f25485b = aVar;
        aVar.setContentViewSize(1);
        this.f25485b.setCancelable(true);
        this.f25485b.setCanceledOnTouchOutside(false);
        this.f25485b.setContentView(this.f25487d);
        this.f25485b.create(this.a).show();
    }
}
