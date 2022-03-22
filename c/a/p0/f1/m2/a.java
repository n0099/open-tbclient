package c.a.p0.f1.m2;

import android.widget.FrameLayout;
import android.widget.TextView;
import c.a.d.f.p.n;
import c.a.p0.f1.d1;
import c.a.p0.f1.q;
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
    public d1 f14244b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f14245c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f14246d;

    /* renamed from: e  reason: collision with root package name */
    public int f14247e;

    public a(FrsFragment frsFragment) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f14247e = -1;
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

    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            if (i >= 0) {
                d(true);
                e(i);
                return;
            }
            d(false);
            e(i);
        }
    }

    public void b() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.f14246d && (i = this.f14247e) >= 0) {
                f(i);
            }
            this.f14246d = false;
        }
    }

    public void c() {
        d1 d1Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (d1Var = this.f14244b) == null) {
            return;
        }
        d1Var.e();
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.f14246d = z;
        }
    }

    public void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.f14247e = i;
        }
    }

    public final void f(int i) {
        q x0;
        FrameLayout frameLayout;
        String string;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i) == null) || (x0 = this.a.x0()) == null || x0.c0() == null || (frameLayout = (FrameLayout) x0.V()) == null) {
            return;
        }
        if (this.f14245c == null && this.a.getPageContext() != null) {
            TextView textView = new TextView(this.a.getPageContext().getPageActivity());
            this.f14245c = textView;
            textView.setTextSize(0, this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702b5));
            this.f14245c.setGravity(17);
        }
        if (this.f14245c != null) {
            if (i > 0) {
                string = String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0f4e), Integer.valueOf(i));
            } else {
                string = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1183);
            }
            this.f14245c.setText(string);
        }
        SkinManager.setBackgroundResource(this.f14245c, R.color.CAM_X0302);
        SkinManager.setViewTextColor(this.f14245c, (int) R.color.CAM_X0112);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, n.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0702d6));
        if (this.f14244b == null) {
            this.f14244b = new d1();
        }
        this.f14244b.h(this.f14245c, frameLayout, layoutParams, 2000);
        this.f14247e = -1;
    }
}
