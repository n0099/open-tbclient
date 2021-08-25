package c.a.q0.n2.i.a;

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
    public TbPageContext f22694a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.p0.s.s.a f22695b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f22696c;

    /* renamed from: d  reason: collision with root package name */
    public View f22697d;

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f22698e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f22699f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f22700g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f22701h;

    /* renamed from: i  reason: collision with root package name */
    public final View.OnClickListener f22702i;

    /* renamed from: c.a.q0.n2.i.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC1049a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f22703e;

        public View$OnClickListenerC1049a(a aVar) {
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
            this.f22703e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f22703e.f22695b == null) {
                return;
            }
            this.f22703e.f22695b.dismiss();
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
        this.f22702i = new View$OnClickListenerC1049a(this);
        this.f22694a = tbPageContext;
        this.f22696c = c.a.p0.s.d0.b.j().g("key_person_dynamic_tab_guide_has_shown", false);
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            View inflate = LayoutInflater.from(this.f22694a.getPageActivity()).inflate(R.layout.person_center_dynamic_tab_guide, (ViewGroup) null);
            this.f22697d = inflate;
            TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.id_person_center_dynamic_tab_guide_img);
            this.f22698e = tbImageView;
            e(tbImageView);
            this.f22698e.setAutoChangeStyle(true);
            this.f22698e.setRadius(l.g(this.f22694a.getPageActivity(), R.dimen.tbds24));
            this.f22698e.setConrers(3);
            this.f22698e.setIsBitmapPic(true);
            this.f22699f = (TextView) this.f22697d.findViewById(R.id.id_person_center_dynamic_tab_guide_tip);
            this.f22700g = (TextView) this.f22697d.findViewById(R.id.id_person_center_dynamic_tab_guide_title);
            TextView textView = (TextView) this.f22697d.findViewById(R.id.id_person_center_dynamic_tab_guide_close);
            this.f22701h = textView;
            textView.setOnClickListener(this.f22702i);
            d();
        }
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f22696c : invokeV.booleanValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SkinManager.setImageResource(this.f22698e, R.drawable.pic_person_center_dynamic_guide);
            SkinManager.setViewTextColor(this.f22699f, R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.f22700g, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f22701h, R.color.CAM_X0302);
        }
    }

    public final void e(TbImageView tbImageView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, tbImageView) == null) || tbImageView == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) tbImageView.getLayoutParams();
        int k = l.k(this.f22694a.getPageActivity()) - (l.g(this.f22694a.getPageActivity(), R.dimen.ds40) * 2);
        layoutParams.width = k;
        layoutParams.height = (k * 214) / 380;
        tbImageView.setLayoutParams(layoutParams);
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.f22696c) {
            return;
        }
        this.f22696c = true;
        c.a.p0.s.d0.b.j().t("key_person_dynamic_tab_guide_has_shown", true);
        b();
        c.a.p0.s.s.a aVar = new c.a.p0.s.s.a(this.f22694a.getPageActivity());
        this.f22695b = aVar;
        aVar.setContentViewSize(1);
        this.f22695b.setCancelable(true);
        this.f22695b.setCanceledOnTouchOutside(false);
        this.f22695b.setContentView(this.f22697d);
        this.f22695b.create(this.f22694a).show();
    }
}
