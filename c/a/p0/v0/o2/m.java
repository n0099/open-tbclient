package c.a.p0.v0.o2;

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
import org.apache.commons.lang3.StringUtils;
/* loaded from: classes4.dex */
public class m {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public FrsFragment f26486a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBarCoverTip f26487b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f26488c;

    /* renamed from: d  reason: collision with root package name */
    public int f26489d;

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
        this.f26486a = frsFragment;
        this.f26487b = navigationBarCoverTip;
        b();
    }

    public void a(String str) {
        int i2;
        String str2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || c.a.e.e.p.k.isEmpty(str) || this.f26487b == null || !this.f26486a.isPrimary() || (i2 = this.f26489d) > 0) {
            return;
        }
        this.f26489d = i2 + 1;
        if (str.length() < 20) {
            str2 = this.f26486a.getResources().getString(R.string.forum_ueg_tip) + StringUtils.LF + str;
        } else if (str.length() < 34) {
            str2 = this.f26486a.getResources().getString(R.string.forum_ueg_tip) + str;
        } else {
            str2 = this.f26486a.getResources().getString(R.string.forum_ueg_tip) + str.substring(0, 34);
        }
        this.f26488c.setText(str2);
        SkinManager.setViewTextColor(this.f26488c, R.color.CAM_X0101);
        SkinManager.setBackgroundColor(this.f26487b, R.color.cp_link_tip_a_alpha95);
        this.f26487b.showTip(this.f26486a.getActivity(), this.f26488c, 5000);
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f26489d = 0;
            this.f26488c = new TextView(this.f26486a.getActivity());
            this.f26488c.setLayoutParams(new LinearLayout.LayoutParams(-1, this.f26486a.getResources().getDimensionPixelSize(R.dimen.tbds112)));
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.f26488c.setPadding(this.f26486a.getResources().getDimensionPixelSize(R.dimen.ds34), this.f26486a.getResources().getDimensionPixelSize(R.dimen.ds1), this.f26486a.getResources().getDimensionPixelSize(R.dimen.ds34), 0);
                this.f26488c.setGravity(3);
            } else {
                this.f26488c.setPadding(this.f26486a.getResources().getDimensionPixelSize(R.dimen.ds34), 0, this.f26486a.getResources().getDimensionPixelSize(R.dimen.ds34), 0);
                this.f26488c.setGravity(19);
            }
            this.f26488c.setTextSize(0, this.f26486a.getResources().getDimensionPixelSize(R.dimen.ds28));
            this.f26488c.setLineSpacing(this.f26486a.getResources().getDimensionPixelSize(R.dimen.ds2), 1.0f);
            this.f26488c.setMaxLines(2);
            this.f26488c.setEllipsize(TextUtils.TruncateAt.END);
        }
    }

    public void c() {
        NavigationBarCoverTip navigationBarCoverTip;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (navigationBarCoverTip = this.f26487b) == null) {
            return;
        }
        navigationBarCoverTip.onDestroy();
    }
}
