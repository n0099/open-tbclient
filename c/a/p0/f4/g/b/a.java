package c.a.p0.f4.g.b;

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
    public View f15101b;

    /* renamed from: c  reason: collision with root package name */
    public View f15102c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f15103d;

    /* renamed from: e  reason: collision with root package name */
    public NoNetworkView f15104e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f15105f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f15106g;

    /* renamed from: h  reason: collision with root package name */
    public TbImageView f15107h;
    public TextView i;
    public TextView j;
    public HeadImageView k;
    public TextView l;
    public TbImageView m;
    public UserIconBox n;
    public View o;
    public View p;
    public c.a.p0.f4.a q;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
        View inflate = LayoutInflater.from(personalCardDetailActivity.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d06de, (ViewGroup) null);
        this.f15101b = inflate;
        this.a.setContentView(inflate);
        this.a.setNetRefreshViewTopMargin(BdListViewHelper.a);
        this.s = n.f(this.a.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f070224);
        this.t = n.f(this.a.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f070229);
        this.u = n.f(this.a.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f0701be);
        this.v = n.f(this.a.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f070201);
        this.r = onClickListener;
        NavigationBar navigationBar = (NavigationBar) this.f15101b.findViewById(R.id.obfuscated_res_0x7f0923cf);
        this.f15103d = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f15103d.setTitleText(R.string.obfuscated_res_0x7f0f0e36);
        this.f15104e = (NoNetworkView) this.f15101b.findViewById(R.id.obfuscated_res_0x7f0923d1);
        this.f15102c = this.f15101b.findViewById(R.id.obfuscated_res_0x7f0906e9);
        this.p = this.f15101b.findViewById(R.id.obfuscated_res_0x7f0920b3);
        TbImageView tbImageView = (TbImageView) this.f15101b.findViewById(R.id.obfuscated_res_0x7f090548);
        this.f15105f = tbImageView;
        tbImageView.setDefaultBgResource(R.drawable.obfuscated_res_0x7f081200);
        this.f15105f.setDefaultResource(R.drawable.obfuscated_res_0x7f081200);
        this.l = (TextView) this.f15101b.findViewById(R.id.obfuscated_res_0x7f0922c0);
        HeadImageView headImageView = (HeadImageView) this.f15101b.findViewById(R.id.obfuscated_res_0x7f0922a7);
        this.k = headImageView;
        headImageView.setIsRound(true);
        this.k.setDrawBorder(false);
        this.n = (UserIconBox) this.f15101b.findViewById(R.id.obfuscated_res_0x7f09058a);
        this.m = (TbImageView) this.f15101b.findViewById(R.id.obfuscated_res_0x7f0922e1);
        this.o = this.f15101b.findViewById(R.id.obfuscated_res_0x7f090809);
        this.f15106g = (TextView) this.f15101b.findViewById(R.id.obfuscated_res_0x7f09055a);
        this.i = (TextView) this.f15101b.findViewById(R.id.obfuscated_res_0x7f0904f3);
        this.j = (TextView) this.f15101b.findViewById(R.id.obfuscated_res_0x7f090589);
        TbImageView tbImageView2 = (TbImageView) this.f15101b.findViewById(R.id.obfuscated_res_0x7f09058b);
        this.f15107h = tbImageView2;
        tbImageView2.setDefaultResource(R.drawable.obfuscated_res_0x7f081200);
        this.f15107h.setDefaultBgResource(R.drawable.obfuscated_res_0x7f081200);
        this.j.setOnClickListener(this.r);
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.getLayoutMode().k(TbadkApplication.getInst().getSkinType() == 1);
            this.a.getLayoutMode().j(this.f15101b);
            NavigationBar navigationBar = this.f15103d;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.a.getPageContext(), TbadkApplication.getInst().getSkinType());
            }
            NoNetworkView noNetworkView = this.f15104e;
            if (noNetworkView != null) {
                noNetworkView.c(this.a.getPageContext(), TbadkApplication.getInst().getSkinType());
            }
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f15102c.setVisibility(0);
            this.p.setVisibility(0);
            this.f15105f.setVisibility(0);
            this.o.setVisibility(0);
            this.f15106g.setVisibility(0);
            this.i.setVisibility(0);
            this.f15107h.setVisibility(0);
            this.j.setVisibility(0);
            this.a.hideNetRefreshView(this.f15101b);
        }
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f15101b : (View) invokeV.objValue;
    }

    public View d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.j : (View) invokeV.objValue;
    }

    public final void e() {
        c.a.p0.f4.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (aVar = this.q) == null) {
            return;
        }
        this.f15106g.setText(aVar.j());
        this.i.setText(this.q.d());
        this.f15107h.J(this.q.i(), 10, false);
    }

    public final void f() {
        String str;
        String str2;
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.q == null) {
            return;
        }
        if (!TbadkCoreApplication.isLogin()) {
            this.n.setVisibility(8);
            this.m.setVisibility(8);
            this.l.setPadding(this.u, 0, 0, 0);
            SkinManager.setViewTextColor(this.l, R.color.CAM_X0308, 1);
            this.l.setText(R.string.obfuscated_res_0x7f0f0480);
        } else {
            AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
            String str3 = null;
            if (currentAccountInfo != null) {
                String portrait = currentAccountInfo.getPortrait();
                str = currentAccountInfo.getAccountNameShow();
                String memberIconUrl = currentAccountInfo.getMemberIconUrl();
                i = currentAccountInfo.getMemberType();
                str2 = portrait;
                str3 = memberIconUrl;
            } else {
                str = null;
                str2 = null;
                i = 0;
            }
            if (i > 0) {
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
                this.m.J(str3, 10, false);
                this.l.setPadding(this.s, 0, 0, 0);
                this.l.setText(str);
            }
            this.n.setVisibility(0);
            int size = (currentAccountInfo == null || currentAccountInfo.getUserIcons() == null) ? 0 : currentAccountInfo.getUserIcons().size();
            int i3 = (size < 8 && (i2 = size - 1) < 4) ? i2 : 4;
            if (currentAccountInfo != null) {
                UserIconBox userIconBox = this.n;
                List<IconData> userIcons = currentAccountInfo.getUserIcons();
                int i4 = this.v;
                userIconBox.h(userIcons, i3, i4, i4, this.t, true);
            }
            this.k.J(str2, 12, false);
        }
        this.f15105f.J(this.q.e(), 10, false);
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f15102c.setVisibility(8);
            this.f15105f.setVisibility(8);
            this.o.setVisibility(8);
            this.p.setVisibility(8);
            this.f15106g.setVisibility(8);
            this.i.setVisibility(8);
            this.f15107h.setVisibility(8);
            this.j.setVisibility(8);
            this.a.showNetRefreshView(this.f15101b, this.a.getPageContext().getResources().getString(R.string.obfuscated_res_0x7f0f0c2d), true);
        }
    }

    public void h(int i, c.a.p0.f4.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048583, this, i, aVar) == null) {
            if (aVar == null) {
                g();
            } else if (i != 0) {
            } else {
                this.q = aVar;
                b();
                f();
                e();
                i(aVar);
            }
        }
    }

    public void i(c.a.p0.f4.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) || aVar == null) {
            return;
        }
        this.q = aVar;
        if (aVar == null) {
            this.j.setVisibility(8);
            return;
        }
        int f2 = aVar.f();
        this.j.setVisibility(0);
        if (this.q.g() == 1) {
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0105, 1);
            SkinManager.setBackgroundResource(this.j, R.drawable.gray_btn_selector);
            this.j.setText(R.string.obfuscated_res_0x7f0f04df);
        } else if (this.q.c() == 1) {
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0105, 1);
            SkinManager.setBackgroundResource(this.j, R.drawable.gray_btn_selector);
            this.j.setText(R.string.obfuscated_res_0x7f0f149c);
        } else if (f2 == 0) {
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0105, 1);
            SkinManager.setBackgroundResource(this.j, R.drawable.gray_btn_selector);
            this.j.setText(R.string.obfuscated_res_0x7f0f149b);
        } else if (f2 == 100) {
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0101, 1);
            SkinManager.setBackgroundResource(this.j, R.drawable.btn_all_blue);
            if (this.q.h() == 0) {
                this.j.setText(R.string.obfuscated_res_0x7f0f008a);
            } else {
                this.j.setText(R.string.obfuscated_res_0x7f0f149c);
            }
        } else if (f2 == 101) {
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0101, 1);
            SkinManager.setBackgroundResource(this.j, R.drawable.orange_btn_selector);
            this.j.setText(R.string.obfuscated_res_0x7f0f02f4);
        } else if (f2 > 1) {
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0101, 1);
            SkinManager.setBackgroundResource(this.j, R.drawable.orange_btn_selector);
            this.j.setText(String.format(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f02fa), Integer.valueOf(f2)));
        } else {
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0101, 1);
            SkinManager.setBackgroundResource(this.j, R.drawable.orange_btn_selector);
            this.j.setText(R.string.obfuscated_res_0x7f0f02f7);
        }
    }
}
