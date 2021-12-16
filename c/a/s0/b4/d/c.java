package c.a.s0.b4.d;

import android.view.View;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.a.f;
import c.a.d.f.p.m;
import c.a.s0.b4.h.e;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import com.baidu.tieba.themeCenter.MemberRecommendView;
import com.baidu.tieba.themeCenter.avatarPendant.AvatarPendantActivity;
import com.baidu.tieba.themeCenter.background.DressItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes7.dex */
public class c extends c.a.d.a.d<AvatarPendantActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public d a;

    /* renamed from: b  reason: collision with root package name */
    public BdListView f15144b;

    /* renamed from: c  reason: collision with root package name */
    public NoNetworkView f15145c;

    /* renamed from: d  reason: collision with root package name */
    public MemberRecommendView f15146d;

    /* renamed from: e  reason: collision with root package name */
    public NavigationBar f15147e;

    /* renamed from: f  reason: collision with root package name */
    public int f15148f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f15149g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f15150h;

    /* renamed from: i  reason: collision with root package name */
    public AvatarPendantActivity f15151i;

    /* renamed from: j  reason: collision with root package name */
    public View f15152j;

    /* renamed from: k  reason: collision with root package name */
    public TextView f15153k;

    /* loaded from: classes7.dex */
    public interface a {
        void onItemClick(DressItemData dressItemData);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(AvatarPendantActivity avatarPendantActivity) {
        super(avatarPendantActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {avatarPendantActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f15148f = 0;
        this.f15151i = avatarPendantActivity;
        avatarPendantActivity.setContentView(R.layout.avatar_pendant_activity_layout);
        this.f15152j = avatarPendantActivity.findViewById(R.id.root_view);
        this.f15148f = m.f(avatarPendantActivity.getPageContext().getPageActivity(), R.dimen.ds320);
        this.f15144b = (BdListView) avatarPendantActivity.findViewById(R.id.avatar_pedant_listview);
        this.f15145c = (NoNetworkView) avatarPendantActivity.findViewById(R.id.view_no_network);
        NavigationBar navigationBar = (NavigationBar) avatarPendantActivity.findViewById(R.id.view_navigation_bar);
        this.f15147e = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f15147e.setTitleText(R.string.avatar_pendant);
        MemberRecommendView memberRecommendView = (MemberRecommendView) avatarPendantActivity.findViewById(R.id.avatar_pendant_theme_recommend);
        this.f15146d = memberRecommendView;
        memberRecommendView.setFromType(8);
        this.f15146d.getButton().setOnClickListener(avatarPendantActivity);
        TextView textView = new TextView(avatarPendantActivity.getActivity());
        this.f15149g = textView;
        textView.setHeight(m.f(avatarPendantActivity.getActivity(), R.dimen.ds104));
        this.f15153k = new TextView(avatarPendantActivity.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + m.f(avatarPendantActivity.getActivity(), R.dimen.ds98));
        TextView textView2 = new TextView(avatarPendantActivity.getActivity());
        this.f15150h = textView2;
        textView2.setHeight(m.f(avatarPendantActivity.getActivity(), R.dimen.ds50));
        this.f15153k.setLayoutParams(layoutParams);
        this.f15144b.addHeaderView(this.f15153k, 0);
        this.f15144b.addFooterView(this.f15150h);
        d dVar = new d(avatarPendantActivity);
        this.a = dVar;
        this.f15144b.setAdapter((ListAdapter) dVar);
    }

    public void c(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.f15145c.addNetworkChangeListener(bVar);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f15151i.hideNetRefreshView(this.f15152j);
            this.f15144b.setVisibility(0);
        }
    }

    public MemberRecommendView e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f15146d : (MemberRecommendView) invokeV.objValue;
    }

    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f15152j : (View) invokeV.objValue;
    }

    public TextView g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f15153k : (TextView) invokeV.objValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f15144b.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0201));
            this.a.notifyDataSetChanged();
            this.f15147e.onChangeSkinType(this.f15151i.getPageContext(), TbadkApplication.getInst().getSkinType());
            this.f15145c.onChangeSkinType(this.f15151i.getPageContext(), TbadkApplication.getInst().getSkinType());
            this.f15146d.changeSkinType();
            SkinManager.setBackgroundColor(this.f15149g, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.f15150h, R.color.CAM_X0201);
        }
    }

    public void i(List<c.a.s0.b4.d.a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, list) == null) {
            if (list != null && list.size() > 0) {
                this.f15144b.setVisibility(0);
                this.a.c(list);
                this.a.notifyDataSetChanged();
                return;
            }
            this.f15144b.setVisibility(8);
        }
    }

    public final boolean j(e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, eVar)) == null) {
            if (eVar != null && !StringUtils.isNull(eVar.c())) {
                this.f15146d.setVisibility(0);
                this.f15146d.fillView(eVar);
                return true;
            }
            this.f15146d.setVisibility(8);
            return false;
        }
        return invokeL.booleanValue;
    }

    public void k(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) {
            this.a.b(aVar);
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f15144b.setVisibility(8);
            String string = this.f15151i.getPageContext().getResources().getString(R.string.no_data_text);
            this.f15151i.setNetRefreshViewTopMargin(this.f15148f);
            this.f15151i.showNetRefreshView(this.f15152j, string, false);
        }
    }

    public void m(e eVar, List<c.a.s0.b4.d.a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, eVar, list) == null) {
            if ((eVar != null && !StringUtils.isNull(eVar.c())) || (list != null && list.size() > 0)) {
                d();
                if (j(eVar)) {
                    this.f15144b.removeHeaderView(this.f15149g);
                    this.f15144b.addHeaderView(this.f15149g);
                } else {
                    this.f15144b.removeHeaderView(this.f15149g);
                }
                i(list);
                return;
            }
            l();
        }
    }
}
