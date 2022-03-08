package c.a.r0.d1.m2;

import android.widget.FrameLayout;
import android.widget.TextView;
import c.a.d.f.p.n;
import c.a.r0.d1.d1;
import c.a.r0.d1.q;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final FrsFragment a;

    /* renamed from: b  reason: collision with root package name */
    public d1 f15850b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f15851c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f15852d;

    /* renamed from: e  reason: collision with root package name */
    public int f15853e;

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
        this.f15853e = -1;
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
            if (this.f15852d && (i2 = this.f15853e) >= 0) {
                f(i2);
            }
            this.f15852d = false;
        }
    }

    public void c() {
        d1 d1Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (d1Var = this.f15850b) == null) {
            return;
        }
        d1Var.e();
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.f15852d = z;
        }
    }

    public void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f15853e = i2;
        }
    }

    public final void f(int i2) {
        q frsView;
        FrameLayout frameLayout;
        String string;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i2) == null) || (frsView = this.a.getFrsView()) == null || frsView.c0() == null || (frameLayout = (FrameLayout) frsView.V()) == null) {
            return;
        }
        if (this.f15851c == null && this.a.getPageContext() != null) {
            TextView textView = new TextView(this.a.getPageContext().getPageActivity());
            this.f15851c = textView;
            textView.setTextSize(0, this.a.getResources().getDimensionPixelSize(R.dimen.fontsize28));
            this.f15851c.setGravity(17);
        }
        if (this.f15851c != null) {
            if (i2 > 0) {
                string = String.format(TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i2));
            } else {
                string = TbadkCoreApplication.getInst().getString(R.string.smart_frs_refresh_nodata);
            }
            this.f15851c.setText(string);
        }
        SkinManager.setBackgroundResource(this.f15851c, R.color.CAM_X0302);
        SkinManager.setViewTextColor(this.f15851c, (int) R.color.CAM_X0112);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, n.f(TbadkCoreApplication.getInst(), R.dimen.ds56));
        if (this.f15850b == null) {
            this.f15850b = new d1();
        }
        this.f15850b.h(this.f15851c, frameLayout, layoutParams, 2000);
        this.f15853e = -1;
    }
}
