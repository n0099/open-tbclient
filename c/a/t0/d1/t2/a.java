package c.a.t0.d1.t2;

import android.widget.FrameLayout;
import android.widget.TextView;
import c.a.d.f.p.n;
import c.a.t0.d1.c1;
import c.a.t0.d1.d1;
import c.a.t0.d1.i1;
import c.a.t0.d1.n1;
import c.a.t0.d1.q;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final FrsFragment a;

    /* renamed from: b  reason: collision with root package name */
    public n1 f16923b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f16924c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f16925d;

    /* renamed from: e  reason: collision with root package name */
    public int f16926e;

    public a(FrsFragment frsFragment) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f16926e = -1;
        if (frsFragment != null) {
            this.a = frsFragment;
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                UtilHelper.getStatusBarHeight();
                return;
            }
            return;
        }
        throw new NullPointerException("FrsFragment is null");
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            if (i2 >= 0) {
                d(true);
                e(i2);
                return;
            }
            d(false);
            e(i2);
        }
    }

    public void b() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.f16925d && (i2 = this.f16926e) >= 0) {
                f(i2);
            }
            this.f16925d = false;
        }
    }

    public void c() {
        n1 n1Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (n1Var = this.f16923b) == null) {
            return;
        }
        n1Var.e();
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.f16925d = z;
        }
    }

    public void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f16926e = i2;
        }
    }

    public final void f(int i2) {
        q frsView;
        FrameLayout frameLayout;
        String string;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i2) == null) || (frsView = this.a.getFrsView()) == null || frsView.a0() == null || (frameLayout = (FrameLayout) frsView.U()) == null) {
            return;
        }
        if (this.f16924c == null && this.a.getPageContext() != null) {
            TextView textView = new TextView(this.a.getPageContext().getPageActivity());
            this.f16924c = textView;
            textView.setTextSize(0, this.a.getResources().getDimensionPixelSize(d1.fontsize28));
            this.f16924c.setGravity(17);
        }
        if (this.f16924c != null) {
            if (i2 > 0) {
                string = String.format(TbadkCoreApplication.getInst().getString(i1.recommend_frs_refresh_return), Integer.valueOf(i2));
            } else {
                string = TbadkCoreApplication.getInst().getString(i1.smart_frs_refresh_nodata);
            }
            this.f16924c.setText(string);
        }
        SkinManager.setBackgroundResource(this.f16924c, c1.CAM_X0302);
        SkinManager.setViewTextColor(this.f16924c, c1.CAM_X0112);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, n.f(TbadkCoreApplication.getInst(), d1.ds56));
        if (this.f16923b == null) {
            this.f16923b = new n1();
        }
        this.f16923b.h(this.f16924c, frameLayout, layoutParams, 2000);
        this.f16926e = -1;
    }
}
