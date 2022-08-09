package com.baidu.pass.biometrics.face.liveness.d;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.utils.CommonViewUtility;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class a extends Dialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public ViewSwitcher b;
    public LinearLayout c;
    public TextView d;
    public TextView e;
    public TextView f;
    public TextView g;
    public TextView h;
    public TextView i;
    public TextView j;
    public TextView k;
    public TextView l;
    public LinearLayout m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Context context) {
        super(context, R.style.obfuscated_res_0x7f100148);
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
        this.a = context;
        a();
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            setContentView(R.layout.obfuscated_res_0x7f0d04a8);
            setCanceledOnTouchOutside(false);
            this.b = (ViewSwitcher) findViewById(R.id.obfuscated_res_0x7f092567);
            this.d = (TextView) findViewById(R.id.obfuscated_res_0x7f0907bc);
            this.e = (TextView) findViewById(R.id.obfuscated_res_0x7f0907b4);
            this.f = (TextView) findViewById(R.id.obfuscated_res_0x7f091562);
            this.g = (TextView) findViewById(R.id.obfuscated_res_0x7f09176d);
            this.h = (TextView) findViewById(R.id.obfuscated_res_0x7f09176c);
            this.i = (TextView) findViewById(R.id.obfuscated_res_0x7f09176e);
            this.j = (TextView) findViewById(R.id.obfuscated_res_0x7f0919f6);
            this.k = (TextView) findViewById(R.id.obfuscated_res_0x7f09163f);
            this.l = (TextView) findViewById(R.id.obfuscated_res_0x7f09164c);
            this.m = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f092190);
            this.c = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f09176b);
            CommonViewUtility.setViewClickAlpha(this.j, 0.2f);
            CommonViewUtility.setViewClickAlpha(this.k, 0.2f);
            CommonViewUtility.setViewClickAlpha(this.l, 0.2f);
        }
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.d.setText(str);
        }
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.e.setVisibility(0);
            this.e.setText(str);
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            if (z) {
                this.d.setVisibility(0);
            } else {
                this.d.setVisibility(8);
            }
        }
    }

    public void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.m.setVisibility(0);
        }
    }

    public void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.f.setText(i);
        }
    }

    public void c(String str, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, str, onClickListener) == null) {
            this.j.setText(str);
            this.j.setOnClickListener(onClickListener);
        }
    }

    public void b(String str, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, onClickListener) == null) {
            this.l.setText(str);
            this.l.setOnClickListener(onClickListener);
        }
    }

    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            if ((i < 1 ? 1 : Math.min(i, 2)) == 2) {
                this.b.setDisplayedChild(0);
            } else {
                this.b.setDisplayedChild(1);
            }
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.f.setVisibility(0);
            this.f.setText(str);
        }
    }

    public void a(String str, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, onClickListener) == null) {
            this.k.setText(str);
            this.k.setOnClickListener(onClickListener);
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            if (z) {
                this.c.setBackgroundDrawable(this.a.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080e69));
                this.d.setTextColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f0608b4));
                this.e.setTextColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f0608a9));
                this.f.setTextColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f0608b3));
                this.g.setTextColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f0608b3));
                this.h.setTextColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f0608b3));
                this.i.setTextColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f0608b3));
                this.k.setTextColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f0608ad));
                this.j.setTextColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f0608b1));
                this.l.setTextColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f0608b1));
                this.k.setBackgroundDrawable(this.a.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080e63));
                this.j.setBackgroundDrawable(this.a.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080e65));
                this.l.setBackgroundDrawable(this.a.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080e65));
                return;
            }
            this.c.setBackgroundDrawable(this.a.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080e68));
            this.d.setTextColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f0608b4));
            this.e.setTextColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f0608a8));
            this.f.setTextColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f0608b2));
            this.g.setTextColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f0608b2));
            this.h.setTextColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f0608b2));
            this.i.setTextColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f0608b2));
            this.k.setTextColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f0608ac));
            this.j.setTextColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f0608b0));
            this.l.setTextColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f0608b0));
            this.k.setBackgroundDrawable(this.a.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080e62));
            this.j.setBackgroundDrawable(this.a.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080e64));
            this.l.setBackgroundDrawable(this.a.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080e64));
        }
    }
}
