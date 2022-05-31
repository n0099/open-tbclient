package com.baidu.pass.biometrics.face.liveness.d;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class b extends Dialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ViewSwitcher a;
    public LinearLayout b;
    public TextView c;
    public TextView d;
    public TextView e;
    public TextView f;
    public TextView g;
    public Context h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Context context) {
        super(context, R.style.obfuscated_res_0x7f100143);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.h = context;
        a();
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            setContentView(R.layout.obfuscated_res_0x7f0d048e);
            setCanceledOnTouchOutside(false);
            this.b = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f09162c);
            this.a = (ViewSwitcher) findViewById(R.id.obfuscated_res_0x7f0923ae);
            this.c = (TextView) findViewById(R.id.obfuscated_res_0x7f092042);
            this.d = (TextView) findViewById(R.id.obfuscated_res_0x7f091434);
            this.e = (TextView) findViewById(R.id.obfuscated_res_0x7f0918a9);
            this.f = (TextView) findViewById(R.id.obfuscated_res_0x7f09150c);
            this.g = (TextView) findViewById(R.id.obfuscated_res_0x7f091518);
        }
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.c.setText(str);
        }
    }

    public void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.c.setVisibility(i);
        }
    }

    public void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.d.setVisibility(i);
        }
    }

    public void c(String str, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, onClickListener) == null) {
            this.e.setText(str);
            this.e.setOnClickListener(onClickListener);
        }
    }

    public void b(String str, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, onClickListener) == null) {
            this.g.setText(str);
            this.g.setOnClickListener(onClickListener);
        }
    }

    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            if ((i < 1 ? 1 : Math.min(i, 2)) == 2) {
                this.a.setDisplayedChild(0);
            } else {
                this.a.setDisplayedChild(1);
            }
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.d.setText(str);
        }
    }

    public void a(String str, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, onClickListener) == null) {
            this.f.setText(str);
            this.f.setOnClickListener(onClickListener);
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            if (z) {
                this.b.setBackgroundDrawable(this.h.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080e9b));
                this.c.setTextColor(this.h.getResources().getColor(R.color.obfuscated_res_0x7f0608a5));
                this.d.setTextColor(this.h.getResources().getColor(R.color.obfuscated_res_0x7f060899));
                this.f.setTextColor(this.h.getResources().getColor(R.color.obfuscated_res_0x7f06089d));
                this.e.setTextColor(this.h.getResources().getColor(R.color.obfuscated_res_0x7f0608a1));
                this.g.setTextColor(this.h.getResources().getColor(R.color.obfuscated_res_0x7f06089d));
                this.f.setBackgroundDrawable(this.h.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080e95));
                this.e.setBackgroundDrawable(this.h.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080e97));
                this.g.setBackgroundDrawable(this.h.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080e95));
                return;
            }
            this.b.setBackgroundDrawable(this.h.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080e9a));
            this.c.setTextColor(this.h.getResources().getColor(R.color.obfuscated_res_0x7f0608a4));
            this.d.setTextColor(this.h.getResources().getColor(R.color.obfuscated_res_0x7f060898));
            this.f.setTextColor(this.h.getResources().getColor(R.color.obfuscated_res_0x7f06089c));
            this.g.setTextColor(this.h.getResources().getColor(R.color.obfuscated_res_0x7f06089c));
            this.e.setTextColor(this.h.getResources().getColor(R.color.obfuscated_res_0x7f0608a0));
            this.f.setBackgroundDrawable(this.h.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080e94));
            this.e.setBackgroundDrawable(this.h.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080e96));
            this.g.setBackgroundDrawable(this.h.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080e94));
        }
    }
}
