package b.a.r0.x0.r1;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b.a.e.f.p.l;
import b.a.r0.x0.a0;
import b.a.r0.x0.c1;
import b.a.r0.x0.d1;
import b.a.r0.x0.f1;
import b.a.r0.x0.i1;
import b.a.r0.x0.t;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.UserPhotoLayout;
import com.baidu.tieba.frs.ad.FrsADFragment;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public FrsADFragment f27790a;

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f27791b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeRecyclerView f27792c;

    /* renamed from: d  reason: collision with root package name */
    public FrameLayout f27793d;

    /* renamed from: e  reason: collision with root package name */
    public PbListView f27794e;

    /* renamed from: f  reason: collision with root package name */
    public b.a.r0.x0.r1.a f27795f;

    /* loaded from: classes6.dex */
    public class a implements RecyclerView.RecyclerListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, viewHolder) == null) || (view = viewHolder.itemView) == null) {
                return;
            }
            PlayVoiceBnt playVoiceBnt = (PlayVoiceBnt) view.findViewById(f1.abstract_voice);
            if (playVoiceBnt != null) {
                playVoiceBnt.reset();
            }
            FrsCommonImageLayout frsCommonImageLayout = (FrsCommonImageLayout) view.findViewById(f1.abstract_img_layout);
            if (frsCommonImageLayout != null) {
                frsCommonImageLayout.reset();
            }
            if (view instanceof UserPhotoLayout) {
                ((UserPhotoLayout) view).reset();
            }
        }
    }

    public e(FrsADFragment frsADFragment, View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsADFragment, view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f27790a = frsADFragment;
        e(view);
    }

    public BdTypeRecyclerView a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f27792c : (BdTypeRecyclerView) invokeV.objValue;
    }

    public RelativeLayout b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f27791b : (RelativeLayout) invokeV.objValue;
    }

    public b.a.r0.x0.r1.a c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f27795f : (b.a.r0.x0.r1.a) invokeV.objValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f27792c.setNextPage(null);
        }
    }

    public final void e(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view) == null) {
            this.f27791b = (RelativeLayout) view.findViewById(f1.frs_ad_container);
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) view.findViewById(f1.frs_ad_listview);
            this.f27792c = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(bdTypeRecyclerView.getContext()));
            this.f27792c.setFadingEdgeLength(0);
            this.f27792c.setOverScrollMode(2);
            this.f27792c.setRecyclerListener(new a(this));
            this.f27792c.setOnSrollToBottomListener(this.f27790a);
            this.f27795f = new b.a.r0.x0.r1.a(this.f27790a, this.f27792c);
            PbListView pbListView = new PbListView(this.f27790a.getPageContext().getPageActivity());
            this.f27794e = pbListView;
            pbListView.a();
            this.f27794e.p(c1.CAM_X0205);
            this.f27794e.s(l.g(this.f27790a.getActivity(), d1.tbds182));
            this.f27794e.x();
            this.f27794e.G(d1.tbfontsize33);
            this.f27794e.E(SkinManager.getColor(c1.CAM_X0107));
            this.f27794e.A(c1.CAM_X0110);
            this.f27793d = (FrameLayout) view.findViewById(f1.frs_ad_list_content);
            j(false);
        }
    }

    public void f() {
        b.a.r0.x0.r1.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (aVar = this.f27795f) == null) {
            return;
        }
        aVar.b();
    }

    public void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.f27790a.getBaseFragmentActivity().getLayoutMode().k(i2 == 1);
            this.f27790a.getBaseFragmentActivity().getLayoutMode().j(this.f27791b);
            PbListView pbListView = this.f27794e;
            if (pbListView != null) {
                pbListView.E(SkinManager.getColor(c1.CAM_X0107));
                this.f27794e.d(i2);
            }
            b.a.r0.x0.r1.a aVar = this.f27795f;
            if (aVar != null) {
                aVar.b();
            }
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f27795f.c();
            this.f27792c.setOnSrollToBottomListener(null);
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            t tVar = new t();
            tVar.f27908a = 90;
            tVar.f27909b = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
        }
    }

    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048585, this, z) == null) || z) {
            return;
        }
        t tVar = new t();
        tVar.f27908a = 90;
        tVar.f27909b = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
    }

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.f27793d.setVisibility(z ? 0 : 8);
        }
    }

    public void l(RecyclerView.OnScrollListener onScrollListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, onScrollListener) == null) {
            this.f27792c.setOnScrollListener(onScrollListener);
        }
    }

    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            a0 a0Var = new a0();
            a0Var.f26957a = 90;
            a0Var.f26959c = z;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(9205410, a0Var));
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.f27792c.setNextPage(this.f27794e);
            this.f27794e.L(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.f27794e.Q();
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.f27792c.setNextPage(this.f27794e);
            this.f27794e.L(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.f27794e.f();
            this.f27794e.C(this.f27790a.getResources().getString(i1.list_no_more));
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            t tVar = new t();
            tVar.f27908a = 90;
            tVar.f27909b = true;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
        }
    }
}
