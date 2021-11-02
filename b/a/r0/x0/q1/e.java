package b.a.r0.x0.q1;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b.a.e.e.p.l;
import b.a.r0.x0.b1;
import b.a.r0.x0.c1;
import b.a.r0.x0.e1;
import b.a.r0.x0.h1;
import b.a.r0.x0.t;
import b.a.r0.x0.z;
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
/* loaded from: classes5.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public FrsADFragment f26195a;

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f26196b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeRecyclerView f26197c;

    /* renamed from: d  reason: collision with root package name */
    public FrameLayout f26198d;

    /* renamed from: e  reason: collision with root package name */
    public PbListView f26199e;

    /* renamed from: f  reason: collision with root package name */
    public b.a.r0.x0.q1.a f26200f;

    /* loaded from: classes5.dex */
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
            PlayVoiceBnt playVoiceBnt = (PlayVoiceBnt) view.findViewById(e1.abstract_voice);
            if (playVoiceBnt != null) {
                playVoiceBnt.reset();
            }
            FrsCommonImageLayout frsCommonImageLayout = (FrsCommonImageLayout) view.findViewById(e1.abstract_img_layout);
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
        this.f26195a = frsADFragment;
        e(view);
    }

    public BdTypeRecyclerView a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f26197c : (BdTypeRecyclerView) invokeV.objValue;
    }

    public RelativeLayout b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f26196b : (RelativeLayout) invokeV.objValue;
    }

    public b.a.r0.x0.q1.a c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f26200f : (b.a.r0.x0.q1.a) invokeV.objValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f26197c.setNextPage(null);
        }
    }

    public final void e(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view) == null) {
            this.f26196b = (RelativeLayout) view.findViewById(e1.frs_ad_container);
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) view.findViewById(e1.frs_ad_listview);
            this.f26197c = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(bdTypeRecyclerView.getContext()));
            this.f26197c.setFadingEdgeLength(0);
            this.f26197c.setOverScrollMode(2);
            this.f26197c.setRecyclerListener(new a(this));
            this.f26197c.setOnSrollToBottomListener(this.f26195a);
            this.f26200f = new b.a.r0.x0.q1.a(this.f26195a, this.f26197c);
            PbListView pbListView = new PbListView(this.f26195a.getPageContext().getPageActivity());
            this.f26199e = pbListView;
            pbListView.a();
            this.f26199e.p(b1.CAM_X0205);
            this.f26199e.s(l.g(this.f26195a.getActivity(), c1.tbds182));
            this.f26199e.x();
            this.f26199e.G(c1.tbfontsize33);
            this.f26199e.E(SkinManager.getColor(b1.CAM_X0107));
            this.f26199e.A(b1.CAM_X0110);
            this.f26198d = (FrameLayout) view.findViewById(e1.frs_ad_list_content);
            j(false);
        }
    }

    public void f() {
        b.a.r0.x0.q1.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (aVar = this.f26200f) == null) {
            return;
        }
        aVar.b();
    }

    public void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.f26195a.getBaseFragmentActivity().getLayoutMode().k(i2 == 1);
            this.f26195a.getBaseFragmentActivity().getLayoutMode().j(this.f26196b);
            PbListView pbListView = this.f26199e;
            if (pbListView != null) {
                pbListView.E(SkinManager.getColor(b1.CAM_X0107));
                this.f26199e.d(i2);
            }
            b.a.r0.x0.q1.a aVar = this.f26200f;
            if (aVar != null) {
                aVar.b();
            }
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f26200f.c();
            this.f26197c.setOnSrollToBottomListener(null);
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            t tVar = new t();
            tVar.f26328a = 90;
            tVar.f26329b = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
        }
    }

    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048585, this, z) == null) || z) {
            return;
        }
        t tVar = new t();
        tVar.f26328a = 90;
        tVar.f26329b = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
    }

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.f26198d.setVisibility(z ? 0 : 8);
        }
    }

    public void l(RecyclerView.OnScrollListener onScrollListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, onScrollListener) == null) {
            this.f26197c.setOnScrollListener(onScrollListener);
        }
    }

    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            z zVar = new z();
            zVar.f26943a = 90;
            zVar.f26945c = z;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(9205410, zVar));
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.f26197c.setNextPage(this.f26199e);
            this.f26199e.L(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.f26199e.Q();
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.f26197c.setNextPage(this.f26199e);
            this.f26199e.L(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.f26199e.f();
            this.f26199e.C(this.f26195a.getResources().getString(h1.list_no_more));
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            t tVar = new t();
            tVar.f26328a = 90;
            tVar.f26329b = true;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
        }
    }
}
