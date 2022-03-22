package c.a.p0.w2.m.f;

import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.view.NavigationBarCoverTip;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class n0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.d.a.f a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBarCoverTip f20250b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f20251c;

    /* renamed from: d  reason: collision with root package name */
    public int f20252d;

    public n0(c.a.d.a.f fVar, NavigationBarCoverTip navigationBarCoverTip) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar, navigationBarCoverTip};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = fVar;
        this.f20250b = navigationBarCoverTip;
        b();
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || this.f20250b == null) {
            return;
        }
        if (!c.a.d.f.p.m.isEmpty(str) && this.f20252d <= 0) {
            this.f20250b.setVisibility(0);
            this.f20252d++;
            this.f20251c.setText(str);
            SkinManager.setViewTextColor(this.f20251c, (int) R.color.CAM_X0101);
            this.f20250b.removeAllViews();
            this.f20250b.addView(this.f20251c);
            this.f20250b.k(this.a.getPageActivity(), 5000);
            return;
        }
        c();
        this.f20250b.setVisibility(8);
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f20251c = new TextView(this.a.getPageActivity());
            this.f20251c.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            this.f20251c.setMinHeight(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds112));
            this.f20251c.setPadding(this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07020f), 0, this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07020f), 0);
            this.f20251c.setGravity(19);
            this.f20251c.setTextSize(0, this.a.getResources().getDimensionPixelSize(R.dimen.tbfontsize42));
            this.f20251c.setLineSpacing(this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701d4), 1.0f);
        }
    }

    public void c() {
        NavigationBarCoverTip navigationBarCoverTip;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (navigationBarCoverTip = this.f20250b) == null) {
            return;
        }
        navigationBarCoverTip.i();
    }
}
