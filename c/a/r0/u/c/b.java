package c.a.r0.u.c;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.q0.r.v.c;
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
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final View.OnClickListener a;

    /* renamed from: b  reason: collision with root package name */
    public BaseActivity f22511b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f22512c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f22513d;

    /* renamed from: e  reason: collision with root package name */
    public TbSettingTextTipView f22514e;

    /* renamed from: f  reason: collision with root package name */
    public TbSettingTextTipView f22515f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f22516g;

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
        this.f22511b = baseActivity;
        this.a = onClickListener;
        b();
    }

    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f22512c : (View) invokeV.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.f22511b).inflate(R.layout.account_safe_activity, (ViewGroup) null);
            this.f22512c = linearLayout;
            this.f22513d = (LinearLayout) linearLayout.findViewById(R.id.content_container);
            this.f22514e = (TbSettingTextTipView) this.f22512c.findViewById(R.id.bar_record);
            this.f22516g = (TextView) this.f22512c.findViewById(R.id.tv_title);
            this.f22515f = (TbSettingTextTipView) this.f22512c.findViewById(R.id.account_status);
            this.f22514e.changeStyleTo1080();
            this.f22515f.changeStyleTo1080();
            this.f22514e.setOnClickListener(this.a);
            this.f22515f.setOnClickListener(this.a);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f22512c.removeAllViews();
            this.f22511b = null;
        }
    }

    public void d(SimpleUser simpleUser) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, simpleUser) == null) || simpleUser == null) {
            return;
        }
        this.f22515f.setTip(simpleUser.block_msg);
    }

    public void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f22511b.getLayoutMode().k(i2 == 1);
            this.f22511b.getLayoutMode().j(this.f22512c);
            c d2 = c.d(this.f22516g);
            d2.v(R.color.CAM_X0109);
            d2.f(R.color.CAM_X0204);
        }
    }
}
