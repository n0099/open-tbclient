package c.a.q0.i2.k.e;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.view.ThreadCardView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class l {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static l f19471f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f19472a;

    /* renamed from: b  reason: collision with root package name */
    public long f19473b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f19474c;

    /* renamed from: d  reason: collision with root package name */
    public int f19475d;

    /* renamed from: e  reason: collision with root package name */
    public int f19476e;

    /* loaded from: classes3.dex */
    public class a extends c.a.p0.m0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.p0.m0.b
        public int getMaxCost() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 3;
            }
            return invokeV.intValue;
        }

        @Override // c.a.p0.m0.b
        public boolean isCurrentPageCanBeAddToSourceTrace() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1079327623, "Lc/a/q0/i2/k/e/l;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1079327623, "Lc/a/q0/i2/k/e/l;");
        }
    }

    public l() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f19472a = 0L;
        this.f19473b = 0L;
        this.f19474c = false;
        this.f19475d = 0;
        this.f19475d = c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds144);
        this.f19476e = c.a.e.e.p.l.i(TbadkCoreApplication.getInst());
    }

    public static l a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f19471f == null) {
                synchronized (l.class) {
                    if (f19471f == null) {
                        f19471f = new l();
                    }
                }
            }
            return f19471f;
        }
        return (l) invokeV.objValue;
    }

    public final boolean b(View view, ListView listView) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, listView)) == null) {
            if (view != null) {
                int[] iArr = new int[2];
                view.getLocationOnScreen(iArr);
                if (iArr[1] > 0 && iArr[1] < this.f19476e - this.f19475d) {
                    return true;
                }
            }
            if (listView != null && listView.getChildCount() > 2) {
                View childAt = listView.getChildAt(listView.getChildCount() - 3);
                if ((childAt instanceof ViewGroup) && (((ViewGroup) childAt).getChildAt(0) instanceof ThreadCardView)) {
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final boolean c(View view, View view2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, view2)) == null) {
            if (view == null || view2 == null) {
                return false;
            }
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            int i2 = iArr[1];
            if (view2.getVisibility() != 0) {
                return i2 > 0 && i2 < this.f19476e - this.f19475d;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            f19471f = null;
            this.f19472a = 0L;
            this.f19474c = false;
            this.f19473b = 0L;
        }
    }

    public final void e(Context context, c.a.p0.m0.d dVar, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048579, this, context, dVar, str) == null) || dVar == null || StringUtils.isNull(dVar.c()) || !new a(this).canStat(dVar)) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem(str);
        statisticItem.param("obj_source", c.a.p0.m0.c.a(dVar.h()));
        statisticItem.param("obj_type", dVar.c());
        statisticItem.param(TiebaStatic.Params.OBJ_DURATION, String.valueOf(dVar.i()));
        if (dVar.d() > 0) {
            statisticItem.param("fid", String.valueOf(dVar.d()));
        }
        if (dVar.m() > 0) {
            statisticItem.param("tid", String.valueOf(dVar.m()));
        }
        if (!StringUtils.isNull(dVar.e())) {
            statisticItem.param("nid", dVar.e());
        }
        if (dVar.g() > 0) {
            statisticItem.param("pid", String.valueOf(dVar.g()));
        }
        if (!StringUtils.isNull(dVar.k)) {
            statisticItem.param("obj_param1", dVar.k);
        }
        if (!StringUtils.isNull(dVar.l)) {
            statisticItem.param(TiebaStatic.Params.IS_VERTICAL, dVar.l);
        }
        if (!StringUtils.isNull(dVar.p)) {
            statisticItem.param("is_dynamic", dVar.p);
        }
        if (!StringUtils.isNull(dVar.q)) {
            statisticItem.param(TiebaStatic.Params.RESOURCE_ID, dVar.q);
        }
        if (!c.a.e.e.p.k.isEmpty(dVar.j())) {
            statisticItem.param("task_id", String.valueOf(dVar.j()));
        }
        if (!c.a.e.e.p.k.isEmpty(dVar.a())) {
            statisticItem.param("ab_tag", dVar.a());
        }
        if (!StringUtils.isNull(dVar.f())) {
            statisticItem.param("obj_location", dVar.f());
        }
        c.a.p0.k0.e.b(context, statisticItem, dVar);
        TiebaStatic.log(statisticItem);
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            h();
        }
    }

    public void g(boolean z, View view, View view2, c.a.p0.m0.d dVar, boolean z2, View view3, ListView listView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), view, view2, dVar, Boolean.valueOf(z2), view3, listView}) == null) {
            if (this.f19474c) {
                z = false;
            } else {
                this.f19474c = z;
            }
            if (c(view, view2) || (z && !z2)) {
                h();
            } else if (z2) {
                k(dVar);
            }
            if (b(view3, listView)) {
                i();
            } else {
                l(dVar);
            }
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && this.f19472a == 0) {
            this.f19472a = System.currentTimeMillis();
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.f19473b == 0) {
            this.f19473b = System.currentTimeMillis();
        }
    }

    public void j(AbsPbActivity absPbActivity) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, absPbActivity) == null) || absPbActivity == null) {
            return;
        }
        k(absPbActivity.getPageStayDurationItem());
        l(absPbActivity.getPageStayDurationItem());
    }

    public final void k(c.a.p0.m0.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, dVar) == null) || this.f19472a <= 0) {
            return;
        }
        this.f19472a = 0L;
        dVar.w(System.currentTimeMillis() - this.f19472a);
        e(TbadkCoreApplication.getInst(), dVar, "c14085");
    }

    public final void l(c.a.p0.m0.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, dVar) == null) || this.f19473b <= 0) {
            return;
        }
        this.f19473b = 0L;
        dVar.w(System.currentTimeMillis() - this.f19473b);
        e(TbadkCoreApplication.getInst(), dVar, "rec_stime");
    }
}
