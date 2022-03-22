package c.a.p0.r2.h.f;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.o0.e1.e.a;
import c.a.o0.f0.g;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.widget.dragsort.SimpleDragSortListView;
import com.baidu.tieba.R;
import com.baidu.tieba.faceshop.EmotionPackageData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes2.dex */
public class d implements Object<List<EmotionPackageData>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public SimpleDragSortListView f18090b;

    /* renamed from: c  reason: collision with root package name */
    public View f18091c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.p0.r2.h.d.a f18092d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.p0.r2.h.f.b f18093e;

    /* renamed from: f  reason: collision with root package name */
    public g f18094f;

    /* renamed from: g  reason: collision with root package name */
    public FrameLayout f18095g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f18096h;
    public c.a.p0.r2.h.b.a i;
    public NoDataView j;
    public NoNetworkView k;

    /* loaded from: classes2.dex */
    public class a implements a.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        @Override // c.a.o0.e1.e.a.i
        public void a(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
                this.a.f18092d.a(i, i2);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f18097b;

        public b(d dVar, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18097b = dVar;
            this.a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f18097b.j();
                if (this.f18097b.f18092d == null || this.a == null) {
                    return;
                }
                this.f18097b.f18092d.update(this.a);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public c(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.f18092d == null) {
                return;
            }
            this.a.f18092d.update();
        }
    }

    public d(TbPageContext tbPageContext) {
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
        this.f18096h = false;
        this.a = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d02e7, (ViewGroup) null, false);
        this.f18091c = inflate;
        this.f18095g = (FrameLayout) inflate.findViewById(R.id.obfuscated_res_0x7f091496);
        this.k = (NoNetworkView) this.f18091c.findViewById(R.id.obfuscated_res_0x7f0923d1);
        this.f18093e = new c.a.p0.r2.h.f.b(this.f18091c.findViewById(R.id.obfuscated_res_0x7f0908a3), tbPageContext.getString(R.string.obfuscated_res_0x7f0f0539));
        SimpleDragSortListView simpleDragSortListView = (SimpleDragSortListView) this.f18091c.findViewById(R.id.obfuscated_res_0x7f091495);
        this.f18090b = simpleDragSortListView;
        simpleDragSortListView.setDivider(null);
        this.f18090b.setOverScrollMode(2);
        this.f18090b.setVerticalScrollBarEnabled(false);
        k();
        this.f18092d = new c.a.p0.r2.h.d.a(tbPageContext, this.f18090b, this.i);
        l();
        this.k.a(this);
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f18091c : (View) invokeV.objValue;
    }

    public void d() {
        FrameLayout frameLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f18094f == null || (frameLayout = this.f18095g) == null) {
            return;
        }
        frameLayout.setVisibility(8);
        this.f18094f.dettachView(this.f18095g);
        this.f18094f = null;
    }

    public final void e() {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (noDataView = this.j) != null && noDataView.getParent() == this.f18095g) {
            this.j.setVisibility(8);
            this.f18095g.removeView(this.j);
            this.f18095g.setVisibility(8);
        }
    }

    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048579, this, z) == null) && z) {
            l();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921054));
        }
    }

    public void g(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            c.a.p0.r2.h.f.b bVar = this.f18093e;
            if (bVar != null) {
                bVar.b(i);
            }
            FrameLayout frameLayout = this.f18095g;
            if (frameLayout != null) {
                SkinManager.setBackgroundColor(frameLayout, R.color.CAM_X0201, i);
            }
            c.a.p0.r2.h.f.b bVar2 = this.f18093e;
            if (bVar2 != null) {
                SkinManager.setBackgroundColor(bVar2.a(), R.color.CAM_X0201, i);
            }
            SimpleDragSortListView simpleDragSortListView = this.f18090b;
            if (simpleDragSortListView != null) {
                SkinManager.setBackgroundColor(simpleDragSortListView, R.color.CAM_X0201, i);
            }
            NoNetworkView noNetworkView = this.k;
            if (noNetworkView != null) {
                noNetworkView.c(this.a, i);
            }
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            c.a.d.f.m.e.a().post(new c(this));
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            d();
            e();
        }
    }

    public final void j() {
        SimpleDragSortListView simpleDragSortListView;
        c.a.p0.r2.h.f.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (simpleDragSortListView = this.f18090b) == null || this.f18096h || (bVar = this.f18093e) == null) {
            return;
        }
        this.f18096h = true;
        simpleDragSortListView.setEmptyView(bVar.a());
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            c.a.p0.r2.h.b.a aVar = new c.a.p0.r2.h.b.a(this.f18090b);
            this.i = aVar;
            aVar.c(new a(this));
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || this.a == null || this.f18095g == null) {
            return;
        }
        i();
        this.f18095g.setVisibility(0);
        g gVar = new g(this.a.getPageActivity());
        this.f18094f = gVar;
        gVar.attachView(this.f18095g, true);
        this.f18094f.onChangeSkinType();
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.a == null || this.f18095g == null) {
            return;
        }
        i();
        this.f18095g.setVisibility(0);
        NoDataView b2 = NoDataViewFactory.b(this.a.getPageActivity(), this.f18095g, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.WEBVIEW, n.f(this.a.getPageActivity(), R.dimen.obfuscated_res_0x7f07022e)), NoDataViewFactory.e.d(null, this.a.getString(R.string.obfuscated_res_0x7f0f053c)), null, true);
        this.j = b2;
        b2.setVisibility(0);
        this.j.d(this.a);
    }

    /* JADX DEBUG: Method merged with bridge method */
    public void update(List<EmotionPackageData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, list) == null) {
            c.a.d.f.m.e.a().post(new b(this, list));
        }
    }
}
