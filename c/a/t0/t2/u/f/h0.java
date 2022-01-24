package c.a.t0.t2.u.f;

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
/* loaded from: classes8.dex */
public class h0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.d.a.f a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBarCoverTip f23164b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f23165c;

    /* renamed from: d  reason: collision with root package name */
    public int f23166d;

    public h0(c.a.d.a.f fVar, NavigationBarCoverTip navigationBarCoverTip) {
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
        this.f23164b = navigationBarCoverTip;
        b();
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || this.f23164b == null) {
            return;
        }
        if (!c.a.d.f.p.m.isEmpty(str) && this.f23166d <= 0) {
            this.f23164b.setVisibility(0);
            this.f23166d++;
            this.f23165c.setText(str);
            SkinManager.setViewTextColor(this.f23165c, c.a.t0.t2.f.CAM_X0101);
            this.f23164b.removeAllViews();
            this.f23164b.addView(this.f23165c);
            this.f23164b.showTip(this.a.getPageActivity(), 5000);
            return;
        }
        c();
        this.f23164b.setVisibility(8);
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f23165c = new TextView(this.a.getPageActivity());
            this.f23165c.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            this.f23165c.setMinHeight(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(c.a.t0.t2.g.tbds112));
            this.f23165c.setPadding(this.a.getResources().getDimensionPixelSize(c.a.t0.t2.g.ds34), 0, this.a.getResources().getDimensionPixelSize(c.a.t0.t2.g.ds34), 0);
            this.f23165c.setGravity(19);
            this.f23165c.setTextSize(0, this.a.getResources().getDimensionPixelSize(c.a.t0.t2.g.tbfontsize42));
            this.f23165c.setLineSpacing(this.a.getResources().getDimensionPixelSize(c.a.t0.t2.g.ds2), 1.0f);
        }
    }

    public void c() {
        NavigationBarCoverTip navigationBarCoverTip;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (navigationBarCoverTip = this.f23164b) == null) {
            return;
        }
        navigationBarCoverTip.onDestroy();
    }
}
