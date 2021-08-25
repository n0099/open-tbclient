package c.a.q0.v0.h2;

import android.widget.FrameLayout;
import android.widget.TextView;
import c.a.e.e.p.l;
import c.a.q0.v0.c1;
import c.a.q0.v0.q;
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
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final FrsFragment f26207a;

    /* renamed from: b  reason: collision with root package name */
    public c1 f26208b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f26209c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f26210d;

    /* renamed from: e  reason: collision with root package name */
    public int f26211e;

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
        this.f26211e = -1;
        if (frsFragment != null) {
            this.f26207a = frsFragment;
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
            if (this.f26210d && (i2 = this.f26211e) >= 0) {
                f(i2);
            }
            this.f26210d = false;
        }
    }

    public void c() {
        c1 c1Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (c1Var = this.f26208b) == null) {
            return;
        }
        c1Var.e();
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.f26210d = z;
        }
    }

    public void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f26211e = i2;
        }
    }

    public final void f(int i2) {
        q frsView;
        FrameLayout frameLayout;
        String string;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i2) == null) || (frsView = this.f26207a.getFrsView()) == null || frsView.b0() == null || (frameLayout = (FrameLayout) frsView.U()) == null) {
            return;
        }
        if (this.f26209c == null && this.f26207a.getPageContext() != null) {
            TextView textView = new TextView(this.f26207a.getPageContext().getPageActivity());
            this.f26209c = textView;
            textView.setTextSize(0, this.f26207a.getResources().getDimensionPixelSize(R.dimen.fontsize28));
            this.f26209c.setGravity(17);
        }
        if (this.f26209c != null) {
            if (i2 > 0) {
                string = String.format(TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i2));
            } else {
                string = TbadkCoreApplication.getInst().getString(R.string.smart_frs_refresh_nodata);
            }
            this.f26209c.setText(string);
        }
        SkinManager.setBackgroundResource(this.f26209c, R.color.CAM_X0302);
        SkinManager.setViewTextColor(this.f26209c, R.color.CAM_X0112);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.g(TbadkCoreApplication.getInst(), R.dimen.ds56));
        if (this.f26208b == null) {
            this.f26208b = new c1();
        }
        this.f26208b.h(this.f26209c, frameLayout, layoutParams, 2000);
        this.f26211e = -1;
    }
}
