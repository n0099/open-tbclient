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
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tieba.R;
import com.baidu.tieba.memberCenter.tail.data.TailData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f27741a;

    /* renamed from: b  reason: collision with root package name */
    public Context f27742b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f27743c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f27744d;

    /* renamed from: e  reason: collision with root package name */
    public TailData f27745e;

    /* renamed from: f  reason: collision with root package name */
    public View f27746f;

    public e() {
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
            View inflate = LayoutInflater.from(context).inflate(R.layout.tail_tool_item, (ViewGroup) null);
            this.f27741a = inflate;
            this.f27742b = context;
            inflate.setTag(this);
            this.f27743c = (TextView) this.f27741a.findViewById(R.id.tail_tool_item_text);
            this.f27744d = (ImageView) this.f27741a.findViewById(R.id.tail_tool_item_selected);
            View findViewById = this.f27741a.findViewById(R.id.tail_tool_item_scope);
            this.f27746f = findViewById;
            findViewById.setTag(this);
            return this.f27741a;
        }
        return (View) invokeL.objValue;
    }

    public TailData b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f27745e : (TailData) invokeV.objValue;
    }

    @SuppressLint({"ResourceAsColor"})
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SkinManager.setBackgroundResource(this.f27746f, R.drawable.tail_item_bg);
            SkinManager.setViewTextColor(this.f27743c, R.color.CAM_X0106, 1);
            SkinManager.setBackgroundResource(this.f27744d, R.drawable.tail_tool_list_item_checkbox_bg);
            SkinManager.setImageResource(this.f27744d, R.drawable.tail_tool_list_item_checkbox_selector);
        }
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.f27743c.setTextColor(b.a.r0.y1.h.f.c.a(str));
        }
    }

    public void e(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
            this.f27746f.setOnClickListener(onClickListener);
        }
    }

    public void f(TailData tailData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, tailData) == null) {
            this.f27745e = tailData;
        }
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.f27743c.setText(TbFaceManager.e().l(this.f27742b, b.a.r0.y1.h.f.d.a(str), null));
        }
    }

    public void h(TailData tailData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, tailData) == null) || tailData == null) {
            return;
        }
        g(tailData.getContent());
        d(tailData.getFontColor());
        this.f27744d.setSelected(tailData.isSelected());
    }
}
