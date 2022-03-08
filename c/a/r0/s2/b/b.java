package c.a.r0.s2.b;

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
    public View f22056b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f22057c;

    /* renamed from: d  reason: collision with root package name */
    public View f22058d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f22059e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f22060f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f22061g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f22062h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f22063i;

    /* renamed from: j  reason: collision with root package name */
    public ImageView f22064j;
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
        this.a = tbPageContext;
        this.f22056b = view;
        NavigationBar navigationBar = (NavigationBar) view.findViewById(R.id.navigation_bar);
        this.f22057c = navigationBar;
        View addSystemImageButton = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f22058d = addSystemImageButton;
        addSystemImageButton.setId(R.id.btn_close);
        TextView addTextButton = this.f22057c.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, tbPageContext.getString(R.string.skip));
        this.f22059e = addTextButton;
        addTextButton.setId(R.id.btn_skip);
        this.m = (TextView) view.findViewById(R.id.top_tip);
        this.n = (TextView) view.findViewById(R.id.top_sub_tip);
        ImageView imageView = (ImageView) view.findViewById(R.id.img_logo);
        this.f22060f = imageView;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
        layoutParams.topMargin = n.i(tbPageContext.getPageActivity()) / 4;
        this.f22060f.setLayoutParams(layoutParams);
        TextView textView = (TextView) view.findViewById(R.id.login_btn);
        this.f22061g = textView;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) textView.getLayoutParams();
        layoutParams2.topMargin = (n.i(tbPageContext.getPageActivity()) / 2) + n.f(tbPageContext.getPageActivity(), R.dimen.tbds239);
        this.f22061g.setLayoutParams(layoutParams2);
        this.f22062h = (ImageView) view.findViewById(R.id.qq_login_btn);
        this.f22063i = (ImageView) view.findViewById(R.id.wechat_login_btn);
        this.f22064j = (ImageView) view.findViewById(R.id.weibo_login_btn);
        this.k = (ImageView) view.findViewById(R.id.yy_login_btn);
        this.l = (ImageView) view.findViewById(R.id.more_login_btn);
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.f22057c.onChangeSkinType(this.a, i2);
            SkinManager.setBackgroundColor(this.f22057c, R.color.CAM_X0201, i2);
            SkinManager.setBackgroundColor(this.f22056b, R.color.CAM_X0201, i2);
            SkinManager.setViewTextColor(this.f22059e, (int) R.color.CAM_X0107);
            c.a.q0.r.v.c d2 = c.a.q0.r.v.c.d(this.m);
            d2.v(R.color.CAM_X0105);
            d2.z(R.dimen.T_X03);
            d2.A(R.string.F_X02);
            c.a.q0.r.v.c d3 = c.a.q0.r.v.c.d(this.n);
            d3.v(R.color.CAM_X0107);
            d3.z(R.dimen.T_X08);
            d3.A(R.string.F_X01);
            if (i2 == 0) {
                WebPManager.setMaskDrawable(this.f22060f, R.drawable.icon_mask_signin_logo_day, null);
            } else {
                WebPManager.setMaskDrawable(this.f22060f, R.drawable.icon_mask_signin_logo_night, null);
            }
            c.a.q0.r.v.c d4 = c.a.q0.r.v.c.d(this.f22061g);
            d4.v(R.color.CAM_X0101);
            d4.z(R.dimen.T_X05);
            d4.A(R.string.F_X01);
            d4.n(R.string.J_X01);
            d4.f(R.color.CAM_X0302);
            WebPManager.setMaskDrawable(this.f22062h, R.drawable.icon_share_qq, null);
            WebPManager.setMaskDrawable(this.f22063i, R.drawable.icon_share_wechat, null);
            WebPManager.setMaskDrawable(this.f22064j, R.drawable.icon_share_weibo, null);
            WebPManager.setMaskDrawable(this.k, R.drawable.icon_share_yy, null);
            WebPManager.setMaskDrawable(this.l, R.drawable.icon_share_more, null);
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.f22058d.setVisibility(z ? 0 : 4);
        }
    }

    public abstract void c(c cVar);

    public void d(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) {
            this.f22059e.setOnClickListener(onClickListener);
            this.f22061g.setOnClickListener(onClickListener);
            this.f22062h.setOnClickListener(onClickListener);
            this.f22063i.setOnClickListener(onClickListener);
            this.f22064j.setOnClickListener(onClickListener);
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
