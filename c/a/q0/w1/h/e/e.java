package c.a.q0.w1.h.e;

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
/* loaded from: classes4.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f28145a;

    /* renamed from: b  reason: collision with root package name */
    public Context f28146b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f28147c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f28148d;

    /* renamed from: e  reason: collision with root package name */
    public TailData f28149e;

    /* renamed from: f  reason: collision with root package name */
    public View f28150f;

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
            this.f28145a = inflate;
            this.f28146b = context;
            inflate.setTag(this);
            this.f28147c = (TextView) this.f28145a.findViewById(R.id.tail_tool_item_text);
            this.f28148d = (ImageView) this.f28145a.findViewById(R.id.tail_tool_item_selected);
            View findViewById = this.f28145a.findViewById(R.id.tail_tool_item_scope);
            this.f28150f = findViewById;
            findViewById.setTag(this);
            return this.f28145a;
        }
        return (View) invokeL.objValue;
    }

    public TailData b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f28149e : (TailData) invokeV.objValue;
    }

    @SuppressLint({"ResourceAsColor"})
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SkinManager.setBackgroundResource(this.f28150f, R.drawable.tail_item_bg);
            SkinManager.setViewTextColor(this.f28147c, R.color.CAM_X0106, 1);
            SkinManager.setBackgroundResource(this.f28148d, R.drawable.tail_tool_list_item_checkbox_bg);
            SkinManager.setImageResource(this.f28148d, R.drawable.tail_tool_list_item_checkbox_selector);
        }
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.f28147c.setTextColor(c.a.q0.w1.h.f.c.a(str));
        }
    }

    public void e(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
            this.f28150f.setOnClickListener(onClickListener);
        }
    }

    public void f(TailData tailData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, tailData) == null) {
            this.f28149e = tailData;
        }
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.f28147c.setText(TbFaceManager.e().l(this.f28146b, c.a.q0.w1.h.f.d.a(str), null));
        }
    }

    public void h(TailData tailData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, tailData) == null) || tailData == null) {
            return;
        }
        g(tailData.getContent());
        d(tailData.getFontColor());
        this.f28148d.setSelected(tailData.isSelected());
    }
}
