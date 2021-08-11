package c.a.p0.s.e.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.ListAdapter;
import androidx.core.view.InputDeviceCompat;
import c.a.e.a.d;
import c.a.e.a.f;
import c.a.e.e.p.l;
import c.a.o0.s.f0.f;
import c.a.o0.s.f0.g;
import c.a.p0.s.e.a.a;
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
    public NewFriendsActivity f23896a;

    /* renamed from: b  reason: collision with root package name */
    public View f23897b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f23898c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f23899d;

    /* renamed from: e  reason: collision with root package name */
    public BdListView f23900e;

    /* renamed from: f  reason: collision with root package name */
    public a f23901f;

    /* renamed from: g  reason: collision with root package name */
    public g f23902g;

    /* renamed from: h  reason: collision with root package name */
    public NoDataView f23903h;

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
        this.f23896a = newFriendsActivity;
        this.f23897b = newFriendsActivity.findViewById(R.id.new_friend_activity);
        NavigationBar navigationBar = (NavigationBar) this.f23896a.findViewById(R.id.view_navigation_bar);
        this.f23898c = navigationBar;
        navigationBar.setTitleText(this.f23896a.getPageContext().getString(R.string.new_friends));
        this.f23898c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView imageView = (ImageView) this.f23898c.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.add_new_friend_text, this.f23896a).findViewById(R.id.new_friend_search);
        this.f23899d = imageView;
        imageView.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_topbar_search40, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
        this.f23900e = (BdListView) this.f23896a.findViewById(R.id.new_friend_listview);
        a aVar = new a(this.f23896a);
        this.f23901f = aVar;
        this.f23900e.setAdapter((ListAdapter) aVar);
        this.f23900e.setOnItemClickListener(this.f23896a);
        this.f23900e.setOnItemLongClickListener(this.f23896a);
        g gVar = new g(newFriendsActivity.getPageContext());
        this.f23902g = gVar;
        this.f23900e.setPullRefresh(gVar);
        BdListViewHelper.d(this.f23896a.getActivity(), this.f23900e, BdListViewHelper.HeadType.DEFAULT);
        this.f23903h = NoDataViewFactory.a(this.f23896a.getPageContext().getPageActivity(), this.f23897b, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, l.g(this.f23896a.getActivity(), R.dimen.ds320)), NoDataViewFactory.e.a(R.string.no_new_friend_hint), null);
    }

    public void c(c.a.o0.s.c cVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, cVar, i2) == null) {
            cVar.k(i2 == 1);
            this.f23898c.onChangeSkinType(this.f23896a.getPageContext(), i2);
            this.f23902g.D(i2);
            cVar.j(this.f23897b);
            this.f23903h.onChangeSkinType(this.f23896a.getPageContext(), i2);
            this.f23899d.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_topbar_search40, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f23900e.completePullRefreshPostDelayed(0L);
        }
    }

    public a e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f23901f : (a) invokeV.objValue;
    }

    public void f(c.a.p0.j1.g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            this.f23901f.d(aVar);
            this.f23901f.notifyDataSetChanged();
        }
    }

    public void g(List<c.a.p0.j1.g.a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            this.f23900e.setEmptyView(this.f23903h);
            this.f23901f.e(list);
            this.f23901f.notifyDataSetChanged();
        }
    }

    public void h(f.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, gVar) == null) {
            this.f23902g.a(gVar);
        }
    }

    public void i(a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, cVar) == null) {
            this.f23901f.f(cVar);
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f23900e.startPullRefresh();
        }
    }

    public void k(List<c.a.p0.j1.g.a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list) == null) {
            this.f23901f.h(list);
            this.f23901f.notifyDataSetChanged();
        }
    }
}
