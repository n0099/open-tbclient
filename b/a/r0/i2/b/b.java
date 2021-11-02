package b.a.r0.i2.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import b.a.e.e.p.l;
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
/* loaded from: classes4.dex */
public abstract class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f17936a;

    /* renamed from: b  reason: collision with root package name */
    public View f17937b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f17938c;

    /* renamed from: d  reason: collision with root package name */
    public View f17939d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f17940e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f17941f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f17942g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f17943h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f17944i;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f17936a = tbPageContext;
        this.f17937b = view;
        NavigationBar navigationBar = (NavigationBar) view.findViewById(R.id.navigation_bar);
        this.f17938c = navigationBar;
        View addSystemImageButton = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f17939d = addSystemImageButton;
        addSystemImageButton.setId(R.id.btn_close);
        TextView addTextButton = this.f17938c.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, tbPageContext.getString(R.string.skip));
        this.f17940e = addTextButton;
        addTextButton.setId(R.id.btn_skip);
        this.m = (TextView) view.findViewById(R.id.top_tip);
        this.n = (TextView) view.findViewById(R.id.top_sub_tip);
        ImageView imageView = (ImageView) view.findViewById(R.id.img_logo);
        this.f17941f = imageView;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
        layoutParams.topMargin = l.i(tbPageContext.getPageActivity()) / 4;
        this.f17941f.setLayoutParams(layoutParams);
        TextView textView = (TextView) view.findViewById(R.id.login_btn);
        this.f17942g = textView;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) textView.getLayoutParams();
        layoutParams2.topMargin = (l.i(tbPageContext.getPageActivity()) / 2) + l.g(tbPageContext.getPageActivity(), R.dimen.tbds239);
        this.f17942g.setLayoutParams(layoutParams2);
        this.f17943h = (ImageView) view.findViewById(R.id.qq_login_btn);
        this.f17944i = (ImageView) view.findViewById(R.id.wechat_login_btn);
        this.j = (ImageView) view.findViewById(R.id.weibo_login_btn);
        this.k = (ImageView) view.findViewById(R.id.yy_login_btn);
        this.l = (ImageView) view.findViewById(R.id.more_login_btn);
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.f17938c.onChangeSkinType(this.f17936a, i2);
            SkinManager.setBackgroundColor(this.f17938c, R.color.CAM_X0201, i2);
            SkinManager.setBackgroundColor(this.f17937b, R.color.CAM_X0201, i2);
            SkinManager.setViewTextColor(this.f17940e, R.color.CAM_X0107);
            b.a.q0.s.u.c d2 = b.a.q0.s.u.c.d(this.m);
            d2.v(R.color.CAM_X0105);
            d2.z(R.dimen.T_X03);
            d2.A(R.string.F_X02);
            b.a.q0.s.u.c d3 = b.a.q0.s.u.c.d(this.n);
            d3.v(R.color.CAM_X0107);
            d3.z(R.dimen.T_X08);
            d3.A(R.string.F_X01);
            if (i2 == 0) {
                WebPManager.setMaskDrawable(this.f17941f, R.drawable.icon_mask_signin_logo_day, null);
            } else {
                WebPManager.setMaskDrawable(this.f17941f, R.drawable.icon_mask_signin_logo_night, null);
            }
            b.a.q0.s.u.c d4 = b.a.q0.s.u.c.d(this.f17942g);
            d4.v(R.color.CAM_X0101);
            d4.z(R.dimen.T_X05);
            d4.A(R.string.F_X01);
            d4.n(R.string.J_X01);
            d4.f(R.color.CAM_X0302);
            WebPManager.setMaskDrawable(this.f17943h, R.drawable.icon_share_qq, null);
            WebPManager.setMaskDrawable(this.f17944i, R.drawable.icon_share_wechat, null);
            WebPManager.setMaskDrawable(this.j, R.drawable.icon_share_weibo, null);
            WebPManager.setMaskDrawable(this.k, R.drawable.icon_share_yy, null);
            WebPManager.setMaskDrawable(this.l, R.drawable.icon_share_more, null);
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.f17939d.setVisibility(z ? 0 : 4);
        }
    }

    public abstract void c(c cVar);

    public void d(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) {
            this.f17940e.setOnClickListener(onClickListener);
            this.f17942g.setOnClickListener(onClickListener);
            this.f17943h.setOnClickListener(onClickListener);
            this.f17944i.setOnClickListener(onClickListener);
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
