package c.a.p0.b3.j.a;

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
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.o0.r.t.a f12777b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f12778c;

    /* renamed from: d  reason: collision with root package name */
    public View f12779d;

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f12780e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f12781f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f12782g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f12783h;
    public final View.OnClickListener i;

    /* renamed from: c.a.p0.b3.j.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class View$OnClickListenerC0961a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public View$OnClickListenerC0961a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.a.f12777b == null) {
                return;
            }
            this.a.f12777b.dismiss();
        }
    }

    public a(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = new View$OnClickListenerC0961a(this);
        this.a = tbPageContext;
        this.f12778c = c.a.o0.r.j0.b.k().h("key_person_dynamic_tab_guide_has_shown", false);
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            View inflate = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d06b1, (ViewGroup) null);
            this.f12779d = inflate;
            TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.obfuscated_res_0x7f090e3a);
            this.f12780e = tbImageView;
            e(tbImageView);
            this.f12780e.setAutoChangeStyle(true);
            this.f12780e.setRadius(n.f(this.a.getPageActivity(), R.dimen.tbds24));
            this.f12780e.setConrers(3);
            this.f12780e.setIsBitmapPic(true);
            this.f12781f = (TextView) this.f12779d.findViewById(R.id.obfuscated_res_0x7f090e3b);
            this.f12782g = (TextView) this.f12779d.findViewById(R.id.obfuscated_res_0x7f090e3c);
            TextView textView = (TextView) this.f12779d.findViewById(R.id.obfuscated_res_0x7f090e39);
            this.f12783h = textView;
            textView.setOnClickListener(this.i);
            d();
        }
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f12778c : invokeV.booleanValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SkinManager.setImageResource(this.f12780e, R.drawable.obfuscated_res_0x7f080f41);
            SkinManager.setViewTextColor(this.f12781f, (int) R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.f12782g, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f12783h, (int) R.color.CAM_X0302);
        }
    }

    public final void e(TbImageView tbImageView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, tbImageView) == null) || tbImageView == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) tbImageView.getLayoutParams();
        int k = n.k(this.a.getPageActivity()) - (n.f(this.a.getPageActivity(), R.dimen.obfuscated_res_0x7f070225) * 2);
        layoutParams.width = k;
        layoutParams.height = (k * w0.c0) / 380;
        tbImageView.setLayoutParams(layoutParams);
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.f12778c) {
            return;
        }
        this.f12778c = true;
        c.a.o0.r.j0.b.k().u("key_person_dynamic_tab_guide_has_shown", true);
        b();
        c.a.o0.r.t.a aVar = new c.a.o0.r.t.a(this.a.getPageActivity());
        this.f12777b = aVar;
        aVar.setContentViewSize(1);
        this.f12777b.setCancelable(true);
        this.f12777b.setCanceledOnTouchOutside(false);
        this.f12777b.setContentView(this.f12779d);
        this.f12777b.create(this.a).show();
    }
}
