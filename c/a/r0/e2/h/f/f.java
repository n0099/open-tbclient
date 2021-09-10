package c.a.r0.e2.h.f;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.l;
import c.a.q0.g0.g;
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
/* loaded from: classes3.dex */
public class f implements Object<List<EmotionPackageData>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f17435e;

    /* renamed from: f  reason: collision with root package name */
    public BdListView f17436f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.r0.e2.h.d.b f17437g;

    /* renamed from: h  reason: collision with root package name */
    public b f17438h;

    /* renamed from: i  reason: collision with root package name */
    public View f17439i;

    /* renamed from: j  reason: collision with root package name */
    public g f17440j;
    public FrameLayout k;
    public NoDataView l;
    public boolean m;
    public NoNetworkView n;

    public f(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = false;
        this.f17435e = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.fragment_single_thread_emotions, (ViewGroup) null, false);
        this.f17439i = inflate;
        NoNetworkView noNetworkView = (NoNetworkView) inflate.findViewById(R.id.view_no_network);
        this.n = noNetworkView;
        noNetworkView.addNetworkChangeListener(this);
        this.k = (FrameLayout) this.f17439i.findViewById(R.id.single_emotion_loading);
        this.f17436f = (BdListView) this.f17439i.findViewById(R.id.emotion_single_thread_list);
        this.f17438h = new b(this.f17439i.findViewById(R.id.emotion_single_thread_empty), tbPageContext.getString(R.string.emotion_empty_single_thread));
        this.f17436f.setDivider(null);
        this.f17436f.setOverScrollMode(2);
        this.f17436f.setVerticalScrollBarEnabled(false);
        this.f17437g = new c.a.r0.e2.h.d.b(tbPageContext, this.f17436f);
        g();
    }

    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f17439i : (View) invokeV.objValue;
    }

    public void b() {
        FrameLayout frameLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f17440j == null || (frameLayout = this.k) == null) {
            return;
        }
        frameLayout.setVisibility(8);
        this.f17440j.dettachView(this.k);
        this.f17440j = null;
    }

    public final void c() {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (noDataView = this.l) != null && noDataView.getParent() == this.k) {
            this.l.setVisibility(8);
            this.k.removeView(this.l);
            this.k.setVisibility(8);
        }
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            View view = this.f17439i;
            if (view != null) {
                SkinManager.setBackgroundColor(view, R.color.cp_bg_line_d_alpha90, i2);
            }
            BdListView bdListView = this.f17436f;
            if (bdListView != null) {
                SkinManager.setBackgroundColor(bdListView, R.color.CAM_X0201, i2);
            }
            b bVar = this.f17438h;
            if (bVar != null) {
                bVar.b(i2);
            }
            NoNetworkView noNetworkView = this.n;
            if (noNetworkView != null) {
                noNetworkView.onChangeSkinType(this.f17435e, i2);
            }
            FrameLayout frameLayout = this.k;
            if (frameLayout != null) {
                SkinManager.setBackgroundColor(frameLayout, R.color.CAM_X0201, i2);
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

    public final void f() {
        BdListView bdListView;
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (bdListView = this.f17436f) == null || this.m || (bVar = this.f17438h) == null) {
            return;
        }
        this.m = true;
        bdListView.setEmptyView(bVar.a());
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.f17435e == null || this.k == null) {
            return;
        }
        e();
        this.k.setVisibility(0);
        if (this.f17440j == null) {
            this.f17440j = new g(this.f17435e.getPageActivity());
        }
        this.f17440j.attachView(this.k, true);
        this.f17440j.onChangeSkinType();
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.f17435e == null || this.k == null) {
            return;
        }
        e();
        this.k.setVisibility(0);
        NoDataView b2 = NoDataViewFactory.b(this.f17435e.getPageActivity(), this.k, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.WEBVIEW, l.g(this.f17435e.getPageActivity(), R.dimen.ds110)), NoDataViewFactory.e.d(null, this.f17435e.getString(R.string.emotion_error_net_tip)), null, true);
        this.l = b2;
        b2.setVisibility(0);
        this.l.onActivityStart(this.f17435e);
    }

    public void i(List<EmotionPackageData> list) {
        c.a.r0.e2.h.d.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list) == null) {
            f();
            if (list == null || (bVar = this.f17437g) == null) {
                return;
            }
            bVar.a(list);
        }
    }

    public void onNetworkChange(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048585, this, z) == null) && z) {
            g();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921314));
        }
    }
}
