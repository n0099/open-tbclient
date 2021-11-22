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
    public View f29244a;

    /* renamed from: b  reason: collision with root package name */
    public Context f29245b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f29246c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f29247d;

    /* renamed from: e  reason: collision with root package name */
    public TailData f29248e;

    /* renamed from: f  reason: collision with root package name */
    public View f29249f;

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
            this.f29244a = inflate;
            this.f29245b = context;
            inflate.setTag(this);
            this.f29246c = (TextView) this.f29244a.findViewById(R.id.tail_tool_item_text);
            this.f29247d = (ImageView) this.f29244a.findViewById(R.id.tail_tool_item_selected);
            View findViewById = this.f29244a.findViewById(R.id.tail_tool_item_scope);
            this.f29249f = findViewById;
            findViewById.setTag(this);
            return this.f29244a;
        }
        return (View) invokeL.objValue;
    }

    public TailData b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f29248e : (TailData) invokeV.objValue;
    }

    @SuppressLint({"ResourceAsColor"})
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SkinManager.setBackgroundResource(this.f29249f, R.drawable.tail_item_bg);
            SkinManager.setViewTextColor(this.f29246c, R.color.CAM_X0106, 1);
            SkinManager.setBackgroundResource(this.f29247d, R.drawable.tail_tool_list_item_checkbox_bg);
            SkinManager.setImageResource(this.f29247d, R.drawable.tail_tool_list_item_checkbox_selector);
        }
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.f29246c.setTextColor(b.a.r0.y1.h.f.c.a(str));
        }
    }

    public void e(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
            this.f29249f.setOnClickListener(onClickListener);
        }
    }

    public void f(TailData tailData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, tailData) == null) {
            this.f29248e = tailData;
        }
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.f29246c.setText(TbFaceManager.e().l(this.f29245b, b.a.r0.y1.h.f.d.a(str), null));
        }
    }

    public void h(TailData tailData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, tailData) == null) || tailData == null) {
            return;
        }
        g(tailData.getContent());
        d(tailData.getFontColor());
        this.f29247d.setSelected(tailData.isSelected());
    }
}
