package b.a.r0.t.e.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.ListAdapter;
import androidx.core.view.InputDeviceCompat;
import b.a.e.a.d;
import b.a.e.a.f;
import b.a.e.f.p.l;
import b.a.q0.s.g0.f;
import b.a.q0.s.g0.g;
import b.a.r0.t.e.a.a;
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
/* loaded from: classes5.dex */
public class c extends d<NewFriendsActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public NewFriendsActivity f25082a;

    /* renamed from: b  reason: collision with root package name */
    public View f25083b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f25084c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f25085d;

    /* renamed from: e  reason: collision with root package name */
    public BdListView f25086e;

    /* renamed from: f  reason: collision with root package name */
    public a f25087f;

    /* renamed from: g  reason: collision with root package name */
    public g f25088g;

    /* renamed from: h  reason: collision with root package name */
    public NoDataView f25089h;

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
        this.f25082a = newFriendsActivity;
        this.f25083b = newFriendsActivity.findViewById(R.id.new_friend_activity);
        NavigationBar navigationBar = (NavigationBar) this.f25082a.findViewById(R.id.view_navigation_bar);
        this.f25084c = navigationBar;
        navigationBar.setTitleText(this.f25082a.getPageContext().getString(R.string.new_friends));
        this.f25084c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView imageView = (ImageView) this.f25084c.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.add_new_friend_text, this.f25082a).findViewById(R.id.new_friend_search);
        this.f25085d = imageView;
        imageView.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_topbar_search40, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
        this.f25086e = (BdListView) this.f25082a.findViewById(R.id.new_friend_listview);
        a aVar = new a(this.f25082a);
        this.f25087f = aVar;
        this.f25086e.setAdapter((ListAdapter) aVar);
        this.f25086e.setOnItemClickListener(this.f25082a);
        this.f25086e.setOnItemLongClickListener(this.f25082a);
        g gVar = new g(newFriendsActivity.getPageContext());
        this.f25088g = gVar;
        this.f25086e.setPullRefresh(gVar);
        BdListViewHelper.d(this.f25082a.getActivity(), this.f25086e, BdListViewHelper.HeadType.DEFAULT);
        this.f25089h = NoDataViewFactory.a(this.f25082a.getPageContext().getPageActivity(), this.f25083b, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, l.g(this.f25082a.getActivity(), R.dimen.ds320)), NoDataViewFactory.e.a(R.string.no_new_friend_hint), null);
    }

    public void c(b.a.q0.s.c cVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, cVar, i2) == null) {
            cVar.k(i2 == 1);
            this.f25084c.onChangeSkinType(this.f25082a.getPageContext(), i2);
            this.f25088g.C(i2);
            cVar.j(this.f25083b);
            this.f25089h.onChangeSkinType(this.f25082a.getPageContext(), i2);
            this.f25085d.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_topbar_search40, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f25086e.completePullRefreshPostDelayed(0L);
        }
    }

    public a e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f25087f : (a) invokeV.objValue;
    }

    public void f(b.a.r0.l1.g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            this.f25087f.d(aVar);
            this.f25087f.notifyDataSetChanged();
        }
    }

    public void g(List<b.a.r0.l1.g.a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            this.f25086e.setEmptyView(this.f25089h);
            this.f25087f.e(list);
            this.f25087f.notifyDataSetChanged();
        }
    }

    public void h(f.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, gVar) == null) {
            this.f25088g.a(gVar);
        }
    }

    public void i(a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, cVar) == null) {
            this.f25087f.f(cVar);
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f25086e.startPullRefresh();
        }
    }

    public void k(List<b.a.r0.l1.g.a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list) == null) {
            this.f25087f.h(list);
            this.f25087f.notifyDataSetChanged();
        }
    }
}
