package c.a.p0.u2.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.d.f.p.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public abstract class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public View f18959b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f18960c;

    /* renamed from: d  reason: collision with root package name */
    public View f18961d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f18962e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f18963f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f18964g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f18965h;
    public ImageView i;
    public ImageView j;
    public ImageView k;
    public ImageView l;
    public TextView m;
    public TextView n;

    public b(TbPageContext tbPageContext, View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = tbPageContext;
        this.f18959b = view;
        NavigationBar navigationBar = (NavigationBar) view.findViewById(R.id.obfuscated_res_0x7f091519);
        this.f18960c = navigationBar;
        View addSystemImageButton = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f18961d = addSystemImageButton;
        addSystemImageButton.setId(R.id.obfuscated_res_0x7f09040d);
        TextView addTextButton = this.f18960c.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, tbPageContext.getString(R.string.obfuscated_res_0x7f0f117c));
        this.f18962e = addTextButton;
        addTextButton.setId(R.id.obfuscated_res_0x7f090438);
        this.m = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0920cd);
        this.n = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0920cc);
        ImageView imageView = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f090ebd);
        this.f18963f = imageView;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
        layoutParams.topMargin = n.i(tbPageContext.getPageActivity()) / 4;
        this.f18963f.setLayoutParams(layoutParams);
        TextView textView = (TextView) view.findViewById(R.id.obfuscated_res_0x7f091336);
        this.f18964g = textView;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) textView.getLayoutParams();
        layoutParams2.topMargin = (n.i(tbPageContext.getPageActivity()) / 2) + n.f(tbPageContext.getPageActivity(), R.dimen.tbds239);
        this.f18964g.setLayoutParams(layoutParams2);
        this.f18965h = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f091990);
        this.i = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f09245d);
        this.j = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f092460);
        this.k = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f0924cd);
        this.l = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f09144a);
    }

    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            this.f18960c.onChangeSkinType(this.a, i);
            SkinManager.setBackgroundColor(this.f18960c, R.color.CAM_X0201, i);
            SkinManager.setBackgroundColor(this.f18959b, R.color.CAM_X0201, i);
            SkinManager.setViewTextColor(this.f18962e, (int) R.color.CAM_X0107);
            c.a.o0.r.v.c d2 = c.a.o0.r.v.c.d(this.m);
            d2.v(R.color.CAM_X0105);
            d2.z(R.dimen.T_X03);
            d2.A(R.string.F_X02);
            c.a.o0.r.v.c d3 = c.a.o0.r.v.c.d(this.n);
            d3.v(R.color.CAM_X0107);
            d3.z(R.dimen.T_X08);
            d3.A(R.string.F_X01);
            if (i == 0) {
                WebPManager.setMaskDrawable(this.f18963f, R.drawable.obfuscated_res_0x7f080827, null);
            } else {
                WebPManager.setMaskDrawable(this.f18963f, R.drawable.obfuscated_res_0x7f080828, null);
            }
            c.a.o0.r.v.c d4 = c.a.o0.r.v.c.d(this.f18964g);
            d4.v(R.color.CAM_X0101);
            d4.z(R.dimen.T_X05);
            d4.A(R.string.F_X01);
            d4.n(R.string.J_X01);
            d4.f(R.color.CAM_X0302);
            WebPManager.setMaskDrawable(this.f18965h, R.drawable.icon_share_qq, null);
            WebPManager.setMaskDrawable(this.i, R.drawable.icon_share_wechat, null);
            WebPManager.setMaskDrawable(this.j, R.drawable.icon_share_weibo, null);
            WebPManager.setMaskDrawable(this.k, R.drawable.icon_share_yy, null);
            WebPManager.setMaskDrawable(this.l, R.drawable.icon_share_more, null);
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.f18961d.setVisibility(z ? 0 : 4);
        }
    }

    public abstract void c(c cVar);

    public void d(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) {
            this.f18962e.setOnClickListener(onClickListener);
            this.f18964g.setOnClickListener(onClickListener);
            this.f18965h.setOnClickListener(onClickListener);
            this.i.setOnClickListener(onClickListener);
            this.j.setOnClickListener(onClickListener);
            this.k.setOnClickListener(onClickListener);
            this.l.setOnClickListener(onClickListener);
        }
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.m.setVisibility(z ? 0 : 4);
            this.n.setVisibility(z ? 0 : 4);
        }
    }
}
