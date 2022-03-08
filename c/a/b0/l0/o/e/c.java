package c.a.b0.l0.o.e;

import android.text.TextUtils;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class c extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @ColorInt
    public int p;
    public CharSequence q;
    public int r;
    public float s;

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
                return;
            }
        }
        this.p = -1;
        this.r = -1;
        this.s = -1.0f;
    }

    public int B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int i2 = this.p;
            return i2 != -1 ? i2 : c.a.b0.l0.b.a().getResources().getColor(R.color.NAD_UC28);
        }
        return invokeV.intValue;
    }

    public void C(CharSequence charSequence, int i2, int i3, float f2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{charSequence, Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f2)}) == null) || (textView = this.f1853e) == null) {
            return;
        }
        if (charSequence != null) {
            textView.setText(charSequence);
        }
        this.f1853e.setTextColor(i2);
        if (i3 < 0 || f2 <= 0.0f) {
            return;
        }
        this.f1853e.setTextSize(i3, f2);
    }

    public void D(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, charSequence) == null) {
            TextUtils.isEmpty(charSequence);
            this.q = charSequence;
        }
    }

    public void E(@ColorInt int i2, @ColorInt int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048579, this, i2, i3) == null) {
            this.p = i2;
        }
    }

    @Override // c.a.b0.l0.o.e.a
    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? R.layout.nad_bubble_tip_d20 : invokeV.intValue;
    }

    @Override // c.a.b0.l0.o.e.a
    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (super.g()) {
                int B = B();
                TextView textView = (TextView) this.f1850b.findViewById(R.id.bubble_text);
                this.f1853e = textView;
                textView.setTextColor(B);
                this.f1853e.setVisibility(0);
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.b0.l0.o.e.a
    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? !TextUtils.isEmpty(this.q) && super.h() : invokeV.booleanValue;
    }

    @Override // c.a.b0.l0.o.e.a
    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.n();
            this.q = null;
        }
    }
}
