package c.a.r0.t.e.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.ListAdapter;
import androidx.core.view.InputDeviceCompat;
import c.a.e.a.d;
import c.a.e.a.f;
import c.a.e.e.p.l;
import c.a.q0.s.f0.f;
import c.a.q0.s.f0.g;
import c.a.r0.t.e.a.a;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.addresslist.im.newFriend.NewFriendsActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes3.dex */
public class c extends d<NewFriendsActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public NewFriendsActivity f24720a;

    /* renamed from: b  reason: collision with root package name */
    public View f24721b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f24722c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f24723d;

    /* renamed from: e  reason: collision with root package name */
    public BdListView f24724e;

    /* renamed from: f  reason: collision with root package name */
    public a f24725f;

    /* renamed from: g  reason: collision with root package name */
    public g f24726g;

    /* renamed from: h  reason: collision with root package name */
    public NoDataView f24727h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(NewFriendsActivity newFriendsActivity) {
        super(newFriendsActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {newFriendsActivity};
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
        this.f24720a = newFriendsActivity;
        this.f24721b = newFriendsActivity.findViewById(R.id.new_friend_activity);
        NavigationBar navigationBar = (NavigationBar) this.f24720a.findViewById(R.id.view_navigation_bar);
        this.f24722c = navigationBar;
        navigationBar.setTitleText(this.f24720a.getPageContext().getString(R.string.new_friends));
        this.f24722c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView imageView = (ImageView) this.f24722c.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.add_new_friend_text, this.f24720a).findViewById(R.id.new_friend_search);
        this.f24723d = imageView;
        imageView.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_topbar_search40, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
        this.f24724e = (BdListView) this.f24720a.findViewById(R.id.new_friend_listview);
        a aVar = new a(this.f24720a);
        this.f24725f = aVar;
        this.f24724e.setAdapter((ListAdapter) aVar);
        this.f24724e.setOnItemClickListener(this.f24720a);
        this.f24724e.setOnItemLongClickListener(this.f24720a);
        g gVar = new g(newFriendsActivity.getPageContext());
        this.f24726g = gVar;
        this.f24724e.setPullRefresh(gVar);
        BdListViewHelper.d(this.f24720a.getActivity(), this.f24724e, BdListViewHelper.HeadType.DEFAULT);
        this.f24727h = NoDataViewFactory.a(this.f24720a.getPageContext().getPageActivity(), this.f24721b, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, l.g(this.f24720a.getActivity(), R.dimen.ds320)), NoDataViewFactory.e.a(R.string.no_new_friend_hint), null);
    }

    public void c(c.a.q0.s.c cVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, cVar, i2) == null) {
            cVar.k(i2 == 1);
            this.f24722c.onChangeSkinType(this.f24720a.getPageContext(), i2);
            this.f24726g.D(i2);
            cVar.j(this.f24721b);
            this.f24727h.onChangeSkinType(this.f24720a.getPageContext(), i2);
            this.f24723d.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_topbar_search40, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f24724e.completePullRefreshPostDelayed(0L);
        }
    }

    public a e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f24725f : (a) invokeV.objValue;
    }

    public void f(c.a.r0.l1.g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            this.f24725f.d(aVar);
            this.f24725f.notifyDataSetChanged();
        }
    }

    public void g(List<c.a.r0.l1.g.a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            this.f24724e.setEmptyView(this.f24727h);
            this.f24725f.e(list);
            this.f24725f.notifyDataSetChanged();
        }
    }

    public void h(f.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, gVar) == null) {
            this.f24726g.a(gVar);
        }
    }

    public void i(a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, cVar) == null) {
            this.f24725f.f(cVar);
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f24724e.startPullRefresh();
        }
    }

    public void k(List<c.a.r0.l1.g.a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list) == null) {
            this.f24725f.h(list);
            this.f24725f.notifyDataSetChanged();
        }
    }
}
