package c.a.a0.l0.p.e;

import android.text.TextUtils;
import android.util.Log;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
            int i = this.p;
            return i != -1 ? i : c.a.a0.l0.b.a().getResources().getColor(R.color.obfuscated_res_0x7f060317);
        }
        return invokeV.intValue;
    }

    public void C(CharSequence charSequence, int i, int i2, float f2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{charSequence, Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f2)}) == null) || (textView = this.f1451e) == null) {
            return;
        }
        if (charSequence != null) {
            textView.setText(charSequence);
        }
        this.f1451e.setTextColor(i);
        if (i2 < 0 || f2 <= 0.0f) {
            return;
        }
        this.f1451e.setTextSize(i2, f2);
    }

    public void D(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, charSequence) == null) {
            if (TextUtils.isEmpty(charSequence)) {
                Log.d("BubbleTextManager", "str is empty !!!, will show nothing !!!");
            }
            this.q = charSequence;
        }
    }

    public void E(@ColorInt int i, @ColorInt int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048579, this, i, i2) == null) {
            this.p = i;
        }
    }

    @Override // c.a.a0.l0.p.e.a
    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? R.layout.obfuscated_res_0x7f0d05a6 : invokeV.intValue;
    }

    @Override // c.a.a0.l0.p.e.a
    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (super.g()) {
                int B = B();
                TextView textView = (TextView) this.f1448b.findViewById(R.id.obfuscated_res_0x7f090459);
                this.f1451e = textView;
                textView.setTextColor(B);
                this.f1451e.setVisibility(0);
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.a0.l0.p.e.a
    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? !TextUtils.isEmpty(this.q) && super.h() : invokeV.booleanValue;
    }

    @Override // c.a.a0.l0.p.e.a
    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.n();
            this.q = null;
        }
    }
}
