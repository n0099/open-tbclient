package b.a.r0.y1.h.e;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
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
    public View f27735a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f27736b;

    /* renamed from: c  reason: collision with root package name */
    public Context f27737c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f27738d;

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

    public View a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            this.f27737c = context;
            View inflate = LayoutInflater.from(context).inflate(R.layout.tail_tool_add_item, (ViewGroup) null);
            this.f27735a = inflate;
            inflate.setTag(this);
            this.f27738d = (TextView) this.f27735a.findViewById(R.id.tail_management_new_text);
            this.f27736b = (ImageView) this.f27735a.findViewById(R.id.tail_management_new_button);
            return this.f27735a;
        }
        return (View) invokeL.objValue;
    }

    @SuppressLint({"ResourceAsColor"})
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            SkinManager.setBackgroundResource(this.f27736b, R.drawable.tail_tool_add_button_bg);
            SkinManager.setImageResource(this.f27736b, R.drawable.icon_tail_post_add);
            SkinManager.setViewTextColor(this.f27738d, R.color.CAM_X0109, 1);
        }
    }

    public void c(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onClickListener) == null) {
            this.f27736b.setOnClickListener(onClickListener);
        }
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f27738d.setText(String.format(this.f27737c.getString(R.string.tail_management_available), Integer.valueOf(i2)));
        }
    }
}
