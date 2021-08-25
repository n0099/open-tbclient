package c.a.q0.o3.d;

import android.view.View;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.e.a.f;
import c.a.e.e.p.l;
import c.a.q0.o3.h.e;
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
    public d f23288a;

    /* renamed from: b  reason: collision with root package name */
    public BdListView f23289b;

    /* renamed from: c  reason: collision with root package name */
    public NoNetworkView f23290c;

    /* renamed from: d  reason: collision with root package name */
    public MemberRecommendView f23291d;

    /* renamed from: e  reason: collision with root package name */
    public NavigationBar f23292e;

    /* renamed from: f  reason: collision with root package name */
    public int f23293f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f23294g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f23295h;

    /* renamed from: i  reason: collision with root package name */
    public AvatarPendantActivity f23296i;

    /* renamed from: j  reason: collision with root package name */
    public View f23297j;
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
        this.f23293f = 0;
        this.f23296i = avatarPendantActivity;
        avatarPendantActivity.setContentView(R.layout.avatar_pendant_activity_layout);
        this.f23297j = avatarPendantActivity.findViewById(R.id.root_view);
        this.f23293f = l.g(avatarPendantActivity.getPageContext().getPageActivity(), R.dimen.ds320);
        this.f23289b = (BdListView) avatarPendantActivity.findViewById(R.id.avatar_pedant_listview);
        this.f23290c = (NoNetworkView) avatarPendantActivity.findViewById(R.id.view_no_network);
        NavigationBar navigationBar = (NavigationBar) avatarPendantActivity.findViewById(R.id.view_navigation_bar);
        this.f23292e = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f23292e.setTitleText(R.string.avatar_pendant);
        MemberRecommendView memberRecommendView = (MemberRecommendView) avatarPendantActivity.findViewById(R.id.avatar_pendant_theme_recommend);
        this.f23291d = memberRecommendView;
        memberRecommendView.setFromType(8);
        this.f23291d.getButton().setOnClickListener(avatarPendantActivity);
        TextView textView = new TextView(avatarPendantActivity.getActivity());
        this.f23294g = textView;
        textView.setHeight(l.g(avatarPendantActivity.getActivity(), R.dimen.ds104));
        this.k = new TextView(avatarPendantActivity.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.g(avatarPendantActivity.getActivity(), R.dimen.ds98));
        TextView textView2 = new TextView(avatarPendantActivity.getActivity());
        this.f23295h = textView2;
        textView2.setHeight(l.g(avatarPendantActivity.getActivity(), R.dimen.ds50));
        this.k.setLayoutParams(layoutParams);
        this.f23289b.addHeaderView(this.k, 0);
        this.f23289b.addFooterView(this.f23295h);
        d dVar = new d(avatarPendantActivity);
        this.f23288a = dVar;
        this.f23289b.setAdapter((ListAdapter) dVar);
    }

    public void c(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.f23290c.addNetworkChangeListener(bVar);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f23296i.hideNetRefreshView(this.f23297j);
            this.f23289b.setVisibility(0);
        }
    }

    public MemberRecommendView e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f23291d : (MemberRecommendView) invokeV.objValue;
    }

    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f23297j : (View) invokeV.objValue;
    }

    public TextView g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.k : (TextView) invokeV.objValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f23289b.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0201));
            this.f23288a.notifyDataSetChanged();
            this.f23292e.onChangeSkinType(this.f23296i.getPageContext(), TbadkApplication.getInst().getSkinType());
            this.f23290c.onChangeSkinType(this.f23296i.getPageContext(), TbadkApplication.getInst().getSkinType());
            this.f23291d.changeSkinType();
            SkinManager.setBackgroundColor(this.f23294g, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.f23295h, R.color.CAM_X0201);
        }
    }

    public void i(List<c.a.q0.o3.d.a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, list) == null) {
            if (list != null && list.size() > 0) {
                this.f23289b.setVisibility(0);
                this.f23288a.c(list);
                this.f23288a.notifyDataSetChanged();
                return;
            }
            this.f23289b.setVisibility(8);
        }
    }

    public final boolean j(e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, eVar)) == null) {
            if (eVar != null && !StringUtils.isNull(eVar.c())) {
                this.f23291d.setVisibility(0);
                this.f23291d.fillView(eVar);
                return true;
            }
            this.f23291d.setVisibility(8);
            return false;
        }
        return invokeL.booleanValue;
    }

    public void k(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) {
            this.f23288a.b(aVar);
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f23289b.setVisibility(8);
            String string = this.f23296i.getPageContext().getResources().getString(R.string.no_data_text);
            this.f23296i.setNetRefreshViewTopMargin(this.f23293f);
            this.f23296i.showNetRefreshView(this.f23297j, string, false);
        }
    }

    public void m(e eVar, List<c.a.q0.o3.d.a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, eVar, list) == null) {
            if ((eVar != null && !StringUtils.isNull(eVar.c())) || (list != null && list.size() > 0)) {
                d();
                if (j(eVar)) {
                    this.f23289b.removeHeaderView(this.f23294g);
                    this.f23289b.addHeaderView(this.f23294g);
                } else {
                    this.f23289b.removeHeaderView(this.f23294g);
                }
                i(list);
                return;
            }
            l();
        }
    }
}
