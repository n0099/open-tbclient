package c.a.r0.d1.p1.f.a;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.d.f.p.l;
import c.a.q0.c1.h0;
import c.a.r0.d1.r2.p;
import c.a.r0.y3.q0.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.abtest.helper.FrsTabTestHelper;
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
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;

    /* renamed from: b  reason: collision with root package name */
    public BaseFragment f16010b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f16011c;

    /* renamed from: d  reason: collision with root package name */
    public FrsTabSortSwitchButton f16012d;

    /* renamed from: e  reason: collision with root package name */
    public int f16013e;

    /* renamed from: f  reason: collision with root package name */
    public String f16014f;

    /* renamed from: g  reason: collision with root package name */
    public FrsTabSortSwitchButton.e f16015g;

    /* renamed from: c.a.r0.d1.p1.f.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1023a implements FrsTabSortSwitchButton.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public C1023a(a aVar) {
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
            this.a = aVar;
        }

        /* JADX WARN: Code restructure failed: missing block: B:25:0x0079, code lost:
            if (((com.baidu.tieba.frs.commontab.FrsCommonTabFragment) r4.a.f16010b).getMainView() != null) goto L18;
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
                if (!c.a.r0.d1.b.f().i() && !c.a.r0.d1.a.h().j()) {
                    if (!l.A()) {
                        this.a.f16010b.showToast(R.string.neterror);
                        return false;
                    }
                    if (this.a.f16010b instanceof FrsNewAreaFragment) {
                        if (((FrsNewAreaFragment) this.a.f16010b).getModelController() == null || ((FrsNewAreaFragment) this.a.f16010b).getFrsView() == null) {
                            return false;
                        }
                    } else if (this.a.f16010b instanceof FrsCommonTabFragment) {
                        if (((FrsCommonTabFragment) this.a.f16010b).getModelController() != null) {
                        }
                    }
                    z = true;
                    if (this.a.f16013e == i2) {
                        return true;
                    }
                    this.a.f16013e = i2;
                    if (this.a.f16013e != 7) {
                        h0.c();
                        e.a();
                    } else {
                        e.b();
                    }
                    if (this.a.f16010b instanceof FrsNewAreaFragment) {
                        ((FrsNewAreaFragment) this.a.f16010b).getModelController().L(this.a.f16012d.getSwitchMenuId(this.a.f16013e));
                        if (UbsABTestHelper.isFrsNewAreaTabSortTestA()) {
                            FrsTabTestHelper.storeFrsNewAreaTabSort(this.a.f16012d.getSwitchMenuId(this.a.f16013e));
                        }
                        ((FrsNewAreaFragment) this.a.f16010b).getFrsView().L();
                    } else {
                        ((FrsCommonTabFragment) this.a.f16010b).setSortType(p.d(this.a.f16012d.getSwitchMenuId(this.a.f16013e)));
                        ((FrsCommonTabFragment) this.a.f16010b).getMainView().x(true);
                    }
                    this.a.f();
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
        this.f16013e = -1;
        this.f16015g = new C1023a(this);
        if (baseFragment == null || relativeLayout == null) {
            return;
        }
        this.f16010b = baseFragment;
        View inflate = LayoutInflater.from(baseFragment.getContext()).inflate(R.layout.frs_sort_tab_layout, relativeLayout);
        this.a = inflate;
        inflate.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X003), 0, UtilHelper.getDimenPixelSize(R.dimen.M_W_X003), 0);
        this.f16011c = (TextView) this.a.findViewById(R.id.sort_tab_sort_name);
        FrsTabSortSwitchButton frsTabSortSwitchButton = (FrsTabSortSwitchButton) this.a.findViewById(R.id.sort_tab_switch_btn);
        this.f16012d = frsTabSortSwitchButton;
        frsTabSortSwitchButton.setOnSwitchChangeListener(this.f16015g);
        this.f16013e = this.f16012d.getState();
        h();
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c11437");
            statisticItem.param("obj_type", this.f16012d.getSwitchMenuId(this.f16013e));
            statisticItem.param("fid", this.f16014f);
            TiebaStatic.log(statisticItem);
        }
    }

    public void g(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || this.f16012d == null) {
            return;
        }
        this.f16012d.changeState(p.f(i2));
        this.f16013e = this.f16012d.getState();
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            FrsTabSortSwitchButton frsTabSortSwitchButton = this.f16012d;
            if (frsTabSortSwitchButton != null) {
                frsTabSortSwitchButton.onChangeSkinType();
            }
            SkinManager.setViewTextColor(this.f16011c, (int) R.color.CAM_X0105);
        }
    }

    public void i(List<FrsTabInfo> list) {
        FrsTabSortSwitchButton frsTabSortSwitchButton;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, list) == null) || (frsTabSortSwitchButton = this.f16012d) == null) {
            return;
        }
        frsTabSortSwitchButton.setData(list);
    }

    public void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.f16014f = str;
        }
    }
}
