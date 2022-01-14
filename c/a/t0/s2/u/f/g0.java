package c.a.t0.s2.u.f;

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
public class g0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.d.a.f a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBarCoverTip f22864b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f22865c;

    /* renamed from: d  reason: collision with root package name */
    public int f22866d;

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
        this.f22864b = navigationBarCoverTip;
        b();
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || this.f22864b == null) {
            return;
        }
        if (!c.a.d.f.p.m.isEmpty(str) && this.f22866d <= 0) {
            this.f22864b.setVisibility(0);
            this.f22866d++;
            this.f22865c.setText(str);
            SkinManager.setViewTextColor(this.f22865c, c.a.t0.s2.f.CAM_X0101);
            this.f22864b.removeAllViews();
            this.f22864b.addView(this.f22865c);
            this.f22864b.showTip(this.a.getPageActivity(), 5000);
            return;
        }
        c();
        this.f22864b.setVisibility(8);
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f22865c = new TextView(this.a.getPageActivity());
            this.f22865c.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            this.f22865c.setMinHeight(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(c.a.t0.s2.g.tbds112));
            this.f22865c.setPadding(this.a.getResources().getDimensionPixelSize(c.a.t0.s2.g.ds34), 0, this.a.getResources().getDimensionPixelSize(c.a.t0.s2.g.ds34), 0);
            this.f22865c.setGravity(19);
            this.f22865c.setTextSize(0, this.a.getResources().getDimensionPixelSize(c.a.t0.s2.g.tbfontsize42));
            this.f22865c.setLineSpacing(this.a.getResources().getDimensionPixelSize(c.a.t0.s2.g.ds2), 1.0f);
        }
    }

    public void c() {
        NavigationBarCoverTip navigationBarCoverTip;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (navigationBarCoverTip = this.f22864b) == null) {
            return;
        }
        navigationBarCoverTip.onDestroy();
    }
}
