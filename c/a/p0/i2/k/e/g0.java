package c.a.p0.i2.k.e;

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
public class g0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c.a.e.a.f f19186a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBarCoverTip f19187b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f19188c;

    /* renamed from: d  reason: collision with root package name */
    public int f19189d;

    public g0(c.a.e.a.f fVar, NavigationBarCoverTip navigationBarCoverTip) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar, navigationBarCoverTip};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f19186a = fVar;
        this.f19187b = navigationBarCoverTip;
        b();
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || this.f19187b == null) {
            return;
        }
        if (!c.a.e.e.p.k.isEmpty(str) && this.f19189d <= 0) {
            this.f19187b.setVisibility(0);
            this.f19189d++;
            this.f19188c.setText(str);
            SkinManager.setViewTextColor(this.f19188c, R.color.CAM_X0101);
            this.f19187b.removeAllViews();
            this.f19187b.addView(this.f19188c);
            this.f19187b.showTip(this.f19186a.getPageActivity(), 5000);
            return;
        }
        c();
        this.f19187b.setVisibility(8);
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f19188c = new TextView(this.f19186a.getPageActivity());
            this.f19188c.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            this.f19188c.setMinHeight(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds112));
            this.f19188c.setPadding(this.f19186a.getResources().getDimensionPixelSize(R.dimen.ds34), 0, this.f19186a.getResources().getDimensionPixelSize(R.dimen.ds34), 0);
            this.f19188c.setGravity(19);
            this.f19188c.setTextSize(0, this.f19186a.getResources().getDimensionPixelSize(R.dimen.tbfontsize42));
            this.f19188c.setLineSpacing(this.f19186a.getResources().getDimensionPixelSize(R.dimen.ds2), 1.0f);
        }
    }

    public void c() {
        NavigationBarCoverTip navigationBarCoverTip;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (navigationBarCoverTip = this.f19187b) == null) {
            return;
        }
        navigationBarCoverTip.onDestroy();
    }
}
