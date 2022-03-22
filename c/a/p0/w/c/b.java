package c.a.p0.w.c;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.o0.r.v.c;
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
    public BaseActivity f19327b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f19328c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f19329d;

    /* renamed from: e  reason: collision with root package name */
    public TbSettingTextTipView f19330e;

    /* renamed from: f  reason: collision with root package name */
    public TbSettingTextTipView f19331f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f19332g;

    public b(BaseActivity baseActivity, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseActivity, onClickListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f19327b = baseActivity;
        this.a = onClickListener;
        b();
    }

    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f19328c : (View) invokeV.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.f19327b).inflate(R.layout.obfuscated_res_0x7f0d0025, (ViewGroup) null);
            this.f19328c = linearLayout;
            this.f19329d = (LinearLayout) linearLayout.findViewById(R.id.obfuscated_res_0x7f0906df);
            this.f19330e = (TbSettingTextTipView) this.f19328c.findViewById(R.id.obfuscated_res_0x7f09031f);
            this.f19332g = (TextView) this.f19328c.findViewById(R.id.obfuscated_res_0x7f09221e);
            this.f19331f = (TbSettingTextTipView) this.f19328c.findViewById(R.id.obfuscated_res_0x7f090052);
            this.f19330e.a();
            this.f19331f.a();
            this.f19330e.setOnClickListener(this.a);
            this.f19331f.setOnClickListener(this.a);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f19328c.removeAllViews();
            this.f19327b = null;
        }
    }

    public void d(SimpleUser simpleUser) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, simpleUser) == null) || simpleUser == null) {
            return;
        }
        this.f19331f.setTip(simpleUser.block_msg);
    }

    public void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.f19327b.getLayoutMode().k(i == 1);
            this.f19327b.getLayoutMode().j(this.f19328c);
            c d2 = c.d(this.f19332g);
            d2.v(R.color.CAM_X0109);
            d2.f(R.color.CAM_X0204);
        }
    }
}
