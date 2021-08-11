package c.a.p0.s1.e;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import c.a.e.e.p.l;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.mutiprocess.location.LocationEvent;
import com.baidu.tieba.R;
import com.baidu.tieba.location.data.SearchLocationActivityConfig;
import com.baidu.tieba.location.selectpoi.SelectLocationActivity;
import com.baidu.tieba.tbadkCore.location.LocationData;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class c implements c.a.o0.v0.a, View.OnClickListener, AdapterView.OnItemClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<SelectLocationActivity> f23990e;

    /* renamed from: f  reason: collision with root package name */
    public NavigationBar f23991f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f23992g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f23993h;

    /* renamed from: i  reason: collision with root package name */
    public BdListView f23994i;

    /* renamed from: j  reason: collision with root package name */
    public b f23995j;
    public Intent k;

    public c(TbPageContext tbPageContext, LinearLayout linearLayout, NavigationBar navigationBar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, linearLayout, navigationBar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f23990e = tbPageContext;
        this.f23993h = linearLayout;
        this.f23991f = navigationBar;
        b();
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LayoutInflater.from(this.f23990e.getPageActivity()).inflate(R.layout.select_location_activity, (ViewGroup) this.f23993h, true);
            this.f23994i = (BdListView) this.f23993h.findViewById(R.id.select_position_list);
            b bVar = new b(this.f23990e);
            this.f23995j = bVar;
            this.f23994i.setAdapter((ListAdapter) bVar);
            this.f23994i.setOnItemClickListener(this);
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f23991f.setCenterTextTitle(this.f23990e.getResources().getString(R.string.select_position_title));
            ImageView imageView = (ImageView) this.f23991f.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_search, (View.OnClickListener) null);
            this.f23992g = imageView;
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) imageView.getLayoutParams();
            layoutParams.setMargins(0, 0, l.g(this.f23990e.getPageActivity(), R.dimen.ds10), 0);
            this.f23992g.setLayoutParams(layoutParams);
            this.f23992g.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_topbar_search40, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
            this.f23992g.setOnClickListener(this);
        }
    }

    @Override // c.a.o0.v0.a
    public Intent getResultIntent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.k : (Intent) invokeV.objValue;
    }

    @Override // c.a.o0.v0.a
    public boolean isOnViewCancel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.o0.v0.a
    public boolean isOnViewTop() {
        InterceptResult invokeV;
        View childAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            BdListView bdListView = this.f23994i;
            return bdListView != null && bdListView.getFirstVisiblePosition() == 0 && (childAt = this.f23994i.getChildAt(0)) != null && childAt.getTop() == 0;
        }
        return invokeV.booleanValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, view) == null) && view == this.f23992g) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002012, new SearchLocationActivityConfig(this.f23990e.getPageActivity(), 23009)));
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) || this.f23995j == null) {
            return;
        }
        MessageManager messageManager = MessageManager.getInstance();
        LocationEvent locationEvent = new LocationEvent();
        locationEvent.setType(1);
        locationEvent.eventType = 2;
        if (i2 == 0) {
            messageManager.dispatchResponsedMessage(new ResponsedSelectLocation(false, null, null, null));
            locationEvent.isShowLocation = false;
            this.f23990e.getOrignalPage().publishEvent(locationEvent);
            this.f23990e.getOrignalPage().finish();
            return;
        }
        Object item = this.f23995j.getItem(i2);
        if (item instanceof LocationData.NearByAddressData) {
            LocationData.NearByAddressData nearByAddressData = (LocationData.NearByAddressData) item;
            messageManager.dispatchResponsedMessage(new ResponsedSelectLocation(true, nearByAddressData.getName(), nearByAddressData.getAddr(), nearByAddressData.getSn()));
            locationEvent.locName = nearByAddressData.getName();
            locationEvent.locAddr = nearByAddressData.getAddr();
            locationEvent.locSn = nearByAddressData.getSn();
            locationEvent.isShowLocation = true;
            this.f23990e.getOrignalPage().publishEvent(locationEvent);
            this.f23990e.getOrignalPage().finish();
        }
    }

    @Override // c.a.o0.v0.a
    public void onViewChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.f23992g.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_topbar_search40, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
            this.f23995j.notifyDataSetChanged();
        }
    }
}
