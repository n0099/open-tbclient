package c.a.p0.j2.h.c;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tieba.R;
import com.baidu.tieba.memberCenter.tail.data.TailData;
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
    public TailData f15826b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f15827c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f15828d;

    /* renamed from: e  reason: collision with root package name */
    public Context f15829e;

    /* renamed from: f  reason: collision with root package name */
    public String f15830f;

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public void a(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, tbPageContext) == null) {
            tbPageContext.getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
            tbPageContext.getLayoutMode().j(this.a);
            d(this.f15830f);
        }
    }

    public View b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            this.f15829e = context;
            View inflate = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d080d, (ViewGroup) null);
            this.a = inflate;
            inflate.setTag(this);
            this.f15827c = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f091edf);
            TextView textView = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f091ede);
            this.f15828d = textView;
            textView.setTag(this);
            return this.a;
        }
        return (View) invokeL.objValue;
    }

    public TailData c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f15826b : (TailData) invokeV.objValue;
    }

    public final void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.f15830f = str;
            this.f15827c.setTextColor(c.a.p0.j2.h.f.c.a(str));
        }
    }

    public final void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.f15827c.setText(TbFaceManager.e().l(this.f15829e, c.a.p0.j2.h.f.d.a(str), null));
        }
    }

    public void f(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, onClickListener) == null) {
            this.f15828d.setOnClickListener(onClickListener);
        }
    }

    public void g(Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bool) == null) {
            this.f15828d.setVisibility(bool.booleanValue() ? 0 : 8);
        }
    }

    public void h(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, onClickListener) == null) {
            this.a.setOnClickListener(onClickListener);
        }
    }

    public void i(TailData tailData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, tailData) == null) {
            this.f15826b = tailData;
            e(tailData.getContent());
            d(tailData.getFontColor());
        }
    }
}
