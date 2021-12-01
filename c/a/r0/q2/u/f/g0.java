package c.a.r0.q2.u.f;

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
/* loaded from: classes6.dex */
public class g0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.d.a.f a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBarCoverTip f21998b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f21999c;

    /* renamed from: d  reason: collision with root package name */
    public int f22000d;

    public g0(c.a.d.a.f fVar, NavigationBarCoverTip navigationBarCoverTip) {
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
        this.a = fVar;
        this.f21998b = navigationBarCoverTip;
        b();
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || this.f21998b == null) {
            return;
        }
        if (!c.a.d.f.p.k.isEmpty(str) && this.f22000d <= 0) {
            this.f21998b.setVisibility(0);
            this.f22000d++;
            this.f21999c.setText(str);
            SkinManager.setViewTextColor(this.f21999c, c.a.r0.q2.f.CAM_X0101);
            this.f21998b.removeAllViews();
            this.f21998b.addView(this.f21999c);
            this.f21998b.showTip(this.a.getPageActivity(), 5000);
            return;
        }
        c();
        this.f21998b.setVisibility(8);
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f21999c = new TextView(this.a.getPageActivity());
            this.f21999c.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            this.f21999c.setMinHeight(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(c.a.r0.q2.g.tbds112));
            this.f21999c.setPadding(this.a.getResources().getDimensionPixelSize(c.a.r0.q2.g.ds34), 0, this.a.getResources().getDimensionPixelSize(c.a.r0.q2.g.ds34), 0);
            this.f21999c.setGravity(19);
            this.f21999c.setTextSize(0, this.a.getResources().getDimensionPixelSize(c.a.r0.q2.g.tbfontsize42));
            this.f21999c.setLineSpacing(this.a.getResources().getDimensionPixelSize(c.a.r0.q2.g.ds2), 1.0f);
        }
    }

    public void c() {
        NavigationBarCoverTip navigationBarCoverTip;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (navigationBarCoverTip = this.f21998b) == null) {
            return;
        }
        navigationBarCoverTip.onDestroy();
    }
}
