package c.a.p0.r2.h.f;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.o0.f0.g;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import com.baidu.tieba.faceshop.EmotionPackageData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes2.dex */
public class f implements Object<List<EmotionPackageData>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public BdListView f18101b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.p0.r2.h.d.b f18102c;

    /* renamed from: d  reason: collision with root package name */
    public b f18103d;

    /* renamed from: e  reason: collision with root package name */
    public View f18104e;

    /* renamed from: f  reason: collision with root package name */
    public g f18105f;

    /* renamed from: g  reason: collision with root package name */
    public FrameLayout f18106g;

    /* renamed from: h  reason: collision with root package name */
    public NoDataView f18107h;
    public boolean i;
    public NoNetworkView j;

    public f(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = false;
        this.a = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d02f0, (ViewGroup) null, false);
        this.f18104e = inflate;
        NoNetworkView noNetworkView = (NoNetworkView) inflate.findViewById(R.id.obfuscated_res_0x7f0923d1);
        this.j = noNetworkView;
        noNetworkView.a(this);
        this.f18106g = (FrameLayout) this.f18104e.findViewById(R.id.obfuscated_res_0x7f091d29);
        this.f18101b = (BdListView) this.f18104e.findViewById(R.id.obfuscated_res_0x7f0908ae);
        this.f18103d = new b(this.f18104e.findViewById(R.id.obfuscated_res_0x7f0908ad), tbPageContext.getString(R.string.obfuscated_res_0x7f0f053a));
        this.f18101b.setDivider(null);
        this.f18101b.setOverScrollMode(2);
        this.f18101b.setVerticalScrollBarEnabled(false);
        this.f18102c = new c.a.p0.r2.h.d.b(tbPageContext, this.f18101b);
        h();
    }

    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f18104e : (View) invokeV.objValue;
    }

    public void b() {
        FrameLayout frameLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f18105f == null || (frameLayout = this.f18106g) == null) {
            return;
        }
        frameLayout.setVisibility(8);
        this.f18105f.dettachView(this.f18106g);
        this.f18105f = null;
    }

    public final void c() {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (noDataView = this.f18107h) != null && noDataView.getParent() == this.f18106g) {
            this.f18107h.setVisibility(8);
            this.f18106g.removeView(this.f18107h);
            this.f18106g.setVisibility(8);
        }
    }

    public void d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            View view = this.f18104e;
            if (view != null) {
                SkinManager.setBackgroundColor(view, R.color.cp_bg_line_d_alpha90, i);
            }
            BdListView bdListView = this.f18101b;
            if (bdListView != null) {
                SkinManager.setBackgroundColor(bdListView, R.color.CAM_X0201, i);
            }
            b bVar = this.f18103d;
            if (bVar != null) {
                bVar.b(i);
            }
            NoNetworkView noNetworkView = this.j;
            if (noNetworkView != null) {
                noNetworkView.c(this.a, i);
            }
            FrameLayout frameLayout = this.f18106g;
            if (frameLayout != null) {
                SkinManager.setBackgroundColor(frameLayout, R.color.CAM_X0201, i);
            }
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            b();
            c();
        }
    }

    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048581, this, z) == null) && z) {
            h();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921314));
        }
    }

    public final void g() {
        BdListView bdListView;
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (bdListView = this.f18101b) == null || this.i || (bVar = this.f18103d) == null) {
            return;
        }
        this.i = true;
        bdListView.setEmptyView(bVar.a());
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.a == null || this.f18106g == null) {
            return;
        }
        e();
        this.f18106g.setVisibility(0);
        if (this.f18105f == null) {
            this.f18105f = new g(this.a.getPageActivity());
        }
        this.f18105f.attachView(this.f18106g, true);
        this.f18105f.onChangeSkinType();
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.a == null || this.f18106g == null) {
            return;
        }
        e();
        this.f18106g.setVisibility(0);
        NoDataView b2 = NoDataViewFactory.b(this.a.getPageActivity(), this.f18106g, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.WEBVIEW, n.f(this.a.getPageActivity(), R.dimen.obfuscated_res_0x7f07022e)), NoDataViewFactory.e.d(null, this.a.getString(R.string.obfuscated_res_0x7f0f053c)), null, true);
        this.f18107h = b2;
        b2.setVisibility(0);
        this.f18107h.d(this.a);
    }

    /* JADX DEBUG: Method merged with bridge method */
    public void update(List<EmotionPackageData> list) {
        c.a.p0.r2.h.d.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, list) == null) {
            g();
            if (list == null || (bVar = this.f18102c) == null) {
                return;
            }
            bVar.update(list);
        }
    }
}
