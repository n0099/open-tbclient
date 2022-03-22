package c.a.p0.f1.p1.f.a;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.d.f.p.l;
import c.a.o0.c1.h0;
import c.a.p0.a4.q0.e;
import c.a.p0.f1.r2.p;
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
    public BaseFragment f14362b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f14363c;

    /* renamed from: d  reason: collision with root package name */
    public FrsTabSortSwitchButton f14364d;

    /* renamed from: e  reason: collision with root package name */
    public int f14365e;

    /* renamed from: f  reason: collision with root package name */
    public String f14366f;

    /* renamed from: g  reason: collision with root package name */
    public FrsTabSortSwitchButton.e f14367g;

    /* renamed from: c.a.p0.f1.p1.f.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1082a implements FrsTabSortSwitchButton.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public C1082a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        /* JADX WARN: Code restructure failed: missing block: B:25:0x0079, code lost:
            if (((com.baidu.tieba.frs.commontab.FrsCommonTabFragment) r4.a.f14362b).R0() != null) goto L18;
         */
        @Override // com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.e
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                boolean z = false;
                if (!c.a.p0.f1.b.f().i() && !c.a.p0.f1.a.h().j()) {
                    if (!l.A()) {
                        this.a.f14362b.showToast(R.string.obfuscated_res_0x7f0f0c15);
                        return false;
                    }
                    if (this.a.f14362b instanceof FrsNewAreaFragment) {
                        if (((FrsNewAreaFragment) this.a.f14362b).l1() == null || ((FrsNewAreaFragment) this.a.f14362b).h1() == null) {
                            return false;
                        }
                    } else if (this.a.f14362b instanceof FrsCommonTabFragment) {
                        if (((FrsCommonTabFragment) this.a.f14362b).S0() != null) {
                        }
                    }
                    z = true;
                    if (this.a.f14365e == i) {
                        return true;
                    }
                    this.a.f14365e = i;
                    if (this.a.f14365e != 7) {
                        h0.c();
                        e.a();
                    } else {
                        e.b();
                    }
                    if (this.a.f14362b instanceof FrsNewAreaFragment) {
                        ((FrsNewAreaFragment) this.a.f14362b).l1().O(this.a.f14364d.w(this.a.f14365e));
                        if (UbsABTestHelper.isFrsNewAreaTabSortTestA()) {
                            FrsTabTestHelper.storeFrsNewAreaTabSort(this.a.f14364d.w(this.a.f14365e));
                        }
                        ((FrsNewAreaFragment) this.a.f14362b).h1().L();
                    } else {
                        ((FrsCommonTabFragment) this.a.f14362b).a1(p.d(this.a.f14364d.w(this.a.f14365e)));
                        ((FrsCommonTabFragment) this.a.f14362b).R0().x(true);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f14365e = -1;
        this.f14367g = new C1082a(this);
        if (baseFragment == null || relativeLayout == null) {
            return;
        }
        this.f14362b = baseFragment;
        View inflate = LayoutInflater.from(baseFragment.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0353, relativeLayout);
        this.a = inflate;
        inflate.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X003), 0, UtilHelper.getDimenPixelSize(R.dimen.M_W_X003), 0);
        this.f14363c = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f091d43);
        FrsTabSortSwitchButton frsTabSortSwitchButton = (FrsTabSortSwitchButton) this.a.findViewById(R.id.obfuscated_res_0x7f091d44);
        this.f14364d = frsTabSortSwitchButton;
        frsTabSortSwitchButton.setOnSwitchChangeListener(this.f14367g);
        this.f14365e = this.f14364d.getState();
        h();
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c11437");
            statisticItem.param("obj_type", this.f14364d.w(this.f14365e));
            statisticItem.param("fid", this.f14366f);
            TiebaStatic.log(statisticItem);
        }
    }

    public void g(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) || this.f14364d == null) {
            return;
        }
        this.f14364d.t(p.f(i));
        this.f14365e = this.f14364d.getState();
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            FrsTabSortSwitchButton frsTabSortSwitchButton = this.f14364d;
            if (frsTabSortSwitchButton != null) {
                frsTabSortSwitchButton.E();
            }
            SkinManager.setViewTextColor(this.f14363c, (int) R.color.CAM_X0105);
        }
    }

    public void i(List<FrsTabInfo> list) {
        FrsTabSortSwitchButton frsTabSortSwitchButton;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, list) == null) || (frsTabSortSwitchButton = this.f14364d) == null) {
            return;
        }
        frsTabSortSwitchButton.setData(list);
    }

    public void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.f14366f = str;
        }
    }
}
