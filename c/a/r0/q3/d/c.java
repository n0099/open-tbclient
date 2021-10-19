package c.a.r0.q3.d;

import android.view.View;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.e.a.f;
import c.a.e.e.p.l;
import c.a.r0.q3.h.e;
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
/* loaded from: classes3.dex */
public class c extends c.a.e.a.d<AvatarPendantActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d f24069a;

    /* renamed from: b  reason: collision with root package name */
    public BdListView f24070b;

    /* renamed from: c  reason: collision with root package name */
    public NoNetworkView f24071c;

    /* renamed from: d  reason: collision with root package name */
    public MemberRecommendView f24072d;

    /* renamed from: e  reason: collision with root package name */
    public NavigationBar f24073e;

    /* renamed from: f  reason: collision with root package name */
    public int f24074f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f24075g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f24076h;

    /* renamed from: i  reason: collision with root package name */
    public AvatarPendantActivity f24077i;

    /* renamed from: j  reason: collision with root package name */
    public View f24078j;
    public TextView k;

    /* loaded from: classes3.dex */
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
        this.f24074f = 0;
        this.f24077i = avatarPendantActivity;
        avatarPendantActivity.setContentView(R.layout.avatar_pendant_activity_layout);
        this.f24078j = avatarPendantActivity.findViewById(R.id.root_view);
        this.f24074f = l.g(avatarPendantActivity.getPageContext().getPageActivity(), R.dimen.ds320);
        this.f24070b = (BdListView) avatarPendantActivity.findViewById(R.id.avatar_pedant_listview);
        this.f24071c = (NoNetworkView) avatarPendantActivity.findViewById(R.id.view_no_network);
        NavigationBar navigationBar = (NavigationBar) avatarPendantActivity.findViewById(R.id.view_navigation_bar);
        this.f24073e = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f24073e.setTitleText(R.string.avatar_pendant);
        MemberRecommendView memberRecommendView = (MemberRecommendView) avatarPendantActivity.findViewById(R.id.avatar_pendant_theme_recommend);
        this.f24072d = memberRecommendView;
        memberRecommendView.setFromType(8);
        this.f24072d.getButton().setOnClickListener(avatarPendantActivity);
        TextView textView = new TextView(avatarPendantActivity.getActivity());
        this.f24075g = textView;
        textView.setHeight(l.g(avatarPendantActivity.getActivity(), R.dimen.ds104));
        this.k = new TextView(avatarPendantActivity.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.g(avatarPendantActivity.getActivity(), R.dimen.ds98));
        TextView textView2 = new TextView(avatarPendantActivity.getActivity());
        this.f24076h = textView2;
        textView2.setHeight(l.g(avatarPendantActivity.getActivity(), R.dimen.ds50));
        this.k.setLayoutParams(layoutParams);
        this.f24070b.addHeaderView(this.k, 0);
        this.f24070b.addFooterView(this.f24076h);
        d dVar = new d(avatarPendantActivity);
        this.f24069a = dVar;
        this.f24070b.setAdapter((ListAdapter) dVar);
    }

    public void c(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.f24071c.addNetworkChangeListener(bVar);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f24077i.hideNetRefreshView(this.f24078j);
            this.f24070b.setVisibility(0);
        }
    }

    public MemberRecommendView e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f24072d : (MemberRecommendView) invokeV.objValue;
    }

    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f24078j : (View) invokeV.objValue;
    }

    public TextView g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.k : (TextView) invokeV.objValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f24070b.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0201));
            this.f24069a.notifyDataSetChanged();
            this.f24073e.onChangeSkinType(this.f24077i.getPageContext(), TbadkApplication.getInst().getSkinType());
            this.f24071c.onChangeSkinType(this.f24077i.getPageContext(), TbadkApplication.getInst().getSkinType());
            this.f24072d.changeSkinType();
            SkinManager.setBackgroundColor(this.f24075g, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.f24076h, R.color.CAM_X0201);
        }
    }

    public void i(List<c.a.r0.q3.d.a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, list) == null) {
            if (list != null && list.size() > 0) {
                this.f24070b.setVisibility(0);
                this.f24069a.c(list);
                this.f24069a.notifyDataSetChanged();
                return;
            }
            this.f24070b.setVisibility(8);
        }
    }

    public final boolean j(e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, eVar)) == null) {
            if (eVar != null && !StringUtils.isNull(eVar.c())) {
                this.f24072d.setVisibility(0);
                this.f24072d.fillView(eVar);
                return true;
            }
            this.f24072d.setVisibility(8);
            return false;
        }
        return invokeL.booleanValue;
    }

    public void k(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) {
            this.f24069a.b(aVar);
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f24070b.setVisibility(8);
            String string = this.f24077i.getPageContext().getResources().getString(R.string.no_data_text);
            this.f24077i.setNetRefreshViewTopMargin(this.f24074f);
            this.f24077i.showNetRefreshView(this.f24078j, string, false);
        }
    }

    public void m(e eVar, List<c.a.r0.q3.d.a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, eVar, list) == null) {
            if ((eVar != null && !StringUtils.isNull(eVar.c())) || (list != null && list.size() > 0)) {
                d();
                if (j(eVar)) {
                    this.f24070b.removeHeaderView(this.f24075g);
                    this.f24070b.addHeaderView(this.f24075g);
                } else {
                    this.f24070b.removeHeaderView(this.f24075g);
                }
                i(list);
                return;
            }
            l();
        }
    }
}
