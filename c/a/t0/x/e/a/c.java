package c.a.t0.x.e.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.ListAdapter;
import androidx.core.view.InputDeviceCompat;
import c.a.d.a.d;
import c.a.d.a.f;
import c.a.d.f.p.n;
import c.a.s0.s.k0.f;
import c.a.s0.s.k0.g;
import c.a.t0.x.e.a.a;
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
/* loaded from: classes8.dex */
public class c extends d<NewFriendsActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NewFriendsActivity a;

    /* renamed from: b  reason: collision with root package name */
    public View f24883b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f24884c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f24885d;

    /* renamed from: e  reason: collision with root package name */
    public BdListView f24886e;

    /* renamed from: f  reason: collision with root package name */
    public a f24887f;

    /* renamed from: g  reason: collision with root package name */
    public g f24888g;

    /* renamed from: h  reason: collision with root package name */
    public NoDataView f24889h;

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
        this.a = newFriendsActivity;
        this.f24883b = newFriendsActivity.findViewById(R.id.new_friend_activity);
        NavigationBar navigationBar = (NavigationBar) this.a.findViewById(R.id.view_navigation_bar);
        this.f24884c = navigationBar;
        navigationBar.setTitleText(this.a.getPageContext().getString(R.string.new_friends));
        this.f24884c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView imageView = (ImageView) this.f24884c.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.add_new_friend_text, this.a).findViewById(R.id.new_friend_search);
        this.f24885d = imageView;
        imageView.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_topbar_search40, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
        this.f24886e = (BdListView) this.a.findViewById(R.id.new_friend_listview);
        a aVar = new a(this.a);
        this.f24887f = aVar;
        this.f24886e.setAdapter((ListAdapter) aVar);
        this.f24886e.setOnItemClickListener(this.a);
        this.f24886e.setOnItemLongClickListener(this.a);
        g gVar = new g(newFriendsActivity.getPageContext());
        this.f24888g = gVar;
        this.f24886e.setPullRefresh(gVar);
        BdListViewHelper.d(this.a.getActivity(), this.f24886e, BdListViewHelper.HeadType.DEFAULT);
        this.f24889h = NoDataViewFactory.a(this.a.getPageContext().getPageActivity(), this.f24883b, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, n.f(this.a.getActivity(), R.dimen.ds320)), NoDataViewFactory.e.a(R.string.no_new_friend_hint), null);
    }

    public void c(c.a.s0.s.c cVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, cVar, i2) == null) {
            cVar.k(i2 == 1);
            this.f24884c.onChangeSkinType(this.a.getPageContext(), i2);
            this.f24888g.C(i2);
            cVar.j(this.f24883b);
            this.f24889h.onChangeSkinType(this.a.getPageContext(), i2);
            this.f24885d.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_topbar_search40, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f24886e.completePullRefreshPostDelayed(0L);
        }
    }

    public a e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f24887f : (a) invokeV.objValue;
    }

    public void f(c.a.t0.t1.g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            this.f24887f.d(aVar);
            this.f24887f.notifyDataSetChanged();
        }
    }

    public void g(List<c.a.t0.t1.g.a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            this.f24886e.setEmptyView(this.f24889h);
            this.f24887f.e(list);
            this.f24887f.notifyDataSetChanged();
        }
    }

    public void h(f.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, gVar) == null) {
            this.f24888g.a(gVar);
        }
    }

    public void i(a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, cVar) == null) {
            this.f24887f.f(cVar);
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f24886e.startPullRefresh();
        }
    }

    public void k(List<c.a.t0.t1.g.a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list) == null) {
            this.f24887f.h(list);
            this.f24887f.notifyDataSetChanged();
        }
    }
}
