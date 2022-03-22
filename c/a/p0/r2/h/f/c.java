package c.a.p0.r2.h.f;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.d.f.q.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f18086b;

    /* renamed from: c  reason: collision with root package name */
    public View f18087c;

    /* renamed from: d  reason: collision with root package name */
    public View f18088d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f18089e;

    public c(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0260, (ViewGroup) null, false);
        this.f18088d = inflate;
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.obfuscated_res_0x7f090890);
        this.f18089e = linearLayout;
        linearLayout.setVisibility(8);
        this.a = this.f18088d.findViewById(R.id.obfuscated_res_0x7f090893);
        this.f18086b = (TextView) this.f18088d.findViewById(R.id.obfuscated_res_0x7f090899);
        View findViewById = this.f18088d.findViewById(R.id.obfuscated_res_0x7f09088d);
        this.f18087c = findViewById;
        findViewById.setVisibility(8);
    }

    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f18088d : (View) invokeV.objValue;
    }

    public void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            View view = this.a;
            if (view != null) {
                SkinManager.setBackgroundColor(view, R.color.CAM_X0204, i);
            }
            LinearLayout linearLayout = this.f18089e;
            if (linearLayout != null) {
                SkinManager.setBackgroundColor(linearLayout, R.color.CAM_X0204, i);
            }
            TextView textView = this.f18086b;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, R.color.CAM_X0107, i);
                SkinManager.setBackgroundColor(this.f18086b, R.color.CAM_X0204, i);
            }
            View view2 = this.f18087c;
            if (view2 != null) {
                SkinManager.setViewTextColor(view2, R.color.CAM_X0107, i);
                SkinManager.setBackgroundColor(this.f18087c, R.color.CAM_X0204, i);
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (c.a.p0.r2.h.a.b().a()) {
                this.f18087c.setVisibility(0);
            } else {
                this.f18087c.setVisibility(8);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    public void update(Integer num) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, num) == null) || num == null) {
            return;
        }
        if (num.intValue() == 0) {
            this.f18089e.setVisibility(8);
        } else {
            this.f18086b.setText(String.format(h.a(R.string.obfuscated_res_0x7f0f0546), num));
            this.f18089e.setVisibility(0);
        }
        if (c.a.p0.r2.h.a.b().a()) {
            this.f18087c.setVisibility(0);
        } else {
            this.f18087c.setVisibility(8);
        }
    }
}
