package c.a.r0.j2.k.e;

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
public class f0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c.a.e.a.f f20052a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBarCoverTip f20053b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f20054c;

    /* renamed from: d  reason: collision with root package name */
    public int f20055d;

    public f0(c.a.e.a.f fVar, NavigationBarCoverTip navigationBarCoverTip) {
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
        this.f20052a = fVar;
        this.f20053b = navigationBarCoverTip;
        b();
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || this.f20053b == null) {
            return;
        }
        if (!c.a.e.e.p.k.isEmpty(str) && this.f20055d <= 0) {
            this.f20053b.setVisibility(0);
            this.f20055d++;
            this.f20054c.setText(str);
            SkinManager.setViewTextColor(this.f20054c, R.color.CAM_X0101);
            this.f20053b.removeAllViews();
            this.f20053b.addView(this.f20054c);
            this.f20053b.showTip(this.f20052a.getPageActivity(), 5000);
            return;
        }
        c();
        this.f20053b.setVisibility(8);
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f20054c = new TextView(this.f20052a.getPageActivity());
            this.f20054c.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            this.f20054c.setMinHeight(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds112));
            this.f20054c.setPadding(this.f20052a.getResources().getDimensionPixelSize(R.dimen.ds34), 0, this.f20052a.getResources().getDimensionPixelSize(R.dimen.ds34), 0);
            this.f20054c.setGravity(19);
            this.f20054c.setTextSize(0, this.f20052a.getResources().getDimensionPixelSize(R.dimen.tbfontsize42));
            this.f20054c.setLineSpacing(this.f20052a.getResources().getDimensionPixelSize(R.dimen.ds2), 1.0f);
        }
    }

    public void c() {
        NavigationBarCoverTip navigationBarCoverTip;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (navigationBarCoverTip = this.f20053b) == null) {
            return;
        }
        navigationBarCoverTip.onDestroy();
    }
}
