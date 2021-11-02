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
public class f0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b.a.e.a.f f19241a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBarCoverTip f19242b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f19243c;

    /* renamed from: d  reason: collision with root package name */
    public int f19244d;

    public f0(b.a.e.a.f fVar, NavigationBarCoverTip navigationBarCoverTip) {
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
        this.f19241a = fVar;
        this.f19242b = navigationBarCoverTip;
        b();
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || this.f19242b == null) {
            return;
        }
        if (!b.a.e.e.p.k.isEmpty(str) && this.f19244d <= 0) {
            this.f19242b.setVisibility(0);
            this.f19244d++;
            this.f19243c.setText(str);
            SkinManager.setViewTextColor(this.f19243c, b.a.r0.k2.f.CAM_X0101);
            this.f19242b.removeAllViews();
            this.f19242b.addView(this.f19243c);
            this.f19242b.showTip(this.f19241a.getPageActivity(), 5000);
            return;
        }
        c();
        this.f19242b.setVisibility(8);
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f19243c = new TextView(this.f19241a.getPageActivity());
            this.f19243c.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            this.f19243c.setMinHeight(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(b.a.r0.k2.g.tbds112));
            this.f19243c.setPadding(this.f19241a.getResources().getDimensionPixelSize(b.a.r0.k2.g.ds34), 0, this.f19241a.getResources().getDimensionPixelSize(b.a.r0.k2.g.ds34), 0);
            this.f19243c.setGravity(19);
            this.f19243c.setTextSize(0, this.f19241a.getResources().getDimensionPixelSize(b.a.r0.k2.g.tbfontsize42));
            this.f19243c.setLineSpacing(this.f19241a.getResources().getDimensionPixelSize(b.a.r0.k2.g.ds2), 1.0f);
        }
    }

    public void c() {
        NavigationBarCoverTip navigationBarCoverTip;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (navigationBarCoverTip = this.f19242b) == null) {
            return;
        }
        navigationBarCoverTip.onDestroy();
    }
}
