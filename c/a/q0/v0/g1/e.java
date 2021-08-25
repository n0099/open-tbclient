package c.a.q0.v0.g1;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c.a.e.e.p.l;
import c.a.q0.v0.t;
import c.a.q0.v0.z;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.UserPhotoLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ad.FrsADFragment;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public FrsADFragment f26102a;

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f26103b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeRecyclerView f26104c;

    /* renamed from: d  reason: collision with root package name */
    public FrameLayout f26105d;

    /* renamed from: e  reason: collision with root package name */
    public PbListView f26106e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.q0.v0.g1.a f26107f;

    /* loaded from: classes4.dex */
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
            PlayVoiceBnt playVoiceBnt = (PlayVoiceBnt) view.findViewById(R.id.abstract_voice);
            if (playVoiceBnt != null) {
                playVoiceBnt.reset();
            }
            FrsCommonImageLayout frsCommonImageLayout = (FrsCommonImageLayout) view.findViewById(R.id.abstract_img_layout);
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
        this.f26102a = frsADFragment;
        e(view);
    }

    public BdTypeRecyclerView a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f26104c : (BdTypeRecyclerView) invokeV.objValue;
    }

    public RelativeLayout b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f26103b : (RelativeLayout) invokeV.objValue;
    }

    public c.a.q0.v0.g1.a c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f26107f : (c.a.q0.v0.g1.a) invokeV.objValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f26104c.setNextPage(null);
        }
    }

    public final void e(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view) == null) {
            this.f26103b = (RelativeLayout) view.findViewById(R.id.frs_ad_container);
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) view.findViewById(R.id.frs_ad_listview);
            this.f26104c = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(bdTypeRecyclerView.getContext()));
            this.f26104c.setFadingEdgeLength(0);
            this.f26104c.setOverScrollMode(2);
            this.f26104c.setRecyclerListener(new a(this));
            this.f26104c.setOnSrollToBottomListener(this.f26102a);
            this.f26107f = new c.a.q0.v0.g1.a(this.f26102a, this.f26104c);
            PbListView pbListView = new PbListView(this.f26102a.getPageContext().getPageActivity());
            this.f26106e = pbListView;
            pbListView.a();
            this.f26106e.o(R.color.CAM_X0205);
            this.f26106e.r(l.g(this.f26102a.getActivity(), R.dimen.tbds182));
            this.f26106e.v();
            this.f26106e.E(R.dimen.tbfontsize33);
            this.f26106e.C(SkinManager.getColor(R.color.CAM_X0107));
            this.f26106e.y(R.color.CAM_X0110);
            this.f26105d = (FrameLayout) view.findViewById(R.id.frs_ad_list_content);
            j(false);
        }
    }

    public void f() {
        c.a.q0.v0.g1.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (aVar = this.f26107f) == null) {
            return;
        }
        aVar.b();
    }

    public void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.f26102a.getBaseFragmentActivity().getLayoutMode().k(i2 == 1);
            this.f26102a.getBaseFragmentActivity().getLayoutMode().j(this.f26103b);
            PbListView pbListView = this.f26106e;
            if (pbListView != null) {
                pbListView.C(SkinManager.getColor(R.color.CAM_X0107));
                this.f26106e.d(i2);
            }
            c.a.q0.v0.g1.a aVar = this.f26107f;
            if (aVar != null) {
                aVar.b();
            }
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f26107f.c();
            this.f26104c.setOnSrollToBottomListener(null);
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            t tVar = new t();
            tVar.f27158a = 90;
            tVar.f27159b = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
        }
    }

    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048585, this, z) == null) || z) {
            return;
        }
        t tVar = new t();
        tVar.f27158a = 90;
        tVar.f27159b = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
    }

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.f26105d.setVisibility(z ? 0 : 8);
        }
    }

    public void l(RecyclerView.OnScrollListener onScrollListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, onScrollListener) == null) {
            this.f26104c.setOnScrollListener(onScrollListener);
        }
    }

    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            z zVar = new z();
            zVar.f27379a = 90;
            zVar.f27381c = z;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(9205410, zVar));
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.f26104c.setNextPage(this.f26106e);
            this.f26106e.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.f26106e.O();
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.f26104c.setNextPage(this.f26106e);
            this.f26106e.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.f26106e.f();
            this.f26106e.A(this.f26102a.getResources().getString(R.string.list_no_more));
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            t tVar = new t();
            tVar.f27158a = 90;
            tVar.f27159b = true;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
        }
    }
}
