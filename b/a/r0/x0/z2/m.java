package b.a.r0.x0.z2;

import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import b.a.r0.x0.c1;
import b.a.r0.x0.d1;
import b.a.r0.x0.i1;
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
/* loaded from: classes6.dex */
public class m {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public FrsFragment f28534a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBarCoverTip f28535b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f28536c;

    /* renamed from: d  reason: collision with root package name */
    public int f28537d;

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
        this.f28534a = frsFragment;
        this.f28535b = navigationBarCoverTip;
        b();
    }

    public void a(String str) {
        int i2;
        String str2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || b.a.e.f.p.k.isEmpty(str) || this.f28535b == null || !this.f28534a.isPrimary() || (i2 = this.f28537d) > 0) {
            return;
        }
        this.f28537d = i2 + 1;
        if (str.length() < 20) {
            str2 = this.f28534a.getResources().getString(i1.forum_ueg_tip) + StringUtils.LF + str;
        } else if (str.length() < 34) {
            str2 = this.f28534a.getResources().getString(i1.forum_ueg_tip) + str;
        } else {
            str2 = this.f28534a.getResources().getString(i1.forum_ueg_tip) + str.substring(0, 34);
        }
        this.f28536c.setText(str2);
        SkinManager.setViewTextColor(this.f28536c, c1.CAM_X0101);
        SkinManager.setBackgroundColor(this.f28535b, c1.cp_link_tip_a_alpha95);
        this.f28535b.showTip(this.f28534a.getActivity(), this.f28536c, 5000);
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f28537d = 0;
            this.f28536c = new TextView(this.f28534a.getActivity());
            this.f28536c.setLayoutParams(new LinearLayout.LayoutParams(-1, this.f28534a.getResources().getDimensionPixelSize(d1.tbds112)));
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.f28536c.setPadding(this.f28534a.getResources().getDimensionPixelSize(d1.ds34), this.f28534a.getResources().getDimensionPixelSize(d1.ds1), this.f28534a.getResources().getDimensionPixelSize(d1.ds34), 0);
                this.f28536c.setGravity(3);
            } else {
                this.f28536c.setPadding(this.f28534a.getResources().getDimensionPixelSize(d1.ds34), 0, this.f28534a.getResources().getDimensionPixelSize(d1.ds34), 0);
                this.f28536c.setGravity(19);
            }
            this.f28536c.setTextSize(0, this.f28534a.getResources().getDimensionPixelSize(d1.ds28));
            this.f28536c.setLineSpacing(this.f28534a.getResources().getDimensionPixelSize(d1.ds2), 1.0f);
            this.f28536c.setMaxLines(2);
            this.f28536c.setEllipsize(TextUtils.TruncateAt.END);
        }
    }

    public void c() {
        NavigationBarCoverTip navigationBarCoverTip;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (navigationBarCoverTip = this.f28535b) == null) {
            return;
        }
        navigationBarCoverTip.onDestroy();
    }
}
