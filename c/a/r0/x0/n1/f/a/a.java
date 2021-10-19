package c.a.r0.x0.n1.f.a;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.e.e.p.j;
import c.a.q0.b.d;
import c.a.q0.d1.f0;
import c.a.r0.k3.o0.e;
import c.a.r0.x0.n2.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.commontab.FrsCommonTabFragment;
import com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton;
import com.baidu.tieba.frs.mc.FrsNewAreaFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f27442a;

    /* renamed from: b  reason: collision with root package name */
    public BaseFragment f27443b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f27444c;

    /* renamed from: d  reason: collision with root package name */
    public FrsTabSortSwitchButton f27445d;

    /* renamed from: e  reason: collision with root package name */
    public int f27446e;

    /* renamed from: f  reason: collision with root package name */
    public String f27447f;

    /* renamed from: g  reason: collision with root package name */
    public FrsTabSortSwitchButton.e f27448g;

    /* renamed from: c.a.r0.x0.n1.f.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1285a implements FrsTabSortSwitchButton.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f27449a;

        public C1285a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27449a = aVar;
        }

        /* JADX WARN: Code restructure failed: missing block: B:25:0x0078, code lost:
            if (((com.baidu.tieba.frs.commontab.FrsCommonTabFragment) r4.f27449a.f27443b).getMainView() != null) goto L18;
         */
        @Override // com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.e
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                boolean z = false;
                if (!c.a.r0.x0.b.f().i() && !c.a.r0.x0.a.h().j()) {
                    if (!j.A()) {
                        this.f27449a.f27443b.showToast(R.string.neterror);
                        return false;
                    }
                    if (this.f27449a.f27443b instanceof FrsNewAreaFragment) {
                        if (((FrsNewAreaFragment) this.f27449a.f27443b).getModelController() == null || ((FrsNewAreaFragment) this.f27449a.f27443b).getFrsView() == null) {
                            return false;
                        }
                    } else if (this.f27449a.f27443b instanceof FrsCommonTabFragment) {
                        if (((FrsCommonTabFragment) this.f27449a.f27443b).getModelController() != null) {
                        }
                    }
                    z = true;
                    if (this.f27449a.f27446e == i2) {
                        return true;
                    }
                    this.f27449a.f27446e = i2;
                    if (this.f27449a.f27446e != 7) {
                        f0.c();
                        e.a();
                    } else {
                        e.b();
                    }
                    if (this.f27449a.f27443b instanceof FrsNewAreaFragment) {
                        ((FrsNewAreaFragment) this.f27449a.f27443b).getModelController().L(this.f27449a.f27445d.getSwitchMenuId(this.f27449a.f27446e));
                        if (d.q()) {
                            c.a.q0.b.g.a.f(this.f27449a.f27445d.getSwitchMenuId(this.f27449a.f27446e));
                        }
                        ((FrsNewAreaFragment) this.f27449a.f27443b).getFrsView().L();
                    } else {
                        ((FrsCommonTabFragment) this.f27449a.f27443b).setSortType(k.d(this.f27449a.f27445d.getSwitchMenuId(this.f27449a.f27446e)));
                        ((FrsCommonTabFragment) this.f27449a.f27443b).getMainView().x(true);
                    }
                    this.f27449a.f();
                }
                return z;
            }
            return invokeI.booleanValue;
        }
    }

    public a(BaseFragment baseFragment, RelativeLayout relativeLayout) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragment, relativeLayout};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f27446e = -1;
        this.f27448g = new C1285a(this);
        if (baseFragment == null || relativeLayout == null) {
            return;
        }
        this.f27443b = baseFragment;
        View inflate = LayoutInflater.from(baseFragment.getContext()).inflate(R.layout.frs_sort_tab_layout, relativeLayout);
        this.f27442a = inflate;
        inflate.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X003), 0, UtilHelper.getDimenPixelSize(R.dimen.M_W_X003), 0);
        this.f27444c = (TextView) this.f27442a.findViewById(R.id.sort_tab_sort_name);
        FrsTabSortSwitchButton frsTabSortSwitchButton = (FrsTabSortSwitchButton) this.f27442a.findViewById(R.id.sort_tab_switch_btn);
        this.f27445d = frsTabSortSwitchButton;
        frsTabSortSwitchButton.setOnSwitchChangeListener(this.f27448g);
        this.f27446e = this.f27445d.getState();
        h();
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c11437");
            statisticItem.param("obj_type", this.f27445d.getSwitchMenuId(this.f27446e));
            statisticItem.param("fid", this.f27447f);
            TiebaStatic.log(statisticItem);
        }
    }

    public void g(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || this.f27445d == null) {
            return;
        }
        this.f27445d.changeState(k.f(i2));
        this.f27446e = this.f27445d.getState();
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            FrsTabSortSwitchButton frsTabSortSwitchButton = this.f27445d;
            if (frsTabSortSwitchButton != null) {
                frsTabSortSwitchButton.onChangeSkinType();
            }
            SkinManager.setViewTextColor(this.f27444c, R.color.CAM_X0105);
        }
    }

    public void i(List<FrsTabInfo> list) {
        FrsTabSortSwitchButton frsTabSortSwitchButton;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, list) == null) || (frsTabSortSwitchButton = this.f27445d) == null) {
            return;
        }
        frsTabSortSwitchButton.setData(list);
    }

    public void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.f27447f = str;
        }
    }
}
