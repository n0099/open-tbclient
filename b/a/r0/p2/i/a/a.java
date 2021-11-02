package b.a.r0.p2.i.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import b.a.e.e.p.l;
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
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f22363a;

    /* renamed from: b  reason: collision with root package name */
    public b.a.q0.s.s.a f22364b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f22365c;

    /* renamed from: d  reason: collision with root package name */
    public View f22366d;

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f22367e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f22368f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f22369g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f22370h;

    /* renamed from: i  reason: collision with root package name */
    public final View.OnClickListener f22371i;

    /* renamed from: b.a.r0.p2.i.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1089a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f22372e;

        public View$OnClickListenerC1089a(a aVar) {
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
            this.f22372e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f22372e.f22364b == null) {
                return;
            }
            this.f22372e.f22364b.dismiss();
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
        this.f22371i = new View$OnClickListenerC1089a(this);
        this.f22363a = tbPageContext;
        this.f22365c = b.a.q0.s.e0.b.j().g("key_person_dynamic_tab_guide_has_shown", false);
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            View inflate = LayoutInflater.from(this.f22363a.getPageActivity()).inflate(R.layout.person_center_dynamic_tab_guide, (ViewGroup) null);
            this.f22366d = inflate;
            TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.id_person_center_dynamic_tab_guide_img);
            this.f22367e = tbImageView;
            e(tbImageView);
            this.f22367e.setAutoChangeStyle(true);
            this.f22367e.setRadius(l.g(this.f22363a.getPageActivity(), R.dimen.tbds24));
            this.f22367e.setConrers(3);
            this.f22367e.setIsBitmapPic(true);
            this.f22368f = (TextView) this.f22366d.findViewById(R.id.id_person_center_dynamic_tab_guide_tip);
            this.f22369g = (TextView) this.f22366d.findViewById(R.id.id_person_center_dynamic_tab_guide_title);
            TextView textView = (TextView) this.f22366d.findViewById(R.id.id_person_center_dynamic_tab_guide_close);
            this.f22370h = textView;
            textView.setOnClickListener(this.f22371i);
            d();
        }
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f22365c : invokeV.booleanValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SkinManager.setImageResource(this.f22367e, R.drawable.pic_person_center_dynamic_guide);
            SkinManager.setViewTextColor(this.f22368f, R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.f22369g, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f22370h, R.color.CAM_X0302);
        }
    }

    public final void e(TbImageView tbImageView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, tbImageView) == null) || tbImageView == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) tbImageView.getLayoutParams();
        int k = l.k(this.f22363a.getPageActivity()) - (l.g(this.f22363a.getPageActivity(), R.dimen.ds40) * 2);
        layoutParams.width = k;
        layoutParams.height = (k * 214) / 380;
        tbImageView.setLayoutParams(layoutParams);
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.f22365c) {
            return;
        }
        this.f22365c = true;
        b.a.q0.s.e0.b.j().t("key_person_dynamic_tab_guide_has_shown", true);
        b();
        b.a.q0.s.s.a aVar = new b.a.q0.s.s.a(this.f22363a.getPageActivity());
        this.f22364b = aVar;
        aVar.setContentViewSize(1);
        this.f22364b.setCancelable(true);
        this.f22364b.setCanceledOnTouchOutside(false);
        this.f22364b.setContentView(this.f22366d);
        this.f22364b.create(this.f22363a).show();
    }
}
