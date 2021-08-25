package c.a.q0.w1.h.c;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f28098a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f28099b;

    /* renamed from: c  reason: collision with root package name */
    public Context f28100c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f28101d;

    public b() {
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
            tbPageContext.getLayoutMode().j(this.f28098a);
        }
    }

    public View b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            this.f28100c = context;
            View inflate = LayoutInflater.from(context).inflate(R.layout.tail_management_add_item, (ViewGroup) null);
            this.f28098a = inflate;
            inflate.setTag(this);
            this.f28101d = (TextView) this.f28098a.findViewById(R.id.tail_management_new_text);
            this.f28099b = (ImageView) this.f28098a.findViewById(R.id.tail_management_new_button);
            return this.f28098a;
        }
        return (View) invokeL.objValue;
    }

    public void c(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onClickListener) == null) {
            this.f28099b.setOnClickListener(onClickListener);
        }
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f28101d.setText(String.format(this.f28100c.getString(R.string.tail_management_available), Integer.valueOf(i2)));
        }
    }
}
