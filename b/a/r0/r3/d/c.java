package b.a.r0.r3.d;

import android.view.View;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import b.a.e.a.f;
import b.a.e.e.p.l;
import b.a.r0.r3.h.e;
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
/* loaded from: classes5.dex */
public class c extends b.a.e.a.d<AvatarPendantActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d f23088a;

    /* renamed from: b  reason: collision with root package name */
    public BdListView f23089b;

    /* renamed from: c  reason: collision with root package name */
    public NoNetworkView f23090c;

    /* renamed from: d  reason: collision with root package name */
    public MemberRecommendView f23091d;

    /* renamed from: e  reason: collision with root package name */
    public NavigationBar f23092e;

    /* renamed from: f  reason: collision with root package name */
    public int f23093f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f23094g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f23095h;

    /* renamed from: i  reason: collision with root package name */
    public AvatarPendantActivity f23096i;
    public View j;
    public TextView k;

    /* loaded from: classes5.dex */
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
        this.f23093f = 0;
        this.f23096i = avatarPendantActivity;
        avatarPendantActivity.setContentView(R.layout.avatar_pendant_activity_layout);
        this.j = avatarPendantActivity.findViewById(R.id.root_view);
        this.f23093f = l.g(avatarPendantActivity.getPageContext().getPageActivity(), R.dimen.ds320);
        this.f23089b = (BdListView) avatarPendantActivity.findViewById(R.id.avatar_pedant_listview);
        this.f23090c = (NoNetworkView) avatarPendantActivity.findViewById(R.id.view_no_network);
        NavigationBar navigationBar = (NavigationBar) avatarPendantActivity.findViewById(R.id.view_navigation_bar);
        this.f23092e = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f23092e.setTitleText(R.string.avatar_pendant);
        MemberRecommendView memberRecommendView = (MemberRecommendView) avatarPendantActivity.findViewById(R.id.avatar_pendant_theme_recommend);
        this.f23091d = memberRecommendView;
        memberRecommendView.setFromType(8);
        this.f23091d.getButton().setOnClickListener(avatarPendantActivity);
        TextView textView = new TextView(avatarPendantActivity.getActivity());
        this.f23094g = textView;
        textView.setHeight(l.g(avatarPendantActivity.getActivity(), R.dimen.ds104));
        this.k = new TextView(avatarPendantActivity.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.g(avatarPendantActivity.getActivity(), R.dimen.ds98));
        TextView textView2 = new TextView(avatarPendantActivity.getActivity());
        this.f23095h = textView2;
        textView2.setHeight(l.g(avatarPendantActivity.getActivity(), R.dimen.ds50));
        this.k.setLayoutParams(layoutParams);
        this.f23089b.addHeaderView(this.k, 0);
        this.f23089b.addFooterView(this.f23095h);
        d dVar = new d(avatarPendantActivity);
        this.f23088a = dVar;
        this.f23089b.setAdapter((ListAdapter) dVar);
    }

    public void c(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.f23090c.addNetworkChangeListener(bVar);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f23096i.hideNetRefreshView(this.j);
            this.f23089b.setVisibility(0);
        }
    }

    public MemberRecommendView e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f23091d : (MemberRecommendView) invokeV.objValue;
    }

    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.j : (View) invokeV.objValue;
    }

    public TextView g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.k : (TextView) invokeV.objValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f23089b.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0201));
            this.f23088a.notifyDataSetChanged();
            this.f23092e.onChangeSkinType(this.f23096i.getPageContext(), TbadkApplication.getInst().getSkinType());
            this.f23090c.onChangeSkinType(this.f23096i.getPageContext(), TbadkApplication.getInst().getSkinType());
            this.f23091d.changeSkinType();
            SkinManager.setBackgroundColor(this.f23094g, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.f23095h, R.color.CAM_X0201);
        }
    }

    public void i(List<b.a.r0.r3.d.a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, list) == null) {
            if (list != null && list.size() > 0) {
                this.f23089b.setVisibility(0);
                this.f23088a.c(list);
                this.f23088a.notifyDataSetChanged();
                return;
            }
            this.f23089b.setVisibility(8);
        }
    }

    public final boolean j(e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, eVar)) == null) {
            if (eVar != null && !StringUtils.isNull(eVar.c())) {
                this.f23091d.setVisibility(0);
                this.f23091d.fillView(eVar);
                return true;
            }
            this.f23091d.setVisibility(8);
            return false;
        }
        return invokeL.booleanValue;
    }

    public void k(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) {
            this.f23088a.b(aVar);
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f23089b.setVisibility(8);
            String string = this.f23096i.getPageContext().getResources().getString(R.string.no_data_text);
            this.f23096i.setNetRefreshViewTopMargin(this.f23093f);
            this.f23096i.showNetRefreshView(this.j, string, false);
        }
    }

    public void m(e eVar, List<b.a.r0.r3.d.a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, eVar, list) == null) {
            if ((eVar != null && !StringUtils.isNull(eVar.c())) || (list != null && list.size() > 0)) {
                d();
                if (j(eVar)) {
                    this.f23089b.removeHeaderView(this.f23094g);
                    this.f23089b.addHeaderView(this.f23094g);
                } else {
                    this.f23089b.removeHeaderView(this.f23094g);
                }
                i(list);
                return;
            }
            l();
        }
    }
}
