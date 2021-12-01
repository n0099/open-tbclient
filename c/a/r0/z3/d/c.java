package c.a.r0.z3.d;

import android.view.View;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.a.f;
import c.a.d.f.p.l;
import c.a.r0.z3.h.e;
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
    public BdListView f25912b;

    /* renamed from: c  reason: collision with root package name */
    public NoNetworkView f25913c;

    /* renamed from: d  reason: collision with root package name */
    public MemberRecommendView f25914d;

    /* renamed from: e  reason: collision with root package name */
    public NavigationBar f25915e;

    /* renamed from: f  reason: collision with root package name */
    public int f25916f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f25917g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f25918h;

    /* renamed from: i  reason: collision with root package name */
    public AvatarPendantActivity f25919i;

    /* renamed from: j  reason: collision with root package name */
    public View f25920j;

    /* renamed from: k  reason: collision with root package name */
    public TextView f25921k;

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
        this.f25916f = 0;
        this.f25919i = avatarPendantActivity;
        avatarPendantActivity.setContentView(R.layout.avatar_pendant_activity_layout);
        this.f25920j = avatarPendantActivity.findViewById(R.id.root_view);
        this.f25916f = l.f(avatarPendantActivity.getPageContext().getPageActivity(), R.dimen.ds320);
        this.f25912b = (BdListView) avatarPendantActivity.findViewById(R.id.avatar_pedant_listview);
        this.f25913c = (NoNetworkView) avatarPendantActivity.findViewById(R.id.view_no_network);
        NavigationBar navigationBar = (NavigationBar) avatarPendantActivity.findViewById(R.id.view_navigation_bar);
        this.f25915e = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f25915e.setTitleText(R.string.avatar_pendant);
        MemberRecommendView memberRecommendView = (MemberRecommendView) avatarPendantActivity.findViewById(R.id.avatar_pendant_theme_recommend);
        this.f25914d = memberRecommendView;
        memberRecommendView.setFromType(8);
        this.f25914d.getButton().setOnClickListener(avatarPendantActivity);
        TextView textView = new TextView(avatarPendantActivity.getActivity());
        this.f25917g = textView;
        textView.setHeight(l.f(avatarPendantActivity.getActivity(), R.dimen.ds104));
        this.f25921k = new TextView(avatarPendantActivity.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.f(avatarPendantActivity.getActivity(), R.dimen.ds98));
        TextView textView2 = new TextView(avatarPendantActivity.getActivity());
        this.f25918h = textView2;
        textView2.setHeight(l.f(avatarPendantActivity.getActivity(), R.dimen.ds50));
        this.f25921k.setLayoutParams(layoutParams);
        this.f25912b.addHeaderView(this.f25921k, 0);
        this.f25912b.addFooterView(this.f25918h);
        d dVar = new d(avatarPendantActivity);
        this.a = dVar;
        this.f25912b.setAdapter((ListAdapter) dVar);
    }

    public void c(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.f25913c.addNetworkChangeListener(bVar);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f25919i.hideNetRefreshView(this.f25920j);
            this.f25912b.setVisibility(0);
        }
    }

    public MemberRecommendView e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f25914d : (MemberRecommendView) invokeV.objValue;
    }

    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f25920j : (View) invokeV.objValue;
    }

    public TextView g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f25921k : (TextView) invokeV.objValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f25912b.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0201));
            this.a.notifyDataSetChanged();
            this.f25915e.onChangeSkinType(this.f25919i.getPageContext(), TbadkApplication.getInst().getSkinType());
            this.f25913c.onChangeSkinType(this.f25919i.getPageContext(), TbadkApplication.getInst().getSkinType());
            this.f25914d.changeSkinType();
            SkinManager.setBackgroundColor(this.f25917g, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.f25918h, R.color.CAM_X0201);
        }
    }

    public void i(List<c.a.r0.z3.d.a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, list) == null) {
            if (list != null && list.size() > 0) {
                this.f25912b.setVisibility(0);
                this.a.c(list);
                this.a.notifyDataSetChanged();
                return;
            }
            this.f25912b.setVisibility(8);
        }
    }

    public final boolean j(e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, eVar)) == null) {
            if (eVar != null && !StringUtils.isNull(eVar.c())) {
                this.f25914d.setVisibility(0);
                this.f25914d.fillView(eVar);
                return true;
            }
            this.f25914d.setVisibility(8);
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
            this.f25912b.setVisibility(8);
            String string = this.f25919i.getPageContext().getResources().getString(R.string.no_data_text);
            this.f25919i.setNetRefreshViewTopMargin(this.f25916f);
            this.f25919i.showNetRefreshView(this.f25920j, string, false);
        }
    }

    public void m(e eVar, List<c.a.r0.z3.d.a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, eVar, list) == null) {
            if ((eVar != null && !StringUtils.isNull(eVar.c())) || (list != null && list.size() > 0)) {
                d();
                if (j(eVar)) {
                    this.f25912b.removeHeaderView(this.f25917g);
                    this.f25912b.addHeaderView(this.f25917g);
                } else {
                    this.f25912b.removeHeaderView(this.f25917g);
                }
                i(list);
                return;
            }
            l();
        }
    }
}
