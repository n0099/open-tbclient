package c.a.r0.l1.a.e;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import c.a.e.a.d;
import c.a.e.a.f;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import com.baidu.tieba.imMessageCenter.im.stranger.StrangerListActivity;
import com.baidu.tieba.imMessageCenter.im.stranger.StrangerListAdapter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class b extends d<StrangerListActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BdListView f21883a;

    /* renamed from: b  reason: collision with root package name */
    public StrangerListAdapter f21884b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f21885c;

    /* renamed from: d  reason: collision with root package name */
    public StrangerListActivity f21886d;

    /* renamed from: e  reason: collision with root package name */
    public ViewGroup f21887e;

    /* renamed from: f  reason: collision with root package name */
    public NoNetworkView f21888f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f21889g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(StrangerListActivity strangerListActivity) {
        super(strangerListActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {strangerListActivity};
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
        strangerListActivity.setContentView(R.layout.officialbar_msg_activity);
        this.f21886d = strangerListActivity;
        e(strangerListActivity);
        f(strangerListActivity);
    }

    public StrangerListAdapter c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f21884b : (StrangerListAdapter) invokeV.objValue;
    }

    public View d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f21889g : (View) invokeV.objValue;
    }

    public final void e(StrangerListActivity strangerListActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, strangerListActivity) == null) {
            NavigationBar navigationBar = (NavigationBar) strangerListActivity.findViewById(R.id.view_navigation_bar);
            this.f21885c = navigationBar;
            navigationBar.setCenterTextTitle(strangerListActivity.getPageContext().getString(R.string.stranger_list_activity_title));
            this.f21885c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f21885c.showBottomLine();
            this.f21889g = (ImageView) this.f21885c.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.stranger_delete, this.f21886d);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f21889g, R.drawable.icon_pure_topbar_delete44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            ViewGroup viewGroup = (ViewGroup) strangerListActivity.findViewById(R.id.root_view);
            this.f21887e = viewGroup;
            this.f21888f = (NoNetworkView) viewGroup.findViewById(R.id.no_network_view);
        }
    }

    public final void f(StrangerListActivity strangerListActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, strangerListActivity) == null) {
            BdListView bdListView = (BdListView) strangerListActivity.findViewById(R.id.msg_list);
            this.f21883a = bdListView;
            bdListView.setOnItemClickListener(strangerListActivity);
            this.f21883a.setOnItemLongClickListener(strangerListActivity);
            StrangerListAdapter strangerListAdapter = new StrangerListAdapter(strangerListActivity);
            this.f21884b = strangerListAdapter;
            this.f21883a.setAdapter((ListAdapter) strangerListAdapter);
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f21886d.getLayoutMode().k(i2 == 1);
            this.f21886d.getLayoutMode().j(this.f21887e);
            this.f21885c.onChangeSkinType(this.f21886d.getPageContext(), i2);
            this.f21888f.onChangeSkinType(this.f21886d.getPageContext(), i2);
            this.f21884b.notifyDataSetChanged();
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f21889g, R.drawable.icon_pure_topbar_delete44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }
}
