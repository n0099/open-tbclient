package c.a.r0.l2.h.f;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.l;
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
/* loaded from: classes6.dex */
public class f implements Object<List<EmotionPackageData>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f19316e;

    /* renamed from: f  reason: collision with root package name */
    public BdListView f19317f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.r0.l2.h.d.b f19318g;

    /* renamed from: h  reason: collision with root package name */
    public b f19319h;

    /* renamed from: i  reason: collision with root package name */
    public View f19320i;

    /* renamed from: j  reason: collision with root package name */
    public g f19321j;

    /* renamed from: k  reason: collision with root package name */
    public FrameLayout f19322k;
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
        this.f19316e = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.fragment_single_thread_emotions, (ViewGroup) null, false);
        this.f19320i = inflate;
        NoNetworkView noNetworkView = (NoNetworkView) inflate.findViewById(R.id.view_no_network);
        this.n = noNetworkView;
        noNetworkView.addNetworkChangeListener(this);
        this.f19322k = (FrameLayout) this.f19320i.findViewById(R.id.single_emotion_loading);
        this.f19317f = (BdListView) this.f19320i.findViewById(R.id.emotion_single_thread_list);
        this.f19319h = new b(this.f19320i.findViewById(R.id.emotion_single_thread_empty), tbPageContext.getString(R.string.emotion_empty_single_thread));
        this.f19317f.setDivider(null);
        this.f19317f.setOverScrollMode(2);
        this.f19317f.setVerticalScrollBarEnabled(false);
        this.f19318g = new c.a.r0.l2.h.d.b(tbPageContext, this.f19317f);
        g();
    }

    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f19320i : (View) invokeV.objValue;
    }

    public void b() {
        FrameLayout frameLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f19321j == null || (frameLayout = this.f19322k) == null) {
            return;
        }
        frameLayout.setVisibility(8);
        this.f19321j.dettachView(this.f19322k);
        this.f19321j = null;
    }

    public final void c() {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (noDataView = this.l) != null && noDataView.getParent() == this.f19322k) {
            this.l.setVisibility(8);
            this.f19322k.removeView(this.l);
            this.f19322k.setVisibility(8);
        }
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            View view = this.f19320i;
            if (view != null) {
                SkinManager.setBackgroundColor(view, R.color.cp_bg_line_d_alpha90, i2);
            }
            BdListView bdListView = this.f19317f;
            if (bdListView != null) {
                SkinManager.setBackgroundColor(bdListView, R.color.CAM_X0201, i2);
            }
            b bVar = this.f19319h;
            if (bVar != null) {
                bVar.b(i2);
            }
            NoNetworkView noNetworkView = this.n;
            if (noNetworkView != null) {
                noNetworkView.onChangeSkinType(this.f19316e, i2);
            }
            FrameLayout frameLayout = this.f19322k;
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
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (bdListView = this.f19317f) == null || this.m || (bVar = this.f19319h) == null) {
            return;
        }
        this.m = true;
        bdListView.setEmptyView(bVar.a());
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.f19316e == null || this.f19322k == null) {
            return;
        }
        e();
        this.f19322k.setVisibility(0);
        if (this.f19321j == null) {
            this.f19321j = new g(this.f19316e.getPageActivity());
        }
        this.f19321j.attachView(this.f19322k, true);
        this.f19321j.onChangeSkinType();
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.f19316e == null || this.f19322k == null) {
            return;
        }
        e();
        this.f19322k.setVisibility(0);
        NoDataView b2 = NoDataViewFactory.b(this.f19316e.getPageActivity(), this.f19322k, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.WEBVIEW, l.f(this.f19316e.getPageActivity(), R.dimen.ds110)), NoDataViewFactory.e.d(null, this.f19316e.getString(R.string.emotion_error_net_tip)), null, true);
        this.l = b2;
        b2.setVisibility(0);
        this.l.onActivityStart(this.f19316e);
    }

    public void onNetworkChange(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) && z) {
            g();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921314));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    public void update(List<EmotionPackageData> list) {
        c.a.r0.l2.h.d.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, list) == null) {
            f();
            if (list == null || (bVar = this.f19318g) == null) {
                return;
            }
            bVar.update(list);
        }
    }
}
