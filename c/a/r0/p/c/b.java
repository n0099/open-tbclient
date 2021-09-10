package c.a.r0.p.c;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.q0.s.u.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.SimpleUser;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final View.OnClickListener f23385a;

    /* renamed from: b  reason: collision with root package name */
    public BaseActivity f23386b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f23387c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f23388d;

    /* renamed from: e  reason: collision with root package name */
    public TbSettingTextTipView f23389e;

    /* renamed from: f  reason: collision with root package name */
    public TbSettingTextTipView f23390f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f23391g;

    public b(BaseActivity baseActivity, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseActivity, onClickListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f23386b = baseActivity;
        this.f23385a = onClickListener;
        b();
    }

    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f23387c : (View) invokeV.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.f23386b).inflate(R.layout.account_safe_activity, (ViewGroup) null);
            this.f23387c = linearLayout;
            this.f23388d = (LinearLayout) linearLayout.findViewById(R.id.content_container);
            this.f23389e = (TbSettingTextTipView) this.f23387c.findViewById(R.id.bar_record);
            this.f23391g = (TextView) this.f23387c.findViewById(R.id.tv_title);
            this.f23390f = (TbSettingTextTipView) this.f23387c.findViewById(R.id.account_status);
            this.f23389e.changeStyleTo1080();
            this.f23390f.changeStyleTo1080();
            this.f23389e.setOnClickListener(this.f23385a);
            this.f23390f.setOnClickListener(this.f23385a);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f23387c.removeAllViews();
            this.f23386b = null;
        }
    }

    public void d(SimpleUser simpleUser) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, simpleUser) == null) || simpleUser == null) {
            return;
        }
        this.f23390f.setTip(simpleUser.block_msg);
    }

    public void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f23386b.getLayoutMode().k(i2 == 1);
            this.f23386b.getLayoutMode().j(this.f23387c);
            c d2 = c.d(this.f23391g);
            d2.w(R.color.CAM_X0109);
            d2.f(R.color.CAM_X0204);
        }
    }
}
