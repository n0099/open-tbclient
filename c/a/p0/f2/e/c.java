package c.a.p0.f2.e;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import c.a.d.f.p.n;
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
/* loaded from: classes2.dex */
public class c implements c.a.o0.x0.b, View.OnClickListener, AdapterView.OnItemClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<SelectLocationActivity> a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f14937b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f14938c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f14939d;

    /* renamed from: e  reason: collision with root package name */
    public BdListView f14940e;

    /* renamed from: f  reason: collision with root package name */
    public b f14941f;

    /* renamed from: g  reason: collision with root package name */
    public Intent f14942g;

    public c(TbPageContext tbPageContext, LinearLayout linearLayout, NavigationBar navigationBar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, linearLayout, navigationBar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = tbPageContext;
        this.f14939d = linearLayout;
        this.f14937b = navigationBar;
        b();
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0765, (ViewGroup) this.f14939d, true);
            this.f14940e = (BdListView) this.f14939d.findViewById(R.id.obfuscated_res_0x7f091c87);
            b bVar = new b(this.a);
            this.f14941f = bVar;
            this.f14940e.setAdapter((ListAdapter) bVar);
            this.f14940e.setOnItemClickListener(this);
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f14937b.setCenterTextTitle(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f10cb));
            ImageView imageView = (ImageView) this.f14937b.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.obfuscated_res_0x7f0d08d2, (View.OnClickListener) null);
            this.f14938c = imageView;
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) imageView.getLayoutParams();
            layoutParams.setMargins(0, 0, n.f(this.a.getPageActivity(), R.dimen.obfuscated_res_0x7f070229), 0);
            this.f14938c.setLayoutParams(layoutParams);
            this.f14938c.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809c1, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
            this.f14938c.setOnClickListener(this);
        }
    }

    @Override // c.a.o0.x0.b
    public Intent getResultIntent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f14942g : (Intent) invokeV.objValue;
    }

    @Override // c.a.o0.x0.b
    public boolean isOnViewCancel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.o0.x0.b
    public boolean isOnViewTop() {
        InterceptResult invokeV;
        View childAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            BdListView bdListView = this.f14940e;
            return bdListView != null && bdListView.getFirstVisiblePosition() == 0 && (childAt = this.f14940e.getChildAt(0)) != null && childAt.getTop() == 0;
        }
        return invokeV.booleanValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, view) == null) && view == this.f14938c) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002012, new SearchLocationActivityConfig(this.a.getPageActivity(), 23009)));
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{adapterView, view, Integer.valueOf(i), Long.valueOf(j)}) == null) || this.f14941f == null) {
            return;
        }
        MessageManager messageManager = MessageManager.getInstance();
        LocationEvent locationEvent = new LocationEvent();
        locationEvent.setType(1);
        locationEvent.eventType = 2;
        if (i == 0) {
            messageManager.dispatchResponsedMessage(new ResponsedSelectLocation(false, null, null, null));
            locationEvent.isShowLocation = false;
            this.a.getOrignalPage().publishEvent(locationEvent);
            this.a.getOrignalPage().finish();
            return;
        }
        Object item = this.f14941f.getItem(i);
        if (item instanceof LocationData.NearByAddressData) {
            LocationData.NearByAddressData nearByAddressData = (LocationData.NearByAddressData) item;
            messageManager.dispatchResponsedMessage(new ResponsedSelectLocation(true, nearByAddressData.getName(), nearByAddressData.getAddr(), nearByAddressData.getSn()));
            locationEvent.locName = nearByAddressData.getName();
            locationEvent.locAddr = nearByAddressData.getAddr();
            locationEvent.locSn = nearByAddressData.getSn();
            locationEvent.isShowLocation = true;
            this.a.getOrignalPage().publishEvent(locationEvent);
            this.a.getOrignalPage().finish();
        }
    }

    @Override // c.a.o0.x0.b
    public void onViewChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.f14938c.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809c1, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
            this.f14941f.notifyDataSetChanged();
        }
    }
}
