package c.a.r0.p2.i.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.e.e.p.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f23475a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.q0.s.s.a f23476b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f23477c;

    /* renamed from: d  reason: collision with root package name */
    public View f23478d;

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f23479e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f23480f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f23481g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f23482h;

    /* renamed from: i  reason: collision with root package name */
    public final View.OnClickListener f23483i;

    /* renamed from: c.a.r0.p2.i.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC1090a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f23484e;

        public View$OnClickListenerC1090a(a aVar) {
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
            this.f23484e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f23484e.f23476b == null) {
                return;
            }
            this.f23484e.f23476b.dismiss();
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
        this.f23483i = new View$OnClickListenerC1090a(this);
        this.f23475a = tbPageContext;
        this.f23477c = c.a.q0.s.d0.b.j().g("key_person_dynamic_tab_guide_has_shown", false);
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            View inflate = LayoutInflater.from(this.f23475a.getPageActivity()).inflate(R.layout.person_center_dynamic_tab_guide, (ViewGroup) null);
            this.f23478d = inflate;
            TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.id_person_center_dynamic_tab_guide_img);
            this.f23479e = tbImageView;
            e(tbImageView);
            this.f23479e.setAutoChangeStyle(true);
            this.f23479e.setRadius(l.g(this.f23475a.getPageActivity(), R.dimen.tbds24));
            this.f23479e.setConrers(3);
            this.f23479e.setIsBitmapPic(true);
            this.f23480f = (TextView) this.f23478d.findViewById(R.id.id_person_center_dynamic_tab_guide_tip);
            this.f23481g = (TextView) this.f23478d.findViewById(R.id.id_person_center_dynamic_tab_guide_title);
            TextView textView = (TextView) this.f23478d.findViewById(R.id.id_person_center_dynamic_tab_guide_close);
            this.f23482h = textView;
            textView.setOnClickListener(this.f23483i);
            d();
        }
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f23477c : invokeV.booleanValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SkinManager.setImageResource(this.f23479e, R.drawable.pic_person_center_dynamic_guide);
            SkinManager.setViewTextColor(this.f23480f, R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.f23481g, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f23482h, R.color.CAM_X0302);
        }
    }

    public final void e(TbImageView tbImageView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, tbImageView) == null) || tbImageView == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) tbImageView.getLayoutParams();
        int k = l.k(this.f23475a.getPageActivity()) - (l.g(this.f23475a.getPageActivity(), R.dimen.ds40) * 2);
        layoutParams.width = k;
        layoutParams.height = (k * 214) / 380;
        tbImageView.setLayoutParams(layoutParams);
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.f23477c) {
            return;
        }
        this.f23477c = true;
        c.a.q0.s.d0.b.j().t("key_person_dynamic_tab_guide_has_shown", true);
        b();
        c.a.q0.s.s.a aVar = new c.a.q0.s.s.a(this.f23475a.getPageActivity());
        this.f23476b = aVar;
        aVar.setContentViewSize(1);
        this.f23476b.setCancelable(true);
        this.f23476b.setCanceledOnTouchOutside(false);
        this.f23476b.setContentView(this.f23478d);
        this.f23476b.create(this.f23475a).show();
    }
}
