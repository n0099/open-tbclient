package c.a.p0.f1.s2;

import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.view.NavigationBarCoverTip;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class m {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsFragment a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBarCoverTip f14631b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f14632c;

    /* renamed from: d  reason: collision with root package name */
    public int f14633d;

    public m(FrsFragment frsFragment, NavigationBarCoverTip navigationBarCoverTip) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, navigationBarCoverTip};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = frsFragment;
        this.f14631b = navigationBarCoverTip;
        b();
    }

    public void a(String str) {
        int i;
        String str2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || c.a.d.f.p.m.isEmpty(str) || this.f14631b == null || !this.a.isPrimary() || (i = this.f14633d) > 0) {
            return;
        }
        this.f14633d = i + 1;
        if (str.length() < 20) {
            str2 = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f06aa) + "\n" + str;
        } else if (str.length() < 34) {
            str2 = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f06aa) + str;
        } else {
            str2 = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f06aa) + str.substring(0, 34);
        }
        this.f14632c.setText(str2);
        SkinManager.setViewTextColor(this.f14632c, (int) R.color.CAM_X0101);
        SkinManager.setBackgroundColor(this.f14631b, R.color.cp_link_tip_a_alpha95);
        this.f14631b.m(this.a.getActivity(), this.f14632c, 5000);
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f14633d = 0;
            this.f14632c = new TextView(this.a.getActivity());
            this.f14632c.setLayoutParams(new LinearLayout.LayoutParams(-1, this.a.getResources().getDimensionPixelSize(R.dimen.tbds112)));
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.f14632c.setPadding(this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07020f), this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070198), this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07020f), 0);
                this.f14632c.setGravity(3);
            } else {
                this.f14632c.setPadding(this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07020f), 0, this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07020f), 0);
                this.f14632c.setGravity(19);
            }
            this.f14632c.setTextSize(0, this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701f9));
            this.f14632c.setLineSpacing(this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701d4), 1.0f);
            this.f14632c.setMaxLines(2);
            this.f14632c.setEllipsize(TextUtils.TruncateAt.END);
        }
    }

    public void c() {
        NavigationBarCoverTip navigationBarCoverTip;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (navigationBarCoverTip = this.f14631b) == null) {
            return;
        }
        navigationBarCoverTip.i();
    }
}
