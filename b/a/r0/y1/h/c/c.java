package b.a.r0.y1.h.c;

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
/* loaded from: classes6.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f27699a;

    /* renamed from: b  reason: collision with root package name */
    public TailData f27700b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f27701c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f27702d;

    /* renamed from: e  reason: collision with root package name */
    public Context f27703e;

    /* renamed from: f  reason: collision with root package name */
    public String f27704f;

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public void a(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, tbPageContext) == null) {
            tbPageContext.getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
            tbPageContext.getLayoutMode().j(this.f27699a);
            d(this.f27704f);
        }
    }

    public View b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            this.f27703e = context;
            View inflate = LayoutInflater.from(context).inflate(R.layout.tail_management_item, (ViewGroup) null);
            this.f27699a = inflate;
            inflate.setTag(this);
            this.f27701c = (TextView) this.f27699a.findViewById(R.id.tail_management_item_text);
            TextView textView = (TextView) this.f27699a.findViewById(R.id.tail_management_item_delete);
            this.f27702d = textView;
            textView.setTag(this);
            return this.f27699a;
        }
        return (View) invokeL.objValue;
    }

    public TailData c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f27700b : (TailData) invokeV.objValue;
    }

    public final void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.f27704f = str;
            this.f27701c.setTextColor(b.a.r0.y1.h.f.c.a(str));
        }
    }

    public final void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.f27701c.setText(TbFaceManager.e().l(this.f27703e, b.a.r0.y1.h.f.d.a(str), null));
        }
    }

    public void f(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, onClickListener) == null) {
            this.f27702d.setOnClickListener(onClickListener);
        }
    }

    public void g(Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bool) == null) {
            this.f27702d.setVisibility(bool.booleanValue() ? 0 : 8);
        }
    }

    public void h(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, onClickListener) == null) {
            this.f27699a.setOnClickListener(onClickListener);
        }
    }

    public void i(TailData tailData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, tailData) == null) {
            this.f27700b = tailData;
            e(tailData.getContent());
            d(tailData.getFontColor());
        }
    }
}
