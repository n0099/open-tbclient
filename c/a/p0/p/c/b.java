package c.a.p0.p.c;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.o0.s.u.c;
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
    public final View.OnClickListener f23154a;

    /* renamed from: b  reason: collision with root package name */
    public BaseActivity f23155b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f23156c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f23157d;

    /* renamed from: e  reason: collision with root package name */
    public TbSettingTextTipView f23158e;

    /* renamed from: f  reason: collision with root package name */
    public TbSettingTextTipView f23159f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f23160g;

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
        this.f23155b = baseActivity;
        this.f23154a = onClickListener;
        b();
    }

    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f23156c : (View) invokeV.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.f23155b).inflate(R.layout.account_safe_activity, (ViewGroup) null);
            this.f23156c = linearLayout;
            this.f23157d = (LinearLayout) linearLayout.findViewById(R.id.content_container);
            this.f23158e = (TbSettingTextTipView) this.f23156c.findViewById(R.id.bar_record);
            this.f23160g = (TextView) this.f23156c.findViewById(R.id.tv_title);
            this.f23159f = (TbSettingTextTipView) this.f23156c.findViewById(R.id.account_status);
            this.f23158e.changeStyleTo1080();
            this.f23159f.changeStyleTo1080();
            this.f23158e.setOnClickListener(this.f23154a);
            this.f23159f.setOnClickListener(this.f23154a);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f23156c.removeAllViews();
            this.f23155b = null;
        }
    }

    public void d(SimpleUser simpleUser) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, simpleUser) == null) || simpleUser == null) {
            return;
        }
        this.f23159f.setTip(simpleUser.block_msg);
    }

    public void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f23155b.getLayoutMode().k(i2 == 1);
            this.f23155b.getLayoutMode().j(this.f23156c);
            c d2 = c.d(this.f23160g);
            d2.t(R.color.CAM_X0109);
            d2.f(R.color.CAM_X0204);
        }
    }
}
