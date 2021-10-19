package c.a.r0.m1.a.e;

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
    public BdListView f22077a;

    /* renamed from: b  reason: collision with root package name */
    public StrangerListAdapter f22078b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f22079c;

    /* renamed from: d  reason: collision with root package name */
    public StrangerListActivity f22080d;

    /* renamed from: e  reason: collision with root package name */
    public ViewGroup f22081e;

    /* renamed from: f  reason: collision with root package name */
    public NoNetworkView f22082f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f22083g;

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
        this.f22080d = strangerListActivity;
        e(strangerListActivity);
        f(strangerListActivity);
    }

    public StrangerListAdapter c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f22078b : (StrangerListAdapter) invokeV.objValue;
    }

    public View d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f22083g : (View) invokeV.objValue;
    }

    public final void e(StrangerListActivity strangerListActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, strangerListActivity) == null) {
            NavigationBar navigationBar = (NavigationBar) strangerListActivity.findViewById(R.id.view_navigation_bar);
            this.f22079c = navigationBar;
            navigationBar.setCenterTextTitle(strangerListActivity.getPageContext().getString(R.string.stranger_list_activity_title));
            this.f22079c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f22079c.showBottomLine();
            this.f22083g = (ImageView) this.f22079c.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.stranger_delete, this.f22080d);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f22083g, R.drawable.icon_pure_topbar_delete44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            ViewGroup viewGroup = (ViewGroup) strangerListActivity.findViewById(R.id.root_view);
            this.f22081e = viewGroup;
            this.f22082f = (NoNetworkView) viewGroup.findViewById(R.id.no_network_view);
        }
    }

    public final void f(StrangerListActivity strangerListActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, strangerListActivity) == null) {
            BdListView bdListView = (BdListView) strangerListActivity.findViewById(R.id.msg_list);
            this.f22077a = bdListView;
            bdListView.setOnItemClickListener(strangerListActivity);
            this.f22077a.setOnItemLongClickListener(strangerListActivity);
            StrangerListAdapter strangerListAdapter = new StrangerListAdapter(strangerListActivity);
            this.f22078b = strangerListAdapter;
            this.f22077a.setAdapter((ListAdapter) strangerListAdapter);
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f22080d.getLayoutMode().k(i2 == 1);
            this.f22080d.getLayoutMode().j(this.f22081e);
            this.f22079c.onChangeSkinType(this.f22080d.getPageContext(), i2);
            this.f22082f.onChangeSkinType(this.f22080d.getPageContext(), i2);
            this.f22078b.notifyDataSetChanged();
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f22083g, R.drawable.icon_pure_topbar_delete44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }
}
