package c.a.p0.z.e.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.ListAdapter;
import androidx.core.view.InputDeviceCompat;
import c.a.d.a.d;
import c.a.d.a.f;
import c.a.d.f.p.n;
import c.a.o0.r.l0.f;
import c.a.o0.r.l0.g;
import c.a.p0.z.e.a.a;
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
    public NewFriendsActivity a;

    /* renamed from: b  reason: collision with root package name */
    public View f20841b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f20842c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f20843d;

    /* renamed from: e  reason: collision with root package name */
    public BdListView f20844e;

    /* renamed from: f  reason: collision with root package name */
    public a f20845f;

    /* renamed from: g  reason: collision with root package name */
    public g f20846g;

    /* renamed from: h  reason: collision with root package name */
    public NoDataView f20847h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(NewFriendsActivity newFriendsActivity) {
        super(newFriendsActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {newFriendsActivity};
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
        this.a = newFriendsActivity;
        this.f20841b = newFriendsActivity.findViewById(R.id.obfuscated_res_0x7f091547);
        NavigationBar navigationBar = (NavigationBar) this.a.findViewById(R.id.obfuscated_res_0x7f0923cf);
        this.f20842c = navigationBar;
        navigationBar.setTitleText(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0c1a));
        this.f20842c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView imageView = (ImageView) this.f20842c.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.obfuscated_res_0x7f0d007d, this.a).findViewById(R.id.obfuscated_res_0x7f091549);
        this.f20843d = imageView;
        imageView.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809c1, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
        this.f20844e = (BdListView) this.a.findViewById(R.id.obfuscated_res_0x7f091548);
        a aVar = new a(this.a);
        this.f20845f = aVar;
        this.f20844e.setAdapter((ListAdapter) aVar);
        this.f20844e.setOnItemClickListener(this.a);
        this.f20844e.setOnItemLongClickListener(this.a);
        g gVar = new g(newFriendsActivity.getPageContext());
        this.f20846g = gVar;
        this.f20844e.setPullRefresh(gVar);
        BdListViewHelper.d(this.a.getActivity(), this.f20844e, BdListViewHelper.HeadType.DEFAULT);
        this.f20847h = NoDataViewFactory.a(this.a.getPageContext().getPageActivity(), this.f20841b, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, n.f(this.a.getActivity(), R.dimen.obfuscated_res_0x7f070297)), NoDataViewFactory.e.a(R.string.obfuscated_res_0x7f0f0c52), null);
    }

    public void c(c.a.o0.r.c cVar, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, cVar, i) == null) {
            cVar.k(i == 1);
            this.f20842c.onChangeSkinType(this.a.getPageContext(), i);
            this.f20846g.H(i);
            cVar.j(this.f20841b);
            this.f20847h.f(this.a.getPageContext(), i);
            this.f20843d.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809c1, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f20844e.A(0L);
        }
    }

    public a g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f20845f : (a) invokeV.objValue;
    }

    public void h(c.a.p0.u1.g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            this.f20845f.d(aVar);
            this.f20845f.notifyDataSetChanged();
        }
    }

    public void i(List<c.a.p0.u1.g.a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            this.f20844e.setEmptyView(this.f20847h);
            this.f20845f.e(list);
            this.f20845f.notifyDataSetChanged();
        }
    }

    public void j(f.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, gVar) == null) {
            this.f20846g.f(gVar);
        }
    }

    public void k(a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, cVar) == null) {
            this.f20845f.f(cVar);
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f20844e.F();
        }
    }

    public void m(List<c.a.p0.u1.g.a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list) == null) {
            this.f20845f.h(list);
            this.f20845f.notifyDataSetChanged();
        }
    }
}
