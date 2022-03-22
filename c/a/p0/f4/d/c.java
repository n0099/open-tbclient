package c.a.p0.f4.d;

import android.view.View;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.a.f;
import c.a.d.f.p.n;
import c.a.p0.f4.h.e;
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
/* loaded from: classes2.dex */
public class c extends c.a.d.a.d<AvatarPendantActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public d a;

    /* renamed from: b  reason: collision with root package name */
    public BdListView f14999b;

    /* renamed from: c  reason: collision with root package name */
    public NoNetworkView f15000c;

    /* renamed from: d  reason: collision with root package name */
    public MemberRecommendView f15001d;

    /* renamed from: e  reason: collision with root package name */
    public NavigationBar f15002e;

    /* renamed from: f  reason: collision with root package name */
    public int f15003f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f15004g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f15005h;
    public AvatarPendantActivity i;
    public View j;
    public TextView k;

    /* loaded from: classes2.dex */
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f15003f = 0;
        this.i = avatarPendantActivity;
        avatarPendantActivity.setContentView(R.layout.obfuscated_res_0x7f0d0129);
        this.j = avatarPendantActivity.findViewById(R.id.obfuscated_res_0x7f091aee);
        this.f15003f = n.f(avatarPendantActivity.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f070297);
        this.f14999b = (BdListView) avatarPendantActivity.findViewById(R.id.obfuscated_res_0x7f0902eb);
        this.f15000c = (NoNetworkView) avatarPendantActivity.findViewById(R.id.obfuscated_res_0x7f0923d1);
        NavigationBar navigationBar = (NavigationBar) avatarPendantActivity.findViewById(R.id.obfuscated_res_0x7f0923cf);
        this.f15002e = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f15002e.setTitleText(R.string.obfuscated_res_0x7f0f02b5);
        MemberRecommendView memberRecommendView = (MemberRecommendView) avatarPendantActivity.findViewById(R.id.obfuscated_res_0x7f0902ed);
        this.f15001d = memberRecommendView;
        memberRecommendView.setFromType(8);
        this.f15001d.getButton().setOnClickListener(avatarPendantActivity);
        TextView textView = new TextView(avatarPendantActivity.getActivity());
        this.f15004g = textView;
        textView.setHeight(n.f(avatarPendantActivity.getActivity(), R.dimen.obfuscated_res_0x7f07019c));
        this.k = new TextView(avatarPendantActivity.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + n.f(avatarPendantActivity.getActivity(), R.dimen.obfuscated_res_0x7f070282));
        TextView textView2 = new TextView(avatarPendantActivity.getActivity());
        this.f15005h = textView2;
        textView2.setHeight(n.f(avatarPendantActivity.getActivity(), R.dimen.obfuscated_res_0x7f0702cb));
        this.k.setLayoutParams(layoutParams);
        this.f14999b.x(this.k, 0);
        this.f14999b.addFooterView(this.f15005h);
        d dVar = new d(avatarPendantActivity);
        this.a = dVar;
        this.f14999b.setAdapter((ListAdapter) dVar);
    }

    public void c(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.f15000c.a(bVar);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.i.hideNetRefreshView(this.j);
            this.f14999b.setVisibility(0);
        }
    }

    public MemberRecommendView g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f15001d : (MemberRecommendView) invokeV.objValue;
    }

    public View h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.j : (View) invokeV.objValue;
    }

    public TextView i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.k : (TextView) invokeV.objValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f14999b.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0201));
            this.a.notifyDataSetChanged();
            this.f15002e.onChangeSkinType(this.i.getPageContext(), TbadkApplication.getInst().getSkinType());
            this.f15000c.c(this.i.getPageContext(), TbadkApplication.getInst().getSkinType());
            this.f15001d.d();
            SkinManager.setBackgroundColor(this.f15004g, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.f15005h, R.color.CAM_X0201);
        }
    }

    public void k(List<c.a.p0.f4.d.a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, list) == null) {
            if (list != null && list.size() > 0) {
                this.f14999b.setVisibility(0);
                this.a.c(list);
                this.a.notifyDataSetChanged();
                return;
            }
            this.f14999b.setVisibility(8);
        }
    }

    public final boolean l(e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, eVar)) == null) {
            if (eVar != null && !StringUtils.isNull(eVar.c())) {
                this.f15001d.setVisibility(0);
                this.f15001d.e(eVar);
                return true;
            }
            this.f15001d.setVisibility(8);
            return false;
        }
        return invokeL.booleanValue;
    }

    public void m(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) {
            this.a.b(aVar);
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f14999b.setVisibility(8);
            String string = this.i.getPageContext().getResources().getString(R.string.obfuscated_res_0x7f0f0c2d);
            this.i.setNetRefreshViewTopMargin(this.f15003f);
            this.i.showNetRefreshView(this.j, string, false);
        }
    }

    public void o(e eVar, List<c.a.p0.f4.d.a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, eVar, list) == null) {
            if ((eVar != null && !StringUtils.isNull(eVar.c())) || (list != null && list.size() > 0)) {
                d();
                if (l(eVar)) {
                    this.f14999b.removeHeaderView(this.f15004g);
                    this.f14999b.addHeaderView(this.f15004g);
                } else {
                    this.f14999b.removeHeaderView(this.f15004g);
                }
                k(list);
                return;
            }
            n();
        }
    }
}
