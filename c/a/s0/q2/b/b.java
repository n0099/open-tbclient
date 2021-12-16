package c.a.s0.q2.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.d.f.p.m;
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
/* loaded from: classes8.dex */
public abstract class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public View f21774b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f21775c;

    /* renamed from: d  reason: collision with root package name */
    public View f21776d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f21777e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f21778f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f21779g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f21780h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f21781i;

    /* renamed from: j  reason: collision with root package name */
    public ImageView f21782j;

    /* renamed from: k  reason: collision with root package name */
    public ImageView f21783k;
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
        this.a = tbPageContext;
        this.f21774b = view;
        NavigationBar navigationBar = (NavigationBar) view.findViewById(R.id.navigation_bar);
        this.f21775c = navigationBar;
        View addSystemImageButton = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f21776d = addSystemImageButton;
        addSystemImageButton.setId(R.id.btn_close);
        TextView addTextButton = this.f21775c.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, tbPageContext.getString(R.string.skip));
        this.f21777e = addTextButton;
        addTextButton.setId(R.id.btn_skip);
        this.m = (TextView) view.findViewById(R.id.top_tip);
        this.n = (TextView) view.findViewById(R.id.top_sub_tip);
        ImageView imageView = (ImageView) view.findViewById(R.id.img_logo);
        this.f21778f = imageView;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
        layoutParams.topMargin = m.i(tbPageContext.getPageActivity()) / 4;
        this.f21778f.setLayoutParams(layoutParams);
        TextView textView = (TextView) view.findViewById(R.id.login_btn);
        this.f21779g = textView;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) textView.getLayoutParams();
        layoutParams2.topMargin = (m.i(tbPageContext.getPageActivity()) / 2) + m.f(tbPageContext.getPageActivity(), R.dimen.tbds239);
        this.f21779g.setLayoutParams(layoutParams2);
        this.f21780h = (ImageView) view.findViewById(R.id.qq_login_btn);
        this.f21781i = (ImageView) view.findViewById(R.id.wechat_login_btn);
        this.f21782j = (ImageView) view.findViewById(R.id.weibo_login_btn);
        this.f21783k = (ImageView) view.findViewById(R.id.yy_login_btn);
        this.l = (ImageView) view.findViewById(R.id.more_login_btn);
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.f21775c.onChangeSkinType(this.a, i2);
            SkinManager.setBackgroundColor(this.f21775c, R.color.CAM_X0201, i2);
            SkinManager.setBackgroundColor(this.f21774b, R.color.CAM_X0201, i2);
            SkinManager.setViewTextColor(this.f21777e, R.color.CAM_X0107);
            c.a.r0.s.v.c d2 = c.a.r0.s.v.c.d(this.m);
            d2.v(R.color.CAM_X0105);
            d2.z(R.dimen.T_X03);
            d2.A(R.string.F_X02);
            c.a.r0.s.v.c d3 = c.a.r0.s.v.c.d(this.n);
            d3.v(R.color.CAM_X0107);
            d3.z(R.dimen.T_X08);
            d3.A(R.string.F_X01);
            if (i2 == 0) {
                WebPManager.setMaskDrawable(this.f21778f, R.drawable.icon_mask_signin_logo_day, null);
            } else {
                WebPManager.setMaskDrawable(this.f21778f, R.drawable.icon_mask_signin_logo_night, null);
            }
            c.a.r0.s.v.c d4 = c.a.r0.s.v.c.d(this.f21779g);
            d4.v(R.color.CAM_X0101);
            d4.z(R.dimen.T_X05);
            d4.A(R.string.F_X01);
            d4.n(R.string.J_X01);
            d4.f(R.color.CAM_X0302);
            WebPManager.setMaskDrawable(this.f21780h, R.drawable.icon_share_qq, null);
            WebPManager.setMaskDrawable(this.f21781i, R.drawable.icon_share_wechat, null);
            WebPManager.setMaskDrawable(this.f21782j, R.drawable.icon_share_weibo, null);
            WebPManager.setMaskDrawable(this.f21783k, R.drawable.icon_share_yy, null);
            WebPManager.setMaskDrawable(this.l, R.drawable.icon_share_more, null);
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.f21776d.setVisibility(z ? 0 : 4);
        }
    }

    public abstract void c(c cVar);

    public void d(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) {
            this.f21777e.setOnClickListener(onClickListener);
            this.f21779g.setOnClickListener(onClickListener);
            this.f21780h.setOnClickListener(onClickListener);
            this.f21781i.setOnClickListener(onClickListener);
            this.f21782j.setOnClickListener(onClickListener);
            this.f21783k.setOnClickListener(onClickListener);
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
