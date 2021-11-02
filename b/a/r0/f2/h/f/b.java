package b.a.r0.f2.h.f;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import b.a.e.e.p.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class b extends b.a.r0.f2.h.f.g.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f16556a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f16557b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f16558c;

    public b(View view, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f16556a = view;
        TextView textView = (TextView) view.findViewById(R.id.emotion_empty_content);
        this.f16557b = textView;
        textView.setText(str);
        this.f16558c = (ImageView) view.findViewById(R.id.emotion_empty_icon);
        c();
    }

    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f16556a : (View) invokeV.objValue;
    }

    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            TextView textView = this.f16557b;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, R.color.CAM_X0107, i2);
            }
            ImageView imageView = this.f16558c;
            if (imageView != null) {
                SkinManager.setImageResource(imageView, R.drawable.new_pic_emotion_02, i2);
            }
            View view = this.f16556a;
            if (view != null) {
                SkinManager.setBackgroundColor(view, R.color.CAM_X0201, i2);
            }
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            int i2 = l.i(TbadkCoreApplication.getInst());
            int dimensionPixelSize = i2 <= 0 ? TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds200) : (int) (i2 * 0.11d);
            ViewGroup.LayoutParams layoutParams = this.f16558c.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = dimensionPixelSize;
                this.f16558c.setLayoutParams(marginLayoutParams);
            }
        }
    }
}
