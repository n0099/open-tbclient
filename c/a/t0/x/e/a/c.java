package c.a.t0.x.e.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.ListAdapter;
import androidx.core.view.InputDeviceCompat;
import c.a.d.a.d;
import c.a.d.a.f;
import c.a.d.f.p.n;
import c.a.s0.s.i0.f;
import c.a.s0.s.i0.g;
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
    public View f25834b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f25835c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f25836d;

    /* renamed from: e  reason: collision with root package name */
    public BdListView f25837e;

    /* renamed from: f  reason: collision with root package name */
    public a f25838f;

    /* renamed from: g  reason: collision with root package name */
    public g f25839g;

    /* renamed from: h  reason: collision with root package name */
    public NoDataView f25840h;

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
        this.f25834b = newFriendsActivity.findViewById(R.id.new_friend_activity);
        NavigationBar navigationBar = (NavigationBar) this.a.findViewById(R.id.view_navigation_bar);
        this.f25835c = navigationBar;
        navigationBar.setTitleText(this.a.getPageContext().getString(R.string.new_friends));
        this.f25835c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView imageView = (ImageView) this.f25835c.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.add_new_friend_text, this.a).findViewById(R.id.new_friend_search);
        this.f25836d = imageView;
        imageView.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_topbar_search40, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
        this.f25837e = (BdListView) this.a.findViewById(R.id.new_friend_listview);
        a aVar = new a(this.a);
        this.f25838f = aVar;
        this.f25837e.setAdapter((ListAdapter) aVar);
        this.f25837e.setOnItemClickListener(this.a);
        this.f25837e.setOnItemLongClickListener(this.a);
        g gVar = new g(newFriendsActivity.getPageContext());
        this.f25839g = gVar;
        this.f25837e.setPullRefresh(gVar);
        BdListViewHelper.d(this.a.getActivity(), this.f25837e, BdListViewHelper.HeadType.DEFAULT);
        this.f25840h = NoDataViewFactory.a(this.a.getPageContext().getPageActivity(), this.f25834b, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, n.f(this.a.getActivity(), R.dimen.ds320)), NoDataViewFactory.e.a(R.string.no_new_friend_hint), null);
    }

    public void c(c.a.s0.s.c cVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, cVar, i2) == null) {
            cVar.k(i2 == 1);
            this.f25835c.onChangeSkinType(this.a.getPageContext(), i2);
            this.f25839g.C(i2);
            cVar.j(this.f25834b);
            this.f25840h.onChangeSkinType(this.a.getPageContext(), i2);
            this.f25836d.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_topbar_search40, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f25837e.completePullRefreshPostDelayed(0L);
        }
    }

    public a e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f25838f : (a) invokeV.objValue;
    }

    public void f(c.a.t0.s1.g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            this.f25838f.d(aVar);
            this.f25838f.notifyDataSetChanged();
        }
    }

    public void g(List<c.a.t0.s1.g.a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            this.f25837e.setEmptyView(this.f25840h);
            this.f25838f.e(list);
            this.f25838f.notifyDataSetChanged();
        }
    }

    public void h(f.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, gVar) == null) {
            this.f25839g.a(gVar);
        }
    }

    public void i(a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, cVar) == null) {
            this.f25838f.f(cVar);
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f25837e.startPullRefresh();
        }
    }

    public void k(List<c.a.t0.s1.g.a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list) == null) {
            this.f25838f.h(list);
            this.f25838f.notifyDataSetChanged();
        }
    }
}
