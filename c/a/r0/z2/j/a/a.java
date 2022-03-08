package c.a.r0.z2.j.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.d.f.p.n;
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
import com.kuaishou.weapon.un.w0;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.q0.r.t.a f25733b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f25734c;

    /* renamed from: d  reason: collision with root package name */
    public View f25735d;

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f25736e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f25737f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f25738g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f25739h;

    /* renamed from: i  reason: collision with root package name */
    public final View.OnClickListener f25740i;

    /* renamed from: c.a.r0.z2.j.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC1569a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f25741e;

        public View$OnClickListenerC1569a(a aVar) {
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
            this.f25741e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f25741e.f25733b == null) {
                return;
            }
            this.f25741e.f25733b.dismiss();
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
        this.f25740i = new View$OnClickListenerC1569a(this);
        this.a = tbPageContext;
        this.f25734c = c.a.q0.r.j0.b.k().h("key_person_dynamic_tab_guide_has_shown", false);
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            View inflate = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.person_center_dynamic_tab_guide, (ViewGroup) null);
            this.f25735d = inflate;
            TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.id_person_center_dynamic_tab_guide_img);
            this.f25736e = tbImageView;
            e(tbImageView);
            this.f25736e.setAutoChangeStyle(true);
            this.f25736e.setRadius(n.f(this.a.getPageActivity(), R.dimen.tbds24));
            this.f25736e.setConrers(3);
            this.f25736e.setIsBitmapPic(true);
            this.f25737f = (TextView) this.f25735d.findViewById(R.id.id_person_center_dynamic_tab_guide_tip);
            this.f25738g = (TextView) this.f25735d.findViewById(R.id.id_person_center_dynamic_tab_guide_title);
            TextView textView = (TextView) this.f25735d.findViewById(R.id.id_person_center_dynamic_tab_guide_close);
            this.f25739h = textView;
            textView.setOnClickListener(this.f25740i);
            d();
        }
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f25734c : invokeV.booleanValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SkinManager.setImageResource(this.f25736e, R.drawable.pic_person_center_dynamic_guide);
            SkinManager.setViewTextColor(this.f25737f, (int) R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.f25738g, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f25739h, (int) R.color.CAM_X0302);
        }
    }

    public final void e(TbImageView tbImageView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, tbImageView) == null) || tbImageView == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) tbImageView.getLayoutParams();
        int k = n.k(this.a.getPageActivity()) - (n.f(this.a.getPageActivity(), R.dimen.ds40) * 2);
        layoutParams.width = k;
        layoutParams.height = (k * w0.c0) / 380;
        tbImageView.setLayoutParams(layoutParams);
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.f25734c) {
            return;
        }
        this.f25734c = true;
        c.a.q0.r.j0.b.k().u("key_person_dynamic_tab_guide_has_shown", true);
        b();
        c.a.q0.r.t.a aVar = new c.a.q0.r.t.a(this.a.getPageActivity());
        this.f25733b = aVar;
        aVar.setContentViewSize(1);
        this.f25733b.setCancelable(true);
        this.f25733b.setCanceledOnTouchOutside(false);
        this.f25733b.setContentView(this.f25735d);
        this.f25733b.create(this.a).show();
    }
}
