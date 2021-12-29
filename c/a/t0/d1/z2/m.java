package c.a.t0.d1.z2;

import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.t0.d1.c1;
import c.a.t0.d1.d1;
import c.a.t0.d1.i1;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.view.NavigationBarCoverTip;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.apache.commons.lang3.StringUtils;
/* loaded from: classes7.dex */
public class m {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsFragment a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBarCoverTip f17458b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f17459c;

    /* renamed from: d  reason: collision with root package name */
    public int f17460d;

    public m(FrsFragment frsFragment, NavigationBarCoverTip navigationBarCoverTip) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, navigationBarCoverTip};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = frsFragment;
        this.f17458b = navigationBarCoverTip;
        b();
    }

    public void a(String str) {
        int i2;
        String str2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || c.a.d.f.p.m.isEmpty(str) || this.f17458b == null || !this.a.isPrimary() || (i2 = this.f17460d) > 0) {
            return;
        }
        this.f17460d = i2 + 1;
        if (str.length() < 20) {
            str2 = this.a.getResources().getString(i1.forum_ueg_tip) + StringUtils.LF + str;
        } else if (str.length() < 34) {
            str2 = this.a.getResources().getString(i1.forum_ueg_tip) + str;
        } else {
            str2 = this.a.getResources().getString(i1.forum_ueg_tip) + str.substring(0, 34);
        }
        this.f17459c.setText(str2);
        SkinManager.setViewTextColor(this.f17459c, c1.CAM_X0101);
        SkinManager.setBackgroundColor(this.f17458b, c1.cp_link_tip_a_alpha95);
        this.f17458b.showTip(this.a.getActivity(), this.f17459c, 5000);
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f17460d = 0;
            this.f17459c = new TextView(this.a.getActivity());
            this.f17459c.setLayoutParams(new LinearLayout.LayoutParams(-1, this.a.getResources().getDimensionPixelSize(d1.tbds112)));
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.f17459c.setPadding(this.a.getResources().getDimensionPixelSize(d1.ds34), this.a.getResources().getDimensionPixelSize(d1.ds1), this.a.getResources().getDimensionPixelSize(d1.ds34), 0);
                this.f17459c.setGravity(3);
            } else {
                this.f17459c.setPadding(this.a.getResources().getDimensionPixelSize(d1.ds34), 0, this.a.getResources().getDimensionPixelSize(d1.ds34), 0);
                this.f17459c.setGravity(19);
            }
            this.f17459c.setTextSize(0, this.a.getResources().getDimensionPixelSize(d1.ds28));
            this.f17459c.setLineSpacing(this.a.getResources().getDimensionPixelSize(d1.ds2), 1.0f);
            this.f17459c.setMaxLines(2);
            this.f17459c.setEllipsize(TextUtils.TruncateAt.END);
        }
    }

    public void c() {
        NavigationBarCoverTip navigationBarCoverTip;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (navigationBarCoverTip = this.f17458b) == null) {
            return;
        }
        navigationBarCoverTip.onDestroy();
    }
}
