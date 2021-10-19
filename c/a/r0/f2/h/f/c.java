package c.a.r0.f2.h.f;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.e.e.q.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f17591a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f17592b;

    /* renamed from: c  reason: collision with root package name */
    public View f17593c;

    /* renamed from: d  reason: collision with root package name */
    public View f17594d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f17595e;

    public c(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.emotion_manage_header, (ViewGroup) null, false);
        this.f17594d = inflate;
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.emotion_manage_header_content);
        this.f17595e = linearLayout;
        linearLayout.setVisibility(8);
        this.f17591a = this.f17594d.findViewById(R.id.emotion_manage_item_header);
        this.f17592b = (TextView) this.f17594d.findViewById(R.id.emotion_manage_total_title);
        View findViewById = this.f17594d.findViewById(R.id.emotion_manage_edit_lable);
        this.f17593c = findViewById;
        findViewById.setVisibility(8);
    }

    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f17594d : (View) invokeV.objValue;
    }

    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            View view = this.f17591a;
            if (view != null) {
                SkinManager.setBackgroundColor(view, R.color.CAM_X0204, i2);
            }
            LinearLayout linearLayout = this.f17595e;
            if (linearLayout != null) {
                SkinManager.setBackgroundColor(linearLayout, R.color.CAM_X0204, i2);
            }
            TextView textView = this.f17592b;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, R.color.CAM_X0107, i2);
                SkinManager.setBackgroundColor(this.f17592b, R.color.CAM_X0204, i2);
            }
            View view2 = this.f17593c;
            if (view2 != null) {
                SkinManager.setViewTextColor(view2, R.color.CAM_X0107, i2);
                SkinManager.setBackgroundColor(this.f17593c, R.color.CAM_X0204, i2);
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (c.a.r0.f2.h.a.b().a()) {
                this.f17593c.setVisibility(0);
            } else {
                this.f17593c.setVisibility(8);
            }
        }
    }

    public void d(Integer num) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, num) == null) || num == null) {
            return;
        }
        if (num.intValue() == 0) {
            this.f17595e.setVisibility(8);
        } else {
            this.f17592b.setText(String.format(h.a(R.string.emotion_manage_local_number), num));
            this.f17595e.setVisibility(0);
        }
        if (c.a.r0.f2.h.a.b().a()) {
            this.f17593c.setVisibility(0);
        } else {
            this.f17593c.setVisibility(8);
        }
    }
}
