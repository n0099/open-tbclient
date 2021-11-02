package b.a.r0.y1.f;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f27593a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f27594b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f27595c;

    /* renamed from: d  reason: collision with root package name */
    public NoNetworkView f27596d;

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f27597e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f27598f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f27599g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f27600h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f27601i;
    public TextView j;
    public TextView k;
    public int l;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f27602e;

        public a(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27602e = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                UrlManager.getInstance().dealOneLink(this.f27602e.f27594b, new String[]{TbConfig.URL_JUMP_TAG_CARDBOX}, true);
            }
        }
    }

    public g(TbPageContext tbPageContext) {
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
        this.l = 3;
        this.f27593a = tbPageContext.getPageActivity();
        this.f27594b = tbPageContext;
        tbPageContext.getPageActivity().setContentView(R.layout.member_pay_result_layout);
        NavigationBar navigationBar = (NavigationBar) tbPageContext.getPageActivity().findViewById(R.id.navigation_bar);
        this.f27595c = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f27595c.showBottomLine();
        this.f27596d = (NoNetworkView) tbPageContext.getPageActivity().findViewById(R.id.no_network_view);
        this.f27595c.onChangeSkinType(tbPageContext, TbadkApplication.getInst().getSkinType());
        this.f27597e = (TbImageView) tbPageContext.getPageActivity().findViewById(R.id.success_img);
        this.f27598f = (TextView) tbPageContext.getPageActivity().findViewById(R.id.success_text);
        this.f27599g = (TextView) tbPageContext.getPageActivity().findViewById(R.id.pay_content);
        this.f27601i = (TextView) tbPageContext.getPageActivity().findViewById(R.id.super_member);
        this.f27600h = (TextView) tbPageContext.getPageActivity().findViewById(R.id.tip_content);
        TextView textView = (TextView) tbPageContext.getPageActivity().findViewById(R.id.open_card_box_view);
        this.j = textView;
        textView.setOnClickListener(new a(this));
        c();
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.f27599g.setText(String.format(this.f27593a.getString(R.string.pay_member_content), str));
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.k = this.f27595c.setCenterTextTitle(this.f27593a.getString(R.string.card_box_nav_title));
            this.f27596d.onChangeSkinType(this.f27594b, TbadkApplication.getInst().getSkinType());
            SkinManager.setViewTextColor(this.k, R.color.CAM_X0105);
            SkinManager.setImageResource(this.f27597e, R.drawable.icon_send_ok);
            SkinManager.setViewTextColor(this.f27598f, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f27599g, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f27601i, R.color.CAM_X0305);
            SkinManager.setViewTextColor(this.f27600h, R.color.CAM_X0108);
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0111);
            SkinManager.setBackgroundResource(this.j, R.drawable.btn_all_orange);
        }
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            if (this.l != i2) {
                this.f27595c.onChangeSkinType(this.f27594b, i2);
                this.f27596d.onChangeSkinType(this.f27594b, i2);
                SkinManager.setViewTextColor(this.k, R.color.CAM_X0105);
                SkinManager.setImageResource(this.f27597e, R.drawable.icon_send_ok);
                SkinManager.setViewTextColor(this.f27598f, R.color.CAM_X0105);
                SkinManager.setViewTextColor(this.f27599g, R.color.CAM_X0105);
                SkinManager.setViewTextColor(this.f27601i, R.color.CAM_X0305);
                SkinManager.setViewTextColor(this.f27600h, R.color.CAM_X0108);
                SkinManager.setViewTextColor(this.j, R.color.CAM_X0111);
                SkinManager.setBackgroundResource(this.j, R.drawable.btn_all_orange);
            }
            this.l = i2;
        }
    }
}
