package c.a.r0.v2.i.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.d.f.p.l;
import c.a.r0.w2.c;
import c.a.r0.w2.d;
import c.a.r0.w2.e;
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
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.q0.s.s.a f24854b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f24855c;

    /* renamed from: d  reason: collision with root package name */
    public View f24856d;

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f24857e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f24858f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f24859g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f24860h;

    /* renamed from: i  reason: collision with root package name */
    public final View.OnClickListener f24861i;

    /* renamed from: c.a.r0.v2.i.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class View$OnClickListenerC1418a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f24862e;

        public View$OnClickListenerC1418a(a aVar) {
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
            this.f24862e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f24862e.f24854b == null) {
                return;
            }
            this.f24862e.f24854b.dismiss();
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
        this.f24861i = new View$OnClickListenerC1418a(this);
        this.a = tbPageContext;
        this.f24855c = c.a.q0.s.e0.b.j().g("key_person_dynamic_tab_guide_has_shown", false);
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            View inflate = LayoutInflater.from(this.a.getPageActivity()).inflate(e.person_center_dynamic_tab_guide, (ViewGroup) null);
            this.f24856d = inflate;
            TbImageView tbImageView = (TbImageView) inflate.findViewById(d.id_person_center_dynamic_tab_guide_img);
            this.f24857e = tbImageView;
            e(tbImageView);
            this.f24857e.setAutoChangeStyle(true);
            this.f24857e.setRadius(l.f(this.a.getPageActivity(), c.a.r0.w2.b.tbds24));
            this.f24857e.setConrers(3);
            this.f24857e.setIsBitmapPic(true);
            this.f24858f = (TextView) this.f24856d.findViewById(d.id_person_center_dynamic_tab_guide_tip);
            this.f24859g = (TextView) this.f24856d.findViewById(d.id_person_center_dynamic_tab_guide_title);
            TextView textView = (TextView) this.f24856d.findViewById(d.id_person_center_dynamic_tab_guide_close);
            this.f24860h = textView;
            textView.setOnClickListener(this.f24861i);
            d();
        }
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f24855c : invokeV.booleanValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SkinManager.setImageResource(this.f24857e, c.pic_person_center_dynamic_guide);
            SkinManager.setViewTextColor(this.f24858f, c.a.r0.w2.a.CAM_X0107);
            SkinManager.setViewTextColor(this.f24859g, c.a.r0.w2.a.CAM_X0105);
            SkinManager.setViewTextColor(this.f24860h, c.a.r0.w2.a.CAM_X0302);
        }
    }

    public final void e(TbImageView tbImageView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, tbImageView) == null) || tbImageView == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) tbImageView.getLayoutParams();
        int k2 = l.k(this.a.getPageActivity()) - (l.f(this.a.getPageActivity(), c.a.r0.w2.b.ds40) * 2);
        layoutParams.width = k2;
        layoutParams.height = (k2 * w0.c0) / 380;
        tbImageView.setLayoutParams(layoutParams);
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.f24855c) {
            return;
        }
        this.f24855c = true;
        c.a.q0.s.e0.b.j().t("key_person_dynamic_tab_guide_has_shown", true);
        b();
        c.a.q0.s.s.a aVar = new c.a.q0.s.s.a(this.a.getPageActivity());
        this.f24854b = aVar;
        aVar.setContentViewSize(1);
        this.f24854b.setCancelable(true);
        this.f24854b.setCanceledOnTouchOutside(false);
        this.f24854b.setContentView(this.f24856d);
        this.f24854b.create(this.a).show();
    }
}
