package c.a.r0.d4.g.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.themeCenter.card.detail.PersonalCardDetailActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PersonalCardDetailActivity a;

    /* renamed from: b  reason: collision with root package name */
    public View f17030b;

    /* renamed from: c  reason: collision with root package name */
    public View f17031c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f17032d;

    /* renamed from: e  reason: collision with root package name */
    public NoNetworkView f17033e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f17034f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f17035g;

    /* renamed from: h  reason: collision with root package name */
    public TbImageView f17036h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f17037i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f17038j;
    public HeadImageView k;
    public TextView l;
    public TbImageView m;
    public UserIconBox n;
    public View o;
    public View p;
    public c.a.r0.d4.a q;
    public View.OnClickListener r;
    public int s;
    public int t;
    public int u;
    public int v;

    public a(PersonalCardDetailActivity personalCardDetailActivity, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {personalCardDetailActivity, onClickListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.s = 0;
        this.t = 0;
        this.u = 0;
        this.v = 0;
        this.a = personalCardDetailActivity;
        View inflate = LayoutInflater.from(personalCardDetailActivity.getPageContext().getPageActivity()).inflate(R.layout.personal_card_detail_layout, (ViewGroup) null);
        this.f17030b = inflate;
        this.a.setContentView(inflate);
        this.a.setNetRefreshViewTopMargin(BdListViewHelper.a);
        this.s = n.f(this.a.getPageContext().getPageActivity(), R.dimen.ds4);
        this.t = n.f(this.a.getPageContext().getPageActivity(), R.dimen.ds10);
        this.u = n.f(this.a.getPageContext().getPageActivity(), R.dimen.ds16);
        this.v = n.f(this.a.getPageContext().getPageActivity(), R.dimen.ds30);
        this.r = onClickListener;
        NavigationBar navigationBar = (NavigationBar) this.f17030b.findViewById(R.id.view_navigation_bar);
        this.f17032d = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f17032d.setTitleText(R.string.personal_card_detail);
        this.f17033e = (NoNetworkView) this.f17030b.findViewById(R.id.view_no_network);
        this.f17031c = this.f17030b.findViewById(R.id.content_view);
        this.p = this.f17030b.findViewById(R.id.top_divider_view);
        TbImageView tbImageView = (TbImageView) this.f17030b.findViewById(R.id.card_image_view);
        this.f17034f = tbImageView;
        tbImageView.setDefaultBgResource(R.drawable.transparent_bg);
        this.f17034f.setDefaultResource(R.drawable.transparent_bg);
        this.l = (TextView) this.f17030b.findViewById(R.id.user_name_text_view);
        HeadImageView headImageView = (HeadImageView) this.f17030b.findViewById(R.id.user_head_view);
        this.k = headImageView;
        headImageView.setIsRound(true);
        this.k.setDrawBorder(false);
        this.n = (UserIconBox) this.f17030b.findViewById(R.id.card_user_icon_box);
        this.m = (TbImageView) this.f17030b.findViewById(R.id.user_vip_image_view);
        this.o = this.f17030b.findViewById(R.id.divider_view);
        this.f17035g = (TextView) this.f17030b.findViewById(R.id.card_name_text_view);
        this.f17037i = (TextView) this.f17030b.findViewById(R.id.card_description_text_view);
        this.f17038j = (TextView) this.f17030b.findViewById(R.id.card_use_button);
        TbImageView tbImageView2 = (TbImageView) this.f17030b.findViewById(R.id.card_vip_image_view);
        this.f17036h = tbImageView2;
        tbImageView2.setDefaultResource(R.drawable.transparent_bg);
        this.f17036h.setDefaultBgResource(R.drawable.transparent_bg);
        this.f17038j.setOnClickListener(this.r);
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.getLayoutMode().k(TbadkApplication.getInst().getSkinType() == 1);
            this.a.getLayoutMode().j(this.f17030b);
            NavigationBar navigationBar = this.f17032d;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.a.getPageContext(), TbadkApplication.getInst().getSkinType());
            }
            NoNetworkView noNetworkView = this.f17033e;
            if (noNetworkView != null) {
                noNetworkView.onChangeSkinType(this.a.getPageContext(), TbadkApplication.getInst().getSkinType());
            }
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f17031c.setVisibility(0);
            this.p.setVisibility(0);
            this.f17034f.setVisibility(0);
            this.o.setVisibility(0);
            this.f17035g.setVisibility(0);
            this.f17037i.setVisibility(0);
            this.f17036h.setVisibility(0);
            this.f17038j.setVisibility(0);
            this.a.hideNetRefreshView(this.f17030b);
        }
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f17030b : (View) invokeV.objValue;
    }

    public View d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f17038j : (View) invokeV.objValue;
    }

    public final void e() {
        c.a.r0.d4.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (aVar = this.q) == null) {
            return;
        }
        this.f17035g.setText(aVar.j());
        this.f17037i.setText(this.q.d());
        this.f17036h.startLoad(this.q.i(), 10, false);
    }

    public final void f() {
        String str;
        String str2;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.q == null) {
            return;
        }
        if (!TbadkCoreApplication.isLogin()) {
            this.n.setVisibility(8);
            this.m.setVisibility(8);
            this.l.setPadding(this.u, 0, 0, 0);
            SkinManager.setViewTextColor(this.l, R.color.CAM_X0308, 1);
            this.l.setText(R.string.default_user_name);
        } else {
            AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
            String str3 = null;
            if (currentAccountInfo != null) {
                String portrait = currentAccountInfo.getPortrait();
                str = currentAccountInfo.getAccountNameShow();
                String memberIconUrl = currentAccountInfo.getMemberIconUrl();
                i2 = currentAccountInfo.getMemberType();
                str2 = portrait;
                str3 = memberIconUrl;
            } else {
                str = null;
                str2 = null;
                i2 = 0;
            }
            if (i2 > 0) {
                SkinManager.setViewTextColor(this.l, R.color.CAM_X0308, 1);
            } else {
                SkinManager.setViewTextColor(this.l, R.color.CAM_X0108, 1);
            }
            if (StringUtils.isNull(str3)) {
                this.m.setVisibility(8);
                this.l.setPadding(this.u, 0, 0, 0);
                this.l.setText(str);
            } else {
                this.m.setVisibility(0);
                this.m.startLoad(str3, 10, false);
                this.l.setPadding(this.s, 0, 0, 0);
                this.l.setText(str);
            }
            this.n.setVisibility(0);
            int size = (currentAccountInfo == null || currentAccountInfo.getUserIcons() == null) ? 0 : currentAccountInfo.getUserIcons().size();
            int i4 = (size < 8 && (i3 = size - 1) < 4) ? i3 : 4;
            if (currentAccountInfo != null) {
                UserIconBox userIconBox = this.n;
                List<IconData> userIcons = currentAccountInfo.getUserIcons();
                int i5 = this.v;
                userIconBox.loadIcon(userIcons, i4, i5, i5, this.t, true);
            }
            this.k.startLoad(str2, 12, false);
        }
        this.f17034f.startLoad(this.q.e(), 10, false);
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f17031c.setVisibility(8);
            this.f17034f.setVisibility(8);
            this.o.setVisibility(8);
            this.p.setVisibility(8);
            this.f17035g.setVisibility(8);
            this.f17037i.setVisibility(8);
            this.f17036h.setVisibility(8);
            this.f17038j.setVisibility(8);
            this.a.showNetRefreshView(this.f17030b, this.a.getPageContext().getResources().getString(R.string.no_data_text), true);
        }
    }

    public void h(int i2, c.a.r0.d4.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048583, this, i2, aVar) == null) {
            if (aVar == null) {
                g();
            } else if (i2 != 0) {
            } else {
                this.q = aVar;
                b();
                f();
                e();
                i(aVar);
            }
        }
    }

    public void i(c.a.r0.d4.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) || aVar == null) {
            return;
        }
        this.q = aVar;
        if (aVar == null) {
            this.f17038j.setVisibility(8);
            return;
        }
        int f2 = aVar.f();
        this.f17038j.setVisibility(0);
        if (this.q.g() == 1) {
            SkinManager.setViewTextColor(this.f17038j, R.color.CAM_X0105, 1);
            SkinManager.setBackgroundResource(this.f17038j, R.drawable.gray_btn_selector);
            this.f17038j.setText(R.string.do_not_use);
        } else if (this.q.c() == 1) {
            SkinManager.setViewTextColor(this.f17038j, R.color.CAM_X0105, 1);
            SkinManager.setBackgroundResource(this.f17038j, R.drawable.gray_btn_selector);
            this.f17038j.setText(R.string.use_immediately);
        } else if (f2 == 0) {
            SkinManager.setViewTextColor(this.f17038j, R.color.CAM_X0105, 1);
            SkinManager.setBackgroundResource(this.f17038j, R.drawable.gray_btn_selector);
            this.f17038j.setText(R.string.use_freely);
        } else if (f2 == 100) {
            SkinManager.setViewTextColor(this.f17038j, R.color.CAM_X0101, 1);
            SkinManager.setBackgroundResource(this.f17038j, R.drawable.btn_all_blue);
            if (this.q.h() == 0) {
                this.f17038j.setText(R.string.activity_free_use);
            } else {
                this.f17038j.setText(R.string.use_immediately);
            }
        } else if (f2 == 101) {
            SkinManager.setViewTextColor(this.f17038j, R.color.CAM_X0101, 1);
            SkinManager.setBackgroundResource(this.f17038j, R.drawable.orange_btn_selector);
            this.f17038j.setText(R.string.become_annual_free_use);
        } else if (f2 > 1) {
            SkinManager.setViewTextColor(this.f17038j, R.color.CAM_X0101, 1);
            SkinManager.setBackgroundResource(this.f17038j, R.drawable.orange_btn_selector);
            this.f17038j.setText(String.format(this.a.getPageContext().getString(R.string.become_vip_free_use), Integer.valueOf(f2)));
        } else {
            SkinManager.setViewTextColor(this.f17038j, R.color.CAM_X0101, 1);
            SkinManager.setBackgroundResource(this.f17038j, R.drawable.orange_btn_selector);
            this.f17038j.setText(R.string.become_member_free_use);
        }
    }
}
