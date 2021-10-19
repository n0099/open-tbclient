package c.a.r0.x0.n1.f.a;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.e.e.p.j;
import c.a.q0.b.d;
import c.a.q0.d1.f0;
import c.a.r0.k3.o0.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f27450a;

    /* renamed from: b  reason: collision with root package name */
    public FrsFragment f27451b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f27452c;

    /* renamed from: d  reason: collision with root package name */
    public FrsTabSortSwitchButton f27453d;

    /* renamed from: e  reason: collision with root package name */
    public String f27454e;

    /* renamed from: f  reason: collision with root package name */
    public int f27455f;

    /* renamed from: g  reason: collision with root package name */
    public FrsTabSortSwitchButton.e f27456g;

    /* loaded from: classes4.dex */
    public class a implements FrsTabSortSwitchButton.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f27457a;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27457a = bVar;
        }

        @Override // com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.e
        public boolean a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                boolean z = false;
                if (!c.a.r0.x0.b.f().i() && !c.a.r0.x0.a.h().j()) {
                    if (!j.A()) {
                        this.f27457a.f27451b.showToast(R.string.neterror);
                        return false;
                    } else if (this.f27457a.f27451b.getModelController() != null && this.f27457a.f27451b.getFrsView() != null) {
                        z = true;
                        if (this.f27457a.f27455f == i2) {
                            return true;
                        }
                        this.f27457a.f27451b.getModelController().N0(this.f27457a.f27453d.getSwitchMenuId(this.f27457a.f27455f));
                        this.f27457a.f27455f = i2;
                        if (this.f27457a.f27455f != 7) {
                            f0.c();
                            e.a();
                        } else {
                            e.b();
                        }
                        this.f27457a.f27451b.getModelController().J0(this.f27457a.f27453d.getSwitchMenuId(this.f27457a.f27455f));
                        if (d.q()) {
                            c.a.q0.b.g.a.f(this.f27457a.f27453d.getSwitchMenuId(this.f27457a.f27455f));
                        }
                        this.f27457a.f27451b.getModelController().M0(true);
                        this.f27457a.f27451b.getFrsView().R1();
                        this.f27457a.f27451b.getModelController().L0(true);
                        this.f27457a.f();
                    }
                }
                return z;
            }
            return invokeI.booleanValue;
        }
    }

    public b(FrsFragment frsFragment, RelativeLayout relativeLayout) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, relativeLayout};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f27455f = -1;
        this.f27456g = new a(this);
        if (frsFragment == null || relativeLayout == null) {
            return;
        }
        this.f27451b = frsFragment;
        View inflate = LayoutInflater.from(frsFragment.getContext()).inflate(R.layout.frs_sort_tab_layout, relativeLayout);
        this.f27450a = inflate;
        inflate.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X003), 0, UtilHelper.getDimenPixelSize(R.dimen.M_W_X003), 0);
        this.f27452c = (TextView) this.f27450a.findViewById(R.id.sort_tab_sort_name);
        FrsTabSortSwitchButton frsTabSortSwitchButton = (FrsTabSortSwitchButton) this.f27450a.findViewById(R.id.sort_tab_switch_btn);
        this.f27453d = frsTabSortSwitchButton;
        frsTabSortSwitchButton.setOnSwitchChangeListener(this.f27456g);
        this.f27455f = this.f27453d.getState();
        i();
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c11437");
            statisticItem.param("obj_type", this.f27453d.getSwitchMenuId(this.f27455f));
            statisticItem.param("fid", this.f27454e);
            TiebaStatic.log(statisticItem);
        }
    }

    public void g(int i2) {
        FrsTabSortSwitchButton frsTabSortSwitchButton;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || (frsTabSortSwitchButton = this.f27453d) == null) {
            return;
        }
        frsTabSortSwitchButton.changeState(i2);
        this.f27455f = this.f27453d.getState();
    }

    public FrsTabSortSwitchButton h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f27453d : (FrsTabSortSwitchButton) invokeV.objValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            FrsTabSortSwitchButton frsTabSortSwitchButton = this.f27453d;
            if (frsTabSortSwitchButton != null) {
                frsTabSortSwitchButton.onChangeSkinType();
            }
            SkinManager.setViewTextColor(this.f27452c, R.color.CAM_X0108);
        }
    }

    public void j(List<FrsTabInfo> list) {
        FrsTabSortSwitchButton frsTabSortSwitchButton;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, list) == null) || (frsTabSortSwitchButton = this.f27453d) == null) {
            return;
        }
        frsTabSortSwitchButton.setData(list);
    }

    public void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.f27454e = str;
        }
    }
}
