package b.a.r0.k2.u.f;

import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.view.NavigationBarCoverTip;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class g0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b.a.e.a.f f20808a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBarCoverTip f20809b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f20810c;

    /* renamed from: d  reason: collision with root package name */
    public int f20811d;

    public g0(b.a.e.a.f fVar, NavigationBarCoverTip navigationBarCoverTip) {
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
        this.f20808a = fVar;
        this.f20809b = navigationBarCoverTip;
        b();
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || this.f20809b == null) {
            return;
        }
        if (!b.a.e.f.p.k.isEmpty(str) && this.f20811d <= 0) {
            this.f20809b.setVisibility(0);
            this.f20811d++;
            this.f20810c.setText(str);
            SkinManager.setViewTextColor(this.f20810c, b.a.r0.k2.f.CAM_X0101);
            this.f20809b.removeAllViews();
            this.f20809b.addView(this.f20810c);
            this.f20809b.showTip(this.f20808a.getPageActivity(), 5000);
            return;
        }
        c();
        this.f20809b.setVisibility(8);
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f20810c = new TextView(this.f20808a.getPageActivity());
            this.f20810c.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            this.f20810c.setMinHeight(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(b.a.r0.k2.g.tbds112));
            this.f20810c.setPadding(this.f20808a.getResources().getDimensionPixelSize(b.a.r0.k2.g.ds34), 0, this.f20808a.getResources().getDimensionPixelSize(b.a.r0.k2.g.ds34), 0);
            this.f20810c.setGravity(19);
            this.f20810c.setTextSize(0, this.f20808a.getResources().getDimensionPixelSize(b.a.r0.k2.g.tbfontsize42));
            this.f20810c.setLineSpacing(this.f20808a.getResources().getDimensionPixelSize(b.a.r0.k2.g.ds2), 1.0f);
        }
    }

    public void c() {
        NavigationBarCoverTip navigationBarCoverTip;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (navigationBarCoverTip = this.f20809b) == null) {
            return;
        }
        navigationBarCoverTip.onDestroy();
    }
}
