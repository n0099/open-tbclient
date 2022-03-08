package c.a.r0.u2.k.f;

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
/* loaded from: classes2.dex */
public class h0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.d.a.f a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBarCoverTip f23577b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f23578c;

    /* renamed from: d  reason: collision with root package name */
    public int f23579d;

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
        this.f23577b = navigationBarCoverTip;
        b();
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || this.f23577b == null) {
            return;
        }
        if (!c.a.d.f.p.m.isEmpty(str) && this.f23579d <= 0) {
            this.f23577b.setVisibility(0);
            this.f23579d++;
            this.f23578c.setText(str);
            SkinManager.setViewTextColor(this.f23578c, (int) R.color.CAM_X0101);
            this.f23577b.removeAllViews();
            this.f23577b.addView(this.f23578c);
            this.f23577b.showTip(this.a.getPageActivity(), 5000);
            return;
        }
        c();
        this.f23577b.setVisibility(8);
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f23578c = new TextView(this.a.getPageActivity());
            this.f23578c.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            this.f23578c.setMinHeight(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds112));
            this.f23578c.setPadding(this.a.getResources().getDimensionPixelSize(R.dimen.ds34), 0, this.a.getResources().getDimensionPixelSize(R.dimen.ds34), 0);
            this.f23578c.setGravity(19);
            this.f23578c.setTextSize(0, this.a.getResources().getDimensionPixelSize(R.dimen.tbfontsize42));
            this.f23578c.setLineSpacing(this.a.getResources().getDimensionPixelSize(R.dimen.ds2), 1.0f);
        }
    }

    public void c() {
        NavigationBarCoverTip navigationBarCoverTip;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (navigationBarCoverTip = this.f23577b) == null) {
            return;
        }
        navigationBarCoverTip.onDestroy();
    }
}
